package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import android.widget.ListAdapter;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import java.lang.ref.WeakReference;
import java.util.List;

public final class d
{
  public static <Input extends EditText,  extends aa> void a(q paramq, Input paramInput, a.a parama)
  {
    if (!((aa)paramInput).arU()) {
      return;
    }
    paramq = new WeakReference(paramq);
    paramq = new d.1(new WeakReference(paramInput), paramq);
    paramInput = ((aa)paramInput).getAutoFillController();
    Object localObject = parama.hyg;
    paramInput.hwQ = new a(paramInput.hwK.getContext(), (List)localObject);
    paramInput.hwQ.hwD = paramInput.hwO;
    localObject = paramInput.hwL;
    a locala = paramInput.hwQ;
    if (((AutoFillListPopupWindowBase)localObject).mObserver == null)
    {
      ((AutoFillListPopupWindowBase)localObject).mObserver = new AutoFillListPopupWindowBase.c((AutoFillListPopupWindowBase)localObject, (byte)0);
      ((AutoFillListPopupWindowBase)localObject).NK = locala;
      if (((AutoFillListPopupWindowBase)localObject).NK != null) {
        locala.registerDataSetObserver(((AutoFillListPopupWindowBase)localObject).mObserver);
      }
      if (((AutoFillListPopupWindowBase)localObject).hxe != null) {
        ((AutoFillListPopupWindowBase)localObject).hxe.setAdapter(((AutoFillListPopupWindowBase)localObject).NK);
      }
      paramInput.hwO.hwW = paramq;
      if (!"screen".equalsIgnoreCase(parama.hyf)) {
        break label220;
      }
    }
    label220:
    for (paramq = f.hxl;; paramq = f.hxm)
    {
      if (paramq != null) {
        paramInput.hwP = paramq;
      }
      paramInput.asy();
      return;
      if (((AutoFillListPopupWindowBase)localObject).NK == null) {
        break;
      }
      ((AutoFillListPopupWindowBase)localObject).NK.unregisterDataSetObserver(((AutoFillListPopupWindowBase)localObject).mObserver);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.d
 * JD-Core Version:    0.7.0.1
 */