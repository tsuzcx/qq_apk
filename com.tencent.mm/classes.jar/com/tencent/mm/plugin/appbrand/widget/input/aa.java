package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.core.g.z;
import com.tencent.luggage.a.e;
import com.tencent.luggage.wxa.b.a.d;
import com.tencent.luggage.wxa.b.a.e;
import com.tencent.luggage.wxa.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.plugin.appbrand.widget.input.d.b.a;
import com.tencent.mm.plugin.appbrand.widget.input.d.b.b;
import com.tencent.mm.plugin.appbrand.widget.input.d.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aa
  extends LinearLayout
  implements ag, u.b
{
  private static final int ehD;
  private static final b uHW;
  private Context context;
  private final MMHandler sVR;
  private int state;
  private final List<d> uHG;
  private int uHH;
  private final Runnable uHI;
  private e uHJ;
  private c uHK;
  private boolean uHL;
  private f uHM;
  protected com.tencent.mm.plugin.appbrand.widget.input.d.b uHN;
  private View uHO;
  protected ImageButton uHP;
  private boolean uHQ;
  private View uHR;
  private boolean uHS;
  public EditText uHT;
  protected final ah uHU;
  private boolean uHV;
  private View uHj;
  private com.tencent.mm.plugin.appbrand.o.a uHk;
  private boolean uHl;
  
  static
  {
    AppMethodBeat.i(136553);
    ehD = a.e.app_brand_keyboard_smiley;
    uHW = new g((byte)0);
    AppMethodBeat.o(136553);
  }
  
  public aa(Context paramContext, com.tencent.mm.plugin.appbrand.o.a parama, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(324505);
    this.uHG = new ArrayList();
    this.uHH = 0;
    this.uHI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(324642);
        if ((aa.d(aa.this) == null) || (!z.ay(aa.d(aa.this))))
        {
          AppMethodBeat.o(324642);
          return;
        }
        if (aa.this.uHN.cSd())
        {
          Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "postMeasure inLayout, skip");
          aa.this.post(this);
          AppMethodBeat.o(324642);
          return;
        }
        aa.e(aa.this);
        AppMethodBeat.o(324642);
      }
    };
    this.uHL = false;
    this.state = 2;
    this.sVR = new aa.4(this, Looper.getMainLooper());
    this.uHk = null;
    this.uHl = false;
    this.uHV = false;
    this.context = paramContext;
    ah localah = ah.a.fy(paramContext);
    paramContext = localah;
    if (localah == null) {
      paramContext = new com.tencent.mm.plugin.appbrand.widget.input.b.a();
    }
    this.uHU = paramContext;
    Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "mComponentView is assigned");
    this.uHk = parama;
    Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "init");
    super.setId(aqr());
    setOrientation(1);
    if (this.uHl)
    {
      this.uHj = this.uHk;
      if (this.uHj != null)
      {
        paramContext = (ViewGroup)this.uHj.getParent();
        if (paramContext != null)
        {
          Log.i("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is already existed in a layout,the class of the parent is %s  the id is : %d", new Object[] { paramContext.getClass().toString(), Integer.valueOf(paramContext.getId()) });
          paramContext.removeView(this.uHj);
        }
      }
      addView(this.uHj);
      this.uHV = false;
      paramContext = (b.b)e.T(b.b.class);
      if (paramContext != null) {
        break label348;
      }
    }
    label348:
    for (paramContext = null;; paramContext = paramContext.F(this.context, paramBoolean))
    {
      this.uHN = paramContext;
      if (this.uHN == null) {
        this.uHN = new b.a(this.context);
      }
      uHW.c(this, u.getValidPanelHeight(getContext()));
      this.uHO = this.uHN.getPanelView();
      this.uHO.setVisibility(8);
      this.uHO.setBackgroundColor(0);
      addView(this.uHO);
      aqt();
      AppMethodBeat.o(324505);
      return;
      this.uHj = aqv();
      break;
    }
  }
  
  private void Er(final int paramInt)
  {
    AppMethodBeat.i(136533);
    Runnable local7 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(324634);
        int i = aa.b(aa.this);
        if (!aa.this.isShown()) {
          aa.a(aa.this, 2);
        }
        while (aa.g(aa.this) == null)
        {
          AppMethodBeat.o(324634);
          return;
          aa.a(aa.this, paramInt);
        }
        if ((i != aa.b(aa.this)) && (!this.uHZ)) {
          aa.g(aa.this).onVisibilityChanged(aa.b(aa.this));
        }
        AppMethodBeat.o(324634);
      }
    };
    this.sVR.obtainMessage(1, local7).sendToTarget();
    AppMethodBeat.o(136533);
  }
  
  private void aWJ()
  {
    AppMethodBeat.i(136536);
    this.uHN.onPause();
    uHW.k(this);
    if (this.uHP != null) {
      this.uHP.setSelected(false);
    }
    Er(0);
    AppMethodBeat.o(136536);
  }
  
  public static aa b(View paramView, com.tencent.mm.plugin.appbrand.o.a parama)
  {
    AppMethodBeat.i(324501);
    n localn = n.ed(paramView);
    if (localn == null)
    {
      AppMethodBeat.o(324501);
      return null;
    }
    n.ef(paramView);
    Object localObject1 = ek(paramView);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = AndroidContextUtil.castActivityOrNull(paramView.getContext());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = paramView.getContext();
        if (localObject1 == null) {
          break label146;
        }
        if ((localObject1 instanceof ContextThemeWrapper)) {
          localObject1 = (ContextThemeWrapper)localObject1;
        }
      }
      else
      {
        label74:
        if (!(paramView instanceof aa)) {
          break label151;
        }
        paramView = (aa)paramView;
        label86:
        localn.ee(paramView);
      }
    }
    for (;;)
    {
      if (paramView.uHk != parama)
      {
        Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "mComponentView != componentView so we set mComponentView = componentView;");
        paramView.uHk = parama;
      }
      AppMethodBeat.o(324501);
      return paramView;
      if ((localObject1 instanceof ContextWrapper))
      {
        localObject2 = ((ContextWrapper)localObject1).getBaseContext();
        if (localObject2 != localObject1)
        {
          localObject1 = localObject2;
          break;
        }
      }
      label146:
      localObject1 = null;
      break label74;
      label151:
      paramView = new aa((Context)localObject1, parama, false);
      break label86;
      paramView = (View)localObject1;
    }
  }
  
  private void cRw()
  {
    AppMethodBeat.i(136531);
    aqs();
    ((u)n.ed(this).getOnLayoutListener()).uHa = this;
    AppMethodBeat.o(136531);
  }
  
  private void cRx()
  {
    AppMethodBeat.i(136532);
    n localn = n.ed(this);
    if (localn == null)
    {
      AppMethodBeat.o(136532);
      return;
    }
    if (localn.getOnLayoutListener() == null)
    {
      AppMethodBeat.o(136532);
      return;
    }
    ((u)localn.getOnLayoutListener()).uHa = null;
    AppMethodBeat.o(136532);
  }
  
  private void cRy()
  {
    AppMethodBeat.i(136534);
    aWJ();
    if (this.uHT != null)
    {
      InputMethodManager localInputMethodManager = an.ep(this.uHT);
      if (!localInputMethodManager.showSoftInput(this.uHT, 1)) {
        localInputMethodManager.showSoftInput(this.uHT, 2);
      }
      AppMethodBeat.o(136534);
      return;
    }
    this.uHU.showVKB();
    AppMethodBeat.o(136534);
  }
  
  private static void ei(View paramView)
  {
    AppMethodBeat.i(324513);
    if (paramView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(paramView);
      }
    }
    AppMethodBeat.o(324513);
  }
  
  public static aa ek(View paramView)
  {
    AppMethodBeat.i(136518);
    paramView = (aa)paramView.getRootView().findViewById(ehD);
    AppMethodBeat.o(136518);
    return paramView;
  }
  
  private void setPanelHeightImpl(int paramInt)
  {
    AppMethodBeat.i(136524);
    if (this.uHN.Ew(paramInt)) {
      this.uHI.run();
    }
    AppMethodBeat.o(136524);
  }
  
  final void Es(int paramInt)
  {
    AppMethodBeat.i(136542);
    int i = paramInt;
    if (paramInt == 0)
    {
      i = paramInt;
      if (ae.dL(this)) {
        i = 8;
      }
    }
    if (getVisibility() == i)
    {
      AppMethodBeat.o(136542);
      return;
    }
    super.setVisibility(i);
    if (i == 0)
    {
      cRw();
      AppMethodBeat.o(136542);
      return;
    }
    cRx();
    AppMethodBeat.o(136542);
  }
  
  protected final void a(ImageButton paramImageButton)
  {
    this.uHP = paramImageButton;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(324563);
    if (!this.uHG.contains(paramd)) {
      this.uHG.add(paramd);
    }
    AppMethodBeat.o(324563);
  }
  
  protected int aqr()
  {
    return ehD;
  }
  
  protected void aqs()
  {
    AppMethodBeat.i(136530);
    b(this, this.uHk);
    AppMethodBeat.o(136530);
  }
  
  protected void aqt()
  {
    boolean bool = false;
    AppMethodBeat.i(136537);
    if (this.uHj == null)
    {
      AppMethodBeat.o(136537);
      return;
    }
    a locala;
    int i;
    if ((this.uHj instanceof a))
    {
      locala = (a)this.uHj;
      if (this.uHQ) {
        break label89;
      }
      i = 1;
      if (this.uHS) {
        break label94;
      }
    }
    label89:
    label94:
    for (int j = 1;; j = 0)
    {
      if (((i & j) != 0) || (ae.dL(this))) {
        bool = true;
      }
      locala.setIsHide(bool);
      AppMethodBeat.o(136537);
      return;
      i = 0;
      break;
    }
  }
  
  protected void aqu()
  {
    AppMethodBeat.i(136545);
    setCanSmileyInput(this.uHQ);
    setShowDoneButton(this.uHS);
    aqt();
    AppMethodBeat.o(136545);
  }
  
  protected <T extends View,  extends a> T aqv()
  {
    AppMethodBeat.i(136529);
    h localh = new h(getContext());
    this.uHP = el(localh);
    if (this.uHP != null)
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      Drawable localDrawable = MMApplicationContext.getResources().getDrawable(a.d.textfield_icon_emoji_pressed);
      localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
      localDrawable = MMApplicationContext.getResources().getDrawable(a.d.textfield_icon_emoji_normal);
      localStateListDrawable.addState(new int[0], localDrawable);
      this.uHP.setImageDrawable(localStateListDrawable);
    }
    this.uHR = localh.findViewById(a.e.smiley_toolbar_done);
    this.uHR.setOnClickListener(new aa.5(this));
    AppMethodBeat.o(136529);
    return localh;
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(324566);
    this.uHG.remove(paramd);
    AppMethodBeat.o(324566);
  }
  
  public final boolean b(EditText paramEditText)
  {
    if (paramEditText == this.uHT)
    {
      this.uHT = null;
      return true;
    }
    return false;
  }
  
  public void cK(boolean paramBoolean)
  {
    AppMethodBeat.i(136523);
    Log.i("MicroMsg.AppBrandSoftKeyboardPanel", "onKeyboardStateChanged, kbShown = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Es(0);
      aWJ();
      AppMethodBeat.o(136523);
      return;
    }
    if (isShown())
    {
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136503);
          if ((aa.a(aa.this)) && (1 == aa.b(aa.this)))
          {
            aa.c(aa.this);
            AppMethodBeat.o(136503);
            return;
          }
          aa.this.hide();
          AppMethodBeat.o(136503);
        }
      };
      if (this.sVR.hasMessages(1))
      {
        this.sVR.post(local1);
        AppMethodBeat.o(136523);
        return;
      }
      local1.run();
    }
    AppMethodBeat.o(136523);
  }
  
  public final void cRA()
  {
    AppMethodBeat.i(324614);
    uHW.n(this);
    this.uHP.setSelected(true);
    AppMethodBeat.o(324614);
  }
  
  public final boolean cRB()
  {
    return this.uHQ;
  }
  
  public final boolean cRp()
  {
    AppMethodBeat.i(136520);
    boolean bool = this.uHN.cRp();
    AppMethodBeat.o(136520);
    return bool;
  }
  
  public final void cRz()
  {
    AppMethodBeat.i(324608);
    if (this.uHj == null)
    {
      AppMethodBeat.o(324608);
      return;
    }
    if (this.uHV)
    {
      ei(this.uHj);
      if (!this.uHl) {
        break label176;
      }
    }
    label176:
    for (this.uHj = this.uHk;; this.uHj = aqv())
    {
      ei(this.uHj);
      addView(this.uHj, 0);
      Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is changed in updateToolbar() because of toolbarChanged");
      this.uHV = false;
      if ((this.uHl) && (this.uHj != this.uHk))
      {
        ei(this.uHj);
        this.uHj = this.uHk;
        ei(this.uHj);
        addView(this.uHj, 0);
        Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is changed in updateToolbar() because toolbar != mComponentView");
      }
      if ((this.uHl) && (this.uHj.getParent() != this))
      {
        ei(this.uHj);
        addView(this.uHj, 0);
      }
      AppMethodBeat.o(324608);
      return;
    }
  }
  
  protected final void df(boolean paramBoolean)
  {
    AppMethodBeat.i(136526);
    if ((!this.uHL) && (this.uHK != null))
    {
      this.uHL = true;
      this.uHK.df(paramBoolean);
      this.uHL = false;
    }
    AppMethodBeat.o(136526);
  }
  
  protected final ImageButton el(View paramView)
  {
    AppMethodBeat.i(324602);
    paramView = (ImageButton)paramView.findViewById(a.e.smiley_toolbar_switcher_image);
    if (paramView == null)
    {
      AppMethodBeat.o(324602);
      return null;
    }
    paramView.setSelected(false);
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(324638);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramAnonymousView.isSelected())
        {
          aa.cRC().m(aa.this);
          paramAnonymousView.setSelected(false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(324638);
          return;
          aa.cRC().n(aa.this);
          paramAnonymousView.setSelected(true);
        }
      }
    });
    AppMethodBeat.o(324602);
    return paramView;
  }
  
  public EditText getAttachedEditText()
  {
    return this.uHT;
  }
  
  public int getMinimumHeight()
  {
    AppMethodBeat.i(136525);
    if ((getVisibility() != 0) || ((this.uHj != null) && ((this.uHj.getVisibility() != 0) || ((this.uHj.getMeasuredWidth() == 0) && (this.uHj.getMeasuredHeight() == 0)))))
    {
      AppMethodBeat.o(136525);
      return 0;
    }
    if ((this.uHl) && (this.uHk != null))
    {
      ap localap = this.uHk.getCustomViewContainer();
      if ((localap != null) && ((localap.getRootView() instanceof ViewGroup)) && (((ViewGroup)localap.getRootView()).getChildCount() > 0) && (((ViewGroup)localap.getRootView()).getChildAt(0).getLayoutParams() != null))
      {
        i = Math.max(((ViewGroup)localap.getRootView()).getChildAt(0).getLayoutParams().height, 0);
        AppMethodBeat.o(136525);
        return i;
      }
      AppMethodBeat.o(136525);
      return 0;
    }
    int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 48);
    AppMethodBeat.o(136525);
    return i;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(136547);
    if (!isShown())
    {
      AppMethodBeat.o(136547);
      return;
    }
    Es(8);
    if ((this.uHT != null) && (!this.uHU.hideVKBHavingResult())) {}
    try
    {
      an.ep(this).hideSoftInputFromWindow(getWindowToken(), 0);
      label58:
      aWJ();
      AppMethodBeat.o(136547);
      return;
    }
    catch (Exception localException)
    {
      break label58;
    }
  }
  
  public void mo(int paramInt)
  {
    AppMethodBeat.i(136521);
    Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] refreshHeight %d", new Object[] { Integer.valueOf(paramInt) });
    uHW.c(this, paramInt);
    AppMethodBeat.o(136521);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(136539);
    super.onAttachedToWindow();
    cRw();
    AppMethodBeat.o(136539);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(136540);
    super.onDetachedFromWindow();
    Es(8);
    if (this.context != null)
    {
      if (this.uHT == null) {
        break label101;
      }
      this.uHU.hideVKB(this.uHT);
    }
    for (;;)
    {
      this.uHN.onDestroy();
      if (this.uHP != null) {
        this.uHP.setOnClickListener(null);
      }
      this.uHJ = null;
      removeAllViews();
      this.context = null;
      this.uHG.clear();
      cRx();
      AppMethodBeat.o(136540);
      return;
      label101:
      this.uHU.hideVKB();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136522);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getMeasuredHeight();
    if (paramInt1 != this.uHH)
    {
      Log.i("MicroMsg.AppBrandSoftKeyboardPanel", "update panel height from %d to %d", new Object[] { Integer.valueOf(this.uHH), Integer.valueOf(paramInt1) });
      this.uHH = paramInt1;
      Iterator localIterator = this.uHG.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if ((locald != null) && (locald.getEditText() == this.uHT)) {
          locald.mL(this.uHH);
        }
      }
    }
    Log.v("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] SoftKeyboardPanel onLayout measuredHeight = %d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    AppMethodBeat.o(136522);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136538);
    super.onMeasure(paramInt1, paramInt2);
    Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "smileyPanelWrapper, onMeasure");
    AppMethodBeat.o(136538);
  }
  
  public void setCanSmileyInput(boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(136543);
    label42:
    ImageButton localImageButton;
    if ((paramBoolean) && (this.uHN.cSe()))
    {
      paramBoolean = true;
      int k = this.uHV;
      if (this.uHQ == paramBoolean) {
        break label103;
      }
      this.uHV = (i | k);
      this.uHQ = paramBoolean;
      cRz();
      if (this.uHP != null)
      {
        localImageButton = this.uHP;
        if (!this.uHQ) {
          break label108;
        }
      }
    }
    label103:
    label108:
    for (i = j;; i = 8)
    {
      localImageButton.setVisibility(i);
      aqt();
      AppMethodBeat.o(136543);
      return;
      paramBoolean = false;
      break;
      i = 0;
      break label42;
    }
  }
  
  public void setComponentView(boolean paramBoolean)
  {
    if (this.uHl != paramBoolean)
    {
      this.uHl = paramBoolean;
      this.uHV = true;
    }
  }
  
  public void setId(int paramInt) {}
  
  public void setOnDoneListener(c paramc)
  {
    this.uHK = paramc;
  }
  
  public void setOnSmileyChosenListener(e parame)
  {
    AppMethodBeat.i(324585);
    if (parame != this.uHJ) {}
    for (int i = 1;; i = 0)
    {
      this.uHJ = parame;
      if (i != 0) {
        this.uHN.setOnTextOperationListener(new f()
        {
          public final void aWM()
          {
            AppMethodBeat.i(324641);
            if (aa.f(aa.this) != null) {
              aa.f(aa.this).eZ("[DELETE_EMOTION]");
            }
            AppMethodBeat.o(324641);
          }
          
          public final void append(String paramAnonymousString)
          {
            AppMethodBeat.i(324639);
            if (aa.f(aa.this) != null) {
              aa.f(aa.this).eZ(paramAnonymousString);
            }
            AppMethodBeat.o(324639);
          }
        });
      }
      AppMethodBeat.o(324585);
      return;
    }
  }
  
  public void setOnVisibilityChangedListener(f paramf)
  {
    this.uHM = paramf;
  }
  
  public void setShowDoneButton(boolean paramBoolean)
  {
    AppMethodBeat.i(136544);
    cRz();
    this.uHS = paramBoolean;
    View localView;
    if (this.uHR != null)
    {
      localView = this.uHR;
      if (!this.uHS) {
        break label52;
      }
    }
    label52:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      aqt();
      AppMethodBeat.o(136544);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(136541);
    if (paramInt == 8)
    {
      if (getVisibility() != paramInt) {
        df(false);
      }
      hide();
      AppMethodBeat.o(136541);
      return;
    }
    if (paramInt == 0)
    {
      show();
      AppMethodBeat.o(136541);
      return;
    }
    Es(paramInt);
    AppMethodBeat.o(136541);
  }
  
  public void show()
  {
    AppMethodBeat.i(136546);
    if (this.uHT != null) {
      cRy();
    }
    aqu();
    if (!isShown()) {
      Es(0);
    }
    AppMethodBeat.o(136546);
  }
  
  public static abstract interface a
  {
    public abstract void setIsHide(boolean paramBoolean);
  }
  
  static abstract interface b
  {
    public abstract void c(aa paramaa, int paramInt);
    
    public abstract void k(aa paramaa);
    
    public abstract void l(aa paramaa);
    
    public abstract void m(aa paramaa);
    
    public abstract void n(aa paramaa);
  }
  
  public static abstract interface c
  {
    public abstract void df(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract EditText getEditText();
    
    public abstract void mL(int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract boolean eZ(String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void onVisibilityChanged(int paramInt);
  }
  
  static final class g
    implements aa.b
  {
    public final void c(aa paramaa, int paramInt)
    {
      AppMethodBeat.i(136511);
      if (ae.dL(paramaa))
      {
        paramaa.Es(8);
        AppMethodBeat.o(136511);
        return;
      }
      if ((aa.d(paramaa) == null) || (paramInt <= 0))
      {
        AppMethodBeat.o(136511);
        return;
      }
      aa.b(paramaa, paramInt);
      AppMethodBeat.o(136511);
    }
    
    public final void k(aa paramaa)
    {
      boolean bool = false;
      AppMethodBeat.i(136509);
      if (paramaa.isShown()) {
        aa.d(paramaa).setVisibility(0);
      }
      com.tencent.mm.plugin.appbrand.widget.input.d.b localb = paramaa.uHN;
      if (!aa.a(paramaa)) {
        bool = true;
      }
      localb.lG(bool);
      AppMethodBeat.o(136509);
    }
    
    public final void l(aa paramaa)
    {
      AppMethodBeat.i(136510);
      if (ae.dL(paramaa))
      {
        paramaa.Es(8);
        aa.h(paramaa);
        AppMethodBeat.o(136510);
        return;
      }
      if (paramaa.isShown()) {
        aa.d(paramaa).setVisibility(0);
      }
      if (!aa.a(paramaa))
      {
        paramaa.uHN.lG(true);
        AppMethodBeat.o(136510);
        return;
      }
      paramaa.uHN.cSc();
      AppMethodBeat.o(136510);
    }
    
    public final void m(aa paramaa)
    {
      AppMethodBeat.i(136512);
      paramaa.uHU.showVKB();
      aa.i(paramaa);
      AppMethodBeat.o(136512);
    }
    
    public final void n(aa paramaa)
    {
      AppMethodBeat.i(136513);
      paramaa.uHU.hideVKB();
      aa.c(paramaa);
      paramaa.mo(u.getValidPanelHeight(aa.j(paramaa)));
      AppMethodBeat.o(136513);
    }
  }
  
  static final class h
    extends FrameLayout
    implements aa.a
  {
    private boolean uIa;
    
    public h(Context paramContext)
    {
      super();
      AppMethodBeat.i(136514);
      this.uIa = false;
      LayoutInflater.from(paramContext).inflate(a.f.appbrand_smiley_panel_wrapper, this);
      AppMethodBeat.o(136514);
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(136516);
      if ((this.uIa) || (!isShown()))
      {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
      }
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(136516);
    }
    
    public final void setIsHide(boolean paramBoolean)
    {
      AppMethodBeat.i(136515);
      if (paramBoolean != this.uIa) {}
      for (int i = 1;; i = 0)
      {
        this.uIa = paramBoolean;
        if ((i != 0) && ((Build.VERSION.SDK_INT < 18) || (!isInLayout()))) {
          requestLayout();
        }
        AppMethodBeat.o(136515);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aa
 * JD-Core Version:    0.7.0.1
 */