package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.z;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class d
  extends b
{
  private f fur;
  private z jFx;
  public aa jFy;
  
  public d(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, LinkedList<String> paramLinkedList, f paramf)
  {
    AppMethodBeat.i(17655);
    this.jFx = new z();
    this.jFy = new aa();
    ab.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramLinkedList.size()) });
    this.jFx.jJs = paramString1;
    this.jFx.jKD = paramLong1;
    this.jFx.jKE = paramLong2;
    this.jFx.jKF = paramString2;
    this.jFx.jKG = paramString3;
    this.jFx.jKk = paramLinkedList;
    this.fur = paramf;
    AppMethodBeat.o(17655);
  }
  
  public final a aUl()
  {
    return this.jFy;
  }
  
  public final a aUm()
  {
    return this.jFx;
  }
  
  public final boolean aUv()
  {
    AppMethodBeat.i(17656);
    boolean bool = super.aUw();
    if (!bool) {
      this.fur.onSceneEnd(1, -2, "doScene failed", this);
    }
    AppMethodBeat.o(17656);
    return bool;
  }
  
  public final int getType()
  {
    return 15;
  }
  
  public final void rt(int paramInt)
  {
    AppMethodBeat.i(17657);
    ab.i("MicroMsg.BackupDataTagScene", "onSceneEnd");
    n(0, 0, "success");
    this.fur.onSceneEnd(0, 0, "", this);
    AppMethodBeat.o(17657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.d
 * JD-Core Version:    0.7.0.1
 */