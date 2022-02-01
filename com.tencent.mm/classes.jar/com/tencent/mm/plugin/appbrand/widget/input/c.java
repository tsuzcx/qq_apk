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
  public final int mCo;
  public af mCp;
  public final WeakReference<com.tencent.mm.plugin.appbrand.page.aa> mCq;
  public ae mCr;
  final String mCs;
  public final View.OnFocusChangeListener mCt = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(136308);
      c.this.hY(paramAnonymousBoolean);
      if (paramAnonymousBoolean)
      {
        o.a((com.tencent.mm.plugin.appbrand.page.aa)c.this.mCq.get(), (ab)c.this.bzJ());
        ((ab)c.this.bzJ()).setInputId(c.this.mCo);
        o.b((com.tencent.mm.plugin.appbrand.page.aa)c.this.mCq.get(), c.this);
      }
      AppMethodBeat.o(136308);
    }
  };
  private final com.tencent.mm.ui.tools.b.c.a mCu = new p.a()
  {
    public final void ca(String paramAnonymousString)
    {
      AppMethodBeat.i(168762);
      if (c.this.bzJ() != null) {
        c.a(c.this, c.this.bzJ().getEditableText());
      }
      AppMethodBeat.o(168762);
    }
  };
  
  c(String paramString, com.tencent.mm.plugin.appbrand.page.aa paramaa, int paramInt)
  {
    this.mCs = paramString;
    this.mCq = new WeakReference(paramaa);
    this.mCo = paramInt;
  }
  
  private void b(Editable paramEditable)
  {
    af localaf;
    if (this.mCp != null)
    {
      localaf = this.mCp;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaf.a(str, Selection.getSelectionEnd(paramEditable), af.a.mFL);
      return;
    }
  }
  
  public abstract boolean RT(String paramString);
  
  final void a(Editable paramEditable)
  {
    af localaf;
    if (this.mCp != null)
    {
      localaf = this.mCp;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaf.a(str, Selection.getSelectionEnd(paramEditable), af.a.mFJ);
      return;
    }
  }
  
  public final void a(String paramString, Integer paramInteger)
  {
    RT(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      et(paramString.intValue(), paramString.intValue());
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
      if (paramh.mIJ == null) {
        paramh.mIJ = Integer.valueOf(140);
      }
      while (bzJ() != null)
      {
        paramh = p.a(bzJ()).acw(paramh.mIJ.intValue());
        paramh.IVj = false;
        paramh.mEd = f.a.IRI;
        paramh.a(this.mCu);
        return true;
        if (paramh.mIJ.intValue() <= 0) {
          paramh.mIJ = Integer.valueOf(2147483647);
        }
      }
    }
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    b(paramEditable);
  }
  
  protected abstract h b(h paramh);
  
  public final Editable bxZ()
  {
    if (bzJ() == null) {
      return null;
    }
    return bzJ().getEditableText();
  }
  
  public abstract Input bzJ();
  
  public abstract Rect bzK();
  
  public final boolean bzL()
  {
    return bzN();
  }
  
  public final Input bzM()
  {
    return bzJ();
  }
  
  public final boolean bzN()
  {
    EditText localEditText = bzJ();
    if (localEditText == null) {
      return false;
    }
    ((ab)localEditText).b(this.mCt);
    localEditText.removeTextChangedListener(this);
    ((ab)localEditText).destroy();
    Object localObject = (com.tencent.mm.plugin.appbrand.page.aa)this.mCq.get();
    if (localObject == null) {
      return false;
    }
    localObject = (g)((com.tencent.mm.plugin.appbrand.page.aa)localObject).bqu();
    if (localObject == null) {
      return false;
    }
    ((g)localObject).da(localEditText);
    return true;
  }
  
  protected final void et(int paramInt1, int paramInt2)
  {
    b.a(bzJ(), paramInt1, paramInt2);
  }
  
  public final int getInputId()
  {
    return this.mCo;
  }
  
  protected abstract boolean hY(boolean paramBoolean);
  
  public final boolean u(com.tencent.mm.plugin.appbrand.page.aa paramaa)
  {
    return (paramaa != null) && (paramaa == this.mCq.get());
  }
  
  public final void vH(int paramInt)
  {
    if (this.mCr != null) {
      this.mCr.vJ(paramInt);
    }
  }
  
  public static enum a
  {
    private static final android.support.v4.e.b<a> mCN;
    
    static
    {
      AppMethodBeat.i(177116);
      mCO = new a[0];
      mCN = new android.support.v4.e.b();
      AppMethodBeat.o(177116);
    }
    
    public static c a(String paramString, com.tencent.mm.plugin.appbrand.page.aa paramaa, e parame)
    {
      AppMethodBeat.i(136312);
      Iterator localIterator = mCN.iterator();
      while (localIterator.hasNext())
      {
        c localc = ((a)localIterator.next()).bzP();
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
      public abstract c bzP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c
 * JD-Core Version:    0.7.0.1
 */