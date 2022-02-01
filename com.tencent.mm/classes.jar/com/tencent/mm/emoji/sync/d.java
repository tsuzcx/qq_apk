package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiMd5ToInfo;", "", "md5List", "", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "", "fetchCount", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "TAG", "getCallback", "()Lkotlin/jvm/functions/Function2;", "endIndex", "getMd5List", "()Ljava/util/List;", "startIndex", "processRsp", "rsp", "Lcom/tencent/mm/protocal/protobuf/BatchEmojiDownLoadResponse;", "runNext", "Companion", "plugin-emojisdk_release"})
public final class d
{
  public static final d.a jNJ;
  private final String TAG;
  private int endIndex;
  final m<Boolean, Integer, x> jHk;
  private final List<String> jNI;
  private int startIndex;
  
  static
  {
    AppMethodBeat.i(237940);
    jNJ = new d.a((byte)0);
    AppMethodBeat.o(237940);
  }
  
  public d(List<String> paramList, m<? super Boolean, ? super Integer, x> paramm)
  {
    AppMethodBeat.i(237938);
    this.jNI = paramList;
    this.jHk = paramm;
    this.TAG = "MicroMsg.EmojiMd5ToInfo";
    Log.i(this.TAG, "request size: " + this.jNI.size());
    if (this.jNI.isEmpty())
    {
      paramList = this.jHk;
      if (paramList != null)
      {
        paramList.invoke(Boolean.TRUE, Integer.valueOf(0));
        AppMethodBeat.o(237938);
        return;
      }
      AppMethodBeat.o(237938);
      return;
    }
    aDg();
    AppMethodBeat.o(237938);
  }
  
  private final void aDg()
  {
    AppMethodBeat.i(237936);
    this.startIndex = this.endIndex;
    this.endIndex = (this.startIndex + 100);
    if (this.endIndex > this.jNI.size()) {
      this.endIndex = this.jNI.size();
    }
    new com.tencent.mm.emoji.b.a.a(this.jNI.subList(this.startIndex, this.endIndex), (byte)0).bhW().g((com.tencent.mm.vending.c.a)new b(this));
    AppMethodBeat.o(237936);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchEmojiDownLoadResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(d paramd) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.d
 * JD-Core Version:    0.7.0.1
 */