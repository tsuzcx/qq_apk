package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.bw.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.protocal.protobuf.hz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  private String filePath;
  private int hux;
  private byte[] key;
  public x mYK;
  private y mYL;
  private h nbB;
  private byte[] nbC;
  private int offset;
  private int start;
  private int type;
  
  public c(String paramString1, int paramInt, LinkedList<hy> paramLinkedList, String paramString2, h paramh, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21940);
    this.mYK = new x();
    this.mYL = new y();
    this.nbB = null;
    this.start = 0;
    this.offset = 0;
    this.hux = 0;
    this.mYK.ndM = paramString1;
    this.mYK.ndN = paramInt;
    this.type = paramInt;
    if (paramInt == 1)
    {
      paramString1 = new hz();
      paramString1.ncM = paramLinkedList;
      paramString1.ncL = paramLinkedList.size();
    }
    for (;;)
    {
      try
      {
        this.nbC = paramString1.toByteArray();
        this.hux = this.nbC.length;
        paramInt = this.hux;
        this.mYK.ndO = (16 - paramInt % 16 + this.hux);
        ac.i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", new Object[] { this.mYK.ndM, Integer.valueOf(this.mYK.ndN), Integer.valueOf(this.hux), Integer.valueOf(this.mYK.ndO) });
        this.nbB = paramh;
        this.key = paramArrayOfByte;
        AppMethodBeat.o(21940);
        return;
      }
      catch (IOException paramString1)
      {
        ac.e("MicroMsg.BakSceneDataPush", "backList to buffer error");
        ac.printErrStackTrace("MicroMsg.BakSceneDataPush", paramString1, "", new Object[0]);
        continue;
      }
      this.filePath = paramString2;
      this.hux = ((int)i.aSp(paramString2));
    }
  }
  
  public static void setProgress(int paramInt)
  {
    AppMethodBeat.i(21941);
    ac.i("MicroMsg.BakSceneDataPush", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
    AppMethodBeat.o(21941);
  }
  
  public final boolean bEA()
  {
    AppMethodBeat.i(21942);
    Object localObject1 = null;
    Object localObject2;
    boolean bool;
    label77:
    int j;
    if (this.type == 1)
    {
      i = this.hux;
      localObject1 = this.nbC;
      this.start = this.offset;
      this.offset = (i + this.start);
      localObject2 = localObject1;
      if (this.key != null)
      {
        localObject2 = this.key;
        if (this.offset != this.hux) {
          break label517;
        }
        bool = true;
        localObject2 = AesEcb.aesCryptEcb((byte[])localObject1, (byte[])localObject2, true, bool);
      }
      this.mYK.ndP = this.start;
      localObject1 = this.mYK;
      j = this.start;
      if (localObject2 != null) {
        break label523;
      }
    }
    label517:
    label523:
    for (int i = 0;; i = localObject2.length)
    {
      ((x)localObject1).ndQ = (i + j);
      this.mYK.ncy = new com.tencent.mm.bw.b((byte[])localObject2);
      this.mYK.ndS = progress;
      ac.i("MicroMsg.BakSceneDataPush", "doSecne %s---total:%d, start:%d, offset:%d, data.len:%d", new Object[] { this.mYK.ndM, Integer.valueOf(this.hux), Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.mYK.ndQ) });
      bool = super.bEA();
      AppMethodBeat.o(21942);
      return bool;
      long l;
      int k;
      if (this.hux - this.offset > 524288L)
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
        if (!bs.isNullOrNil(this.filePath))
        {
          localObject1 = this.filePath;
          az.ayM();
          if (((String)localObject1).startsWith(com.tencent.mm.model.c.awQ()))
          {
            localObject1 = this.filePath.substring(this.filePath.lastIndexOf("/") + 1);
            ac.i("MicroMsg.BakSceneDataPush", "md5:%s", new Object[] { localObject1 });
            localObject1 = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL((String)localObject1);
            if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.Kgm) == EmojiInfo.Kgm))
            {
              localObject2 = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((EmojiInfo)localObject1);
              localObject1 = new byte[k];
              System.arraycopy(localObject2, this.offset, localObject1, 0, k);
              i = j;
              continue;
              l = this.hux - this.offset;
              break;
            }
            localObject1 = i.aU(this.filePath, this.offset, k);
            i = j;
            continue;
          }
        }
        localObject1 = i.aU(this.filePath, this.offset, k);
        i = j;
      }
      label479:
      if (localObject1 == null) {
        ac.e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(k) });
      }
      i = k;
      break;
      bool = false;
      break label77;
    }
  }
  
  public final a bEq()
  {
    return this.mYL;
  }
  
  public final a bEr()
  {
    return this.mYK;
  }
  
  public final int getType()
  {
    return 5;
  }
  
  public final void wW(int paramInt)
  {
    AppMethodBeat.i(21943);
    ac.i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.mYL.ndM, Integer.valueOf(this.mYL.ndN), Integer.valueOf(this.mYL.ndP), Integer.valueOf(this.mYL.ndQ), Integer.valueOf(this.mYL.ndj) });
    if (this.mYL.ndj != 0)
    {
      ac.e("MicroMsg.BakSceneDataPush", "status:%d", new Object[] { Integer.valueOf(this.mYL.ndj) });
      q(4, this.mYL.ndj, "error");
      AppMethodBeat.o(21943);
      return;
    }
    this.nbB.a(this.mYK.ndQ - this.mYK.ndP, this.hux, this);
    if (this.offset == this.hux)
    {
      ac.i("MicroMsg.BakSceneDataPush", "back complete: %s,  %d", new Object[] { this.mYK.ndM, Integer.valueOf(this.hux) });
      q(0, 0, "success");
      AppMethodBeat.o(21943);
      return;
    }
    bEA();
    AppMethodBeat.o(21943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.c
 * JD-Core Version:    0.7.0.1
 */