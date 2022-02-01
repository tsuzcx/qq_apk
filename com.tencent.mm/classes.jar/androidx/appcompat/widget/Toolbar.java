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
import androidx.core.g.z;
import androidx.customview.view.AbsSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
  extends ViewGroup
{
  private Context oD;
  ActionMenuView oE;
  private boolean oI;
  private boolean oJ;
  private int qh;
  o.a qj;
  h.a qk;
  private int tJ;
  private Drawable xA;
  private CharSequence xB;
  ImageButton xC;
  View xD;
  int xE;
  int xF;
  int xG;
  private int xH;
  private int xI;
  private int xJ;
  private int xK;
  private int xL;
  v xM;
  private int xN;
  private int xO;
  private CharSequence xP;
  private CharSequence xQ;
  private int xR;
  private int xS;
  private final ArrayList<View> xT;
  final ArrayList<View> xU;
  private final int[] xV;
  b xW;
  private final ActionMenuView.d xX;
  private ad xY;
  private ActionMenuPresenter xZ;
  TextView xw;
  TextView xx;
  private ImageButton xy;
  private ImageView xz;
  a ya;
  private boolean yb;
  private final Runnable yc;
  
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
    AppMethodBeat.i(199593);
    this.tJ = 8388627;
    this.xT = new ArrayList();
    this.xU = new ArrayList();
    this.xV = new int[2];
    this.xX = new ActionMenuView.d()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(200148);
        if (Toolbar.this.xW != null)
        {
          boolean bool = Toolbar.this.xW.onMenuItemClick(paramAnonymousMenuItem);
          AppMethodBeat.o(200148);
          return bool;
        }
        AppMethodBeat.o(200148);
        return false;
      }
    };
    this.yc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200162);
        Toolbar.this.dv();
        AppMethodBeat.o(200162);
      }
    };
    paramContext = ac.a(getContext(), paramAttributeSet, a.j.Toolbar, paramInt, 0);
    this.xE = paramContext.w(a.j.Toolbar_titleTextAppearance, 0);
    this.xF = paramContext.w(a.j.Toolbar_subtitleTextAppearance, 0);
    this.tJ = paramContext.s(a.j.Toolbar_android_gravity, this.tJ);
    this.xG = paramContext.s(a.j.Toolbar_buttonGravity, 48);
    int i = paramContext.t(a.j.Toolbar_titleMargin, 0);
    paramInt = i;
    if (paramContext.az(a.j.Toolbar_titleMargins)) {
      paramInt = paramContext.t(a.j.Toolbar_titleMargins, i);
    }
    this.xL = paramInt;
    this.xK = paramInt;
    this.xJ = paramInt;
    this.xI = paramInt;
    paramInt = paramContext.t(a.j.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0) {
      this.xI = paramInt;
    }
    paramInt = paramContext.t(a.j.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0) {
      this.xJ = paramInt;
    }
    paramInt = paramContext.t(a.j.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0) {
      this.xK = paramInt;
    }
    paramInt = paramContext.t(a.j.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0) {
      this.xL = paramInt;
    }
    this.xH = paramContext.u(a.j.Toolbar_maxButtonHeight, -1);
    paramInt = paramContext.t(a.j.Toolbar_contentInsetStart, -2147483648);
    i = paramContext.t(a.j.Toolbar_contentInsetEnd, -2147483648);
    int j = paramContext.u(a.j.Toolbar_contentInsetLeft, 0);
    int k = paramContext.u(a.j.Toolbar_contentInsetRight, 0);
    fx();
    this.xM.q(j, k);
    if ((paramInt != -2147483648) || (i != -2147483648)) {
      this.xM.p(paramInt, i);
    }
    this.xN = paramContext.t(a.j.Toolbar_contentInsetStartWithNavigation, -2147483648);
    this.xO = paramContext.t(a.j.Toolbar_contentInsetEndWithActions, -2147483648);
    this.xA = paramContext.getDrawable(a.j.Toolbar_collapseIcon);
    this.xB = paramContext.getText(a.j.Toolbar_collapseContentDescription);
    paramAttributeSet = paramContext.getText(a.j.Toolbar_title);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(a.j.Toolbar_subtitle);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    this.oD = getContext();
    setPopupTheme(paramContext.w(a.j.Toolbar_popupTheme, 0));
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
    if (paramContext.az(a.j.Toolbar_titleTextColor)) {
      setTitleTextColor(paramContext.r(a.j.Toolbar_titleTextColor, -1));
    }
    if (paramContext.az(a.j.Toolbar_subtitleTextColor)) {
      setSubtitleTextColor(paramContext.r(a.j.Toolbar_subtitleTextColor, -1));
    }
    paramContext.xv.recycle();
    AppMethodBeat.o(199593);
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(199718);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int j = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int k = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int i = Math.max(0, j) + Math.max(0, k);
    paramArrayOfInt[0] = Math.max(0, -j);
    paramArrayOfInt[1] = Math.max(0, -k);
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + i + paramInt2, localMarginLayoutParams.width), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height));
    paramInt1 = paramView.getMeasuredWidth();
    AppMethodBeat.o(199718);
    return paramInt1 + i;
  }
  
  private int a(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    AppMethodBeat.i(199732);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.leftMargin - paramArrayOfInt[0];
    paramInt1 = Math.max(0, i) + paramInt1;
    paramArrayOfInt[0] = Math.max(0, -i);
    i = g(paramView, paramInt2);
    paramInt2 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, i, paramInt1 + paramInt2, paramView.getMeasuredHeight() + i);
    i = localLayoutParams.rightMargin;
    AppMethodBeat.o(199732);
    return i + paramInt2 + paramInt1;
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(199688);
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = fv();
    }
    for (;;)
    {
      ((LayoutParams)localObject).yf = 1;
      if ((!paramBoolean) || (this.xD == null)) {
        break;
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.xU.add(paramView);
      AppMethodBeat.o(199688);
      return;
      if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
        localObject = c((ViewGroup.LayoutParams)localObject);
      } else {
        localObject = (LayoutParams)localObject;
      }
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(199688);
  }
  
  private int aA(int paramInt)
  {
    int i = paramInt & 0x70;
    paramInt = i;
    switch (i)
    {
    default: 
      paramInt = this.tJ & 0x70;
    }
    return paramInt;
  }
  
  private int aB(int paramInt)
  {
    AppMethodBeat.i(199812);
    int i = z.U(this);
    paramInt = e.ay(paramInt, i) & 0x7;
    switch (paramInt)
    {
    case 2: 
    case 4: 
    default: 
      if (i == 1)
      {
        AppMethodBeat.o(199812);
        return 5;
      }
      break;
    case 1: 
    case 3: 
    case 5: 
      AppMethodBeat.o(199812);
      return paramInt;
    }
    AppMethodBeat.o(199812);
    return 3;
  }
  
  private int b(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    AppMethodBeat.i(199743);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i);
    paramArrayOfInt[1] = Math.max(0, -i);
    i = g(paramView, paramInt2);
    paramInt2 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - paramInt2, i, paramInt1, paramView.getMeasuredHeight() + i);
    i = localLayoutParams.leftMargin;
    AppMethodBeat.o(199743);
    return paramInt1 - (i + paramInt2);
  }
  
  private void b(List<View> paramList, int paramInt)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(199798);
    if (z.U(this) == 1) {}
    int m;
    int k;
    View localView;
    LayoutParams localLayoutParams;
    for (;;)
    {
      m = getChildCount();
      k = e.ay(paramInt, z.U(this));
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
        if ((localLayoutParams.yf == 0) && (n(localView)) && (aB(localLayoutParams.fl) == k)) {
          paramList.add(localView);
        }
        paramInt -= 1;
      }
      i = 0;
    }
    AppMethodBeat.o(199798);
    return;
    label133:
    while (paramInt < m)
    {
      localView = getChildAt(paramInt);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams.yf == 0) && (n(localView)) && (aB(localLayoutParams.fl) == k)) {
        paramList.add(localView);
      }
      paramInt += 1;
    }
    AppMethodBeat.o(199798);
  }
  
  private static LayoutParams c(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(199885);
    if ((paramLayoutParams instanceof LayoutParams))
    {
      paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
      AppMethodBeat.o(199885);
      return paramLayoutParams;
    }
    if ((paramLayoutParams instanceof ActionBar.LayoutParams))
    {
      paramLayoutParams = new LayoutParams((ActionBar.LayoutParams)paramLayoutParams);
      AppMethodBeat.o(199885);
      return paramLayoutParams;
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      AppMethodBeat.o(199885);
      return paramLayoutParams;
    }
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(199885);
    return paramLayoutParams;
  }
  
  private void d(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199707);
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
    AppMethodBeat.o(199707);
  }
  
  private void fp()
  {
    AppMethodBeat.i(199607);
    if (this.xz == null) {
      this.xz = new AppCompatImageView(getContext());
    }
    AppMethodBeat.o(199607);
  }
  
  private void fq()
  {
    AppMethodBeat.i(199627);
    fr();
    if (this.oE.jo == null)
    {
      androidx.appcompat.view.menu.h localh = (androidx.appcompat.view.menu.h)this.oE.getMenu();
      if (this.ya == null) {
        this.ya = new a();
      }
      this.oE.setExpandedActionViewsExclusive(true);
      localh.a(this.ya, this.oD);
    }
    AppMethodBeat.o(199627);
  }
  
  private void fr()
  {
    AppMethodBeat.i(199646);
    if (this.oE == null)
    {
      this.oE = new ActionMenuView(getContext());
      this.oE.setPopupTheme(this.qh);
      this.oE.setOnMenuItemClickListener(this.xX);
      this.oE.a(this.qj, this.qk);
      LayoutParams localLayoutParams = fv();
      localLayoutParams.fl = (0x800005 | this.xG & 0x70);
      this.oE.setLayoutParams(localLayoutParams);
      a(this.oE, false);
    }
    AppMethodBeat.o(199646);
  }
  
  private void ft()
  {
    AppMethodBeat.i(199672);
    if (this.xy == null)
    {
      this.xy = new AppCompatImageButton(getContext(), null, a.a.toolbarNavigationButtonStyle);
      LayoutParams localLayoutParams = fv();
      localLayoutParams.fl = (0x800003 | this.xG & 0x70);
      this.xy.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(199672);
  }
  
  protected static LayoutParams fv()
  {
    AppMethodBeat.i(199895);
    LayoutParams localLayoutParams = new LayoutParams(-2);
    AppMethodBeat.o(199895);
    return localLayoutParams;
  }
  
  private int g(View paramView, int paramInt)
  {
    AppMethodBeat.i(199766);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredHeight();
    int j;
    int k;
    int m;
    if (paramInt > 0)
    {
      paramInt = (i - paramInt) / 2;
      switch (aA(localLayoutParams.fl))
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
      AppMethodBeat.o(199766);
      return paramInt + j;
      paramInt = 0;
      break;
      i = getPaddingTop();
      AppMethodBeat.o(199766);
      return i - paramInt;
      j = getHeight();
      k = getPaddingBottom();
      m = localLayoutParams.bottomMargin;
      AppMethodBeat.o(199766);
      return j - k - i - m - paramInt;
      i = m - k - i - paramInt - j;
      if (i < localLayoutParams.bottomMargin) {
        paramInt = Math.max(0, paramInt - (localLayoutParams.bottomMargin - i));
      }
    }
  }
  
  private MenuInflater getMenuInflater()
  {
    AppMethodBeat.i(199656);
    g localg = new g(getContext());
    AppMethodBeat.o(199656);
    return localg;
  }
  
  private boolean n(View paramView)
  {
    AppMethodBeat.i(199830);
    if ((paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8))
    {
      AppMethodBeat.o(199830);
      return true;
    }
    AppMethodBeat.o(199830);
    return false;
  }
  
  private static int o(View paramView)
  {
    AppMethodBeat.i(199850);
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = androidx.core.g.h.a(paramView);
    int j = androidx.core.g.h.b(paramView);
    AppMethodBeat.o(199850);
    return j + i;
  }
  
  private static int p(View paramView)
  {
    AppMethodBeat.i(199867);
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = paramView.topMargin;
    int j = paramView.bottomMargin;
    AppMethodBeat.o(199867);
    return j + i;
  }
  
  private boolean q(View paramView)
  {
    AppMethodBeat.i(199902);
    if ((paramView.getParent() == this) || (this.xU.contains(paramView)))
    {
      AppMethodBeat.o(199902);
      return true;
    }
    AppMethodBeat.o(199902);
    return false;
  }
  
  public final void a(androidx.appcompat.view.menu.h paramh, ActionMenuPresenter paramActionMenuPresenter)
  {
    AppMethodBeat.i(200099);
    if ((paramh == null) && (this.oE == null))
    {
      AppMethodBeat.o(200099);
      return;
    }
    fr();
    androidx.appcompat.view.menu.h localh = this.oE.jo;
    if (localh == paramh)
    {
      AppMethodBeat.o(200099);
      return;
    }
    if (localh != null)
    {
      localh.b(this.xZ);
      localh.b(this.ya);
    }
    if (this.ya == null) {
      this.ya = new a();
    }
    paramActionMenuPresenter.pR = true;
    if (paramh != null)
    {
      paramh.a(paramActionMenuPresenter, this.oD);
      paramh.a(this.ya, this.oD);
    }
    for (;;)
    {
      this.oE.setPopupTheme(this.qh);
      this.oE.setPresenter(paramActionMenuPresenter);
      this.xZ = paramActionMenuPresenter;
      AppMethodBeat.o(200099);
      return;
      paramActionMenuPresenter.a(this.oD, null);
      this.ya.a(this.oD, null);
      paramActionMenuPresenter.J(true);
      this.ya.J(true);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(200758);
    if ((super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams)))
    {
      AppMethodBeat.o(200758);
      return true;
    }
    AppMethodBeat.o(200758);
    return false;
  }
  
  public final boolean dC()
  {
    AppMethodBeat.i(200066);
    if (this.oE != null)
    {
      ActionMenuView localActionMenuView = this.oE;
      if ((localActionMenuView.qi != null) && (localActionMenuView.qi.dC())) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(200066);
        return true;
      }
    }
    AppMethodBeat.o(200066);
    return false;
  }
  
  public final boolean dv()
  {
    AppMethodBeat.i(200080);
    if (this.oE != null)
    {
      ActionMenuView localActionMenuView = this.oE;
      if ((localActionMenuView.qi != null) && (localActionMenuView.qi.dv())) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(200080);
        return true;
      }
    }
    AppMethodBeat.o(200080);
    return false;
  }
  
  public final void eF()
  {
    AppMethodBeat.i(200182);
    if (this.ya == null) {}
    for (j localj = null;; localj = this.ya.ye)
    {
      if (localj != null) {
        localj.collapseActionView();
      }
      AppMethodBeat.o(200182);
      return;
    }
  }
  
  public final void fs()
  {
    AppMethodBeat.i(200446);
    fx();
    this.xM.q(0, 0);
    AppMethodBeat.o(200446);
  }
  
  final void fu()
  {
    AppMethodBeat.i(200589);
    if (this.xC == null)
    {
      this.xC = new AppCompatImageButton(getContext(), null, a.a.toolbarNavigationButtonStyle);
      this.xC.setImageDrawable(this.xA);
      this.xC.setContentDescription(this.xB);
      LayoutParams localLayoutParams = fv();
      localLayoutParams.fl = (0x800003 | this.xG & 0x70);
      localLayoutParams.yf = 2;
      this.xC.setLayoutParams(localLayoutParams);
      this.xC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(200117);
          Toolbar.this.eF();
          AppMethodBeat.o(200117);
        }
      });
    }
    AppMethodBeat.o(200589);
  }
  
  final void fw()
  {
    AppMethodBeat.i(200793);
    int i = this.xU.size() - 1;
    while (i >= 0)
    {
      addView((View)this.xU.get(i));
      i -= 1;
    }
    this.xU.clear();
    AppMethodBeat.o(200793);
  }
  
  final void fx()
  {
    AppMethodBeat.i(200822);
    if (this.xM == null) {
      this.xM = new v();
    }
    AppMethodBeat.o(200822);
  }
  
  public int getContentInsetEnd()
  {
    if (this.xM != null)
    {
      v localv = this.xM;
      if (localv.uK) {
        return localv.uE;
      }
      return localv.uF;
    }
    return 0;
  }
  
  public int getContentInsetEndWithActions()
  {
    AppMethodBeat.i(200506);
    if (this.xO != -2147483648)
    {
      i = this.xO;
      AppMethodBeat.o(200506);
      return i;
    }
    int i = getContentInsetEnd();
    AppMethodBeat.o(200506);
    return i;
  }
  
  public int getContentInsetLeft()
  {
    if (this.xM != null) {
      return this.xM.uE;
    }
    return 0;
  }
  
  public int getContentInsetRight()
  {
    if (this.xM != null) {
      return this.xM.uF;
    }
    return 0;
  }
  
  public int getContentInsetStart()
  {
    if (this.xM != null)
    {
      v localv = this.xM;
      if (localv.uK) {
        return localv.uF;
      }
      return localv.uE;
    }
    return 0;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    AppMethodBeat.i(200481);
    if (this.xN != -2147483648)
    {
      i = this.xN;
      AppMethodBeat.o(200481);
      return i;
    }
    int i = getContentInsetStart();
    AppMethodBeat.o(200481);
    return i;
  }
  
  public int getCurrentContentInsetEnd()
  {
    AppMethodBeat.i(200541);
    int i;
    if (this.oE != null)
    {
      androidx.appcompat.view.menu.h localh = this.oE.jo;
      if ((localh != null) && (localh.hasVisibleItems())) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        i = Math.max(getContentInsetEnd(), Math.max(this.xO, 0));
        AppMethodBeat.o(200541);
        return i;
        i = 0;
      }
      else
      {
        i = getContentInsetEnd();
        AppMethodBeat.o(200541);
        return i;
        i = 0;
      }
    }
  }
  
  public int getCurrentContentInsetLeft()
  {
    AppMethodBeat.i(200557);
    if (z.U(this) == 1)
    {
      i = getCurrentContentInsetEnd();
      AppMethodBeat.o(200557);
      return i;
    }
    int i = getCurrentContentInsetStart();
    AppMethodBeat.o(200557);
    return i;
  }
  
  public int getCurrentContentInsetRight()
  {
    AppMethodBeat.i(200572);
    if (z.U(this) == 1)
    {
      i = getCurrentContentInsetStart();
      AppMethodBeat.o(200572);
      return i;
    }
    int i = getCurrentContentInsetEnd();
    AppMethodBeat.o(200572);
    return i;
  }
  
  public int getCurrentContentInsetStart()
  {
    AppMethodBeat.i(200530);
    if (getNavigationIcon() != null)
    {
      i = Math.max(getContentInsetStart(), Math.max(this.xN, 0));
      AppMethodBeat.o(200530);
      return i;
    }
    int i = getContentInsetStart();
    AppMethodBeat.o(200530);
    return i;
  }
  
  public Drawable getLogo()
  {
    AppMethodBeat.i(200124);
    if (this.xz != null)
    {
      Drawable localDrawable = this.xz.getDrawable();
      AppMethodBeat.o(200124);
      return localDrawable;
    }
    AppMethodBeat.o(200124);
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    AppMethodBeat.i(200170);
    if (this.xz != null)
    {
      CharSequence localCharSequence = this.xz.getContentDescription();
      AppMethodBeat.o(200170);
      return localCharSequence;
    }
    AppMethodBeat.o(200170);
    return null;
  }
  
  public Menu getMenu()
  {
    AppMethodBeat.i(200378);
    fq();
    Menu localMenu = this.oE.getMenu();
    AppMethodBeat.o(200378);
    return localMenu;
  }
  
  public CharSequence getNavigationContentDescription()
  {
    AppMethodBeat.i(200275);
    if (this.xy != null)
    {
      CharSequence localCharSequence = this.xy.getContentDescription();
      AppMethodBeat.o(200275);
      return localCharSequence;
    }
    AppMethodBeat.o(200275);
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    AppMethodBeat.i(200354);
    if (this.xy != null)
    {
      Drawable localDrawable = this.xy.getDrawable();
      AppMethodBeat.o(200354);
      return localDrawable;
    }
    AppMethodBeat.o(200354);
    return null;
  }
  
  ActionMenuPresenter getOuterActionMenuPresenter()
  {
    return this.xZ;
  }
  
  public Drawable getOverflowIcon()
  {
    AppMethodBeat.i(200403);
    fq();
    Drawable localDrawable = this.oE.getOverflowIcon();
    AppMethodBeat.o(200403);
    return localDrawable;
  }
  
  Context getPopupContext()
  {
    return this.oD;
  }
  
  public int getPopupTheme()
  {
    return this.qh;
  }
  
  public CharSequence getSubtitle()
  {
    return this.xQ;
  }
  
  public CharSequence getTitle()
  {
    return this.xP;
  }
  
  public int getTitleMarginBottom()
  {
    return this.xL;
  }
  
  public int getTitleMarginEnd()
  {
    return this.xJ;
  }
  
  public int getTitleMarginStart()
  {
    return this.xI;
  }
  
  public int getTitleMarginTop()
  {
    return this.xK;
  }
  
  public n getWrapper()
  {
    AppMethodBeat.i(200779);
    if (this.xY == null) {
      this.xY = new ad(this, true);
    }
    ad localad = this.xY;
    AppMethodBeat.o(200779);
    return localad;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(200626);
    super.onDetachedFromWindow();
    removeCallbacks(this.yc);
    AppMethodBeat.o(200626);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200652);
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.oJ = false;
    }
    if (!this.oJ)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.oJ = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.oJ = false;
    }
    AppMethodBeat.o(200652);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200741);
    int k;
    int i1;
    int i4;
    int j;
    int i2;
    int i3;
    int i5;
    int[] arrayOfInt;
    int i;
    if (z.U(this) == 1)
    {
      k = 1;
      i1 = getWidth();
      i4 = getHeight();
      j = getPaddingLeft();
      i2 = getPaddingRight();
      i3 = getPaddingTop();
      i5 = getPaddingBottom();
      paramInt1 = i1 - i2;
      arrayOfInt = this.xV;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      paramInt3 = z.ab(this);
      if (paramInt3 < 0) {
        break label902;
      }
      i = Math.min(paramInt3, paramInt4 - paramInt2);
      label97:
      if (!n(this.xy)) {
        break label1749;
      }
      if (k == 0) {
        break label908;
      }
      paramInt1 = b(this.xy, paramInt1, arrayOfInt, i);
      paramInt2 = j;
    }
    for (;;)
    {
      label130:
      paramInt3 = paramInt1;
      paramInt4 = paramInt2;
      if (n(this.xC))
      {
        if (k != 0)
        {
          paramInt3 = b(this.xC, paramInt1, arrayOfInt, i);
          paramInt4 = paramInt2;
        }
      }
      else
      {
        label170:
        paramInt1 = paramInt3;
        paramInt2 = paramInt4;
        if (n(this.oE))
        {
          if (k == 0) {
            break label947;
          }
          paramInt2 = a(this.oE, paramInt4, arrayOfInt, i);
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
        if (n(this.xD))
        {
          if (k == 0) {
            break label968;
          }
          paramInt2 = b(this.xD, paramInt4, arrayOfInt, i);
          paramInt1 = paramInt3;
        }
        label314:
        if (!n(this.xz)) {
          break label1741;
        }
        if (k == 0) {
          break label989;
        }
        paramInt3 = b(this.xz, paramInt2, arrayOfInt, i);
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        label347:
        paramBoolean = n(this.xw);
        boolean bool = n(this.xx);
        paramInt1 = 0;
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = (LayoutParams)this.xw.getLayoutParams();
          paramInt1 = ((LayoutParams)localObject1).topMargin;
          paramInt4 = this.xw.getMeasuredHeight();
          paramInt1 = ((LayoutParams)localObject1).bottomMargin + (paramInt1 + paramInt4) + 0;
        }
        int m;
        if (bool)
        {
          localObject1 = (LayoutParams)this.xx.getLayoutParams();
          paramInt4 = ((LayoutParams)localObject1).topMargin;
          m = this.xx.getMeasuredHeight();
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
            localObject1 = this.xw;
            if (!bool) {
              break label1020;
            }
            localObject2 = this.xx;
            label496:
            localObject1 = (LayoutParams)((View)localObject1).getLayoutParams();
            localObject2 = (LayoutParams)((View)localObject2).getLayoutParams();
            if (((!paramBoolean) || (this.xw.getMeasuredWidth() <= 0)) && ((!bool) || (this.xx.getMeasuredWidth() <= 0))) {
              break label1029;
            }
            m = 1;
            switch (this.tJ & 0x70)
            {
            default: 
              paramInt1 = (i4 - i3 - i5 - n) / 2;
              if (paramInt1 < ((LayoutParams)localObject1).topMargin + this.xK) {
                paramInt1 = ((LayoutParams)localObject1).topMargin + this.xK;
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
                paramInt4 = this.xI;
                paramInt4 -= arrayOfInt[1];
                paramInt3 -= Math.max(0, paramInt4);
                arrayOfInt[1] = Math.max(0, -paramInt4);
                if (!paramBoolean) {
                  break label1725;
                }
                localObject1 = (LayoutParams)this.xw.getLayoutParams();
                paramInt4 = paramInt3 - this.xw.getMeasuredWidth();
                k = this.xw.getMeasuredHeight() + paramInt1;
                this.xw.layout(paramInt4, paramInt1, paramInt3, k);
                n = this.xJ;
                paramInt1 = k + ((LayoutParams)localObject1).bottomMargin;
                paramInt4 -= n;
              }
            }
            for (;;)
            {
              if (bool)
              {
                localObject1 = (LayoutParams)this.xx.getLayoutParams();
                paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1;
                k = this.xx.getMeasuredWidth();
                n = this.xx.getMeasuredHeight();
                this.xx.layout(paramInt3 - k, paramInt1, paramInt3, n + paramInt1);
                paramInt1 = this.xJ;
                k = ((LayoutParams)localObject1).bottomMargin;
              }
              for (paramInt1 = paramInt3 - paramInt1;; paramInt1 = paramInt3)
              {
                if (m != 0) {}
                for (paramInt1 = Math.min(paramInt4, paramInt1);; paramInt1 = paramInt3)
                {
                  paramInt4 = paramInt1;
                  paramInt1 = paramInt2;
                  b(this.xT, 3);
                  paramInt3 = this.xT.size();
                  paramInt2 = 0;
                  for (;;)
                  {
                    if (paramInt2 < paramInt3)
                    {
                      paramInt1 = a((View)this.xT.get(paramInt2), paramInt1, arrayOfInt, i);
                      paramInt2 += 1;
                      continue;
                      k = 0;
                      break;
                      i = 0;
                      break label97;
                      paramInt2 = a(this.xy, j, arrayOfInt, i);
                      break label130;
                      paramInt4 = a(this.xC, paramInt2, arrayOfInt, i);
                      paramInt3 = paramInt1;
                      break label170;
                      paramInt1 = b(this.oE, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label210;
                      label968:
                      paramInt1 = a(this.xD, paramInt3, arrayOfInt, i);
                      paramInt2 = paramInt4;
                      break label314;
                      label989:
                      paramInt1 = a(this.xz, paramInt1, arrayOfInt, i);
                      paramInt3 = paramInt2;
                      paramInt2 = paramInt1;
                      break label347;
                      label1011:
                      localObject1 = this.xx;
                      break label485;
                      label1020:
                      localObject2 = this.xw;
                      break label496;
                      m = 0;
                      break label548;
                      paramInt1 = getPaddingTop();
                      paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1 + this.xK;
                      break label624;
                      paramInt4 = i4 - i5 - n - paramInt1 - i3;
                      if (paramInt4 >= ((LayoutParams)localObject1).bottomMargin + this.xL) {
                        break label1732;
                      }
                      paramInt1 = Math.max(0, paramInt1 - (((LayoutParams)localObject2).bottomMargin + this.xL - paramInt4));
                      break label619;
                      paramInt1 = i4 - i5 - ((LayoutParams)localObject2).bottomMargin - this.xL - n;
                      break label624;
                      paramInt4 = 0;
                      break label640;
                      if (m != 0)
                      {
                        paramInt4 = this.xI;
                        label1149:
                        paramInt4 -= arrayOfInt[0];
                        paramInt2 += Math.max(0, paramInt4);
                        arrayOfInt[0] = Math.max(0, -paramInt4);
                        if (!paramBoolean) {
                          break label1707;
                        }
                        localObject1 = (LayoutParams)this.xw.getLayoutParams();
                        k = this.xw.getMeasuredWidth() + paramInt2;
                        paramInt4 = this.xw.getMeasuredHeight() + paramInt1;
                        this.xw.layout(paramInt2, paramInt1, k, paramInt4);
                        n = this.xJ;
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
                      localObject1 = (LayoutParams)this.xx.getLayoutParams();
                      paramInt4 = ((LayoutParams)localObject1).topMargin + paramInt1;
                      paramInt1 = this.xx.getMeasuredWidth() + paramInt2;
                      n = this.xx.getMeasuredHeight();
                      this.xx.layout(paramInt2, paramInt4, paramInt1, n + paramInt4);
                      paramInt4 = this.xJ;
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
                      b(this.xT, 5);
                      k = this.xT.size();
                      paramInt3 = 0;
                      paramInt2 = paramInt4;
                      while (paramInt3 < k)
                      {
                        paramInt2 = b((View)this.xT.get(paramInt3), paramInt2, arrayOfInt, i);
                        paramInt3 += 1;
                      }
                      b(this.xT, 1);
                      localObject1 = this.xT;
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
                        paramInt4 = this.xT.size();
                        paramInt3 = 0;
                        paramInt2 = paramInt1;
                        paramInt1 = paramInt3;
                        while (paramInt1 < paramInt4)
                        {
                          paramInt2 = a((View)this.xT.get(paramInt1), paramInt2, arrayOfInt, i);
                          paramInt1 += 1;
                        }
                        paramInt1 = paramInt4;
                        if (paramInt3 > paramInt2) {
                          paramInt1 = paramInt4 - (paramInt3 - paramInt2);
                        }
                      }
                      this.xT.clear();
                      AppMethodBeat.o(200741);
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
    AppMethodBeat.i(200693);
    Object localObject = this.xV;
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
      if (!n(this.xy)) {
        break label1020;
      }
      d(this.xy, paramInt1, 0, paramInt2, this.xH);
      i = this.xy.getMeasuredWidth() + o(this.xy);
      m = Math.max(0, this.xy.getMeasuredHeight() + p(this.xy));
      k = View.combineMeasuredStates(0, this.xy.getMeasuredState());
    }
    for (;;)
    {
      int i2 = i;
      i = k;
      int j = m;
      if (n(this.xC))
      {
        d(this.xC, paramInt1, 0, paramInt2, this.xH);
        i2 = this.xC.getMeasuredWidth() + o(this.xC);
        j = Math.max(m, this.xC.getMeasuredHeight() + p(this.xC));
        i = View.combineMeasuredStates(k, this.xC.getMeasuredState());
      }
      k = getCurrentContentInsetStart();
      int i3 = Math.max(k, i2) + 0;
      localObject[i1] = Math.max(0, k - i2);
      i1 = 0;
      k = i;
      m = j;
      if (n(this.oE))
      {
        d(this.oE, paramInt1, i3, paramInt2, this.xH);
        i1 = this.oE.getMeasuredWidth() + o(this.oE);
        m = Math.max(j, this.oE.getMeasuredHeight() + p(this.oE));
        k = View.combineMeasuredStates(i, this.oE.getMeasuredState());
      }
      i = getCurrentContentInsetEnd();
      i2 = i3 + Math.max(i, i1);
      localObject[n] = Math.max(0, i - i1);
      n = i2;
      i = k;
      j = m;
      if (n(this.xD))
      {
        n = i2 + a(this.xD, paramInt1, i2, paramInt2, 0, (int[])localObject);
        j = Math.max(m, this.xD.getMeasuredHeight() + p(this.xD));
        i = View.combineMeasuredStates(k, this.xD.getMeasuredState());
      }
      k = n;
      i1 = i;
      m = j;
      if (n(this.xz))
      {
        k = n + a(this.xz, paramInt1, n, paramInt2, 0, (int[])localObject);
        m = Math.max(j, this.xz.getMeasuredHeight() + p(this.xz));
        i1 = View.combineMeasuredStates(i, this.xz.getMeasuredState());
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
        if ((((LayoutParams)localView.getLayoutParams()).yf != 0) || (!n(localView))) {
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
        int i4 = this.xK + this.xL;
        int i5 = this.xI + this.xJ;
        k = i;
        if (n(this.xw))
        {
          a(this.xw, paramInt1, i1 + i5, paramInt2, i4, (int[])localObject);
          k = this.xw.getMeasuredWidth();
          n = o(this.xw) + k;
          m = this.xw.getMeasuredHeight() + p(this.xw);
          k = View.combineMeasuredStates(i, this.xw.getMeasuredState());
        }
        i3 = m;
        i2 = n;
        i = k;
        if (n(this.xx))
        {
          i2 = Math.max(n, a(this.xx, paramInt1, i1 + i5, paramInt2, i4 + m, (int[])localObject));
          i3 = m + (this.xx.getMeasuredHeight() + p(this.xx));
          i = View.combineMeasuredStates(k, this.xx.getMeasuredState());
        }
        k = Math.max(j, i3);
        j = getPaddingLeft();
        i3 = getPaddingRight();
        m = getPaddingTop();
        n = getPaddingBottom();
        j = View.resolveSizeAndState(Math.max(i2 + i1 + (j + i3), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i);
        paramInt2 = View.resolveSizeAndState(Math.max(k + (m + n), getSuggestedMinimumHeight()), paramInt2, i << 16);
        if (!this.yb) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 != 0) {
            paramInt2 = 0;
          }
          setMeasuredDimension(j, paramInt2);
          AppMethodBeat.o(200693);
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
    AppMethodBeat.i(200614);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(200614);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.bxs);
    if (this.oE != null) {}
    for (paramParcelable = this.oE.jo;; paramParcelable = null)
    {
      if ((localSavedState.yg != 0) && (this.ya != null) && (paramParcelable != null))
      {
        paramParcelable = paramParcelable.findItem(localSavedState.yg);
        if (paramParcelable != null) {
          paramParcelable.expandActionView();
        }
      }
      if (localSavedState.yh)
      {
        removeCallbacks(this.yc);
        post(this.yc);
      }
      AppMethodBeat.o(200614);
      return;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(200037);
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    fx();
    v localv = this.xM;
    if (paramInt == 1)
    {
      if (bool == localv.uK) {
        break label202;
      }
      localv.uK = bool;
      if (!localv.uL) {
        break label186;
      }
      if (!bool) {
        break label125;
      }
      if (localv.uH == -2147483648) {
        break label109;
      }
      paramInt = localv.uH;
      label73:
      localv.uE = paramInt;
      if (localv.uG == -2147483648) {
        break label117;
      }
    }
    label109:
    label117:
    for (paramInt = localv.uG;; paramInt = localv.uJ)
    {
      localv.uF = paramInt;
      AppMethodBeat.o(200037);
      return;
      bool = false;
      break;
      paramInt = localv.uI;
      break label73;
    }
    label125:
    if (localv.uG != -2147483648)
    {
      paramInt = localv.uG;
      localv.uE = paramInt;
      if (localv.uH == -2147483648) {
        break label178;
      }
    }
    label178:
    for (paramInt = localv.uH;; paramInt = localv.uJ)
    {
      localv.uF = paramInt;
      AppMethodBeat.o(200037);
      return;
      paramInt = localv.uI;
      break;
    }
    label186:
    localv.uE = localv.uI;
    localv.uF = localv.uJ;
    label202:
    AppMethodBeat.o(200037);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(200601);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((this.ya != null) && (this.ya.ye != null)) {
      localSavedState.yg = this.ya.ye.getItemId();
    }
    localSavedState.yh = dC();
    AppMethodBeat.o(200601);
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200642);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.oI = false;
    }
    if (!this.oI)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.oI = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.oI = false;
    }
    AppMethodBeat.o(200642);
    return true;
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    AppMethodBeat.i(200809);
    this.yb = paramBoolean;
    requestLayout();
    AppMethodBeat.o(200809);
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    AppMethodBeat.i(200518);
    int i = paramInt;
    if (paramInt < 0) {
      i = -2147483648;
    }
    if (i != this.xO)
    {
      this.xO = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
    AppMethodBeat.o(200518);
  }
  
  public void setContentInsetStartWithNavigation(int paramInt)
  {
    AppMethodBeat.i(200497);
    int i = paramInt;
    if (paramInt < 0) {
      i = -2147483648;
    }
    if (i != this.xN)
    {
      this.xN = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
    AppMethodBeat.o(200497);
  }
  
  public void setLogo(int paramInt)
  {
    AppMethodBeat.i(200052);
    setLogo(a.m(getContext(), paramInt));
    AppMethodBeat.o(200052);
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(200114);
    if (paramDrawable != null)
    {
      fp();
      if (!q(this.xz)) {
        a(this.xz, true);
      }
    }
    for (;;)
    {
      if (this.xz != null) {
        this.xz.setImageDrawable(paramDrawable);
      }
      AppMethodBeat.o(200114);
      return;
      if ((this.xz != null) && (q(this.xz)))
      {
        removeView(this.xz);
        this.xU.remove(this.xz);
      }
    }
  }
  
  public void setLogoDescription(int paramInt)
  {
    AppMethodBeat.i(200135);
    setLogoDescription(getContext().getText(paramInt));
    AppMethodBeat.o(200135);
  }
  
  public void setLogoDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200154);
    if (!TextUtils.isEmpty(paramCharSequence)) {
      fp();
    }
    if (this.xz != null) {
      this.xz.setContentDescription(paramCharSequence);
    }
    AppMethodBeat.o(200154);
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    AppMethodBeat.i(200287);
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = getContext().getText(paramInt);; localCharSequence = null)
    {
      setNavigationContentDescription(localCharSequence);
      AppMethodBeat.o(200287);
      return;
    }
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200295);
    if (!TextUtils.isEmpty(paramCharSequence)) {
      ft();
    }
    if (this.xy != null) {
      this.xy.setContentDescription(paramCharSequence);
    }
    AppMethodBeat.o(200295);
  }
  
  public void setNavigationIcon(int paramInt)
  {
    AppMethodBeat.i(200298);
    setNavigationIcon(a.m(getContext(), paramInt));
    AppMethodBeat.o(200298);
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(200342);
    if (paramDrawable != null)
    {
      ft();
      if (!q(this.xy)) {
        a(this.xy, true);
      }
    }
    for (;;)
    {
      if (this.xy != null) {
        this.xy.setImageDrawable(paramDrawable);
      }
      AppMethodBeat.o(200342);
      return;
      if ((this.xy != null) && (q(this.xy)))
      {
        removeView(this.xy);
        this.xU.remove(this.xy);
      }
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(200365);
    ft();
    this.xy.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(200365);
  }
  
  public void setOnMenuItemClickListener(b paramb)
  {
    this.xW = paramb;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(200389);
    fq();
    this.oE.setOverflowIcon(paramDrawable);
    AppMethodBeat.o(200389);
  }
  
  public void setPopupTheme(int paramInt)
  {
    AppMethodBeat.i(199913);
    if (this.qh != paramInt)
    {
      this.qh = paramInt;
      if (paramInt == 0)
      {
        this.oD = getContext();
        AppMethodBeat.o(199913);
        return;
      }
      this.oD = new ContextThemeWrapper(getContext(), paramInt);
    }
    AppMethodBeat.o(199913);
  }
  
  public void setSubtitle(int paramInt)
  {
    AppMethodBeat.i(200230);
    setSubtitle(getContext().getText(paramInt));
    AppMethodBeat.o(200230);
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200243);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.xx == null)
      {
        Context localContext = getContext();
        this.xx = new AppCompatTextView(localContext);
        this.xx.setSingleLine();
        this.xx.setEllipsize(TextUtils.TruncateAt.END);
        if (this.xF != 0) {
          this.xx.setTextAppearance(localContext, this.xF);
        }
        if (this.xS != 0) {
          this.xx.setTextColor(this.xS);
        }
      }
      if (!q(this.xx)) {
        a(this.xx, true);
      }
    }
    for (;;)
    {
      if (this.xx != null) {
        this.xx.setText(paramCharSequence);
      }
      this.xQ = paramCharSequence;
      AppMethodBeat.o(200243);
      return;
      if ((this.xx != null) && (q(this.xx)))
      {
        removeView(this.xx);
        this.xU.remove(this.xx);
      }
    }
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    AppMethodBeat.i(200265);
    this.xS = paramInt;
    if (this.xx != null) {
      this.xx.setTextColor(paramInt);
    }
    AppMethodBeat.o(200265);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(200200);
    setTitle(getContext().getText(paramInt));
    AppMethodBeat.o(200200);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200212);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.xw == null)
      {
        Context localContext = getContext();
        this.xw = new AppCompatTextView(localContext);
        this.xw.setSingleLine();
        this.xw.setEllipsize(TextUtils.TruncateAt.END);
        if (this.xE != 0) {
          this.xw.setTextAppearance(localContext, this.xE);
        }
        if (this.xR != 0) {
          this.xw.setTextColor(this.xR);
        }
      }
      if (!q(this.xw)) {
        a(this.xw, true);
      }
    }
    for (;;)
    {
      if (this.xw != null) {
        this.xw.setText(paramCharSequence);
      }
      this.xP = paramCharSequence;
      AppMethodBeat.o(200212);
      return;
      if ((this.xw != null) && (q(this.xw)))
      {
        removeView(this.xw);
        this.xU.remove(this.xw);
      }
    }
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    AppMethodBeat.i(200022);
    this.xL = paramInt;
    requestLayout();
    AppMethodBeat.o(200022);
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    AppMethodBeat.i(199995);
    this.xJ = paramInt;
    requestLayout();
    AppMethodBeat.o(199995);
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    AppMethodBeat.i(199946);
    this.xI = paramInt;
    requestLayout();
    AppMethodBeat.o(199946);
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    AppMethodBeat.i(199970);
    this.xK = paramInt;
    requestLayout();
    AppMethodBeat.o(199970);
  }
  
  public void setTitleTextColor(int paramInt)
  {
    AppMethodBeat.i(200254);
    this.xR = paramInt;
    if (this.xw != null) {
      this.xw.setTextColor(paramInt);
    }
    AppMethodBeat.o(200254);
  }
  
  public static class LayoutParams
    extends ActionBar.LayoutParams
  {
    int yf;
    
    public LayoutParams(int paramInt)
    {
      super(-2);
      this.yf = 0;
      this.fl = 8388627;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.yf = 0;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.yf = 0;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      AppMethodBeat.i(199586);
      this.yf = 0;
      this.leftMargin = paramMarginLayoutParams.leftMargin;
      this.topMargin = paramMarginLayoutParams.topMargin;
      this.rightMargin = paramMarginLayoutParams.rightMargin;
      this.bottomMargin = paramMarginLayoutParams.bottomMargin;
      AppMethodBeat.o(199586);
    }
    
    public LayoutParams(ActionBar.LayoutParams paramLayoutParams)
    {
      super();
      this.yf = 0;
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.yf = 0;
      this.yf = paramLayoutParams.yf;
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    int yg;
    boolean yh;
    
    static
    {
      AppMethodBeat.i(199828);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(199828);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(199802);
      this.yg = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.yh = bool;
        AppMethodBeat.o(199802);
        return;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(199845);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.yg);
      if (this.yh) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(199845);
        return;
      }
    }
  }
  
  final class a
    implements o
  {
    androidx.appcompat.view.menu.h jo;
    j ye;
    
    a() {}
    
    public final void J(boolean paramBoolean)
    {
      int k = 0;
      AppMethodBeat.i(200188);
      int j;
      int m;
      int i;
      if (this.ye != null)
      {
        j = k;
        if (this.jo != null)
        {
          m = this.jo.size();
          i = 0;
        }
      }
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (this.jo.getItem(i) == this.ye) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            d(this.ye);
          }
          AppMethodBeat.o(200188);
          return;
        }
        i += 1;
      }
    }
    
    public final void a(Context paramContext, androidx.appcompat.view.menu.h paramh)
    {
      AppMethodBeat.i(200177);
      if ((this.jo != null) && (this.ye != null)) {
        this.jo.g(this.ye);
      }
      this.jo = paramh;
      AppMethodBeat.o(200177);
    }
    
    public final void a(androidx.appcompat.view.menu.h paramh, boolean paramBoolean) {}
    
    public final boolean a(u paramu)
    {
      return false;
    }
    
    public final void b(o.a parama) {}
    
    public final boolean c(j paramj)
    {
      AppMethodBeat.i(200215);
      Toolbar.this.fu();
      Object localObject = Toolbar.this.xC.getParent();
      if (localObject != Toolbar.this)
      {
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(Toolbar.this.xC);
        }
        Toolbar.this.addView(Toolbar.this.xC);
      }
      Toolbar.this.xD = paramj.getActionView();
      this.ye = paramj;
      localObject = Toolbar.this.xD.getParent();
      if (localObject != Toolbar.this)
      {
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(Toolbar.this.xD);
        }
        localObject = Toolbar.fv();
        ((Toolbar.LayoutParams)localObject).fl = (0x800003 | Toolbar.this.xG & 0x70);
        ((Toolbar.LayoutParams)localObject).yf = 2;
        Toolbar.this.xD.setLayoutParams((ViewGroup.LayoutParams)localObject);
        Toolbar.this.addView(Toolbar.this.xD);
      }
      localObject = Toolbar.this;
      int i = ((Toolbar)localObject).getChildCount() - 1;
      while (i >= 0)
      {
        View localView = ((Toolbar)localObject).getChildAt(i);
        if ((((Toolbar.LayoutParams)localView.getLayoutParams()).yf != 2) && (localView != ((Toolbar)localObject).oE))
        {
          ((Toolbar)localObject).removeViewAt(i);
          ((Toolbar)localObject).xU.add(localView);
        }
        i -= 1;
      }
      Toolbar.this.requestLayout();
      paramj.Q(true);
      if ((Toolbar.this.xD instanceof c)) {
        ((c)Toolbar.this.xD).cu();
      }
      AppMethodBeat.o(200215);
      return true;
    }
    
    public final boolean cL()
    {
      return false;
    }
    
    public final boolean d(j paramj)
    {
      AppMethodBeat.i(200220);
      if ((Toolbar.this.xD instanceof c)) {
        ((c)Toolbar.this.xD).cv();
      }
      Toolbar.this.removeView(Toolbar.this.xD);
      Toolbar.this.removeView(Toolbar.this.xC);
      Toolbar.this.xD = null;
      Toolbar.this.fw();
      this.ye = null;
      Toolbar.this.requestLayout();
      paramj.Q(false);
      AppMethodBeat.o(200220);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.Toolbar
 * JD-Core Version:    0.7.0.1
 */