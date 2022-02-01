package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.gkq;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;

public abstract interface z
{
  public abstract void a(gkq paramgkq);
  
  public abstract void dd(String paramString, int paramInt);
  
  public static final class a
  {
    private static final z tOT;
    
    static
    {
      AppMethodBeat.i(321374);
      tOT = new z()
      {
        public final void a(gkq paramAnonymousgkq)
        {
          AppMethodBeat.i(321337);
          AppBrandIDKeyBatchReport.a(paramAnonymousgkq);
          AppMethodBeat.o(321337);
        }
        
        public final void dd(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(321341);
          AppBrandIDKeyBatchReport.dd(paramAnonymousString, paramAnonymousInt);
          AppMethodBeat.o(321341);
        }
      };
      AppMethodBeat.o(321374);
    }
    
    public static z cIG()
    {
      AppMethodBeat.i(321370);
      int i = ((c)h.ax(c.class)).a(c.a.yON, 0);
      Log.i("Luggage.WxaCgiIDKeyBatchReportProtocol.Factory", "IMPL() exptVal=%d", new Object[] { Integer.valueOf(i) });
      if ((i > 0) || (BuildInfo.DEBUG))
      {
        localObject = d.tNo;
        AppMethodBeat.o(321370);
        return localObject;
      }
      Object localObject = tOT;
      AppMethodBeat.o(321370);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.z
 * JD-Core Version:    0.7.0.1
 */