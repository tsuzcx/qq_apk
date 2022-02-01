package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBackgroundMusic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModBackgroundMusicResponse;", "liveId", "", "liveCookies", "", "finderUsername", "", "objectId", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBackgroundMusicInfo;", "times", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBackgroundMusic$CallBack;", "(J[BLjava/lang/String;JLcom/tencent/mm/protocal/protobuf/FinderLiveBackgroundMusicInfo;ILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBackgroundMusic$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModBackgroundMusicRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class ab
  extends n<bax>
{
  private final String TAG;
  private int mgw;
  private a yjK;
  private baw yjL;
  
  public ab(long paramLong1, byte[] paramArrayOfByte, String paramString, long paramLong2, ayk paramayk, int paramInt, a parama)
  {
    AppMethodBeat.i(280260);
    this.TAG = "Finder.CgiFinderLiveModBackgroundMusic";
    this.mgw = paramInt;
    this.yjK = parama;
    this.yjL = new baw();
    parama = this.yjL;
    ao localao = ao.xcj;
    parama.RLM = ao.dnO();
    this.yjL.klE = paramLong1;
    this.yjL.RLO = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.yjL.RLN = paramString;
    this.yjL.object_id = paramLong2;
    this.yjL.SEV = paramayk;
    paramArrayOfByte = new d.a();
    paramArrayOfByte.c((a)this.yjL);
    paramString = new bax();
    paramString.setBaseResponse(new jh());
    paramString.getBaseResponse().Tef = new eaf();
    paramArrayOfByte.d((a)paramString);
    paramArrayOfByte.TW("/cgi-bin/micromsg-bin/finderlivemodbackgroundmusic");
    paramArrayOfByte.vD(6813);
    c(paramArrayOfByte.bgN());
    paramString = this.TAG;
    paramayk = new StringBuilder("CgiFinderLiveModBackgroundMusic init ").append(this.yjL.klE).append(',').append(this.yjL.RLN).append(", times:").append(this.mgw).append(", song_id_list:");
    paramArrayOfByte = this.yjL.SEV;
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = paramArrayOfByte.SKz;
      paramArrayOfByte = paramayk.append(paramArrayOfByte).append(",liveCookies is null:");
      if (this.yjL.RLO != null) {
        break label329;
      }
    }
    label329:
    for (boolean bool = true;; bool = false)
    {
      Log.i(paramString, bool);
      AppMethodBeat.o(280260);
      return;
      paramArrayOfByte = null;
      break;
    }
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModBackgroundMusic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "times", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModBackgroundMusicResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, bax parambax);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ab
 * JD-Core Version:    0.7.0.1
 */