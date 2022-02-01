package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
import androidx.appcompat.a.a;
import androidx.appcompat.a.f;
import androidx.appcompat.a.j;
import androidx.appcompat.view.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.b.a;
import androidx.appcompat.view.g;
import androidx.appcompat.view.menu.h.a;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionBarOverlayLayout.a;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.n;
import androidx.appcompat.widget.w;
import androidx.core.g.ad;
import androidx.core.g.ae;
import androidx.core.g.af;
import androidx.core.g.ag;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class j
  extends ActionBar
  implements ActionBarOverlayLayout.a
{
  private static final Interpolator iM;
  private static final Interpolator iN;
  private Context iO;
  ActionBarOverlayLayout iP;
  ActionBarContainer iQ;
  ActionBarContextView iR;
  w iS;
  private ArrayList<Object> iT;
  private int iU;
  private boolean iV;
  a iW;
  b iX;
  b.a iY;
  private boolean iZ;
  n iq;
  private boolean iu;
  private ArrayList<Object> iw;
  private int ja;
  boolean jb;
  boolean jc;
  boolean jd;
  private boolean je;
  private boolean jf;
  androidx.appcompat.view.h jg;
  private boolean jh;
  boolean ji;
  final ae jj;
  final ae jk;
  final ag jl;
  private Activity mActivity;
  View mContentView;
  Context mContext;
  private Dialog mDialog;
  
  static
  {
    AppMethodBeat.i(200688);
    if (!j.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      iM = new AccelerateInterpolator();
      iN = new DecelerateInterpolator();
      AppMethodBeat.o(200688);
      return;
    }
  }
  
  public j(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(200558);
    this.iT = new ArrayList();
    this.iU = -1;
    this.iw = new ArrayList();
    this.ja = 0;
    this.jb = true;
    this.jf = true;
    this.jj = new af()
    {
      public final void f(View paramAnonymousView)
      {
        AppMethodBeat.i(200476);
        if ((j.this.jb) && (j.this.mContentView != null))
        {
          j.this.mContentView.setTranslationY(0.0F);
          j.this.iQ.setTranslationY(0.0F);
        }
        j.this.iQ.setVisibility(8);
        j.this.iQ.setTransitioning(false);
        j.this.jg = null;
        paramAnonymousView = j.this;
        if (paramAnonymousView.iY != null)
        {
          paramAnonymousView.iY.a(paramAnonymousView.iX);
          paramAnonymousView.iX = null;
          paramAnonymousView.iY = null;
        }
        if (j.this.iP != null) {
          z.ak(j.this.iP);
        }
        AppMethodBeat.o(200476);
      }
    };
    this.jk = new af()
    {
      public final void f(View paramAnonymousView)
      {
        AppMethodBeat.i(200471);
        j.this.jg = null;
        j.this.iQ.requestLayout();
        AppMethodBeat.o(200471);
      }
    };
    this.jl = new ag()
    {
      public final void cf()
      {
        AppMethodBeat.i(200479);
        ((View)j.this.iQ.getParent()).invalidate();
        AppMethodBeat.o(200479);
      }
    };
    this.mActivity = paramActivity;
    paramActivity = paramActivity.getWindow().getDecorView();
    g(paramActivity);
    if (!paramBoolean) {
      this.mContentView = paramActivity.findViewById(16908290);
    }
    AppMethodBeat.o(200558);
  }
  
  public j(Dialog paramDialog)
  {
    AppMethodBeat.i(200568);
    this.iT = new ArrayList();
    this.iU = -1;
    this.iw = new ArrayList();
    this.ja = 0;
    this.jb = true;
    this.jf = true;
    this.jj = new af()
    {
      public final void f(View paramAnonymousView)
      {
        AppMethodBeat.i(200476);
        if ((j.this.jb) && (j.this.mContentView != null))
        {
          j.this.mContentView.setTranslationY(0.0F);
          j.this.iQ.setTranslationY(0.0F);
        }
        j.this.iQ.setVisibility(8);
        j.this.iQ.setTransitioning(false);
        j.this.jg = null;
        paramAnonymousView = j.this;
        if (paramAnonymousView.iY != null)
        {
          paramAnonymousView.iY.a(paramAnonymousView.iX);
          paramAnonymousView.iX = null;
          paramAnonymousView.iY = null;
        }
        if (j.this.iP != null) {
          z.ak(j.this.iP);
        }
        AppMethodBeat.o(200476);
      }
    };
    this.jk = new af()
    {
      public final void f(View paramAnonymousView)
      {
        AppMethodBeat.i(200471);
        j.this.jg = null;
        j.this.iQ.requestLayout();
        AppMethodBeat.o(200471);
      }
    };
    this.jl = new ag()
    {
      public final void cf()
      {
        AppMethodBeat.i(200479);
        ((View)j.this.iQ.getParent()).invalidate();
        AppMethodBeat.o(200479);
      }
    };
    this.mDialog = paramDialog;
    g(paramDialog.getWindow().getDecorView());
    AppMethodBeat.o(200568);
  }
  
  private void C(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(200606);
    this.iZ = paramBoolean;
    int i;
    label50:
    label83:
    Object localObject;
    if (!this.iZ)
    {
      this.iq.a(null);
      this.iQ.setTabContainer(this.iS);
      if (bZ() != 2) {
        break label165;
      }
      i = 1;
      if (this.iS != null)
      {
        if (i == 0) {
          break label170;
        }
        this.iS.setVisibility(0);
        if (this.iP != null) {
          z.ak(this.iP);
        }
      }
      localObject = this.iq;
      if ((this.iZ) || (i == 0)) {
        break label182;
      }
      paramBoolean = true;
      label102:
      ((n)localObject).setCollapsible(paramBoolean);
      localObject = this.iP;
      if ((this.iZ) || (i == 0)) {
        break label187;
      }
    }
    label165:
    label170:
    label182:
    label187:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((ActionBarOverlayLayout)localObject).setHasNonEmbeddedTabs(paramBoolean);
      AppMethodBeat.o(200606);
      return;
      this.iQ.setTabContainer(null);
      this.iq.a(this.iS);
      break;
      i = 0;
      break label50;
      this.iS.setVisibility(8);
      break label83;
      paramBoolean = false;
      break label102;
    }
  }
  
  private void E(boolean paramBoolean)
  {
    AppMethodBeat.i(200653);
    if (b(this.jc, this.jd, this.je))
    {
      if (!this.jf)
      {
        this.jf = true;
        F(paramBoolean);
        AppMethodBeat.o(200653);
      }
    }
    else if (this.jf)
    {
      this.jf = false;
      G(paramBoolean);
    }
    AppMethodBeat.o(200653);
  }
  
  private void F(boolean paramBoolean)
  {
    AppMethodBeat.i(200669);
    if (this.jg != null) {
      this.jg.cancel();
    }
    this.iQ.setVisibility(0);
    if ((this.ja == 0) && ((this.jh) || (paramBoolean)))
    {
      this.iQ.setTranslationY(0.0F);
      float f2 = -this.iQ.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp76_74 = localObject;
        tmp76_74[0] = 0;
        Object tmp80_76 = tmp76_74;
        tmp80_76[1] = 0;
        tmp80_76;
        this.iQ.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      this.iQ.setTranslationY(f1);
      Object localObject = new androidx.appcompat.view.h();
      ad localad = z.ac(this.iQ).ap(0.0F);
      localad.a(this.jl);
      ((androidx.appcompat.view.h)localObject).a(localad);
      if ((this.jb) && (this.mContentView != null))
      {
        this.mContentView.setTranslationY(f1);
        ((androidx.appcompat.view.h)localObject).a(z.ac(this.mContentView).ap(0.0F));
      }
      ((androidx.appcompat.view.h)localObject).b(iN);
      ((androidx.appcompat.view.h)localObject).cA();
      ((androidx.appcompat.view.h)localObject).a(this.jk);
      this.jg = ((androidx.appcompat.view.h)localObject);
      ((androidx.appcompat.view.h)localObject).start();
    }
    for (;;)
    {
      if (this.iP != null) {
        z.ak(this.iP);
      }
      AppMethodBeat.o(200669);
      return;
      this.iQ.setAlpha(1.0F);
      this.iQ.setTranslationY(0.0F);
      if ((this.jb) && (this.mContentView != null)) {
        this.mContentView.setTranslationY(0.0F);
      }
      this.jk.f(null);
    }
  }
  
  private void G(boolean paramBoolean)
  {
    AppMethodBeat.i(200680);
    if (this.jg != null) {
      this.jg.cancel();
    }
    if ((this.ja == 0) && ((this.jh) || (paramBoolean)))
    {
      this.iQ.setAlpha(1.0F);
      this.iQ.setTransitioning(true);
      androidx.appcompat.view.h localh = new androidx.appcompat.view.h();
      float f2 = -this.iQ.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp86_84 = localObject;
        tmp86_84[0] = 0;
        Object tmp90_86 = tmp86_84;
        tmp90_86[1] = 0;
        tmp90_86;
        this.iQ.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = z.ac(this.iQ).ap(f1);
      ((ad)localObject).a(this.jl);
      localh.a((ad)localObject);
      if ((this.jb) && (this.mContentView != null)) {
        localh.a(z.ac(this.mContentView).ap(f1));
      }
      localh.b(iM);
      localh.cA();
      localh.a(this.jj);
      this.jg = localh;
      localh.start();
      AppMethodBeat.o(200680);
      return;
    }
    this.jj.f(null);
    AppMethodBeat.o(200680);
  }
  
  static boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private int bZ()
  {
    AppMethodBeat.i(200623);
    int i = this.iq.bZ();
    AppMethodBeat.o(200623);
    return i;
  }
  
  private void ca()
  {
    AppMethodBeat.i(200633);
    if (!this.je)
    {
      this.je = true;
      if (this.iP != null) {
        this.iP.setShowingForActionMode(true);
      }
      E(false);
    }
    AppMethodBeat.o(200633);
  }
  
  private void cc()
  {
    AppMethodBeat.i(200640);
    if (this.je)
    {
      this.je = false;
      if (this.iP != null) {
        this.iP.setShowingForActionMode(false);
      }
      E(false);
    }
    AppMethodBeat.o(200640);
  }
  
  private void g(View paramView)
  {
    AppMethodBeat.i(200585);
    this.iP = ((ActionBarOverlayLayout)paramView.findViewById(a.f.decor_content_parent));
    if (this.iP != null) {
      this.iP.setActionBarVisibilityCallback(this);
    }
    this.iq = h(paramView.findViewById(a.f.action_bar));
    this.iR = ((ActionBarContextView)paramView.findViewById(a.f.action_context_bar));
    this.iQ = ((ActionBarContainer)paramView.findViewById(a.f.action_bar_container));
    if ((this.iq == null) || (this.iR == null) || (this.iQ == null))
    {
      paramView = new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
      AppMethodBeat.o(200585);
      throw paramView;
    }
    this.mContext = this.iq.getContext();
    if ((this.iq.bu() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.iV = true;
      }
      paramView = a.I(this.mContext);
      paramView.ct();
      C(paramView.cs());
      paramView = this.mContext.obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
      if (paramView.getBoolean(a.j.ActionBar_hideOnContentScroll, false)) {
        setHideOnContentScrollEnabled(true);
      }
      i = paramView.getDimensionPixelSize(a.j.ActionBar_elevation, 0);
      if (i != 0) {
        g(i);
      }
      paramView.recycle();
      AppMethodBeat.o(200585);
      return;
    }
  }
  
  private static n h(View paramView)
  {
    AppMethodBeat.i(200592);
    if ((paramView instanceof n))
    {
      paramView = (n)paramView;
      AppMethodBeat.o(200592);
      return paramView;
    }
    if ((paramView instanceof Toolbar))
    {
      paramView = ((Toolbar)paramView).getWrapper();
      AppMethodBeat.o(200592);
      return paramView;
    }
    StringBuilder localStringBuilder = new StringBuilder("Can't make a decor toolbar out of ");
    if (paramView != null) {}
    for (paramView = paramView.getClass().getSimpleName();; paramView = "null")
    {
      paramView = new IllegalStateException(paramView);
      AppMethodBeat.o(200592);
      throw paramView;
    }
  }
  
  private void k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200615);
    int i = this.iq.bu();
    if ((paramInt2 & 0x4) != 0) {
      this.iV = true;
    }
    this.iq.M(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    AppMethodBeat.o(200615);
  }
  
  public final void A(boolean paramBoolean)
  {
    AppMethodBeat.i(200732);
    this.jh = paramBoolean;
    if ((!paramBoolean) && (this.jg != null)) {
      this.jg.cancel();
    }
    AppMethodBeat.o(200732);
  }
  
  public final void B(boolean paramBoolean)
  {
    AppMethodBeat.i(200745);
    if (paramBoolean == this.iu)
    {
      AppMethodBeat.o(200745);
      return;
    }
    this.iu = paramBoolean;
    int j = this.iw.size();
    int i = 0;
    while (i < j)
    {
      this.iw.get(i);
      i += 1;
    }
    AppMethodBeat.o(200745);
  }
  
  public final void D(boolean paramBoolean)
  {
    this.jb = paramBoolean;
  }
  
  public final void H(boolean paramBoolean)
  {
    AppMethodBeat.i(200945);
    ad localad1;
    ad localad2;
    if (paramBoolean)
    {
      ca();
      if (!z.au(this.iQ)) {
        break label120;
      }
      if (!paramBoolean) {
        break label90;
      }
      localad1 = this.iq.b(4, 100L);
      localad2 = this.iR.b(0, 200L);
    }
    for (;;)
    {
      androidx.appcompat.view.h localh = new androidx.appcompat.view.h();
      localh.a(localad1, localad2);
      localh.start();
      AppMethodBeat.o(200945);
      return;
      cc();
      break;
      label90:
      localad2 = this.iq.b(0, 200L);
      localad1 = this.iR.b(8, 100L);
    }
    label120:
    if (paramBoolean)
    {
      this.iq.setVisibility(4);
      this.iR.setVisibility(0);
      AppMethodBeat.o(200945);
      return;
    }
    this.iq.setVisibility(0);
    this.iR.setVisibility(8);
    AppMethodBeat.o(200945);
  }
  
  public final void L(int paramInt)
  {
    AppMethodBeat.i(200756);
    setCustomView(LayoutInflater.from(bw()).inflate(paramInt, this.iq.eD(), false));
    AppMethodBeat.o(200756);
  }
  
  public final void M(int paramInt)
  {
    AppMethodBeat.i(200821);
    if ((paramInt & 0x4) != 0) {
      this.iV = true;
    }
    this.iq.M(paramInt);
    AppMethodBeat.o(200821);
  }
  
  public final b a(b.a parama)
  {
    AppMethodBeat.i(200863);
    if (this.iW != null) {
      this.iW.finish();
    }
    this.iP.setHideOnContentScrollEnabled(false);
    this.iR.dy();
    parama = new a(this.iR.getContext(), parama);
    if (parama.cg())
    {
      this.iW = parama;
      parama.invalidate();
      this.iR.c(parama);
      H(true);
      this.iR.sendAccessibilityEvent(32);
      AppMethodBeat.o(200863);
      return parama;
    }
    AppMethodBeat.o(200863);
    return null;
  }
  
  public final void a(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(201000);
    paramView.setLayoutParams(paramLayoutParams);
    this.iq.setCustomView(paramView);
    AppMethodBeat.o(201000);
  }
  
  public final int bu()
  {
    AppMethodBeat.i(200851);
    int i = this.iq.bu();
    AppMethodBeat.o(200851);
    return i;
  }
  
  public final Context bw()
  {
    AppMethodBeat.i(200953);
    Object localObject;
    int i;
    if (this.iO == null)
    {
      localObject = new TypedValue();
      this.mContext.getTheme().resolveAttribute(a.a.actionBarWidgetTheme, (TypedValue)localObject, true);
      i = ((TypedValue)localObject).resourceId;
      if (i == 0) {
        break label75;
      }
    }
    label75:
    for (this.iO = new ContextThemeWrapper(this.mContext, i);; this.iO = this.mContext)
    {
      localObject = this.iO;
      AppMethodBeat.o(200953);
      return localObject;
    }
  }
  
  public final void cb()
  {
    AppMethodBeat.i(200896);
    if (this.jd)
    {
      this.jd = false;
      E(true);
    }
    AppMethodBeat.o(200896);
  }
  
  public final void cd()
  {
    AppMethodBeat.i(200911);
    if (!this.jd)
    {
      this.jd = true;
      E(true);
    }
    AppMethodBeat.o(200911);
  }
  
  public final void ce()
  {
    AppMethodBeat.i(200967);
    if (this.jg != null)
    {
      this.jg.cancel();
      this.jg = null;
    }
    AppMethodBeat.o(200967);
  }
  
  public final boolean collapseActionView()
  {
    AppMethodBeat.i(200982);
    if ((this.iq != null) && (this.iq.eE()))
    {
      this.iq.eF();
      AppMethodBeat.o(200982);
      return true;
    }
    AppMethodBeat.o(200982);
    return false;
  }
  
  public final void g(float paramFloat)
  {
    AppMethodBeat.i(200699);
    z.k(this.iQ, paramFloat);
    AppMethodBeat.o(200699);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(200837);
    View localView = this.iq.getCustomView();
    AppMethodBeat.o(200837);
    return localView;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(200871);
    int i = this.iQ.getHeight();
    AppMethodBeat.o(200871);
    return i;
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(200845);
    CharSequence localCharSequence = this.iq.getTitle();
    AppMethodBeat.o(200845);
    return localCharSequence;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(200903);
    if (!this.jc)
    {
      this.jc = true;
      E(false);
    }
    AppMethodBeat.o(200903);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(200932);
    int i = this.iQ.getHeight();
    if ((this.jf) && ((i == 0) || (this.iP.getActionBarHideOffset() < i)))
    {
      AppMethodBeat.o(200932);
      return true;
    }
    AppMethodBeat.o(200932);
    return false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(200710);
    C(a.I(this.mContext).cs());
    AppMethodBeat.o(200710);
  }
  
  public final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(201035);
    if (this.iW == null)
    {
      AppMethodBeat.o(201035);
      return false;
    }
    androidx.appcompat.view.menu.h localh = this.iW.jo;
    if (localh != null)
    {
      int i;
      if (paramKeyEvent != null)
      {
        i = paramKeyEvent.getDeviceId();
        if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
          break label93;
        }
      }
      label93:
      for (boolean bool = true;; bool = false)
      {
        localh.setQwertyMode(bool);
        bool = localh.performShortcut(paramInt, paramKeyEvent, 0);
        AppMethodBeat.o(201035);
        return bool;
        i = -1;
        break;
      }
    }
    AppMethodBeat.o(201035);
    return false;
  }
  
  public final void onWindowVisibilityChanged(int paramInt)
  {
    this.ja = paramInt;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(200828);
    this.iQ.setPrimaryBackground(paramDrawable);
    AppMethodBeat.o(200828);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(200990);
    this.iq.setCustomView(paramView);
    AppMethodBeat.o(200990);
  }
  
  public final void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(200920);
    if ((paramBoolean) && (!this.iP.pl))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
      AppMethodBeat.o(200920);
      throw localIllegalStateException;
    }
    this.ji = paramBoolean;
    this.iP.setHideOnContentScrollEnabled(paramBoolean);
    AppMethodBeat.o(200920);
  }
  
  public final void setIcon(int paramInt)
  {
    AppMethodBeat.i(201009);
    this.iq.setIcon(paramInt);
    AppMethodBeat.o(201009);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(201019);
    this.iq.setLogo(paramDrawable);
    AppMethodBeat.o(201019);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200810);
    this.iq.setWindowTitle(paramCharSequence);
    AppMethodBeat.o(200810);
  }
  
  public final void show()
  {
    AppMethodBeat.i(200886);
    if (this.jc)
    {
      this.jc = false;
      E(false);
    }
    AppMethodBeat.o(200886);
  }
  
  public final void v(boolean paramBoolean)
  {
    AppMethodBeat.i(200765);
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      k(i, 2);
      AppMethodBeat.o(200765);
      return;
    }
  }
  
  public final void w(boolean paramBoolean)
  {
    AppMethodBeat.i(200778);
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      k(i, 4);
      AppMethodBeat.o(200778);
      return;
    }
  }
  
  public final void x(boolean paramBoolean)
  {
    AppMethodBeat.i(200785);
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      k(i, 8);
      AppMethodBeat.o(200785);
      return;
    }
  }
  
  public final void y(boolean paramBoolean)
  {
    AppMethodBeat.i(200799);
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      k(i, 16);
      AppMethodBeat.o(200799);
      return;
    }
  }
  
  public final void z(boolean paramBoolean)
  {
    AppMethodBeat.i(201030);
    if (!this.iV) {
      w(paramBoolean);
    }
    AppMethodBeat.o(201030);
  }
  
  public final class a
    extends b
    implements h.a
  {
    private final Context jn;
    final androidx.appcompat.view.menu.h jo;
    private b.a jp;
    private WeakReference<View> jq;
    
    public a(Context paramContext, b.a parama)
    {
      AppMethodBeat.i(200345);
      this.jn = paramContext;
      this.jp = parama;
      this$1 = new androidx.appcompat.view.menu.h(paramContext);
      j.this.nF = 1;
      this.jo = j.this;
      this.jo.a(this);
      AppMethodBeat.o(200345);
    }
    
    public final void a(androidx.appcompat.view.menu.h paramh)
    {
      AppMethodBeat.i(200483);
      if (this.jp == null)
      {
        AppMethodBeat.o(200483);
        return;
      }
      invalidate();
      j.this.iR.dv();
      AppMethodBeat.o(200483);
    }
    
    public final boolean a(androidx.appcompat.view.menu.h paramh, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(200473);
      if (this.jp != null)
      {
        boolean bool = this.jp.a(this, paramMenuItem);
        AppMethodBeat.o(200473);
        return bool;
      }
      AppMethodBeat.o(200473);
      return false;
    }
    
    public final boolean cg()
    {
      AppMethodBeat.i(200388);
      this.jo.cX();
      try
      {
        boolean bool = this.jp.a(this, this.jo);
        return bool;
      }
      finally
      {
        this.jo.cY();
        AppMethodBeat.o(200388);
      }
    }
    
    public final void finish()
    {
      AppMethodBeat.i(200369);
      if (j.this.iW != this)
      {
        AppMethodBeat.o(200369);
        return;
      }
      if (!j.b(j.this.jc, j.this.jd, false))
      {
        j.this.iX = this;
        j.this.iY = this.jp;
      }
      for (;;)
      {
        this.jp = null;
        j.this.H(false);
        j.this.iR.dx();
        j.this.iq.eD().sendAccessibilityEvent(32);
        j.this.iP.setHideOnContentScrollEnabled(j.this.ji);
        j.this.iW = null;
        AppMethodBeat.o(200369);
        return;
        this.jp.a(this);
      }
    }
    
    public final View getCustomView()
    {
      AppMethodBeat.i(200466);
      if (this.jq != null)
      {
        View localView = (View)this.jq.get();
        AppMethodBeat.o(200466);
        return localView;
      }
      AppMethodBeat.o(200466);
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.jo;
    }
    
    public final MenuInflater getMenuInflater()
    {
      AppMethodBeat.i(200353);
      g localg = new g(this.jn);
      AppMethodBeat.o(200353);
      return localg;
    }
    
    public final CharSequence getSubtitle()
    {
      AppMethodBeat.i(200444);
      CharSequence localCharSequence = j.this.iR.getSubtitle();
      AppMethodBeat.o(200444);
      return localCharSequence;
    }
    
    public final CharSequence getTitle()
    {
      AppMethodBeat.i(200438);
      CharSequence localCharSequence = j.this.iR.getTitle();
      AppMethodBeat.o(200438);
      return localCharSequence;
    }
    
    public final void invalidate()
    {
      AppMethodBeat.i(200376);
      if (j.this.iW != this)
      {
        AppMethodBeat.o(200376);
        return;
      }
      this.jo.cX();
      try
      {
        this.jp.b(this, this.jo);
        return;
      }
      finally
      {
        this.jo.cY();
        AppMethodBeat.o(200376);
      }
    }
    
    public final boolean isTitleOptional()
    {
      return j.this.iR.pb;
    }
    
    public final void setCustomView(View paramView)
    {
      AppMethodBeat.i(200396);
      j.this.iR.setCustomView(paramView);
      this.jq = new WeakReference(paramView);
      AppMethodBeat.o(200396);
    }
    
    public final void setSubtitle(int paramInt)
    {
      AppMethodBeat.i(200428);
      setSubtitle(j.this.mContext.getResources().getString(paramInt));
      AppMethodBeat.o(200428);
    }
    
    public final void setSubtitle(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(200407);
      j.this.iR.setSubtitle(paramCharSequence);
      AppMethodBeat.o(200407);
    }
    
    public final void setTitle(int paramInt)
    {
      AppMethodBeat.i(200420);
      setTitle(j.this.mContext.getResources().getString(paramInt));
      AppMethodBeat.o(200420);
    }
    
    public final void setTitle(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(200413);
      j.this.iR.setTitle(paramCharSequence);
      AppMethodBeat.o(200413);
    }
    
    public final void setTitleOptionalHint(boolean paramBoolean)
    {
      AppMethodBeat.i(200452);
      super.setTitleOptionalHint(paramBoolean);
      j.this.iR.setTitleOptional(paramBoolean);
      AppMethodBeat.o(200452);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.app.j
 * JD-Core Version:    0.7.0.1
 */