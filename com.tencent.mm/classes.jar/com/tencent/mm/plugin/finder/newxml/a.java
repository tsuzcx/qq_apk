package com.tencent.mm.plugin.finder.newxml;

import com.tencent.c.a.a.a.b;
import com.tencent.c.a.a.a.d.a.e;
import com.tencent.c.a.a.a.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/newxml/FinderLiveNotifyCloseConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "MANUAL_REQUEST_LIVE_DELAY", "", "getMANUAL_REQUEST_LIVE_DELAY", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "nextTimeStamp", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "requestLiveNotify", "", "funcMsgId", "plugin-finder_release"})
public final class a
  implements s
{
  private final String TAG = "FinderLiveNotifyRevokeConsumer";
  private final int zJZ = 1;
  private volatile int zKa;
  
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(241314);
    p.k(paramMap, "values");
    parama = (String)paramMap.get(".sysmsg.finderliveclosenotifymsg.revoke_id");
    paramString = ((b)h.ag(b.class)).getFinderLiveNotifyExposureInfoStorage().aCK(parama);
    paramMap = (String)paramMap.get(".sysmsg.finderliveclosenotifymsg.functionmsgid");
    Log.i(this.TAG, "get close live notify, revokeID = " + parama + " rowId = " + paramString.systemRowid + " exposure = " + paramString.field_exposureStatus + " , funcMsgId =  " + paramMap + " ,msdId = " + paramString.field_msgId);
    int i;
    if (paramString.systemRowid != -1L)
    {
      parama = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
      p.j(parama, "MMKernel.service(IMessengerStorage::class.java)");
      parama = ((com.tencent.mm.plugin.messenger.foundation.a.n)parama).eSe().Oq(paramString.field_msgId);
      p.j(parama, "msg");
      if (parama.apG() <= 0L)
      {
        Log.i(this.TAG, "msg info not exist, id = " + paramString.field_msgId);
        AppMethodBeat.o(241314);
        return null;
      }
      paramString = parama.getContent();
      if (paramString != null)
      {
        i = kotlin.n.n.a((CharSequence)paramString, "<status>", 0, false, 6);
        paramString = parama.getContent();
        if (paramString == null) {
          break label302;
        }
      }
      CharSequence localCharSequence;
      label302:
      for (int j = kotlin.n.n.a((CharSequence)paramString, "</status>", 0, false, 6);; j = 0)
      {
        paramString = parama.getContent();
        if (paramString == null) {
          break label473;
        }
        localCharSequence = (CharSequence)"0";
        if (paramString != null) {
          break label308;
        }
        paramString = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(241314);
        throw paramString;
        i = 0;
        break;
      }
      label308:
      paramString = kotlin.n.n.a((CharSequence)paramString, i + 8, j, localCharSequence).toString();
      parama.setContent(paramString);
      paramString = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
      p.j(paramString, "MMKernel.service(IMessengerStorage::class.java)");
      ((com.tencent.mm.plugin.messenger.foundation.a.n)paramString).eSe().a(parama.apG(), parama);
      ((b)h.ag(b.class)).getFinderLiveNotifyExposureInfoStorage().K(parama.apG(), 0);
      if (cm.bfF() <= this.zKa) {
        break label484;
      }
      paramString = paramMap;
      if (paramMap == null) {
        paramString = "";
      }
      Log.i(this.TAG, "[requestLiveNotify] funcMsgId:".concat(String.valueOf(paramString)));
      if (((CharSequence)paramString).length() <= 0) {
        break label478;
      }
      i = 1;
      label435:
      if (i != 0)
      {
        this.zKa = (cm.bfF() + this.zJZ);
        ((b)h.ag(b.class)).requestFinderLiveNotifyOnLiveClose(paramString);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(241314);
      return null;
      label473:
      paramString = null;
      break;
      label478:
      i = 0;
      break label435;
      label484:
      Log.i(this.TAG, "funcMsgId：" + paramMap + " but Frequency limit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.newxml.a
 * JD-Core Version:    0.7.0.1
 */