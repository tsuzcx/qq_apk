package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.z;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class d
  extends b
{
  private g gWw;
  private z mwR;
  public aa mwS;
  
  public d(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, LinkedList<String> paramLinkedList, g paramg)
  {
    AppMethodBeat.i(21714);
    this.mwR = new z();
    this.mwS = new aa();
    ad.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramLinkedList.size()) });
    this.mwR.mAI = paramString1;
    this.mwR.mBS = paramLong1;
    this.mwR.mBT = paramLong2;
    this.mwR.mBU = paramString2;
    this.mwR.mBV = paramString3;
    this.mwR.mBz = paramLinkedList;
    this.gWw = paramg;
    AppMethodBeat.o(21714);
  }
  
  public final boolean bxE()
  {
    AppMethodBeat.i(21715);
    boolean bool = super.bxF();
    if (!bool) {
      this.gWw.onSceneEnd(1, -2, "doScene failed", this);
    }
    AppMethodBeat.o(21715);
    return bool;
  }
  
  public final a bxu()
  {
    return this.mwS;
  }
  
  public final a bxv()
  {
    return this.mwR;
  }
  
  public final int getType()
  {
    return 15;
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(21716);
    ad.i("MicroMsg.BackupDataTagScene", "onSceneEnd");
    q(0, 0, "success");
    this.gWw.onSceneEnd(0, 0, "", this);
    AppMethodBeat.o(21716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.d
 * JD-Core Version:    0.7.0.1
 */