package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
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
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
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
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.aa;
import android.support.v7.widget.aa.a;
import android.support.v7.widget.aw;
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
  private static final boolean Ou;
  private static final int[] Ov;
  private static boolean Ow;
  private CharSequence Cv;
  final Window Na;
  private TextView Nx;
  private android.support.v7.widget.t OA;
  private b OB;
  private g OC;
  b OD;
  ActionBarContextView OE;
  PopupWindow OF;
  Runnable OG;
  x OH = null;
  boolean OI = true;
  private boolean OJ;
  private ViewGroup OL;
  private View OM;
  private boolean OO;
  private boolean OP;
  boolean OQ;
  boolean OR;
  boolean OS;
  boolean OT;
  boolean OU;
  private boolean OV;
  private PanelFeatureState[] OW;
  private PanelFeatureState OX;
  private boolean OY;
  boolean OZ;
  final Window.Callback Ox;
  final Window.Callback Oy;
  final c Oz;
  private int Pa = -100;
  private boolean Pb;
  private e Pc;
  boolean Pd;
  int Pe;
  private final Runnable Pf = new Runnable()
  {
    public final void run()
    {
      if ((AppCompatDelegateImpl.this.Pe & 0x1) != 0) {
        AppCompatDelegateImpl.this.aQ(0);
      }
      if ((AppCompatDelegateImpl.this.Pe & 0x1000) != 0) {
        AppCompatDelegateImpl.this.aQ(108);
      }
      AppCompatDelegateImpl.this.Pd = false;
      AppCompatDelegateImpl.this.Pe = 0;
    }
  };
  private boolean Pg;
  private AppCompatViewInflater Ph;
  MenuInflater gd;
  private Rect jW;
  private Rect jX;
  ActionBar mActionBar;
  final Context mContext;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      Ou = bool;
      Ov = new int[] { 16842836 };
      if ((Ou) && (!Ow))
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
              this.Pi.uncaughtException(paramAnonymousThread, (Throwable)localObject);
              return;
            }
            this.Pi.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
          }
        });
        Ow = true;
      }
      return;
    }
  }
  
  AppCompatDelegateImpl(Context paramContext, Window paramWindow, c paramc)
  {
    this.mContext = paramContext;
    this.Na = paramWindow;
    this.Oz = paramc;
    this.Ox = this.Na.getCallback();
    if ((this.Ox instanceof d)) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    this.Oy = new d(this.Ox);
    this.Na.setCallback(this.Oy);
    paramContext = az.a(paramContext, null, Ov);
    paramWindow = paramContext.cH(0);
    if (paramWindow != null) {
      this.Na.setBackgroundDrawable(paramWindow);
    }
    paramContext.aoo.recycle();
  }
  
  private View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    int j = 1;
    Object localObject;
    boolean bool1;
    if (this.Ph == null)
    {
      localObject = this.mContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme).getString(120);
      if ((localObject == null) || (AppCompatViewInflater.class.getName().equals(localObject))) {
        this.Ph = new AppCompatViewInflater();
      }
    }
    else
    {
      if (!Ou) {
        break label1016;
      }
      if (!(paramAttributeSet instanceof XmlPullParser)) {
        break label533;
      }
      if (((XmlPullParser)paramAttributeSet).getDepth() <= 1) {
        break label527;
      }
      bool1 = true;
    }
    for (;;)
    {
      label87:
      AppCompatViewInflater localAppCompatViewInflater = this.Ph;
      boolean bool2 = Ou;
      boolean bool3 = be.kZ();
      if ((bool1) && (paramView != null)) {}
      for (paramView = paramView.getContext();; paramView = paramContext)
      {
        localObject = paramView.obtainStyledAttributes(paramAttributeSet, android.support.v7.a.a.a.View, 0, 0);
        if (bool2) {}
        for (int i = ((TypedArray)localObject).getResourceId(0, 0);; i = 0)
        {
          if (i == 0) {
            i = ((TypedArray)localObject).getResourceId(4, 0);
          }
          for (;;)
          {
            ((TypedArray)localObject).recycle();
            if ((i != 0) && ((!(paramView instanceof android.support.v7.view.d)) || (((android.support.v7.view.d)paramView).TD != i))) {
              paramView = new android.support.v7.view.d(paramView, i);
            }
            for (;;)
            {
              localObject = paramView;
              if (bool3) {
                localObject = aw.Z(paramView);
              }
              switch (paramString.hashCode())
              {
              default: 
                label332:
                i = -1;
                switch (i)
                {
                default: 
                  label335:
                  paramView = null;
                  label406:
                  if ((paramView == null) && (paramContext != localObject)) {
                    paramView = localAppCompatViewInflater.a((Context)localObject, paramString, paramAttributeSet);
                  }
                  break;
                }
                break;
              }
              for (;;)
              {
                for (;;)
                {
                  if (paramView != null)
                  {
                    paramString = paramView.getContext();
                    if (((paramString instanceof ContextWrapper)) && ((Build.VERSION.SDK_INT < 15) || (android.support.v4.view.t.ax(paramView)))) {
                      break label957;
                    }
                  }
                  return paramView;
                  try
                  {
                    this.Ph = ((AppCompatViewInflater)Class.forName((String)localObject).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                  }
                  catch (Throwable localThrowable)
                  {
                    new StringBuilder("Failed to instantiate custom view inflater ").append((String)localObject).append(". Falling back to default.");
                    this.Ph = new AppCompatViewInflater();
                  }
                }
                break;
                label527:
                bool1 = false;
                break label87;
                label533:
                bool1 = a((ViewParent)paramView);
                break label87;
                if (!paramString.equals("TextView")) {
                  break label332;
                }
                i = 0;
                break label335;
                if (!paramString.equals("ImageView")) {
                  break label332;
                }
                i = j;
                break label335;
                if (!paramString.equals("Button")) {
                  break label332;
                }
                i = 2;
                break label335;
                if (!paramString.equals("EditText")) {
                  break label332;
                }
                i = 3;
                break label335;
                if (!paramString.equals("Spinner")) {
                  break label332;
                }
                i = 4;
                break label335;
                if (!paramString.equals("ImageButton")) {
                  break label332;
                }
                i = 5;
                break label335;
                if (!paramString.equals("CheckBox")) {
                  break label332;
                }
                i = 6;
                break label335;
                if (!paramString.equals("RadioButton")) {
                  break label332;
                }
                i = 7;
                break label335;
                if (!paramString.equals("CheckedTextView")) {
                  break label332;
                }
                i = 8;
                break label335;
                if (!paramString.equals("AutoCompleteTextView")) {
                  break label332;
                }
                i = 9;
                break label335;
                if (!paramString.equals("MultiAutoCompleteTextView")) {
                  break label332;
                }
                i = 10;
                break label335;
                if (!paramString.equals("RatingBar")) {
                  break label332;
                }
                i = 11;
                break label335;
                if (!paramString.equals("SeekBar")) {
                  break label332;
                }
                i = 12;
                break label335;
                paramView = new AppCompatTextView((Context)localObject, paramAttributeSet);
                break label406;
                paramView = new AppCompatImageView((Context)localObject, paramAttributeSet);
                break label406;
                paramView = new AppCompatButton((Context)localObject, paramAttributeSet);
                break label406;
                paramView = new AppCompatEditText((Context)localObject, paramAttributeSet);
                break label406;
                paramView = new AppCompatSpinner((Context)localObject, paramAttributeSet);
                break label406;
                paramView = new AppCompatImageButton((Context)localObject, paramAttributeSet);
                break label406;
                paramView = new AppCompatCheckBox((Context)localObject, paramAttributeSet);
                break label406;
                paramView = new AppCompatRadioButton((Context)localObject, paramAttributeSet);
                break label406;
                paramView = new AppCompatCheckedTextView((Context)localObject, paramAttributeSet);
                break label406;
                paramView = new AppCompatAutoCompleteTextView((Context)localObject, paramAttributeSet);
                break label406;
                paramView = new AppCompatMultiAutoCompleteTextView((Context)localObject, paramAttributeSet);
                break label406;
                paramView = new AppCompatRatingBar((Context)localObject, paramAttributeSet);
                break label406;
                paramView = new AppCompatSeekBar((Context)localObject, paramAttributeSet);
                break label406;
                label957:
                paramString = paramString.obtainStyledAttributes(paramAttributeSet, AppCompatViewInflater.PI);
                paramContext = paramString.getString(0);
                if (paramContext != null) {
                  paramView.setOnClickListener(new AppCompatViewInflater.a(paramView, paramContext));
                }
                paramString.recycle();
                return paramView;
              }
            }
          }
        }
      }
      label1016:
      bool1 = false;
    }
  }
  
  private void a(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    int j = -1;
    if ((paramPanelFeatureState.LB) || (this.OZ)) {}
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
          if (paramPanelFeatureState.Ps == 0) {
            if ((this.mContext.getResources().getConfiguration().screenLayout & 0xF) != 4) {
              break label90;
            }
          }
          for (i = 1; i == 0; i = 0)
          {
            localObject = this.Na.getCallback();
            if ((localObject == null) || (((Window.Callback)localObject).onMenuOpened(paramPanelFeatureState.Ps, paramPanelFeatureState.Pw))) {
              break label95;
            }
            a(paramPanelFeatureState, true);
            return;
          }
        }
        localObject = (WindowManager)this.mContext.getSystemService("window");
      } while ((localObject == null) || (!b(paramPanelFeatureState, paramKeyEvent)));
      if ((paramPanelFeatureState.Pt != null) && (!paramPanelFeatureState.PC)) {
        break label370;
      }
      if (paramPanelFeatureState.Pt != null) {
        break;
      }
      a(paramPanelFeatureState);
    } while (paramPanelFeatureState.Pt == null);
    label158:
    if ((c(paramPanelFeatureState)) && (paramPanelFeatureState.eR()))
    {
      paramKeyEvent = paramPanelFeatureState.Pu.getLayoutParams();
      if (paramKeyEvent != null) {
        break label406;
      }
      paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
    }
    label406:
    for (;;)
    {
      i = paramPanelFeatureState.background;
      paramPanelFeatureState.Pt.setBackgroundResource(i);
      ViewParent localViewParent = paramPanelFeatureState.Pu.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeView(paramPanelFeatureState.Pu);
      }
      paramPanelFeatureState.Pt.addView(paramPanelFeatureState.Pu, paramKeyEvent);
      if (!paramPanelFeatureState.Pu.hasFocus()) {
        paramPanelFeatureState.Pu.requestFocus();
      }
      i = -2;
      for (;;)
      {
        paramPanelFeatureState.PA = false;
        paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.x, paramPanelFeatureState.y, 1002, 8519680, -3);
        paramKeyEvent.gravity = paramPanelFeatureState.gravity;
        paramKeyEvent.windowAnimations = paramPanelFeatureState.windowAnimations;
        ((WindowManager)localObject).addView(paramPanelFeatureState.Pt, paramKeyEvent);
        paramPanelFeatureState.LB = true;
        return;
        if ((!paramPanelFeatureState.PC) || (paramPanelFeatureState.Pt.getChildCount() <= 0)) {
          break label158;
        }
        paramPanelFeatureState.Pt.removeAllViews();
        break label158;
        break;
        label370:
        if (paramPanelFeatureState.Pv != null)
        {
          paramKeyEvent = paramPanelFeatureState.Pv.getLayoutParams();
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
    paramPanelFeatureState.U(eF());
    paramPanelFeatureState.Pt = new f(paramPanelFeatureState.Py);
    paramPanelFeatureState.gravity = 81;
    return true;
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.isSystem()) {}
    while (((!paramPanelFeatureState.Pz) && (!b(paramPanelFeatureState, paramKeyEvent))) || (paramPanelFeatureState.Pw == null)) {
      return false;
    }
    return paramPanelFeatureState.Pw.performShortcut(paramInt, paramKeyEvent, 1);
  }
  
  private boolean a(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    View localView = this.Na.getDecorView();
    for (;;)
    {
      if (paramViewParent == null) {
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View)) || (android.support.v4.view.t.aw((View)paramViewParent))) {
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
  }
  
  private static int aS(int paramInt)
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
  
  private int aT(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      if ((Build.VERSION.SDK_INT >= 23) && (((UiModeManager)this.mContext.getSystemService(UiModeManager.class)).getNightMode() == 0)) {
        return -1;
      }
      eO();
      return this.Pc.eQ();
    }
    return -1;
  }
  
  private boolean aU(int paramInt)
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
      if (!eP()) {
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
  
  private b b(b.a parama)
  {
    eK();
    if (this.OD != null) {
      this.OD.finish();
    }
    if ((this.Oz != null) && (!this.OZ)) {}
    for (;;)
    {
      try
      {
        b localb = this.Oz.onWindowStartingSupportActionMode(parama);
        if (localb == null) {
          break label95;
        }
        this.OD = localb;
        if ((this.OD != null) && (this.Oz != null)) {
          this.Oz.onSupportActionModeStarted(this.OD);
        }
        return this.OD;
      }
      catch (AbstractMethodError localAbstractMethodError) {}
      Object localObject1 = null;
      continue;
      label95:
      Object localObject2;
      label201:
      boolean bool;
      if (this.OE == null)
      {
        if (!this.OT) {
          break label492;
        }
        localObject2 = new TypedValue();
        localObject1 = this.mContext.getTheme();
        ((Resources.Theme)localObject1).resolveAttribute(2130772141, (TypedValue)localObject2, true);
        if (((TypedValue)localObject2).resourceId != 0)
        {
          Resources.Theme localTheme = this.mContext.getResources().newTheme();
          localTheme.setTo((Resources.Theme)localObject1);
          localTheme.applyStyle(((TypedValue)localObject2).resourceId, true);
          localObject1 = new android.support.v7.view.d(this.mContext, 0);
          ((Context)localObject1).getTheme().setTo(localTheme);
          this.OE = new ActionBarContextView((Context)localObject1);
          this.OF = new PopupWindow((Context)localObject1, null, 2130772160);
          n.a(this.OF, 2);
          this.OF.setContentView(this.OE);
          this.OF.setWidth(-1);
          ((Context)localObject1).getTheme().resolveAttribute(2130772143, (TypedValue)localObject2, true);
          int i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, ((Context)localObject1).getResources().getDisplayMetrics());
          this.OE.setContentHeight(i);
          this.OF.setHeight(-2);
          this.OG = new Runnable()
          {
            public final void run()
            {
              AppCompatDelegateImpl.this.OF.showAtLocation(AppCompatDelegateImpl.this.OE, 55, 0, 0);
              AppCompatDelegateImpl.this.eK();
              if (AppCompatDelegateImpl.this.eJ())
              {
                AppCompatDelegateImpl.this.OE.setAlpha(0.0F);
                AppCompatDelegateImpl.this.OH = android.support.v4.view.t.ab(AppCompatDelegateImpl.this.OE).s(1.0F);
                AppCompatDelegateImpl.this.OH.a(new z()
                {
                  public final void aB(View paramAnonymous2View)
                  {
                    AppCompatDelegateImpl.this.OE.setVisibility(0);
                  }
                  
                  public final void aC(View paramAnonymous2View)
                  {
                    AppCompatDelegateImpl.this.OE.setAlpha(1.0F);
                    AppCompatDelegateImpl.this.OH.a(null);
                    AppCompatDelegateImpl.this.OH = null;
                  }
                });
                return;
              }
              AppCompatDelegateImpl.this.OE.setAlpha(1.0F);
              AppCompatDelegateImpl.this.OE.setVisibility(0);
            }
          };
        }
      }
      else
      {
        label319:
        if (this.OE == null) {
          break label537;
        }
        eK();
        this.OE.gu();
        localObject1 = this.OE.getContext();
        localObject2 = this.OE;
        if (this.OF != null) {
          break label539;
        }
        bool = true;
        label361:
        localObject1 = new android.support.v7.view.e((Context)localObject1, (ActionBarContextView)localObject2, parama, bool);
        if (!parama.a((b)localObject1, ((b)localObject1).getMenu())) {
          break label598;
        }
        ((b)localObject1).invalidate();
        this.OE.c((b)localObject1);
        this.OD = ((b)localObject1);
        if (!eJ()) {
          break label544;
        }
        this.OE.setAlpha(0.0F);
        this.OH = android.support.v4.view.t.ab(this.OE).s(1.0F);
        this.OH.a(new z()
        {
          public final void aB(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.OE.setVisibility(0);
            AppCompatDelegateImpl.this.OE.sendAccessibilityEvent(32);
            if ((AppCompatDelegateImpl.this.OE.getParent() instanceof View)) {
              android.support.v4.view.t.ak((View)AppCompatDelegateImpl.this.OE.getParent());
            }
          }
          
          public final void aC(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.OE.setAlpha(1.0F);
            AppCompatDelegateImpl.this.OH.a(null);
            AppCompatDelegateImpl.this.OH = null;
          }
        });
      }
      for (;;)
      {
        if (this.OF == null) {
          break label596;
        }
        this.Na.getDecorView().post(this.OG);
        break;
        localObject1 = this.mContext;
        break label201;
        label492:
        localObject1 = (ViewStubCompat)this.OL.findViewById(2131820953);
        if (localObject1 == null) {
          break label319;
        }
        ((ViewStubCompat)localObject1).setLayoutInflater(LayoutInflater.from(eF()));
        this.OE = ((ActionBarContextView)((ViewStubCompat)localObject1).inflate());
        break label319;
        label537:
        break;
        label539:
        bool = false;
        break label361;
        label544:
        this.OE.setAlpha(1.0F);
        this.OE.setVisibility(0);
        this.OE.sendAccessibilityEvent(32);
        if ((this.OE.getParent() instanceof View)) {
          android.support.v4.view.t.ak((View)this.OE.getParent());
        }
      }
      label596:
      continue;
      label598:
      this.OD = null;
    }
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState)
  {
    Context localContext = this.mContext;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if (((paramPanelFeatureState.Ps == 0) || (paramPanelFeatureState.Ps == 108)) && (this.OA != null))
    {
      localTypedValue = new TypedValue();
      localTheme = localContext.getTheme();
      localTheme.resolveAttribute(2130772141, localTypedValue, true);
      localObject1 = null;
      if (localTypedValue.resourceId != 0)
      {
        localObject1 = localContext.getResources().newTheme();
        ((Resources.Theme)localObject1).setTo(localTheme);
        ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
        ((Resources.Theme)localObject1).resolveAttribute(2130772142, localTypedValue, true);
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
      localTheme.resolveAttribute(2130772142, localTypedValue, true);
      break;
      label203:
      localObject1 = localContext;
    }
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (this.OZ) {
      return false;
    }
    if (paramPanelFeatureState.Pz) {
      return true;
    }
    if ((this.OX != null) && (this.OX != paramPanelFeatureState)) {
      a(this.OX, false);
    }
    Window.Callback localCallback = this.Na.getCallback();
    if (localCallback != null) {
      paramPanelFeatureState.Pv = localCallback.onCreatePanelView(paramPanelFeatureState.Ps);
    }
    if ((paramPanelFeatureState.Ps == 0) || (paramPanelFeatureState.Ps == 108)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.OA != null)) {
        this.OA.gz();
      }
      if ((paramPanelFeatureState.Pv != null) || ((i != 0) && ((this.mActionBar instanceof g)))) {
        break label408;
      }
      if ((paramPanelFeatureState.Pw != null) && (!paramPanelFeatureState.PD)) {
        break label278;
      }
      if (paramPanelFeatureState.Pw == null)
      {
        b(paramPanelFeatureState);
        if (paramPanelFeatureState.Pw == null) {
          break;
        }
      }
      if ((i != 0) && (this.OA != null))
      {
        if (this.OB == null) {
          this.OB = new b();
        }
        this.OA.a(paramPanelFeatureState.Pw, this.OB);
      }
      paramPanelFeatureState.Pw.fX();
      if (localCallback.onCreatePanelMenu(paramPanelFeatureState.Ps, paramPanelFeatureState.Pw)) {
        break label273;
      }
      paramPanelFeatureState.e(null);
      if ((i == 0) || (this.OA == null)) {
        break;
      }
      this.OA.a(null, this.OB);
      return false;
    }
    label273:
    paramPanelFeatureState.PD = false;
    label278:
    paramPanelFeatureState.Pw.fX();
    if (paramPanelFeatureState.PE != null)
    {
      paramPanelFeatureState.Pw.e(paramPanelFeatureState.PE);
      paramPanelFeatureState.PE = null;
    }
    if (!localCallback.onPreparePanel(0, paramPanelFeatureState.Pv, paramPanelFeatureState.Pw))
    {
      if ((i != 0) && (this.OA != null)) {
        this.OA.a(null, this.OB);
      }
      paramPanelFeatureState.Pw.fY();
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
      paramPanelFeatureState.PB = bool;
      paramPanelFeatureState.Pw.setQwertyMode(paramPanelFeatureState.PB);
      paramPanelFeatureState.Pw.fY();
      paramPanelFeatureState.Pz = true;
      paramPanelFeatureState.PA = false;
      this.OX = paramPanelFeatureState;
      return true;
      i = -1;
      break;
    }
  }
  
  private boolean c(PanelFeatureState paramPanelFeatureState)
  {
    if (paramPanelFeatureState.Pv != null)
    {
      paramPanelFeatureState.Pu = paramPanelFeatureState.Pv;
      return true;
    }
    if (paramPanelFeatureState.Pw == null) {
      return false;
    }
    if (this.OC == null) {
      this.OC = new g();
    }
    paramPanelFeatureState.Pu = ((View)paramPanelFeatureState.b(this.OC));
    return paramPanelFeatureState.Pu != null;
  }
  
  private void eE()
  {
    eG();
    if ((!this.OQ) || (this.mActionBar != null)) {}
    for (;;)
    {
      return;
      if ((this.Ox instanceof Activity)) {
        this.mActionBar = new j((Activity)this.Ox, this.OR);
      }
      while (this.mActionBar != null)
      {
        this.mActionBar.K(this.Pg);
        return;
        if ((this.Ox instanceof Dialog)) {
          this.mActionBar = new j((Dialog)this.Ox);
        }
      }
    }
  }
  
  private Context eF()
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
  
  private void eG()
  {
    Object localObject;
    if (!this.OJ)
    {
      this.OL = eH();
      localObject = getTitle();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (this.OA == null) {
          break label84;
        }
        this.OA.setWindowTitle((CharSequence)localObject);
      }
    }
    for (;;)
    {
      eI();
      this.OJ = true;
      localObject = aP(0);
      if ((!this.OZ) && ((localObject == null) || (((PanelFeatureState)localObject).Pw == null))) {
        invalidatePanelMenu(108);
      }
      return;
      label84:
      if (this.mActionBar != null) {
        this.mActionBar.setWindowTitle((CharSequence)localObject);
      } else if (this.Nx != null) {
        this.Nx.setText((CharSequence)localObject);
      }
    }
  }
  
  private ViewGroup eH()
  {
    Object localObject = this.mContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme);
    if (!((TypedArray)localObject).hasValue(2))
    {
      ((TypedArray)localObject).recycle();
      throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }
    if (((TypedArray)localObject).getBoolean(3, false))
    {
      requestWindowFeature(1);
      if (((TypedArray)localObject).getBoolean(4, false)) {
        requestWindowFeature(109);
      }
      if (((TypedArray)localObject).getBoolean(5, false)) {
        requestWindowFeature(10);
      }
      this.OT = ((TypedArray)localObject).getBoolean(0, false);
      ((TypedArray)localObject).recycle();
      this.Na.getDecorView();
      localObject = LayoutInflater.from(this.mContext);
      if (this.OU) {
        break label418;
      }
      if (!this.OT) {
        break label256;
      }
      localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2130968596, null);
      this.OR = false;
      this.OQ = false;
    }
    for (;;)
    {
      if (localObject == null)
      {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.OQ + ", windowActionBarOverlay: " + this.OR + ", android:windowIsFloating: " + this.OT + ", windowActionModeOverlay: " + this.OS + ", windowNoTitle: " + this.OU + " }");
        if (!((TypedArray)localObject).getBoolean(2, false)) {
          break;
        }
        requestWindowFeature(108);
        break;
        label256:
        if (!this.OQ) {
          break label626;
        }
        localObject = new TypedValue();
        this.mContext.getTheme().resolveAttribute(2130772141, (TypedValue)localObject, true);
        if (((TypedValue)localObject).resourceId != 0) {}
        for (localObject = new android.support.v7.view.d(this.mContext, ((TypedValue)localObject).resourceId);; localObject = this.mContext)
        {
          localObject = (ViewGroup)LayoutInflater.from((Context)localObject).inflate(2130968607, null);
          this.OA = ((android.support.v7.widget.t)((ViewGroup)localObject).findViewById(2131820955));
          this.OA.setWindowCallback(this.Na.getCallback());
          if (this.OR) {
            this.OA.bc(109);
          }
          if (this.OO) {
            this.OA.bc(2);
          }
          if (this.OP) {
            this.OA.bc(5);
          }
          break;
        }
        label418:
        if (this.OS) {}
        for (localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2130968606, null);; localObject = (ViewGroup)((LayoutInflater)localObject).inflate(2130968605, null))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label475;
          }
          android.support.v4.view.t.a((View)localObject, new android.support.v4.view.p()
          {
            public final ab a(View paramAnonymousView, ab paramAnonymousab)
            {
              int i = paramAnonymousab.getSystemWindowInsetTop();
              int j = AppCompatDelegateImpl.this.aR(i);
              ab localab = paramAnonymousab;
              if (i != j) {
                localab = paramAnonymousab.f(paramAnonymousab.getSystemWindowInsetLeft(), j, paramAnonymousab.getSystemWindowInsetRight(), paramAnonymousab.getSystemWindowInsetBottom());
              }
              return android.support.v4.view.t.a(paramAnonymousView, localab);
            }
          });
          break;
        }
        label475:
        ((aa)localObject).setOnFitSystemWindowsListener(new aa.a()
        {
          public final void f(Rect paramAnonymousRect)
          {
            paramAnonymousRect.top = AppCompatDelegateImpl.this.aR(paramAnonymousRect.top);
          }
        });
        continue;
      }
      if (this.OA == null) {
        this.Nx = ((TextView)((ViewGroup)localObject).findViewById(2131820680));
      }
      bh.bZ((View)localObject);
      ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject).findViewById(2131820544);
      ViewGroup localViewGroup = (ViewGroup)this.Na.findViewById(16908290);
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
      this.Na.setContentView((View)localObject);
      localContentFrameLayout.setAttachListener(new ContentFrameLayout.a()
      {
        public final void onDetachedFromWindow()
        {
          AppCompatDelegateImpl.this.eN();
        }
      });
      return localObject;
      label626:
      localObject = null;
    }
  }
  
  private void eI()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.OL.findViewById(16908290);
    Object localObject = this.Na.getDecorView();
    localContentFrameLayout.j(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    localObject = this.mContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme);
    ((TypedArray)localObject).getValue(10, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(11, localContentFrameLayout.getMinWidthMinor());
    if (((TypedArray)localObject).hasValue(6)) {
      ((TypedArray)localObject).getValue(6, localContentFrameLayout.getFixedWidthMajor());
    }
    if (((TypedArray)localObject).hasValue(8)) {
      ((TypedArray)localObject).getValue(8, localContentFrameLayout.getFixedWidthMinor());
    }
    if (((TypedArray)localObject).hasValue(9)) {
      ((TypedArray)localObject).getValue(9, localContentFrameLayout.getFixedHeightMajor());
    }
    if (((TypedArray)localObject).hasValue(7)) {
      ((TypedArray)localObject).getValue(7, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
  }
  
  private void eM()
  {
    if (this.OJ) {
      throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }
  }
  
  private void eO()
  {
    if (this.Pc == null) {
      this.Pc = new e(i.V(this.mContext));
    }
  }
  
  private boolean eP()
  {
    PackageManager localPackageManager;
    if ((this.Pb) && ((this.mContext instanceof Activity))) {
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
    if (this.Pa != -100) {
      return this.Pa;
    }
    return d.Ot;
  }
  
  private CharSequence getTitle()
  {
    if ((this.Ox instanceof Activity)) {
      return ((Activity)this.Ox).getTitle();
    }
    return this.Cv;
  }
  
  private void invalidatePanelMenu(int paramInt)
  {
    this.Pe |= 1 << paramInt;
    if (!this.Pd)
    {
      android.support.v4.view.t.b(this.Na.getDecorView(), this.Pf);
      this.Pd = true;
    }
  }
  
  final PanelFeatureState a(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.OW;
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
      if ((localPanelFeatureState != null) && (localPanelFeatureState.Pw == paramMenu))
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
          if (paramInt < this.OW.length) {
            localPanelFeatureState = this.OW[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.Pw;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((PanelFeatureState)localObject1).LB)) {}
    while (this.OZ) {
      return;
    }
    this.Ox.onPanelClosed(paramInt, (Menu)localObject2);
  }
  
  final void a(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.Ps == 0) && (this.OA != null) && (this.OA.isOverflowMenuShowing())) {
      c(paramPanelFeatureState.Pw);
    }
    do
    {
      return;
      WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
      if ((localWindowManager != null) && (paramPanelFeatureState.LB) && (paramPanelFeatureState.Pt != null))
      {
        localWindowManager.removeView(paramPanelFeatureState.Pt);
        if (paramBoolean) {
          a(paramPanelFeatureState.Ps, paramPanelFeatureState, null);
        }
      }
      paramPanelFeatureState.Pz = false;
      paramPanelFeatureState.PA = false;
      paramPanelFeatureState.LB = false;
      paramPanelFeatureState.Pu = null;
      paramPanelFeatureState.PC = true;
    } while (this.OX != paramPanelFeatureState);
    this.OX = null;
  }
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = this.Na.getCallback();
    if ((localCallback != null) && (!this.OZ))
    {
      paramh = a(paramh.gf());
      if (paramh != null) {
        return localCallback.onMenuItemSelected(paramh.Ps, paramMenuItem);
      }
    }
    return false;
  }
  
  final void aO(int paramInt)
  {
    Object localObject;
    if (paramInt == 108)
    {
      localObject = getSupportActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).M(false);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      localObject = aP(paramInt);
    } while (!((PanelFeatureState)localObject).LB);
    a((PanelFeatureState)localObject, false);
  }
  
  protected final PanelFeatureState aP(int paramInt)
  {
    Object localObject2 = this.OW;
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
      this.OW = ((PanelFeatureState[])localObject1);
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
  
  final void aQ(int paramInt)
  {
    PanelFeatureState localPanelFeatureState = aP(paramInt);
    if (localPanelFeatureState.Pw != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState.Pw.d(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState.PE = localBundle;
      }
      localPanelFeatureState.Pw.fX();
      localPanelFeatureState.Pw.clear();
    }
    localPanelFeatureState.PD = true;
    localPanelFeatureState.PC = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.OA != null))
    {
      localPanelFeatureState = aP(0);
      if (localPanelFeatureState != null)
      {
        localPanelFeatureState.Pz = false;
        b(localPanelFeatureState, null);
      }
    }
  }
  
  final int aR(int paramInt)
  {
    int j = 1;
    int m = 0;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.OE != null) && ((this.OE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.OE.getLayoutParams();
      if (this.OE.isShown())
      {
        if (this.jW == null)
        {
          this.jW = new Rect();
          this.jX = new Rect();
        }
        localObject2 = this.jW;
        Rect localRect = this.jX;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        bh.a(this.OL, (Rect)localObject2, localRect);
        if (localRect.top == 0)
        {
          i = paramInt;
          if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == i) {
            break label351;
          }
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
          if (this.OM != null) {
            break label274;
          }
          this.OM = new View(this.mContext);
          this.OM.setBackgroundColor(this.mContext.getResources().getColor(2131689633));
          this.OL.addView(this.OM, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i = 1;
          label198:
          if (this.OM == null) {
            break label312;
          }
          label205:
          int k = paramInt;
          if (!this.OS)
          {
            k = paramInt;
            if (j != 0) {
              k = 0;
            }
          }
          paramInt = k;
          label228:
          if (i != 0) {
            this.OE.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.OM != null)
      {
        localObject1 = this.OM;
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
        localObject2 = this.OM.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
        {
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          this.OM.setLayoutParams((ViewGroup.LayoutParams)localObject2);
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
  
  public final void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    eG();
    ((ViewGroup)this.OL.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.Ox.onContentChanged();
  }
  
  public final void b(h paramh)
  {
    if ((this.OA != null) && (this.OA.gx()) && ((!ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) || (this.OA.gy())))
    {
      paramh = this.Na.getCallback();
      if (!this.OA.isOverflowMenuShowing()) {
        if ((paramh != null) && (!this.OZ))
        {
          if ((this.Pd) && ((this.Pe & 0x1) != 0))
          {
            this.Na.getDecorView().removeCallbacks(this.Pf);
            this.Pf.run();
          }
          PanelFeatureState localPanelFeatureState = aP(0);
          if ((localPanelFeatureState.Pw != null) && (!localPanelFeatureState.PD) && (paramh.onPreparePanel(0, localPanelFeatureState.Pv, localPanelFeatureState.Pw)))
          {
            paramh.onMenuOpened(108, localPanelFeatureState.Pw);
            this.OA.showOverflowMenu();
          }
        }
      }
      do
      {
        return;
        this.OA.hideOverflowMenu();
      } while (this.OZ);
      paramh.onPanelClosed(108, aP(0).Pw);
      return;
    }
    paramh = aP(0);
    paramh.PC = true;
    a(paramh, false);
    a(paramh, null);
  }
  
  final void c(h paramh)
  {
    if (this.OV) {
      return;
    }
    this.OV = true;
    this.OA.eN();
    Window.Callback localCallback = this.Na.getCallback();
    if ((localCallback != null) && (!this.OZ)) {
      localCallback.onPanelClosed(108, paramh);
    }
    this.OV = false;
  }
  
  final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (((this.Ox instanceof e.a)) || ((this.Ox instanceof e)))
    {
      localObject = this.Na.getDecorView();
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
          } while ((paramKeyEvent.getKeyCode() == 82) && (this.Ox.dispatchKeyEvent(paramKeyEvent)));
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
        localObject = aP(0);
      } while (((PanelFeatureState)localObject).LB);
      b((PanelFeatureState)localObject, paramKeyEvent);
      return true;
      if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
      for (bool = true;; bool = false)
      {
        this.OY = bool;
        break;
      }
      switch (j)
      {
      default: 
        return false;
      }
    } while (this.OD != null);
    Object localObject = aP(0);
    if ((this.OA != null) && (this.OA.gx()) && (!ViewConfiguration.get(this.mContext).hasPermanentMenuKey())) {
      if (!this.OA.isOverflowMenuShowing())
      {
        if ((this.OZ) || (!b((PanelFeatureState)localObject, paramKeyEvent))) {
          break label511;
        }
        bool = this.OA.showOverflowMenu();
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
      bool = this.OA.hideOverflowMenu();
      continue;
      if ((!((PanelFeatureState)localObject).LB) && (!((PanelFeatureState)localObject).PA)) {
        break label373;
      }
      bool = ((PanelFeatureState)localObject).LB;
      a((PanelFeatureState)localObject, true);
    }
    label373:
    if (((PanelFeatureState)localObject).Pz)
    {
      if (!((PanelFeatureState)localObject).PD) {
        break label517;
      }
      ((PanelFeatureState)localObject).Pz = false;
    }
    label517:
    for (boolean bool = b((PanelFeatureState)localObject, paramKeyEvent);; bool = true)
    {
      if (bool)
      {
        a((PanelFeatureState)localObject, paramKeyEvent);
        bool = true;
        break label296;
        bool = this.OY;
        this.OY = false;
        paramKeyEvent = aP(0);
        if ((paramKeyEvent != null) && (paramKeyEvent.LB))
        {
          if (bool) {
            break;
          }
          a(paramKeyEvent, true);
          return true;
        }
        if (this.OD != null)
        {
          this.OD.finish();
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
  
  public final void eB()
  {
    eG();
  }
  
  public final void eC()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    if (localLayoutInflater.getFactory() == null)
    {
      android.support.v4.view.f.b(localLayoutInflater, this);
      return;
    }
    localLayoutInflater.getFactory2();
  }
  
  public final boolean eD()
  {
    boolean bool = false;
    int i = getNightMode();
    int j = aT(i);
    if (j != -1) {
      bool = aU(j);
    }
    if (i == 0)
    {
      eO();
      this.Pc.setup();
    }
    this.Pb = true;
    return bool;
  }
  
  final boolean eJ()
  {
    return (this.OJ) && (this.OL != null) && (android.support.v4.view.t.as(this.OL));
  }
  
  final void eK()
  {
    if (this.OH != null) {
      this.OH.cancel();
    }
  }
  
  final void eL()
  {
    a(aP(0), true);
  }
  
  final void eN()
  {
    if (this.OA != null) {
      this.OA.eN();
    }
    if (this.OF != null)
    {
      this.Na.getDecorView().removeCallbacks(this.OG);
      if (!this.OF.isShowing()) {}
    }
    try
    {
      this.OF.dismiss();
      label55:
      this.OF = null;
      eK();
      PanelFeatureState localPanelFeatureState = aP(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.Pw != null)) {
        localPanelFeatureState.Pw.close();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label55;
    }
  }
  
  public final <T extends View> T findViewById(int paramInt)
  {
    eG();
    return this.Na.findViewById(paramInt);
  }
  
  public final a.a getDrawerToggleDelegate()
  {
    return new a();
  }
  
  public final MenuInflater getMenuInflater()
  {
    if (this.gd == null)
    {
      eE();
      if (this.mActionBar == null) {
        break label43;
      }
    }
    label43:
    for (Context localContext = this.mActionBar.getThemedContext();; localContext = this.mContext)
    {
      this.gd = new android.support.v7.view.g(localContext);
      return this.gd;
    }
  }
  
  public final ActionBar getSupportActionBar()
  {
    eE();
    return this.mActionBar;
  }
  
  public final void invalidateOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar != null) && (localActionBar.ez())) {
      return;
    }
    invalidatePanelMenu(0);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.OQ) && (this.OJ))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
    android.support.v7.widget.g.hg().X(this.mContext);
    eD();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    if ((this.Ox instanceof Activity)) {}
    try
    {
      Object localObject1 = q.i((Activity)this.Ox);
      if (localObject1 != null)
      {
        localObject1 = this.mActionBar;
        if (localObject1 == null) {
          this.Pg = true;
        }
      }
      else
      {
        if ((paramBundle != null) && (this.Pa == -100)) {
          this.Pa = paramBundle.getInt("appcompat:local_night_mode", -100);
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
        localObject2.K(true);
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
    if (this.Pd) {
      this.Na.getDecorView().removeCallbacks(this.Pf);
    }
    this.OZ = true;
    if (this.mActionBar != null) {
      this.mActionBar.onDestroy();
    }
    if (this.Pc != null) {
      this.Pc.cleanup();
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
        if ((this.OX == null) || (!a(this.OX, paramKeyEvent.getKeyCode(), paramKeyEvent))) {
          break;
        }
      } while (this.OX == null);
      this.OX.PA = true;
      return true;
      if (this.OX != null) {
        break;
      }
      localObject = aP(0);
      b((PanelFeatureState)localObject, paramKeyEvent);
      bool = a((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent);
      ((PanelFeatureState)localObject).Pz = false;
    } while (bool);
    return false;
  }
  
  public final void onPostResume()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.L(true);
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.Pa != -100) {
      paramBundle.putInt("appcompat:local_night_mode", this.Pa);
    }
  }
  
  public final void onStart()
  {
    eD();
  }
  
  public final void onStop()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.L(false);
    }
    if (this.Pc != null) {
      this.Pc.cleanup();
    }
  }
  
  public final boolean requestWindowFeature(int paramInt)
  {
    paramInt = aS(paramInt);
    if ((this.OU) && (paramInt == 108)) {
      return false;
    }
    if ((this.OQ) && (paramInt == 1)) {
      this.OQ = false;
    }
    switch (paramInt)
    {
    default: 
      return this.Na.requestFeature(paramInt);
    case 108: 
      eM();
      this.OQ = true;
      return true;
    case 109: 
      eM();
      this.OR = true;
      return true;
    case 10: 
      eM();
      this.OS = true;
      return true;
    case 2: 
      eM();
      this.OO = true;
      return true;
    case 5: 
      eM();
      this.OP = true;
      return true;
    }
    eM();
    this.OU = true;
    return true;
  }
  
  public final void setContentView(int paramInt)
  {
    eG();
    ViewGroup localViewGroup = (ViewGroup)this.OL.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.mContext).inflate(paramInt, localViewGroup);
    this.Ox.onContentChanged();
  }
  
  public final void setContentView(View paramView)
  {
    eG();
    ViewGroup localViewGroup = (ViewGroup)this.OL.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.Ox.onContentChanged();
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    eG();
    ViewGroup localViewGroup = (ViewGroup)this.OL.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.Ox.onContentChanged();
  }
  
  public final void setSupportActionBar(Toolbar paramToolbar)
  {
    if (!(this.Ox instanceof Activity)) {
      return;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar instanceof j)) {
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }
    this.gd = null;
    if (localActionBar != null) {
      localActionBar.onDestroy();
    }
    if (paramToolbar != null)
    {
      paramToolbar = new g(paramToolbar, ((Activity)this.Ox).getTitle(), this.Oy);
      this.mActionBar = paramToolbar;
      this.Na.setCallback(paramToolbar.Qa);
    }
    for (;;)
    {
      invalidateOptionsMenu();
      return;
      this.mActionBar = null;
      this.Na.setCallback(this.Oy);
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.Cv = paramCharSequence;
    if (this.OA != null) {
      this.OA.setWindowTitle(paramCharSequence);
    }
    do
    {
      return;
      if (this.mActionBar != null)
      {
        this.mActionBar.setWindowTitle(paramCharSequence);
        return;
      }
    } while (this.Nx == null);
    this.Nx.setText(paramCharSequence);
  }
  
  public final b startSupportActionMode(b.a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (this.OD != null) {
      this.OD.finish();
    }
    parama = new c(parama);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      this.OD = localActionBar.a(parama);
      if ((this.OD != null) && (this.Oz != null)) {
        this.Oz.onSupportActionModeStarted(this.OD);
      }
    }
    if (this.OD == null) {
      this.OD = b(parama);
    }
    return this.OD;
  }
  
  protected static final class PanelFeatureState
  {
    boolean LB;
    boolean PA;
    public boolean PB;
    boolean PC;
    boolean PD;
    Bundle PE;
    int Ps;
    ViewGroup Pt;
    View Pu;
    View Pv;
    h Pw;
    android.support.v7.view.menu.f Px;
    Context Py;
    boolean Pz;
    int background;
    int gravity;
    int windowAnimations;
    int x;
    int y;
    
    PanelFeatureState(int paramInt)
    {
      this.Ps = paramInt;
      this.PC = false;
    }
    
    final void U(Context paramContext)
    {
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(2130772138, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      localTheme.resolveAttribute(2130772204, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      for (;;)
      {
        paramContext = new android.support.v7.view.d(paramContext, 0);
        paramContext.getTheme().setTo(localTheme);
        this.Py = paramContext;
        paramContext = paramContext.obtainStyledAttributes(android.support.v7.a.a.a.AppCompatTheme);
        this.background = paramContext.getResourceId(81, 0);
        this.windowAnimations = paramContext.getResourceId(1, 0);
        paramContext.recycle();
        return;
        localTheme.applyStyle(2131493664, true);
      }
    }
    
    final android.support.v7.view.menu.p b(o.a parama)
    {
      if (this.Pw == null) {
        return null;
      }
      if (this.Px == null)
      {
        this.Px = new android.support.v7.view.menu.f(this.Py);
        this.Px.eN = parama;
        this.Pw.a(this.Px);
      }
      return this.Px.e(this.Pt);
    }
    
    final void e(h paramh)
    {
      if (paramh == this.Pw) {}
      do
      {
        return;
        if (this.Pw != null) {
          this.Pw.b(this.Px);
        }
        this.Pw = paramh;
      } while ((paramh == null) || (this.Px == null));
      paramh.a(this.Px);
    }
    
    public final boolean eR()
    {
      if (this.Pu == null) {}
      do
      {
        return false;
        if (this.Pv != null) {
          return true;
        }
      } while (this.Px.getAdapter().getCount() <= 0);
      return true;
    }
    
    static class SavedState
      implements Parcelable
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
      boolean LB;
      int Ps;
      Bundle kl;
      
      static SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        boolean bool = true;
        SavedState localSavedState = new SavedState();
        localSavedState.Ps = paramParcel.readInt();
        if (paramParcel.readInt() == 1) {}
        for (;;)
        {
          localSavedState.LB = bool;
          if (localSavedState.LB) {
            localSavedState.kl = paramParcel.readBundle(paramClassLoader);
          }
          return localSavedState;
          bool = false;
        }
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.Ps);
        if (this.LB) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeInt(paramInt);
          if (this.LB) {
            paramParcel.writeBundle(this.kl);
          }
          return;
        }
      }
    }
  }
  
  final class a
    implements a.a
  {
    a() {}
    
    public final void aN(int paramInt)
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
      Window.Callback localCallback = AppCompatDelegateImpl.this.Na.getCallback();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramh);
      }
      return true;
    }
  }
  
  final class c
    implements b.a
  {
    private b.a Pl;
    
    public c(b.a parama)
    {
      this.Pl = parama;
    }
    
    public final void a(b paramb)
    {
      this.Pl.a(paramb);
      if (AppCompatDelegateImpl.this.OF != null) {
        AppCompatDelegateImpl.this.Na.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.OG);
      }
      if (AppCompatDelegateImpl.this.OE != null)
      {
        AppCompatDelegateImpl.this.eK();
        AppCompatDelegateImpl.this.OH = android.support.v4.view.t.ab(AppCompatDelegateImpl.this.OE).s(0.0F);
        AppCompatDelegateImpl.this.OH.a(new z()
        {
          public final void aC(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.OE.setVisibility(8);
            if (AppCompatDelegateImpl.this.OF != null) {
              AppCompatDelegateImpl.this.OF.dismiss();
            }
            for (;;)
            {
              AppCompatDelegateImpl.this.OE.removeAllViews();
              AppCompatDelegateImpl.this.OH.a(null);
              AppCompatDelegateImpl.this.OH = null;
              return;
              if ((AppCompatDelegateImpl.this.OE.getParent() instanceof View)) {
                android.support.v4.view.t.ak((View)AppCompatDelegateImpl.this.OE.getParent());
              }
            }
          }
        });
      }
      if (AppCompatDelegateImpl.this.Oz != null) {
        AppCompatDelegateImpl.this.Oz.onSupportActionModeFinished(AppCompatDelegateImpl.this.OD);
      }
      AppCompatDelegateImpl.this.OD = null;
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      return this.Pl.a(paramb, paramMenu);
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.Pl.a(paramb, paramMenuItem);
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      return this.Pl.b(paramb, paramMenu);
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
          paramMenu.M(true);
        }
      }
      return true;
    }
    
    public final void onPanelClosed(int paramInt, Menu paramMenu)
    {
      super.onPanelClosed(paramInt, paramMenu);
      AppCompatDelegateImpl.this.aO(paramInt);
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
          localh.WG = true;
        }
        bool2 = super.onPreparePanel(paramInt, paramView, paramMenu);
        bool1 = bool2;
      } while (localh == null);
      localh.WG = false;
      return bool2;
    }
    
    public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
    {
      AppCompatDelegateImpl.PanelFeatureState localPanelFeatureState = AppCompatDelegateImpl.this.aP(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.Pw != null))
      {
        super.onProvideKeyboardShortcuts(paramList, localPanelFeatureState.Pw, paramInt);
        return;
      }
      super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return null;
      }
      if (AppCompatDelegateImpl.this.OI) {
        return a(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if (AppCompatDelegateImpl.this.OI) {}
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
    i Pn;
    boolean Po;
    private BroadcastReceiver Pp;
    private IntentFilter Pq;
    
    e(i parami)
    {
      this.Pn = parami;
      this.Po = parami.eU();
    }
    
    final void cleanup()
    {
      if (this.Pp != null)
      {
        AppCompatDelegateImpl.this.mContext.unregisterReceiver(this.Pp);
        this.Pp = null;
      }
    }
    
    final int eQ()
    {
      this.Po = this.Pn.eU();
      if (this.Po) {
        return 2;
      }
      return 1;
    }
    
    final void setup()
    {
      cleanup();
      if (this.Pp == null) {
        this.Pp = new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            paramAnonymousContext = AppCompatDelegateImpl.e.this;
            boolean bool = paramAnonymousContext.Pn.eU();
            if (bool != paramAnonymousContext.Po)
            {
              paramAnonymousContext.Po = bool;
              paramAnonymousContext.Pj.eD();
            }
          }
        };
      }
      if (this.Pq == null)
      {
        this.Pq = new IntentFilter();
        this.Pq.addAction("android.intent.action.TIME_SET");
        this.Pq.addAction("android.intent.action.TIMEZONE_CHANGED");
        this.Pq.addAction("android.intent.action.TIME_TICK");
      }
      AppCompatDelegateImpl.this.mContext.registerReceiver(this.Pp, this.Pq);
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
          AppCompatDelegateImpl.this.eL();
          return true;
        }
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public final void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(a.k(getContext(), paramInt));
    }
  }
  
  final class g
    implements o.a
  {
    g() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      h localh = paramh.gf();
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
          AppCompatDelegateImpl.this.a(paramh.Ps, paramh, localh);
          AppCompatDelegateImpl.this.a(paramh, true);
        }
        return;
      }
      AppCompatDelegateImpl.this.a(paramh, paramBoolean);
    }
    
    public final boolean d(h paramh)
    {
      if ((paramh == null) && (AppCompatDelegateImpl.this.OQ))
      {
        Window.Callback localCallback = AppCompatDelegateImpl.this.Na.getCallback();
        if ((localCallback != null) && (!AppCompatDelegateImpl.this.OZ)) {
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