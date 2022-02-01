package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.t;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.a;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.b;
import com.tencent.mm.plugin.appbrand.widget.input.panel.f;
import com.tencent.mm.sdk.platformtools.z;

public class w
  extends LinearLayout
  implements ac, u.b
{
  private static final int VIEW_ID;
  private static final b mde;
  private Context context;
  private final Runnable mcQ;
  private d mcR;
  private c mcS;
  private boolean mcT;
  private e mcU;
  private com.tencent.mm.plugin.appbrand.widget.input.panel.e mcV;
  private View mcW;
  private View mcX;
  private ImageButton mcY;
  private boolean mcZ;
  private View mda;
  private boolean mdb;
  protected EditText mdc;
  private final ad mdd;
  private int state;
  
  static
  {
    AppMethodBeat.i(136553);
    VIEW_ID = 2131296762;
    mde = new f((byte)0);
    AppMethodBeat.o(136553);
  }
  
  public w(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(136527);
    this.mcQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136503);
        if ((w.a(w.this) == null) || (!t.aC(w.a(w.this))))
        {
          AppMethodBeat.o(136503);
          return;
        }
        if (w.b(w.this).bty())
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandSoftKeyboardPanel", "postMeasure inLayout, skip");
          w.this.post(this);
          AppMethodBeat.o(136503);
          return;
        }
        w.c(w.this);
        AppMethodBeat.o(136503);
      }
    };
    this.mcT = false;
    this.state = 2;
    this.context = paramContext;
    if ((paramContext instanceof ad))
    {
      paramContext = (ad)paramContext;
      this.mdd = paramContext;
      super.setId(VIEW_ID);
      setOrientation(1);
      paramContext = CQ();
      this.mcX = paramContext;
      addView(paramContext);
      paramContext = (e.b)com.tencent.luggage.a.e.K(e.b.class);
      if (paramContext != null) {
        break label199;
      }
    }
    label199:
    for (paramContext = null;; paramContext = paramContext.dw(this.context))
    {
      this.mcV = paramContext;
      if (this.mcV == null) {
        this.mcV = new e.a(this.context);
      }
      this.mcW = this.mcV.getPanelView();
      this.mcW.setVisibility(8);
      this.mcW.setBackgroundColor(0);
      this.mcV.setOnTextOperationListener(new f()
      {
        public final void append(String paramAnonymousString)
        {
          AppMethodBeat.i(136506);
          if (w.d(w.this) != null) {
            w.d(w.this).NL(paramAnonymousString);
          }
          AppMethodBeat.o(136506);
        }
        
        public final void btF()
        {
          AppMethodBeat.i(136507);
          if (w.d(w.this) != null) {
            w.d(w.this).NL("[DELETE_EMOTION]");
          }
          AppMethodBeat.o(136507);
        }
      });
      addView(this.mcW);
      CO();
      AppMethodBeat.o(136527);
      return;
      paramContext = new com.tencent.mm.plugin.appbrand.widget.input.b.a();
      break;
    }
  }
  
  private void btA()
  {
    AppMethodBeat.i(136532);
    n localn = n.cZ(this);
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
    ((u)localn.getOnLayoutListener()).mcz = null;
    AppMethodBeat.o(136532);
  }
  
  private void btB()
  {
    AppMethodBeat.i(136534);
    btD();
    if (this.mdc != null)
    {
      InputMethodManager localInputMethodManager = aj.dl(this.mdc);
      if (!localInputMethodManager.showSoftInput(this.mdc, 1)) {
        localInputMethodManager.showSoftInput(this.mdc, 2);
      }
      AppMethodBeat.o(136534);
      return;
    }
    this.mdd.showVKB();
    AppMethodBeat.o(136534);
  }
  
  private void btC()
  {
    AppMethodBeat.i(136535);
    mde.n(this);
    if (this.mcY != null) {
      this.mcY.setSelected(true);
    }
    uY(1);
    AppMethodBeat.o(136535);
  }
  
  private void btD()
  {
    AppMethodBeat.i(136536);
    mde.m(this);
    if (this.mcY != null) {
      this.mcY.setSelected(false);
    }
    uY(0);
    AppMethodBeat.o(136536);
  }
  
  private void btz()
  {
    AppMethodBeat.i(136531);
    CN();
    ((u)n.cZ(this).getOnLayoutListener()).mcz = this;
    AppMethodBeat.o(136531);
  }
  
  public static w dg(View paramView)
  {
    AppMethodBeat.i(136518);
    paramView = (w)paramView.getRootView().findViewById(VIEW_ID);
    AppMethodBeat.o(136518);
    return paramView;
  }
  
  public static w dh(View paramView)
  {
    AppMethodBeat.i(136519);
    n localn = n.cZ(paramView);
    if (localn == null)
    {
      AppMethodBeat.o(136519);
      return null;
    }
    if ((localn.getOnLayoutListener() == null) || (!(localn.getOnLayoutListener() instanceof u))) {
      localn.setOnLayoutListener(new u());
    }
    Object localObject1 = dg(paramView);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = com.tencent.mm.sdk.f.a.iV(paramView.getContext());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = paramView.getContext();
        if (localObject1 == null) {
          break label145;
        }
        if ((localObject1 instanceof ContextThemeWrapper)) {
          localObject1 = (ContextThemeWrapper)localObject1;
        }
      }
      else
      {
        label95:
        if (!(paramView instanceof w)) {
          break label150;
        }
        paramView = (w)paramView;
        label107:
        localn.da(paramView);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(136519);
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
      label145:
      localObject1 = null;
      break label95;
      label150:
      paramView = new w((Context)localObject1);
      break label107;
      paramView = (View)localObject1;
    }
  }
  
  private void setPanelHeightImpl(int paramInt)
  {
    AppMethodBeat.i(136524);
    if (this.mcV.uW(paramInt)) {
      this.mcQ.run();
    }
    AppMethodBeat.o(136524);
  }
  
  private void uY(final int paramInt)
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
        if ((i != w.e(w.this)) && (!this.mdh)) {
          w.f(w.this).gI(w.e(w.this));
        }
        AppMethodBeat.o(136508);
      }
    });
    AppMethodBeat.o(136533);
  }
  
  protected void CN()
  {
    AppMethodBeat.i(136530);
    dh(this);
    AppMethodBeat.o(136530);
  }
  
  protected void CO()
  {
    boolean bool = false;
    AppMethodBeat.i(136537);
    if (this.mcX == null)
    {
      AppMethodBeat.o(136537);
      return;
    }
    w.a locala = (w.a)this.mcX;
    int i;
    if (!this.mcZ)
    {
      i = 1;
      if (this.mdb) {
        break label84;
      }
    }
    label84:
    for (int j = 1;; j = 0)
    {
      if (((i & j) != 0) || (r.cK(this))) {
        bool = true;
      }
      locala.setIsHide(bool);
      AppMethodBeat.o(136537);
      return;
      i = 0;
      break;
    }
  }
  
  protected void CP()
  {
    AppMethodBeat.i(136545);
    setCanSmileyInput(this.mcZ);
    setShowDoneButton(this.mdb);
    CO();
    AppMethodBeat.o(136545);
  }
  
  protected <T extends View,  extends w.a> T CQ()
  {
    AppMethodBeat.i(136529);
    w.g localg = new w.g(getContext());
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = com.tencent.mm.sdk.platformtools.aj.getResources().getDrawable(2131234370);
    localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    localDrawable = com.tencent.mm.sdk.platformtools.aj.getResources().getDrawable(2131234369);
    localStateListDrawable.addState(new int[0], localDrawable);
    this.mcY = ((ImageButton)localg.findViewById(2131304878));
    this.mcY.setSelected(false);
    this.mcY.setImageDrawable(localStateListDrawable);
    this.mcY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(136504);
        if (paramAnonymousView.isSelected())
        {
          w.btE().o(w.this);
          paramAnonymousView.setSelected(false);
          AppMethodBeat.o(136504);
          return;
        }
        w.btE().p(w.this);
        paramAnonymousView.setSelected(true);
        AppMethodBeat.o(136504);
      }
    });
    this.mda = localg.findViewById(2131304877);
    this.mda.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(136505);
        w.this.bM(true);
        AppMethodBeat.o(136505);
      }
    });
    AppMethodBeat.o(136529);
    return localg;
  }
  
  public final boolean b(EditText paramEditText)
  {
    if (paramEditText == this.mdc)
    {
      this.mdc = null;
      return true;
    }
    return false;
  }
  
  protected final void bM(boolean paramBoolean)
  {
    AppMethodBeat.i(136526);
    if ((!this.mcT) && (this.mcS != null))
    {
      this.mcT = true;
      this.mcS.bM(paramBoolean);
      this.mcT = false;
    }
    AppMethodBeat.o(136526);
  }
  
  public final boolean btu()
  {
    AppMethodBeat.i(136520);
    boolean bool = this.mcV.btu();
    AppMethodBeat.o(136520);
    return bool;
  }
  
  public final void bu(boolean paramBoolean)
  {
    AppMethodBeat.i(136523);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandSoftKeyboardPanel", "onKeyboardStateChanged, kbShown = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      uZ(0);
      btD();
      AppMethodBeat.o(136523);
      return;
    }
    if (isShown())
    {
      if ((this.mcZ) && (1 == this.state))
      {
        btC();
        AppMethodBeat.o(136523);
        return;
      }
      hide();
    }
    AppMethodBeat.o(136523);
  }
  
  public final void gM(int paramInt)
  {
    AppMethodBeat.i(136521);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] refreshHeight %d", new Object[] { Integer.valueOf(paramInt) });
    mde.c(this, paramInt);
    AppMethodBeat.o(136521);
  }
  
  public EditText getAttachedEditText()
  {
    return this.mdc;
  }
  
  public int getMinimumHeight()
  {
    AppMethodBeat.i(136525);
    if (getVisibility() == 0)
    {
      int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 48);
      AppMethodBeat.o(136525);
      return i;
    }
    AppMethodBeat.o(136525);
    return 0;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(136547);
    if (!isShown())
    {
      AppMethodBeat.o(136547);
      return;
    }
    uZ(8);
    if ((this.mdc != null) && (!this.mdd.hideVKBHavingResult())) {
      aj.dl(this).hideSoftInputFromWindow(getWindowToken(), 0);
    }
    btD();
    AppMethodBeat.o(136547);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(136539);
    super.onAttachedToWindow();
    btz();
    AppMethodBeat.o(136539);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(136540);
    super.onDetachedFromWindow();
    uZ(8);
    if (this.context != null)
    {
      if (this.mdc == null) {
        break label92;
      }
      this.mdd.hideVKB(this.mdc);
    }
    for (;;)
    {
      this.mcV.onDestroy();
      if (this.mcY != null) {
        this.mcY.setOnClickListener(null);
      }
      this.mcR = null;
      removeAllViews();
      this.context = null;
      btA();
      AppMethodBeat.o(136540);
      return;
      label92:
      this.mdd.hideVKB();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136522);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] SoftKeyboardPanel onLayout measuredHeight = %d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    AppMethodBeat.o(136522);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136538);
    super.onMeasure(paramInt1, paramInt2);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandSoftKeyboardPanel", "smileyPanelWrapper, onMeasure");
    AppMethodBeat.o(136538);
  }
  
  public void setCanSmileyInput(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(136543);
    this.mcZ = false;
    ImageButton localImageButton;
    if (this.mcY != null)
    {
      localImageButton = this.mcY;
      if (!this.mcZ) {
        break label48;
      }
    }
    for (;;)
    {
      localImageButton.setVisibility(i);
      CO();
      AppMethodBeat.o(136543);
      return;
      label48:
      i = 4;
    }
  }
  
  public void setId(int paramInt) {}
  
  public void setOnDoneListener(c paramc)
  {
    this.mcS = paramc;
  }
  
  public void setOnSmileyChosenListener(d paramd)
  {
    this.mcR = paramd;
  }
  
  public void setOnVisibilityChangedListener(e parame)
  {
    this.mcU = parame;
  }
  
  public void setShowDoneButton(boolean paramBoolean)
  {
    AppMethodBeat.i(136544);
    this.mdb = paramBoolean;
    View localView;
    if (this.mda != null)
    {
      localView = this.mda;
      if (!this.mdb) {
        break label48;
      }
    }
    label48:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      CO();
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
        bM(false);
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
    uZ(paramInt);
    AppMethodBeat.o(136541);
  }
  
  public void show()
  {
    AppMethodBeat.i(136546);
    if (this.mdc != null) {
      btB();
    }
    CP();
    if (!isShown()) {
      uZ(0);
    }
    AppMethodBeat.o(136546);
  }
  
  protected final void uX(int paramInt)
  {
    AppMethodBeat.i(205065);
    super.setId(paramInt);
    AppMethodBeat.o(205065);
  }
  
  final void uZ(int paramInt)
  {
    AppMethodBeat.i(136542);
    int i = paramInt;
    if (paramInt == 0)
    {
      i = paramInt;
      if (r.cK(this)) {
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
      btz();
      AppMethodBeat.o(136542);
      return;
    }
    btA();
    AppMethodBeat.o(136542);
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
    public abstract void bM(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract boolean NL(String paramString);
  }
  
  public static abstract interface e
  {
    public abstract void gI(int paramInt);
  }
  
  static final class f
    implements w.b
  {
    public final void c(w paramw, int paramInt)
    {
      AppMethodBeat.i(136511);
      if (r.cK(paramw))
      {
        paramw.uZ(8);
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
      w.b(paramw).buc();
      AppMethodBeat.o(136509);
    }
    
    public final void n(w paramw)
    {
      AppMethodBeat.i(136510);
      if (r.cK(paramw))
      {
        paramw.uZ(8);
        w.g(paramw);
        AppMethodBeat.o(136510);
        return;
      }
      if (paramw.isShown()) {
        w.a(paramw).setVisibility(0);
      }
      if (!w.h(paramw))
      {
        w.b(paramw).buc();
        AppMethodBeat.o(136510);
        return;
      }
      w.b(paramw).bub();
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
      paramw.gM(z.in(w.l(paramw)));
      AppMethodBeat.o(136513);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w
 * JD-Core Version:    0.7.0.1
 */