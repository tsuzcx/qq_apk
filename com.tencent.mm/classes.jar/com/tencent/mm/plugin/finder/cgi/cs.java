package com.tencent.mm.plugin.finder.cgi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.spam.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoBulletPost;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "videoObjectId", "", "videoNonceId", "", "videoTimeStamp", "content", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "clientMsgId", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getVideoObjectId", "()J", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getBulletInfo", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cs
  extends cr
  implements m
{
  public static final a twH;
  private i callback;
  public d rr;
  public final long twG;
  
  static
  {
    AppMethodBeat.i(242548);
    twH = new a((byte)0);
    AppMethodBeat.o(242548);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242547);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    params = a.vwk;
    if (Util.isNullOrNil(paramString)) {}
    for (params = MMApplicationContext.getContext().getString(2131759597);; params = paramString)
    {
      a.w(paramInt2, paramInt3, params);
      params = a.vwk;
      params = paramString;
      if (Util.isNullOrNil(paramString)) {
        params = MMApplicationContext.getContext().getString(2131759596);
      }
      a.x(paramInt2, paramInt3, params);
      AppMethodBeat.o(242547);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242546);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242546);
    return i;
  }
  
  public final int getType()
  {
    return 4101;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoBulletPost$Companion;", "", "()V", "TAG", "", "globalClientMsgId", "", "getGlobalClientMsgId", "()J", "setGlobalClientMsgId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cs
 * JD-Core Version:    0.7.0.1
 */