package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  private String filePath;
  private int hPI;
  private byte[] key;
  public x nEC;
  private y nED;
  private com.tencent.mm.ak.g nHt;
  private byte[] nHu;
  private int offset;
  private int start;
  private int type;
  
  public c(String paramString1, int paramInt, LinkedList<if> paramLinkedList, String paramString2, com.tencent.mm.ak.g paramg, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21940);
    this.nEC = new x();
    this.nED = new y();
    this.nHt = null;
    this.start = 0;
    this.offset = 0;
    this.hPI = 0;
    this.nEC.nJE = paramString1;
    this.nEC.nJF = paramInt;
    this.type = paramInt;
    if (paramInt == 1)
    {
      paramString1 = new ig();
      paramString1.nIE = paramLinkedList;
      paramString1.nID = paramLinkedList.size();
    }
    for (;;)
    {
      try
      {
        this.nHu = paramString1.toByteArray();
        this.hPI = this.nHu.length;
        paramInt = this.hPI;
        this.nEC.nJG = (16 - paramInt % 16 + this.hPI);
        ae.i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", new Object[] { this.nEC.nJE, Integer.valueOf(this.nEC.nJF), Integer.valueOf(this.hPI), Integer.valueOf(this.nEC.nJG) });
        this.nHt = paramg;
        this.key = paramArrayOfByte;
        AppMethodBeat.o(21940);
        return;
      }
      catch (IOException paramString1)
      {
        ae.e("MicroMsg.BakSceneDataPush", "backList to buffer error");
        ae.printErrStackTrace("MicroMsg.BakSceneDataPush", paramString1, "", new Object[0]);
        continue;
      }
      this.filePath = paramString2;
      this.hPI = ((int)o.aZR(paramString2));
    }
  }
  
  public static void setProgress(int paramInt)
  {
    AppMethodBeat.i(21941);
    ae.i("MicroMsg.BakSceneDataPush", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
    AppMethodBeat.o(21941);
  }
  
  public final boolean bJH()
  {
    AppMethodBeat.i(21942);
    Object localObject1 = null;
    Object localObject2;
    boolean bool;
    label77:
    int j;
    if (this.type == 1)
    {
      i = this.hPI;
      localObject1 = this.nHu;
      this.start = this.offset;
      this.offset = (i + this.start);
      localObject2 = localObject1;
      if (this.key != null)
      {
        localObject2 = this.key;
        if (this.offset != this.hPI) {
          break label517;
        }
        bool = true;
        localObject2 = AesEcb.aesCryptEcb((byte[])localObject1, (byte[])localObject2, true, bool);
      }
      this.nEC.nJH = this.start;
      localObject1 = this.nEC;
      j = this.start;
      if (localObject2 != null) {
        break label523;
      }
    }
    label517:
    label523:
    for (int i = 0;; i = localObject2.length)
    {
      ((x)localObject1).nJI = (i + j);
      this.nEC.nIq = new com.tencent.mm.bw.b((byte[])localObject2);
      this.nEC.nJK = progress;
      ae.i("MicroMsg.BakSceneDataPush", "doSecne %s---total:%d, start:%d, offset:%d, data.len:%d", new Object[] { this.nEC.nJE, Integer.valueOf(this.hPI), Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.nEC.nJI) });
      bool = super.bJH();
      AppMethodBeat.o(21942);
      return bool;
      long l;
      int k;
      if (this.hPI - this.offset > 524288L)
      {
        l = 524288L;
        k = (int)l;
        i = 3;
      }
      for (;;)
      {
        j = i - 1;
        if ((i <= 0) || (localObject1 != null)) {
          break label479;
        }
        if (!bu.isNullOrNil(this.filePath))
        {
          localObject1 = this.filePath;
          bc.aCg();
          if (((String)localObject1).startsWith(com.tencent.mm.model.c.azV()))
          {
            localObject1 = this.filePath.substring(this.filePath.lastIndexOf("/") + 1);
            ae.i("MicroMsg.BakSceneDataPush", "md5:%s", new Object[] { localObject1 });
            localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci((String)localObject1);
            if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.OAp) == EmojiInfo.OAp))
            {
              localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((EmojiInfo)localObject1);
              localObject1 = new byte[k];
              System.arraycopy(localObject2, this.offset, localObject1, 0, k);
              i = j;
              continue;
              l = this.hPI - this.offset;
              break;
            }
            localObject1 = o.bb(this.filePath, this.offset, k);
            i = j;
            continue;
          }
        }
        localObject1 = o.bb(this.filePath, this.offset, k);
        i = j;
      }
      label479:
      if (localObject1 == null) {
        ae.e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(k) });
      }
      i = k;
      break;
      bool = false;
      break label77;
    }
  }
  
  public final a bJx()
  {
    return this.nED;
  }
  
  public final a bJy()
  {
    return this.nEC;
  }
  
  public final int getType()
  {
    return 5;
  }
  
  public final void xG(int paramInt)
  {
    AppMethodBeat.i(21943);
    ae.i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.nED.nJE, Integer.valueOf(this.nED.nJF), Integer.valueOf(this.nED.nJH), Integer.valueOf(this.nED.nJI), Integer.valueOf(this.nED.nJb) });
    if (this.nED.nJb != 0)
    {
      ae.e("MicroMsg.BakSceneDataPush", "status:%d", new Object[] { Integer.valueOf(this.nED.nJb) });
      q(4, this.nED.nJb, "error");
      AppMethodBeat.o(21943);
      return;
    }
    this.nHt.a(this.nEC.nJI - this.nEC.nJH, this.hPI, this);
    if (this.offset == this.hPI)
    {
      ae.i("MicroMsg.BakSceneDataPush", "back complete: %s,  %d", new Object[] { this.nEC.nJE, Integer.valueOf(this.hPI) });
      q(0, 0, "success");
      AppMethodBeat.o(21943);
      return;
    }
    bJH();
    AppMethodBeat.o(21943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.c
 * JD-Core Version:    0.7.0.1
 */