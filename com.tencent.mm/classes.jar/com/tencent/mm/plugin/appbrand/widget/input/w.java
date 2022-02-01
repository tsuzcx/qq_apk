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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ui.s;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.a;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.b;
import com.tencent.mm.plugin.appbrand.widget.input.panel.f;
import com.tencent.mm.sdk.platformtools.z;

public class w
  extends LinearLayout
  implements ac, u.b
{
  private static final int VIEW_ID;
  private static final b nfB;
  private Context context;
  private final ad nfA;
  private final Runnable nfn;
  private d nfo;
  private c nfp;
  private boolean nfq;
  private e nfr;
  private com.tencent.mm.plugin.appbrand.widget.input.panel.e nfs;
  private View nft;
  private View nfu;
  private ImageButton nfv;
  private boolean nfw;
  private View nfx;
  private boolean nfy;
  protected EditText nfz;
  private int state;
  
  static
  {
    AppMethodBeat.i(136553);
    VIEW_ID = 2131296762;
    nfB = new f((byte)0);
    AppMethodBeat.o(136553);
  }
  
  public w(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(136527);
    this.nfn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136503);
        if ((w.a(w.this) == null) || (!t.aC(w.a(w.this))))
        {
          AppMethodBeat.o(136503);
          return;
        }
        if (w.b(w.this).bEA())
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
    this.nfq = false;
    this.state = 2;
    this.context = paramContext;
    if ((paramContext instanceof ad))
    {
      paramContext = (ad)paramContext;
      this.nfA = paramContext;
      super.setId(VIEW_ID);
      setOrientation(1);
      paramContext = DT();
      this.nfu = paramContext;
      addView(paramContext);
      paramContext = (e.b)com.tencent.luggage.a.e.K(e.b.class);
      if (paramContext != null) {
        break label199;
      }
    }
    label199:
    for (paramContext = null;; paramContext = paramContext.dD(this.context))
    {
      this.nfs = paramContext;
      if (this.nfs == null) {
        this.nfs = new e.a(this.context);
      }
      this.nft = this.nfs.getPanelView();
      this.nft.setVisibility(8);
      this.nft.setBackgroundColor(0);
      this.nfs.setOnTextOperationListener(new f()
      {
        public final void aoO()
        {
          AppMethodBeat.i(136507);
          if (w.d(w.this) != null) {
            w.d(w.this).Vr("[DELETE_EMOTION]");
          }
          AppMethodBeat.o(136507);
        }
        
        public final void append(String paramAnonymousString)
        {
          AppMethodBeat.i(136506);
          if (w.d(w.this) != null) {
            w.d(w.this).Vr(paramAnonymousString);
          }
          AppMethodBeat.o(136506);
        }
      });
      addView(this.nft);
      DR();
      AppMethodBeat.o(136527);
      return;
      paramContext = new com.tencent.mm.plugin.appbrand.widget.input.b.a();
      break;
    }
  }
  
  private void bEB()
  {
    AppMethodBeat.i(136531);
    DQ();
    ((u)n.dd(this).getOnLayoutListener()).neW = this;
    AppMethodBeat.o(136531);
  }
  
  private void bEC()
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
    ((u)localn.getOnLayoutListener()).neW = null;
    AppMethodBeat.o(136532);
  }
  
  private void bED()
  {
    AppMethodBeat.i(136534);
    bEF();
    if (this.nfz != null)
    {
      InputMethodManager localInputMethodManager = aj.dp(this.nfz);
      if (!localInputMethodManager.showSoftInput(this.nfz, 1)) {
        localInputMethodManager.showSoftInput(this.nfz, 2);
      }
      AppMethodBeat.o(136534);
      return;
    }
    this.nfA.showVKB();
    AppMethodBeat.o(136534);
  }
  
  private void bEE()
  {
    AppMethodBeat.i(136535);
    nfB.n(this);
    if (this.nfv != null) {
      this.nfv.setSelected(true);
    }
    wu(1);
    AppMethodBeat.o(136535);
  }
  
  private void bEF()
  {
    AppMethodBeat.i(136536);
    nfB.m(this);
    if (this.nfv != null) {
      this.nfv.setSelected(false);
    }
    wu(0);
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
      localObject2 = com.tencent.mm.sdk.f.a.jq(paramView.getContext());
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
    if (this.nfs.ws(paramInt)) {
      this.nfn.run();
    }
    AppMethodBeat.o(136524);
  }
  
  private void wu(final int paramInt)
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
        if ((i != w.e(w.this)) && (!this.nfE)) {
          w.f(w.this).gv(w.e(w.this));
        }
        AppMethodBeat.o(136508);
      }
    });
    AppMethodBeat.o(136533);
  }
  
  protected void DQ()
  {
    AppMethodBeat.i(136530);
    dl(this);
    AppMethodBeat.o(136530);
  }
  
  protected void DR()
  {
    boolean bool = false;
    AppMethodBeat.i(136537);
    if (this.nfu == null)
    {
      AppMethodBeat.o(136537);
      return;
    }
    w.a locala = (w.a)this.nfu;
    int i;
    if (!this.nfw)
    {
      i = 1;
      if (this.nfy) {
        break label84;
      }
    }
    label84:
    for (int j = 1;; j = 0)
    {
      if (((i & j) != 0) || (s.cO(this))) {
        bool = true;
      }
      locala.setIsHide(bool);
      AppMethodBeat.o(136537);
      return;
      i = 0;
      break;
    }
  }
  
  protected void DS()
  {
    AppMethodBeat.i(136545);
    setCanSmileyInput(this.nfw);
    setShowDoneButton(this.nfy);
    DR();
    AppMethodBeat.o(136545);
  }
  
  protected <T extends View,  extends w.a> T DT()
  {
    AppMethodBeat.i(136529);
    w.g localg = new w.g(getContext());
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = com.tencent.mm.sdk.platformtools.aj.getResources().getDrawable(2131234370);
    localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    localDrawable = com.tencent.mm.sdk.platformtools.aj.getResources().getDrawable(2131234369);
    localStateListDrawable.addState(new int[0], localDrawable);
    this.nfv = ((ImageButton)localg.findViewById(2131304878));
    this.nfv.setSelected(false);
    this.nfv.setImageDrawable(localStateListDrawable);
    this.nfv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(136504);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (paramAnonymousView.isSelected())
        {
          w.bEG().o(w.this);
          paramAnonymousView.setSelected(false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandSoftKeyboardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(136504);
          return;
          w.bEG().p(w.this);
          paramAnonymousView.setSelected(true);
        }
      }
    });
    this.nfx = localg.findViewById(2131304877);
    this.nfx.setOnClickListener(new w.3(this));
    AppMethodBeat.o(136529);
    return localg;
  }
  
  public final boolean b(EditText paramEditText)
  {
    if (paramEditText == this.nfz)
    {
      this.nfz = null;
      return true;
    }
    return false;
  }
  
  public final boolean bEw()
  {
    AppMethodBeat.i(136520);
    boolean bool = this.nfs.bEw();
    AppMethodBeat.o(136520);
    return bool;
  }
  
  protected final void bM(boolean paramBoolean)
  {
    AppMethodBeat.i(136526);
    if ((!this.nfq) && (this.nfp != null))
    {
      this.nfq = true;
      this.nfp.bM(paramBoolean);
      this.nfq = false;
    }
    AppMethodBeat.o(136526);
  }
  
  public final void bu(boolean paramBoolean)
  {
    AppMethodBeat.i(136523);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandSoftKeyboardPanel", "onKeyboardStateChanged, kbShown = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      wv(0);
      bEF();
      AppMethodBeat.o(136523);
      return;
    }
    if (isShown())
    {
      if ((this.nfw) && (1 == this.state))
      {
        bEE();
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] refreshHeight %d", new Object[] { Integer.valueOf(paramInt) });
    nfB.c(this, paramInt);
    AppMethodBeat.o(136521);
  }
  
  public EditText getAttachedEditText()
  {
    return this.nfz;
  }
  
  public int getMinimumHeight()
  {
    AppMethodBeat.i(136525);
    if (getVisibility() == 0)
    {
      int i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 48);
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
    wv(8);
    if ((this.nfz != null) && (!this.nfA.hideVKBHavingResult())) {
      aj.dp(this).hideSoftInputFromWindow(getWindowToken(), 0);
    }
    bEF();
    AppMethodBeat.o(136547);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(136539);
    super.onAttachedToWindow();
    bEB();
    AppMethodBeat.o(136539);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(136540);
    super.onDetachedFromWindow();
    wv(8);
    if (this.context != null)
    {
      if (this.nfz == null) {
        break label92;
      }
      this.nfA.hideVKB(this.nfz);
    }
    for (;;)
    {
      this.nfs.onDestroy();
      if (this.nfv != null) {
        this.nfv.setOnClickListener(null);
      }
      this.nfo = null;
      removeAllViews();
      this.context = null;
      bEC();
      AppMethodBeat.o(136540);
      return;
      label92:
      this.nfA.hideVKB();
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
    this.nfw = false;
    ImageButton localImageButton;
    if (this.nfv != null)
    {
      localImageButton = this.nfv;
      if (!this.nfw) {
        break label48;
      }
    }
    for (;;)
    {
      localImageButton.setVisibility(i);
      DR();
      AppMethodBeat.o(136543);
      return;
      label48:
      i = 4;
    }
  }
  
  public void setId(int paramInt) {}
  
  public void setOnDoneListener(c paramc)
  {
    this.nfp = paramc;
  }
  
  public void setOnSmileyChosenListener(d paramd)
  {
    this.nfo = paramd;
  }
  
  public void setOnVisibilityChangedListener(e parame)
  {
    this.nfr = parame;
  }
  
  public void setShowDoneButton(boolean paramBoolean)
  {
    AppMethodBeat.i(136544);
    this.nfy = paramBoolean;
    View localView;
    if (this.nfx != null)
    {
      localView = this.nfx;
      if (!this.nfy) {
        break label48;
      }
    }
    label48:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      DR();
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
    wv(paramInt);
    AppMethodBeat.o(136541);
  }
  
  public void show()
  {
    AppMethodBeat.i(136546);
    if (this.nfz != null) {
      bED();
    }
    DS();
    if (!isShown()) {
      wv(0);
    }
    AppMethodBeat.o(136546);
  }
  
  protected final void wt(int paramInt)
  {
    AppMethodBeat.i(221597);
    super.setId(paramInt);
    AppMethodBeat.o(221597);
  }
  
  final void wv(int paramInt)
  {
    AppMethodBeat.i(136542);
    int i = paramInt;
    if (paramInt == 0)
    {
      i = paramInt;
      if (s.cO(this)) {
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
      bEB();
      AppMethodBeat.o(136542);
      return;
    }
    bEC();
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
    public abstract boolean Vr(String paramString);
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
      if (s.cO(paramw))
      {
        paramw.wv(8);
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
      w.b(paramw).bFd();
      AppMethodBeat.o(136509);
    }
    
    public final void n(w paramw)
    {
      AppMethodBeat.i(136510);
      if (s.cO(paramw))
      {
        paramw.wv(8);
        w.g(paramw);
        AppMethodBeat.o(136510);
        return;
      }
      if (paramw.isShown()) {
        w.a(paramw).setVisibility(0);
      }
      if (!w.h(paramw))
      {
        w.b(paramw).bFd();
        AppMethodBeat.o(136510);
        return;
      }
      w.b(paramw).bFc();
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
      paramw.gB(z.iI(w.l(paramw)));
      AppMethodBeat.o(136513);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w
 * JD-Core Version:    0.7.0.1
 */