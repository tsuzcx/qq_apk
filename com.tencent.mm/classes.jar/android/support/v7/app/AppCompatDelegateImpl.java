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
import android.support.v4.view.ac;
import android.support.v4.view.e.a;
import android.support.v4.view.u;
import android.support.v4.view.y;
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
import android.support.v7.widget.aa.a;
import android.support.v7.widget.az;
import android.support.v7.widget.be;
import android.support.v7.widget.bh;
import android.support.v7.widget.t;
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
  private static final boolean Yw;
  private static final int[] Yx;
  private static boolean Yy;
  private CharSequence Hn;
  final Window WZ;
  private TextView Xy;
  final Window.Callback YA;
  final c YB;
  MenuInflater YC;
  private t YD;
  private b YE;
  private g YF;
  b YG;
  ActionBarContextView YH;
  PopupWindow YI;
  Runnable YJ;
  y YK = null;
  boolean YL = true;
  private boolean YM;
  private ViewGroup YN;
  private View YO;
  private boolean YP;
  private boolean YQ;
  boolean YR;
  boolean YS;
  boolean YT;
  boolean YU;
  boolean YV;
  private boolean YW;
  private PanelFeatureState[] YX;
  private PanelFeatureState YY;
  private boolean YZ;
  final Window.Callback Yz;
  private int Za = -100;
  private boolean Zb;
  private e Zc;
  boolean Zd;
  int Ze;
  private final Runnable Zf = new Runnable()
  {
    public final void run()
    {
      if ((AppCompatDelegateImpl.this.Ze & 0x1) != 0) {
        AppCompatDelegateImpl.this.bk(0);
      }
      if ((AppCompatDelegateImpl.this.Ze & 0x1000) != 0) {
        AppCompatDelegateImpl.this.bk(108);
      }
      AppCompatDelegateImpl.this.Zd = false;
      AppCompatDelegateImpl.this.Ze = 0;
    }
  };
  private boolean Zg;
  private Rect Zh;
  private Rect Zi;
  private AppCompatViewInflater Zj;
  ActionBar mActionBar;
  final Context mContext;
  boolean mIsDestroyed;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      Yw = bool;
      Yx = new int[] { 16842836 };
      if ((Yw) && (!Yy))
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
              this.Zk.uncaughtException(paramAnonymousThread, (Throwable)localObject);
              return;
            }
            this.Zk.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
          }
        });
        Yy = true;
      }
      return;
    }
  }
  
  AppCompatDelegateImpl(Context paramContext, Window paramWindow, c paramc)
  {
    this.mContext = paramContext;
    this.WZ = paramWindow;
    this.YB = paramc;
    this.Yz = this.WZ.getCallback();
    if ((this.Yz instanceof d)) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    this.YA = new d(this.Yz);
    this.WZ.setCallback(this.YA);
    paramContext = az.a(paramContext, null, Yx);
    paramWindow = paramContext.cU(0);
    if (paramWindow != null) {
      this.WZ.setBackgroundDrawable(paramWindow);
    }
    paramContext.ayy.recycle();
  }
  
  private View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    String str;
    boolean bool;
    if (this.Zj == null)
    {
      str = this.mContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme).getString(110);
      if ((str == null) || (AppCompatViewInflater.class.getName().equals(str))) {
        this.Zj = new AppCompatViewInflater();
      }
    }
    else
    {
      if (!Yw) {
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
        return this.Zj.createView(paramView, paramString, paramContext, paramAttributeSet, bool, Yw, true, be.nk());
        try
        {
          this.Zj = ((AppCompatViewInflater)Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        catch (Throwable localThrowable)
        {
          new StringBuilder("Failed to instantiate custom view inflater ").append(str).append(". Falling back to default.");
          this.Zj = new AppCompatViewInflater();
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
    if ((paramPanelFeatureState.VC) || (this.mIsDestroyed)) {}
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
          if (paramPanelFeatureState.Zu == 0) {
            if ((this.mContext.getResources().getConfiguration().screenLayout & 0xF) != 4) {
              break label90;
            }
          }
          for (i = 1; i == 0; i = 0)
          {
            localObject = this.WZ.getCallback();
            if ((localObject == null) || (((Window.Callback)localObject).onMenuOpened(paramPanelFeatureState.Zu, paramPanelFeatureState.kE))) {
              break label95;
            }
            a(paramPanelFeatureState, true);
            return;
          }
        }
        localObject = (WindowManager)this.mContext.getSystemService("window");
      } while ((localObject == null) || (!b(paramPanelFeatureState, paramKeyEvent)));
      if ((paramPanelFeatureState.Zv != null) && (!paramPanelFeatureState.ZD)) {
        break label370;
      }
      if (paramPanelFeatureState.Zv != null) {
        break;
      }
      a(paramPanelFeatureState);
    } while (paramPanelFeatureState.Zv == null);
    label158:
    if ((c(paramPanelFeatureState)) && (paramPanelFeatureState.gQ()))
    {
      paramKeyEvent = paramPanelFeatureState.Zw.getLayoutParams();
      if (paramKeyEvent != null) {
        break label406;
      }
      paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
    }
    label406:
    for (;;)
    {
      i = paramPanelFeatureState.background;
      paramPanelFeatureState.Zv.setBackgroundResource(i);
      ViewParent localViewParent = paramPanelFeatureState.Zw.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeView(paramPanelFeatureState.Zw);
      }
      paramPanelFeatureState.Zv.addView(paramPanelFeatureState.Zw, paramKeyEvent);
      if (!paramPanelFeatureState.Zw.hasFocus()) {
        paramPanelFeatureState.Zw.requestFocus();
      }
      i = -2;
      for (;;)
      {
        paramPanelFeatureState.ZB = false;
        paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.x, paramPanelFeatureState.y, 1002, 8519680, -3);
        paramKeyEvent.gravity = paramPanelFeatureState.gravity;
        paramKeyEvent.windowAnimations = paramPanelFeatureState.windowAnimations;
        ((WindowManager)localObject).addView(paramPanelFeatureState.Zv, paramKeyEvent);
        paramPanelFeatureState.VC = true;
        return;
        if ((!paramPanelFeatureState.ZD) || (paramPanelFeatureState.Zv.getChildCount() <= 0)) {
          break label158;
        }
        paramPanelFeatureState.Zv.removeAllViews();
        break label158;
        break;
        label370:
        if (paramPanelFeatureState.Zx != null)
        {
          paramKeyEvent = paramPanelFeatureState.Zx.getLayoutParams();
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
    paramPanelFeatureState.Z(gE());
    paramPanelFeatureState.Zv = new f(paramPanelFeatureState.Zz);
    paramPanelFeatureState.gravity = 81;
    return true;
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.isSystem()) {}
    while (((!paramPanelFeatureState.ZA) && (!b(paramPanelFeatureState, paramKeyEvent))) || (paramPanelFeatureState.kE == null)) {
      return false;
    }
    return paramPanelFeatureState.kE.performShortcut(paramInt, paramKeyEvent, 1);
  }
  
  private boolean a(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    View localView = this.WZ.getDecorView();
    for (;;)
    {
      if (paramViewParent == null) {
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View)) || (u.aD((View)paramViewParent))) {
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
  }
  
  private b b(b.a parama)
  {
    gJ();
    if (this.YG != null) {
      this.YG.finish();
    }
    if ((this.YB != null) && (!this.mIsDestroyed)) {}
    for (;;)
    {
      try
      {
        b localb = this.YB.onWindowStartingSupportActionMode(parama);
        if (localb == null) {
          break label95;
        }
        this.YG = localb;
        if ((this.YG != null) && (this.YB != null)) {
          this.YB.onSupportActionModeStarted(this.YG);
        }
        return this.YG;
      }
      catch (AbstractMethodError localAbstractMethodError) {}
      Object localObject1 = null;
      continue;
      label95:
      Object localObject2;
      label201:
      boolean bool;
      if (this.YH == null)
      {
        if (!this.YU) {
          break label492;
        }
        localObject2 = new TypedValue();
        localObject1 = this.mContext.getTheme();
        ((Resources.Theme)localObject1).resolveAttribute(2130968607, (TypedValue)localObject2, true);
        if (((TypedValue)localObject2).resourceId != 0)
        {
          Resources.Theme localTheme = this.mContext.getResources().newTheme();
          localTheme.setTo((Resources.Theme)localObject1);
          localTheme.applyStyle(((TypedValue)localObject2).resourceId, true);
          localObject1 = new android.support.v7.view.d(this.mContext, 0);
          ((Context)localObject1).getTheme().setTo(localTheme);
          this.YH = new ActionBarContextView((Context)localObject1);
          this.YI = new PopupWindow((Context)localObject1, null, 2130968621);
          n.a(this.YI, 2);
          this.YI.setContentView(this.YH);
          this.YI.setWidth(-1);
          ((Context)localObject1).getTheme().resolveAttribute(2130968601, (TypedValue)localObject2, true);
          int i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, ((Context)localObject1).getResources().getDisplayMetrics());
          this.YH.setContentHeight(i);
          this.YI.setHeight(-2);
          this.YJ = new Runnable()
          {
            public final void run()
            {
              AppCompatDelegateImpl.this.YI.showAtLocation(AppCompatDelegateImpl.this.YH, 55, 0, 0);
              AppCompatDelegateImpl.this.gJ();
              if (AppCompatDelegateImpl.this.gI())
              {
                AppCompatDelegateImpl.this.YH.setAlpha(0.0F);
                AppCompatDelegateImpl.this.YK = u.ah(AppCompatDelegateImpl.this.YH).y(1.0F);
                AppCompatDelegateImpl.this.YK.a(new android.support.v4.view.aa()
                {
                  public final void aI(View paramAnonymous2View)
                  {
                    AppCompatDelegateImpl.this.YH.setVisibility(0);
                  }
                  
                  public final void aJ(View paramAnonymous2View)
                  {
                    AppCompatDelegateImpl.this.YH.setAlpha(1.0F);
                    AppCompatDelegateImpl.this.YK.a(null);
                    AppCompatDelegateImpl.this.YK = null;
                  }
                });
                return;
              }
              AppCompatDelegateImpl.this.YH.setAlpha(1.0F);
              AppCompatDelegateImpl.this.YH.setVisibility(0);
            }
          };
        }
      }
      else
      {
        label319:
        if (this.YH == null) {
          break label537;
        }
        gJ();
        this.YH.iy();
        localObject1 = this.YH.getContext();
        localObject2 = this.YH;
        if (this.YI != null) {
          break label539;
        }
        bool = true;
        label361:
        localObject1 = new android.support.v7.view.e((Context)localObject1, (ActionBarContextView)localObject2, parama, bool);
        if (!parama.a((b)localObject1, ((b)localObject1).getMenu())) {
          break label598;
        }
        ((b)localObject1).invalidate();
        this.YH.c((b)localObject1);
        this.YG = ((b)localObject1);
        if (!gI()) {
          break label544;
        }
        this.YH.setAlpha(0.0F);
        this.YK = u.ah(this.YH).y(1.0F);
        this.YK.a(new android.support.v4.view.aa()
        {
          public final void aI(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.YH.setVisibility(0);
            AppCompatDelegateImpl.this.YH.sendAccessibilityEvent(32);
            if ((AppCompatDelegateImpl.this.YH.getParent() instanceof View)) {
              u.ap((View)AppCompatDelegateImpl.this.YH.getParent());
            }
          }
          
          public final void aJ(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.YH.setAlpha(1.0F);
            AppCompatDelegateImpl.this.YK.a(null);
            AppCompatDelegateImpl.this.YK = null;
          }
        });
      }
      for (;;)
      {
        if (this.YI == null) {
          break label596;
        }
        this.WZ.getDecorView().post(this.YJ);
        break;
        localObject1 = this.mContext;
        break label201;
        label492:
        localObject1 = (ViewStubCompat)this.YN.findViewById(2131296397);
        if (localObject1 == null) {
          break label319;
        }
        ((ViewStubCompat)localObject1).setLayoutInflater(LayoutInflater.from(gE()));
        this.YH = ((ActionBarContextView)((ViewStubCompat)localObject1).inflate());
        break label319;
        label537:
        break;
        label539:
        bool = false;
        break label361;
        label544:
        this.YH.setAlpha(1.0F);
        this.YH.setVisibility(0);
        this.YH.sendAccessibilityEvent(32);
        if ((this.YH.getParent() instanceof View)) {
          u.ap((View)this.YH.getParent());
        }
      }
      label596:
      continue;
      label598:
      this.YG = null;
    }
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState)
  {
    Context localContext = this.mContext;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if (((paramPanelFeatureState.Zu == 0) || (paramPanelFeatureState.Zu == 108)) && (this.YD != null))
    {
      localTypedValue = new TypedValue();
      localTheme = localContext.getTheme();
      localTheme.resolveAttribute(2130968607, localTypedValue, true);
      localObject1 = null;
      if (localTypedValue.resourceId != 0)
      {
        localObject1 = localContext.getResources().newTheme();
        ((Resources.Theme)localObject1).setTo(localTheme);
        ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
        ((Resources.Theme)localObject1).resolveAttribute(2130968608, localTypedValue, true);
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
      localTheme.resolveAttribute(2130968608, localTypedValue, true);
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
    if (paramPanelFeatureState.ZA) {
      return true;
    }
    if ((this.YY != null) && (this.YY != paramPanelFeatureState)) {
      a(this.YY, false);
    }
    Window.Callback localCallback = this.WZ.getCallback();
    if (localCallback != null) {
      paramPanelFeatureState.Zx = localCallback.onCreatePanelView(paramPanelFeatureState.Zu);
    }
    if ((paramPanelFeatureState.Zu == 0) || (paramPanelFeatureState.Zu == 108)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.YD != null)) {
        this.YD.iD();
      }
      if ((paramPanelFeatureState.Zx != null) || ((i != 0) && ((this.mActionBar instanceof g)))) {
        break label408;
      }
      if ((paramPanelFeatureState.kE != null) && (!paramPanelFeatureState.ZE)) {
        break label278;
      }
      if (paramPanelFeatureState.kE == null)
      {
        b(paramPanelFeatureState);
        if (paramPanelFeatureState.kE == null) {
          break;
        }
      }
      if ((i != 0) && (this.YD != null))
      {
        if (this.YE == null) {
          this.YE = new b();
        }
        this.YD.a(paramPanelFeatureState.kE, this.YE);
      }
      paramPanelFeatureState.kE.ia();
      if (localCallback.onCreatePanelMenu(paramPanelFeatureState.Zu, paramPanelFeatureState.kE)) {
        break label273;
      }
      paramPanelFeatureState.e(null);
      if ((i == 0) || (this.YD == null)) {
        break;
      }
      this.YD.a(null, this.YE);
      return false;
    }
    label273:
    paramPanelFeatureState.ZE = false;
    label278:
    paramPanelFeatureState.kE.ia();
    if (paramPanelFeatureState.ZF != null)
    {
      paramPanelFeatureState.kE.g(paramPanelFeatureState.ZF);
      paramPanelFeatureState.ZF = null;
    }
    if (!localCallback.onPreparePanel(0, paramPanelFeatureState.Zx, paramPanelFeatureState.kE))
    {
      if ((i != 0) && (this.YD != null)) {
        this.YD.a(null, this.YE);
      }
      paramPanelFeatureState.kE.ib();
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
      paramPanelFeatureState.ZC = bool;
      paramPanelFeatureState.kE.setQwertyMode(paramPanelFeatureState.ZC);
      paramPanelFeatureState.kE.ib();
      paramPanelFeatureState.ZA = true;
      paramPanelFeatureState.ZB = false;
      this.YY = paramPanelFeatureState;
      return true;
      i = -1;
      break;
    }
  }
  
  private static int bm(int paramInt)
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
  
  private int bn(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      if ((Build.VERSION.SDK_INT >= 23) && (((UiModeManager)this.mContext.getSystemService(UiModeManager.class)).getNightMode() == 0)) {
        return -1;
      }
      gN();
      return this.Zc.gP();
    }
    return -1;
  }
  
  private boolean bo(int paramInt)
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
      if (!gO()) {
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
    if (paramPanelFeatureState.Zx != null)
    {
      paramPanelFeatureState.Zw = paramPanelFeatureState.Zx;
      return true;
    }
    if (paramPanelFeatureState.kE == null) {
      return false;
    }
    if (this.YF == null) {
      this.YF = new g();
    }
    paramPanelFeatureState.Zw = ((View)paramPanelFeatureState.b(this.YF));
    return paramPanelFeatureState.Zw != null;
  }
  
  private void gD()
  {
    gF();
    if ((!this.YR) || (this.mActionBar != null)) {}
    for (;;)
    {
      return;
      if ((this.Yz instanceof Activity)) {
        this.mActionBar = new j((Activity)this.Yz, this.YS);
      }
      while (this.mActionBar != null)
      {
        this.mActionBar.P(this.Zg);
        return;
        if ((this.Yz instanceof Dialog)) {
          this.mActionBar = new j((Dialog)this.Yz);
        }
      }
    }
  }
  
  private Context gE()
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
  
  private void gF()
  {
    Object localObject;
    if (!this.YM)
    {
      this.YN = gG();
      localObject = getTitle();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (this.YD == null) {
          break label84;
        }
        this.YD.setWindowTitle((CharSequence)localObject);
      }
    }
    for (;;)
    {
      gH();
      this.YM = true;
      localObject = bj(0);
      if ((!this.mIsDestroyed) && ((localObject == null) || (((PanelFeatureState)localObject).kE == null))) {
        invalidatePanelMenu(108);
      }
      return;
      label84:
      if (this.mActionBar != null) {
        this.mActionBar.setWindowTitle((CharSequence)localObject);
      } else if (this.Xy != null) {
        this.Xy.setText((CharSequence)localObject);
      }
    }
  }
  
  private ViewGroup gG()
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
      this.YU = ((TypedArray)localObject).getBoolean(0, false);
      ((TypedArray)localObject).recycle();
      this.WZ.getDecorView();
      localObject = LayoutInflater.from(this.mContext);
      if (this.YV) {
        break label423;
      }
      if (!this.YU) {
        break label261;
      }
      localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2131492920, null);
      this.YS = false;
      this.YR = false;
    }
    for (;;)
    {
      if (localObject == null)
      {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.YR + ", windowActionBarOverlay: " + this.YS + ", android:windowIsFloating: " + this.YU + ", windowActionModeOverlay: " + this.YT + ", windowNoTitle: " + this.YV + " }");
        if (!((TypedArray)localObject).getBoolean(111, false)) {
          break;
        }
        requestWindowFeature(108);
        break;
        label261:
        if (!this.YR) {
          break label631;
        }
        localObject = new TypedValue();
        this.mContext.getTheme().resolveAttribute(2130968607, (TypedValue)localObject, true);
        if (((TypedValue)localObject).resourceId != 0) {}
        for (localObject = new android.support.v7.view.d(this.mContext, ((TypedValue)localObject).resourceId);; localObject = this.mContext)
        {
          localObject = (ViewGroup)LayoutInflater.from((Context)localObject).inflate(2131492931, null);
          this.YD = ((t)((ViewGroup)localObject).findViewById(2131299436));
          this.YD.setWindowCallback(this.WZ.getCallback());
          if (this.YS) {
            this.YD.bw(109);
          }
          if (this.YP) {
            this.YD.bw(2);
          }
          if (this.YQ) {
            this.YD.bw(5);
          }
          break;
        }
        label423:
        if (this.YT) {}
        for (localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2131492930, null);; localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2131492929, null))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label480;
          }
          u.a((View)localObject, new android.support.v4.view.p()
          {
            public final ac a(View paramAnonymousView, ac paramAnonymousac)
            {
              int i = paramAnonymousac.getSystemWindowInsetTop();
              int j = AppCompatDelegateImpl.this.bl(i);
              ac localac = paramAnonymousac;
              if (i != j) {
                localac = paramAnonymousac.f(paramAnonymousac.getSystemWindowInsetLeft(), j, paramAnonymousac.getSystemWindowInsetRight(), paramAnonymousac.getSystemWindowInsetBottom());
              }
              return u.a(paramAnonymousView, localac);
            }
          });
          break;
        }
        label480:
        ((android.support.v7.widget.aa)localObject).setOnFitSystemWindowsListener(new aa.a()
        {
          public final void f(Rect paramAnonymousRect)
          {
            paramAnonymousRect.top = AppCompatDelegateImpl.this.bl(paramAnonymousRect.top);
          }
        });
        continue;
      }
      if (this.YD == null) {
        this.Xy = ((TextView)((ViewGroup)localObject).findViewById(2131309195));
      }
      bh.bS((View)localObject);
      ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject).findViewById(2131296364);
      ViewGroup localViewGroup = (ViewGroup)this.WZ.findViewById(16908290);
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
      this.WZ.setContentView((View)localObject);
      localContentFrameLayout.setAttachListener(new ContentFrameLayout.a()
      {
        public final void onDetachedFromWindow()
        {
          AppCompatDelegateImpl.this.gM();
        }
      });
      return localObject;
      label631:
      localObject = null;
    }
  }
  
  private void gH()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.YN.findViewById(16908290);
    Object localObject = this.WZ.getDecorView();
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
  
  private void gL()
  {
    if (this.YM) {
      throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }
  }
  
  private void gN()
  {
    if (this.Zc == null) {
      this.Zc = new e(i.aa(this.mContext));
    }
  }
  
  private boolean gO()
  {
    PackageManager localPackageManager;
    if ((this.Zb) && ((this.mContext instanceof Activity))) {
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
  
  private int getNightMode()
  {
    if (this.Za != -100) {
      return this.Za;
    }
    return d.Yv;
  }
  
  private CharSequence getTitle()
  {
    if ((this.Yz instanceof Activity)) {
      return ((Activity)this.Yz).getTitle();
    }
    return this.Hn;
  }
  
  private void invalidatePanelMenu(int paramInt)
  {
    this.Ze |= 1 << paramInt;
    if (!this.Zd)
    {
      u.b(this.WZ.getDecorView(), this.Zf);
      this.Zd = true;
    }
  }
  
  final PanelFeatureState a(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.YX;
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
      if ((localPanelFeatureState != null) && (localPanelFeatureState.kE == paramMenu))
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
          if (paramInt < this.YX.length) {
            localPanelFeatureState = this.YX[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.kE;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((PanelFeatureState)localObject1).VC)) {}
    while (this.mIsDestroyed) {
      return;
    }
    this.Yz.onPanelClosed(paramInt, (Menu)localObject2);
  }
  
  final void a(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.Zu == 0) && (this.YD != null) && (this.YD.isOverflowMenuShowing())) {
      c(paramPanelFeatureState.kE);
    }
    do
    {
      return;
      WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
      if ((localWindowManager != null) && (paramPanelFeatureState.VC) && (paramPanelFeatureState.Zv != null))
      {
        localWindowManager.removeView(paramPanelFeatureState.Zv);
        if (paramBoolean) {
          a(paramPanelFeatureState.Zu, paramPanelFeatureState, null);
        }
      }
      paramPanelFeatureState.ZA = false;
      paramPanelFeatureState.ZB = false;
      paramPanelFeatureState.VC = false;
      paramPanelFeatureState.Zw = null;
      paramPanelFeatureState.ZD = true;
    } while (this.YY != paramPanelFeatureState);
    this.YY = null;
  }
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = this.WZ.getCallback();
    if ((localCallback != null) && (!this.mIsDestroyed))
    {
      paramh = a(paramh.ii());
      if (paramh != null) {
        return localCallback.onMenuItemSelected(paramh.Zu, paramMenuItem);
      }
    }
    return false;
  }
  
  public final void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    gF();
    ((ViewGroup)this.YN.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.Yz.onContentChanged();
  }
  
  public final void b(h paramh)
  {
    if ((this.YD != null) && (this.YD.iB()) && ((!ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) || (this.YD.iC())))
    {
      paramh = this.WZ.getCallback();
      if (!this.YD.isOverflowMenuShowing()) {
        if ((paramh != null) && (!this.mIsDestroyed))
        {
          if ((this.Zd) && ((this.Ze & 0x1) != 0))
          {
            this.WZ.getDecorView().removeCallbacks(this.Zf);
            this.Zf.run();
          }
          PanelFeatureState localPanelFeatureState = bj(0);
          if ((localPanelFeatureState.kE != null) && (!localPanelFeatureState.ZE) && (paramh.onPreparePanel(0, localPanelFeatureState.Zx, localPanelFeatureState.kE)))
          {
            paramh.onMenuOpened(108, localPanelFeatureState.kE);
            this.YD.showOverflowMenu();
          }
        }
      }
      do
      {
        return;
        this.YD.hideOverflowMenu();
      } while (this.mIsDestroyed);
      paramh.onPanelClosed(108, bj(0).kE);
      return;
    }
    paramh = bj(0);
    paramh.ZD = true;
    a(paramh, false);
    a(paramh, null);
  }
  
  final void bi(int paramInt)
  {
    Object localObject;
    if (paramInt == 108)
    {
      localObject = getSupportActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).R(false);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      localObject = bj(paramInt);
    } while (!((PanelFeatureState)localObject).VC);
    a((PanelFeatureState)localObject, false);
  }
  
  protected final PanelFeatureState bj(int paramInt)
  {
    Object localObject2 = this.YX;
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
      this.YX = ((PanelFeatureState[])localObject1);
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
  
  final void bk(int paramInt)
  {
    PanelFeatureState localPanelFeatureState = bj(paramInt);
    if (localPanelFeatureState.kE != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState.kE.f(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState.ZF = localBundle;
      }
      localPanelFeatureState.kE.ia();
      localPanelFeatureState.kE.clear();
    }
    localPanelFeatureState.ZE = true;
    localPanelFeatureState.ZD = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.YD != null))
    {
      localPanelFeatureState = bj(0);
      if (localPanelFeatureState != null)
      {
        localPanelFeatureState.ZA = false;
        b(localPanelFeatureState, null);
      }
    }
  }
  
  final int bl(int paramInt)
  {
    int j = 1;
    int m = 0;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.YH != null) && ((this.YH.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.YH.getLayoutParams();
      if (this.YH.isShown())
      {
        if (this.Zh == null)
        {
          this.Zh = new Rect();
          this.Zi = new Rect();
        }
        localObject2 = this.Zh;
        Rect localRect = this.Zi;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        bh.a(this.YN, (Rect)localObject2, localRect);
        if (localRect.top == 0)
        {
          i = paramInt;
          if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == i) {
            break label351;
          }
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
          if (this.YO != null) {
            break label274;
          }
          this.YO = new View(this.mContext);
          this.YO.setBackgroundColor(this.mContext.getResources().getColor(2131099870));
          this.YN.addView(this.YO, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i = 1;
          label198:
          if (this.YO == null) {
            break label312;
          }
          label205:
          int k = paramInt;
          if (!this.YT)
          {
            k = paramInt;
            if (j != 0) {
              k = 0;
            }
          }
          paramInt = k;
          label228:
          if (i != 0) {
            this.YH.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.YO != null)
      {
        localObject1 = this.YO;
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
        localObject2 = this.YO.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
        {
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          this.YO.setLayoutParams((ViewGroup.LayoutParams)localObject2);
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
    if (this.YW) {
      return;
    }
    this.YW = true;
    this.YD.gM();
    Window.Callback localCallback = this.WZ.getCallback();
    if ((localCallback != null) && (!this.mIsDestroyed)) {
      localCallback.onPanelClosed(108, paramh);
    }
    this.YW = false;
  }
  
  final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (((this.Yz instanceof e.a)) || ((this.Yz instanceof e)))
    {
      localObject = this.WZ.getDecorView();
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
          } while ((paramKeyEvent.getKeyCode() == 82) && (this.Yz.dispatchKeyEvent(paramKeyEvent)));
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
        localObject = bj(0);
      } while (((PanelFeatureState)localObject).VC);
      b((PanelFeatureState)localObject, paramKeyEvent);
      return true;
      if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
      for (bool = true;; bool = false)
      {
        this.YZ = bool;
        break;
      }
      switch (j)
      {
      default: 
        return false;
      }
    } while (this.YG != null);
    Object localObject = bj(0);
    if ((this.YD != null) && (this.YD.iB()) && (!ViewConfiguration.get(this.mContext).hasPermanentMenuKey())) {
      if (!this.YD.isOverflowMenuShowing())
      {
        if ((this.mIsDestroyed) || (!b((PanelFeatureState)localObject, paramKeyEvent))) {
          break label511;
        }
        bool = this.YD.showOverflowMenu();
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
      bool = this.YD.hideOverflowMenu();
      continue;
      if ((!((PanelFeatureState)localObject).VC) && (!((PanelFeatureState)localObject).ZB)) {
        break label373;
      }
      bool = ((PanelFeatureState)localObject).VC;
      a((PanelFeatureState)localObject, true);
    }
    label373:
    if (((PanelFeatureState)localObject).ZA)
    {
      if (!((PanelFeatureState)localObject).ZE) {
        break label517;
      }
      ((PanelFeatureState)localObject).ZA = false;
    }
    label517:
    for (boolean bool = b((PanelFeatureState)localObject, paramKeyEvent);; bool = true)
    {
      if (bool)
      {
        a((PanelFeatureState)localObject, paramKeyEvent);
        bool = true;
        break label296;
        bool = this.YZ;
        this.YZ = false;
        paramKeyEvent = bj(0);
        if ((paramKeyEvent != null) && (paramKeyEvent.VC))
        {
          if (bool) {
            break;
          }
          a(paramKeyEvent, true);
          return true;
        }
        if (this.YG != null)
        {
          this.YG.finish();
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
    gF();
    return this.WZ.findViewById(paramInt);
  }
  
  public final void gA()
  {
    gF();
  }
  
  public final void gB()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    if (localLayoutInflater.getFactory() == null)
    {
      android.support.v4.view.f.b(localLayoutInflater, this);
      return;
    }
    localLayoutInflater.getFactory2();
  }
  
  public final boolean gC()
  {
    boolean bool = false;
    int i = getNightMode();
    int j = bn(i);
    if (j != -1) {
      bool = bo(j);
    }
    if (i == 0)
    {
      gN();
      this.Zc.setup();
    }
    this.Zb = true;
    return bool;
  }
  
  final boolean gI()
  {
    return (this.YM) && (this.YN != null) && (u.az(this.YN));
  }
  
  final void gJ()
  {
    if (this.YK != null) {
      this.YK.cancel();
    }
  }
  
  final void gK()
  {
    a(bj(0), true);
  }
  
  final void gM()
  {
    if (this.YD != null) {
      this.YD.gM();
    }
    if (this.YI != null)
    {
      this.WZ.getDecorView().removeCallbacks(this.YJ);
      if (!this.YI.isShowing()) {}
    }
    try
    {
      this.YI.dismiss();
      label55:
      this.YI = null;
      gJ();
      PanelFeatureState localPanelFeatureState = bj(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.kE != null)) {
        localPanelFeatureState.kE.close();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label55;
    }
  }
  
  public final a.a getDrawerToggleDelegate()
  {
    return new a();
  }
  
  public final MenuInflater getMenuInflater()
  {
    if (this.YC == null)
    {
      gD();
      if (this.mActionBar == null) {
        break label43;
      }
    }
    label43:
    for (Context localContext = this.mActionBar.getThemedContext();; localContext = this.mContext)
    {
      this.YC = new android.support.v7.view.g(localContext);
      return this.YC;
    }
  }
  
  public final ActionBar getSupportActionBar()
  {
    gD();
    return this.mActionBar;
  }
  
  public final void invalidateOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar != null) && (localActionBar.gy())) {
      return;
    }
    invalidatePanelMenu(0);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.YR) && (this.YM))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
    android.support.v7.widget.g.jk().ac(this.mContext);
    gC();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    if ((this.Yz instanceof Activity)) {}
    try
    {
      Object localObject1 = q.i((Activity)this.Yz);
      if (localObject1 != null)
      {
        localObject1 = this.mActionBar;
        if (localObject1 == null) {
          this.Zg = true;
        }
      }
      else
      {
        if ((paramBundle != null) && (this.Za == -100)) {
          this.Za = paramBundle.getInt("appcompat:local_night_mode", -100);
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
        localObject2.P(true);
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
    if (this.Zd) {
      this.WZ.getDecorView().removeCallbacks(this.Zf);
    }
    this.mIsDestroyed = true;
    if (this.mActionBar != null) {
      this.mActionBar.onDestroy();
    }
    if (this.Zc != null) {
      this.Zc.cleanup();
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
        if ((this.YY == null) || (!a(this.YY, paramKeyEvent.getKeyCode(), paramKeyEvent))) {
          break;
        }
      } while (this.YY == null);
      this.YY.ZB = true;
      return true;
      if (this.YY != null) {
        break;
      }
      localObject = bj(0);
      b((PanelFeatureState)localObject, paramKeyEvent);
      bool = a((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent);
      ((PanelFeatureState)localObject).ZA = false;
    } while (bool);
    return false;
  }
  
  public final void onPostResume()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.Q(true);
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.Za != -100) {
      paramBundle.putInt("appcompat:local_night_mode", this.Za);
    }
  }
  
  public final void onStart()
  {
    gC();
  }
  
  public final void onStop()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.Q(false);
    }
    if (this.Zc != null) {
      this.Zc.cleanup();
    }
  }
  
  public final boolean requestWindowFeature(int paramInt)
  {
    paramInt = bm(paramInt);
    if ((this.YV) && (paramInt == 108)) {
      return false;
    }
    if ((this.YR) && (paramInt == 1)) {
      this.YR = false;
    }
    switch (paramInt)
    {
    default: 
      return this.WZ.requestFeature(paramInt);
    case 108: 
      gL();
      this.YR = true;
      return true;
    case 109: 
      gL();
      this.YS = true;
      return true;
    case 10: 
      gL();
      this.YT = true;
      return true;
    case 2: 
      gL();
      this.YP = true;
      return true;
    case 5: 
      gL();
      this.YQ = true;
      return true;
    }
    gL();
    this.YV = true;
    return true;
  }
  
  public final void setContentView(int paramInt)
  {
    gF();
    ViewGroup localViewGroup = (ViewGroup)this.YN.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.mContext).inflate(paramInt, localViewGroup);
    this.Yz.onContentChanged();
  }
  
  public final void setContentView(View paramView)
  {
    gF();
    ViewGroup localViewGroup = (ViewGroup)this.YN.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.Yz.onContentChanged();
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    gF();
    ViewGroup localViewGroup = (ViewGroup)this.YN.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.Yz.onContentChanged();
  }
  
  public final void setSupportActionBar(Toolbar paramToolbar)
  {
    if (!(this.Yz instanceof Activity)) {
      return;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar instanceof j)) {
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }
    this.YC = null;
    if (localActionBar != null) {
      localActionBar.onDestroy();
    }
    if (paramToolbar != null)
    {
      paramToolbar = new g(paramToolbar, ((Activity)this.Yz).getTitle(), this.YA);
      this.mActionBar = paramToolbar;
      this.WZ.setCallback(paramToolbar.ZW);
    }
    for (;;)
    {
      invalidateOptionsMenu();
      return;
      this.mActionBar = null;
      this.WZ.setCallback(this.YA);
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.Hn = paramCharSequence;
    if (this.YD != null) {
      this.YD.setWindowTitle(paramCharSequence);
    }
    do
    {
      return;
      if (this.mActionBar != null)
      {
        this.mActionBar.setWindowTitle(paramCharSequence);
        return;
      }
    } while (this.Xy == null);
    this.Xy.setText(paramCharSequence);
  }
  
  public final b startSupportActionMode(b.a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (this.YG != null) {
      this.YG.finish();
    }
    parama = new c(parama);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      this.YG = localActionBar.a(parama);
      if ((this.YG != null) && (this.YB != null)) {
        this.YB.onSupportActionModeStarted(this.YG);
      }
    }
    if (this.YG == null) {
      this.YG = b(parama);
    }
    return this.YG;
  }
  
  protected static final class PanelFeatureState
  {
    boolean VC;
    boolean ZA;
    boolean ZB;
    public boolean ZC;
    boolean ZD;
    boolean ZE;
    Bundle ZF;
    int Zu;
    ViewGroup Zv;
    View Zw;
    View Zx;
    android.support.v7.view.menu.f Zy;
    Context Zz;
    int background;
    int gravity;
    h kE;
    int windowAnimations;
    int x;
    int y;
    
    PanelFeatureState(int paramInt)
    {
      this.Zu = paramInt;
      this.ZD = false;
    }
    
    final void Z(Context paramContext)
    {
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(2130968600, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      localTheme.resolveAttribute(2130969439, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      for (;;)
      {
        paramContext = new android.support.v7.view.d(paramContext, 0);
        paramContext.getTheme().setTo(localTheme);
        this.Zz = paramContext;
        paramContext = paramContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme);
        this.background = paramContext.getResourceId(80, 0);
        this.windowAnimations = paramContext.getResourceId(1, 0);
        paramContext.recycle();
        return;
        localTheme.applyStyle(2131821459, true);
      }
    }
    
    final android.support.v7.view.menu.p b(o.a parama)
    {
      if (this.kE == null) {
        return null;
      }
      if (this.Zy == null)
      {
        this.Zy = new android.support.v7.view.menu.f(this.Zz);
        this.Zy.afg = parama;
        this.kE.a(this.Zy);
      }
      return this.Zy.c(this.Zv);
    }
    
    final void e(h paramh)
    {
      if (paramh == this.kE) {}
      do
      {
        return;
        if (this.kE != null) {
          this.kE.b(this.Zy);
        }
        this.kE = paramh;
      } while ((paramh == null) || (this.Zy == null));
      paramh.a(this.Zy);
    }
    
    public final boolean gQ()
    {
      if (this.Zw == null) {}
      do
      {
        return false;
        if (this.Zx != null) {
          return true;
        }
      } while (this.Zy.getAdapter().getCount() <= 0);
      return true;
    }
  }
  
  final class a
    implements a.a
  {
    a() {}
    
    public final void bh(int paramInt)
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
      Window.Callback localCallback = AppCompatDelegateImpl.this.WZ.getCallback();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramh);
      }
      return true;
    }
  }
  
  final class c
    implements b.a
  {
    private b.a Zn;
    
    public c(b.a parama)
    {
      this.Zn = parama;
    }
    
    public final void a(b paramb)
    {
      this.Zn.a(paramb);
      if (AppCompatDelegateImpl.this.YI != null) {
        AppCompatDelegateImpl.this.WZ.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.YJ);
      }
      if (AppCompatDelegateImpl.this.YH != null)
      {
        AppCompatDelegateImpl.this.gJ();
        AppCompatDelegateImpl.this.YK = u.ah(AppCompatDelegateImpl.this.YH).y(0.0F);
        AppCompatDelegateImpl.this.YK.a(new android.support.v4.view.aa()
        {
          public final void aJ(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.YH.setVisibility(8);
            if (AppCompatDelegateImpl.this.YI != null) {
              AppCompatDelegateImpl.this.YI.dismiss();
            }
            for (;;)
            {
              AppCompatDelegateImpl.this.YH.removeAllViews();
              AppCompatDelegateImpl.this.YK.a(null);
              AppCompatDelegateImpl.this.YK = null;
              return;
              if ((AppCompatDelegateImpl.this.YH.getParent() instanceof View)) {
                u.ap((View)AppCompatDelegateImpl.this.YH.getParent());
              }
            }
          }
        });
      }
      if (AppCompatDelegateImpl.this.YB != null) {
        AppCompatDelegateImpl.this.YB.onSupportActionModeFinished(AppCompatDelegateImpl.this.YG);
      }
      AppCompatDelegateImpl.this.YG = null;
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      return this.Zn.a(paramb, paramMenu);
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.Zn.a(paramb, paramMenuItem);
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      return this.Zn.b(paramb, paramMenu);
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
          paramMenu.R(true);
        }
      }
      return true;
    }
    
    public final void onPanelClosed(int paramInt, Menu paramMenu)
    {
      super.onPanelClosed(paramInt, paramMenu);
      AppCompatDelegateImpl.this.bi(paramInt);
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
          localh.agK = true;
        }
        bool2 = super.onPreparePanel(paramInt, paramView, paramMenu);
        bool1 = bool2;
      } while (localh == null);
      localh.agK = false;
      return bool2;
    }
    
    public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
    {
      AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = AppCompatDelegateImpl.this.bj(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.kE != null))
      {
        super.onProvideKeyboardShortcuts(paramList, localPanelFeatureState.kE, paramInt);
        return;
      }
      super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return null;
      }
      if (AppCompatDelegateImpl.this.YL) {
        return a(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if (AppCompatDelegateImpl.this.YL) {}
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
    i Zp;
    boolean Zq;
    private BroadcastReceiver Zr;
    private IntentFilter Zs;
    
    e(i parami)
    {
      this.Zp = parami;
      this.Zq = parami.gT();
    }
    
    final void cleanup()
    {
      if (this.Zr != null)
      {
        AppCompatDelegateImpl.this.mContext.unregisterReceiver(this.Zr);
        this.Zr = null;
      }
    }
    
    final int gP()
    {
      this.Zq = this.Zp.gT();
      if (this.Zq) {
        return 2;
      }
      return 1;
    }
    
    final void setup()
    {
      cleanup();
      if (this.Zr == null) {
        this.Zr = new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            paramAnonymousContext = AppCompatDelegateImpl.e.this;
            boolean bool = paramAnonymousContext.Zp.gT();
            if (bool != paramAnonymousContext.Zq)
            {
              paramAnonymousContext.Zq = bool;
              paramAnonymousContext.Zl.gC();
            }
          }
        };
      }
      if (this.Zs == null)
      {
        this.Zs = new IntentFilter();
        this.Zs.addAction("android.intent.action.TIME_SET");
        this.Zs.addAction("android.intent.action.TIMEZONE_CHANGED");
        this.Zs.addAction("android.intent.action.TIME_TICK");
      }
      AppCompatDelegateImpl.this.mContext.registerReceiver(this.Zr, this.Zs);
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
          AppCompatDelegateImpl.this.gK();
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
      h localh = paramh.ii();
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
          AppCompatDelegateImpl.this.a(paramh.Zu, paramh, localh);
          AppCompatDelegateImpl.this.a(paramh, true);
        }
        return;
      }
      AppCompatDelegateImpl.this.a(paramh, paramBoolean);
    }
    
    public final boolean d(h paramh)
    {
      if ((paramh == null) && (AppCompatDelegateImpl.this.YR))
      {
        Window.Callback localCallback = AppCompatDelegateImpl.this.WZ.getCallback();
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