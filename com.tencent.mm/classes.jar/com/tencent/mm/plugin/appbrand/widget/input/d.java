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
  int ncW;
  s ncX;
  v ncY;
  com.tencent.mm.plugin.appbrand.widget.input.d.h ncZ;
  boolean nda;
  boolean ndb;
  
  d(String paramString, aa paramaa, e parame)
  {
    super(paramString, paramaa, parame.ncO);
    AppMethodBeat.i(136314);
    this.ncW = 0;
    this.ncX = new s(paramaa.getContext());
    this.ncW = bt.a((Integer)o.nev.get(paramString), 0);
    AppMethodBeat.o(136314);
  }
  
  private v bDV()
  {
    AppMethodBeat.i(136325);
    if (this.ncY != null)
    {
      localv = this.ncY;
      AppMethodBeat.o(136325);
      return localv;
    }
    v localv = this.ncX.getInputPanel();
    this.ncY = localv;
    AppMethodBeat.o(136325);
    return localv;
  }
  
  private boolean isFocused()
  {
    AppMethodBeat.i(136323);
    if (this.ncX == null)
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (this.ncX.isFocused())
    {
      AppMethodBeat.o(136323);
      return true;
    }
    if (bDV() == null)
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (!bDV().isShown())
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (this.ncY.getAttachedEditText() == this.ncX)
    {
      AppMethodBeat.o(136323);
      return true;
    }
    AppMethodBeat.o(136323);
    return false;
  }
  
  public final boolean Vq(String paramString)
  {
    AppMethodBeat.i(136320);
    if (this.ncX == null)
    {
      AppMethodBeat.o(136320);
      return false;
    }
    this.ncX.D(paramString);
    AppMethodBeat.o(136320);
    return true;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.input.d.h b(com.tencent.mm.plugin.appbrand.widget.input.d.h paramh)
  {
    AppMethodBeat.i(136319);
    if (this.ncZ == null)
    {
      this.ncZ = paramh;
      if ((aj.i(paramh.njB)) && (this.ncX != null)) {
        this.ncX.setPasswordMode(true);
      }
    }
    while (this.ncX == null)
    {
      AppMethodBeat.o(136319);
      return null;
      this.ncZ.a(paramh);
    }
    b.a(this.ncX, this.ncZ);
    paramh = this.ncZ;
    AppMethodBeat.o(136319);
    return paramh;
  }
  
  final Rect bDN()
  {
    AppMethodBeat.i(136318);
    Rect localRect = new Rect(this.ncZ.niZ.intValue(), this.ncZ.niY.intValue(), this.ncZ.niZ.intValue() + this.ncZ.niW.intValue(), this.ncZ.niY.intValue() + this.ncZ.niX.intValue());
    AppMethodBeat.o(136318);
    return localRect;
  }
  
  public final boolean bDS()
  {
    AppMethodBeat.i(136316);
    if ((this.ncZ != null) && (aj.i(this.ncZ.njt)))
    {
      AppMethodBeat.o(136316);
      return true;
    }
    AppMethodBeat.o(136316);
    return false;
  }
  
  public final int bDT()
  {
    AppMethodBeat.i(136317);
    if ((this.ncZ == null) || (this.ncZ.njq == null))
    {
      AppMethodBeat.o(136317);
      return 0;
    }
    int i = this.ncZ.njq.intValue();
    AppMethodBeat.o(136317);
    return i;
  }
  
  public final boolean bDU()
  {
    AppMethodBeat.i(136322);
    if (bDV() == null)
    {
      AppMethodBeat.o(136322);
      return false;
    }
    if (isFocused())
    {
      Object localObject = this.ncY;
      ((v)localObject).setVisibility(8);
      ((v)localObject).bEx();
      ad.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", new Object[] { this.ncX });
      if (this.ncX != null)
      {
        this.ncX.setFocusable(false);
        this.ncX.setFocusableInTouchMode(false);
        this.ncX.setEnabled(false);
      }
      localObject = (aa)this.ncQ.get();
      if ((localObject != null) && (((aa)localObject).lYc != null)) {
        h.bDY().e(((aa)localObject).lYc);
      }
      k.a(this.ncQ).wq(this.ncO);
      AppMethodBeat.o(136322);
      return true;
    }
    AppMethodBeat.o(136322);
    return false;
  }
  
  public final boolean ew(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136321);
    if (this.ncX == null)
    {
      AppMethodBeat.o(136321);
      return false;
    }
    this.ncY = v.dj(((aa)this.ncQ.get()).kca);
    if (this.ncY == null)
    {
      AppMethodBeat.o(136321);
      return false;
    }
    this.ndb = true;
    Object localObject = (aa)this.ncQ.get();
    if ((localObject != null) && (((aa)localObject).lYc != null)) {
      h.bDY().d(((aa)localObject).lYc);
    }
    this.ncY.setXMode(this.ncW);
    localObject = this.ncY;
    s locals = this.ncX;
    if (locals != null)
    {
      if (((v)localObject).mEditText != locals) {
        ((v)localObject).bEx();
      }
      ((v)localObject).setInputEditText(locals);
      ((v)localObject).setVisibility(0);
    }
    this.ncY.setOnDoneListener(new v.a()
    {
      public final void onDone()
      {
        AppMethodBeat.i(136313);
        d.this.a(d.this.aUP());
        d.this.ih(false);
        AppMethodBeat.o(136313);
      }
    });
    eu(paramInt1, paramInt2);
    k.a(this.ncQ).wp(this.ncO);
    this.ndb = false;
    AppMethodBeat.o(136321);
    return true;
  }
  
  public final View getInputPanel()
  {
    AppMethodBeat.i(136315);
    bDV();
    v localv = this.ncY;
    AppMethodBeat.o(136315);
    return localv;
  }
  
  protected final boolean ih(boolean paramBoolean)
  {
    AppMethodBeat.i(136324);
    ad.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(isFocused()) });
    if (!paramBoolean)
    {
      if (this.nda)
      {
        AppMethodBeat.o(136324);
        return true;
      }
      if (!isFocused())
      {
        AppMethodBeat.o(136324);
        return true;
      }
      this.nda = true;
      a(aUP());
      bDU();
      remove();
      this.nda = false;
      this.ncX = null;
    }
    for (;;)
    {
      AppMethodBeat.o(136324);
      return true;
      if (this.ndb)
      {
        AppMethodBeat.o(136324);
        return true;
      }
      if (isFocused())
      {
        AppMethodBeat.o(136324);
        return true;
      }
      this.ndb = true;
      ew(-2, -2);
      this.ndb = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d
 * JD-Core Version:    0.7.0.1
 */