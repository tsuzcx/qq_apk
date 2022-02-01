package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.conv.j;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.i.a.p.b;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/service/FinderSessionStatusUpdater;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "setCallback", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;)V", "doScene", "", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class e
  implements f
{
  static p.b sEF;
  public static final e sEG;
  
  static
  {
    AppMethodBeat.i(204104);
    sEG = new e();
    AppMethodBeat.o(204104);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(204103);
    g.ajj().b(6218, (f)this);
    ae.i("Finder.FinderSessionStatusUpdater", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof bb)))
    {
      paramString = sEF;
      if (paramString != null) {
        paramString.dK((List)((bb)paramn).cAm());
      }
      paramString = ((bb)paramn).cAm();
      if (paramString != null)
      {
        paramString = ((Iterable)paramString).iterator();
        while (paramString.hasNext())
        {
          Object localObject = (aqi)paramString.next();
          ae.i("Finder.FinderSessionStatusUpdater", "sessionId:" + ((aqi)localObject).sessionId + " , reject:" + ((aqi)localObject).GHf + ", enableAction:" + ((aqi)localObject).GHg);
          paramn = ((PluginFinder)g.ad(PluginFinder.class)).getSessionInfoStorage();
          String str = ((aqi)localObject).sessionId;
          p.g(str, "it.sessionId");
          paramInt1 = ((aqi)localObject).GHf;
          paramInt2 = ((aqi)localObject).GHg;
          p.h(str, "sessionId");
          localObject = paramn.ajt(str);
          ((j)localObject).field_rejectMsg = paramInt1;
          ((j)localObject).field_actionPermission = paramInt2;
          if (paramn.updateNotify((c)localObject, false, new String[] { null }))
          {
            paramn.sJV.remove(((j)localObject).field_talker);
            paramn.sJW.remove(((j)localObject).field_sessionId);
            paramn.doNotify(((j)localObject).field_sessionId);
          }
        }
      }
    }
    sEF = null;
    AppMethodBeat.o(204103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.e
 * JD-Core Version:    0.7.0.1
 */