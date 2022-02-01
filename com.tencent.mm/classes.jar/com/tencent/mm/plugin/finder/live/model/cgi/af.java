package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.big;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingShelf;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;", "liveId", "", "objectId", "anchorUsername", "", "liveCookies", "", "scene", "", "username", "requestId", "stockId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "uxInfo", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingShelf$CallBack;", "(JJLjava/lang/String;[BILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingShelf$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
  extends o<bih>
{
  private a CJW;
  private big CJX;
  private final String TAG;
  
  private af(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, bui parambui, String paramString5, a parama)
  {
    AppMethodBeat.i(360284);
    this.TAG = "Finder.CgiFinderLiveGetShoppingShelf";
    this.CJW = parama;
    this.CJX = new big();
    this.CJX.mMJ = paramLong1;
    this.CJX.object_id = paramLong2;
    this.CJX.ZKq = paramString1;
    this.CJX.scene = paramInt1;
    this.CJX.YIZ = paramString2;
    this.CJX.YJa = b.cX(paramArrayOfByte);
    paramString1 = this.CJX;
    paramArrayOfByte = bi.ABn;
    paramString1.YIY = bi.dVu();
    this.CJX.ZRn = paramString3;
    this.CJX.mdE = paramString4;
    this.CJX.ZEQ = null;
    this.CJX.ZRo = paramInt2;
    paramString1 = (CharSequence)paramString5;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        this.CJX.ZRd = b.bsj(paramString5);
      }
      paramString1 = bi.ABn;
      paramString1 = this.CJX.YIY;
      if (parambui != null) {
        break label466;
      }
    }
    label466:
    for (paramInt1 = 0;; paramInt1 = parambui.AJo)
    {
      bi.a(paramString1, p.listOf(new r(Integer.valueOf(paramInt1), Long.valueOf(paramLong2))));
      paramString1 = new c.a();
      paramString1.otE = ((a)this.CJX);
      paramArrayOfByte = new bih();
      paramArrayOfByte.setBaseResponse(new kd());
      paramArrayOfByte.getBaseResponse().akjO = new etl();
      paramString1.otF = ((a)paramArrayOfByte);
      paramString1.uri = "/cgi-bin/micromsg-bin/finderlivegetshopshelf";
      paramString1.funcId = 4049;
      c(paramString1.bEF());
      Log.i(this.TAG, "init " + this.CJX.mMJ + ", " + this.CJX.scene + ", " + this.CJX.ZKq + ",requestId:" + this.CJX.ZRn + ",pullScene:" + this.CJX.ZRo + ",ux_info:" + this.CJX.ZRd);
      AppMethodBeat.o(360284);
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingShelf$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bih parambih);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.af
 * JD-Core Version:    0.7.0.1
 */