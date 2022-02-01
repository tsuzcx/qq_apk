package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.a;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.b;
import com.tencent.mm.plugin.appbrand.widget.input.panel.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public class w
  extends LinearLayout
  implements ac, u.b
{
  private static final int VIEW_ID;
  private static final w.b nkJ;
  private Context context;
  private com.tencent.mm.plugin.appbrand.widget.input.panel.e nkA;
  private View nkB;
  private View nkC;
  private ImageButton nkD;
  private boolean nkE;
  private View nkF;
  private boolean nkG;
  protected EditText nkH;
  private final ad nkI;
  private final Runnable nkv;
  private d nkw;
  private w.c nkx;
  private boolean nky;
  private e nkz;
  private int state;
  
  static
  {
    AppMethodBeat.i(136553);
    VIEW_ID = 2131296762;
    nkJ = new f((byte)0);
    AppMethodBeat.o(136553);
  }
  
  public w(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(136527);
    this.nkv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136503);
        if ((w.a(w.this) == null) || (!android.support.v4.view.t.aC(w.a(w.this))))
        {
          AppMethodBeat.o(136503);
          return;
        }
        if (w.b(w.this).bFs())
        {
          ae.d("MicroMsg.AppBrandSoftKeyboardPanel", "postMeasure inLayout, skip");
          w.this.post(this);
          AppMethodBeat.o(136503);
          return;
        }
        w.c(w.this);
        AppMethodBeat.o(136503);
      }
    };
    this.nky = false;
    this.state = 2;
    this.context = paramContext;
    if ((paramContext instanceof ad))
    {
      paramContext = (ad)paramContext;
      this.nkI = paramContext;
      super.setId(VIEW_ID);
      setOrientation(1);
      paramContext = DW();
      this.nkC = paramContext;
      addView(paramContext);
      paramContext = (e.b)com.tencent.luggage.a.e.K(e.b.class);
      if (paramContext != null) {
        break label199;
      }
    }
    label199:
    for (paramContext = null;; paramContext = paramContext.dH(this.context))
    {
      this.nkA = paramContext;
      if (this.nkA == null) {
        this.nkA = new e.a(this.context);
      }
      this.nkB = this.nkA.getPanelView();
      this.nkB.setVisibility(8);
      this.nkB.setBackgroundColor(0);
      this.nkA.setOnTextOperationListener(new f()
      {
        public final void apc()
        {
          AppMethodBeat.i(136507);
          if (w.d(w.this) != null) {
            w.d(w.this).Wd("[DELETE_EMOTION]");
          }
          AppMethodBeat.o(136507);
        }
        
        public final void append(String paramAnonymousString)
        {
          AppMethodBeat.i(136506);
          if (w.d(w.this) != null) {
            w.d(w.this).Wd(paramAnonymousString);
          }
          AppMethodBeat.o(136506);
        }
      });
      addView(this.nkB);
      DU();
      AppMethodBeat.o(136527);
      return;
      paramContext = new com.tencent.mm.plugin.appbrand.widget.input.b.a();
      break;
    }
  }
  
  private void bFt()
  {
    AppMethodBeat.i(136531);
    DT();
    ((u)n.dd(this).getOnLayoutListener()).nke = this;
    AppMethodBeat.o(136531);
  }
  
  private void bFu()
  {
    AppMethodBeat.i(136532);
    n localn = n.dd(this);
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
    ((u)localn.getOnLayoutListener()).nke = null;
    AppMethodBeat.o(136532);
  }
  
  private void bFv()
  {
    AppMethodBeat.i(136534);
    bFx();
    if (this.nkH != null)
    {
      InputMethodManager localInputMethodManager = aj.dp(this.nkH);
      if (!localInputMethodManager.showSoftInput(this.nkH, 1)) {
        localInputMethodManager.showSoftInput(this.nkH, 2);
      }
      AppMethodBeat.o(136534);
      return;
    }
    this.nkI.showVKB();
    AppMethodBeat.o(136534);
  }
  
  private void bFw()
  {
    AppMethodBeat.i(136535);
    nkJ.n(this);
    if (this.nkD != null) {
      this.nkD.setSelected(true);
    }
    wz(1);
    AppMethodBeat.o(136535);
  }
  
  private void bFx()
  {
    AppMethodBeat.i(136536);
    nkJ.m(this);
    if (this.nkD != null) {
      this.nkD.setSelected(false);
    }
    wz(0);
    AppMethodBeat.o(136536);
  }
  
  public static w dk(View paramView)
  {
    AppMethodBeat.i(136518);
    paramView = (w)paramView.getRootView().findViewById(VIEW_ID);
    AppMethodBeat.o(136518);
    return paramView;
  }
  
  public static w dl(View paramView)
  {
    AppMethodBeat.i(136519);
    n localn = n.dd(paramView);
    if (localn == null)
    {
      AppMethodBeat.o(136519);
      return null;
    }
    if ((localn.getOnLayoutListener() == null) || (!(localn.getOnLayoutListener() instanceof u))) {
      localn.setOnLayoutListener(new u());
    }
    Object localObject1 = dk(paramView);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = com.tencent.mm.sdk.f.a.jw(paramView.getContext());
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
        localn.de(paramView);
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
    if (this.nkA.wx(paramInt)) {
      this.nkv.run();
    }
    AppMethodBeat.o(136524);
  }
  
  private void wz(final int paramInt)
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
        if ((i != w.e(w.this)) && (!this.nkM)) {
          w.f(w.this).gv(w.e(w.this));
        }
        AppMethodBeat.o(136508);
      }
    });
    AppMethodBeat.o(136533);
  }
  
  protected void DT()
  {
    AppMethodBeat.i(136530);
    dl(this);
    AppMethodBeat.o(136530);
  }
  
  protected void DU()
  {
    boolean bool = false;
    AppMethodBeat.i(136537);
    if (this.nkC == null)
    {
      AppMethodBeat.o(136537);
      return;
    }
    w.a locala = (w.a)this.nkC;
    int i;
    if (!this.nkE)
    {
      i = 1;
      if (this.nkG) {
        break label84;
      }
    }
    label84:
    for (int j = 1;; j = 0)
    {
      if (((i & j) != 0) || (com.tencent.mm.plugin.appbrand.ui.t.cP(this))) {
        bool = true;
      }
      locala.setIsHide(bool);
      AppMethodBeat.o(136537);
      return;
      i = 0;
      break;
    }
  }
  
  protected void DV()
  {
    AppMethodBeat.i(136545);
    setCanSmileyInput(this.nkE);
    setShowDoneButton(this.nkG);
    DU();
    AppMethodBeat.o(136545);
  }
  
  protected <T extends View,  extends w.a> T DW()
  {
    AppMethodBeat.i(136529);
    w.g localg = new w.g(getContext());
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = ak.getResources().getDrawable(2131234370);
    localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    localDrawable = ak.getResources().getDrawable(2131234369);
    localStateListDrawable.addState(new int[0], localDrawable);
    this.nkD = ((ImageButton)localg.findViewById(2131304878));
    this.nkD.setSelected(false);
    this.nkD.setImageDrawable(localStateListDrawable);
    this.nkD.setOnClickListener(new w.2(this));
    this.nkF = localg.findViewById(2131304877);
    this.nkF.setOnClickListener(new w.3(this));
    AppMethodBeat.o(136529);
    return localg;
  }
  
  public final boolean b(EditText paramEditText)
  {
    if (paramEditText == this.nkH)
    {
      this.nkH = null;
      return true;
    }
    return false;
  }
  
  public final boolean bFo()
  {
    AppMethodBeat.i(136520);
    boolean bool = this.nkA.bFo();
    AppMethodBeat.o(136520);
    return bool;
  }
  
  protected final void bM(boolean paramBoolean)
  {
    AppMethodBeat.i(136526);
    if ((!this.nky) && (this.nkx != null))
    {
      this.nky = true;
      this.nkx.bM(paramBoolean);
      this.nky = false;
    }
    AppMethodBeat.o(136526);
  }
  
  public final void bu(boolean paramBoolean)
  {
    AppMethodBeat.i(136523);
    ae.d("MicroMsg.AppBrandSoftKeyboardPanel", "onKeyboardStateChanged, kbShown = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      wA(0);
      bFx();
      AppMethodBeat.o(136523);
      return;
    }
    if (isShown())
    {
      if ((this.nkE) && (1 == this.state))
      {
        bFw();
        AppMethodBeat.o(136523);
        return;
      }
      hide();
    }
    AppMethodBeat.o(136523);
  }
  
  public final void gB(int paramInt)
  {
    AppMethodBeat.i(136521);
    ae.d("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] refreshHeight %d", new Object[] { Integer.valueOf(paramInt) });
    nkJ.c(this, paramInt);
    AppMethodBeat.o(136521);
  }
  
  public EditText getAttachedEditText()
  {
    return this.nkH;
  }
  
  public int getMinimumHeight()
  {
    AppMethodBeat.i(136525);
    if (getVisibility() == 0)
    {
      int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 48);
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
    wA(8);
    if ((this.nkH != null) && (!this.nkI.hideVKBHavingResult())) {
      aj.dp(this).hideSoftInputFromWindow(getWindowToken(), 0);
    }
    bFx();
    AppMethodBeat.o(136547);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(136539);
    super.onAttachedToWindow();
    bFt();
    AppMethodBeat.o(136539);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(136540);
    super.onDetachedFromWindow();
    wA(8);
    if (this.context != null)
    {
      if (this.nkH == null) {
        break label92;
      }
      this.nkI.hideVKB(this.nkH);
    }
    for (;;)
    {
      this.nkA.onDestroy();
      if (this.nkD != null) {
        this.nkD.setOnClickListener(null);
      }
      this.nkw = null;
      removeAllViews();
      this.context = null;
      bFu();
      AppMethodBeat.o(136540);
      return;
      label92:
      this.nkI.hideVKB();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136522);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ae.v("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] SoftKeyboardPanel onLayout measuredHeight = %d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    AppMethodBeat.o(136522);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136538);
    super.onMeasure(paramInt1, paramInt2);
    ae.d("MicroMsg.AppBrandSoftKeyboardPanel", "smileyPanelWrapper, onMeasure");
    AppMethodBeat.o(136538);
  }
  
  public void setCanSmileyInput(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(136543);
    this.nkE = false;
    ImageButton localImageButton;
    if (this.nkD != null)
    {
      localImageButton = this.nkD;
      if (!this.nkE) {
        break label48;
      }
    }
    for (;;)
    {
      localImageButton.setVisibility(i);
      DU();
      AppMethodBeat.o(136543);
      return;
      label48:
      i = 4;
    }
  }
  
  public void setId(int paramInt) {}
  
  public void setOnDoneListener(w.c paramc)
  {
    this.nkx = paramc;
  }
  
  public void setOnSmileyChosenListener(d paramd)
  {
    this.nkw = paramd;
  }
  
  public void setOnVisibilityChangedListener(e parame)
  {
    this.nkz = parame;
  }
  
  public void setShowDoneButton(boolean paramBoolean)
  {
    AppMethodBeat.i(136544);
    this.nkG = paramBoolean;
    View localView;
    if (this.nkF != null)
    {
      localView = this.nkF;
      if (!this.nkG) {
        break label48;
      }
    }
    label48:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      DU();
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
    wA(paramInt);
    AppMethodBeat.o(136541);
  }
  
  public void show()
  {
    AppMethodBeat.i(136546);
    if (this.nkH != null) {
      bFv();
    }
    DV();
    if (!isShown()) {
      wA(0);
    }
    AppMethodBeat.o(136546);
  }
  
  final void wA(int paramInt)
  {
    AppMethodBeat.i(136542);
    int i = paramInt;
    if (paramInt == 0)
    {
      i = paramInt;
      if (com.tencent.mm.plugin.appbrand.ui.t.cP(this)) {
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
      bFt();
      AppMethodBeat.o(136542);
      return;
    }
    bFu();
    AppMethodBeat.o(136542);
  }
  
  protected final void wy(int paramInt)
  {
    AppMethodBeat.i(224444);
    super.setId(paramInt);
    AppMethodBeat.o(224444);
  }
  
  public static abstract interface d
  {
    public abstract boolean Wd(String paramString);
  }
  
  public static abstract interface e
  {
    public abstract void gv(int paramInt);
  }
  
  static final class f
    implements w.b
  {
    public final void c(w paramw, int paramInt)
    {
      AppMethodBeat.i(136511);
      if (com.tencent.mm.plugin.appbrand.ui.t.cP(paramw))
      {
        paramw.wA(8);
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
      w.b(paramw).bFV();
      AppMethodBeat.o(136509);
    }
    
    public final void n(w paramw)
    {
      AppMethodBeat.i(136510);
      if (com.tencent.mm.plugin.appbrand.ui.t.cP(paramw))
      {
        paramw.wA(8);
        w.g(paramw);
        AppMethodBeat.o(136510);
        return;
      }
      if (paramw.isShown()) {
        w.a(paramw).setVisibility(0);
      }
      if (!w.h(paramw))
      {
        w.b(paramw).bFV();
        AppMethodBeat.o(136510);
        return;
      }
      w.b(paramw).bFU();
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
      paramw.gB(aa.iN(w.l(paramw)));
      AppMethodBeat.o(136513);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w
 * JD-Core Version:    0.7.0.1
 */