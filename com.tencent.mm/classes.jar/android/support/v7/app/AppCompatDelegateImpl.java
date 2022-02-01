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
  private static final int[] VA;
  private static boolean VB;
  private static final boolean Vz;
  private CharSequence Eo;
  private TextView UA;
  final Window Ub;
  final Window.Callback VC;
  final Window.Callback VD;
  final c VE;
  MenuInflater VF;
  private android.support.v7.widget.t VG;
  private b VH;
  private g VI;
  b VJ;
  ActionBarContextView VK;
  PopupWindow VL;
  Runnable VM;
  x VN = null;
  boolean VO = true;
  private boolean VP;
  private ViewGroup VQ;
  private View VR;
  private boolean VS;
  private boolean VT;
  boolean VU;
  boolean VV;
  boolean VW;
  boolean VX;
  boolean VY;
  private boolean VZ;
  private PanelFeatureState[] Wa;
  private PanelFeatureState Wb;
  private boolean Wc;
  private int Wd = -100;
  private boolean We;
  private e Wf;
  boolean Wg;
  int Wh;
  private final Runnable Wi = new Runnable()
  {
    public final void run()
    {
      if ((AppCompatDelegateImpl.this.Wh & 0x1) != 0) {
        AppCompatDelegateImpl.this.bj(0);
      }
      if ((AppCompatDelegateImpl.this.Wh & 0x1000) != 0) {
        AppCompatDelegateImpl.this.bj(108);
      }
      AppCompatDelegateImpl.this.Wg = false;
      AppCompatDelegateImpl.this.Wh = 0;
    }
  };
  private boolean Wj;
  private Rect Wk;
  private Rect Wl;
  private AppCompatViewInflater Wm;
  ActionBar mActionBar;
  final Context mContext;
  boolean mIsDestroyed;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      Vz = bool;
      VA = new int[] { 16842836 };
      if ((Vz) && (!VB))
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
              this.Wn.uncaughtException(paramAnonymousThread, (Throwable)localObject);
              return;
            }
            this.Wn.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
          }
        });
        VB = true;
      }
      return;
    }
  }
  
  AppCompatDelegateImpl(Context paramContext, Window paramWindow, c paramc)
  {
    this.mContext = paramContext;
    this.Ub = paramWindow;
    this.VE = paramc;
    this.VC = this.Ub.getCallback();
    if ((this.VC instanceof d)) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    this.VD = new d(this.VC);
    this.Ub.setCallback(this.VD);
    paramContext = az.a(paramContext, null, VA);
    paramWindow = paramContext.db(0);
    if (paramWindow != null) {
      this.Ub.setBackgroundDrawable(paramWindow);
    }
    paramContext.avP.recycle();
  }
  
  private View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    String str;
    boolean bool;
    if (this.Wm == null)
    {
      str = this.mContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme).getString(110);
      if ((str == null) || (AppCompatViewInflater.class.getName().equals(str))) {
        this.Wm = new AppCompatViewInflater();
      }
    }
    else
    {
      if (!Vz) {
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
        return this.Wm.createView(paramView, paramString, paramContext, paramAttributeSet, bool, Vz, true, be.mG());
        try
        {
          this.Wm = ((AppCompatViewInflater)Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        catch (Throwable localThrowable)
        {
          new StringBuilder("Failed to instantiate custom view inflater ").append(str).append(". Falling back to default.");
          this.Wm = new AppCompatViewInflater();
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
    if ((paramPanelFeatureState.SE) || (this.mIsDestroyed)) {}
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
          if (paramPanelFeatureState.Wx == 0) {
            if ((this.mContext.getResources().getConfiguration().screenLayout & 0xF) != 4) {
              break label90;
            }
          }
          for (i = 1; i == 0; i = 0)
          {
            localObject = this.Ub.getCallback();
            if ((localObject == null) || (((Window.Callback)localObject).onMenuOpened(paramPanelFeatureState.Wx, paramPanelFeatureState.hI))) {
              break label95;
            }
            a(paramPanelFeatureState, true);
            return;
          }
        }
        localObject = (WindowManager)this.mContext.getSystemService("window");
      } while ((localObject == null) || (!b(paramPanelFeatureState, paramKeyEvent)));
      if ((paramPanelFeatureState.Wy != null) && (!paramPanelFeatureState.WG)) {
        break label370;
      }
      if (paramPanelFeatureState.Wy != null) {
        break;
      }
      a(paramPanelFeatureState);
    } while (paramPanelFeatureState.Wy == null);
    label158:
    if ((c(paramPanelFeatureState)) && (paramPanelFeatureState.gk()))
    {
      paramKeyEvent = paramPanelFeatureState.Wz.getLayoutParams();
      if (paramKeyEvent != null) {
        break label406;
      }
      paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
    }
    label406:
    for (;;)
    {
      i = paramPanelFeatureState.background;
      paramPanelFeatureState.Wy.setBackgroundResource(i);
      ViewParent localViewParent = paramPanelFeatureState.Wz.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeView(paramPanelFeatureState.Wz);
      }
      paramPanelFeatureState.Wy.addView(paramPanelFeatureState.Wz, paramKeyEvent);
      if (!paramPanelFeatureState.Wz.hasFocus()) {
        paramPanelFeatureState.Wz.requestFocus();
      }
      i = -2;
      for (;;)
      {
        paramPanelFeatureState.WE = false;
        paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.x, paramPanelFeatureState.y, 1002, 8519680, -3);
        paramKeyEvent.gravity = paramPanelFeatureState.gravity;
        paramKeyEvent.windowAnimations = paramPanelFeatureState.windowAnimations;
        ((WindowManager)localObject).addView(paramPanelFeatureState.Wy, paramKeyEvent);
        paramPanelFeatureState.SE = true;
        return;
        if ((!paramPanelFeatureState.WG) || (paramPanelFeatureState.Wy.getChildCount() <= 0)) {
          break label158;
        }
        paramPanelFeatureState.Wy.removeAllViews();
        break label158;
        break;
        label370:
        if (paramPanelFeatureState.WA != null)
        {
          paramKeyEvent = paramPanelFeatureState.WA.getLayoutParams();
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
    paramPanelFeatureState.W(fX());
    paramPanelFeatureState.Wy = new f(paramPanelFeatureState.WC);
    paramPanelFeatureState.gravity = 81;
    return true;
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.isSystem()) {}
    while (((!paramPanelFeatureState.WD) && (!b(paramPanelFeatureState, paramKeyEvent))) || (paramPanelFeatureState.hI == null)) {
      return false;
    }
    return paramPanelFeatureState.hI.performShortcut(paramInt, paramKeyEvent, 1);
  }
  
  private boolean a(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    View localView = this.Ub.getDecorView();
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
    gd();
    if (this.VJ != null) {
      this.VJ.finish();
    }
    if ((this.VE != null) && (!this.mIsDestroyed)) {}
    for (;;)
    {
      try
      {
        b localb = this.VE.onWindowStartingSupportActionMode(parama);
        if (localb == null) {
          break label95;
        }
        this.VJ = localb;
        if ((this.VJ != null) && (this.VE != null)) {
          this.VE.onSupportActionModeStarted(this.VJ);
        }
        return this.VJ;
      }
      catch (AbstractMethodError localAbstractMethodError) {}
      Object localObject1 = null;
      continue;
      label95:
      Object localObject2;
      label201:
      boolean bool;
      if (this.VK == null)
      {
        if (!this.VX) {
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
          this.VK = new ActionBarContextView((Context)localObject1);
          this.VL = new PopupWindow((Context)localObject1, null, 2130968620);
          n.a(this.VL, 2);
          this.VL.setContentView(this.VK);
          this.VL.setWidth(-1);
          ((Context)localObject1).getTheme().resolveAttribute(2130968600, (TypedValue)localObject2, true);
          int i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, ((Context)localObject1).getResources().getDisplayMetrics());
          this.VK.setContentHeight(i);
          this.VL.setHeight(-2);
          this.VM = new Runnable()
          {
            public final void run()
            {
              AppCompatDelegateImpl.this.VL.showAtLocation(AppCompatDelegateImpl.this.VK, 55, 0, 0);
              AppCompatDelegateImpl.this.gd();
              if (AppCompatDelegateImpl.this.gb())
              {
                AppCompatDelegateImpl.this.VK.setAlpha(0.0F);
                AppCompatDelegateImpl.this.VN = android.support.v4.view.t.ag(AppCompatDelegateImpl.this.VK).w(1.0F);
                AppCompatDelegateImpl.this.VN.a(new z()
                {
                  public final void aH(View paramAnonymous2View)
                  {
                    AppCompatDelegateImpl.this.VK.setVisibility(0);
                  }
                  
                  public final void aI(View paramAnonymous2View)
                  {
                    AppCompatDelegateImpl.this.VK.setAlpha(1.0F);
                    AppCompatDelegateImpl.this.VN.a(null);
                    AppCompatDelegateImpl.this.VN = null;
                  }
                });
                return;
              }
              AppCompatDelegateImpl.this.VK.setAlpha(1.0F);
              AppCompatDelegateImpl.this.VK.setVisibility(0);
            }
          };
        }
      }
      else
      {
        label319:
        if (this.VK == null) {
          break label537;
        }
        gd();
        this.VK.hP();
        localObject1 = this.VK.getContext();
        localObject2 = this.VK;
        if (this.VL != null) {
          break label539;
        }
        bool = true;
        label361:
        localObject1 = new android.support.v7.view.e((Context)localObject1, (ActionBarContextView)localObject2, parama, bool);
        if (!parama.a((b)localObject1, ((b)localObject1).getMenu())) {
          break label598;
        }
        ((b)localObject1).invalidate();
        this.VK.c((b)localObject1);
        this.VJ = ((b)localObject1);
        if (!gb()) {
          break label544;
        }
        this.VK.setAlpha(0.0F);
        this.VN = android.support.v4.view.t.ag(this.VK).w(1.0F);
        this.VN.a(new z()
        {
          public final void aH(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.VK.setVisibility(0);
            AppCompatDelegateImpl.this.VK.sendAccessibilityEvent(32);
            if ((AppCompatDelegateImpl.this.VK.getParent() instanceof View)) {
              android.support.v4.view.t.ap((View)AppCompatDelegateImpl.this.VK.getParent());
            }
          }
          
          public final void aI(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.VK.setAlpha(1.0F);
            AppCompatDelegateImpl.this.VN.a(null);
            AppCompatDelegateImpl.this.VN = null;
          }
        });
      }
      for (;;)
      {
        if (this.VL == null) {
          break label596;
        }
        this.Ub.getDecorView().post(this.VM);
        break;
        localObject1 = this.mContext;
        break label201;
        label492:
        localObject1 = (ViewStubCompat)this.VQ.findViewById(2131296372);
        if (localObject1 == null) {
          break label319;
        }
        ((ViewStubCompat)localObject1).setLayoutInflater(LayoutInflater.from(fX()));
        this.VK = ((ActionBarContextView)((ViewStubCompat)localObject1).inflate());
        break label319;
        label537:
        break;
        label539:
        bool = false;
        break label361;
        label544:
        this.VK.setAlpha(1.0F);
        this.VK.setVisibility(0);
        this.VK.sendAccessibilityEvent(32);
        if ((this.VK.getParent() instanceof View)) {
          android.support.v4.view.t.ap((View)this.VK.getParent());
        }
      }
      label596:
      continue;
      label598:
      this.VJ = null;
    }
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState)
  {
    Context localContext = this.mContext;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if (((paramPanelFeatureState.Wx == 0) || (paramPanelFeatureState.Wx == 108)) && (this.VG != null))
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
    if (paramPanelFeatureState.WD) {
      return true;
    }
    if ((this.Wb != null) && (this.Wb != paramPanelFeatureState)) {
      a(this.Wb, false);
    }
    Window.Callback localCallback = this.Ub.getCallback();
    if (localCallback != null) {
      paramPanelFeatureState.WA = localCallback.onCreatePanelView(paramPanelFeatureState.Wx);
    }
    if ((paramPanelFeatureState.Wx == 0) || (paramPanelFeatureState.Wx == 108)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.VG != null)) {
        this.VG.hU();
      }
      if ((paramPanelFeatureState.WA != null) || ((i != 0) && ((this.mActionBar instanceof g)))) {
        break label408;
      }
      if ((paramPanelFeatureState.hI != null) && (!paramPanelFeatureState.WH)) {
        break label278;
      }
      if (paramPanelFeatureState.hI == null)
      {
        b(paramPanelFeatureState);
        if (paramPanelFeatureState.hI == null) {
          break;
        }
      }
      if ((i != 0) && (this.VG != null))
      {
        if (this.VH == null) {
          this.VH = new b();
        }
        this.VG.a(paramPanelFeatureState.hI, this.VH);
      }
      paramPanelFeatureState.hI.ht();
      if (localCallback.onCreatePanelMenu(paramPanelFeatureState.Wx, paramPanelFeatureState.hI)) {
        break label273;
      }
      paramPanelFeatureState.e(null);
      if ((i == 0) || (this.VG == null)) {
        break;
      }
      this.VG.a(null, this.VH);
      return false;
    }
    label273:
    paramPanelFeatureState.WH = false;
    label278:
    paramPanelFeatureState.hI.ht();
    if (paramPanelFeatureState.WI != null)
    {
      paramPanelFeatureState.hI.g(paramPanelFeatureState.WI);
      paramPanelFeatureState.WI = null;
    }
    if (!localCallback.onPreparePanel(0, paramPanelFeatureState.WA, paramPanelFeatureState.hI))
    {
      if ((i != 0) && (this.VG != null)) {
        this.VG.a(null, this.VH);
      }
      paramPanelFeatureState.hI.hu();
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
      paramPanelFeatureState.WF = bool;
      paramPanelFeatureState.hI.setQwertyMode(paramPanelFeatureState.WF);
      paramPanelFeatureState.hI.hu();
      paramPanelFeatureState.WD = true;
      paramPanelFeatureState.WE = false;
      this.Wb = paramPanelFeatureState;
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
      gh();
      return this.Wf.gj();
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
      if (!gi()) {
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
    if (paramPanelFeatureState.WA != null)
    {
      paramPanelFeatureState.Wz = paramPanelFeatureState.WA;
      return true;
    }
    if (paramPanelFeatureState.hI == null) {
      return false;
    }
    if (this.VI == null) {
      this.VI = new g();
    }
    paramPanelFeatureState.Wz = ((View)paramPanelFeatureState.b(this.VI));
    return paramPanelFeatureState.Wz != null;
  }
  
  private void fW()
  {
    fY();
    if ((!this.VU) || (this.mActionBar != null)) {}
    for (;;)
    {
      return;
      if ((this.VC instanceof Activity)) {
        this.mActionBar = new j((Activity)this.VC, this.VV);
      }
      while (this.mActionBar != null)
      {
        this.mActionBar.Q(this.Wj);
        return;
        if ((this.VC instanceof Dialog)) {
          this.mActionBar = new j((Dialog)this.VC);
        }
      }
    }
  }
  
  private Context fX()
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
  
  private void fY()
  {
    Object localObject;
    if (!this.VP)
    {
      this.VQ = fZ();
      localObject = getTitle();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (this.VG == null) {
          break label84;
        }
        this.VG.setWindowTitle((CharSequence)localObject);
      }
    }
    for (;;)
    {
      ga();
      this.VP = true;
      localObject = bi(0);
      if ((!this.mIsDestroyed) && ((localObject == null) || (((PanelFeatureState)localObject).hI == null))) {
        invalidatePanelMenu(108);
      }
      return;
      label84:
      if (this.mActionBar != null) {
        this.mActionBar.setWindowTitle((CharSequence)localObject);
      } else if (this.UA != null) {
        this.UA.setText((CharSequence)localObject);
      }
    }
  }
  
  private ViewGroup fZ()
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
      this.VX = ((TypedArray)localObject).getBoolean(0, false);
      ((TypedArray)localObject).recycle();
      this.Ub.getDecorView();
      localObject = LayoutInflater.from(this.mContext);
      if (this.VY) {
        break label423;
      }
      if (!this.VX) {
        break label261;
      }
      localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2131492903, null);
      this.VV = false;
      this.VU = false;
    }
    for (;;)
    {
      if (localObject == null)
      {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.VU + ", windowActionBarOverlay: " + this.VV + ", android:windowIsFloating: " + this.VX + ", windowActionModeOverlay: " + this.VW + ", windowNoTitle: " + this.VY + " }");
        if (!((TypedArray)localObject).getBoolean(111, false)) {
          break;
        }
        requestWindowFeature(108);
        break;
        label261:
        if (!this.VU) {
          break label631;
        }
        localObject = new TypedValue();
        this.mContext.getTheme().resolveAttribute(2130968606, (TypedValue)localObject, true);
        if (((TypedValue)localObject).resourceId != 0) {}
        for (localObject = new android.support.v7.view.d(this.mContext, ((TypedValue)localObject).resourceId);; localObject = this.mContext)
        {
          localObject = (ViewGroup)LayoutInflater.from((Context)localObject).inflate(2131492914, null);
          this.VG = ((android.support.v7.widget.t)((ViewGroup)localObject).findViewById(2131298945));
          this.VG.setWindowCallback(this.Ub.getCallback());
          if (this.VV) {
            this.VG.bv(109);
          }
          if (this.VS) {
            this.VG.bv(2);
          }
          if (this.VT) {
            this.VG.bv(5);
          }
          break;
        }
        label423:
        if (this.VW) {}
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
      if (this.VG == null) {
        this.UA = ((TextView)((ViewGroup)localObject).findViewById(2131305902));
      }
      bh.cg((View)localObject);
      ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject).findViewById(2131296344);
      ViewGroup localViewGroup = (ViewGroup)this.Ub.findViewById(16908290);
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
      this.Ub.setContentView((View)localObject);
      localContentFrameLayout.setAttachListener(new ContentFrameLayout.a()
      {
        public final void onDetachedFromWindow()
        {
          AppCompatDelegateImpl.this.gg();
        }
      });
      return localObject;
      label631:
      localObject = null;
    }
  }
  
  private void ga()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.VQ.findViewById(16908290);
    Object localObject = this.Ub.getDecorView();
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
  
  private int getNightMode()
  {
    if (this.Wd != -100) {
      return this.Wd;
    }
    return d.Vy;
  }
  
  private CharSequence getTitle()
  {
    if ((this.VC instanceof Activity)) {
      return ((Activity)this.VC).getTitle();
    }
    return this.Eo;
  }
  
  private void gf()
  {
    if (this.VP) {
      throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }
  }
  
  private void gh()
  {
    if (this.Wf == null) {
      this.Wf = new e(i.X(this.mContext));
    }
  }
  
  private boolean gi()
  {
    PackageManager localPackageManager;
    if ((this.We) && ((this.mContext instanceof Activity))) {
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
    this.Wh |= 1 << paramInt;
    if (!this.Wg)
    {
      android.support.v4.view.t.b(this.Ub.getDecorView(), this.Wi);
      this.Wg = true;
    }
  }
  
  final PanelFeatureState a(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.Wa;
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
      if ((localPanelFeatureState != null) && (localPanelFeatureState.hI == paramMenu))
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
          if (paramInt < this.Wa.length) {
            localPanelFeatureState = this.Wa[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.hI;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((PanelFeatureState)localObject1).SE)) {}
    while (this.mIsDestroyed) {
      return;
    }
    this.VC.onPanelClosed(paramInt, (Menu)localObject2);
  }
  
  final void a(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.Wx == 0) && (this.VG != null) && (this.VG.isOverflowMenuShowing())) {
      c(paramPanelFeatureState.hI);
    }
    do
    {
      return;
      WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
      if ((localWindowManager != null) && (paramPanelFeatureState.SE) && (paramPanelFeatureState.Wy != null))
      {
        localWindowManager.removeView(paramPanelFeatureState.Wy);
        if (paramBoolean) {
          a(paramPanelFeatureState.Wx, paramPanelFeatureState, null);
        }
      }
      paramPanelFeatureState.WD = false;
      paramPanelFeatureState.WE = false;
      paramPanelFeatureState.SE = false;
      paramPanelFeatureState.Wz = null;
      paramPanelFeatureState.WG = true;
    } while (this.Wb != paramPanelFeatureState);
    this.Wb = null;
  }
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = this.Ub.getCallback();
    if ((localCallback != null) && (!this.mIsDestroyed))
    {
      paramh = a(paramh.hA());
      if (paramh != null) {
        return localCallback.onMenuItemSelected(paramh.Wx, paramMenuItem);
      }
    }
    return false;
  }
  
  public final void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    fY();
    ((ViewGroup)this.VQ.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.VC.onContentChanged();
  }
  
  public final void b(h paramh)
  {
    if ((this.VG != null) && (this.VG.hS()) && ((!ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) || (this.VG.hT())))
    {
      paramh = this.Ub.getCallback();
      if (!this.VG.isOverflowMenuShowing()) {
        if ((paramh != null) && (!this.mIsDestroyed))
        {
          if ((this.Wg) && ((this.Wh & 0x1) != 0))
          {
            this.Ub.getDecorView().removeCallbacks(this.Wi);
            this.Wi.run();
          }
          PanelFeatureState localPanelFeatureState = bi(0);
          if ((localPanelFeatureState.hI != null) && (!localPanelFeatureState.WH) && (paramh.onPreparePanel(0, localPanelFeatureState.WA, localPanelFeatureState.hI)))
          {
            paramh.onMenuOpened(108, localPanelFeatureState.hI);
            this.VG.showOverflowMenu();
          }
        }
      }
      do
      {
        return;
        this.VG.hideOverflowMenu();
      } while (this.mIsDestroyed);
      paramh.onPanelClosed(108, bi(0).hI);
      return;
    }
    paramh = bi(0);
    paramh.WG = true;
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
    } while (!((PanelFeatureState)localObject).SE);
    a((PanelFeatureState)localObject, false);
  }
  
  protected final PanelFeatureState bi(int paramInt)
  {
    Object localObject2 = this.Wa;
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
      this.Wa = ((PanelFeatureState[])localObject1);
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
    if (localPanelFeatureState.hI != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState.hI.f(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState.WI = localBundle;
      }
      localPanelFeatureState.hI.ht();
      localPanelFeatureState.hI.clear();
    }
    localPanelFeatureState.WH = true;
    localPanelFeatureState.WG = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.VG != null))
    {
      localPanelFeatureState = bi(0);
      if (localPanelFeatureState != null)
      {
        localPanelFeatureState.WD = false;
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
    if ((this.VK != null) && ((this.VK.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.VK.getLayoutParams();
      if (this.VK.isShown())
      {
        if (this.Wk == null)
        {
          this.Wk = new Rect();
          this.Wl = new Rect();
        }
        localObject2 = this.Wk;
        Rect localRect = this.Wl;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        bh.a(this.VQ, (Rect)localObject2, localRect);
        if (localRect.top == 0)
        {
          i = paramInt;
          if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == i) {
            break label351;
          }
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
          if (this.VR != null) {
            break label274;
          }
          this.VR = new View(this.mContext);
          this.VR.setBackgroundColor(this.mContext.getResources().getColor(2131099852));
          this.VQ.addView(this.VR, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i = 1;
          label198:
          if (this.VR == null) {
            break label312;
          }
          label205:
          int k = paramInt;
          if (!this.VW)
          {
            k = paramInt;
            if (j != 0) {
              k = 0;
            }
          }
          paramInt = k;
          label228:
          if (i != 0) {
            this.VK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.VR != null)
      {
        localObject1 = this.VR;
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
        localObject2 = this.VR.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
        {
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          this.VR.setLayoutParams((ViewGroup.LayoutParams)localObject2);
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
    if (this.VZ) {
      return;
    }
    this.VZ = true;
    this.VG.gg();
    Window.Callback localCallback = this.Ub.getCallback();
    if ((localCallback != null) && (!this.mIsDestroyed)) {
      localCallback.onPanelClosed(108, paramh);
    }
    this.VZ = false;
  }
  
  final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (((this.VC instanceof e.a)) || ((this.VC instanceof e)))
    {
      localObject = this.Ub.getDecorView();
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
          } while ((paramKeyEvent.getKeyCode() == 82) && (this.VC.dispatchKeyEvent(paramKeyEvent)));
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
      } while (((PanelFeatureState)localObject).SE);
      b((PanelFeatureState)localObject, paramKeyEvent);
      return true;
      if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
      for (bool = true;; bool = false)
      {
        this.Wc = bool;
        break;
      }
      switch (j)
      {
      default: 
        return false;
      }
    } while (this.VJ != null);
    Object localObject = bi(0);
    if ((this.VG != null) && (this.VG.hS()) && (!ViewConfiguration.get(this.mContext).hasPermanentMenuKey())) {
      if (!this.VG.isOverflowMenuShowing())
      {
        if ((this.mIsDestroyed) || (!b((PanelFeatureState)localObject, paramKeyEvent))) {
          break label511;
        }
        bool = this.VG.showOverflowMenu();
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
      bool = this.VG.hideOverflowMenu();
      continue;
      if ((!((PanelFeatureState)localObject).SE) && (!((PanelFeatureState)localObject).WE)) {
        break label373;
      }
      bool = ((PanelFeatureState)localObject).SE;
      a((PanelFeatureState)localObject, true);
    }
    label373:
    if (((PanelFeatureState)localObject).WD)
    {
      if (!((PanelFeatureState)localObject).WH) {
        break label517;
      }
      ((PanelFeatureState)localObject).WD = false;
    }
    label517:
    for (boolean bool = b((PanelFeatureState)localObject, paramKeyEvent);; bool = true)
    {
      if (bool)
      {
        a((PanelFeatureState)localObject, paramKeyEvent);
        bool = true;
        break label296;
        bool = this.Wc;
        this.Wc = false;
        paramKeyEvent = bi(0);
        if ((paramKeyEvent != null) && (paramKeyEvent.SE))
        {
          if (bool) {
            break;
          }
          a(paramKeyEvent, true);
          return true;
        }
        if (this.VJ != null)
        {
          this.VJ.finish();
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
  
  public final void fT()
  {
    fY();
  }
  
  public final void fU()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    if (localLayoutInflater.getFactory() == null)
    {
      android.support.v4.view.f.b(localLayoutInflater, this);
      return;
    }
    localLayoutInflater.getFactory2();
  }
  
  public final boolean fV()
  {
    boolean bool = false;
    int i = getNightMode();
    int j = bm(i);
    if (j != -1) {
      bool = bn(j);
    }
    if (i == 0)
    {
      gh();
      this.Wf.setup();
    }
    this.We = true;
    return bool;
  }
  
  public final <T extends View> T findViewById(int paramInt)
  {
    fY();
    return this.Ub.findViewById(paramInt);
  }
  
  final boolean gb()
  {
    return (this.VP) && (this.VQ != null) && (android.support.v4.view.t.ay(this.VQ));
  }
  
  final void gd()
  {
    if (this.VN != null) {
      this.VN.cancel();
    }
  }
  
  final void ge()
  {
    a(bi(0), true);
  }
  
  public final a.a getDrawerToggleDelegate()
  {
    return new a();
  }
  
  public final MenuInflater getMenuInflater()
  {
    if (this.VF == null)
    {
      fW();
      if (this.mActionBar == null) {
        break label43;
      }
    }
    label43:
    for (Context localContext = this.mActionBar.getThemedContext();; localContext = this.mContext)
    {
      this.VF = new android.support.v7.view.g(localContext);
      return this.VF;
    }
  }
  
  public final ActionBar getSupportActionBar()
  {
    fW();
    return this.mActionBar;
  }
  
  final void gg()
  {
    if (this.VG != null) {
      this.VG.gg();
    }
    if (this.VL != null)
    {
      this.Ub.getDecorView().removeCallbacks(this.VM);
      if (!this.VL.isShowing()) {}
    }
    try
    {
      this.VL.dismiss();
      label55:
      this.VL = null;
      gd();
      PanelFeatureState localPanelFeatureState = bi(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.hI != null)) {
        localPanelFeatureState.hI.close();
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
    if ((localActionBar != null) && (localActionBar.fR())) {
      return;
    }
    invalidatePanelMenu(0);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.VU) && (this.VP))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
    android.support.v7.widget.g.iD().Z(this.mContext);
    fV();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    if ((this.VC instanceof Activity)) {}
    try
    {
      Object localObject1 = q.i((Activity)this.VC);
      if (localObject1 != null)
      {
        localObject1 = this.mActionBar;
        if (localObject1 == null) {
          this.Wj = true;
        }
      }
      else
      {
        if ((paramBundle != null) && (this.Wd == -100)) {
          this.Wd = paramBundle.getInt("appcompat:local_night_mode", -100);
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
    if (this.Wg) {
      this.Ub.getDecorView().removeCallbacks(this.Wi);
    }
    this.mIsDestroyed = true;
    if (this.mActionBar != null) {
      this.mActionBar.onDestroy();
    }
    if (this.Wf != null) {
      this.Wf.cleanup();
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
        if ((this.Wb == null) || (!a(this.Wb, paramKeyEvent.getKeyCode(), paramKeyEvent))) {
          break;
        }
      } while (this.Wb == null);
      this.Wb.WE = true;
      return true;
      if (this.Wb != null) {
        break;
      }
      localObject = bi(0);
      b((PanelFeatureState)localObject, paramKeyEvent);
      bool = a((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent);
      ((PanelFeatureState)localObject).WD = false;
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
    if (this.Wd != -100) {
      paramBundle.putInt("appcompat:local_night_mode", this.Wd);
    }
  }
  
  public final void onStart()
  {
    fV();
  }
  
  public final void onStop()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.R(false);
    }
    if (this.Wf != null) {
      this.Wf.cleanup();
    }
  }
  
  public final boolean requestWindowFeature(int paramInt)
  {
    paramInt = bl(paramInt);
    if ((this.VY) && (paramInt == 108)) {
      return false;
    }
    if ((this.VU) && (paramInt == 1)) {
      this.VU = false;
    }
    switch (paramInt)
    {
    default: 
      return this.Ub.requestFeature(paramInt);
    case 108: 
      gf();
      this.VU = true;
      return true;
    case 109: 
      gf();
      this.VV = true;
      return true;
    case 10: 
      gf();
      this.VW = true;
      return true;
    case 2: 
      gf();
      this.VS = true;
      return true;
    case 5: 
      gf();
      this.VT = true;
      return true;
    }
    gf();
    this.VY = true;
    return true;
  }
  
  public final void setContentView(int paramInt)
  {
    fY();
    ViewGroup localViewGroup = (ViewGroup)this.VQ.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.mContext).inflate(paramInt, localViewGroup);
    this.VC.onContentChanged();
  }
  
  public final void setContentView(View paramView)
  {
    fY();
    ViewGroup localViewGroup = (ViewGroup)this.VQ.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.VC.onContentChanged();
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    fY();
    ViewGroup localViewGroup = (ViewGroup)this.VQ.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.VC.onContentChanged();
  }
  
  public final void setSupportActionBar(Toolbar paramToolbar)
  {
    if (!(this.VC instanceof Activity)) {
      return;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar instanceof j)) {
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }
    this.VF = null;
    if (localActionBar != null) {
      localActionBar.onDestroy();
    }
    if (paramToolbar != null)
    {
      paramToolbar = new g(paramToolbar, ((Activity)this.VC).getTitle(), this.VD);
      this.mActionBar = paramToolbar;
      this.Ub.setCallback(paramToolbar.WZ);
    }
    for (;;)
    {
      invalidateOptionsMenu();
      return;
      this.mActionBar = null;
      this.Ub.setCallback(this.VD);
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.Eo = paramCharSequence;
    if (this.VG != null) {
      this.VG.setWindowTitle(paramCharSequence);
    }
    do
    {
      return;
      if (this.mActionBar != null)
      {
        this.mActionBar.setWindowTitle(paramCharSequence);
        return;
      }
    } while (this.UA == null);
    this.UA.setText(paramCharSequence);
  }
  
  public final b startSupportActionMode(b.a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (this.VJ != null) {
      this.VJ.finish();
    }
    parama = new c(parama);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      this.VJ = localActionBar.a(parama);
      if ((this.VJ != null) && (this.VE != null)) {
        this.VE.onSupportActionModeStarted(this.VJ);
      }
    }
    if (this.VJ == null) {
      this.VJ = b(parama);
    }
    return this.VJ;
  }
  
  protected static final class PanelFeatureState
  {
    boolean SE;
    View WA;
    android.support.v7.view.menu.f WB;
    Context WC;
    boolean WD;
    boolean WE;
    public boolean WF;
    boolean WG;
    boolean WH;
    Bundle WI;
    int Wx;
    ViewGroup Wy;
    View Wz;
    int background;
    int gravity;
    h hI;
    int windowAnimations;
    int x;
    int y;
    
    PanelFeatureState(int paramInt)
    {
      this.Wx = paramInt;
      this.WG = false;
    }
    
    final void W(Context paramContext)
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
        this.WC = paramContext;
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
      if (this.hI == null) {
        return null;
      }
      if (this.WB == null)
      {
        this.WB = new android.support.v7.view.menu.f(this.WC);
        this.WB.aci = parama;
        this.hI.a(this.WB);
      }
      return this.WB.c(this.Wy);
    }
    
    final void e(h paramh)
    {
      if (paramh == this.hI) {}
      do
      {
        return;
        if (this.hI != null) {
          this.hI.b(this.WB);
        }
        this.hI = paramh;
      } while ((paramh == null) || (this.WB == null));
      paramh.a(this.WB);
    }
    
    public final boolean gk()
    {
      if (this.Wz == null) {}
      do
      {
        return false;
        if (this.WA != null) {
          return true;
        }
      } while (this.WB.getAdapter().getCount() <= 0);
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
      Window.Callback localCallback = AppCompatDelegateImpl.this.Ub.getCallback();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramh);
      }
      return true;
    }
  }
  
  final class c
    implements b.a
  {
    private b.a Wq;
    
    public c(b.a parama)
    {
      this.Wq = parama;
    }
    
    public final void a(b paramb)
    {
      this.Wq.a(paramb);
      if (AppCompatDelegateImpl.this.VL != null) {
        AppCompatDelegateImpl.this.Ub.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.VM);
      }
      if (AppCompatDelegateImpl.this.VK != null)
      {
        AppCompatDelegateImpl.this.gd();
        AppCompatDelegateImpl.this.VN = android.support.v4.view.t.ag(AppCompatDelegateImpl.this.VK).w(0.0F);
        AppCompatDelegateImpl.this.VN.a(new z()
        {
          public final void aI(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.VK.setVisibility(8);
            if (AppCompatDelegateImpl.this.VL != null) {
              AppCompatDelegateImpl.this.VL.dismiss();
            }
            for (;;)
            {
              AppCompatDelegateImpl.this.VK.removeAllViews();
              AppCompatDelegateImpl.this.VN.a(null);
              AppCompatDelegateImpl.this.VN = null;
              return;
              if ((AppCompatDelegateImpl.this.VK.getParent() instanceof View)) {
                android.support.v4.view.t.ap((View)AppCompatDelegateImpl.this.VK.getParent());
              }
            }
          }
        });
      }
      if (AppCompatDelegateImpl.this.VE != null) {
        AppCompatDelegateImpl.this.VE.onSupportActionModeFinished(AppCompatDelegateImpl.this.VJ);
      }
      AppCompatDelegateImpl.this.VJ = null;
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      return this.Wq.a(paramb, paramMenu);
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.Wq.a(paramb, paramMenuItem);
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      return this.Wq.b(paramb, paramMenu);
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
          localh.adM = true;
        }
        bool2 = super.onPreparePanel(paramInt, paramView, paramMenu);
        bool1 = bool2;
      } while (localh == null);
      localh.adM = false;
      return bool2;
    }
    
    public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
    {
      AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = AppCompatDelegateImpl.this.bi(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.hI != null))
      {
        super.onProvideKeyboardShortcuts(paramList, localPanelFeatureState.hI, paramInt);
        return;
      }
      super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return null;
      }
      if (AppCompatDelegateImpl.this.VO) {
        return a(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if (AppCompatDelegateImpl.this.VO) {}
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
    i Ws;
    boolean Wt;
    private BroadcastReceiver Wu;
    private IntentFilter Wv;
    
    e(i parami)
    {
      this.Ws = parami;
      this.Wt = parami.gn();
    }
    
    final void cleanup()
    {
      if (this.Wu != null)
      {
        AppCompatDelegateImpl.this.mContext.unregisterReceiver(this.Wu);
        this.Wu = null;
      }
    }
    
    final int gj()
    {
      this.Wt = this.Ws.gn();
      if (this.Wt) {
        return 2;
      }
      return 1;
    }
    
    final void setup()
    {
      cleanup();
      if (this.Wu == null) {
        this.Wu = new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            paramAnonymousContext = AppCompatDelegateImpl.e.this;
            boolean bool = paramAnonymousContext.Ws.gn();
            if (bool != paramAnonymousContext.Wt)
            {
              paramAnonymousContext.Wt = bool;
              paramAnonymousContext.Wo.fV();
            }
          }
        };
      }
      if (this.Wv == null)
      {
        this.Wv = new IntentFilter();
        this.Wv.addAction("android.intent.action.TIME_SET");
        this.Wv.addAction("android.intent.action.TIMEZONE_CHANGED");
        this.Wv.addAction("android.intent.action.TIME_TICK");
      }
      AppCompatDelegateImpl.this.mContext.registerReceiver(this.Wu, this.Wv);
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
          AppCompatDelegateImpl.this.ge();
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
      h localh = paramh.hA();
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
          AppCompatDelegateImpl.this.a(paramh.Wx, paramh, localh);
          AppCompatDelegateImpl.this.a(paramh, true);
        }
        return;
      }
      AppCompatDelegateImpl.this.a(paramh, paramBoolean);
    }
    
    public final boolean d(h paramh)
    {
      if ((paramh == null) && (AppCompatDelegateImpl.this.VU))
      {
        Window.Callback localCallback = AppCompatDelegateImpl.this.Ub.getCallback();
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