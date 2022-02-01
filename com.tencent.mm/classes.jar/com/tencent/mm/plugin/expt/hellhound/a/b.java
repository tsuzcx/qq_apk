package com.tencent.mm.plugin.expt.hellhound.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.hellhound.ext.session.e.l;
import com.tencent.mm.plugin.expt.hellhound.ext.session.e.l.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/model/NetSceneGetHell;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "scene", "", "rversion", "", "buildTag", "(ILjava/lang/String;Ljava/lang/String;)V", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "fillLocalIdList", "", "localIdInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ConfigId;", "getType", "noteGetHellTime", "currSvrTime", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateConfigTime", "currSvrSecond", "intervalSecond", "updateHell", "resp", "Lcom/tencent/mm/protocal/protobuf/GetHellResponse;", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends p
  implements m
{
  public static final a zLK;
  
  static
  {
    AppMethodBeat.i(299905);
    zLK = new a((byte)0);
    AppMethodBeat.o(299905);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    throw null;
  }
  
  public final int getType()
  {
    return 1021;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(299932);
    Log.i("HABBYGE-MALI.NetSceneGetHell", "onGYNetEnd, errType[" + paramInt2 + "] erroCode[" + paramInt3 + "] errMsg[" + paramString + ']');
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(299932);
        throw paramString;
      }
      if (c.c.b(((c)params).otC) == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetHellResponse");
        AppMethodBeat.o(299932);
        throw paramString;
      }
      AppMethodBeat.o(299932);
      throw null;
    }
    paramString = l.zKT;
    l.a.jX(120L);
    Log.w("HABBYGE-MALI.NetSceneGetHell", "onGYNetEnd, get hell error");
    paramInt1 = (int)Util.nowSecond();
    paramInt2 = (int)Util.nowSecond();
    if (paramInt2 > paramInt1)
    {
      Log.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime yes");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adfT, Integer.valueOf(paramInt2));
    }
    for (;;)
    {
      AppMethodBeat.o(299932);
      throw null;
      Log.i("HABBYGE-MALI.NetSceneGetHell", "updateConfigTime no");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adfT, Integer.valueOf(paramInt1));
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/model/NetSceneGetHell$Companion;", "", "()V", "TAG", "", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b
 * JD-Core Version:    0.7.0.1
 */