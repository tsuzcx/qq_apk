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
import android.support.v4.view.ab;
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
  private static final Interpolator aap;
  private static final Interpolator aaq;
  private ArrayList<Object> Ep = new ArrayList();
  android.support.v7.widget.u ZU;
  private boolean ZY;
  private ArrayList<Object> ZZ = new ArrayList();
  b.a aaA;
  private boolean aaB;
  private int aaC = 0;
  boolean aaD = true;
  boolean aaE;
  boolean aaF;
  private boolean aaG;
  private boolean aaH = true;
  android.support.v7.view.h aaI;
  private boolean aaJ;
  boolean aaK;
  final z aaL = new aa()
  {
    public final void aJ(View paramAnonymousView)
    {
      if ((j.this.aaD) && (j.this.mContentView != null))
      {
        j.this.mContentView.setTranslationY(0.0F);
        j.this.aat.setTranslationY(0.0F);
      }
      j.this.aat.setVisibility(8);
      j.this.aat.setTransitioning(false);
      j.this.aaI = null;
      paramAnonymousView = j.this;
      if (paramAnonymousView.aaA != null)
      {
        paramAnonymousView.aaA.a(paramAnonymousView.aaz);
        paramAnonymousView.aaz = null;
        paramAnonymousView.aaA = null;
      }
      if (j.this.aas != null) {
        android.support.v4.view.u.ap(j.this.aas);
      }
    }
  };
  final z aaM = new aa()
  {
    public final void aJ(View paramAnonymousView)
    {
      j.this.aaI = null;
      j.this.aat.requestLayout();
    }
  };
  final ab aaN = new ab()
  {
    public final void fH()
    {
      ((View)j.this.aat.getParent()).invalidate();
    }
  };
  private Context aar;
  ActionBarOverlayLayout aas;
  ActionBarContainer aat;
  ActionBarContextView aau;
  ar aav;
  private int aaw = -1;
  private boolean aax;
  a aay;
  b aaz;
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
      aap = new AccelerateInterpolator();
      aaq = new DecelerateInterpolator();
      return;
    }
  }
  
  public j(Activity paramActivity, boolean paramBoolean)
  {
    this.mActivity = paramActivity;
    paramActivity = paramActivity.getWindow().getDecorView();
    ba(paramActivity);
    if (!paramBoolean) {
      this.mContentView = paramActivity.findViewById(16908290);
    }
  }
  
  public j(Dialog paramDialog)
  {
    this.mDialog = paramDialog;
    ba(paramDialog.getWindow().getDecorView());
  }
  
  private void S(boolean paramBoolean)
  {
    boolean bool = true;
    this.aaB = paramBoolean;
    int i;
    label45:
    label78:
    Object localObject;
    if (!this.aaB)
    {
      this.ZU.a(null);
      this.aat.setTabContainer(this.aav);
      if (getNavigationMode() != 2) {
        break label155;
      }
      i = 1;
      if (this.aav != null)
      {
        if (i == 0) {
          break label160;
        }
        this.aav.setVisibility(0);
        if (this.aas != null) {
          android.support.v4.view.u.ap(this.aas);
        }
      }
      localObject = this.ZU;
      if ((this.aaB) || (i == 0)) {
        break label172;
      }
      paramBoolean = true;
      label97:
      ((android.support.v7.widget.u)localObject).setCollapsible(paramBoolean);
      localObject = this.aas;
      if ((this.aaB) || (i == 0)) {
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
      this.aat.setTabContainer(null);
      this.ZU.a(this.aav);
      break;
      i = 0;
      break label45;
      this.aav.setVisibility(8);
      break label78;
      paramBoolean = false;
      break label97;
    }
  }
  
  private void U(boolean paramBoolean)
  {
    if (c(this.aaE, this.aaF, this.aaG)) {
      if (!this.aaH)
      {
        this.aaH = true;
        V(paramBoolean);
      }
    }
    while (!this.aaH) {
      return;
    }
    this.aaH = false;
    W(paramBoolean);
  }
  
  private void V(boolean paramBoolean)
  {
    if (this.aaI != null) {
      this.aaI.cancel();
    }
    this.aat.setVisibility(0);
    if ((this.aaC == 0) && ((this.aaJ) || (paramBoolean)))
    {
      this.aat.setTranslationY(0.0F);
      float f2 = -this.aat.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp71_69 = localObject;
        tmp71_69[0] = 0;
        Object tmp75_71 = tmp71_69;
        tmp75_71[1] = 0;
        tmp75_71;
        this.aat.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      this.aat.setTranslationY(f1);
      Object localObject = new android.support.v7.view.h();
      y localy = android.support.v4.view.u.ah(this.aat).z(0.0F);
      localy.a(this.aaN);
      ((android.support.v7.view.h)localObject).a(localy);
      if ((this.aaD) && (this.mContentView != null))
      {
        this.mContentView.setTranslationY(f1);
        ((android.support.v7.view.h)localObject).a(android.support.v4.view.u.ah(this.mContentView).z(0.0F));
      }
      ((android.support.v7.view.h)localObject).b(aaq);
      ((android.support.v7.view.h)localObject).hI();
      ((android.support.v7.view.h)localObject).b(this.aaM);
      this.aaI = ((android.support.v7.view.h)localObject);
      ((android.support.v7.view.h)localObject).start();
    }
    for (;;)
    {
      if (this.aas != null) {
        android.support.v4.view.u.ap(this.aas);
      }
      return;
      this.aat.setAlpha(1.0F);
      this.aat.setTranslationY(0.0F);
      if ((this.aaD) && (this.mContentView != null)) {
        this.mContentView.setTranslationY(0.0F);
      }
      this.aaM.aJ(null);
    }
  }
  
  private void W(boolean paramBoolean)
  {
    if (this.aaI != null) {
      this.aaI.cancel();
    }
    if ((this.aaC == 0) && ((this.aaJ) || (paramBoolean)))
    {
      this.aat.setAlpha(1.0F);
      this.aat.setTransitioning(true);
      android.support.v7.view.h localh = new android.support.v7.view.h();
      float f2 = -this.aat.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp80_78 = localObject;
        tmp80_78[0] = 0;
        Object tmp84_80 = tmp80_78;
        tmp84_80[1] = 0;
        tmp84_80;
        this.aat.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = android.support.v4.view.u.ah(this.aat).z(f1);
      ((y)localObject).a(this.aaN);
      localh.a((y)localObject);
      if ((this.aaD) && (this.mContentView != null)) {
        localh.a(android.support.v4.view.u.ah(this.mContentView).z(f1));
      }
      localh.b(aap);
      localh.hI();
      localh.b(this.aaL);
      this.aaI = localh;
      localh.start();
      return;
    }
    this.aaL.aJ(null);
  }
  
  private void ba(View paramView)
  {
    this.aas = ((ActionBarOverlayLayout)paramView.findViewById(2131299436));
    if (this.aas != null) {
      this.aas.setActionBarVisibilityCallback(this);
    }
    this.ZU = bb(paramView.findViewById(2131296363));
    this.aau = ((ActionBarContextView)paramView.findViewById(2131296380));
    this.aat = ((ActionBarContainer)paramView.findViewById(2131296366));
    if ((this.ZU == null) || (this.aau == null) || (this.aat == null)) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
    }
    this.mContext = this.ZU.getContext();
    if ((this.ZU.getDisplayOptions() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.aax = true;
      }
      paramView = a.ab(this.mContext);
      paramView.hD();
      S(paramView.hC());
      paramView = this.mContext.obtainStyledAttributes(null, a.a.ActionBar, 2130968603, 0);
      if (paramView.getBoolean(14, false)) {
        gv();
      }
      i = paramView.getDimensionPixelSize(12, 0);
      if (i != 0) {
        setElevation(i);
      }
      paramView.recycle();
      return;
    }
  }
  
  private static android.support.v7.widget.u bb(View paramView)
  {
    if ((paramView instanceof android.support.v7.widget.u)) {
      return (android.support.v7.widget.u)paramView;
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
  
  private void gW()
  {
    if (!this.aaG)
    {
      this.aaG = true;
      if (this.aas != null) {
        this.aas.setShowingForActionMode(true);
      }
      U(false);
    }
  }
  
  private void gY()
  {
    if (this.aaG)
    {
      this.aaG = false;
      if (this.aas != null) {
        this.aas.setShowingForActionMode(false);
      }
      U(false);
    }
  }
  
  private int getNavigationMode()
  {
    return this.ZU.getNavigationMode();
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.ZU.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.aax = true;
    }
    this.ZU.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void P(boolean paramBoolean)
  {
    if (!this.aax) {
      setDisplayHomeAsUpEnabled(paramBoolean);
    }
  }
  
  public final void Q(boolean paramBoolean)
  {
    this.aaJ = paramBoolean;
    if ((!paramBoolean) && (this.aaI != null)) {
      this.aaI.cancel();
    }
  }
  
  public final void R(boolean paramBoolean)
  {
    if (paramBoolean == this.ZY) {}
    for (;;)
    {
      return;
      this.ZY = paramBoolean;
      int j = this.ZZ.size();
      int i = 0;
      while (i < j)
      {
        this.ZZ.get(i);
        i += 1;
      }
    }
  }
  
  public final void T(boolean paramBoolean)
  {
    this.aaD = paramBoolean;
  }
  
  public final void X(boolean paramBoolean)
  {
    y localy1;
    y localy2;
    if (paramBoolean)
    {
      gW();
      if (!android.support.v4.view.u.az(this.aat)) {
        break label108;
      }
      if (!paramBoolean) {
        break label78;
      }
      localy1 = this.ZU.c(4, 100L);
      localy2 = this.aau.c(0, 200L);
    }
    for (;;)
    {
      android.support.v7.view.h localh = new android.support.v7.view.h();
      localh.a(localy1, localy2);
      localh.start();
      return;
      gY();
      break;
      label78:
      localy2 = this.ZU.c(0, 200L);
      localy1 = this.aau.c(8, 100L);
    }
    label108:
    if (paramBoolean)
    {
      this.ZU.setVisibility(4);
      this.aau.setVisibility(0);
      return;
    }
    this.ZU.setVisibility(0);
    this.aau.setVisibility(8);
  }
  
  public final b a(b.a parama)
  {
    if (this.aay != null) {
      this.aay.finish();
    }
    this.aas.setHideOnContentScrollEnabled(false);
    this.aau.iy();
    parama = new a(this.aau.getContext(), parama);
    if (parama.hb())
    {
      this.aay = parama;
      parama.invalidate();
      this.aau.c(parama);
      X(true);
      this.aau.sendAccessibilityEvent(32);
      return parama;
    }
    return null;
  }
  
  public final void a(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    paramView.setLayoutParams(paramLayoutParams);
    this.ZU.setCustomView(paramView);
  }
  
  public final boolean collapseActionView()
  {
    if ((this.ZU != null) && (this.ZU.hasExpandedActionView()))
    {
      this.ZU.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final void gX()
  {
    if (this.aaF)
    {
      this.aaF = false;
      U(true);
    }
  }
  
  public final void gZ()
  {
    if (!this.aaF)
    {
      this.aaF = true;
      U(true);
    }
  }
  
  public final View getCustomView()
  {
    return this.ZU.getCustomView();
  }
  
  public final int getDisplayOptions()
  {
    return this.ZU.getDisplayOptions();
  }
  
  public final int getHeight()
  {
    return this.aat.getHeight();
  }
  
  public final Context getThemedContext()
  {
    int i;
    if (this.aar == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.mContext.getTheme().resolveAttribute(2130968608, localTypedValue, true);
      i = localTypedValue.resourceId;
      if (i == 0) {
        break label61;
      }
    }
    label61:
    for (this.aar = new ContextThemeWrapper(this.mContext, i);; this.aar = this.mContext) {
      return this.aar;
    }
  }
  
  public final CharSequence getTitle()
  {
    return this.ZU.getTitle();
  }
  
  public final void gr()
  {
    this.ZU.setIcon(2131235359);
  }
  
  public final void gs()
  {
    setDisplayOptions(0, 2);
  }
  
  public final void gt()
  {
    setDisplayOptions(0, 8);
  }
  
  public final void gu()
  {
    setDisplayOptions(16, 16);
  }
  
  public final void gv()
  {
    if (!this.aas.ahX) {
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    this.aaK = true;
    this.aas.setHideOnContentScrollEnabled(true);
  }
  
  public final void ha()
  {
    if (this.aaI != null)
    {
      this.aaI.cancel();
      this.aaI = null;
    }
  }
  
  public final void hide()
  {
    if (!this.aaE)
    {
      this.aaE = true;
      U(false);
    }
  }
  
  public final boolean isShowing()
  {
    int i = this.aat.getHeight();
    return (this.aaH) && ((i == 0) || (this.aas.getActionBarHideOffset() < i));
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    S(a.ab(this.mContext).hC());
  }
  
  public final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.aay == null) {}
    android.support.v7.view.menu.h localh;
    do
    {
      return false;
      localh = this.aay.aaQ;
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
    this.aaC = paramInt;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.aat.setPrimaryBackground(paramDrawable);
  }
  
  public final void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.ZU.jC(), false));
  }
  
  public final void setCustomView(View paramView)
  {
    this.ZU.setCustomView(paramView);
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
      this.aax = true;
    }
    this.ZU.setDisplayOptions(paramInt);
  }
  
  public final void setElevation(float paramFloat)
  {
    android.support.v4.view.u.l(this.aat, paramFloat);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    this.ZU.setNavigationContentDescription(paramInt);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.ZU.setLogo(paramDrawable);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.ZU.setTitle(paramCharSequence);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    this.ZU.setWindowTitle(paramCharSequence);
  }
  
  public final void show()
  {
    if (this.aaE)
    {
      this.aaE = false;
      U(false);
    }
  }
  
  public final class a
    extends b
    implements h.a
  {
    private final Context aaP;
    final android.support.v7.view.menu.h aaQ;
    private b.a aaR;
    private WeakReference<View> aaS;
    
    public a(Context paramContext, b.a parama)
    {
      this.aaP = paramContext;
      this.aaR = parama;
      this$1 = new android.support.v7.view.menu.h(paramContext);
      j.this.agw = 1;
      this.aaQ = j.this;
      this.aaQ.a(this);
    }
    
    public final boolean a(android.support.v7.view.menu.h paramh, MenuItem paramMenuItem)
    {
      if (this.aaR != null) {
        return this.aaR.a(this, paramMenuItem);
      }
      return false;
    }
    
    public final void b(android.support.v7.view.menu.h paramh)
    {
      if (this.aaR == null) {
        return;
      }
      invalidate();
      j.this.aau.showOverflowMenu();
    }
    
    public final void finish()
    {
      if (j.this.aay != this) {
        return;
      }
      if (!j.c(j.this.aaE, j.this.aaF, false))
      {
        j.this.aaz = this;
        j.this.aaA = this.aaR;
      }
      for (;;)
      {
        this.aaR = null;
        j.this.X(false);
        j.this.aau.ix();
        j.this.ZU.jC().sendAccessibilityEvent(32);
        j.this.aas.setHideOnContentScrollEnabled(j.this.aaK);
        j.this.aay = null;
        return;
        this.aaR.a(this);
      }
    }
    
    public final View getCustomView()
    {
      if (this.aaS != null) {
        return (View)this.aaS.get();
      }
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.aaQ;
    }
    
    public final MenuInflater getMenuInflater()
    {
      return new g(this.aaP);
    }
    
    public final CharSequence getSubtitle()
    {
      return j.this.aau.getSubtitle();
    }
    
    public final CharSequence getTitle()
    {
      return j.this.aau.getTitle();
    }
    
    public final boolean hb()
    {
      this.aaQ.ia();
      try
      {
        boolean bool = this.aaR.a(this, this.aaQ);
        return bool;
      }
      finally
      {
        this.aaQ.ib();
      }
    }
    
    public final void invalidate()
    {
      if (j.this.aay != this) {
        return;
      }
      this.aaQ.ia();
      try
      {
        this.aaR.b(this, this.aaQ);
        return;
      }
      finally
      {
        this.aaQ.ib();
      }
    }
    
    public final boolean isTitleOptional()
    {
      return j.this.aau.ahO;
    }
    
    public final void setCustomView(View paramView)
    {
      j.this.aau.setCustomView(paramView);
      this.aaS = new WeakReference(paramView);
    }
    
    public final void setSubtitle(int paramInt)
    {
      setSubtitle(j.this.mContext.getResources().getString(paramInt));
    }
    
    public final void setSubtitle(CharSequence paramCharSequence)
    {
      j.this.aau.setSubtitle(paramCharSequence);
    }
    
    public final void setTitle(int paramInt)
    {
      setTitle(j.this.mContext.getResources().getString(paramInt));
    }
    
    public final void setTitle(CharSequence paramCharSequence)
    {
      j.this.aau.setTitle(paramCharSequence);
    }
    
    public final void setTitleOptionalHint(boolean paramBoolean)
    {
      super.setTitleOptionalHint(paramBoolean);
      j.this.aau.setTitleOptional(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.j
 * JD-Core Version:    0.7.0.1
 */