package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.emoji.c.a.a;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bl;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncMd5List;", "", "customType", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "", "", "needInfoList", "", "(ILkotlin/jvm/functions/Function2;)V", "TAG", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getCustomType", "()I", "md5List", "Ljava/util/LinkedList;", "reqBuff", "Lcom/tencent/mm/protobuf/ByteString;", "processResponse", "rsp", "Lcom/tencent/mm/protocal/protobuf/BatchEmojiDownLoadResponse;", "requestNext", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private final String TAG;
  private final m<Boolean, List<String>, ah> mgM;
  private final int mmT;
  private final LinkedList<String> mnB;
  private b mnC;
  
  public h(int paramInt, m<? super Boolean, ? super List<String>, ah> paramm)
  {
    AppMethodBeat.i(242550);
    this.mmT = paramInt;
    this.mgM = paramm;
    this.TAG = "MicroMsg.EmojiSyncMd5List";
    this.mnB = new LinkedList();
    aWx();
    AppMethodBeat.o(242550);
  }
  
  private static final ah a(h paramh, b.a parama)
  {
    Boolean localBoolean = null;
    AppMethodBeat.i(242560);
    s.u(paramh, "this$0");
    int i = parama.errType;
    int j = parama.errCode;
    kn localkn = (kn)parama.ott;
    String str = paramh.TAG;
    StringBuilder localStringBuilder = new StringBuilder("requestNext: ").append(i).append(", ").append(j).append(", end:");
    if (localkn == null)
    {
      parama = null;
      localStringBuilder = localStringBuilder.append(parama).append(", size:");
      if (localkn != null) {
        break label214;
      }
      parama = null;
      label95:
      localStringBuilder = localStringBuilder.append(parama).append(", first:");
      if (localkn != null) {
        break label240;
      }
      parama = localBoolean;
      label116:
      Log.i(str, parama);
      if ((i != 0) || (j != 0)) {
        break label320;
      }
      paramh.mnC = localkn.YMy;
      s.s(localkn, "rsp");
      if (localkn.YKG != null) {
        paramh.mnB.addAll((Collection)localkn.YKG);
      }
      if (localkn.oOu == 1) {
        break label270;
      }
      paramh.aWx();
    }
    for (;;)
    {
      paramh = ah.aiuX;
      AppMethodBeat.o(242560);
      return paramh;
      parama = Integer.valueOf(localkn.oOu);
      break;
      label214:
      parama = localkn.YKG;
      if (parama == null)
      {
        parama = null;
        break label95;
      }
      parama = Integer.valueOf(parama.size());
      break label95;
      label240:
      LinkedList localLinkedList = localkn.YKG;
      parama = localBoolean;
      if (localLinkedList == null) {
        break label116;
      }
      parama = (String)p.oL((List)localLinkedList);
      break label116;
      label270:
      parama = bl.jba().adju.X(paramh.mmT, (List)paramh.mnB);
      paramh = paramh.mgM;
      localBoolean = Boolean.TRUE;
      s.s(parama, "result");
      paramh.invoke(localBoolean, parama);
      continue;
      label320:
      paramh.mgM.invoke(Boolean.FALSE, (List)ab.aivy);
    }
  }
  
  private final void aWx()
  {
    AppMethodBeat.i(242552);
    new a(this.mmT, this.mnC).bFJ().g(new h..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(242552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.h
 * JD-Core Version:    0.7.0.1
 */