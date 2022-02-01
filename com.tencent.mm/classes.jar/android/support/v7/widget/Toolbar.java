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
  private int Is = 8388627;
  private int ZE;
  private Context afn;
  ActionMenuView afo;
  private boolean afs;
  private boolean aft;
  private int agO;
  o.a agQ;
  h.a agR;
  TextView awK;
  TextView awL;
  private ImageButton awM;
  private ImageView awN;
  private Drawable awO;
  private CharSequence awP;
  ImageButton awQ;
  View awR;
  int awS;
  int awT;
  int awU;
  private int awV;
  private int awW;
  private int awX;
  private int awY;
  private int awZ;
  ap axa;
  private int axb;
  private int axc;
  private CharSequence axd;
  private CharSequence axe;
  private int axf;
  private final ArrayList<View> axg = new ArrayList();
  final ArrayList<View> axh = new ArrayList();
  private final int[] axi = new int[2];
  b axj;
  private final ActionMenuView.d axk = new ActionMenuView.d()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      if (Toolbar.this.axj != null) {
        return Toolbar.this.axj.onMenuItemClick(paramAnonymousMenuItem);
      }
      return false;
    }
  };
  private ba axl;
  private ActionMenuPresenter axm;
  a axn;
  private boolean axo;
  private final Runnable axp = new Runnable()
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
    this.awS = paramContext.getResourceId(27, 0);
    this.awT = paramContext.getResourceId(18, 0);
    this.Is = paramContext.getInteger(0, this.Is);
    this.awU = paramContext.getInteger(2, 48);
    int i = paramContext.getDimensionPixelOffset(21, 0);
    paramInt = i;
    if (paramContext.hasValue(26)) {
      paramInt = paramContext.getDimensionPixelOffset(26, i);
    }
    this.awZ = paramInt;
    this.awY = paramInt;
    this.awX = paramInt;
    this.awW = paramInt;
    paramInt = paramContext.getDimensionPixelOffset(24, -1);
    if (paramInt >= 0) {
      this.awW = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(23, -1);
    if (paramInt >= 0) {
      this.awX = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(25, -1);
    if (paramInt >= 0) {
      this.awY = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(22, -1);
    if (paramInt >= 0) {
      this.awZ = paramInt;
    }
    this.awV = paramContext.getDimensionPixelSize(13, -1);
    paramInt = paramContext.getDimensionPixelOffset(9, -2147483648);
    i = paramContext.getDimensionPixelOffset(5, -2147483648);
    int j = paramContext.getDimensionPixelSize(7, 0);
    int k = paramContext.getDimensionPixelSize(8, 0);
    mJ();
    this.axa.aG(j, k);
    if ((paramInt != -2147483648) || (i != -2147483648)) {
      this.axa.aF(paramInt, i);
    }
    this.axb = paramContext.getDimensionPixelOffset(10, -2147483648);
    this.axc = paramContext.getDimensionPixelOffset(6, -2147483648);
    this.awO = paramContext.getDrawable(4);
    this.awP = paramContext.getText(3);
    paramAttributeSet = paramContext.getText(20);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(17);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    this.afn = getContext();
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
    paramContext.awJ.recycle();
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
        if ((localLayoutParams.axs == 0) && (ca(localView)) && (dd(localLayoutParams.gravity) == k)) {
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
      if ((localLayoutParams.axs == 0) && (ca(localView)) && (dd(localLayoutParams.gravity) == k)) {
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
    return (paramView.getParent() == this) || (this.axh.contains(paramView));
  }
  
  private int dc(int paramInt)
  {
    int i = paramInt & 0x70;
    paramInt = i;
    switch (i)
    {
    default: 
      paramInt = this.Is & 0x70;
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
      localObject = mH();
    }
    for (;;)
    {
      ((LayoutParams)localObject).axs = 1;
      if ((!paramBoolean) || (this.awR == null)) {
        break;
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.axh.add(paramView);
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
  
  private void mB()
  {
    if (this.awN == null) {
      this.awN = new AppCompatImageView(getContext());
    }
  }
  
  private void mC()
  {
    mD();
    if (this.afo.YO == null)
    {
      h localh = (h)this.afo.getMenu();
      if (this.axn == null) {
        this.axn = new a();
      }
      this.afo.setExpandedActionViewsExclusive(true);
      localh.a(this.axn, this.afn);
    }
  }
  
  private void mD()
  {
    if (this.afo == null)
    {
      this.afo = new ActionMenuView(getContext());
      this.afo.setPopupTheme(this.agO);
      this.afo.setOnMenuItemClickListener(this.axk);
      this.afo.a(this.agQ, this.agR);
      LayoutParams localLayoutParams = mH();
      localLayoutParams.gravity = (0x800005 | this.awU & 0x70);
      this.afo.setLayoutParams(localLayoutParams);
      i(this.afo, false);
    }
  }
  
  private void mF()
  {
    if (this.awM == null)
    {
      this.awM = new AppCompatImageButton(getContext(), null, 2130969606);
      LayoutParams localLayoutParams = mH();
      localLayoutParams.gravity = (0x800003 | this.awU & 0x70);
      this.awM.setLayoutParams(localLayoutParams);
    }
  }
  
  protected static LayoutParams mH()
  {
    return new LayoutParams(-2);
  }
  
  public final void a(h paramh, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((paramh == null) && (this.afo == null)) {}
    h localh;
    do
    {
      return;
      mD();
      localh = this.afo.YO;
    } while (localh == paramh);
    if (localh != null)
    {
      localh.b(this.axm);
      localh.b(this.axn);
    }
    if (this.axn == null) {
      this.axn = new a();
    }
    paramActionMenuPresenter.agy = true;
    if (paramh != null)
    {
      paramh.a(paramActionMenuPresenter, this.afn);
      paramh.a(this.axn, this.afn);
    }
    for (;;)
    {
      this.afo.setPopupTheme(this.agO);
      this.afo.setPresenter(paramActionMenuPresenter);
      this.axm = paramActionMenuPresenter;
      return;
      paramActionMenuPresenter.a(this.afn, null);
      this.axn.a(this.afn, null);
      paramActionMenuPresenter.p(true);
      this.axn.p(true);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public final void collapseActionView()
  {
    if (this.axn == null) {}
    for (j localj = null;; localj = this.axn.axr)
    {
      if (localj != null) {
        localj.collapseActionView();
      }
      return;
    }
  }
  
  public int getContentInsetEnd()
  {
    if (this.axa != null)
    {
      ap localap = this.axa;
      if (localap.mIsRtl) {
        return localap.ym;
      }
      return localap.yo;
    }
    return 0;
  }
  
  public int getContentInsetEndWithActions()
  {
    if (this.axc != -2147483648) {
      return this.axc;
    }
    return getContentInsetEnd();
  }
  
  public int getContentInsetLeft()
  {
    if (this.axa != null) {
      return this.axa.ym;
    }
    return 0;
  }
  
  public int getContentInsetRight()
  {
    if (this.axa != null) {
      return this.axa.yo;
    }
    return 0;
  }
  
  public int getContentInsetStart()
  {
    if (this.axa != null)
    {
      ap localap = this.axa;
      if (localap.mIsRtl) {
        return localap.yo;
      }
      return localap.ym;
    }
    return 0;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    if (this.axb != -2147483648) {
      return this.axb;
    }
    return getContentInsetStart();
  }
  
  public int getCurrentContentInsetEnd()
  {
    int i;
    if (this.afo != null)
    {
      h localh = this.afo.YO;
      if ((localh != null) && (localh.hasVisibleItems())) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return Math.max(getContentInsetEnd(), Math.max(this.axc, 0));
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
      return Math.max(getContentInsetStart(), Math.max(this.axb, 0));
    }
    return getContentInsetStart();
  }
  
  public Drawable getLogo()
  {
    if (this.awN != null) {
      return this.awN.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    if (this.awN != null) {
      return this.awN.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    mC();
    return this.afo.getMenu();
  }
  
  public CharSequence getNavigationContentDescription()
  {
    if (this.awM != null) {
      return this.awM.getContentDescription();
    }
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    if (this.awM != null) {
      return this.awM.getDrawable();
    }
    return null;
  }
  
  ActionMenuPresenter getOuterActionMenuPresenter()
  {
    return this.axm;
  }
  
  public Drawable getOverflowIcon()
  {
    mC();
    return this.afo.getOverflowIcon();
  }
  
  Context getPopupContext()
  {
    return this.afn;
  }
  
  public int getPopupTheme()
  {
    return this.agO;
  }
  
  public CharSequence getSubtitle()
  {
    return this.axe;
  }
  
  public CharSequence getTitle()
  {
    return this.axd;
  }
  
  public int getTitleMarginBottom()
  {
    return this.awZ;
  }
  
  public int getTitleMarginEnd()
  {
    return this.awX;
  }
  
  public int getTitleMarginStart()
  {
    return this.awW;
  }
  
  public int getTitleMarginTop()
  {
    return this.awY;
  }
  
  public u getWrapper()
  {
    if (this.axl == null) {
      this.axl = new ba(this, true);
    }
    return this.axl;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    if (this.afo != null)
    {
      ActionMenuView localActionMenuView = this.afo;
      if ((localActionMenuView.agP != null) && (localActionMenuView.agP.isOverflowMenuShowing())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final void mE()
  {
    mJ();
    this.axa.aG(0, 0);
  }
  
  final void mG()
  {
    if (this.awQ == null)
    {
      this.awQ = new AppCompatImageButton(getContext(), null, 2130969606);
      this.awQ.setImageDrawable(this.awO);
      this.awQ.setContentDescription(this.awP);
      LayoutParams localLayoutParams = mH();
      localLayoutParams.gravity = (0x800003 | this.awU & 0x70);
      localLayoutParams.axs = 2;
      this.awQ.setLayoutParams(localLayoutParams);
      this.awQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Toolbar.this.collapseActionView();
        }
      });
    }
  }
  
  final void mI()
  {
    int i = this.axh.size() - 1;
    while (i >= 0)
    {
      addView((View)this.axh.get(i));
      i -= 1;
    }
    this.axh.clear();
  }
  
  final void mJ()
  {
    if (this.axa == null) {
      this.axa = new ap();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.axp);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.aft = false;
    }
    if (!this.aft)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.aft = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.aft = false;
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
      arrayOfInt = this.axi;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      paramInt3 = t.af(this);
      if (paramInt3 < 0) {
        break label898;
      }
      i = Math.min(paramInt3, paramInt4 - paramInt2);
      label91:
      if (!ca(this.awM)) {
        break label1739;
      }
      if (k == 0) {
        break label904;
      }
      paramInt1 = b(this.awM, paramInt1, arrayOfInt, i);
      paramInt2 = j;
    }
    for (;;)
    {
      label124:
      paramInt3 = paramInt1;
      paramInt4 = paramInt2;
      if (ca(this.awQ))
      {
        if (k != 0)
        {
          paramInt3 = b(this.awQ, paramInt1, arrayOfInt, i);
          paramInt4 = paramInt2;
        }
      }
      else
      {
        label164:
        paramInt1 = paramInt3;
        paramInt2 = paramInt4;
        if (ca(this.afo))
        {
          if (k == 0) {
            break label943;
          }
          paramInt2 = a(this.afo, paramInt4, arrayOfInt, i);
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
        if (ca(this.awR))
        {
          if (k == 0) {
            break label964;
          }
          paramInt2 = b(this.awR, paramInt4, arrayOfInt, i);
          paramInt1 = paramInt3;
        }
        label308:
        if (!ca(this.awN)) {
          break label1731;
        }
        if (k == 0) {
          break label985;
        }
        paramInt3 = b(this.awN, paramInt2, arrayOfInt, i);
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        label341:
        paramBoolean = ca(this.awK);
        boolean bool = ca(this.awL);
        paramInt1 = 0;
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = (LayoutParams)this.awK.getLayoutParams();
          paramInt1 = ((LayoutParams)localObject1).topMargin;
          paramInt4 = this.awK.getMeasuredHeight();
          paramInt1 = ((LayoutParams)localObject1).bottomMargin + (paramInt1 + paramInt4) + 0;
        }
        int m;
        if (bool)
        {
          localObject1 = (LayoutParams)this.awL.getLayoutParams();
          paramInt4 = ((LayoutParams)localObject1).topMargin;
          m = this.awL.getMeasuredHeight();
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
            localObject1 = this.awK;
            if (!bool) {
              break label1016;
            }
            localObject2 = this.awL;
            label490:
            localObject1 = (LayoutParams)((View)localObject1).getLayoutParams();
            localObject2 = (LayoutParams)((View)localObject2).getLayoutParams();
            if (((!paramBoolean) || (this.awK.getMeasuredWidth() <= 0)) && ((!bool) || (this.awL.getMeasuredWidth() <= 0))) {
              break label1025;
            }
            m = 1;
            switch (this.Is & 0x70)
            {
            default: 
              paramInt1 = (i4 - i3 - i5 - n) / 2;
              if (paramInt1 < ((LayoutParams)localObject1).topMargin + this.awY) {
                paramInt1 = ((LayoutParams)localObject1).topMargin + this.awY;
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
                paramInt4 = this.awW;
                label636:
                paramInt4 -= arrayOfInt[1];
                paramInt3 -= Math.max(0, paramInt4);
                arrayOfInt[1] = Math.max(0, -paramInt4);
                if (!paramBoolean) {
                  break label1715;
                }
                localObject1 = (LayoutParams)this.awK.getLayoutParams();
                paramInt4 = paramInt3 - this.awK.getMeasuredWidth();
                k = this.awK.getMeasuredHeight() + paramInt1;
                this.awK.layout(paramInt4, paramInt1, paramInt3, k);
                n = this.awX;
                paramInt1 = k + ((LayoutParams)localObject1).bottomMargin;
                paramInt4 -= n;
              }
            }
            for (;;)
            {
              if (bool)
              {
                localObject1 = (LayoutParams)this.awL.getLayoutParams();
                paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1;
                k = this.awL.getMeasuredWidth();
                n = this.awL.getMeasuredHeight();
                this.awL.layout(paramInt3 - k, paramInt1, paramInt3, n + paramInt1);
                paramInt1 = this.awX;
                k = ((LayoutParams)localObject1).bottomMargin;
              }
              for (paramInt1 = paramInt3 - paramInt1;; paramInt1 = paramInt3)
              {
                if (m != 0) {}
                for (paramInt1 = Math.min(paramInt4, paramInt1);; paramInt1 = paramInt3)
                {
                  paramInt4 = paramInt1;
                  paramInt1 = paramInt2;
                  a(this.axg, 3);
                  paramInt3 = this.axg.size();
                  paramInt2 = 0;
                  for (;;)
                  {
                    if (paramInt2 < paramInt3)
                    {
                      paramInt1 = a((View)this.axg.get(paramInt2), paramInt1, arrayOfInt, i);
                      paramInt2 += 1;
                      continue;
                      k = 0;
                      break;
                      i = 0;
                      break label91;
                      paramInt2 = a(this.awM, j, arrayOfInt, i);
                      break label124;
                      paramInt4 = a(this.awQ, paramInt2, arrayOfInt, i);
                      paramInt3 = paramInt1;
                      break label164;
                      paramInt1 = b(this.afo, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label204;
                      label964:
                      paramInt1 = a(this.awR, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label308;
                      label985:
                      paramInt1 = a(this.awN, paramInt1, arrayOfInt, i);
                      paramInt3 = paramInt2;
                      paramInt2 = paramInt1;
                      break label341;
                      label1007:
                      localObject1 = this.awL;
                      break label479;
                      label1016:
                      localObject2 = this.awK;
                      break label490;
                      m = 0;
                      break label542;
                      paramInt1 = getPaddingTop();
                      paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1 + this.awY;
                      break label620;
                      paramInt4 = i4 - i5 - n - paramInt1 - i3;
                      if (paramInt4 >= ((LayoutParams)localObject1).bottomMargin + this.awZ) {
                        break label1722;
                      }
                      paramInt1 = Math.max(0, paramInt1 - (((LayoutParams)localObject2).bottomMargin + this.awZ - paramInt4));
                      break label615;
                      paramInt1 = i4 - i5 - ((LayoutParams)localObject2).bottomMargin - this.awZ - n;
                      break label620;
                      paramInt4 = 0;
                      break label636;
                      if (m != 0)
                      {
                        paramInt4 = this.awW;
                        label1145:
                        paramInt4 -= arrayOfInt[0];
                        paramInt2 += Math.max(0, paramInt4);
                        arrayOfInt[0] = Math.max(0, -paramInt4);
                        if (!paramBoolean) {
                          break label1697;
                        }
                        localObject1 = (LayoutParams)this.awK.getLayoutParams();
                        k = this.awK.getMeasuredWidth() + paramInt2;
                        paramInt4 = this.awK.getMeasuredHeight() + paramInt1;
                        this.awK.layout(paramInt2, paramInt1, k, paramInt4);
                        n = this.awX;
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
                      localObject1 = (LayoutParams)this.awL.getLayoutParams();
                      paramInt4 = ((LayoutParams)localObject1).topMargin + paramInt1;
                      paramInt1 = this.awL.getMeasuredWidth() + paramInt2;
                      n = this.awL.getMeasuredHeight();
                      this.awL.layout(paramInt2, paramInt4, paramInt1, n + paramInt4);
                      paramInt4 = this.awX;
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
                      a(this.axg, 5);
                      k = this.axg.size();
                      paramInt3 = 0;
                      paramInt2 = paramInt4;
                      while (paramInt3 < k)
                      {
                        paramInt2 = b((View)this.axg.get(paramInt3), paramInt2, arrayOfInt, i);
                        paramInt3 += 1;
                      }
                      a(this.axg, 1);
                      localObject1 = this.axg;
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
                        paramInt4 = this.axg.size();
                        paramInt3 = 0;
                        paramInt2 = paramInt1;
                        paramInt1 = paramInt3;
                        while (paramInt1 < paramInt4)
                        {
                          paramInt2 = a((View)this.axg.get(paramInt1), paramInt2, arrayOfInt, i);
                          paramInt1 += 1;
                        }
                        paramInt1 = paramInt4;
                        if (paramInt3 > paramInt2) {
                          paramInt1 = paramInt4 - (paramInt3 - paramInt2);
                        }
                      }
                      this.axg.clear();
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
    Object localObject = this.axi;
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
      if (!ca(this.awM)) {
        break label1008;
      }
      l(this.awM, paramInt1, 0, paramInt2, this.awV);
      i = this.awM.getMeasuredWidth() + cb(this.awM);
      m = Math.max(0, this.awM.getMeasuredHeight() + cc(this.awM));
      k = View.combineMeasuredStates(0, this.awM.getMeasuredState());
    }
    for (;;)
    {
      int i2 = i;
      i = k;
      int j = m;
      if (ca(this.awQ))
      {
        l(this.awQ, paramInt1, 0, paramInt2, this.awV);
        i2 = this.awQ.getMeasuredWidth() + cb(this.awQ);
        j = Math.max(m, this.awQ.getMeasuredHeight() + cc(this.awQ));
        i = View.combineMeasuredStates(k, this.awQ.getMeasuredState());
      }
      k = getCurrentContentInsetStart();
      int i3 = Math.max(k, i2) + 0;
      localObject[i1] = Math.max(0, k - i2);
      i1 = 0;
      k = i;
      m = j;
      if (ca(this.afo))
      {
        l(this.afo, paramInt1, i3, paramInt2, this.awV);
        i1 = this.afo.getMeasuredWidth() + cb(this.afo);
        m = Math.max(j, this.afo.getMeasuredHeight() + cc(this.afo));
        k = View.combineMeasuredStates(i, this.afo.getMeasuredState());
      }
      i = getCurrentContentInsetEnd();
      i2 = i3 + Math.max(i, i1);
      localObject[n] = Math.max(0, i - i1);
      n = i2;
      i = k;
      j = m;
      if (ca(this.awR))
      {
        n = i2 + a(this.awR, paramInt1, i2, paramInt2, 0, (int[])localObject);
        j = Math.max(m, this.awR.getMeasuredHeight() + cc(this.awR));
        i = View.combineMeasuredStates(k, this.awR.getMeasuredState());
      }
      k = n;
      i1 = i;
      m = j;
      if (ca(this.awN))
      {
        k = n + a(this.awN, paramInt1, n, paramInt2, 0, (int[])localObject);
        m = Math.max(j, this.awN.getMeasuredHeight() + cc(this.awN));
        i1 = View.combineMeasuredStates(i, this.awN.getMeasuredState());
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
        if ((((LayoutParams)localView.getLayoutParams()).axs != 0) || (!ca(localView))) {
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
        int i4 = this.awY + this.awZ;
        int i5 = this.awW + this.awX;
        k = i;
        if (ca(this.awK))
        {
          a(this.awK, paramInt1, i1 + i5, paramInt2, i4, (int[])localObject);
          k = this.awK.getMeasuredWidth();
          n = cb(this.awK) + k;
          m = this.awK.getMeasuredHeight() + cc(this.awK);
          k = View.combineMeasuredStates(i, this.awK.getMeasuredState());
        }
        i3 = m;
        i2 = n;
        i = k;
        if (ca(this.awL))
        {
          i2 = Math.max(n, a(this.awL, paramInt1, i1 + i5, paramInt2, i4 + m, (int[])localObject));
          i3 = m + (this.awL.getMeasuredHeight() + cc(this.awL));
          i = View.combineMeasuredStates(k, this.awL.getMeasuredState());
        }
        k = Math.max(j, i3);
        j = getPaddingLeft();
        i3 = getPaddingRight();
        m = getPaddingTop();
        n = getPaddingBottom();
        j = View.resolveSizeAndState(Math.max(i2 + i1 + (j + i3), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i);
        paramInt2 = View.resolveSizeAndState(Math.max(k + (m + n), getSuggestedMinimumHeight()), paramInt2, i << 16);
        if (!this.axo) {
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
    super.onRestoreInstanceState(localSavedState.Nj);
    if (this.afo != null) {}
    for (paramParcelable = this.afo.YO;; paramParcelable = null)
    {
      if ((localSavedState.axt != 0) && (this.axn != null) && (paramParcelable != null))
      {
        paramParcelable = paramParcelable.findItem(localSavedState.axt);
        if (paramParcelable != null) {
          paramParcelable.expandActionView();
        }
      }
      if (!localSavedState.axu) {
        break;
      }
      removeCallbacks(this.axp);
      post(this.axp);
      return;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    mJ();
    ap localap = this.axa;
    if (paramInt == 1) {
      if (bool != localap.mIsRtl)
      {
        localap.mIsRtl = bool;
        if (!localap.atu) {
          break label168;
        }
        if (!bool) {
          break label113;
        }
        if (localap.MZ == -2147483648) {
          break label97;
        }
        paramInt = localap.MZ;
        label67:
        localap.ym = paramInt;
        if (localap.atr == -2147483648) {
          break label105;
        }
      }
    }
    label97:
    label105:
    for (paramInt = localap.atr;; paramInt = localap.att)
    {
      localap.yo = paramInt;
      return;
      bool = false;
      break;
      paramInt = localap.ats;
      break label67;
    }
    label113:
    if (localap.atr != -2147483648)
    {
      paramInt = localap.atr;
      localap.ym = paramInt;
      if (localap.MZ == -2147483648) {
        break label160;
      }
    }
    label160:
    for (paramInt = localap.MZ;; paramInt = localap.att)
    {
      localap.yo = paramInt;
      return;
      paramInt = localap.ats;
      break;
    }
    label168:
    localap.ym = localap.ats;
    localap.yo = localap.att;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((this.axn != null) && (this.axn.axr != null)) {
      localSavedState.axt = this.axn.axr.getItemId();
    }
    localSavedState.axu = isOverflowMenuShowing();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.afs = false;
    }
    if (!this.afs)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.afs = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.afs = false;
    }
    return true;
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.axo = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = -2147483648;
    }
    if (i != this.axc)
    {
      this.axc = i;
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
    if (i != this.axb)
    {
      this.axb = i;
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
      mB();
      if (!cd(this.awN)) {
        i(this.awN, true);
      }
    }
    for (;;)
    {
      if (this.awN != null) {
        this.awN.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.awN != null) && (cd(this.awN)))
      {
        removeView(this.awN);
        this.axh.remove(this.awN);
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
      mB();
    }
    if (this.awN != null) {
      this.awN.setContentDescription(paramCharSequence);
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
      mF();
    }
    if (this.awM != null) {
      this.awM.setContentDescription(paramCharSequence);
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
      mF();
      if (!cd(this.awM)) {
        i(this.awM, true);
      }
    }
    for (;;)
    {
      if (this.awM != null) {
        this.awM.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.awM != null) && (cd(this.awM)))
      {
        removeView(this.awM);
        this.axh.remove(this.awM);
      }
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    mF();
    this.awM.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(b paramb)
  {
    this.axj = paramb;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    mC();
    this.afo.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.agO != paramInt)
    {
      this.agO = paramInt;
      if (paramInt == 0) {
        this.afn = getContext();
      }
    }
    else
    {
      return;
    }
    this.afn = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.awL == null)
      {
        Context localContext = getContext();
        this.awL = new AppCompatTextView(localContext);
        this.awL.setSingleLine();
        this.awL.setEllipsize(TextUtils.TruncateAt.END);
        if (this.awT != 0) {
          this.awL.setTextAppearance(localContext, this.awT);
        }
        if (this.axf != 0) {
          this.awL.setTextColor(this.axf);
        }
      }
      if (!cd(this.awL)) {
        i(this.awL, true);
      }
    }
    for (;;)
    {
      if (this.awL != null) {
        this.awL.setText(paramCharSequence);
      }
      this.axe = paramCharSequence;
      return;
      if ((this.awL != null) && (cd(this.awL)))
      {
        removeView(this.awL);
        this.axh.remove(this.awL);
      }
    }
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    this.axf = paramInt;
    if (this.awL != null) {
      this.awL.setTextColor(paramInt);
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
      if (this.awK == null)
      {
        Context localContext = getContext();
        this.awK = new AppCompatTextView(localContext);
        this.awK.setSingleLine();
        this.awK.setEllipsize(TextUtils.TruncateAt.END);
        if (this.awS != 0) {
          this.awK.setTextAppearance(localContext, this.awS);
        }
        if (this.ZE != 0) {
          this.awK.setTextColor(this.ZE);
        }
      }
      if (!cd(this.awK)) {
        i(this.awK, true);
      }
    }
    for (;;)
    {
      if (this.awK != null) {
        this.awK.setText(paramCharSequence);
      }
      this.axd = paramCharSequence;
      return;
      if ((this.awK != null) && (cd(this.awK)))
      {
        removeView(this.awK);
        this.axh.remove(this.awK);
      }
    }
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    this.awZ = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    this.awX = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    this.awW = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    this.awY = paramInt;
    requestLayout();
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.ZE = paramInt;
    if (this.awK != null) {
      this.awK.setTextColor(paramInt);
    }
  }
  
  public final boolean showOverflowMenu()
  {
    if (this.afo != null)
    {
      ActionMenuView localActionMenuView = this.afo;
      if ((localActionMenuView.agP != null) && (localActionMenuView.agP.showOverflowMenu())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public static class LayoutParams
    extends ActionBar.LayoutParams
  {
    int axs = 0;
    
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
      this.axs = paramLayoutParams.axs;
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
    int axt;
    boolean axu;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.axt = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.axu = bool;
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
      paramParcel.writeInt(this.axt);
      if (this.axu) {}
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
    h YO;
    j axr;
    
    a() {}
    
    public final void a(Context paramContext, h paramh)
    {
      if ((this.YO != null) && (this.axr != null)) {
        this.YO.h(this.axr);
      }
      this.YO = paramh;
    }
    
    public final void a(h paramh, boolean paramBoolean) {}
    
    public final void a(o.a parama) {}
    
    public final boolean a(android.support.v7.view.menu.u paramu)
    {
      return false;
    }
    
    public final boolean b(j paramj)
    {
      Toolbar.this.mG();
      Object localObject = Toolbar.this.awQ.getParent();
      if (localObject != Toolbar.this)
      {
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(Toolbar.this.awQ);
        }
        Toolbar.this.addView(Toolbar.this.awQ);
      }
      Toolbar.this.awR = paramj.getActionView();
      this.axr = paramj;
      localObject = Toolbar.this.awR.getParent();
      if (localObject != Toolbar.this)
      {
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(Toolbar.this.awR);
        }
        localObject = Toolbar.mH();
        ((Toolbar.LayoutParams)localObject).gravity = (0x800003 | Toolbar.this.awU & 0x70);
        ((Toolbar.LayoutParams)localObject).axs = 2;
        Toolbar.this.awR.setLayoutParams((ViewGroup.LayoutParams)localObject);
        Toolbar.this.addView(Toolbar.this.awR);
      }
      localObject = Toolbar.this;
      int i = ((Toolbar)localObject).getChildCount() - 1;
      while (i >= 0)
      {
        View localView = ((Toolbar)localObject).getChildAt(i);
        if ((((Toolbar.LayoutParams)localView.getLayoutParams()).axs != 2) && (localView != ((Toolbar)localObject).afo))
        {
          ((Toolbar)localObject).removeViewAt(i);
          ((Toolbar)localObject).axh.add(localView);
        }
        i -= 1;
      }
      Toolbar.this.requestLayout();
      paramj.ag(true);
      if ((Toolbar.this.awR instanceof c)) {
        ((c)Toolbar.this.awR).onActionViewExpanded();
      }
      return true;
    }
    
    public final boolean bo()
    {
      return false;
    }
    
    public final boolean c(j paramj)
    {
      if ((Toolbar.this.awR instanceof c)) {
        ((c)Toolbar.this.awR).onActionViewCollapsed();
      }
      Toolbar.this.removeView(Toolbar.this.awR);
      Toolbar.this.removeView(Toolbar.this.awQ);
      Toolbar.this.awR = null;
      Toolbar.this.mI();
      this.axr = null;
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
      if (this.axr != null)
      {
        j = k;
        if (this.YO != null)
        {
          m = this.YO.size();
          i = 0;
        }
      }
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (this.YO.getItem(i) == this.axr) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            c(this.axr);
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