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
  private int AZ = 8388627;
  private int RG;
  private Context Xo;
  ActionMenuView Xp;
  private boolean Xt;
  private boolean Xu;
  private int YO;
  o.a YQ;
  h.a YR;
  private int aoA;
  private int aoB;
  private int aoC;
  private int aoD;
  private int aoE;
  public ap aoF;
  private int aoG;
  private int aoH;
  private CharSequence aoI;
  private CharSequence aoJ;
  private int aoK;
  private final ArrayList<View> aoL = new ArrayList();
  final ArrayList<View> aoM = new ArrayList();
  private final int[] aoN = new int[2];
  b aoO;
  private final ActionMenuView.d aoP = new ActionMenuView.d()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      if (Toolbar.this.aoO != null) {
        return Toolbar.this.aoO.onMenuItemClick(paramAnonymousMenuItem);
      }
      return false;
    }
  };
  private ba aoQ;
  private ActionMenuPresenter aoR;
  a aoS;
  private final Runnable aoT = new Runnable()
  {
    public final void run()
    {
      Toolbar.this.showOverflowMenu();
    }
  };
  TextView aop;
  TextView aoq;
  private ImageButton aor;
  private ImageView aos;
  private Drawable aot;
  private CharSequence aou;
  ImageButton aov;
  View aow;
  int aox;
  int aoy;
  int aoz;
  private boolean fw;
  
  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772181);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = az.a(getContext(), paramAttributeSet, a.a.Toolbar, paramInt, 0);
    this.aox = paramContext.getResourceId(12, 0);
    this.aoy = paramContext.getResourceId(13, 0);
    this.AZ = paramContext.getInteger(0, this.AZ);
    this.aoz = paramContext.getInteger(21, 48);
    int i = paramContext.getDimensionPixelOffset(14, 0);
    paramInt = i;
    if (paramContext.hasValue(19)) {
      paramInt = paramContext.getDimensionPixelOffset(19, i);
    }
    this.aoE = paramInt;
    this.aoD = paramInt;
    this.aoC = paramInt;
    this.aoB = paramInt;
    paramInt = paramContext.getDimensionPixelOffset(15, -1);
    if (paramInt >= 0) {
      this.aoB = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(16, -1);
    if (paramInt >= 0) {
      this.aoC = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(17, -1);
    if (paramInt >= 0) {
      this.aoD = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(18, -1);
    if (paramInt >= 0) {
      this.aoE = paramInt;
    }
    this.aoA = paramContext.getDimensionPixelSize(20, -1);
    paramInt = paramContext.getDimensionPixelOffset(5, -2147483648);
    i = paramContext.getDimensionPixelOffset(6, -2147483648);
    int j = paramContext.getDimensionPixelSize(7, 0);
    int k = paramContext.getDimensionPixelSize(8, 0);
    kS();
    this.aoF.aF(j, k);
    if ((paramInt != -2147483648) || (i != -2147483648)) {
      this.aoF.aE(paramInt, i);
    }
    this.aoG = paramContext.getDimensionPixelOffset(9, -2147483648);
    this.aoH = paramContext.getDimensionPixelOffset(10, -2147483648);
    this.aot = paramContext.getDrawable(22);
    this.aou = paramContext.getText(23);
    paramAttributeSet = paramContext.getText(2);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(3);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    this.Xo = getContext();
    setPopupTheme(paramContext.getResourceId(11, 0));
    paramAttributeSet = paramContext.getDrawable(24);
    if (paramAttributeSet != null) {
      setNavigationIcon(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(25);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setNavigationContentDescription(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(4);
    if (paramAttributeSet != null) {
      setLogo(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(26);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setLogoDescription(paramAttributeSet);
    }
    if (paramContext.hasValue(27)) {
      setTitleTextColor(paramContext.getColor(27, -1));
    }
    if (paramContext.hasValue(28)) {
      setSubtitleTextColor(paramContext.getColor(28, -1));
    }
    paramContext.aoo.recycle();
  }
  
  private int E(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int j = paramView.getMeasuredHeight();
    int i;
    int k;
    int m;
    if (paramInt > 0)
    {
      paramInt = (j - paramInt) / 2;
      switch (cI(localLayoutParams.gravity))
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
    paramInt2 = E(paramView, paramInt2);
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
    paramInt2 = E(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - (localLayoutParams.leftMargin + i);
  }
  
  private void b(List<View> paramList, int paramInt)
  {
    int i = 1;
    int j = 0;
    if (t.T(this) == 1) {}
    int m;
    int k;
    View localView;
    LayoutParams localLayoutParams;
    for (;;)
    {
      m = getChildCount();
      k = d.getAbsoluteGravity(paramInt, t.T(this));
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
        if ((localLayoutParams.aoW == 0) && (bS(localView)) && (cJ(localLayoutParams.gravity) == k)) {
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
      if ((localLayoutParams.aoW == 0) && (bS(localView)) && (cJ(localLayoutParams.gravity) == k)) {
        paramList.add(localView);
      }
      paramInt += 1;
    }
  }
  
  private boolean bS(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  private static int bT(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = android.support.v4.view.g.a(paramView);
    return android.support.v4.view.g.b(paramView) + i;
  }
  
  private static int bU(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = paramView.topMargin;
    return paramView.bottomMargin + i;
  }
  
  private boolean bV(View paramView)
  {
    return (paramView.getParent() == this) || (this.aoM.contains(paramView));
  }
  
  private int cI(int paramInt)
  {
    int i = paramInt & 0x70;
    paramInt = i;
    switch (i)
    {
    default: 
      paramInt = this.AZ & 0x70;
    }
    return paramInt;
  }
  
  private int cJ(int paramInt)
  {
    int j = t.T(this);
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
      localObject = kQ();
    }
    for (;;)
    {
      ((LayoutParams)localObject).aoW = 1;
      if ((!paramBoolean) || (this.aow == null)) {
        break;
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.aoM.add(paramView);
      return;
      if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
        localObject = e((ViewGroup.LayoutParams)localObject);
      } else {
        localObject = (LayoutParams)localObject;
      }
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void kL()
  {
    if (this.aos == null) {
      this.aos = new AppCompatImageView(getContext());
    }
  }
  
  private void kM()
  {
    kN();
    if (this.Xp.eq == null)
    {
      h localh = (h)this.Xp.getMenu();
      if (this.aoS == null) {
        this.aoS = new a();
      }
      this.Xp.setExpandedActionViewsExclusive(true);
      localh.a(this.aoS, this.Xo);
    }
  }
  
  private void kN()
  {
    if (this.Xp == null)
    {
      this.Xp = new ActionMenuView(getContext());
      this.Xp.setPopupTheme(this.YO);
      this.Xp.setOnMenuItemClickListener(this.aoP);
      this.Xp.a(this.YQ, this.YR);
      LayoutParams localLayoutParams = kQ();
      localLayoutParams.gravity = (0x800005 | this.aoz & 0x70);
      this.Xp.setLayoutParams(localLayoutParams);
      i(this.Xp, false);
    }
  }
  
  private void kO()
  {
    if (this.aor == null)
    {
      this.aor = new AppCompatImageButton(getContext(), null, 2130772182);
      LayoutParams localLayoutParams = kQ();
      localLayoutParams.gravity = (0x800003 | this.aoz & 0x70);
      this.aor.setLayoutParams(localLayoutParams);
    }
  }
  
  protected static LayoutParams kQ()
  {
    return new LayoutParams(-2);
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
  
  public final void a(h paramh, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((paramh == null) && (this.Xp == null)) {}
    h localh;
    do
    {
      return;
      kN();
      localh = this.Xp.eq;
    } while (localh == paramh);
    if (localh != null)
    {
      localh.b(this.aoR);
      localh.b(this.aoS);
    }
    if (this.aoS == null) {
      this.aoS = new a();
    }
    paramActionMenuPresenter.Yy = true;
    if (paramh != null)
    {
      paramh.a(paramActionMenuPresenter, this.Xo);
      paramh.a(this.aoS, this.Xo);
    }
    for (;;)
    {
      this.Xp.setPopupTheme(this.YO);
      this.Xp.setPresenter(paramActionMenuPresenter);
      this.aoR = paramActionMenuPresenter;
      return;
      paramActionMenuPresenter.a(this.Xo, null);
      this.aoS.a(this.Xo, null);
      paramActionMenuPresenter.n(true);
      this.aoS.n(true);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public final void collapseActionView()
  {
    if (this.aoS == null) {}
    for (j localj = null;; localj = this.aoS.aoV)
    {
      if (localj != null) {
        localj.collapseActionView();
      }
      return;
    }
  }
  
  public int getContentInsetEnd()
  {
    if (this.aoF != null)
    {
      ap localap = this.aoF;
      if (localap.mIsRtl) {
        return localap.qO;
      }
      return localap.qQ;
    }
    return 0;
  }
  
  public int getContentInsetEndWithActions()
  {
    if (this.aoH != -2147483648) {
      return this.aoH;
    }
    return getContentInsetEnd();
  }
  
  public int getContentInsetLeft()
  {
    if (this.aoF != null) {
      return this.aoF.qO;
    }
    return 0;
  }
  
  public int getContentInsetRight()
  {
    if (this.aoF != null) {
      return this.aoF.qQ;
    }
    return 0;
  }
  
  public int getContentInsetStart()
  {
    if (this.aoF != null)
    {
      ap localap = this.aoF;
      if (localap.mIsRtl) {
        return localap.qQ;
      }
      return localap.qO;
    }
    return 0;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    if (this.aoG != -2147483648) {
      return this.aoG;
    }
    return getContentInsetStart();
  }
  
  public int getCurrentContentInsetEnd()
  {
    int i;
    if (this.Xp != null)
    {
      h localh = this.Xp.eq;
      if ((localh != null) && (localh.hasVisibleItems())) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return Math.max(getContentInsetEnd(), Math.max(this.aoH, 0));
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
    if (t.T(this) == 1) {
      return getCurrentContentInsetEnd();
    }
    return getCurrentContentInsetStart();
  }
  
  public int getCurrentContentInsetRight()
  {
    if (t.T(this) == 1) {
      return getCurrentContentInsetStart();
    }
    return getCurrentContentInsetEnd();
  }
  
  public int getCurrentContentInsetStart()
  {
    if (getNavigationIcon() != null) {
      return Math.max(getContentInsetStart(), Math.max(this.aoG, 0));
    }
    return getContentInsetStart();
  }
  
  public Drawable getLogo()
  {
    if (this.aos != null) {
      return this.aos.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    if (this.aos != null) {
      return this.aos.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    kM();
    return this.Xp.getMenu();
  }
  
  public CharSequence getNavigationContentDescription()
  {
    if (this.aor != null) {
      return this.aor.getContentDescription();
    }
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    if (this.aor != null) {
      return this.aor.getDrawable();
    }
    return null;
  }
  
  ActionMenuPresenter getOuterActionMenuPresenter()
  {
    return this.aoR;
  }
  
  public Drawable getOverflowIcon()
  {
    kM();
    return this.Xp.getOverflowIcon();
  }
  
  Context getPopupContext()
  {
    return this.Xo;
  }
  
  public int getPopupTheme()
  {
    return this.YO;
  }
  
  public CharSequence getSubtitle()
  {
    return this.aoJ;
  }
  
  public CharSequence getTitle()
  {
    return this.aoI;
  }
  
  public int getTitleMarginBottom()
  {
    return this.aoE;
  }
  
  public int getTitleMarginEnd()
  {
    return this.aoC;
  }
  
  public int getTitleMarginStart()
  {
    return this.aoB;
  }
  
  public int getTitleMarginTop()
  {
    return this.aoD;
  }
  
  public u getWrapper()
  {
    if (this.aoQ == null) {
      this.aoQ = new ba(this, true);
    }
    return this.aoQ;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    if (this.Xp != null)
    {
      ActionMenuView localActionMenuView = this.Xp;
      if ((localActionMenuView.YP != null) && (localActionMenuView.YP.isOverflowMenuShowing())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  final void kP()
  {
    if (this.aov == null)
    {
      this.aov = new AppCompatImageButton(getContext(), null, 2130772182);
      this.aov.setImageDrawable(this.aot);
      this.aov.setContentDescription(this.aou);
      LayoutParams localLayoutParams = kQ();
      localLayoutParams.gravity = (0x800003 | this.aoz & 0x70);
      localLayoutParams.aoW = 2;
      this.aov.setLayoutParams(localLayoutParams);
      this.aov.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Toolbar.this.collapseActionView();
        }
      });
    }
  }
  
  final void kR()
  {
    int i = this.aoM.size() - 1;
    while (i >= 0)
    {
      addView((View)this.aoM.get(i));
      i -= 1;
    }
    this.aoM.clear();
  }
  
  public final void kS()
  {
    if (this.aoF == null) {
      this.aoF = new ap();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.aoT);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.Xu = false;
    }
    if (!this.Xu)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.Xu = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.Xu = false;
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
    if (t.T(this) == 1)
    {
      k = 1;
      i1 = getWidth();
      i4 = getHeight();
      j = getPaddingLeft();
      i2 = getPaddingRight();
      i3 = getPaddingTop();
      i5 = getPaddingBottom();
      paramInt1 = i1 - i2;
      arrayOfInt = this.aoN;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      paramInt3 = t.aa(this);
      if (paramInt3 < 0) {
        break label898;
      }
      i = Math.min(paramInt3, paramInt4 - paramInt2);
      label91:
      if (!bS(this.aor)) {
        break label1739;
      }
      if (k == 0) {
        break label904;
      }
      paramInt1 = b(this.aor, paramInt1, arrayOfInt, i);
      paramInt2 = j;
    }
    for (;;)
    {
      label124:
      paramInt3 = paramInt1;
      paramInt4 = paramInt2;
      if (bS(this.aov))
      {
        if (k != 0)
        {
          paramInt3 = b(this.aov, paramInt1, arrayOfInt, i);
          paramInt4 = paramInt2;
        }
      }
      else
      {
        label164:
        paramInt1 = paramInt3;
        paramInt2 = paramInt4;
        if (bS(this.Xp))
        {
          if (k == 0) {
            break label943;
          }
          paramInt2 = a(this.Xp, paramInt4, arrayOfInt, i);
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
        if (bS(this.aow))
        {
          if (k == 0) {
            break label964;
          }
          paramInt2 = b(this.aow, paramInt4, arrayOfInt, i);
          paramInt1 = paramInt3;
        }
        label308:
        if (!bS(this.aos)) {
          break label1731;
        }
        if (k == 0) {
          break label985;
        }
        paramInt3 = b(this.aos, paramInt2, arrayOfInt, i);
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        label341:
        paramBoolean = bS(this.aop);
        boolean bool = bS(this.aoq);
        paramInt1 = 0;
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = (LayoutParams)this.aop.getLayoutParams();
          paramInt1 = ((LayoutParams)localObject1).topMargin;
          paramInt4 = this.aop.getMeasuredHeight();
          paramInt1 = ((LayoutParams)localObject1).bottomMargin + (paramInt1 + paramInt4) + 0;
        }
        int m;
        if (bool)
        {
          localObject1 = (LayoutParams)this.aoq.getLayoutParams();
          paramInt4 = ((LayoutParams)localObject1).topMargin;
          m = this.aoq.getMeasuredHeight();
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
            localObject1 = this.aop;
            if (!bool) {
              break label1016;
            }
            localObject2 = this.aoq;
            label490:
            localObject1 = (LayoutParams)((View)localObject1).getLayoutParams();
            localObject2 = (LayoutParams)((View)localObject2).getLayoutParams();
            if (((!paramBoolean) || (this.aop.getMeasuredWidth() <= 0)) && ((!bool) || (this.aoq.getMeasuredWidth() <= 0))) {
              break label1025;
            }
            m = 1;
            switch (this.AZ & 0x70)
            {
            default: 
              paramInt1 = (i4 - i3 - i5 - n) / 2;
              if (paramInt1 < ((LayoutParams)localObject1).topMargin + this.aoD) {
                paramInt1 = ((LayoutParams)localObject1).topMargin + this.aoD;
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
                paramInt4 = this.aoB;
                label636:
                paramInt4 -= arrayOfInt[1];
                paramInt3 -= Math.max(0, paramInt4);
                arrayOfInt[1] = Math.max(0, -paramInt4);
                if (!paramBoolean) {
                  break label1715;
                }
                localObject1 = (LayoutParams)this.aop.getLayoutParams();
                paramInt4 = paramInt3 - this.aop.getMeasuredWidth();
                k = this.aop.getMeasuredHeight() + paramInt1;
                this.aop.layout(paramInt4, paramInt1, paramInt3, k);
                n = this.aoC;
                paramInt1 = k + ((LayoutParams)localObject1).bottomMargin;
                paramInt4 -= n;
              }
            }
            for (;;)
            {
              if (bool)
              {
                localObject1 = (LayoutParams)this.aoq.getLayoutParams();
                paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1;
                k = this.aoq.getMeasuredWidth();
                n = this.aoq.getMeasuredHeight();
                this.aoq.layout(paramInt3 - k, paramInt1, paramInt3, n + paramInt1);
                paramInt1 = this.aoC;
                k = ((LayoutParams)localObject1).bottomMargin;
              }
              for (paramInt1 = paramInt3 - paramInt1;; paramInt1 = paramInt3)
              {
                if (m != 0) {}
                for (paramInt1 = Math.min(paramInt4, paramInt1);; paramInt1 = paramInt3)
                {
                  paramInt4 = paramInt1;
                  paramInt1 = paramInt2;
                  b(this.aoL, 3);
                  paramInt3 = this.aoL.size();
                  paramInt2 = 0;
                  for (;;)
                  {
                    if (paramInt2 < paramInt3)
                    {
                      paramInt1 = a((View)this.aoL.get(paramInt2), paramInt1, arrayOfInt, i);
                      paramInt2 += 1;
                      continue;
                      k = 0;
                      break;
                      i = 0;
                      break label91;
                      paramInt2 = a(this.aor, j, arrayOfInt, i);
                      break label124;
                      paramInt4 = a(this.aov, paramInt2, arrayOfInt, i);
                      paramInt3 = paramInt1;
                      break label164;
                      paramInt1 = b(this.Xp, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label204;
                      label964:
                      paramInt1 = a(this.aow, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label308;
                      label985:
                      paramInt1 = a(this.aos, paramInt1, arrayOfInt, i);
                      paramInt3 = paramInt2;
                      paramInt2 = paramInt1;
                      break label341;
                      label1007:
                      localObject1 = this.aoq;
                      break label479;
                      label1016:
                      localObject2 = this.aop;
                      break label490;
                      m = 0;
                      break label542;
                      paramInt1 = getPaddingTop();
                      paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1 + this.aoD;
                      break label620;
                      paramInt4 = i4 - i5 - n - paramInt1 - i3;
                      if (paramInt4 >= ((LayoutParams)localObject1).bottomMargin + this.aoE) {
                        break label1722;
                      }
                      paramInt1 = Math.max(0, paramInt1 - (((LayoutParams)localObject2).bottomMargin + this.aoE - paramInt4));
                      break label615;
                      paramInt1 = i4 - i5 - ((LayoutParams)localObject2).bottomMargin - this.aoE - n;
                      break label620;
                      paramInt4 = 0;
                      break label636;
                      if (m != 0)
                      {
                        paramInt4 = this.aoB;
                        label1145:
                        paramInt4 -= arrayOfInt[0];
                        paramInt2 += Math.max(0, paramInt4);
                        arrayOfInt[0] = Math.max(0, -paramInt4);
                        if (!paramBoolean) {
                          break label1697;
                        }
                        localObject1 = (LayoutParams)this.aop.getLayoutParams();
                        k = this.aop.getMeasuredWidth() + paramInt2;
                        paramInt4 = this.aop.getMeasuredHeight() + paramInt1;
                        this.aop.layout(paramInt2, paramInt1, k, paramInt4);
                        n = this.aoC;
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
                      localObject1 = (LayoutParams)this.aoq.getLayoutParams();
                      paramInt4 = ((LayoutParams)localObject1).topMargin + paramInt1;
                      paramInt1 = this.aoq.getMeasuredWidth() + paramInt2;
                      n = this.aoq.getMeasuredHeight();
                      this.aoq.layout(paramInt2, paramInt4, paramInt1, n + paramInt4);
                      paramInt4 = this.aoC;
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
                      b(this.aoL, 5);
                      k = this.aoL.size();
                      paramInt3 = 0;
                      paramInt2 = paramInt4;
                      while (paramInt3 < k)
                      {
                        paramInt2 = b((View)this.aoL.get(paramInt3), paramInt2, arrayOfInt, i);
                        paramInt3 += 1;
                      }
                      b(this.aoL, 1);
                      localObject1 = this.aoL;
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
                        paramInt4 = this.aoL.size();
                        paramInt3 = 0;
                        paramInt2 = paramInt1;
                        paramInt1 = paramInt3;
                        while (paramInt1 < paramInt4)
                        {
                          paramInt2 = a((View)this.aoL.get(paramInt1), paramInt2, arrayOfInt, i);
                          paramInt1 += 1;
                        }
                        paramInt1 = paramInt4;
                        if (paramInt3 > paramInt2) {
                          paramInt1 = paramInt4 - (paramInt3 - paramInt2);
                        }
                      }
                      this.aoL.clear();
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
    Object localObject = this.aoN;
    int n;
    int i1;
    int i;
    int m;
    int k;
    if (bh.bY(this))
    {
      n = 0;
      i1 = 1;
      i = 0;
      if (!bS(this.aor)) {
        break label1008;
      }
      l(this.aor, paramInt1, 0, paramInt2, this.aoA);
      i = this.aor.getMeasuredWidth() + bT(this.aor);
      m = Math.max(0, this.aor.getMeasuredHeight() + bU(this.aor));
      k = View.combineMeasuredStates(0, this.aor.getMeasuredState());
    }
    for (;;)
    {
      int i2 = i;
      i = k;
      int j = m;
      if (bS(this.aov))
      {
        l(this.aov, paramInt1, 0, paramInt2, this.aoA);
        i2 = this.aov.getMeasuredWidth() + bT(this.aov);
        j = Math.max(m, this.aov.getMeasuredHeight() + bU(this.aov));
        i = View.combineMeasuredStates(k, this.aov.getMeasuredState());
      }
      k = getCurrentContentInsetStart();
      int i3 = Math.max(k, i2) + 0;
      localObject[i1] = Math.max(0, k - i2);
      i1 = 0;
      k = i;
      m = j;
      if (bS(this.Xp))
      {
        l(this.Xp, paramInt1, i3, paramInt2, this.aoA);
        i1 = this.Xp.getMeasuredWidth() + bT(this.Xp);
        m = Math.max(j, this.Xp.getMeasuredHeight() + bU(this.Xp));
        k = View.combineMeasuredStates(i, this.Xp.getMeasuredState());
      }
      i = getCurrentContentInsetEnd();
      i2 = i3 + Math.max(i, i1);
      localObject[n] = Math.max(0, i - i1);
      n = i2;
      i = k;
      j = m;
      if (bS(this.aow))
      {
        n = i2 + a(this.aow, paramInt1, i2, paramInt2, 0, (int[])localObject);
        j = Math.max(m, this.aow.getMeasuredHeight() + bU(this.aow));
        i = View.combineMeasuredStates(k, this.aow.getMeasuredState());
      }
      k = n;
      i1 = i;
      m = j;
      if (bS(this.aos))
      {
        k = n + a(this.aos, paramInt1, n, paramInt2, 0, (int[])localObject);
        m = Math.max(j, this.aos.getMeasuredHeight() + bU(this.aos));
        i1 = View.combineMeasuredStates(i, this.aos.getMeasuredState());
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
        if ((((LayoutParams)localView.getLayoutParams()).aoW != 0) || (!bS(localView))) {
          break label995;
        }
        i1 += a(localView, paramInt1, i1, paramInt2, 0, (int[])localObject);
        k = Math.max(j, localView.getMeasuredHeight() + bU(localView));
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
        int i4 = this.aoD + this.aoE;
        int i5 = this.aoB + this.aoC;
        k = i;
        if (bS(this.aop))
        {
          a(this.aop, paramInt1, i1 + i5, paramInt2, i4, (int[])localObject);
          k = this.aop.getMeasuredWidth();
          n = bT(this.aop) + k;
          m = this.aop.getMeasuredHeight() + bU(this.aop);
          k = View.combineMeasuredStates(i, this.aop.getMeasuredState());
        }
        i3 = m;
        i2 = n;
        i = k;
        if (bS(this.aoq))
        {
          i2 = Math.max(n, a(this.aoq, paramInt1, i1 + i5, paramInt2, i4 + m, (int[])localObject));
          i3 = m + (this.aoq.getMeasuredHeight() + bU(this.aoq));
          i = View.combineMeasuredStates(k, this.aoq.getMeasuredState());
        }
        k = Math.max(j, i3);
        j = getPaddingLeft();
        i3 = getPaddingRight();
        m = getPaddingTop();
        n = getPaddingBottom();
        j = View.resolveSizeAndState(Math.max(i2 + i1 + (j + i3), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i);
        paramInt2 = View.resolveSizeAndState(Math.max(k + (m + n), getSuggestedMinimumHeight()), paramInt2, i << 16);
        if (!this.fw) {
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
            if ((bS((View)localObject)) && (((View)localObject).getMeasuredWidth() > 0) && (((View)localObject).getMeasuredHeight() > 0))
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
    super.onRestoreInstanceState(localSavedState.Fo);
    if (this.Xp != null) {}
    for (paramParcelable = this.Xp.eq;; paramParcelable = null)
    {
      if ((localSavedState.aoX != 0) && (this.aoS != null) && (paramParcelable != null))
      {
        paramParcelable = paramParcelable.findItem(localSavedState.aoX);
        if (paramParcelable != null) {
          paramParcelable.expandActionView();
        }
      }
      if (!localSavedState.aoY) {
        break;
      }
      removeCallbacks(this.aoT);
      post(this.aoT);
      return;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    kS();
    ap localap = this.aoF;
    if (paramInt == 1) {
      if (bool != localap.mIsRtl)
      {
        localap.mIsRtl = bool;
        if (!localap.ala) {
          break label168;
        }
        if (!bool) {
          break label113;
        }
        if (localap.Fe == -2147483648) {
          break label97;
        }
        paramInt = localap.Fe;
        label67:
        localap.qO = paramInt;
        if (localap.akX == -2147483648) {
          break label105;
        }
      }
    }
    label97:
    label105:
    for (paramInt = localap.akX;; paramInt = localap.akZ)
    {
      localap.qQ = paramInt;
      return;
      bool = false;
      break;
      paramInt = localap.akY;
      break label67;
    }
    label113:
    if (localap.akX != -2147483648)
    {
      paramInt = localap.akX;
      localap.qO = paramInt;
      if (localap.Fe == -2147483648) {
        break label160;
      }
    }
    label160:
    for (paramInt = localap.Fe;; paramInt = localap.akZ)
    {
      localap.qQ = paramInt;
      return;
      paramInt = localap.akY;
      break;
    }
    label168:
    localap.qO = localap.akY;
    localap.qQ = localap.akZ;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((this.aoS != null) && (this.aoS.aoV != null)) {
      localSavedState.aoX = this.aoS.aoV.getItemId();
    }
    localSavedState.aoY = isOverflowMenuShowing();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.Xt = false;
    }
    if (!this.Xt)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.Xt = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.Xt = false;
    }
    return true;
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.fw = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = -2147483648;
    }
    if (i != this.aoH)
    {
      this.aoH = i;
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
    if (i != this.aoG)
    {
      this.aoG = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setLogo(int paramInt)
  {
    setLogo(a.k(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      kL();
      if (!bV(this.aos)) {
        i(this.aos, true);
      }
    }
    for (;;)
    {
      if (this.aos != null) {
        this.aos.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.aos != null) && (bV(this.aos)))
      {
        removeView(this.aos);
        this.aoM.remove(this.aos);
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
      kL();
    }
    if (this.aos != null) {
      this.aos.setContentDescription(paramCharSequence);
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
      kO();
    }
    if (this.aor != null) {
      this.aor.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationIcon(int paramInt)
  {
    setNavigationIcon(a.k(getContext(), paramInt));
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      kO();
      if (!bV(this.aor)) {
        i(this.aor, true);
      }
    }
    for (;;)
    {
      if (this.aor != null) {
        this.aor.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.aor != null) && (bV(this.aor)))
      {
        removeView(this.aor);
        this.aoM.remove(this.aor);
      }
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    kO();
    this.aor.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(b paramb)
  {
    this.aoO = paramb;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    kM();
    this.Xp.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.YO != paramInt)
    {
      this.YO = paramInt;
      if (paramInt == 0) {
        this.Xo = getContext();
      }
    }
    else
    {
      return;
    }
    this.Xo = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.aoq == null)
      {
        Context localContext = getContext();
        this.aoq = new AppCompatTextView(localContext);
        this.aoq.setSingleLine();
        this.aoq.setEllipsize(TextUtils.TruncateAt.END);
        if (this.aoy != 0) {
          this.aoq.setTextAppearance(localContext, this.aoy);
        }
        if (this.aoK != 0) {
          this.aoq.setTextColor(this.aoK);
        }
      }
      if (!bV(this.aoq)) {
        i(this.aoq, true);
      }
    }
    for (;;)
    {
      if (this.aoq != null) {
        this.aoq.setText(paramCharSequence);
      }
      this.aoJ = paramCharSequence;
      return;
      if ((this.aoq != null) && (bV(this.aoq)))
      {
        removeView(this.aoq);
        this.aoM.remove(this.aoq);
      }
    }
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    this.aoK = paramInt;
    if (this.aoq != null) {
      this.aoq.setTextColor(paramInt);
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
      if (this.aop == null)
      {
        Context localContext = getContext();
        this.aop = new AppCompatTextView(localContext);
        this.aop.setSingleLine();
        this.aop.setEllipsize(TextUtils.TruncateAt.END);
        if (this.aox != 0) {
          this.aop.setTextAppearance(localContext, this.aox);
        }
        if (this.RG != 0) {
          this.aop.setTextColor(this.RG);
        }
      }
      if (!bV(this.aop)) {
        i(this.aop, true);
      }
    }
    for (;;)
    {
      if (this.aop != null) {
        this.aop.setText(paramCharSequence);
      }
      this.aoI = paramCharSequence;
      return;
      if ((this.aop != null) && (bV(this.aop)))
      {
        removeView(this.aop);
        this.aoM.remove(this.aop);
      }
    }
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    this.aoE = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    this.aoC = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    this.aoB = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    this.aoD = paramInt;
    requestLayout();
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.RG = paramInt;
    if (this.aop != null) {
      this.aop.setTextColor(paramInt);
    }
  }
  
  public final boolean showOverflowMenu()
  {
    if (this.Xp != null)
    {
      ActionMenuView localActionMenuView = this.Xp;
      if ((localActionMenuView.YP != null) && (localActionMenuView.YP.showOverflowMenu())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public static class LayoutParams
    extends ActionBar.LayoutParams
  {
    int aoW = 0;
    
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
      this.aoW = paramLayoutParams.aoW;
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
    int aoX;
    boolean aoY;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.aoX = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.aoY = bool;
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
      paramParcel.writeInt(this.aoX);
      if (this.aoY) {}
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
    j aoV;
    h eq;
    
    a() {}
    
    public final void a(Context paramContext, h paramh)
    {
      if ((this.eq != null) && (this.aoV != null)) {
        this.eq.h(this.aoV);
      }
      this.eq = paramh;
    }
    
    public final void a(h paramh, boolean paramBoolean) {}
    
    public final void a(o.a parama) {}
    
    public final boolean a(android.support.v7.view.menu.u paramu)
    {
      return false;
    }
    
    public final boolean aG()
    {
      return false;
    }
    
    public final boolean b(j paramj)
    {
      Toolbar.this.kP();
      Object localObject = Toolbar.this.aov.getParent();
      if (localObject != Toolbar.this)
      {
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(Toolbar.this.aov);
        }
        Toolbar.this.addView(Toolbar.this.aov);
      }
      Toolbar.this.aow = paramj.getActionView();
      this.aoV = paramj;
      localObject = Toolbar.this.aow.getParent();
      if (localObject != Toolbar.this)
      {
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(Toolbar.this.aow);
        }
        localObject = Toolbar.kQ();
        ((Toolbar.LayoutParams)localObject).gravity = (0x800003 | Toolbar.this.aoz & 0x70);
        ((Toolbar.LayoutParams)localObject).aoW = 2;
        Toolbar.this.aow.setLayoutParams((ViewGroup.LayoutParams)localObject);
        Toolbar.this.addView(Toolbar.this.aow);
      }
      localObject = Toolbar.this;
      int i = ((Toolbar)localObject).getChildCount() - 1;
      while (i >= 0)
      {
        View localView = ((Toolbar)localObject).getChildAt(i);
        if ((((Toolbar.LayoutParams)localView.getLayoutParams()).aoW != 2) && (localView != ((Toolbar)localObject).Xp))
        {
          ((Toolbar)localObject).removeViewAt(i);
          ((Toolbar)localObject).aoM.add(localView);
        }
        i -= 1;
      }
      Toolbar.this.requestLayout();
      paramj.aa(true);
      if ((Toolbar.this.aow instanceof c)) {
        ((c)Toolbar.this.aow).onActionViewExpanded();
      }
      return true;
    }
    
    public final boolean c(j paramj)
    {
      if ((Toolbar.this.aow instanceof c)) {
        ((c)Toolbar.this.aow).onActionViewCollapsed();
      }
      Toolbar.this.removeView(Toolbar.this.aow);
      Toolbar.this.removeView(Toolbar.this.aov);
      Toolbar.this.aow = null;
      Toolbar.this.kR();
      this.aoV = null;
      Toolbar.this.requestLayout();
      paramj.aa(false);
      return true;
    }
    
    public final int getId()
    {
      return 0;
    }
    
    public final void n(boolean paramBoolean)
    {
      int k = 0;
      int j;
      int m;
      int i;
      if (this.aoV != null)
      {
        j = k;
        if (this.eq != null)
        {
          m = this.eq.size();
          i = 0;
        }
      }
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (this.eq.getItem(i) == this.aoV) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            c(this.aoV);
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