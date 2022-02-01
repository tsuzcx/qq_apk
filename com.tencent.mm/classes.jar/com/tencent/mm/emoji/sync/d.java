package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.emoji.c.a.a;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bl;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiMd5ToInfo;", "", "md5List", "", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "", "fetchCount", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "TAG", "getCallback", "()Lkotlin/jvm/functions/Function2;", "endIndex", "getMd5List", "()Ljava/util/List;", "startIndex", "processRsp", "rsp", "Lcom/tencent/mm/protocal/protobuf/BatchEmojiDownLoadResponse;", "runNext", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a mmG;
  private final String TAG;
  private int endIndex;
  private final m<Boolean, Integer, ah> mgM;
  private final List<String> mmH;
  private int startIndex;
  
  static
  {
    AppMethodBeat.i(242574);
    mmG = new a((byte)0);
    AppMethodBeat.o(242574);
  }
  
  public d(List<String> paramList, m<? super Boolean, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(242561);
    this.mmH = paramList;
    this.mgM = paramm;
    this.TAG = "MicroMsg.EmojiMd5ToInfo";
    Log.i(this.TAG, s.X("request size: ", Integer.valueOf(this.mmH.size())));
    if (this.mmH.isEmpty())
    {
      paramList = this.mgM;
      if (paramList != null)
      {
        paramList.invoke(Boolean.TRUE, Integer.valueOf(0));
        AppMethodBeat.o(242561);
      }
    }
    else
    {
      aWg();
    }
    AppMethodBeat.o(242561);
  }
  
  private static final ah a(d paramd, b.a parama)
  {
    AppMethodBeat.i(242571);
    s.u(paramd, "this$0");
    int i = parama.errType;
    int j = parama.errCode;
    parama = (kn)parama.ott;
    Log.i(paramd.TAG, "requestNext: " + i + ", " + j);
    if ((i == 0) && (j == 0))
    {
      s.s(parama, "rsp");
      paramd.a(parama);
      paramd = ah.aiuX;
      AppMethodBeat.o(242571);
      return paramd;
    }
    parama = paramd.mgM;
    if (parama == null)
    {
      AppMethodBeat.o(242571);
      return null;
    }
    parama.invoke(Boolean.FALSE, Integer.valueOf(paramd.startIndex));
    paramd = ah.aiuX;
    AppMethodBeat.o(242571);
    return paramd;
  }
  
  private final void a(kn paramkn)
  {
    AppMethodBeat.i(242569);
    if (paramkn.YMz != null) {
      bl.jba().adju.nh((List)paramkn.YMz);
    }
    if (this.endIndex < this.mmH.size())
    {
      aWg();
      AppMethodBeat.o(242569);
      return;
    }
    paramkn = this.mgM;
    if (paramkn != null) {
      paramkn.invoke(Boolean.TRUE, Integer.valueOf(this.endIndex));
    }
    AppMethodBeat.o(242569);
  }
  
  private final void aWg()
  {
    AppMethodBeat.i(242564);
    this.startIndex = this.endIndex;
    this.endIndex = (this.startIndex + 100);
    if (this.endIndex > this.mmH.size()) {
      this.endIndex = this.mmH.size();
    }
    new a(this.mmH.subList(this.startIndex, this.endIndex), (byte)0).bFJ().g(new d..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(242564);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiMd5ToInfo$Companion;", "", "()V", "BATCH_GET_COUNT", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.d
 * JD-Core Version:    0.7.0.1
 */