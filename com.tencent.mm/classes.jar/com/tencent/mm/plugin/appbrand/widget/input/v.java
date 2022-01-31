package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.luggage.l.a.a.c;
import com.tencent.luggage.l.a.a.d;
import com.tencent.luggage.l.a.a.e;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.a;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public class v
  extends LinearLayout
  implements ab, t.a
{
  private static final int gdr = a.d.app_brand_keyboard_smiley;
  private static final v.b hve = new v.f((byte)0);
  private Context context;
  private final Runnable huQ = new v.1(this);
  private v.d huR;
  private v.c huS;
  private boolean huT = false;
  private v.e huU;
  private com.tencent.mm.plugin.appbrand.widget.input.panel.e huV;
  private View huW;
  private View huX;
  private ImageButton huY;
  private boolean huZ;
  private View hva;
  private boolean hvb;
  public EditText hvc;
  private final ac hvd;
  private int state = 2;
  
  public v(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    if ((paramContext instanceof ac))
    {
      paramContext = (ac)paramContext;
      this.hvd = paramContext;
      super.setId(gdr);
      setOrientation(1);
      paramContext = ahs();
      this.huX = paramContext;
      addView(paramContext);
      paramContext = (e.b)com.tencent.luggage.b.e.i(e.b.class);
      if (paramContext != null) {
        break label189;
      }
    }
    label189:
    for (paramContext = null;; paramContext = paramContext.cu(this.context))
    {
      this.huV = paramContext;
      if (this.huV == null) {
        this.huV = new e.a(this.context);
      }
      this.huW = this.huV.getPanelView();
      this.huW.setVisibility(8);
      this.huW.setBackgroundColor(0);
      this.huV.setOnTextOperationListener(new v.4(this));
      addView(this.huW);
      ahq();
      return;
      paramContext = new com.tencent.mm.plugin.appbrand.widget.input.b.a();
      break;
    }
  }
  
  private void ase()
  {
    ((t)m.ch(this).getOnLayoutListener()).huD = this;
  }
  
  private void asf()
  {
    ((t)m.ch(this).getOnLayoutListener()).huD = null;
  }
  
  private void asg()
  {
    hideSmileyPanel();
    if (this.hvc != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.hvc.getContext().getSystemService("input_method");
      if (!localInputMethodManager.showSoftInput(this.hvc, 1)) {
        localInputMethodManager.showSoftInput(this.hvc, 2);
      }
      return;
    }
    this.hvd.showVKB();
  }
  
  private void ash()
  {
    hve.n(this);
    if (this.huY != null) {
      this.huY.setSelected(true);
    }
    mS(1);
  }
  
  public static v cn(View paramView)
  {
    return (v)paramView.getRootView().findViewById(gdr);
  }
  
  public static v co(View paramView)
  {
    m localm = m.ch(paramView);
    if ((localm.getOnLayoutListener() == null) || (!(localm.getOnLayoutListener() instanceof t))) {
      localm.setOnLayoutListener(new t());
    }
    v localv2 = cn(paramView);
    v localv1 = localv2;
    if (localv2 == null)
    {
      localv1 = new v(paramView.getContext());
      localm.ci(localv1);
    }
    return localv1;
  }
  
  private void hideSmileyPanel()
  {
    hve.m(this);
    if (this.huY != null) {
      this.huY.setSelected(false);
    }
    mS(0);
  }
  
  private void mS(final int paramInt)
  {
    post(new Runnable()
    {
      public final void run()
      {
        int i = v.e(v.this);
        if (!v.this.isShown())
        {
          v.a(v.this, 2);
          if (v.f(v.this) != null) {
            break label53;
          }
        }
        label53:
        while ((i == v.e(v.this)) || (this.hvh))
        {
          return;
          v.a(v.this, paramInt);
          break;
        }
        v.f(v.this).kT(v.e(v.this));
      }
    });
  }
  
  private void setPanelHeightImpl(int paramInt)
  {
    if (this.huV.mQ(paramInt)) {
      this.huQ.run();
    }
  }
  
  public void ahq()
  {
    boolean bool = false;
    if (this.huX == null) {
      return;
    }
    v.a locala = (v.a)this.huX;
    int i;
    if (!this.huZ)
    {
      i = 1;
      if (this.hvb) {
        break label66;
      }
    }
    label66:
    for (int j = 1;; j = 0)
    {
      if (((i & j) != 0) || (l.bW(this))) {
        bool = true;
      }
      locala.setIsHide(bool);
      return;
      i = 0;
      break;
    }
  }
  
  public void ahr()
  {
    setCanSmileyInput(this.huZ);
    setShowDoneButton(this.hvb);
    ahq();
  }
  
  public <T extends View,  extends v.a> T ahs()
  {
    g localg = new g(getContext());
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = ae.getResources().getDrawable(a.c.textfield_icon_emoji_pressed);
    localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    localDrawable = ae.getResources().getDrawable(a.c.textfield_icon_emoji_normal);
    localStateListDrawable.addState(new int[0], localDrawable);
    this.huY = ((ImageButton)localg.findViewById(a.d.smiley_toolbar_switcher_image));
    this.huY.setSelected(false);
    this.huY.setImageDrawable(localStateListDrawable);
    this.huY.setOnClickListener(new v.2(this));
    this.hva = localg.findViewById(a.d.smiley_toolbar_done);
    this.hva.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        v.this.dU(true);
      }
    });
    return localg;
  }
  
  public final boolean arZ()
  {
    return this.huV.arZ();
  }
  
  public final void b(EditText paramEditText)
  {
    if (paramEditText == this.hvc) {
      this.hvc = null;
    }
  }
  
  protected final void dU(boolean paramBoolean)
  {
    if ((!this.huT) && (this.huS != null))
    {
      this.huT = true;
      this.huS.dU(paramBoolean);
      this.huT = false;
    }
  }
  
  public final void dW(boolean paramBoolean)
  {
    y.d("MicroMsg.AppBrandSoftKeyboardPanel", "onKeyboardStateChanged, kbShown = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      mT(0);
      hideSmileyPanel();
    }
    while (!isShown()) {
      return;
    }
    if ((this.huZ) && (1 == this.state))
    {
      ash();
      return;
    }
    hide();
  }
  
  public EditText getAttachedEditText()
  {
    return this.hvc;
  }
  
  public int getMinimumHeight()
  {
    if (getVisibility() == 0) {
      return com.tencent.mm.cb.a.fromDPToPix(getContext(), 48);
    }
    return 0;
  }
  
  public final void hide()
  {
    if (!isShown()) {
      return;
    }
    mT(8);
    if (!this.hvd.ass()) {
      ai.cs(this).hideSoftInputFromWindow(getWindowToken(), 0);
    }
    hideSmileyPanel();
  }
  
  public final void mP(int paramInt)
  {
    y.d("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] refreshHeight %d", new Object[] { Integer.valueOf(paramInt) });
    hve.c(this, paramInt);
  }
  
  public final void mR(int paramInt)
  {
    super.setId(paramInt);
  }
  
  final void mT(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
    {
      i = paramInt;
      if (l.bW(this)) {
        i = 8;
      }
    }
    if (getVisibility() == i) {
      return;
    }
    super.setVisibility(i);
    if (i == 0)
    {
      ase();
      return;
    }
    asf();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ase();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    mT(8);
    if (this.context != null)
    {
      if (this.hvc == null) {
        break label80;
      }
      this.hvd.hideVKB(this.hvc);
    }
    for (;;)
    {
      this.huV.onDestroy();
      if (this.huY != null) {
        this.huY.setOnClickListener(null);
      }
      this.huR = null;
      removeAllViews();
      this.context = null;
      asf();
      return;
      label80:
      this.hvd.XM();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    y.v("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] SoftKeyboardPanel onLayout measuredHeight = %d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    y.d("MicroMsg.AppBrandSoftKeyboardPanel", "smileyPanelWrapper, onMeasure");
  }
  
  public void setCanSmileyInput(boolean paramBoolean)
  {
    int i = 0;
    this.huZ = false;
    ImageButton localImageButton;
    if (this.huY != null)
    {
      localImageButton = this.huY;
      if (!this.huZ) {
        break label36;
      }
    }
    for (;;)
    {
      localImageButton.setVisibility(i);
      ahq();
      return;
      label36:
      i = 4;
    }
  }
  
  public void setId(int paramInt) {}
  
  public void setOnDoneListener(v.c paramc)
  {
    this.huS = paramc;
  }
  
  public void setOnSmileyChosenListener(v.d paramd)
  {
    this.huR = paramd;
  }
  
  public void setOnVisibilityChangedListener(v.e parame)
  {
    this.huU = parame;
  }
  
  public void setShowDoneButton(boolean paramBoolean)
  {
    this.hvb = paramBoolean;
    View localView;
    if (this.hva != null)
    {
      localView = this.hva;
      if (!this.hvb) {
        break label36;
      }
    }
    label36:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      ahq();
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 8)
    {
      if (getVisibility() != paramInt) {
        dU(false);
      }
      hide();
      return;
    }
    if (paramInt == 0)
    {
      show();
      return;
    }
    mT(paramInt);
  }
  
  public void show()
  {
    asg();
    ahr();
    if (!isShown()) {
      mT(0);
    }
  }
  
  private static final class g
    extends FrameLayout
    implements v.a
  {
    private boolean hvi = false;
    
    public g(Context paramContext)
    {
      super();
      LayoutInflater.from(paramContext).inflate(a.e.appbrand_smiley_panel_wrapper, this);
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      if ((this.hvi) || (!isShown()))
      {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
      }
      super.onMeasure(paramInt1, paramInt2);
    }
    
    public final void setIsHide(boolean paramBoolean)
    {
      if (paramBoolean != this.hvi) {}
      for (int i = 1;; i = 0)
      {
        this.hvi = paramBoolean;
        if ((i != 0) && ((Build.VERSION.SDK_INT < 18) || (!isInLayout()))) {
          requestLayout();
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.v
 * JD-Core Version:    0.7.0.1
 */