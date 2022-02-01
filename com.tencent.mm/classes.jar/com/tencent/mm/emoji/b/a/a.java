package com.tencent.mm.emoji.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.jq;
import com.tencent.mm.protocal.protobuf.jr;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/cgi/CgiBatchEmojiDownload;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BatchEmojiDownLoadResponse;", "customType", "", "reqBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(ILcom/tencent/mm/protobuf/ByteString;)V", "md5List", "", "", "(Ljava/util/List;)V", "reqType", "(IILjava/util/List;Lcom/tencent/mm/protobuf/ByteString;)V", "Companion", "plugin-emojisdk_release"})
public final class a
  extends c<jr>
{
  public static final a jIT;
  
  static
  {
    AppMethodBeat.i(229947);
    jIT = new a((byte)0);
    AppMethodBeat.o(229947);
  }
  
  private a(int paramInt1, int paramInt2, List<String> paramList, b paramb)
  {
    AppMethodBeat.i(229935);
    jq localjq = new jq();
    jr localjr = new jr();
    localjq.lpw = paramInt1;
    localjq.RPk = new LinkedList((Collection)paramList);
    localjq.CNe = paramInt2;
    localjq.RPl = paramb;
    paramList = new d.a();
    paramList.c((com.tencent.mm.cd.a)localjq);
    paramList.d((com.tencent.mm.cd.a)localjr);
    paramList.TW("/cgi-bin/micromsg-bin/mmbatchemojidownload");
    paramList.vD(697);
    c(paramList.bgN());
    AppMethodBeat.o(229935);
  }
  
  public a(int paramInt, b paramb)
  {
    this(2, paramInt, (List)v.aaAd, paramb);
    AppMethodBeat.o(229940);
  }
  
  public a(List<String> paramList, byte paramByte)
  {
    this(paramList);
    AppMethodBeat.i(229944);
    AppMethodBeat.o(229944);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/cgi/CgiBatchEmojiDownload$Companion;", "", "()V", "MM_BATCH_EMOJI_DOWNLOAD_REQ_BACKUP", "", "MM_BATCH_EMOJI_DOWNLOAD_REQ_BACKUP_MD5ONLY", "MM_BATCH_EMOJI_DOWNLOAD_REQ_MD5LIST", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.a.a
 * JD-Core Version:    0.7.0.1
 */