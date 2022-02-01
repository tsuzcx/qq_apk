package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.protocal.protobuf.hy;
import d.l;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/sync/CgiBackupEmojiOperate;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BackupEmojiOperateResponse;", "customType", "", "opcode", "md5List", "", "", "(IILjava/util/List;)V", "Companion", "plugin-emojisdk_release"})
public final class a
  extends com.tencent.mm.al.a<hy>
{
  private static final int goM = 1;
  private static final int goN = 2;
  private static final int goO = 3;
  public static final a goP;
  
  static
  {
    AppMethodBeat.i(105729);
    goP = new a((byte)0);
    goM = 1;
    goN = 2;
    goO = 3;
    AppMethodBeat.o(105729);
  }
  
  public a(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(105728);
    hx localhx = new hx();
    hy localhy = new hy();
    localhx.FAt = 4;
    localhx.FAs.addAll((Collection)paramList);
    localhx.FAu = paramInt;
    paramList = new b.a();
    paramList.c((com.tencent.mm.bx.a)localhx);
    paramList.d((com.tencent.mm.bx.a)localhy);
    paramList.Dl("/cgi-bin/micromsg-bin/mmbackupemojioperate");
    paramList.oP(698);
    c(paramList.aDC());
    AppMethodBeat.o(105728);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/sync/CgiBackupEmojiOperate$Companion;", "", "()V", "MM_EMOJI_BACKUP_ADD", "", "getMM_EMOJI_BACKUP_ADD", "()I", "MM_EMOJI_BACKUP_ADD_TO_TOP", "MM_EMOJI_BACKUP_DEL", "getMM_EMOJI_BACKUP_DEL", "MM_EMOJI_BACKUP_TOP", "getMM_EMOJI_BACKUP_TOP", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.a
 * JD-Core Version:    0.7.0.1
 */