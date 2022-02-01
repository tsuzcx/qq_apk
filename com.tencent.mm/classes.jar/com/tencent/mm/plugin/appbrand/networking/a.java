package com.tencent.mm.plugin.appbrand.networking;

import android.os.SystemClock;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.y;
import com.tencent.mm.g.b.a.ie;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "appId", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "startElapsedTime", "", "startTimestamp", "call", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "plugin-appbrand-integration_release"})
public class a<T extends cvp>
  extends com.tencent.mm.al.a<T>
{
  final String appId;
  final long lXf;
  final long lXg;
  final String userName;
  
  public a(byte paramByte)
  {
    this();
  }
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189547);
    this.appId = paramString1;
    this.userName = paramString2;
    this.lXf = System.currentTimeMillis();
    this.lXg = SystemClock.elapsedRealtime();
    AppMethodBeat.o(189547);
  }
  
  public void a(int paramInt1, final int paramInt2, String paramString, final T paramT, final n paramn)
  {
    AppMethodBeat.i(189546);
    super.a(paramInt1, paramInt2, paramString, paramT, paramn);
    if (paramn != null) {
      com.tencent.e.h.LTJ.aR((Runnable)new a(this, paramT, paramInt2, paramn));
    }
    AppMethodBeat.o(189546);
  }
  
  public com.tencent.mm.al.a.a<T> brO()
  {
    AppMethodBeat.i(189545);
    com.tencent.mm.al.a.a locala = y.a((com.tencent.mm.al.a)this);
    AppMethodBeat.o(189545);
    return locala;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "run"})
  static final class a
    implements Runnable
  {
    a(a parama, cvp paramcvp, int paramInt, n paramn) {}
    
    public final void run()
    {
      AppMethodBeat.i(189544);
      long l1 = System.currentTimeMillis();
      long l2 = SystemClock.elapsedRealtime();
      long l3 = this.lXh.lXg;
      ie localie = new ie();
      localie.nF(this.lXh.lXf);
      localie.nG(l1);
      localie.nH(l2 - l3);
      localie.qQ(com.tencent.mm.plugin.appbrand.report.h.getNetworkType(aj.getContext()));
      Object localObject1 = paramT;
      int i;
      label139:
      Object localObject3;
      Object localObject2;
      if (localObject1 != null)
      {
        l1 = ((cvp)localObject1).computeSize();
        localie.nI(l1);
        localie.jj(paramInt2);
        localObject1 = paramT;
        if (localObject1 == null) {
          break label311;
        }
        localObject1 = ((cvp)localObject1).BaseResponse;
        if (localObject1 == null) {
          break label311;
        }
        i = ((BaseResponse)localObject1).Ret;
        localie.jk(i);
        localie.jl(paramn.getType());
        com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
        localObject1 = this.lXh.appId;
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = "";
        }
        localObject1 = this.lXh.userName;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        p.h(localie, "weAppQualityCGISpeedStruct");
      }
      for (;;)
      {
        try
        {
          localObject1 = com.tencent.mm.plugin.appbrand.report.quality.a.Ut((String)localObject3);
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((QualitySessionRuntime)localObject1).lEv;
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
        localie.qO((String)localObject4);
        if (localObject1 != null) {
          continue;
        }
        localObject1 = "";
        localie.qN((String)localObject1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localie.qP((String)localObject1);
        localie.aLk();
        AppMethodBeat.o(189544);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.a
 * JD-Core Version:    0.7.0.1
 */