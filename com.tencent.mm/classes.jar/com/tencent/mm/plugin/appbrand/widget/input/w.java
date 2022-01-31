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
import com.tencent.mm.plugin.appbrand.ui.o;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.a;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public class w
  extends LinearLayout
  implements ac, u.b
{
  private static final int VIEW_ID;
  private static final w.b jnp;
  private Context context;
  private final Runnable jna;
  private d jnb;
  private c jnc;
  private boolean jnd;
  private e jne;
  private com.tencent.mm.plugin.appbrand.widget.input.panel.e jnf;
  private View jng;
  private View jnh;
  private ImageButton jnj;
  private boolean jnk;
  private View jnl;
  private boolean jnm;
  protected EditText jnn;
  private final ad jno;
  private int state;
  
  static
  {
    AppMethodBeat.i(123815);
    VIEW_ID = 2131820561;
    jnp = new w.f((byte)0);
    AppMethodBeat.o(123815);
  }
  
  public w(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(123790);
    this.jna = new w.1(this);
    this.jnd = false;
    this.state = 2;
    this.context = paramContext;
    if ((paramContext instanceof ad))
    {
      paramContext = (ad)paramContext;
      this.jno = paramContext;
      super.setId(VIEW_ID);
      setOrientation(1);
      paramContext = vR();
      this.jnh = paramContext;
      addView(paramContext);
      paramContext = (e.b)com.tencent.luggage.a.e.q(e.b.class);
      if (paramContext != null) {
        break label199;
      }
    }
    label199:
    for (paramContext = null;; paramContext = paramContext.cV(this.context))
    {
      this.jnf = paramContext;
      if (this.jnf == null) {
        this.jnf = new e.a(this.context);
      }
      this.jng = this.jnf.getPanelView();
      this.jng.setVisibility(8);
      this.jng.setBackgroundColor(0);
      this.jnf.setOnTextOperationListener(new w.4(this));
      addView(this.jng);
      vP();
      AppMethodBeat.o(123790);
      return;
      paramContext = new com.tencent.mm.plugin.appbrand.widget.input.b.a();
      break;
    }
  }
  
  private void aRi()
  {
    AppMethodBeat.i(123793);
    vO();
    ((u)n.cJ(this).getOnLayoutListener()).jmJ = this;
    AppMethodBeat.o(123793);
  }
  
  private void aRj()
  {
    AppMethodBeat.i(123794);
    n localn = n.cJ(this);
    if (localn.getOnLayoutListener() == null)
    {
      AppMethodBeat.o(123794);
      return;
    }
    ((u)localn.getOnLayoutListener()).jmJ = null;
    AppMethodBeat.o(123794);
  }
  
  private void aRk()
  {
    AppMethodBeat.i(123796);
    aRm();
    if (this.jnn != null)
    {
      InputMethodManager localInputMethodManager = aj.cV(this.jnn);
      if (!localInputMethodManager.showSoftInput(this.jnn, 1)) {
        localInputMethodManager.showSoftInput(this.jnn, 2);
      }
      AppMethodBeat.o(123796);
      return;
    }
    this.jno.showVKB();
    AppMethodBeat.o(123796);
  }
  
  private void aRl()
  {
    AppMethodBeat.i(123797);
    jnp.n(this);
    if (this.jnj != null) {
      this.jnj.setSelected(true);
    }
    qw(1);
    AppMethodBeat.o(123797);
  }
  
  private void aRm()
  {
    AppMethodBeat.i(123798);
    jnp.m(this);
    if (this.jnj != null) {
      this.jnj.setSelected(false);
    }
    qw(0);
    AppMethodBeat.o(123798);
  }
  
  public static w cQ(View paramView)
  {
    AppMethodBeat.i(123781);
    paramView = (w)paramView.getRootView().findViewById(VIEW_ID);
    AppMethodBeat.o(123781);
    return paramView;
  }
  
  public static w cR(View paramView)
  {
    AppMethodBeat.i(123782);
    n localn = n.cJ(paramView);
    if ((localn.getOnLayoutListener() == null) || (!(localn.getOnLayoutListener() instanceof u))) {
      localn.setOnLayoutListener(new u());
    }
    Object localObject1 = cQ(paramView);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = com.tencent.mm.sdk.f.a.hr(paramView.getContext());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = paramView.getContext();
        if (localObject1 == null) {
          break label133;
        }
        if ((localObject1 instanceof ContextThemeWrapper)) {
          localObject1 = (ContextThemeWrapper)localObject1;
        }
      }
      else
      {
        label83:
        if (!(paramView instanceof w)) {
          break label138;
        }
        paramView = (w)paramView;
        label95:
        localn.cK(paramView);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(123782);
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
      label133:
      localObject1 = null;
      break label83;
      label138:
      paramView = new w((Context)localObject1);
      break label95;
      paramView = (View)localObject1;
    }
  }
  
  private void qw(int paramInt)
  {
    AppMethodBeat.i(123795);
    post(new w.5(this, paramInt, this.jnd));
    AppMethodBeat.o(123795);
  }
  
  private void setPanelHeightImpl(int paramInt)
  {
    AppMethodBeat.i(123787);
    if (this.jnf.qu(paramInt)) {
      this.jna.run();
    }
    AppMethodBeat.o(123787);
  }
  
  public final boolean aRd()
  {
    AppMethodBeat.i(123783);
    boolean bool = this.jnf.aRd();
    AppMethodBeat.o(123783);
    return bool;
  }
  
  public final boolean b(EditText paramEditText)
  {
    if (paramEditText == this.jnn)
    {
      this.jnn = null;
      return true;
    }
    return false;
  }
  
  public final void bc(boolean paramBoolean)
  {
    AppMethodBeat.i(123786);
    ab.d("MicroMsg.AppBrandSoftKeyboardPanel", "onKeyboardStateChanged, kbShown = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      qx(0);
      aRm();
      AppMethodBeat.o(123786);
      return;
    }
    if (isShown())
    {
      if ((this.jnk) && (1 == this.state))
      {
        aRl();
        AppMethodBeat.o(123786);
        return;
      }
      hide();
    }
    AppMethodBeat.o(123786);
  }
  
  protected final void fq(boolean paramBoolean)
  {
    AppMethodBeat.i(123789);
    if ((!this.jnd) && (this.jnc != null))
    {
      this.jnd = true;
      this.jnc.fq(paramBoolean);
      this.jnd = false;
    }
    AppMethodBeat.o(123789);
  }
  
  public final void fu(int paramInt)
  {
    AppMethodBeat.i(123784);
    ab.d("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] refreshHeight %d", new Object[] { Integer.valueOf(paramInt) });
    jnp.c(this, paramInt);
    AppMethodBeat.o(123784);
  }
  
  public EditText getAttachedEditText()
  {
    return this.jnn;
  }
  
  public int getMinimumHeight()
  {
    AppMethodBeat.i(123788);
    if (getVisibility() == 0)
    {
      int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 48);
      AppMethodBeat.o(123788);
      return i;
    }
    AppMethodBeat.o(123788);
    return 0;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(123809);
    if (!isShown())
    {
      AppMethodBeat.o(123809);
      return;
    }
    qx(8);
    if (!this.jno.hideVKBHavingResult()) {
      aj.cV(this).hideSoftInputFromWindow(getWindowToken(), 0);
    }
    aRm();
    AppMethodBeat.o(123809);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(123801);
    super.onAttachedToWindow();
    aRi();
    AppMethodBeat.o(123801);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(123802);
    super.onDetachedFromWindow();
    qx(8);
    if (this.context != null)
    {
      if (this.jnn == null) {
        break label92;
      }
      this.jno.hideVKB(this.jnn);
    }
    for (;;)
    {
      this.jnf.onDestroy();
      if (this.jnj != null) {
        this.jnj.setOnClickListener(null);
      }
      this.jnb = null;
      removeAllViews();
      this.context = null;
      aRj();
      AppMethodBeat.o(123802);
      return;
      label92:
      this.jno.hideVKB();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(123785);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ab.v("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] SoftKeyboardPanel onLayout measuredHeight = %d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    AppMethodBeat.o(123785);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123800);
    super.onMeasure(paramInt1, paramInt2);
    ab.d("MicroMsg.AppBrandSoftKeyboardPanel", "smileyPanelWrapper, onMeasure");
    AppMethodBeat.o(123800);
  }
  
  protected final void qv(int paramInt)
  {
    AppMethodBeat.i(156854);
    super.setId(paramInt);
    AppMethodBeat.o(156854);
  }
  
  final void qx(int paramInt)
  {
    AppMethodBeat.i(123804);
    int i = paramInt;
    if (paramInt == 0)
    {
      i = paramInt;
      if (o.cy(this)) {
        i = 8;
      }
    }
    if (getVisibility() == i)
    {
      AppMethodBeat.o(123804);
      return;
    }
    super.setVisibility(i);
    if (i == 0)
    {
      aRi();
      AppMethodBeat.o(123804);
      return;
    }
    aRj();
    AppMethodBeat.o(123804);
  }
  
  public void setCanSmileyInput(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(123805);
    this.jnk = false;
    ImageButton localImageButton;
    if (this.jnj != null)
    {
      localImageButton = this.jnj;
      if (!this.jnk) {
        break label48;
      }
    }
    for (;;)
    {
      localImageButton.setVisibility(i);
      vP();
      AppMethodBeat.o(123805);
      return;
      label48:
      i = 4;
    }
  }
  
  public void setId(int paramInt) {}
  
  public void setOnDoneListener(c paramc)
  {
    this.jnc = paramc;
  }
  
  public void setOnSmileyChosenListener(d paramd)
  {
    this.jnb = paramd;
  }
  
  public void setOnVisibilityChangedListener(e parame)
  {
    this.jne = parame;
  }
  
  public void setShowDoneButton(boolean paramBoolean)
  {
    AppMethodBeat.i(123806);
    this.jnm = paramBoolean;
    View localView;
    if (this.jnl != null)
    {
      localView = this.jnl;
      if (!this.jnm) {
        break label48;
      }
    }
    label48:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      vP();
      AppMethodBeat.o(123806);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(123803);
    if (paramInt == 8)
    {
      if (getVisibility() != paramInt) {
        fq(false);
      }
      hide();
      AppMethodBeat.o(123803);
      return;
    }
    if (paramInt == 0)
    {
      show();
      AppMethodBeat.o(123803);
      return;
    }
    qx(paramInt);
    AppMethodBeat.o(123803);
  }
  
  public void show()
  {
    AppMethodBeat.i(123808);
    aRk();
    vQ();
    if (!isShown()) {
      qx(0);
    }
    AppMethodBeat.o(123808);
  }
  
  protected void vO()
  {
    AppMethodBeat.i(156301);
    cR(this);
    AppMethodBeat.o(156301);
  }
  
  protected void vP()
  {
    boolean bool = false;
    AppMethodBeat.i(123799);
    if (this.jnh == null)
    {
      AppMethodBeat.o(123799);
      return;
    }
    w.a locala = (w.a)this.jnh;
    int i;
    if (!this.jnk)
    {
      i = 1;
      if (this.jnm) {
        break label84;
      }
    }
    label84:
    for (int j = 1;; j = 0)
    {
      if (((i & j) != 0) || (o.cy(this))) {
        bool = true;
      }
      locala.setIsHide(bool);
      AppMethodBeat.o(123799);
      return;
      i = 0;
      break;
    }
  }
  
  protected void vQ()
  {
    AppMethodBeat.i(123807);
    setCanSmileyInput(this.jnk);
    setShowDoneButton(this.jnm);
    vP();
    AppMethodBeat.o(123807);
  }
  
  protected <T extends View,  extends w.a> T vR()
  {
    AppMethodBeat.i(123792);
    w.g localg = new w.g(getContext());
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = ah.getResources().getDrawable(2130840576);
    localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    localDrawable = ah.getResources().getDrawable(2130840575);
    localStateListDrawable.addState(new int[0], localDrawable);
    this.jnj = ((ImageButton)localg.findViewById(2131821548));
    this.jnj.setSelected(false);
    this.jnj.setImageDrawable(localStateListDrawable);
    this.jnj.setOnClickListener(new w.2(this));
    this.jnl = localg.findViewById(2131821547);
    this.jnl.setOnClickListener(new w.3(this));
    AppMethodBeat.o(123792);
    return localg;
  }
  
  public static abstract interface c
  {
    public abstract void fq(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract boolean FO(String paramString);
  }
  
  public static abstract interface e
  {
    public abstract void fq(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w
 * JD-Core Version:    0.7.0.1
 */