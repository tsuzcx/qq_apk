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
  public final int ncO;
  public final WeakReference<com.tencent.mm.plugin.appbrand.page.aa> ncQ;
  final String sZN;
  public final View.OnFocusChangeListener sZO = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136308);
      c.this.ih(paramAnonymousBoolean);
      if (paramAnonymousBoolean)
      {
        o.a((com.tencent.mm.plugin.appbrand.page.aa)c.this.ncQ.get(), (ab)c.this.bDM());
        ((ab)c.this.bDM()).setInputId(c.this.ncO);
        o.b((com.tencent.mm.plugin.appbrand.page.aa)c.this.ncQ.get(), c.this);
      }
      AppMethodBeat.o(136308);
    }
  };
  private final com.tencent.mm.ui.tools.b.c.a sZP = new p.a()
  {
    public final void cU(String paramAnonymousString)
    {
      AppMethodBeat.i(168762);
      if (c.this.bDM() != null) {
        c.a(c.this, c.this.bDM().getEditableText());
      }
      AppMethodBeat.o(168762);
    }
  };
  public ae sxE;
  public af sxt;
  
  c(String paramString, com.tencent.mm.plugin.appbrand.page.aa paramaa, int paramInt)
  {
    this.sZN = paramString;
    this.ncQ = new WeakReference(paramaa);
    this.ncO = paramInt;
  }
  
  private void b(Editable paramEditable)
  {
    af localaf;
    if (this.sxt != null)
    {
      localaf = this.sxt;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaf.a(str, Selection.getSelectionEnd(paramEditable), af.a.ngj);
      return;
    }
  }
  
  public abstract boolean Vq(String paramString);
  
  final void a(Editable paramEditable)
  {
    af localaf;
    if (this.sxt != null)
    {
      localaf = this.sxt;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaf.a(str, Selection.getSelectionEnd(paramEditable), af.a.ngh);
      return;
    }
  }
  
  public final void a(String paramString, Integer paramInteger)
  {
    Vq(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      eu(paramString.intValue(), paramString.intValue());
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
      if (paramh.njf == null) {
        paramh.njf = Integer.valueOf(140);
      }
      while (bDM() != null)
      {
        paramh = p.a(bDM()).aeU(paramh.njf.intValue());
        paramh.KMn = false;
        paramh.neC = f.a.KIM;
        paramh.a(this.sZP);
        return true;
        if (paramh.njf.intValue() <= 0) {
          paramh.njf = Integer.valueOf(2147483647);
        }
      }
    }
  }
  
  public final Editable aUP()
  {
    if (bDM() == null) {
      return null;
    }
    return bDM().getEditableText();
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    b(paramEditable);
  }
  
  protected abstract h b(h paramh);
  
  public abstract Input bDM();
  
  public abstract Rect bDN();
  
  public final boolean bDO()
  {
    return remove();
  }
  
  public final Input bDP()
  {
    return bDM();
  }
  
  protected final void eu(int paramInt1, int paramInt2)
  {
    b.a(bDM(), paramInt1, paramInt2);
  }
  
  public final int getInputId()
  {
    return this.ncO;
  }
  
  protected abstract boolean ih(boolean paramBoolean);
  
  public final boolean remove()
  {
    EditText localEditText = bDM();
    if (localEditText == null) {
      return false;
    }
    ((ab)localEditText).b(this.sZO);
    localEditText.removeTextChangedListener(this);
    ((ab)localEditText).destroy();
    Object localObject = (com.tencent.mm.plugin.appbrand.page.aa)this.ncQ.get();
    if (localObject == null) {
      return false;
    }
    localObject = (g)((com.tencent.mm.plugin.appbrand.page.aa)localObject).but();
    if (localObject == null) {
      return false;
    }
    ((g)localObject).dc(localEditText);
    return true;
  }
  
  public final boolean u(com.tencent.mm.plugin.appbrand.page.aa paramaa)
  {
    return (paramaa != null) && (paramaa == this.ncQ.get());
  }
  
  public final void wm(int paramInt)
  {
    if (this.sxE != null) {
      this.sxE.wo(paramInt);
    }
  }
  
  public static enum a
  {
    private static final android.support.v4.e.b<a> sZR;
    
    static
    {
      AppMethodBeat.i(177116);
      sZS = new a[0];
      sZR = new android.support.v4.e.b();
      AppMethodBeat.o(177116);
    }
    
    public static c a(String paramString, com.tencent.mm.plugin.appbrand.page.aa paramaa, e parame)
    {
      AppMethodBeat.i(136312);
      Iterator localIterator = sZR.iterator();
      while (localIterator.hasNext())
      {
        c localc = ((a)localIterator.next()).bDR();
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
      public abstract c bDR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c
 * JD-Core Version:    0.7.0.1
 */