package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bjo;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBackgroundMusic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModBackgroundMusicResponse;", "liveId", "", "liveCookies", "", "finderUsername", "", "objectId", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBackgroundMusicInfo;", "times", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBackgroundMusic$CallBack;", "(J[BLjava/lang/String;JLcom/tencent/mm/protocal/protobuf/FinderLiveBackgroundMusicInfo;ILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBackgroundMusic$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModBackgroundMusicRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
  extends o<bjp>
{
  private a CKb;
  private bjo CKc;
  private final String TAG;
  private int oZt;
  
  public ai(long paramLong1, byte[] paramArrayOfByte, String paramString, long paramLong2, bfk parambfk, int paramInt, a parama)
  {
    AppMethodBeat.i(360291);
    this.TAG = "Finder.CgiFinderLiveModBackgroundMusic";
    this.oZt = paramInt;
    this.CKb = parama;
    this.CKc = new bjo();
    parama = this.CKc;
    bi localbi = bi.ABn;
    parama.YIY = bi.dVu();
    this.CKc.mMJ = paramLong1;
    this.CKc.YJa = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.CKc.YIZ = paramString;
    this.CKc.object_id = paramLong2;
    this.CKc.ZGx = parambfk;
    paramArrayOfByte = new c.a();
    paramArrayOfByte.otE = ((a)this.CKc);
    paramString = new bjp();
    paramString.setBaseResponse(new kd());
    paramString.getBaseResponse().akjO = new etl();
    paramArrayOfByte.otF = ((a)paramString);
    paramArrayOfByte.uri = "/cgi-bin/micromsg-bin/finderlivemodbackgroundmusic";
    paramArrayOfByte.funcId = 6813;
    c(paramArrayOfByte.bEF());
    paramString = this.TAG;
    parambfk = new StringBuilder("CgiFinderLiveModBackgroundMusic init ").append(this.CKc.mMJ).append(',').append(this.CKc.YIZ).append(", times:").append(this.oZt).append(", song_id_list:");
    paramArrayOfByte = this.CKc.ZGx;
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = null;
      paramArrayOfByte = parambfk.append(paramArrayOfByte).append(",liveCookies is null:");
      if (this.CKc.YJa != null) {
        break label329;
      }
    }
    label329:
    for (boolean bool = true;; bool = false)
    {
      Log.i(paramString, bool);
      AppMethodBeat.o(360291);
      return;
      paramArrayOfByte = paramArrayOfByte.ZPo;
      break;
    }
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBackgroundMusic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "times", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModBackgroundMusicResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, bjp parambjp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ai
 * JD-Core Version:    0.7.0.1
 */