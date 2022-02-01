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
  private static final Interpolator Xs;
  private static final Interpolator Xt;
  private ArrayList<Object> Bq = new ArrayList();
  u WX;
  private boolean XA;
  a XB;
  b XC;
  b.a XD;
  private boolean XE;
  private int XF = 0;
  boolean XG = true;
  boolean XH;
  boolean XI;
  private boolean XJ;
  private boolean XK = true;
  android.support.v7.view.h XL;
  private boolean XM;
  boolean XN;
  final y XO = new z()
  {
    public final void aI(View paramAnonymousView)
    {
      if ((j.this.XG) && (j.this.mContentView != null))
      {
        j.this.mContentView.setTranslationY(0.0F);
        j.this.Xw.setTranslationY(0.0F);
      }
      j.this.Xw.setVisibility(8);
      j.this.Xw.setTransitioning(false);
      j.this.XL = null;
      paramAnonymousView = j.this;
      if (paramAnonymousView.XD != null)
      {
        paramAnonymousView.XD.a(paramAnonymousView.XC);
        paramAnonymousView.XC = null;
        paramAnonymousView.XD = null;
      }
      if (j.this.Xv != null) {
        t.ap(j.this.Xv);
      }
    }
  };
  final y XP = new z()
  {
    public final void aI(View paramAnonymousView)
    {
      j.this.XL = null;
      j.this.Xw.requestLayout();
    }
  };
  final aa XQ = new aa()
  {
    public final void fb()
    {
      ((View)j.this.Xw.getParent()).invalidate();
    }
  };
  private boolean Xb;
  private ArrayList<Object> Xc = new ArrayList();
  private Context Xu;
  ActionBarOverlayLayout Xv;
  ActionBarContainer Xw;
  ActionBarContextView Xx;
  ar Xy;
  private int Xz = -1;
  private Activity mActivity;
  View mContentView;
  Context mContext;
  private Dialog mDialog;
  
  static
  {
    if (!j.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      Xs = new AccelerateInterpolator();
      Xt = new DecelerateInterpolator();
      return;
    }
  }
  
  public j(Activity paramActivity, boolean paramBoolean)
  {
    this.mActivity = paramActivity;
    paramActivity = paramActivity.getWindow().getDecorView();
    aZ(paramActivity);
    if (!paramBoolean) {
      this.mContentView = paramActivity.findViewById(16908290);
    }
  }
  
  public j(Dialog paramDialog)
  {
    this.mDialog = paramDialog;
    aZ(paramDialog.getWindow().getDecorView());
  }
  
  private void T(boolean paramBoolean)
  {
    boolean bool = true;
    this.XE = paramBoolean;
    int i;
    label45:
    label78:
    Object localObject;
    if (!this.XE)
    {
      this.WX.a(null);
      this.Xw.setTabContainer(this.Xy);
      if (getNavigationMode() != 2) {
        break label155;
      }
      i = 1;
      if (this.Xy != null)
      {
        if (i == 0) {
          break label160;
        }
        this.Xy.setVisibility(0);
        if (this.Xv != null) {
          t.ap(this.Xv);
        }
      }
      localObject = this.WX;
      if ((this.XE) || (i == 0)) {
        break label172;
      }
      paramBoolean = true;
      label97:
      ((u)localObject).setCollapsible(paramBoolean);
      localObject = this.Xv;
      if ((this.XE) || (i == 0)) {
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
      this.Xw.setTabContainer(null);
      this.WX.a(this.Xy);
      break;
      i = 0;
      break label45;
      this.Xy.setVisibility(8);
      break label78;
      paramBoolean = false;
      break label97;
    }
  }
  
  private void V(boolean paramBoolean)
  {
    if (c(this.XH, this.XI, this.XJ)) {
      if (!this.XK)
      {
        this.XK = true;
        W(paramBoolean);
      }
    }
    while (!this.XK) {
      return;
    }
    this.XK = false;
    X(paramBoolean);
  }
  
  private void W(boolean paramBoolean)
  {
    if (this.XL != null) {
      this.XL.cancel();
    }
    this.Xw.setVisibility(0);
    if ((this.XF == 0) && ((this.XM) || (paramBoolean)))
    {
      this.Xw.setTranslationY(0.0F);
      float f2 = -this.Xw.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp71_69 = localObject;
        tmp71_69[0] = 0;
        Object tmp75_71 = tmp71_69;
        tmp75_71[1] = 0;
        tmp75_71;
        this.Xw.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      this.Xw.setTranslationY(f1);
      Object localObject = new android.support.v7.view.h();
      x localx = t.ag(this.Xw).x(0.0F);
      localx.a(this.XQ);
      ((android.support.v7.view.h)localObject).a(localx);
      if ((this.XG) && (this.mContentView != null))
      {
        this.mContentView.setTranslationY(f1);
        ((android.support.v7.view.h)localObject).a(t.ag(this.mContentView).x(0.0F));
      }
      ((android.support.v7.view.h)localObject).b(Xt);
      ((android.support.v7.view.h)localObject).hb();
      ((android.support.v7.view.h)localObject).b(this.XP);
      this.XL = ((android.support.v7.view.h)localObject);
      ((android.support.v7.view.h)localObject).start();
    }
    for (;;)
    {
      if (this.Xv != null) {
        t.ap(this.Xv);
      }
      return;
      this.Xw.setAlpha(1.0F);
      this.Xw.setTranslationY(0.0F);
      if ((this.XG) && (this.mContentView != null)) {
        this.mContentView.setTranslationY(0.0F);
      }
      this.XP.aI(null);
    }
  }
  
  private void X(boolean paramBoolean)
  {
    if (this.XL != null) {
      this.XL.cancel();
    }
    if ((this.XF == 0) && ((this.XM) || (paramBoolean)))
    {
      this.Xw.setAlpha(1.0F);
      this.Xw.setTransitioning(true);
      android.support.v7.view.h localh = new android.support.v7.view.h();
      float f2 = -this.Xw.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp80_78 = localObject;
        tmp80_78[0] = 0;
        Object tmp84_80 = tmp80_78;
        tmp84_80[1] = 0;
        tmp84_80;
        this.Xw.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = t.ag(this.Xw).x(f1);
      ((x)localObject).a(this.XQ);
      localh.a((x)localObject);
      if ((this.XG) && (this.mContentView != null)) {
        localh.a(t.ag(this.mContentView).x(f1));
      }
      localh.b(Xs);
      localh.hb();
      localh.b(this.XO);
      this.XL = localh;
      localh.start();
      return;
    }
    this.XO.aI(null);
  }
  
  private void aZ(View paramView)
  {
    this.Xv = ((ActionBarOverlayLayout)paramView.findViewById(2131298945));
    if (this.Xv != null) {
      this.Xv.setActionBarVisibilityCallback(this);
    }
    this.WX = ba(paramView.findViewById(2131296343));
    this.Xx = ((ActionBarContextView)paramView.findViewById(2131296357));
    this.Xw = ((ActionBarContainer)paramView.findViewById(2131296345));
    if ((this.WX == null) || (this.Xx == null) || (this.Xw == null)) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
    }
    this.mContext = this.WX.getContext();
    if ((this.WX.getDisplayOptions() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.XA = true;
      }
      paramView = a.Y(this.mContext);
      paramView.gW();
      T(paramView.gV());
      paramView = this.mContext.obtainStyledAttributes(null, a.a.ActionBar, 2130968602, 0);
      if (paramView.getBoolean(14, false)) {
        fO();
      }
      i = paramView.getDimensionPixelSize(12, 0);
      if (i != 0) {
        setElevation(i);
      }
      paramView.recycle();
      return;
    }
  }
  
  private static u ba(View paramView)
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
  
  private int getNavigationMode()
  {
    return this.WX.getNavigationMode();
  }
  
  private void gq()
  {
    if (!this.XJ)
    {
      this.XJ = true;
      if (this.Xv != null) {
        this.Xv.setShowingForActionMode(true);
      }
      V(false);
    }
  }
  
  private void gs()
  {
    if (this.XJ)
    {
      this.XJ = false;
      if (this.Xv != null) {
        this.Xv.setShowingForActionMode(false);
      }
      V(false);
    }
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.WX.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.XA = true;
    }
    this.WX.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void Q(boolean paramBoolean)
  {
    if (!this.XA) {
      setDisplayHomeAsUpEnabled(paramBoolean);
    }
  }
  
  public final void R(boolean paramBoolean)
  {
    this.XM = paramBoolean;
    if ((!paramBoolean) && (this.XL != null)) {
      this.XL.cancel();
    }
  }
  
  public final void S(boolean paramBoolean)
  {
    if (paramBoolean == this.Xb) {}
    for (;;)
    {
      return;
      this.Xb = paramBoolean;
      int j = this.Xc.size();
      int i = 0;
      while (i < j)
      {
        this.Xc.get(i);
        i += 1;
      }
    }
  }
  
  public final void U(boolean paramBoolean)
  {
    this.XG = paramBoolean;
  }
  
  public final void Y(boolean paramBoolean)
  {
    x localx1;
    x localx2;
    if (paramBoolean)
    {
      gq();
      if (!t.ay(this.Xw)) {
        break label108;
      }
      if (!paramBoolean) {
        break label78;
      }
      localx1 = this.WX.c(4, 100L);
      localx2 = this.Xx.c(0, 200L);
    }
    for (;;)
    {
      android.support.v7.view.h localh = new android.support.v7.view.h();
      localh.a(localx1, localx2);
      localh.start();
      return;
      gs();
      break;
      label78:
      localx2 = this.WX.c(0, 200L);
      localx1 = this.Xx.c(8, 100L);
    }
    label108:
    if (paramBoolean)
    {
      this.WX.setVisibility(4);
      this.Xx.setVisibility(0);
      return;
    }
    this.WX.setVisibility(0);
    this.Xx.setVisibility(8);
  }
  
  public final b a(b.a parama)
  {
    if (this.XB != null) {
      this.XB.finish();
    }
    this.Xv.setHideOnContentScrollEnabled(false);
    this.Xx.hP();
    parama = new a(this.Xx.getContext(), parama);
    if (parama.gv())
    {
      this.XB = parama;
      parama.invalidate();
      this.Xx.c(parama);
      Y(true);
      this.Xx.sendAccessibilityEvent(32);
      return parama;
    }
    return null;
  }
  
  public final boolean collapseActionView()
  {
    if ((this.WX != null) && (this.WX.hasExpandedActionView()))
    {
      this.WX.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final void fK()
  {
    this.WX.setIcon(2131234429);
  }
  
  public final void fL()
  {
    setDisplayOptions(0, 2);
  }
  
  public final void fM()
  {
    setDisplayOptions(0, 8);
  }
  
  public final void fN()
  {
    setDisplayOptions(16, 16);
  }
  
  public final void fO()
  {
    if (!this.Xv.afa) {
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    this.XN = true;
    this.Xv.setHideOnContentScrollEnabled(true);
  }
  
  public final View getCustomView()
  {
    return this.WX.getCustomView();
  }
  
  public final int getDisplayOptions()
  {
    return this.WX.getDisplayOptions();
  }
  
  public final int getHeight()
  {
    return this.Xw.getHeight();
  }
  
  public final Context getThemedContext()
  {
    int i;
    if (this.Xu == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.mContext.getTheme().resolveAttribute(2130968607, localTypedValue, true);
      i = localTypedValue.resourceId;
      if (i == 0) {
        break label61;
      }
    }
    label61:
    for (this.Xu = new ContextThemeWrapper(this.mContext, i);; this.Xu = this.mContext) {
      return this.Xu;
    }
  }
  
  public final CharSequence getTitle()
  {
    return this.WX.getTitle();
  }
  
  public final void gr()
  {
    if (this.XI)
    {
      this.XI = false;
      V(true);
    }
  }
  
  public final void gt()
  {
    if (!this.XI)
    {
      this.XI = true;
      V(true);
    }
  }
  
  public final void gu()
  {
    if (this.XL != null)
    {
      this.XL.cancel();
      this.XL = null;
    }
  }
  
  public final void hide()
  {
    if (!this.XH)
    {
      this.XH = true;
      V(false);
    }
  }
  
  public final boolean isShowing()
  {
    int i = this.Xw.getHeight();
    return (this.XK) && ((i == 0) || (this.Xv.getActionBarHideOffset() < i));
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    T(a.Y(this.mContext).gV());
  }
  
  public final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.XB == null) {}
    android.support.v7.view.menu.h localh;
    do
    {
      return false;
      localh = this.XB.XT;
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
    this.XF = paramInt;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.Xw.setPrimaryBackground(paramDrawable);
  }
  
  public final void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.WX.iV(), false));
  }
  
  public final void setCustomView(View paramView)
  {
    this.WX.setCustomView(paramView);
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
      this.XA = true;
    }
    this.WX.setDisplayOptions(paramInt);
  }
  
  public final void setElevation(float paramFloat)
  {
    t.k(this.Xw, paramFloat);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    this.WX.setNavigationContentDescription(paramInt);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.WX.setLogo(paramDrawable);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    this.WX.setWindowTitle(paramCharSequence);
  }
  
  public final void show()
  {
    if (this.XH)
    {
      this.XH = false;
      V(false);
    }
  }
  
  public final class a
    extends b
    implements h.a
  {
    private final Context XS;
    final android.support.v7.view.menu.h XT;
    private b.a XU;
    private WeakReference<View> XV;
    
    public a(Context paramContext, b.a parama)
    {
      this.XS = paramContext;
      this.XU = parama;
      this$1 = new android.support.v7.view.menu.h(paramContext);
      j.this.ady = 1;
      this.XT = j.this;
      this.XT.a(this);
    }
    
    public final boolean a(android.support.v7.view.menu.h paramh, MenuItem paramMenuItem)
    {
      if (this.XU != null) {
        return this.XU.a(this, paramMenuItem);
      }
      return false;
    }
    
    public final void b(android.support.v7.view.menu.h paramh)
    {
      if (this.XU == null) {
        return;
      }
      invalidate();
      j.this.Xx.showOverflowMenu();
    }
    
    public final void finish()
    {
      if (j.this.XB != this) {
        return;
      }
      if (!j.c(j.this.XH, j.this.XI, false))
      {
        j.this.XC = this;
        j.this.XD = this.XU;
      }
      for (;;)
      {
        this.XU = null;
        j.this.Y(false);
        j.this.Xx.hO();
        j.this.WX.iV().sendAccessibilityEvent(32);
        j.this.Xv.setHideOnContentScrollEnabled(j.this.XN);
        j.this.XB = null;
        return;
        this.XU.a(this);
      }
    }
    
    public final View getCustomView()
    {
      if (this.XV != null) {
        return (View)this.XV.get();
      }
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.XT;
    }
    
    public final MenuInflater getMenuInflater()
    {
      return new g(this.XS);
    }
    
    public final CharSequence getSubtitle()
    {
      return j.this.Xx.getSubtitle();
    }
    
    public final CharSequence getTitle()
    {
      return j.this.Xx.getTitle();
    }
    
    public final boolean gv()
    {
      this.XT.ht();
      try
      {
        boolean bool = this.XU.a(this, this.XT);
        return bool;
      }
      finally
      {
        this.XT.hu();
      }
    }
    
    public final void invalidate()
    {
      if (j.this.XB != this) {
        return;
      }
      this.XT.ht();
      try
      {
        this.XU.b(this, this.XT);
        return;
      }
      finally
      {
        this.XT.hu();
      }
    }
    
    public final boolean isTitleOptional()
    {
      return j.this.Xx.aeQ;
    }
    
    public final void setCustomView(View paramView)
    {
      j.this.Xx.setCustomView(paramView);
      this.XV = new WeakReference(paramView);
    }
    
    public final void setSubtitle(int paramInt)
    {
      setSubtitle(j.this.mContext.getResources().getString(paramInt));
    }
    
    public final void setSubtitle(CharSequence paramCharSequence)
    {
      j.this.Xx.setSubtitle(paramCharSequence);
    }
    
    public final void setTitle(int paramInt)
    {
      setTitle(j.this.mContext.getResources().getString(paramInt));
    }
    
    public final void setTitle(CharSequence paramCharSequence)
    {
      j.this.Xx.setTitle(paramCharSequence);
    }
    
    public final void setTitleOptionalHint(boolean paramBoolean)
    {
      super.setTitleOptionalHint(paramBoolean);
      j.this.Xx.setTitleOptional(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.j
 * JD-Core Version:    0.7.0.1
 */