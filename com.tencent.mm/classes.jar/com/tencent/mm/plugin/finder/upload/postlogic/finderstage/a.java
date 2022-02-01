package com.tencent.mm.plugin.finder.upload.postlogic.finderstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.ah.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.upload.postlogic.base.c;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/FinderFailedStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/FailedStage;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "errType", "", "errCode", "errMsg", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;IILjava/lang/String;)V", "TAG", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getErrType", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "exec", "", "getStageType", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c
{
  private final FinderItem Ged;
  private final String TAG;
  private final int errCode;
  private final String errMsg;
  private final int errType;
  
  public a(FinderItem paramFinderItem, String paramString)
  {
    super(String.valueOf(paramFinderItem.getLocalId()));
    AppMethodBeat.i(343157);
    this.Ged = paramFinderItem;
    this.errType = -1;
    this.errCode = -1;
    this.errMsg = paramString;
    this.TAG = "LogPost.FinderFailedStage";
    AppMethodBeat.o(343157);
  }
  
  public final void cpv()
  {
    AppMethodBeat.i(343166);
    Log.w(this.TAG, "post failed, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(this.errType), Integer.valueOf(this.errCode), this.errMsg });
    this.Ged.setPostFailed();
    Object localObject = this.Ged.field_reportObject;
    if (localObject != null) {
      ((FinderFeedReportObject)localObject).cgiErrorType = this.errType;
    }
    localObject = this.Ged.field_reportObject;
    if (localObject != null) {
      ((FinderFeedReportObject)localObject).cgiErrorCode = this.errCode;
    }
    localObject = d.FND;
    d.a.v(this.Ged);
    localObject = ah.d.Ftw;
    ah.d.tU(this.Ged.isLongVideo());
    localObject = g.GbJ;
    g.fdW().qy(this.Ged.getLocalId());
    localObject = g.GbJ;
    g.fdW().qz(this.Ged.getLocalId());
    localObject = ah.d.Ftw;
    ah.d.tC(this.Ged.isLongVideo());
    AppMethodBeat.o(343166);
  }
  
  public final int fer()
  {
    return 100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.finderstage.a
 * JD-Core Version:    0.7.0.1
 */