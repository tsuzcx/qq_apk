package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSearchMusicListResponse;", "liveId", "", "liveCookies", "", "finderUsername", "", "objectId", "query", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList$CallBack;", "(J[BLjava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSearchMusicListRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "printDebugMsg", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class as
  extends o<bmm>
{
  private a CKy;
  private bml CKz;
  private final String TAG;
  
  public as(long paramLong1, byte[] paramArrayOfByte, String paramString1, long paramLong2, String paramString2, com.tencent.mm.bx.b paramb, a parama)
  {
    AppMethodBeat.i(360177);
    this.TAG = "Finder.CgiFinderLiveSearchMusicList";
    this.CKy = parama;
    this.CKz = new bml();
    parama = this.CKz;
    bi localbi = bi.ABn;
    parama.YIY = bi.dVu();
    this.CKz.mMJ = paramLong1;
    this.CKz.YJa = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.CKz.YIZ = paramString1;
    this.CKz.object_id = paramLong2;
    this.CKz.query = paramString2;
    this.CKz.ZEQ = paramb;
    paramArrayOfByte = new c.a();
    paramArrayOfByte.otE = ((com.tencent.mm.bx.a)this.CKz);
    paramString1 = new bmm();
    paramString1.setBaseResponse(new kd());
    paramString1.getBaseResponse().akjO = new etl();
    paramArrayOfByte.otF = ((com.tencent.mm.bx.a)paramString1);
    paramArrayOfByte.uri = "/cgi-bin/micromsg-bin/finderlivesearchmusiclist";
    paramArrayOfByte.funcId = 6291;
    c(paramArrayOfByte.bEF());
    paramArrayOfByte = this.TAG;
    paramString1 = new StringBuilder("CgiFinderLiveSearchMusicList init ").append(this.CKz.mMJ).append(',').append(this.CKz.YIZ).append(",query:").append(this.CKz.query).append(",liveCookies is null:");
    if (this.CKz.YJa == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(paramArrayOfByte, bool);
      AppMethodBeat.o(360177);
      return;
    }
  }
  
  private final void a(bmm parambmm)
  {
    AppMethodBeat.i(360190);
    Object localObject = aw.Gjk;
    if (aw.bgV())
    {
      localObject = parambmm.ZPz;
      parambmm = new StringBuilder("搜索内容:" + this.CKz.query + '\n');
      s.s(localObject, "list");
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        bkh localbkh = (bkh)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new StringBuilder().append(localbkh.ZTw).append('(').append(localbkh.ZTx).append("),url is empty:");
        CharSequence localCharSequence = (CharSequence)localbkh.ZTB;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (boolean bool = true;; bool = false)
        {
          parambmm.append(bool + ", playable:" + localbkh.playable + '\n');
          break;
        }
      }
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject = this.TAG;
      parambmm = parambmm.toString();
      s.s(parambmm, "sb.toString()");
      com.tencent.mm.plugin.finder.live.utils.a.hQ((String)localObject, parambmm);
    }
    AppMethodBeat.o(360190);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSearchMusicList$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSearchMusicListResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt, bmm parambmm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.as
 * JD-Core Version:    0.7.0.1
 */