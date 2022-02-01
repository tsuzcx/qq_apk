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
  private static final Interpolator aac;
  private static final Interpolator aad;
  private ArrayList<Object> Eg = new ArrayList();
  u ZH;
  private boolean ZL;
  private ArrayList<Object> ZM = new ArrayList();
  final aa aaA = new aa()
  {
    public final void fA()
    {
      ((View)j.this.aag.getParent()).invalidate();
    }
  };
  private Context aae;
  ActionBarOverlayLayout aaf;
  ActionBarContainer aag;
  ActionBarContextView aah;
  ar aai;
  private int aaj = -1;
  private boolean aak;
  a aal;
  b aam;
  b.a aan;
  private boolean aao;
  private int aap = 0;
  boolean aaq = true;
  boolean aar;
  boolean aas;
  private boolean aat;
  private boolean aau = true;
  android.support.v7.view.h aav;
  private boolean aaw;
  boolean aax;
  final y aay = new z()
  {
    public final void aI(View paramAnonymousView)
    {
      if ((j.this.aaq) && (j.this.mContentView != null))
      {
        j.this.mContentView.setTranslationY(0.0F);
        j.this.aag.setTranslationY(0.0F);
      }
      j.this.aag.setVisibility(8);
      j.this.aag.setTransitioning(false);
      j.this.aav = null;
      paramAnonymousView = j.this;
      if (paramAnonymousView.aan != null)
      {
        paramAnonymousView.aan.a(paramAnonymousView.aam);
        paramAnonymousView.aam = null;
        paramAnonymousView.aan = null;
      }
      if (j.this.aaf != null) {
        t.ap(j.this.aaf);
      }
    }
  };
  final y aaz = new z()
  {
    public final void aI(View paramAnonymousView)
    {
      j.this.aav = null;
      j.this.aag.requestLayout();
    }
  };
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
      aac = new AccelerateInterpolator();
      aad = new DecelerateInterpolator();
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
    this.aao = paramBoolean;
    int i;
    label45:
    label78:
    Object localObject;
    if (!this.aao)
    {
      this.ZH.a(null);
      this.aag.setTabContainer(this.aai);
      if (getNavigationMode() != 2) {
        break label155;
      }
      i = 1;
      if (this.aai != null)
      {
        if (i == 0) {
          break label160;
        }
        this.aai.setVisibility(0);
        if (this.aaf != null) {
          t.ap(this.aaf);
        }
      }
      localObject = this.ZH;
      if ((this.aao) || (i == 0)) {
        break label172;
      }
      paramBoolean = true;
      label97:
      ((u)localObject).setCollapsible(paramBoolean);
      localObject = this.aaf;
      if ((this.aao) || (i == 0)) {
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
      this.aag.setTabContainer(null);
      this.ZH.a(this.aai);
      break;
      i = 0;
      break label45;
      this.aai.setVisibility(8);
      break label78;
      paramBoolean = false;
      break label97;
    }
  }
  
  private void V(boolean paramBoolean)
  {
    if (c(this.aar, this.aas, this.aat)) {
      if (!this.aau)
      {
        this.aau = true;
        W(paramBoolean);
      }
    }
    while (!this.aau) {
      return;
    }
    this.aau = false;
    X(paramBoolean);
  }
  
  private void W(boolean paramBoolean)
  {
    if (this.aav != null) {
      this.aav.cancel();
    }
    this.aag.setVisibility(0);
    if ((this.aap == 0) && ((this.aaw) || (paramBoolean)))
    {
      this.aag.setTranslationY(0.0F);
      float f2 = -this.aag.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp71_69 = localObject;
        tmp71_69[0] = 0;
        Object tmp75_71 = tmp71_69;
        tmp75_71[1] = 0;
        tmp75_71;
        this.aag.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      this.aag.setTranslationY(f1);
      Object localObject = new android.support.v7.view.h();
      x localx = t.ag(this.aag).z(0.0F);
      localx.a(this.aaA);
      ((android.support.v7.view.h)localObject).a(localx);
      if ((this.aaq) && (this.mContentView != null))
      {
        this.mContentView.setTranslationY(f1);
        ((android.support.v7.view.h)localObject).a(t.ag(this.mContentView).z(0.0F));
      }
      ((android.support.v7.view.h)localObject).b(aad);
      ((android.support.v7.view.h)localObject).hz();
      ((android.support.v7.view.h)localObject).b(this.aaz);
      this.aav = ((android.support.v7.view.h)localObject);
      ((android.support.v7.view.h)localObject).start();
    }
    for (;;)
    {
      if (this.aaf != null) {
        t.ap(this.aaf);
      }
      return;
      this.aag.setAlpha(1.0F);
      this.aag.setTranslationY(0.0F);
      if ((this.aaq) && (this.mContentView != null)) {
        this.mContentView.setTranslationY(0.0F);
      }
      this.aaz.aI(null);
    }
  }
  
  private void X(boolean paramBoolean)
  {
    if (this.aav != null) {
      this.aav.cancel();
    }
    if ((this.aap == 0) && ((this.aaw) || (paramBoolean)))
    {
      this.aag.setAlpha(1.0F);
      this.aag.setTransitioning(true);
      android.support.v7.view.h localh = new android.support.v7.view.h();
      float f2 = -this.aag.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp80_78 = localObject;
        tmp80_78[0] = 0;
        Object tmp84_80 = tmp80_78;
        tmp84_80[1] = 0;
        tmp84_80;
        this.aag.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = t.ag(this.aag).z(f1);
      ((x)localObject).a(this.aaA);
      localh.a((x)localObject);
      if ((this.aaq) && (this.mContentView != null)) {
        localh.a(t.ag(this.mContentView).z(f1));
      }
      localh.b(aac);
      localh.hz();
      localh.b(this.aay);
      this.aav = localh;
      localh.start();
      return;
    }
    this.aay.aI(null);
  }
  
  private void aZ(View paramView)
  {
    this.aaf = ((ActionBarOverlayLayout)paramView.findViewById(2131298945));
    if (this.aaf != null) {
      this.aaf.setActionBarVisibilityCallback(this);
    }
    this.ZH = ba(paramView.findViewById(2131296343));
    this.aah = ((ActionBarContextView)paramView.findViewById(2131296357));
    this.aag = ((ActionBarContainer)paramView.findViewById(2131296345));
    if ((this.ZH == null) || (this.aah == null) || (this.aag == null)) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
    }
    this.mContext = this.ZH.getContext();
    if ((this.ZH.getDisplayOptions() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.aak = true;
      }
      paramView = a.aa(this.mContext);
      paramView.hu();
      T(paramView.ht());
      paramView = this.mContext.obtainStyledAttributes(null, a.a.ActionBar, 2130968602, 0);
      if (paramView.getBoolean(14, false)) {
        go();
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
  
  private void gP()
  {
    if (!this.aat)
    {
      this.aat = true;
      if (this.aaf != null) {
        this.aaf.setShowingForActionMode(true);
      }
      V(false);
    }
  }
  
  private void gR()
  {
    if (this.aat)
    {
      this.aat = false;
      if (this.aaf != null) {
        this.aaf.setShowingForActionMode(false);
      }
      V(false);
    }
  }
  
  private int getNavigationMode()
  {
    return this.ZH.getNavigationMode();
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.ZH.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.aak = true;
    }
    this.ZH.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void Q(boolean paramBoolean)
  {
    if (!this.aak) {
      setDisplayHomeAsUpEnabled(paramBoolean);
    }
  }
  
  public final void R(boolean paramBoolean)
  {
    this.aaw = paramBoolean;
    if ((!paramBoolean) && (this.aav != null)) {
      this.aav.cancel();
    }
  }
  
  public final void S(boolean paramBoolean)
  {
    if (paramBoolean == this.ZL) {}
    for (;;)
    {
      return;
      this.ZL = paramBoolean;
      int j = this.ZM.size();
      int i = 0;
      while (i < j)
      {
        this.ZM.get(i);
        i += 1;
      }
    }
  }
  
  public final void U(boolean paramBoolean)
  {
    this.aaq = paramBoolean;
  }
  
  public final void Y(boolean paramBoolean)
  {
    x localx1;
    x localx2;
    if (paramBoolean)
    {
      gP();
      if (!t.ay(this.aag)) {
        break label108;
      }
      if (!paramBoolean) {
        break label78;
      }
      localx1 = this.ZH.c(4, 100L);
      localx2 = this.aah.c(0, 200L);
    }
    for (;;)
    {
      android.support.v7.view.h localh = new android.support.v7.view.h();
      localh.a(localx1, localx2);
      localh.start();
      return;
      gR();
      break;
      label78:
      localx2 = this.ZH.c(0, 200L);
      localx1 = this.aah.c(8, 100L);
    }
    label108:
    if (paramBoolean)
    {
      this.ZH.setVisibility(4);
      this.aah.setVisibility(0);
      return;
    }
    this.ZH.setVisibility(0);
    this.aah.setVisibility(8);
  }
  
  public final b a(b.a parama)
  {
    if (this.aal != null) {
      this.aal.finish();
    }
    this.aaf.setHideOnContentScrollEnabled(false);
    this.aah.ip();
    parama = new a(this.aah.getContext(), parama);
    if (parama.gU())
    {
      this.aal = parama;
      parama.invalidate();
      this.aah.c(parama);
      Y(true);
      this.aah.sendAccessibilityEvent(32);
      return parama;
    }
    return null;
  }
  
  public final boolean collapseActionView()
  {
    if ((this.ZH != null) && (this.ZH.hasExpandedActionView()))
    {
      this.ZH.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final void gQ()
  {
    if (this.aas)
    {
      this.aas = false;
      V(true);
    }
  }
  
  public final void gS()
  {
    if (!this.aas)
    {
      this.aas = true;
      V(true);
    }
  }
  
  public final void gT()
  {
    if (this.aav != null)
    {
      this.aav.cancel();
      this.aav = null;
    }
  }
  
  public final View getCustomView()
  {
    return this.ZH.getCustomView();
  }
  
  public final int getDisplayOptions()
  {
    return this.ZH.getDisplayOptions();
  }
  
  public final int getHeight()
  {
    return this.aag.getHeight();
  }
  
  public final Context getThemedContext()
  {
    int i;
    if (this.aae == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.mContext.getTheme().resolveAttribute(2130968607, localTypedValue, true);
      i = localTypedValue.resourceId;
      if (i == 0) {
        break label61;
      }
    }
    label61:
    for (this.aae = new ContextThemeWrapper(this.mContext, i);; this.aae = this.mContext) {
      return this.aae;
    }
  }
  
  public final CharSequence getTitle()
  {
    return this.ZH.getTitle();
  }
  
  public final void gk()
  {
    this.ZH.setIcon(2131234429);
  }
  
  public final void gl()
  {
    setDisplayOptions(0, 2);
  }
  
  public final void gm()
  {
    setDisplayOptions(0, 8);
  }
  
  public final void gn()
  {
    setDisplayOptions(16, 16);
  }
  
  public final void go()
  {
    if (!this.aaf.ahL) {
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    this.aax = true;
    this.aaf.setHideOnContentScrollEnabled(true);
  }
  
  public final void hide()
  {
    if (!this.aar)
    {
      this.aar = true;
      V(false);
    }
  }
  
  public final boolean isShowing()
  {
    int i = this.aag.getHeight();
    return (this.aau) && ((i == 0) || (this.aaf.getActionBarHideOffset() < i));
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    T(a.aa(this.mContext).ht());
  }
  
  public final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.aal == null) {}
    android.support.v7.view.menu.h localh;
    do
    {
      return false;
      localh = this.aal.aaD;
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
    this.aap = paramInt;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.aag.setPrimaryBackground(paramDrawable);
  }
  
  public final void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.ZH.jt(), false));
  }
  
  public final void setCustomView(View paramView)
  {
    this.ZH.setCustomView(paramView);
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
      this.aak = true;
    }
    this.ZH.setDisplayOptions(paramInt);
  }
  
  public final void setElevation(float paramFloat)
  {
    t.k(this.aag, paramFloat);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    this.ZH.setNavigationContentDescription(paramInt);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.ZH.setLogo(paramDrawable);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    this.ZH.setWindowTitle(paramCharSequence);
  }
  
  public final void show()
  {
    if (this.aar)
    {
      this.aar = false;
      V(false);
    }
  }
  
  public final class a
    extends b
    implements h.a
  {
    private final Context aaC;
    final android.support.v7.view.menu.h aaD;
    private b.a aaE;
    private WeakReference<View> aaF;
    
    public a(Context paramContext, b.a parama)
    {
      this.aaC = paramContext;
      this.aaE = parama;
      this$1 = new android.support.v7.view.menu.h(paramContext);
      j.this.agj = 1;
      this.aaD = j.this;
      this.aaD.a(this);
    }
    
    public final boolean a(android.support.v7.view.menu.h paramh, MenuItem paramMenuItem)
    {
      if (this.aaE != null) {
        return this.aaE.a(this, paramMenuItem);
      }
      return false;
    }
    
    public final void b(android.support.v7.view.menu.h paramh)
    {
      if (this.aaE == null) {
        return;
      }
      invalidate();
      j.this.aah.showOverflowMenu();
    }
    
    public final void finish()
    {
      if (j.this.aal != this) {
        return;
      }
      if (!j.c(j.this.aar, j.this.aas, false))
      {
        j.this.aam = this;
        j.this.aan = this.aaE;
      }
      for (;;)
      {
        this.aaE = null;
        j.this.Y(false);
        j.this.aah.in();
        j.this.ZH.jt().sendAccessibilityEvent(32);
        j.this.aaf.setHideOnContentScrollEnabled(j.this.aax);
        j.this.aal = null;
        return;
        this.aaE.a(this);
      }
    }
    
    public final boolean gU()
    {
      this.aaD.hR();
      try
      {
        boolean bool = this.aaE.a(this, this.aaD);
        return bool;
      }
      finally
      {
        this.aaD.hS();
      }
    }
    
    public final View getCustomView()
    {
      if (this.aaF != null) {
        return (View)this.aaF.get();
      }
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.aaD;
    }
    
    public final MenuInflater getMenuInflater()
    {
      return new g(this.aaC);
    }
    
    public final CharSequence getSubtitle()
    {
      return j.this.aah.getSubtitle();
    }
    
    public final CharSequence getTitle()
    {
      return j.this.aah.getTitle();
    }
    
    public final void invalidate()
    {
      if (j.this.aal != this) {
        return;
      }
      this.aaD.hR();
      try
      {
        this.aaE.b(this, this.aaD);
        return;
      }
      finally
      {
        this.aaD.hS();
      }
    }
    
    public final boolean isTitleOptional()
    {
      return j.this.aah.ahB;
    }
    
    public final void setCustomView(View paramView)
    {
      j.this.aah.setCustomView(paramView);
      this.aaF = new WeakReference(paramView);
    }
    
    public final void setSubtitle(int paramInt)
    {
      setSubtitle(j.this.mContext.getResources().getString(paramInt));
    }
    
    public final void setSubtitle(CharSequence paramCharSequence)
    {
      j.this.aah.setSubtitle(paramCharSequence);
    }
    
    public final void setTitle(int paramInt)
    {
      setTitle(j.this.mContext.getResources().getString(paramInt));
    }
    
    public final void setTitle(CharSequence paramCharSequence)
    {
      j.this.aah.setTitle(paramCharSequence);
    }
    
    public final void setTitleOptionalHint(boolean paramBoolean)
    {
      super.setTitleOptionalHint(paramBoolean);
      j.this.aah.setTitleOptional(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.j
 * JD-Core Version:    0.7.0.1
 */