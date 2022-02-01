package androidx.appcompat.app;

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
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import androidx.appcompat.a.c;
import androidx.appcompat.a.f;
import androidx.appcompat.a.g;
import androidx.appcompat.a.i;
import androidx.appcompat.a.j;
import androidx.appcompat.a.a.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.b.a;
import androidx.appcompat.view.menu.h.a;
import androidx.appcompat.view.menu.o.a;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ContentFrameLayout.a;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ac;
import androidx.appcompat.widget.ai;
import androidx.appcompat.widget.m;
import androidx.appcompat.widget.q;
import androidx.appcompat.widget.q.a;
import androidx.core.g.ad;
import androidx.core.g.af;
import androidx.core.g.ah;
import androidx.core.g.s;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class AppCompatDelegateImpl
  extends d
  implements LayoutInflater.Factory2, h.a
{
  private static final boolean gM;
  private static final int[] gN;
  private static boolean gO;
  private CharSequence cZ;
  private TextView fO;
  final Window fo;
  final Window.Callback gP;
  final Window.Callback gQ;
  final c gR;
  MenuInflater gS;
  private m gT;
  private b gU;
  private g gV;
  b gW;
  ActionBarContextView gX;
  PopupWindow gY;
  Runnable gZ;
  ad ha;
  boolean hb;
  private boolean hc;
  private ViewGroup hd;
  private View he;
  private boolean hf;
  private boolean hg;
  boolean hh;
  boolean hi;
  boolean hj;
  boolean hk;
  boolean hl;
  private boolean hm;
  private PanelFeatureState[] hn;
  private PanelFeatureState ho;
  private boolean hp;
  private int hq;
  private boolean hr;
  private e hs;
  boolean ht;
  int hu;
  private final Runnable hv;
  private boolean hw;
  private Rect hx;
  private Rect hy;
  private AppCompatViewInflater hz;
  ActionBar mActionBar;
  final Context mContext;
  boolean mIsDestroyed;
  
  static
  {
    AppMethodBeat.i(200780);
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      gM = bool;
      gN = new int[] { 16842836 };
      if ((gM) && (!gO))
      {
        Thread.setDefaultUncaughtExceptionHandler(new AppCompatDelegateImpl.1(Thread.getDefaultUncaughtExceptionHandler()));
        gO = true;
      }
      AppMethodBeat.o(200780);
      return;
    }
  }
  
  AppCompatDelegateImpl(Context paramContext, Window paramWindow, c paramc)
  {
    AppMethodBeat.i(200495);
    this.ha = null;
    this.hb = true;
    this.hq = -100;
    this.hv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200429);
        if ((AppCompatDelegateImpl.this.hu & 0x1) != 0) {
          AppCompatDelegateImpl.this.R(0);
        }
        if ((AppCompatDelegateImpl.this.hu & 0x1000) != 0) {
          AppCompatDelegateImpl.this.R(108);
        }
        AppCompatDelegateImpl.this.ht = false;
        AppCompatDelegateImpl.this.hu = 0;
        AppMethodBeat.o(200429);
      }
    };
    this.mContext = paramContext;
    this.fo = paramWindow;
    this.gR = paramc;
    this.gP = this.fo.getCallback();
    if ((this.gP instanceof d))
    {
      paramContext = new IllegalStateException("AppCompat has already installed itself into the Window");
      AppMethodBeat.o(200495);
      throw paramContext;
    }
    this.gQ = new d(this.gP);
    this.fo.setCallback(this.gQ);
    paramContext = ac.a(paramContext, null, gN);
    paramWindow = paramContext.ax(0);
    if (paramWindow != null) {
      this.fo.setBackgroundDrawable(paramWindow);
    }
    paramContext.xv.recycle();
    AppMethodBeat.o(200495);
  }
  
  private void Q(int paramInt)
  {
    AppMethodBeat.i(200681);
    this.hu |= 1 << paramInt;
    if (!this.ht)
    {
      z.b(this.fo.getDecorView(), this.hv);
      this.ht = true;
    }
    AppMethodBeat.o(200681);
  }
  
  private static int T(int paramInt)
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
  
  private int U(int paramInt)
  {
    AppMethodBeat.i(200717);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(200717);
      return paramInt;
    case 0: 
      if ((Build.VERSION.SDK_INT >= 23) && (((UiModeManager)this.mContext.getSystemService(UiModeManager.class)).getNightMode() == 0))
      {
        AppMethodBeat.o(200717);
        return -1;
      }
      bQ();
      paramInt = this.hs.bS();
      AppMethodBeat.o(200717);
      return paramInt;
    }
    AppMethodBeat.o(200717);
    return -1;
  }
  
  private boolean V(int paramInt)
  {
    AppMethodBeat.i(200742);
    Resources localResources = this.mContext.getResources();
    Configuration localConfiguration = localResources.getConfiguration();
    int i = localConfiguration.uiMode;
    if (paramInt == 2)
    {
      paramInt = 32;
      if ((i & 0x30) == paramInt) {
        break label128;
      }
      if (!bR()) {
        break label73;
      }
      ((Activity)this.mContext).recreate();
    }
    for (;;)
    {
      AppMethodBeat.o(200742);
      return true;
      paramInt = 16;
      break;
      label73:
      localConfiguration = new Configuration(localConfiguration);
      DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
      localConfiguration.uiMode = (paramInt | localConfiguration.uiMode & 0xFFFFFFCF);
      localResources.updateConfiguration(localConfiguration, localDisplayMetrics);
      if (Build.VERSION.SDK_INT < 26) {
        f.a(localResources);
      }
    }
    label128:
    AppMethodBeat.o(200742);
    return false;
  }
  
  /* Error */
  private View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: ldc_w 315
    //   3: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 317	androidx/appcompat/app/AppCompatDelegateImpl:hz	Landroidx/appcompat/app/AppCompatViewInflater;
    //   10: ifnonnull +51 -> 61
    //   13: aload_0
    //   14: getfield 181	androidx/appcompat/app/AppCompatDelegateImpl:mContext	Landroid/content/Context;
    //   17: getstatic 322	androidx/appcompat/a$j:AppCompatTheme	[I
    //   20: invokevirtual 326	android/content/Context:obtainStyledAttributes	([I)Landroid/content/res/TypedArray;
    //   23: getstatic 329	androidx/appcompat/a$j:AppCompatTheme_viewInflaterClass	I
    //   26: invokevirtual 333	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   29: astore 6
    //   31: aload 6
    //   33: ifnull +17 -> 50
    //   36: ldc_w 335
    //   39: invokevirtual 341	java/lang/Class:getName	()Ljava/lang/String;
    //   42: aload 6
    //   44: invokevirtual 347	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   47: ifeq +75 -> 122
    //   50: aload_0
    //   51: new 335	androidx/appcompat/app/AppCompatViewInflater
    //   54: dup
    //   55: invokespecial 348	androidx/appcompat/app/AppCompatViewInflater:<init>	()V
    //   58: putfield 317	androidx/appcompat/app/AppCompatDelegateImpl:hz	Landroidx/appcompat/app/AppCompatViewInflater;
    //   61: getstatic 140	androidx/appcompat/app/AppCompatDelegateImpl:gM	Z
    //   64: ifeq +144 -> 208
    //   67: aload 4
    //   69: instanceof 350
    //   72: ifeq +123 -> 195
    //   75: aload 4
    //   77: checkcast 350	org/xmlpull/v1/XmlPullParser
    //   80: invokeinterface 353 1 0
    //   85: iconst_1
    //   86: if_icmple +103 -> 189
    //   89: iconst_1
    //   90: istore 5
    //   92: aload_0
    //   93: getfield 317	androidx/appcompat/app/AppCompatDelegateImpl:hz	Landroidx/appcompat/app/AppCompatViewInflater;
    //   96: aload_1
    //   97: aload_2
    //   98: aload_3
    //   99: aload 4
    //   101: iload 5
    //   103: getstatic 140	androidx/appcompat/app/AppCompatDelegateImpl:gM	Z
    //   106: iconst_1
    //   107: invokestatic 358	androidx/appcompat/widget/ah:fE	()Z
    //   110: invokevirtual 362	androidx/appcompat/app/AppCompatViewInflater:createView	(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;ZZZZ)Landroid/view/View;
    //   113: astore_1
    //   114: ldc_w 315
    //   117: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: areturn
    //   122: aload_0
    //   123: aload 6
    //   125: invokestatic 366	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   128: iconst_0
    //   129: anewarray 337	java/lang/Class
    //   132: invokevirtual 370	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   135: iconst_0
    //   136: anewarray 372	java/lang/Object
    //   139: invokevirtual 378	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   142: checkcast 335	androidx/appcompat/app/AppCompatViewInflater
    //   145: putfield 317	androidx/appcompat/app/AppCompatDelegateImpl:hz	Landroidx/appcompat/app/AppCompatViewInflater;
    //   148: goto -87 -> 61
    //   151: astore 7
    //   153: new 380	java/lang/StringBuilder
    //   156: dup
    //   157: ldc_w 382
    //   160: invokespecial 383	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: aload 6
    //   165: invokevirtual 387	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 389
    //   171: invokevirtual 387	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_0
    //   176: new 335	androidx/appcompat/app/AppCompatViewInflater
    //   179: dup
    //   180: invokespecial 348	androidx/appcompat/app/AppCompatViewInflater:<init>	()V
    //   183: putfield 317	androidx/appcompat/app/AppCompatDelegateImpl:hz	Landroidx/appcompat/app/AppCompatViewInflater;
    //   186: goto -125 -> 61
    //   189: iconst_0
    //   190: istore 5
    //   192: goto -100 -> 92
    //   195: aload_0
    //   196: aload_1
    //   197: checkcast 391	android/view/ViewParent
    //   200: invokespecial 394	androidx/appcompat/app/AppCompatDelegateImpl:a	(Landroid/view/ViewParent;)Z
    //   203: istore 5
    //   205: goto -113 -> 92
    //   208: iconst_0
    //   209: istore 5
    //   211: goto -119 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	AppCompatDelegateImpl
    //   0	214	1	paramView	View
    //   0	214	2	paramString	String
    //   0	214	3	paramContext	Context
    //   0	214	4	paramAttributeSet	AttributeSet
    //   90	120	5	bool	boolean
    //   29	135	6	str	String
    //   151	1	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   122	148	151	finally
  }
  
  private void a(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    int j = -1;
    AppMethodBeat.i(200616);
    if ((paramPanelFeatureState.hU) || (this.mIsDestroyed))
    {
      AppMethodBeat.o(200616);
      return;
    }
    int i;
    if (paramPanelFeatureState.hK == 0)
    {
      if ((this.mContext.getResources().getConfiguration().screenLayout & 0xF) == 4) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(200616);
        return;
      }
    }
    Object localObject = this.fo.getCallback();
    if ((localObject != null) && (!((Window.Callback)localObject).onMenuOpened(paramPanelFeatureState.hK, paramPanelFeatureState.hP)))
    {
      a(paramPanelFeatureState, true);
      AppMethodBeat.o(200616);
      return;
    }
    localObject = (WindowManager)this.mContext.getSystemService("window");
    if (localObject == null)
    {
      AppMethodBeat.o(200616);
      return;
    }
    if (!b(paramPanelFeatureState, paramKeyEvent))
    {
      AppMethodBeat.o(200616);
      return;
    }
    if ((paramPanelFeatureState.hM == null) || (paramPanelFeatureState.hW))
    {
      if (paramPanelFeatureState.hM == null)
      {
        if ((!a(paramPanelFeatureState)) || (paramPanelFeatureState.hM == null)) {
          AppMethodBeat.o(200616);
        }
      }
      else if ((paramPanelFeatureState.hW) && (paramPanelFeatureState.hM.getChildCount() > 0)) {
        paramPanelFeatureState.hM.removeAllViews();
      }
      if ((!c(paramPanelFeatureState)) || (!paramPanelFeatureState.bT()))
      {
        AppMethodBeat.o(200616);
        return;
      }
      paramKeyEvent = paramPanelFeatureState.hN.getLayoutParams();
      if (paramKeyEvent != null) {
        break label464;
      }
      paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
    }
    label464:
    for (;;)
    {
      i = paramPanelFeatureState.background;
      paramPanelFeatureState.hM.setBackgroundResource(i);
      ViewParent localViewParent = paramPanelFeatureState.hN.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeView(paramPanelFeatureState.hN);
      }
      paramPanelFeatureState.hM.addView(paramPanelFeatureState.hN, paramKeyEvent);
      if (!paramPanelFeatureState.hN.hasFocus()) {
        paramPanelFeatureState.hN.requestFocus();
      }
      i = -2;
      for (;;)
      {
        paramPanelFeatureState.hT = false;
        paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.x, paramPanelFeatureState.y, 1002, 8519680, -3);
        paramKeyEvent.gravity = paramPanelFeatureState.fl;
        paramKeyEvent.windowAnimations = paramPanelFeatureState.hL;
        ((WindowManager)localObject).addView(paramPanelFeatureState.hM, paramKeyEvent);
        paramPanelFeatureState.hU = true;
        AppMethodBeat.o(200616);
        return;
        if (paramPanelFeatureState.hO != null)
        {
          paramKeyEvent = paramPanelFeatureState.hO.getLayoutParams();
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
  
  private boolean a(ViewParent paramViewParent)
  {
    AppMethodBeat.i(200604);
    if (paramViewParent == null)
    {
      AppMethodBeat.o(200604);
      return false;
    }
    View localView = this.fo.getDecorView();
    for (;;)
    {
      if (paramViewParent == null)
      {
        AppMethodBeat.o(200604);
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View)) || (z.ay((View)paramViewParent)))
      {
        AppMethodBeat.o(200604);
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState)
  {
    AppMethodBeat.i(200627);
    paramPanelFeatureState.G(bG());
    paramPanelFeatureState.hM = new f(paramPanelFeatureState.hR);
    paramPanelFeatureState.fl = 81;
    AppMethodBeat.o(200627);
    return true;
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(200670);
    if (paramKeyEvent.isSystem())
    {
      AppMethodBeat.o(200670);
      return false;
    }
    boolean bool1;
    if (!paramPanelFeatureState.hS)
    {
      bool1 = bool2;
      if (!b(paramPanelFeatureState, paramKeyEvent)) {}
    }
    else
    {
      bool1 = bool2;
      if (paramPanelFeatureState.hP != null) {
        bool1 = paramPanelFeatureState.hP.performShortcut(paramInt, paramKeyEvent, 1);
      }
    }
    AppMethodBeat.o(200670);
    return bool1;
  }
  
  private b b(b.a parama)
  {
    AppMethodBeat.i(200584);
    bL();
    if (this.gW != null) {
      this.gW.finish();
    }
    if ((this.gR != null) && (!this.mIsDestroyed)) {}
    for (;;)
    {
      try
      {
        b localb = this.gR.onWindowStartingSupportActionMode(parama);
        if (localb == null) {
          break label109;
        }
        this.gW = localb;
        if ((this.gW != null) && (this.gR != null)) {
          this.gR.onSupportActionModeStarted(this.gW);
        }
        parama = this.gW;
        AppMethodBeat.o(200584);
        return parama;
      }
      catch (AbstractMethodError localAbstractMethodError) {}
      Object localObject1 = null;
      continue;
      label109:
      Object localObject2;
      label215:
      boolean bool;
      if (this.gX == null)
      {
        if (!this.hk) {
          break label506;
        }
        localObject2 = new TypedValue();
        localObject1 = this.mContext.getTheme();
        ((Resources.Theme)localObject1).resolveAttribute(androidx.appcompat.a.a.actionBarTheme, (TypedValue)localObject2, true);
        if (((TypedValue)localObject2).resourceId != 0)
        {
          Resources.Theme localTheme = this.mContext.getResources().newTheme();
          localTheme.setTo((Resources.Theme)localObject1);
          localTheme.applyStyle(((TypedValue)localObject2).resourceId, true);
          localObject1 = new androidx.appcompat.view.d(this.mContext, 0);
          ((Context)localObject1).getTheme().setTo(localTheme);
          this.gX = new ActionBarContextView((Context)localObject1);
          this.gY = new PopupWindow((Context)localObject1, null, androidx.appcompat.a.a.actionModePopupWindowStyle);
          androidx.core.widget.h.a(this.gY, 2);
          this.gY.setContentView(this.gX);
          this.gY.setWidth(-1);
          ((Context)localObject1).getTheme().resolveAttribute(androidx.appcompat.a.a.actionBarSize, (TypedValue)localObject2, true);
          int i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, ((Context)localObject1).getResources().getDisplayMetrics());
          this.gX.setContentHeight(i);
          this.gY.setHeight(-2);
          this.gZ = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200397);
              AppCompatDelegateImpl.this.gY.showAtLocation(AppCompatDelegateImpl.this.gX, 55, 0, 0);
              AppCompatDelegateImpl.this.bL();
              if (AppCompatDelegateImpl.this.bK())
              {
                AppCompatDelegateImpl.this.gX.setAlpha(0.0F);
                AppCompatDelegateImpl.this.ha = z.ac(AppCompatDelegateImpl.this.gX).ao(1.0F);
                AppCompatDelegateImpl.this.ha.b(new af()
                {
                  public final void e(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(200454);
                    AppCompatDelegateImpl.this.gX.setVisibility(0);
                    AppMethodBeat.o(200454);
                  }
                  
                  public final void f(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(200461);
                    AppCompatDelegateImpl.this.gX.setAlpha(1.0F);
                    AppCompatDelegateImpl.this.ha.b(null);
                    AppCompatDelegateImpl.this.ha = null;
                    AppMethodBeat.o(200461);
                  }
                });
                AppMethodBeat.o(200397);
                return;
              }
              AppCompatDelegateImpl.this.gX.setAlpha(1.0F);
              AppCompatDelegateImpl.this.gX.setVisibility(0);
              AppMethodBeat.o(200397);
            }
          };
        }
      }
      else
      {
        label333:
        if (this.gX == null) {
          break label551;
        }
        bL();
        this.gX.dy();
        localObject1 = this.gX.getContext();
        localObject2 = this.gX;
        if (this.gY != null) {
          break label553;
        }
        bool = true;
        label375:
        localObject1 = new androidx.appcompat.view.e((Context)localObject1, (ActionBarContextView)localObject2, parama, bool);
        if (!parama.a((b)localObject1, ((b)localObject1).getMenu())) {
          break label612;
        }
        ((b)localObject1).invalidate();
        this.gX.c((b)localObject1);
        this.gW = ((b)localObject1);
        if (!bK()) {
          break label558;
        }
        this.gX.setAlpha(0.0F);
        this.ha = z.ac(this.gX).ao(1.0F);
        this.ha.b(new af()
        {
          public final void e(View paramAnonymousView)
          {
            AppMethodBeat.i(200395);
            AppCompatDelegateImpl.this.gX.setVisibility(0);
            AppCompatDelegateImpl.this.gX.sendAccessibilityEvent(32);
            if ((AppCompatDelegateImpl.this.gX.getParent() instanceof View)) {
              z.ak((View)AppCompatDelegateImpl.this.gX.getParent());
            }
            AppMethodBeat.o(200395);
          }
          
          public final void f(View paramAnonymousView)
          {
            AppMethodBeat.i(200406);
            AppCompatDelegateImpl.this.gX.setAlpha(1.0F);
            AppCompatDelegateImpl.this.ha.b(null);
            AppCompatDelegateImpl.this.ha = null;
            AppMethodBeat.o(200406);
          }
        });
      }
      for (;;)
      {
        if (this.gY == null) {
          break label610;
        }
        this.fo.getDecorView().post(this.gZ);
        break;
        localObject1 = this.mContext;
        break label215;
        label506:
        localObject1 = (ViewStubCompat)this.hd.findViewById(a.f.action_mode_bar_stub);
        if (localObject1 == null) {
          break label333;
        }
        ((ViewStubCompat)localObject1).setLayoutInflater(LayoutInflater.from(bG()));
        this.gX = ((ActionBarContextView)((ViewStubCompat)localObject1).fF());
        break label333;
        label551:
        break;
        label553:
        bool = false;
        break label375;
        label558:
        this.gX.setAlpha(1.0F);
        this.gX.setVisibility(0);
        this.gX.sendAccessibilityEvent(32);
        if ((this.gX.getParent() instanceof View)) {
          z.ak((View)this.gX.getParent());
        }
      }
      label610:
      continue;
      label612:
      this.gW = null;
    }
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState)
  {
    AppMethodBeat.i(200639);
    Context localContext = this.mContext;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if (((paramPanelFeatureState.hK == 0) || (paramPanelFeatureState.hK == 108)) && (this.gT != null))
    {
      localTypedValue = new TypedValue();
      localTheme = localContext.getTheme();
      localTheme.resolveAttribute(androidx.appcompat.a.a.actionBarTheme, localTypedValue, true);
      localObject1 = null;
      if (localTypedValue.resourceId != 0)
      {
        localObject1 = localContext.getResources().newTheme();
        ((Resources.Theme)localObject1).setTo(localTheme);
        ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
        ((Resources.Theme)localObject1).resolveAttribute(androidx.appcompat.a.a.actionBarWidgetTheme, localTypedValue, true);
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
          break label215;
        }
        localObject1 = new androidx.appcompat.view.d(localContext, 0);
        ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new androidx.appcompat.view.menu.h((Context)localObject1);
      ((androidx.appcompat.view.menu.h)localObject1).a(this);
      paramPanelFeatureState.d((androidx.appcompat.view.menu.h)localObject1);
      AppMethodBeat.o(200639);
      return true;
      localTheme.resolveAttribute(androidx.appcompat.a.a.actionBarWidgetTheme, localTypedValue, true);
      break;
      label215:
      localObject1 = localContext;
    }
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(200661);
    if (this.mIsDestroyed)
    {
      AppMethodBeat.o(200661);
      return false;
    }
    if (paramPanelFeatureState.hS)
    {
      AppMethodBeat.o(200661);
      return true;
    }
    if ((this.ho != null) && (this.ho != paramPanelFeatureState)) {
      a(this.ho, false);
    }
    Window.Callback localCallback = this.fo.getCallback();
    if (localCallback != null) {
      paramPanelFeatureState.hO = localCallback.onCreatePanelView(paramPanelFeatureState.hK);
    }
    if ((paramPanelFeatureState.hK == 0) || (paramPanelFeatureState.hK == 108)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.gT != null)) {
        this.gT.dF();
      }
      if ((paramPanelFeatureState.hO != null) || ((i != 0) && ((this.mActionBar instanceof g)))) {
        break label448;
      }
      if ((paramPanelFeatureState.hP != null) && (!paramPanelFeatureState.hX)) {
        break label312;
      }
      if ((paramPanelFeatureState.hP != null) || ((b(paramPanelFeatureState)) && (paramPanelFeatureState.hP != null))) {
        break;
      }
      AppMethodBeat.o(200661);
      return false;
    }
    if ((i != 0) && (this.gT != null))
    {
      if (this.gU == null) {
        this.gU = new b();
      }
      this.gT.a(paramPanelFeatureState.hP, this.gU);
    }
    paramPanelFeatureState.hP.cX();
    if (!localCallback.onCreatePanelMenu(paramPanelFeatureState.hK, paramPanelFeatureState.hP))
    {
      paramPanelFeatureState.d(null);
      if ((i != 0) && (this.gT != null)) {
        this.gT.a(null, this.gU);
      }
      AppMethodBeat.o(200661);
      return false;
    }
    paramPanelFeatureState.hX = false;
    label312:
    paramPanelFeatureState.hP.cX();
    if (paramPanelFeatureState.hY != null)
    {
      paramPanelFeatureState.hP.i(paramPanelFeatureState.hY);
      paramPanelFeatureState.hY = null;
    }
    if (!localCallback.onPreparePanel(0, paramPanelFeatureState.hO, paramPanelFeatureState.hP))
    {
      if ((i != 0) && (this.gT != null)) {
        this.gT.a(null, this.gU);
      }
      paramPanelFeatureState.hP.cY();
      AppMethodBeat.o(200661);
      return false;
    }
    if (paramKeyEvent != null)
    {
      i = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
        break label476;
      }
    }
    label448:
    label476:
    for (boolean bool = true;; bool = false)
    {
      paramPanelFeatureState.hV = bool;
      paramPanelFeatureState.hP.setQwertyMode(paramPanelFeatureState.hV);
      paramPanelFeatureState.hP.cY();
      paramPanelFeatureState.hS = true;
      paramPanelFeatureState.hT = false;
      this.ho = paramPanelFeatureState;
      AppMethodBeat.o(200661);
      return true;
      i = -1;
      break;
    }
  }
  
  private void bF()
  {
    AppMethodBeat.i(200504);
    bH();
    if ((!this.hh) || (this.mActionBar != null))
    {
      AppMethodBeat.o(200504);
      return;
    }
    if ((this.gP instanceof Activity)) {
      this.mActionBar = new j((Activity)this.gP, this.hi);
    }
    for (;;)
    {
      if (this.mActionBar != null) {
        this.mActionBar.z(this.hw);
      }
      AppMethodBeat.o(200504);
      return;
      if ((this.gP instanceof Dialog)) {
        this.mActionBar = new j((Dialog)this.gP);
      }
    }
  }
  
  private Context bG()
  {
    AppMethodBeat.i(200511);
    Context localContext = null;
    Object localObject = getSupportActionBar();
    if (localObject != null) {
      localContext = ((ActionBar)localObject).bw();
    }
    localObject = localContext;
    if (localContext == null) {
      localObject = this.mContext;
    }
    AppMethodBeat.o(200511);
    return localObject;
  }
  
  private void bH()
  {
    AppMethodBeat.i(200523);
    Object localObject;
    if (!this.hc)
    {
      this.hd = bI();
      localObject = getTitle();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (this.gT == null) {
          break label96;
        }
        this.gT.setWindowTitle((CharSequence)localObject);
      }
    }
    for (;;)
    {
      bJ();
      this.hc = true;
      localObject = P(0);
      if ((!this.mIsDestroyed) && ((localObject == null) || (((PanelFeatureState)localObject).hP == null))) {
        Q(108);
      }
      AppMethodBeat.o(200523);
      return;
      label96:
      if (this.mActionBar != null) {
        this.mActionBar.setWindowTitle((CharSequence)localObject);
      } else if (this.fO != null) {
        this.fO.setText((CharSequence)localObject);
      }
    }
  }
  
  private ViewGroup bI()
  {
    AppMethodBeat.i(200540);
    Object localObject = this.mContext.obtainStyledAttributes(a.j.AppCompatTheme);
    if (!((TypedArray)localObject).hasValue(a.j.AppCompatTheme_windowActionBar))
    {
      ((TypedArray)localObject).recycle();
      localObject = new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
      AppMethodBeat.o(200540);
      throw ((Throwable)localObject);
    }
    if (((TypedArray)localObject).getBoolean(a.j.AppCompatTheme_windowNoTitle, false))
    {
      N(1);
      if (((TypedArray)localObject).getBoolean(a.j.AppCompatTheme_windowActionBarOverlay, false)) {
        N(109);
      }
      if (((TypedArray)localObject).getBoolean(a.j.AppCompatTheme_windowActionModeOverlay, false)) {
        N(10);
      }
      this.hk = ((TypedArray)localObject).getBoolean(a.j.AppCompatTheme_android_windowIsFloating, false);
      ((TypedArray)localObject).recycle();
      this.fo.getDecorView();
      localObject = LayoutInflater.from(this.mContext);
      if (this.hl) {
        break label452;
      }
      if (!this.hk) {
        break label290;
      }
      localObject = (ViewGroup)((LayoutInflater)localObject).inflate(a.g.abc_dialog_title_material, null);
      this.hi = false;
      this.hh = false;
    }
    for (;;)
    {
      if (localObject == null)
      {
        localObject = new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.hh + ", windowActionBarOverlay: " + this.hi + ", android:windowIsFloating: " + this.hk + ", windowActionModeOverlay: " + this.hj + ", windowNoTitle: " + this.hl + " }");
        AppMethodBeat.o(200540);
        throw ((Throwable)localObject);
        if (!((TypedArray)localObject).getBoolean(a.j.AppCompatTheme_windowActionBar, false)) {
          break;
        }
        N(108);
        break;
        label290:
        if (!this.hh) {
          break label666;
        }
        localObject = new TypedValue();
        this.mContext.getTheme().resolveAttribute(androidx.appcompat.a.a.actionBarTheme, (TypedValue)localObject, true);
        if (((TypedValue)localObject).resourceId != 0) {}
        for (localObject = new androidx.appcompat.view.d(this.mContext, ((TypedValue)localObject).resourceId);; localObject = this.mContext)
        {
          localObject = (ViewGroup)LayoutInflater.from((Context)localObject).inflate(a.g.abc_screen_toolbar, null);
          this.gT = ((m)((ViewGroup)localObject).findViewById(a.f.decor_content_parent));
          this.gT.setWindowCallback(this.fo.getCallback());
          if (this.hi) {
            this.gT.aj(109);
          }
          if (this.hf) {
            this.gT.aj(2);
          }
          if (this.hg) {
            this.gT.aj(5);
          }
          break;
        }
        label452:
        if (this.hj) {}
        for (localObject = (ViewGroup)((LayoutInflater)localObject).inflate(a.g.abc_screen_simple_overlay_action_mode, null);; localObject = (ViewGroup)((LayoutInflater)localObject).inflate(a.g.abc_screen_simple, null))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label509;
          }
          z.a((View)localObject, new s()
          {
            public final ah a(View paramAnonymousView, ah paramAnonymousah)
            {
              AppMethodBeat.i(200430);
              int i = paramAnonymousah.En();
              int j = AppCompatDelegateImpl.this.S(i);
              ah localah = paramAnonymousah;
              if (i != j) {
                localah = paramAnonymousah.n(paramAnonymousah.Em(), j, paramAnonymousah.Eo(), paramAnonymousah.Ep());
              }
              paramAnonymousView = z.a(paramAnonymousView, localah);
              AppMethodBeat.o(200430);
              return paramAnonymousView;
            }
          });
          break;
        }
        label509:
        ((q)localObject).setOnFitSystemWindowsListener(new q.a()
        {
          public final void e(Rect paramAnonymousRect)
          {
            AppMethodBeat.i(200432);
            paramAnonymousRect.top = AppCompatDelegateImpl.this.S(paramAnonymousRect.top);
            AppMethodBeat.o(200432);
          }
        });
        continue;
      }
      if (this.gT == null) {
        this.fO = ((TextView)((ViewGroup)localObject).findViewById(a.f.title));
      }
      ai.t((View)localObject);
      ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject).findViewById(a.f.action_bar_activity_content);
      ViewGroup localViewGroup = (ViewGroup)this.fo.findViewById(16908290);
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
      this.fo.setContentView((View)localObject);
      localContentFrameLayout.setAttachListener(new ContentFrameLayout.a()
      {
        public final void onDetachedFromWindow()
        {
          AppMethodBeat.i(200400);
          AppCompatDelegateImpl.this.bO();
          AppMethodBeat.o(200400);
        }
      });
      AppMethodBeat.o(200540);
      return localObject;
      label666:
      localObject = null;
    }
  }
  
  private void bJ()
  {
    AppMethodBeat.i(200552);
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.hd.findViewById(16908290);
    Object localObject = this.fo.getDecorView();
    localContentFrameLayout.c(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    localObject = this.mContext.obtainStyledAttributes(a.j.AppCompatTheme);
    ((TypedArray)localObject).getValue(a.j.AppCompatTheme_windowMinWidthMajor, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(a.j.AppCompatTheme_windowMinWidthMinor, localContentFrameLayout.getMinWidthMinor());
    if (((TypedArray)localObject).hasValue(a.j.AppCompatTheme_windowFixedWidthMajor)) {
      ((TypedArray)localObject).getValue(a.j.AppCompatTheme_windowFixedWidthMajor, localContentFrameLayout.getFixedWidthMajor());
    }
    if (((TypedArray)localObject).hasValue(a.j.AppCompatTheme_windowFixedWidthMinor)) {
      ((TypedArray)localObject).getValue(a.j.AppCompatTheme_windowFixedWidthMinor, localContentFrameLayout.getFixedWidthMinor());
    }
    if (((TypedArray)localObject).hasValue(a.j.AppCompatTheme_windowFixedHeightMajor)) {
      ((TypedArray)localObject).getValue(a.j.AppCompatTheme_windowFixedHeightMajor, localContentFrameLayout.getFixedHeightMajor());
    }
    if (((TypedArray)localObject).hasValue(a.j.AppCompatTheme_windowFixedHeightMinor)) {
      ((TypedArray)localObject).getValue(a.j.AppCompatTheme_windowFixedHeightMinor, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
    AppMethodBeat.o(200552);
  }
  
  private void bN()
  {
    AppMethodBeat.i(200697);
    if (this.hc)
    {
      AndroidRuntimeException localAndroidRuntimeException = new AndroidRuntimeException("Window feature must be requested before adding content");
      AppMethodBeat.o(200697);
      throw localAndroidRuntimeException;
    }
    AppMethodBeat.o(200697);
  }
  
  private int bP()
  {
    AppMethodBeat.i(200728);
    if (this.hq != -100)
    {
      i = this.hq;
      AppMethodBeat.o(200728);
      return i;
    }
    int i = bE();
    AppMethodBeat.o(200728);
    return i;
  }
  
  private void bQ()
  {
    AppMethodBeat.i(200754);
    if (this.hs == null) {
      this.hs = new e(i.H(this.mContext));
    }
    AppMethodBeat.o(200754);
  }
  
  private boolean bR()
  {
    AppMethodBeat.i(200768);
    if ((this.hr) && ((this.mContext instanceof Activity)))
    {
      PackageManager localPackageManager = this.mContext.getPackageManager();
      try
      {
        if ((localPackageManager.getActivityInfo(new ComponentName(this.mContext, this.mContext.getClass()), 0).configChanges & 0x200) == 0)
        {
          AppMethodBeat.o(200768);
          return true;
        }
        AppMethodBeat.o(200768);
        return false;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(200768);
        return true;
      }
    }
    AppMethodBeat.o(200768);
    return false;
  }
  
  private boolean c(PanelFeatureState paramPanelFeatureState)
  {
    AppMethodBeat.i(200647);
    if (paramPanelFeatureState.hO != null)
    {
      paramPanelFeatureState.hN = paramPanelFeatureState.hO;
      AppMethodBeat.o(200647);
      return true;
    }
    if (paramPanelFeatureState.hP == null)
    {
      AppMethodBeat.o(200647);
      return false;
    }
    if (this.gV == null) {
      this.gV = new g();
    }
    paramPanelFeatureState.hN = ((View)paramPanelFeatureState.a(this.gV));
    if (paramPanelFeatureState.hN != null)
    {
      AppMethodBeat.o(200647);
      return true;
    }
    AppMethodBeat.o(200647);
    return false;
  }
  
  private CharSequence getTitle()
  {
    AppMethodBeat.i(200561);
    if ((this.gP instanceof Activity))
    {
      localCharSequence = ((Activity)this.gP).getTitle();
      AppMethodBeat.o(200561);
      return localCharSequence;
    }
    CharSequence localCharSequence = this.cZ;
    AppMethodBeat.o(200561);
    return localCharSequence;
  }
  
  public final boolean N(int paramInt)
  {
    AppMethodBeat.i(200941);
    paramInt = T(paramInt);
    if ((this.hl) && (paramInt == 108))
    {
      AppMethodBeat.o(200941);
      return false;
    }
    if ((this.hh) && (paramInt == 1)) {
      this.hh = false;
    }
    switch (paramInt)
    {
    default: 
      boolean bool = this.fo.requestFeature(paramInt);
      AppMethodBeat.o(200941);
      return bool;
    case 108: 
      bN();
      this.hh = true;
      AppMethodBeat.o(200941);
      return true;
    case 109: 
      bN();
      this.hi = true;
      AppMethodBeat.o(200941);
      return true;
    case 10: 
      bN();
      this.hj = true;
      AppMethodBeat.o(200941);
      return true;
    case 2: 
      bN();
      this.hf = true;
      AppMethodBeat.o(200941);
      return true;
    case 5: 
      bN();
      this.hg = true;
      AppMethodBeat.o(200941);
      return true;
    }
    bN();
    this.hl = true;
    AppMethodBeat.o(200941);
    return true;
  }
  
  final void O(int paramInt)
  {
    AppMethodBeat.i(200958);
    Object localObject;
    if (paramInt == 108)
    {
      localObject = getSupportActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).B(false);
      }
      AppMethodBeat.o(200958);
      return;
    }
    if (paramInt == 0)
    {
      localObject = P(paramInt);
      if (((PanelFeatureState)localObject).hU) {
        a((PanelFeatureState)localObject, false);
      }
    }
    AppMethodBeat.o(200958);
  }
  
  protected final PanelFeatureState P(int paramInt)
  {
    AppMethodBeat.i(201130);
    Object localObject2 = this.hn;
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
      this.hn = ((PanelFeatureState[])localObject1);
    }
    localObject2 = localObject1[paramInt];
    if (localObject2 == null)
    {
      localObject2 = new PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
    }
    for (Object localObject1 = localObject2;; localObject1 = localObject2)
    {
      AppMethodBeat.o(201130);
      return localObject1;
    }
  }
  
  final void R(int paramInt)
  {
    AppMethodBeat.i(201142);
    PanelFeatureState localPanelFeatureState = P(paramInt);
    if (localPanelFeatureState.hP != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState.hP.h(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState.hY = localBundle;
      }
      localPanelFeatureState.hP.cX();
      localPanelFeatureState.hP.clear();
    }
    localPanelFeatureState.hX = true;
    localPanelFeatureState.hW = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.gT != null))
    {
      localPanelFeatureState = P(0);
      if (localPanelFeatureState != null)
      {
        localPanelFeatureState.hS = false;
        b(localPanelFeatureState, null);
      }
    }
    AppMethodBeat.o(201142);
  }
  
  final int S(int paramInt)
  {
    int j = 1;
    int m = 0;
    AppMethodBeat.i(201154);
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.gX != null) && ((this.gX.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.gX.getLayoutParams();
      if (this.gX.isShown())
      {
        if (this.hx == null)
        {
          this.hx = new Rect();
          this.hy = new Rect();
        }
        localObject2 = this.hx;
        Rect localRect = this.hy;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        ai.a(this.hd, (Rect)localObject2, localRect);
        if (localRect.top == 0)
        {
          i = paramInt;
          if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == i) {
            break label363;
          }
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
          if (this.he != null) {
            break label286;
          }
          this.he = new View(this.mContext);
          this.he.setBackgroundColor(this.mContext.getResources().getColor(a.c.abc_input_method_navigation_guard));
          this.hd.addView(this.he, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i = 1;
          label204:
          if (this.he == null) {
            break label324;
          }
          label211:
          int k = paramInt;
          if (!this.hj)
          {
            k = paramInt;
            if (j != 0) {
              k = 0;
            }
          }
          paramInt = k;
          label234:
          if (i != 0) {
            this.gX.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.he != null)
      {
        localObject1 = this.he;
        if (j == 0) {
          break label350;
        }
      }
      label286:
      label324:
      label350:
      for (i = m;; i = 8)
      {
        ((View)localObject1).setVisibility(i);
        AppMethodBeat.o(201154);
        return paramInt;
        i = 0;
        break;
        localObject2 = this.he.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
        {
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          this.he.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        i = 1;
        break label204;
        j = 0;
        break label211;
        if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == 0) {
          break label356;
        }
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
        i = 1;
        j = 0;
        break label234;
      }
      label356:
      i = 0;
      j = 0;
      break label234;
      label363:
      i = 0;
      break label204;
      j = 0;
    }
  }
  
  final PanelFeatureState a(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.hn;
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
      if ((localPanelFeatureState != null) && (localPanelFeatureState.hP == paramMenu))
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
    AppMethodBeat.i(201102);
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
          if (paramInt < this.hn.length) {
            localPanelFeatureState = this.hn[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.hP;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((PanelFeatureState)localObject1).hU))
    {
      AppMethodBeat.o(201102);
      return;
    }
    if (!this.mIsDestroyed) {
      this.gP.onPanelClosed(paramInt, (Menu)localObject2);
    }
    AppMethodBeat.o(201102);
  }
  
  final void a(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    AppMethodBeat.i(201094);
    if ((paramBoolean) && (paramPanelFeatureState.hK == 0) && (this.gT != null) && (this.gT.dC()))
    {
      b(paramPanelFeatureState.hP);
      AppMethodBeat.o(201094);
      return;
    }
    WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
    if ((localWindowManager != null) && (paramPanelFeatureState.hU) && (paramPanelFeatureState.hM != null))
    {
      localWindowManager.removeView(paramPanelFeatureState.hM);
      if (paramBoolean) {
        a(paramPanelFeatureState.hK, paramPanelFeatureState, null);
      }
    }
    paramPanelFeatureState.hS = false;
    paramPanelFeatureState.hT = false;
    paramPanelFeatureState.hU = false;
    paramPanelFeatureState.hN = null;
    paramPanelFeatureState.hW = true;
    if (this.ho == paramPanelFeatureState) {
      this.ho = null;
    }
    AppMethodBeat.o(201094);
  }
  
  public final void a(androidx.appcompat.view.menu.h paramh)
  {
    AppMethodBeat.i(200988);
    if ((this.gT != null) && (this.gT.dB()) && ((!ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) || (this.gT.dD())))
    {
      paramh = this.fo.getCallback();
      if (!this.gT.dC())
      {
        if ((paramh != null) && (!this.mIsDestroyed))
        {
          if ((this.ht) && ((this.hu & 0x1) != 0))
          {
            this.fo.getDecorView().removeCallbacks(this.hv);
            this.hv.run();
          }
          PanelFeatureState localPanelFeatureState = P(0);
          if ((localPanelFeatureState.hP != null) && (!localPanelFeatureState.hX) && (paramh.onPreparePanel(0, localPanelFeatureState.hO, localPanelFeatureState.hP)))
          {
            paramh.onMenuOpened(108, localPanelFeatureState.hP);
            this.gT.dv();
          }
          AppMethodBeat.o(200988);
        }
      }
      else
      {
        this.gT.dE();
        if (!this.mIsDestroyed) {
          paramh.onPanelClosed(108, P(0).hP);
        }
      }
      AppMethodBeat.o(200988);
      return;
    }
    paramh = P(0);
    paramh.hW = true;
    a(paramh, false);
    a(paramh, null);
    AppMethodBeat.o(200988);
  }
  
  public final boolean a(androidx.appcompat.view.menu.h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(200972);
    Window.Callback localCallback = this.fo.getCallback();
    if ((localCallback != null) && (!this.mIsDestroyed))
    {
      paramh = a(paramh.de());
      if (paramh != null)
      {
        boolean bool = localCallback.onMenuItemSelected(paramh.hK, paramMenuItem);
        AppMethodBeat.o(200972);
        return bool;
      }
    }
    AppMethodBeat.o(200972);
    return false;
  }
  
  public final void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(200912);
    bH();
    ((ViewGroup)this.hd.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.gP.onContentChanged();
    AppMethodBeat.o(200912);
  }
  
  final void b(androidx.appcompat.view.menu.h paramh)
  {
    AppMethodBeat.i(201078);
    if (this.hm)
    {
      AppMethodBeat.o(201078);
      return;
    }
    this.hm = true;
    this.gT.bO();
    Window.Callback localCallback = this.fo.getCallback();
    if ((localCallback != null) && (!this.mIsDestroyed)) {
      localCallback.onPanelClosed(108, paramh);
    }
    this.hm = false;
    AppMethodBeat.o(201078);
  }
  
  public final void bB()
  {
    AppMethodBeat.i(200802);
    bH();
    AppMethodBeat.o(200802);
  }
  
  public final void bC()
  {
    AppMethodBeat.i(201061);
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    if (localLayoutInflater.getFactory() == null)
    {
      androidx.core.g.g.b(localLayoutInflater, this);
      AppMethodBeat.o(201061);
      return;
    }
    localLayoutInflater.getFactory2();
    AppMethodBeat.o(201061);
  }
  
  public final boolean bD()
  {
    AppMethodBeat.i(201172);
    boolean bool = false;
    int i = bP();
    int j = U(i);
    if (j != -1) {
      bool = V(j);
    }
    if (i == 0)
    {
      bQ();
      this.hs.setup();
    }
    this.hr = true;
    AppMethodBeat.o(201172);
    return bool;
  }
  
  final boolean bK()
  {
    AppMethodBeat.i(201020);
    if ((this.hc) && (this.hd != null) && (z.au(this.hd)))
    {
      AppMethodBeat.o(201020);
      return true;
    }
    AppMethodBeat.o(201020);
    return false;
  }
  
  final void bL()
  {
    AppMethodBeat.i(201034);
    if (this.ha != null) {
      this.ha.cancel();
    }
    AppMethodBeat.o(201034);
  }
  
  final void bM()
  {
    AppMethodBeat.i(201084);
    a(P(0), true);
    AppMethodBeat.o(201084);
  }
  
  final void bO()
  {
    AppMethodBeat.i(201164);
    if (this.gT != null) {
      this.gT.bO();
    }
    if (this.gY != null)
    {
      this.fo.getDecorView().removeCallbacks(this.gZ);
      if (!this.gY.isShowing()) {}
    }
    try
    {
      this.gY.dismiss();
      label61:
      this.gY = null;
      bL();
      PanelFeatureState localPanelFeatureState = P(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.hP != null)) {
        localPanelFeatureState.hP.close();
      }
      AppMethodBeat.o(201164);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label61;
    }
  }
  
  final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(201053);
    Object localObject;
    if (((this.gP instanceof androidx.core.g.f.a)) || ((this.gP instanceof e)))
    {
      localObject = this.fo.getDecorView();
      if ((localObject != null) && (androidx.core.g.f.a((View)localObject, paramKeyEvent)))
      {
        AppMethodBeat.o(201053);
        return true;
      }
    }
    if ((paramKeyEvent.getKeyCode() == 82) && (this.gP.dispatchKeyEvent(paramKeyEvent)))
    {
      AppMethodBeat.o(201053);
      return true;
    }
    int j = paramKeyEvent.getKeyCode();
    int i;
    if (paramKeyEvent.getAction() == 0) {
      i = 1;
    }
    while (i != 0) {
      switch (j)
      {
      default: 
        AppMethodBeat.o(201053);
        return false;
        i = 0;
        break;
      case 82: 
        if (paramKeyEvent.getRepeatCount() == 0)
        {
          localObject = P(0);
          if (!((PanelFeatureState)localObject).hU) {
            b((PanelFeatureState)localObject, paramKeyEvent);
          }
        }
        AppMethodBeat.o(201053);
        return true;
      case 4: 
        if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
        for (bool = true;; bool = false)
        {
          this.hp = bool;
          break;
        }
      }
    }
    switch (j)
    {
    default: 
      AppMethodBeat.o(201053);
      return false;
    case 82: 
      if (this.gW == null)
      {
        localObject = P(0);
        if ((this.gT == null) || (!this.gT.dB()) || (ViewConfiguration.get(this.mContext).hasPermanentMenuKey())) {
          break label384;
        }
        if (this.gT.dC()) {
          break label370;
        }
        if ((this.mIsDestroyed) || (!b((PanelFeatureState)localObject, paramKeyEvent))) {
          break;
        }
        bool = this.gT.dv();
      }
      for (;;)
      {
        label334:
        if (bool)
        {
          paramKeyEvent = (AudioManager)this.mContext.getSystemService("audio");
          if (paramKeyEvent != null) {
            paramKeyEvent.playSoundEffect(0);
          }
        }
        AppMethodBeat.o(201053);
        return true;
        label370:
        bool = this.gT.dE();
        continue;
        label384:
        if ((!((PanelFeatureState)localObject).hU) && (!((PanelFeatureState)localObject).hT)) {
          break;
        }
        bool = ((PanelFeatureState)localObject).hU;
        a((PanelFeatureState)localObject, true);
      }
      if (((PanelFeatureState)localObject).hS)
      {
        if (!((PanelFeatureState)localObject).hX) {
          break label573;
        }
        ((PanelFeatureState)localObject).hS = false;
      }
      break;
    }
    label573:
    for (boolean bool = b((PanelFeatureState)localObject, paramKeyEvent);; bool = true)
    {
      if (bool)
      {
        a((PanelFeatureState)localObject, paramKeyEvent);
        bool = true;
        break label334;
        bool = this.hp;
        this.hp = false;
        paramKeyEvent = P(0);
        if ((paramKeyEvent != null) && (paramKeyEvent.hU))
        {
          if (!bool) {
            a(paramKeyEvent, true);
          }
          AppMethodBeat.o(201053);
          return true;
        }
        if (this.gW != null)
        {
          this.gW.finish();
          i = 1;
        }
        while (i != 0)
        {
          AppMethodBeat.o(201053);
          return true;
          paramKeyEvent = getSupportActionBar();
          if ((paramKeyEvent != null) && (paramKeyEvent.collapseActionView())) {
            i = 1;
          } else {
            i = 0;
          }
        }
        break;
      }
      bool = false;
      break label334;
    }
  }
  
  public final <T extends View> T findViewById(int paramInt)
  {
    AppMethodBeat.i(200844);
    bH();
    View localView = this.fo.findViewById(paramInt);
    AppMethodBeat.o(200844);
    return localView;
  }
  
  public final a.a getDrawerToggleDelegate()
  {
    AppMethodBeat.i(201179);
    a locala = new a();
    AppMethodBeat.o(201179);
    return locala;
  }
  
  public final MenuInflater getMenuInflater()
  {
    AppMethodBeat.i(200836);
    if (this.gS == null)
    {
      bF();
      if (this.mActionBar == null) {
        break label57;
      }
    }
    label57:
    for (Object localObject = this.mActionBar.bw();; localObject = this.mContext)
    {
      this.gS = new androidx.appcompat.view.g((Context)localObject);
      localObject = this.gS;
      AppMethodBeat.o(200836);
      return localObject;
    }
  }
  
  public final ActionBar getSupportActionBar()
  {
    AppMethodBeat.i(200813);
    bF();
    ActionBar localActionBar = this.mActionBar;
    AppMethodBeat.o(200813);
    return localActionBar;
  }
  
  public final void invalidateOptionsMenu()
  {
    AppMethodBeat.i(201010);
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar != null) && (localActionBar.bz()))
    {
      AppMethodBeat.o(201010);
      return;
    }
    Q(0);
    AppMethodBeat.o(201010);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(200853);
    if ((this.hh) && (this.hc))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
    androidx.appcompat.widget.f.ep().J(this.mContext);
    bD();
    AppMethodBeat.o(200853);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200792);
    if ((this.gP instanceof Activity)) {}
    try
    {
      Object localObject1 = androidx.core.app.d.g((Activity)this.gP);
      if (localObject1 != null)
      {
        localObject1 = this.mActionBar;
        if (localObject1 == null) {
          this.hw = true;
        }
      }
      else
      {
        if ((paramBundle != null) && (this.hq == -100)) {
          this.hq = paramBundle.getInt("appcompat:local_night_mode", -100);
        }
        AppMethodBeat.o(200792);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject2 = null;
        continue;
        localObject2.z(true);
      }
    }
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(201067);
    paramView = a(paramView, paramString, paramContext, paramAttributeSet);
    AppMethodBeat.o(201067);
    return paramView;
  }
  
  public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(201072);
    paramString = onCreateView(null, paramString, paramContext, paramAttributeSet);
    AppMethodBeat.o(201072);
    return paramString;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200929);
    if (this.ht) {
      this.fo.getDecorView().removeCallbacks(this.hv);
    }
    this.mIsDestroyed = true;
    if (this.mActionBar != null) {
      this.mActionBar.onDestroy();
    }
    if (this.hs != null) {
      this.hs.cleanup();
    }
    AppMethodBeat.o(200929);
  }
  
  final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(201040);
    Object localObject = getSupportActionBar();
    if ((localObject != null) && (((ActionBar)localObject).onKeyShortcut(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(201040);
      return true;
    }
    if ((this.ho != null) && (a(this.ho, paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      if (this.ho != null) {
        this.ho.hT = true;
      }
      AppMethodBeat.o(201040);
      return true;
    }
    if (this.ho == null)
    {
      localObject = P(0);
      b((PanelFeatureState)localObject, paramKeyEvent);
      boolean bool = a((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent);
      ((PanelFeatureState)localObject).hS = false;
      if (bool)
      {
        AppMethodBeat.o(201040);
        return true;
      }
    }
    AppMethodBeat.o(201040);
    return false;
  }
  
  public final void onPostResume()
  {
    AppMethodBeat.i(200878);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.A(true);
    }
    AppMethodBeat.o(200878);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(200919);
    if (this.hq != -100) {
      paramBundle.putInt("appcompat:local_night_mode", this.hq);
    }
    AppMethodBeat.o(200919);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(200860);
    bD();
    AppMethodBeat.o(200860);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(200869);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.A(false);
    }
    if (this.hs != null) {
      this.hs.cleanup();
    }
    AppMethodBeat.o(200869);
  }
  
  public final void setContentView(int paramInt)
  {
    AppMethodBeat.i(200893);
    bH();
    ViewGroup localViewGroup = (ViewGroup)this.hd.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.mContext).inflate(paramInt, localViewGroup);
    this.gP.onContentChanged();
    AppMethodBeat.o(200893);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(200885);
    bH();
    ViewGroup localViewGroup = (ViewGroup)this.hd.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.gP.onContentChanged();
    AppMethodBeat.o(200885);
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(200902);
    bH();
    ViewGroup localViewGroup = (ViewGroup)this.hd.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.gP.onContentChanged();
    AppMethodBeat.o(200902);
  }
  
  public final void setSupportActionBar(Toolbar paramToolbar)
  {
    AppMethodBeat.i(200827);
    if (!(this.gP instanceof Activity))
    {
      AppMethodBeat.o(200827);
      return;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar instanceof j))
    {
      paramToolbar = new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
      AppMethodBeat.o(200827);
      throw paramToolbar;
    }
    this.gS = null;
    if (localActionBar != null) {
      localActionBar.onDestroy();
    }
    if (paramToolbar != null)
    {
      paramToolbar = new g(paramToolbar, ((Activity)this.gP).getTitle(), this.gQ);
      this.mActionBar = paramToolbar;
      this.fo.setCallback(paramToolbar.is);
    }
    for (;;)
    {
      invalidateOptionsMenu();
      AppMethodBeat.o(200827);
      return;
      this.mActionBar = null;
      this.fo.setCallback(this.gQ);
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200950);
    this.cZ = paramCharSequence;
    if (this.gT != null)
    {
      this.gT.setWindowTitle(paramCharSequence);
      AppMethodBeat.o(200950);
      return;
    }
    if (this.mActionBar != null)
    {
      this.mActionBar.setWindowTitle(paramCharSequence);
      AppMethodBeat.o(200950);
      return;
    }
    if (this.fO != null) {
      this.fO.setText(paramCharSequence);
    }
    AppMethodBeat.o(200950);
  }
  
  public final b startSupportActionMode(b.a parama)
  {
    AppMethodBeat.i(200999);
    if (parama == null)
    {
      parama = new IllegalArgumentException("ActionMode callback can not be null.");
      AppMethodBeat.o(200999);
      throw parama;
    }
    if (this.gW != null) {
      this.gW.finish();
    }
    parama = new c(parama);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      this.gW = localActionBar.a(parama);
      if ((this.gW != null) && (this.gR != null)) {
        this.gR.onSupportActionModeStarted(this.gW);
      }
    }
    if (this.gW == null) {
      this.gW = b(parama);
    }
    parama = this.gW;
    AppMethodBeat.o(200999);
    return parama;
  }
  
  protected static final class PanelFeatureState
  {
    int background;
    int fl;
    int hK;
    int hL;
    ViewGroup hM;
    View hN;
    View hO;
    androidx.appcompat.view.menu.h hP;
    androidx.appcompat.view.menu.f hQ;
    Context hR;
    boolean hS;
    boolean hT;
    boolean hU;
    public boolean hV;
    boolean hW;
    boolean hX;
    Bundle hY;
    int x;
    int y;
    
    PanelFeatureState(int paramInt)
    {
      this.hK = paramInt;
      this.hW = false;
    }
    
    final void G(Context paramContext)
    {
      AppMethodBeat.i(200559);
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(androidx.appcompat.a.a.actionBarPopupTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      localTheme.resolveAttribute(androidx.appcompat.a.a.panelMenuListTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      for (;;)
      {
        paramContext = new androidx.appcompat.view.d(paramContext, 0);
        paramContext.getTheme().setTo(localTheme);
        this.hR = paramContext;
        paramContext = paramContext.obtainStyledAttributes(a.j.AppCompatTheme);
        this.background = paramContext.getResourceId(a.j.AppCompatTheme_panelBackground, 0);
        this.hL = paramContext.getResourceId(a.j.AppCompatTheme_android_windowAnimationStyle, 0);
        paramContext.recycle();
        AppMethodBeat.o(200559);
        return;
        localTheme.applyStyle(a.i.Theme_AppCompat_CompactMenu, true);
      }
    }
    
    final p a(o.a parama)
    {
      AppMethodBeat.i(200578);
      if (this.hP == null)
      {
        AppMethodBeat.o(200578);
        return null;
      }
      if (this.hQ == null)
      {
        this.hQ = new androidx.appcompat.view.menu.f(this.hR, a.g.abc_list_menu_item_layout);
        this.hQ.ml = parama;
        this.hP.a(this.hQ);
      }
      parama = this.hQ.a(this.hM);
      AppMethodBeat.o(200578);
      return parama;
    }
    
    public final boolean bT()
    {
      AppMethodBeat.i(200546);
      if (this.hN == null)
      {
        AppMethodBeat.o(200546);
        return false;
      }
      if (this.hO != null)
      {
        AppMethodBeat.o(200546);
        return true;
      }
      if (this.hQ.getAdapter().getCount() > 0)
      {
        AppMethodBeat.o(200546);
        return true;
      }
      AppMethodBeat.o(200546);
      return false;
    }
    
    final void d(androidx.appcompat.view.menu.h paramh)
    {
      AppMethodBeat.i(200567);
      if (paramh == this.hP)
      {
        AppMethodBeat.o(200567);
        return;
      }
      if (this.hP != null) {
        this.hP.b(this.hQ);
      }
      this.hP = paramh;
      if ((paramh != null) && (this.hQ != null)) {
        paramh.a(this.hQ);
      }
      AppMethodBeat.o(200567);
    }
  }
  
  final class a
    implements a.a
  {
    a() {}
  }
  
  final class b
    implements o.a
  {
    b() {}
    
    public final void a(androidx.appcompat.view.menu.h paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(200335);
      AppCompatDelegateImpl.this.b(paramh);
      AppMethodBeat.o(200335);
    }
    
    public final boolean c(androidx.appcompat.view.menu.h paramh)
    {
      AppMethodBeat.i(200329);
      Window.Callback localCallback = AppCompatDelegateImpl.this.fo.getCallback();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramh);
      }
      AppMethodBeat.o(200329);
      return true;
    }
  }
  
  final class c
    implements b.a
  {
    private b.a hD;
    
    public c(b.a parama)
    {
      this.hD = parama;
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(200351);
      this.hD.a(paramb);
      if (AppCompatDelegateImpl.this.gY != null) {
        AppCompatDelegateImpl.this.fo.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.gZ);
      }
      if (AppCompatDelegateImpl.this.gX != null)
      {
        AppCompatDelegateImpl.this.bL();
        AppCompatDelegateImpl.this.ha = z.ac(AppCompatDelegateImpl.this.gX).ao(0.0F);
        AppCompatDelegateImpl.this.ha.b(new af()
        {
          public final void f(View paramAnonymousView)
          {
            AppMethodBeat.i(200628);
            AppCompatDelegateImpl.this.gX.setVisibility(8);
            if (AppCompatDelegateImpl.this.gY != null) {
              AppCompatDelegateImpl.this.gY.dismiss();
            }
            for (;;)
            {
              AppCompatDelegateImpl.this.gX.removeAllViews();
              AppCompatDelegateImpl.this.ha.b(null);
              AppCompatDelegateImpl.this.ha = null;
              AppMethodBeat.o(200628);
              return;
              if ((AppCompatDelegateImpl.this.gX.getParent() instanceof View)) {
                z.ak((View)AppCompatDelegateImpl.this.gX.getParent());
              }
            }
          }
        });
      }
      if (AppCompatDelegateImpl.this.gR != null) {
        AppCompatDelegateImpl.this.gR.onSupportActionModeFinished(AppCompatDelegateImpl.this.gW);
      }
      AppCompatDelegateImpl.this.gW = null;
      AppMethodBeat.o(200351);
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(200328);
      boolean bool = this.hD.a(paramb, paramMenu);
      AppMethodBeat.o(200328);
      return bool;
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(200340);
      boolean bool = this.hD.a(paramb, paramMenuItem);
      AppMethodBeat.o(200340);
      return bool;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(200334);
      boolean bool = this.hD.b(paramb, paramMenu);
      AppMethodBeat.o(200334);
      return bool;
    }
  }
  
  final class d
    extends androidx.appcompat.view.i
  {
    d(Window.Callback paramCallback)
    {
      super();
    }
    
    private ActionMode a(ActionMode.Callback paramCallback)
    {
      AppMethodBeat.i(200339);
      paramCallback = new androidx.appcompat.view.f.a(AppCompatDelegateImpl.this.mContext, paramCallback);
      b localb = AppCompatDelegateImpl.this.startSupportActionMode(paramCallback);
      if (localb != null)
      {
        paramCallback = paramCallback.b(localb);
        AppMethodBeat.o(200339);
        return paramCallback;
      }
      AppMethodBeat.o(200339);
      return null;
    }
    
    public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(200347);
      if ((AppCompatDelegateImpl.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent)))
      {
        AppMethodBeat.o(200347);
        return true;
      }
      AppMethodBeat.o(200347);
      return false;
    }
    
    public final boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(200355);
      if ((super.dispatchKeyShortcutEvent(paramKeyEvent)) || (AppCompatDelegateImpl.this.onKeyShortcut(paramKeyEvent.getKeyCode(), paramKeyEvent)))
      {
        AppMethodBeat.o(200355);
        return true;
      }
      AppMethodBeat.o(200355);
      return false;
    }
    
    public final void onContentChanged() {}
    
    public final boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      AppMethodBeat.i(200362);
      if ((paramInt == 0) && (!(paramMenu instanceof androidx.appcompat.view.menu.h)))
      {
        AppMethodBeat.o(200362);
        return false;
      }
      boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
      AppMethodBeat.o(200362);
      return bool;
    }
    
    public final boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      AppMethodBeat.i(200387);
      super.onMenuOpened(paramInt, paramMenu);
      paramMenu = AppCompatDelegateImpl.this;
      if (paramInt == 108)
      {
        paramMenu = paramMenu.getSupportActionBar();
        if (paramMenu != null) {
          paramMenu.B(true);
        }
      }
      AppMethodBeat.o(200387);
      return true;
    }
    
    public final void onPanelClosed(int paramInt, Menu paramMenu)
    {
      AppMethodBeat.i(200393);
      super.onPanelClosed(paramInt, paramMenu);
      AppCompatDelegateImpl.this.O(paramInt);
      AppMethodBeat.o(200393);
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      AppMethodBeat.i(200379);
      if ((paramMenu instanceof androidx.appcompat.view.menu.h)) {}
      for (androidx.appcompat.view.menu.h localh = (androidx.appcompat.view.menu.h)paramMenu; (paramInt == 0) && (localh == null); localh = null)
      {
        AppMethodBeat.o(200379);
        return false;
      }
      if (localh != null) {
        localh.nT = true;
      }
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if (localh != null) {
        localh.nT = false;
      }
      AppMethodBeat.o(200379);
      return bool;
    }
    
    public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
    {
      AppMethodBeat.i(200424);
      AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = AppCompatDelegateImpl.this.P(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.hP != null))
      {
        super.onProvideKeyboardShortcuts(paramList, localPanelFeatureState.hP, paramInt);
        AppMethodBeat.o(200424);
        return;
      }
      super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
      AppMethodBeat.o(200424);
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      AppMethodBeat.i(200401);
      if (Build.VERSION.SDK_INT >= 23)
      {
        AppMethodBeat.o(200401);
        return null;
      }
      if (AppCompatDelegateImpl.this.hb)
      {
        paramCallback = a(paramCallback);
        AppMethodBeat.o(200401);
        return paramCallback;
      }
      paramCallback = super.onWindowStartingActionMode(paramCallback);
      AppMethodBeat.o(200401);
      return paramCallback;
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      AppMethodBeat.i(200415);
      if (AppCompatDelegateImpl.this.hb) {}
      switch (paramInt)
      {
      default: 
        paramCallback = super.onWindowStartingActionMode(paramCallback, paramInt);
        AppMethodBeat.o(200415);
        return paramCallback;
      }
      paramCallback = a(paramCallback);
      AppMethodBeat.o(200415);
      return paramCallback;
    }
  }
  
  final class e
  {
    i hF;
    boolean hG;
    private BroadcastReceiver hH;
    private IntentFilter hI;
    
    e(i parami)
    {
      AppMethodBeat.i(200301);
      this.hF = parami;
      this.hG = parami.bW();
      AppMethodBeat.o(200301);
    }
    
    final int bS()
    {
      AppMethodBeat.i(200305);
      this.hG = this.hF.bW();
      if (this.hG)
      {
        AppMethodBeat.o(200305);
        return 2;
      }
      AppMethodBeat.o(200305);
      return 1;
    }
    
    final void cleanup()
    {
      AppMethodBeat.i(200312);
      if (this.hH != null)
      {
        AppCompatDelegateImpl.this.mContext.unregisterReceiver(this.hH);
        this.hH = null;
      }
      AppMethodBeat.o(200312);
    }
    
    final void setup()
    {
      AppMethodBeat.i(200308);
      cleanup();
      if (this.hH == null) {
        this.hH = new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(200534);
            paramAnonymousContext = AppCompatDelegateImpl.e.this;
            boolean bool = paramAnonymousContext.hF.bW();
            if (bool != paramAnonymousContext.hG)
            {
              paramAnonymousContext.hG = bool;
              paramAnonymousContext.hB.bD();
            }
            AppMethodBeat.o(200534);
          }
        };
      }
      if (this.hI == null)
      {
        this.hI = new IntentFilter();
        this.hI.addAction("android.intent.action.TIME_SET");
        this.hI.addAction("android.intent.action.TIMEZONE_CHANGED");
        this.hI.addAction("android.intent.action.TIME_TICK");
      }
      AppCompatDelegateImpl.this.mContext.registerReceiver(this.hH, this.hI);
      AppMethodBeat.o(200308);
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
      AppMethodBeat.i(200352);
      if ((AppCompatDelegateImpl.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent)))
      {
        AppMethodBeat.o(200352);
        return true;
      }
      AppMethodBeat.o(200352);
      return false;
    }
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200358);
      if (paramMotionEvent.getAction() == 0)
      {
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        if ((i < -5) || (j < -5) || (i > getWidth() + 5) || (j > getHeight() + 5)) {}
        for (i = 1; i != 0; i = 0)
        {
          AppCompatDelegateImpl.this.bM();
          AppMethodBeat.o(200358);
          return true;
        }
      }
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(200358);
      return bool;
    }
    
    public final void setBackgroundResource(int paramInt)
    {
      AppMethodBeat.i(200366);
      setBackgroundDrawable(a.m(getContext(), paramInt));
      AppMethodBeat.o(200366);
    }
  }
  
  final class g
    implements o.a
  {
    g() {}
    
    public final void a(androidx.appcompat.view.menu.h paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(200304);
      androidx.appcompat.view.menu.h localh = paramh.de();
      if (localh != paramh) {}
      for (int i = 1;; i = 0)
      {
        AppCompatDelegateImpl localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
        if (i != 0) {
          paramh = localh;
        }
        paramh = localAppCompatDelegateImpl.a(paramh);
        if (paramh == null) {
          break label90;
        }
        if (i == 0) {
          break;
        }
        AppCompatDelegateImpl.this.a(paramh.hK, paramh, localh);
        AppCompatDelegateImpl.this.a(paramh, true);
        AppMethodBeat.o(200304);
        return;
      }
      AppCompatDelegateImpl.this.a(paramh, paramBoolean);
      label90:
      AppMethodBeat.o(200304);
    }
    
    public final boolean c(androidx.appcompat.view.menu.h paramh)
    {
      AppMethodBeat.i(200313);
      if ((paramh == null) && (AppCompatDelegateImpl.this.hh))
      {
        Window.Callback localCallback = AppCompatDelegateImpl.this.fo.getCallback();
        if ((localCallback != null) && (!AppCompatDelegateImpl.this.mIsDestroyed)) {
          localCallback.onMenuOpened(108, paramh);
        }
      }
      AppMethodBeat.o(200313);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl
 * JD-Core Version:    0.7.0.1
 */