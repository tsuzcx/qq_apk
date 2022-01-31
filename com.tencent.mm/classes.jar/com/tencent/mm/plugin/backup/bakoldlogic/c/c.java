package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.bv.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.protobuf.gy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  private String filePath;
  private int fsd;
  public x jFp;
  private y jFq;
  private com.tencent.mm.ai.g jIi;
  private byte[] jIj;
  private byte[] key;
  private int offset;
  private int start;
  private int type;
  
  public c(String paramString1, int paramInt, LinkedList<gx> paramLinkedList, String paramString2, com.tencent.mm.ai.g paramg, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17883);
    this.jFp = new x();
    this.jFq = new y();
    this.jIi = null;
    this.start = 0;
    this.offset = 0;
    this.fsd = 0;
    this.jFp.jKw = paramString1;
    this.jFp.jKx = paramInt;
    this.type = paramInt;
    if (paramInt == 1)
    {
      paramString1 = new gy();
      paramString1.jJv = paramLinkedList;
      paramString1.jJu = paramLinkedList.size();
    }
    for (;;)
    {
      try
      {
        this.jIj = paramString1.toByteArray();
        this.fsd = this.jIj.length;
        paramInt = this.fsd;
        this.jFp.jKy = (16 - paramInt % 16 + this.fsd);
        ab.i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", new Object[] { this.jFp.jKw, Integer.valueOf(this.jFp.jKx), Integer.valueOf(this.fsd), Integer.valueOf(this.jFp.jKy) });
        this.jIi = paramg;
        this.key = paramArrayOfByte;
        AppMethodBeat.o(17883);
        return;
      }
      catch (IOException paramString1)
      {
        ab.e("MicroMsg.BakSceneDataPush", "backList to buffer error");
        ab.printErrStackTrace("MicroMsg.BakSceneDataPush", paramString1, "", new Object[0]);
        continue;
      }
      this.filePath = paramString2;
      this.fsd = e.cM(paramString2);
    }
  }
  
  public static void setProgress(int paramInt)
  {
    AppMethodBeat.i(17884);
    ab.i("MicroMsg.BakSceneDataPush", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
    AppMethodBeat.o(17884);
  }
  
  public final a aUl()
  {
    return this.jFq;
  }
  
  public final a aUm()
  {
    return this.jFp;
  }
  
  public final boolean aUv()
  {
    AppMethodBeat.i(17885);
    Object localObject1 = null;
    Object localObject2;
    boolean bool;
    label77:
    int j;
    if (this.type == 1)
    {
      i = this.fsd;
      localObject1 = this.jIj;
      this.start = this.offset;
      this.offset = (i + this.start);
      localObject2 = localObject1;
      if (this.key != null)
      {
        localObject2 = this.key;
        if (this.offset != this.fsd) {
          break label517;
        }
        bool = true;
        localObject2 = AesEcb.aesCryptEcb((byte[])localObject1, (byte[])localObject2, true, bool);
      }
      this.jFp.jKz = this.start;
      localObject1 = this.jFp;
      j = this.start;
      if (localObject2 != null) {
        break label523;
      }
    }
    label517:
    label523:
    for (int i = 0;; i = localObject2.length)
    {
      ((x)localObject1).jKA = (i + j);
      this.jFp.jJh = new com.tencent.mm.bv.b((byte[])localObject2);
      this.jFp.jKC = progress;
      ab.i("MicroMsg.BakSceneDataPush", "doSecne %s---total:%d, start:%d, offset:%d, data.len:%d", new Object[] { this.jFp.jKw, Integer.valueOf(this.fsd), Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.jFp.jKA) });
      bool = super.aUv();
      AppMethodBeat.o(17885);
      return bool;
      long l;
      int k;
      if (this.fsd - this.offset > 524288L)
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
        if (!bo.isNullOrNil(this.filePath))
        {
          localObject1 = this.filePath;
          aw.aaz();
          if (((String)localObject1).startsWith(com.tencent.mm.model.c.YP()))
          {
            localObject1 = this.filePath.substring(this.filePath.lastIndexOf("/") + 1);
            ab.i("MicroMsg.BakSceneDataPush", "md5:%s", new Object[] { localObject1 });
            localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt((String)localObject1);
            if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.APx) == EmojiInfo.APx))
            {
              localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().l((EmojiInfo)localObject1);
              localObject1 = new byte[k];
              System.arraycopy(localObject2, this.offset, localObject1, 0, k);
              i = j;
              continue;
              l = this.fsd - this.offset;
              break;
            }
            localObject1 = e.i(this.filePath, this.offset, k);
            i = j;
            continue;
          }
        }
        localObject1 = e.i(this.filePath, this.offset, k);
        i = j;
      }
      label479:
      if (localObject1 == null) {
        ab.e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(k) });
      }
      i = k;
      break;
      bool = false;
      break label77;
    }
  }
  
  public final int getType()
  {
    return 5;
  }
  
  public final void rt(int paramInt)
  {
    AppMethodBeat.i(17886);
    ab.i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.jFq.jKw, Integer.valueOf(this.jFq.jKx), Integer.valueOf(this.jFq.jKz), Integer.valueOf(this.jFq.jKA), Integer.valueOf(this.jFq.jJS) });
    if (this.jFq.jJS != 0)
    {
      ab.e("MicroMsg.BakSceneDataPush", "status:%d", new Object[] { Integer.valueOf(this.jFq.jJS) });
      n(4, this.jFq.jJS, "error");
      AppMethodBeat.o(17886);
      return;
    }
    this.jIi.a(this.jFp.jKA - this.jFp.jKz, this.fsd, this);
    if (this.offset == this.fsd)
    {
      ab.i("MicroMsg.BakSceneDataPush", "back complete: %s,  %d", new Object[] { this.jFp.jKw, Integer.valueOf(this.fsd) });
      n(0, 0, "success");
      AppMethodBeat.o(17886);
      return;
    }
    aUv();
    AppMethodBeat.o(17886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.c
 * JD-Core Version:    0.7.0.1
 */