package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ba;
import com.tencent.mm.plugin.finder.conv.j;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.i.a.p.b;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/service/FinderSessionStatusUpdater;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "setCallback", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;)V", "doScene", "", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class e
  implements f
{
  static p.b suv;
  public static final e suw;
  
  static
  {
    AppMethodBeat.i(203544);
    suw = new e();
    AppMethodBeat.o(203544);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(203543);
    g.aiU().b(6218, (f)this);
    ad.i("Finder.FinderSessionStatusUpdater", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof ba)))
    {
      paramString = suv;
      if (paramString != null) {
        paramString.dH((List)((ba)paramn).cyL());
      }
      paramString = ((ba)paramn).cyL();
      if (paramString != null)
      {
        paramString = ((Iterable)paramString).iterator();
        while (paramString.hasNext())
        {
          Object localObject = (apv)paramString.next();
          ad.i("Finder.FinderSessionStatusUpdater", "sessionId:" + ((apv)localObject).sessionId + " , reject:" + ((apv)localObject).GnZ + ", enableAction:" + ((apv)localObject).Goa);
          paramn = ((PluginFinder)g.ad(PluginFinder.class)).getSessionInfoStorage();
          String str = ((apv)localObject).sessionId;
          p.g(str, "it.sessionId");
          paramInt1 = ((apv)localObject).GnZ;
          paramInt2 = ((apv)localObject).Goa;
          p.h(str, "sessionId");
          localObject = paramn.aiw(str);
          ((j)localObject).field_rejectMsg = paramInt1;
          ((j)localObject).field_actionPermission = paramInt2;
          if (paramn.updateNotify((c)localObject, false, new String[] { null }))
          {
            paramn.sze.remove(((j)localObject).field_talker);
            paramn.szf.remove(((j)localObject).field_sessionId);
            paramn.doNotify(((j)localObject).field_sessionId);
          }
        }
      }
    }
    suv = null;
    AppMethodBeat.o(203543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.e
 * JD-Core Version:    0.7.0.1
 */