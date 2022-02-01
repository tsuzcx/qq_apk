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
  private int Hu = 8388627;
  private int YJ;
  private Context aet;
  ActionMenuView aeu;
  private boolean aey;
  private boolean aez;
  private int afU;
  o.a afW;
  h.a afX;
  TextView avQ;
  TextView avR;
  private ImageButton avS;
  private ImageView avT;
  private Drawable avU;
  private CharSequence avV;
  ImageButton avW;
  View avX;
  int avY;
  int avZ;
  int awa;
  private int awb;
  private int awc;
  private int awd;
  private int awe;
  private int awf;
  ap awg;
  private int awh;
  private int awi;
  private CharSequence awj;
  private CharSequence awk;
  private int awl;
  private final ArrayList<View> awm = new ArrayList();
  final ArrayList<View> awn = new ArrayList();
  private final int[] awo = new int[2];
  b awp;
  private final ActionMenuView.d awq = new ActionMenuView.d()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      if (Toolbar.this.awp != null) {
        return Toolbar.this.awp.onMenuItemClick(paramAnonymousMenuItem);
      }
      return false;
    }
  };
  private ba awr;
  private ActionMenuPresenter aws;
  a awt;
  private boolean awu;
  private final Runnable awv = new Runnable()
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
    this.avY = paramContext.getResourceId(27, 0);
    this.avZ = paramContext.getResourceId(18, 0);
    this.Hu = paramContext.getInteger(0, this.Hu);
    this.awa = paramContext.getInteger(2, 48);
    int i = paramContext.getDimensionPixelOffset(21, 0);
    paramInt = i;
    if (paramContext.hasValue(26)) {
      paramInt = paramContext.getDimensionPixelOffset(26, i);
    }
    this.awf = paramInt;
    this.awe = paramInt;
    this.awd = paramInt;
    this.awc = paramInt;
    paramInt = paramContext.getDimensionPixelOffset(24, -1);
    if (paramInt >= 0) {
      this.awc = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(23, -1);
    if (paramInt >= 0) {
      this.awd = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(25, -1);
    if (paramInt >= 0) {
      this.awe = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(22, -1);
    if (paramInt >= 0) {
      this.awf = paramInt;
    }
    this.awb = paramContext.getDimensionPixelSize(13, -1);
    paramInt = paramContext.getDimensionPixelOffset(9, -2147483648);
    i = paramContext.getDimensionPixelOffset(5, -2147483648);
    int j = paramContext.getDimensionPixelSize(7, 0);
    int k = paramContext.getDimensionPixelSize(8, 0);
    mz();
    this.awg.aG(j, k);
    if ((paramInt != -2147483648) || (i != -2147483648)) {
      this.awg.aF(paramInt, i);
    }
    this.awh = paramContext.getDimensionPixelOffset(10, -2147483648);
    this.awi = paramContext.getDimensionPixelOffset(6, -2147483648);
    this.avU = paramContext.getDrawable(4);
    this.avV = paramContext.getText(3);
    paramAttributeSet = paramContext.getText(20);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(17);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    this.aet = getContext();
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
    paramContext.avP.recycle();
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
      switch (dd(localLayoutParams.gravity))
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
        if ((localLayoutParams.awy == 0) && (ca(localView)) && (de(localLayoutParams.gravity) == k)) {
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
      if ((localLayoutParams.awy == 0) && (ca(localView)) && (de(localLayoutParams.gravity) == k)) {
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
    return (paramView.getParent() == this) || (this.awn.contains(paramView));
  }
  
  private int dd(int paramInt)
  {
    int i = paramInt & 0x70;
    paramInt = i;
    switch (i)
    {
    default: 
      paramInt = this.Hu & 0x70;
    }
    return paramInt;
  }
  
  private int de(int paramInt)
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
      localObject = mx();
    }
    for (;;)
    {
      ((LayoutParams)localObject).awy = 1;
      if ((!paramBoolean) || (this.avX == null)) {
        break;
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.awn.add(paramView);
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
  
  private void mr()
  {
    if (this.avT == null) {
      this.avT = new AppCompatImageView(getContext());
    }
  }
  
  private void ms()
  {
    mt();
    if (this.aeu.XT == null)
    {
      h localh = (h)this.aeu.getMenu();
      if (this.awt == null) {
        this.awt = new a();
      }
      this.aeu.setExpandedActionViewsExclusive(true);
      localh.a(this.awt, this.aet);
    }
  }
  
  private void mt()
  {
    if (this.aeu == null)
    {
      this.aeu = new ActionMenuView(getContext());
      this.aeu.setPopupTheme(this.afU);
      this.aeu.setOnMenuItemClickListener(this.awq);
      this.aeu.a(this.afW, this.afX);
      LayoutParams localLayoutParams = mx();
      localLayoutParams.gravity = (0x800005 | this.awa & 0x70);
      this.aeu.setLayoutParams(localLayoutParams);
      i(this.aeu, false);
    }
  }
  
  private void mv()
  {
    if (this.avS == null)
    {
      this.avS = new AppCompatImageButton(getContext(), null, 2130969606);
      LayoutParams localLayoutParams = mx();
      localLayoutParams.gravity = (0x800003 | this.awa & 0x70);
      this.avS.setLayoutParams(localLayoutParams);
    }
  }
  
  protected static LayoutParams mx()
  {
    return new LayoutParams(-2);
  }
  
  public final void a(h paramh, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((paramh == null) && (this.aeu == null)) {}
    h localh;
    do
    {
      return;
      mt();
      localh = this.aeu.XT;
    } while (localh == paramh);
    if (localh != null)
    {
      localh.b(this.aws);
      localh.b(this.awt);
    }
    if (this.awt == null) {
      this.awt = new a();
    }
    paramActionMenuPresenter.afE = true;
    if (paramh != null)
    {
      paramh.a(paramActionMenuPresenter, this.aet);
      paramh.a(this.awt, this.aet);
    }
    for (;;)
    {
      this.aeu.setPopupTheme(this.afU);
      this.aeu.setPresenter(paramActionMenuPresenter);
      this.aws = paramActionMenuPresenter;
      return;
      paramActionMenuPresenter.a(this.aet, null);
      this.awt.a(this.aet, null);
      paramActionMenuPresenter.p(true);
      this.awt.p(true);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public final void collapseActionView()
  {
    if (this.awt == null) {}
    for (j localj = null;; localj = this.awt.awx)
    {
      if (localj != null) {
        localj.collapseActionView();
      }
      return;
    }
  }
  
  public int getContentInsetEnd()
  {
    if (this.awg != null)
    {
      ap localap = this.awg;
      if (localap.mIsRtl) {
        return localap.xo;
      }
      return localap.xq;
    }
    return 0;
  }
  
  public int getContentInsetEndWithActions()
  {
    if (this.awi != -2147483648) {
      return this.awi;
    }
    return getContentInsetEnd();
  }
  
  public int getContentInsetLeft()
  {
    if (this.awg != null) {
      return this.awg.xo;
    }
    return 0;
  }
  
  public int getContentInsetRight()
  {
    if (this.awg != null) {
      return this.awg.xq;
    }
    return 0;
  }
  
  public int getContentInsetStart()
  {
    if (this.awg != null)
    {
      ap localap = this.awg;
      if (localap.mIsRtl) {
        return localap.xq;
      }
      return localap.xo;
    }
    return 0;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    if (this.awh != -2147483648) {
      return this.awh;
    }
    return getContentInsetStart();
  }
  
  public int getCurrentContentInsetEnd()
  {
    int i;
    if (this.aeu != null)
    {
      h localh = this.aeu.XT;
      if ((localh != null) && (localh.hasVisibleItems())) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return Math.max(getContentInsetEnd(), Math.max(this.awi, 0));
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
      return Math.max(getContentInsetStart(), Math.max(this.awh, 0));
    }
    return getContentInsetStart();
  }
  
  public Drawable getLogo()
  {
    if (this.avT != null) {
      return this.avT.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    if (this.avT != null) {
      return this.avT.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    ms();
    return this.aeu.getMenu();
  }
  
  public CharSequence getNavigationContentDescription()
  {
    if (this.avS != null) {
      return this.avS.getContentDescription();
    }
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    if (this.avS != null) {
      return this.avS.getDrawable();
    }
    return null;
  }
  
  ActionMenuPresenter getOuterActionMenuPresenter()
  {
    return this.aws;
  }
  
  public Drawable getOverflowIcon()
  {
    ms();
    return this.aeu.getOverflowIcon();
  }
  
  Context getPopupContext()
  {
    return this.aet;
  }
  
  public int getPopupTheme()
  {
    return this.afU;
  }
  
  public CharSequence getSubtitle()
  {
    return this.awk;
  }
  
  public CharSequence getTitle()
  {
    return this.awj;
  }
  
  public int getTitleMarginBottom()
  {
    return this.awf;
  }
  
  public int getTitleMarginEnd()
  {
    return this.awd;
  }
  
  public int getTitleMarginStart()
  {
    return this.awc;
  }
  
  public int getTitleMarginTop()
  {
    return this.awe;
  }
  
  public u getWrapper()
  {
    if (this.awr == null) {
      this.awr = new ba(this, true);
    }
    return this.awr;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    if (this.aeu != null)
    {
      ActionMenuView localActionMenuView = this.aeu;
      if ((localActionMenuView.afV != null) && (localActionMenuView.afV.isOverflowMenuShowing())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final void mu()
  {
    mz();
    this.awg.aG(0, 0);
  }
  
  final void mw()
  {
    if (this.avW == null)
    {
      this.avW = new AppCompatImageButton(getContext(), null, 2130969606);
      this.avW.setImageDrawable(this.avU);
      this.avW.setContentDescription(this.avV);
      LayoutParams localLayoutParams = mx();
      localLayoutParams.gravity = (0x800003 | this.awa & 0x70);
      localLayoutParams.awy = 2;
      this.avW.setLayoutParams(localLayoutParams);
      this.avW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Toolbar.this.collapseActionView();
        }
      });
    }
  }
  
  final void my()
  {
    int i = this.awn.size() - 1;
    while (i >= 0)
    {
      addView((View)this.awn.get(i));
      i -= 1;
    }
    this.awn.clear();
  }
  
  final void mz()
  {
    if (this.awg == null) {
      this.awg = new ap();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.awv);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.aez = false;
    }
    if (!this.aez)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.aez = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.aez = false;
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
      arrayOfInt = this.awo;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      paramInt3 = t.af(this);
      if (paramInt3 < 0) {
        break label898;
      }
      i = Math.min(paramInt3, paramInt4 - paramInt2);
      label91:
      if (!ca(this.avS)) {
        break label1739;
      }
      if (k == 0) {
        break label904;
      }
      paramInt1 = b(this.avS, paramInt1, arrayOfInt, i);
      paramInt2 = j;
    }
    for (;;)
    {
      label124:
      paramInt3 = paramInt1;
      paramInt4 = paramInt2;
      if (ca(this.avW))
      {
        if (k != 0)
        {
          paramInt3 = b(this.avW, paramInt1, arrayOfInt, i);
          paramInt4 = paramInt2;
        }
      }
      else
      {
        label164:
        paramInt1 = paramInt3;
        paramInt2 = paramInt4;
        if (ca(this.aeu))
        {
          if (k == 0) {
            break label943;
          }
          paramInt2 = a(this.aeu, paramInt4, arrayOfInt, i);
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
        if (ca(this.avX))
        {
          if (k == 0) {
            break label964;
          }
          paramInt2 = b(this.avX, paramInt4, arrayOfInt, i);
          paramInt1 = paramInt3;
        }
        label308:
        if (!ca(this.avT)) {
          break label1731;
        }
        if (k == 0) {
          break label985;
        }
        paramInt3 = b(this.avT, paramInt2, arrayOfInt, i);
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        label341:
        paramBoolean = ca(this.avQ);
        boolean bool = ca(this.avR);
        paramInt1 = 0;
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = (LayoutParams)this.avQ.getLayoutParams();
          paramInt1 = ((LayoutParams)localObject1).topMargin;
          paramInt4 = this.avQ.getMeasuredHeight();
          paramInt1 = ((LayoutParams)localObject1).bottomMargin + (paramInt1 + paramInt4) + 0;
        }
        int m;
        if (bool)
        {
          localObject1 = (LayoutParams)this.avR.getLayoutParams();
          paramInt4 = ((LayoutParams)localObject1).topMargin;
          m = this.avR.getMeasuredHeight();
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
            localObject1 = this.avQ;
            if (!bool) {
              break label1016;
            }
            localObject2 = this.avR;
            label490:
            localObject1 = (LayoutParams)((View)localObject1).getLayoutParams();
            localObject2 = (LayoutParams)((View)localObject2).getLayoutParams();
            if (((!paramBoolean) || (this.avQ.getMeasuredWidth() <= 0)) && ((!bool) || (this.avR.getMeasuredWidth() <= 0))) {
              break label1025;
            }
            m = 1;
            switch (this.Hu & 0x70)
            {
            default: 
              paramInt1 = (i4 - i3 - i5 - n) / 2;
              if (paramInt1 < ((LayoutParams)localObject1).topMargin + this.awe) {
                paramInt1 = ((LayoutParams)localObject1).topMargin + this.awe;
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
                paramInt4 = this.awc;
                label636:
                paramInt4 -= arrayOfInt[1];
                paramInt3 -= Math.max(0, paramInt4);
                arrayOfInt[1] = Math.max(0, -paramInt4);
                if (!paramBoolean) {
                  break label1715;
                }
                localObject1 = (LayoutParams)this.avQ.getLayoutParams();
                paramInt4 = paramInt3 - this.avQ.getMeasuredWidth();
                k = this.avQ.getMeasuredHeight() + paramInt1;
                this.avQ.layout(paramInt4, paramInt1, paramInt3, k);
                n = this.awd;
                paramInt1 = k + ((LayoutParams)localObject1).bottomMargin;
                paramInt4 -= n;
              }
            }
            for (;;)
            {
              if (bool)
              {
                localObject1 = (LayoutParams)this.avR.getLayoutParams();
                paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1;
                k = this.avR.getMeasuredWidth();
                n = this.avR.getMeasuredHeight();
                this.avR.layout(paramInt3 - k, paramInt1, paramInt3, n + paramInt1);
                paramInt1 = this.awd;
                k = ((LayoutParams)localObject1).bottomMargin;
              }
              for (paramInt1 = paramInt3 - paramInt1;; paramInt1 = paramInt3)
              {
                if (m != 0) {}
                for (paramInt1 = Math.min(paramInt4, paramInt1);; paramInt1 = paramInt3)
                {
                  paramInt4 = paramInt1;
                  paramInt1 = paramInt2;
                  a(this.awm, 3);
                  paramInt3 = this.awm.size();
                  paramInt2 = 0;
                  for (;;)
                  {
                    if (paramInt2 < paramInt3)
                    {
                      paramInt1 = a((View)this.awm.get(paramInt2), paramInt1, arrayOfInt, i);
                      paramInt2 += 1;
                      continue;
                      k = 0;
                      break;
                      i = 0;
                      break label91;
                      paramInt2 = a(this.avS, j, arrayOfInt, i);
                      break label124;
                      paramInt4 = a(this.avW, paramInt2, arrayOfInt, i);
                      paramInt3 = paramInt1;
                      break label164;
                      paramInt1 = b(this.aeu, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label204;
                      label964:
                      paramInt1 = a(this.avX, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label308;
                      label985:
                      paramInt1 = a(this.avT, paramInt1, arrayOfInt, i);
                      paramInt3 = paramInt2;
                      paramInt2 = paramInt1;
                      break label341;
                      label1007:
                      localObject1 = this.avR;
                      break label479;
                      label1016:
                      localObject2 = this.avQ;
                      break label490;
                      m = 0;
                      break label542;
                      paramInt1 = getPaddingTop();
                      paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1 + this.awe;
                      break label620;
                      paramInt4 = i4 - i5 - n - paramInt1 - i3;
                      if (paramInt4 >= ((LayoutParams)localObject1).bottomMargin + this.awf) {
                        break label1722;
                      }
                      paramInt1 = Math.max(0, paramInt1 - (((LayoutParams)localObject2).bottomMargin + this.awf - paramInt4));
                      break label615;
                      paramInt1 = i4 - i5 - ((LayoutParams)localObject2).bottomMargin - this.awf - n;
                      break label620;
                      paramInt4 = 0;
                      break label636;
                      if (m != 0)
                      {
                        paramInt4 = this.awc;
                        label1145:
                        paramInt4 -= arrayOfInt[0];
                        paramInt2 += Math.max(0, paramInt4);
                        arrayOfInt[0] = Math.max(0, -paramInt4);
                        if (!paramBoolean) {
                          break label1697;
                        }
                        localObject1 = (LayoutParams)this.avQ.getLayoutParams();
                        k = this.avQ.getMeasuredWidth() + paramInt2;
                        paramInt4 = this.avQ.getMeasuredHeight() + paramInt1;
                        this.avQ.layout(paramInt2, paramInt1, k, paramInt4);
                        n = this.awd;
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
                      localObject1 = (LayoutParams)this.avR.getLayoutParams();
                      paramInt4 = ((LayoutParams)localObject1).topMargin + paramInt1;
                      paramInt1 = this.avR.getMeasuredWidth() + paramInt2;
                      n = this.avR.getMeasuredHeight();
                      this.avR.layout(paramInt2, paramInt4, paramInt1, n + paramInt4);
                      paramInt4 = this.awd;
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
                      a(this.awm, 5);
                      k = this.awm.size();
                      paramInt3 = 0;
                      paramInt2 = paramInt4;
                      while (paramInt3 < k)
                      {
                        paramInt2 = b((View)this.awm.get(paramInt3), paramInt2, arrayOfInt, i);
                        paramInt3 += 1;
                      }
                      a(this.awm, 1);
                      localObject1 = this.awm;
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
                        paramInt4 = this.awm.size();
                        paramInt3 = 0;
                        paramInt2 = paramInt1;
                        paramInt1 = paramInt3;
                        while (paramInt1 < paramInt4)
                        {
                          paramInt2 = a((View)this.awm.get(paramInt1), paramInt2, arrayOfInt, i);
                          paramInt1 += 1;
                        }
                        paramInt1 = paramInt4;
                        if (paramInt3 > paramInt2) {
                          paramInt1 = paramInt4 - (paramInt3 - paramInt2);
                        }
                      }
                      this.awm.clear();
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
    Object localObject = this.awo;
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
      if (!ca(this.avS)) {
        break label1008;
      }
      l(this.avS, paramInt1, 0, paramInt2, this.awb);
      i = this.avS.getMeasuredWidth() + cb(this.avS);
      m = Math.max(0, this.avS.getMeasuredHeight() + cc(this.avS));
      k = View.combineMeasuredStates(0, this.avS.getMeasuredState());
    }
    for (;;)
    {
      int i2 = i;
      i = k;
      int j = m;
      if (ca(this.avW))
      {
        l(this.avW, paramInt1, 0, paramInt2, this.awb);
        i2 = this.avW.getMeasuredWidth() + cb(this.avW);
        j = Math.max(m, this.avW.getMeasuredHeight() + cc(this.avW));
        i = View.combineMeasuredStates(k, this.avW.getMeasuredState());
      }
      k = getCurrentContentInsetStart();
      int i3 = Math.max(k, i2) + 0;
      localObject[i1] = Math.max(0, k - i2);
      i1 = 0;
      k = i;
      m = j;
      if (ca(this.aeu))
      {
        l(this.aeu, paramInt1, i3, paramInt2, this.awb);
        i1 = this.aeu.getMeasuredWidth() + cb(this.aeu);
        m = Math.max(j, this.aeu.getMeasuredHeight() + cc(this.aeu));
        k = View.combineMeasuredStates(i, this.aeu.getMeasuredState());
      }
      i = getCurrentContentInsetEnd();
      i2 = i3 + Math.max(i, i1);
      localObject[n] = Math.max(0, i - i1);
      n = i2;
      i = k;
      j = m;
      if (ca(this.avX))
      {
        n = i2 + a(this.avX, paramInt1, i2, paramInt2, 0, (int[])localObject);
        j = Math.max(m, this.avX.getMeasuredHeight() + cc(this.avX));
        i = View.combineMeasuredStates(k, this.avX.getMeasuredState());
      }
      k = n;
      i1 = i;
      m = j;
      if (ca(this.avT))
      {
        k = n + a(this.avT, paramInt1, n, paramInt2, 0, (int[])localObject);
        m = Math.max(j, this.avT.getMeasuredHeight() + cc(this.avT));
        i1 = View.combineMeasuredStates(i, this.avT.getMeasuredState());
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
        if ((((LayoutParams)localView.getLayoutParams()).awy != 0) || (!ca(localView))) {
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
        int i4 = this.awe + this.awf;
        int i5 = this.awc + this.awd;
        k = i;
        if (ca(this.avQ))
        {
          a(this.avQ, paramInt1, i1 + i5, paramInt2, i4, (int[])localObject);
          k = this.avQ.getMeasuredWidth();
          n = cb(this.avQ) + k;
          m = this.avQ.getMeasuredHeight() + cc(this.avQ);
          k = View.combineMeasuredStates(i, this.avQ.getMeasuredState());
        }
        i3 = m;
        i2 = n;
        i = k;
        if (ca(this.avR))
        {
          i2 = Math.max(n, a(this.avR, paramInt1, i1 + i5, paramInt2, i4 + m, (int[])localObject));
          i3 = m + (this.avR.getMeasuredHeight() + cc(this.avR));
          i = View.combineMeasuredStates(k, this.avR.getMeasuredState());
        }
        k = Math.max(j, i3);
        j = getPaddingLeft();
        i3 = getPaddingRight();
        m = getPaddingTop();
        n = getPaddingBottom();
        j = View.resolveSizeAndState(Math.max(i2 + i1 + (j + i3), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i);
        paramInt2 = View.resolveSizeAndState(Math.max(k + (m + n), getSuggestedMinimumHeight()), paramInt2, i << 16);
        if (!this.awu) {
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
    super.onRestoreInstanceState(localSavedState.Mm);
    if (this.aeu != null) {}
    for (paramParcelable = this.aeu.XT;; paramParcelable = null)
    {
      if ((localSavedState.awz != 0) && (this.awt != null) && (paramParcelable != null))
      {
        paramParcelable = paramParcelable.findItem(localSavedState.awz);
        if (paramParcelable != null) {
          paramParcelable.expandActionView();
        }
      }
      if (!localSavedState.awA) {
        break;
      }
      removeCallbacks(this.awv);
      post(this.awv);
      return;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    mz();
    ap localap = this.awg;
    if (paramInt == 1) {
      if (bool != localap.mIsRtl)
      {
        localap.mIsRtl = bool;
        if (!localap.asz) {
          break label168;
        }
        if (!bool) {
          break label113;
        }
        if (localap.Mc == -2147483648) {
          break label97;
        }
        paramInt = localap.Mc;
        label67:
        localap.xo = paramInt;
        if (localap.asw == -2147483648) {
          break label105;
        }
      }
    }
    label97:
    label105:
    for (paramInt = localap.asw;; paramInt = localap.asy)
    {
      localap.xq = paramInt;
      return;
      bool = false;
      break;
      paramInt = localap.asx;
      break label67;
    }
    label113:
    if (localap.asw != -2147483648)
    {
      paramInt = localap.asw;
      localap.xo = paramInt;
      if (localap.Mc == -2147483648) {
        break label160;
      }
    }
    label160:
    for (paramInt = localap.Mc;; paramInt = localap.asy)
    {
      localap.xq = paramInt;
      return;
      paramInt = localap.asx;
      break;
    }
    label168:
    localap.xo = localap.asx;
    localap.xq = localap.asy;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((this.awt != null) && (this.awt.awx != null)) {
      localSavedState.awz = this.awt.awx.getItemId();
    }
    localSavedState.awA = isOverflowMenuShowing();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.aey = false;
    }
    if (!this.aey)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.aey = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.aey = false;
    }
    return true;
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.awu = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = -2147483648;
    }
    if (i != this.awi)
    {
      this.awi = i;
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
    if (i != this.awh)
    {
      this.awh = i;
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
      mr();
      if (!cd(this.avT)) {
        i(this.avT, true);
      }
    }
    for (;;)
    {
      if (this.avT != null) {
        this.avT.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.avT != null) && (cd(this.avT)))
      {
        removeView(this.avT);
        this.awn.remove(this.avT);
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
      mr();
    }
    if (this.avT != null) {
      this.avT.setContentDescription(paramCharSequence);
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
      mv();
    }
    if (this.avS != null) {
      this.avS.setContentDescription(paramCharSequence);
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
      mv();
      if (!cd(this.avS)) {
        i(this.avS, true);
      }
    }
    for (;;)
    {
      if (this.avS != null) {
        this.avS.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.avS != null) && (cd(this.avS)))
      {
        removeView(this.avS);
        this.awn.remove(this.avS);
      }
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    mv();
    this.avS.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(b paramb)
  {
    this.awp = paramb;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    ms();
    this.aeu.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.afU != paramInt)
    {
      this.afU = paramInt;
      if (paramInt == 0) {
        this.aet = getContext();
      }
    }
    else
    {
      return;
    }
    this.aet = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.avR == null)
      {
        Context localContext = getContext();
        this.avR = new AppCompatTextView(localContext);
        this.avR.setSingleLine();
        this.avR.setEllipsize(TextUtils.TruncateAt.END);
        if (this.avZ != 0) {
          this.avR.setTextAppearance(localContext, this.avZ);
        }
        if (this.awl != 0) {
          this.avR.setTextColor(this.awl);
        }
      }
      if (!cd(this.avR)) {
        i(this.avR, true);
      }
    }
    for (;;)
    {
      if (this.avR != null) {
        this.avR.setText(paramCharSequence);
      }
      this.awk = paramCharSequence;
      return;
      if ((this.avR != null) && (cd(this.avR)))
      {
        removeView(this.avR);
        this.awn.remove(this.avR);
      }
    }
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    this.awl = paramInt;
    if (this.avR != null) {
      this.avR.setTextColor(paramInt);
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
      if (this.avQ == null)
      {
        Context localContext = getContext();
        this.avQ = new AppCompatTextView(localContext);
        this.avQ.setSingleLine();
        this.avQ.setEllipsize(TextUtils.TruncateAt.END);
        if (this.avY != 0) {
          this.avQ.setTextAppearance(localContext, this.avY);
        }
        if (this.YJ != 0) {
          this.avQ.setTextColor(this.YJ);
        }
      }
      if (!cd(this.avQ)) {
        i(this.avQ, true);
      }
    }
    for (;;)
    {
      if (this.avQ != null) {
        this.avQ.setText(paramCharSequence);
      }
      this.awj = paramCharSequence;
      return;
      if ((this.avQ != null) && (cd(this.avQ)))
      {
        removeView(this.avQ);
        this.awn.remove(this.avQ);
      }
    }
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    this.awf = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    this.awd = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    this.awc = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    this.awe = paramInt;
    requestLayout();
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.YJ = paramInt;
    if (this.avQ != null) {
      this.avQ.setTextColor(paramInt);
    }
  }
  
  public final boolean showOverflowMenu()
  {
    if (this.aeu != null)
    {
      ActionMenuView localActionMenuView = this.aeu;
      if ((localActionMenuView.afV != null) && (localActionMenuView.afV.showOverflowMenu())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public static class LayoutParams
    extends ActionBar.LayoutParams
  {
    int awy = 0;
    
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
      this.awy = paramLayoutParams.awy;
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
    boolean awA;
    int awz;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.awz = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.awA = bool;
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
      paramParcel.writeInt(this.awz);
      if (this.awA) {}
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
    h XT;
    j awx;
    
    a() {}
    
    public final void a(Context paramContext, h paramh)
    {
      if ((this.XT != null) && (this.awx != null)) {
        this.XT.h(this.awx);
      }
      this.XT = paramh;
    }
    
    public final void a(h paramh, boolean paramBoolean) {}
    
    public final void a(o.a parama) {}
    
    public final boolean a(android.support.v7.view.menu.u paramu)
    {
      return false;
    }
    
    public final boolean b(j paramj)
    {
      Toolbar.this.mw();
      Object localObject = Toolbar.this.avW.getParent();
      if (localObject != Toolbar.this)
      {
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(Toolbar.this.avW);
        }
        Toolbar.this.addView(Toolbar.this.avW);
      }
      Toolbar.this.avX = paramj.getActionView();
      this.awx = paramj;
      localObject = Toolbar.this.avX.getParent();
      if (localObject != Toolbar.this)
      {
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(Toolbar.this.avX);
        }
        localObject = Toolbar.mx();
        ((Toolbar.LayoutParams)localObject).gravity = (0x800003 | Toolbar.this.awa & 0x70);
        ((Toolbar.LayoutParams)localObject).awy = 2;
        Toolbar.this.avX.setLayoutParams((ViewGroup.LayoutParams)localObject);
        Toolbar.this.addView(Toolbar.this.avX);
      }
      localObject = Toolbar.this;
      int i = ((Toolbar)localObject).getChildCount() - 1;
      while (i >= 0)
      {
        View localView = ((Toolbar)localObject).getChildAt(i);
        if ((((Toolbar.LayoutParams)localView.getLayoutParams()).awy != 2) && (localView != ((Toolbar)localObject).aeu))
        {
          ((Toolbar)localObject).removeViewAt(i);
          ((Toolbar)localObject).awn.add(localView);
        }
        i -= 1;
      }
      Toolbar.this.requestLayout();
      paramj.ag(true);
      if ((Toolbar.this.avX instanceof c)) {
        ((c)Toolbar.this.avX).onActionViewExpanded();
      }
      return true;
    }
    
    public final boolean bh()
    {
      return false;
    }
    
    public final boolean c(j paramj)
    {
      if ((Toolbar.this.avX instanceof c)) {
        ((c)Toolbar.this.avX).onActionViewCollapsed();
      }
      Toolbar.this.removeView(Toolbar.this.avX);
      Toolbar.this.removeView(Toolbar.this.avW);
      Toolbar.this.avX = null;
      Toolbar.this.my();
      this.awx = null;
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
      if (this.awx != null)
      {
        j = k;
        if (this.XT != null)
        {
          m = this.XT.size();
          i = 0;
        }
      }
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (this.XT.getItem(i) == this.awx) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            c(this.awx);
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