package com.tencent.mm.emoji.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.protocal.protobuf.kn;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/cgi/CgiBatchEmojiDownload;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BatchEmojiDownLoadResponse;", "customType", "", "reqBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(ILcom/tencent/mm/protobuf/ByteString;)V", "md5List", "", "", "(Ljava/util/List;)V", "reqType", "(IILjava/util/List;Lcom/tencent/mm/protobuf/ByteString;)V", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.am.b<kn>
{
  public static final a mik;
  
  static
  {
    AppMethodBeat.i(242669);
    mik = new a((byte)0);
    AppMethodBeat.o(242669);
  }
  
  private a(int paramInt1, int paramInt2, List<String> paramList, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(242660);
    km localkm = new km();
    kn localkn = new kn();
    localkm.nUz = paramInt1;
    localkm.YMx = new LinkedList((Collection)paramList);
    localkm.IHj = paramInt2;
    localkm.YMy = paramb;
    paramList = new c.a();
    paramList.otE = ((com.tencent.mm.bx.a)localkm);
    paramList.otF = ((com.tencent.mm.bx.a)localkn);
    paramList.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
    paramList.funcId = 697;
    c(paramList.bEF());
    AppMethodBeat.o(242660);
  }
  
  public a(int paramInt, com.tencent.mm.bx.b paramb)
  {
    this(2, paramInt, (List)ab.aivy, paramb);
    AppMethodBeat.i(242663);
    AppMethodBeat.o(242663);
  }
  
  public a(List<String> paramList, byte paramByte)
  {
    this(paramList);
    AppMethodBeat.i(242667);
    AppMethodBeat.o(242667);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/cgi/CgiBatchEmojiDownload$Companion;", "", "()V", "MM_BATCH_EMOJI_DOWNLOAD_REQ_BACKUP", "", "MM_BATCH_EMOJI_DOWNLOAD_REQ_BACKUP_MD5ONLY", "MM_BATCH_EMOJI_DOWNLOAD_REQ_MD5LIST", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.c.a.a
 * JD-Core Version:    0.7.0.1
 */