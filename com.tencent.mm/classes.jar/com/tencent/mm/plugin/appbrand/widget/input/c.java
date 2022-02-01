package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class c<Input extends EditText,  extends ab>
  extends com.tencent.mm.ui.widget.g
  implements aa
{
  public af OrH;
  public ae OrI;
  final String OrJ;
  public final View.OnFocusChangeListener OrK = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136308);
      c.this.jg(paramAnonymousBoolean);
      if (paramAnonymousBoolean)
      {
        o.a((ac)c.this.orG.get(), (ab)c.this.caS());
        ((ab)c.this.caS()).setInputId(c.this.orE);
        o.b((ac)c.this.orG.get(), c.this);
      }
      AppMethodBeat.o(136308);
    }
  };
  private final com.tencent.mm.ui.tools.b.c.a OrL = new p.a()
  {
    public final void dv(String paramAnonymousString)
    {
      AppMethodBeat.i(168762);
      if (c.this.caS() != null) {
        c.a(c.this, c.this.caS().getEditableText());
      }
      AppMethodBeat.o(168762);
    }
  };
  public final int orE;
  public final WeakReference<ac> orG;
  
  c(String paramString, ac paramac, int paramInt)
  {
    this.OrJ = paramString;
    this.orG = new WeakReference(paramac);
    this.orE = paramInt;
  }
  
  private void b(Editable paramEditable)
  {
    af localaf;
    if (this.OrH != null)
    {
      localaf = this.OrH;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaf.a(str, Selection.getSelectionEnd(paramEditable), af.a.ouY);
      return;
    }
  }
  
  public final boolean A(ac paramac)
  {
    return (paramac != null) && (paramac == this.orG.get());
  }
  
  final void a(Editable paramEditable)
  {
    af localaf;
    if (this.OrH != null)
    {
      localaf = this.OrH;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaf.a(str, Selection.getSelectionEnd(paramEditable), af.a.ouW);
      return;
    }
  }
  
  public final void a(String paramString, Integer paramInteger)
  {
    afY(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      eJ(paramString.intValue(), paramString.intValue());
      return;
    }
  }
  
  public final boolean a(h paramh)
  {
    paramh = b(paramh);
    if (paramh == null) {}
    for (;;)
    {
      return false;
      if (paramh.oxT == null) {
        paramh.oxT = Integer.valueOf(140);
      }
      while (caS() != null)
      {
        p.a(caS()).aoq(paramh.oxT.intValue()).CN(false).a(f.a.Quh).a(this.OrL);
        return true;
        if (paramh.oxT.intValue() <= 0) {
          paramh.oxT = Integer.valueOf(2147483647);
        }
      }
    }
  }
  
  public abstract boolean afY(String paramString);
  
  public final void afterTextChanged(Editable paramEditable)
  {
    b(paramEditable);
  }
  
  protected abstract h b(h paramh);
  
  public abstract Input caS();
  
  public abstract Rect caT();
  
  public final boolean caU()
  {
    return remove();
  }
  
  public final Input caV()
  {
    return caS();
  }
  
  public final Editable cbf()
  {
    if (caS() == null) {
      return null;
    }
    return caS().getEditableText();
  }
  
  protected final void eJ(int paramInt1, int paramInt2)
  {
    b.a(caS(), paramInt1, paramInt2);
  }
  
  public final int getInputId()
  {
    return this.orE;
  }
  
  protected abstract boolean jg(boolean paramBoolean);
  
  public final boolean remove()
  {
    EditText localEditText = caS();
    if (localEditText == null) {
      return false;
    }
    ((ab)localEditText).b(this.OrK);
    localEditText.removeTextChangedListener(this);
    ((ab)localEditText).destroy();
    Object localObject = (ac)this.orG.get();
    if (localObject == null) {
      return false;
    }
    localObject = (g)((ac)localObject).bRe();
    if (localObject == null) {
      return false;
    }
    ((g)localObject).cV(localEditText);
    return true;
  }
  
  public final void zZ(int paramInt)
  {
    if (this.OrI != null) {
      this.OrI.Ab(paramInt);
    }
  }
  
  public static enum a
  {
    private static final android.support.v4.e.b<a> OrN;
    
    static
    {
      AppMethodBeat.i(177116);
      OrO = new a[0];
      OrN = new android.support.v4.e.b();
      AppMethodBeat.o(177116);
    }
    
    public static c a(String paramString, ac paramac, e parame)
    {
      AppMethodBeat.i(136312);
      Iterator localIterator = OrN.iterator();
      while (localIterator.hasNext())
      {
        c localc = ((a)localIterator.next()).caX();
        if (localc != null)
        {
          AppMethodBeat.o(136312);
          return localc;
        }
      }
      if (("digit".equalsIgnoreCase(paramString)) || ("idcard".equalsIgnoreCase(paramString)) || ("number".equalsIgnoreCase(paramString)))
      {
        paramString = new d(paramString, paramac, parame);
        AppMethodBeat.o(136312);
        return paramString;
      }
      AppMethodBeat.o(136312);
      return null;
    }
    
    public static abstract interface a
    {
      public abstract c caX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c
 * JD-Core Version:    0.7.0.1
 */