package com.tencent.mm.plugin.finder.upload.postlogic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.upload.postlogic.draftstage.g;
import com.tencent.mm.plugin.vlog.model.k;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderPostHelper;", "", "()V", "checkNotRetryAndSave", "", "result", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isDraftToManyTry", "", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "isToManyTry", "updateTryCount", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "feedObject", "stageInfo", "", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c GdI;
  
  static
  {
    AppMethodBeat.i(343009);
    GdI = new c();
    AppMethodBeat.o(343009);
  }
  
  public static String a(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343005);
    s.u(parame, "<this>");
    String str;
    if ((parame instanceof com.tencent.mm.plugin.finder.upload.postlogic.finderstage.d)) {
      str = "FinderPostPrepareStage";
    }
    for (;;)
    {
      parame = "stageName:" + str + ", taskId:" + parame.feq() + ", taskType:" + parame.fer();
      AppMethodBeat.o(343005);
      return parame;
      if ((parame instanceof com.tencent.mm.plugin.finder.upload.postlogic.finderstage.b)) {
        str = "FinderMediaProcessStage";
      } else if ((parame instanceof com.tencent.mm.plugin.finder.upload.postlogic.finderstage.f)) {
        str = "FinderUploadStage";
      } else if ((parame instanceof com.tencent.mm.plugin.finder.upload.postlogic.finderstage.c)) {
        str = "FinderPostCgiStage";
      } else if ((parame instanceof com.tencent.mm.plugin.finder.upload.postlogic.draftstage.f)) {
        str = "FinderDraftPrepareStage";
      } else if ((parame instanceof com.tencent.mm.plugin.finder.upload.postlogic.draftstage.d)) {
        str = "FinderDraftMediaProcessStage";
      } else if ((parame instanceof g)) {
        str = "FinderDraftUploadStage";
      } else if ((parame instanceof com.tencent.mm.plugin.finder.upload.postlogic.draftstage.e)) {
        str = "FinderDraftPostCgiStage";
      } else {
        str = parame.getClass().getSimpleName();
      }
    }
  }
  
  public static void a(k paramk, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(342998);
    s.u(paramk, "result");
    s.u(paramFinderItem, "finderObj");
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eQB().bmg()).intValue() == 5)
    {
      paramk.ygJ = false;
      paramk.success = false;
    }
    if ((!paramk.ygJ) && (!paramk.success))
    {
      paramFinderItem.setPostFailedAndNotRetry(0);
      paramk = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      d.a.v(paramFinderItem);
    }
    AppMethodBeat.o(342998);
  }
  
  public static boolean a(djj paramdjj)
  {
    AppMethodBeat.i(342988);
    s.u(paramdjj, "postinfo");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      com.tencent.mm.plugin.finder.storage.d.ePR();
    }
    int i = paramdjj.nrQ;
    paramdjj = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (i > com.tencent.mm.plugin.finder.storage.d.ePQ())
    {
      AppMethodBeat.o(342988);
      return true;
    }
    AppMethodBeat.o(342988);
    return false;
  }
  
  public static boolean b(djj paramdjj)
  {
    AppMethodBeat.i(342993);
    s.u(paramdjj, "postinfo");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      com.tencent.mm.plugin.finder.storage.d.ePT();
    }
    int i = paramdjj.nrQ;
    paramdjj = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (i > com.tencent.mm.plugin.finder.storage.d.ePS())
    {
      AppMethodBeat.o(342993);
      return true;
    }
    AppMethodBeat.o(342993);
    return false;
  }
  
  public static djj j(i parami)
  {
    AppMethodBeat.i(342983);
    s.u(parami, "draftItem");
    djj localdjj = parami.eYK().getPostInfo();
    localdjj.nrQ += 1;
    s.u(localdjj, "field_postinfo");
    parami.eYK().setPostInfo(localdjj);
    com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
    com.tencent.mm.plugin.finder.storage.logic.c.g(parami);
    AppMethodBeat.o(342983);
    return localdjj;
  }
  
  public static djj z(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(342976);
    s.u(paramFinderItem, "feedObject");
    djj localdjj = paramFinderItem.getPostInfo();
    localdjj.nrQ += 1;
    paramFinderItem.setPostInfo(localdjj);
    d.a locala = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    d.a.v(paramFinderItem);
    AppMethodBeat.o(342976);
    return localdjj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.c
 * JD-Core Version:    0.7.0.1
 */