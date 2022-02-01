package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.z;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
  extends b
{
  private i jxB;
  private z rRE;
  public aa rRF;
  
  public d(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, LinkedList<String> paramLinkedList, i parami)
  {
    AppMethodBeat.i(21714);
    this.rRE = new z();
    this.rRF = new aa();
    Log.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramLinkedList.size()) });
    this.rRE.rVv = paramString1;
    this.rRE.rWF = paramLong1;
    this.rRE.rWG = paramLong2;
    this.rRE.rWH = paramString2;
    this.rRE.rWI = paramString3;
    this.rRE.rWl = paramLinkedList;
    this.jxB = parami;
    AppMethodBeat.o(21714);
  }
  
  public final void EN(int paramInt)
  {
    AppMethodBeat.i(21716);
    r(0, 0, "success");
    this.jxB.onSceneEnd(0, 0, "", this);
    AppMethodBeat.o(21716);
  }
  
  public final a ctC()
  {
    return this.rRF;
  }
  
  public final a ctD()
  {
    return this.rRE;
  }
  
  public final boolean ctM()
  {
    AppMethodBeat.i(21715);
    boolean bool = super.ctN();
    if (!bool)
    {
      this.rRF.rVv = this.rRE.rVv;
      this.rRF.rWF = this.rRE.rWF;
      this.rRF.rWG = this.rRE.rWG;
      this.rRF.rWH = this.rRE.rWH;
      this.jxB.onSceneEnd(1, -2, "doScene failed", this);
    }
    AppMethodBeat.o(21715);
    return bool;
  }
  
  public final int getType()
  {
    return 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.d
 * JD-Core Version:    0.7.0.1
 */