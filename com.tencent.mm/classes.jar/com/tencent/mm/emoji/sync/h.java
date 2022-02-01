package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.cw.f;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncMd5List;", "", "customType", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "", "", "needInfoList", "", "(ILkotlin/jvm/functions/Function2;)V", "TAG", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getCustomType", "()I", "md5List", "Ljava/util/LinkedList;", "reqBuff", "Lcom/tencent/mm/protobuf/ByteString;", "processResponse", "rsp", "Lcom/tencent/mm/protocal/protobuf/BatchEmojiDownLoadResponse;", "requestNext", "plugin-emojisdk_release"})
public final class h
{
  final String TAG;
  final m<Boolean, List<String>, x> jHk;
  final int jNY;
  final LinkedList<String> jOH;
  b jOI;
  
  public h(int paramInt, m<? super Boolean, ? super List<String>, x> paramm)
  {
    AppMethodBeat.i(240552);
    this.jNY = paramInt;
    this.jHk = paramm;
    this.TAG = "MicroMsg.EmojiSyncMd5List";
    this.jOH = new LinkedList();
    aDw();
    AppMethodBeat.o(240552);
  }
  
  final void aDw()
  {
    AppMethodBeat.i(240548);
    new com.tencent.mm.emoji.b.a.a(this.jNY, this.jOI).bhW().g((com.tencent.mm.vending.c.a)new a(this));
    AppMethodBeat.o(240548);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchEmojiDownLoadResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(h paramh) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.h
 * JD-Core Version:    0.7.0.1
 */