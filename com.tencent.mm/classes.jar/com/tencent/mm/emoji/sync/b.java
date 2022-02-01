package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.hz;
import com.tencent.mm.protocal.protobuf.ia;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/CgiBackupEmojiOperate;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BackupEmojiOperateResponse;", "customType", "", "opcode", "md5List", "", "", "(IILjava/util/List;)V", "Companion", "plugin-emojisdk_release"})
public final class b
  extends c<ia>
{
  public static final a jNC;
  
  static
  {
    AppMethodBeat.i(105729);
    jNC = new a((byte)0);
    AppMethodBeat.o(105729);
  }
  
  public b(int paramInt1, int paramInt2, List<String> paramList)
  {
    AppMethodBeat.i(224379);
    hz localhz = new hz();
    ia localia = new ia();
    localhz.RNt = paramInt2;
    localhz.RNs.addAll((Collection)paramList);
    localhz.CNe = paramInt1;
    paramList = new d.a();
    paramList.c((a)localhz);
    paramList.d((a)localia);
    paramList.TW("/cgi-bin/micromsg-bin/mmbackupemojioperate");
    paramList.vD(698);
    c(paramList.bgN());
    AppMethodBeat.o(224379);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/CgiBackupEmojiOperate$Companion;", "", "()V", "MM_EMOJI_BACKUP_ADD", "", "MM_EMOJI_BACKUP_ADD_TO_TOP", "MM_EMOJI_BACKUP_DEL", "MM_EMOJI_BACKUP_TOP", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.b
 * JD-Core Version:    0.7.0.1
 */