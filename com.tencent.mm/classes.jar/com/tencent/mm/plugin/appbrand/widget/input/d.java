package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.Map;

final class d
  extends c<s>
{
  boolean mCA;
  boolean mCB;
  int mCw;
  s mCx;
  v mCy;
  com.tencent.mm.plugin.appbrand.widget.input.d.h mCz;
  
  d(String paramString, aa paramaa, e parame)
  {
    super(paramString, paramaa, parame.mCo);
    AppMethodBeat.i(136314);
    this.mCw = 0;
    this.mCx = new s(paramaa.getContext());
    this.mCw = bs.a((Integer)o.mDW.get(paramString), 0);
    AppMethodBeat.o(136314);
  }
  
  private v bzT()
  {
    AppMethodBeat.i(136325);
    if (this.mCy != null)
    {
      localv = this.mCy;
      AppMethodBeat.o(136325);
      return localv;
    }
    v localv = this.mCx.getInputPanel();
    this.mCy = localv;
    AppMethodBeat.o(136325);
    return localv;
  }
  
  private boolean isFocused()
  {
    AppMethodBeat.i(136323);
    if (this.mCx == null)
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (this.mCx.isFocused())
    {
      AppMethodBeat.o(136323);
      return true;
    }
    if (bzT() == null)
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (!bzT().isShown())
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (this.mCy.getAttachedEditText() == this.mCx)
    {
      AppMethodBeat.o(136323);
      return true;
    }
    AppMethodBeat.o(136323);
    return false;
  }
  
  public final boolean RT(String paramString)
  {
    AppMethodBeat.i(136320);
    if (this.mCx == null)
    {
      AppMethodBeat.o(136320);
      return false;
    }
    this.mCx.D(paramString);
    AppMethodBeat.o(136320);
    return true;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.input.d.h b(com.tencent.mm.plugin.appbrand.widget.input.d.h paramh)
  {
    AppMethodBeat.i(136319);
    if (this.mCz == null)
    {
      this.mCz = paramh;
      if ((aj.g(paramh.mJf)) && (this.mCx != null)) {
        this.mCx.setPasswordMode(true);
      }
    }
    while (this.mCx == null)
    {
      AppMethodBeat.o(136319);
      return null;
      this.mCz.a(paramh);
    }
    b.a(this.mCx, this.mCz);
    paramh = this.mCz;
    AppMethodBeat.o(136319);
    return paramh;
  }
  
  final Rect bzK()
  {
    AppMethodBeat.i(136318);
    Rect localRect = new Rect(this.mCz.mIC.intValue(), this.mCz.mIB.intValue(), this.mCz.mIC.intValue() + this.mCz.mIz.intValue(), this.mCz.mIB.intValue() + this.mCz.mIA.intValue());
    AppMethodBeat.o(136318);
    return localRect;
  }
  
  public final boolean bzQ()
  {
    AppMethodBeat.i(136316);
    if ((this.mCz != null) && (aj.g(this.mCz.mIX)))
    {
      AppMethodBeat.o(136316);
      return true;
    }
    AppMethodBeat.o(136316);
    return false;
  }
  
  public final int bzR()
  {
    AppMethodBeat.i(136317);
    if ((this.mCz == null) || (this.mCz.mIU == null))
    {
      AppMethodBeat.o(136317);
      return 0;
    }
    int i = this.mCz.mIU.intValue();
    AppMethodBeat.o(136317);
    return i;
  }
  
  public final boolean bzS()
  {
    AppMethodBeat.i(136322);
    if (bzT() == null)
    {
      AppMethodBeat.o(136322);
      return false;
    }
    if (isFocused())
    {
      Object localObject = this.mCy;
      ((v)localObject).setVisibility(8);
      ((v)localObject).bAv();
      ac.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", new Object[] { this.mCx });
      if (this.mCx != null)
      {
        this.mCx.setFocusable(false);
        this.mCx.setFocusableInTouchMode(false);
        this.mCx.setEnabled(false);
      }
      localObject = (aa)this.mCq.get();
      if ((localObject != null) && (((aa)localObject).lyE != null)) {
        h.bzW().e(((aa)localObject).lyE);
      }
      k.a(this.mCq).vL(this.mCo);
      AppMethodBeat.o(136322);
      return true;
    }
    AppMethodBeat.o(136322);
    return false;
  }
  
  public final boolean eu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136321);
    if (this.mCx == null)
    {
      AppMethodBeat.o(136321);
      return false;
    }
    this.mCy = v.dh(((aa)this.mCq.get()).jHO);
    if (this.mCy == null)
    {
      AppMethodBeat.o(136321);
      return false;
    }
    this.mCB = true;
    Object localObject = (aa)this.mCq.get();
    if ((localObject != null) && (((aa)localObject).lyE != null)) {
      h.bzW().d(((aa)localObject).lyE);
    }
    this.mCy.setXMode(this.mCw);
    localObject = this.mCy;
    s locals = this.mCx;
    if (locals != null)
    {
      if (((v)localObject).mEditText != locals) {
        ((v)localObject).bAv();
      }
      ((v)localObject).setInputEditText(locals);
      ((v)localObject).setVisibility(0);
    }
    this.mCy.setOnDoneListener(new v.a()
    {
      public final void onDone()
      {
        AppMethodBeat.i(136313);
        d.this.a(d.this.bxZ());
        d.this.hY(false);
        AppMethodBeat.o(136313);
      }
    });
    et(paramInt1, paramInt2);
    k.a(this.mCq).vK(this.mCo);
    this.mCB = false;
    AppMethodBeat.o(136321);
    return true;
  }
  
  public final View getInputPanel()
  {
    AppMethodBeat.i(136315);
    bzT();
    v localv = this.mCy;
    AppMethodBeat.o(136315);
    return localv;
  }
  
  protected final boolean hY(boolean paramBoolean)
  {
    AppMethodBeat.i(136324);
    ac.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(isFocused()) });
    if (!paramBoolean)
    {
      if (this.mCA)
      {
        AppMethodBeat.o(136324);
        return true;
      }
      if (!isFocused())
      {
        AppMethodBeat.o(136324);
        return true;
      }
      this.mCA = true;
      a(bxZ());
      bzS();
      bzN();
      this.mCA = false;
      this.mCx = null;
    }
    for (;;)
    {
      AppMethodBeat.o(136324);
      return true;
      if (this.mCB)
      {
        AppMethodBeat.o(136324);
        return true;
      }
      if (isFocused())
      {
        AppMethodBeat.o(136324);
        return true;
      }
      this.mCB = true;
      eu(-2, -2);
      this.mCB = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d
 * JD-Core Version:    0.7.0.1
 */