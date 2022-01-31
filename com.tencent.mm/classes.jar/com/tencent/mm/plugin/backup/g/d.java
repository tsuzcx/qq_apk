package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.ah.f;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.z;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class d
  extends b
{
  private f eeo;
  private z hLV = new z();
  public aa hLW = new aa();
  
  public d(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, LinkedList<String> paramLinkedList, f paramf)
  {
    y.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramLinkedList.size()) });
    this.hLV.hPQ = paramString1;
    this.hLV.hRc = paramLong1;
    this.hLV.hRd = paramLong2;
    this.hLV.hRe = paramString2;
    this.hLV.hRf = paramString3;
    this.hLV.hQI = paramLinkedList;
    this.eeo = paramf;
  }
  
  public final a auJ()
  {
    return this.hLW;
  }
  
  public final a auK()
  {
    return this.hLV;
  }
  
  public final boolean auT()
  {
    boolean bool = super.auU();
    if (!bool) {
      this.eeo.onSceneEnd(1, -2, "doScene failed", this);
    }
    return bool;
  }
  
  public final int getType()
  {
    return 15;
  }
  
  public final void nF(int paramInt)
  {
    y.i("MicroMsg.BackupDataTagScene", "onSceneEnd");
    j(0, 0, "success");
    this.eeo.onSceneEnd(0, 0, "", this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.d
 * JD-Core Version:    0.7.0.1
 */