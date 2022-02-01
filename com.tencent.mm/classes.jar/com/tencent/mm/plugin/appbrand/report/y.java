package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.fnr;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;

public abstract interface y
{
  public abstract void a(fnr paramfnr);
  
  public abstract void cD(String paramString, int paramInt);
  
  public static final class a
  {
    private static final y qKq;
    
    static
    {
      AppMethodBeat.i(277836);
      qKq = new y()
      {
        public final void a(fnr paramAnonymousfnr)
        {
          AppMethodBeat.i(281089);
          AppBrandIDKeyBatchReport.a(paramAnonymousfnr);
          AppMethodBeat.o(281089);
        }
        
        public final void cD(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(281090);
          AppBrandIDKeyBatchReport.cD(paramAnonymousString, paramAnonymousInt);
          AppMethodBeat.o(281090);
        }
      };
      AppMethodBeat.o(277836);
    }
    
    public static y chL()
    {
      AppMethodBeat.i(277835);
      int i = ((b)h.ae(b.class)).a(b.a.vAZ, 0);
      Log.i("Luggage.WxaCgiIDKeyBatchReportProtocol.Factory", "IMPL() exptVal=%d", new Object[] { Integer.valueOf(i) });
      if ((i > 0) || (BuildInfo.DEBUG))
      {
        localObject = d.qIP;
        AppMethodBeat.o(277835);
        return localObject;
      }
      Object localObject = qKq;
      AppMethodBeat.o(277835);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.y
 * JD-Core Version:    0.7.0.1
 */