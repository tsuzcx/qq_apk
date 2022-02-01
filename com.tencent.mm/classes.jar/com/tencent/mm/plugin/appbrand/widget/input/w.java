package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.t;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.a;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.b;
import com.tencent.mm.plugin.appbrand.widget.input.panel.f;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public class w
  extends LinearLayout
  implements ac, u.b
{
  private static final int VIEW_ID;
  private static final b mFc;
  private Context context;
  private final Runnable mEO;
  private d mEP;
  private c mEQ;
  private boolean mER;
  private e mES;
  private com.tencent.mm.plugin.appbrand.widget.input.panel.e mET;
  private View mEU;
  private View mEV;
  private ImageButton mEW;
  private boolean mEX;
  private View mEY;
  private boolean mEZ;
  protected EditText mFa;
  private final ad mFb;
  private int state;
  
  static
  {
    AppMethodBeat.i(136553);
    VIEW_ID = 2131296762;
    mFc = new f((byte)0);
    AppMethodBeat.o(136553);
  }
  
  public w(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(136527);
    this.mEO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136503);
        if ((w.a(w.this) == null) || (!t.aC(w.a(w.this))))
        {
          AppMethodBeat.o(136503);
          return;
        }
        if (w.b(w.this).bAy())
        {
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AppBrandSoftKeyboardPanel", "postMeasure inLayout, skip");
          w.this.post(this);
          AppMethodBeat.o(136503);
          return;
        }
        w.c(w.this);
        AppMethodBeat.o(136503);
      }
    };
    this.mER = false;
    this.state = 2;
    this.context = paramContext;
    if ((paramContext instanceof ad))
    {
      paramContext = (ad)paramContext;
      this.mFb = paramContext;
      super.setId(VIEW_ID);
      setOrientation(1);
      paramContext = Cu();
      this.mEV = paramContext;
      addView(paramContext);
      paramContext = (e.b)com.tencent.luggage.a.e.K(e.b.class);
      if (paramContext != null) {
        break label199;
      }
    }
    label199:
    for (paramContext = null;; paramContext = paramContext.dF(this.context))
    {
      this.mET = paramContext;
      if (this.mET == null) {
        this.mET = new e.a(this.context);
      }
      this.mEU = this.mET.getPanelView();
      this.mEU.setVisibility(8);
      this.mEU.setBackgroundColor(0);
      this.mET.setOnTextOperationListener(new f()
      {
        public final void amb()
        {
          AppMethodBeat.i(136507);
          if (w.d(w.this) != null) {
            w.d(w.this).RU("[DELETE_EMOTION]");
          }
          AppMethodBeat.o(136507);
        }
        
        public final void append(String paramAnonymousString)
        {
          AppMethodBeat.i(136506);
          if (w.d(w.this) != null) {
            w.d(w.this).RU(paramAnonymousString);
          }
          AppMethodBeat.o(136506);
        }
      });
      addView(this.mEU);
      Cs();
      AppMethodBeat.o(136527);
      return;
      paramContext = new com.tencent.mm.plugin.appbrand.widget.input.b.a();
      break;
    }
  }
  
  private void bAA()
  {
    AppMethodBeat.i(136532);
    n localn = n.db(this);
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
    ((u)localn.getOnLayoutListener()).mEx = null;
    AppMethodBeat.o(136532);
  }
  
  private void bAB()
  {
    AppMethodBeat.i(136534);
    bAD();
    if (this.mFa != null)
    {
      InputMethodManager localInputMethodManager = aj.dn(this.mFa);
      if (!localInputMethodManager.showSoftInput(this.mFa, 1)) {
        localInputMethodManager.showSoftInput(this.mFa, 2);
      }
      AppMethodBeat.o(136534);
      return;
    }
    this.mFb.showVKB();
    AppMethodBeat.o(136534);
  }
  
  private void bAC()
  {
    AppMethodBeat.i(136535);
    mFc.n(this);
    if (this.mEW != null) {
      this.mEW.setSelected(true);
    }
    vP(1);
    AppMethodBeat.o(136535);
  }
  
  private void bAD()
  {
    AppMethodBeat.i(136536);
    mFc.m(this);
    if (this.mEW != null) {
      this.mEW.setSelected(false);
    }
    vP(0);
    AppMethodBeat.o(136536);
  }
  
  private void bAz()
  {
    AppMethodBeat.i(136531);
    Cr();
    ((u)n.db(this).getOnLayoutListener()).mEx = this;
    AppMethodBeat.o(136531);
  }
  
  public static w di(View paramView)
  {
    AppMethodBeat.i(136518);
    paramView = (w)paramView.getRootView().findViewById(VIEW_ID);
    AppMethodBeat.o(136518);
    return paramView;
  }
  
  public static w dj(View paramView)
  {
    AppMethodBeat.i(136519);
    n localn = n.db(paramView);
    if (localn == null)
    {
      AppMethodBeat.o(136519);
      return null;
    }
    if ((localn.getOnLayoutListener() == null) || (!(localn.getOnLayoutListener() instanceof u))) {
      localn.setOnLayoutListener(new u());
    }
    Object localObject1 = di(paramView);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = com.tencent.mm.sdk.f.a.jg(paramView.getContext());
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
        localn.dc(paramView);
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
    if (this.mET.vN(paramInt)) {
      this.mEO.run();
    }
    AppMethodBeat.o(136524);
  }
  
  private void vP(final int paramInt)
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
        if ((i != w.e(w.this)) && (!this.mFg)) {
          w.f(w.this).gs(w.e(w.this));
        }
        AppMethodBeat.o(136508);
      }
    });
    AppMethodBeat.o(136533);
  }
  
  protected void Cr()
  {
    AppMethodBeat.i(136530);
    dj(this);
    AppMethodBeat.o(136530);
  }
  
  protected void Cs()
  {
    boolean bool = false;
    AppMethodBeat.i(136537);
    if (this.mEV == null)
    {
      AppMethodBeat.o(136537);
      return;
    }
    a locala = (a)this.mEV;
    int i;
    if (!this.mEX)
    {
      i = 1;
      if (this.mEZ) {
        break label84;
      }
    }
    label84:
    for (int j = 1;; j = 0)
    {
      if (((i & j) != 0) || (r.cM(this))) {
        bool = true;
      }
      locala.setIsHide(bool);
      AppMethodBeat.o(136537);
      return;
      i = 0;
      break;
    }
  }
  
  protected void Ct()
  {
    AppMethodBeat.i(136545);
    setCanSmileyInput(this.mEX);
    setShowDoneButton(this.mEZ);
    Cs();
    AppMethodBeat.o(136545);
  }
  
  protected <T extends View,  extends a> T Cu()
  {
    AppMethodBeat.i(136529);
    g localg = new g(getContext());
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = ai.getResources().getDrawable(2131234370);
    localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    localDrawable = ai.getResources().getDrawable(2131234369);
    localStateListDrawable.addState(new int[0], localDrawable);
    this.mEW = ((ImageButton)localg.findViewById(2131304878));
    this.mEW.setSelected(false);
    this.mEW.setImageDrawable(localStateListDrawable);
    this.mEW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(136504);
        if (paramAnonymousView.isSelected())
        {
          w.bAE().o(w.this);
          paramAnonymousView.setSelected(false);
          AppMethodBeat.o(136504);
          return;
        }
        w.bAE().p(w.this);
        paramAnonymousView.setSelected(true);
        AppMethodBeat.o(136504);
      }
    });
    this.mEY = localg.findViewById(2131304877);
    this.mEY.setOnClickListener(new View.OnClickListener()
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
    if (paramEditText == this.mFa)
    {
      this.mFa = null;
      return true;
    }
    return false;
  }
  
  public final boolean bAu()
  {
    AppMethodBeat.i(136520);
    boolean bool = this.mET.bAu();
    AppMethodBeat.o(136520);
    return bool;
  }
  
  protected final void bM(boolean paramBoolean)
  {
    AppMethodBeat.i(136526);
    if ((!this.mER) && (this.mEQ != null))
    {
      this.mER = true;
      this.mEQ.bM(paramBoolean);
      this.mER = false;
    }
    AppMethodBeat.o(136526);
  }
  
  public final void bt(boolean paramBoolean)
  {
    AppMethodBeat.i(136523);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AppBrandSoftKeyboardPanel", "onKeyboardStateChanged, kbShown = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      vQ(0);
      bAD();
      AppMethodBeat.o(136523);
      return;
    }
    if (isShown())
    {
      if ((this.mEX) && (1 == this.state))
      {
        bAC();
        AppMethodBeat.o(136523);
        return;
      }
      hide();
    }
    AppMethodBeat.o(136523);
  }
  
  public EditText getAttachedEditText()
  {
    return this.mFa;
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
  
  public final void gw(int paramInt)
  {
    AppMethodBeat.i(136521);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] refreshHeight %d", new Object[] { Integer.valueOf(paramInt) });
    mFc.c(this, paramInt);
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
    vQ(8);
    if ((this.mFa != null) && (!this.mFb.hideVKBHavingResult())) {
      aj.dn(this).hideSoftInputFromWindow(getWindowToken(), 0);
    }
    bAD();
    AppMethodBeat.o(136547);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(136539);
    super.onAttachedToWindow();
    bAz();
    AppMethodBeat.o(136539);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(136540);
    super.onDetachedFromWindow();
    vQ(8);
    if (this.context != null)
    {
      if (this.mFa == null) {
        break label92;
      }
      this.mFb.hideVKB(this.mFa);
    }
    for (;;)
    {
      this.mET.onDestroy();
      if (this.mEW != null) {
        this.mEW.setOnClickListener(null);
      }
      this.mEP = null;
      removeAllViews();
      this.context = null;
      bAA();
      AppMethodBeat.o(136540);
      return;
      label92:
      this.mFb.hideVKB();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136522);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] SoftKeyboardPanel onLayout measuredHeight = %d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    AppMethodBeat.o(136522);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136538);
    super.onMeasure(paramInt1, paramInt2);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AppBrandSoftKeyboardPanel", "smileyPanelWrapper, onMeasure");
    AppMethodBeat.o(136538);
  }
  
  public void setCanSmileyInput(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(136543);
    this.mEX = false;
    ImageButton localImageButton;
    if (this.mEW != null)
    {
      localImageButton = this.mEW;
      if (!this.mEX) {
        break label48;
      }
    }
    for (;;)
    {
      localImageButton.setVisibility(i);
      Cs();
      AppMethodBeat.o(136543);
      return;
      label48:
      i = 4;
    }
  }
  
  public void setId(int paramInt) {}
  
  public void setOnDoneListener(c paramc)
  {
    this.mEQ = paramc;
  }
  
  public void setOnSmileyChosenListener(d paramd)
  {
    this.mEP = paramd;
  }
  
  public void setOnVisibilityChangedListener(e parame)
  {
    this.mES = parame;
  }
  
  public void setShowDoneButton(boolean paramBoolean)
  {
    AppMethodBeat.i(136544);
    this.mEZ = paramBoolean;
    View localView;
    if (this.mEY != null)
    {
      localView = this.mEY;
      if (!this.mEZ) {
        break label48;
      }
    }
    label48:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      Cs();
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
    vQ(paramInt);
    AppMethodBeat.o(136541);
  }
  
  public void show()
  {
    AppMethodBeat.i(136546);
    if (this.mFa != null) {
      bAB();
    }
    Ct();
    if (!isShown()) {
      vQ(0);
    }
    AppMethodBeat.o(136546);
  }
  
  protected final void vO(int paramInt)
  {
    AppMethodBeat.i(210370);
    super.setId(paramInt);
    AppMethodBeat.o(210370);
  }
  
  final void vQ(int paramInt)
  {
    AppMethodBeat.i(136542);
    int i = paramInt;
    if (paramInt == 0)
    {
      i = paramInt;
      if (r.cM(this)) {
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
      bAz();
      AppMethodBeat.o(136542);
      return;
    }
    bAA();
    AppMethodBeat.o(136542);
  }
  
  public static abstract interface a
  {
    public abstract void setIsHide(boolean paramBoolean);
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
    public abstract boolean RU(String paramString);
  }
  
  public static abstract interface e
  {
    public abstract void gs(int paramInt);
  }
  
  static final class f
    implements w.b
  {
    public final void c(w paramw, int paramInt)
    {
      AppMethodBeat.i(136511);
      if (r.cM(paramw))
      {
        paramw.vQ(8);
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
      w.b(paramw).bBb();
      AppMethodBeat.o(136509);
    }
    
    public final void n(w paramw)
    {
      AppMethodBeat.i(136510);
      if (r.cM(paramw))
      {
        paramw.vQ(8);
        w.g(paramw);
        AppMethodBeat.o(136510);
        return;
      }
      if (paramw.isShown()) {
        w.a(paramw).setVisibility(0);
      }
      if (!w.h(paramw))
      {
        w.b(paramw).bBb();
        AppMethodBeat.o(136510);
        return;
      }
      w.b(paramw).bBa();
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
      paramw.gw(y.iy(w.l(paramw)));
      AppMethodBeat.o(136513);
    }
  }
  
  static final class g
    extends FrameLayout
    implements w.a
  {
    private boolean mFh;
    
    public g(Context paramContext)
    {
      super();
      AppMethodBeat.i(136514);
      this.mFh = false;
      LayoutInflater.from(paramContext).inflate(2131493108, this);
      AppMethodBeat.o(136514);
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(136516);
      if ((this.mFh) || (!isShown()))
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
      if (paramBoolean != this.mFh) {}
      for (int i = 1;; i = 0)
      {
        this.mFh = paramBoolean;
        if ((i != 0) && ((Build.VERSION.SDK_INT < 18) || (!isInLayout()))) {
          requestLayout();
        }
        AppMethodBeat.o(136515);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w
 * JD-Core Version:    0.7.0.1
 */