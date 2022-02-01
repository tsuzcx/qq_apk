package com.tencent.mm.plugin.finder.live;

import com.tencent.d.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveNotifyReplaceManager;", "", "()V", "INTERVAL", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "hasLaunchCollectTimer", "", "newTipsIdList", "", "kotlin.jvm.PlatformType", "", "replaceableTipsIdList", "timeHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimeHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timeHandler$delegate", "Lkotlin/Lazy;", "doReport", "", "getTipsId", "info", "Lcom/tencent/mm/storage/MsgInfo;", "replaceNotify", "newMsgInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f Bwh;
  private static volatile boolean Bwi;
  private static final List<String> Bwj;
  private static final List<String> Bwk;
  private static final j Bwl;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(350765);
    Bwh = new f();
    TAG = "FinderLiveNotifyReplaceManager";
    Bwj = Collections.synchronizedList((List)new ArrayList());
    Bwk = Collections.synchronizedList((List)new ArrayList());
    Bwl = k.cm((a)a.Bwm);
    AppMethodBeat.o(350765);
  }
  
  public static void aA(cc paramcc)
  {
    AppMethodBeat.i(350736);
    s.u(paramcc, "newMsgInfo");
    com.tencent.threadpool.h.ahAA.bo(new f..ExternalSyntheticLambda0(paramcc));
    AppMethodBeat.o(350736);
  }
  
  private static String aS(cc paramcc)
  {
    AppMethodBeat.i(350742);
    paramcc = Util.nullAsNil((String)XmlParser.parseXml(paramcc.field_content, "msg", null).get(".msg.appmsg.extinfo.notifymsg.tipsinfo.tips_id"));
    s.s(paramcc, "nullAsNil(values[\".msg.a…fymsg.tipsinfo.tips_id\"])");
    AppMethodBeat.o(350742);
    return paramcc;
  }
  
  private static final void aT(cc paramcc)
  {
    AppMethodBeat.i(350750);
    s.u(paramcc, "$newMsgInfo");
    long l;
    String str1;
    int i;
    label112:
    label116:
    Object localObject;
    if (!Bwi)
    {
      Log.i(TAG, "[replaceNotify] start collect timer");
      Bwi = true;
      getTimeHandler().startTimer(1000L);
      l = ((b)com.tencent.mm.kernel.h.az(b.class)).getFinderLiveNotifyExposureInfoStorage().etZ();
      str1 = aS(paramcc);
      if (l == -1L) {
        break label429;
      }
      paramcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(l);
      if ((paramcc.field_msgId <= 0L) || (!s.p(paramcc.field_talker, "notifymessage"))) {
        break label225;
      }
      i = 1;
      if (i == 0) {
        break label230;
      }
      if (paramcc != null) {
        break label235;
      }
      localObject = null;
      label123:
      paramcc = (cc)localObject;
      if (localObject == null) {
        paramcc = null;
      }
      label133:
      if (((CharSequence)str1).length() <= 0) {
        break label464;
      }
      i = 1;
      label148:
      if (i == 0) {
        break label469;
      }
      localObject = str1;
      label156:
      if (localObject != null) {
        Bwj.add(localObject);
      }
      if (paramcc != null)
      {
        if (((CharSequence)paramcc).length() <= 0) {
          break label475;
        }
        i = 1;
        label190:
        if (i == 0) {
          break label480;
        }
      }
    }
    for (;;)
    {
      if (paramcc != null) {
        Bwk.add(paramcc);
      }
      AppMethodBeat.o(350750);
      return;
      Log.i(TAG, "[replaceNotify] collect timer already start");
      break;
      label225:
      i = 0;
      break label112;
      label230:
      paramcc = null;
      break label116;
      label235:
      String str2 = aS(paramcc);
      Log.i(TAG, "[replaceNotify] newTipsId = " + str1 + ",replaceTipsId = " + str2);
      if (s.p(str1, str2))
      {
        Log.i(TAG, "[replaceNotify] newTipsId = oldTipsId ,return");
        AppMethodBeat.o(350750);
        return;
      }
      i = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sm(paramcc.field_msgId);
      ((b)com.tencent.mm.kernel.h.az(b.class)).getFinderLiveNotifyExposureInfoStorage().oB(l);
      localObject = str2;
      if (i <= 0) {
        break label123;
      }
      paramcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM("notifymessage");
      localObject = str2;
      if (paramcc == null) {
        break label123;
      }
      localObject = str2;
      if (paramcc.field_unReadCount <= 0) {
        break label123;
      }
      paramcc.pG(paramcc.field_unReadCount - 1);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c(paramcc, "notifymessage");
      localObject = str2;
      break label123;
      label429:
      Log.i(TAG, "[replaceNotify] newTipsId = " + str1 + " ,no replaceable msg");
      paramcc = null;
      break label133;
      label464:
      i = 0;
      break label148;
      label469:
      localObject = null;
      break label156;
      label475:
      i = 0;
      break label190;
      label480:
      paramcc = null;
    }
  }
  
  private static MTimerHandler getTimeHandler()
  {
    AppMethodBeat.i(350731);
    MTimerHandler localMTimerHandler = (MTimerHandler)Bwl.getValue();
    AppMethodBeat.o(350731);
    return localMTimerHandler;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<MTimerHandler>
  {
    public static final a Bwm;
    
    static
    {
      AppMethodBeat.i(350791);
      Bwm = new a();
      AppMethodBeat.o(350791);
    }
    
    a()
    {
      super();
    }
    
    private static final boolean egX()
    {
      AppMethodBeat.i(350785);
      f localf = f.Bwh;
      f.egW();
      AppMethodBeat.o(350785);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.f
 * JD-Core Version:    0.7.0.1
 */