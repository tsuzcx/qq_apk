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
import android.support.v4.view.t;
import android.support.v7.a.a.a;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.c.a.a;
import android.support.v7.view.c;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.o.a;
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
  private int Kk = 8388627;
  private int abu;
  private Context ahe;
  ActionMenuView ahf;
  private boolean ahj;
  private boolean ahk;
  private int aiF;
  o.a aiH;
  h.a aiI;
  TextView ayB;
  TextView ayC;
  private ImageButton ayD;
  private ImageView ayE;
  private Drawable ayF;
  private CharSequence ayG;
  ImageButton ayH;
  View ayI;
  int ayJ;
  int ayK;
  int ayL;
  private int ayM;
  private int ayN;
  private int ayO;
  private int ayP;
  private int ayQ;
  ap ayR;
  private int ayS;
  private int ayT;
  private CharSequence ayU;
  private CharSequence ayV;
  private int ayW;
  private final ArrayList<View> ayX = new ArrayList();
  final ArrayList<View> ayY = new ArrayList();
  private final int[] ayZ = new int[2];
  b aza;
  private final ActionMenuView.d azb = new ActionMenuView.d()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      if (Toolbar.this.aza != null) {
        return Toolbar.this.aza.onMenuItemClick(paramAnonymousMenuItem);
      }
      return false;
    }
  };
  private ba azc;
  private ActionMenuPresenter azd;
  a aze;
  private boolean azf;
  private final Runnable azg = new Runnable()
  {
    public final void run()
    {
      Toolbar.this.showOverflowMenu();
    }
  };
  
  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969607);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = az.a(getContext(), paramAttributeSet, a.a.Toolbar, paramInt, 0);
    this.ayJ = paramContext.getResourceId(27, 0);
    this.ayK = paramContext.getResourceId(18, 0);
    this.Kk = paramContext.getInteger(0, this.Kk);
    this.ayL = paramContext.getInteger(2, 48);
    int i = paramContext.getDimensionPixelOffset(21, 0);
    paramInt = i;
    if (paramContext.hasValue(26)) {
      paramInt = paramContext.getDimensionPixelOffset(26, i);
    }
    this.ayQ = paramInt;
    this.ayP = paramInt;
    this.ayO = paramInt;
    this.ayN = paramInt;
    paramInt = paramContext.getDimensionPixelOffset(24, -1);
    if (paramInt >= 0) {
      this.ayN = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(23, -1);
    if (paramInt >= 0) {
      this.ayO = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(25, -1);
    if (paramInt >= 0) {
      this.ayP = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(22, -1);
    if (paramInt >= 0) {
      this.ayQ = paramInt;
    }
    this.ayM = paramContext.getDimensionPixelSize(13, -1);
    paramInt = paramContext.getDimensionPixelOffset(9, -2147483648);
    i = paramContext.getDimensionPixelOffset(5, -2147483648);
    int j = paramContext.getDimensionPixelSize(7, 0);
    int k = paramContext.getDimensionPixelSize(8, 0);
    nb();
    this.ayR.aH(j, k);
    if ((paramInt != -2147483648) || (i != -2147483648)) {
      this.ayR.aG(paramInt, i);
    }
    this.ayS = paramContext.getDimensionPixelOffset(10, -2147483648);
    this.ayT = paramContext.getDimensionPixelOffset(6, -2147483648);
    this.ayF = paramContext.getDrawable(4);
    this.ayG = paramContext.getText(3);
    paramAttributeSet = paramContext.getText(20);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(17);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    this.ahe = getContext();
    setPopupTheme(paramContext.getResourceId(16, 0));
    paramAttributeSet = paramContext.getDrawable(15);
    if (paramAttributeSet != null) {
      setNavigationIcon(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(14);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setNavigationContentDescription(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(11);
    if (paramAttributeSet != null) {
      setLogo(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(12);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setLogoDescription(paramAttributeSet);
    }
    if (paramContext.hasValue(28)) {
      setTitleTextColor(paramContext.getColor(28, -1));
    }
    if (paramContext.hasValue(19)) {
      setSubtitleTextColor(paramContext.getColor(19, -1));
    }
    paramContext.ayA.recycle();
  }
  
  private int I(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int j = paramView.getMeasuredHeight();
    int i;
    int k;
    int m;
    if (paramInt > 0)
    {
      paramInt = (j - paramInt) / 2;
      switch (dc(localLayoutParams.gravity))
      {
      default: 
        i = getPaddingTop();
        k = getPaddingBottom();
        m = getHeight();
        paramInt = (m - i - k - j) / 2;
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
      return getHeight() - getPaddingBottom() - j - localLayoutParams.bottomMargin - paramInt;
      j = m - k - j - paramInt - i;
      if (j < localLayoutParams.bottomMargin) {
        paramInt = Math.max(0, paramInt - (localLayoutParams.bottomMargin - j));
      }
    }
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
    paramInt2 = I(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i, paramView.getMeasuredHeight() + paramInt2);
    return localLayoutParams.rightMargin + i + paramInt1;
  }
  
  private void a(List<View> paramList, int paramInt)
  {
    int i = 1;
    int j = 0;
    if (t.Y(this) == 1) {}
    int m;
    int k;
    View localView;
    LayoutParams localLayoutParams;
    for (;;)
    {
      m = getChildCount();
      k = d.getAbsoluteGravity(paramInt, t.Y(this));
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
        if ((localLayoutParams.azj == 0) && (ca(localView)) && (dd(localLayoutParams.gravity) == k)) {
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
      if ((localLayoutParams.azj == 0) && (ca(localView)) && (dd(localLayoutParams.gravity) == k)) {
        paramList.add(localView);
      }
      paramInt += 1;
    }
  }
  
  private int b(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i);
    paramArrayOfInt[1] = Math.max(0, -i);
    paramInt2 = I(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - (localLayoutParams.leftMargin + i);
  }
  
  private boolean ca(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  private static int cb(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = android.support.v4.view.g.a(paramView);
    return android.support.v4.view.g.b(paramView) + i;
  }
  
  private static int cc(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = paramView.topMargin;
    return paramView.bottomMargin + i;
  }
  
  private boolean cd(View paramView)
  {
    return (paramView.getParent() == this) || (this.ayY.contains(paramView));
  }
  
  private int dc(int paramInt)
  {
    int i = paramInt & 0x70;
    paramInt = i;
    switch (i)
    {
    default: 
      paramInt = this.Kk & 0x70;
    }
    return paramInt;
  }
  
  private int dd(int paramInt)
  {
    int j = t.Y(this);
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
  
  private MenuInflater getMenuInflater()
  {
    return new android.support.v7.view.g(getContext());
  }
  
  private void i(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = mZ();
    }
    for (;;)
    {
      ((LayoutParams)localObject).azj = 1;
      if ((!paramBoolean) || (this.ayI == null)) {
        break;
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.ayY.add(paramView);
      return;
      if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
        localObject = e((ViewGroup.LayoutParams)localObject);
      } else {
        localObject = (LayoutParams)localObject;
      }
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void l(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  private void mT()
  {
    if (this.ayE == null) {
      this.ayE = new AppCompatImageView(getContext());
    }
  }
  
  private void mU()
  {
    mV();
    if (this.ahf.aaD == null)
    {
      h localh = (h)this.ahf.getMenu();
      if (this.aze == null) {
        this.aze = new a();
      }
      this.ahf.setExpandedActionViewsExclusive(true);
      localh.a(this.aze, this.ahe);
    }
  }
  
  private void mV()
  {
    if (this.ahf == null)
    {
      this.ahf = new ActionMenuView(getContext());
      this.ahf.setPopupTheme(this.aiF);
      this.ahf.setOnMenuItemClickListener(this.azb);
      this.ahf.a(this.aiH, this.aiI);
      LayoutParams localLayoutParams = mZ();
      localLayoutParams.gravity = (0x800005 | this.ayL & 0x70);
      this.ahf.setLayoutParams(localLayoutParams);
      i(this.ahf, false);
    }
  }
  
  private void mX()
  {
    if (this.ayD == null)
    {
      this.ayD = new AppCompatImageButton(getContext(), null, 2130969606);
      LayoutParams localLayoutParams = mZ();
      localLayoutParams.gravity = (0x800003 | this.ayL & 0x70);
      this.ayD.setLayoutParams(localLayoutParams);
    }
  }
  
  protected static LayoutParams mZ()
  {
    return new LayoutParams(-2);
  }
  
  public final void a(h paramh, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((paramh == null) && (this.ahf == null)) {}
    h localh;
    do
    {
      return;
      mV();
      localh = this.ahf.aaD;
    } while (localh == paramh);
    if (localh != null)
    {
      localh.b(this.azd);
      localh.b(this.aze);
    }
    if (this.aze == null) {
      this.aze = new a();
    }
    paramActionMenuPresenter.aip = true;
    if (paramh != null)
    {
      paramh.a(paramActionMenuPresenter, this.ahe);
      paramh.a(this.aze, this.ahe);
    }
    for (;;)
    {
      this.ahf.setPopupTheme(this.aiF);
      this.ahf.setPresenter(paramActionMenuPresenter);
      this.azd = paramActionMenuPresenter;
      return;
      paramActionMenuPresenter.a(this.ahe, null);
      this.aze.a(this.ahe, null);
      paramActionMenuPresenter.p(true);
      this.aze.p(true);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public final void collapseActionView()
  {
    if (this.aze == null) {}
    for (j localj = null;; localj = this.aze.azi)
    {
      if (localj != null) {
        localj.collapseActionView();
      }
      return;
    }
  }
  
  public int getContentInsetEnd()
  {
    if (this.ayR != null)
    {
      ap localap = this.ayR;
      if (localap.mIsRtl) {
        return localap.Af;
      }
      return localap.Ah;
    }
    return 0;
  }
  
  public int getContentInsetEndWithActions()
  {
    if (this.ayT != -2147483648) {
      return this.ayT;
    }
    return getContentInsetEnd();
  }
  
  public int getContentInsetLeft()
  {
    if (this.ayR != null) {
      return this.ayR.Af;
    }
    return 0;
  }
  
  public int getContentInsetRight()
  {
    if (this.ayR != null) {
      return this.ayR.Ah;
    }
    return 0;
  }
  
  public int getContentInsetStart()
  {
    if (this.ayR != null)
    {
      ap localap = this.ayR;
      if (localap.mIsRtl) {
        return localap.Ah;
      }
      return localap.Af;
    }
    return 0;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    if (this.ayS != -2147483648) {
      return this.ayS;
    }
    return getContentInsetStart();
  }
  
  public int getCurrentContentInsetEnd()
  {
    int i;
    if (this.ahf != null)
    {
      h localh = this.ahf.aaD;
      if ((localh != null) && (localh.hasVisibleItems())) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return Math.max(getContentInsetEnd(), Math.max(this.ayT, 0));
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
    if (t.Y(this) == 1) {
      return getCurrentContentInsetEnd();
    }
    return getCurrentContentInsetStart();
  }
  
  public int getCurrentContentInsetRight()
  {
    if (t.Y(this) == 1) {
      return getCurrentContentInsetStart();
    }
    return getCurrentContentInsetEnd();
  }
  
  public int getCurrentContentInsetStart()
  {
    if (getNavigationIcon() != null) {
      return Math.max(getContentInsetStart(), Math.max(this.ayS, 0));
    }
    return getContentInsetStart();
  }
  
  public Drawable getLogo()
  {
    if (this.ayE != null) {
      return this.ayE.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    if (this.ayE != null) {
      return this.ayE.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    mU();
    return this.ahf.getMenu();
  }
  
  public CharSequence getNavigationContentDescription()
  {
    if (this.ayD != null) {
      return this.ayD.getContentDescription();
    }
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    if (this.ayD != null) {
      return this.ayD.getDrawable();
    }
    return null;
  }
  
  ActionMenuPresenter getOuterActionMenuPresenter()
  {
    return this.azd;
  }
  
  public Drawable getOverflowIcon()
  {
    mU();
    return this.ahf.getOverflowIcon();
  }
  
  Context getPopupContext()
  {
    return this.ahe;
  }
  
  public int getPopupTheme()
  {
    return this.aiF;
  }
  
  public CharSequence getSubtitle()
  {
    return this.ayV;
  }
  
  public CharSequence getTitle()
  {
    return this.ayU;
  }
  
  public int getTitleMarginBottom()
  {
    return this.ayQ;
  }
  
  public int getTitleMarginEnd()
  {
    return this.ayO;
  }
  
  public int getTitleMarginStart()
  {
    return this.ayN;
  }
  
  public int getTitleMarginTop()
  {
    return this.ayP;
  }
  
  public u getWrapper()
  {
    if (this.azc == null) {
      this.azc = new ba(this, true);
    }
    return this.azc;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    if (this.ahf != null)
    {
      ActionMenuView localActionMenuView = this.ahf;
      if ((localActionMenuView.aiG != null) && (localActionMenuView.aiG.isOverflowMenuShowing())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final void mW()
  {
    nb();
    this.ayR.aH(0, 0);
  }
  
  final void mY()
  {
    if (this.ayH == null)
    {
      this.ayH = new AppCompatImageButton(getContext(), null, 2130969606);
      this.ayH.setImageDrawable(this.ayF);
      this.ayH.setContentDescription(this.ayG);
      LayoutParams localLayoutParams = mZ();
      localLayoutParams.gravity = (0x800003 | this.ayL & 0x70);
      localLayoutParams.azj = 2;
      this.ayH.setLayoutParams(localLayoutParams);
      this.ayH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Toolbar.this.collapseActionView();
        }
      });
    }
  }
  
  final void na()
  {
    int i = this.ayY.size() - 1;
    while (i >= 0)
    {
      addView((View)this.ayY.get(i));
      i -= 1;
    }
    this.ayY.clear();
  }
  
  final void nb()
  {
    if (this.ayR == null) {
      this.ayR = new ap();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.azg);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.ahk = false;
    }
    if (!this.ahk)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.ahk = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.ahk = false;
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
    if (t.Y(this) == 1)
    {
      k = 1;
      i1 = getWidth();
      i4 = getHeight();
      j = getPaddingLeft();
      i2 = getPaddingRight();
      i3 = getPaddingTop();
      i5 = getPaddingBottom();
      paramInt1 = i1 - i2;
      arrayOfInt = this.ayZ;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      paramInt3 = t.af(this);
      if (paramInt3 < 0) {
        break label898;
      }
      i = Math.min(paramInt3, paramInt4 - paramInt2);
      label91:
      if (!ca(this.ayD)) {
        break label1739;
      }
      if (k == 0) {
        break label904;
      }
      paramInt1 = b(this.ayD, paramInt1, arrayOfInt, i);
      paramInt2 = j;
    }
    for (;;)
    {
      label124:
      paramInt3 = paramInt1;
      paramInt4 = paramInt2;
      if (ca(this.ayH))
      {
        if (k != 0)
        {
          paramInt3 = b(this.ayH, paramInt1, arrayOfInt, i);
          paramInt4 = paramInt2;
        }
      }
      else
      {
        label164:
        paramInt1 = paramInt3;
        paramInt2 = paramInt4;
        if (ca(this.ahf))
        {
          if (k == 0) {
            break label943;
          }
          paramInt2 = a(this.ahf, paramInt4, arrayOfInt, i);
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
        if (ca(this.ayI))
        {
          if (k == 0) {
            break label964;
          }
          paramInt2 = b(this.ayI, paramInt4, arrayOfInt, i);
          paramInt1 = paramInt3;
        }
        label308:
        if (!ca(this.ayE)) {
          break label1731;
        }
        if (k == 0) {
          break label985;
        }
        paramInt3 = b(this.ayE, paramInt2, arrayOfInt, i);
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        label341:
        paramBoolean = ca(this.ayB);
        boolean bool = ca(this.ayC);
        paramInt1 = 0;
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = (LayoutParams)this.ayB.getLayoutParams();
          paramInt1 = ((LayoutParams)localObject1).topMargin;
          paramInt4 = this.ayB.getMeasuredHeight();
          paramInt1 = ((LayoutParams)localObject1).bottomMargin + (paramInt1 + paramInt4) + 0;
        }
        int m;
        if (bool)
        {
          localObject1 = (LayoutParams)this.ayC.getLayoutParams();
          paramInt4 = ((LayoutParams)localObject1).topMargin;
          m = this.ayC.getMeasuredHeight();
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
            localObject1 = this.ayB;
            if (!bool) {
              break label1016;
            }
            localObject2 = this.ayC;
            label490:
            localObject1 = (LayoutParams)((View)localObject1).getLayoutParams();
            localObject2 = (LayoutParams)((View)localObject2).getLayoutParams();
            if (((!paramBoolean) || (this.ayB.getMeasuredWidth() <= 0)) && ((!bool) || (this.ayC.getMeasuredWidth() <= 0))) {
              break label1025;
            }
            m = 1;
            switch (this.Kk & 0x70)
            {
            default: 
              paramInt1 = (i4 - i3 - i5 - n) / 2;
              if (paramInt1 < ((LayoutParams)localObject1).topMargin + this.ayP) {
                paramInt1 = ((LayoutParams)localObject1).topMargin + this.ayP;
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
                paramInt4 = this.ayN;
                label636:
                paramInt4 -= arrayOfInt[1];
                paramInt3 -= Math.max(0, paramInt4);
                arrayOfInt[1] = Math.max(0, -paramInt4);
                if (!paramBoolean) {
                  break label1715;
                }
                localObject1 = (LayoutParams)this.ayB.getLayoutParams();
                paramInt4 = paramInt3 - this.ayB.getMeasuredWidth();
                k = this.ayB.getMeasuredHeight() + paramInt1;
                this.ayB.layout(paramInt4, paramInt1, paramInt3, k);
                n = this.ayO;
                paramInt1 = k + ((LayoutParams)localObject1).bottomMargin;
                paramInt4 -= n;
              }
            }
            for (;;)
            {
              if (bool)
              {
                localObject1 = (LayoutParams)this.ayC.getLayoutParams();
                paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1;
                k = this.ayC.getMeasuredWidth();
                n = this.ayC.getMeasuredHeight();
                this.ayC.layout(paramInt3 - k, paramInt1, paramInt3, n + paramInt1);
                paramInt1 = this.ayO;
                k = ((LayoutParams)localObject1).bottomMargin;
              }
              for (paramInt1 = paramInt3 - paramInt1;; paramInt1 = paramInt3)
              {
                if (m != 0) {}
                for (paramInt1 = Math.min(paramInt4, paramInt1);; paramInt1 = paramInt3)
                {
                  paramInt4 = paramInt1;
                  paramInt1 = paramInt2;
                  a(this.ayX, 3);
                  paramInt3 = this.ayX.size();
                  paramInt2 = 0;
                  for (;;)
                  {
                    if (paramInt2 < paramInt3)
                    {
                      paramInt1 = a((View)this.ayX.get(paramInt2), paramInt1, arrayOfInt, i);
                      paramInt2 += 1;
                      continue;
                      k = 0;
                      break;
                      i = 0;
                      break label91;
                      paramInt2 = a(this.ayD, j, arrayOfInt, i);
                      break label124;
                      paramInt4 = a(this.ayH, paramInt2, arrayOfInt, i);
                      paramInt3 = paramInt1;
                      break label164;
                      paramInt1 = b(this.ahf, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label204;
                      label964:
                      paramInt1 = a(this.ayI, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label308;
                      label985:
                      paramInt1 = a(this.ayE, paramInt1, arrayOfInt, i);
                      paramInt3 = paramInt2;
                      paramInt2 = paramInt1;
                      break label341;
                      label1007:
                      localObject1 = this.ayC;
                      break label479;
                      label1016:
                      localObject2 = this.ayB;
                      break label490;
                      m = 0;
                      break label542;
                      paramInt1 = getPaddingTop();
                      paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1 + this.ayP;
                      break label620;
                      paramInt4 = i4 - i5 - n - paramInt1 - i3;
                      if (paramInt4 >= ((LayoutParams)localObject1).bottomMargin + this.ayQ) {
                        break label1722;
                      }
                      paramInt1 = Math.max(0, paramInt1 - (((LayoutParams)localObject2).bottomMargin + this.ayQ - paramInt4));
                      break label615;
                      paramInt1 = i4 - i5 - ((LayoutParams)localObject2).bottomMargin - this.ayQ - n;
                      break label620;
                      paramInt4 = 0;
                      break label636;
                      if (m != 0)
                      {
                        paramInt4 = this.ayN;
                        label1145:
                        paramInt4 -= arrayOfInt[0];
                        paramInt2 += Math.max(0, paramInt4);
                        arrayOfInt[0] = Math.max(0, -paramInt4);
                        if (!paramBoolean) {
                          break label1697;
                        }
                        localObject1 = (LayoutParams)this.ayB.getLayoutParams();
                        k = this.ayB.getMeasuredWidth() + paramInt2;
                        paramInt4 = this.ayB.getMeasuredHeight() + paramInt1;
                        this.ayB.layout(paramInt2, paramInt1, k, paramInt4);
                        n = this.ayO;
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
                      localObject1 = (LayoutParams)this.ayC.getLayoutParams();
                      paramInt4 = ((LayoutParams)localObject1).topMargin + paramInt1;
                      paramInt1 = this.ayC.getMeasuredWidth() + paramInt2;
                      n = this.ayC.getMeasuredHeight();
                      this.ayC.layout(paramInt2, paramInt4, paramInt1, n + paramInt4);
                      paramInt4 = this.ayO;
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
                      a(this.ayX, 5);
                      k = this.ayX.size();
                      paramInt3 = 0;
                      paramInt2 = paramInt4;
                      while (paramInt3 < k)
                      {
                        paramInt2 = b((View)this.ayX.get(paramInt3), paramInt2, arrayOfInt, i);
                        paramInt3 += 1;
                      }
                      a(this.ayX, 1);
                      localObject1 = this.ayX;
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
                        paramInt4 = this.ayX.size();
                        paramInt3 = 0;
                        paramInt2 = paramInt1;
                        paramInt1 = paramInt3;
                        while (paramInt1 < paramInt4)
                        {
                          paramInt2 = a((View)this.ayX.get(paramInt1), paramInt2, arrayOfInt, i);
                          paramInt1 += 1;
                        }
                        paramInt1 = paramInt4;
                        if (paramInt3 > paramInt2) {
                          paramInt1 = paramInt4 - (paramInt3 - paramInt2);
                        }
                      }
                      this.ayX.clear();
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
    Object localObject = this.ayZ;
    int n;
    int i1;
    int i;
    int m;
    int k;
    if (bh.d(this))
    {
      n = 0;
      i1 = 1;
      i = 0;
      if (!ca(this.ayD)) {
        break label1008;
      }
      l(this.ayD, paramInt1, 0, paramInt2, this.ayM);
      i = this.ayD.getMeasuredWidth() + cb(this.ayD);
      m = Math.max(0, this.ayD.getMeasuredHeight() + cc(this.ayD));
      k = View.combineMeasuredStates(0, this.ayD.getMeasuredState());
    }
    for (;;)
    {
      int i2 = i;
      i = k;
      int j = m;
      if (ca(this.ayH))
      {
        l(this.ayH, paramInt1, 0, paramInt2, this.ayM);
        i2 = this.ayH.getMeasuredWidth() + cb(this.ayH);
        j = Math.max(m, this.ayH.getMeasuredHeight() + cc(this.ayH));
        i = View.combineMeasuredStates(k, this.ayH.getMeasuredState());
      }
      k = getCurrentContentInsetStart();
      int i3 = Math.max(k, i2) + 0;
      localObject[i1] = Math.max(0, k - i2);
      i1 = 0;
      k = i;
      m = j;
      if (ca(this.ahf))
      {
        l(this.ahf, paramInt1, i3, paramInt2, this.ayM);
        i1 = this.ahf.getMeasuredWidth() + cb(this.ahf);
        m = Math.max(j, this.ahf.getMeasuredHeight() + cc(this.ahf));
        k = View.combineMeasuredStates(i, this.ahf.getMeasuredState());
      }
      i = getCurrentContentInsetEnd();
      i2 = i3 + Math.max(i, i1);
      localObject[n] = Math.max(0, i - i1);
      n = i2;
      i = k;
      j = m;
      if (ca(this.ayI))
      {
        n = i2 + a(this.ayI, paramInt1, i2, paramInt2, 0, (int[])localObject);
        j = Math.max(m, this.ayI.getMeasuredHeight() + cc(this.ayI));
        i = View.combineMeasuredStates(k, this.ayI.getMeasuredState());
      }
      k = n;
      i1 = i;
      m = j;
      if (ca(this.ayE))
      {
        k = n + a(this.ayE, paramInt1, n, paramInt2, 0, (int[])localObject);
        m = Math.max(j, this.ayE.getMeasuredHeight() + cc(this.ayE));
        i1 = View.combineMeasuredStates(i, this.ayE.getMeasuredState());
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
        if ((((LayoutParams)localView.getLayoutParams()).azj != 0) || (!ca(localView))) {
          break label995;
        }
        i1 += a(localView, paramInt1, i1, paramInt2, 0, (int[])localObject);
        k = Math.max(j, localView.getMeasuredHeight() + cc(localView));
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
        int i4 = this.ayP + this.ayQ;
        int i5 = this.ayN + this.ayO;
        k = i;
        if (ca(this.ayB))
        {
          a(this.ayB, paramInt1, i1 + i5, paramInt2, i4, (int[])localObject);
          k = this.ayB.getMeasuredWidth();
          n = cb(this.ayB) + k;
          m = this.ayB.getMeasuredHeight() + cc(this.ayB);
          k = View.combineMeasuredStates(i, this.ayB.getMeasuredState());
        }
        i3 = m;
        i2 = n;
        i = k;
        if (ca(this.ayC))
        {
          i2 = Math.max(n, a(this.ayC, paramInt1, i1 + i5, paramInt2, i4 + m, (int[])localObject));
          i3 = m + (this.ayC.getMeasuredHeight() + cc(this.ayC));
          i = View.combineMeasuredStates(k, this.ayC.getMeasuredState());
        }
        k = Math.max(j, i3);
        j = getPaddingLeft();
        i3 = getPaddingRight();
        m = getPaddingTop();
        n = getPaddingBottom();
        j = View.resolveSizeAndState(Math.max(i2 + i1 + (j + i3), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i);
        paramInt2 = View.resolveSizeAndState(Math.max(k + (m + n), getSuggestedMinimumHeight()), paramInt2, i << 16);
        if (!this.azf) {
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
            if ((ca((View)localObject)) && (((View)localObject).getMeasuredWidth() > 0) && (((View)localObject).getMeasuredHeight() > 0))
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
    super.onRestoreInstanceState(localSavedState.Pa);
    if (this.ahf != null) {}
    for (paramParcelable = this.ahf.aaD;; paramParcelable = null)
    {
      if ((localSavedState.azk != 0) && (this.aze != null) && (paramParcelable != null))
      {
        paramParcelable = paramParcelable.findItem(localSavedState.azk);
        if (paramParcelable != null) {
          paramParcelable.expandActionView();
        }
      }
      if (!localSavedState.azl) {
        break;
      }
      removeCallbacks(this.azg);
      post(this.azg);
      return;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    nb();
    ap localap = this.ayR;
    if (paramInt == 1) {
      if (bool != localap.mIsRtl)
      {
        localap.mIsRtl = bool;
        if (!localap.avm) {
          break label168;
        }
        if (!bool) {
          break label113;
        }
        if (localap.OQ == -2147483648) {
          break label97;
        }
        paramInt = localap.OQ;
        label67:
        localap.Af = paramInt;
        if (localap.avj == -2147483648) {
          break label105;
        }
      }
    }
    label97:
    label105:
    for (paramInt = localap.avj;; paramInt = localap.avl)
    {
      localap.Ah = paramInt;
      return;
      bool = false;
      break;
      paramInt = localap.avk;
      break label67;
    }
    label113:
    if (localap.avj != -2147483648)
    {
      paramInt = localap.avj;
      localap.Af = paramInt;
      if (localap.OQ == -2147483648) {
        break label160;
      }
    }
    label160:
    for (paramInt = localap.OQ;; paramInt = localap.avl)
    {
      localap.Ah = paramInt;
      return;
      paramInt = localap.avk;
      break;
    }
    label168:
    localap.Af = localap.avk;
    localap.Ah = localap.avl;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((this.aze != null) && (this.aze.azi != null)) {
      localSavedState.azk = this.aze.azi.getItemId();
    }
    localSavedState.azl = isOverflowMenuShowing();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.ahj = false;
    }
    if (!this.ahj)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.ahj = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.ahj = false;
    }
    return true;
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.azf = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = -2147483648;
    }
    if (i != this.ayT)
    {
      this.ayT = i;
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
    if (i != this.ayS)
    {
      this.ayS = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setLogo(int paramInt)
  {
    setLogo(a.l(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      mT();
      if (!cd(this.ayE)) {
        i(this.ayE, true);
      }
    }
    for (;;)
    {
      if (this.ayE != null) {
        this.ayE.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.ayE != null) && (cd(this.ayE)))
      {
        removeView(this.ayE);
        this.ayY.remove(this.ayE);
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
      mT();
    }
    if (this.ayE != null) {
      this.ayE.setContentDescription(paramCharSequence);
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
      mX();
    }
    if (this.ayD != null) {
      this.ayD.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationIcon(int paramInt)
  {
    setNavigationIcon(a.l(getContext(), paramInt));
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      mX();
      if (!cd(this.ayD)) {
        i(this.ayD, true);
      }
    }
    for (;;)
    {
      if (this.ayD != null) {
        this.ayD.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.ayD != null) && (cd(this.ayD)))
      {
        removeView(this.ayD);
        this.ayY.remove(this.ayD);
      }
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    mX();
    this.ayD.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(b paramb)
  {
    this.aza = paramb;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    mU();
    this.ahf.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.aiF != paramInt)
    {
      this.aiF = paramInt;
      if (paramInt == 0) {
        this.ahe = getContext();
      }
    }
    else
    {
      return;
    }
    this.ahe = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.ayC == null)
      {
        Context localContext = getContext();
        this.ayC = new AppCompatTextView(localContext);
        this.ayC.setSingleLine();
        this.ayC.setEllipsize(TextUtils.TruncateAt.END);
        if (this.ayK != 0) {
          this.ayC.setTextAppearance(localContext, this.ayK);
        }
        if (this.ayW != 0) {
          this.ayC.setTextColor(this.ayW);
        }
      }
      if (!cd(this.ayC)) {
        i(this.ayC, true);
      }
    }
    for (;;)
    {
      if (this.ayC != null) {
        this.ayC.setText(paramCharSequence);
      }
      this.ayV = paramCharSequence;
      return;
      if ((this.ayC != null) && (cd(this.ayC)))
      {
        removeView(this.ayC);
        this.ayY.remove(this.ayC);
      }
    }
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    this.ayW = paramInt;
    if (this.ayC != null) {
      this.ayC.setTextColor(paramInt);
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
      if (this.ayB == null)
      {
        Context localContext = getContext();
        this.ayB = new AppCompatTextView(localContext);
        this.ayB.setSingleLine();
        this.ayB.setEllipsize(TextUtils.TruncateAt.END);
        if (this.ayJ != 0) {
          this.ayB.setTextAppearance(localContext, this.ayJ);
        }
        if (this.abu != 0) {
          this.ayB.setTextColor(this.abu);
        }
      }
      if (!cd(this.ayB)) {
        i(this.ayB, true);
      }
    }
    for (;;)
    {
      if (this.ayB != null) {
        this.ayB.setText(paramCharSequence);
      }
      this.ayU = paramCharSequence;
      return;
      if ((this.ayB != null) && (cd(this.ayB)))
      {
        removeView(this.ayB);
        this.ayY.remove(this.ayB);
      }
    }
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    this.ayQ = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    this.ayO = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    this.ayN = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    this.ayP = paramInt;
    requestLayout();
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.abu = paramInt;
    if (this.ayB != null) {
      this.ayB.setTextColor(paramInt);
    }
  }
  
  public final boolean showOverflowMenu()
  {
    if (this.ahf != null)
    {
      ActionMenuView localActionMenuView = this.ahf;
      if ((localActionMenuView.aiG != null) && (localActionMenuView.aiG.showOverflowMenu())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public static class LayoutParams
    extends ActionBar.LayoutParams
  {
    int azj = 0;
    
    public LayoutParams(int paramInt)
    {
      super();
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
      this.azj = paramLayoutParams.azj;
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
    int azk;
    boolean azl;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.azk = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.azl = bool;
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
      paramParcel.writeInt(this.azk);
      if (this.azl) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  final class a
    implements o
  {
    h aaD;
    j azi;
    
    a() {}
    
    public final void a(Context paramContext, h paramh)
    {
      if ((this.aaD != null) && (this.azi != null)) {
        this.aaD.h(this.azi);
      }
      this.aaD = paramh;
    }
    
    public final void a(h paramh, boolean paramBoolean) {}
    
    public final void a(o.a parama) {}
    
    public final boolean a(android.support.v7.view.menu.u paramu)
    {
      return false;
    }
    
    public final boolean b(j paramj)
    {
      Toolbar.this.mY();
      Object localObject = Toolbar.this.ayH.getParent();
      if (localObject != Toolbar.this)
      {
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(Toolbar.this.ayH);
        }
        Toolbar.this.addView(Toolbar.this.ayH);
      }
      Toolbar.this.ayI = paramj.getActionView();
      this.azi = paramj;
      localObject = Toolbar.this.ayI.getParent();
      if (localObject != Toolbar.this)
      {
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(Toolbar.this.ayI);
        }
        localObject = Toolbar.mZ();
        ((Toolbar.LayoutParams)localObject).gravity = (0x800003 | Toolbar.this.ayL & 0x70);
        ((Toolbar.LayoutParams)localObject).azj = 2;
        Toolbar.this.ayI.setLayoutParams((ViewGroup.LayoutParams)localObject);
        Toolbar.this.addView(Toolbar.this.ayI);
      }
      localObject = Toolbar.this;
      int i = ((Toolbar)localObject).getChildCount() - 1;
      while (i >= 0)
      {
        View localView = ((Toolbar)localObject).getChildAt(i);
        if ((((Toolbar.LayoutParams)localView.getLayoutParams()).azj != 2) && (localView != ((Toolbar)localObject).ahf))
        {
          ((Toolbar)localObject).removeViewAt(i);
          ((Toolbar)localObject).ayY.add(localView);
        }
        i -= 1;
      }
      Toolbar.this.requestLayout();
      paramj.ag(true);
      if ((Toolbar.this.ayI instanceof c)) {
        ((c)Toolbar.this.ayI).onActionViewExpanded();
      }
      return true;
    }
    
    public final boolean bD()
    {
      return false;
    }
    
    public final boolean c(j paramj)
    {
      if ((Toolbar.this.ayI instanceof c)) {
        ((c)Toolbar.this.ayI).onActionViewCollapsed();
      }
      Toolbar.this.removeView(Toolbar.this.ayI);
      Toolbar.this.removeView(Toolbar.this.ayH);
      Toolbar.this.ayI = null;
      Toolbar.this.na();
      this.azi = null;
      Toolbar.this.requestLayout();
      paramj.ag(false);
      return true;
    }
    
    public final int getId()
    {
      return 0;
    }
    
    public final void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    public final Parcelable onSaveInstanceState()
    {
      return null;
    }
    
    public final void p(boolean paramBoolean)
    {
      int k = 0;
      int j;
      int m;
      int i;
      if (this.azi != null)
      {
        j = k;
        if (this.aaD != null)
        {
          m = this.aaD.size();
          i = 0;
        }
      }
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (this.aaD.getItem(i) == this.azi) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            c(this.azi);
          }
          return;
        }
        i += 1;
      }
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