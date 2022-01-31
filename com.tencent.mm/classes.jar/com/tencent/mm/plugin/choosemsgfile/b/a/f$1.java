package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.plugin.choosemsgfile.b.b.b;
import com.tencent.mm.sdk.platformtools.ab;

final class f$1
  implements b.a
{
  f$1(f paramf) {}
  
  public final void bV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54270);
    this.kEF.dU(paramInt1, paramInt2);
    AppMethodBeat.o(54270);
  }
  
  public final void p(int paramInt, String paramString)
  {
    AppMethodBeat.i(54269);
    ab.i("MicroMsg.MsgFileWorker_Image", "DownloadCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      if ((this.kEF.kEs instanceof b))
      {
        ab.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
        f.a(this.kEF, (b)this.kEF.kEs);
        AppMethodBeat.o(54269);
        return;
      }
      this.kEF.bgi();
      AppMethodBeat.o(54269);
      return;
    }
    ab.e("MicroMsg.MsgFileWorker_Image", "download fail");
    this.kEF.bgi();
    AppMethodBeat.o(54269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.f.1
 * JD-Core Version:    0.7.0.1
 */