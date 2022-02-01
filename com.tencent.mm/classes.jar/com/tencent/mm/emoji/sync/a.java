package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.protocal.protobuf.il;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/sync/CgiBackupEmojiOperate;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BackupEmojiOperateResponse;", "customType", "", "opcode", "md5List", "", "", "(IILjava/util/List;)V", "Companion", "plugin-emojisdk_release"})
public final class a
  extends c<il>
{
  private static final int hcs = 1;
  private static final int hct = 2;
  private static final int hcu = 3;
  public static final a hcv;
  
  static
  {
    AppMethodBeat.i(105729);
    hcv = new a((byte)0);
    hcs = 1;
    hct = 2;
    hcu = 3;
    AppMethodBeat.o(105729);
  }
  
  public a(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(105728);
    ik localik = new ik();
    il localil = new il();
    localik.KMz = 4;
    localik.KMy.addAll((Collection)paramList);
    localik.xIY = paramInt;
    paramList = new d.a();
    paramList.c((com.tencent.mm.bw.a)localik);
    paramList.d((com.tencent.mm.bw.a)localil);
    paramList.MB("/cgi-bin/micromsg-bin/mmbackupemojioperate");
    paramList.sG(698);
    c(paramList.aXF());
    AppMethodBeat.o(105728);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/sync/CgiBackupEmojiOperate$Companion;", "", "()V", "MM_EMOJI_BACKUP_ADD", "", "getMM_EMOJI_BACKUP_ADD", "()I", "MM_EMOJI_BACKUP_ADD_TO_TOP", "MM_EMOJI_BACKUP_DEL", "getMM_EMOJI_BACKUP_DEL", "MM_EMOJI_BACKUP_TOP", "getMM_EMOJI_BACKUP_TOP", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.a
 * JD-Core Version:    0.7.0.1
 */