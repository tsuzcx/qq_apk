package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.z;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
  extends b
{
  private h maV;
  private z vcU;
  public aa vcV;
  
  public d(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, LinkedList<String> paramLinkedList, h paramh)
  {
    AppMethodBeat.i(21714);
    this.vcU = new z();
    this.vcV = new aa();
    Log.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramLinkedList.size()) });
    this.vcU.vgL = paramString1;
    this.vcU.vhU = paramLong1;
    this.vcU.vhV = paramLong2;
    this.vcU.vhW = paramString2;
    this.vcU.vhX = paramString3;
    this.vcU.vhB = paramLinkedList;
    this.maV = paramh;
    AppMethodBeat.o(21714);
  }
  
  public final void Fo(int paramInt)
  {
    AppMethodBeat.i(21716);
    u(0, 0, "success");
    this.maV.onSceneEnd(0, 0, "", this);
    AppMethodBeat.o(21716);
  }
  
  public final a cWm()
  {
    return this.vcV;
  }
  
  public final a cWn()
  {
    return this.vcU;
  }
  
  public final boolean cWw()
  {
    AppMethodBeat.i(21715);
    boolean bool = super.cWx();
    if (!bool)
    {
      this.vcV.vgL = this.vcU.vgL;
      this.vcV.vhU = this.vcU.vhU;
      this.vcV.vhV = this.vcU.vhV;
      this.vcV.vhW = this.vcU.vhW;
      this.maV.onSceneEnd(1, -2, "doScene failed", this);
    }
    AppMethodBeat.o(21715);
    return bool;
  }
  
  public final int getType()
  {
    return 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.d
 * JD-Core Version:    0.7.0.1
 */