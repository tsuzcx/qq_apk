package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.f.a;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;
import java.util.Set;

final class x$a
  implements TextWatcher
{
  final Map<TextWatcher, Object> hvz = new a();
  
  private x$a(x paramx) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    Object localObject;
    int i;
    int j;
    if (f.arL())
    {
      localObject = new PBool();
      PInt localPInt = new PInt();
      String str = x.a(paramEditable, (PBool)localObject, localPInt);
      i = localPInt.value;
      if ((((PBool)localObject).value) && (!bk.bl(str)))
      {
        j = Selection.getSelectionEnd(paramEditable);
        boolean bool = x.b(this.hvy);
        this.hvy.post(new x.a.1(this, bool, str, j, i));
      }
    }
    for (;;)
    {
      return;
      if (!x.b(this.hvy))
      {
        x.c(this.hvy);
        if (this.hvz.isEmpty()) {
          break;
        }
        localObject = (TextWatcher[])this.hvz.keySet().toArray(new TextWatcher[this.hvz.size()]);
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          localObject[i].afterTextChanged(paramEditable);
          i += 1;
        }
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!x.b(this.hvy)) && (!this.hvz.isEmpty()))
    {
      TextWatcher[] arrayOfTextWatcher = (TextWatcher[])this.hvz.keySet().toArray(new TextWatcher[this.hvz.size()]);
      int j = arrayOfTextWatcher.length;
      int i = 0;
      while (i < j)
      {
        arrayOfTextWatcher[i].beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
        i += 1;
      }
    }
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!x.b(this.hvy)) && (!this.hvz.isEmpty()))
    {
      TextWatcher[] arrayOfTextWatcher = (TextWatcher[])this.hvz.keySet().toArray(new TextWatcher[this.hvz.size()]);
      int j = arrayOfTextWatcher.length;
      int i = 0;
      while (i < j)
      {
        arrayOfTextWatcher[i].onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.x.a
 * JD-Core Version:    0.7.0.1
 */