package com.tencent.mm.plugin.finder.newxml;

import com.tencent.d.a.a.a.d.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/newxml/FinderLiveNotifyCloseConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "MANUAL_REQUEST_LIVE_DELAY", "", "getMANUAL_REQUEST_LIVE_DELAY", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "nextTimeStamp", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "requestLiveNotify", "", "funcMsgId", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.s
{
  private final int ERX = 1;
  private volatile int ERY;
  private final String TAG = "FinderLiveNotifyRevokeConsumer";
  
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(329950);
    kotlin.g.b.s.u(paramMap, "values");
    parama = (String)paramMap.get(".sysmsg.finderliveclosenotifymsg.revoke_id");
    paramString = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage().axL(parama);
    paramMap = (String)paramMap.get(".sysmsg.finderliveclosenotifymsg.functionmsgid");
    Log.i(this.TAG, "get close live notify, revokeID = " + parama + " rowId = " + paramString.systemRowid + " exposure = " + paramString.field_exposureStatus + " , funcMsgId =  " + paramMap + " ,msdId = " + paramString.field_msgId);
    int i;
    int j;
    if (paramString.systemRowid != -1L)
    {
      parama = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(paramString.field_msgId);
      if (parama.field_msgId <= 0L)
      {
        Log.i(this.TAG, kotlin.g.b.s.X("msg info not exist, id = ", Long.valueOf(paramString.field_msgId)));
        AppMethodBeat.o(329950);
        return null;
      }
      paramString = parama.field_content;
      if (paramString == null)
      {
        i = 0;
        paramString = parama.field_content;
        if (paramString != null) {
          break label280;
        }
      }
      label280:
      for (j = 0;; j = kotlin.n.n.a((CharSequence)paramString, "</status>", 0, false, 6))
      {
        if ((i != -1) && (j != -1)) {
          break label298;
        }
        e.a.a((e)com.tencent.mm.plugin.findersdk.b.HbT, this.TAG, false, null, false, (kotlin.g.a.a)new a(parama), 28);
        AppMethodBeat.o(329950);
        return null;
        i = kotlin.n.n.a((CharSequence)paramString, "<status>", 0, false, 6);
        break;
      }
      label298:
      paramString = parama.field_content;
      if (paramString != null) {
        break label443;
      }
      paramString = null;
      parama.setContent(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(parama.field_msgId, parama);
      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage().V(parama.field_msgId, 0);
      if (cn.getSyncServerTimeSecond() <= this.ERY) {
        break label479;
      }
      paramString = paramMap;
      if (paramMap == null) {
        paramString = "";
      }
      Log.i(this.TAG, kotlin.g.b.s.X("[requestLiveNotify] funcMsgId:", paramString));
      if (((CharSequence)paramString).length() <= 0) {
        break label473;
      }
      i = 1;
      label405:
      if (i != 0)
      {
        this.ERY = (cn.getSyncServerTimeSecond() + this.ERX);
        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).requestFinderLiveNotifyOnLiveClose(paramString);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(329950);
      return null;
      label443:
      CharSequence localCharSequence = (CharSequence)"0";
      paramString = kotlin.n.n.a((CharSequence)paramString, i + 8, j, localCharSequence).toString();
      break;
      label473:
      i = 0;
      break label405;
      label479:
      Log.i(this.TAG, "funcMsgId：" + paramMap + " but Frequency limit");
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<String>
  {
    a(cc paramcc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.newxml.a
 * JD-Core Version:    0.7.0.1
 */