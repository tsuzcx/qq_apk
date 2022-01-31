package com.tencent.mm.plugin.cdndownloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cdndownloader.a.b.a;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.sdk.platformtools.ab;

final class a$4
  extends b.a
{
  a$4(a parama) {}
  
  public final void e(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(895);
    ab.i("MicroMsg.CDNDownloadClient", "onDownloadStateChange, mediaId = %s, state = %d, errCode = %d, errMsg = %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if (paramInt1 != 1) {
      a.a(this.kDM, new CDNTaskInfo(paramString1));
    }
    if (a.k(this.kDM) != null) {
      a.k(this.kDM).f(paramString1, paramInt1, paramInt2, paramString2);
    }
    AppMethodBeat.o(895);
  }
  
  public final void s(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(896);
    ab.d("MicroMsg.CDNDownloadClient", "onDownloadProgressChange, mediaId = %s, receiveLen = %d, totalLen = %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (a.k(this.kDM) != null) {
      a.k(this.kDM).t(paramString, paramLong1, paramLong2);
    }
    AppMethodBeat.o(896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.d.a.4
 * JD-Core Version:    0.7.0.1
 */