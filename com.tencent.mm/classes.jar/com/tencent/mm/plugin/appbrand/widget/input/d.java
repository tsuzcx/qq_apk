package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.Map;

final class d
  extends c<s>
{
  v maA;
  com.tencent.mm.plugin.appbrand.widget.input.d.h maB;
  boolean maC;
  boolean maD;
  int may;
  s maz;
  
  d(String paramString, aa paramaa, e parame)
  {
    super(paramString, paramaa, parame.mao);
    AppMethodBeat.i(136314);
    this.may = 0;
    this.maz = new s(paramaa.getContext());
    this.may = bt.a((Integer)o.mbY.get(paramString), 0);
    AppMethodBeat.o(136314);
  }
  
  private v bsT()
  {
    AppMethodBeat.i(136325);
    if (this.maA != null)
    {
      localv = this.maA;
      AppMethodBeat.o(136325);
      return localv;
    }
    v localv = this.maz.getInputPanel();
    this.maA = localv;
    AppMethodBeat.o(136325);
    return localv;
  }
  
  private boolean isFocused()
  {
    AppMethodBeat.i(136323);
    if (this.maz == null)
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (this.maz.isFocused())
    {
      AppMethodBeat.o(136323);
      return true;
    }
    if (bsT() == null)
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (!bsT().isShown())
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (this.maA.getAttachedEditText() == this.maz)
    {
      AppMethodBeat.o(136323);
      return true;
    }
    AppMethodBeat.o(136323);
    return false;
  }
  
  public final boolean NK(String paramString)
  {
    AppMethodBeat.i(136320);
    if (this.maz == null)
    {
      AppMethodBeat.o(136320);
      return false;
    }
    this.maz.D(paramString);
    AppMethodBeat.o(136320);
    return true;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.input.d.h b(com.tencent.mm.plugin.appbrand.widget.input.d.h paramh)
  {
    AppMethodBeat.i(136319);
    if (this.maB == null)
    {
      this.maB = paramh;
      if ((aj.g(paramh.mhe)) && (this.maz != null)) {
        this.maz.setPasswordMode(true);
      }
    }
    while (this.maz == null)
    {
      AppMethodBeat.o(136319);
      return null;
      this.maB.a(paramh);
    }
    b.a(this.maz, this.maB);
    paramh = this.maB;
    AppMethodBeat.o(136319);
    return paramh;
  }
  
  final Rect bsK()
  {
    AppMethodBeat.i(136318);
    Rect localRect = new Rect(this.maB.mgC.intValue(), this.maB.mgB.intValue(), this.maB.mgC.intValue() + this.maB.mgz.intValue(), this.maB.mgB.intValue() + this.maB.mgA.intValue());
    AppMethodBeat.o(136318);
    return localRect;
  }
  
  public final boolean bsQ()
  {
    AppMethodBeat.i(136316);
    if ((this.maB != null) && (aj.g(this.maB.mgW)))
    {
      AppMethodBeat.o(136316);
      return true;
    }
    AppMethodBeat.o(136316);
    return false;
  }
  
  public final int bsR()
  {
    AppMethodBeat.i(136317);
    if ((this.maB == null) || (this.maB.mgT == null))
    {
      AppMethodBeat.o(136317);
      return 0;
    }
    int i = this.maB.mgT.intValue();
    AppMethodBeat.o(136317);
    return i;
  }
  
  public final boolean bsS()
  {
    AppMethodBeat.i(136322);
    if (bsT() == null)
    {
      AppMethodBeat.o(136322);
      return false;
    }
    if (isFocused())
    {
      Object localObject = this.maA;
      ((v)localObject).setVisibility(8);
      ((v)localObject).btv();
      ad.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", new Object[] { this.maz });
      if (this.maz != null)
      {
        this.maz.setFocusable(false);
        this.maz.setFocusableInTouchMode(false);
        this.maz.setEnabled(false);
      }
      localObject = (aa)this.mar.get();
      if ((localObject != null) && (((aa)localObject).kWU != null)) {
        h.bsW().e(((aa)localObject).kWU);
      }
      k.a(this.mar).uU(this.mao);
      AppMethodBeat.o(136322);
      return true;
    }
    AppMethodBeat.o(136322);
    return false;
  }
  
  public final boolean er(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136321);
    if (this.maz == null)
    {
      AppMethodBeat.o(136321);
      return false;
    }
    this.maA = v.df(((aa)this.mar.get()).jhz);
    if (this.maA == null)
    {
      AppMethodBeat.o(136321);
      return false;
    }
    this.maD = true;
    Object localObject = (aa)this.mar.get();
    if ((localObject != null) && (((aa)localObject).kWU != null)) {
      h.bsW().d(((aa)localObject).kWU);
    }
    this.maA.setXMode(this.may);
    localObject = this.maA;
    s locals = this.maz;
    if (locals != null)
    {
      if (((v)localObject).mEditText != locals) {
        ((v)localObject).btv();
      }
      ((v)localObject).setInputEditText(locals);
      ((v)localObject).setVisibility(0);
    }
    this.maA.setOnDoneListener(new v.a()
    {
      public final void onDone()
      {
        AppMethodBeat.i(136313);
        d.this.a(d.this.fQZ());
        d.this.hA(false);
        AppMethodBeat.o(136313);
      }
    });
    ja(paramInt1, paramInt2);
    k.a(this.mar).uT(this.mao);
    this.maD = false;
    AppMethodBeat.o(136321);
    return true;
  }
  
  public final View getInputPanel()
  {
    AppMethodBeat.i(136315);
    bsT();
    v localv = this.maA;
    AppMethodBeat.o(136315);
    return localv;
  }
  
  protected final boolean hA(boolean paramBoolean)
  {
    AppMethodBeat.i(136324);
    ad.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(isFocused()) });
    if (!paramBoolean)
    {
      if (this.maC)
      {
        AppMethodBeat.o(136324);
        return true;
      }
      if (!isFocused())
      {
        AppMethodBeat.o(136324);
        return true;
      }
      this.maC = true;
      a(fQZ());
      bsS();
      bsN();
      this.maC = false;
      this.maz = null;
    }
    for (;;)
    {
      AppMethodBeat.o(136324);
      return true;
      if (this.maD)
      {
        AppMethodBeat.o(136324);
        return true;
      }
      if (isFocused())
      {
        AppMethodBeat.o(136324);
        return true;
      }
      this.maD = true;
      er(-2, -2);
      this.maD = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d
 * JD-Core Version:    0.7.0.1
 */