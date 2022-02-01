package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.iv;
import com.tencent.mm.protocal.protobuf.iw;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/CgiBackupEmojiOperate;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BackupEmojiOperateResponse;", "customType", "", "opcode", "md5List", "", "", "(IILjava/util/List;)V", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.am.b<iw>
{
  public static final a mmB;
  
  static
  {
    AppMethodBeat.i(105729);
    mmB = new a((byte)0);
    AppMethodBeat.o(105729);
  }
  
  public b(int paramInt1, int paramInt2, List<String> paramList)
  {
    AppMethodBeat.i(242546);
    iv localiv = new iv();
    iw localiw = new iw();
    localiv.YKH = paramInt2;
    localiv.YKG.addAll((Collection)paramList);
    localiv.IHj = paramInt1;
    paramList = new c.a();
    paramList.otE = ((a)localiv);
    paramList.otF = ((a)localiw);
    paramList.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
    paramList.funcId = 698;
    c(paramList.bEF());
    AppMethodBeat.o(242546);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/CgiBackupEmojiOperate$Companion;", "", "()V", "MM_EMOJI_BACKUP_ADD", "", "MM_EMOJI_BACKUP_ADD_TO_TOP", "MM_EMOJI_BACKUP_DEL", "MM_EMOJI_BACKUP_TOP", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.b
 * JD-Core Version:    0.7.0.1
 */