package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.q;
import android.support.v4.view.u;
import android.support.v4.view.v;
import android.support.v4.view.x;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.j;
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
import android.support.v7.widget.aq;
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

public class o
  extends ActionBar
  implements ActionBarOverlayLayout.a
{
  private static final Interpolator QL;
  private static final Interpolator QM;
  private Context QN;
  ActionBarOverlayLayout QO;
  ActionBarContainer QP;
  ActionBarContextView QQ;
  View QR;
  aq QS;
  private int QT = -1;
  private boolean QU;
  a QV;
  b QW;
  b.a QX;
  private boolean QY;
  private int QZ = 0;
  android.support.v7.widget.w Qq;
  private boolean Qu;
  private ArrayList<Object> Qv = new ArrayList();
  boolean Ra = true;
  boolean Rb;
  boolean Rc;
  private boolean Rd;
  private boolean Re = true;
  android.support.v7.view.h Rf;
  private boolean Rg;
  boolean Rh;
  final v Ri = new android.support.v4.view.w()
  {
    public final void av(View paramAnonymousView)
    {
      if ((o.this.Ra) && (o.this.QR != null))
      {
        o.this.QR.setTranslationY(0.0F);
        o.this.QP.setTranslationY(0.0F);
      }
      o.this.QP.setVisibility(8);
      o.this.QP.setTransitioning(false);
      o.this.Rf = null;
      paramAnonymousView = o.this;
      if (paramAnonymousView.QX != null)
      {
        paramAnonymousView.QX.a(paramAnonymousView.QW);
        paramAnonymousView.QW = null;
        paramAnonymousView.QX = null;
      }
      if (o.this.QO != null) {
        q.ad(o.this.QO);
      }
    }
  };
  final v Rj = new android.support.v4.view.w()
  {
    public final void av(View paramAnonymousView)
    {
      o.this.Rf = null;
      o.this.QP.requestLayout();
    }
  };
  final x Rk = new x()
  {
    public final void du()
    {
      ((View)o.this.QP.getParent()).invalidate();
    }
  };
  private ArrayList<Object> kf = new ArrayList();
  private Activity mActivity;
  Context mContext;
  private Dialog mDialog;
  
  static
  {
    if (!o.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      QL = new AccelerateInterpolator();
      QM = new DecelerateInterpolator();
      return;
    }
  }
  
  public o(Activity paramActivity, boolean paramBoolean)
  {
    this.mActivity = paramActivity;
    paramActivity = paramActivity.getWindow().getDecorView();
    aM(paramActivity);
    if (!paramBoolean) {
      this.QR = paramActivity.findViewById(16908290);
    }
  }
  
  public o(Dialog paramDialog)
  {
    this.mDialog = paramDialog;
    aM(paramDialog.getWindow().getDecorView());
  }
  
  private void O(boolean paramBoolean)
  {
    boolean bool = true;
    this.QY = paramBoolean;
    int i;
    label50:
    label83:
    Object localObject;
    if (!this.QY)
    {
      this.Qq.a(null);
      this.QP.setTabContainer(this.QS);
      if (this.Qq.getNavigationMode() != 2) {
        break label160;
      }
      i = 1;
      if (this.QS != null)
      {
        if (i == 0) {
          break label165;
        }
        this.QS.setVisibility(0);
        if (this.QO != null) {
          q.ad(this.QO);
        }
      }
      localObject = this.Qq;
      if ((this.QY) || (i == 0)) {
        break label177;
      }
      paramBoolean = true;
      label102:
      ((android.support.v7.widget.w)localObject).setCollapsible(paramBoolean);
      localObject = this.QO;
      if ((this.QY) || (i == 0)) {
        break label182;
      }
    }
    label160:
    label165:
    label177:
    label182:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((ActionBarOverlayLayout)localObject).setHasNonEmbeddedTabs(paramBoolean);
      return;
      this.QP.setTabContainer(null);
      this.Qq.a(this.QS);
      break;
      i = 0;
      break label50;
      this.QS.setVisibility(8);
      break label83;
      paramBoolean = false;
      break label102;
    }
  }
  
  private void Q(boolean paramBoolean)
  {
    float f2;
    float f1;
    Object localObject1;
    Object localObject2;
    if (e(this.Rb, this.Rc, this.Rd)) {
      if (!this.Re)
      {
        this.Re = true;
        if (this.Rf != null) {
          this.Rf.cancel();
        }
        this.QP.setVisibility(0);
        if ((this.QZ != 0) || ((!this.Rg) && (!paramBoolean))) {
          break label265;
        }
        this.QP.setTranslationY(0.0F);
        f2 = -this.QP.getHeight();
        f1 = f2;
        if (paramBoolean)
        {
          localObject1 = new int[2];
          Object tmp101_99 = localObject1;
          tmp101_99[0] = 0;
          Object tmp105_101 = tmp101_99;
          tmp105_101[1] = 0;
          tmp105_101;
          this.QP.getLocationInWindow((int[])localObject1);
          f1 = f2 - localObject1[1];
        }
        this.QP.setTranslationY(f1);
        localObject1 = new android.support.v7.view.h();
        localObject2 = q.Y(this.QP).t(0.0F);
        ((u)localObject2).a(this.Rk);
        ((android.support.v7.view.h)localObject1).a((u)localObject2);
        if ((this.Ra) && (this.QR != null))
        {
          this.QR.setTranslationY(f1);
          ((android.support.v7.view.h)localObject1).a(q.Y(this.QR).t(0.0F));
        }
        ((android.support.v7.view.h)localObject1).d(QM);
        ((android.support.v7.view.h)localObject1).eR();
        ((android.support.v7.view.h)localObject1).b(this.Rj);
        this.Rf = ((android.support.v7.view.h)localObject1);
        ((android.support.v7.view.h)localObject1).start();
        if (this.QO != null) {
          q.ad(this.QO);
        }
      }
    }
    label265:
    while (!this.Re) {
      for (;;)
      {
        return;
        this.QP.setAlpha(1.0F);
        this.QP.setTranslationY(0.0F);
        if ((this.Ra) && (this.QR != null)) {
          this.QR.setTranslationY(0.0F);
        }
        this.Rj.av(null);
      }
    }
    this.Re = false;
    if (this.Rf != null) {
      this.Rf.cancel();
    }
    if ((this.QZ == 0) && ((this.Rg) || (paramBoolean)))
    {
      this.QP.setAlpha(1.0F);
      this.QP.setTransitioning(true);
      localObject1 = new android.support.v7.view.h();
      f2 = -this.QP.getHeight();
      f1 = f2;
      if (paramBoolean)
      {
        localObject2 = new int[2];
        Object tmp408_406 = localObject2;
        tmp408_406[0] = 0;
        Object tmp412_408 = tmp408_406;
        tmp412_408[1] = 0;
        tmp412_408;
        this.QP.getLocationInWindow((int[])localObject2);
        f1 = f2 - localObject2[1];
      }
      localObject2 = q.Y(this.QP).t(f1);
      ((u)localObject2).a(this.Rk);
      ((android.support.v7.view.h)localObject1).a((u)localObject2);
      if ((this.Ra) && (this.QR != null)) {
        ((android.support.v7.view.h)localObject1).a(q.Y(this.QR).t(f1));
      }
      ((android.support.v7.view.h)localObject1).d(QL);
      ((android.support.v7.view.h)localObject1).eR();
      ((android.support.v7.view.h)localObject1).b(this.Ri);
      this.Rf = ((android.support.v7.view.h)localObject1);
      ((android.support.v7.view.h)localObject1).start();
      return;
    }
    this.Ri.av(null);
  }
  
  private void aM(View paramView)
  {
    this.QO = ((ActionBarOverlayLayout)paramView.findViewById(a.f.decor_content_parent));
    if (this.QO != null) {
      this.QO.setActionBarVisibilityCallback(this);
    }
    Object localObject = paramView.findViewById(a.f.action_bar);
    if ((localObject instanceof android.support.v7.widget.w)) {}
    for (localObject = (android.support.v7.widget.w)localObject;; localObject = ((Toolbar)localObject).getWrapper())
    {
      this.Qq = ((android.support.v7.widget.w)localObject);
      this.QQ = ((ActionBarContextView)paramView.findViewById(a.f.action_context_bar));
      this.QP = ((ActionBarContainer)paramView.findViewById(a.f.action_bar_container));
      if ((this.Qq != null) && (this.QQ != null) && (this.QP != null)) {
        break label199;
      }
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
      if (!(localObject instanceof Toolbar)) {
        break;
      }
    }
    if ("Can't make a decor toolbar out of " + localObject != null) {}
    for (paramView = localObject.getClass().getSimpleName();; paramView = "null") {
      throw new IllegalStateException(paramView);
    }
    label199:
    this.mContext = this.Qq.getContext();
    if ((this.Qq.getDisplayOptions() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.QU = true;
      }
      paramView = a.T(this.mContext);
      paramView.eN();
      O(paramView.eM());
      paramView = this.mContext.obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
      if (!paramView.getBoolean(a.j.ActionBar_hideOnContentScroll, false)) {
        break label324;
      }
      if (this.QO.Xi) {
        break;
      }
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    this.Rh = true;
    this.QO.setHideOnContentScrollEnabled(true);
    label324:
    i = paramView.getDimensionPixelSize(a.j.ActionBar_elevation, 0);
    if (i != 0) {
      setElevation(i);
    }
    paramView.recycle();
  }
  
  static boolean e(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.Qq.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.QU = true;
    }
    this.Qq.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void L(boolean paramBoolean)
  {
    if (!this.QU) {
      setDisplayHomeAsUpEnabled(paramBoolean);
    }
  }
  
  public final void M(boolean paramBoolean)
  {
    this.Rg = paramBoolean;
    if ((!paramBoolean) && (this.Rf != null)) {
      this.Rf.cancel();
    }
  }
  
  public final void N(boolean paramBoolean)
  {
    if (paramBoolean == this.Qu) {}
    for (;;)
    {
      return;
      this.Qu = paramBoolean;
      int j = this.Qv.size();
      int i = 0;
      while (i < j)
      {
        this.Qv.get(i);
        i += 1;
      }
    }
  }
  
  public final void P(boolean paramBoolean)
  {
    this.Ra = paramBoolean;
  }
  
  public final void R(boolean paramBoolean)
  {
    u localu1;
    u localu2;
    if (paramBoolean)
    {
      if (!this.Rd)
      {
        this.Rd = true;
        if (this.QO != null) {
          this.QO.setShowingForActionMode(true);
        }
        Q(false);
      }
      if (!q.al(this.QP)) {
        break label164;
      }
      if (!paramBoolean) {
        break label134;
      }
      localu1 = this.Qq.c(4, 100L);
      localu2 = this.QQ.c(0, 200L);
    }
    for (;;)
    {
      android.support.v7.view.h localh = new android.support.v7.view.h();
      localh.a(localu1, localu2);
      localh.start();
      return;
      if (!this.Rd) {
        break;
      }
      this.Rd = false;
      if (this.QO != null) {
        this.QO.setShowingForActionMode(false);
      }
      Q(false);
      break;
      label134:
      localu2 = this.Qq.c(0, 200L);
      localu1 = this.QQ.c(8, 100L);
    }
    label164:
    if (paramBoolean)
    {
      this.Qq.setVisibility(4);
      this.QQ.setVisibility(0);
      return;
    }
    this.Qq.setVisibility(0);
    this.QQ.setVisibility(8);
  }
  
  public final b a(b.a parama)
  {
    if (this.QV != null) {
      this.QV.finish();
    }
    this.QO.setHideOnContentScrollEnabled(false);
    this.QQ.fB();
    parama = new a(this.QQ.getContext(), parama);
    if (parama.ey())
    {
      this.QV = parama;
      parama.invalidate();
      this.QQ.c(parama);
      R(true);
      this.QQ.sendAccessibilityEvent(32);
      return parama;
    }
    return null;
  }
  
  public final boolean collapseActionView()
  {
    if ((this.Qq != null) && (this.Qq.hasExpandedActionView()))
    {
      this.Qq.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final void dY()
  {
    setDisplayOptions(0, 2);
  }
  
  public final void dZ()
  {
    setDisplayOptions(0, 8);
  }
  
  public final void ea()
  {
    setDisplayOptions(16, 16);
  }
  
  public final void ev()
  {
    if (this.Rc)
    {
      this.Rc = false;
      Q(true);
    }
  }
  
  public final void ew()
  {
    if (!this.Rc)
    {
      this.Rc = true;
      Q(true);
    }
  }
  
  public final void ex()
  {
    if (this.Rf != null)
    {
      this.Rf.cancel();
      this.Rf = null;
    }
  }
  
  public final View getCustomView()
  {
    return this.Qq.getCustomView();
  }
  
  public final int getDisplayOptions()
  {
    return this.Qq.getDisplayOptions();
  }
  
  public final int getHeight()
  {
    return this.QP.getHeight();
  }
  
  public final Context getThemedContext()
  {
    int i;
    if (this.QN == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.mContext.getTheme().resolveAttribute(a.a.actionBarWidgetTheme, localTypedValue, true);
      i = localTypedValue.resourceId;
      if (i == 0) {
        break label61;
      }
    }
    label61:
    for (this.QN = new ContextThemeWrapper(this.mContext, i);; this.QN = this.mContext) {
      return this.QN;
    }
  }
  
  public final CharSequence getTitle()
  {
    return this.Qq.getTitle();
  }
  
  public final void hide()
  {
    if (!this.Rb)
    {
      this.Rb = true;
      Q(false);
    }
  }
  
  public final boolean isShowing()
  {
    int i = this.QP.getHeight();
    return (this.Re) && ((i == 0) || (this.QO.getActionBarHideOffset() < i));
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    O(a.T(this.mContext).eM());
  }
  
  public final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.QV == null) {}
    android.support.v7.view.menu.h localh;
    do
    {
      return false;
      localh = this.QV.dm;
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
    this.QZ = paramInt;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.QP.setPrimaryBackground(paramDrawable);
  }
  
  public final void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.Qq.gz(), false));
  }
  
  public final void setCustomView(View paramView)
  {
    this.Qq.setCustomView(paramView);
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
      this.QU = true;
    }
    this.Qq.setDisplayOptions(paramInt);
  }
  
  public final void setElevation(float paramFloat)
  {
    q.h(this.QP, paramFloat);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    this.Qq.setNavigationContentDescription(paramInt);
  }
  
  public final void setIcon(int paramInt)
  {
    this.Qq.setIcon(paramInt);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.Qq.setLogo(paramDrawable);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    this.Qq.setWindowTitle(paramCharSequence);
  }
  
  public final void show()
  {
    if (this.Rb)
    {
      this.Rb = false;
      Q(false);
    }
  }
  
  public final class a
    extends b
    implements h.a
  {
    private final Context Rm;
    private b.a Rn;
    private WeakReference<View> Ro;
    final android.support.v7.view.menu.h dm;
    
    public a(Context paramContext, b.a parama)
    {
      this.Rm = paramContext;
      this.Rn = parama;
      this$1 = new android.support.v7.view.menu.h(paramContext);
      o.this.VD = 1;
      this.dm = o.this;
      this.dm.a(this);
    }
    
    public final boolean a(android.support.v7.view.menu.h paramh, MenuItem paramMenuItem)
    {
      if (this.Rn != null) {
        return this.Rn.a(this, paramMenuItem);
      }
      return false;
    }
    
    public final void b(android.support.v7.view.menu.h paramh)
    {
      if (this.Rn == null) {
        return;
      }
      invalidate();
      o.this.QQ.showOverflowMenu();
    }
    
    public final boolean ey()
    {
      this.dm.fh();
      try
      {
        boolean bool = this.Rn.a(this, this.dm);
        return bool;
      }
      finally
      {
        this.dm.fi();
      }
    }
    
    public final void finish()
    {
      if (o.this.QV != this) {
        return;
      }
      if (!o.e(o.this.Rb, o.this.Rc, false))
      {
        o.this.QW = this;
        o.this.QX = this.Rn;
      }
      for (;;)
      {
        this.Rn = null;
        o.this.R(false);
        o.this.QQ.fA();
        o.this.Qq.gz().sendAccessibilityEvent(32);
        o.this.QO.setHideOnContentScrollEnabled(o.this.Rh);
        o.this.QV = null;
        return;
        this.Rn.a(this);
      }
    }
    
    public final View getCustomView()
    {
      if (this.Ro != null) {
        return (View)this.Ro.get();
      }
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.dm;
    }
    
    public final MenuInflater getMenuInflater()
    {
      return new g(this.Rm);
    }
    
    public final CharSequence getSubtitle()
    {
      return o.this.QQ.getSubtitle();
    }
    
    public final CharSequence getTitle()
    {
      return o.this.QQ.getTitle();
    }
    
    public final void invalidate()
    {
      if (o.this.QV != this) {
        return;
      }
      this.dm.fh();
      try
      {
        this.Rn.b(this, this.dm);
        return;
      }
      finally
      {
        this.dm.fi();
      }
    }
    
    public final boolean isTitleOptional()
    {
      return o.this.QQ.WY;
    }
    
    public final void setCustomView(View paramView)
    {
      o.this.QQ.setCustomView(paramView);
      this.Ro = new WeakReference(paramView);
    }
    
    public final void setSubtitle(int paramInt)
    {
      setSubtitle(o.this.mContext.getResources().getString(paramInt));
    }
    
    public final void setSubtitle(CharSequence paramCharSequence)
    {
      o.this.QQ.setSubtitle(paramCharSequence);
    }
    
    public final void setTitle(int paramInt)
    {
      setTitle(o.this.mContext.getResources().getString(paramInt));
    }
    
    public final void setTitle(CharSequence paramCharSequence)
    {
      o.this.QQ.setTitle(paramCharSequence);
    }
    
    public final void setTitleOptionalHint(boolean paramBoolean)
    {
      super.setTitleOptionalHint(paramBoolean);
      o.this.QQ.setTitleOptional(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.o
 * JD-Core Version:    0.7.0.1
 */