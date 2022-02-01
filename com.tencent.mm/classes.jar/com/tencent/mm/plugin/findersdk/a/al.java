package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.bb.f;
import com.tencent.mm.f.b.a.ig;
import com.tencent.mm.f.b.a.in;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.util.c;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/api/MusicActionReportLogic;", "", "()V", "TAG", "", "buildCommonReportStruct", "", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/MvCardActionReportStruct;", "report22233", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "isGroupChat", "", "isMvType", "fromSourceId", "report22243", "context", "Landroid/content/Context;", "songName", "singer", "musicWebUrl", "musicDataUrl", "musicAppId", "action", "", "scene", "reportFav22233", "itemInfo", "Lcom/tencent/mm/autogen/table/BaseFavItemInfo;", "ActionType", "SceneType", "ShareActionType", "finder-sdk_release"})
public final class al
{
  public static final al Bvs;
  
  static
  {
    AppMethodBeat.i(208688);
    Bvs = new al();
    AppMethodBeat.o(208688);
  }
  
  public static final void a(ig paramig)
  {
    Object localObject2 = null;
    AppMethodBeat.i(208686);
    p.k(paramig, "struct");
    Log.i("MicroMsg.MusicActionReportLogic", "reportMvMusicCardAction, action:" + paramig.ahC() + ", scene:" + paramig.alF());
    Object localObject1 = k.fet();
    p.j(localObject1, "MusicPlayerManager.Instance()");
    f localf = ((k)localObject1).fed();
    if (localf != null)
    {
      localObject1 = localf.lVv;
      if (localObject1 != null)
      {
        localObject1 = n.l((String)localObject1, ",", " ", false);
        paramig.xQ((String)localObject1);
        String str = localf.lVw;
        localObject1 = localObject2;
        if (str != null) {
          localObject1 = n.l(str, ",", " ", false);
        }
        paramig.xU((String)localObject1);
        paramig.xS(localf.lVB);
        paramig.xT(localf.lVz);
        paramig.xW(localf.lVG);
        Log.i("MicroMsg.MusicActionReportLogic", "song:" + paramig.alP() + ", singer:" + paramig.alQ() + ", appId:" + paramig.getAppId());
      }
    }
    for (;;)
    {
      paramig.bpa();
      localObject1 = c.Yyz;
      c.a((a)paramig);
      AppMethodBeat.o(208686);
      return;
      localObject1 = null;
      break;
      Log.e("MicroMsg.MusicActionReportLogic", "buildCommonReportStruct, musicWrapper must not be null");
    }
  }
  
  public static void a(ca paramca, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    long l = 2L;
    AppMethodBeat.i(208687);
    p.k(paramca, "msg");
    p.k(paramString, "fromSourceId");
    in localin = new in();
    String str1 = paramca.getContent();
    if (paramBoolean1)
    {
      String str2 = paramca.getContent();
      p.j(str2, "msg.content");
      int i = n.a((CharSequence)str2, ':', 0, false, 6);
      if (i != -1)
      {
        str1 = paramca.getContent();
        p.j(str1, "msg.content");
        if (str1 == null)
        {
          paramca = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(208687);
          throw paramca;
        }
        str1 = str1.substring(i + 1);
        p.j(str1, "(this as java.lang.String).substring(startIndex)");
      }
    }
    for (;;)
    {
      if (str1 != null) {}
      for (paramca = k.b.aG(str1, paramca.apL());; paramca = null)
      {
        if (paramca != null)
        {
          localin.zn(paramca.title);
          localin.zw(paramca.description);
          localin.zp(paramca.url);
          localin.zq(paramca.lms);
          localin.zu(paramca.appId);
          paramca = (b)paramca.ar(b.class);
          if (paramca == null) {
            break label257;
          }
          localin.zr(paramca.Ruu);
          localin.zs(paramca.Ruv);
          localin.zt(paramca.Rux);
        }
        label257:
        for (paramca = x.aazN; paramca == null; paramca = null)
        {
          AppMethodBeat.o(208687);
          return;
        }
        localin.zv(paramString);
        localin.tJ(3L);
        localin.tK(2L);
        if (paramBoolean2) {}
        for (;;)
        {
          localin.tL(l);
          localin.bpa();
          paramca = c.Yyz;
          c.a((a)localin);
          AppMethodBeat.o(208687);
          return;
          l = 1L;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.al
 * JD-Core Version:    0.7.0.1
 */