package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class SmartGalleryUI$4
  implements TextWatcher
{
  SmartGalleryUI$4(SmartGalleryUI paramSmartGalleryUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(111674);
    paramEditable = paramEditable.toString();
    ac.d("MicroMsg.SmartGalleryUI", "cur txt: %s.", new Object[] { paramEditable });
    SmartGalleryUI.d(this.sTo).sTA = paramEditable;
    if (bs.isNullOrNil(paramEditable))
    {
      SmartGalleryUI.e(this.sTo);
      SmartGalleryUI.g(this.sTo).setAdapter(SmartGalleryUI.f(this.sTo));
      SmartGalleryUI.g(this.sTo).a(this.sTo.sTj);
      SmartGalleryUI.f(this.sTo).arg.notifyChanged();
      AppMethodBeat.o(111674);
      return;
    }
    SmartGalleryUI.a(this.sTo, paramEditable, false);
    AppMethodBeat.o(111674);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.4
 * JD-Core Version:    0.7.0.1
 */