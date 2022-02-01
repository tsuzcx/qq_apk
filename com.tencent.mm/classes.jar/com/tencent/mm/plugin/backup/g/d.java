package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.z;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class d
  extends b
{
  private f ghB;
  private z nEK;
  public aa nEL;
  
  public d(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, LinkedList<String> paramLinkedList, f paramf)
  {
    AppMethodBeat.i(21714);
    this.nEK = new z();
    this.nEL = new aa();
    ae.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramLinkedList.size()) });
    this.nEK.nIB = paramString1;
    this.nEK.nJL = paramLong1;
    this.nEK.nJM = paramLong2;
    this.nEK.nJN = paramString2;
    this.nEK.nJO = paramString3;
    this.nEK.nJs = paramLinkedList;
    this.ghB = paramf;
    AppMethodBeat.o(21714);
  }
  
  public final boolean bJH()
  {
    AppMethodBeat.i(21715);
    boolean bool = super.bJI();
    if (!bool) {
      this.ghB.onSceneEnd(1, -2, "doScene failed", this);
    }
    AppMethodBeat.o(21715);
    return bool;
  }
  
  public final a bJx()
  {
    return this.nEL;
  }
  
  public final a bJy()
  {
    return this.nEK;
  }
  
  public final int getType()
  {
    return 15;
  }
  
  public final void xG(int paramInt)
  {
    AppMethodBeat.i(21716);
    ae.i("MicroMsg.BackupDataTagScene", "onSceneEnd");
    q(0, 0, "success");
    this.ghB.onSceneEnd(0, 0, "", this);
    AppMethodBeat.o(21716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.d
 * JD-Core Version:    0.7.0.1
 */