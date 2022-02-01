package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.finder.cgi.dg;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "mvClipListener", "getMvClipListener", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "postClipFailed", "", "getPostClipFailed", "()Z", "setPostClipFailed", "(Z)V", "postingClipSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost;", "Lkotlin/collections/HashSet;", "getPostingClipSet", "()Ljava/util/HashSet;", "checkIfNeedMarkDelete", "", "preUrl", "", "clearPostFile", "dealDumpCgi", "feedObject", "postScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost;", "dealLongVideoCgi", "doMvPostScene", "doMvPostSceneContinue", "doPostScene", "doPostSceneContinue", "fillReportProcessCostTime", "finderItem", "succ", "costTime", "", "fillReportTotalCostTime", "svrId", "fillReportUploadCostTime", "isToManyTry", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "notifyError", "errType", "", "errCode", "errMsg", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "postFinderFeed", "postInfo", "postMvFeed", "saveToDb", "start", "tryPost", "uniqueId", "updateTryCount", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public class h
  extends j
  implements com.tencent.mm.am.h
{
  public static final a GbZ;
  private static boolean Gca;
  
  static
  {
    AppMethodBeat.i(167777);
    GbZ = new a((byte)0);
    AppMethodBeat.o(167777);
  }
  
  public String aUE()
  {
    AppMethodBeat.i(167772);
    AppMethodBeat.o(167772);
    throw null;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(167771);
    com.tencent.mm.kernel.h.baD().mCm.b(3585, (com.tencent.mm.am.h)this);
    if (paramp == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPost");
      AppMethodBeat.o(167771);
      throw paramString;
    }
    Log.i("Finder.LogPost.FinderPostTask", "errType %d, errCode %d, errMsg %s, clientId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, ((dg)paramp).clientId });
    AppMethodBeat.o(167771);
    throw null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/FinderPostTask$Companion;", "", "()V", "TAG", "", "debugDeleteFileWhenMoveFile", "", "getDebugDeleteFileWhenMoveFile", "()Z", "setDebugDeleteFileWhenMoveFile", "(Z)V", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.h
 * JD-Core Version:    0.7.0.1
 */