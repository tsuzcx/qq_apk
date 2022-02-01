package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetContact;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetContactResponse;", "liveId", "", "objectId", "finderUserName", "", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetContact$CallBack;", "(JJLjava/lang/String;ILcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetContact$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetContactRequest;", "resp", "getResp", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends c<bhj>
{
  private bhi Cvs;
  private bhj Cvt;
  private a Cvu;
  private final String TAG;
  
  public l(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(351171);
    this.TAG = "Finder.CgiFinderLiveGetContact";
    this.Cvs = new bhi();
    this.Cvu = null;
    this.Cvs.liveId = paramLong1;
    this.Cvs.hKN = paramLong2;
    this.Cvs.username = paramString;
    paramString = this.Cvs;
    Object localObject = bi.ABn;
    paramString.ZEc = bi.dVu();
    this.Cvs.scene = 0;
    paramString = new c.a();
    paramString.otE = ((a)this.Cvs);
    localObject = new bhj();
    ((bhj)localObject).setBaseResponse(new kd());
    ((bhj)localObject).getBaseResponse().akjO = new etl();
    paramString.otF = ((a)localObject);
    paramString.uri = "/cgi-bin/micromsg-bin/finderlivegetcontact";
    paramString.funcId = 6678;
    c(paramString.bEF());
    Log.i(this.TAG, "init " + this.Cvs.liveId + ',' + this.Cvs.username + ',' + this.Cvs.scene);
    AppMethodBeat.o(351171);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetContact$CallBack;", "", "onFinish", "", "success", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.l
 * JD-Core Version:    0.7.0.1
 */