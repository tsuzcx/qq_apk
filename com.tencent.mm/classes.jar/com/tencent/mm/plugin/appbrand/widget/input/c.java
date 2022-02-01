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
  public final int rtN;
  public final WeakReference<ad> rtP;
  public aj ruD;
  public ai ruE;
  final String ruF;
  public final View.OnFocusChangeListener ruG = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136308);
      c.this.kn(paramAnonymousBoolean);
      if (paramAnonymousBoolean)
      {
        o.a((ad)c.this.rtP.get(), (af)c.this.cnZ());
        ((af)c.this.cnZ()).setInputId(c.this.rtN);
        o.b((ad)c.this.rtP.get(), c.this);
      }
      AppMethodBeat.o(136308);
    }
  };
  private final com.tencent.mm.ui.tools.b.c.a ruH = new p.a()
  {
    public final void dN(String paramAnonymousString)
    {
      AppMethodBeat.i(168762);
      if (c.this.cnZ() != null) {
        c.a(c.this, c.this.cnZ().getEditableText());
      }
      AppMethodBeat.o(168762);
    }
  };
  
  c(String paramString, ad paramad, int paramInt)
  {
    this.ruF = paramString;
    this.rtP = new WeakReference(paramad);
    this.rtN = paramInt;
  }
  
  private void b(Editable paramEditable)
  {
    aj localaj;
    if (this.ruD != null)
    {
      localaj = this.ruD;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaj.a(str, Selection.getSelectionEnd(paramEditable), aj.a.rxA);
      return;
    }
  }
  
  public final boolean A(ad paramad)
  {
    return (paramad != null) && (paramad == this.rtP.get());
  }
  
  public final void DJ(int paramInt)
  {
    if (this.ruE != null) {
      this.ruE.DL(paramInt);
    }
  }
  
  final void a(Editable paramEditable)
  {
    aj localaj;
    if (this.ruD != null)
    {
      localaj = this.ruD;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaj.a(str, Selection.getSelectionEnd(paramEditable), aj.a.rxy);
      return;
    }
  }
  
  final void a(Editable paramEditable, String paramString1, String paramString2)
  {
    aj localaj;
    if (this.ruD != null)
    {
      localaj = this.ruD;
      if (paramEditable != null) {
        break label37;
      }
    }
    label37:
    for (String str = "";; str = paramEditable.toString())
    {
      localaj.f(str, Selection.getSelectionEnd(paramEditable), paramString1, paramString2);
      return;
    }
  }
  
  public final void a(String paramString, Integer paramInteger)
  {
    anC(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      fh(paramString.intValue(), paramString.intValue());
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
      if (paramh.rAs == null) {
        paramh.rAs = Integer.valueOf(140);
      }
      while (cnZ() != null)
      {
        p.a(cnZ()).axx(paramh.rAs.intValue()).Hh(false).b(g.a.XSt).a(this.ruH);
        return true;
        if (paramh.rAs.intValue() <= 0) {
          paramh.rAs = Integer.valueOf(2147483647);
        }
      }
    }
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    b(paramEditable);
  }
  
  public abstract boolean anC(String paramString);
  
  protected abstract com.tencent.mm.plugin.appbrand.widget.input.e.h b(com.tencent.mm.plugin.appbrand.widget.input.e.h paramh);
  
  public abstract Input cnZ();
  
  public abstract Rect coa();
  
  public final boolean cob()
  {
    return remove();
  }
  
  public final Input coc()
  {
    return cnZ();
  }
  
  public Editable cod()
  {
    if (cnZ() == null) {
      return null;
    }
    return cnZ().getEditableText();
  }
  
  protected final void coe()
  {
    ad localad = (ad)this.rtP.get();
    if ((localad != null) && (localad.qoF != null)) {
      h.cop().d(localad.qoF);
    }
  }
  
  protected final void cof()
  {
    ad localad = (ad)this.rtP.get();
    if ((localad != null) && (localad.qoF != null)) {
      h.cop().e(localad.qoF);
    }
  }
  
  final void cog()
  {
    k.a(this.rtP).DN(this.rtN);
  }
  
  final void coh()
  {
    k.a(this.rtP).DM(this.rtN);
  }
  
  protected final void fh(int paramInt1, int paramInt2)
  {
    b.a(cnZ(), paramInt1, paramInt2);
  }
  
  public final int getInputId()
  {
    return this.rtN;
  }
  
  protected abstract boolean kn(boolean paramBoolean);
  
  public final boolean remove()
  {
    EditText localEditText = cnZ();
    if (localEditText == null) {
      return false;
    }
    ((af)localEditText).b(this.ruG);
    localEditText.removeTextChangedListener(this);
    ((af)localEditText).destroy();
    Object localObject = (ad)this.rtP.get();
    if (localObject == null) {
      return false;
    }
    localObject = (g)((ad)localObject).cdU();
    if (localObject == null) {
      return false;
    }
    ((g)localObject).jdMethod_do(localEditText);
    return true;
  }
  
  public static enum a
  {
    private static final androidx.b.b<a> ruJ;
    
    static
    {
      AppMethodBeat.i(177116);
      ruK = new a[0];
      ruJ = new androidx.b.b();
      AppMethodBeat.o(177116);
    }
    
    public static c a(String paramString, ad paramad, e parame)
    {
      AppMethodBeat.i(136312);
      Iterator localIterator = ruJ.iterator();
      while (localIterator.hasNext())
      {
        c localc = ((a)localIterator.next()).coi();
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
      public abstract c coi();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c
 * JD-Core Version:    0.7.0.1
 */