package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class c<Input extends EditText,  extends ab>
  extends com.tencent.mm.ui.widget.g
  implements aa
{
  final String KDA;
  public final View.OnFocusChangeListener KDB = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136308);
      c.this.hA(paramAnonymousBoolean);
      if (paramAnonymousBoolean)
      {
        o.a((com.tencent.mm.plugin.appbrand.page.aa)c.this.mar.get(), (ab)c.this.bsJ());
        ((ab)c.this.bsJ()).setInputId(c.this.mao);
        o.b((com.tencent.mm.plugin.appbrand.page.aa)c.this.mar.get(), c.this);
      }
      AppMethodBeat.o(136308);
    }
  };
  private final com.tencent.mm.ui.tools.b.c.a KDC = new p.a()
  {
    public final void ck(String paramAnonymousString)
    {
      AppMethodBeat.i(168762);
      if (c.this.bsJ() != null) {
        c.a(c.this, c.this.bsJ().getEditableText());
      }
      AppMethodBeat.o(168762);
    }
  };
  public af KDy;
  public ae KDz;
  public final int mao;
  public final WeakReference<com.tencent.mm.plugin.appbrand.page.aa> mar;
  
  c(String paramString, com.tencent.mm.plugin.appbrand.page.aa paramaa, int paramInt)
  {
    this.KDA = paramString;
    this.mar = new WeakReference(paramaa);
    this.mao = paramInt;
  }
  
  private void b(Editable paramEditable)
  {
    af localaf;
    if (this.KDy != null)
    {
      localaf = this.KDy;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaf.a(str, Selection.getSelectionEnd(paramEditable), af.a.mdM);
      return;
    }
  }
  
  public abstract boolean NK(String paramString);
  
  final void a(Editable paramEditable)
  {
    af localaf;
    if (this.KDy != null)
    {
      localaf = this.KDy;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaf.a(str, Selection.getSelectionEnd(paramEditable), af.a.mdK);
      return;
    }
  }
  
  public final void a(String paramString, Integer paramInteger)
  {
    NK(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      ja(paramString.intValue(), paramString.intValue());
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
      if (paramh.mgI == null) {
        paramh.mgI = Integer.valueOf(140);
      }
      while (bsJ() != null)
      {
        paramh = p.a(bsJ()).aaj(paramh.mgI.intValue());
        paramh.HuM = false;
        paramh.mcf = f.a.Hrl;
        paramh.a(this.KDC);
        return true;
        if (paramh.mgI.intValue() <= 0) {
          paramh.mgI = Integer.valueOf(2147483647);
        }
      }
    }
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    b(paramEditable);
  }
  
  protected abstract h b(h paramh);
  
  public abstract Input bsJ();
  
  public abstract Rect bsK();
  
  public final boolean bsL()
  {
    return bsN();
  }
  
  public final Input bsM()
  {
    return bsJ();
  }
  
  public final boolean bsN()
  {
    EditText localEditText = bsJ();
    if (localEditText == null) {
      return false;
    }
    ((ab)localEditText).b(this.KDB);
    localEditText.removeTextChangedListener(this);
    ((ab)localEditText).destroy();
    Object localObject = (com.tencent.mm.plugin.appbrand.page.aa)this.mar.get();
    if (localObject == null) {
      return false;
    }
    localObject = (g)((com.tencent.mm.plugin.appbrand.page.aa)localObject).bjD();
    if (localObject == null) {
      return false;
    }
    ((g)localObject).cY(localEditText);
    return true;
  }
  
  public final Editable fQZ()
  {
    if (bsJ() == null) {
      return null;
    }
    return bsJ().getEditableText();
  }
  
  public final int getInputId()
  {
    return this.mao;
  }
  
  protected abstract boolean hA(boolean paramBoolean);
  
  protected final void ja(int paramInt1, int paramInt2)
  {
    b.a(bsJ(), paramInt1, paramInt2);
  }
  
  public final boolean u(com.tencent.mm.plugin.appbrand.page.aa paramaa)
  {
    return (paramaa != null) && (paramaa == this.mar.get());
  }
  
  public final void uQ(int paramInt)
  {
    if (this.KDz != null) {
      this.KDz.uS(paramInt);
    }
  }
  
  public static enum a
  {
    private static final android.support.v4.e.b<a> KDE;
    
    static
    {
      AppMethodBeat.i(177116);
      KDF = new a[0];
      KDE = new android.support.v4.e.b();
      AppMethodBeat.o(177116);
    }
    
    public static c a(String paramString, com.tencent.mm.plugin.appbrand.page.aa paramaa, e parame)
    {
      AppMethodBeat.i(136312);
      Iterator localIterator = KDE.iterator();
      while (localIterator.hasNext())
      {
        c localc = ((a)localIterator.next()).bsP();
        if (localc != null)
        {
          AppMethodBeat.o(136312);
          return localc;
        }
      }
      if (("digit".equalsIgnoreCase(paramString)) || ("idcard".equalsIgnoreCase(paramString)) || ("number".equalsIgnoreCase(paramString)))
      {
        paramString = new d(paramString, paramaa, parame);
        AppMethodBeat.o(136312);
        return paramString;
      }
      AppMethodBeat.o(136312);
      return null;
    }
    
    public static abstract interface a
    {
      public abstract c bsP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c
 * JD-Core Version:    0.7.0.1
 */