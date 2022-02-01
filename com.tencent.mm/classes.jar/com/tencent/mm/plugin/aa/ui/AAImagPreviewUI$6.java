package com.tencent.mm.plugin.aa.ui;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;

final class AAImagPreviewUI$6
  implements Runnable
{
  AAImagPreviewUI$6(AAImagPreviewUI paramAAImagPreviewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(186977);
    if (com.tencent.mm.vfs.i.eK(AAImagPreviewUI.d(this.ibz)))
    {
      String str = com.tencent.mm.loader.j.b.ais() + "img_" + g.getMD5(AAImagPreviewUI.d(this.ibz)) + System.currentTimeMillis() + ".jpg";
      com.tencent.mm.vfs.i.deleteFile(str);
      com.tencent.mm.vfs.i.lC(AAImagPreviewUI.d(this.ibz), str);
      com.tencent.mm.sdk.f.b.k(str, this.ibz.getContext());
      Toast.makeText(this.ibz.getContext(), this.ibz.getContext().getString(2131760066, new Object[] { com.tencent.mm.loader.j.b.ais() }), 1).show();
    }
    for (;;)
    {
      com.tencent.mm.plugin.aa.model.i.pS(15);
      AppMethodBeat.o(186977);
      return;
      Toast.makeText(this.ibz.getContext(), this.ibz.getContext().getString(2131760659), 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.6
 * JD-Core Version:    0.7.0.1
 */