package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class c<Input extends EditText,  extends ab>
  extends com.tencent.mm.ui.widget.g
  implements aa
{
  public final int nhX;
  public final WeakReference<z> nhZ;
  public af nid;
  public ae nie;
  final String niw;
  public final View.OnFocusChangeListener nix = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136308);
      c.this.jdMethod_if(paramAnonymousBoolean);
      if (paramAnonymousBoolean)
      {
        o.a((z)c.this.nhZ.get(), (ab)c.this.bEE());
        ((ab)c.this.bEE()).setInputId(c.this.nhX);
        o.b((z)c.this.nhZ.get(), c.this);
      }
      AppMethodBeat.o(136308);
    }
  };
  private final com.tencent.mm.ui.tools.b.c.a niy = new p.a()
  {
    public final void cW(String paramAnonymousString)
    {
      AppMethodBeat.i(168762);
      if (c.this.bEE() != null) {
        c.a(c.this, c.this.bEE().getEditableText());
      }
      AppMethodBeat.o(168762);
    }
  };
  
  c(String paramString, z paramz, int paramInt)
  {
    this.niw = paramString;
    this.nhZ = new WeakReference(paramz);
    this.nhX = paramInt;
  }
  
  private void b(Editable paramEditable)
  {
    af localaf;
    if (this.nid != null)
    {
      localaf = this.nid;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaf.a(str, Selection.getSelectionEnd(paramEditable), af.a.nlr);
      return;
    }
  }
  
  public abstract boolean Wc(String paramString);
  
  final void a(Editable paramEditable)
  {
    af localaf;
    if (this.nid != null)
    {
      localaf = this.nid;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaf.a(str, Selection.getSelectionEnd(paramEditable), af.a.nlp);
      return;
    }
  }
  
  public final void a(String paramString, Integer paramInteger)
  {
    Wc(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      ev(paramString.intValue(), paramString.intValue());
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
      if (paramh.non == null) {
        paramh.non = Integer.valueOf(140);
      }
      while (bEE() != null)
      {
        paramh = p.a(bEE()).afD(paramh.non.intValue());
        paramh.LiL = false;
        paramh.njK = f.a.Lfg;
        paramh.a(this.niy);
        return true;
        if (paramh.non.intValue() <= 0) {
          paramh.non = Integer.valueOf(2147483647);
        }
      }
    }
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    b(paramEditable);
  }
  
  protected abstract h b(h paramh);
  
  public abstract Input bEE();
  
  public abstract Rect bEF();
  
  public final boolean bEG()
  {
    return remove();
  }
  
  public final Input bEH()
  {
    return bEE();
  }
  
  public final Editable bER()
  {
    if (bEE() == null) {
      return null;
    }
    return bEE().getEditableText();
  }
  
  protected final void ev(int paramInt1, int paramInt2)
  {
    b.a(bEE(), paramInt1, paramInt2);
  }
  
  public final int getInputId()
  {
    return this.nhX;
  }
  
  protected abstract boolean jdMethod_if(boolean paramBoolean);
  
  public final boolean remove()
  {
    EditText localEditText = bEE();
    if (localEditText == null) {
      return false;
    }
    ((ab)localEditText).b(this.nix);
    localEditText.removeTextChangedListener(this);
    ((ab)localEditText).destroy();
    Object localObject = (z)this.nhZ.get();
    if (localObject == null) {
      return false;
    }
    localObject = (g)((z)localObject).bve();
    if (localObject == null) {
      return false;
    }
    ((g)localObject).dc(localEditText);
    return true;
  }
  
  public final boolean v(z paramz)
  {
    return (paramz != null) && (paramz == this.nhZ.get());
  }
  
  public final void wr(int paramInt)
  {
    if (this.nie != null) {
      this.nie.wt(paramInt);
    }
  }
  
  public static enum a
  {
    private static final android.support.v4.e.b<a> niA;
    
    static
    {
      AppMethodBeat.i(177116);
      niB = new a[0];
      niA = new android.support.v4.e.b();
      AppMethodBeat.o(177116);
    }
    
    public static c a(String paramString, z paramz, e parame)
    {
      AppMethodBeat.i(136312);
      Iterator localIterator = niA.iterator();
      while (localIterator.hasNext())
      {
        c localc = ((a)localIterator.next()).bEJ();
        if (localc != null)
        {
          AppMethodBeat.o(136312);
          return localc;
        }
      }
      if (("digit".equalsIgnoreCase(paramString)) || ("idcard".equalsIgnoreCase(paramString)) || ("number".equalsIgnoreCase(paramString)))
      {
        paramString = new d(paramString, paramz, parame);
        AppMethodBeat.o(136312);
        return paramString;
      }
      AppMethodBeat.o(136312);
      return null;
    }
    
    public static abstract interface a
    {
      public abstract c bEJ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c
 * JD-Core Version:    0.7.0.1
 */