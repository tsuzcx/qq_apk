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
import androidx.core.g.aa;
import androidx.core.g.ab;
import androidx.core.g.ac;
import androidx.core.g.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class j
  extends ActionBar
  implements ActionBarOverlayLayout.a
{
  private static final Interpolator hO;
  private static final Interpolator hP;
  private Context hQ;
  ActionBarOverlayLayout hR;
  ActionBarContainer hS;
  ActionBarContextView hT;
  androidx.appcompat.widget.w hU;
  private ArrayList<Object> hV;
  private int hW;
  private boolean hX;
  a hY;
  b hZ;
  n ht;
  private boolean hx;
  private ArrayList<Object> hy;
  b.a ia;
  private boolean ib;
  private int ic;
  boolean ie;
  boolean jdField_if;
  boolean ig;
  private boolean ih;
  private boolean ii;
  androidx.appcompat.view.h ij;
  private boolean ik;
  boolean il;
  final ab im;
  final ab in;
  final ad io;
  private Activity mActivity;
  View mContentView;
  Context mContext;
  private Dialog mDialog;
  
  static
  {
    AppMethodBeat.i(238610);
    if (!j.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      hO = new AccelerateInterpolator();
      hP = new DecelerateInterpolator();
      AppMethodBeat.o(238610);
      return;
    }
  }
  
  public j(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(238540);
    this.hV = new ArrayList();
    this.hW = -1;
    this.hy = new ArrayList();
    this.ic = 0;
    this.ie = true;
    this.ii = true;
    this.im = new ac()
    {
      public final void f(View paramAnonymousView)
      {
        AppMethodBeat.i(238500);
        if ((j.this.ie) && (j.this.mContentView != null))
        {
          j.this.mContentView.setTranslationY(0.0F);
          j.this.hS.setTranslationY(0.0F);
        }
        j.this.hS.setVisibility(8);
        j.this.hS.setTransitioning(false);
        j.this.ij = null;
        paramAnonymousView = j.this;
        if (paramAnonymousView.ia != null)
        {
          paramAnonymousView.ia.a(paramAnonymousView.hZ);
          paramAnonymousView.hZ = null;
          paramAnonymousView.ia = null;
        }
        if (j.this.hR != null) {
          androidx.core.g.w.Y(j.this.hR);
        }
        AppMethodBeat.o(238500);
      }
    };
    this.in = new ac()
    {
      public final void f(View paramAnonymousView)
      {
        AppMethodBeat.i(238504);
        j.this.ij = null;
        j.this.hS.requestLayout();
        AppMethodBeat.o(238504);
      }
    };
    this.io = new ad()
    {
      public final void bm()
      {
        AppMethodBeat.i(238507);
        ((View)j.this.hS.getParent()).invalidate();
        AppMethodBeat.o(238507);
      }
    };
    this.mActivity = paramActivity;
    paramActivity = paramActivity.getWindow().getDecorView();
    g(paramActivity);
    if (!paramBoolean) {
      this.mContentView = paramActivity.findViewById(16908290);
    }
    AppMethodBeat.o(238540);
  }
  
  public j(Dialog paramDialog)
  {
    AppMethodBeat.i(238541);
    this.hV = new ArrayList();
    this.hW = -1;
    this.hy = new ArrayList();
    this.ic = 0;
    this.ie = true;
    this.ii = true;
    this.im = new ac()
    {
      public final void f(View paramAnonymousView)
      {
        AppMethodBeat.i(238500);
        if ((j.this.ie) && (j.this.mContentView != null))
        {
          j.this.mContentView.setTranslationY(0.0F);
          j.this.hS.setTranslationY(0.0F);
        }
        j.this.hS.setVisibility(8);
        j.this.hS.setTransitioning(false);
        j.this.ij = null;
        paramAnonymousView = j.this;
        if (paramAnonymousView.ia != null)
        {
          paramAnonymousView.ia.a(paramAnonymousView.hZ);
          paramAnonymousView.hZ = null;
          paramAnonymousView.ia = null;
        }
        if (j.this.hR != null) {
          androidx.core.g.w.Y(j.this.hR);
        }
        AppMethodBeat.o(238500);
      }
    };
    this.in = new ac()
    {
      public final void f(View paramAnonymousView)
      {
        AppMethodBeat.i(238504);
        j.this.ij = null;
        j.this.hS.requestLayout();
        AppMethodBeat.o(238504);
      }
    };
    this.io = new ad()
    {
      public final void bm()
      {
        AppMethodBeat.i(238507);
        ((View)j.this.hS.getParent()).invalidate();
        AppMethodBeat.o(238507);
      }
    };
    this.mDialog = paramDialog;
    g(paramDialog.getWindow().getDecorView());
    AppMethodBeat.o(238541);
  }
  
  private void A(boolean paramBoolean)
  {
    AppMethodBeat.i(238584);
    if (b(this.jdField_if, this.ig, this.ih))
    {
      if (!this.ii)
      {
        this.ii = true;
        B(paramBoolean);
        AppMethodBeat.o(238584);
      }
    }
    else if (this.ii)
    {
      this.ii = false;
      C(paramBoolean);
    }
    AppMethodBeat.o(238584);
  }
  
  private void B(boolean paramBoolean)
  {
    AppMethodBeat.i(238585);
    if (this.ij != null) {
      this.ij.cancel();
    }
    this.hS.setVisibility(0);
    if ((this.ic == 0) && ((this.ik) || (paramBoolean)))
    {
      this.hS.setTranslationY(0.0F);
      float f2 = -this.hS.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp76_74 = localObject;
        tmp76_74[0] = 0;
        Object tmp80_76 = tmp76_74;
        tmp80_76[1] = 0;
        tmp80_76;
        this.hS.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      this.hS.setTranslationY(f1);
      Object localObject = new androidx.appcompat.view.h();
      aa localaa = androidx.core.g.w.Q(this.hS).j(0.0F);
      localaa.a(this.io);
      ((androidx.appcompat.view.h)localObject).a(localaa);
      if ((this.ie) && (this.mContentView != null))
      {
        this.mContentView.setTranslationY(f1);
        ((androidx.appcompat.view.h)localObject).a(androidx.core.g.w.Q(this.mContentView).j(0.0F));
      }
      ((androidx.appcompat.view.h)localObject).a(hP);
      ((androidx.appcompat.view.h)localObject).bH();
      ((androidx.appcompat.view.h)localObject).a(this.in);
      this.ij = ((androidx.appcompat.view.h)localObject);
      ((androidx.appcompat.view.h)localObject).start();
    }
    for (;;)
    {
      if (this.hR != null) {
        androidx.core.g.w.Y(this.hR);
      }
      AppMethodBeat.o(238585);
      return;
      this.hS.setAlpha(1.0F);
      this.hS.setTranslationY(0.0F);
      if ((this.ie) && (this.mContentView != null)) {
        this.mContentView.setTranslationY(0.0F);
      }
      this.in.f(null);
    }
  }
  
  private void C(boolean paramBoolean)
  {
    AppMethodBeat.i(238586);
    if (this.ij != null) {
      this.ij.cancel();
    }
    if ((this.ic == 0) && ((this.ik) || (paramBoolean)))
    {
      this.hS.setAlpha(1.0F);
      this.hS.setTransitioning(true);
      androidx.appcompat.view.h localh = new androidx.appcompat.view.h();
      float f2 = -this.hS.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp86_84 = localObject;
        tmp86_84[0] = 0;
        Object tmp90_86 = tmp86_84;
        tmp90_86[1] = 0;
        tmp90_86;
        this.hS.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = androidx.core.g.w.Q(this.hS).j(f1);
      ((aa)localObject).a(this.io);
      localh.a((aa)localObject);
      if ((this.ie) && (this.mContentView != null)) {
        localh.a(androidx.core.g.w.Q(this.mContentView).j(f1));
      }
      localh.a(hO);
      localh.bH();
      localh.a(this.im);
      this.ij = localh;
      localh.start();
      AppMethodBeat.o(238586);
      return;
    }
    this.im.f(null);
    AppMethodBeat.o(238586);
  }
  
  static boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private int bg()
  {
    AppMethodBeat.i(238569);
    int i = this.ht.bg();
    AppMethodBeat.o(238569);
    return i;
  }
  
  private void bh()
  {
    AppMethodBeat.i(238576);
    if (!this.ih)
    {
      this.ih = true;
      if (this.hR != null) {
        this.hR.setShowingForActionMode(true);
      }
      A(false);
    }
    AppMethodBeat.o(238576);
  }
  
  private void bj()
  {
    AppMethodBeat.i(238579);
    if (this.ih)
    {
      this.ih = false;
      if (this.hR != null) {
        this.hR.setShowingForActionMode(false);
      }
      A(false);
    }
    AppMethodBeat.o(238579);
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238565);
    int i = this.ht.aC();
    if ((paramInt2 & 0x4) != 0) {
      this.hX = true;
    }
    this.ht.O(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    AppMethodBeat.o(238565);
  }
  
  private void g(View paramView)
  {
    AppMethodBeat.i(238543);
    this.hR = ((ActionBarOverlayLayout)paramView.findViewById(a.f.decor_content_parent));
    if (this.hR != null) {
      this.hR.setActionBarVisibilityCallback(this);
    }
    this.ht = h(paramView.findViewById(a.f.action_bar));
    this.hT = ((ActionBarContextView)paramView.findViewById(a.f.action_context_bar));
    this.hS = ((ActionBarContainer)paramView.findViewById(a.f.action_bar_container));
    if ((this.ht == null) || (this.hT == null) || (this.hS == null))
    {
      paramView = new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
      AppMethodBeat.o(238543);
      throw paramView;
    }
    this.mContext = this.ht.getContext();
    if ((this.ht.aC() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.hX = true;
      }
      paramView = a.I(this.mContext);
      paramView.bA();
      y(paramView.bz());
      paramView = this.mContext.obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
      if (paramView.getBoolean(a.j.ActionBar_hideOnContentScroll, false)) {
        setHideOnContentScrollEnabled(true);
      }
      i = paramView.getDimensionPixelSize(a.j.ActionBar_elevation, 0);
      if (i != 0) {
        e(i);
      }
      paramView.recycle();
      AppMethodBeat.o(238543);
      return;
    }
  }
  
  private static n h(View paramView)
  {
    AppMethodBeat.i(238547);
    if ((paramView instanceof n))
    {
      paramView = (n)paramView;
      AppMethodBeat.o(238547);
      return paramView;
    }
    if ((paramView instanceof Toolbar))
    {
      paramView = ((Toolbar)paramView).getWrapper();
      AppMethodBeat.o(238547);
      return paramView;
    }
    StringBuilder localStringBuilder = new StringBuilder("Can't make a decor toolbar out of ");
    if (paramView != null) {}
    for (paramView = paramView.getClass().getSimpleName();; paramView = "null")
    {
      paramView = new IllegalStateException(paramView);
      AppMethodBeat.o(238547);
      throw paramView;
    }
  }
  
  private void y(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(238553);
    this.ib = paramBoolean;
    int i;
    label51:
    label84:
    Object localObject;
    if (!this.ib)
    {
      this.ht.a(null);
      this.hS.setTabContainer(this.hU);
      if (bg() != 2) {
        break label167;
      }
      i = 1;
      if (this.hU != null)
      {
        if (i == 0) {
          break label172;
        }
        this.hU.setVisibility(0);
        if (this.hR != null) {
          androidx.core.g.w.Y(this.hR);
        }
      }
      localObject = this.ht;
      if ((this.ib) || (i == 0)) {
        break label184;
      }
      paramBoolean = true;
      label103:
      ((n)localObject).setCollapsible(paramBoolean);
      localObject = this.hR;
      if ((this.ib) || (i == 0)) {
        break label189;
      }
    }
    label167:
    label172:
    label184:
    label189:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((ActionBarOverlayLayout)localObject).setHasNonEmbeddedTabs(paramBoolean);
      AppMethodBeat.o(238553);
      return;
      this.hS.setTabContainer(null);
      this.ht.a(this.hU);
      break;
      i = 0;
      break label51;
      this.hU.setVisibility(8);
      break label84;
      paramBoolean = false;
      break label103;
    }
  }
  
  public final void D(boolean paramBoolean)
  {
    AppMethodBeat.i(238589);
    aa localaa1;
    aa localaa2;
    if (paramBoolean)
    {
      bh();
      if (!androidx.core.g.w.ah(this.hS)) {
        break label120;
      }
      if (!paramBoolean) {
        break label90;
      }
      localaa1 = this.ht.b(4, 100L);
      localaa2 = this.hT.b(0, 200L);
    }
    for (;;)
    {
      androidx.appcompat.view.h localh = new androidx.appcompat.view.h();
      localh.a(localaa1, localaa2);
      localh.start();
      AppMethodBeat.o(238589);
      return;
      bj();
      break;
      label90:
      localaa2 = this.ht.b(0, 200L);
      localaa1 = this.hT.b(8, 100L);
    }
    label120:
    if (paramBoolean)
    {
      this.ht.setVisibility(4);
      this.hT.setVisibility(0);
      AppMethodBeat.o(238589);
      return;
    }
    this.ht.setVisibility(0);
    this.hT.setVisibility(8);
    AppMethodBeat.o(238589);
  }
  
  public final void N(int paramInt)
  {
    AppMethodBeat.i(238556);
    setCustomView(LayoutInflater.from(aD()).inflate(paramInt, this.ht.dE(), false));
    AppMethodBeat.o(238556);
  }
  
  public final void O(int paramInt)
  {
    AppMethodBeat.i(238563);
    if ((paramInt & 0x4) != 0) {
      this.hX = true;
    }
    this.ht.O(paramInt);
    AppMethodBeat.o(238563);
  }
  
  public final b a(b.a parama)
  {
    AppMethodBeat.i(238571);
    if (this.hY != null) {
      this.hY.finish();
    }
    this.hR.setHideOnContentScrollEnabled(false);
    this.hT.cF();
    parama = new a(this.hT.getContext(), parama);
    if (parama.bn())
    {
      this.hY = parama;
      parama.invalidate();
      this.hT.c(parama);
      D(true);
      this.hT.sendAccessibilityEvent(32);
      AppMethodBeat.o(238571);
      return parama;
    }
    AppMethodBeat.o(238571);
    return null;
  }
  
  public final void a(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(238602);
    paramView.setLayoutParams(paramLayoutParams);
    this.ht.setCustomView(paramView);
    AppMethodBeat.o(238602);
  }
  
  public final int aC()
  {
    AppMethodBeat.i(238570);
    int i = this.ht.aC();
    AppMethodBeat.o(238570);
    return i;
  }
  
  public final Context aD()
  {
    AppMethodBeat.i(238592);
    Object localObject;
    int i;
    if (this.hQ == null)
    {
      localObject = new TypedValue();
      this.mContext.getTheme().resolveAttribute(a.a.actionBarWidgetTheme, (TypedValue)localObject, true);
      i = ((TypedValue)localObject).resourceId;
      if (i == 0) {
        break label75;
      }
    }
    label75:
    for (this.hQ = new ContextThemeWrapper(this.mContext, i);; this.hQ = this.mContext)
    {
      localObject = this.hQ;
      AppMethodBeat.o(238592);
      return localObject;
    }
  }
  
  public final void bi()
  {
    AppMethodBeat.i(238577);
    if (this.ig)
    {
      this.ig = false;
      A(true);
    }
    AppMethodBeat.o(238577);
  }
  
  public final void bk()
  {
    AppMethodBeat.i(238580);
    if (!this.ig)
    {
      this.ig = true;
      A(true);
    }
    AppMethodBeat.o(238580);
  }
  
  public final void bl()
  {
    AppMethodBeat.i(238594);
    if (this.ij != null)
    {
      this.ij.cancel();
      this.ij = null;
    }
    AppMethodBeat.o(238594);
  }
  
  public final boolean collapseActionView()
  {
    AppMethodBeat.i(238596);
    if ((this.ht != null) && (this.ht.dF()))
    {
      this.ht.dG();
      AppMethodBeat.o(238596);
      return true;
    }
    AppMethodBeat.o(238596);
    return false;
  }
  
  public final void e(float paramFloat)
  {
    AppMethodBeat.i(238550);
    androidx.core.g.w.j(this.hS, paramFloat);
    AppMethodBeat.o(238550);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(238567);
    View localView = this.ht.getCustomView();
    AppMethodBeat.o(238567);
    return localView;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(238572);
    int i = this.hS.getHeight();
    AppMethodBeat.o(238572);
    return i;
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(238568);
    CharSequence localCharSequence = this.ht.getTitle();
    AppMethodBeat.o(238568);
    return localCharSequence;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(238578);
    if (!this.jdField_if)
    {
      this.jdField_if = true;
      A(false);
    }
    AppMethodBeat.o(238578);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(238587);
    int i = this.hS.getHeight();
    if ((this.ii) && ((i == 0) || (this.hR.getActionBarHideOffset() < i)))
    {
      AppMethodBeat.o(238587);
      return true;
    }
    AppMethodBeat.o(238587);
    return false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(238552);
    y(a.I(this.mContext).bz());
    AppMethodBeat.o(238552);
  }
  
  public final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(238608);
    if (this.hY == null)
    {
      AppMethodBeat.o(238608);
      return false;
    }
    androidx.appcompat.view.menu.h localh = this.hY.is;
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
        AppMethodBeat.o(238608);
        return bool;
        i = -1;
        break;
      }
    }
    AppMethodBeat.o(238608);
    return false;
  }
  
  public final void onWindowVisibilityChanged(int paramInt)
  {
    this.ic = paramInt;
  }
  
  public final void r(boolean paramBoolean)
  {
    AppMethodBeat.i(238558);
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      f(i, 2);
      AppMethodBeat.o(238558);
      return;
    }
  }
  
  public final void s(boolean paramBoolean)
  {
    AppMethodBeat.i(238559);
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      f(i, 4);
      AppMethodBeat.o(238559);
      return;
    }
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(238566);
    this.hS.setPrimaryBackground(paramDrawable);
    AppMethodBeat.o(238566);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(238599);
    this.ht.setCustomView(paramView);
    AppMethodBeat.o(238599);
  }
  
  public final void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(238583);
    if ((paramBoolean) && (!this.hR.ol))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
      AppMethodBeat.o(238583);
      throw localIllegalStateException;
    }
    this.il = paramBoolean;
    this.hR.setHideOnContentScrollEnabled(paramBoolean);
    AppMethodBeat.o(238583);
  }
  
  public final void setIcon(int paramInt)
  {
    AppMethodBeat.i(238603);
    this.ht.setIcon(paramInt);
    AppMethodBeat.o(238603);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(238604);
    this.ht.setLogo(paramDrawable);
    AppMethodBeat.o(238604);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(238562);
    this.ht.setWindowTitle(paramCharSequence);
    AppMethodBeat.o(238562);
  }
  
  public final void show()
  {
    AppMethodBeat.i(238575);
    if (this.jdField_if)
    {
      this.jdField_if = false;
      A(false);
    }
    AppMethodBeat.o(238575);
  }
  
  public final void t(boolean paramBoolean)
  {
    AppMethodBeat.i(238560);
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      f(i, 8);
      AppMethodBeat.o(238560);
      return;
    }
  }
  
  public final void u(boolean paramBoolean)
  {
    AppMethodBeat.i(238561);
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      f(i, 16);
      AppMethodBeat.o(238561);
      return;
    }
  }
  
  public final void v(boolean paramBoolean)
  {
    AppMethodBeat.i(238606);
    if (!this.hX) {
      s(paramBoolean);
    }
    AppMethodBeat.o(238606);
  }
  
  public final void w(boolean paramBoolean)
  {
    AppMethodBeat.i(238554);
    this.ik = paramBoolean;
    if ((!paramBoolean) && (this.ij != null)) {
      this.ij.cancel();
    }
    AppMethodBeat.o(238554);
  }
  
  public final void x(boolean paramBoolean)
  {
    AppMethodBeat.i(238555);
    if (paramBoolean == this.hx)
    {
      AppMethodBeat.o(238555);
      return;
    }
    this.hx = paramBoolean;
    int j = this.hy.size();
    int i = 0;
    while (i < j)
    {
      this.hy.get(i);
      i += 1;
    }
    AppMethodBeat.o(238555);
  }
  
  public final void z(boolean paramBoolean)
  {
    this.ie = paramBoolean;
  }
  
  public final class a
    extends b
    implements h.a
  {
    private final Context ir;
    final androidx.appcompat.view.menu.h is;
    private b.a it;
    private WeakReference<View> iu;
    
    public a(Context paramContext, b.a parama)
    {
      AppMethodBeat.i(238512);
      this.ir = paramContext;
      this.it = parama;
      this$1 = new androidx.appcompat.view.menu.h(paramContext);
      j.this.mG = 1;
      this.is = j.this;
      this.is.a(this);
      AppMethodBeat.o(238512);
    }
    
    public final void a(androidx.appcompat.view.menu.h paramh)
    {
      AppMethodBeat.i(238536);
      if (this.it == null)
      {
        AppMethodBeat.o(238536);
        return;
      }
      invalidate();
      j.this.hT.cC();
      AppMethodBeat.o(238536);
    }
    
    public final boolean a(androidx.appcompat.view.menu.h paramh, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(238534);
      if (this.it != null)
      {
        boolean bool = this.it.a(this, paramMenuItem);
        AppMethodBeat.o(238534);
        return bool;
      }
      AppMethodBeat.o(238534);
      return false;
    }
    
    public final boolean bn()
    {
      AppMethodBeat.i(238519);
      this.is.ce();
      try
      {
        boolean bool = this.it.a(this, this.is);
        return bool;
      }
      finally
      {
        this.is.cf();
        AppMethodBeat.o(238519);
      }
    }
    
    public final void finish()
    {
      AppMethodBeat.i(238514);
      if (j.this.hY != this)
      {
        AppMethodBeat.o(238514);
        return;
      }
      if (!j.b(j.this.jdField_if, j.this.ig, false))
      {
        j.this.hZ = this;
        j.this.ia = this.it;
      }
      for (;;)
      {
        this.it = null;
        j.this.D(false);
        j.this.hT.cE();
        j.this.ht.dE().sendAccessibilityEvent(32);
        j.this.hR.setHideOnContentScrollEnabled(j.this.il);
        j.this.hY = null;
        AppMethodBeat.o(238514);
        return;
        this.it.a(this);
      }
    }
    
    public final View getCustomView()
    {
      AppMethodBeat.i(238533);
      if (this.iu != null)
      {
        View localView = (View)this.iu.get();
        AppMethodBeat.o(238533);
        return localView;
      }
      AppMethodBeat.o(238533);
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.is;
    }
    
    public final MenuInflater getMenuInflater()
    {
      AppMethodBeat.i(238513);
      g localg = new g(this.ir);
      AppMethodBeat.o(238513);
      return localg;
    }
    
    public final CharSequence getSubtitle()
    {
      AppMethodBeat.i(238530);
      CharSequence localCharSequence = j.this.hT.getSubtitle();
      AppMethodBeat.o(238530);
      return localCharSequence;
    }
    
    public final CharSequence getTitle()
    {
      AppMethodBeat.i(238529);
      CharSequence localCharSequence = j.this.hT.getTitle();
      AppMethodBeat.o(238529);
      return localCharSequence;
    }
    
    public final void invalidate()
    {
      AppMethodBeat.i(238516);
      if (j.this.hY != this)
      {
        AppMethodBeat.o(238516);
        return;
      }
      this.is.ce();
      try
      {
        this.it.b(this, this.is);
        return;
      }
      finally
      {
        this.is.cf();
        AppMethodBeat.o(238516);
      }
    }
    
    public final boolean isTitleOptional()
    {
      return j.this.hT.oc;
    }
    
    public final void setCustomView(View paramView)
    {
      AppMethodBeat.i(238522);
      j.this.hT.setCustomView(paramView);
      this.iu = new WeakReference(paramView);
      AppMethodBeat.o(238522);
    }
    
    public final void setSubtitle(int paramInt)
    {
      AppMethodBeat.i(238528);
      setSubtitle(j.this.mContext.getResources().getString(paramInt));
      AppMethodBeat.o(238528);
    }
    
    public final void setSubtitle(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(238524);
      j.this.hT.setSubtitle(paramCharSequence);
      AppMethodBeat.o(238524);
    }
    
    public final void setTitle(int paramInt)
    {
      AppMethodBeat.i(238527);
      setTitle(j.this.mContext.getResources().getString(paramInt));
      AppMethodBeat.o(238527);
    }
    
    public final void setTitle(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(238525);
      j.this.hT.setTitle(paramCharSequence);
      AppMethodBeat.o(238525);
    }
    
    public final void setTitleOptionalHint(boolean paramBoolean)
    {
      AppMethodBeat.i(238532);
      super.setTitleOptionalHint(paramBoolean);
      j.this.hT.setTitleOptional(paramBoolean);
      AppMethodBeat.o(238532);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.app.j
 * JD-Core Version:    0.7.0.1
 */