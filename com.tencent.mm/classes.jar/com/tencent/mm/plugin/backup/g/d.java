package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.z;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class d
  extends b
{
  private g hwV;
  private z mYS;
  public aa mYT;
  
  public d(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, LinkedList<String> paramLinkedList, g paramg)
  {
    AppMethodBeat.i(21714);
    this.mYS = new z();
    this.mYT = new aa();
    ac.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramLinkedList.size()) });
    this.mYS.ncJ = paramString1;
    this.mYS.ndT = paramLong1;
    this.mYS.ndU = paramLong2;
    this.mYS.ndV = paramString2;
    this.mYS.ndW = paramString3;
    this.mYS.ndA = paramLinkedList;
    this.hwV = paramg;
    AppMethodBeat.o(21714);
  }
  
  public final boolean bEA()
  {
    AppMethodBeat.i(21715);
    boolean bool = super.bEB();
    if (!bool) {
      this.hwV.onSceneEnd(1, -2, "doScene failed", this);
    }
    AppMethodBeat.o(21715);
    return bool;
  }
  
  public final a bEq()
  {
    return this.mYT;
  }
  
  public final a bEr()
  {
    return this.mYS;
  }
  
  public final int getType()
  {
    return 15;
  }
  
  public final void wW(int paramInt)
  {
    AppMethodBeat.i(21716);
    ac.i("MicroMsg.BackupDataTagScene", "onSceneEnd");
    q(0, 0, "success");
    this.hwV.onSceneEnd(0, 0, "", this);
    AppMethodBeat.o(21716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.d
 * JD-Core Version:    0.7.0.1
 */