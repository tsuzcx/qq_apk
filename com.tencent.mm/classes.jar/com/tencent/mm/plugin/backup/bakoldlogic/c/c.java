package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.a.e;
import com.tencent.mm.bv.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.protocal.c.fp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  private int ebK = 0;
  private String filePath;
  public x hLN = new x();
  private com.tencent.mm.plugin.backup.i.y hLO = new com.tencent.mm.plugin.backup.i.y();
  private com.tencent.mm.ah.g hOG = null;
  private byte[] hOH;
  private byte[] key;
  private int offset = 0;
  private int start = 0;
  private int type;
  
  public c(String paramString1, int paramInt, LinkedList<fo> paramLinkedList, String paramString2, com.tencent.mm.ah.g paramg, byte[] paramArrayOfByte)
  {
    this.hLN.hQV = paramString1;
    this.hLN.hQW = paramInt;
    this.type = paramInt;
    if (paramInt == 1)
    {
      paramString1 = new fp();
      paramString1.hPT = paramLinkedList;
      paramString1.hPS = paramLinkedList.size();
    }
    for (;;)
    {
      try
      {
        this.hOH = paramString1.toByteArray();
        this.ebK = this.hOH.length;
        paramInt = this.ebK;
        this.hLN.hQX = (16 - paramInt % 16 + this.ebK);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", new Object[] { this.hLN.hQV, Integer.valueOf(this.hLN.hQW), Integer.valueOf(this.ebK), Integer.valueOf(this.hLN.hQX) });
        this.hOG = paramg;
        this.key = paramArrayOfByte;
        return;
      }
      catch (IOException paramString1)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BakSceneDataPush", "backList to buffer error");
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.BakSceneDataPush", paramString1, "", new Object[0]);
        continue;
      }
      this.filePath = paramString2;
      this.ebK = e.bJ(paramString2);
    }
  }
  
  public static void setProgress(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BakSceneDataPush", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
  }
  
  public final a auJ()
  {
    return this.hLO;
  }
  
  public final a auK()
  {
    return this.hLN;
  }
  
  public final boolean auT()
  {
    long l = 524288L;
    Object localObject2;
    Object localObject1;
    boolean bool;
    label73:
    int j;
    if (this.type == 1)
    {
      i = this.ebK;
      localObject2 = this.hOH;
      this.start = this.offset;
      this.offset = (i + this.start);
      localObject1 = localObject2;
      if (this.key != null)
      {
        localObject1 = this.key;
        if (this.offset != this.ebK) {
          break label511;
        }
        bool = true;
        localObject1 = AesEcb.aesCryptEcb((byte[])localObject2, (byte[])localObject1, true, bool);
      }
      this.hLN.hQY = this.start;
      localObject2 = this.hLN;
      j = this.start;
      if (localObject1 != null) {
        break label517;
      }
    }
    label517:
    for (int i = 0;; i = localObject1.length)
    {
      ((x)localObject2).hQZ = (i + j);
      this.hLN.hPF = new com.tencent.mm.bv.b((byte[])localObject1);
      this.hLN.hRb = progress;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BakSceneDataPush", "doSecne %s---total:%d, start:%d, offset:%d, data.len:%d", new Object[] { this.hLN.hQV, Integer.valueOf(this.ebK), Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.hLN.hQZ) });
      return super.auT();
      int k;
      if (this.ebK - this.offset > 524288L)
      {
        k = (int)l;
        i = 3;
        localObject1 = null;
      }
      for (;;)
      {
        j = i - 1;
        if ((i <= 0) || (localObject1 != null)) {
          break label463;
        }
        if (!bk.bl(this.filePath))
        {
          localObject1 = this.filePath;
          au.Hx();
          if (((String)localObject1).startsWith(com.tencent.mm.model.c.FL()))
          {
            localObject1 = this.filePath.substring(this.filePath.lastIndexOf("/") + 1);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BakSceneDataPush", "md5:%s", new Object[] { localObject1 });
            localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As((String)localObject1);
            if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.uDo) == EmojiInfo.uDo))
            {
              localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((EmojiInfo)localObject1);
              localObject1 = new byte[k];
              System.arraycopy(localObject2, this.offset, localObject1, 0, k);
              i = j;
              continue;
              l = this.ebK - this.offset;
              break;
            }
            localObject1 = e.c(this.filePath, this.offset, k);
            i = j;
            continue;
          }
        }
        localObject1 = e.c(this.filePath, this.offset, k);
        i = j;
      }
      label463:
      localObject2 = localObject1;
      i = k;
      if (localObject1 != null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(k) });
      localObject2 = localObject1;
      i = k;
      break;
      label511:
      bool = false;
      break label73;
    }
  }
  
  public final int getType()
  {
    return 5;
  }
  
  public final void nF(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.hLO.hQV, Integer.valueOf(this.hLO.hQW), Integer.valueOf(this.hLO.hQY), Integer.valueOf(this.hLO.hQZ), Integer.valueOf(this.hLO.hQq) });
    if (this.hLO.hQq != 0)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BakSceneDataPush", "status:%d", new Object[] { Integer.valueOf(this.hLO.hQq) });
      j(4, this.hLO.hQq, "error");
      return;
    }
    this.hOG.a(this.hLN.hQZ - this.hLN.hQY, this.ebK, this);
    if (this.offset == this.ebK)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BakSceneDataPush", "back complete: %s,  %d", new Object[] { this.hLN.hQV, Integer.valueOf(this.ebK) });
      j(0, 0, "success");
      return;
    }
    auT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.c
 * JD-Core Version:    0.7.0.1
 */