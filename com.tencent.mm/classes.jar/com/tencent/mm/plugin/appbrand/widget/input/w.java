package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.a;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.b;
import com.tencent.mm.plugin.appbrand.widget.input.panel.f;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class w
  extends LinearLayout
  implements ac, u.b
{
  private static final int VIEW_ID;
  private static com.tencent.mm.plugin.appbrand.n.a otP;
  private static boolean otQ;
  private static boolean ouo;
  private static final b oup;
  private Context context;
  private View otO;
  private List<d> otZ;
  private int oua;
  private final Runnable oub;
  private e ouc;
  private c oud;
  private boolean oue;
  private f ouf;
  private com.tencent.mm.plugin.appbrand.widget.input.panel.e oug;
  private View ouh;
  private ImageButton oui;
  private boolean ouj;
  private View ouk;
  private boolean oul;
  public EditText oum;
  private final ad oun;
  private int state;
  
  static
  {
    AppMethodBeat.i(136553);
    VIEW_ID = 2131296843;
    otP = null;
    otQ = false;
    ouo = false;
    oup = new g((byte)0);
    AppMethodBeat.o(136553);
  }
  
  public w(Context paramContext, com.tencent.mm.plugin.appbrand.n.a parama)
  {
    super(paramContext);
    AppMethodBeat.i(230587);
    this.otZ = new ArrayList();
    this.oua = 0;
    this.oub = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136503);
        if ((w.a(w.this) == null) || (!android.support.v4.view.u.aD(w.a(w.this))))
        {
          AppMethodBeat.o(136503);
          return;
        }
        if (w.b(w.this).cbH())
        {
          Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "postMeasure inLayout, skip");
          w.this.post(this);
          AppMethodBeat.o(136503);
          return;
        }
        w.c(w.this);
        AppMethodBeat.o(136503);
      }
    };
    this.oue = false;
    this.state = 2;
    this.context = paramContext;
    if ((paramContext instanceof ad))
    {
      paramContext = (ad)paramContext;
      this.oun = paramContext;
      Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "mComponentView is assigned");
      otP = parama;
      Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "init");
      super.setId(VIEW_ID);
      setOrientation(1);
      if (!otQ) {
        break label304;
      }
      this.otO = otP;
      label113:
      if (this.otO != null)
      {
        paramContext = (ViewGroup)this.otO.getParent();
        if (paramContext != null)
        {
          Log.i("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is already exsited in a layout,the class of the parent is %s  the id is : %d", new Object[] { paramContext.getClass().toString(), Integer.valueOf(paramContext.getId()) });
          paramContext.removeView(this.otO);
        }
      }
      addView(this.otO);
      ouo = false;
      paramContext = (e.b)com.tencent.luggage.a.e.M(e.b.class);
      if (paramContext != null) {
        break label315;
      }
    }
    label304:
    label315:
    for (paramContext = null;; paramContext = paramContext.ec(this.context))
    {
      this.oug = paramContext;
      if (this.oug == null) {
        this.oug = new e.a(this.context);
      }
      this.ouh = this.oug.getPanelView();
      this.ouh.setVisibility(8);
      this.ouh.setBackgroundColor(0);
      this.oug.setOnTextOperationListener(new f()
      {
        public final void aHC()
        {
          AppMethodBeat.i(136507);
          if (w.d(w.this) != null) {
            w.d(w.this).afZ("[DELETE_EMOTION]");
          }
          AppMethodBeat.o(136507);
        }
        
        public final void append(String paramAnonymousString)
        {
          AppMethodBeat.i(136506);
          if (w.d(w.this) != null) {
            w.d(w.this).afZ(paramAnonymousString);
          }
          AppMethodBeat.o(136506);
        }
      });
      addView(this.ouh);
      Nq();
      AppMethodBeat.o(230587);
      return;
      paramContext = new com.tencent.mm.plugin.appbrand.widget.input.b.a();
      break;
      this.otO = Ns();
      break label113;
    }
  }
  
  private void Ah(final int paramInt)
  {
    AppMethodBeat.i(136533);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136508);
        int i = w.e(w.this);
        if (!w.this.isShown()) {
          w.a(w.this, 2);
        }
        while (w.f(w.this) == null)
        {
          AppMethodBeat.o(136508);
          return;
          w.a(w.this, paramInt);
        }
        if ((i != w.e(w.this)) && (!this.ous)) {
          w.f(w.this).hJ(w.e(w.this));
        }
        AppMethodBeat.o(136508);
      }
    });
    AppMethodBeat.o(136533);
  }
  
  public static w b(View paramView, com.tencent.mm.plugin.appbrand.n.a parama)
  {
    AppMethodBeat.i(230586);
    if (otP != parama)
    {
      Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "mComponentView != componentView so we set mComponentView = componentView;");
      otP = parama;
    }
    n localn = n.cW(paramView);
    if (localn == null)
    {
      AppMethodBeat.o(230586);
      return null;
    }
    if ((localn.getOnLayoutListener() == null) || (!(localn.getOnLayoutListener() instanceof u))) {
      localn.setOnLayoutListener(new u());
    }
    Object localObject1 = dc(paramView);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = AndroidContextUtil.castActivityOrNull(paramView.getContext());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = paramView.getContext();
        if (localObject1 == null) {
          break label170;
        }
        if ((localObject1 instanceof ContextThemeWrapper)) {
          localObject1 = (ContextThemeWrapper)localObject1;
        }
      }
      else
      {
        label119:
        if (!(paramView instanceof w)) {
          break label175;
        }
        paramView = (w)paramView;
        label131:
        localn.cX(paramView);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(230586);
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
      label170:
      localObject1 = null;
      break label119;
      label175:
      paramView = new w((Context)localObject1, parama);
      break label131;
      paramView = (View)localObject1;
    }
  }
  
  private void cbI()
  {
    AppMethodBeat.i(136531);
    Np();
    ((u)n.cW(this).getOnLayoutListener()).otH = this;
    AppMethodBeat.o(136531);
  }
  
  private void cbJ()
  {
    AppMethodBeat.i(136532);
    n localn = n.cW(this);
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
    ((u)localn.getOnLayoutListener()).otH = null;
    AppMethodBeat.o(136532);
  }
  
  private void cbK()
  {
    AppMethodBeat.i(136534);
    cbM();
    if (this.oum != null)
    {
      InputMethodManager localInputMethodManager = aj.dg(this.oum);
      if (!localInputMethodManager.showSoftInput(this.oum, 1)) {
        localInputMethodManager.showSoftInput(this.oum, 2);
      }
      AppMethodBeat.o(136534);
      return;
    }
    this.oun.showVKB();
    AppMethodBeat.o(136534);
  }
  
  private void cbL()
  {
    AppMethodBeat.i(136535);
    oup.n(this);
    if (this.oui != null) {
      this.oui.setSelected(true);
    }
    Ah(1);
    AppMethodBeat.o(136535);
  }
  
  private void cbM()
  {
    AppMethodBeat.i(136536);
    oup.m(this);
    if (this.oui != null) {
      this.oui.setSelected(false);
    }
    Ah(0);
    AppMethodBeat.o(136536);
  }
  
  private static void db(View paramView)
  {
    AppMethodBeat.i(230589);
    if (paramView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(paramView);
      }
    }
    AppMethodBeat.o(230589);
  }
  
  public static w dc(View paramView)
  {
    AppMethodBeat.i(136518);
    paramView = (w)paramView.getRootView().findViewById(VIEW_ID);
    AppMethodBeat.o(136518);
    return paramView;
  }
  
  private void setPanelHeightImpl(int paramInt)
  {
    AppMethodBeat.i(136524);
    if (this.oug.Af(paramInt)) {
      this.oub.run();
    }
    AppMethodBeat.o(136524);
  }
  
  protected final void Ag(int paramInt)
  {
    AppMethodBeat.i(258632);
    super.setId(paramInt);
    AppMethodBeat.o(258632);
  }
  
  final void Ai(int paramInt)
  {
    AppMethodBeat.i(136542);
    int i = paramInt;
    if (paramInt == 0)
    {
      i = paramInt;
      if (y.cI(this)) {
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
      cbI();
      AppMethodBeat.o(136542);
      return;
    }
    cbJ();
    AppMethodBeat.o(136542);
  }
  
  protected void Np()
  {
    AppMethodBeat.i(136530);
    b(this, otP);
    AppMethodBeat.o(136530);
  }
  
  protected void Nq()
  {
    boolean bool = false;
    AppMethodBeat.i(136537);
    if (this.otO == null)
    {
      AppMethodBeat.o(136537);
      return;
    }
    w.a locala;
    int i;
    if ((this.otO instanceof w.a))
    {
      locala = (w.a)this.otO;
      if (this.ouj) {
        break label89;
      }
      i = 1;
      if (this.oul) {
        break label94;
      }
    }
    label89:
    label94:
    for (int j = 1;; j = 0)
    {
      if (((i & j) != 0) || (y.cI(this))) {
        bool = true;
      }
      locala.setIsHide(bool);
      AppMethodBeat.o(136537);
      return;
      i = 0;
      break;
    }
  }
  
  protected void Nr()
  {
    AppMethodBeat.i(136545);
    setCanSmileyInput(this.ouj);
    setShowDoneButton(this.oul);
    Nq();
    AppMethodBeat.o(136545);
  }
  
  protected <T extends View,  extends w.a> T Ns()
  {
    AppMethodBeat.i(136529);
    w.h localh = new w.h(getContext());
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = MMApplicationContext.getResources().getDrawable(2131235290);
    localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    localDrawable = MMApplicationContext.getResources().getDrawable(2131235289);
    localStateListDrawable.addState(new int[0], localDrawable);
    this.oui = ((ImageButton)localh.findViewById(2131307964));
    this.oui.setSelected(false);
    this.oui.setImageDrawable(localStateListDrawable);
    this.oui.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(136504);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramAnonymousView.isSelected())
        {
          w.cbO().o(w.this);
          paramAnonymousView.setSelected(false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(136504);
          return;
          w.cbO().p(w.this);
          paramAnonymousView.setSelected(true);
        }
      }
    });
    this.ouk = localh.findViewById(2131307963);
    this.ouk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(136505);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        w.this.cm(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(136505);
      }
    });
    AppMethodBeat.o(136529);
    return localh;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(230584);
    if (!this.otZ.contains(paramd)) {
      this.otZ.add(paramd);
    }
    AppMethodBeat.o(230584);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(230585);
    this.otZ.remove(paramd);
    AppMethodBeat.o(230585);
  }
  
  public final boolean b(EditText paramEditText)
  {
    if (paramEditText == this.oum)
    {
      this.oum = null;
      return true;
    }
    return false;
  }
  
  public final void bQ(boolean paramBoolean)
  {
    AppMethodBeat.i(136523);
    Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "onKeyboardStateChanged, kbShown = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      Ai(0);
      cbM();
      AppMethodBeat.o(136523);
      return;
    }
    if (isShown())
    {
      if ((this.ouj) && (1 == this.state))
      {
        cbL();
        AppMethodBeat.o(136523);
        return;
      }
      hide();
    }
    AppMethodBeat.o(136523);
  }
  
  public final boolean cbD()
  {
    AppMethodBeat.i(136520);
    boolean bool = this.oug.cbD();
    AppMethodBeat.o(136520);
    return bool;
  }
  
  public final void cbN()
  {
    AppMethodBeat.i(230590);
    if (this.otO == null)
    {
      AppMethodBeat.o(230590);
      return;
    }
    if (ouo)
    {
      db(this.otO);
      if (!otQ) {
        break label168;
      }
    }
    label168:
    for (this.otO = otP;; this.otO = Ns())
    {
      db(this.otO);
      addView(this.otO, 0);
      Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is changed in updateToolbar() because of toolbarChanged");
      ouo = false;
      if ((otQ) && (this.otO != otP))
      {
        db(this.otO);
        this.otO = otP;
        db(this.otO);
        addView(this.otO, 0);
        Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "toolbar is changed in updateToolbar() because toolbar != mComponentView");
      }
      if ((otQ) && (this.otO.getParent() != this))
      {
        db(this.otO);
        addView(this.otO, 0);
      }
      AppMethodBeat.o(230590);
      return;
    }
  }
  
  protected final void cm(boolean paramBoolean)
  {
    AppMethodBeat.i(136526);
    if ((!this.oue) && (this.oud != null))
    {
      this.oue = true;
      this.oud.cm(paramBoolean);
      this.oue = false;
    }
    AppMethodBeat.o(136526);
  }
  
  public EditText getAttachedEditText()
  {
    return this.oum;
  }
  
  public int getMinimumHeight()
  {
    AppMethodBeat.i(136525);
    if (getVisibility() != 0)
    {
      AppMethodBeat.o(136525);
      return 0;
    }
    if ((otQ) && (otP != null))
    {
      ao localao = otP.getCustomViewContainer();
      if ((localao != null) && ((localao.getRootView() instanceof ViewGroup)) && (((ViewGroup)localao.getRootView()).getChildCount() > 0) && (((ViewGroup)localao.getRootView()).getChildAt(0).getLayoutParams() != null))
      {
        i = Math.max(((ViewGroup)localao.getRootView()).getChildAt(0).getLayoutParams().height, 0);
        AppMethodBeat.o(136525);
        return i;
      }
      AppMethodBeat.o(136525);
      return 0;
    }
    int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 48);
    AppMethodBeat.o(136525);
    return i;
  }
  
  public final void hF(int paramInt)
  {
    AppMethodBeat.i(136521);
    Log.d("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] refreshHeight %d", new Object[] { Integer.valueOf(paramInt) });
    oup.c(this, paramInt);
    AppMethodBeat.o(136521);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(136547);
    if (!isShown())
    {
      AppMethodBeat.o(136547);
      return;
    }
    Ai(8);
    if ((this.oum != null) && (!this.oun.hideVKBHavingResult())) {
      aj.dg(this).hideSoftInputFromWindow(getWindowToken(), 0);
    }
    cbM();
    AppMethodBeat.o(136547);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(136539);
    super.onAttachedToWindow();
    cbI();
    AppMethodBeat.o(136539);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(136540);
    super.onDetachedFromWindow();
    Ai(8);
    if (this.context != null)
    {
      if (this.oum == null) {
        break label101;
      }
      this.oun.hideVKB(this.oum);
    }
    for (;;)
    {
      this.oug.onDestroy();
      if (this.oui != null) {
        this.oui.setOnClickListener(null);
      }
      this.ouc = null;
      removeAllViews();
      this.context = null;
      this.otZ.clear();
      cbJ();
      AppMethodBeat.o(136540);
      return;
      label101:
      this.oun.hideVKB();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136522);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getMeasuredHeight();
    if (paramInt1 != this.oua)
    {
      Log.i("MicroMsg.AppBrandSoftKeyboardPanel", "update panel height from %d to %d", new Object[] { Integer.valueOf(this.oua), Integer.valueOf(paramInt1) });
      this.oua = paramInt1;
      Iterator localIterator = this.otZ.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if ((locald != null) && (locald.getEditText() == this.oum)) {
          locald.ig(this.oua);
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
    int i = 0;
    AppMethodBeat.i(136543);
    cbN();
    this.ouj = false;
    ImageButton localImageButton;
    if (this.oui != null)
    {
      localImageButton = this.oui;
      if (!this.ouj) {
        break label52;
      }
    }
    for (;;)
    {
      localImageButton.setVisibility(i);
      Nq();
      AppMethodBeat.o(136543);
      return;
      label52:
      i = 4;
    }
  }
  
  public void setComponentView(boolean paramBoolean)
  {
    if (otQ != paramBoolean)
    {
      otQ = paramBoolean;
      ouo = true;
    }
  }
  
  public void setId(int paramInt) {}
  
  public void setOnDoneListener(c paramc)
  {
    this.oud = paramc;
  }
  
  public void setOnSmileyChosenListener(e parame)
  {
    this.ouc = parame;
  }
  
  public void setOnVisibilityChangedListener(f paramf)
  {
    this.ouf = paramf;
  }
  
  public void setShowDoneButton(boolean paramBoolean)
  {
    AppMethodBeat.i(136544);
    cbN();
    this.oul = paramBoolean;
    View localView;
    if (this.ouk != null)
    {
      localView = this.ouk;
      if (!this.oul) {
        break label52;
      }
    }
    label52:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      Nq();
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
        cm(false);
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
    Ai(paramInt);
    AppMethodBeat.o(136541);
  }
  
  public void show()
  {
    AppMethodBeat.i(136546);
    if (this.oum != null) {
      cbK();
    }
    Nr();
    if (!isShown()) {
      Ai(0);
    }
    AppMethodBeat.o(136546);
  }
  
  static abstract interface b
  {
    public abstract void c(w paramw, int paramInt);
    
    public abstract void m(w paramw);
    
    public abstract void n(w paramw);
    
    public abstract void o(w paramw);
    
    public abstract void p(w paramw);
  }
  
  public static abstract interface c
  {
    public abstract void cm(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract EditText getEditText();
    
    public abstract void ig(int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract boolean afZ(String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void hJ(int paramInt);
  }
  
  static final class g
    implements w.b
  {
    public final void c(w paramw, int paramInt)
    {
      AppMethodBeat.i(136511);
      if (y.cI(paramw))
      {
        paramw.Ai(8);
        AppMethodBeat.o(136511);
        return;
      }
      if ((w.a(paramw) == null) || (paramInt <= 0))
      {
        AppMethodBeat.o(136511);
        return;
      }
      w.b(paramw, paramInt);
      AppMethodBeat.o(136511);
    }
    
    public final void m(w paramw)
    {
      AppMethodBeat.i(136509);
      if (paramw.isShown()) {
        w.a(paramw).setVisibility(0);
      }
      w.b(paramw).ccl();
      AppMethodBeat.o(136509);
    }
    
    public final void n(w paramw)
    {
      AppMethodBeat.i(136510);
      if (y.cI(paramw))
      {
        paramw.Ai(8);
        w.g(paramw);
        AppMethodBeat.o(136510);
        return;
      }
      if (paramw.isShown()) {
        w.a(paramw).setVisibility(0);
      }
      if (!w.h(paramw))
      {
        w.b(paramw).ccl();
        AppMethodBeat.o(136510);
        return;
      }
      w.b(paramw).cck();
      AppMethodBeat.o(136510);
    }
    
    public final void o(w paramw)
    {
      AppMethodBeat.i(136512);
      w.i(paramw).showVKB();
      w.j(paramw);
      AppMethodBeat.o(136512);
    }
    
    public final void p(w paramw)
    {
      AppMethodBeat.i(136513);
      w.i(paramw).hideVKB();
      w.k(paramw);
      paramw.hF(KeyBoardUtil.getValidPanelHeight(w.l(paramw)));
      AppMethodBeat.o(136513);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w
 * JD-Core Version:    0.7.0.1
 */