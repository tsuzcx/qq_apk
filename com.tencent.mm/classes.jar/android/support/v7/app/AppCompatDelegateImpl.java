package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.q;
import android.support.v4.view.ab;
import android.support.v4.view.e.a;
import android.support.v4.view.x;
import android.support.v4.view.z;
import android.support.v4.widget.n;
import android.support.v7.c.a.a;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.view.f.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.o.a;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.aa;
import android.support.v7.widget.aa.a;
import android.support.v7.widget.az;
import android.support.v7.widget.be;
import android.support.v7.widget.bh;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.reflect.Constructor;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

final class AppCompatDelegateImpl
  extends d
  implements h.a, LayoutInflater.Factory2
{
  private static final boolean Wu;
  private static final int[] Wv;
  private static boolean Ww;
  private CharSequence Fm;
  final Window UX;
  private TextView Vw;
  MenuInflater WA;
  private android.support.v7.widget.t WB;
  private b WC;
  private g WD;
  b WE;
  ActionBarContextView WF;
  PopupWindow WG;
  Runnable WH;
  x WI = null;
  boolean WJ = true;
  private boolean WK;
  private ViewGroup WL;
  private View WM;
  private boolean WN;
  private boolean WO;
  boolean WP;
  boolean WQ;
  boolean WR;
  boolean WS;
  boolean WT;
  private boolean WU;
  private PanelFeatureState[] WV;
  private PanelFeatureState WW;
  private boolean WX;
  private int WY = -100;
  private boolean WZ;
  final Window.Callback Wx;
  final Window.Callback Wy;
  final c Wz;
  private e Xa;
  boolean Xb;
  int Xc;
  private final Runnable Xd = new Runnable()
  {
    public final void run()
    {
      if ((AppCompatDelegateImpl.this.Xc & 0x1) != 0) {
        AppCompatDelegateImpl.this.bj(0);
      }
      if ((AppCompatDelegateImpl.this.Xc & 0x1000) != 0) {
        AppCompatDelegateImpl.this.bj(108);
      }
      AppCompatDelegateImpl.this.Xb = false;
      AppCompatDelegateImpl.this.Xc = 0;
    }
  };
  private boolean Xe;
  private Rect Xf;
  private Rect Xg;
  private AppCompatViewInflater Xh;
  ActionBar mActionBar;
  final Context mContext;
  boolean mIsDestroyed;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      Wu = bool;
      Wv = new int[] { 16842836 };
      if ((Wu) && (!Ww))
      {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
          public final void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
          {
            int j = 0;
            int i = j;
            Object localObject;
            if ((paramAnonymousThrowable instanceof Resources.NotFoundException))
            {
              localObject = paramAnonymousThrowable.getMessage();
              i = j;
              if (localObject != null) {
                if (!((String)localObject).contains("drawable"))
                {
                  i = j;
                  if (!((String)localObject).contains("Drawable")) {}
                }
                else
                {
                  i = 1;
                }
              }
            }
            if (i != 0)
            {
              localObject = new Resources.NotFoundException(paramAnonymousThrowable.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
              ((Throwable)localObject).initCause(paramAnonymousThrowable.getCause());
              ((Throwable)localObject).setStackTrace(paramAnonymousThrowable.getStackTrace());
              this.Xi.uncaughtException(paramAnonymousThread, (Throwable)localObject);
              return;
            }
            this.Xi.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
          }
        });
        Ww = true;
      }
      return;
    }
  }
  
  AppCompatDelegateImpl(Context paramContext, Window paramWindow, c paramc)
  {
    this.mContext = paramContext;
    this.UX = paramWindow;
    this.Wz = paramc;
    this.Wx = this.UX.getCallback();
    if ((this.Wx instanceof d)) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    this.Wy = new d(this.Wx);
    this.UX.setCallback(this.Wy);
    paramContext = az.a(paramContext, null, Wv);
    paramWindow = paramContext.da(0);
    if (paramWindow != null) {
      this.UX.setBackgroundDrawable(paramWindow);
    }
    paramContext.awJ.recycle();
  }
  
  private View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    String str;
    boolean bool;
    if (this.Xh == null)
    {
      str = this.mContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme).getString(110);
      if ((str == null) || (AppCompatViewInflater.class.getName().equals(str))) {
        this.Xh = new AppCompatViewInflater();
      }
    }
    else
    {
      if (!Wu) {
        break label192;
      }
      if (!(paramAttributeSet instanceof XmlPullParser)) {
        break label179;
      }
      if (((XmlPullParser)paramAttributeSet).getDepth() <= 1) {
        break label173;
      }
      bool = true;
    }
    for (;;)
    {
      for (;;)
      {
        return this.Xh.createView(paramView, paramString, paramContext, paramAttributeSet, bool, Wu, true, be.mQ());
        try
        {
          this.Xh = ((AppCompatViewInflater)Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        catch (Throwable localThrowable)
        {
          new StringBuilder("Failed to instantiate custom view inflater ").append(str).append(". Falling back to default.");
          this.Xh = new AppCompatViewInflater();
        }
      }
      break;
      label173:
      bool = false;
      continue;
      label179:
      bool = a((ViewParent)paramView);
      continue;
      label192:
      bool = false;
    }
  }
  
  private void a(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    int j = -1;
    if ((paramPanelFeatureState.Tz) || (this.mIsDestroyed)) {}
    int i;
    Object localObject;
    label90:
    label95:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramPanelFeatureState.Xs == 0) {
            if ((this.mContext.getResources().getConfiguration().screenLayout & 0xF) != 4) {
              break label90;
            }
          }
          for (i = 1; i == 0; i = 0)
          {
            localObject = this.UX.getCallback();
            if ((localObject == null) || (((Window.Callback)localObject).onMenuOpened(paramPanelFeatureState.Xs, paramPanelFeatureState.iL))) {
              break label95;
            }
            a(paramPanelFeatureState, true);
            return;
          }
        }
        localObject = (WindowManager)this.mContext.getSystemService("window");
      } while ((localObject == null) || (!b(paramPanelFeatureState, paramKeyEvent)));
      if ((paramPanelFeatureState.Xt != null) && (!paramPanelFeatureState.XB)) {
        break label370;
      }
      if (paramPanelFeatureState.Xt != null) {
        break;
      }
      a(paramPanelFeatureState);
    } while (paramPanelFeatureState.Xt == null);
    label158:
    if ((c(paramPanelFeatureState)) && (paramPanelFeatureState.gs()))
    {
      paramKeyEvent = paramPanelFeatureState.Xu.getLayoutParams();
      if (paramKeyEvent != null) {
        break label406;
      }
      paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
    }
    label406:
    for (;;)
    {
      i = paramPanelFeatureState.background;
      paramPanelFeatureState.Xt.setBackgroundResource(i);
      ViewParent localViewParent = paramPanelFeatureState.Xu.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeView(paramPanelFeatureState.Xu);
      }
      paramPanelFeatureState.Xt.addView(paramPanelFeatureState.Xu, paramKeyEvent);
      if (!paramPanelFeatureState.Xu.hasFocus()) {
        paramPanelFeatureState.Xu.requestFocus();
      }
      i = -2;
      for (;;)
      {
        paramPanelFeatureState.Xz = false;
        paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.x, paramPanelFeatureState.y, 1002, 8519680, -3);
        paramKeyEvent.gravity = paramPanelFeatureState.gravity;
        paramKeyEvent.windowAnimations = paramPanelFeatureState.windowAnimations;
        ((WindowManager)localObject).addView(paramPanelFeatureState.Xt, paramKeyEvent);
        paramPanelFeatureState.Tz = true;
        return;
        if ((!paramPanelFeatureState.XB) || (paramPanelFeatureState.Xt.getChildCount() <= 0)) {
          break label158;
        }
        paramPanelFeatureState.Xt.removeAllViews();
        break label158;
        break;
        label370:
        if (paramPanelFeatureState.Xv != null)
        {
          paramKeyEvent = paramPanelFeatureState.Xv.getLayoutParams();
          if (paramKeyEvent != null)
          {
            i = j;
            if (paramKeyEvent.width == -1) {
              continue;
            }
          }
        }
        i = -2;
      }
    }
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.X(gg());
    paramPanelFeatureState.Xt = new f(paramPanelFeatureState.Xx);
    paramPanelFeatureState.gravity = 81;
    return true;
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.isSystem()) {}
    while (((!paramPanelFeatureState.Xy) && (!b(paramPanelFeatureState, paramKeyEvent))) || (paramPanelFeatureState.iL == null)) {
      return false;
    }
    return paramPanelFeatureState.iL.performShortcut(paramInt, paramKeyEvent, 1);
  }
  
  private boolean a(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    View localView = this.UX.getDecorView();
    for (;;)
    {
      if (paramViewParent == null) {
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View)) || (android.support.v4.view.t.aC((View)paramViewParent))) {
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
  }
  
  private b b(b.a parama)
  {
    gl();
    if (this.WE != null) {
      this.WE.finish();
    }
    if ((this.Wz != null) && (!this.mIsDestroyed)) {}
    for (;;)
    {
      try
      {
        b localb = this.Wz.onWindowStartingSupportActionMode(parama);
        if (localb == null) {
          break label95;
        }
        this.WE = localb;
        if ((this.WE != null) && (this.Wz != null)) {
          this.Wz.onSupportActionModeStarted(this.WE);
        }
        return this.WE;
      }
      catch (AbstractMethodError localAbstractMethodError) {}
      Object localObject1 = null;
      continue;
      label95:
      Object localObject2;
      label201:
      boolean bool;
      if (this.WF == null)
      {
        if (!this.WS) {
          break label492;
        }
        localObject2 = new TypedValue();
        localObject1 = this.mContext.getTheme();
        ((Resources.Theme)localObject1).resolveAttribute(2130968606, (TypedValue)localObject2, true);
        if (((TypedValue)localObject2).resourceId != 0)
        {
          Resources.Theme localTheme = this.mContext.getResources().newTheme();
          localTheme.setTo((Resources.Theme)localObject1);
          localTheme.applyStyle(((TypedValue)localObject2).resourceId, true);
          localObject1 = new android.support.v7.view.d(this.mContext, 0);
          ((Context)localObject1).getTheme().setTo(localTheme);
          this.WF = new ActionBarContextView((Context)localObject1);
          this.WG = new PopupWindow((Context)localObject1, null, 2130968620);
          n.a(this.WG, 2);
          this.WG.setContentView(this.WF);
          this.WG.setWidth(-1);
          ((Context)localObject1).getTheme().resolveAttribute(2130968600, (TypedValue)localObject2, true);
          int i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, ((Context)localObject1).getResources().getDisplayMetrics());
          this.WF.setContentHeight(i);
          this.WG.setHeight(-2);
          this.WH = new Runnable()
          {
            public final void run()
            {
              AppCompatDelegateImpl.this.WG.showAtLocation(AppCompatDelegateImpl.this.WF, 55, 0, 0);
              AppCompatDelegateImpl.this.gl();
              if (AppCompatDelegateImpl.this.gk())
              {
                AppCompatDelegateImpl.this.WF.setAlpha(0.0F);
                AppCompatDelegateImpl.this.WI = android.support.v4.view.t.ag(AppCompatDelegateImpl.this.WF).A(1.0F);
                AppCompatDelegateImpl.this.WI.a(new z()
                {
                  public final void aH(View paramAnonymous2View)
                  {
                    AppCompatDelegateImpl.this.WF.setVisibility(0);
                  }
                  
                  public final void aI(View paramAnonymous2View)
                  {
                    AppCompatDelegateImpl.this.WF.setAlpha(1.0F);
                    AppCompatDelegateImpl.this.WI.a(null);
                    AppCompatDelegateImpl.this.WI = null;
                  }
                });
                return;
              }
              AppCompatDelegateImpl.this.WF.setAlpha(1.0F);
              AppCompatDelegateImpl.this.WF.setVisibility(0);
            }
          };
        }
      }
      else
      {
        label319:
        if (this.WF == null) {
          break label537;
        }
        gl();
        this.WF.hX();
        localObject1 = this.WF.getContext();
        localObject2 = this.WF;
        if (this.WG != null) {
          break label539;
        }
        bool = true;
        label361:
        localObject1 = new android.support.v7.view.e((Context)localObject1, (ActionBarContextView)localObject2, parama, bool);
        if (!parama.a((b)localObject1, ((b)localObject1).getMenu())) {
          break label598;
        }
        ((b)localObject1).invalidate();
        this.WF.c((b)localObject1);
        this.WE = ((b)localObject1);
        if (!gk()) {
          break label544;
        }
        this.WF.setAlpha(0.0F);
        this.WI = android.support.v4.view.t.ag(this.WF).A(1.0F);
        this.WI.a(new z()
        {
          public final void aH(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.WF.setVisibility(0);
            AppCompatDelegateImpl.this.WF.sendAccessibilityEvent(32);
            if ((AppCompatDelegateImpl.this.WF.getParent() instanceof View)) {
              android.support.v4.view.t.ap((View)AppCompatDelegateImpl.this.WF.getParent());
            }
          }
          
          public final void aI(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.WF.setAlpha(1.0F);
            AppCompatDelegateImpl.this.WI.a(null);
            AppCompatDelegateImpl.this.WI = null;
          }
        });
      }
      for (;;)
      {
        if (this.WG == null) {
          break label596;
        }
        this.UX.getDecorView().post(this.WH);
        break;
        localObject1 = this.mContext;
        break label201;
        label492:
        localObject1 = (ViewStubCompat)this.WL.findViewById(2131296372);
        if (localObject1 == null) {
          break label319;
        }
        ((ViewStubCompat)localObject1).setLayoutInflater(LayoutInflater.from(gg()));
        this.WF = ((ActionBarContextView)((ViewStubCompat)localObject1).inflate());
        break label319;
        label537:
        break;
        label539:
        bool = false;
        break label361;
        label544:
        this.WF.setAlpha(1.0F);
        this.WF.setVisibility(0);
        this.WF.sendAccessibilityEvent(32);
        if ((this.WF.getParent() instanceof View)) {
          android.support.v4.view.t.ap((View)this.WF.getParent());
        }
      }
      label596:
      continue;
      label598:
      this.WE = null;
    }
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState)
  {
    Context localContext = this.mContext;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if (((paramPanelFeatureState.Xs == 0) || (paramPanelFeatureState.Xs == 108)) && (this.WB != null))
    {
      localTypedValue = new TypedValue();
      localTheme = localContext.getTheme();
      localTheme.resolveAttribute(2130968606, localTypedValue, true);
      localObject1 = null;
      if (localTypedValue.resourceId != 0)
      {
        localObject1 = localContext.getResources().newTheme();
        ((Resources.Theme)localObject1).setTo(localTheme);
        ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
        ((Resources.Theme)localObject1).resolveAttribute(2130968607, localTypedValue, true);
        Object localObject2 = localObject1;
        if (localTypedValue.resourceId != 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localContext.getResources().newTheme();
            ((Resources.Theme)localObject2).setTo(localTheme);
          }
          ((Resources.Theme)localObject2).applyStyle(localTypedValue.resourceId, true);
        }
        if (localObject2 == null) {
          break label203;
        }
        localObject1 = new android.support.v7.view.d(localContext, 0);
        ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new h((Context)localObject1);
      ((h)localObject1).a(this);
      paramPanelFeatureState.e((h)localObject1);
      return true;
      localTheme.resolveAttribute(2130968607, localTypedValue, true);
      break;
      label203:
      localObject1 = localContext;
    }
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (this.mIsDestroyed) {
      return false;
    }
    if (paramPanelFeatureState.Xy) {
      return true;
    }
    if ((this.WW != null) && (this.WW != paramPanelFeatureState)) {
      a(this.WW, false);
    }
    Window.Callback localCallback = this.UX.getCallback();
    if (localCallback != null) {
      paramPanelFeatureState.Xv = localCallback.onCreatePanelView(paramPanelFeatureState.Xs);
    }
    if ((paramPanelFeatureState.Xs == 0) || (paramPanelFeatureState.Xs == 108)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.WB != null)) {
        this.WB.ic();
      }
      if ((paramPanelFeatureState.Xv != null) || ((i != 0) && ((this.mActionBar instanceof g)))) {
        break label408;
      }
      if ((paramPanelFeatureState.iL != null) && (!paramPanelFeatureState.XC)) {
        break label278;
      }
      if (paramPanelFeatureState.iL == null)
      {
        b(paramPanelFeatureState);
        if (paramPanelFeatureState.iL == null) {
          break;
        }
      }
      if ((i != 0) && (this.WB != null))
      {
        if (this.WC == null) {
          this.WC = new b();
        }
        this.WB.a(paramPanelFeatureState.iL, this.WC);
      }
      paramPanelFeatureState.iL.hB();
      if (localCallback.onCreatePanelMenu(paramPanelFeatureState.Xs, paramPanelFeatureState.iL)) {
        break label273;
      }
      paramPanelFeatureState.e(null);
      if ((i == 0) || (this.WB == null)) {
        break;
      }
      this.WB.a(null, this.WC);
      return false;
    }
    label273:
    paramPanelFeatureState.XC = false;
    label278:
    paramPanelFeatureState.iL.hB();
    if (paramPanelFeatureState.XD != null)
    {
      paramPanelFeatureState.iL.g(paramPanelFeatureState.XD);
      paramPanelFeatureState.XD = null;
    }
    if (!localCallback.onPreparePanel(0, paramPanelFeatureState.Xv, paramPanelFeatureState.iL))
    {
      if ((i != 0) && (this.WB != null)) {
        this.WB.a(null, this.WC);
      }
      paramPanelFeatureState.iL.hC();
      return false;
    }
    if (paramKeyEvent != null)
    {
      i = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
        break label430;
      }
    }
    label408:
    label430:
    for (boolean bool = true;; bool = false)
    {
      paramPanelFeatureState.XA = bool;
      paramPanelFeatureState.iL.setQwertyMode(paramPanelFeatureState.XA);
      paramPanelFeatureState.iL.hC();
      paramPanelFeatureState.Xy = true;
      paramPanelFeatureState.Xz = false;
      this.WW = paramPanelFeatureState;
      return true;
      i = -1;
      break;
    }
  }
  
  private static int bl(int paramInt)
  {
    int i;
    if (paramInt == 8) {
      i = 108;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt != 9);
    return 109;
  }
  
  private int bm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      if ((Build.VERSION.SDK_INT >= 23) && (((UiModeManager)this.mContext.getSystemService(UiModeManager.class)).getNightMode() == 0)) {
        return -1;
      }
      gp();
      return this.Xa.gr();
    }
    return -1;
  }
  
  private boolean bn(int paramInt)
  {
    Resources localResources = this.mContext.getResources();
    Configuration localConfiguration = localResources.getConfiguration();
    int i = localConfiguration.uiMode;
    if (paramInt == 2)
    {
      paramInt = 32;
      if ((i & 0x30) == paramInt) {
        break label116;
      }
      if (!gq()) {
        break label61;
      }
      ((Activity)this.mContext).recreate();
    }
    for (;;)
    {
      return true;
      paramInt = 16;
      break;
      label61:
      localConfiguration = new Configuration(localConfiguration);
      DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
      localConfiguration.uiMode = (paramInt | localConfiguration.uiMode & 0xFFFFFFCF);
      localResources.updateConfiguration(localConfiguration, localDisplayMetrics);
      if (Build.VERSION.SDK_INT < 26) {
        f.a(localResources);
      }
    }
    label116:
    return false;
  }
  
  private boolean c(PanelFeatureState paramPanelFeatureState)
  {
    if (paramPanelFeatureState.Xv != null)
    {
      paramPanelFeatureState.Xu = paramPanelFeatureState.Xv;
      return true;
    }
    if (paramPanelFeatureState.iL == null) {
      return false;
    }
    if (this.WD == null) {
      this.WD = new g();
    }
    paramPanelFeatureState.Xu = ((View)paramPanelFeatureState.b(this.WD));
    return paramPanelFeatureState.Xu != null;
  }
  
  private int getNightMode()
  {
    if (this.WY != -100) {
      return this.WY;
    }
    return d.Wt;
  }
  
  private CharSequence getTitle()
  {
    if ((this.Wx instanceof Activity)) {
      return ((Activity)this.Wx).getTitle();
    }
    return this.Fm;
  }
  
  private void gf()
  {
    gh();
    if ((!this.WP) || (this.mActionBar != null)) {}
    for (;;)
    {
      return;
      if ((this.Wx instanceof Activity)) {
        this.mActionBar = new j((Activity)this.Wx, this.WQ);
      }
      while (this.mActionBar != null)
      {
        this.mActionBar.Q(this.Xe);
        return;
        if ((this.Wx instanceof Dialog)) {
          this.mActionBar = new j((Dialog)this.Wx);
        }
      }
    }
  }
  
  private Context gg()
  {
    Context localContext = null;
    Object localObject = getSupportActionBar();
    if (localObject != null) {
      localContext = ((ActionBar)localObject).getThemedContext();
    }
    localObject = localContext;
    if (localContext == null) {
      localObject = this.mContext;
    }
    return localObject;
  }
  
  private void gh()
  {
    Object localObject;
    if (!this.WK)
    {
      this.WL = gi();
      localObject = getTitle();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (this.WB == null) {
          break label84;
        }
        this.WB.setWindowTitle((CharSequence)localObject);
      }
    }
    for (;;)
    {
      gj();
      this.WK = true;
      localObject = bi(0);
      if ((!this.mIsDestroyed) && ((localObject == null) || (((PanelFeatureState)localObject).iL == null))) {
        invalidatePanelMenu(108);
      }
      return;
      label84:
      if (this.mActionBar != null) {
        this.mActionBar.setWindowTitle((CharSequence)localObject);
      } else if (this.Vw != null) {
        this.Vw.setText((CharSequence)localObject);
      }
    }
  }
  
  private ViewGroup gi()
  {
    Object localObject = this.mContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme);
    if (!((TypedArray)localObject).hasValue(111))
    {
      ((TypedArray)localObject).recycle();
      throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }
    if (((TypedArray)localObject).getBoolean(120, false))
    {
      requestWindowFeature(1);
      if (((TypedArray)localObject).getBoolean(112, false)) {
        requestWindowFeature(109);
      }
      if (((TypedArray)localObject).getBoolean(113, false)) {
        requestWindowFeature(10);
      }
      this.WS = ((TypedArray)localObject).getBoolean(0, false);
      ((TypedArray)localObject).recycle();
      this.UX.getDecorView();
      localObject = LayoutInflater.from(this.mContext);
      if (this.WT) {
        break label423;
      }
      if (!this.WS) {
        break label261;
      }
      localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2131492903, null);
      this.WQ = false;
      this.WP = false;
    }
    for (;;)
    {
      if (localObject == null)
      {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.WP + ", windowActionBarOverlay: " + this.WQ + ", android:windowIsFloating: " + this.WS + ", windowActionModeOverlay: " + this.WR + ", windowNoTitle: " + this.WT + " }");
        if (!((TypedArray)localObject).getBoolean(111, false)) {
          break;
        }
        requestWindowFeature(108);
        break;
        label261:
        if (!this.WP) {
          break label631;
        }
        localObject = new TypedValue();
        this.mContext.getTheme().resolveAttribute(2130968606, (TypedValue)localObject, true);
        if (((TypedValue)localObject).resourceId != 0) {}
        for (localObject = new android.support.v7.view.d(this.mContext, ((TypedValue)localObject).resourceId);; localObject = this.mContext)
        {
          localObject = (ViewGroup)LayoutInflater.from((Context)localObject).inflate(2131492914, null);
          this.WB = ((android.support.v7.widget.t)((ViewGroup)localObject).findViewById(2131298945));
          this.WB.setWindowCallback(this.UX.getCallback());
          if (this.WQ) {
            this.WB.bv(109);
          }
          if (this.WN) {
            this.WB.bv(2);
          }
          if (this.WO) {
            this.WB.bv(5);
          }
          break;
        }
        label423:
        if (this.WR) {}
        for (localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2131492913, null);; localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2131492912, null))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label480;
          }
          android.support.v4.view.t.a((View)localObject, new android.support.v4.view.p()
          {
            public final ab a(View paramAnonymousView, ab paramAnonymousab)
            {
              int i = paramAnonymousab.getSystemWindowInsetTop();
              int j = AppCompatDelegateImpl.this.bk(i);
              ab localab = paramAnonymousab;
              if (i != j) {
                localab = paramAnonymousab.f(paramAnonymousab.getSystemWindowInsetLeft(), j, paramAnonymousab.getSystemWindowInsetRight(), paramAnonymousab.getSystemWindowInsetBottom());
              }
              return android.support.v4.view.t.a(paramAnonymousView, localab);
            }
          });
          break;
        }
        label480:
        ((aa)localObject).setOnFitSystemWindowsListener(new aa.a()
        {
          public final void f(Rect paramAnonymousRect)
          {
            paramAnonymousRect.top = AppCompatDelegateImpl.this.bk(paramAnonymousRect.top);
          }
        });
        continue;
      }
      if (this.WB == null) {
        this.Vw = ((TextView)((ViewGroup)localObject).findViewById(2131305902));
      }
      bh.cg((View)localObject);
      ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject).findViewById(2131296344);
      ViewGroup localViewGroup = (ViewGroup)this.UX.findViewById(16908290);
      if (localViewGroup != null)
      {
        while (localViewGroup.getChildCount() > 0)
        {
          View localView = localViewGroup.getChildAt(0);
          localViewGroup.removeViewAt(0);
          localContentFrameLayout.addView(localView);
        }
        localViewGroup.setId(-1);
        localContentFrameLayout.setId(16908290);
        if ((localViewGroup instanceof FrameLayout)) {
          ((FrameLayout)localViewGroup).setForeground(null);
        }
      }
      this.UX.setContentView((View)localObject);
      localContentFrameLayout.setAttachListener(new ContentFrameLayout.a()
      {
        public final void onDetachedFromWindow()
        {
          AppCompatDelegateImpl.this.go();
        }
      });
      return localObject;
      label631:
      localObject = null;
    }
  }
  
  private void gj()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.WL.findViewById(16908290);
    Object localObject = this.UX.getDecorView();
    localContentFrameLayout.j(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    localObject = this.mContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme);
    ((TypedArray)localObject).getValue(118, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(119, localContentFrameLayout.getMinWidthMinor());
    if (((TypedArray)localObject).hasValue(116)) {
      ((TypedArray)localObject).getValue(116, localContentFrameLayout.getFixedWidthMajor());
    }
    if (((TypedArray)localObject).hasValue(117)) {
      ((TypedArray)localObject).getValue(117, localContentFrameLayout.getFixedWidthMinor());
    }
    if (((TypedArray)localObject).hasValue(114)) {
      ((TypedArray)localObject).getValue(114, localContentFrameLayout.getFixedHeightMajor());
    }
    if (((TypedArray)localObject).hasValue(115)) {
      ((TypedArray)localObject).getValue(115, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
  }
  
  private void gn()
  {
    if (this.WK) {
      throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }
  }
  
  private void gp()
  {
    if (this.Xa == null) {
      this.Xa = new e(i.Y(this.mContext));
    }
  }
  
  private boolean gq()
  {
    PackageManager localPackageManager;
    if ((this.WZ) && ((this.mContext instanceof Activity))) {
      localPackageManager = this.mContext.getPackageManager();
    }
    try
    {
      int i = localPackageManager.getActivityInfo(new ComponentName(this.mContext, this.mContext.getClass()), 0).configChanges;
      return (i & 0x200) == 0;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
    return true;
  }
  
  private void invalidatePanelMenu(int paramInt)
  {
    this.Xc |= 1 << paramInt;
    if (!this.Xb)
    {
      android.support.v4.view.t.b(this.UX.getDecorView(), this.Xd);
      this.Xb = true;
    }
  }
  
  final PanelFeatureState a(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.WV;
    int i;
    int j;
    if (arrayOfPanelFeatureState != null)
    {
      i = arrayOfPanelFeatureState.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label57;
      }
      PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[j];
      if ((localPanelFeatureState != null) && (localPanelFeatureState.iL == paramMenu))
      {
        return localPanelFeatureState;
        i = 0;
        break;
      }
      j += 1;
    }
    label57:
    return null;
  }
  
  final void a(int paramInt, PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    Object localObject1 = paramPanelFeatureState;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
      if (paramPanelFeatureState == null)
      {
        localPanelFeatureState = paramPanelFeatureState;
        if (paramInt >= 0)
        {
          localPanelFeatureState = paramPanelFeatureState;
          if (paramInt < this.WV.length) {
            localPanelFeatureState = this.WV[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.iL;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((PanelFeatureState)localObject1).Tz)) {}
    while (this.mIsDestroyed) {
      return;
    }
    this.Wx.onPanelClosed(paramInt, (Menu)localObject2);
  }
  
  final void a(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.Xs == 0) && (this.WB != null) && (this.WB.isOverflowMenuShowing())) {
      c(paramPanelFeatureState.iL);
    }
    do
    {
      return;
      WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
      if ((localWindowManager != null) && (paramPanelFeatureState.Tz) && (paramPanelFeatureState.Xt != null))
      {
        localWindowManager.removeView(paramPanelFeatureState.Xt);
        if (paramBoolean) {
          a(paramPanelFeatureState.Xs, paramPanelFeatureState, null);
        }
      }
      paramPanelFeatureState.Xy = false;
      paramPanelFeatureState.Xz = false;
      paramPanelFeatureState.Tz = false;
      paramPanelFeatureState.Xu = null;
      paramPanelFeatureState.XB = true;
    } while (this.WW != paramPanelFeatureState);
    this.WW = null;
  }
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = this.UX.getCallback();
    if ((localCallback != null) && (!this.mIsDestroyed))
    {
      paramh = a(paramh.hI());
      if (paramh != null) {
        return localCallback.onMenuItemSelected(paramh.Xs, paramMenuItem);
      }
    }
    return false;
  }
  
  public final void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    gh();
    ((ViewGroup)this.WL.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.Wx.onContentChanged();
  }
  
  public final void b(h paramh)
  {
    if ((this.WB != null) && (this.WB.ia()) && ((!ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) || (this.WB.ib())))
    {
      paramh = this.UX.getCallback();
      if (!this.WB.isOverflowMenuShowing()) {
        if ((paramh != null) && (!this.mIsDestroyed))
        {
          if ((this.Xb) && ((this.Xc & 0x1) != 0))
          {
            this.UX.getDecorView().removeCallbacks(this.Xd);
            this.Xd.run();
          }
          PanelFeatureState localPanelFeatureState = bi(0);
          if ((localPanelFeatureState.iL != null) && (!localPanelFeatureState.XC) && (paramh.onPreparePanel(0, localPanelFeatureState.Xv, localPanelFeatureState.iL)))
          {
            paramh.onMenuOpened(108, localPanelFeatureState.iL);
            this.WB.showOverflowMenu();
          }
        }
      }
      do
      {
        return;
        this.WB.hideOverflowMenu();
      } while (this.mIsDestroyed);
      paramh.onPanelClosed(108, bi(0).iL);
      return;
    }
    paramh = bi(0);
    paramh.XB = true;
    a(paramh, false);
    a(paramh, null);
  }
  
  final void bh(int paramInt)
  {
    Object localObject;
    if (paramInt == 108)
    {
      localObject = getSupportActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).S(false);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      localObject = bi(paramInt);
    } while (!((PanelFeatureState)localObject).Tz);
    a((PanelFeatureState)localObject, false);
  }
  
  protected final PanelFeatureState bi(int paramInt)
  {
    Object localObject2 = this.WV;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > paramInt) {}
    }
    else
    {
      localObject1 = new PanelFeatureState[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      this.WV = ((PanelFeatureState[])localObject1);
    }
    localObject2 = localObject1[paramInt];
    if (localObject2 == null)
    {
      localObject2 = new PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
      return localObject2;
    }
    return localObject2;
  }
  
  final void bj(int paramInt)
  {
    PanelFeatureState localPanelFeatureState = bi(paramInt);
    if (localPanelFeatureState.iL != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState.iL.f(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState.XD = localBundle;
      }
      localPanelFeatureState.iL.hB();
      localPanelFeatureState.iL.clear();
    }
    localPanelFeatureState.XC = true;
    localPanelFeatureState.XB = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.WB != null))
    {
      localPanelFeatureState = bi(0);
      if (localPanelFeatureState != null)
      {
        localPanelFeatureState.Xy = false;
        b(localPanelFeatureState, null);
      }
    }
  }
  
  final int bk(int paramInt)
  {
    int j = 1;
    int m = 0;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.WF != null) && ((this.WF.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.WF.getLayoutParams();
      if (this.WF.isShown())
      {
        if (this.Xf == null)
        {
          this.Xf = new Rect();
          this.Xg = new Rect();
        }
        localObject2 = this.Xf;
        Rect localRect = this.Xg;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        bh.a(this.WL, (Rect)localObject2, localRect);
        if (localRect.top == 0)
        {
          i = paramInt;
          if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == i) {
            break label351;
          }
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
          if (this.WM != null) {
            break label274;
          }
          this.WM = new View(this.mContext);
          this.WM.setBackgroundColor(this.mContext.getResources().getColor(2131099852));
          this.WL.addView(this.WM, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i = 1;
          label198:
          if (this.WM == null) {
            break label312;
          }
          label205:
          int k = paramInt;
          if (!this.WR)
          {
            k = paramInt;
            if (j != 0) {
              k = 0;
            }
          }
          paramInt = k;
          label228:
          if (i != 0) {
            this.WF.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.WM != null)
      {
        localObject1 = this.WM;
        if (j == 0) {
          break label338;
        }
      }
      label274:
      label312:
      label338:
      for (i = m;; i = 8)
      {
        ((View)localObject1).setVisibility(i);
        return paramInt;
        i = 0;
        break;
        localObject2 = this.WM.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
        {
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          this.WM.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        i = 1;
        break label198;
        j = 0;
        break label205;
        if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == 0) {
          break label344;
        }
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
        i = 1;
        j = 0;
        break label228;
      }
      label344:
      i = 0;
      j = 0;
      break label228;
      label351:
      i = 0;
      break label198;
      j = 0;
    }
  }
  
  final void c(h paramh)
  {
    if (this.WU) {
      return;
    }
    this.WU = true;
    this.WB.go();
    Window.Callback localCallback = this.UX.getCallback();
    if ((localCallback != null) && (!this.mIsDestroyed)) {
      localCallback.onPanelClosed(108, paramh);
    }
    this.WU = false;
  }
  
  final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (((this.Wx instanceof e.a)) || ((this.Wx instanceof e)))
    {
      localObject = this.UX.getDecorView();
      if ((localObject == null) || (!android.support.v4.view.e.a((View)localObject, paramKeyEvent))) {}
    }
    int i;
    label208:
    do
    {
      int j;
      do
      {
        do
        {
          do
          {
            return true;
          } while ((paramKeyEvent.getKeyCode() == 82) && (this.Wx.dispatchKeyEvent(paramKeyEvent)));
          j = paramKeyEvent.getKeyCode();
          if (paramKeyEvent.getAction() == 0) {}
          for (i = 1; i != 0; i = 0) {
            switch (j)
            {
            default: 
              return false;
            }
          }
        } while (paramKeyEvent.getRepeatCount() != 0);
        localObject = bi(0);
      } while (((PanelFeatureState)localObject).Tz);
      b((PanelFeatureState)localObject, paramKeyEvent);
      return true;
      if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
      for (bool = true;; bool = false)
      {
        this.WX = bool;
        break;
      }
      switch (j)
      {
      default: 
        return false;
      }
    } while (this.WE != null);
    Object localObject = bi(0);
    if ((this.WB != null) && (this.WB.ia()) && (!ViewConfiguration.get(this.mContext).hasPermanentMenuKey())) {
      if (!this.WB.isOverflowMenuShowing())
      {
        if ((this.mIsDestroyed) || (!b((PanelFeatureState)localObject, paramKeyEvent))) {
          break label511;
        }
        bool = this.WB.showOverflowMenu();
      }
    }
    label296:
    while (bool)
    {
      paramKeyEvent = (AudioManager)this.mContext.getSystemService("audio");
      if (paramKeyEvent == null) {
        break;
      }
      paramKeyEvent.playSoundEffect(0);
      return true;
      bool = this.WB.hideOverflowMenu();
      continue;
      if ((!((PanelFeatureState)localObject).Tz) && (!((PanelFeatureState)localObject).Xz)) {
        break label373;
      }
      bool = ((PanelFeatureState)localObject).Tz;
      a((PanelFeatureState)localObject, true);
    }
    label373:
    if (((PanelFeatureState)localObject).Xy)
    {
      if (!((PanelFeatureState)localObject).XC) {
        break label517;
      }
      ((PanelFeatureState)localObject).Xy = false;
    }
    label517:
    for (boolean bool = b((PanelFeatureState)localObject, paramKeyEvent);; bool = true)
    {
      if (bool)
      {
        a((PanelFeatureState)localObject, paramKeyEvent);
        bool = true;
        break label296;
        bool = this.WX;
        this.WX = false;
        paramKeyEvent = bi(0);
        if ((paramKeyEvent != null) && (paramKeyEvent.Tz))
        {
          if (bool) {
            break;
          }
          a(paramKeyEvent, true);
          return true;
        }
        if (this.WE != null)
        {
          this.WE.finish();
          i = 1;
        }
        while (i != 0)
        {
          return true;
          paramKeyEvent = getSupportActionBar();
          if ((paramKeyEvent != null) && (paramKeyEvent.collapseActionView())) {
            i = 1;
          } else {
            i = 0;
          }
        }
        break label208;
      }
      label511:
      bool = false;
      break label296;
    }
  }
  
  public final <T extends View> T findViewById(int paramInt)
  {
    gh();
    return this.UX.findViewById(paramInt);
  }
  
  public final void gb()
  {
    gh();
  }
  
  public final void gd()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    if (localLayoutInflater.getFactory() == null)
    {
      android.support.v4.view.f.b(localLayoutInflater, this);
      return;
    }
    localLayoutInflater.getFactory2();
  }
  
  public final boolean ge()
  {
    boolean bool = false;
    int i = getNightMode();
    int j = bm(i);
    if (j != -1) {
      bool = bn(j);
    }
    if (i == 0)
    {
      gp();
      this.Xa.setup();
    }
    this.WZ = true;
    return bool;
  }
  
  public final a.a getDrawerToggleDelegate()
  {
    return new a();
  }
  
  public final MenuInflater getMenuInflater()
  {
    if (this.WA == null)
    {
      gf();
      if (this.mActionBar == null) {
        break label43;
      }
    }
    label43:
    for (Context localContext = this.mActionBar.getThemedContext();; localContext = this.mContext)
    {
      this.WA = new android.support.v7.view.g(localContext);
      return this.WA;
    }
  }
  
  public final ActionBar getSupportActionBar()
  {
    gf();
    return this.mActionBar;
  }
  
  final boolean gk()
  {
    return (this.WK) && (this.WL != null) && (android.support.v4.view.t.ay(this.WL));
  }
  
  final void gl()
  {
    if (this.WI != null) {
      this.WI.cancel();
    }
  }
  
  final void gm()
  {
    a(bi(0), true);
  }
  
  final void go()
  {
    if (this.WB != null) {
      this.WB.go();
    }
    if (this.WG != null)
    {
      this.UX.getDecorView().removeCallbacks(this.WH);
      if (!this.WG.isShowing()) {}
    }
    try
    {
      this.WG.dismiss();
      label55:
      this.WG = null;
      gl();
      PanelFeatureState localPanelFeatureState = bi(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.iL != null)) {
        localPanelFeatureState.iL.close();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label55;
    }
  }
  
  public final void invalidateOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar != null) && (localActionBar.fZ())) {
      return;
    }
    invalidatePanelMenu(0);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.WP) && (this.WK))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
    android.support.v7.widget.g.iL().aa(this.mContext);
    ge();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    if ((this.Wx instanceof Activity)) {}
    try
    {
      Object localObject1 = q.i((Activity)this.Wx);
      if (localObject1 != null)
      {
        localObject1 = this.mActionBar;
        if (localObject1 == null) {
          this.Xe = true;
        }
      }
      else
      {
        if ((paramBundle != null) && (this.WY == -100)) {
          this.WY = paramBundle.getInt("appcompat:local_night_mode", -100);
        }
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject2 = null;
        continue;
        localObject2.Q(true);
      }
    }
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return a(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public final void onDestroy()
  {
    if (this.Xb) {
      this.UX.getDecorView().removeCallbacks(this.Xd);
    }
    this.mIsDestroyed = true;
    if (this.mActionBar != null) {
      this.mActionBar.onDestroy();
    }
    if (this.Xa != null) {
      this.Xa.cleanup();
    }
  }
  
  final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = getSupportActionBar();
    if ((localObject != null) && (((ActionBar)localObject).onKeyShortcut(paramInt, paramKeyEvent))) {}
    boolean bool;
    do
    {
      do
      {
        return true;
        if ((this.WW == null) || (!a(this.WW, paramKeyEvent.getKeyCode(), paramKeyEvent))) {
          break;
        }
      } while (this.WW == null);
      this.WW.Xz = true;
      return true;
      if (this.WW != null) {
        break;
      }
      localObject = bi(0);
      b((PanelFeatureState)localObject, paramKeyEvent);
      bool = a((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent);
      ((PanelFeatureState)localObject).Xy = false;
    } while (bool);
    return false;
  }
  
  public final void onPostResume()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.R(true);
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.WY != -100) {
      paramBundle.putInt("appcompat:local_night_mode", this.WY);
    }
  }
  
  public final void onStart()
  {
    ge();
  }
  
  public final void onStop()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.R(false);
    }
    if (this.Xa != null) {
      this.Xa.cleanup();
    }
  }
  
  public final boolean requestWindowFeature(int paramInt)
  {
    paramInt = bl(paramInt);
    if ((this.WT) && (paramInt == 108)) {
      return false;
    }
    if ((this.WP) && (paramInt == 1)) {
      this.WP = false;
    }
    switch (paramInt)
    {
    default: 
      return this.UX.requestFeature(paramInt);
    case 108: 
      gn();
      this.WP = true;
      return true;
    case 109: 
      gn();
      this.WQ = true;
      return true;
    case 10: 
      gn();
      this.WR = true;
      return true;
    case 2: 
      gn();
      this.WN = true;
      return true;
    case 5: 
      gn();
      this.WO = true;
      return true;
    }
    gn();
    this.WT = true;
    return true;
  }
  
  public final void setContentView(int paramInt)
  {
    gh();
    ViewGroup localViewGroup = (ViewGroup)this.WL.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.mContext).inflate(paramInt, localViewGroup);
    this.Wx.onContentChanged();
  }
  
  public final void setContentView(View paramView)
  {
    gh();
    ViewGroup localViewGroup = (ViewGroup)this.WL.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.Wx.onContentChanged();
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    gh();
    ViewGroup localViewGroup = (ViewGroup)this.WL.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.Wx.onContentChanged();
  }
  
  public final void setSupportActionBar(Toolbar paramToolbar)
  {
    if (!(this.Wx instanceof Activity)) {
      return;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar instanceof j)) {
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }
    this.WA = null;
    if (localActionBar != null) {
      localActionBar.onDestroy();
    }
    if (paramToolbar != null)
    {
      paramToolbar = new g(paramToolbar, ((Activity)this.Wx).getTitle(), this.Wy);
      this.mActionBar = paramToolbar;
      this.UX.setCallback(paramToolbar.XU);
    }
    for (;;)
    {
      invalidateOptionsMenu();
      return;
      this.mActionBar = null;
      this.UX.setCallback(this.Wy);
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.Fm = paramCharSequence;
    if (this.WB != null) {
      this.WB.setWindowTitle(paramCharSequence);
    }
    do
    {
      return;
      if (this.mActionBar != null)
      {
        this.mActionBar.setWindowTitle(paramCharSequence);
        return;
      }
    } while (this.Vw == null);
    this.Vw.setText(paramCharSequence);
  }
  
  public final b startSupportActionMode(b.a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (this.WE != null) {
      this.WE.finish();
    }
    parama = new c(parama);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      this.WE = localActionBar.a(parama);
      if ((this.WE != null) && (this.Wz != null)) {
        this.Wz.onSupportActionModeStarted(this.WE);
      }
    }
    if (this.WE == null) {
      this.WE = b(parama);
    }
    return this.WE;
  }
  
  protected static final class PanelFeatureState
  {
    boolean Tz;
    public boolean XA;
    boolean XB;
    boolean XC;
    Bundle XD;
    int Xs;
    ViewGroup Xt;
    View Xu;
    View Xv;
    android.support.v7.view.menu.f Xw;
    Context Xx;
    boolean Xy;
    boolean Xz;
    int background;
    int gravity;
    h iL;
    int windowAnimations;
    int x;
    int y;
    
    PanelFeatureState(int paramInt)
    {
      this.Xs = paramInt;
      this.XB = false;
    }
    
    final void X(Context paramContext)
    {
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(2130968599, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      localTheme.resolveAttribute(2130969365, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      for (;;)
      {
        paramContext = new android.support.v7.view.d(paramContext, 0);
        paramContext.getTheme().setTo(localTheme);
        this.Xx = paramContext;
        paramContext = paramContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme);
        this.background = paramContext.getResourceId(80, 0);
        this.windowAnimations = paramContext.getResourceId(1, 0);
        paramContext.recycle();
        return;
        localTheme.applyStyle(2131821414, true);
      }
    }
    
    final android.support.v7.view.menu.p b(o.a parama)
    {
      if (this.iL == null) {
        return null;
      }
      if (this.Xw == null)
      {
        this.Xw = new android.support.v7.view.menu.f(this.Xx);
        this.Xw.adc = parama;
        this.iL.a(this.Xw);
      }
      return this.Xw.c(this.Xt);
    }
    
    final void e(h paramh)
    {
      if (paramh == this.iL) {}
      do
      {
        return;
        if (this.iL != null) {
          this.iL.b(this.Xw);
        }
        this.iL = paramh;
      } while ((paramh == null) || (this.Xw == null));
      paramh.a(this.Xw);
    }
    
    public final boolean gs()
    {
      if (this.Xu == null) {}
      do
      {
        return false;
        if (this.Xv != null) {
          return true;
        }
      } while (this.Xw.getAdapter().getCount() <= 0);
      return true;
    }
  }
  
  final class a
    implements a.a
  {
    a() {}
    
    public final void bg(int paramInt)
    {
      ActionBar localActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
  }
  
  final class b
    implements o.a
  {
    b() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      AppCompatDelegateImpl.this.c(paramh);
    }
    
    public final boolean d(h paramh)
    {
      Window.Callback localCallback = AppCompatDelegateImpl.this.UX.getCallback();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramh);
      }
      return true;
    }
  }
  
  final class c
    implements b.a
  {
    private b.a Xl;
    
    public c(b.a parama)
    {
      this.Xl = parama;
    }
    
    public final void a(b paramb)
    {
      this.Xl.a(paramb);
      if (AppCompatDelegateImpl.this.WG != null) {
        AppCompatDelegateImpl.this.UX.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.WH);
      }
      if (AppCompatDelegateImpl.this.WF != null)
      {
        AppCompatDelegateImpl.this.gl();
        AppCompatDelegateImpl.this.WI = android.support.v4.view.t.ag(AppCompatDelegateImpl.this.WF).A(0.0F);
        AppCompatDelegateImpl.this.WI.a(new z()
        {
          public final void aI(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.WF.setVisibility(8);
            if (AppCompatDelegateImpl.this.WG != null) {
              AppCompatDelegateImpl.this.WG.dismiss();
            }
            for (;;)
            {
              AppCompatDelegateImpl.this.WF.removeAllViews();
              AppCompatDelegateImpl.this.WI.a(null);
              AppCompatDelegateImpl.this.WI = null;
              return;
              if ((AppCompatDelegateImpl.this.WF.getParent() instanceof View)) {
                android.support.v4.view.t.ap((View)AppCompatDelegateImpl.this.WF.getParent());
              }
            }
          }
        });
      }
      if (AppCompatDelegateImpl.this.Wz != null) {
        AppCompatDelegateImpl.this.Wz.onSupportActionModeFinished(AppCompatDelegateImpl.this.WE);
      }
      AppCompatDelegateImpl.this.WE = null;
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      return this.Xl.a(paramb, paramMenu);
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.Xl.a(paramb, paramMenuItem);
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      return this.Xl.b(paramb, paramMenu);
    }
  }
  
  final class d
    extends android.support.v7.view.i
  {
    d(Window.Callback paramCallback)
    {
      super();
    }
    
    private ActionMode a(ActionMode.Callback paramCallback)
    {
      paramCallback = new f.a(AppCompatDelegateImpl.this.mContext, paramCallback);
      b localb = AppCompatDelegateImpl.this.startSupportActionMode(paramCallback);
      if (localb != null) {
        return paramCallback.b(localb);
      }
      return null;
    }
    
    public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImpl.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public final boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (AppCompatDelegateImpl.this.onKeyShortcut(paramKeyEvent.getKeyCode(), paramKeyEvent));
    }
    
    public final void onContentChanged() {}
    
    public final boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      if ((paramInt == 0) && (!(paramMenu instanceof h))) {
        return false;
      }
      return super.onCreatePanelMenu(paramInt, paramMenu);
    }
    
    public final boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      super.onMenuOpened(paramInt, paramMenu);
      paramMenu = AppCompatDelegateImpl.this;
      if (paramInt == 108)
      {
        paramMenu = paramMenu.getSupportActionBar();
        if (paramMenu != null) {
          paramMenu.S(true);
        }
      }
      return true;
    }
    
    public final void onPanelClosed(int paramInt, Menu paramMenu)
    {
      super.onPanelClosed(paramInt, paramMenu);
      AppCompatDelegateImpl.this.bh(paramInt);
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      h localh;
      boolean bool1;
      if ((paramMenu instanceof h))
      {
        localh = (h)paramMenu;
        if ((paramInt != 0) || (localh != null)) {
          break label34;
        }
        bool1 = false;
      }
      label34:
      boolean bool2;
      do
      {
        return bool1;
        localh = null;
        break;
        if (localh != null) {
          localh.aeG = true;
        }
        bool2 = super.onPreparePanel(paramInt, paramView, paramMenu);
        bool1 = bool2;
      } while (localh == null);
      localh.aeG = false;
      return bool2;
    }
    
    public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
    {
      AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = AppCompatDelegateImpl.this.bi(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.iL != null))
      {
        super.onProvideKeyboardShortcuts(paramList, localPanelFeatureState.iL, paramInt);
        return;
      }
      super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return null;
      }
      if (AppCompatDelegateImpl.this.WJ) {
        return a(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if (AppCompatDelegateImpl.this.WJ) {}
      switch (paramInt)
      {
      default: 
        return super.onWindowStartingActionMode(paramCallback, paramInt);
      }
      return a(paramCallback);
    }
  }
  
  final class e
  {
    i Xn;
    boolean Xo;
    private BroadcastReceiver Xp;
    private IntentFilter Xq;
    
    e(i parami)
    {
      this.Xn = parami;
      this.Xo = parami.gv();
    }
    
    final void cleanup()
    {
      if (this.Xp != null)
      {
        AppCompatDelegateImpl.this.mContext.unregisterReceiver(this.Xp);
        this.Xp = null;
      }
    }
    
    final int gr()
    {
      this.Xo = this.Xn.gv();
      if (this.Xo) {
        return 2;
      }
      return 1;
    }
    
    final void setup()
    {
      cleanup();
      if (this.Xp == null) {
        this.Xp = new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            paramAnonymousContext = AppCompatDelegateImpl.e.this;
            boolean bool = paramAnonymousContext.Xn.gv();
            if (bool != paramAnonymousContext.Xo)
            {
              paramAnonymousContext.Xo = bool;
              paramAnonymousContext.Xj.ge();
            }
          }
        };
      }
      if (this.Xq == null)
      {
        this.Xq = new IntentFilter();
        this.Xq.addAction("android.intent.action.TIME_SET");
        this.Xq.addAction("android.intent.action.TIMEZONE_CHANGED");
        this.Xq.addAction("android.intent.action.TIME_TICK");
      }
      AppCompatDelegateImpl.this.mContext.registerReceiver(this.Xp, this.Xq);
    }
  }
  
  final class f
    extends ContentFrameLayout
  {
    public f(Context paramContext)
    {
      super();
    }
    
    public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImpl.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        if ((i < -5) || (j < -5) || (i > getWidth() + 5) || (j > getHeight() + 5)) {}
        for (i = 1; i != 0; i = 0)
        {
          AppCompatDelegateImpl.this.gm();
          return true;
        }
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public final void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(a.l(getContext(), paramInt));
    }
  }
  
  final class g
    implements o.a
  {
    g() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      h localh = paramh.hI();
      if (localh != paramh) {}
      for (int i = 1;; i = 0)
      {
        AppCompatDelegateImpl localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
        if (i != 0) {
          paramh = localh;
        }
        paramh = localAppCompatDelegateImpl.a(paramh);
        if (paramh != null)
        {
          if (i == 0) {
            break;
          }
          AppCompatDelegateImpl.this.a(paramh.Xs, paramh, localh);
          AppCompatDelegateImpl.this.a(paramh, true);
        }
        return;
      }
      AppCompatDelegateImpl.this.a(paramh, paramBoolean);
    }
    
    public final boolean d(h paramh)
    {
      if ((paramh == null) && (AppCompatDelegateImpl.this.WP))
      {
        Window.Callback localCallback = AppCompatDelegateImpl.this.UX.getCallback();
        if ((localCallback != null) && (!AppCompatDelegateImpl.this.mIsDestroyed)) {
          localCallback.onMenuOpened(108, paramh);
        }
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImpl
 * JD-Core Version:    0.7.0.1
 */