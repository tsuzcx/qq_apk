package com.tencent.mm.plugin.finder.service;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ck;
import com.tencent.mm.plugin.finder.conv.c.a;
import com.tencent.mm.plugin.finder.conv.c.b;
import com.tencent.mm.plugin.finder.storage.af;
import com.tencent.mm.plugin.findersdk.a.ab.b;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/service/FinderSessionStatusUpdater;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "setCallback", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;)V", "doScene", "", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class g
  implements i
{
  static ab.b AdE;
  public static final g AdF;
  
  static
  {
    AppMethodBeat.i(273635);
    AdF = new g();
    AppMethodBeat.o(273635);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(273634);
    h.aGY().b(6218, (i)this);
    Log.i("Finder.FinderSessionStatusUpdater", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof ck)))
    {
      paramString = AdE;
      if (paramString != null) {
        paramString.eK((List)((ck)paramq).doV());
      }
      paramString = ((ck)paramq).doV();
      if (paramString != null)
      {
        Iterator localIterator = ((Iterable)paramString).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (bff)localIterator.next();
          Log.i("Finder.FinderSessionStatusUpdater", "sessionId:" + ((bff)localObject).sessionId + " , reject:" + ((bff)localObject).SPR + ", enableAction:" + ((bff)localObject).SPS);
          af localaf = ((PluginFinder)h.ag(PluginFinder.class)).getSessionInfoStorage();
          paramq = ((bff)localObject).sessionId;
          paramString = paramq;
          if (paramq == null) {
            paramString = "";
          }
          paramInt1 = ((bff)localObject).SPR;
          paramInt2 = ((bff)localObject).SPS;
          p.k(paramString, "sessionId");
          paramString = localaf.aEN(paramString);
          paramString.field_rejectMsg = paramInt1;
          paramString.field_actionPermission = paramInt2;
          long l = SystemClock.uptimeMillis();
          localaf.updateNotify((IAutoDBItem)paramString, false, new String[] { null });
          paramq = new c.a();
          localObject = Thread.currentThread();
          p.j(localObject, "Thread.currentThread()");
          localObject = ((Thread)localObject).getName();
          p.j(localObject, "Thread.currentThread().name");
          paramq = paramq.aAY((String)localObject).aAX("updateNotify");
          paramq.duration = (SystemClock.uptimeMillis() - l);
          paramq.aAW("FinderSessionInfoStorage.updateOpTypeAndAction").dpk().report();
          if (localaf.updateNotify((IAutoDBItem)paramString, false, new String[] { null }))
          {
            localaf.Amr.remove(paramString.field_talker + '_' + paramString.field_senderUserName);
            localaf.Ams.remove(paramString.field_sessionId);
            localaf.doNotify(paramString.field_sessionId);
          }
        }
      }
    }
    AdE = null;
    AppMethodBeat.o(273634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.g
 * JD-Core Version:    0.7.0.1
 */