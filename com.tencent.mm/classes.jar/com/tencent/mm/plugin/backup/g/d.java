package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.z;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
  extends b
{
  private i gNh;
  private z oPH;
  public aa oPI;
  
  public d(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, LinkedList<String> paramLinkedList, i parami)
  {
    AppMethodBeat.i(21714);
    this.oPH = new z();
    this.oPI = new aa();
    Log.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramLinkedList.size()) });
    this.oPH.oTx = paramString1;
    this.oPH.oUG = paramLong1;
    this.oPH.oUH = paramLong2;
    this.oPH.oUI = paramString2;
    this.oPH.oUJ = paramString3;
    this.oPH.oUn = paramLinkedList;
    this.gNh = parami;
    AppMethodBeat.o(21714);
  }
  
  public final void Bm(int paramInt)
  {
    AppMethodBeat.i(21716);
    Log.i("MicroMsg.BackupDataTagScene", "onSceneEnd");
    q(0, 0, "success");
    this.gNh.onSceneEnd(0, 0, "", this);
    AppMethodBeat.o(21716);
  }
  
  public final boolean cgA()
  {
    AppMethodBeat.i(21715);
    boolean bool = super.cgB();
    if (!bool) {
      this.gNh.onSceneEnd(1, -2, "doScene failed", this);
    }
    AppMethodBeat.o(21715);
    return bool;
  }
  
  public final a cgq()
  {
    return this.oPI;
  }
  
  public final a cgr()
  {
    return this.oPH;
  }
  
  public final int getType()
  {
    return 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.d
 * JD-Core Version:    0.7.0.1
 */