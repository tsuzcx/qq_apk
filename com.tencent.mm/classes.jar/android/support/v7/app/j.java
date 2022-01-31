package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.aa;
import android.support.v4.view.t;
import android.support.v4.view.x;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v7.a.a.a;
import android.support.v7.view.a;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.view.g;
import android.support.v7.view.menu.h.a;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ar;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class j
  extends ActionBar
  implements ActionBarOverlayLayout.a
{
  private static final Interpolator Qt;
  private static final Interpolator Qu;
  u PY;
  ar QA;
  private int QB = -1;
  private boolean QC;
  a QD;
  b QE;
  b.a QF;
  private boolean QG;
  private int QH = 0;
  boolean QI = true;
  boolean QJ;
  boolean QK;
  private boolean QL;
  private boolean QM = true;
  android.support.v7.view.h QN;
  private boolean QO;
  boolean QP;
  final y QQ = new z()
  {
    public final void aC(View paramAnonymousView)
    {
      if ((j.this.QI) && (j.this.Qz != null))
      {
        j.this.Qz.setTranslationY(0.0F);
        j.this.Qx.setTranslationY(0.0F);
      }
      j.this.Qx.setVisibility(8);
      j.this.Qx.setTransitioning(false);
      j.this.QN = null;
      paramAnonymousView = j.this;
      if (paramAnonymousView.QF != null)
      {
        paramAnonymousView.QF.a(paramAnonymousView.QE);
        paramAnonymousView.QE = null;
        paramAnonymousView.QF = null;
      }
      if (j.this.Qw != null) {
        t.ak(j.this.Qw);
      }
    }
  };
  final y QR = new z()
  {
    public final void aC(View paramAnonymousView)
    {
      j.this.QN = null;
      j.this.Qx.requestLayout();
    }
  };
  final aa QS = new aa()
  {
    public final void dJ()
    {
      ((View)j.this.Qx.getParent()).invalidate();
    }
  };
  private boolean Qc;
  private ArrayList<Object> Qd = new ArrayList();
  private Context Qv;
  ActionBarOverlayLayout Qw;
  ActionBarContainer Qx;
  ActionBarContextView Qy;
  View Qz;
  private ArrayList<Object> ld = new ArrayList();
  private Activity mActivity;
  Context mContext;
  private Dialog mDialog;
  
  static
  {
    if (!j.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      Qt = new AccelerateInterpolator();
      Qu = new DecelerateInterpolator();
      return;
    }
  }
  
  public j(Activity paramActivity, boolean paramBoolean)
  {
    this.mActivity = paramActivity;
    paramActivity = paramActivity.getWindow().getDecorView();
    aT(paramActivity);
    if (!paramBoolean) {
      this.Qz = paramActivity.findViewById(16908290);
    }
  }
  
  public j(Dialog paramDialog)
  {
    this.mDialog = paramDialog;
    aT(paramDialog.getWindow().getDecorView());
  }
  
  private void N(boolean paramBoolean)
  {
    boolean bool = true;
    this.QG = paramBoolean;
    int i;
    label45:
    label78:
    Object localObject;
    if (!this.QG)
    {
      this.PY.a(null);
      this.Qx.setTabContainer(this.QA);
      if (getNavigationMode() != 2) {
        break label155;
      }
      i = 1;
      if (this.QA != null)
      {
        if (i == 0) {
          break label160;
        }
        this.QA.setVisibility(0);
        if (this.Qw != null) {
          t.ak(this.Qw);
        }
      }
      localObject = this.PY;
      if ((this.QG) || (i == 0)) {
        break label172;
      }
      paramBoolean = true;
      label97:
      ((u)localObject).setCollapsible(paramBoolean);
      localObject = this.Qw;
      if ((this.QG) || (i == 0)) {
        break label177;
      }
    }
    label155:
    label160:
    label172:
    label177:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((ActionBarOverlayLayout)localObject).setHasNonEmbeddedTabs(paramBoolean);
      return;
      this.Qx.setTabContainer(null);
      this.PY.a(this.QA);
      break;
      i = 0;
      break label45;
      this.QA.setVisibility(8);
      break label78;
      paramBoolean = false;
      break label97;
    }
  }
  
  private void P(boolean paramBoolean)
  {
    if (c(this.QJ, this.QK, this.QL)) {
      if (!this.QM)
      {
        this.QM = true;
        Q(paramBoolean);
      }
    }
    while (!this.QM) {
      return;
    }
    this.QM = false;
    R(paramBoolean);
  }
  
  private void Q(boolean paramBoolean)
  {
    if (this.QN != null) {
      this.QN.cancel();
    }
    this.Qx.setVisibility(0);
    if ((this.QH == 0) && ((this.QO) || (paramBoolean)))
    {
      this.Qx.setTranslationY(0.0F);
      float f2 = -this.Qx.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp71_69 = localObject;
        tmp71_69[0] = 0;
        Object tmp75_71 = tmp71_69;
        tmp75_71[1] = 0;
        tmp75_71;
        this.Qx.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      this.Qx.setTranslationY(f1);
      Object localObject = new android.support.v7.view.h();
      x localx = t.ab(this.Qx).t(0.0F);
      localx.a(this.QS);
      ((android.support.v7.view.h)localObject).a(localx);
      if ((this.QI) && (this.Qz != null))
      {
        this.Qz.setTranslationY(f1);
        ((android.support.v7.view.h)localObject).a(t.ab(this.Qz).t(0.0F));
      }
      ((android.support.v7.view.h)localObject).d(Qu);
      ((android.support.v7.view.h)localObject).fF();
      ((android.support.v7.view.h)localObject).b(this.QR);
      this.QN = ((android.support.v7.view.h)localObject);
      ((android.support.v7.view.h)localObject).start();
    }
    for (;;)
    {
      if (this.Qw != null) {
        t.ak(this.Qw);
      }
      return;
      this.Qx.setAlpha(1.0F);
      this.Qx.setTranslationY(0.0F);
      if ((this.QI) && (this.Qz != null)) {
        this.Qz.setTranslationY(0.0F);
      }
      this.QR.aC(null);
    }
  }
  
  private void R(boolean paramBoolean)
  {
    if (this.QN != null) {
      this.QN.cancel();
    }
    if ((this.QH == 0) && ((this.QO) || (paramBoolean)))
    {
      this.Qx.setAlpha(1.0F);
      this.Qx.setTransitioning(true);
      android.support.v7.view.h localh = new android.support.v7.view.h();
      float f2 = -this.Qx.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp80_78 = localObject;
        tmp80_78[0] = 0;
        Object tmp84_80 = tmp80_78;
        tmp84_80[1] = 0;
        tmp84_80;
        this.Qx.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = t.ab(this.Qx).t(f1);
      ((x)localObject).a(this.QS);
      localh.a((x)localObject);
      if ((this.QI) && (this.Qz != null)) {
        localh.a(t.ab(this.Qz).t(f1));
      }
      localh.d(Qt);
      localh.fF();
      localh.b(this.QQ);
      this.QN = localh;
      localh.start();
      return;
    }
    this.QQ.aC(null);
  }
  
  private void aT(View paramView)
  {
    this.Qw = ((ActionBarOverlayLayout)paramView.findViewById(2131820955));
    if (this.Qw != null) {
      this.Qw.setActionBarVisibilityCallback(this);
    }
    this.PY = aU(paramView.findViewById(2131820957));
    this.Qy = ((ActionBarContextView)paramView.findViewById(2131820958));
    this.Qx = ((ActionBarContainer)paramView.findViewById(2131820956));
    if ((this.PY == null) || (this.Qy == null) || (this.Qx == null)) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
    }
    this.mContext = this.PY.getContext();
    if ((this.PY.getDisplayOptions() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.QC = true;
      }
      paramView = a.W(this.mContext);
      paramView.fA();
      N(paramView.fz());
      paramView = this.mContext.obtainStyledAttributes(null, a.a.ActionBar, 2130772139, 0);
      if (paramView.getBoolean(19, false)) {
        ew();
      }
      i = paramView.getDimensionPixelSize(26, 0);
      if (i != 0) {
        setElevation(i);
      }
      paramView.recycle();
      return;
    }
  }
  
  private static u aU(View paramView)
  {
    if ((paramView instanceof u)) {
      return (u)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    StringBuilder localStringBuilder = new StringBuilder("Can't make a decor toolbar out of ");
    if (paramView != null) {}
    for (paramView = paramView.getClass().getSimpleName();; paramView = "null") {
      throw new IllegalStateException(paramView);
    }
  }
  
  static boolean c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private void eX()
  {
    if (!this.QL)
    {
      this.QL = true;
      if (this.Qw != null) {
        this.Qw.setShowingForActionMode(true);
      }
      P(false);
    }
  }
  
  private void eZ()
  {
    if (this.QL)
    {
      this.QL = false;
      if (this.Qw != null) {
        this.Qw.setShowingForActionMode(false);
      }
      P(false);
    }
  }
  
  private int getNavigationMode()
  {
    return this.PY.getNavigationMode();
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.PY.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.QC = true;
    }
    this.PY.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void K(boolean paramBoolean)
  {
    if (!this.QC) {
      setDisplayHomeAsUpEnabled(paramBoolean);
    }
  }
  
  public final void L(boolean paramBoolean)
  {
    this.QO = paramBoolean;
    if ((!paramBoolean) && (this.QN != null)) {
      this.QN.cancel();
    }
  }
  
  public final void M(boolean paramBoolean)
  {
    if (paramBoolean == this.Qc) {}
    for (;;)
    {
      return;
      this.Qc = paramBoolean;
      int j = this.Qd.size();
      int i = 0;
      while (i < j)
      {
        this.Qd.get(i);
        i += 1;
      }
    }
  }
  
  public final void O(boolean paramBoolean)
  {
    this.QI = paramBoolean;
  }
  
  public final void S(boolean paramBoolean)
  {
    x localx1;
    x localx2;
    if (paramBoolean)
    {
      eX();
      if (!t.as(this.Qx)) {
        break label108;
      }
      if (!paramBoolean) {
        break label78;
      }
      localx1 = this.PY.c(4, 100L);
      localx2 = this.Qy.c(0, 200L);
    }
    for (;;)
    {
      android.support.v7.view.h localh = new android.support.v7.view.h();
      localh.a(localx1, localx2);
      localh.start();
      return;
      eZ();
      break;
      label78:
      localx2 = this.PY.c(0, 200L);
      localx1 = this.Qy.c(8, 100L);
    }
    label108:
    if (paramBoolean)
    {
      this.PY.setVisibility(4);
      this.Qy.setVisibility(0);
      return;
    }
    this.PY.setVisibility(0);
    this.Qy.setVisibility(8);
  }
  
  public final b a(b.a parama)
  {
    if (this.QD != null) {
      this.QD.finish();
    }
    this.Qw.setHideOnContentScrollEnabled(false);
    this.Qy.gu();
    parama = new a(this.Qy.getContext(), parama);
    if (parama.fc())
    {
      this.QD = parama;
      parama.invalidate();
      this.Qy.c(parama);
      S(true);
      this.Qy.sendAccessibilityEvent(32);
      return parama;
    }
    return null;
  }
  
  public final boolean collapseActionView()
  {
    if ((this.PY != null) && (this.PY.hasExpandedActionView()))
    {
      this.PY.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final void eY()
  {
    if (this.QK)
    {
      this.QK = false;
      P(true);
    }
  }
  
  public final void es()
  {
    this.PY.setIcon(2130840999);
  }
  
  public final void et()
  {
    setDisplayOptions(0, 2);
  }
  
  public final void eu()
  {
    setDisplayOptions(0, 8);
  }
  
  public final void ev()
  {
    setDisplayOptions(16, 16);
  }
  
  public final void ew()
  {
    if (!this.Qw.XU) {
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    this.QP = true;
    this.Qw.setHideOnContentScrollEnabled(true);
  }
  
  public final void fa()
  {
    if (!this.QK)
    {
      this.QK = true;
      P(true);
    }
  }
  
  public final void fb()
  {
    if (this.QN != null)
    {
      this.QN.cancel();
      this.QN = null;
    }
  }
  
  public final View getCustomView()
  {
    return this.PY.getCustomView();
  }
  
  public final int getDisplayOptions()
  {
    return this.PY.getDisplayOptions();
  }
  
  public final int getHeight()
  {
    return this.Qx.getHeight();
  }
  
  public final Context getThemedContext()
  {
    int i;
    if (this.Qv == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.mContext.getTheme().resolveAttribute(2130772142, localTypedValue, true);
      i = localTypedValue.resourceId;
      if (i == 0) {
        break label61;
      }
    }
    label61:
    for (this.Qv = new ContextThemeWrapper(this.mContext, i);; this.Qv = this.mContext) {
      return this.Qv;
    }
  }
  
  public final CharSequence getTitle()
  {
    return this.PY.getTitle();
  }
  
  public final void hide()
  {
    if (!this.QJ)
    {
      this.QJ = true;
      P(false);
    }
  }
  
  public final boolean isShowing()
  {
    int i = this.Qx.getHeight();
    return (this.QM) && ((i == 0) || (this.Qw.getActionBarHideOffset() < i));
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    N(a.W(this.mContext).fz());
  }
  
  public final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.QD == null) {}
    android.support.v7.view.menu.h localh;
    do
    {
      return false;
      localh = this.QD.eq;
    } while (localh == null);
    int i;
    if (paramKeyEvent != null)
    {
      i = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
        break label71;
      }
    }
    label71:
    for (boolean bool = true;; bool = false)
    {
      localh.setQwertyMode(bool);
      return localh.performShortcut(paramInt, paramKeyEvent, 0);
      i = -1;
      break;
    }
  }
  
  public final void onWindowVisibilityChanged(int paramInt)
  {
    this.QH = paramInt;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.Qx.setPrimaryBackground(paramDrawable);
  }
  
  public final void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.PY.hz(), false));
  }
  
  public final void setCustomView(View paramView)
  {
    this.PY.setCustomView(paramView);
  }
  
  public final void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      setDisplayOptions(i, 4);
      return;
    }
  }
  
  public final void setDisplayOptions(int paramInt)
  {
    if ((paramInt & 0x4) != 0) {
      this.QC = true;
    }
    this.PY.setDisplayOptions(paramInt);
  }
  
  public final void setElevation(float paramFloat)
  {
    t.i(this.Qx, paramFloat);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    this.PY.setNavigationContentDescription(paramInt);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.PY.setLogo(paramDrawable);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    this.PY.setWindowTitle(paramCharSequence);
  }
  
  public final void show()
  {
    if (this.QJ)
    {
      this.QJ = false;
      P(false);
    }
  }
  
  public final class a
    extends b
    implements h.a
  {
    private final Context QU;
    private b.a QV;
    private WeakReference<View> QW;
    final android.support.v7.view.menu.h eq;
    
    public a(Context paramContext, b.a parama)
    {
      this.QU = paramContext;
      this.QV = parama;
      this$1 = new android.support.v7.view.menu.h(paramContext);
      j.this.Ws = 1;
      this.eq = j.this;
      this.eq.a(this);
    }
    
    public final boolean a(android.support.v7.view.menu.h paramh, MenuItem paramMenuItem)
    {
      if (this.QV != null) {
        return this.QV.a(this, paramMenuItem);
      }
      return false;
    }
    
    public final void b(android.support.v7.view.menu.h paramh)
    {
      if (this.QV == null) {
        return;
      }
      invalidate();
      j.this.Qy.showOverflowMenu();
    }
    
    public final boolean fc()
    {
      this.eq.fX();
      try
      {
        boolean bool = this.QV.a(this, this.eq);
        return bool;
      }
      finally
      {
        this.eq.fY();
      }
    }
    
    public final void finish()
    {
      if (j.this.QD != this) {
        return;
      }
      if (!j.c(j.this.QJ, j.this.QK, false))
      {
        j.this.QE = this;
        j.this.QF = this.QV;
      }
      for (;;)
      {
        this.QV = null;
        j.this.S(false);
        j.this.Qy.gt();
        j.this.PY.hz().sendAccessibilityEvent(32);
        j.this.Qw.setHideOnContentScrollEnabled(j.this.QP);
        j.this.QD = null;
        return;
        this.QV.a(this);
      }
    }
    
    public final View getCustomView()
    {
      if (this.QW != null) {
        return (View)this.QW.get();
      }
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.eq;
    }
    
    public final MenuInflater getMenuInflater()
    {
      return new g(this.QU);
    }
    
    public final CharSequence getSubtitle()
    {
      return j.this.Qy.getSubtitle();
    }
    
    public final CharSequence getTitle()
    {
      return j.this.Qy.getTitle();
    }
    
    public final void invalidate()
    {
      if (j.this.QD != this) {
        return;
      }
      this.eq.fX();
      try
      {
        this.QV.b(this, this.eq);
        return;
      }
      finally
      {
        this.eq.fY();
      }
    }
    
    public final boolean isTitleOptional()
    {
      return j.this.Qy.XK;
    }
    
    public final void setCustomView(View paramView)
    {
      j.this.Qy.setCustomView(paramView);
      this.QW = new WeakReference(paramView);
    }
    
    public final void setSubtitle(int paramInt)
    {
      setSubtitle(j.this.mContext.getResources().getString(paramInt));
    }
    
    public final void setSubtitle(CharSequence paramCharSequence)
    {
      j.this.Qy.setSubtitle(paramCharSequence);
    }
    
    public final void setTitle(int paramInt)
    {
      setTitle(j.this.mContext.getResources().getString(paramInt));
    }
    
    public final void setTitle(CharSequence paramCharSequence)
    {
      j.this.Qy.setTitle(paramCharSequence);
    }
    
    public final void setTitleOptionalHint(boolean paramBoolean)
    {
      super.setTitleOptionalHint(paramBoolean);
      j.this.Qy.setTitleOptional(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.j
 * JD-Core Version:    0.7.0.1
 */