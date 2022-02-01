package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.ui.s;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.d;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import java.util.Locale;
import junit.framework.Assert;

public abstract class i
  implements aa<y>
{
  final ap lEc = new ap(Looper.getMainLooper());
  public int ndw;
  private final c.a sZP = new p.a()
  {
    public final void cU(String paramAnonymousString)
    {
      AppMethodBeat.i(168763);
      if (i.this.tac != null) {
        try
        {
          i.this.taj.a(i.this.tac.getEditableText(), false);
          AppMethodBeat.o(168763);
          return;
        }
        catch (Exception paramAnonymousString) {}
      }
      AppMethodBeat.o(168763);
    }
  };
  public volatile i.c sZT;
  private volatile a sZU;
  public volatile b sZV;
  final View.OnFocusChangeListener sZW = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136369);
      if (paramAnonymousBoolean) {
        o.b((com.tencent.mm.plugin.appbrand.page.aa)i.this.tab.get(), i.this);
      }
      i.a(i.this, paramAnonymousBoolean);
      if ((paramAnonymousBoolean) && ((!i.this.taa.niS) || (s.cO(i.this.tac)))) {}
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (i.this.tac != null) && (i.this.tad != null))
        {
          i.this.tac.requestFocus();
          i.this.tad.show();
        }
        AppMethodBeat.o(136369);
        return;
      }
    }
  };
  private int sZX = -1;
  private int sZY = -1;
  i.d sZZ = null;
  private final w.c tGL = new w.c()
  {
    public final void bM(boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136365);
      if (paramAnonymousBoolean) {
        i.this.sZZ = i.d.ndO;
      }
      i.f(i.this);
      i.this.sZZ = null;
      AppMethodBeat.o(136365);
    }
  };
  private final w.e tGN = new w.e()
  {
    public final void gv(int paramAnonymousInt)
    {
      AppMethodBeat.i(136366);
      ad.d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
      if (paramAnonymousInt != 2)
      {
        if ((paramAnonymousInt == 0) && (i.this.tac != null)) {
          i.this.tac.requestFocus();
        }
        i.g(i.this);
        if ((i.this.tab != null) && (i.this.tab.get() != null))
        {
          o.a((com.tencent.mm.plugin.appbrand.page.aa)i.this.tab.get(), i.this.tac);
          AppMethodBeat.o(136366);
        }
      }
      else
      {
        i.this.sZZ = i.d.ndN;
        i.f(i.this);
        i.this.sZZ = null;
      }
      AppMethodBeat.o(136366);
    }
  };
  public com.tencent.mm.plugin.appbrand.widget.input.d.e taa;
  protected WeakReference<com.tencent.mm.plugin.appbrand.page.aa> tab;
  public y tac;
  w tad;
  private v tae;
  private final Runnable taf = new i.13(this);
  int tah;
  int tai;
  public final com.tencent.mm.plugin.appbrand.widget.input.c.a taj = new com.tencent.mm.plugin.appbrand.widget.input.c.a();
  boolean tak = false;
  final Runnable tal = new i.14(this);
  private final w.d tam = new w.d()
  {
    public final boolean Vr(String paramAnonymousString)
    {
      AppMethodBeat.i(136364);
      if (i.this.tac != null)
      {
        if (!"[DELETE_EMOTION]".equalsIgnoreCase(paramAnonymousString)) {
          break label119;
        }
        paramAnonymousString = i.this.tac;
        if (paramAnonymousString.nfi == null) {
          break label86;
        }
        if (!bt.ai(paramAnonymousString.getEditableText())) {
          paramAnonymousString.nfi.deleteSurroundingText(paramAnonymousString.getEditableText().length(), paramAnonymousString.getEditableText().length() - 1);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(136364);
        return true;
        label86:
        paramAnonymousString.dispatchKeyEvent(new KeyEvent(0, 67));
        paramAnonymousString.dispatchKeyEvent(new KeyEvent(1, 67));
      }
      label119:
      y localy = i.this.tac;
      f.bDW();
      if (localy.getEditableText() == null) {
        localy.setText(paramAnonymousString, TextView.BufferType.EDITABLE);
      }
      for (;;)
      {
        localy.setSelection(localy.getEditableText().length());
        break;
        localy.getEditableText().append(paramAnonymousString);
      }
    }
  };
  
  private void bCf()
  {
    boolean bool3 = true;
    com.tencent.mm.plugin.appbrand.page.aa localaa;
    boolean bool1;
    label33:
    boolean bool2;
    if (this.tab == null)
    {
      localaa = null;
      if (this.tad == null) {
        bDZ();
      }
      if (this.tac != null) {
        break label114;
      }
      bool1 = true;
      if (localaa != null) {
        break label119;
      }
      bool2 = true;
      label40:
      if (this.tad != null) {
        break label124;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, null==mInput[%b], null==page[%b], null==mSmileyPanel[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((localaa != null) && (this.tac != null) && (this.tad != null)) {
        break label129;
      }
      return;
      localaa = (com.tencent.mm.plugin.appbrand.page.aa)this.tab.get();
      break;
      label114:
      bool1 = false;
      break label33;
      label119:
      bool2 = false;
      break label40;
      label124:
      bool3 = false;
    }
    label129:
    o.a(localaa, this.tac);
    final PBool localPBool = new PBool();
    localPBool.value = false;
    final Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136361);
        ad.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, before run checkForInput");
        localPBool.value = true;
        if (i.this.tab == null) {}
        for (com.tencent.mm.plugin.appbrand.page.aa localaa = null; (localaa == null) || (i.this.tac == null); localaa = (com.tencent.mm.plugin.appbrand.page.aa)i.this.tab.get())
        {
          AppMethodBeat.o(136361);
          return;
        }
        if (o.z(localaa) != i.this)
        {
          AppMethodBeat.o(136361);
          return;
        }
        ad.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, run checkForInput");
        h.bDY().d(localaa.lYc);
        aj.dq(i.this.tac);
        if ((i.this.tad != null) && (i.this.tad.b(null))) {
          i.this.tad.hide();
        }
        i.this.tac.a(i.this.sZW);
        i.this.tac.setFocusable(true);
        i.this.tac.setFocusableInTouchMode(true);
        i.this.tad.nfz = i.this.tac;
        i.this.tac.requestFocus();
        aj.dq(i.this.tac);
        if (i.this.tad != null) {
          i.this.tad.show();
        }
        AppMethodBeat.o(136361);
      }
    };
    Object localObject = com.tencent.mm.sdk.f.a.jq(localaa.getContext());
    if ((localObject != null) && (((Activity)localObject).getCurrentFocus() != null))
    {
      localObject = ((Activity)localObject).getCurrentFocus();
      bool1 = aj.dp((View)localObject).isActive((View)localObject);
      bool2 = aj.h(localaa.lYc.getWrapperView(), (View)localObject);
      if ((bool1) && (bool2))
      {
        ad.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, servedConnecting && servedForWebView, delay checkForInput");
        this.tad.setOnVisibilityChangedListener(new w.e()
        {
          public final void gv(int paramAnonymousInt)
          {
            AppMethodBeat.i(136362);
            if ((localPBool.value) || (paramAnonymousInt != 2))
            {
              AppMethodBeat.o(136362);
              return;
            }
            local3.run();
            AppMethodBeat.o(136362);
          }
        });
        com.tencent.e.h.LTJ.q(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136363);
            if (localPBool.value)
            {
              AppMethodBeat.o(136363);
              return;
            }
            local3.run();
            AppMethodBeat.o(136363);
          }
        }, 100L);
        return;
      }
    }
    local3.run();
  }
  
  private void bDE()
  {
    if (this.tad == null) {
      return;
    }
    this.tad.setOnSmileyChosenListener(this.tam);
    this.tad.setOnDoneListener(this.tGL);
    this.tad.setOnVisibilityChangedListener(this.tGN);
  }
  
  private void bDQ()
  {
    Object localObject = (com.tencent.mm.plugin.appbrand.page.aa)this.tab.get();
    if (!android.support.v4.view.t.aC(((com.tencent.mm.plugin.appbrand.page.aa)localObject).kca)) {}
    label169:
    label301:
    label352:
    label376:
    for (;;)
    {
      return;
      this.tad = w.dl(((com.tencent.mm.plugin.appbrand.page.aa)localObject).kca);
      if (this.taa.niS)
      {
        bDE();
        bEa();
      }
      this.tac.a(this.sZW);
      this.tac.setOnKeyListener(new i.9(this));
      if (this.taa.niS) {
        o.a((com.tencent.mm.plugin.appbrand.page.aa)this.tab.get(), this.tac);
      }
      localObject = this.tad;
      boolean bool;
      final int i;
      if ((!this.taa.cvK) && ("emoji".equals(this.taa.cvH)))
      {
        bool = true;
        ((w)localObject).setCanSmileyInput(bool);
        if (this.taa.njr != null) {
          break label301;
        }
        i = com.tencent.mm.plugin.appbrand.widget.input.d.b.il(this.taa.njm.booleanValue()).niM;
        ad.d("MicroMsg.AppBrandInputInvokeHandler", "initSmileyPanelAndShow, myImeOption: ".concat(String.valueOf(i)));
        localObject = null;
        if ((!this.taa.njm.booleanValue()) || (i != 0)) {
          localObject = new TextView.OnEditorActionListener()
          {
            public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(136368);
              if (paramAnonymousInt == i)
              {
                i.this.sZZ = i.d.ndO;
                i.f(i.this);
                i.this.sZZ = null;
                AppMethodBeat.o(136368);
                return true;
              }
              AppMethodBeat.o(136368);
              return false;
            }
          };
        }
        this.tac.setImeOptions(i);
        this.tac.setOnEditorActionListener((TextView.OnEditorActionListener)localObject);
        this.tad.setShowDoneButton(this.taa.njn.booleanValue());
        this.tad.nfz = this.tac;
        if (!this.taa.niS) {
          break label352;
        }
        bCf();
      }
      for (;;)
      {
        if (!this.taa.niS) {
          break label376;
        }
        k.a(this.tab).wp(this.ndw);
        return;
        bool = false;
        break;
        if ((!this.taa.njm.booleanValue()) && (com.tencent.mm.plugin.appbrand.widget.input.d.b.niL == this.taa.njr)) {
          this.taa.njr = com.tencent.mm.plugin.appbrand.widget.input.d.b.il(false);
        }
        i = this.taa.njr.niM;
        break label169;
        this.tac.setFocusable(false);
        this.tac.setFocusableInTouchMode(false);
        this.tad.hide();
      }
    }
  }
  
  private v bDV()
  {
    if (this.tae != null) {
      return this.tae;
    }
    if (this.tab != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.aa)this.tab.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    if ((((com.tencent.mm.plugin.appbrand.page.aa)localObject).kca == null) || (!android.support.v4.view.t.aC(((com.tencent.mm.plugin.appbrand.page.aa)localObject).kca))) {
      return null;
    }
    Object localObject = v.di(((com.tencent.mm.plugin.appbrand.page.aa)localObject).kca);
    this.tae = ((v)localObject);
    return localObject;
  }
  
  private w bDZ()
  {
    if (this.tad != null) {
      return this.tad;
    }
    if (this.tab != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.aa)this.tab.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    Object localObject = w.dk(((com.tencent.mm.plugin.appbrand.page.aa)localObject).kca);
    this.tad = ((w)localObject);
    return localObject;
  }
  
  private void bEa()
  {
    if (bDV() != null) {
      this.tae.setVisibility(8);
    }
  }
  
  private void bbp()
  {
    if (this.tac == null) {
      break label7;
    }
    label7:
    while ((this.tac.getLineCount() == this.sZX) && (this.tac.bEH() == this.sZY)) {
      return;
    }
    if (this.sZX == -1) {}
    for (int i = 1;; i = 0)
    {
      this.sZX = this.tac.getLineCount();
      this.sZY = this.tac.bEH();
      if (this.sZT != null) {
        this.sZT.dR(this.sZX, this.sZY);
      }
      if ((!this.taa.njm.booleanValue()) || (i != 0)) {
        break;
      }
      this.tah = (aj.j(this.taa.niY) + aj.j(this.taa.niX));
      aUQ();
      this.tai = (aj.j(this.taa.niY) + aj.j(this.taa.niX));
      ii(true);
      return;
    }
  }
  
  private void bbv()
  {
    if (this.taa.njm.booleanValue()) {
      bDZ();
    }
    if ((this.tad != null) && (this.tac != null))
    {
      this.tad.nfz = this.tac;
      this.tad.setShowDoneButton(aj.i(this.taa.njn));
      bDE();
      if ((s.cO(this.tac)) && (this.tac.hasFocus())) {
        this.tad.show();
      }
    }
  }
  
  private void bbw()
  {
    this.tad.b(this.tac);
    a(this.tac);
    this.tac.destroy();
    onDestroy();
  }
  
  private void eu(int paramInt1, int paramInt2)
  {
    b.a(this.tac, paramInt1, paramInt2);
    ii(false);
  }
  
  private void ii(boolean paramBoolean)
  {
    if ((this.taa.njm.booleanValue()) && (this.tad != null) && (this.tad.isShown()) && (this.tac != null) && (this.tac == this.tad.getAttachedEditText()))
    {
      if (!paramBoolean) {
        break label204;
      }
      if ((this.tab == null) || (this.tab.get() == null) || (((com.tencent.mm.plugin.appbrand.page.aa)this.tab.get()).but() == null)) {
        break label219;
      }
      i = ((com.tencent.mm.plugin.appbrand.page.aa)this.tab.get()).but().getMeasuredHeight();
    }
    label204:
    label219:
    for (int i = ((com.tencent.mm.plugin.appbrand.page.aa)this.tab.get()).but().getScrollY() + i;; i = 0)
    {
      if (((this.tai > this.tah) && (this.tai - this.tac.getLineHeight() <= i)) || ((this.tai <= this.tah) && (this.tai + this.tac.getLineHeight() <= i)) || (this.tac.bEH() >= i)) {
        k.a(this.tab).wp(this.ndw);
      }
      return;
      k.a(this.tab).wp(this.ndw);
      return;
    }
  }
  
  private void ij(boolean paramBoolean)
  {
    if (this.tac == null) {
      return;
    }
    String str = this.tac.getText().toString();
    int i = this.tac.getSelectionEnd();
    if (this.sZZ == i.d.ndO) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, i, bool, paramBoolean);
      return;
    }
  }
  
  private void onDestroy()
  {
    this.tac = null;
    com.tencent.mm.plugin.appbrand.utils.e.bj(this);
  }
  
  public abstract void PE(String paramString);
  
  void a(y paramy)
  {
    if (paramy == null) {}
    label58:
    for (;;)
    {
      return;
      paramy.b(this.sZW);
      if (this.tab == null) {}
      for (Object localObject = null;; localObject = (com.tencent.mm.plugin.appbrand.page.aa)this.tab.get())
      {
        if (localObject == null) {
          break label58;
        }
        localObject = (g)((com.tencent.mm.plugin.appbrand.page.aa)localObject).but();
        if (localObject == null) {
          break;
        }
        ((g)localObject).dc(paramy);
        return;
      }
    }
  }
  
  public abstract void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public final void a(String paramString, Integer paramInteger)
  {
    if (this.tac == null) {
      return;
    }
    this.tac.D(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      eu(paramString.intValue(), paramString.intValue());
      bbp();
      return;
    }
  }
  
  boolean a(y paramy, com.tencent.mm.plugin.appbrand.widget.input.d.e parame)
  {
    if ((paramy == null) || (this.tab == null) || (this.tab.get() == null)) {
      return false;
    }
    g localg = (g)((com.tencent.mm.plugin.appbrand.page.aa)this.tab.get()).but();
    return (localg != null) && (localg.a(((com.tencent.mm.plugin.appbrand.page.aa)this.tab.get()).lYc, paramy, parame.niW.intValue(), parame.niX.intValue(), parame.niZ.intValue(), parame.niY.intValue()));
  }
  
  final void aUQ()
  {
    int k;
    int i;
    if ((this.tac != null) && (aj.i(this.taa.njo)) && (aj.i(this.taa.njm)))
    {
      ((q)this.tac).setAutoHeight(true);
      j = this.tac.getLineHeight();
      k = this.tac.bEH();
      if ((this.taa.nja != null) && (this.taa.nja.intValue() > 0)) {
        break label161;
      }
      i = j;
      if ((this.taa.njb != null) && (this.taa.njb.intValue() > 0)) {
        break label175;
      }
    }
    label161:
    label175:
    for (int j = 2147483647;; j = Math.max(this.taa.njb.intValue(), j))
    {
      this.tac.setMinHeight(i);
      this.tac.setMaxHeight(j);
      this.taa.niX = Integer.valueOf(Math.max(i, Math.min(k, j)));
      b(this.tac, this.taa);
      return;
      i = this.taa.nja.intValue();
      break;
    }
  }
  
  public boolean b(y paramy, com.tencent.mm.plugin.appbrand.widget.input.d.e parame)
  {
    if ((paramy == null) || (this.tab == null) || (this.tab.get() == null)) {
      return false;
    }
    g localg = (g)((com.tencent.mm.plugin.appbrand.page.aa)this.tab.get()).but();
    return (localg != null) && (localg.c(((com.tencent.mm.plugin.appbrand.page.aa)this.tab.get()).lYc, paramy, parame.niW.intValue(), parame.niX.intValue(), parame.niZ.intValue(), parame.niY.intValue()));
  }
  
  public final boolean bDO()
  {
    int i;
    if ((this.tac == null) || (this.tab == null) || (this.tab.get() == null)) {
      i = 0;
    }
    while (i != 0)
    {
      onDestroy();
      return true;
      this.tac.destroy();
      g localg = (g)((com.tencent.mm.plugin.appbrand.page.aa)this.tab.get()).but();
      if (localg == null)
      {
        i = 0;
      }
      else
      {
        if (this.tac.hasFocus())
        {
          if (this.tae != null) {
            this.tae.setVisibility(8);
          }
          bDZ();
          if (this.tad != null) {
            this.tad.setVisibility(8);
          }
        }
        localg.dc(this.tac);
        i = 1;
      }
    }
    return false;
  }
  
  public final boolean bDS()
  {
    return (this.taa != null) && (aj.i(this.taa.njt));
  }
  
  public final int bDT()
  {
    if ((this.taa != null) && (this.taa.njq != null)) {
      return this.taa.njq.intValue();
    }
    if ((this.tac != null) && (this.tac.bEq())) {
      return 5;
    }
    return 0;
  }
  
  public final boolean bDU()
  {
    int i;
    if ((this.tac != null) && ((this.tac.isFocused()) || ((bDZ() != null) && (bDZ().getAttachedEditText() == this.tac))))
    {
      i = 1;
      if (i != 0) {
        break label128;
      }
      if ((this.tab != null) && (this.tab.get() != null)) {
        break label82;
      }
      i = 0;
      label63:
      if (i == 0) {
        break label128;
      }
      ad.d("MicroMsg.AppBrandInputInvokeHandler", "doHideKeyboard, not focused, return");
    }
    label82:
    Object localObject;
    label128:
    do
    {
      return true;
      i = 0;
      break;
      localObject = ((com.tencent.mm.plugin.appbrand.page.aa)this.tab.get()).getContext();
      if ((localObject instanceof Activity))
      {
        if (((Activity)localObject).getCurrentFocus() != null)
        {
          i = 1;
          break label63;
        }
        i = 0;
        break label63;
      }
      i = 0;
      break label63;
      localObject = bDZ();
    } while (localObject == null);
    ((w)localObject).setVisibility(8);
    return true;
  }
  
  public final void bbo()
  {
    b.a(this.tac, this.taa);
    if (this.taa.njf == null)
    {
      this.taa.njf = Integer.valueOf(140);
      c localc = p.a(this.tac).aeU(this.taa.njf.intValue());
      localc.KMn = false;
      localc.neC = f.a.KIM;
      localc.a(this.sZP);
      this.tac.setPasswordMode(this.taa.cvK);
      if (!aj.i(this.taa.njk)) {
        break label236;
      }
      this.tac.setEnabled(false);
      this.tac.setFocusable(false);
      this.tac.setFocusableInTouchMode(false);
      this.tac.setClickable(false);
    }
    for (;;)
    {
      if ((this.tac instanceof q))
      {
        if (this.taa.nju != null) {
          ((q)this.tac).setLineSpace(this.taa.nju.intValue());
        }
        if (this.taa.njv != null) {
          ((q)this.tac).setLineHeight(this.taa.njv.intValue());
        }
      }
      return;
      if (this.taa.njf.intValue() > 0) {
        break;
      }
      this.taa.njf = Integer.valueOf(2147483647);
      break;
      label236:
      this.tac.setEnabled(true);
      this.tac.setClickable(true);
    }
  }
  
  public abstract void bkw();
  
  public abstract void bkx();
  
  public final void ev(int paramInt1, int paramInt2)
  {
    this.tab = this.taa.ncQ;
    if (this.tab == null) {}
    for (com.tencent.mm.plugin.appbrand.page.aa localaa = null; (localaa == null) || (localaa.lYc == null); localaa = (com.tencent.mm.plugin.appbrand.page.aa)this.tab.get())
    {
      ad.e("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
      bkx();
      return;
    }
    if (aj.i(this.taa.njm)) {}
    for (Object localObject = new q(localaa.getContext());; localObject = new t(localaa.getContext()))
    {
      this.tac = ((y)localObject);
      this.ndw = this.taa.ncO;
      this.tac.setInputId(this.ndw);
      o.b(localaa, this);
      bbo();
      this.tac.setText(bt.nullAsNil(this.taa.niV));
      if (aj.i(this.taa.njo)) {
        bbp();
      }
      this.tac.addTextChangedListener(new com.tencent.mm.ui.widget.g()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(136373);
          if ((i.this.tab == null) || (i.this.tab.get() == null) || (i.this.tac == null))
          {
            AppMethodBeat.o(136373);
            return;
          }
          i.b(i.this);
          if (aj.F(paramAnonymousEditable))
          {
            ad.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", new Object[] { paramAnonymousEditable });
            AppMethodBeat.o(136373);
            return;
          }
          ad.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", new Object[] { paramAnonymousEditable });
          paramAnonymousEditable = i.this.tac.getEditableText();
          i.this.taj.a(paramAnonymousEditable, i.this.tak);
          AppMethodBeat.o(136373);
        }
      });
      this.tac.setOnComposingDismissedListener(new com.tencent.mm.plugin.appbrand.widget.input.c.b()
      {
        public final void Dm()
        {
          AppMethodBeat.i(136374);
          if (i.this.tac == null)
          {
            AppMethodBeat.o(136374);
            return;
          }
          ad.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", new Object[] { i.this.tac.getEditableText() });
          i.this.taj.a(i.this.tac.getEditableText(), false);
          AppMethodBeat.o(136374);
        }
      });
      this.tac.setOnKeyUpPostImeListener(new ab.b()
      {
        public final boolean wn(int paramAnonymousInt)
        {
          AppMethodBeat.i(136375);
          if (paramAnonymousInt == 67)
          {
            if (aj.F(i.this.tac.getText()))
            {
              AppMethodBeat.o(136375);
              return false;
            }
            i.this.PE(i.this.tac.getText().toString());
            AppMethodBeat.o(136375);
            return true;
          }
          AppMethodBeat.o(136375);
          return false;
        }
      });
      if (a(this.tac, this.taa)) {
        break;
      }
      ad.e("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
      bkx();
      return;
    }
    if ((this.taa.niU != null) && (!bt.hj(this.taa.niU.niF))) {
      d.a(localaa, this.tac, this.taa.niU);
    }
    if (!aj.i(this.taa.njm)) {
      b.a(this.tac, paramInt1, paramInt2);
    }
    if (aj.i(this.taa.njm)) {
      this.tac.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136376);
          i.b(i.this);
          AppMethodBeat.o(136376);
        }
      });
    }
    if (("text".equalsIgnoreCase(this.taa.cvH)) || ("emoji".equalsIgnoreCase(this.taa.cvH))) {
      bDQ();
    }
    for (;;)
    {
      this.tac.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(136360);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (i.this.tac == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(136360);
            return;
          }
          if (i.this.tac.hasFocus())
          {
            i.d(i.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(136360);
            return;
          }
          if (i.this.tac == paramAnonymousView) {
            i.e(i.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(136360);
        }
      });
      bkw();
      return;
      Assert.assertTrue(String.format(Locale.US, "Unrecognized type(%s) implementation removed from here", new Object[] { this.taa.cvH }), true);
      bDQ();
    }
  }
  
  public final boolean ew(int paramInt1, int paramInt2)
  {
    if ((this.tac == null) || (this.tab == null) || (this.tab.get() == null)) {}
    for (;;)
    {
      eu(paramInt1, paramInt2);
      return true;
      this.tac.performClick();
    }
  }
  
  public final int getInputId()
  {
    return this.ndw;
  }
  
  public final <P extends View,  extends ac> P getInputPanel()
  {
    return this.tad;
  }
  
  public final boolean u(com.tencent.mm.plugin.appbrand.page.aa paramaa)
  {
    return (paramaa != null) && (this.tab != null) && (paramaa == this.tab.get());
  }
  
  public final void wm(int paramInt)
  {
    b localb = this.sZV;
    if (localb != null) {
      localb.a(this, paramInt);
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void a(aa paramaa, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i
 * JD-Core Version:    0.7.0.1
 */