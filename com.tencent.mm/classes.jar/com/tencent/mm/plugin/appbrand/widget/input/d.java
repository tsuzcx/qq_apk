package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.Map;

final class d
  extends c<s>
{
  int nif;
  s nig;
  v nih;
  com.tencent.mm.plugin.appbrand.widget.input.d.h nii;
  boolean nij;
  boolean nik;
  
  d(String paramString, z paramz, e parame)
  {
    super(paramString, paramz, parame.nhX);
    AppMethodBeat.i(136314);
    this.nif = 0;
    this.nig = new s(paramz.getContext());
    this.nif = bu.a((Integer)o.njD.get(paramString), 0);
    AppMethodBeat.o(136314);
  }
  
  private v bEN()
  {
    AppMethodBeat.i(136325);
    if (this.nih != null)
    {
      localv = this.nih;
      AppMethodBeat.o(136325);
      return localv;
    }
    v localv = this.nig.getInputPanel();
    this.nih = localv;
    AppMethodBeat.o(136325);
    return localv;
  }
  
  private boolean isFocused()
  {
    AppMethodBeat.i(136323);
    if (this.nig == null)
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (this.nig.isFocused())
    {
      AppMethodBeat.o(136323);
      return true;
    }
    if (bEN() == null)
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (!bEN().isShown())
    {
      AppMethodBeat.o(136323);
      return false;
    }
    if (this.nih.getAttachedEditText() == this.nig)
    {
      AppMethodBeat.o(136323);
      return true;
    }
    AppMethodBeat.o(136323);
    return false;
  }
  
  public final boolean Wc(String paramString)
  {
    AppMethodBeat.i(136320);
    if (this.nig == null)
    {
      AppMethodBeat.o(136320);
      return false;
    }
    this.nig.C(paramString);
    AppMethodBeat.o(136320);
    return true;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.input.d.h b(com.tencent.mm.plugin.appbrand.widget.input.d.h paramh)
  {
    AppMethodBeat.i(136319);
    if (this.nii == null)
    {
      this.nii = paramh;
      if ((aj.i(paramh.noJ)) && (this.nig != null)) {
        this.nig.setPasswordMode(true);
      }
    }
    while (this.nig == null)
    {
      AppMethodBeat.o(136319);
      return null;
      this.nii.a(paramh);
    }
    b.a(this.nig, this.nii);
    paramh = this.nii;
    AppMethodBeat.o(136319);
    return paramh;
  }
  
  final Rect bEF()
  {
    AppMethodBeat.i(136318);
    Rect localRect = new Rect(this.nii.noh.intValue(), this.nii.nog.intValue(), this.nii.noh.intValue() + this.nii.noe.intValue(), this.nii.nog.intValue() + this.nii.nof.intValue());
    AppMethodBeat.o(136318);
    return localRect;
  }
  
  public final boolean bEK()
  {
    AppMethodBeat.i(136316);
    if ((this.nii != null) && (aj.i(this.nii.noB)))
    {
      AppMethodBeat.o(136316);
      return true;
    }
    AppMethodBeat.o(136316);
    return false;
  }
  
  public final int bEL()
  {
    AppMethodBeat.i(136317);
    if ((this.nii == null) || (this.nii.noy == null))
    {
      AppMethodBeat.o(136317);
      return 0;
    }
    int i = this.nii.noy.intValue();
    AppMethodBeat.o(136317);
    return i;
  }
  
  public final boolean bEM()
  {
    AppMethodBeat.i(136322);
    if (bEN() == null)
    {
      AppMethodBeat.o(136322);
      return false;
    }
    if (isFocused())
    {
      Object localObject = this.nih;
      ((v)localObject).setVisibility(8);
      ((v)localObject).bFp();
      ae.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", new Object[] { this.nig });
      if (this.nig != null)
      {
        this.nig.setFocusable(false);
        this.nig.setFocusableInTouchMode(false);
        this.nig.setEnabled(false);
      }
      localObject = (z)this.nhZ.get();
      if ((localObject != null) && (((z)localObject).mcJ != null)) {
        h.bEQ().e(((z)localObject).mcJ);
      }
      k.a(this.nhZ).wv(this.nhX);
      AppMethodBeat.o(136322);
      return true;
    }
    AppMethodBeat.o(136322);
    return false;
  }
  
  public final boolean ew(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136321);
    if (this.nig == null)
    {
      AppMethodBeat.o(136321);
      return false;
    }
    this.nih = v.dj(((z)this.nhZ.get()).kfr);
    if (this.nih == null)
    {
      AppMethodBeat.o(136321);
      return false;
    }
    this.nik = true;
    Object localObject = (z)this.nhZ.get();
    if ((localObject != null) && (((z)localObject).mcJ != null)) {
      h.bEQ().d(((z)localObject).mcJ);
    }
    this.nih.setXMode(this.nif);
    localObject = this.nih;
    s locals = this.nig;
    if (locals != null)
    {
      if (((v)localObject).mEditText != locals) {
        ((v)localObject).bFp();
      }
      ((v)localObject).setInputEditText(locals);
      ((v)localObject).setVisibility(0);
    }
    this.nih.setOnDoneListener(new v.a()
    {
      public final void onDone()
      {
        AppMethodBeat.i(136313);
        d.this.a(d.this.bER());
        d.this.jdMethod_if(false);
        AppMethodBeat.o(136313);
      }
    });
    ev(paramInt1, paramInt2);
    k.a(this.nhZ).wu(this.nhX);
    this.nik = false;
    AppMethodBeat.o(136321);
    return true;
  }
  
  public final View getInputPanel()
  {
    AppMethodBeat.i(136315);
    bEN();
    v localv = this.nih;
    AppMethodBeat.o(136315);
    return localv;
  }
  
  protected final boolean jdMethod_if(boolean paramBoolean)
  {
    AppMethodBeat.i(136324);
    ae.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(isFocused()) });
    if (!paramBoolean)
    {
      if (this.nij)
      {
        AppMethodBeat.o(136324);
        return true;
      }
      if (!isFocused())
      {
        AppMethodBeat.o(136324);
        return true;
      }
      this.nij = true;
      a(bER());
      bEM();
      remove();
      this.nij = false;
      this.nig = null;
    }
    for (;;)
    {
      AppMethodBeat.o(136324);
      return true;
      if (this.nik)
      {
        AppMethodBeat.o(136324);
        return true;
      }
      if (isFocused())
      {
        AppMethodBeat.o(136324);
        return true;
      }
      this.nik = true;
      ew(-2, -2);
      this.nik = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d
 * JD-Core Version:    0.7.0.1
 */