package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.s.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

final class SmartGalleryUI$g
  implements Runnable
{
  s.c sTv;
  WeakReference<SmartGalleryUI.b> sTx;
  WeakReference<ProgressDialog> sTy;
  WeakReference<EditText> sTz;
  
  SmartGalleryUI$g(WeakReference<SmartGalleryUI.b> paramWeakReference, s.c paramc)
  {
    this.sTx = paramWeakReference;
    this.sTv = paramc;
  }
  
  public final void run()
  {
    AppMethodBeat.i(111700);
    if ((this.sTx != null) && (this.sTv != null))
    {
      Object localObject = (SmartGalleryUI.b)this.sTx.get();
      if (localObject != null)
      {
        ac.i("MicroMsg.SmartGalleryUI", "show category.");
        ((SmartGalleryUI.b)localObject).sTv = this.sTv;
        ((RecyclerView.a)localObject).arg.notifyChanged();
      }
      if (this.sTy != null)
      {
        localObject = (ProgressDialog)this.sTy.get();
        if (localObject != null)
        {
          ac.i("MicroMsg.SmartGalleryUI", "tipDialog dismiss.");
          ((ProgressDialog)localObject).dismiss();
        }
      }
      if (this.sTz != null)
      {
        localObject = (EditText)this.sTz.get();
        if (localObject != null)
        {
          ac.i("MicroMsg.SmartGalleryUI", "show keyboard.");
          ((EditText)localObject).requestFocus();
          ((InputMethodManager)((EditText)localObject).getContext().getSystemService("input_method")).showSoftInput((View)localObject, 0);
        }
      }
    }
    AppMethodBeat.o(111700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.g
 * JD-Core Version:    0.7.0.1
 */