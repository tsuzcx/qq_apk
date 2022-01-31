package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.d;
import android.support.v4.view.q;
import android.support.v7.a.a.a;
import android.support.v7.a.a.j;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.c.a.b;
import android.support.v7.view.c;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.o.a;
import android.support.v7.view.menu.u;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
  extends ViewGroup
{
  private int An = 8388627;
  private int RZ;
  Context WB;
  ActionMenuView WC;
  private boolean WG;
  private boolean WH;
  int Yd;
  o.a Yf;
  h.a Yg;
  private final ActionMenuView.d amA = new ActionMenuView.d()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      if (Toolbar.this.amz != null) {
        return Toolbar.this.amz.onMenuItemClick(paramAnonymousMenuItem);
      }
      return false;
    }
  };
  private ay amB;
  ActionMenuPresenter amC;
  a amD;
  private final Runnable amE = new Runnable()
  {
    public final void run()
    {
      Toolbar.this.showOverflowMenu();
    }
  };
  TextView ama;
  TextView amb;
  private ImageButton amc;
  private ImageView amd;
  Drawable ame;
  CharSequence amf;
  ImageButton amg;
  View amh;
  int ami;
  int amj;
  int amk;
  private int aml;
  private int amm;
  private int amn;
  private int amo;
  private int amp;
  ao amq;
  private int amr;
  private int ams;
  private CharSequence amt;
  private CharSequence amu;
  private int amv;
  private final ArrayList<View> amw = new ArrayList();
  final ArrayList<View> amx = new ArrayList();
  private final int[] amy = new int[2];
  b amz;
  private boolean ew;
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.toolbarStyle);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ax.a(getContext(), paramAttributeSet, a.j.Toolbar, paramInt, 0);
    this.ami = paramContext.getResourceId(a.j.Toolbar_titleTextAppearance, 0);
    this.amj = paramContext.getResourceId(a.j.Toolbar_subtitleTextAppearance, 0);
    this.An = paramContext.getInteger(a.j.Toolbar_android_gravity, this.An);
    this.amk = paramContext.getInteger(a.j.Toolbar_buttonGravity, 48);
    int i = paramContext.getDimensionPixelOffset(a.j.Toolbar_titleMargin, 0);
    paramInt = i;
    if (paramContext.hasValue(a.j.Toolbar_titleMargins)) {
      paramInt = paramContext.getDimensionPixelOffset(a.j.Toolbar_titleMargins, i);
    }
    this.amp = paramInt;
    this.amo = paramInt;
    this.amn = paramInt;
    this.amm = paramInt;
    paramInt = paramContext.getDimensionPixelOffset(a.j.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0) {
      this.amm = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(a.j.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0) {
      this.amn = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(a.j.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0) {
      this.amo = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(a.j.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0) {
      this.amp = paramInt;
    }
    this.aml = paramContext.getDimensionPixelSize(a.j.Toolbar_maxButtonHeight, -1);
    paramInt = paramContext.getDimensionPixelOffset(a.j.Toolbar_contentInsetStart, -2147483648);
    i = paramContext.getDimensionPixelOffset(a.j.Toolbar_contentInsetEnd, -2147483648);
    int j = paramContext.getDimensionPixelSize(a.j.Toolbar_contentInsetLeft, 0);
    int k = paramContext.getDimensionPixelSize(a.j.Toolbar_contentInsetRight, 0);
    ja();
    paramAttributeSet = this.amq;
    paramAttributeSet.aiK = false;
    if (j != -2147483648)
    {
      paramAttributeSet.aiI = j;
      paramAttributeSet.pR = j;
    }
    if (k != -2147483648)
    {
      paramAttributeSet.aiJ = k;
      paramAttributeSet.pT = k;
    }
    if ((paramInt != -2147483648) || (i != -2147483648)) {
      this.amq.av(paramInt, i);
    }
    this.amr = paramContext.getDimensionPixelOffset(a.j.Toolbar_contentInsetStartWithNavigation, -2147483648);
    this.ams = paramContext.getDimensionPixelOffset(a.j.Toolbar_contentInsetEndWithActions, -2147483648);
    this.ame = paramContext.getDrawable(a.j.Toolbar_collapseIcon);
    this.amf = paramContext.getText(a.j.Toolbar_collapseContentDescription);
    paramAttributeSet = paramContext.getText(a.j.Toolbar_title);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(a.j.Toolbar_subtitle);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    this.WB = getContext();
    setPopupTheme(paramContext.getResourceId(a.j.Toolbar_popupTheme, 0));
    paramAttributeSet = paramContext.getDrawable(a.j.Toolbar_navigationIcon);
    if (paramAttributeSet != null) {
      setNavigationIcon(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(a.j.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setNavigationContentDescription(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(a.j.Toolbar_logo);
    if (paramAttributeSet != null) {
      setLogo(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(a.j.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setLogoDescription(paramAttributeSet);
    }
    if (paramContext.hasValue(a.j.Toolbar_titleTextColor)) {
      setTitleTextColor(paramContext.getColor(a.j.Toolbar_titleTextColor, -1));
    }
    if (paramContext.hasValue(a.j.Toolbar_subtitleTextColor)) {
      setSubtitleTextColor(paramContext.getColor(a.j.Toolbar_subtitleTextColor, -1));
    }
    paramContext.alZ.recycle();
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int j = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int k = Math.max(0, i) + Math.max(0, j);
    paramArrayOfInt[0] = Math.max(0, -i);
    paramArrayOfInt[1] = Math.max(0, -j);
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + k + paramInt2, localMarginLayoutParams.width), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height));
    return paramView.getMeasuredWidth() + k;
  }
  
  private int a(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.leftMargin - paramArrayOfInt[0];
    paramInt1 = Math.max(0, i) + paramInt1;
    paramArrayOfInt[0] = Math.max(0, -i);
    paramInt2 = x(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i, paramView.getMeasuredHeight() + paramInt2);
    return localLayoutParams.rightMargin + i + paramInt1;
  }
  
  private int b(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i);
    paramArrayOfInt[1] = Math.max(0, -i);
    paramInt2 = x(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - (localLayoutParams.leftMargin + i);
  }
  
  private void b(List<View> paramList, int paramInt)
  {
    int i = 1;
    int j = 0;
    if (q.Q(this) == 1) {}
    int m;
    int k;
    View localView;
    LayoutParams localLayoutParams;
    for (;;)
    {
      m = getChildCount();
      k = d.getAbsoluteGravity(paramInt, q.Q(this));
      paramList.clear();
      paramInt = j;
      if (i == 0) {
        break;
      }
      paramInt = m - 1;
      while (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams.amH == 0) && (bA(localView)) && (cs(localLayoutParams.gravity) == k)) {
          paramList.add(localView);
        }
        paramInt -= 1;
      }
      i = 0;
    }
    while (paramInt < m)
    {
      localView = getChildAt(paramInt);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams.amH == 0) && (bA(localView)) && (cs(localLayoutParams.gravity) == k)) {
        paramList.add(localView);
      }
      paramInt += 1;
    }
  }
  
  private boolean bA(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  private static int bB(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i;
    if (Build.VERSION.SDK_INT >= 17)
    {
      i = paramView.getMarginStart();
      if (Build.VERSION.SDK_INT < 17) {
        break label46;
      }
    }
    label46:
    for (int j = paramView.getMarginEnd();; j = paramView.rightMargin)
    {
      return j + i;
      i = paramView.leftMargin;
      break;
    }
  }
  
  private static int bC(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = paramView.topMargin;
    return paramView.bottomMargin + i;
  }
  
  private boolean bD(View paramView)
  {
    return (paramView.getParent() == this) || (this.amx.contains(paramView));
  }
  
  private int cs(int paramInt)
  {
    int j = q.Q(this);
    int i = d.getAbsoluteGravity(paramInt, j) & 0x7;
    paramInt = i;
    switch (i)
    {
    case 2: 
    case 4: 
    default: 
      if (j == 1) {
        paramInt = 5;
      }
      break;
    case 1: 
    case 3: 
    case 5: 
      return paramInt;
    }
    return 3;
  }
  
  private static LayoutParams e(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ActionBar.LayoutParams)) {
      return new LayoutParams((ActionBar.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  private void g(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = new LayoutParams();
    }
    for (;;)
    {
      ((LayoutParams)localObject).amH = 1;
      if ((!paramBoolean) || (this.amh == null)) {
        break;
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.amx.add(paramView);
      return;
      if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
        localObject = e((ViewGroup.LayoutParams)localObject);
      } else {
        localObject = (LayoutParams)localObject;
      }
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
  }
  
  private MenuInflater getMenuInflater()
  {
    return new g(getContext());
  }
  
  private void i(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + 0, localMarginLayoutParams.height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt3 != 1073741824)
    {
      paramInt1 = paramInt2;
      if (paramInt4 >= 0)
      {
        paramInt1 = paramInt4;
        if (paramInt3 != 0) {
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt4);
        }
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
    }
    paramView.measure(i, paramInt1);
  }
  
  private void iV()
  {
    if (this.amd == null) {
      this.amd = new AppCompatImageView(getContext());
    }
  }
  
  private void iW()
  {
    iX();
    if (this.WC.dm == null)
    {
      h localh = (h)this.WC.getMenu();
      if (this.amD == null) {
        this.amD = new a();
      }
      this.WC.setExpandedActionViewsExclusive(true);
      localh.a(this.amD, this.WB);
    }
  }
  
  private void iY()
  {
    if (this.amc == null)
    {
      this.amc = new AppCompatImageButton(getContext(), null, a.a.toolbarNavigationButtonStyle);
      LayoutParams localLayoutParams = new LayoutParams();
      localLayoutParams.gravity = (0x800003 | this.amk & 0x70);
      this.amc.setLayoutParams(localLayoutParams);
    }
  }
  
  protected static LayoutParams iZ()
  {
    return new LayoutParams();
  }
  
  private int x(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int k = paramView.getMeasuredHeight();
    int j;
    int i;
    int m;
    if (paramInt > 0)
    {
      paramInt = (k - paramInt) / 2;
      j = localLayoutParams.gravity & 0x70;
      i = j;
      switch (j)
      {
      default: 
        i = this.An & 0x70;
      }
      switch (i)
      {
      default: 
        i = getPaddingTop();
        j = getPaddingBottom();
        m = getHeight();
        paramInt = (m - i - j - k) / 2;
        if (paramInt < localLayoutParams.topMargin) {
          paramInt = localLayoutParams.topMargin;
        }
        break;
      }
    }
    for (;;)
    {
      return paramInt + i;
      paramInt = 0;
      break;
      return getPaddingTop() - paramInt;
      return getHeight() - getPaddingBottom() - k - localLayoutParams.bottomMargin - paramInt;
      j = m - j - k - paramInt - i;
      if (j < localLayoutParams.bottomMargin) {
        paramInt = Math.max(0, paramInt - (localLayoutParams.bottomMargin - j));
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public final void collapseActionView()
  {
    if (this.amD == null) {}
    for (j localj = null;; localj = this.amD.amG)
    {
      if (localj != null) {
        localj.collapseActionView();
      }
      return;
    }
  }
  
  public int getContentInsetEnd()
  {
    if (this.amq != null)
    {
      ao localao = this.amq;
      if (localao.gz) {
        return localao.pR;
      }
      return localao.pT;
    }
    return 0;
  }
  
  public int getContentInsetEndWithActions()
  {
    if (this.ams != -2147483648) {
      return this.ams;
    }
    return getContentInsetEnd();
  }
  
  public int getContentInsetLeft()
  {
    if (this.amq != null) {
      return this.amq.pR;
    }
    return 0;
  }
  
  public int getContentInsetRight()
  {
    if (this.amq != null) {
      return this.amq.pT;
    }
    return 0;
  }
  
  public int getContentInsetStart()
  {
    if (this.amq != null)
    {
      ao localao = this.amq;
      if (localao.gz) {
        return localao.pT;
      }
      return localao.pR;
    }
    return 0;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    if (this.amr != -2147483648) {
      return this.amr;
    }
    return getContentInsetStart();
  }
  
  public int getCurrentContentInsetEnd()
  {
    int i;
    if (this.WC != null)
    {
      h localh = this.WC.dm;
      if ((localh != null) && (localh.hasVisibleItems())) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return Math.max(getContentInsetEnd(), Math.max(this.ams, 0));
        i = 0;
      }
      else
      {
        return getContentInsetEnd();
        i = 0;
      }
    }
  }
  
  public int getCurrentContentInsetLeft()
  {
    if (q.Q(this) == 1) {
      return getCurrentContentInsetEnd();
    }
    return getCurrentContentInsetStart();
  }
  
  public int getCurrentContentInsetRight()
  {
    if (q.Q(this) == 1) {
      return getCurrentContentInsetStart();
    }
    return getCurrentContentInsetEnd();
  }
  
  public int getCurrentContentInsetStart()
  {
    if (getNavigationIcon() != null) {
      return Math.max(getContentInsetStart(), Math.max(this.amr, 0));
    }
    return getContentInsetStart();
  }
  
  public Drawable getLogo()
  {
    if (this.amd != null) {
      return this.amd.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    if (this.amd != null) {
      return this.amd.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    iW();
    return this.WC.getMenu();
  }
  
  public CharSequence getNavigationContentDescription()
  {
    if (this.amc != null) {
      return this.amc.getContentDescription();
    }
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    if (this.amc != null) {
      return this.amc.getDrawable();
    }
    return null;
  }
  
  ActionMenuPresenter getOuterActionMenuPresenter()
  {
    return this.amC;
  }
  
  public Drawable getOverflowIcon()
  {
    iW();
    return this.WC.getOverflowIcon();
  }
  
  Context getPopupContext()
  {
    return this.WB;
  }
  
  public int getPopupTheme()
  {
    return this.Yd;
  }
  
  public CharSequence getSubtitle()
  {
    return this.amu;
  }
  
  public CharSequence getTitle()
  {
    return this.amt;
  }
  
  public int getTitleMarginBottom()
  {
    return this.amp;
  }
  
  public int getTitleMarginEnd()
  {
    return this.amn;
  }
  
  public int getTitleMarginStart()
  {
    return this.amm;
  }
  
  public int getTitleMarginTop()
  {
    return this.amo;
  }
  
  public w getWrapper()
  {
    if (this.amB == null) {
      this.amB = new ay(this, true);
    }
    return this.amB;
  }
  
  final void iX()
  {
    if (this.WC == null)
    {
      this.WC = new ActionMenuView(getContext());
      this.WC.setPopupTheme(this.Yd);
      this.WC.setOnMenuItemClickListener(this.amA);
      this.WC.a(this.Yf, this.Yg);
      LayoutParams localLayoutParams = new LayoutParams();
      localLayoutParams.gravity = (0x800005 | this.amk & 0x70);
      this.WC.setLayoutParams(localLayoutParams);
      g(this.WC, false);
    }
  }
  
  public final boolean isOverflowMenuShowing()
  {
    if (this.WC != null)
    {
      ActionMenuView localActionMenuView = this.WC;
      if ((localActionMenuView.Ye != null) && (localActionMenuView.Ye.isOverflowMenuShowing())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  final void ja()
  {
    if (this.amq == null) {
      this.amq = new ao();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.amE);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.WH = false;
    }
    if (!this.WH)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.WH = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.WH = false;
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k;
    int i1;
    int i4;
    int j;
    int i2;
    int i3;
    int i5;
    int[] arrayOfInt;
    int i;
    if (q.Q(this) == 1)
    {
      k = 1;
      i1 = getWidth();
      i4 = getHeight();
      j = getPaddingLeft();
      i2 = getPaddingRight();
      i3 = getPaddingTop();
      i5 = getPaddingBottom();
      paramInt1 = i1 - i2;
      arrayOfInt = this.amy;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      paramInt3 = q.X(this);
      if (paramInt3 < 0) {
        break label898;
      }
      i = Math.min(paramInt3, paramInt4 - paramInt2);
      label91:
      if (!bA(this.amc)) {
        break label1739;
      }
      if (k == 0) {
        break label904;
      }
      paramInt1 = b(this.amc, paramInt1, arrayOfInt, i);
      paramInt2 = j;
    }
    for (;;)
    {
      label124:
      paramInt3 = paramInt1;
      paramInt4 = paramInt2;
      if (bA(this.amg))
      {
        if (k != 0)
        {
          paramInt3 = b(this.amg, paramInt1, arrayOfInt, i);
          paramInt4 = paramInt2;
        }
      }
      else
      {
        label164:
        paramInt1 = paramInt3;
        paramInt2 = paramInt4;
        if (bA(this.WC))
        {
          if (k == 0) {
            break label943;
          }
          paramInt2 = a(this.WC, paramInt4, arrayOfInt, i);
          paramInt1 = paramInt3;
        }
        label204:
        paramInt3 = getCurrentContentInsetLeft();
        paramInt4 = getCurrentContentInsetRight();
        arrayOfInt[0] = Math.max(0, paramInt3 - paramInt2);
        arrayOfInt[1] = Math.max(0, paramInt4 - (i1 - i2 - paramInt1));
        paramInt3 = Math.max(paramInt2, paramInt3);
        paramInt4 = Math.min(paramInt1, i1 - i2 - paramInt4);
        paramInt2 = paramInt4;
        paramInt1 = paramInt3;
        if (bA(this.amh))
        {
          if (k == 0) {
            break label964;
          }
          paramInt2 = b(this.amh, paramInt4, arrayOfInt, i);
          paramInt1 = paramInt3;
        }
        label308:
        if (!bA(this.amd)) {
          break label1731;
        }
        if (k == 0) {
          break label985;
        }
        paramInt3 = b(this.amd, paramInt2, arrayOfInt, i);
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        label341:
        paramBoolean = bA(this.ama);
        boolean bool = bA(this.amb);
        paramInt1 = 0;
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = (LayoutParams)this.ama.getLayoutParams();
          paramInt1 = ((LayoutParams)localObject1).topMargin;
          paramInt4 = this.ama.getMeasuredHeight();
          paramInt1 = ((LayoutParams)localObject1).bottomMargin + (paramInt1 + paramInt4) + 0;
        }
        int m;
        if (bool)
        {
          localObject1 = (LayoutParams)this.amb.getLayoutParams();
          paramInt4 = ((LayoutParams)localObject1).topMargin;
          m = this.amb.getMeasuredHeight();
        }
        label542:
        label1697:
        for (int n = ((LayoutParams)localObject1).bottomMargin + (paramInt4 + m) + paramInt1;; n = paramInt1)
        {
          label479:
          Object localObject2;
          if (!paramBoolean)
          {
            paramInt4 = paramInt3;
            paramInt1 = paramInt2;
            if (!bool) {}
          }
          else
          {
            if (!paramBoolean) {
              break label1007;
            }
            localObject1 = this.ama;
            if (!bool) {
              break label1016;
            }
            localObject2 = this.amb;
            label490:
            localObject1 = (LayoutParams)((View)localObject1).getLayoutParams();
            localObject2 = (LayoutParams)((View)localObject2).getLayoutParams();
            if (((!paramBoolean) || (this.ama.getMeasuredWidth() <= 0)) && ((!bool) || (this.amb.getMeasuredWidth() <= 0))) {
              break label1025;
            }
            m = 1;
            switch (this.An & 0x70)
            {
            default: 
              paramInt1 = (i4 - i3 - i5 - n) / 2;
              if (paramInt1 < ((LayoutParams)localObject1).topMargin + this.amo) {
                paramInt1 = ((LayoutParams)localObject1).topMargin + this.amo;
              }
              break;
            }
          }
          label943:
          label1715:
          label1722:
          for (;;)
          {
            label615:
            paramInt1 = i3 + paramInt1;
            label620:
            if (k != 0) {
              if (m != 0)
              {
                paramInt4 = this.amm;
                label636:
                paramInt4 -= arrayOfInt[1];
                paramInt3 -= Math.max(0, paramInt4);
                arrayOfInt[1] = Math.max(0, -paramInt4);
                if (!paramBoolean) {
                  break label1715;
                }
                localObject1 = (LayoutParams)this.ama.getLayoutParams();
                paramInt4 = paramInt3 - this.ama.getMeasuredWidth();
                k = this.ama.getMeasuredHeight() + paramInt1;
                this.ama.layout(paramInt4, paramInt1, paramInt3, k);
                n = this.amn;
                paramInt1 = k + ((LayoutParams)localObject1).bottomMargin;
                paramInt4 -= n;
              }
            }
            for (;;)
            {
              if (bool)
              {
                localObject1 = (LayoutParams)this.amb.getLayoutParams();
                paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1;
                k = this.amb.getMeasuredWidth();
                n = this.amb.getMeasuredHeight();
                this.amb.layout(paramInt3 - k, paramInt1, paramInt3, n + paramInt1);
                paramInt1 = this.amn;
                k = ((LayoutParams)localObject1).bottomMargin;
              }
              for (paramInt1 = paramInt3 - paramInt1;; paramInt1 = paramInt3)
              {
                if (m != 0) {}
                for (paramInt1 = Math.min(paramInt4, paramInt1);; paramInt1 = paramInt3)
                {
                  paramInt4 = paramInt1;
                  paramInt1 = paramInt2;
                  b(this.amw, 3);
                  paramInt3 = this.amw.size();
                  paramInt2 = 0;
                  for (;;)
                  {
                    if (paramInt2 < paramInt3)
                    {
                      paramInt1 = a((View)this.amw.get(paramInt2), paramInt1, arrayOfInt, i);
                      paramInt2 += 1;
                      continue;
                      k = 0;
                      break;
                      i = 0;
                      break label91;
                      paramInt2 = a(this.amc, j, arrayOfInt, i);
                      break label124;
                      paramInt4 = a(this.amg, paramInt2, arrayOfInt, i);
                      paramInt3 = paramInt1;
                      break label164;
                      paramInt1 = b(this.WC, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label204;
                      label964:
                      paramInt1 = a(this.amh, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label308;
                      label985:
                      paramInt1 = a(this.amd, paramInt1, arrayOfInt, i);
                      paramInt3 = paramInt2;
                      paramInt2 = paramInt1;
                      break label341;
                      label1007:
                      localObject1 = this.amb;
                      break label479;
                      label1016:
                      localObject2 = this.ama;
                      break label490;
                      m = 0;
                      break label542;
                      paramInt1 = getPaddingTop();
                      paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1 + this.amo;
                      break label620;
                      paramInt4 = i4 - i5 - n - paramInt1 - i3;
                      if (paramInt4 >= ((LayoutParams)localObject1).bottomMargin + this.amp) {
                        break label1722;
                      }
                      paramInt1 = Math.max(0, paramInt1 - (((LayoutParams)localObject2).bottomMargin + this.amp - paramInt4));
                      break label615;
                      paramInt1 = i4 - i5 - ((LayoutParams)localObject2).bottomMargin - this.amp - n;
                      break label620;
                      paramInt4 = 0;
                      break label636;
                      if (m != 0)
                      {
                        paramInt4 = this.amm;
                        label1145:
                        paramInt4 -= arrayOfInt[0];
                        paramInt2 += Math.max(0, paramInt4);
                        arrayOfInt[0] = Math.max(0, -paramInt4);
                        if (!paramBoolean) {
                          break label1697;
                        }
                        localObject1 = (LayoutParams)this.ama.getLayoutParams();
                        k = this.ama.getMeasuredWidth() + paramInt2;
                        paramInt4 = this.ama.getMeasuredHeight() + paramInt1;
                        this.ama.layout(paramInt2, paramInt1, k, paramInt4);
                        n = this.amn;
                        paramInt1 = ((LayoutParams)localObject1).bottomMargin;
                        k += n;
                        paramInt1 += paramInt4;
                      }
                    }
                  }
                  for (;;)
                  {
                    if (bool)
                    {
                      localObject1 = (LayoutParams)this.amb.getLayoutParams();
                      paramInt4 = ((LayoutParams)localObject1).topMargin + paramInt1;
                      paramInt1 = this.amb.getMeasuredWidth() + paramInt2;
                      n = this.amb.getMeasuredHeight();
                      this.amb.layout(paramInt2, paramInt4, paramInt1, n + paramInt4);
                      paramInt4 = this.amn;
                      n = ((LayoutParams)localObject1).bottomMargin;
                    }
                    for (n = paramInt4 + paramInt1;; n = paramInt2)
                    {
                      paramInt4 = paramInt3;
                      paramInt1 = paramInt2;
                      if (m == 0) {
                        break;
                      }
                      paramInt1 = Math.max(k, n);
                      paramInt4 = paramInt3;
                      break;
                      paramInt4 = 0;
                      break label1145;
                      b(this.amw, 5);
                      k = this.amw.size();
                      paramInt3 = 0;
                      paramInt2 = paramInt4;
                      while (paramInt3 < k)
                      {
                        paramInt2 = b((View)this.amw.get(paramInt3), paramInt2, arrayOfInt, i);
                        paramInt3 += 1;
                      }
                      b(this.amw, 1);
                      localObject1 = this.amw;
                      m = arrayOfInt[0];
                      k = arrayOfInt[1];
                      n = ((List)localObject1).size();
                      paramInt4 = 0;
                      paramInt3 = 0;
                      while (paramInt4 < n)
                      {
                        localObject2 = (View)((List)localObject1).get(paramInt4);
                        LayoutParams localLayoutParams = (LayoutParams)((View)localObject2).getLayoutParams();
                        m = localLayoutParams.leftMargin - m;
                        k = localLayoutParams.rightMargin - k;
                        i3 = Math.max(0, m);
                        i4 = Math.max(0, k);
                        m = Math.max(0, -m);
                        k = Math.max(0, -k);
                        i5 = ((View)localObject2).getMeasuredWidth();
                        paramInt4 += 1;
                        paramInt3 += i5 + i3 + i4;
                      }
                      paramInt4 = (i1 - j - i2) / 2 + j - paramInt3 / 2;
                      paramInt3 = paramInt4 + paramInt3;
                      if (paramInt4 < paramInt1) {}
                      for (;;)
                      {
                        paramInt4 = this.amw.size();
                        paramInt3 = 0;
                        paramInt2 = paramInt1;
                        paramInt1 = paramInt3;
                        while (paramInt1 < paramInt4)
                        {
                          paramInt2 = a((View)this.amw.get(paramInt1), paramInt2, arrayOfInt, i);
                          paramInt1 += 1;
                        }
                        paramInt1 = paramInt4;
                        if (paramInt3 > paramInt2) {
                          paramInt1 = paramInt4 - (paramInt3 - paramInt2);
                        }
                      }
                      this.amw.clear();
                      return;
                    }
                    k = paramInt2;
                  }
                }
              }
              paramInt4 = paramInt3;
            }
          }
        }
        label898:
        label904:
        label1731:
        paramInt3 = paramInt2;
        label1025:
        paramInt2 = paramInt1;
      }
      label1739:
      paramInt2 = j;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = this.amy;
    int n;
    int i1;
    int i;
    int m;
    int k;
    if (bf.bF(this))
    {
      n = 0;
      i1 = 1;
      i = 0;
      if (!bA(this.amc)) {
        break label1008;
      }
      i(this.amc, paramInt1, 0, paramInt2, this.aml);
      i = this.amc.getMeasuredWidth() + bB(this.amc);
      m = Math.max(0, this.amc.getMeasuredHeight() + bC(this.amc));
      k = View.combineMeasuredStates(0, this.amc.getMeasuredState());
    }
    for (;;)
    {
      int i2 = i;
      i = k;
      int j = m;
      if (bA(this.amg))
      {
        i(this.amg, paramInt1, 0, paramInt2, this.aml);
        i2 = this.amg.getMeasuredWidth() + bB(this.amg);
        j = Math.max(m, this.amg.getMeasuredHeight() + bC(this.amg));
        i = View.combineMeasuredStates(k, this.amg.getMeasuredState());
      }
      k = getCurrentContentInsetStart();
      int i3 = Math.max(k, i2) + 0;
      localObject[i1] = Math.max(0, k - i2);
      i1 = 0;
      k = i;
      m = j;
      if (bA(this.WC))
      {
        i(this.WC, paramInt1, i3, paramInt2, this.aml);
        i1 = this.WC.getMeasuredWidth() + bB(this.WC);
        m = Math.max(j, this.WC.getMeasuredHeight() + bC(this.WC));
        k = View.combineMeasuredStates(i, this.WC.getMeasuredState());
      }
      i = getCurrentContentInsetEnd();
      i2 = i3 + Math.max(i, i1);
      localObject[n] = Math.max(0, i - i1);
      n = i2;
      i = k;
      j = m;
      if (bA(this.amh))
      {
        n = i2 + a(this.amh, paramInt1, i2, paramInt2, 0, (int[])localObject);
        j = Math.max(m, this.amh.getMeasuredHeight() + bC(this.amh));
        i = View.combineMeasuredStates(k, this.amh.getMeasuredState());
      }
      k = n;
      i1 = i;
      m = j;
      if (bA(this.amd))
      {
        k = n + a(this.amd, paramInt1, n, paramInt2, 0, (int[])localObject);
        m = Math.max(j, this.amd.getMeasuredHeight() + bC(this.amd));
        i1 = View.combineMeasuredStates(i, this.amd.getMeasuredState());
      }
      i2 = getChildCount();
      n = 0;
      i = i1;
      j = m;
      m = n;
      i1 = k;
      label512:
      if (m < i2)
      {
        View localView = getChildAt(m);
        if ((((LayoutParams)localView.getLayoutParams()).amH != 0) || (!bA(localView))) {
          break label995;
        }
        i1 += a(localView, paramInt1, i1, paramInt2, 0, (int[])localObject);
        k = Math.max(j, localView.getMeasuredHeight() + bC(localView));
        j = View.combineMeasuredStates(i, localView.getMeasuredState());
      }
      for (i = k;; i = k)
      {
        m += 1;
        k = i;
        i = j;
        j = k;
        break label512;
        n = 1;
        i1 = 0;
        break;
        n = 0;
        m = 0;
        int i4 = this.amo + this.amp;
        int i5 = this.amm + this.amn;
        k = i;
        if (bA(this.ama))
        {
          a(this.ama, paramInt1, i1 + i5, paramInt2, i4, (int[])localObject);
          k = this.ama.getMeasuredWidth();
          n = bB(this.ama) + k;
          m = this.ama.getMeasuredHeight() + bC(this.ama);
          k = View.combineMeasuredStates(i, this.ama.getMeasuredState());
        }
        i3 = m;
        i2 = n;
        i = k;
        if (bA(this.amb))
        {
          i2 = Math.max(n, a(this.amb, paramInt1, i1 + i5, paramInt2, i4 + m, (int[])localObject));
          i3 = m + (this.amb.getMeasuredHeight() + bC(this.amb));
          i = View.combineMeasuredStates(k, this.amb.getMeasuredState());
        }
        k = Math.max(j, i3);
        j = getPaddingLeft();
        i3 = getPaddingRight();
        m = getPaddingTop();
        n = getPaddingBottom();
        j = View.resolveSizeAndState(Math.max(i2 + i1 + (j + i3), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i);
        paramInt2 = View.resolveSizeAndState(Math.max(k + (m + n), getSuggestedMinimumHeight()), paramInt2, i << 16);
        if (!this.ew) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 != 0) {
            paramInt2 = 0;
          }
          setMeasuredDimension(j, paramInt2);
          return;
          i = getChildCount();
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 >= i) {
              break label990;
            }
            localObject = getChildAt(paramInt1);
            if ((bA((View)localObject)) && (((View)localObject).getMeasuredWidth() > 0) && (((View)localObject).getMeasuredHeight() > 0))
            {
              paramInt1 = 0;
              break;
            }
            paramInt1 += 1;
          }
          label990:
          paramInt1 = 1;
        }
        label995:
        k = j;
        j = i;
      }
      label1008:
      k = 0;
      m = 0;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.EA);
    if (this.WC != null) {}
    for (paramParcelable = this.WC.dm;; paramParcelable = null)
    {
      if ((localSavedState.amI != 0) && (this.amD != null) && (paramParcelable != null))
      {
        paramParcelable = paramParcelable.findItem(localSavedState.amI);
        if (paramParcelable != null) {
          paramParcelable.expandActionView();
        }
      }
      if (!localSavedState.amJ) {
        break;
      }
      removeCallbacks(this.amE);
      post(this.amE);
      return;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    ja();
    ao localao = this.amq;
    if (paramInt == 1) {
      if (bool != localao.gz)
      {
        localao.gz = bool;
        if (!localao.aiK) {
          break label168;
        }
        if (!bool) {
          break label113;
        }
        if (localao.Eo == -2147483648) {
          break label97;
        }
        paramInt = localao.Eo;
        label67:
        localao.pR = paramInt;
        if (localao.aiH == -2147483648) {
          break label105;
        }
      }
    }
    label97:
    label105:
    for (paramInt = localao.aiH;; paramInt = localao.aiJ)
    {
      localao.pT = paramInt;
      return;
      bool = false;
      break;
      paramInt = localao.aiI;
      break label67;
    }
    label113:
    if (localao.aiH != -2147483648)
    {
      paramInt = localao.aiH;
      localao.pR = paramInt;
      if (localao.Eo == -2147483648) {
        break label160;
      }
    }
    label160:
    for (paramInt = localao.Eo;; paramInt = localao.aiJ)
    {
      localao.pT = paramInt;
      return;
      paramInt = localao.aiI;
      break;
    }
    label168:
    localao.pR = localao.aiI;
    localao.pT = localao.aiJ;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((this.amD != null) && (this.amD.amG != null)) {
      localSavedState.amI = this.amD.amG.getItemId();
    }
    localSavedState.amJ = isOverflowMenuShowing();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.WG = false;
    }
    if (!this.WG)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.WG = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.WG = false;
    }
    return true;
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.ew = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = -2147483648;
    }
    if (i != this.ams)
    {
      this.ams = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setContentInsetStartWithNavigation(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = -2147483648;
    }
    if (i != this.amr)
    {
      this.amr = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setLogo(int paramInt)
  {
    setLogo(b.g(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      iV();
      if (!bD(this.amd)) {
        g(this.amd, true);
      }
    }
    for (;;)
    {
      if (this.amd != null) {
        this.amd.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.amd != null) && (bD(this.amd)))
      {
        removeView(this.amd);
        this.amx.remove(this.amd);
      }
    }
  }
  
  public void setLogoDescription(int paramInt)
  {
    setLogoDescription(getContext().getText(paramInt));
  }
  
  public void setLogoDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      iV();
    }
    if (this.amd != null) {
      this.amd.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = getContext().getText(paramInt);; localCharSequence = null)
    {
      setNavigationContentDescription(localCharSequence);
      return;
    }
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      iY();
    }
    if (this.amc != null) {
      this.amc.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationIcon(int paramInt)
  {
    setNavigationIcon(b.g(getContext(), paramInt));
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      iY();
      if (!bD(this.amc)) {
        g(this.amc, true);
      }
    }
    for (;;)
    {
      if (this.amc != null) {
        this.amc.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.amc != null) && (bD(this.amc)))
      {
        removeView(this.amc);
        this.amx.remove(this.amc);
      }
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    iY();
    this.amc.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(b paramb)
  {
    this.amz = paramb;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    iW();
    this.WC.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.Yd != paramInt)
    {
      this.Yd = paramInt;
      if (paramInt == 0) {
        this.WB = getContext();
      }
    }
    else
    {
      return;
    }
    this.WB = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.amb == null)
      {
        Context localContext = getContext();
        this.amb = new AppCompatTextView(localContext);
        this.amb.setSingleLine();
        this.amb.setEllipsize(TextUtils.TruncateAt.END);
        if (this.amj != 0) {
          this.amb.setTextAppearance(localContext, this.amj);
        }
        if (this.amv != 0) {
          this.amb.setTextColor(this.amv);
        }
      }
      if (!bD(this.amb)) {
        g(this.amb, true);
      }
    }
    for (;;)
    {
      if (this.amb != null) {
        this.amb.setText(paramCharSequence);
      }
      this.amu = paramCharSequence;
      return;
      if ((this.amb != null) && (bD(this.amb)))
      {
        removeView(this.amb);
        this.amx.remove(this.amb);
      }
    }
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    this.amv = paramInt;
    if (this.amb != null) {
      this.amb.setTextColor(paramInt);
    }
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getContext().getText(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.ama == null)
      {
        Context localContext = getContext();
        this.ama = new AppCompatTextView(localContext);
        this.ama.setSingleLine();
        this.ama.setEllipsize(TextUtils.TruncateAt.END);
        if (this.ami != 0) {
          this.ama.setTextAppearance(localContext, this.ami);
        }
        if (this.RZ != 0) {
          this.ama.setTextColor(this.RZ);
        }
      }
      if (!bD(this.ama)) {
        g(this.ama, true);
      }
    }
    for (;;)
    {
      if (this.ama != null) {
        this.ama.setText(paramCharSequence);
      }
      this.amt = paramCharSequence;
      return;
      if ((this.ama != null) && (bD(this.ama)))
      {
        removeView(this.ama);
        this.amx.remove(this.ama);
      }
    }
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    this.amp = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    this.amn = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    this.amm = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    this.amo = paramInt;
    requestLayout();
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.RZ = paramInt;
    if (this.ama != null) {
      this.ama.setTextColor(paramInt);
    }
  }
  
  public final boolean showOverflowMenu()
  {
    if (this.WC != null)
    {
      ActionMenuView localActionMenuView = this.WC;
      if ((localActionMenuView.Ye != null) && (localActionMenuView.Ye.showOverflowMenu())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public static class LayoutParams
    extends ActionBar.LayoutParams
  {
    int amH = 0;
    
    public LayoutParams()
    {
      this.gravity = 8388627;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ActionBar.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.amH = paramLayoutParams.amH;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.leftMargin = paramMarginLayoutParams.leftMargin;
      this.topMargin = paramMarginLayoutParams.topMargin;
      this.rightMargin = paramMarginLayoutParams.rightMargin;
      this.bottomMargin = paramMarginLayoutParams.bottomMargin;
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    int amI;
    boolean amJ;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.amI = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.amJ = bool;
        return;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.amI);
      if (this.amJ) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  private final class a
    implements o
  {
    j amG;
    h dm;
    
    a() {}
    
    public final boolean V()
    {
      return false;
    }
    
    public final void a(Context paramContext, h paramh)
    {
      if ((this.dm != null) && (this.amG != null)) {
        this.dm.h(this.amG);
      }
      this.dm = paramh;
    }
    
    public final void a(h paramh, boolean paramBoolean) {}
    
    public final void a(o.a parama) {}
    
    public final boolean a(u paramu)
    {
      return false;
    }
    
    public final boolean b(j paramj)
    {
      Object localObject1 = Toolbar.this;
      Object localObject2;
      if (((Toolbar)localObject1).amg == null)
      {
        ((Toolbar)localObject1).amg = new AppCompatImageButton(((Toolbar)localObject1).getContext(), null, a.a.toolbarNavigationButtonStyle);
        ((Toolbar)localObject1).amg.setImageDrawable(((Toolbar)localObject1).ame);
        ((Toolbar)localObject1).amg.setContentDescription(((Toolbar)localObject1).amf);
        localObject2 = new Toolbar.LayoutParams();
        ((Toolbar.LayoutParams)localObject2).gravity = (((Toolbar)localObject1).amk & 0x70 | 0x800003);
        ((Toolbar.LayoutParams)localObject2).amH = 2;
        ((Toolbar)localObject1).amg.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((Toolbar)localObject1).amg.setOnClickListener(new Toolbar.3((Toolbar)localObject1));
      }
      localObject1 = Toolbar.this.amg.getParent();
      if (localObject1 != Toolbar.this)
      {
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(Toolbar.this.amg);
        }
        Toolbar.this.addView(Toolbar.this.amg);
      }
      Toolbar.this.amh = paramj.getActionView();
      this.amG = paramj;
      localObject1 = Toolbar.this.amh.getParent();
      if (localObject1 != Toolbar.this)
      {
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(Toolbar.this.amh);
        }
        localObject1 = Toolbar.iZ();
        ((Toolbar.LayoutParams)localObject1).gravity = (Toolbar.this.amk & 0x70 | 0x800003);
        ((Toolbar.LayoutParams)localObject1).amH = 2;
        Toolbar.this.amh.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        Toolbar.this.addView(Toolbar.this.amh);
      }
      localObject1 = Toolbar.this;
      int i = ((Toolbar)localObject1).getChildCount() - 1;
      while (i >= 0)
      {
        localObject2 = ((Toolbar)localObject1).getChildAt(i);
        if ((((Toolbar.LayoutParams)((View)localObject2).getLayoutParams()).amH != 2) && (localObject2 != ((Toolbar)localObject1).WC))
        {
          ((Toolbar)localObject1).removeViewAt(i);
          ((Toolbar)localObject1).amx.add(localObject2);
        }
        i -= 1;
      }
      Toolbar.this.requestLayout();
      paramj.Y(true);
      if ((Toolbar.this.amh instanceof c)) {
        ((c)Toolbar.this.amh).onActionViewExpanded();
      }
      return true;
    }
    
    public final boolean c(j paramj)
    {
      if ((Toolbar.this.amh instanceof c)) {
        ((c)Toolbar.this.amh).onActionViewCollapsed();
      }
      Toolbar.this.removeView(Toolbar.this.amh);
      Toolbar.this.removeView(Toolbar.this.amg);
      Toolbar.this.amh = null;
      Toolbar localToolbar = Toolbar.this;
      int i = localToolbar.amx.size() - 1;
      while (i >= 0)
      {
        localToolbar.addView((View)localToolbar.amx.get(i));
        i -= 1;
      }
      localToolbar.amx.clear();
      this.amG = null;
      Toolbar.this.requestLayout();
      paramj.Y(false);
      return true;
    }
    
    public final int getId()
    {
      return 0;
    }
    
    public final void o(boolean paramBoolean)
    {
      int k = 0;
      int j;
      int m;
      int i;
      if (this.amG != null)
      {
        j = k;
        if (this.dm != null)
        {
          m = this.dm.size();
          i = 0;
        }
      }
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (this.dm.getItem(i) == this.amG) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            c(this.amG);
          }
          return;
        }
        i += 1;
      }
    }
    
    public final void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    public final Parcelable onSaveInstanceState()
    {
      return null;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.Toolbar
 * JD-Core Version:    0.7.0.1
 */