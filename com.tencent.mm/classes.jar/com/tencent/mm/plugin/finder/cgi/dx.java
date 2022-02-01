package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bkm;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneGetLiveNoticeQrCode;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "anchorUserName", "", "noticeId", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getQRCodeBitmap", "Landroid/graphics/Bitmap;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeQRCodeResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dx
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ADH;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  static
  {
    AppMethodBeat.i(336777);
    ADH = new a((byte)0);
    AppMethodBeat.o(336777);
  }
  
  public dx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(336771);
    Object localObject1 = new c.a();
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/finderlivenoticeqrcode";
    ((c.a)localObject1).funcId = getType();
    bkm localbkm = new bkm();
    localbkm.ZKq = paramString1;
    localbkm.YSS = paramString2;
    Object localObject2 = bi.ABn;
    localbkm.YIY = bi.dVu();
    localObject2 = new bkn();
    ((c.a)localObject1).otE = ((a)localbkm);
    ((c.a)localObject1).otF = ((a)localObject2);
    localObject1 = ((c.a)localObject1).bEF();
    kotlin.g.b.s.s(localObject1, "builder.buildInstance()");
    this.rr = ((c)localObject1);
    Log.i("Finder.NetSceneGetLiveNoticeQrCode", "NetSceneGetLiveNoticeQrCode init userName:" + paramString1 + ", noticeId:" + paramString2 + ' ');
    AppMethodBeat.o(336771);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336794);
    Log.i("Finder.NetSceneGetLiveNoticeQrCode", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336794);
  }
  
  public final bkn dWI()
  {
    AppMethodBeat.i(336798);
    c localc = this.rr;
    Object localObject = localc;
    if (localc == null)
    {
      kotlin.g.b.s.bIx("rr");
      localObject = null;
    }
    localObject = c.c.b(((c)localObject).otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveNoticeQRCodeResponse");
      AppMethodBeat.o(336798);
      throw ((Throwable)localObject);
    }
    localObject = (bkn)localObject;
    AppMethodBeat.o(336798);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336784);
    this.callback = paramh;
    c localc = this.rr;
    paramh = localc;
    if (localc == null)
    {
      kotlin.g.b.s.bIx("rr");
      paramh = null;
    }
    int i = dispatch(paramg, (com.tencent.mm.network.s)paramh, (m)this);
    AppMethodBeat.o(336784);
    return i;
  }
  
  public final int getType()
  {
    return 4214;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneGetLiveNoticeQrCode$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dx
 * JD-Core Version:    0.7.0.1
 */