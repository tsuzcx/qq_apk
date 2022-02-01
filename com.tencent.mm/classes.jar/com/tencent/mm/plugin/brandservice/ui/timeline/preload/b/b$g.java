package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.d.d;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$getUrlWithA8key$2$1"})
final class b$g
  implements i
{
  b$g(d paramd, String paramString, HashMap paramHashMap) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(6838);
    Log.i("MicroMsg.Preload.TmplInfoManager", "[processTmplInfo]errType:%d, errCode:%dm errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramq.setHasCallbackToQueue(true);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null) {
        try
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelsimple.NetSceneGetA8Key");
          AppMethodBeat.o(6838);
          throw paramString;
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.Preload.TmplInfoManager", "NetSceneGetA8Key ex " + paramString.getMessage());
          AppMethodBeat.o(6838);
          return;
        }
      }
      paramString = (com.tencent.mm.modelsimple.l)paramq;
      paramq = paramString.beX();
      p.g(paramq, "netSceneGetA8Key.httpHeader");
      paramq = ((Iterable)paramq).iterator();
    }
    label185:
    label335:
    label340:
    label345:
    label348:
    label350:
    label353:
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      if (paramq.hasNext())
      {
        localObject1 = (ccc)paramq.next();
        localObject2 = (CharSequence)((ccc)localObject1).xMX;
        if (localObject2 == null) {
          break label335;
        }
        if (((CharSequence)localObject2).length() != 0) {
          break label345;
        }
        break label335;
        if (paramInt1 != 0) {
          break label348;
        }
        localObject2 = (CharSequence)((ccc)localObject1).Cyk;
        if (localObject2 == null) {
          break label340;
        }
        if (((CharSequence)localObject2).length() != 0) {
          break label350;
        }
        break label340;
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          break label353;
        }
        localObject2 = (Map)this.pFz;
        String str = ((ccc)localObject1).xMX;
        p.g(str, "it.Key");
        localObject1 = ((ccc)localObject1).Cyk;
        p.g(localObject1, "it.Value");
        ((Map)localObject2).put(str, localObject1);
        break;
        paramq = this.pEq;
        paramString = paramString.beQ();
        localObject1 = Result.Companion;
        paramq.resumeWith(Result.constructor-impl(paramString));
        AppMethodBeat.o(6838);
        return;
        paramString = this.pEq;
        paramq = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(""));
        AppMethodBeat.o(6838);
        return;
        paramInt1 = 1;
        break label185;
        paramInt1 = 1;
        continue;
        paramInt1 = 0;
        break label185;
        break;
        paramInt1 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.g
 * JD-Core Version:    0.7.0.1
 */