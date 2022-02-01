package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSearchMusicListResponse;", "liveId", "", "liveCookies", "", "finderUsername", "", "objectId", "query", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList$CallBack;", "(J[BLjava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSearchMusicListRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "printDebugMsg", "CallBack", "plugin-finder_release"})
public final class aj
  extends n<bcl>
{
  private final String TAG;
  private a ykd;
  private bck yke;
  
  public aj(long paramLong1, byte[] paramArrayOfByte, String paramString1, long paramLong2, String paramString2, com.tencent.mm.cd.b paramb, a parama)
  {
    AppMethodBeat.i(269133);
    this.TAG = "Finder.CgiFinderLiveSearchMusicList";
    this.ykd = parama;
    this.yke = new bck();
    parama = this.yke;
    ao localao = ao.xcj;
    parama.RLM = ao.dnO();
    this.yke.klE = paramLong1;
    this.yke.RLO = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.yke.RLN = paramString1;
    this.yke.object_id = paramLong2;
    this.yke.query = paramString2;
    this.yke.SDI = paramb;
    paramArrayOfByte = new d.a();
    paramArrayOfByte.c((com.tencent.mm.cd.a)this.yke);
    paramString1 = new bcl();
    paramString1.setBaseResponse(new jh());
    paramString1.getBaseResponse().Tef = new eaf();
    paramArrayOfByte.d((com.tencent.mm.cd.a)paramString1);
    paramArrayOfByte.TW("/cgi-bin/micromsg-bin/finderlivesearchmusiclist");
    paramArrayOfByte.vD(6291);
    c(paramArrayOfByte.bgN());
    paramArrayOfByte = this.TAG;
    paramString1 = new StringBuilder("CgiFinderLiveSearchMusicList init ").append(this.yke.klE).append(',').append(this.yke.RLN).append(",query:").append(this.yke.query).append(",liveCookies is null:");
    if (this.yke.RLO == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(paramArrayOfByte, bool);
      AppMethodBeat.o(269133);
      return;
    }
  }
  
  private final void a(bcl parambcl)
  {
    AppMethodBeat.i(269132);
    Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (com.tencent.mm.plugin.finder.utils.aj.eej())
    {
      localObject = parambcl.SKG;
      parambcl = new StringBuilder("搜索内容:" + this.yke.query + '\n');
      p.j(localObject, "list");
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        bbg localbbg = (bbg)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new StringBuilder().append(localbbg.SMU).append('(').append(localbbg.SMV).append("),url is empty:");
        CharSequence localCharSequence = (CharSequence)localbbg.SMZ;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (boolean bool = true;; bool = false)
        {
          parambcl.append(bool + ", playable:" + localbbg.playable + '\n');
          break;
        }
      }
      localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      localObject = this.TAG;
      parambcl = parambcl.toString();
      p.j(parambcl, "sb.toString()");
      com.tencent.mm.plugin.finder.live.utils.a.ha((String)localObject, parambcl);
    }
    AppMethodBeat.o(269132);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSearchMusicListResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt, bcl parambcl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.aj
 * JD-Core Version:    0.7.0.1
 */