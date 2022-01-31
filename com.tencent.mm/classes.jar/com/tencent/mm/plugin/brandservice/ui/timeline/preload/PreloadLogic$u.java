package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.b.j;
import a.l;
import a.v;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.protocal.protobuf.ie;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
final class PreloadLogic$u
  implements w.a
{
  PreloadLogic$u(long paramLong1, long paramLong2, a.f.a.b paramb, ArrayList paramArrayList) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, m paramm)
  {
    AppMethodBeat.i(14911);
    paramm = PreloadLogic.kbJ;
    ab.i(PreloadLogic.aXI(), "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = new Bundle();
    Object localObject1;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      j.p(paramb, "rr");
      if ((paramb.adn() != null) && ((paramb.adn() instanceof ie)))
      {
        paramb = paramb.adn();
        if (paramb == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BatchGetAppMsgResp");
          AppMethodBeat.o(14911);
          throw paramString;
        }
        paramb = (ie)paramb;
        paramString.putBoolean("success", true);
        paramString.putByteArray("response", paramb.toByteArray());
        paramm = paramb.wuM;
        j.p(paramm, "response.SceneControlList");
        if (!((Collection)paramm).isEmpty())
        {
          paramInt1 = 1;
          if (paramInt1 != 0)
          {
            paramm = o.aXO();
            localObject1 = new bwu();
            ((bwu)localObject1).wuM = paramb.wuM;
            paramm.encode("_msg_scene_strip", ((bwu)localObject1).toByteArray());
          }
        }
      }
    }
    for (;;)
    {
      paramString.putLong("start", this.kch);
      long l = System.currentTimeMillis();
      paramString.putLong("end", l);
      paramb = PreloadLogic.kbJ;
      ab.v(PreloadLogic.aXI(), "terry performance runCGI #" + this.kci + ": " + this.kch + ',' + l);
      this.evA.S(paramString);
      paramString.putBoolean("mount", true);
      paramb = this.kcj;
      j.p(paramb, "urls");
      paramb = ((Iterable)paramb).iterator();
      while (paramb.hasNext())
      {
        paramm = (String)paramb.next();
        j.p(paramm, "url");
        paramm = b.GR(paramm);
        localObject1 = PreloadLogic.kbJ;
        localObject1 = (ConcurrentLinkedDeque)PreloadLogic.aXD().get(paramm);
        Object localObject2 = PreloadLogic.kbJ;
        PreloadLogic.aXD().remove(paramm);
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (a.f.a.b)((Iterator)localObject1).next();
            paramString.putString("id", paramm);
            ((a.f.a.b)localObject2).S(paramString);
          }
        }
      }
      paramInt1 = 0;
      break;
      paramString.putBoolean("success", false);
    }
    AppMethodBeat.o(14911);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.u
 * JD-Core Version:    0.7.0.1
 */