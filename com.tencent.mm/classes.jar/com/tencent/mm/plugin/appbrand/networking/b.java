package com.tencent.mm.plugin.appbrand.networking;

import android.os.SystemClock;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ab;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.co.f;
import com.tencent.mm.g.b.a.mb;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "appId", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "startElapsedTime", "", "startTimestamp", "call", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "onBeforeRunCgi", "Lcom/tencent/mm/wx/WxPipeline;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "run", "plugin-appbrand-integration_release"})
public class b<T extends dpc>
  extends c<T>
{
  final String appId;
  final long njx;
  final long njy;
  final String userName;
  
  public b(byte paramByte)
  {
    this();
  }
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(229066);
    this.appId = paramString1;
    this.userName = paramString2;
    this.njx = System.currentTimeMillis();
    this.njy = SystemClock.elapsedRealtime();
    AppMethodBeat.o(229066);
  }
  
  public void a(int paramInt1, final int paramInt2, String paramString, final T paramT, final q paramq)
  {
    AppMethodBeat.i(229064);
    super.a(paramInt1, paramInt2, paramString, paramT, paramq);
    if (paramq != null) {
      h.RTc.aX((Runnable)new a(this, paramT, paramInt2, paramq));
    }
    AppMethodBeat.o(229064);
  }
  
  public f<c.a<T>> aYI()
  {
    AppMethodBeat.i(229065);
    f localf = bAe();
    if (localf != null)
    {
      AppMethodBeat.o(229065);
      return localf;
    }
    localf = super.aYI();
    p.g(localf, "super.run()");
    AppMethodBeat.o(229065);
    return localf;
  }
  
  public f<c.a<T>> bAe()
  {
    return null;
  }
  
  public c.a<T> bNV()
  {
    AppMethodBeat.i(229063);
    c.a locala = ab.a((c)this);
    AppMethodBeat.o(229063);
    return locala;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "run"})
  static final class a
    implements Runnable
  {
    a(b paramb, dpc paramdpc, int paramInt, q paramq) {}
    
    public final void run()
    {
      AppMethodBeat.i(229062);
      long l1 = System.currentTimeMillis();
      long l2 = SystemClock.elapsedRealtime();
      long l3 = this.njz.njy;
      mb localmb = new mb();
      localmb.vB(this.njz.njx);
      localmb.vC(l1);
      localmb.vD(l2 - l3);
      localmb.zo(com.tencent.mm.plugin.appbrand.report.i.getNetworkType(MMApplicationContext.getContext()));
      Object localObject1 = paramT;
      int i;
      label139:
      Object localObject3;
      Object localObject2;
      if (localObject1 != null)
      {
        l1 = ((dpc)localObject1).computeSize();
        localmb.vE(l1);
        localmb.mn(paramInt2);
        localObject1 = paramT;
        if (localObject1 == null) {
          break label311;
        }
        localObject1 = ((dpc)localObject1).BaseResponse;
        if (localObject1 == null) {
          break label311;
        }
        i = ((BaseResponse)localObject1).Ret;
        localmb.mo(i);
        localmb.mp(paramq.getType());
        com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
        localObject1 = this.njz.appId;
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = "";
        }
        localObject1 = this.njz.userName;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        p.h(localmb, "weAppQualityCGISpeedStruct");
      }
      for (;;)
      {
        try
        {
          localObject1 = com.tencent.mm.plugin.appbrand.report.quality.b.aeU((String)localObject3);
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((QualitySessionRuntime)localObject1).kEY;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          Object localObject4;
          label311:
          String str = "";
          continue;
          continue;
        }
        localObject4 = localObject3;
        if (localObject3 == null) {
          localObject4 = "";
        }
        localmb.zm((String)localObject4);
        if (localObject1 != null) {
          continue;
        }
        localObject1 = "";
        localmb.zl((String)localObject1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localmb.zn((String)localObject1);
        localmb.bfK();
        AppMethodBeat.o(229062);
        return;
        l1 = -1L;
        break;
        i = -2147483648;
        break label139;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.b
 * JD-Core Version:    0.7.0.1
 */