package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.t.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class SmartGalleryUI$g
  implements Runnable
{
  t.c HQD;
  WeakReference<SmartGalleryUI.b> HQF;
  WeakReference<ProgressDialog> HQG;
  WeakReference<EditText> HQH;
  
  SmartGalleryUI$g(WeakReference<SmartGalleryUI.b> paramWeakReference, t.c paramc)
  {
    this.HQF = paramWeakReference;
    this.HQD = paramc;
  }
  
  public final void run()
  {
    AppMethodBeat.i(111700);
    if ((this.HQF != null) && (this.HQD != null))
    {
      Object localObject = (SmartGalleryUI.b)this.HQF.get();
      if (localObject != null)
      {
        Log.i("MicroMsg.SmartGalleryUI", "show category.");
        ((SmartGalleryUI.b)localObject).HQD = this.HQD;
        ((RecyclerView.a)localObject).bZE.notifyChanged();
      }
      if (this.HQG != null)
      {
        localObject = (ProgressDialog)this.HQG.get();
        if (localObject != null)
        {
          Log.i("MicroMsg.SmartGalleryUI", "tipDialog dismiss.");
          ((ProgressDialog)localObject).dismiss();
        }
      }
      if (this.HQH != null)
      {
        localObject = (EditText)this.HQH.get();
        if (localObject != null)
        {
          Log.i("MicroMsg.SmartGalleryUI", "show keyboard.");
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