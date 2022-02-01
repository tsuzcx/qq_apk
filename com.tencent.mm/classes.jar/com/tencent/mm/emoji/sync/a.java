package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.hq;
import com.tencent.mm.protocal.protobuf.hr;
import d.l;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/sync/CgiBackupEmojiOperate;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/BackupEmojiOperateResponse;", "customType", "", "opcode", "md5List", "", "", "(IILjava/util/List;)V", "Companion", "plugin-emojisdk_release"})
public final class a
  extends c<hr>
{
  private static final int fVj = 1;
  private static final int fVk = 2;
  private static final int fVl = 3;
  public static final a.a fVm;
  
  static
  {
    AppMethodBeat.i(105729);
    fVm = new a.a((byte)0);
    fVj = 1;
    fVk = 2;
    fVl = 3;
    AppMethodBeat.o(105729);
  }
  
  public a(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(105728);
    hq localhq = new hq();
    hr localhr = new hr();
    localhq.DUY = 4;
    localhq.DUX.addAll((Collection)paramList);
    localhq.DUZ = paramInt;
    paramList = new b.a();
    paramList.c((com.tencent.mm.bw.a)localhq);
    paramList.d((com.tencent.mm.bw.a)localhr);
    paramList.Am("/cgi-bin/micromsg-bin/mmbackupemojioperate");
    paramList.op(698);
    c(paramList.aAz());
    AppMethodBeat.o(105728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.a
 * JD-Core Version:    0.7.0.1
 */