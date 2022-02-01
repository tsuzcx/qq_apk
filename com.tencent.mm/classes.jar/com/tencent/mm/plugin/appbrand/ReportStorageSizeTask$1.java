package com.tencent.mm.plugin.appbrand;

import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class ReportStorageSizeTask$1
  implements h
{
  ReportStorageSizeTask$1(ReportStorageSizeTask paramReportStorageSizeTask) {}
  
  public final String getKey()
  {
    AppMethodBeat.i(259521);
    String str = "MicroMsg.AppBrand.ReportStorageSizeTask#" + ReportStorageSizeTask.b(this.nzc);
    AppMethodBeat.o(259521);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(259520);
    try
    {
      ReportStorageSizeTask.a(this.nzc);
      AppMethodBeat.o(259520);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AppBrand.ReportStorageSizeTask", "doReport appId:%s, e:%s", new Object[] { ReportStorageSizeTask.b(this.nzc), localThrowable });
      AppMethodBeat.o(259520);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ReportStorageSizeTask.1
 * JD-Core Version:    0.7.0.1
 */