package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.protocal.protobuf.hy;
import d.l;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/sync/CgiBackupEmojiOperate;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BackupEmojiOperateResponse;", "customType", "", "opcode", "md5List", "", "", "(IILjava/util/List;)V", "Companion", "plugin-emojisdk_release"})
public final class a
  extends com.tencent.mm.ak.a<hy>
{
  private static final int grh = 1;
  private static final int gri = 2;
  private static final int grj = 3;
  public static final a grk;
  
  static
  {
    AppMethodBeat.i(105729);
    grk = new a((byte)0);
    grh = 1;
    gri = 2;
    grj = 3;
    AppMethodBeat.o(105729);
  }
  
  public a(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(105728);
    hx localhx = new hx();
    hy localhy = new hy();
    localhx.FSQ = 4;
    localhx.FSP.addAll((Collection)paramList);
    localhx.uqG = paramInt;
    paramList = new b.a();
    paramList.c((com.tencent.mm.bw.a)localhx);
    paramList.d((com.tencent.mm.bw.a)localhy);
    paramList.DN("/cgi-bin/micromsg-bin/mmbackupemojioperate");
    paramList.oS(698);
    c(paramList.aDS());
    AppMethodBeat.o(105728);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/sync/CgiBackupEmojiOperate$Companion;", "", "()V", "MM_EMOJI_BACKUP_ADD", "", "getMM_EMOJI_BACKUP_ADD", "()I", "MM_EMOJI_BACKUP_ADD_TO_TOP", "MM_EMOJI_BACKUP_DEL", "getMM_EMOJI_BACKUP_DEL", "MM_EMOJI_BACKUP_TOP", "getMM_EMOJI_BACKUP_TOP", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.a
 * JD-Core Version:    0.7.0.1
 */