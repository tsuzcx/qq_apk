package com.tencent.liteav.network;

import android.os.Handler;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Vector;

class TXCStreamDownloader$2
  implements g.a
{
  TXCStreamDownloader$2(TXCStreamDownloader paramTXCStreamDownloader, String paramString, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString, Vector<e> paramVector)
  {
    AppMethodBeat.i(67533);
    int i;
    if ((paramInt == 0) && (paramVector != null) && (!paramVector.isEmpty())) {
      if (TXCStreamDownloader.access$400(this.c)) {
        if (TXCStreamDownloader.access$500(this.c) != null)
        {
          paramString = paramVector.iterator();
          i = 0;
          if (paramString.hasNext())
          {
            e locale = (e)paramString.next();
            if ((locale == null) || (!locale.b) || (locale.a == null) || (locale.a.length() <= 0)) {
              break label355;
            }
            i += 1;
          }
        }
      }
    }
    label355:
    for (;;)
    {
      break;
      this.c.setStatusValue(7113, Long.valueOf(i));
      this.c.setStatusValue(7112, Long.valueOf(2L));
      TXCStreamDownloader.access$500(this.c).setOriginUrl(this.a);
      TXCStreamDownloader.access$500(this.c).startDownload(paramVector, true, true, this.b);
      if (TXCStreamDownloader.access$600(this.c) != null) {
        TXCStreamDownloader.access$600(this.c).postDelayed(TXCStreamDownloader.access$700(this.c), 2000L);
      }
      paramString = TXCStreamDownloader.access$800(this.c).b();
      TXCDRApi.txReportDAU(TXCStreamDownloader.access$900(this.c), a.at, paramInt, paramString);
      AppMethodBeat.o(67533);
      return;
      TXCDRApi.txReportDAU(TXCStreamDownloader.access$900(this.c), a.at, -4, "livePlayer have been stopped");
      AppMethodBeat.o(67533);
      return;
      this.c.onNotifyEvent(-2302, null);
      TXCDRApi.txReportDAU(TXCStreamDownloader.access$900(this.c), a.at, paramInt, paramString);
      TXCLog.e("TXCStreamDownloader", "getAccelerateStreamPlayUrl failed, play stream with raw url");
      if (TXCStreamDownloader.access$400(this.c))
      {
        TXCStreamDownloader.access$1000(this.c, this.a, this.b);
        if (TXCStreamDownloader.access$600(this.c) != null) {
          TXCStreamDownloader.access$600(this.c).postDelayed(TXCStreamDownloader.access$700(this.c), 2000L);
        }
      }
      AppMethodBeat.o(67533);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.network.TXCStreamDownloader.2
 * JD-Core Version:    0.7.0.1
 */