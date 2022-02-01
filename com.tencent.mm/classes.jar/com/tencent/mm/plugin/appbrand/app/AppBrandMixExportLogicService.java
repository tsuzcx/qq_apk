package com.tencent.mm.plugin.appbrand.app;

import android.content.Context;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.plugin.appbrand.ui.recommend.c;

public final class AppBrandMixExportLogicService
  implements com.tencent.mm.plugin.appbrand.service.g
{
  public static com.tencent.mm.vending.g.e<Pair<String, String>> x(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44098);
    paramString = com.tencent.mm.co.g.j(paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(44098);
    return paramString;
  }
  
  public final String Du(String paramString)
  {
    AppMethodBeat.i(195587);
    paramString = u.Du(paramString);
    AppMethodBeat.o(195587);
    return paramString;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(174698);
    OpenFileRequest localOpenFileRequest = new OpenFileRequest();
    localOpenFileRequest.filePath = paramString1;
    localOpenFileRequest.fyk = paramString2;
    localOpenFileRequest.appId = paramString3;
    localOpenFileRequest.juW = paramBoolean;
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, localOpenFileRequest, paramString4);
    AppMethodBeat.o(174698);
  }
  
  public final <T extends Parcelable> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(174695);
    com.tencent.mm.plugin.appbrand.ipc.e.b(paramString, paramT);
    AppMethodBeat.o(174695);
  }
  
  public final void aOn()
  {
    AppMethodBeat.i(44096);
    com.tencent.mm.plugin.appbrand.task.f.bnE();
    AppMethodBeat.o(44096);
  }
  
  public final void aOo()
  {
    AppMethodBeat.i(44097);
    if ((c.bpT()) && (c.bpV())) {
      com.tencent.mm.plugin.appbrand.task.f.bnE();
    }
    h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44089);
        com.tencent.mm.plugin.appbrand.ui.recommend.d locald = com.tencent.mm.plugin.appbrand.ui.recommend.d.lKz;
        com.tencent.mm.plugin.appbrand.ui.recommend.d.bpW();
        AppMethodBeat.o(44089);
      }
    });
    AppMethodBeat.o(44097);
  }
  
  public final void aOp()
  {
    AppMethodBeat.i(195586);
    j.aLG();
    AppMethodBeat.o(195586);
  }
  
  public final Pair<String, Integer> qB(int paramInt)
  {
    AppMethodBeat.i(195588);
    Pair localPair = new Pair(com.tencent.mm.plugin.appbrand.appcache.e.qC(paramInt), Integer.valueOf(2131231009));
    AppMethodBeat.o(195588);
    return localPair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService
 * JD-Core Version:    0.7.0.1
 */