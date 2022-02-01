package com.tencent.mm.plugin.finder.service;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.dl;
import com.tencent.mm.plugin.finder.conv.a.a;
import com.tencent.mm.plugin.finder.conv.a.b;
import com.tencent.mm.plugin.finder.conv.o;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.findersdk.a.bp.b;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderSessionStatusUpdater;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;", "setCallback", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderSessionInfoService$SessionStatusCallback;)V", "doScene", "", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements com.tencent.mm.am.h
{
  public static final j Fzw;
  static bp.b Fzx;
  
  static
  {
    AppMethodBeat.i(330146);
    Fzw = new j();
    AppMethodBeat.o(330146);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(330168);
    com.tencent.mm.kernel.h.aZW().b(6218, (com.tencent.mm.am.h)this);
    Log.i("Finder.FinderSessionStatusUpdater", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof dl)))
    {
      paramString = Fzx;
      if (paramString != null) {
        paramString.onDone((List)((dl)paramp).dWv());
      }
      paramString = ((dl)paramp).dWv();
      if (paramString != null)
      {
        Iterator localIterator = ((Iterable)paramString).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (bqi)localIterator.next();
          Log.i("Finder.FinderSessionStatusUpdater", "sessionId:" + ((bqi)localObject).sessionId + " , reject:" + ((bqi)localObject).ZYl + ", enableAction:" + ((bqi)localObject).ZYm);
          ak localak = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getSessionInfoStorage();
          paramp = ((bqi)localObject).sessionId;
          paramString = paramp;
          if (paramp == null) {
            paramString = "";
          }
          paramInt1 = ((bqi)localObject).ZYl;
          paramInt2 = ((bqi)localObject).ZYm;
          kotlin.g.b.s.u(paramString, "sessionId");
          paramString = localak.aAG(paramString);
          paramString.field_rejectMsg = paramInt1;
          paramString.field_actionPermission = paramInt2;
          long l = SystemClock.uptimeMillis();
          localak.updateNotify((IAutoDBItem)paramString, false, new String[] { null });
          paramp = new a.a();
          localObject = Thread.currentThread().getName();
          kotlin.g.b.s.s(localObject, "currentThread().name");
          paramp = paramp.avh((String)localObject).avg("updateNotify");
          paramp.duration = (SystemClock.uptimeMillis() - l);
          paramp.avf("FinderSessionInfoStorage.updateOpTypeAndAction").dWL().report();
          if (localak.updateNotify((IAutoDBItem)paramString, false, new String[] { null }))
          {
            localak.FMm.remove(paramString.field_talker + '_' + paramString.field_senderUserName);
            localak.FMn.remove(paramString.field_sessionId);
            localak.doNotify(paramString.field_sessionId);
          }
        }
      }
    }
    Fzx = null;
    AppMethodBeat.o(330168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.j
 * JD-Core Version:    0.7.0.1
 */