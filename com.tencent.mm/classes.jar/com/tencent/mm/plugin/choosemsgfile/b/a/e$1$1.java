package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.ab;

final class e$1$1
  implements b.a
{
  e$1$1(e.1 param1, b paramb) {}
  
  public final void bV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54263);
    this.kED.kEB.dU(paramInt1, paramInt2);
    AppMethodBeat.o(54263);
  }
  
  public final void p(int paramInt, String paramString)
  {
    AppMethodBeat.i(54262);
    ab.i("MicroMsg.MsgFileWorker_File", "DownloadCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      paramString = new MsgFile();
      paramString.fileSize = this.kED.kEB.kEs.bgn();
      paramString.filePath = this.kEC.field_fileFullPath;
      paramString.fileName = this.kED.kEB.kEs.getFileName();
      paramString.type = "file";
      paramString.elt = this.kED.kEB.kEs.bgm();
      paramString.timeStamp = (this.kED.kEB.kEs.getTimeStamp() / 1000L);
      this.kED.kEB.b(paramString);
      AppMethodBeat.o(54262);
      return;
    }
    if (paramInt == 1)
    {
      this.kED.kEB.bgh();
      AppMethodBeat.o(54262);
      return;
    }
    ab.e("MicroMsg.MsgFileWorker_File", "download %s fail", new Object[] { this.kED.kEB.kEs });
    this.kED.kEB.bgi();
    AppMethodBeat.o(54262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.e.1.1
 * JD-Core Version:    0.7.0.1
 */