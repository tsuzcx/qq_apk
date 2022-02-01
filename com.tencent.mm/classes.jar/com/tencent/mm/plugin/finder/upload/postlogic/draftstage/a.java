package com.tencent.mm.plugin.finder.upload.postlogic.draftstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.i.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/DraftFailedStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/FailedStage;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "errType", "", "errCode", "errMsg", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;IILjava/lang/String;)V", "TAG", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getErrType", "exec", "", "getStageType", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.finder.upload.postlogic.base.c
{
  private final i ABX;
  private final String TAG;
  private final int errCode;
  private final String errMsg;
  private final int errType;
  
  public a(i parami, String paramString)
  {
    super(j.e(parami));
    AppMethodBeat.i(343082);
    this.ABX = parami;
    this.errType = -1;
    this.errCode = -1;
    this.errMsg = paramString;
    this.TAG = "LogPost.FinderDraftFailedStage";
    AppMethodBeat.o(343082);
  }
  
  public final void cpv()
  {
    AppMethodBeat.i(343102);
    Log.w(this.TAG, "post failed, localId:" + this.ABX.field_localId + ", errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(this.errType), Integer.valueOf(this.errCode), this.errMsg });
    this.ABX.setPostFailed();
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
    com.tencent.mm.plugin.finder.storage.logic.c.g(this.ABX);
    localObject = h.Fop;
    h.c(this.ABX);
    localObject = g.GbJ;
    g.fdW().qB(this.ABX.field_localId);
    localObject = i.c.FoQ;
    i.c.tC(this.ABX.eYK().isLongVideo());
    AppMethodBeat.o(343102);
  }
  
  public final int fer()
  {
    return 100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.draftstage.a
 * JD-Core Version:    0.7.0.1
 */