package com.tencent.mm.plugin.finder.newxml;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.protocal.protobuf.bbr;
import com.tencent.mm.protocal.protobuf.bbu;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/newxml/FinderSnsKeyWordsJumpConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "transXmlToFinderKeyWordsJumpConfigMsg", "Lcom/tencent/mm/protocal/protobuf/FinderHotWordsJumpMsg;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements com.tencent.mm.plugin.messenger.foundation.a.s
{
  public static final a ESc;
  
  static
  {
    AppMethodBeat.i(329919);
    ESc = new a((byte)0);
    AppMethodBeat.o(329919);
  }
  
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(329930);
    kotlin.g.b.s.u(paramMap, "values");
    kotlin.g.b.s.u(parama, "addMsgInfo");
    if (kotlin.g.b.s.p(paramString, "FinderHotWordsJumpMsg"))
    {
      ((PluginFinder)h.az(PluginFinder.class)).getSnsKeyWordsStorage().ud(false);
      parama = new bbu();
      Object localObject = new LinkedList();
      Log.i("Finder.FinderSnsKeyWordsJumpConsumer", kotlin.g.b.s.X("msg values: ", paramMap));
      paramString = ".sysmsg.msg.infos";
      int i = 1;
      while (paramMap.containsKey(paramString))
      {
        Log.i("Finder.FinderSnsKeyWordsJumpConsumer", kotlin.g.b.s.X("prefix: ", paramString));
        bbv localbbv = new bbv();
        localbbv.start_time = Util.safeParseInt((String)paramMap.get(kotlin.g.b.s.X(paramString, ".start_time")));
        localbbv.end_time = Util.safeParseInt((String)paramMap.get(kotlin.g.b.s.X(paramString, ".end_time")));
        localbbv.ZMo = ((String)paramMap.get(kotlin.g.b.s.X(paramString, ".key_word")));
        bbr localbbr = new bbr();
        localbbr.ZMk = Util.safeParseInt((String)paramMap.get(kotlin.g.b.s.X(paramString, ".jump_info.jump_dest")));
        localbbr.ZMl = Util.safeParseInt((String)paramMap.get(kotlin.g.b.s.X(paramString, ".jump_info.jump_scene")));
        localbbr.ZMm = ((String)paramMap.get(kotlin.g.b.s.X(paramString, ".jump_info.jump_bypass_info")));
        localbbv.ZMp = localbbr;
        ((LinkedList)localObject).add(localbbv);
        paramString = kotlin.g.b.s.X(".sysmsg.msg.infos", Integer.valueOf(i));
        i += 1;
      }
      paramString = ah.aiuX;
      parama.ToF = ((LinkedList)localObject);
      Log.i("Finder.FinderSnsKeyWordsJumpConsumer", kotlin.g.b.s.X("transXmlToFinderKeyWordsJumpConfigMsg: ", parama));
      long l = 1L;
      paramString = (Collection)parama.ToF;
      if ((paramString == null) || (paramString.isEmpty()))
      {
        i = 1;
        if (i != 0) {
          break label548;
        }
        paramString = parama.ToF;
        if (paramString == null) {
          break label525;
        }
        paramMap = ((Iterable)paramString).iterator();
        label354:
        if (!paramMap.hasNext()) {
          break label525;
        }
        paramString = (bbv)paramMap.next();
        parama = new am();
        parama.field_localId = l;
        localObject = paramString.ZMp;
        if (localObject != null) {
          break label497;
        }
        i = -1;
        label401:
        parama.field_jumpScene = i;
        localObject = paramString.ZMp;
        if (localObject != null) {
          break label507;
        }
        i = -1;
        label421:
        parama.field_jumpDest = i;
        parama.field_startTime = paramString.start_time;
        parama.field_endTime = paramString.end_time;
        parama.field_keyWord = paramString.ZMo;
        paramString = paramString.ZMp;
        if (paramString != null) {
          break label517;
        }
      }
      label517:
      for (paramString = null;; paramString = paramString.ZMm)
      {
        parama.field_passByInfo = paramString;
        ((PluginFinder)h.az(PluginFinder.class)).getSnsKeyWordsStorage().a(parama);
        l = 1L + l;
        break label354;
        i = 0;
        break;
        label497:
        i = ((bbr)localObject).ZMl;
        break label401;
        label507:
        i = ((bbr)localObject).ZMk;
        break label421;
      }
      label525:
      ((PluginFinder)h.az(PluginFinder.class)).getSnsKeyWordsStorage().doNotify("SnsHotWord add data");
    }
    for (;;)
    {
      AppMethodBeat.o(329930);
      return null;
      label548:
      ((PluginFinder)h.az(PluginFinder.class)).getSnsKeyWordsStorage().ud(true);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/newxml/FinderSnsKeyWordsJumpConsumer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.newxml.d
 * JD-Core Version:    0.7.0.1
 */