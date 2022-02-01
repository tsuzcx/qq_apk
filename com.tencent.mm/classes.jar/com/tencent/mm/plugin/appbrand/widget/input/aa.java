package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Looper;
import android.os.Message;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.core.g.w;
import com.tencent.luggage.wxa.b.a.d;
import com.tencent.luggage.wxa.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.ui.x;
import com.tencent.mm.plugin.appbrand.widget.input.d.b.a;
import com.tencent.mm.plugin.appbrand.widget.input.d.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public class aa
  extends LinearLayout
  implements ag, u.b
{
  private static final int cpM;
  private static final b rwS;
  private Context context;
  private final MMHandler pRi;
  private final List<d> rwC;
  private int rwD;
  private final Runnable rwE;
  private e rwF;
  private c rwG;
  private boolean rwH;
  private f rwI;
  protected com.tencent.mm.plugin.appbrand.widget.input.d.b rwJ;
  private View rwK;
  protected ImageButton rwL;
  private boolean rwM;
  private View rwN;
  private boolean rwO;
  public EditText rwP;
  protected final ah rwQ;
  private boolean rwR;
  private View rwc;
  private com.tencent.mm.plugin.appbrand.n.a rwd;
  private boolean rwe;
  private int state;
  
  static
  {
    AppMethodBeat.i(136553);
    cpM = a.e.app_brand_keyboard_smiley;
    rwS = new g((byte)0);
    AppMethodBeat.o(136553);
  }
  
  public aa(Context paramContext, com.tencent.mm.plugin.appbrand.n.a parama)
  {
    super(paramContext);
    AppMethodBeat.i(214963);
    this.rwC = new ArrayList();
    this.rwD = 0;
    this.rwE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215114);
        if ((aa.d(aa.this) == null) || (!w.al(aa.d(aa.this))))
        {
          AppMethodBeat.o(215114);
          return;
        }
        if (aa.this.rwJ.cpA())
        {
          Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "postMeasure inLayout, skip");
          aa.this.post(this);
          AppMethodBeat.o(215114);
          return;
        }
        aa.e(aa.this);
        AppMethodBeat.o(215114);
      }
    };
    this.rwH = false;
    this.state = 2;
    this.pRi = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(214762);
        if (1 == paramAnonymousMessage.what)
        {
          ((Runnable)paramAnonymousMessage.obj).run();
          AppMethodBeat.o(214762);
          return;
        }
        super.handleMessage(paramAnonymousMessage);
        AppMethodBeat.o(214762);
      }
    };
    this.rwd = null;
    this.rwe = false;
    this.rwR = false;
    this.context = paramContext;
    ah localah = ah.a.eC(paramContext);
    paramContext = localah;
    if (localah == null) {
      paramContext = new com.tencent.mm.plugin.appbrand.widget.input.b.a();
    }
    this.rwQ = paramContext;
    Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "mComponentView is assigned");
    this.rwd = parama;
    Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "init");
    super.setId(Qh());
    setOrientation(1);
    if (this.rwe)
    {
      this.rwc = this.rwd;
      if (this.rwc != null)
      {
        paramContext = (ViewGroup)this.rwc.getParent();
        if (paramContext != null)
        {
          Log.i("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is already existed in a layout,the class of the parent is %s  the id is : %d", new Object[] { paramContext.getClass().toString(), Integer.valueOf(paramContext.getId()) });
          paramContext.removeView(this.rwc);
        }
      }
      addView(this.rwc);
      this.rwR = false;
      paramContext = (b.b)com.tencent.luggage.a.e.K(b.b.class);
      if (paramContext != null) {
        break label345;
      }
    }
    label345:
    for (paramContext = null;; paramContext = paramContext.eD(this.context))
    {
      this.rwJ = paramContext;
      if (this.rwJ == null) {
        this.rwJ = new b.a(this.context);
      }
      rwS.c(this, u.getValidPanelHeight(getContext()));
      this.rwK = this.rwJ.getPanelView();
      this.rwK.setVisibility(8);
      this.rwK.setBackgroundColor(0);
      addView(this.rwK);
      Qj();
      AppMethodBeat.o(214963);
      return;
      this.rwc = Ql();
      break;
    }
  }
  
  private void DR(final int paramInt)
  {
    AppMethodBeat.i(136533);
    Runnable local7 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214054);
        int i = aa.b(aa.this);
        if (!aa.this.isShown()) {
          aa.a(aa.this, 2);
        }
        while (aa.g(aa.this) == null)
        {
          AppMethodBeat.o(214054);
          return;
          aa.a(aa.this, paramInt);
        }
        if ((i != aa.b(aa.this)) && (!this.rwV)) {
          aa.g(aa.this).iJ(aa.b(aa.this));
        }
        AppMethodBeat.o(214054);
      }
    };
    this.pRi.obtainMessage(1, local7).sendToTarget();
    AppMethodBeat.o(136533);
  }
  
  private void aDL()
  {
    AppMethodBeat.i(136536);
    this.rwJ.onPause();
    rwS.k(this);
    if (this.rwL != null) {
      this.rwL.setSelected(false);
    }
    DR(0);
    AppMethodBeat.o(136536);
  }
  
  public static aa b(View paramView, com.tencent.mm.plugin.appbrand.n.a parama)
  {
    AppMethodBeat.i(214943);
    n localn = n.dp(paramView);
    if (localn == null)
    {
      AppMethodBeat.o(214943);
      return null;
    }
    n.dr(paramView);
    Object localObject1 = dw(paramView);
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
        localn.dq(paramView);
      }
    }
    for (;;)
    {
      if (paramView.rwd != parama)
      {
        Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "mComponentView != componentView so we set mComponentView = componentView;");
        paramView.rwd = parama;
      }
      AppMethodBeat.o(214943);
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
      paramView = new aa((Context)localObject1, parama);
      break label86;
      paramView = (View)localObject1;
    }
  }
  
  private void coU()
  {
    AppMethodBeat.i(136531);
    Qi();
    ((u)n.dp(this).getOnLayoutListener()).rvU = this;
    AppMethodBeat.o(136531);
  }
  
  private void coV()
  {
    AppMethodBeat.i(136532);
    n localn = n.dp(this);
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
    ((u)localn.getOnLayoutListener()).rvU = null;
    AppMethodBeat.o(136532);
  }
  
  private void coW()
  {
    AppMethodBeat.i(136534);
    aDL();
    if (this.rwP != null)
    {
      InputMethodManager localInputMethodManager = an.dB(this.rwP);
      if (!localInputMethodManager.showSoftInput(this.rwP, 1)) {
        localInputMethodManager.showSoftInput(this.rwP, 2);
      }
      AppMethodBeat.o(136534);
      return;
    }
    this.rwQ.showVKB();
    AppMethodBeat.o(136534);
  }
  
  private static void du(View paramView)
  {
    AppMethodBeat.i(214975);
    if (paramView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(paramView);
      }
    }
    AppMethodBeat.o(214975);
  }
  
  public static aa dw(View paramView)
  {
    AppMethodBeat.i(136518);
    paramView = (aa)paramView.getRootView().findViewById(cpM);
    AppMethodBeat.o(136518);
    return paramView;
  }
  
  private void setPanelHeightImpl(int paramInt)
  {
    AppMethodBeat.i(136524);
    if (this.rwJ.DW(paramInt)) {
      this.rwE.run();
    }
    AppMethodBeat.o(136524);
  }
  
  final void DS(int paramInt)
  {
    AppMethodBeat.i(136542);
    int i = paramInt;
    if (paramInt == 0)
    {
      i = paramInt;
      if (x.dc(this)) {
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
      coU();
      AppMethodBeat.o(136542);
      return;
    }
    coV();
    AppMethodBeat.o(136542);
  }
  
  protected int Qh()
  {
    return cpM;
  }
  
  protected void Qi()
  {
    AppMethodBeat.i(136530);
    b(this, this.rwd);
    AppMethodBeat.o(136530);
  }
  
  protected void Qj()
  {
    boolean bool = false;
    AppMethodBeat.i(136537);
    if (this.rwc == null)
    {
      AppMethodBeat.o(136537);
      return;
    }
    aa.a locala;
    int i;
    if ((this.rwc instanceof aa.a))
    {
      locala = (aa.a)this.rwc;
      if (this.rwM) {
        break label89;
      }
      i = 1;
      if (this.rwO) {
        break label94;
      }
    }
    label89:
    label94:
    for (int j = 1;; j = 0)
    {
      if (((i & j) != 0) || (x.dc(this))) {
        bool = true;
      }
      locala.setIsHide(bool);
      AppMethodBeat.o(136537);
      return;
      i = 0;
      break;
    }
  }
  
  protected void Qk()
  {
    AppMethodBeat.i(136545);
    setCanSmileyInput(this.rwM);
    setShowDoneButton(this.rwO);
    Qj();
    AppMethodBeat.o(136545);
  }
  
  protected <T extends View,  extends aa.a> T Ql()
  {
    AppMethodBeat.i(136529);
    aa.h localh = new aa.h(getContext());
    this.rwL = dx(localh);
    if (this.rwL != null)
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      Drawable localDrawable = MMApplicationContext.getResources().getDrawable(a.d.textfield_icon_emoji_pressed);
      localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
      localDrawable = MMApplicationContext.getResources().getDrawable(a.d.textfield_icon_emoji_normal);
      localStateListDrawable.addState(new int[0], localDrawable);
      this.rwL.setImageDrawable(localStateListDrawable);
    }
    this.rwN = localh.findViewById(a.e.smiley_toolbar_done);
    this.rwN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213966);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        aa.this.cz(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(213966);
      }
    });
    AppMethodBeat.o(136529);
    return localh;
  }
  
  protected final void a(ImageButton paramImageButton)
  {
    this.rwL = paramImageButton;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(214937);
    if (!this.rwC.contains(paramd)) {
      this.rwC.add(paramd);
    }
    AppMethodBeat.o(214937);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(214940);
    this.rwC.remove(paramd);
    AppMethodBeat.o(214940);
  }
  
  public final boolean b(EditText paramEditText)
  {
    if (paramEditText == this.rwP)
    {
      this.rwP = null;
      return true;
    }
    return false;
  }
  
  public void ca(boolean paramBoolean)
  {
    AppMethodBeat.i(136523);
    Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "onKeyboardStateChanged, kbShown = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      DS(0);
      aDL();
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
      if (this.pRi.hasMessages(1))
      {
        this.pRi.post(local1);
        AppMethodBeat.o(136523);
        return;
      }
      local1.run();
    }
    AppMethodBeat.o(136523);
  }
  
  public final boolean coN()
  {
    AppMethodBeat.i(136520);
    boolean bool = this.rwJ.coN();
    AppMethodBeat.o(136520);
    return bool;
  }
  
  public final void coX()
  {
    AppMethodBeat.i(214977);
    if (this.rwc == null)
    {
      AppMethodBeat.o(214977);
      return;
    }
    if (this.rwR)
    {
      du(this.rwc);
      if (!this.rwe) {
        break label176;
      }
    }
    label176:
    for (this.rwc = this.rwd;; this.rwc = Ql())
    {
      du(this.rwc);
      addView(this.rwc, 0);
      Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is changed in updateToolbar() because of toolbarChanged");
      this.rwR = false;
      if ((this.rwe) && (this.rwc != this.rwd))
      {
        du(this.rwc);
        this.rwc = this.rwd;
        du(this.rwc);
        addView(this.rwc, 0);
        Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is changed in updateToolbar() because toolbar != mComponentView");
      }
      if ((this.rwe) && (this.rwc.getParent() != this))
      {
        du(this.rwc);
        addView(this.rwc, 0);
      }
      AppMethodBeat.o(214977);
      return;
    }
  }
  
  public final boolean coY()
  {
    return this.rwM;
  }
  
  protected final void cz(boolean paramBoolean)
  {
    AppMethodBeat.i(136526);
    if ((!this.rwH) && (this.rwG != null))
    {
      this.rwH = true;
      this.rwG.cz(paramBoolean);
      this.rwH = false;
    }
    AppMethodBeat.o(136526);
  }
  
  protected final ImageButton dx(View paramView)
  {
    AppMethodBeat.i(214970);
    paramView = (ImageButton)paramView.findViewById(a.e.smiley_toolbar_switcher_image);
    if (paramView == null)
    {
      AppMethodBeat.o(214970);
      return null;
    }
    paramView.setSelected(false);
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213864);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (paramAnonymousView.isSelected())
        {
          aa.coZ().m(aa.this);
          paramAnonymousView.setSelected(false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213864);
          return;
          aa.coZ().n(aa.this);
          paramAnonymousView.setSelected(true);
        }
      }
    });
    AppMethodBeat.o(214970);
    return paramView;
  }
  
  public EditText getAttachedEditText()
  {
    return this.rwP;
  }
  
  public int getMinimumHeight()
  {
    AppMethodBeat.i(136525);
    if (getVisibility() != 0)
    {
      AppMethodBeat.o(136525);
      return 0;
    }
    if ((this.rwe) && (this.rwd != null))
    {
      ap localap = this.rwd.getCustomViewContainer();
      if ((localap != null) && ((localap.getRootView() instanceof ViewGroup)) && (((ViewGroup)localap.getRootView()).getChildCount() > 0) && (((ViewGroup)localap.getRootView()).getChildAt(0).getLayoutParams() != null))
      {
        i = Math.max(((ViewGroup)localap.getRootView()).getChildAt(0).getLayoutParams().height, 0);
        AppMethodBeat.o(136525);
        return i;
      }
      AppMethodBeat.o(136525);
      return 0;
    }
    int i = com.tencent.mm.ci.a.fromDPToPix(getContext(), 48);
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
    DS(8);
    if ((this.rwP != null) && (!this.rwQ.hideVKBHavingResult())) {}
    try
    {
      an.dB(this).hideSoftInputFromWindow(getWindowToken(), 0);
      label58:
      aDL();
      AppMethodBeat.o(136547);
      return;
    }
    catch (Exception localException)
    {
      break label58;
    }
  }
  
  public void iF(int paramInt)
  {
    AppMethodBeat.i(136521);
    Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] refreshHeight %d", new Object[] { Integer.valueOf(paramInt) });
    rwS.c(this, paramInt);
    AppMethodBeat.o(136521);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(136539);
    super.onAttachedToWindow();
    coU();
    AppMethodBeat.o(136539);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(136540);
    super.onDetachedFromWindow();
    DS(8);
    if (this.context != null)
    {
      if (this.rwP == null) {
        break label101;
      }
      this.rwQ.hideVKB(this.rwP);
    }
    for (;;)
    {
      this.rwJ.onDestroy();
      if (this.rwL != null) {
        this.rwL.setOnClickListener(null);
      }
      this.rwF = null;
      removeAllViews();
      this.context = null;
      this.rwC.clear();
      coV();
      AppMethodBeat.o(136540);
      return;
      label101:
      this.rwQ.hideVKB();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136522);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getMeasuredHeight();
    if (paramInt1 != this.rwD)
    {
      Log.i("MicroMsg.AppBrandSoftKeyboardPanel", "update panel height from %d to %d", new Object[] { Integer.valueOf(this.rwD), Integer.valueOf(paramInt1) });
      this.rwD = paramInt1;
      Iterator localIterator = this.rwC.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if ((locald != null) && (locald.getEditText() == this.rwP)) {
          locald.jj(this.rwD);
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
    if ((paramBoolean) && (this.rwJ.cpB()))
    {
      paramBoolean = true;
      int k = this.rwR;
      if (this.rwM == paramBoolean) {
        break label103;
      }
      this.rwR = (i | k);
      this.rwM = paramBoolean;
      coX();
      if (this.rwL != null)
      {
        localImageButton = this.rwL;
        if (!this.rwM) {
          break label108;
        }
      }
    }
    label103:
    label108:
    for (i = j;; i = 8)
    {
      localImageButton.setVisibility(i);
      Qj();
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
    if (this.rwe != paramBoolean)
    {
      this.rwe = paramBoolean;
      this.rwR = true;
    }
  }
  
  public void setId(int paramInt) {}
  
  public void setOnDoneListener(c paramc)
  {
    this.rwG = paramc;
  }
  
  public void setOnSmileyChosenListener(e parame)
  {
    AppMethodBeat.i(214955);
    if (parame != this.rwF) {}
    for (int i = 1;; i = 0)
    {
      this.rwF = parame;
      if (i != 0) {
        this.rwJ.setOnTextOperationListener(new com.tencent.mm.plugin.appbrand.widget.input.d.e()
        {
          public final void aDO()
          {
            AppMethodBeat.i(214565);
            if (aa.f(aa.this) != null) {
              aa.f(aa.this).dO("[DELETE_EMOTION]");
            }
            AppMethodBeat.o(214565);
          }
          
          public final void append(String paramAnonymousString)
          {
            AppMethodBeat.i(214564);
            if (aa.f(aa.this) != null) {
              aa.f(aa.this).dO(paramAnonymousString);
            }
            AppMethodBeat.o(214564);
          }
        });
      }
      AppMethodBeat.o(214955);
      return;
    }
  }
  
  public void setOnVisibilityChangedListener(f paramf)
  {
    this.rwI = paramf;
  }
  
  public void setShowDoneButton(boolean paramBoolean)
  {
    AppMethodBeat.i(136544);
    coX();
    this.rwO = paramBoolean;
    View localView;
    if (this.rwN != null)
    {
      localView = this.rwN;
      if (!this.rwO) {
        break label52;
      }
    }
    label52:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      Qj();
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
        cz(false);
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
    DS(paramInt);
    AppMethodBeat.o(136541);
  }
  
  public void show()
  {
    AppMethodBeat.i(136546);
    if (this.rwP != null) {
      coW();
    }
    Qk();
    if (!isShown()) {
      DS(0);
    }
    AppMethodBeat.o(136546);
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
    public abstract void cz(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract EditText getEditText();
    
    public abstract void jj(int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract boolean dO(String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void iJ(int paramInt);
  }
  
  static final class g
    implements aa.b
  {
    public final void c(aa paramaa, int paramInt)
    {
      AppMethodBeat.i(136511);
      if (x.dc(paramaa))
      {
        paramaa.DS(8);
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
      com.tencent.mm.plugin.appbrand.widget.input.d.b localb = paramaa.rwJ;
      if (!aa.a(paramaa)) {
        bool = true;
      }
      localb.ku(bool);
      AppMethodBeat.o(136509);
    }
    
    public final void l(aa paramaa)
    {
      AppMethodBeat.i(136510);
      if (x.dc(paramaa))
      {
        paramaa.DS(8);
        aa.h(paramaa);
        AppMethodBeat.o(136510);
        return;
      }
      if (paramaa.isShown()) {
        aa.d(paramaa).setVisibility(0);
      }
      if (!aa.a(paramaa))
      {
        paramaa.rwJ.ku(true);
        AppMethodBeat.o(136510);
        return;
      }
      paramaa.rwJ.cpz();
      AppMethodBeat.o(136510);
    }
    
    public final void m(aa paramaa)
    {
      AppMethodBeat.i(136512);
      paramaa.rwQ.showVKB();
      aa.i(paramaa);
      AppMethodBeat.o(136512);
    }
    
    public final void n(aa paramaa)
    {
      AppMethodBeat.i(136513);
      paramaa.rwQ.hideVKB();
      aa.c(paramaa);
      paramaa.iF(u.getValidPanelHeight(aa.j(paramaa)));
      AppMethodBeat.o(136513);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aa
 * JD-Core Version:    0.7.0.1
 */