package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
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
import androidx.appcompat.a.a;
import androidx.appcompat.a.j;
import androidx.appcompat.a.a.a;
import androidx.appcompat.app.ActionBar.LayoutParams;
import androidx.appcompat.view.c;
import androidx.appcompat.view.g;
import androidx.appcompat.view.menu.h.a;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.o.a;
import androidx.appcompat.view.menu.u;
import androidx.core.g.e;
import androidx.core.g.w;
import androidx.customview.view.AbsSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
  extends ViewGroup
{
  private Context nE;
  ActionMenuView nF;
  private boolean nJ;
  private boolean nK;
  private int pl;
  o.a pn;
  h.a po;
  private int sK;
  TextView wB;
  TextView wC;
  private ImageButton wD;
  private ImageView wE;
  private Drawable wF;
  private CharSequence wG;
  ImageButton wH;
  View wI;
  int wJ;
  int wK;
  int wL;
  private int wM;
  private int wN;
  private int wO;
  private int wP;
  private int wQ;
  v wR;
  private int wS;
  private int wT;
  private CharSequence wU;
  private CharSequence wV;
  private int wW;
  private int wX;
  private final ArrayList<View> wY;
  final ArrayList<View> wZ;
  private final int[] xa;
  b xb;
  private final ActionMenuView.d xc;
  private ad xd;
  private ActionMenuPresenter xe;
  a xf;
  private boolean xg;
  private final Runnable xh;
  
  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.toolbarStyle);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(242158);
    this.sK = 8388627;
    this.wY = new ArrayList();
    this.wZ = new ArrayList();
    this.xa = new int[2];
    this.xc = new ActionMenuView.d()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(242075);
        if (Toolbar.this.xb != null)
        {
          boolean bool = Toolbar.this.xb.onMenuItemClick(paramAnonymousMenuItem);
          AppMethodBeat.o(242075);
          return bool;
        }
        AppMethodBeat.o(242075);
        return false;
      }
    };
    this.xh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(242086);
        Toolbar.this.cC();
        AppMethodBeat.o(242086);
      }
    };
    paramContext = ac.a(getContext(), paramAttributeSet, a.j.Toolbar, paramInt, 0);
    this.wJ = paramContext.r(a.j.Toolbar_titleTextAppearance, 0);
    this.wK = paramContext.r(a.j.Toolbar_subtitleTextAppearance, 0);
    this.sK = paramContext.n(a.j.Toolbar_android_gravity, this.sK);
    this.wL = paramContext.n(a.j.Toolbar_buttonGravity, 48);
    int i = paramContext.o(a.j.Toolbar_titleMargin, 0);
    paramInt = i;
    if (paramContext.aC(a.j.Toolbar_titleMargins)) {
      paramInt = paramContext.o(a.j.Toolbar_titleMargins, i);
    }
    this.wQ = paramInt;
    this.wP = paramInt;
    this.wO = paramInt;
    this.wN = paramInt;
    paramInt = paramContext.o(a.j.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0) {
      this.wN = paramInt;
    }
    paramInt = paramContext.o(a.j.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0) {
      this.wO = paramInt;
    }
    paramInt = paramContext.o(a.j.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0) {
      this.wP = paramInt;
    }
    paramInt = paramContext.o(a.j.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0) {
      this.wQ = paramInt;
    }
    this.wM = paramContext.p(a.j.Toolbar_maxButtonHeight, -1);
    paramInt = paramContext.o(a.j.Toolbar_contentInsetStart, -2147483648);
    i = paramContext.o(a.j.Toolbar_contentInsetEnd, -2147483648);
    int j = paramContext.p(a.j.Toolbar_contentInsetLeft, 0);
    int k = paramContext.p(a.j.Toolbar_contentInsetRight, 0);
    eA();
    this.wR.l(j, k);
    if ((paramInt != -2147483648) || (i != -2147483648)) {
      this.wR.k(paramInt, i);
    }
    this.wS = paramContext.o(a.j.Toolbar_contentInsetStartWithNavigation, -2147483648);
    this.wT = paramContext.o(a.j.Toolbar_contentInsetEndWithActions, -2147483648);
    this.wF = paramContext.getDrawable(a.j.Toolbar_collapseIcon);
    this.wG = paramContext.getText(a.j.Toolbar_collapseContentDescription);
    paramAttributeSet = paramContext.getText(a.j.Toolbar_title);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(a.j.Toolbar_subtitle);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    this.nE = getContext();
    setPopupTheme(paramContext.r(a.j.Toolbar_popupTheme, 0));
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
    if (paramContext.aC(a.j.Toolbar_titleTextColor)) {
      setTitleTextColor(paramContext.m(a.j.Toolbar_titleTextColor, -1));
    }
    if (paramContext.aC(a.j.Toolbar_subtitleTextColor)) {
      setSubtitleTextColor(paramContext.m(a.j.Toolbar_subtitleTextColor, -1));
    }
    paramContext.wA.recycle();
    AppMethodBeat.o(242158);
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(242231);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int j = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int k = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int i = Math.max(0, j) + Math.max(0, k);
    paramArrayOfInt[0] = Math.max(0, -j);
    paramArrayOfInt[1] = Math.max(0, -k);
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + i + paramInt2, localMarginLayoutParams.width), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height));
    paramInt1 = paramView.getMeasuredWidth();
    AppMethodBeat.o(242231);
    return paramInt1 + i;
  }
  
  private int a(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    AppMethodBeat.i(242236);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.leftMargin - paramArrayOfInt[0];
    paramInt1 = Math.max(0, i) + paramInt1;
    paramArrayOfInt[0] = Math.max(0, -i);
    i = g(paramView, paramInt2);
    paramInt2 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, i, paramInt1 + paramInt2, paramView.getMeasuredHeight() + i);
    i = localLayoutParams.rightMargin;
    AppMethodBeat.o(242236);
    return i + paramInt2 + paramInt1;
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(242222);
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = ey();
    }
    for (;;)
    {
      ((LayoutParams)localObject).xk = 1;
      if ((!paramBoolean) || (this.wI == null)) {
        break;
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.wZ.add(paramView);
      AppMethodBeat.o(242222);
      return;
      if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
        localObject = c((ViewGroup.LayoutParams)localObject);
      } else {
        localObject = (LayoutParams)localObject;
      }
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(242222);
  }
  
  private void a(List<View> paramList, int paramInt)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(242241);
    if (w.I(this) == 1) {}
    int m;
    int k;
    View localView;
    LayoutParams localLayoutParams;
    for (;;)
    {
      m = getChildCount();
      k = e.D(paramInt, w.I(this));
      paramList.clear();
      paramInt = j;
      if (i == 0) {
        break label133;
      }
      paramInt = m - 1;
      while (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams.xk == 0) && (n(localView)) && (aE(localLayoutParams.ek) == k)) {
          paramList.add(localView);
        }
        paramInt -= 1;
      }
      i = 0;
    }
    AppMethodBeat.o(242241);
    return;
    label133:
    while (paramInt < m)
    {
      localView = getChildAt(paramInt);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams.xk == 0) && (n(localView)) && (aE(localLayoutParams.ek) == k)) {
        paramList.add(localView);
      }
      paramInt += 1;
    }
    AppMethodBeat.o(242241);
  }
  
  private int aD(int paramInt)
  {
    int i = paramInt & 0x70;
    paramInt = i;
    switch (i)
    {
    default: 
      paramInt = this.sK & 0x70;
    }
    return paramInt;
  }
  
  private int aE(int paramInt)
  {
    AppMethodBeat.i(242242);
    int i = w.I(this);
    paramInt = e.D(paramInt, i) & 0x7;
    switch (paramInt)
    {
    case 2: 
    case 4: 
    default: 
      if (i == 1)
      {
        AppMethodBeat.o(242242);
        return 5;
      }
      break;
    case 1: 
    case 3: 
    case 5: 
      AppMethodBeat.o(242242);
      return paramInt;
    }
    AppMethodBeat.o(242242);
    return 3;
  }
  
  private int b(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    AppMethodBeat.i(242237);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i);
    paramArrayOfInt[1] = Math.max(0, -i);
    i = g(paramView, paramInt2);
    paramInt2 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - paramInt2, i, paramInt1, paramView.getMeasuredHeight() + i);
    i = localLayoutParams.leftMargin;
    AppMethodBeat.o(242237);
    return paramInt1 - (i + paramInt2);
  }
  
  private static LayoutParams c(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(242246);
    if ((paramLayoutParams instanceof LayoutParams))
    {
      paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
      AppMethodBeat.o(242246);
      return paramLayoutParams;
    }
    if ((paramLayoutParams instanceof ActionBar.LayoutParams))
    {
      paramLayoutParams = new LayoutParams((ActionBar.LayoutParams)paramLayoutParams);
      AppMethodBeat.o(242246);
      return paramLayoutParams;
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      AppMethodBeat.o(242246);
      return paramLayoutParams;
    }
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(242246);
    return paramLayoutParams;
  }
  
  private void d(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(242230);
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
    AppMethodBeat.o(242230);
  }
  
  private void es()
  {
    AppMethodBeat.i(242178);
    if (this.wE == null) {
      this.wE = new AppCompatImageView(getContext());
    }
    AppMethodBeat.o(242178);
  }
  
  private void et()
  {
    AppMethodBeat.i(242200);
    eu();
    if (this.nF.is == null)
    {
      androidx.appcompat.view.menu.h localh = (androidx.appcompat.view.menu.h)this.nF.getMenu();
      if (this.xf == null) {
        this.xf = new a();
      }
      this.nF.setExpandedActionViewsExclusive(true);
      localh.a(this.xf, this.nE);
    }
    AppMethodBeat.o(242200);
  }
  
  private void eu()
  {
    AppMethodBeat.i(242201);
    if (this.nF == null)
    {
      this.nF = new ActionMenuView(getContext());
      this.nF.setPopupTheme(this.pl);
      this.nF.setOnMenuItemClickListener(this.xc);
      this.nF.a(this.pn, this.po);
      LayoutParams localLayoutParams = ey();
      localLayoutParams.ek = (0x800005 | this.wL & 0x70);
      this.nF.setLayoutParams(localLayoutParams);
      a(this.nF, false);
    }
    AppMethodBeat.o(242201);
  }
  
  private void ew()
  {
    AppMethodBeat.i(242220);
    if (this.wD == null)
    {
      this.wD = new AppCompatImageButton(getContext(), null, a.a.toolbarNavigationButtonStyle);
      LayoutParams localLayoutParams = ey();
      localLayoutParams.ek = (0x800003 | this.wL & 0x70);
      this.wD.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(242220);
  }
  
  protected static LayoutParams ey()
  {
    AppMethodBeat.i(242247);
    LayoutParams localLayoutParams = new LayoutParams(-2);
    AppMethodBeat.o(242247);
    return localLayoutParams;
  }
  
  private int g(View paramView, int paramInt)
  {
    AppMethodBeat.i(242239);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredHeight();
    int j;
    int k;
    int m;
    if (paramInt > 0)
    {
      paramInt = (i - paramInt) / 2;
      switch (aD(localLayoutParams.ek))
      {
      default: 
        j = getPaddingTop();
        k = getPaddingBottom();
        m = getHeight();
        paramInt = (m - j - k - i) / 2;
        if (paramInt < localLayoutParams.topMargin) {
          paramInt = localLayoutParams.topMargin;
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(242239);
      return paramInt + j;
      paramInt = 0;
      break;
      i = getPaddingTop();
      AppMethodBeat.o(242239);
      return i - paramInt;
      j = getHeight();
      k = getPaddingBottom();
      m = localLayoutParams.bottomMargin;
      AppMethodBeat.o(242239);
      return j - k - i - m - paramInt;
      i = m - k - i - paramInt - j;
      if (i < localLayoutParams.bottomMargin) {
        paramInt = Math.max(0, paramInt - (localLayoutParams.bottomMargin - i));
      }
    }
  }
  
  private MenuInflater getMenuInflater()
  {
    AppMethodBeat.i(242204);
    g localg = new g(getContext());
    AppMethodBeat.o(242204);
    return localg;
  }
  
  private boolean n(View paramView)
  {
    AppMethodBeat.i(242243);
    if ((paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8))
    {
      AppMethodBeat.o(242243);
      return true;
    }
    AppMethodBeat.o(242243);
    return false;
  }
  
  private static int o(View paramView)
  {
    AppMethodBeat.i(242244);
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = androidx.core.g.h.a(paramView);
    int j = androidx.core.g.h.b(paramView);
    AppMethodBeat.o(242244);
    return j + i;
  }
  
  private static int p(View paramView)
  {
    AppMethodBeat.i(242245);
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = paramView.topMargin;
    int j = paramView.bottomMargin;
    AppMethodBeat.o(242245);
    return j + i;
  }
  
  private boolean q(View paramView)
  {
    AppMethodBeat.i(242251);
    if ((paramView.getParent() == this) || (this.wZ.contains(paramView)))
    {
      AppMethodBeat.o(242251);
      return true;
    }
    AppMethodBeat.o(242251);
    return false;
  }
  
  public final void a(androidx.appcompat.view.menu.h paramh, ActionMenuPresenter paramActionMenuPresenter)
  {
    AppMethodBeat.i(242169);
    if ((paramh == null) && (this.nF == null))
    {
      AppMethodBeat.o(242169);
      return;
    }
    eu();
    androidx.appcompat.view.menu.h localh = this.nF.is;
    if (localh == paramh)
    {
      AppMethodBeat.o(242169);
      return;
    }
    if (localh != null)
    {
      localh.b(this.xe);
      localh.b(this.xf);
    }
    if (this.xf == null) {
      this.xf = new a();
    }
    paramActionMenuPresenter.oU = true;
    if (paramh != null)
    {
      paramh.a(paramActionMenuPresenter, this.nE);
      paramh.a(this.xf, this.nE);
    }
    for (;;)
    {
      this.nF.setPopupTheme(this.pl);
      this.nF.setPresenter(paramActionMenuPresenter);
      this.xe = paramActionMenuPresenter;
      AppMethodBeat.o(242169);
      return;
      paramActionMenuPresenter.a(this.nE, null);
      this.xf.a(this.nE, null);
      paramActionMenuPresenter.F(true);
      this.xf.F(true);
    }
  }
  
  public final boolean cC()
  {
    AppMethodBeat.i(242168);
    if (this.nF != null)
    {
      ActionMenuView localActionMenuView = this.nF;
      if ((localActionMenuView.pm != null) && (localActionMenuView.pm.cC())) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(242168);
        return true;
      }
    }
    AppMethodBeat.o(242168);
    return false;
  }
  
  public final boolean cJ()
  {
    AppMethodBeat.i(242167);
    if (this.nF != null)
    {
      ActionMenuView localActionMenuView = this.nF;
      if ((localActionMenuView.pm != null) && (localActionMenuView.pm.cJ())) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(242167);
        return true;
      }
    }
    AppMethodBeat.o(242167);
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(242248);
    if ((super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams)))
    {
      AppMethodBeat.o(242248);
      return true;
    }
    AppMethodBeat.o(242248);
    return false;
  }
  
  public final void dG()
  {
    AppMethodBeat.i(242180);
    if (this.xf == null) {}
    for (j localj = null;; localj = this.xf.xj)
    {
      if (localj != null) {
        localj.collapseActionView();
      }
      AppMethodBeat.o(242180);
      return;
    }
  }
  
  final void eA()
  {
    AppMethodBeat.i(242253);
    if (this.wR == null) {
      this.wR = new v();
    }
    AppMethodBeat.o(242253);
  }
  
  public final void ev()
  {
    AppMethodBeat.i(242207);
    eA();
    this.wR.l(0, 0);
    AppMethodBeat.o(242207);
  }
  
  final void ex()
  {
    AppMethodBeat.i(242221);
    if (this.wH == null)
    {
      this.wH = new AppCompatImageButton(getContext(), null, a.a.toolbarNavigationButtonStyle);
      this.wH.setImageDrawable(this.wF);
      this.wH.setContentDescription(this.wG);
      LayoutParams localLayoutParams = ey();
      localLayoutParams.ek = (0x800003 | this.wL & 0x70);
      localLayoutParams.xk = 2;
      this.wH.setLayoutParams(localLayoutParams);
      this.wH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(242090);
          Toolbar.this.dG();
          AppMethodBeat.o(242090);
        }
      });
    }
    AppMethodBeat.o(242221);
  }
  
  final void ez()
  {
    AppMethodBeat.i(242250);
    int i = this.wZ.size() - 1;
    while (i >= 0)
    {
      addView((View)this.wZ.get(i));
      i -= 1;
    }
    this.wZ.clear();
    AppMethodBeat.o(242250);
  }
  
  public int getContentInsetEnd()
  {
    if (this.wR != null)
    {
      v localv = this.wR;
      if (localv.tL) {
        return localv.tF;
      }
      return localv.tG;
    }
    return 0;
  }
  
  public int getContentInsetEndWithActions()
  {
    AppMethodBeat.i(242213);
    if (this.wT != -2147483648)
    {
      i = this.wT;
      AppMethodBeat.o(242213);
      return i;
    }
    int i = getContentInsetEnd();
    AppMethodBeat.o(242213);
    return i;
  }
  
  public int getContentInsetLeft()
  {
    if (this.wR != null) {
      return this.wR.tF;
    }
    return 0;
  }
  
  public int getContentInsetRight()
  {
    if (this.wR != null) {
      return this.wR.tG;
    }
    return 0;
  }
  
  public int getContentInsetStart()
  {
    if (this.wR != null)
    {
      v localv = this.wR;
      if (localv.tL) {
        return localv.tG;
      }
      return localv.tF;
    }
    return 0;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    AppMethodBeat.i(242209);
    if (this.wS != -2147483648)
    {
      i = this.wS;
      AppMethodBeat.o(242209);
      return i;
    }
    int i = getContentInsetStart();
    AppMethodBeat.o(242209);
    return i;
  }
  
  public int getCurrentContentInsetEnd()
  {
    AppMethodBeat.i(242217);
    int i;
    if (this.nF != null)
    {
      androidx.appcompat.view.menu.h localh = this.nF.is;
      if ((localh != null) && (localh.hasVisibleItems())) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        i = Math.max(getContentInsetEnd(), Math.max(this.wT, 0));
        AppMethodBeat.o(242217);
        return i;
        i = 0;
      }
      else
      {
        i = getContentInsetEnd();
        AppMethodBeat.o(242217);
        return i;
        i = 0;
      }
    }
  }
  
  public int getCurrentContentInsetLeft()
  {
    AppMethodBeat.i(242218);
    if (w.I(this) == 1)
    {
      i = getCurrentContentInsetEnd();
      AppMethodBeat.o(242218);
      return i;
    }
    int i = getCurrentContentInsetStart();
    AppMethodBeat.o(242218);
    return i;
  }
  
  public int getCurrentContentInsetRight()
  {
    AppMethodBeat.i(242219);
    if (w.I(this) == 1)
    {
      i = getCurrentContentInsetStart();
      AppMethodBeat.o(242219);
      return i;
    }
    int i = getCurrentContentInsetEnd();
    AppMethodBeat.o(242219);
    return i;
  }
  
  public int getCurrentContentInsetStart()
  {
    AppMethodBeat.i(242216);
    if (getNavigationIcon() != null)
    {
      i = Math.max(getContentInsetStart(), Math.max(this.wS, 0));
      AppMethodBeat.o(242216);
      return i;
    }
    int i = getContentInsetStart();
    AppMethodBeat.o(242216);
    return i;
  }
  
  public Drawable getLogo()
  {
    AppMethodBeat.i(242172);
    if (this.wE != null)
    {
      Drawable localDrawable = this.wE.getDrawable();
      AppMethodBeat.o(242172);
      return localDrawable;
    }
    AppMethodBeat.o(242172);
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    AppMethodBeat.i(242177);
    if (this.wE != null)
    {
      CharSequence localCharSequence = this.wE.getContentDescription();
      AppMethodBeat.o(242177);
      return localCharSequence;
    }
    AppMethodBeat.o(242177);
    return null;
  }
  
  public Menu getMenu()
  {
    AppMethodBeat.i(242197);
    et();
    Menu localMenu = this.nF.getMenu();
    AppMethodBeat.o(242197);
    return localMenu;
  }
  
  public CharSequence getNavigationContentDescription()
  {
    AppMethodBeat.i(242188);
    if (this.wD != null)
    {
      CharSequence localCharSequence = this.wD.getContentDescription();
      AppMethodBeat.o(242188);
      return localCharSequence;
    }
    AppMethodBeat.o(242188);
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    AppMethodBeat.i(242195);
    if (this.wD != null)
    {
      Drawable localDrawable = this.wD.getDrawable();
      AppMethodBeat.o(242195);
      return localDrawable;
    }
    AppMethodBeat.o(242195);
    return null;
  }
  
  ActionMenuPresenter getOuterActionMenuPresenter()
  {
    return this.xe;
  }
  
  public Drawable getOverflowIcon()
  {
    AppMethodBeat.i(242199);
    et();
    Drawable localDrawable = this.nF.getOverflowIcon();
    AppMethodBeat.o(242199);
    return localDrawable;
  }
  
  Context getPopupContext()
  {
    return this.nE;
  }
  
  public int getPopupTheme()
  {
    return this.pl;
  }
  
  public CharSequence getSubtitle()
  {
    return this.wV;
  }
  
  public CharSequence getTitle()
  {
    return this.wU;
  }
  
  public int getTitleMarginBottom()
  {
    return this.wQ;
  }
  
  public int getTitleMarginEnd()
  {
    return this.wO;
  }
  
  public int getTitleMarginStart()
  {
    return this.wN;
  }
  
  public int getTitleMarginTop()
  {
    return this.wP;
  }
  
  public n getWrapper()
  {
    AppMethodBeat.i(242249);
    if (this.xd == null) {
      this.xd = new ad(this, true);
    }
    ad localad = this.xd;
    AppMethodBeat.o(242249);
    return localad;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(242225);
    super.onDetachedFromWindow();
    removeCallbacks(this.xh);
    AppMethodBeat.o(242225);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(242229);
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.nK = false;
    }
    if (!this.nK)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.nK = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.nK = false;
    }
    AppMethodBeat.o(242229);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(242234);
    int k;
    int i1;
    int i4;
    int j;
    int i2;
    int i3;
    int i5;
    int[] arrayOfInt;
    int i;
    if (w.I(this) == 1)
    {
      k = 1;
      i1 = getWidth();
      i4 = getHeight();
      j = getPaddingLeft();
      i2 = getPaddingRight();
      i3 = getPaddingTop();
      i5 = getPaddingBottom();
      paramInt1 = i1 - i2;
      arrayOfInt = this.xa;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      paramInt3 = w.P(this);
      if (paramInt3 < 0) {
        break label902;
      }
      i = Math.min(paramInt3, paramInt4 - paramInt2);
      label97:
      if (!n(this.wD)) {
        break label1749;
      }
      if (k == 0) {
        break label908;
      }
      paramInt1 = b(this.wD, paramInt1, arrayOfInt, i);
      paramInt2 = j;
    }
    for (;;)
    {
      label130:
      paramInt3 = paramInt1;
      paramInt4 = paramInt2;
      if (n(this.wH))
      {
        if (k != 0)
        {
          paramInt3 = b(this.wH, paramInt1, arrayOfInt, i);
          paramInt4 = paramInt2;
        }
      }
      else
      {
        label170:
        paramInt1 = paramInt3;
        paramInt2 = paramInt4;
        if (n(this.nF))
        {
          if (k == 0) {
            break label947;
          }
          paramInt2 = a(this.nF, paramInt4, arrayOfInt, i);
          paramInt1 = paramInt3;
        }
        label210:
        paramInt3 = getCurrentContentInsetLeft();
        paramInt4 = getCurrentContentInsetRight();
        arrayOfInt[0] = Math.max(0, paramInt3 - paramInt2);
        arrayOfInt[1] = Math.max(0, paramInt4 - (i1 - i2 - paramInt1));
        paramInt3 = Math.max(paramInt2, paramInt3);
        paramInt4 = Math.min(paramInt1, i1 - i2 - paramInt4);
        paramInt2 = paramInt4;
        paramInt1 = paramInt3;
        if (n(this.wI))
        {
          if (k == 0) {
            break label968;
          }
          paramInt2 = b(this.wI, paramInt4, arrayOfInt, i);
          paramInt1 = paramInt3;
        }
        label314:
        if (!n(this.wE)) {
          break label1741;
        }
        if (k == 0) {
          break label989;
        }
        paramInt3 = b(this.wE, paramInt2, arrayOfInt, i);
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        label347:
        paramBoolean = n(this.wB);
        boolean bool = n(this.wC);
        paramInt1 = 0;
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = (LayoutParams)this.wB.getLayoutParams();
          paramInt1 = ((LayoutParams)localObject1).topMargin;
          paramInt4 = this.wB.getMeasuredHeight();
          paramInt1 = ((LayoutParams)localObject1).bottomMargin + (paramInt1 + paramInt4) + 0;
        }
        int m;
        if (bool)
        {
          localObject1 = (LayoutParams)this.wC.getLayoutParams();
          paramInt4 = ((LayoutParams)localObject1).topMargin;
          m = this.wC.getMeasuredHeight();
        }
        label548:
        label1707:
        for (int n = ((LayoutParams)localObject1).bottomMargin + (paramInt4 + m) + paramInt1;; n = paramInt1)
        {
          label485:
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
              break label1011;
            }
            localObject1 = this.wB;
            if (!bool) {
              break label1020;
            }
            localObject2 = this.wC;
            label496:
            localObject1 = (LayoutParams)((View)localObject1).getLayoutParams();
            localObject2 = (LayoutParams)((View)localObject2).getLayoutParams();
            if (((!paramBoolean) || (this.wB.getMeasuredWidth() <= 0)) && ((!bool) || (this.wC.getMeasuredWidth() <= 0))) {
              break label1029;
            }
            m = 1;
            switch (this.sK & 0x70)
            {
            default: 
              paramInt1 = (i4 - i3 - i5 - n) / 2;
              if (paramInt1 < ((LayoutParams)localObject1).topMargin + this.wP) {
                paramInt1 = ((LayoutParams)localObject1).topMargin + this.wP;
              }
              break;
            }
          }
          label947:
          label1725:
          label1732:
          for (;;)
          {
            label619:
            paramInt1 = i3 + paramInt1;
            label624:
            if (k != 0) {
              if (m != 0)
              {
                paramInt4 = this.wN;
                paramInt4 -= arrayOfInt[1];
                paramInt3 -= Math.max(0, paramInt4);
                arrayOfInt[1] = Math.max(0, -paramInt4);
                if (!paramBoolean) {
                  break label1725;
                }
                localObject1 = (LayoutParams)this.wB.getLayoutParams();
                paramInt4 = paramInt3 - this.wB.getMeasuredWidth();
                k = this.wB.getMeasuredHeight() + paramInt1;
                this.wB.layout(paramInt4, paramInt1, paramInt3, k);
                n = this.wO;
                paramInt1 = k + ((LayoutParams)localObject1).bottomMargin;
                paramInt4 -= n;
              }
            }
            for (;;)
            {
              if (bool)
              {
                localObject1 = (LayoutParams)this.wC.getLayoutParams();
                paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1;
                k = this.wC.getMeasuredWidth();
                n = this.wC.getMeasuredHeight();
                this.wC.layout(paramInt3 - k, paramInt1, paramInt3, n + paramInt1);
                paramInt1 = this.wO;
                k = ((LayoutParams)localObject1).bottomMargin;
              }
              for (paramInt1 = paramInt3 - paramInt1;; paramInt1 = paramInt3)
              {
                if (m != 0) {}
                for (paramInt1 = Math.min(paramInt4, paramInt1);; paramInt1 = paramInt3)
                {
                  paramInt4 = paramInt1;
                  paramInt1 = paramInt2;
                  a(this.wY, 3);
                  paramInt3 = this.wY.size();
                  paramInt2 = 0;
                  for (;;)
                  {
                    if (paramInt2 < paramInt3)
                    {
                      paramInt1 = a((View)this.wY.get(paramInt2), paramInt1, arrayOfInt, i);
                      paramInt2 += 1;
                      continue;
                      k = 0;
                      break;
                      i = 0;
                      break label97;
                      paramInt2 = a(this.wD, j, arrayOfInt, i);
                      break label130;
                      paramInt4 = a(this.wH, paramInt2, arrayOfInt, i);
                      paramInt3 = paramInt1;
                      break label170;
                      paramInt1 = b(this.nF, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label210;
                      label968:
                      paramInt1 = a(this.wI, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label314;
                      label989:
                      paramInt1 = a(this.wE, paramInt1, arrayOfInt, i);
                      paramInt3 = paramInt2;
                      paramInt2 = paramInt1;
                      break label347;
                      label1011:
                      localObject1 = this.wC;
                      break label485;
                      label1020:
                      localObject2 = this.wB;
                      break label496;
                      m = 0;
                      break label548;
                      paramInt1 = getPaddingTop();
                      paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1 + this.wP;
                      break label624;
                      paramInt4 = i4 - i5 - n - paramInt1 - i3;
                      if (paramInt4 >= ((LayoutParams)localObject1).bottomMargin + this.wQ) {
                        break label1732;
                      }
                      paramInt1 = Math.max(0, paramInt1 - (((LayoutParams)localObject2).bottomMargin + this.wQ - paramInt4));
                      break label619;
                      paramInt1 = i4 - i5 - ((LayoutParams)localObject2).bottomMargin - this.wQ - n;
                      break label624;
                      paramInt4 = 0;
                      break label640;
                      if (m != 0)
                      {
                        paramInt4 = this.wN;
                        label1149:
                        paramInt4 -= arrayOfInt[0];
                        paramInt2 += Math.max(0, paramInt4);
                        arrayOfInt[0] = Math.max(0, -paramInt4);
                        if (!paramBoolean) {
                          break label1707;
                        }
                        localObject1 = (LayoutParams)this.wB.getLayoutParams();
                        k = this.wB.getMeasuredWidth() + paramInt2;
                        paramInt4 = this.wB.getMeasuredHeight() + paramInt1;
                        this.wB.layout(paramInt2, paramInt1, k, paramInt4);
                        n = this.wO;
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
                      localObject1 = (LayoutParams)this.wC.getLayoutParams();
                      paramInt4 = ((LayoutParams)localObject1).topMargin + paramInt1;
                      paramInt1 = this.wC.getMeasuredWidth() + paramInt2;
                      n = this.wC.getMeasuredHeight();
                      this.wC.layout(paramInt2, paramInt4, paramInt1, n + paramInt4);
                      paramInt4 = this.wO;
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
                      break label1149;
                      a(this.wY, 5);
                      k = this.wY.size();
                      paramInt3 = 0;
                      paramInt2 = paramInt4;
                      while (paramInt3 < k)
                      {
                        paramInt2 = b((View)this.wY.get(paramInt3), paramInt2, arrayOfInt, i);
                        paramInt3 += 1;
                      }
                      a(this.wY, 1);
                      localObject1 = this.wY;
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
                        paramInt4 = this.wY.size();
                        paramInt3 = 0;
                        paramInt2 = paramInt1;
                        paramInt1 = paramInt3;
                        while (paramInt1 < paramInt4)
                        {
                          paramInt2 = a((View)this.wY.get(paramInt1), paramInt2, arrayOfInt, i);
                          paramInt1 += 1;
                        }
                        paramInt1 = paramInt4;
                        if (paramInt3 > paramInt2) {
                          paramInt1 = paramInt4 - (paramInt3 - paramInt2);
                        }
                      }
                      this.wY.clear();
                      AppMethodBeat.o(242234);
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
        label640:
        label902:
        label908:
        label1741:
        paramInt3 = paramInt2;
        label1029:
        paramInt2 = paramInt1;
      }
      label1749:
      paramInt2 = j;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242232);
    Object localObject = this.xa;
    int n;
    int i1;
    int i;
    int m;
    int k;
    if (ai.s(this))
    {
      n = 0;
      i1 = 1;
      i = 0;
      if (!n(this.wD)) {
        break label1020;
      }
      d(this.wD, paramInt1, 0, paramInt2, this.wM);
      i = this.wD.getMeasuredWidth() + o(this.wD);
      m = Math.max(0, this.wD.getMeasuredHeight() + p(this.wD));
      k = View.combineMeasuredStates(0, this.wD.getMeasuredState());
    }
    for (;;)
    {
      int i2 = i;
      i = k;
      int j = m;
      if (n(this.wH))
      {
        d(this.wH, paramInt1, 0, paramInt2, this.wM);
        i2 = this.wH.getMeasuredWidth() + o(this.wH);
        j = Math.max(m, this.wH.getMeasuredHeight() + p(this.wH));
        i = View.combineMeasuredStates(k, this.wH.getMeasuredState());
      }
      k = getCurrentContentInsetStart();
      int i3 = Math.max(k, i2) + 0;
      localObject[i1] = Math.max(0, k - i2);
      i1 = 0;
      k = i;
      m = j;
      if (n(this.nF))
      {
        d(this.nF, paramInt1, i3, paramInt2, this.wM);
        i1 = this.nF.getMeasuredWidth() + o(this.nF);
        m = Math.max(j, this.nF.getMeasuredHeight() + p(this.nF));
        k = View.combineMeasuredStates(i, this.nF.getMeasuredState());
      }
      i = getCurrentContentInsetEnd();
      i2 = i3 + Math.max(i, i1);
      localObject[n] = Math.max(0, i - i1);
      n = i2;
      i = k;
      j = m;
      if (n(this.wI))
      {
        n = i2 + a(this.wI, paramInt1, i2, paramInt2, 0, (int[])localObject);
        j = Math.max(m, this.wI.getMeasuredHeight() + p(this.wI));
        i = View.combineMeasuredStates(k, this.wI.getMeasuredState());
      }
      k = n;
      i1 = i;
      m = j;
      if (n(this.wE))
      {
        k = n + a(this.wE, paramInt1, n, paramInt2, 0, (int[])localObject);
        m = Math.max(j, this.wE.getMeasuredHeight() + p(this.wE));
        i1 = View.combineMeasuredStates(i, this.wE.getMeasuredState());
      }
      i2 = getChildCount();
      n = 0;
      i = i1;
      j = m;
      m = n;
      i1 = k;
      label518:
      if (m < i2)
      {
        View localView = getChildAt(m);
        if ((((LayoutParams)localView.getLayoutParams()).xk != 0) || (!n(localView))) {
          break label1007;
        }
        i1 += a(localView, paramInt1, i1, paramInt2, 0, (int[])localObject);
        k = Math.max(j, localView.getMeasuredHeight() + p(localView));
        j = View.combineMeasuredStates(i, localView.getMeasuredState());
      }
      for (i = k;; i = k)
      {
        m += 1;
        k = i;
        i = j;
        j = k;
        break label518;
        n = 1;
        i1 = 0;
        break;
        n = 0;
        m = 0;
        int i4 = this.wP + this.wQ;
        int i5 = this.wN + this.wO;
        k = i;
        if (n(this.wB))
        {
          a(this.wB, paramInt1, i1 + i5, paramInt2, i4, (int[])localObject);
          k = this.wB.getMeasuredWidth();
          n = o(this.wB) + k;
          m = this.wB.getMeasuredHeight() + p(this.wB);
          k = View.combineMeasuredStates(i, this.wB.getMeasuredState());
        }
        i3 = m;
        i2 = n;
        i = k;
        if (n(this.wC))
        {
          i2 = Math.max(n, a(this.wC, paramInt1, i1 + i5, paramInt2, i4 + m, (int[])localObject));
          i3 = m + (this.wC.getMeasuredHeight() + p(this.wC));
          i = View.combineMeasuredStates(k, this.wC.getMeasuredState());
        }
        k = Math.max(j, i3);
        j = getPaddingLeft();
        i3 = getPaddingRight();
        m = getPaddingTop();
        n = getPaddingBottom();
        j = View.resolveSizeAndState(Math.max(i2 + i1 + (j + i3), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i);
        paramInt2 = View.resolveSizeAndState(Math.max(k + (m + n), getSuggestedMinimumHeight()), paramInt2, i << 16);
        if (!this.xg) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 != 0) {
            paramInt2 = 0;
          }
          setMeasuredDimension(j, paramInt2);
          AppMethodBeat.o(242232);
          return;
          i = getChildCount();
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 >= i) {
              break label1002;
            }
            localObject = getChildAt(paramInt1);
            if ((n((View)localObject)) && (((View)localObject).getMeasuredWidth() > 0) && (((View)localObject).getMeasuredHeight() > 0))
            {
              paramInt1 = 0;
              break;
            }
            paramInt1 += 1;
          }
          label1002:
          paramInt1 = 1;
        }
        label1007:
        k = j;
        j = i;
      }
      label1020:
      k = 0;
      m = 0;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(242224);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(242224);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.Rb);
    if (this.nF != null) {}
    for (paramParcelable = this.nF.is;; paramParcelable = null)
    {
      if ((localSavedState.xl != 0) && (this.xf != null) && (paramParcelable != null))
      {
        paramParcelable = paramParcelable.findItem(localSavedState.xl);
        if (paramParcelable != null) {
          paramParcelable.expandActionView();
        }
      }
      if (localSavedState.xm)
      {
        removeCallbacks(this.xh);
        post(this.xh);
      }
      AppMethodBeat.o(242224);
      return;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(242165);
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    eA();
    v localv = this.wR;
    if (paramInt == 1)
    {
      if (bool == localv.tL) {
        break label202;
      }
      localv.tL = bool;
      if (!localv.tM) {
        break label186;
      }
      if (!bool) {
        break label125;
      }
      if (localv.tI == -2147483648) {
        break label109;
      }
      paramInt = localv.tI;
      label73:
      localv.tF = paramInt;
      if (localv.tH == -2147483648) {
        break label117;
      }
    }
    label109:
    label117:
    for (paramInt = localv.tH;; paramInt = localv.tK)
    {
      localv.tG = paramInt;
      AppMethodBeat.o(242165);
      return;
      bool = false;
      break;
      paramInt = localv.tJ;
      break label73;
    }
    label125:
    if (localv.tH != -2147483648)
    {
      paramInt = localv.tH;
      localv.tF = paramInt;
      if (localv.tI == -2147483648) {
        break label178;
      }
    }
    label178:
    for (paramInt = localv.tI;; paramInt = localv.tK)
    {
      localv.tG = paramInt;
      AppMethodBeat.o(242165);
      return;
      paramInt = localv.tJ;
      break;
    }
    label186:
    localv.tF = localv.tJ;
    localv.tG = localv.tK;
    label202:
    AppMethodBeat.o(242165);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(242223);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((this.xf != null) && (this.xf.xj != null)) {
      localSavedState.xl = this.xf.xj.getItemId();
    }
    localSavedState.xm = cJ();
    AppMethodBeat.o(242223);
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(242226);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.nJ = false;
    }
    if (!this.nJ)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.nJ = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.nJ = false;
    }
    AppMethodBeat.o(242226);
    return true;
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    AppMethodBeat.i(242252);
    this.xg = paramBoolean;
    requestLayout();
    AppMethodBeat.o(242252);
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    AppMethodBeat.i(242215);
    int i = paramInt;
    if (paramInt < 0) {
      i = -2147483648;
    }
    if (i != this.wT)
    {
      this.wT = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
    AppMethodBeat.o(242215);
  }
  
  public void setContentInsetStartWithNavigation(int paramInt)
  {
    AppMethodBeat.i(242212);
    int i = paramInt;
    if (paramInt < 0) {
      i = -2147483648;
    }
    if (i != this.wS)
    {
      this.wS = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
    AppMethodBeat.o(242212);
  }
  
  public void setLogo(int paramInt)
  {
    AppMethodBeat.i(242166);
    setLogo(a.m(getContext(), paramInt));
    AppMethodBeat.o(242166);
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(242171);
    if (paramDrawable != null)
    {
      es();
      if (!q(this.wE)) {
        a(this.wE, true);
      }
    }
    for (;;)
    {
      if (this.wE != null) {
        this.wE.setImageDrawable(paramDrawable);
      }
      AppMethodBeat.o(242171);
      return;
      if ((this.wE != null) && (q(this.wE)))
      {
        removeView(this.wE);
        this.wZ.remove(this.wE);
      }
    }
  }
  
  public void setLogoDescription(int paramInt)
  {
    AppMethodBeat.i(242173);
    setLogoDescription(getContext().getText(paramInt));
    AppMethodBeat.o(242173);
  }
  
  public void setLogoDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(242175);
    if (!TextUtils.isEmpty(paramCharSequence)) {
      es();
    }
    if (this.wE != null) {
      this.wE.setContentDescription(paramCharSequence);
    }
    AppMethodBeat.o(242175);
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    AppMethodBeat.i(242189);
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = getContext().getText(paramInt);; localCharSequence = null)
    {
      setNavigationContentDescription(localCharSequence);
      AppMethodBeat.o(242189);
      return;
    }
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(242190);
    if (!TextUtils.isEmpty(paramCharSequence)) {
      ew();
    }
    if (this.wD != null) {
      this.wD.setContentDescription(paramCharSequence);
    }
    AppMethodBeat.o(242190);
  }
  
  public void setNavigationIcon(int paramInt)
  {
    AppMethodBeat.i(242192);
    setNavigationIcon(a.m(getContext(), paramInt));
    AppMethodBeat.o(242192);
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(242193);
    if (paramDrawable != null)
    {
      ew();
      if (!q(this.wD)) {
        a(this.wD, true);
      }
    }
    for (;;)
    {
      if (this.wD != null) {
        this.wD.setImageDrawable(paramDrawable);
      }
      AppMethodBeat.o(242193);
      return;
      if ((this.wD != null) && (q(this.wD)))
      {
        removeView(this.wD);
        this.wZ.remove(this.wD);
      }
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(242196);
    ew();
    this.wD.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(242196);
  }
  
  public void setOnMenuItemClickListener(b paramb)
  {
    this.xb = paramb;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(242198);
    et();
    this.nF.setOverflowIcon(paramDrawable);
    AppMethodBeat.o(242198);
  }
  
  public void setPopupTheme(int paramInt)
  {
    AppMethodBeat.i(242159);
    if (this.pl != paramInt)
    {
      this.pl = paramInt;
      if (paramInt == 0)
      {
        this.nE = getContext();
        AppMethodBeat.o(242159);
        return;
      }
      this.nE = new ContextThemeWrapper(getContext(), paramInt);
    }
    AppMethodBeat.o(242159);
  }
  
  public void setSubtitle(int paramInt)
  {
    AppMethodBeat.i(242184);
    setSubtitle(getContext().getText(paramInt));
    AppMethodBeat.o(242184);
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(242185);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.wC == null)
      {
        Context localContext = getContext();
        this.wC = new AppCompatTextView(localContext);
        this.wC.setSingleLine();
        this.wC.setEllipsize(TextUtils.TruncateAt.END);
        if (this.wK != 0) {
          this.wC.setTextAppearance(localContext, this.wK);
        }
        if (this.wX != 0) {
          this.wC.setTextColor(this.wX);
        }
      }
      if (!q(this.wC)) {
        a(this.wC, true);
      }
    }
    for (;;)
    {
      if (this.wC != null) {
        this.wC.setText(paramCharSequence);
      }
      this.wV = paramCharSequence;
      AppMethodBeat.o(242185);
      return;
      if ((this.wC != null) && (q(this.wC)))
      {
        removeView(this.wC);
        this.wZ.remove(this.wC);
      }
    }
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    AppMethodBeat.i(242187);
    this.wX = paramInt;
    if (this.wC != null) {
      this.wC.setTextColor(paramInt);
    }
    AppMethodBeat.o(242187);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(242181);
    setTitle(getContext().getText(paramInt));
    AppMethodBeat.o(242181);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(242183);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.wB == null)
      {
        Context localContext = getContext();
        this.wB = new AppCompatTextView(localContext);
        this.wB.setSingleLine();
        this.wB.setEllipsize(TextUtils.TruncateAt.END);
        if (this.wJ != 0) {
          this.wB.setTextAppearance(localContext, this.wJ);
        }
        if (this.wW != 0) {
          this.wB.setTextColor(this.wW);
        }
      }
      if (!q(this.wB)) {
        a(this.wB, true);
      }
    }
    for (;;)
    {
      if (this.wB != null) {
        this.wB.setText(paramCharSequence);
      }
      this.wU = paramCharSequence;
      AppMethodBeat.o(242183);
      return;
      if ((this.wB != null) && (q(this.wB)))
      {
        removeView(this.wB);
        this.wZ.remove(this.wB);
      }
    }
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    AppMethodBeat.i(242164);
    this.wQ = paramInt;
    requestLayout();
    AppMethodBeat.o(242164);
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    AppMethodBeat.i(242163);
    this.wO = paramInt;
    requestLayout();
    AppMethodBeat.o(242163);
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    AppMethodBeat.i(242161);
    this.wN = paramInt;
    requestLayout();
    AppMethodBeat.o(242161);
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    AppMethodBeat.i(242162);
    this.wP = paramInt;
    requestLayout();
    AppMethodBeat.o(242162);
  }
  
  public void setTitleTextColor(int paramInt)
  {
    AppMethodBeat.i(242186);
    this.wW = paramInt;
    if (this.wB != null) {
      this.wB.setTextColor(paramInt);
    }
    AppMethodBeat.o(242186);
  }
  
  public static class LayoutParams
    extends ActionBar.LayoutParams
  {
    int xk;
    
    public LayoutParams(int paramInt)
    {
      super(-2);
      this.xk = 0;
      this.ek = 8388627;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.xk = 0;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.xk = 0;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      AppMethodBeat.i(242105);
      this.xk = 0;
      this.leftMargin = paramMarginLayoutParams.leftMargin;
      this.topMargin = paramMarginLayoutParams.topMargin;
      this.rightMargin = paramMarginLayoutParams.rightMargin;
      this.bottomMargin = paramMarginLayoutParams.bottomMargin;
      AppMethodBeat.o(242105);
    }
    
    public LayoutParams(ActionBar.LayoutParams paramLayoutParams)
    {
      super();
      this.xk = 0;
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.xk = 0;
      this.xk = paramLayoutParams.xk;
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    int xl;
    boolean xm;
    
    static
    {
      AppMethodBeat.i(242143);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(242143);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(242140);
      this.xl = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.xm = bool;
        AppMethodBeat.o(242140);
        return;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(242142);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.xl);
      if (this.xm) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(242142);
        return;
      }
    }
  }
  
  final class a
    implements o
  {
    androidx.appcompat.view.menu.h is;
    j xj;
    
    a() {}
    
    public final void F(boolean paramBoolean)
    {
      int k = 0;
      AppMethodBeat.i(242097);
      int j;
      int m;
      int i;
      if (this.xj != null)
      {
        j = k;
        if (this.is != null)
        {
          m = this.is.size();
          i = 0;
        }
      }
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (this.is.getItem(i) == this.xj) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            d(this.xj);
          }
          AppMethodBeat.o(242097);
          return;
        }
        i += 1;
      }
    }
    
    public final void a(Context paramContext, androidx.appcompat.view.menu.h paramh)
    {
      AppMethodBeat.i(242096);
      if ((this.is != null) && (this.xj != null)) {
        this.is.g(this.xj);
      }
      this.is = paramh;
      AppMethodBeat.o(242096);
    }
    
    public final void a(androidx.appcompat.view.menu.h paramh, boolean paramBoolean) {}
    
    public final boolean a(u paramu)
    {
      return false;
    }
    
    public final void b(o.a parama) {}
    
    public final boolean bS()
    {
      return false;
    }
    
    public final boolean c(j paramj)
    {
      AppMethodBeat.i(242101);
      Toolbar.this.ex();
      Object localObject = Toolbar.this.wH.getParent();
      if (localObject != Toolbar.this)
      {
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(Toolbar.this.wH);
        }
        Toolbar.this.addView(Toolbar.this.wH);
      }
      Toolbar.this.wI = paramj.getActionView();
      this.xj = paramj;
      localObject = Toolbar.this.wI.getParent();
      if (localObject != Toolbar.this)
      {
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(Toolbar.this.wI);
        }
        localObject = Toolbar.ey();
        ((Toolbar.LayoutParams)localObject).ek = (0x800003 | Toolbar.this.wL & 0x70);
        ((Toolbar.LayoutParams)localObject).xk = 2;
        Toolbar.this.wI.setLayoutParams((ViewGroup.LayoutParams)localObject);
        Toolbar.this.addView(Toolbar.this.wI);
      }
      localObject = Toolbar.this;
      int i = ((Toolbar)localObject).getChildCount() - 1;
      while (i >= 0)
      {
        View localView = ((Toolbar)localObject).getChildAt(i);
        if ((((Toolbar.LayoutParams)localView.getLayoutParams()).xk != 2) && (localView != ((Toolbar)localObject).nF))
        {
          ((Toolbar)localObject).removeViewAt(i);
          ((Toolbar)localObject).wZ.add(localView);
        }
        i -= 1;
      }
      Toolbar.this.requestLayout();
      paramj.M(true);
      if ((Toolbar.this.wI instanceof c)) {
        ((c)Toolbar.this.wI).bB();
      }
      AppMethodBeat.o(242101);
      return true;
    }
    
    public final boolean d(j paramj)
    {
      AppMethodBeat.i(242102);
      if ((Toolbar.this.wI instanceof c)) {
        ((c)Toolbar.this.wI).bC();
      }
      Toolbar.this.removeView(Toolbar.this.wI);
      Toolbar.this.removeView(Toolbar.this.wH);
      Toolbar.this.wI = null;
      Toolbar.this.ez();
      this.xj = null;
      Toolbar.this.requestLayout();
      paramj.M(false);
      AppMethodBeat.o(242102);
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
  }
  
  public static abstract interface b
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.Toolbar
 * JD-Core Version:    0.7.0.1
 */