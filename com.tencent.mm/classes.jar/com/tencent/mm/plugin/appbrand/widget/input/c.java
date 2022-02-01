package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.input.e.e;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.i;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class c<Input extends EditText,  extends af>
  extends i
  implements ae
{
  public final int uES;
  public final WeakReference<ad> uEU;
  public aj uFv;
  public ai uFw;
  final String uFx;
  public final View.OnFocusChangeListener uFy = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136308);
      if ((c.this.lz(paramAnonymousBoolean)) && (paramAnonymousBoolean))
      {
        o.a((ad)c.this.uEU.get(), (af)c.this.cQB());
        ((af)c.this.cQB()).setInputId(c.this.uES);
        o.b((ad)c.this.uEU.get(), c.this);
      }
      AppMethodBeat.o(136308);
    }
  };
  private final com.tencent.mm.ui.tools.b.c.a uFz = new p.a()
  {
    public final void eY(String paramAnonymousString)
    {
      AppMethodBeat.i(168762);
      if (c.this.cQB() != null) {
        c.a(c.this, c.this.cQB().getEditableText());
      }
      AppMethodBeat.o(168762);
    }
  };
  
  c(String paramString, ad paramad, int paramInt)
  {
    this.uFx = paramString;
    this.uEU = new WeakReference(paramad);
    this.uES = paramInt;
  }
  
  private void b(Editable paramEditable)
  {
    aj localaj;
    if (this.uFv != null)
    {
      localaj = this.uFv;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaj.a(str, Selection.getSelectionEnd(paramEditable), aj.a.uIE);
      return;
    }
  }
  
  public final boolean B(ad paramad)
  {
    return (paramad != null) && (paramad == this.uEU.get());
  }
  
  public final void Ej(int paramInt)
  {
    if (this.uFw != null) {
      this.uFw.El(paramInt);
    }
  }
  
  final void a(Editable paramEditable)
  {
    aj localaj;
    if (this.uFv != null)
    {
      localaj = this.uFv;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaj.a(str, Selection.getSelectionEnd(paramEditable), aj.a.uIC);
      return;
    }
  }
  
  final void a(Editable paramEditable, String paramString1, String paramString2)
  {
    aj localaj;
    if (this.uFv != null)
    {
      localaj = this.uFv;
      if (paramEditable != null) {
        break label37;
      }
    }
    label37:
    for (String str = "";; str = paramEditable.toString())
    {
      localaj.b(str, Selection.getSelectionEnd(paramEditable), paramString1, paramString2);
      return;
    }
  }
  
  public final void a(String paramString, Integer paramInteger)
  {
    agZ(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      fZ(paramString.intValue(), paramString.intValue());
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.widget.input.e.h paramh)
  {
    paramh = b(paramh);
    if (paramh == null) {}
    for (;;)
    {
      return false;
      if (paramh.uLI == null) {
        paramh.uLI = Integer.valueOf(140);
      }
      while (cQB() != null)
      {
        p.a(cQB()).aEg(paramh.uLI.intValue()).Nc(false).b(g.a.afIH).a(this.uFz);
        return true;
        if (paramh.uLI.intValue() <= 0) {
          paramh.uLI = Integer.valueOf(2147483647);
        }
      }
    }
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    b(paramEditable);
  }
  
  public abstract boolean agZ(String paramString);
  
  protected abstract com.tencent.mm.plugin.appbrand.widget.input.e.h b(com.tencent.mm.plugin.appbrand.widget.input.e.h paramh);
  
  public abstract Input cQB();
  
  public abstract Rect cQC();
  
  public final boolean cQD()
  {
    return remove();
  }
  
  public final Input cQE()
  {
    return cQB();
  }
  
  public Editable cQF()
  {
    if (cQB() == null) {
      return null;
    }
    return cQB().getEditableText();
  }
  
  protected final void cQJ()
  {
    ad localad = (ad)this.uEU.get();
    if ((localad != null) && (localad.tti != null)) {
      h.cQR().d(localad.tti);
    }
  }
  
  protected final void cQS()
  {
    ad localad = (ad)this.uEU.get();
    if ((localad != null) && (localad.tti != null)) {
      h.cQR().e(localad.tti);
    }
  }
  
  final void cQT()
  {
    k.a(this.uEU).En(this.uES);
  }
  
  final void cQU()
  {
    k.a(this.uEU).Em(this.uES);
  }
  
  protected final void fZ(int paramInt1, int paramInt2)
  {
    b.a(cQB(), paramInt1, paramInt2);
  }
  
  public final int getInputId()
  {
    return this.uES;
  }
  
  protected abstract boolean lz(boolean paramBoolean);
  
  public final boolean remove()
  {
    EditText localEditText = cQB();
    if (localEditText == null) {
      return false;
    }
    ((af)localEditText).b(this.uFy);
    localEditText.removeTextChangedListener(this);
    ((af)localEditText).destroy();
    ad localad = (ad)this.uEU.get();
    if (localad == null) {
      return false;
    }
    g localg = (g)localad.cEy();
    if (localg == null) {
      return false;
    }
    localg.ec(localEditText);
    o.b(localad, (af)localEditText);
    return true;
  }
  
  public static enum a
  {
    private static final androidx.b.b<a> uFC;
    
    static
    {
      AppMethodBeat.i(177116);
      uFD = new a[0];
      uFC = new androidx.b.b();
      AppMethodBeat.o(177116);
    }
    
    public static c a(String paramString, ad paramad, e parame)
    {
      AppMethodBeat.i(136312);
      Iterator localIterator = uFC.iterator();
      while (localIterator.hasNext())
      {
        c localc = ((a)localIterator.next()).cQK();
        if (localc != null)
        {
          AppMethodBeat.o(136312);
          return localc;
        }
      }
      if (("digit".equalsIgnoreCase(paramString)) || ("number".equalsIgnoreCase(paramString)) || ("idcard".equalsIgnoreCase(paramString)))
      {
        paramString = new d(paramString, paramad, parame);
        AppMethodBeat.o(136312);
        return paramString;
      }
      if ("safe-password".equalsIgnoreCase(paramString))
      {
        paramString = new w(paramString, paramad, parame);
        AppMethodBeat.o(136312);
        return paramString;
      }
      AppMethodBeat.o(136312);
      return null;
    }
    
    public static abstract interface a
    {
      public abstract c cQK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c
 * JD-Core Version:    0.7.0.1
 */