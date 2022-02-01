package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.h;
import com.tencent.mm.bx.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.protocal.protobuf.hv;
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
  private int gTY;
  private byte[] key;
  public x mwJ;
  private y mwK;
  private h mzA;
  private byte[] mzB;
  private int offset;
  private int start;
  private int type;
  
  public c(String paramString1, int paramInt, LinkedList<hu> paramLinkedList, String paramString2, h paramh, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21940);
    this.mwJ = new x();
    this.mwK = new y();
    this.mzA = null;
    this.start = 0;
    this.offset = 0;
    this.gTY = 0;
    this.mwJ.mBL = paramString1;
    this.mwJ.mBM = paramInt;
    this.type = paramInt;
    if (paramInt == 1)
    {
      paramString1 = new hv();
      paramString1.mAL = paramLinkedList;
      paramString1.mAK = paramLinkedList.size();
    }
    for (;;)
    {
      try
      {
        this.mzB = paramString1.toByteArray();
        this.gTY = this.mzB.length;
        paramInt = this.gTY;
        this.mwJ.mBN = (16 - paramInt % 16 + this.gTY);
        ad.i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", new Object[] { this.mwJ.mBL, Integer.valueOf(this.mwJ.mBM), Integer.valueOf(this.gTY), Integer.valueOf(this.mwJ.mBN) });
        this.mzA = paramh;
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
      this.gTY = ((int)i.aMN(paramString2));
    }
  }
  
  public static void setProgress(int paramInt)
  {
    AppMethodBeat.i(21941);
    ad.i("MicroMsg.BakSceneDataPush", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
    AppMethodBeat.o(21941);
  }
  
  public final boolean bxE()
  {
    AppMethodBeat.i(21942);
    Object localObject1 = null;
    Object localObject2;
    boolean bool;
    label77:
    int j;
    if (this.type == 1)
    {
      i = this.gTY;
      localObject1 = this.mzB;
      this.start = this.offset;
      this.offset = (i + this.start);
      localObject2 = localObject1;
      if (this.key != null)
      {
        localObject2 = this.key;
        if (this.offset != this.gTY) {
          break label517;
        }
        bool = true;
        localObject2 = AesEcb.aesCryptEcb((byte[])localObject1, (byte[])localObject2, true, bool);
      }
      this.mwJ.mBO = this.start;
      localObject1 = this.mwJ;
      j = this.start;
      if (localObject2 != null) {
        break label523;
      }
    }
    label517:
    label523:
    for (int i = 0;; i = localObject2.length)
    {
      ((x)localObject1).mBP = (i + j);
      this.mwJ.mAx = new com.tencent.mm.bx.b((byte[])localObject2);
      this.mwJ.mBR = progress;
      ad.i("MicroMsg.BakSceneDataPush", "doSecne %s---total:%d, start:%d, offset:%d, data.len:%d", new Object[] { this.mwJ.mBL, Integer.valueOf(this.gTY), Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.mwJ.mBP) });
      bool = super.bxE();
      AppMethodBeat.o(21942);
      return bool;
      long l;
      int k;
      if (this.gTY - this.offset > 524288L)
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
          az.arV();
          if (((String)localObject1).startsWith(com.tencent.mm.model.c.aqb()))
          {
            localObject1 = this.filePath.substring(this.filePath.lastIndexOf("/") + 1);
            ad.i("MicroMsg.BakSceneDataPush", "md5:%s", new Object[] { localObject1 });
            localObject1 = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz((String)localObject1);
            if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.LCl) == EmojiInfo.LCl))
            {
              localObject2 = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((EmojiInfo)localObject1);
              localObject1 = new byte[k];
              System.arraycopy(localObject2, this.offset, localObject1, 0, k);
              i = j;
              continue;
              l = this.gTY - this.offset;
              break;
            }
            localObject1 = i.aR(this.filePath, this.offset, k);
            i = j;
            continue;
          }
        }
        localObject1 = i.aR(this.filePath, this.offset, k);
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
  
  public final a bxu()
  {
    return this.mwK;
  }
  
  public final a bxv()
  {
    return this.mwJ;
  }
  
  public final int getType()
  {
    return 5;
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(21943);
    ad.i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.mwK.mBL, Integer.valueOf(this.mwK.mBM), Integer.valueOf(this.mwK.mBO), Integer.valueOf(this.mwK.mBP), Integer.valueOf(this.mwK.mBi) });
    if (this.mwK.mBi != 0)
    {
      ad.e("MicroMsg.BakSceneDataPush", "status:%d", new Object[] { Integer.valueOf(this.mwK.mBi) });
      q(4, this.mwK.mBi, "error");
      AppMethodBeat.o(21943);
      return;
    }
    this.mzA.a(this.mwJ.mBP - this.mwJ.mBO, this.gTY, this);
    if (this.offset == this.gTY)
    {
      ad.i("MicroMsg.BakSceneDataPush", "back complete: %s,  %d", new Object[] { this.mwJ.mBL, Integer.valueOf(this.gTY) });
      q(0, 0, "success");
      AppMethodBeat.o(21943);
      return;
    }
    bxE();
    AppMethodBeat.o(21943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.c
 * JD-Core Version:    0.7.0.1
 */