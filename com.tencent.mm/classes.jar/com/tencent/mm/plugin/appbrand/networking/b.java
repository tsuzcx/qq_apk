package com.tencent.mm.plugin.appbrand.networking;

import android.os.SystemClock;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.ab;
import com.tencent.mm.an.c;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.q;
import com.tencent.mm.cw.f;
import com.tencent.mm.protocal.protobuf.dyy;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "appId", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "startElapsedTime", "", "startTimestamp", "call", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "onBeforeRunCgi", "Lcom/tencent/mm/wx/WxPipeline;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "run", "plugin-appbrand-integration_release"})
public class b<T extends dyy>
  extends c<T>
{
  private final String appId;
  private final long qkV;
  private final long qkW;
  private final String userName;
  
  public b(byte paramByte)
  {
    this();
  }
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(275194);
    this.appId = paramString1;
    this.userName = paramString2;
    this.qkV = System.currentTimeMillis();
    this.qkW = SystemClock.elapsedRealtime();
    AppMethodBeat.o(275194);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, T paramT, q paramq)
  {
    AppMethodBeat.i(275190);
    super.a(paramInt1, paramInt2, paramString, paramT, paramq);
    if (paramq != null) {
      h.ZvG.be((Runnable)new b.a(this, paramT, paramInt2, paramq));
    }
    AppMethodBeat.o(275190);
  }
  
  public f<c.a<T>> bLt()
  {
    return null;
  }
  
  public f<c.a<T>> bhW()
  {
    AppMethodBeat.i(275192);
    f localf = bLt();
    if (localf != null)
    {
      AppMethodBeat.o(275192);
      return localf;
    }
    localf = super.bhW();
    p.j(localf, "super.run()");
    AppMethodBeat.o(275192);
    return localf;
  }
  
  public c.a<T> cap()
  {
    AppMethodBeat.i(275189);
    c.a locala = ab.c((c)this);
    AppMethodBeat.o(275189);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.b
 * JD-Core Version:    0.7.0.1
 */