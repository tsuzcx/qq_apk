package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.z;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class d
  extends b
{
  private f hPn;
  private z nzp;
  public aa nzq;
  
  public d(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, LinkedList<String> paramLinkedList, f paramf)
  {
    AppMethodBeat.i(21714);
    this.nzp = new z();
    this.nzq = new aa();
    ad.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramLinkedList.size()) });
    this.nzp.nDg = paramString1;
    this.nzp.nEq = paramLong1;
    this.nzp.nEr = paramLong2;
    this.nzp.nEs = paramString2;
    this.nzp.nEt = paramString3;
    this.nzp.nDX = paramLinkedList;
    this.hPn = paramf;
    AppMethodBeat.o(21714);
  }
  
  public final a bIA()
  {
    return this.nzp;
  }
  
  public final boolean bIJ()
  {
    AppMethodBeat.i(21715);
    boolean bool = super.bIK();
    if (!bool) {
      this.hPn.onSceneEnd(1, -2, "doScene failed", this);
    }
    AppMethodBeat.o(21715);
    return bool;
  }
  
  public final a bIz()
  {
    return this.nzq;
  }
  
  public final int getType()
  {
    return 15;
  }
  
  public final void xC(int paramInt)
  {
    AppMethodBeat.i(21716);
    ad.i("MicroMsg.BackupDataTagScene", "onSceneEnd");
    q(0, 0, "success");
    this.hPn.onSceneEnd(0, 0, "", this);
    AppMethodBeat.o(21716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.d
 * JD-Core Version:    0.7.0.1
 */