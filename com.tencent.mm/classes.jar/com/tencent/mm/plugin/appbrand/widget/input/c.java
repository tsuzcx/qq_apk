package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.f;
import java.lang.ref.WeakReference;

public abstract class c<Input extends EditText,  extends aa>
  extends f
  implements z
{
  public ae hsV;
  public ad hsW;
  public final int hsX;
  final String hsY;
  public final WeakReference<q> hsZ;
  public final View.OnFocusChangeListener hta = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      c.this.dT(paramAnonymousBoolean);
      if (paramAnonymousBoolean)
      {
        n.a((q)c.this.hsZ.get(), (aa)c.this.arH());
        ((aa)c.this.arH()).setInputId(c.this.hsX);
        n.b((q)c.this.hsZ.get(), c.this);
      }
    }
  };
  private final c.a inputExceedMaxLengthCallback = new c.2(this);
  
  c(String paramString, q paramq, int paramInt)
  {
    this.hsY = paramString;
    this.hsZ = new WeakReference(paramq);
    this.hsX = paramInt;
  }
  
  private void b(Editable paramEditable)
  {
    ae localae;
    if (this.hsV != null)
    {
      localae = this.hsV;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localae.a(str, Selection.getSelectionEnd(paramEditable), ae.a.hvK);
      return;
    }
  }
  
  final void a(Editable paramEditable)
  {
    ae localae;
    if (this.hsV != null)
    {
      localae = this.hsV;
      if (paramEditable != null) {
        break label34;
      }
    }
    label34:
    for (String str = "";; str = paramEditable.toString())
    {
      localae.a(str, Selection.getSelectionEnd(paramEditable), ae.a.hvI);
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
      if (paramh.hyH == null) {
        paramh.hyH = Integer.valueOf(140);
      }
      while (arH() != null)
      {
        paramh = o.a(arH()).Ig(paramh.hyH.intValue());
        paramh.wfM = false;
        paramh.huj = f.a.wcS;
        paramh.a(this.inputExceedMaxLengthCallback);
        return true;
        if (paramh.hyH.intValue() <= 0) {
          paramh.hyH = Integer.valueOf(2147483647);
        }
      }
    }
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    b(paramEditable);
  }
  
  public abstract Input arH();
  
  public abstract Rect arI();
  
  public final boolean arJ()
  {
    EditText localEditText = arH();
    if (localEditText == null) {
      return false;
    }
    ((aa)localEditText).b(this.hta);
    localEditText.removeTextChangedListener(this);
    ((aa)localEditText).destroy();
    Object localObject = (q)this.hsZ.get();
    if (localObject == null) {
      return false;
    }
    localObject = (g)((q)localObject).agO();
    if (localObject == null) {
      return false;
    }
    ((g)localObject).cg(localEditText);
    return true;
  }
  
  public final Editable arK()
  {
    if (arH() == null) {
      return null;
    }
    return arH().getEditableText();
  }
  
  protected abstract h b(h paramh);
  
  protected abstract boolean dT(boolean paramBoolean);
  
  public Input getWidget()
  {
    return arH();
  }
  
  public boolean isAttachedTo(q paramq)
  {
    return (paramq != null) && (paramq == this.hsZ.get());
  }
  
  public final void lt(int paramInt)
  {
    if (this.hsW != null) {
      this.hsW.mL(paramInt);
    }
  }
  
  public boolean removeSelf()
  {
    return arJ();
  }
  
  protected final void setInputSelection(int paramInt1, int paramInt2)
  {
    b.a(arH(), paramInt1, paramInt2);
  }
  
  public final void updateValue(String paramString, Integer paramInteger)
  {
    xa(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      setInputSelection(paramString.intValue(), paramString.intValue());
      return;
    }
  }
  
  public abstract boolean xa(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c
 * JD-Core Version:    0.7.0.1
 */