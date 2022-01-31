package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;

public abstract class c<Input extends EditText,  extends ab>
  extends com.tencent.mm.ui.widget.g
  implements aa
{
  public ae jkA;
  public final int jkB;
  final String jkC;
  public final WeakReference<v> jkD;
  public final View.OnFocusChangeListener jkE = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(123577);
      c.this.fo(paramAnonymousBoolean);
      if (paramAnonymousBoolean)
      {
        o.a((v)c.this.jkD.get(), (ab)c.this.aQt());
        ((ab)c.this.aQt()).setInputId(c.this.jkB);
        o.b((v)c.this.jkD.get(), c.this);
      }
      AppMethodBeat.o(123577);
    }
  };
  private final c.a jkF = new c.2(this);
  public af jkz;
  
  c(String paramString, v paramv, int paramInt)
  {
    this.jkC = paramString;
    this.jkD = new WeakReference(paramv);
    this.jkB = paramInt;
  }
  
  private void b(Editable paramEditable)
  {
    af localaf;
    if (this.jkz != null)
    {
      localaf = this.jkz;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaf.a(str, Selection.getSelectionEnd(paramEditable), af.a.jnX);
      return;
    }
  }
  
  public abstract boolean FN(String paramString);
  
  final void a(Editable paramEditable)
  {
    af localaf;
    if (this.jkz != null)
    {
      localaf = this.jkz;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localaf.a(str, Selection.getSelectionEnd(paramEditable), af.a.jnV);
      return;
    }
  }
  
  public final void a(String paramString, Integer paramInteger)
  {
    FN(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      dv(paramString.intValue(), paramString.intValue());
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
      if (paramh.jqR == null) {
        paramh.jqR = Integer.valueOf(140);
      }
      while (aQt() != null)
      {
        paramh = p.a(aQt()).QS(paramh.jqR.intValue());
        paramh.AyD = false;
        paramh.jmp = f.a.Avm;
        paramh.a(this.jkF);
        return true;
        if (paramh.jqR.intValue() <= 0) {
          paramh.jqR = Integer.valueOf(2147483647);
        }
      }
    }
  }
  
  public final Editable aQH()
  {
    if (aQt() == null) {
      return null;
    }
    return aQt().getEditableText();
  }
  
  public abstract Input aQt();
  
  public abstract Rect aQu();
  
  public final boolean aQv()
  {
    return aQx();
  }
  
  public final Input aQw()
  {
    return aQt();
  }
  
  public final boolean aQx()
  {
    EditText localEditText = aQt();
    if (localEditText == null) {
      return false;
    }
    ((ab)localEditText).b(this.jkE);
    localEditText.removeTextChangedListener(this);
    ((ab)localEditText).destroy();
    Object localObject = (v)this.jkD.get();
    if (localObject == null) {
      return false;
    }
    localObject = (g)((v)localObject).aJk();
    if (localObject == null) {
      return false;
    }
    ((g)localObject).cI(localEditText);
    return true;
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    b(paramEditable);
  }
  
  protected abstract h b(h paramh);
  
  protected final void dv(int paramInt1, int paramInt2)
  {
    b.a(aQt(), paramInt1, paramInt2);
  }
  
  protected abstract boolean fo(boolean paramBoolean);
  
  public final int getInputId()
  {
    return this.jkB;
  }
  
  public final boolean n(v paramv)
  {
    return (paramv != null) && (paramv == this.jkD.get());
  }
  
  public final void qo(int paramInt)
  {
    if (this.jkA != null) {
      this.jkA.qq(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c
 * JD-Core Version:    0.7.0.1
 */