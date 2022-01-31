package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import android.support.v4.view.m;
import android.support.v4.view.q;
import android.support.v4.view.u;
import android.support.v4.view.w;
import android.support.v4.view.y;
import android.support.v7.a.a.a;
import android.support.v7.a.a.c;
import android.support.v7.a.a.f;
import android.support.v7.a.a.g;
import android.support.v7.a.a.i;
import android.support.v7.a.a.j;
import android.support.v7.view.b.a;
import android.support.v7.view.d;
import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.view.menu.f.a;
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
import android.support.v7.widget.ab;
import android.support.v7.widget.ab.a;
import android.support.v7.widget.au;
import android.support.v7.widget.bc;
import android.support.v7.widget.bf;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
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
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDelegateImplV9
  extends e
  implements h.a, LayoutInflater.Factory2
{
  private static final boolean Pl;
  private TextView NI;
  private PanelFeatureState[] PA;
  private PanelFeatureState PB;
  private boolean PC;
  boolean PD;
  int PE;
  private final Runnable PF = new Runnable()
  {
    public final void run()
    {
      if ((AppCompatDelegateImplV9.this.PE & 0x1) != 0) {
        AppCompatDelegateImplV9.this.aW(0);
      }
      if ((AppCompatDelegateImplV9.this.PE & 0x1000) != 0) {
        AppCompatDelegateImplV9.this.aW(108);
      }
      AppCompatDelegateImplV9.this.PD = false;
      AppCompatDelegateImplV9.this.PE = 0;
    }
  };
  private boolean PG;
  private j PH;
  private android.support.v7.widget.v Pm;
  private a Pn;
  private d Po;
  android.support.v7.view.b Pp;
  ActionBarContextView Pq;
  PopupWindow Pr;
  Runnable Ps;
  u Pt = null;
  private boolean Pu;
  private ViewGroup Pv;
  private View Pw;
  private boolean Px;
  private boolean Py;
  private boolean Pz;
  private Rect jf;
  private Rect jg;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      Pl = bool;
      return;
    }
  }
  
  AppCompatDelegateImplV9(Context paramContext, Window paramWindow, c paramc)
  {
    super(paramContext, paramWindow, paramc);
  }
  
  private View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    int j = 1;
    Object localObject;
    boolean bool1;
    if (this.PH == null)
    {
      localObject = this.mContext.obtainStyledAttributes(a.j.AppCompatTheme).getString(a.j.AppCompatTheme_viewInflaterClass);
      if ((localObject == null) || (j.class.getName().equals(localObject))) {
        this.PH = new j();
      }
    }
    else
    {
      if (!Pl) {
        break label1017;
      }
      if (!(paramAttributeSet instanceof XmlPullParser)) {
        break label535;
      }
      if (((XmlPullParser)paramAttributeSet).getDepth() <= 1) {
        break label529;
      }
      bool1 = true;
    }
    for (;;)
    {
      label88:
      j localj = this.PH;
      boolean bool2 = Pl;
      boolean bool3 = bc.je();
      if ((bool1) && (paramView != null)) {}
      for (paramView = paramView.getContext();; paramView = paramContext)
      {
        localObject = paramView.obtainStyledAttributes(paramAttributeSet, a.j.View, 0, 0);
        if (bool2) {}
        for (int i = ((TypedArray)localObject).getResourceId(a.j.View_android_theme, 0);; i = 0)
        {
          if (i == 0) {
            i = ((TypedArray)localObject).getResourceId(a.j.View_theme, 0);
          }
          for (;;)
          {
            ((TypedArray)localObject).recycle();
            if ((i != 0) && ((!(paramView instanceof d)) || (((d)paramView).ST != i))) {
              paramView = new d(paramView, i);
            }
            for (;;)
            {
              localObject = paramView;
              if (bool3) {
                localObject = au.V(paramView);
              }
              switch (paramString.hashCode())
              {
              default: 
                label336:
                i = -1;
                switch (i)
                {
                default: 
                  label339:
                  paramView = null;
                  label410:
                  if ((paramView == null) && (paramContext != localObject)) {
                    paramView = localj.a((Context)localObject, paramString, paramAttributeSet);
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
                    if (((paramString instanceof ContextWrapper)) && ((Build.VERSION.SDK_INT < 15) || (q.ap(paramView)))) {
                      break label958;
                    }
                  }
                  return paramView;
                  try
                  {
                    this.PH = ((j)Class.forName((String)localObject).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                  }
                  catch (Throwable localThrowable)
                  {
                    new StringBuilder("Failed to instantiate custom view inflater ").append((String)localObject).append(". Falling back to default.");
                    this.PH = new j();
                  }
                }
                break;
                label529:
                bool1 = false;
                break label88;
                label535:
                bool1 = a((ViewParent)paramView);
                break label88;
                if (!paramString.equals("TextView")) {
                  break label336;
                }
                i = 0;
                break label339;
                if (!paramString.equals("ImageView")) {
                  break label336;
                }
                i = j;
                break label339;
                if (!paramString.equals("Button")) {
                  break label336;
                }
                i = 2;
                break label339;
                if (!paramString.equals("EditText")) {
                  break label336;
                }
                i = 3;
                break label339;
                if (!paramString.equals("Spinner")) {
                  break label336;
                }
                i = 4;
                break label339;
                if (!paramString.equals("ImageButton")) {
                  break label336;
                }
                i = 5;
                break label339;
                if (!paramString.equals("CheckBox")) {
                  break label336;
                }
                i = 6;
                break label339;
                if (!paramString.equals("RadioButton")) {
                  break label336;
                }
                i = 7;
                break label339;
                if (!paramString.equals("CheckedTextView")) {
                  break label336;
                }
                i = 8;
                break label339;
                if (!paramString.equals("AutoCompleteTextView")) {
                  break label336;
                }
                i = 9;
                break label339;
                if (!paramString.equals("MultiAutoCompleteTextView")) {
                  break label336;
                }
                i = 10;
                break label339;
                if (!paramString.equals("RatingBar")) {
                  break label336;
                }
                i = 11;
                break label339;
                if (!paramString.equals("SeekBar")) {
                  break label336;
                }
                i = 12;
                break label339;
                paramView = new AppCompatTextView((Context)localObject, paramAttributeSet);
                break label410;
                paramView = new AppCompatImageView((Context)localObject, paramAttributeSet);
                break label410;
                paramView = new AppCompatButton((Context)localObject, paramAttributeSet);
                break label410;
                paramView = new AppCompatEditText((Context)localObject, paramAttributeSet);
                break label410;
                paramView = new AppCompatSpinner((Context)localObject, paramAttributeSet);
                break label410;
                paramView = new AppCompatImageButton((Context)localObject, paramAttributeSet);
                break label410;
                paramView = new AppCompatCheckBox((Context)localObject, paramAttributeSet);
                break label410;
                paramView = new AppCompatRadioButton((Context)localObject, paramAttributeSet);
                break label410;
                paramView = new AppCompatCheckedTextView((Context)localObject, paramAttributeSet);
                break label410;
                paramView = new AppCompatAutoCompleteTextView((Context)localObject, paramAttributeSet);
                break label410;
                paramView = new AppCompatMultiAutoCompleteTextView((Context)localObject, paramAttributeSet);
                break label410;
                paramView = new AppCompatRatingBar((Context)localObject, paramAttributeSet);
                break label410;
                paramView = new AppCompatSeekBar((Context)localObject, paramAttributeSet);
                break label410;
                label958:
                paramString = paramString.obtainStyledAttributes(paramAttributeSet, j.Qa);
                paramContext = paramString.getString(0);
                if (paramContext != null) {
                  paramView.setOnClickListener(new j.a(paramView, paramContext));
                }
                paramString.recycle();
                return paramView;
              }
            }
          }
        }
      }
      label1017:
      bool1 = false;
    }
  }
  
  private void a(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    int j = -1;
    if ((paramPanelFeatureState.LQ) || (this.OV)) {}
    int i;
    Object localObject1;
    label90:
    label95:
    Object localObject2;
    label236:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramPanelFeatureState.PM == 0) {
            if ((this.mContext.getResources().getConfiguration().screenLayout & 0xF) != 4) {
              break label90;
            }
          }
          for (i = 1; i == 0; i = 0)
          {
            localObject1 = this.Nk.getCallback();
            if ((localObject1 == null) || (((Window.Callback)localObject1).onMenuOpened(paramPanelFeatureState.PM, paramPanelFeatureState.PQ))) {
              break label95;
            }
            a(paramPanelFeatureState, true);
            return;
          }
        }
        localObject1 = (WindowManager)this.mContext.getSystemService("window");
      } while ((localObject1 == null) || (!b(paramPanelFeatureState, paramKeyEvent)));
      if ((paramPanelFeatureState.PN != null) && (!paramPanelFeatureState.PW)) {
        break label796;
      }
      if (paramPanelFeatureState.PN != null) {
        break label551;
      }
      localObject2 = ek();
      TypedValue localTypedValue = new TypedValue();
      paramKeyEvent = ((Context)localObject2).getResources().newTheme();
      paramKeyEvent.setTo(((Context)localObject2).getTheme());
      paramKeyEvent.resolveAttribute(a.a.actionBarPopupTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        paramKeyEvent.applyStyle(localTypedValue.resourceId, true);
      }
      paramKeyEvent.resolveAttribute(a.a.panelMenuListTheme, localTypedValue, true);
      if (localTypedValue.resourceId == 0) {
        break;
      }
      paramKeyEvent.applyStyle(localTypedValue.resourceId, true);
      localObject2 = new d((Context)localObject2, 0);
      ((Context)localObject2).getTheme().setTo(paramKeyEvent);
      paramPanelFeatureState.PS = ((Context)localObject2);
      paramKeyEvent = ((Context)localObject2).obtainStyledAttributes(a.j.AppCompatTheme);
      paramPanelFeatureState.background = paramKeyEvent.getResourceId(a.j.AppCompatTheme_panelBackground, 0);
      paramPanelFeatureState.windowAnimations = paramKeyEvent.getResourceId(a.j.AppCompatTheme_android_windowAnimationStyle, 0);
      paramKeyEvent.recycle();
      paramPanelFeatureState.PN = new c(paramPanelFeatureState.PS);
      paramPanelFeatureState.gravity = 81;
    } while (paramPanelFeatureState.PN == null);
    label329:
    if (paramPanelFeatureState.PP != null)
    {
      paramPanelFeatureState.PO = paramPanelFeatureState.PP;
      i = 1;
      label346:
      if (i == 0) {
        break label769;
      }
      if (paramPanelFeatureState.PO == null) {
        break label791;
      }
      if (paramPanelFeatureState.PP == null) {
        break label771;
      }
      i = 1;
      label366:
      if (i == 0) {
        break label794;
      }
      paramKeyEvent = paramPanelFeatureState.PO.getLayoutParams();
      if (paramKeyEvent != null) {
        break label832;
      }
      paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
    }
    label551:
    label832:
    for (;;)
    {
      i = paramPanelFeatureState.background;
      paramPanelFeatureState.PN.setBackgroundResource(i);
      localObject2 = paramPanelFeatureState.PO.getParent();
      if ((localObject2 != null) && ((localObject2 instanceof ViewGroup))) {
        ((ViewGroup)localObject2).removeView(paramPanelFeatureState.PO);
      }
      paramPanelFeatureState.PN.addView(paramPanelFeatureState.PO, paramKeyEvent);
      if (!paramPanelFeatureState.PO.hasFocus()) {
        paramPanelFeatureState.PO.requestFocus();
      }
      i = -2;
      for (;;)
      {
        paramPanelFeatureState.PU = false;
        paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.x, paramPanelFeatureState.y, 1002, 8519680, -3);
        paramKeyEvent.gravity = paramPanelFeatureState.gravity;
        paramKeyEvent.windowAnimations = paramPanelFeatureState.windowAnimations;
        ((WindowManager)localObject1).addView(paramPanelFeatureState.PN, paramKeyEvent);
        paramPanelFeatureState.LQ = true;
        return;
        paramKeyEvent.applyStyle(a.i.Theme_AppCompat_CompactMenu, true);
        break label236;
        if ((!paramPanelFeatureState.PW) || (paramPanelFeatureState.PN.getChildCount() <= 0)) {
          break label329;
        }
        paramPanelFeatureState.PN.removeAllViews();
        break label329;
        if (paramPanelFeatureState.PQ != null)
        {
          if (this.Po == null) {
            this.Po = new d();
          }
          paramKeyEvent = this.Po;
          if (paramPanelFeatureState.PQ == null) {}
          for (paramKeyEvent = null;; paramKeyEvent = paramKeyEvent.Vm)
          {
            paramPanelFeatureState.PO = ((View)paramKeyEvent);
            if (paramPanelFeatureState.PO == null) {
              break label766;
            }
            i = 1;
            break;
            if (paramPanelFeatureState.PR == null)
            {
              paramPanelFeatureState.PR = new android.support.v7.view.menu.f(paramPanelFeatureState.PS, a.g.abc_list_menu_item_layout);
              paramPanelFeatureState.PR.dL = paramKeyEvent;
              paramPanelFeatureState.PQ.a(paramPanelFeatureState.PR);
            }
            paramKeyEvent = paramPanelFeatureState.PR;
            localObject2 = paramPanelFeatureState.PN;
            if (paramKeyEvent.Vm == null)
            {
              paramKeyEvent.Vm = ((ExpandedMenuView)paramKeyEvent.Lu.inflate(a.g.abc_expanded_menu_layout, (ViewGroup)localObject2, false));
              if (paramKeyEvent.Vp == null) {
                paramKeyEvent.Vp = new f.a(paramKeyEvent);
              }
              paramKeyEvent.Vm.setAdapter(paramKeyEvent.Vp);
              paramKeyEvent.Vm.setOnItemClickListener(paramKeyEvent);
            }
          }
        }
        label766:
        i = 0;
        break label346;
        break;
        if (paramPanelFeatureState.PR.getAdapter().getCount() > 0)
        {
          i = 1;
          break label366;
        }
        i = 0;
        break label366;
        break;
        if (paramPanelFeatureState.PP != null)
        {
          paramKeyEvent = paramPanelFeatureState.PP.getLayoutParams();
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
  
  private boolean a(PanelFeatureState paramPanelFeatureState, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.isSystem()) {}
    while (((!paramPanelFeatureState.PT) && (!b(paramPanelFeatureState, paramKeyEvent))) || (paramPanelFeatureState.PQ == null)) {
      return false;
    }
    return paramPanelFeatureState.PQ.performShortcut(paramInt, paramKeyEvent, 1);
  }
  
  private boolean a(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    View localView = this.Nk.getDecorView();
    for (;;)
    {
      if (paramViewParent == null) {
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View)) || (q.ao((View)paramViewParent))) {
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (this.OV) {
      return false;
    }
    if (paramPanelFeatureState.PT) {
      return true;
    }
    if ((this.PB != null) && (this.PB != paramPanelFeatureState)) {
      a(this.PB, false);
    }
    Window.Callback localCallback = this.Nk.getCallback();
    if (localCallback != null) {
      paramPanelFeatureState.PP = localCallback.onCreatePanelView(paramPanelFeatureState.PM);
    }
    int i;
    label89:
    Context localContext;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if ((paramPanelFeatureState.PM == 0) || (paramPanelFeatureState.PM == 108))
    {
      i = 1;
      if ((i != 0) && (this.Pm != null)) {
        this.Pm.fG();
      }
      if ((paramPanelFeatureState.PP != null) || ((i != 0) && ((this.mActionBar instanceof l)))) {
        break label624;
      }
      if ((paramPanelFeatureState.PQ != null) && (!paramPanelFeatureState.PX)) {
        break label494;
      }
      if (paramPanelFeatureState.PQ == null)
      {
        localContext = this.mContext;
        if (((paramPanelFeatureState.PM != 0) && (paramPanelFeatureState.PM != 108)) || (this.Pm == null)) {
          break label652;
        }
        localTypedValue = new TypedValue();
        localTheme = localContext.getTheme();
        localTheme.resolveAttribute(a.a.actionBarTheme, localTypedValue, true);
        if (localTypedValue.resourceId == 0) {
          break label471;
        }
        localObject1 = localContext.getResources().newTheme();
        ((Resources.Theme)localObject1).setTo(localTheme);
        ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
        ((Resources.Theme)localObject1).resolveAttribute(a.a.actionBarWidgetTheme, localTypedValue, true);
        label256:
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
          break label652;
        }
        localObject1 = new d(localContext, 0);
        ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new android.support.v7.view.menu.h((Context)localObject1);
      ((android.support.v7.view.menu.h)localObject1).a(this);
      paramPanelFeatureState.e((android.support.v7.view.menu.h)localObject1);
      if (paramPanelFeatureState.PQ == null) {
        break;
      }
      if ((i != 0) && (this.Pm != null))
      {
        if (this.Pn == null) {
          this.Pn = new a();
        }
        this.Pm.a(paramPanelFeatureState.PQ, this.Pn);
      }
      paramPanelFeatureState.PQ.fh();
      if (!localCallback.onCreatePanelMenu(paramPanelFeatureState.PM, paramPanelFeatureState.PQ))
      {
        paramPanelFeatureState.e(null);
        if ((i == 0) || (this.Pm == null)) {
          break;
        }
        this.Pm.a(null, this.Pn);
        return false;
        i = 0;
        break label89;
        label471:
        localTheme.resolveAttribute(a.a.actionBarWidgetTheme, localTypedValue, true);
        localObject1 = null;
        break label256;
      }
      paramPanelFeatureState.PX = false;
      label494:
      paramPanelFeatureState.PQ.fh();
      if (paramPanelFeatureState.PY != null)
      {
        paramPanelFeatureState.PQ.f(paramPanelFeatureState.PY);
        paramPanelFeatureState.PY = null;
      }
      if (!localCallback.onPreparePanel(0, paramPanelFeatureState.PP, paramPanelFeatureState.PQ))
      {
        if ((i != 0) && (this.Pm != null)) {
          this.Pm.a(null, this.Pn);
        }
        paramPanelFeatureState.PQ.fi();
        return false;
      }
      if (paramKeyEvent != null)
      {
        i = paramKeyEvent.getDeviceId();
        if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
          break label646;
        }
      }
      label646:
      for (boolean bool = true;; bool = false)
      {
        paramPanelFeatureState.PV = bool;
        paramPanelFeatureState.PQ.setQwertyMode(paramPanelFeatureState.PV);
        paramPanelFeatureState.PQ.fi();
        label624:
        paramPanelFeatureState.PT = true;
        paramPanelFeatureState.PU = false;
        this.PB = paramPanelFeatureState;
        return true;
        i = -1;
        break;
      }
      label652:
      localObject1 = localContext;
    }
  }
  
  private void en()
  {
    Object localObject1;
    if (!this.Pu)
    {
      localObject1 = this.mContext.obtainStyledAttributes(a.j.AppCompatTheme);
      if (!((TypedArray)localObject1).hasValue(a.j.AppCompatTheme_windowActionBar))
      {
        ((TypedArray)localObject1).recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
      }
      if (((TypedArray)localObject1).getBoolean(a.j.AppCompatTheme_windowNoTitle, false))
      {
        requestWindowFeature(1);
        if (((TypedArray)localObject1).getBoolean(a.j.AppCompatTheme_windowActionBarOverlay, false)) {
          requestWindowFeature(109);
        }
        if (((TypedArray)localObject1).getBoolean(a.j.AppCompatTheme_windowActionModeOverlay, false)) {
          requestWindowFeature(10);
        }
        this.OS = ((TypedArray)localObject1).getBoolean(a.j.AppCompatTheme_android_windowIsFloating, false);
        ((TypedArray)localObject1).recycle();
        this.Nk.getDecorView();
        localObject1 = LayoutInflater.from(this.mContext);
        if (this.OT) {
          break label459;
        }
        if (!this.OS) {
          break label288;
        }
        localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(a.g.abc_dialog_title_material, null);
        this.OQ = false;
        this.OP = false;
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.OP + ", windowActionBarOverlay: " + this.OQ + ", android:windowIsFloating: " + this.OS + ", windowActionModeOverlay: " + this.OR + ", windowNoTitle: " + this.OT + " }");
        if (!((TypedArray)localObject1).getBoolean(a.j.AppCompatTheme_windowActionBar, false)) {
          break;
        }
        requestWindowFeature(108);
        break;
        label288:
        if (!this.OP) {
          break label1002;
        }
        localObject1 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(a.a.actionBarTheme, (TypedValue)localObject1, true);
        if (((TypedValue)localObject1).resourceId != 0) {}
        for (localObject1 = new d(this.mContext, ((TypedValue)localObject1).resourceId);; localObject1 = this.mContext)
        {
          localObject1 = (ViewGroup)LayoutInflater.from((Context)localObject1).inflate(a.g.abc_screen_toolbar, null);
          this.Pm = ((android.support.v7.widget.v)((ViewGroup)localObject1).findViewById(a.f.decor_content_parent));
          this.Pm.setWindowCallback(this.Nk.getCallback());
          if (this.OQ) {
            this.Pm.be(109);
          }
          if (this.Px) {
            this.Pm.be(2);
          }
          if (this.Py) {
            this.Pm.be(5);
          }
          break;
        }
        label459:
        if (this.OR) {}
        for (localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(a.g.abc_screen_simple_overlay_action_mode, null);; localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(a.g.abc_screen_simple, null))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label521;
          }
          q.a((View)localObject1, new m()
          {
            public final y a(View paramAnonymousView, y paramAnonymousy)
            {
              int i = paramAnonymousy.getSystemWindowInsetTop();
              int j = AppCompatDelegateImplV9.this.aX(i);
              y localy = paramAnonymousy;
              if (i != j) {
                localy = paramAnonymousy.f(paramAnonymousy.getSystemWindowInsetLeft(), j, paramAnonymousy.getSystemWindowInsetRight(), paramAnonymousy.getSystemWindowInsetBottom());
              }
              return q.a(paramAnonymousView, localy);
            }
          });
          break;
        }
        label521:
        ((ab)localObject1).setOnFitSystemWindowsListener(new ab.a()
        {
          public final void f(Rect paramAnonymousRect)
          {
            paramAnonymousRect.top = AppCompatDelegateImplV9.this.aX(paramAnonymousRect.top);
          }
        });
        continue;
      }
      if (this.Pm == null) {
        this.NI = ((TextView)((ViewGroup)localObject1).findViewById(a.f.title));
      }
      bf.bG((View)localObject1);
      Object localObject2 = (ContentFrameLayout)((ViewGroup)localObject1).findViewById(a.f.action_bar_activity_content);
      ViewGroup localViewGroup = (ViewGroup)this.Nk.findViewById(16908290);
      if (localViewGroup != null)
      {
        while (localViewGroup.getChildCount() > 0)
        {
          View localView = localViewGroup.getChildAt(0);
          localViewGroup.removeViewAt(0);
          ((ContentFrameLayout)localObject2).addView(localView);
        }
        localViewGroup.setId(-1);
        ((ContentFrameLayout)localObject2).setId(16908290);
        if ((localViewGroup instanceof FrameLayout)) {
          ((FrameLayout)localViewGroup).setForeground(null);
        }
      }
      this.Nk.setContentView((View)localObject1);
      ((ContentFrameLayout)localObject2).setAttachListener(new ContentFrameLayout.a()
      {
        public final void onDetachedFromWindow()
        {
          AppCompatDelegateImplV9.this.es();
        }
      });
      this.Pv = ((ViewGroup)localObject1);
      if ((this.OL instanceof Activity)) {}
      for (localObject1 = ((Activity)this.OL).getTitle();; localObject1 = this.BM)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          i((CharSequence)localObject1);
        }
        localObject1 = (ContentFrameLayout)this.Pv.findViewById(16908290);
        localObject2 = this.Nk.getDecorView();
        int i = ((View)localObject2).getPaddingLeft();
        int j = ((View)localObject2).getPaddingTop();
        int k = ((View)localObject2).getPaddingRight();
        int m = ((View)localObject2).getPaddingBottom();
        ((ContentFrameLayout)localObject1).abs.set(i, j, k, m);
        if (q.al((View)localObject1)) {
          ((ContentFrameLayout)localObject1).requestLayout();
        }
        localObject2 = this.mContext.obtainStyledAttributes(a.j.AppCompatTheme);
        ((TypedArray)localObject2).getValue(a.j.AppCompatTheme_windowMinWidthMajor, ((ContentFrameLayout)localObject1).getMinWidthMajor());
        ((TypedArray)localObject2).getValue(a.j.AppCompatTheme_windowMinWidthMinor, ((ContentFrameLayout)localObject1).getMinWidthMinor());
        if (((TypedArray)localObject2).hasValue(a.j.AppCompatTheme_windowFixedWidthMajor)) {
          ((TypedArray)localObject2).getValue(a.j.AppCompatTheme_windowFixedWidthMajor, ((ContentFrameLayout)localObject1).getFixedWidthMajor());
        }
        if (((TypedArray)localObject2).hasValue(a.j.AppCompatTheme_windowFixedWidthMinor)) {
          ((TypedArray)localObject2).getValue(a.j.AppCompatTheme_windowFixedWidthMinor, ((ContentFrameLayout)localObject1).getFixedWidthMinor());
        }
        if (((TypedArray)localObject2).hasValue(a.j.AppCompatTheme_windowFixedHeightMajor)) {
          ((TypedArray)localObject2).getValue(a.j.AppCompatTheme_windowFixedHeightMajor, ((ContentFrameLayout)localObject1).getFixedHeightMajor());
        }
        if (((TypedArray)localObject2).hasValue(a.j.AppCompatTheme_windowFixedHeightMinor)) {
          ((TypedArray)localObject2).getValue(a.j.AppCompatTheme_windowFixedHeightMinor, ((ContentFrameLayout)localObject1).getFixedHeightMinor());
        }
        ((TypedArray)localObject2).recycle();
        ((ContentFrameLayout)localObject1).requestLayout();
        this.Pu = true;
        localObject1 = aV(0);
        if ((!this.OV) && ((localObject1 == null) || (((PanelFeatureState)localObject1).PQ == null))) {
          invalidatePanelMenu(108);
        }
        return;
      }
      label1002:
      localObject1 = null;
    }
  }
  
  private void er()
  {
    if (this.Pu) {
      throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }
  }
  
  private void invalidatePanelMenu(int paramInt)
  {
    this.PE |= 1 << paramInt;
    if (!this.PD)
    {
      q.b(this.Nk.getDecorView(), this.PF);
      this.PD = true;
    }
  }
  
  final PanelFeatureState a(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.PA;
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
      if ((localPanelFeatureState != null) && (localPanelFeatureState.PQ == paramMenu))
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
  
  View a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if ((this.OL instanceof LayoutInflater.Factory))
    {
      paramString = ((LayoutInflater.Factory)this.OL).onCreateView(paramString, paramContext, paramAttributeSet);
      if (paramString != null) {
        return paramString;
      }
    }
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
          if (paramInt < this.PA.length) {
            localPanelFeatureState = this.PA[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.PQ;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((PanelFeatureState)localObject1).LQ)) {}
    while (this.OV) {
      return;
    }
    this.OL.onPanelClosed(paramInt, (Menu)localObject2);
  }
  
  final void a(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.PM == 0) && (this.Pm != null) && (this.Pm.isOverflowMenuShowing())) {
      c(paramPanelFeatureState.PQ);
    }
    do
    {
      return;
      WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
      if ((localWindowManager != null) && (paramPanelFeatureState.LQ) && (paramPanelFeatureState.PN != null))
      {
        localWindowManager.removeView(paramPanelFeatureState.PN);
        if (paramBoolean) {
          a(paramPanelFeatureState.PM, paramPanelFeatureState, null);
        }
      }
      paramPanelFeatureState.PT = false;
      paramPanelFeatureState.PU = false;
      paramPanelFeatureState.LQ = false;
      paramPanelFeatureState.PO = null;
      paramPanelFeatureState.PW = true;
    } while (this.PB != paramPanelFeatureState);
    this.PB = null;
  }
  
  public final boolean a(android.support.v7.view.menu.h paramh, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = this.Nk.getCallback();
    if ((localCallback != null) && (!this.OV))
    {
      paramh = a(paramh.fo());
      if (paramh != null) {
        return localCallback.onMenuItemSelected(paramh.PM, paramMenuItem);
      }
    }
    return false;
  }
  
  final void aS(int paramInt)
  {
    Object localObject;
    if (paramInt == 108)
    {
      localObject = getSupportActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).N(false);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      localObject = aV(paramInt);
    } while (!((PanelFeatureState)localObject).LQ);
    a((PanelFeatureState)localObject, false);
  }
  
  final boolean aT(int paramInt)
  {
    if (paramInt == 108)
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.N(true);
      }
      return true;
    }
    return false;
  }
  
  protected final PanelFeatureState aV(int paramInt)
  {
    Object localObject2 = this.PA;
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
      this.PA = ((PanelFeatureState[])localObject1);
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
  
  final void aW(int paramInt)
  {
    PanelFeatureState localPanelFeatureState = aV(paramInt);
    if (localPanelFeatureState.PQ != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState.PQ.e(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState.PY = localBundle;
      }
      localPanelFeatureState.PQ.fh();
      localPanelFeatureState.PQ.clear();
    }
    localPanelFeatureState.PX = true;
    localPanelFeatureState.PW = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.Pm != null))
    {
      localPanelFeatureState = aV(0);
      if (localPanelFeatureState != null)
      {
        localPanelFeatureState.PT = false;
        b(localPanelFeatureState, null);
      }
    }
  }
  
  final int aX(int paramInt)
  {
    int j = 1;
    int m = 0;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.Pq != null) && ((this.Pq.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.Pq.getLayoutParams();
      if (this.Pq.isShown())
      {
        if (this.jf == null)
        {
          this.jf = new Rect();
          this.jg = new Rect();
        }
        localObject2 = this.jf;
        Rect localRect = this.jg;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        bf.a(this.Pv, (Rect)localObject2, localRect);
        if (localRect.top == 0)
        {
          i = paramInt;
          if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == i) {
            break label351;
          }
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
          if (this.Pw != null) {
            break label274;
          }
          this.Pw = new View(this.mContext);
          this.Pw.setBackgroundColor(this.mContext.getResources().getColor(a.c.abc_input_method_navigation_guard));
          this.Pv.addView(this.Pw, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i = 1;
          label198:
          if (this.Pw == null) {
            break label312;
          }
          label205:
          int k = paramInt;
          if (!this.OR)
          {
            k = paramInt;
            if (j != 0) {
              k = 0;
            }
          }
          paramInt = k;
          label228:
          if (i != 0) {
            this.Pq.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.Pw != null)
      {
        localObject1 = this.Pw;
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
        localObject2 = this.Pw.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
        {
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          this.Pw.setLayoutParams((ViewGroup.LayoutParams)localObject2);
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
    en();
    ((ViewGroup)this.Pv.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.OL.onContentChanged();
  }
  
  final android.support.v7.view.b b(b.a parama)
  {
    ep();
    if (this.Pp != null) {
      this.Pp.finish();
    }
    if ((this.OO != null) && (!this.OV)) {}
    for (;;)
    {
      try
      {
        android.support.v7.view.b localb = this.OO.onWindowStartingSupportActionMode(parama);
        if (localb == null) {
          break label95;
        }
        this.Pp = localb;
        if ((this.Pp != null) && (this.OO != null)) {
          this.OO.onSupportActionModeStarted(this.Pp);
        }
        return this.Pp;
      }
      catch (AbstractMethodError localAbstractMethodError) {}
      Object localObject1 = null;
      continue;
      label95:
      Object localObject2;
      label201:
      boolean bool;
      if (this.Pq == null)
      {
        if (!this.OS) {
          break label492;
        }
        localObject2 = new TypedValue();
        localObject1 = this.mContext.getTheme();
        ((Resources.Theme)localObject1).resolveAttribute(a.a.actionBarTheme, (TypedValue)localObject2, true);
        if (((TypedValue)localObject2).resourceId != 0)
        {
          Resources.Theme localTheme = this.mContext.getResources().newTheme();
          localTheme.setTo((Resources.Theme)localObject1);
          localTheme.applyStyle(((TypedValue)localObject2).resourceId, true);
          localObject1 = new d(this.mContext, 0);
          ((Context)localObject1).getTheme().setTo(localTheme);
          this.Pq = new ActionBarContextView((Context)localObject1);
          this.Pr = new PopupWindow((Context)localObject1, null, a.a.actionModePopupWindowStyle);
          android.support.v4.widget.l.a(this.Pr, 2);
          this.Pr.setContentView(this.Pq);
          this.Pr.setWidth(-1);
          ((Context)localObject1).getTheme().resolveAttribute(a.a.actionBarSize, (TypedValue)localObject2, true);
          int i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, ((Context)localObject1).getResources().getDisplayMetrics());
          this.Pq.setContentHeight(i);
          this.Pr.setHeight(-2);
          this.Ps = new Runnable()
          {
            public final void run()
            {
              AppCompatDelegateImplV9.this.Pr.showAtLocation(AppCompatDelegateImplV9.this.Pq, 55, 0, 0);
              AppCompatDelegateImplV9.this.ep();
              if (AppCompatDelegateImplV9.this.eo())
              {
                AppCompatDelegateImplV9.this.Pq.setAlpha(0.0F);
                AppCompatDelegateImplV9.this.Pt = q.Y(AppCompatDelegateImplV9.this.Pq).s(1.0F);
                AppCompatDelegateImplV9.this.Pt.a(new w()
                {
                  public final void au(View paramAnonymous2View)
                  {
                    AppCompatDelegateImplV9.this.Pq.setVisibility(0);
                  }
                  
                  public final void av(View paramAnonymous2View)
                  {
                    AppCompatDelegateImplV9.this.Pq.setAlpha(1.0F);
                    AppCompatDelegateImplV9.this.Pt.a(null);
                    AppCompatDelegateImplV9.this.Pt = null;
                  }
                });
                return;
              }
              AppCompatDelegateImplV9.this.Pq.setAlpha(1.0F);
              AppCompatDelegateImplV9.this.Pq.setVisibility(0);
            }
          };
        }
      }
      else
      {
        label319:
        if (this.Pq == null) {
          break label537;
        }
        ep();
        this.Pq.fB();
        localObject1 = this.Pq.getContext();
        localObject2 = this.Pq;
        if (this.Pr != null) {
          break label539;
        }
        bool = true;
        label361:
        localObject1 = new android.support.v7.view.e((Context)localObject1, (ActionBarContextView)localObject2, parama, bool);
        if (!parama.a((android.support.v7.view.b)localObject1, ((android.support.v7.view.b)localObject1).getMenu())) {
          break label598;
        }
        ((android.support.v7.view.b)localObject1).invalidate();
        this.Pq.c((android.support.v7.view.b)localObject1);
        this.Pp = ((android.support.v7.view.b)localObject1);
        if (!eo()) {
          break label544;
        }
        this.Pq.setAlpha(0.0F);
        this.Pt = q.Y(this.Pq).s(1.0F);
        this.Pt.a(new w()
        {
          public final void au(View paramAnonymousView)
          {
            AppCompatDelegateImplV9.this.Pq.setVisibility(0);
            AppCompatDelegateImplV9.this.Pq.sendAccessibilityEvent(32);
            if ((AppCompatDelegateImplV9.this.Pq.getParent() instanceof View)) {
              q.ad((View)AppCompatDelegateImplV9.this.Pq.getParent());
            }
          }
          
          public final void av(View paramAnonymousView)
          {
            AppCompatDelegateImplV9.this.Pq.setAlpha(1.0F);
            AppCompatDelegateImplV9.this.Pt.a(null);
            AppCompatDelegateImplV9.this.Pt = null;
          }
        });
      }
      for (;;)
      {
        if (this.Pr == null) {
          break label596;
        }
        this.Nk.getDecorView().post(this.Ps);
        break;
        localObject1 = this.mContext;
        break label201;
        label492:
        localObject1 = (ViewStubCompat)this.Pv.findViewById(a.f.action_mode_bar_stub);
        if (localObject1 == null) {
          break label319;
        }
        ((ViewStubCompat)localObject1).setLayoutInflater(LayoutInflater.from(ek()));
        this.Pq = ((ActionBarContextView)((ViewStubCompat)localObject1).inflate());
        break label319;
        label537:
        break;
        label539:
        bool = false;
        break label361;
        label544:
        this.Pq.setAlpha(1.0F);
        this.Pq.setVisibility(0);
        this.Pq.sendAccessibilityEvent(32);
        if ((this.Pq.getParent() instanceof View)) {
          q.ad((View)this.Pq.getParent());
        }
      }
      label596:
      continue;
      label598:
      this.Pp = null;
    }
  }
  
  public final void b(android.support.v7.view.menu.h paramh)
  {
    if ((this.Pm != null) && (this.Pm.fE()) && ((!ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) || (this.Pm.fF())))
    {
      paramh = this.Nk.getCallback();
      if (!this.Pm.isOverflowMenuShowing()) {
        if ((paramh != null) && (!this.OV))
        {
          if ((this.PD) && ((this.PE & 0x1) != 0))
          {
            this.Nk.getDecorView().removeCallbacks(this.PF);
            this.PF.run();
          }
          PanelFeatureState localPanelFeatureState = aV(0);
          if ((localPanelFeatureState.PQ != null) && (!localPanelFeatureState.PX) && (paramh.onPreparePanel(0, localPanelFeatureState.PP, localPanelFeatureState.PQ)))
          {
            paramh.onMenuOpened(108, localPanelFeatureState.PQ);
            this.Pm.showOverflowMenu();
          }
        }
      }
      do
      {
        return;
        this.Pm.hideOverflowMenu();
      } while (this.OV);
      paramh.onPanelClosed(108, aV(0).PQ);
      return;
    }
    paramh = aV(0);
    paramh.PW = true;
    a(paramh, false);
    a(paramh, null);
  }
  
  final void c(android.support.v7.view.menu.h paramh)
  {
    if (this.Pz) {
      return;
    }
    this.Pz = true;
    this.Pm.es();
    Window.Callback localCallback = this.Nk.getCallback();
    if ((localCallback != null) && (!this.OV)) {
      localCallback.onPanelClosed(108, paramh);
    }
    this.Pz = false;
  }
  
  final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 82) && (this.OL.dispatchKeyEvent(paramKeyEvent))) {}
    int i;
    label164:
    do
    {
      int j;
      do
      {
        do
        {
          return true;
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
        localPanelFeatureState = aV(0);
      } while (localPanelFeatureState.LQ);
      b(localPanelFeatureState, paramKeyEvent);
      return true;
      if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
      for (bool = true;; bool = false)
      {
        this.PC = bool;
        break;
      }
      switch (j)
      {
      default: 
        return false;
      }
    } while (this.Pp != null);
    PanelFeatureState localPanelFeatureState = aV(0);
    if ((this.Pm != null) && (this.Pm.fE()) && (!ViewConfiguration.get(this.mContext).hasPermanentMenuKey())) {
      if (!this.Pm.isOverflowMenuShowing())
      {
        if ((this.OV) || (!b(localPanelFeatureState, paramKeyEvent))) {
          break label467;
        }
        bool = this.Pm.showOverflowMenu();
      }
    }
    label252:
    while (bool)
    {
      paramKeyEvent = (AudioManager)this.mContext.getSystemService("audio");
      if (paramKeyEvent == null) {
        break;
      }
      paramKeyEvent.playSoundEffect(0);
      return true;
      bool = this.Pm.hideOverflowMenu();
      continue;
      if ((!localPanelFeatureState.LQ) && (!localPanelFeatureState.PU)) {
        break label329;
      }
      bool = localPanelFeatureState.LQ;
      a(localPanelFeatureState, true);
    }
    label329:
    if (localPanelFeatureState.PT)
    {
      if (!localPanelFeatureState.PX) {
        break label473;
      }
      localPanelFeatureState.PT = false;
    }
    label467:
    label473:
    for (boolean bool = b(localPanelFeatureState, paramKeyEvent);; bool = true)
    {
      if (bool)
      {
        a(localPanelFeatureState, paramKeyEvent);
        bool = true;
        break label252;
        bool = this.PC;
        this.PC = false;
        paramKeyEvent = aV(0);
        if ((paramKeyEvent != null) && (paramKeyEvent.LQ))
        {
          if (bool) {
            break;
          }
          a(paramKeyEvent, true);
          return true;
        }
        if (this.Pp != null)
        {
          this.Pp.finish();
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
        break label164;
      }
      bool = false;
      break label252;
    }
  }
  
  public final void ef()
  {
    en();
  }
  
  public final void eg()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    if (localLayoutInflater.getFactory() == null)
    {
      android.support.v4.view.e.b(localLayoutInflater, this);
      return;
    }
    localLayoutInflater.getFactory2();
  }
  
  public final void ej()
  {
    en();
    if ((!this.OP) || (this.mActionBar != null)) {}
    for (;;)
    {
      return;
      if ((this.OL instanceof Activity)) {
        this.mActionBar = new o((Activity)this.OL, this.OQ);
      }
      while (this.mActionBar != null)
      {
        this.mActionBar.L(this.PG);
        return;
        if ((this.OL instanceof Dialog)) {
          this.mActionBar = new o((Dialog)this.OL);
        }
      }
    }
  }
  
  final boolean eo()
  {
    return (this.Pu) && (this.Pv != null) && (q.al(this.Pv));
  }
  
  final void ep()
  {
    if (this.Pt != null) {
      this.Pt.cancel();
    }
  }
  
  final void eq()
  {
    a(aV(0), true);
  }
  
  final void es()
  {
    if (this.Pm != null) {
      this.Pm.es();
    }
    if (this.Pr != null)
    {
      this.Nk.getDecorView().removeCallbacks(this.Ps);
      if (!this.Pr.isShowing()) {}
    }
    try
    {
      this.Pr.dismiss();
      label55:
      this.Pr = null;
      ep();
      PanelFeatureState localPanelFeatureState = aV(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.PQ != null)) {
        localPanelFeatureState.PQ.close();
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
    en();
    return this.Nk.findViewById(paramInt);
  }
  
  final void i(CharSequence paramCharSequence)
  {
    if (this.Pm != null) {
      this.Pm.setWindowTitle(paramCharSequence);
    }
    do
    {
      return;
      if (this.mActionBar != null)
      {
        this.mActionBar.setWindowTitle(paramCharSequence);
        return;
      }
    } while (this.NI == null);
    this.NI.setText(paramCharSequence);
  }
  
  public final void invalidateOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar != null) && (localActionBar.ed())) {
      return;
    }
    invalidatePanelMenu(0);
  }
  
  public final void onConfigurationChanged(Configuration arg1)
  {
    if ((this.OP) && (this.Pu))
    {
      localObject1 = getSupportActionBar();
      if (localObject1 != null) {
        ((ActionBar)localObject1).onConfigurationChanged(???);
      }
    }
    Object localObject1 = android.support.v7.widget.h.gi();
    Context localContext = this.mContext;
    synchronized (((android.support.v7.widget.h)localObject1).ZO)
    {
      localObject1 = (android.support.v4.f.f)((android.support.v7.widget.h)localObject1).ZP.get(localContext);
      if (localObject1 != null) {
        ((android.support.v4.f.f)localObject1).clear();
      }
      eh();
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (((this.OL instanceof Activity)) && (android.support.v4.app.v.g((Activity)this.OL) != null))
    {
      paramBundle = this.mActionBar;
      if (paramBundle == null) {
        this.PG = true;
      }
    }
    else
    {
      return;
    }
    paramBundle.L(true);
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = a(paramString, paramContext, paramAttributeSet);
    if (localView != null) {
      return localView;
    }
    return a(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public void onDestroy()
  {
    if (this.PD) {
      this.Nk.getDecorView().removeCallbacks(this.PF);
    }
    super.onDestroy();
    if (this.mActionBar != null) {
      this.mActionBar.onDestroy();
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
        if ((this.PB == null) || (!a(this.PB, paramKeyEvent.getKeyCode(), paramKeyEvent))) {
          break;
        }
      } while (this.PB == null);
      this.PB.PU = true;
      return true;
      if (this.PB != null) {
        break;
      }
      localObject = aV(0);
      b((PanelFeatureState)localObject, paramKeyEvent);
      bool = a((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent);
      ((PanelFeatureState)localObject).PT = false;
    } while (bool);
    return false;
  }
  
  public final void onPostResume()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.M(true);
    }
  }
  
  public void onStop()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.M(false);
    }
  }
  
  public final boolean requestWindowFeature(int paramInt)
  {
    int i;
    if (paramInt == 8) {
      i = 108;
    }
    while ((this.OT) && (i == 108))
    {
      return false;
      i = paramInt;
      if (paramInt == 9) {
        i = 109;
      }
    }
    if ((this.OP) && (i == 1)) {
      this.OP = false;
    }
    switch (i)
    {
    default: 
      return this.Nk.requestFeature(i);
    case 108: 
      er();
      this.OP = true;
      return true;
    case 109: 
      er();
      this.OQ = true;
      return true;
    case 10: 
      er();
      this.OR = true;
      return true;
    case 2: 
      er();
      this.Px = true;
      return true;
    case 5: 
      er();
      this.Py = true;
      return true;
    }
    er();
    this.OT = true;
    return true;
  }
  
  public final void setContentView(int paramInt)
  {
    en();
    ViewGroup localViewGroup = (ViewGroup)this.Pv.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.mContext).inflate(paramInt, localViewGroup);
    this.OL.onContentChanged();
  }
  
  public final void setContentView(View paramView)
  {
    en();
    ViewGroup localViewGroup = (ViewGroup)this.Pv.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.OL.onContentChanged();
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    en();
    ViewGroup localViewGroup = (ViewGroup)this.Pv.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.OL.onContentChanged();
  }
  
  public final void setSupportActionBar(Toolbar paramToolbar)
  {
    if (!(this.OL instanceof Activity)) {
      return;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar instanceof o)) {
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }
    this.fe = null;
    if (localActionBar != null) {
      localActionBar.onDestroy();
    }
    if (paramToolbar != null)
    {
      paramToolbar = new l(paramToolbar, ((Activity)this.OL).getTitle(), this.OM);
      this.mActionBar = paramToolbar;
      this.Nk.setCallback(paramToolbar.Qs);
    }
    for (;;)
    {
      invalidateOptionsMenu();
      return;
      this.mActionBar = null;
      this.Nk.setCallback(this.OM);
    }
  }
  
  public final android.support.v7.view.b startSupportActionMode(b.a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (this.Pp != null) {
      this.Pp.finish();
    }
    parama = new b(parama);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      this.Pp = localActionBar.a(parama);
      if ((this.Pp != null) && (this.OO != null)) {
        this.OO.onSupportActionModeStarted(this.Pp);
      }
    }
    if (this.Pp == null) {
      this.Pp = b(parama);
    }
    return this.Pp;
  }
  
  protected static final class PanelFeatureState
  {
    boolean LQ;
    int PM;
    ViewGroup PN;
    View PO;
    View PP;
    android.support.v7.view.menu.h PQ;
    android.support.v7.view.menu.f PR;
    Context PS;
    boolean PT;
    boolean PU;
    public boolean PV;
    boolean PW;
    boolean PX;
    Bundle PY;
    int background;
    int gravity;
    int windowAnimations;
    int x;
    int y;
    
    PanelFeatureState(int paramInt)
    {
      this.PM = paramInt;
      this.PW = false;
    }
    
    final void e(android.support.v7.view.menu.h paramh)
    {
      if (paramh == this.PQ) {}
      do
      {
        return;
        if (this.PQ != null) {
          this.PQ.b(this.PR);
        }
        this.PQ = paramh;
      } while ((paramh == null) || (this.PR == null));
      paramh.a(this.PR);
    }
    
    private static class SavedState
      implements Parcelable
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
      boolean LQ;
      int PM;
      Bundle jn;
      
      static SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        boolean bool = true;
        SavedState localSavedState = new SavedState();
        localSavedState.PM = paramParcel.readInt();
        if (paramParcel.readInt() == 1) {}
        for (;;)
        {
          localSavedState.LQ = bool;
          if (localSavedState.LQ) {
            localSavedState.jn = paramParcel.readBundle(paramClassLoader);
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
        paramParcel.writeInt(this.PM);
        if (this.LQ) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeInt(paramInt);
          if (this.LQ) {
            paramParcel.writeBundle(this.jn);
          }
          return;
        }
      }
    }
  }
  
  private final class a
    implements o.a
  {
    a() {}
    
    public final void a(android.support.v7.view.menu.h paramh, boolean paramBoolean)
    {
      AppCompatDelegateImplV9.this.c(paramh);
    }
    
    public final boolean d(android.support.v7.view.menu.h paramh)
    {
      Window.Callback localCallback = AppCompatDelegateImplV9.this.Nk.getCallback();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramh);
      }
      return true;
    }
  }
  
  final class b
    implements b.a
  {
    private b.a PK;
    
    public b(b.a parama)
    {
      this.PK = parama;
    }
    
    public final void a(android.support.v7.view.b paramb)
    {
      this.PK.a(paramb);
      if (AppCompatDelegateImplV9.this.Pr != null) {
        AppCompatDelegateImplV9.this.Nk.getDecorView().removeCallbacks(AppCompatDelegateImplV9.this.Ps);
      }
      if (AppCompatDelegateImplV9.this.Pq != null)
      {
        AppCompatDelegateImplV9.this.ep();
        AppCompatDelegateImplV9.this.Pt = q.Y(AppCompatDelegateImplV9.this.Pq).s(0.0F);
        AppCompatDelegateImplV9.this.Pt.a(new w()
        {
          public final void av(View paramAnonymousView)
          {
            AppCompatDelegateImplV9.this.Pq.setVisibility(8);
            if (AppCompatDelegateImplV9.this.Pr != null) {
              AppCompatDelegateImplV9.this.Pr.dismiss();
            }
            for (;;)
            {
              AppCompatDelegateImplV9.this.Pq.removeAllViews();
              AppCompatDelegateImplV9.this.Pt.a(null);
              AppCompatDelegateImplV9.this.Pt = null;
              return;
              if ((AppCompatDelegateImplV9.this.Pq.getParent() instanceof View)) {
                q.ad((View)AppCompatDelegateImplV9.this.Pq.getParent());
              }
            }
          }
        });
      }
      if (AppCompatDelegateImplV9.this.OO != null) {
        AppCompatDelegateImplV9.this.OO.onSupportActionModeFinished(AppCompatDelegateImplV9.this.Pp);
      }
      AppCompatDelegateImplV9.this.Pp = null;
    }
    
    public final boolean a(android.support.v7.view.b paramb, Menu paramMenu)
    {
      return this.PK.a(paramb, paramMenu);
    }
    
    public final boolean a(android.support.v7.view.b paramb, MenuItem paramMenuItem)
    {
      return this.PK.a(paramb, paramMenuItem);
    }
    
    public final boolean b(android.support.v7.view.b paramb, Menu paramMenu)
    {
      return this.PK.b(paramb, paramMenu);
    }
  }
  
  private final class c
    extends ContentFrameLayout
  {
    public c(Context paramContext)
    {
      super();
    }
    
    public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImplV9.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
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
          AppCompatDelegateImplV9.this.eq();
          return true;
        }
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public final void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(android.support.v7.c.a.b.g(getContext(), paramInt));
    }
  }
  
  private final class d
    implements o.a
  {
    d() {}
    
    public final void a(android.support.v7.view.menu.h paramh, boolean paramBoolean)
    {
      android.support.v7.view.menu.h localh = paramh.fo();
      if (localh != paramh) {}
      for (int i = 1;; i = 0)
      {
        AppCompatDelegateImplV9 localAppCompatDelegateImplV9 = AppCompatDelegateImplV9.this;
        if (i != 0) {
          paramh = localh;
        }
        paramh = localAppCompatDelegateImplV9.a(paramh);
        if (paramh != null)
        {
          if (i == 0) {
            break;
          }
          AppCompatDelegateImplV9.this.a(paramh.PM, paramh, localh);
          AppCompatDelegateImplV9.this.a(paramh, true);
        }
        return;
      }
      AppCompatDelegateImplV9.this.a(paramh, paramBoolean);
    }
    
    public final boolean d(android.support.v7.view.menu.h paramh)
    {
      if ((paramh == null) && (AppCompatDelegateImplV9.this.OP))
      {
        Window.Callback localCallback = AppCompatDelegateImplV9.this.Nk.getCallback();
        if ((localCallback != null) && (!AppCompatDelegateImplV9.this.OV)) {
          localCallback.onMenuOpened(108, paramh);
        }
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV9
 * JD-Core Version:    0.7.0.1
 */