package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.fcq;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;

public abstract interface x
{
  public abstract void a(fcq paramfcq);
  
  public abstract void ce(String paramString, int paramInt);
  
  public static final class a
  {
    private static final x nIe;
    
    static
    {
      AppMethodBeat.i(227378);
      nIe = new x()
      {
        public final void a(fcq paramAnonymousfcq)
        {
          AppMethodBeat.i(227375);
          AppBrandIDKeyBatchReport.a(paramAnonymousfcq);
          AppMethodBeat.o(227375);
        }
        
        public final void ce(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(227376);
          AppBrandIDKeyBatchReport.ce(paramAnonymousString, paramAnonymousInt);
          AppMethodBeat.o(227376);
        }
      };
      AppMethodBeat.o(227378);
    }
    
    public static x bUB()
    {
      AppMethodBeat.i(227377);
      int i = ((b)g.af(b.class)).a(b.a.rUp, 0);
      Log.i("Luggage.WxaCgiIDKeyBatchReportProtocol.Factory", "IMPL() exptVal=%d", new Object[] { Integer.valueOf(i) });
      if ((i > 0) || (BuildInfo.DEBUG))
      {
        localObject = d.nGE;
        AppMethodBeat.o(227377);
        return localObject;
      }
      Object localObject = nIe;
      AppMethodBeat.o(227377);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.x
 * JD-Core Version:    0.7.0.1
 */