package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import a.c.c;
import a.l;
import a.p;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$getUrlWithA8key$2$1"})
final class b$g
  implements f
{
  b$g(c paramc, String paramString, HashMap paramHashMap) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(152714);
    ab.i("MicroMsg.Preload.TmplInfoManager", "[processTmplInfo]errType:%d, errCode:%dm errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramm.setHasCallbackToQueue(true);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelsimple.NetSceneGetA8Key");
        AppMethodBeat.o(152714);
        throw paramString;
      }
      paramString = (com.tencent.mm.modelsimple.j)paramm;
      paramm = paramString.ajs();
      a.f.b.j.p(paramm, "netSceneGetA8Key.httpHeader");
      paramm = ((Iterable)paramm).iterator();
      label150:
      label240:
      label242:
      label245:
      while (paramm.hasNext())
      {
        localObject1 = (avl)paramm.next();
        Object localObject2 = (CharSequence)((avl)localObject1).wxP;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
        {
          paramInt1 = 1;
          if (paramInt1 != 0) {
            break label240;
          }
          localObject2 = (CharSequence)((avl)localObject1).qsu;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label242;
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            break label245;
          }
          localObject2 = (Map)this.kcR;
          String str = ((avl)localObject1).wxP;
          a.f.b.j.p(str, "it.Key");
          localObject1 = ((avl)localObject1).qsu;
          a.f.b.j.p(localObject1, "it.Value");
          ((Map)localObject2).put(str, localObject1);
          break;
          paramInt1 = 0;
          break label150;
          break;
        }
      }
      paramm = this.kcP;
      paramString = paramString.ajl();
      Object localObject1 = p.BLX;
      paramm.dg(p.de(paramString));
      AppMethodBeat.o(152714);
      return;
    }
    paramString = this.kcP;
    paramm = p.BLX;
    paramString.dg(p.de(""));
    AppMethodBeat.o(152714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.g
 * JD-Core Version:    0.7.0.1
 */