package com.tencent.mm.plugin.aa.ui;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;

final class AAImagPreviewUI$7
  implements Runnable
{
  AAImagPreviewUI$7(AAImagPreviewUI paramAAImagPreviewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(206992);
    if (com.tencent.mm.vfs.i.eA(AAImagPreviewUI.d(this.iBG)))
    {
      String str = com.tencent.mm.loader.j.b.aps() + "img_" + g.getMD5(AAImagPreviewUI.d(this.iBG)) + System.currentTimeMillis() + ".jpg";
      com.tencent.mm.vfs.i.deleteFile(str);
      com.tencent.mm.vfs.i.lZ(AAImagPreviewUI.d(this.iBG), str);
      com.tencent.mm.sdk.f.b.k(str, this.iBG.getContext());
      Toast.makeText(this.iBG.getContext(), this.iBG.getContext().getString(2131760066, new Object[] { com.tencent.mm.loader.j.b.aps() }), 1).show();
    }
    for (;;)
    {
      com.tencent.mm.plugin.aa.model.i.qF(15);
      AppMethodBeat.o(206992);
      return;
      Toast.makeText(this.iBG.getContext(), this.iBG.getContext().getString(2131760659), 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.7
 * JD-Core Version:    0.7.0.1
 */