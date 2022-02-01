package com.tencent.mm.plugin.appbrand.networking;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.oz;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "run"})
final class b$a
  implements Runnable
{
  b$a(b paramb, dyy paramdyy, int paramInt, q paramq) {}
  
  public final void run()
  {
    AppMethodBeat.i(280455);
    long l1 = System.currentTimeMillis();
    long l2 = SystemClock.elapsedRealtime();
    long l3 = b.a(this.qkX);
    oz localoz = new oz();
    localoz.Bw(b.b(this.qkX));
    localoz.Bx(l1);
    localoz.By(l2 - l3);
    localoz.FU(j.getNetworkType(MMApplicationContext.getContext()));
    Object localObject1 = this.qkY;
    int i;
    label139:
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      l1 = ((dyy)localObject1).computeSize();
      localoz.Bz(l1);
      localoz.oy(this.iVN);
      localObject1 = this.qkY;
      if (localObject1 == null) {
        break label311;
      }
      localObject1 = ((dyy)localObject1).BaseResponse;
      if (localObject1 == null) {
        break label311;
      }
      i = ((jh)localObject1).CqV;
      localoz.oz(i);
      localoz.oA(this.khQ.getType());
      com.tencent.mm.plugin.appbrand.report.quality.b.cik();
      localObject1 = b.c(this.qkX);
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = "";
      }
      localObject1 = b.d(this.qkX);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      p.k(localoz, "weAppQualityCGISpeedStruct");
    }
    for (;;)
    {
      try
      {
        localObject1 = com.tencent.mm.plugin.appbrand.report.quality.b.amO((String)localObject3);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((QualitySessionRuntime)localObject1).cBH;
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
      localoz.FS((String)localObject4);
      if (localObject1 != null) {
        continue;
      }
      localObject1 = "";
      localoz.FR((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localoz.FT((String)localObject1);
      localoz.bpa();
      AppMethodBeat.o(280455);
      return;
      l1 = -1L;
      break;
      i = -2147483648;
      break label139;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.b.a
 * JD-Core Version:    0.7.0.1
 */