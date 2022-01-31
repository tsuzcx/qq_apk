package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Map;

final class d
  extends c<s>
{
  int jkI;
  s jkJ;
  v jkK;
  com.tencent.mm.plugin.appbrand.widget.input.d.h jkL;
  boolean jkM;
  boolean jkN;
  
  d(String paramString, com.tencent.mm.plugin.appbrand.page.v paramv, e parame)
  {
    super(paramString, paramv, parame.jkB);
    AppMethodBeat.i(123583);
    this.jkI = 0;
    this.jkJ = new s(paramv.getContext());
    this.jkI = bo.a((Integer)o.jmi.get(paramString), 0);
    AppMethodBeat.o(123583);
  }
  
  private v aQC()
  {
    AppMethodBeat.i(123594);
    if (this.jkK != null)
    {
      localv = this.jkK;
      AppMethodBeat.o(123594);
      return localv;
    }
    v localv = this.jkJ.getInputPanel();
    this.jkK = localv;
    AppMethodBeat.o(123594);
    return localv;
  }
  
  private boolean isFocused()
  {
    AppMethodBeat.i(123592);
    if (this.jkJ == null)
    {
      AppMethodBeat.o(123592);
      return false;
    }
    if (this.jkJ.isFocused())
    {
      AppMethodBeat.o(123592);
      return true;
    }
    if (aQC() == null)
    {
      AppMethodBeat.o(123592);
      return false;
    }
    if (!aQC().isShown())
    {
      AppMethodBeat.o(123592);
      return false;
    }
    if (this.jkK.getAttachedEditText() == this.jkJ)
    {
      AppMethodBeat.o(123592);
      return true;
    }
    AppMethodBeat.o(123592);
    return false;
  }
  
  public final boolean FN(String paramString)
  {
    AppMethodBeat.i(123589);
    if (this.jkJ == null)
    {
      AppMethodBeat.o(123589);
      return false;
    }
    this.jkJ.z(paramString);
    AppMethodBeat.o(123589);
    return true;
  }
  
  public final int aQA()
  {
    AppMethodBeat.i(123586);
    if ((this.jkL == null) || (this.jkL.jrc == null))
    {
      AppMethodBeat.o(123586);
      return 0;
    }
    int i = this.jkL.jrc.intValue();
    AppMethodBeat.o(123586);
    return i;
  }
  
  public final boolean aQB()
  {
    AppMethodBeat.i(123591);
    if (aQC() == null)
    {
      AppMethodBeat.o(123591);
      return false;
    }
    if (isFocused())
    {
      Object localObject = this.jkK;
      ((v)localObject).setVisibility(8);
      ((v)localObject).aRe();
      ab.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", new Object[] { this.jkJ });
      if (this.jkJ != null)
      {
        this.jkJ.setFocusable(false);
        this.jkJ.setFocusableInTouchMode(false);
        this.jkJ.setEnabled(false);
      }
      localObject = (com.tencent.mm.plugin.appbrand.page.v)this.jkD.get();
      if ((localObject != null) && (((com.tencent.mm.plugin.appbrand.page.v)localObject).iuy != null)) {
        h.aQF().d(((com.tencent.mm.plugin.appbrand.page.v)localObject).iuy);
      }
      k.a(this.jkD).qs(this.jkB);
      AppMethodBeat.o(123591);
      return true;
    }
    AppMethodBeat.o(123591);
    return false;
  }
  
  final Rect aQu()
  {
    AppMethodBeat.i(123587);
    Rect localRect = new Rect(this.jkL.jqL.intValue(), this.jkL.jqK.intValue(), this.jkL.jqL.intValue() + this.jkL.jqI.intValue(), this.jkL.jqK.intValue() + this.jkL.jqJ.intValue());
    AppMethodBeat.o(123587);
    return localRect;
  }
  
  public final boolean aQz()
  {
    AppMethodBeat.i(123585);
    if ((this.jkL != null) && (aj.g(this.jkL.jrf)))
    {
      AppMethodBeat.o(123585);
      return true;
    }
    AppMethodBeat.o(123585);
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.input.d.h b(com.tencent.mm.plugin.appbrand.widget.input.d.h paramh)
  {
    AppMethodBeat.i(123588);
    if (this.jkL == null)
    {
      this.jkL = paramh;
      if ((aj.g(paramh.jrn)) && (this.jkJ != null)) {
        this.jkJ.setPasswordMode(true);
      }
    }
    while (this.jkJ == null)
    {
      AppMethodBeat.o(123588);
      return null;
      this.jkL.a(paramh);
    }
    b.a(this.jkJ, this.jkL);
    paramh = this.jkL;
    AppMethodBeat.o(123588);
    return paramh;
  }
  
  public final boolean dw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123590);
    if (this.jkJ == null)
    {
      AppMethodBeat.o(123590);
      return false;
    }
    this.jkK = v.cP(((com.tencent.mm.plugin.appbrand.page.v)this.jkD.get()).hmw);
    if (this.jkK == null)
    {
      AppMethodBeat.o(123590);
      return false;
    }
    this.jkN = true;
    Object localObject = (com.tencent.mm.plugin.appbrand.page.v)this.jkD.get();
    if ((localObject != null) && (((com.tencent.mm.plugin.appbrand.page.v)localObject).iuy != null)) {
      h.aQF().c(((com.tencent.mm.plugin.appbrand.page.v)localObject).iuy);
    }
    this.jkK.setXMode(this.jkI);
    localObject = this.jkK;
    s locals = this.jkJ;
    if (locals != null)
    {
      if (((v)localObject).mEditText != locals) {
        ((v)localObject).aRe();
      }
      ((v)localObject).setInputEditText(locals);
      ((v)localObject).setVisibility(0);
    }
    this.jkK.setOnDoneListener(new v.a()
    {
      public final void onDone()
      {
        AppMethodBeat.i(123582);
        d.this.a(d.this.aQH());
        d.this.fo(false);
        AppMethodBeat.o(123582);
      }
    });
    dv(paramInt1, paramInt2);
    k.a(this.jkD).qr(this.jkB);
    this.jkN = false;
    AppMethodBeat.o(123590);
    return true;
  }
  
  protected final boolean fo(boolean paramBoolean)
  {
    AppMethodBeat.i(123593);
    ab.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(isFocused()) });
    if (!paramBoolean)
    {
      if (this.jkM)
      {
        AppMethodBeat.o(123593);
        return true;
      }
      if (!isFocused())
      {
        AppMethodBeat.o(123593);
        return true;
      }
      this.jkM = true;
      a(aQH());
      aQB();
      aQx();
      this.jkM = false;
      this.jkJ = null;
    }
    for (;;)
    {
      AppMethodBeat.o(123593);
      return true;
      if (this.jkN)
      {
        AppMethodBeat.o(123593);
        return true;
      }
      if (isFocused())
      {
        AppMethodBeat.o(123593);
        return true;
      }
      this.jkN = true;
      dw(-2, -2);
      this.jkN = false;
    }
  }
  
  public final View getInputPanel()
  {
    AppMethodBeat.i(123584);
    aQC();
    v localv = this.jkK;
    AppMethodBeat.o(123584);
    return localv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d
 * JD-Core Version:    0.7.0.1
 */