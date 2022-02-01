package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.protocal.protobuf.csy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.u;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/net/NetSceneGetEmotionStoreRecList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqType", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sceneEndCallBack", "Lcom/tencent/mm/network/IOnGYNetEnd;", "getSceneEndCallBack", "()Lcom/tencent/mm/network/IOnGYNetEnd;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getEmotionStoreRecListResponse", "Lcom/tencent/mm/protocal/protobuf/GetStoreRecListResponse;", "getType", "setReqbuf", "", "endRR", "Lcom/tencent/mm/network/IReqResp;", "Companion", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends p
{
  public static final a xOU;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private c rr;
  private final int vrr;
  private final m xOV;
  
  static
  {
    AppMethodBeat.i(269838);
    xOU = new a((byte)0);
    AppMethodBeat.o(269838);
  }
  
  public q()
  {
    AppMethodBeat.i(269833);
    this.TAG = "MicroMsg.NetSceneGetEmotionStoreRecList";
    this.vrr = 1;
    c.a locala = new c.a();
    locala.otE = ((a)new csx());
    locala.otF = ((a)new csy());
    locala.uri = "/cgi-bin/micromsg-bin/getstorereclist";
    locala.funcId = 6910;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.xOV = new q..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(269833);
  }
  
  private static final void a(q paramq, int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(269836);
    kotlin.g.b.s.u(paramq, "this$0");
    Log.i(paramq.TAG, "ErrType: " + paramInt2 + ", errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acIb, Long.valueOf(System.currentTimeMillis()));
    }
    for (;;)
    {
      if (paramInt3 == 0)
      {
        Log.i(paramq.TAG, kotlin.g.b.s.X("insertCache, type:", Integer.valueOf(paramq.vrr)));
        com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjy.a(paramq.vrr, paramq.dAI());
      }
      if ((paramInt2 == 0) || (paramInt2 == 4)) {
        break;
      }
      params = paramq.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)paramq);
      }
      AppMethodBeat.o(269836);
      return;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acIb, Long.valueOf(System.currentTimeMillis() - 28800000L + 600000L));
    }
    params = paramq.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)paramq);
    }
    AppMethodBeat.o(269836);
  }
  
  public final csy dAI()
  {
    AppMethodBeat.i(269846);
    if (this.rr == null)
    {
      AppMethodBeat.o(269846);
      return null;
    }
    Object localObject = this.rr;
    if (localObject != null) {
      c.c.b(((c)localObject).otC);
    }
    localObject = this.rr;
    if (localObject == null) {}
    for (localObject = null; (localObject instanceof csy); localObject = c.c.b(((c)localObject).otC))
    {
      localObject = (csy)localObject;
      AppMethodBeat.o(269846);
      return localObject;
    }
    AppMethodBeat.o(269846);
    return null;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(269844);
    this.callback = paramh;
    paramh = this.rr;
    if (paramh == null)
    {
      paramh = null;
      if (!(paramh instanceof csx)) {
        break label84;
      }
    }
    label84:
    for (paramh = (csx)paramh;; paramh = null)
    {
      if (paramh == null) {
        Log.i(this.TAG, "doScene failed, GetStoreRecListRequest null");
      }
      int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, this.xOV);
      AppMethodBeat.o(269844);
      return i;
      paramh = c.b.b(paramh.otB);
      break;
    }
  }
  
  public final int getType()
  {
    return 6910;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/net/NetSceneGetEmotionStoreRecList$Companion;", "", "()V", "MM_EMOTION_BANNER_SET_EMOJILIST", "", "MM_EMOTION_BANNER_SET_EMOTIONLIST", "MM_EMOTION_BANNER_SET_H5", "MM_EMOTION_BANNER_SET_NULL", "MM_EMOTION_BANNER_SET_PRODUCTID", "MM_EMOTION_STORE_REC_LIST_ID_EMOJI_SET", "MM_EMOTION_STORE_REC_LIST_ID_FRIEND", "MM_EMOTION_STORE_REC_LIST_ID_GOOD", "MM_EMOTION_STORE_REC_LIST_ID_HOT_REC", "MM_EMOTION_STORE_REC_LIST_ID_SPECIAL_REC", "MM_EMOTION_STORE_REC_LIST_ID_TOP_BANNER", "MM_EMOTION_STORE_REC_LIST_ID_ULIKE", "MM_EMOTION_STORE_REC_LIST_TYPE_BANNER", "MM_EMOTION_STORE_REC_LIST_TYPE_EMOJILIST", "MM_EMOTION_STORE_REC_LIST_TYPE_EMOTION", "MM_GET_STORE_REC_LIST_REQ_TYPE", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.q
 * JD-Core Version:    0.7.0.1
 */