package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.cg;
import com.tencent.mm.plugin.finder.conv.k;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.i.a.aa.b;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/service/FinderSessionStatusUpdater;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "setCallback", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;)V", "doScene", "", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class f
  implements i
{
  static aa.b vwd;
  public static final f vwe;
  
  static
  {
    AppMethodBeat.i(251487);
    vwe = new f();
    AppMethodBeat.o(251487);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(251486);
    g.azz().b(6218, (i)this);
    Log.i("Finder.FinderSessionStatusUpdater", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof cg)))
    {
      paramString = vwd;
      if (paramString != null) {
        paramString.er((List)((cg)paramq).cZe());
      }
      paramString = ((cg)paramq).cZe();
      if (paramString != null)
      {
        paramString = ((Iterable)paramString).iterator();
        while (paramString.hasNext())
        {
          Object localObject = (azj)paramString.next();
          Log.i("Finder.FinderSessionStatusUpdater", "sessionId:" + ((azj)localObject).sessionId + " , reject:" + ((azj)localObject).LJe + ", enableAction:" + ((azj)localObject).LJf);
          paramq = ((PluginFinder)g.ah(PluginFinder.class)).getSessionInfoStorage();
          String str = ((azj)localObject).sessionId;
          p.g(str, "it.sessionId");
          paramInt1 = ((azj)localObject).LJe;
          paramInt2 = ((azj)localObject).LJf;
          p.h(str, "sessionId");
          localObject = paramq.avz(str);
          ((k)localObject).field_rejectMsg = paramInt1;
          ((k)localObject).field_actionPermission = paramInt2;
          if (paramq.updateNotify((IAutoDBItem)localObject, false, new String[] { null }))
          {
            paramq.vFa.remove(((k)localObject).field_talker);
            paramq.vFb.remove(((k)localObject).field_sessionId);
            paramq.doNotify(((k)localObject).field_sessionId);
          }
        }
      }
    }
    vwd = null;
    AppMethodBeat.o(251486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.f
 * JD-Core Version:    0.7.0.1
 */