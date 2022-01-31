package com.tencent.mm.plugin.exdevice.f.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;

final class e$2
  implements h.d
{
  e$2(MMActivity paramMMActivity) {}
  
  public final void ca(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(19440);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(19440);
      return;
      MMActivity localMMActivity = this.lHl;
      Intent localIntent = new Intent();
      localIntent.putExtra("query_source_type", 9);
      localIntent.putExtra("query_media_type", 1);
      localIntent.putExtra("max_select_count", 1);
      d.b(localMMActivity, "gallery", ".ui.AlbumPreviewUI", localIntent, 1001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.e.2
 * JD-Core Version:    0.7.0.1
 */