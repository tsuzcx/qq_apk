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
  private int Ku = 8388627;
  private int abH;
  private Context ahr;
  ActionMenuView ahs;
  private boolean ahw;
  private boolean ahx;
  private int aiS;
  o.a aiU;
  h.a aiV;
  TextView ayA;
  private ImageButton ayB;
  private ImageView ayC;
  private Drawable ayD;
  private CharSequence ayE;
  ImageButton ayF;
  View ayG;
  int ayH;
  int ayI;
  int ayJ;
  private int ayK;
  private int ayL;
  private int ayM;
  private int ayN;
  private int ayO;
  ap ayP;
  private int ayQ;
  private int ayR;
  private CharSequence ayS;
  private CharSequence ayT;
  private int ayU;
  private final ArrayList<View> ayV = new ArrayList();
  final ArrayList<View> ayW = new ArrayList();
  private final int[] ayX = new int[2];
  b ayY;
  private final ActionMenuView.d ayZ = new ActionMenuView.d()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      if (Toolbar.this.ayY != null) {
        return Toolbar.this.ayY.onMenuItemClick(paramAnonymousMenuItem);
      }
      return false;
    }
  };
  TextView ayz;
  private ba aza;
  private ActionMenuPresenter azb;
  a azc;
  private boolean azd;
  private final Runnable aze = new Runnable()
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
    this(paramContext, paramAttributeSet, 2130969693);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = az.a(getContext(), paramAttributeSet, a.a.Toolbar, paramInt, 0);
    this.ayH = paramContext.getResourceId(27, 0);
    this.ayI = paramContext.getResourceId(18, 0);
    this.Ku = paramContext.getInteger(0, this.Ku);
    this.ayJ = paramContext.getInteger(2, 48);
    int i = paramContext.getDimensionPixelOffset(21, 0);
    paramInt = i;
    if (paramContext.hasValue(26)) {
      paramInt = paramContext.getDimensionPixelOffset(26, i);
    }
    this.ayO = paramInt;
    this.ayN = paramInt;
    this.ayM = paramInt;
    this.ayL = paramInt;
    paramInt = paramContext.getDimensionPixelOffset(24, -1);
    if (paramInt >= 0) {
      this.ayL = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(23, -1);
    if (paramInt >= 0) {
      this.ayM = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(25, -1);
    if (paramInt >= 0) {
      this.ayN = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(22, -1);
    if (paramInt >= 0) {
      this.ayO = paramInt;
    }
    this.ayK = paramContext.getDimensionPixelSize(13, -1);
    paramInt = paramContext.getDimensionPixelOffset(9, -2147483648);
    i = paramContext.getDimensionPixelOffset(5, -2147483648);
    int j = paramContext.getDimensionPixelSize(7, 0);
    int k = paramContext.getDimensionPixelSize(8, 0);
    nd();
    this.ayP.aB(j, k);
    if ((paramInt != -2147483648) || (i != -2147483648)) {
      this.ayP.aA(paramInt, i);
    }
    this.ayQ = paramContext.getDimensionPixelOffset(10, -2147483648);
    this.ayR = paramContext.getDimensionPixelOffset(6, -2147483648);
    this.ayD = paramContext.getDrawable(4);
    this.ayE = paramContext.getText(3);
    paramAttributeSet = paramContext.getText(20);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(17);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    this.ahr = getContext();
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
    paramContext.ayy.recycle();
  }
  
  private int G(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int j = paramView.getMeasuredHeight();
    int i;
    int k;
    int m;
    if (paramInt > 0)
    {
      paramInt = (j - paramInt) / 2;
      switch (cW(localLayoutParams.gravity))
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
    paramInt2 = G(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i, paramView.getMeasuredHeight() + paramInt2);
    return localLayoutParams.rightMargin + i + paramInt1;
  }
  
  private void a(List<View> paramList, int paramInt)
  {
    int i = 1;
    int j = 0;
    if (android.support.v4.view.u.Z(this) == 1) {}
    int m;
    int k;
    View localView;
    LayoutParams localLayoutParams;
    for (;;)
    {
      m = getChildCount();
      k = d.getAbsoluteGravity(paramInt, android.support.v4.view.u.Z(this));
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
        if ((localLayoutParams.azh == 0) && (bM(localView)) && (cX(localLayoutParams.gravity) == k)) {
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
      if ((localLayoutParams.azh == 0) && (bM(localView)) && (cX(localLayoutParams.gravity) == k)) {
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
    paramInt2 = G(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - (localLayoutParams.leftMargin + i);
  }
  
  private boolean bM(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  private static int bN(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = android.support.v4.view.g.a(paramView);
    return android.support.v4.view.g.b(paramView) + i;
  }
  
  private static int bO(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = paramView.topMargin;
    return paramView.bottomMargin + i;
  }
  
  private boolean bP(View paramView)
  {
    return (paramView.getParent() == this) || (this.ayW.contains(paramView));
  }
  
  private int cW(int paramInt)
  {
    int i = paramInt & 0x70;
    paramInt = i;
    switch (i)
    {
    default: 
      paramInt = this.Ku & 0x70;
    }
    return paramInt;
  }
  
  private int cX(int paramInt)
  {
    int j = android.support.v4.view.u.Z(this);
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
  
  private static LayoutParams d(ViewGroup.LayoutParams paramLayoutParams)
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
      localObject = nb();
    }
    for (;;)
    {
      ((LayoutParams)localObject).azh = 1;
      if ((!paramBoolean) || (this.ayG == null)) {
        break;
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.ayW.add(paramView);
      return;
      if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
        localObject = d((ViewGroup.LayoutParams)localObject);
      } else {
        localObject = (LayoutParams)localObject;
      }
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void j(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  private void mV()
  {
    if (this.ayC == null) {
      this.ayC = new AppCompatImageView(getContext());
    }
  }
  
  private void mW()
  {
    mX();
    if (this.ahs.aaQ == null)
    {
      h localh = (h)this.ahs.getMenu();
      if (this.azc == null) {
        this.azc = new a();
      }
      this.ahs.setExpandedActionViewsExclusive(true);
      localh.a(this.azc, this.ahr);
    }
  }
  
  private void mX()
  {
    if (this.ahs == null)
    {
      this.ahs = new ActionMenuView(getContext());
      this.ahs.setPopupTheme(this.aiS);
      this.ahs.setOnMenuItemClickListener(this.ayZ);
      this.ahs.a(this.aiU, this.aiV);
      LayoutParams localLayoutParams = nb();
      localLayoutParams.gravity = (0x800005 | this.ayJ & 0x70);
      this.ahs.setLayoutParams(localLayoutParams);
      i(this.ahs, false);
    }
  }
  
  private void mZ()
  {
    if (this.ayB == null)
    {
      this.ayB = new AppCompatImageButton(getContext(), null, 2130969692);
      LayoutParams localLayoutParams = nb();
      localLayoutParams.gravity = (0x800003 | this.ayJ & 0x70);
      this.ayB.setLayoutParams(localLayoutParams);
    }
  }
  
  protected static LayoutParams nb()
  {
    return new LayoutParams(-2);
  }
  
  public final void a(h paramh, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((paramh == null) && (this.ahs == null)) {}
    h localh;
    do
    {
      return;
      mX();
      localh = this.ahs.aaQ;
    } while (localh == paramh);
    if (localh != null)
    {
      localh.b(this.azb);
      localh.b(this.azc);
    }
    if (this.azc == null) {
      this.azc = new a();
    }
    paramActionMenuPresenter.aiC = true;
    if (paramh != null)
    {
      paramh.a(paramActionMenuPresenter, this.ahr);
      paramh.a(this.azc, this.ahr);
    }
    for (;;)
    {
      this.ahs.setPopupTheme(this.aiS);
      this.ahs.setPresenter(paramActionMenuPresenter);
      this.azb = paramActionMenuPresenter;
      return;
      paramActionMenuPresenter.a(this.ahr, null);
      this.azc.a(this.ahr, null);
      paramActionMenuPresenter.p(true);
      this.azc.p(true);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public final void collapseActionView()
  {
    if (this.azc == null) {}
    for (j localj = null;; localj = this.azc.azg)
    {
      if (localj != null) {
        localj.collapseActionView();
      }
      return;
    }
  }
  
  public int getContentInsetEnd()
  {
    if (this.ayP != null)
    {
      ap localap = this.ayP;
      if (localap.mIsRtl) {
        return localap.Al;
      }
      return localap.An;
    }
    return 0;
  }
  
  public int getContentInsetEndWithActions()
  {
    if (this.ayR != -2147483648) {
      return this.ayR;
    }
    return getContentInsetEnd();
  }
  
  public int getContentInsetLeft()
  {
    if (this.ayP != null) {
      return this.ayP.Al;
    }
    return 0;
  }
  
  public int getContentInsetRight()
  {
    if (this.ayP != null) {
      return this.ayP.An;
    }
    return 0;
  }
  
  public int getContentInsetStart()
  {
    if (this.ayP != null)
    {
      ap localap = this.ayP;
      if (localap.mIsRtl) {
        return localap.An;
      }
      return localap.Al;
    }
    return 0;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    if (this.ayQ != -2147483648) {
      return this.ayQ;
    }
    return getContentInsetStart();
  }
  
  public int getCurrentContentInsetEnd()
  {
    int i;
    if (this.ahs != null)
    {
      h localh = this.ahs.aaQ;
      if ((localh != null) && (localh.hasVisibleItems())) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return Math.max(getContentInsetEnd(), Math.max(this.ayR, 0));
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
    if (android.support.v4.view.u.Z(this) == 1) {
      return getCurrentContentInsetEnd();
    }
    return getCurrentContentInsetStart();
  }
  
  public int getCurrentContentInsetRight()
  {
    if (android.support.v4.view.u.Z(this) == 1) {
      return getCurrentContentInsetStart();
    }
    return getCurrentContentInsetEnd();
  }
  
  public int getCurrentContentInsetStart()
  {
    if (getNavigationIcon() != null) {
      return Math.max(getContentInsetStart(), Math.max(this.ayQ, 0));
    }
    return getContentInsetStart();
  }
  
  public Drawable getLogo()
  {
    if (this.ayC != null) {
      return this.ayC.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    if (this.ayC != null) {
      return this.ayC.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    mW();
    return this.ahs.getMenu();
  }
  
  public CharSequence getNavigationContentDescription()
  {
    if (this.ayB != null) {
      return this.ayB.getContentDescription();
    }
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    if (this.ayB != null) {
      return this.ayB.getDrawable();
    }
    return null;
  }
  
  ActionMenuPresenter getOuterActionMenuPresenter()
  {
    return this.azb;
  }
  
  public Drawable getOverflowIcon()
  {
    mW();
    return this.ahs.getOverflowIcon();
  }
  
  Context getPopupContext()
  {
    return this.ahr;
  }
  
  public int getPopupTheme()
  {
    return this.aiS;
  }
  
  public CharSequence getSubtitle()
  {
    return this.ayT;
  }
  
  public CharSequence getTitle()
  {
    return this.ayS;
  }
  
  public int getTitleMarginBottom()
  {
    return this.ayO;
  }
  
  public int getTitleMarginEnd()
  {
    return this.ayM;
  }
  
  public int getTitleMarginStart()
  {
    return this.ayL;
  }
  
  public int getTitleMarginTop()
  {
    return this.ayN;
  }
  
  public u getWrapper()
  {
    if (this.aza == null) {
      this.aza = new ba(this, true);
    }
    return this.aza;
  }
  
  public final boolean isOverflowMenuShowing()
  {
    if (this.ahs != null)
    {
      ActionMenuView localActionMenuView = this.ahs;
      if ((localActionMenuView.aiT != null) && (localActionMenuView.aiT.isOverflowMenuShowing())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final void mY()
  {
    nd();
    this.ayP.aB(0, 0);
  }
  
  final void na()
  {
    if (this.ayF == null)
    {
      this.ayF = new AppCompatImageButton(getContext(), null, 2130969692);
      this.ayF.setImageDrawable(this.ayD);
      this.ayF.setContentDescription(this.ayE);
      LayoutParams localLayoutParams = nb();
      localLayoutParams.gravity = (0x800003 | this.ayJ & 0x70);
      localLayoutParams.azh = 2;
      this.ayF.setLayoutParams(localLayoutParams);
      this.ayF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Toolbar.this.collapseActionView();
        }
      });
    }
  }
  
  final void nc()
  {
    int i = this.ayW.size() - 1;
    while (i >= 0)
    {
      addView((View)this.ayW.get(i));
      i -= 1;
    }
    this.ayW.clear();
  }
  
  final void nd()
  {
    if (this.ayP == null) {
      this.ayP = new ap();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.aze);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.ahx = false;
    }
    if (!this.ahx)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.ahx = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.ahx = false;
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
    if (android.support.v4.view.u.Z(this) == 1)
    {
      k = 1;
      i1 = getWidth();
      i4 = getHeight();
      j = getPaddingLeft();
      i2 = getPaddingRight();
      i3 = getPaddingTop();
      i5 = getPaddingBottom();
      paramInt1 = i1 - i2;
      arrayOfInt = this.ayX;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      paramInt3 = android.support.v4.view.u.ag(this);
      if (paramInt3 < 0) {
        break label898;
      }
      i = Math.min(paramInt3, paramInt4 - paramInt2);
      label91:
      if (!bM(this.ayB)) {
        break label1739;
      }
      if (k == 0) {
        break label904;
      }
      paramInt1 = b(this.ayB, paramInt1, arrayOfInt, i);
      paramInt2 = j;
    }
    for (;;)
    {
      label124:
      paramInt3 = paramInt1;
      paramInt4 = paramInt2;
      if (bM(this.ayF))
      {
        if (k != 0)
        {
          paramInt3 = b(this.ayF, paramInt1, arrayOfInt, i);
          paramInt4 = paramInt2;
        }
      }
      else
      {
        label164:
        paramInt1 = paramInt3;
        paramInt2 = paramInt4;
        if (bM(this.ahs))
        {
          if (k == 0) {
            break label943;
          }
          paramInt2 = a(this.ahs, paramInt4, arrayOfInt, i);
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
        if (bM(this.ayG))
        {
          if (k == 0) {
            break label964;
          }
          paramInt2 = b(this.ayG, paramInt4, arrayOfInt, i);
          paramInt1 = paramInt3;
        }
        label308:
        if (!bM(this.ayC)) {
          break label1731;
        }
        if (k == 0) {
          break label985;
        }
        paramInt3 = b(this.ayC, paramInt2, arrayOfInt, i);
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        label341:
        paramBoolean = bM(this.ayz);
        boolean bool = bM(this.ayA);
        paramInt1 = 0;
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = (LayoutParams)this.ayz.getLayoutParams();
          paramInt1 = ((LayoutParams)localObject1).topMargin;
          paramInt4 = this.ayz.getMeasuredHeight();
          paramInt1 = ((LayoutParams)localObject1).bottomMargin + (paramInt1 + paramInt4) + 0;
        }
        int m;
        if (bool)
        {
          localObject1 = (LayoutParams)this.ayA.getLayoutParams();
          paramInt4 = ((LayoutParams)localObject1).topMargin;
          m = this.ayA.getMeasuredHeight();
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
            localObject1 = this.ayz;
            if (!bool) {
              break label1016;
            }
            localObject2 = this.ayA;
            label490:
            localObject1 = (LayoutParams)((View)localObject1).getLayoutParams();
            localObject2 = (LayoutParams)((View)localObject2).getLayoutParams();
            if (((!paramBoolean) || (this.ayz.getMeasuredWidth() <= 0)) && ((!bool) || (this.ayA.getMeasuredWidth() <= 0))) {
              break label1025;
            }
            m = 1;
            switch (this.Ku & 0x70)
            {
            default: 
              paramInt1 = (i4 - i3 - i5 - n) / 2;
              if (paramInt1 < ((LayoutParams)localObject1).topMargin + this.ayN) {
                paramInt1 = ((LayoutParams)localObject1).topMargin + this.ayN;
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
                paramInt4 = this.ayL;
                label636:
                paramInt4 -= arrayOfInt[1];
                paramInt3 -= Math.max(0, paramInt4);
                arrayOfInt[1] = Math.max(0, -paramInt4);
                if (!paramBoolean) {
                  break label1715;
                }
                localObject1 = (LayoutParams)this.ayz.getLayoutParams();
                paramInt4 = paramInt3 - this.ayz.getMeasuredWidth();
                k = this.ayz.getMeasuredHeight() + paramInt1;
                this.ayz.layout(paramInt4, paramInt1, paramInt3, k);
                n = this.ayM;
                paramInt1 = k + ((LayoutParams)localObject1).bottomMargin;
                paramInt4 -= n;
              }
            }
            for (;;)
            {
              if (bool)
              {
                localObject1 = (LayoutParams)this.ayA.getLayoutParams();
                paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1;
                k = this.ayA.getMeasuredWidth();
                n = this.ayA.getMeasuredHeight();
                this.ayA.layout(paramInt3 - k, paramInt1, paramInt3, n + paramInt1);
                paramInt1 = this.ayM;
                k = ((LayoutParams)localObject1).bottomMargin;
              }
              for (paramInt1 = paramInt3 - paramInt1;; paramInt1 = paramInt3)
              {
                if (m != 0) {}
                for (paramInt1 = Math.min(paramInt4, paramInt1);; paramInt1 = paramInt3)
                {
                  paramInt4 = paramInt1;
                  paramInt1 = paramInt2;
                  a(this.ayV, 3);
                  paramInt3 = this.ayV.size();
                  paramInt2 = 0;
                  for (;;)
                  {
                    if (paramInt2 < paramInt3)
                    {
                      paramInt1 = a((View)this.ayV.get(paramInt2), paramInt1, arrayOfInt, i);
                      paramInt2 += 1;
                      continue;
                      k = 0;
                      break;
                      i = 0;
                      break label91;
                      paramInt2 = a(this.ayB, j, arrayOfInt, i);
                      break label124;
                      paramInt4 = a(this.ayF, paramInt2, arrayOfInt, i);
                      paramInt3 = paramInt1;
                      break label164;
                      paramInt1 = b(this.ahs, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label204;
                      label964:
                      paramInt1 = a(this.ayG, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label308;
                      label985:
                      paramInt1 = a(this.ayC, paramInt1, arrayOfInt, i);
                      paramInt3 = paramInt2;
                      paramInt2 = paramInt1;
                      break label341;
                      label1007:
                      localObject1 = this.ayA;
                      break label479;
                      label1016:
                      localObject2 = this.ayz;
                      break label490;
                      m = 0;
                      break label542;
                      paramInt1 = getPaddingTop();
                      paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1 + this.ayN;
                      break label620;
                      paramInt4 = i4 - i5 - n - paramInt1 - i3;
                      if (paramInt4 >= ((LayoutParams)localObject1).bottomMargin + this.ayO) {
                        break label1722;
                      }
                      paramInt1 = Math.max(0, paramInt1 - (((LayoutParams)localObject2).bottomMargin + this.ayO - paramInt4));
                      break label615;
                      paramInt1 = i4 - i5 - ((LayoutParams)localObject2).bottomMargin - this.ayO - n;
                      break label620;
                      paramInt4 = 0;
                      break label636;
                      if (m != 0)
                      {
                        paramInt4 = this.ayL;
                        label1145:
                        paramInt4 -= arrayOfInt[0];
                        paramInt2 += Math.max(0, paramInt4);
                        arrayOfInt[0] = Math.max(0, -paramInt4);
                        if (!paramBoolean) {
                          break label1697;
                        }
                        localObject1 = (LayoutParams)this.ayz.getLayoutParams();
                        k = this.ayz.getMeasuredWidth() + paramInt2;
                        paramInt4 = this.ayz.getMeasuredHeight() + paramInt1;
                        this.ayz.layout(paramInt2, paramInt1, k, paramInt4);
                        n = this.ayM;
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
                      localObject1 = (LayoutParams)this.ayA.getLayoutParams();
                      paramInt4 = ((LayoutParams)localObject1).topMargin + paramInt1;
                      paramInt1 = this.ayA.getMeasuredWidth() + paramInt2;
                      n = this.ayA.getMeasuredHeight();
                      this.ayA.layout(paramInt2, paramInt4, paramInt1, n + paramInt4);
                      paramInt4 = this.ayM;
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
                      a(this.ayV, 5);
                      k = this.ayV.size();
                      paramInt3 = 0;
                      paramInt2 = paramInt4;
                      while (paramInt3 < k)
                      {
                        paramInt2 = b((View)this.ayV.get(paramInt3), paramInt2, arrayOfInt, i);
                        paramInt3 += 1;
                      }
                      a(this.ayV, 1);
                      localObject1 = this.ayV;
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
                        paramInt4 = this.ayV.size();
                        paramInt3 = 0;
                        paramInt2 = paramInt1;
                        paramInt1 = paramInt3;
                        while (paramInt1 < paramInt4)
                        {
                          paramInt2 = a((View)this.ayV.get(paramInt1), paramInt2, arrayOfInt, i);
                          paramInt1 += 1;
                        }
                        paramInt1 = paramInt4;
                        if (paramInt3 > paramInt2) {
                          paramInt1 = paramInt4 - (paramInt3 - paramInt2);
                        }
                      }
                      this.ayV.clear();
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
    Object localObject = this.ayX;
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
      if (!bM(this.ayB)) {
        break label1008;
      }
      j(this.ayB, paramInt1, 0, paramInt2, this.ayK);
      i = this.ayB.getMeasuredWidth() + bN(this.ayB);
      m = Math.max(0, this.ayB.getMeasuredHeight() + bO(this.ayB));
      k = View.combineMeasuredStates(0, this.ayB.getMeasuredState());
    }
    for (;;)
    {
      int i2 = i;
      i = k;
      int j = m;
      if (bM(this.ayF))
      {
        j(this.ayF, paramInt1, 0, paramInt2, this.ayK);
        i2 = this.ayF.getMeasuredWidth() + bN(this.ayF);
        j = Math.max(m, this.ayF.getMeasuredHeight() + bO(this.ayF));
        i = View.combineMeasuredStates(k, this.ayF.getMeasuredState());
      }
      k = getCurrentContentInsetStart();
      int i3 = Math.max(k, i2) + 0;
      localObject[i1] = Math.max(0, k - i2);
      i1 = 0;
      k = i;
      m = j;
      if (bM(this.ahs))
      {
        j(this.ahs, paramInt1, i3, paramInt2, this.ayK);
        i1 = this.ahs.getMeasuredWidth() + bN(this.ahs);
        m = Math.max(j, this.ahs.getMeasuredHeight() + bO(this.ahs));
        k = View.combineMeasuredStates(i, this.ahs.getMeasuredState());
      }
      i = getCurrentContentInsetEnd();
      i2 = i3 + Math.max(i, i1);
      localObject[n] = Math.max(0, i - i1);
      n = i2;
      i = k;
      j = m;
      if (bM(this.ayG))
      {
        n = i2 + a(this.ayG, paramInt1, i2, paramInt2, 0, (int[])localObject);
        j = Math.max(m, this.ayG.getMeasuredHeight() + bO(this.ayG));
        i = View.combineMeasuredStates(k, this.ayG.getMeasuredState());
      }
      k = n;
      i1 = i;
      m = j;
      if (bM(this.ayC))
      {
        k = n + a(this.ayC, paramInt1, n, paramInt2, 0, (int[])localObject);
        m = Math.max(j, this.ayC.getMeasuredHeight() + bO(this.ayC));
        i1 = View.combineMeasuredStates(i, this.ayC.getMeasuredState());
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
        if ((((LayoutParams)localView.getLayoutParams()).azh != 0) || (!bM(localView))) {
          break label995;
        }
        i1 += a(localView, paramInt1, i1, paramInt2, 0, (int[])localObject);
        k = Math.max(j, localView.getMeasuredHeight() + bO(localView));
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
        int i4 = this.ayN + this.ayO;
        int i5 = this.ayL + this.ayM;
        k = i;
        if (bM(this.ayz))
        {
          a(this.ayz, paramInt1, i1 + i5, paramInt2, i4, (int[])localObject);
          k = this.ayz.getMeasuredWidth();
          n = bN(this.ayz) + k;
          m = this.ayz.getMeasuredHeight() + bO(this.ayz);
          k = View.combineMeasuredStates(i, this.ayz.getMeasuredState());
        }
        i3 = m;
        i2 = n;
        i = k;
        if (bM(this.ayA))
        {
          i2 = Math.max(n, a(this.ayA, paramInt1, i1 + i5, paramInt2, i4 + m, (int[])localObject));
          i3 = m + (this.ayA.getMeasuredHeight() + bO(this.ayA));
          i = View.combineMeasuredStates(k, this.ayA.getMeasuredState());
        }
        k = Math.max(j, i3);
        j = getPaddingLeft();
        i3 = getPaddingRight();
        m = getPaddingTop();
        n = getPaddingBottom();
        j = View.resolveSizeAndState(Math.max(i2 + i1 + (j + i3), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i);
        paramInt2 = View.resolveSizeAndState(Math.max(k + (m + n), getSuggestedMinimumHeight()), paramInt2, i << 16);
        if (!this.azd) {
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
            if ((bM((View)localObject)) && (((View)localObject).getMeasuredWidth() > 0) && (((View)localObject).getMeasuredHeight() > 0))
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
    super.onRestoreInstanceState(localSavedState.Pm);
    if (this.ahs != null) {}
    for (paramParcelable = this.ahs.aaQ;; paramParcelable = null)
    {
      if ((localSavedState.azi != 0) && (this.azc != null) && (paramParcelable != null))
      {
        paramParcelable = paramParcelable.findItem(localSavedState.azi);
        if (paramParcelable != null) {
          paramParcelable.expandActionView();
        }
      }
      if (!localSavedState.azj) {
        break;
      }
      removeCallbacks(this.aze);
      post(this.aze);
      return;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    nd();
    ap localap = this.ayP;
    if (paramInt == 1) {
      if (bool != localap.mIsRtl)
      {
        localap.mIsRtl = bool;
        if (!localap.avk) {
          break label168;
        }
        if (!bool) {
          break label113;
        }
        if (localap.Pc == -2147483648) {
          break label97;
        }
        paramInt = localap.Pc;
        label67:
        localap.Al = paramInt;
        if (localap.avh == -2147483648) {
          break label105;
        }
      }
    }
    label97:
    label105:
    for (paramInt = localap.avh;; paramInt = localap.avj)
    {
      localap.An = paramInt;
      return;
      bool = false;
      break;
      paramInt = localap.avi;
      break label67;
    }
    label113:
    if (localap.avh != -2147483648)
    {
      paramInt = localap.avh;
      localap.Al = paramInt;
      if (localap.Pc == -2147483648) {
        break label160;
      }
    }
    label160:
    for (paramInt = localap.Pc;; paramInt = localap.avj)
    {
      localap.An = paramInt;
      return;
      paramInt = localap.avi;
      break;
    }
    label168:
    localap.Al = localap.avi;
    localap.An = localap.avj;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((this.azc != null) && (this.azc.azg != null)) {
      localSavedState.azi = this.azc.azg.getItemId();
    }
    localSavedState.azj = isOverflowMenuShowing();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.ahw = false;
    }
    if (!this.ahw)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.ahw = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.ahw = false;
    }
    return true;
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.azd = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = -2147483648;
    }
    if (i != this.ayR)
    {
      this.ayR = i;
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
    if (i != this.ayQ)
    {
      this.ayQ = i;
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
      mV();
      if (!bP(this.ayC)) {
        i(this.ayC, true);
      }
    }
    for (;;)
    {
      if (this.ayC != null) {
        this.ayC.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.ayC != null) && (bP(this.ayC)))
      {
        removeView(this.ayC);
        this.ayW.remove(this.ayC);
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
      mV();
    }
    if (this.ayC != null) {
      this.ayC.setContentDescription(paramCharSequence);
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
      mZ();
    }
    if (this.ayB != null) {
      this.ayB.setContentDescription(paramCharSequence);
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
      mZ();
      if (!bP(this.ayB)) {
        i(this.ayB, true);
      }
    }
    for (;;)
    {
      if (this.ayB != null) {
        this.ayB.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.ayB != null) && (bP(this.ayB)))
      {
        removeView(this.ayB);
        this.ayW.remove(this.ayB);
      }
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    mZ();
    this.ayB.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(b paramb)
  {
    this.ayY = paramb;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    mW();
    this.ahs.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.aiS != paramInt)
    {
      this.aiS = paramInt;
      if (paramInt == 0) {
        this.ahr = getContext();
      }
    }
    else
    {
      return;
    }
    this.ahr = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.ayA == null)
      {
        Context localContext = getContext();
        this.ayA = new AppCompatTextView(localContext);
        this.ayA.setSingleLine();
        this.ayA.setEllipsize(TextUtils.TruncateAt.END);
        if (this.ayI != 0) {
          this.ayA.setTextAppearance(localContext, this.ayI);
        }
        if (this.ayU != 0) {
          this.ayA.setTextColor(this.ayU);
        }
      }
      if (!bP(this.ayA)) {
        i(this.ayA, true);
      }
    }
    for (;;)
    {
      if (this.ayA != null) {
        this.ayA.setText(paramCharSequence);
      }
      this.ayT = paramCharSequence;
      return;
      if ((this.ayA != null) && (bP(this.ayA)))
      {
        removeView(this.ayA);
        this.ayW.remove(this.ayA);
      }
    }
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    this.ayU = paramInt;
    if (this.ayA != null) {
      this.ayA.setTextColor(paramInt);
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
      if (this.ayz == null)
      {
        Context localContext = getContext();
        this.ayz = new AppCompatTextView(localContext);
        this.ayz.setSingleLine();
        this.ayz.setEllipsize(TextUtils.TruncateAt.END);
        if (this.ayH != 0) {
          this.ayz.setTextAppearance(localContext, this.ayH);
        }
        if (this.abH != 0) {
          this.ayz.setTextColor(this.abH);
        }
      }
      if (!bP(this.ayz)) {
        i(this.ayz, true);
      }
    }
    for (;;)
    {
      if (this.ayz != null) {
        this.ayz.setText(paramCharSequence);
      }
      this.ayS = paramCharSequence;
      return;
      if ((this.ayz != null) && (bP(this.ayz)))
      {
        removeView(this.ayz);
        this.ayW.remove(this.ayz);
      }
    }
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    this.ayO = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    this.ayM = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    this.ayL = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    this.ayN = paramInt;
    requestLayout();
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.abH = paramInt;
    if (this.ayz != null) {
      this.ayz.setTextColor(paramInt);
    }
  }
  
  public final boolean showOverflowMenu()
  {
    if (this.ahs != null)
    {
      ActionMenuView localActionMenuView = this.ahs;
      if ((localActionMenuView.aiT != null) && (localActionMenuView.aiT.showOverflowMenu())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public static class LayoutParams
    extends ActionBar.LayoutParams
  {
    int azh = 0;
    
    public LayoutParams(int paramInt)
    {
      super(-2);
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
      this.azh = paramLayoutParams.azh;
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
    int azi;
    boolean azj;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.azi = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.azj = bool;
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
      paramParcel.writeInt(this.azi);
      if (this.azj) {}
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
    h aaQ;
    j azg;
    
    a() {}
    
    public final void a(Context paramContext, h paramh)
    {
      if ((this.aaQ != null) && (this.azg != null)) {
        this.aaQ.h(this.azg);
      }
      this.aaQ = paramh;
    }
    
    public final void a(h paramh, boolean paramBoolean) {}
    
    public final void a(o.a parama) {}
    
    public final boolean a(android.support.v7.view.menu.u paramu)
    {
      return false;
    }
    
    public final boolean b(j paramj)
    {
      Toolbar.this.na();
      Object localObject = Toolbar.this.ayF.getParent();
      if (localObject != Toolbar.this)
      {
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(Toolbar.this.ayF);
        }
        Toolbar.this.addView(Toolbar.this.ayF);
      }
      Toolbar.this.ayG = paramj.getActionView();
      this.azg = paramj;
      localObject = Toolbar.this.ayG.getParent();
      if (localObject != Toolbar.this)
      {
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(Toolbar.this.ayG);
        }
        localObject = Toolbar.nb();
        ((Toolbar.LayoutParams)localObject).gravity = (0x800003 | Toolbar.this.ayJ & 0x70);
        ((Toolbar.LayoutParams)localObject).azh = 2;
        Toolbar.this.ayG.setLayoutParams((ViewGroup.LayoutParams)localObject);
        Toolbar.this.addView(Toolbar.this.ayG);
      }
      localObject = Toolbar.this;
      int i = ((Toolbar)localObject).getChildCount() - 1;
      while (i >= 0)
      {
        View localView = ((Toolbar)localObject).getChildAt(i);
        if ((((Toolbar.LayoutParams)localView.getLayoutParams()).azh != 2) && (localView != ((Toolbar)localObject).ahs))
        {
          ((Toolbar)localObject).removeViewAt(i);
          ((Toolbar)localObject).ayW.add(localView);
        }
        i -= 1;
      }
      Toolbar.this.requestLayout();
      paramj.af(true);
      if ((Toolbar.this.ayG instanceof c)) {
        ((c)Toolbar.this.ayG).onActionViewExpanded();
      }
      return true;
    }
    
    public final boolean bF()
    {
      return false;
    }
    
    public final boolean c(j paramj)
    {
      if ((Toolbar.this.ayG instanceof c)) {
        ((c)Toolbar.this.ayG).onActionViewCollapsed();
      }
      Toolbar.this.removeView(Toolbar.this.ayG);
      Toolbar.this.removeView(Toolbar.this.ayF);
      Toolbar.this.ayG = null;
      Toolbar.this.nc();
      this.azg = null;
      Toolbar.this.requestLayout();
      paramj.af(false);
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
      if (this.azg != null)
      {
        j = k;
        if (this.aaQ != null)
        {
          m = this.aaQ.size();
          i = 0;
        }
      }
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (this.aaQ.getItem(i) == this.azg) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            c(this.azg);
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