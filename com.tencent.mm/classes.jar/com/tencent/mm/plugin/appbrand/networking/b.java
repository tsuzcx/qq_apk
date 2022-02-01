package com.tencent.mm.plugin.appbrand.networking;

import android.os.SystemClock;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.y;
import com.tencent.mm.cm.f;
import com.tencent.mm.g.b.a.ig;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "appId", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "startElapsedTime", "", "startTimestamp", "call", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "onBeforeRunCgi", "Lcom/tencent/mm/wx/WxPipeline;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "run", "plugin-appbrand-integration_release"})
public class b<T extends cwj>
  extends com.tencent.mm.ak.a<T>
{
  final String appId;
  final long mbM;
  final long mbN;
  final String userName;
  
  public b(byte paramByte)
  {
    this();
  }
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223816);
    this.appId = paramString1;
    this.userName = paramString2;
    this.mbM = System.currentTimeMillis();
    this.mbN = SystemClock.elapsedRealtime();
    AppMethodBeat.o(223816);
  }
  
  public void a(int paramInt1, final int paramInt2, String paramString, final T paramT, final n paramn)
  {
    AppMethodBeat.i(223814);
    super.a(paramInt1, paramInt2, paramString, paramT, paramn);
    if (paramn != null) {
      com.tencent.e.h.MqF.aO((Runnable)new a(this, paramT, paramInt2, paramn));
    }
    AppMethodBeat.o(223814);
  }
  
  public f<a.a<T>> aET()
  {
    AppMethodBeat.i(223815);
    f localf = beN();
    if (localf != null)
    {
      AppMethodBeat.o(223815);
      return localf;
    }
    localf = super.aET();
    p.g(localf, "super.run()");
    AppMethodBeat.o(223815);
    return localf;
  }
  
  public f<a.a<T>> beN()
  {
    return null;
  }
  
  public a.a<T> bsz()
  {
    AppMethodBeat.i(223813);
    a.a locala = y.a((com.tencent.mm.ak.a)this);
    AppMethodBeat.o(223813);
    return locala;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "run"})
  static final class a
    implements Runnable
  {
    a(b paramb, cwj paramcwj, int paramInt, n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(223812);
      long l1 = System.currentTimeMillis();
      long l2 = SystemClock.elapsedRealtime();
      long l3 = this.mbO.mbN;
      ig localig = new ig();
      localig.nR(this.mbO.mbM);
      localig.nS(l1);
      localig.nT(l2 - l3);
      localig.rl(com.tencent.mm.plugin.appbrand.report.h.getNetworkType(ak.getContext()));
      Object localObject1 = paramT;
      int i;
      label139:
      Object localObject3;
      Object localObject2;
      if (localObject1 != null)
      {
        l1 = ((cwj)localObject1).computeSize();
        localig.nU(l1);
        localig.jl(paramInt2);
        localObject1 = paramT;
        if (localObject1 == null) {
          break label311;
        }
        localObject1 = ((cwj)localObject1).BaseResponse;
        if (localObject1 == null) {
          break label311;
        }
        i = ((BaseResponse)localObject1).Ret;
        localig.jm(i);
        localig.jn(paramn.getType());
        com.tencent.mm.plugin.appbrand.report.quality.a.byG();
        localObject1 = this.mbO.appId;
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = "";
        }
        localObject1 = this.mbO.userName;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        p.h(localig, "weAppQualityCGISpeedStruct");
      }
      for (;;)
      {
        try
        {
          localObject1 = com.tencent.mm.plugin.appbrand.report.quality.a.Ve((String)localObject3);
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((QualitySessionRuntime)localObject1).lIU;
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
        localig.rj((String)localObject4);
        if (localObject1 != null) {
          continue;
        }
        localObject1 = "";
        localig.ri((String)localObject1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localig.rk((String)localObject1);
        localig.aLH();
        AppMethodBeat.o(223812);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.b
 * JD-Core Version:    0.7.0.1
 */