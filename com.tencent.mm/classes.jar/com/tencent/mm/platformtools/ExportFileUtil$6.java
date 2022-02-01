package com.tencent.mm.platformtools;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExportFileUtil$6
  implements Runnable
{
  ExportFileUtil$6(Context paramContext, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(234010);
    Toast.makeText(this.val$context, this.pAF, 1).show();
    AppMethodBeat.o(234010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.ExportFileUtil.6
 * JD-Core Version:    0.7.0.1
 */