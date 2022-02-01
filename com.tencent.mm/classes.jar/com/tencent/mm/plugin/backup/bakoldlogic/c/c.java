package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  private String filePath;
  private int hMP;
  private byte[] key;
  private com.tencent.mm.al.g nBY;
  private byte[] nBZ;
  public x nzh;
  private y nzi;
  private int offset;
  private int start;
  private int type;
  
  public c(String paramString1, int paramInt, LinkedList<if> paramLinkedList, String paramString2, com.tencent.mm.al.g paramg, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21940);
    this.nzh = new x();
    this.nzi = new y();
    this.nBY = null;
    this.start = 0;
    this.offset = 0;
    this.hMP = 0;
    this.nzh.nEj = paramString1;
    this.nzh.nEk = paramInt;
    this.type = paramInt;
    if (paramInt == 1)
    {
      paramString1 = new ig();
      paramString1.nDj = paramLinkedList;
      paramString1.nDi = paramLinkedList.size();
    }
    for (;;)
    {
      try
      {
        this.nBZ = paramString1.toByteArray();
        this.hMP = this.nBZ.length;
        paramInt = this.hMP;
        this.nzh.nEl = (16 - paramInt % 16 + this.hMP);
        ad.i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", new Object[] { this.nzh.nEj, Integer.valueOf(this.nzh.nEk), Integer.valueOf(this.hMP), Integer.valueOf(this.nzh.nEl) });
        this.nBY = paramg;
        this.key = paramArrayOfByte;
        AppMethodBeat.o(21940);
        return;
      }
      catch (IOException paramString1)
      {
        ad.e("MicroMsg.BakSceneDataPush", "backList to buffer error");
        ad.printErrStackTrace("MicroMsg.BakSceneDataPush", paramString1, "", new Object[0]);
        continue;
      }
      this.filePath = paramString2;
      this.hMP = ((int)i.aYo(paramString2));
    }
  }
  
  public static void setProgress(int paramInt)
  {
    AppMethodBeat.i(21941);
    ad.i("MicroMsg.BakSceneDataPush", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
    AppMethodBeat.o(21941);
  }
  
  public final a bIA()
  {
    return this.nzh;
  }
  
  public final boolean bIJ()
  {
    AppMethodBeat.i(21942);
    Object localObject1 = null;
    Object localObject2;
    boolean bool;
    label77:
    int j;
    if (this.type == 1)
    {
      i = this.hMP;
      localObject1 = this.nBZ;
      this.start = this.offset;
      this.offset = (i + this.start);
      localObject2 = localObject1;
      if (this.key != null)
      {
        localObject2 = this.key;
        if (this.offset != this.hMP) {
          break label517;
        }
        bool = true;
        localObject2 = AesEcb.aesCryptEcb((byte[])localObject1, (byte[])localObject2, true, bool);
      }
      this.nzh.nEm = this.start;
      localObject1 = this.nzh;
      j = this.start;
      if (localObject2 != null) {
        break label523;
      }
    }
    label517:
    label523:
    for (int i = 0;; i = localObject2.length)
    {
      ((x)localObject1).nEn = (i + j);
      this.nzh.nCV = new com.tencent.mm.bx.b((byte[])localObject2);
      this.nzh.nEp = progress;
      ad.i("MicroMsg.BakSceneDataPush", "doSecne %s---total:%d, start:%d, offset:%d, data.len:%d", new Object[] { this.nzh.nEj, Integer.valueOf(this.hMP), Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.nzh.nEn) });
      bool = super.bIJ();
      AppMethodBeat.o(21942);
      return bool;
      long l;
      int k;
      if (this.hMP - this.offset > 524288L)
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
        if (!bt.isNullOrNil(this.filePath))
        {
          localObject1 = this.filePath;
          ba.aBQ();
          if (((String)localObject1).startsWith(com.tencent.mm.model.c.azF()))
          {
            localObject1 = this.filePath.substring(this.filePath.lastIndexOf("/") + 1);
            ad.i("MicroMsg.BakSceneDataPush", "md5:%s", new Object[] { localObject1 });
            localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr((String)localObject1);
            if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.Ofi) == EmojiInfo.Ofi))
            {
              localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((EmojiInfo)localObject1);
              localObject1 = new byte[k];
              System.arraycopy(localObject2, this.offset, localObject1, 0, k);
              i = j;
              continue;
              l = this.hMP - this.offset;
              break;
            }
            localObject1 = i.aY(this.filePath, this.offset, k);
            i = j;
            continue;
          }
        }
        localObject1 = i.aY(this.filePath, this.offset, k);
        i = j;
      }
      label479:
      if (localObject1 == null) {
        ad.e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(k) });
      }
      i = k;
      break;
      bool = false;
      break label77;
    }
  }
  
  public final a bIz()
  {
    return this.nzi;
  }
  
  public final int getType()
  {
    return 5;
  }
  
  public final void xC(int paramInt)
  {
    AppMethodBeat.i(21943);
    ad.i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.nzi.nEj, Integer.valueOf(this.nzi.nEk), Integer.valueOf(this.nzi.nEm), Integer.valueOf(this.nzi.nEn), Integer.valueOf(this.nzi.nDG) });
    if (this.nzi.nDG != 0)
    {
      ad.e("MicroMsg.BakSceneDataPush", "status:%d", new Object[] { Integer.valueOf(this.nzi.nDG) });
      q(4, this.nzi.nDG, "error");
      AppMethodBeat.o(21943);
      return;
    }
    this.nBY.a(this.nzh.nEn - this.nzh.nEm, this.hMP, this);
    if (this.offset == this.hMP)
    {
      ad.i("MicroMsg.BakSceneDataPush", "back complete: %s,  %d", new Object[] { this.nzh.nEj, Integer.valueOf(this.hMP) });
      q(0, 0, "success");
      AppMethodBeat.o(21943);
      return;
    }
    bIJ();
    AppMethodBeat.o(21943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.c
 * JD-Core Version:    0.7.0.1
 */