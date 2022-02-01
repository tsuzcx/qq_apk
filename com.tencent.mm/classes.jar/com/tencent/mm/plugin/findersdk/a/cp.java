package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.kn;
import com.tencent.mm.autogen.mmdata.rpt.ku;
import com.tencent.mm.aw.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.util.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/MusicActionReportLogic;", "", "()V", "TAG", "", "buildCommonReportStruct", "", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/MvCardActionReportStruct;", "report22233", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "isGroupChat", "", "isMvType", "fromSourceId", "report22243", "context", "Landroid/content/Context;", "songName", "singer", "musicWebUrl", "musicDataUrl", "musicAppId", "action", "", "scene", "reportFav22233", "itemInfo", "Lcom/tencent/mm/autogen/table/BaseFavItemInfo;", "ActionType", "SceneType", "ShareActionType", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cp
{
  public static final cp HcA;
  
  static
  {
    AppMethodBeat.i(274033);
    HcA = new cp();
    AppMethodBeat.o(274033);
  }
  
  public static final void a(kn paramkn)
  {
    Object localObject2 = null;
    AppMethodBeat.i(274023);
    s.u(paramkn, "struct");
    Log.i("MicroMsg.MusicActionReportLogic", "reportMvMusicCardAction, action:" + paramkn.ioV + ", scene:" + paramkn.iqr);
    f localf = j.gnw().gng();
    Object localObject1;
    if (localf != null)
    {
      localObject1 = localf.oOx;
      if (localObject1 == null)
      {
        localObject1 = null;
        paramkn.sT((String)localObject1);
        localObject1 = localf.oOy;
        if (localObject1 != null) {
          break label203;
        }
        localObject1 = localObject2;
        label88:
        paramkn.sW((String)localObject1);
        paramkn.sU(localf.oOD);
        paramkn.sV(localf.oOB);
        paramkn.sY(localf.oOI);
        Log.i("MicroMsg.MusicActionReportLogic", "song:" + paramkn.iWS + ", singer:" + paramkn.iWT + ", appId:" + paramkn.imT);
      }
    }
    for (;;)
    {
      paramkn.bMH();
      localObject1 = c.agsX;
      c.a((a)paramkn);
      AppMethodBeat.o(274023);
      return;
      localObject1 = n.bV((String)localObject1, ",", " ");
      break;
      label203:
      localObject1 = n.bV((String)localObject1, ",", " ");
      break label88;
      Log.e("MicroMsg.MusicActionReportLogic", "buildCommonReportStruct, musicWrapper must not be null");
    }
  }
  
  public static void a(cc paramcc, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    long l = 2L;
    AppMethodBeat.i(274030);
    s.u(paramcc, "msg");
    s.u(paramString, "fromSourceId");
    ku localku = new ku();
    String str1 = paramcc.field_content;
    if (paramBoolean1)
    {
      String str2 = paramcc.field_content;
      s.s(str2, "msg.content");
      int i = n.a((CharSequence)str2, ':', 0, false, 6);
      if (i != -1)
      {
        str1 = paramcc.field_content;
        s.s(str1, "msg.content");
        str1 = str1.substring(i + 1);
        s.s(str1, "(this as java.lang.String).substring(startIndex)");
      }
    }
    for (;;)
    {
      if (str1 != null) {}
      for (paramcc = k.b.aP(str1, paramcc.field_reserved);; paramcc = null)
      {
        if (paramcc == null) {
          paramcc = null;
        }
        while (paramcc == null)
        {
          AppMethodBeat.o(274030);
          return;
          localku.tJ(paramcc.title);
          localku.tR(paramcc.description);
          localku.tK(paramcc.url);
          localku.tL(paramcc.nRx);
          localku.tP(paramcc.appId);
          paramcc = (b)paramcc.aK(b.class);
          if (paramcc == null)
          {
            paramcc = null;
          }
          else
          {
            localku.tM(paramcc.YqN);
            localku.tN(paramcc.YqO);
            localku.tO(paramcc.YqQ);
            paramcc = ah.aiuX;
          }
        }
        localku.tQ(paramString);
        localku.ioV = 3L;
        localku.iqr = 2L;
        if (paramBoolean2) {}
        for (;;)
        {
          localku.iYc = l;
          localku.bMH();
          paramcc = c.agsX;
          c.a((a)localku);
          AppMethodBeat.o(274030);
          return;
          l = 1L;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.cp
 * JD-Core Version:    0.7.0.1
 */