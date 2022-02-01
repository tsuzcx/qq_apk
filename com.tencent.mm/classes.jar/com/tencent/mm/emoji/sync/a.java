package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.hm;
import com.tencent.mm.protocal.protobuf.hn;
import d.l;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/sync/CgiBackupEmojiOperate;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/BackupEmojiOperateResponse;", "customType", "", "opcode", "md5List", "", "", "(IILjava/util/List;)V", "Companion", "plugin-emojisdk_release"})
public final class a
  extends c<hn>
{
  private static final int fRo = 1;
  private static final int fRp = 2;
  private static final int fRq = 3;
  public static final a fRr;
  
  static
  {
    AppMethodBeat.i(105729);
    fRr = new a((byte)0);
    fRo = 1;
    fRp = 2;
    fRq = 3;
    AppMethodBeat.o(105729);
  }
  
  public a(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(105728);
    hm localhm = new hm();
    hn localhn = new hn();
    localhm.CCB = 4;
    localhm.CCA.addAll((Collection)paramList);
    localhm.CCC = paramInt;
    paramList = new b.a();
    paramList.c((com.tencent.mm.bx.a)localhm);
    paramList.d((com.tencent.mm.bx.a)localhn);
    paramList.wg("/cgi-bin/micromsg-bin/mmbackupemojioperate");
    paramList.nB(698);
    c(paramList.atI());
    AppMethodBeat.o(105728);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/sync/CgiBackupEmojiOperate$Companion;", "", "()V", "MM_EMOJI_BACKUP_ADD", "", "getMM_EMOJI_BACKUP_ADD", "()I", "MM_EMOJI_BACKUP_ADD_TO_TOP", "MM_EMOJI_BACKUP_DEL", "getMM_EMOJI_BACKUP_DEL", "MM_EMOJI_BACKUP_TOP", "getMM_EMOJI_BACKUP_TOP", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.a
 * JD-Core Version:    0.7.0.1
 */