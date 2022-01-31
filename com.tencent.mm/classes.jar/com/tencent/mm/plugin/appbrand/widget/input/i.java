package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.os.Looper;
import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import java.util.Locale;
import junit.framework.Assert;

public abstract class i
  implements aa<y>
{
  private final c.a jkF = new i.12(this);
  public volatile i.c jlb;
  private volatile i.a jlc;
  public volatile i.b jld;
  final View.OnFocusChangeListener jle = new i.11(this);
  private int jlf = -1;
  private int jlg = -1;
  i.d jlh = null;
  public com.tencent.mm.plugin.appbrand.widget.input.d.e jli;
  protected WeakReference<com.tencent.mm.plugin.appbrand.page.v> jlj;
  public int jlk;
  public y jll;
  w jlm;
  private v jln;
  private final Runnable jlo = new i.13(this);
  public final com.tencent.mm.plugin.appbrand.widget.input.c.a jlp = new com.tencent.mm.plugin.appbrand.widget.input.c.a();
  boolean jlq = false;
  final Runnable jlr = new i.14(this);
  final ak jls = new ak(Looper.getMainLooper());
  private final w.d jlt = new i.6(this);
  private final w.c jlu = new i.7(this);
  private final w.e jlv = new i.8(this);
  
  private v aQC()
  {
    if (this.jln != null) {
      return this.jln;
    }
    if (this.jlj != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.v)this.jlj.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    Object localObject = v.cO(((com.tencent.mm.plugin.appbrand.page.v)localObject).hmw);
    this.jln = ((v)localObject);
    return localObject;
  }
  
  private void aQK()
  {
    if (this.jll == null) {
      break label7;
    }
    label7:
    while ((this.jll.getLineCount() == this.jlf) && (this.jll.aRp() == this.jlg)) {
      return;
    }
    if (this.jlf == -1) {}
    for (int i = 1;; i = 0)
    {
      this.jlf = this.jll.getLineCount();
      this.jlg = this.jll.aRp();
      if (this.jlb != null) {
        this.jlb.dh(this.jlf, this.jlg);
      }
      if ((!this.jli.jqY.booleanValue()) || (i != 0)) {
        break;
      }
      aQI();
      aQL();
      return;
    }
  }
  
  private void aQL()
  {
    if ((this.jli.jqY.booleanValue()) && (this.jlm != null) && (this.jlm.isShown()) && (this.jll != null) && (this.jll == this.jlm.getAttachedEditText())) {
      k.a(this.jlj).qr(this.jlk);
    }
  }
  
  private void aQM()
  {
    if (this.jli.jqY.booleanValue()) {
      bla();
    }
    if ((this.jlm != null) && (this.jll != null))
    {
      this.jlm.jnn = this.jll;
      this.jlm.setShowDoneButton(aj.g(this.jli.jqZ));
      aQP();
      if ((com.tencent.mm.plugin.appbrand.ui.o.cy(this.jll)) && (this.jll.hasFocus())) {
        this.jlm.show();
      }
    }
  }
  
  private void aQN()
  {
    this.jlm.b(this.jll);
    a(this.jll);
    this.jll.destroy();
    onDestroy();
  }
  
  private void aQO()
  {
    boolean bool3 = true;
    com.tencent.mm.plugin.appbrand.page.v localv;
    boolean bool1;
    label33:
    boolean bool2;
    if (this.jlj == null)
    {
      localv = null;
      if (this.jlm == null) {
        bla();
      }
      if (this.jll != null) {
        break label116;
      }
      bool1 = true;
      if (localv != null) {
        break label121;
      }
      bool2 = true;
      label40:
      if (this.jlm != null) {
        break label126;
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, null==mInput[%b], null==page[%b], null==mSmileyPanel[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((localv != null) && (this.jll != null) && (this.jlm != null)) {
        break label131;
      }
      return;
      localv = (com.tencent.mm.plugin.appbrand.page.v)this.jlj.get();
      break;
      label116:
      bool1 = false;
      break label33;
      label121:
      bool2 = false;
      break label40;
      label126:
      bool3 = false;
    }
    label131:
    o.a(localv, this.jll);
    final PBool localPBool = new PBool();
    localPBool.value = false;
    final i.3 local3 = new i.3(this, localPBool);
    Object localObject = com.tencent.mm.sdk.f.a.hr(localv.getContext());
    if ((localObject != null) && (((Activity)localObject).getCurrentFocus() != null))
    {
      localObject = ((Activity)localObject).getCurrentFocus();
      bool1 = aj.cV((View)localObject).isActive((View)localObject);
      bool2 = aj.f(localv.iuy.getWrapperView(), (View)localObject);
      if ((bool1) && (bool2))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, servedConnecting && servedForWebView, delay checkForInput");
        this.jlm.setOnVisibilityChangedListener(new w.e()
        {
          public final void fq(int paramAnonymousInt)
          {
            AppMethodBeat.i(141604);
            if ((localPBool.value) || (paramAnonymousInt != 2))
            {
              AppMethodBeat.o(141604);
              return;
            }
            local3.run();
            AppMethodBeat.o(141604);
          }
        });
        com.tencent.mm.sdk.g.d.ysm.s(new i.5(this, localPBool, local3), 100L);
        return;
      }
    }
    local3.run();
  }
  
  private void aQP()
  {
    if (this.jlm == null) {
      return;
    }
    this.jlm.setOnSmileyChosenListener(this.jlt);
    this.jlm.setOnDoneListener(this.jlu);
    this.jlm.setOnVisibilityChangedListener(this.jlv);
  }
  
  private void aQQ()
  {
    Object localObject = (com.tencent.mm.plugin.appbrand.page.v)this.jlj.get();
    if (!android.support.v4.view.t.aw(((com.tencent.mm.plugin.appbrand.page.v)localObject).hmw)) {}
    label169:
    label300:
    label324:
    for (;;)
    {
      return;
      this.jlm = w.cR(((com.tencent.mm.plugin.appbrand.page.v)localObject).hmw);
      if (this.jli.jqE)
      {
        aQP();
        bEh();
      }
      this.jll.a(this.jle);
      this.jll.setOnKeyListener(new i.9(this));
      if (this.jli.jqE) {
        o.a((com.tencent.mm.plugin.appbrand.page.v)this.jlj.get(), this.jll);
      }
      localObject = this.jlm;
      boolean bool;
      if ((!this.jli.jqD) && ("emoji".equals(this.jli.jqC)))
      {
        bool = true;
        ((w)localObject).setCanSmileyInput(bool);
        if (this.jli.jqY.booleanValue()) {
          break label281;
        }
        if (this.jli.jrd != null) {
          break label270;
        }
        localObject = com.tencent.mm.plugin.appbrand.widget.input.d.b.aRP();
        int i = ((com.tencent.mm.plugin.appbrand.widget.input.d.b)localObject).jqw;
        this.jll.setImeOptions(i);
        this.jll.setOnEditorActionListener(new i.10(this, i));
        label198:
        this.jlm.setShowDoneButton(this.jli.jqZ.booleanValue());
        this.jlm.jnn = this.jll;
        if (!this.jli.jqE) {
          break label300;
        }
        aQO();
      }
      for (;;)
      {
        if (!this.jli.jqE) {
          break label324;
        }
        k.a(this.jlj).qr(this.jlk);
        return;
        bool = false;
        break;
        localObject = this.jli.jrd;
        break label169;
        this.jll.setOnEditorActionListener(null);
        this.jll.setImeOptions(0);
        break label198;
        this.jll.setFocusable(false);
        this.jll.setFocusableInTouchMode(false);
        this.jlm.hide();
      }
    }
  }
  
  private void bEh()
  {
    if (aQC() != null) {
      this.jln.setVisibility(8);
    }
  }
  
  private w bla()
  {
    if (this.jlm != null) {
      return this.jlm;
    }
    if (this.jlj != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.v)this.jlj.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    Object localObject = w.cQ(((com.tencent.mm.plugin.appbrand.page.v)localObject).hmw);
    this.jlm = ((w)localObject);
    return localObject;
  }
  
  private void dv(int paramInt1, int paramInt2)
  {
    b.a(this.jll, paramInt1, paramInt2);
    aQL();
  }
  
  private void fp(boolean paramBoolean)
  {
    if (this.jll == null) {
      return;
    }
    String str = this.jll.getText().toString();
    int i = this.jll.getSelectionEnd();
    if (this.jlh == i.d.jlB) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, i, bool, paramBoolean);
      return;
    }
  }
  
  private void onDestroy()
  {
    this.jll = null;
    com.tencent.mm.plugin.appbrand.t.e.ai(this);
  }
  
  public abstract void Cb(String paramString);
  
  void a(y paramy)
  {
    if (paramy == null) {}
    label58:
    for (;;)
    {
      return;
      paramy.b(this.jle);
      if (this.jlj == null) {}
      for (Object localObject = null;; localObject = (com.tencent.mm.plugin.appbrand.page.v)this.jlj.get())
      {
        if (localObject == null) {
          break label58;
        }
        localObject = (g)((com.tencent.mm.plugin.appbrand.page.v)localObject).aJk();
        if (localObject == null) {
          break;
        }
        ((g)localObject).cI(paramy);
        return;
      }
    }
  }
  
  public abstract void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public final void a(String paramString, Integer paramInteger)
  {
    if (this.jll == null) {
      return;
    }
    this.jll.z(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      dv(paramString.intValue(), paramString.intValue());
      aQK();
      return;
    }
  }
  
  boolean a(y paramy, com.tencent.mm.plugin.appbrand.widget.input.d.e parame)
  {
    if ((paramy == null) || (this.jlj == null) || (this.jlj.get() == null)) {
      return false;
    }
    g localg = (g)((com.tencent.mm.plugin.appbrand.page.v)this.jlj.get()).aJk();
    return (localg != null) && (localg.a(((com.tencent.mm.plugin.appbrand.page.v)this.jlj.get()).iuy, paramy, parame.jqI.intValue(), parame.jqJ.intValue(), parame.jqL.intValue(), parame.jqK.intValue()));
  }
  
  public abstract void aDc();
  
  public abstract void aDd();
  
  public final int aQA()
  {
    if ((this.jli != null) && (this.jli.jrc != null)) {
      return this.jli.jrc.intValue();
    }
    if ((this.jll != null) && (this.jll.aQX())) {
      return 5;
    }
    return 0;
  }
  
  public final boolean aQB()
  {
    int i;
    if ((this.jll != null) && ((this.jll.isFocused()) || ((bla() != null) && (bla().getAttachedEditText() == this.jll))))
    {
      i = 1;
      if (i != 0) {
        break label60;
      }
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AppBrandInputInvokeHandler", "doHideKeyboard, not focused, return");
    }
    label60:
    w localw;
    do
    {
      return true;
      i = 0;
      break;
      localw = bla();
    } while (localw == null);
    localw.setVisibility(8);
    return true;
  }
  
  final void aQI()
  {
    int k;
    int i;
    if ((this.jll != null) && (aj.g(this.jli.jra)) && (aj.g(this.jli.jqY)))
    {
      ((q)this.jll).setAutoHeight(true);
      j = this.jll.getLineHeight();
      k = this.jll.aRp();
      if ((this.jli.jqM != null) && (this.jli.jqM.intValue() > 0)) {
        break label161;
      }
      i = j;
      if ((this.jli.jqN != null) && (this.jli.jqN.intValue() > 0)) {
        break label175;
      }
    }
    label161:
    label175:
    for (int j = 2147483647;; j = Math.max(this.jli.jqN.intValue(), j))
    {
      this.jll.setMinHeight(i);
      this.jll.setMaxHeight(j);
      this.jli.jqJ = Integer.valueOf(Math.max(i, Math.min(k, j)));
      b(this.jll, this.jli);
      return;
      i = this.jli.jqM.intValue();
      break;
    }
  }
  
  public final void aQJ()
  {
    b.a(this.jll, this.jli);
    if (this.jli.jqR == null)
    {
      this.jli.jqR = Integer.valueOf(140);
      c localc = p.a(this.jll).QS(this.jli.jqR.intValue());
      localc.AyD = false;
      localc.jmp = f.a.Avm;
      localc.a(this.jkF);
      this.jll.setPasswordMode(this.jli.jqD);
      if (!aj.g(this.jli.jqW)) {
        break label236;
      }
      this.jll.setEnabled(false);
      this.jll.setFocusable(false);
      this.jll.setFocusableInTouchMode(false);
      this.jll.setClickable(false);
    }
    for (;;)
    {
      if ((this.jll instanceof q))
      {
        if (this.jli.jrg != null) {
          ((q)this.jll).setLineSpace(this.jli.jrg.intValue());
        }
        if (this.jli.jrh != null) {
          ((q)this.jll).setLineHeight(this.jli.jrh.intValue());
        }
      }
      return;
      if (this.jli.jqR.intValue() > 0) {
        break;
      }
      this.jli.jqR = Integer.valueOf(2147483647);
      break;
      label236:
      this.jll.setEnabled(true);
      this.jll.setClickable(true);
    }
  }
  
  public final boolean aQv()
  {
    int i;
    if ((this.jll == null) || (this.jlj == null) || (this.jlj.get() == null)) {
      i = 0;
    }
    while (i != 0)
    {
      onDestroy();
      return true;
      this.jll.destroy();
      g localg = (g)((com.tencent.mm.plugin.appbrand.page.v)this.jlj.get()).aJk();
      if (localg == null)
      {
        i = 0;
      }
      else
      {
        if (this.jll.hasFocus())
        {
          if (this.jln != null) {
            this.jln.setVisibility(8);
          }
          bla();
          if (this.jlm != null) {
            this.jlm.setVisibility(8);
          }
        }
        localg.cI(this.jll);
        i = 1;
      }
    }
    return false;
  }
  
  public final boolean aQz()
  {
    return (this.jli != null) && (aj.g(this.jli.jrf));
  }
  
  public boolean b(y paramy, com.tencent.mm.plugin.appbrand.widget.input.d.e parame)
  {
    if ((paramy == null) || (this.jlj == null) || (this.jlj.get() == null)) {
      return false;
    }
    g localg = (g)((com.tencent.mm.plugin.appbrand.page.v)this.jlj.get()).aJk();
    return (localg != null) && (localg.c(((com.tencent.mm.plugin.appbrand.page.v)this.jlj.get()).iuy, paramy, parame.jqI.intValue(), parame.jqJ.intValue(), parame.jqL.intValue(), parame.jqK.intValue()));
  }
  
  public final boolean dw(int paramInt1, int paramInt2)
  {
    if ((this.jll == null) || (this.jlj == null) || (this.jlj.get() == null)) {}
    for (;;)
    {
      dv(paramInt1, paramInt2);
      return true;
      this.jll.performClick();
    }
  }
  
  public final void dx(int paramInt1, int paramInt2)
  {
    this.jlj = this.jli.jkD;
    if (this.jlj == null) {}
    for (com.tencent.mm.plugin.appbrand.page.v localv = null; (localv == null) || (localv.iuy == null); localv = (com.tencent.mm.plugin.appbrand.page.v)this.jlj.get())
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
      aDd();
      return;
    }
    if (aj.g(this.jli.jqY)) {}
    for (Object localObject = new q(localv.getContext());; localObject = new t(localv.getContext()))
    {
      this.jll = ((y)localObject);
      this.jlk = this.jli.jkB;
      this.jll.setInputId(this.jlk);
      o.b(localv, this);
      aQJ();
      this.jll.setText(bo.nullAsNil(this.jli.jqH));
      if (aj.g(this.jli.jra)) {
        aQK();
      }
      this.jll.addTextChangedListener(new com.tencent.mm.ui.widget.g()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(141614);
          if ((i.this.jlj == null) || (i.this.jlj.get() == null) || (i.this.jll == null))
          {
            AppMethodBeat.o(141614);
            return;
          }
          i.b(i.this);
          if (aj.B(paramAnonymousEditable))
          {
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", new Object[] { paramAnonymousEditable });
            AppMethodBeat.o(141614);
            return;
          }
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", new Object[] { paramAnonymousEditable });
          paramAnonymousEditable = i.this.jll.getEditableText();
          i.this.jlp.a(paramAnonymousEditable, i.this.jlq);
          AppMethodBeat.o(141614);
        }
      });
      this.jll.setOnComposingDismissedListener(new com.tencent.mm.plugin.appbrand.widget.input.c.b()
      {
        public final void vo()
        {
          AppMethodBeat.i(141615);
          if (i.this.jll == null)
          {
            AppMethodBeat.o(141615);
            return;
          }
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", new Object[] { i.this.jll.getEditableText() });
          i.this.jlp.a(i.this.jll.getEditableText(), false);
          AppMethodBeat.o(141615);
        }
      });
      this.jll.setOnKeyUpPostImeListener(new ab.b()
      {
        public final boolean qp(int paramAnonymousInt)
        {
          AppMethodBeat.i(141616);
          if (paramAnonymousInt == 67)
          {
            if (aj.B(i.this.jll.getText()))
            {
              AppMethodBeat.o(141616);
              return false;
            }
            i.this.Cb(i.this.jll.getText().toString());
            AppMethodBeat.o(141616);
            return true;
          }
          AppMethodBeat.o(141616);
          return false;
        }
      });
      if (a(this.jll, this.jli)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
      aDd();
      return;
    }
    if ((this.jli.jqG != null) && (!bo.es(this.jli.jqG.jqq))) {
      com.tencent.mm.plugin.appbrand.widget.input.autofill.d.a(localv, this.jll, this.jli.jqG);
    }
    if (!aj.g(this.jli.jqY)) {
      b.a(this.jll, paramInt1, paramInt2);
    }
    if (aj.g(this.jli.jqY)) {
      this.jll.post(new i.18(this));
    }
    if (("text".equalsIgnoreCase(this.jli.jqC)) || ("emoji".equalsIgnoreCase(this.jli.jqC))) {
      aQQ();
    }
    for (;;)
    {
      this.jll.setOnClickListener(new i.2(this));
      aDc();
      return;
      Assert.assertTrue(String.format(Locale.US, "Unrecognized type(%s) implementation removed from here", new Object[] { this.jli.jqC }), true);
      aQQ();
    }
  }
  
  public final int getInputId()
  {
    return this.jlk;
  }
  
  public final <P extends View,  extends ac> P getInputPanel()
  {
    return this.jlm;
  }
  
  public final boolean n(com.tencent.mm.plugin.appbrand.page.v paramv)
  {
    return (paramv != null) && (this.jlj != null) && (paramv == this.jlj.get());
  }
  
  public final void qo(int paramInt)
  {
    i.b localb = this.jld;
    if (localb != null) {
      localb.a(this, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i
 * JD-Core Version:    0.7.0.1
 */