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
  private static final Interpolator Yn;
  private static final Interpolator Yo;
  private ArrayList<Object> Co = new ArrayList();
  u XS;
  private boolean XW;
  private ArrayList<Object> XX = new ArrayList();
  private int YA = 0;
  boolean YB = true;
  boolean YC;
  boolean YD;
  private boolean YE;
  private boolean YF = true;
  android.support.v7.view.h YG;
  private boolean YH;
  boolean YI;
  final y YJ = new z()
  {
    public final void aI(View paramAnonymousView)
    {
      if ((j.this.YB) && (j.this.mContentView != null))
      {
        j.this.mContentView.setTranslationY(0.0F);
        j.this.Yr.setTranslationY(0.0F);
      }
      j.this.Yr.setVisibility(8);
      j.this.Yr.setTransitioning(false);
      j.this.YG = null;
      paramAnonymousView = j.this;
      if (paramAnonymousView.Yy != null)
      {
        paramAnonymousView.Yy.a(paramAnonymousView.Yx);
        paramAnonymousView.Yx = null;
        paramAnonymousView.Yy = null;
      }
      if (j.this.Yq != null) {
        t.ap(j.this.Yq);
      }
    }
  };
  final y YK = new z()
  {
    public final void aI(View paramAnonymousView)
    {
      j.this.YG = null;
      j.this.Yr.requestLayout();
    }
  };
  final aa YL = new aa()
  {
    public final void fj()
    {
      ((View)j.this.Yr.getParent()).invalidate();
    }
  };
  private Context Yp;
  ActionBarOverlayLayout Yq;
  ActionBarContainer Yr;
  ActionBarContextView Ys;
  ar Yt;
  private int Yu = -1;
  private boolean Yv;
  a Yw;
  b Yx;
  b.a Yy;
  private boolean Yz;
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
      Yn = new AccelerateInterpolator();
      Yo = new DecelerateInterpolator();
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
    this.Yz = paramBoolean;
    int i;
    label45:
    label78:
    Object localObject;
    if (!this.Yz)
    {
      this.XS.a(null);
      this.Yr.setTabContainer(this.Yt);
      if (getNavigationMode() != 2) {
        break label155;
      }
      i = 1;
      if (this.Yt != null)
      {
        if (i == 0) {
          break label160;
        }
        this.Yt.setVisibility(0);
        if (this.Yq != null) {
          t.ap(this.Yq);
        }
      }
      localObject = this.XS;
      if ((this.Yz) || (i == 0)) {
        break label172;
      }
      paramBoolean = true;
      label97:
      ((u)localObject).setCollapsible(paramBoolean);
      localObject = this.Yq;
      if ((this.Yz) || (i == 0)) {
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
      this.Yr.setTabContainer(null);
      this.XS.a(this.Yt);
      break;
      i = 0;
      break label45;
      this.Yt.setVisibility(8);
      break label78;
      paramBoolean = false;
      break label97;
    }
  }
  
  private void V(boolean paramBoolean)
  {
    if (c(this.YC, this.YD, this.YE)) {
      if (!this.YF)
      {
        this.YF = true;
        W(paramBoolean);
      }
    }
    while (!this.YF) {
      return;
    }
    this.YF = false;
    X(paramBoolean);
  }
  
  private void W(boolean paramBoolean)
  {
    if (this.YG != null) {
      this.YG.cancel();
    }
    this.Yr.setVisibility(0);
    if ((this.YA == 0) && ((this.YH) || (paramBoolean)))
    {
      this.Yr.setTranslationY(0.0F);
      float f2 = -this.Yr.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp71_69 = localObject;
        tmp71_69[0] = 0;
        Object tmp75_71 = tmp71_69;
        tmp75_71[1] = 0;
        tmp75_71;
        this.Yr.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      this.Yr.setTranslationY(f1);
      Object localObject = new android.support.v7.view.h();
      x localx = t.ag(this.Yr).B(0.0F);
      localx.a(this.YL);
      ((android.support.v7.view.h)localObject).a(localx);
      if ((this.YB) && (this.mContentView != null))
      {
        this.mContentView.setTranslationY(f1);
        ((android.support.v7.view.h)localObject).a(t.ag(this.mContentView).B(0.0F));
      }
      ((android.support.v7.view.h)localObject).b(Yo);
      ((android.support.v7.view.h)localObject).hj();
      ((android.support.v7.view.h)localObject).b(this.YK);
      this.YG = ((android.support.v7.view.h)localObject);
      ((android.support.v7.view.h)localObject).start();
    }
    for (;;)
    {
      if (this.Yq != null) {
        t.ap(this.Yq);
      }
      return;
      this.Yr.setAlpha(1.0F);
      this.Yr.setTranslationY(0.0F);
      if ((this.YB) && (this.mContentView != null)) {
        this.mContentView.setTranslationY(0.0F);
      }
      this.YK.aI(null);
    }
  }
  
  private void X(boolean paramBoolean)
  {
    if (this.YG != null) {
      this.YG.cancel();
    }
    if ((this.YA == 0) && ((this.YH) || (paramBoolean)))
    {
      this.Yr.setAlpha(1.0F);
      this.Yr.setTransitioning(true);
      android.support.v7.view.h localh = new android.support.v7.view.h();
      float f2 = -this.Yr.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp80_78 = localObject;
        tmp80_78[0] = 0;
        Object tmp84_80 = tmp80_78;
        tmp84_80[1] = 0;
        tmp84_80;
        this.Yr.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = t.ag(this.Yr).B(f1);
      ((x)localObject).a(this.YL);
      localh.a((x)localObject);
      if ((this.YB) && (this.mContentView != null)) {
        localh.a(t.ag(this.mContentView).B(f1));
      }
      localh.b(Yn);
      localh.hj();
      localh.b(this.YJ);
      this.YG = localh;
      localh.start();
      return;
    }
    this.YJ.aI(null);
  }
  
  private void aZ(View paramView)
  {
    this.Yq = ((ActionBarOverlayLayout)paramView.findViewById(2131298945));
    if (this.Yq != null) {
      this.Yq.setActionBarVisibilityCallback(this);
    }
    this.XS = ba(paramView.findViewById(2131296343));
    this.Ys = ((ActionBarContextView)paramView.findViewById(2131296357));
    this.Yr = ((ActionBarContainer)paramView.findViewById(2131296345));
    if ((this.XS == null) || (this.Ys == null) || (this.Yr == null)) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
    }
    this.mContext = this.XS.getContext();
    if ((this.XS.getDisplayOptions() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.Yv = true;
      }
      paramView = a.Z(this.mContext);
      paramView.he();
      T(paramView.hd());
      paramView = this.mContext.obtainStyledAttributes(null, a.a.ActionBar, 2130968602, 0);
      if (paramView.getBoolean(14, false)) {
        fW();
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
  
  private void gA()
  {
    if (this.YE)
    {
      this.YE = false;
      if (this.Yq != null) {
        this.Yq.setShowingForActionMode(false);
      }
      V(false);
    }
  }
  
  private int getNavigationMode()
  {
    return this.XS.getNavigationMode();
  }
  
  private void gy()
  {
    if (!this.YE)
    {
      this.YE = true;
      if (this.Yq != null) {
        this.Yq.setShowingForActionMode(true);
      }
      V(false);
    }
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.XS.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.Yv = true;
    }
    this.XS.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void Q(boolean paramBoolean)
  {
    if (!this.Yv) {
      setDisplayHomeAsUpEnabled(paramBoolean);
    }
  }
  
  public final void R(boolean paramBoolean)
  {
    this.YH = paramBoolean;
    if ((!paramBoolean) && (this.YG != null)) {
      this.YG.cancel();
    }
  }
  
  public final void S(boolean paramBoolean)
  {
    if (paramBoolean == this.XW) {}
    for (;;)
    {
      return;
      this.XW = paramBoolean;
      int j = this.XX.size();
      int i = 0;
      while (i < j)
      {
        this.XX.get(i);
        i += 1;
      }
    }
  }
  
  public final void U(boolean paramBoolean)
  {
    this.YB = paramBoolean;
  }
  
  public final void Y(boolean paramBoolean)
  {
    x localx1;
    x localx2;
    if (paramBoolean)
    {
      gy();
      if (!t.ay(this.Yr)) {
        break label108;
      }
      if (!paramBoolean) {
        break label78;
      }
      localx1 = this.XS.c(4, 100L);
      localx2 = this.Ys.c(0, 200L);
    }
    for (;;)
    {
      android.support.v7.view.h localh = new android.support.v7.view.h();
      localh.a(localx1, localx2);
      localh.start();
      return;
      gA();
      break;
      label78:
      localx2 = this.XS.c(0, 200L);
      localx1 = this.Ys.c(8, 100L);
    }
    label108:
    if (paramBoolean)
    {
      this.XS.setVisibility(4);
      this.Ys.setVisibility(0);
      return;
    }
    this.XS.setVisibility(0);
    this.Ys.setVisibility(8);
  }
  
  public final b a(b.a parama)
  {
    if (this.Yw != null) {
      this.Yw.finish();
    }
    this.Yq.setHideOnContentScrollEnabled(false);
    this.Ys.hX();
    parama = new a(this.Ys.getContext(), parama);
    if (parama.gD())
    {
      this.Yw = parama;
      parama.invalidate();
      this.Ys.c(parama);
      Y(true);
      this.Ys.sendAccessibilityEvent(32);
      return parama;
    }
    return null;
  }
  
  public final boolean collapseActionView()
  {
    if ((this.XS != null) && (this.XS.hasExpandedActionView()))
    {
      this.XS.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final void fS()
  {
    this.XS.setIcon(2131234429);
  }
  
  public final void fT()
  {
    setDisplayOptions(0, 2);
  }
  
  public final void fU()
  {
    setDisplayOptions(0, 8);
  }
  
  public final void fV()
  {
    setDisplayOptions(16, 16);
  }
  
  public final void fW()
  {
    if (!this.Yq.afU) {
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    this.YI = true;
    this.Yq.setHideOnContentScrollEnabled(true);
  }
  
  public final void gB()
  {
    if (!this.YD)
    {
      this.YD = true;
      V(true);
    }
  }
  
  public final void gC()
  {
    if (this.YG != null)
    {
      this.YG.cancel();
      this.YG = null;
    }
  }
  
  public final View getCustomView()
  {
    return this.XS.getCustomView();
  }
  
  public final int getDisplayOptions()
  {
    return this.XS.getDisplayOptions();
  }
  
  public final int getHeight()
  {
    return this.Yr.getHeight();
  }
  
  public final Context getThemedContext()
  {
    int i;
    if (this.Yp == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.mContext.getTheme().resolveAttribute(2130968607, localTypedValue, true);
      i = localTypedValue.resourceId;
      if (i == 0) {
        break label61;
      }
    }
    label61:
    for (this.Yp = new ContextThemeWrapper(this.mContext, i);; this.Yp = this.mContext) {
      return this.Yp;
    }
  }
  
  public final CharSequence getTitle()
  {
    return this.XS.getTitle();
  }
  
  public final void gz()
  {
    if (this.YD)
    {
      this.YD = false;
      V(true);
    }
  }
  
  public final void hide()
  {
    if (!this.YC)
    {
      this.YC = true;
      V(false);
    }
  }
  
  public final boolean isShowing()
  {
    int i = this.Yr.getHeight();
    return (this.YF) && ((i == 0) || (this.Yq.getActionBarHideOffset() < i));
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    T(a.Z(this.mContext).hd());
  }
  
  public final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.Yw == null) {}
    android.support.v7.view.menu.h localh;
    do
    {
      return false;
      localh = this.Yw.YO;
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
    this.YA = paramInt;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.Yr.setPrimaryBackground(paramDrawable);
  }
  
  public final void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.XS.jd(), false));
  }
  
  public final void setCustomView(View paramView)
  {
    this.XS.setCustomView(paramView);
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
      this.Yv = true;
    }
    this.XS.setDisplayOptions(paramInt);
  }
  
  public final void setElevation(float paramFloat)
  {
    t.k(this.Yr, paramFloat);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    this.XS.setNavigationContentDescription(paramInt);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.XS.setLogo(paramDrawable);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    this.XS.setWindowTitle(paramCharSequence);
  }
  
  public final void show()
  {
    if (this.YC)
    {
      this.YC = false;
      V(false);
    }
  }
  
  public final class a
    extends b
    implements h.a
  {
    private final Context YN;
    final android.support.v7.view.menu.h YO;
    private b.a YP;
    private WeakReference<View> YQ;
    
    public a(Context paramContext, b.a parama)
    {
      this.YN = paramContext;
      this.YP = parama;
      this$1 = new android.support.v7.view.menu.h(paramContext);
      j.this.aes = 1;
      this.YO = j.this;
      this.YO.a(this);
    }
    
    public final boolean a(android.support.v7.view.menu.h paramh, MenuItem paramMenuItem)
    {
      if (this.YP != null) {
        return this.YP.a(this, paramMenuItem);
      }
      return false;
    }
    
    public final void b(android.support.v7.view.menu.h paramh)
    {
      if (this.YP == null) {
        return;
      }
      invalidate();
      j.this.Ys.showOverflowMenu();
    }
    
    public final void finish()
    {
      if (j.this.Yw != this) {
        return;
      }
      if (!j.c(j.this.YC, j.this.YD, false))
      {
        j.this.Yx = this;
        j.this.Yy = this.YP;
      }
      for (;;)
      {
        this.YP = null;
        j.this.Y(false);
        j.this.Ys.hW();
        j.this.XS.jd().sendAccessibilityEvent(32);
        j.this.Yq.setHideOnContentScrollEnabled(j.this.YI);
        j.this.Yw = null;
        return;
        this.YP.a(this);
      }
    }
    
    public final boolean gD()
    {
      this.YO.hB();
      try
      {
        boolean bool = this.YP.a(this, this.YO);
        return bool;
      }
      finally
      {
        this.YO.hC();
      }
    }
    
    public final View getCustomView()
    {
      if (this.YQ != null) {
        return (View)this.YQ.get();
      }
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.YO;
    }
    
    public final MenuInflater getMenuInflater()
    {
      return new g(this.YN);
    }
    
    public final CharSequence getSubtitle()
    {
      return j.this.Ys.getSubtitle();
    }
    
    public final CharSequence getTitle()
    {
      return j.this.Ys.getTitle();
    }
    
    public final void invalidate()
    {
      if (j.this.Yw != this) {
        return;
      }
      this.YO.hB();
      try
      {
        this.YP.b(this, this.YO);
        return;
      }
      finally
      {
        this.YO.hC();
      }
    }
    
    public final boolean isTitleOptional()
    {
      return j.this.Ys.afK;
    }
    
    public final void setCustomView(View paramView)
    {
      j.this.Ys.setCustomView(paramView);
      this.YQ = new WeakReference(paramView);
    }
    
    public final void setSubtitle(int paramInt)
    {
      setSubtitle(j.this.mContext.getResources().getString(paramInt));
    }
    
    public final void setSubtitle(CharSequence paramCharSequence)
    {
      j.this.Ys.setSubtitle(paramCharSequence);
    }
    
    public final void setTitle(int paramInt)
    {
      setTitle(j.this.mContext.getResources().getString(paramInt));
    }
    
    public final void setTitle(CharSequence paramCharSequence)
    {
      j.this.Ys.setTitle(paramCharSequence);
    }
    
    public final void setTitleOptionalHint(boolean paramBoolean)
    {
      super.setTitleOptionalHint(paramBoolean);
      j.this.Ys.setTitleOptional(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.j
 * JD-Core Version:    0.7.0.1
 */