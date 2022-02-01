package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.j;
import com.tencent.mm.cd.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.protocal.protobuf.ii;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  private String filePath;
  private byte[] key;
  private int lAW;
  private int offset;
  public x rRw;
  private y rRx;
  private j rUp;
  private byte[] rUq;
  private int start;
  private int type;
  
  public c(String paramString1, int paramInt, LinkedList<ih> paramLinkedList, String paramString2, j paramj, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21940);
    this.rRw = new x();
    this.rRx = new y();
    this.rUp = null;
    this.start = 0;
    this.offset = 0;
    this.lAW = 0;
    this.rRw.rWy = paramString1;
    this.rRw.rWz = paramInt;
    this.type = paramInt;
    if (paramInt == 1)
    {
      paramString1 = new ii();
      paramString1.rVy = paramLinkedList;
      paramString1.rVx = paramLinkedList.size();
    }
    for (;;)
    {
      try
      {
        this.rUq = paramString1.toByteArray();
        this.lAW = this.rUq.length;
        paramInt = this.lAW;
        this.rRw.rWA = (16 - paramInt % 16 + this.lAW);
        Log.i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", new Object[] { this.rRw.rWy, Integer.valueOf(this.rRw.rWz), Integer.valueOf(this.lAW), Integer.valueOf(this.rRw.rWA) });
        this.rUp = paramj;
        this.key = paramArrayOfByte;
        AppMethodBeat.o(21940);
        return;
      }
      catch (IOException paramString1)
      {
        Log.e("MicroMsg.BakSceneDataPush", "backList to buffer error");
        Log.printErrStackTrace("MicroMsg.BakSceneDataPush", paramString1, "", new Object[0]);
        continue;
      }
      this.filePath = paramString2;
      this.lAW = ((int)u.bBQ(paramString2));
    }
  }
  
  public static void setProgress(int paramInt)
  {
    AppMethodBeat.i(21941);
    Log.i("MicroMsg.BakSceneDataPush", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
    AppMethodBeat.o(21941);
  }
  
  public final void EN(int paramInt)
  {
    AppMethodBeat.i(21943);
    Log.i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.rRx.rWy, Integer.valueOf(this.rRx.rWz), Integer.valueOf(this.rRx.rWB), Integer.valueOf(this.rRx.rWC), Integer.valueOf(this.rRx.rVU) });
    if (this.rRx.rVU != 0)
    {
      Log.e("MicroMsg.BakSceneDataPush", "status:%d", new Object[] { Integer.valueOf(this.rRx.rVU) });
      r(4, this.rRx.rVU, "error");
      AppMethodBeat.o(21943);
      return;
    }
    this.rUp.a(this.rRw.rWC - this.rRw.rWB, this.lAW, this);
    if (this.offset == this.lAW)
    {
      Log.i("MicroMsg.BakSceneDataPush", "back complete: %s,  %d", new Object[] { this.rRw.rWy, Integer.valueOf(this.lAW) });
      r(0, 0, "success");
      AppMethodBeat.o(21943);
      return;
    }
    ctM();
    AppMethodBeat.o(21943);
  }
  
  public final a ctC()
  {
    return this.rRx;
  }
  
  public final a ctD()
  {
    return this.rRw;
  }
  
  public final boolean ctM()
  {
    AppMethodBeat.i(21942);
    Object localObject1 = null;
    Object localObject2;
    boolean bool;
    label77:
    int j;
    if (this.type == 1)
    {
      i = this.lAW;
      localObject1 = this.rUq;
      this.start = this.offset;
      this.offset = (i + this.start);
      localObject2 = localObject1;
      if (this.key != null)
      {
        localObject2 = this.key;
        if (this.offset != this.lAW) {
          break label518;
        }
        bool = true;
        localObject2 = AesEcb.aesCryptEcb((byte[])localObject1, (byte[])localObject2, true, bool);
      }
      this.rRw.rWB = this.start;
      localObject1 = this.rRw;
      j = this.start;
      if (localObject2 != null) {
        break label524;
      }
    }
    label518:
    label524:
    for (int i = 0;; i = localObject2.length)
    {
      ((x)localObject1).rWC = (i + j);
      this.rRw.rVk = new com.tencent.mm.cd.b((byte[])localObject2);
      this.rRw.rWE = progress;
      Log.i("MicroMsg.BakSceneDataPush", "doSecne %s---total:%d, start:%d, offset:%d, data.len:%d", new Object[] { this.rRw.rWy, Integer.valueOf(this.lAW), Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.rRw.rWC) });
      bool = super.ctM();
      AppMethodBeat.o(21942);
      return bool;
      long l;
      int k;
      if (this.lAW - this.offset > 524288L)
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
        if (!Util.isNullOrNil(this.filePath))
        {
          localObject1 = this.filePath;
          bh.beI();
          if (((String)localObject1).startsWith(com.tencent.mm.model.c.bcb()))
          {
            localObject1 = this.filePath.substring(this.filePath.lastIndexOf("/") + 1);
            Log.i("MicroMsg.BakSceneDataPush", "md5:%s", new Object[] { localObject1 });
            localObject1 = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud((String)localObject1);
            if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.ZuM) == EmojiInfo.ZuM))
            {
              localObject2 = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((EmojiInfo)localObject1);
              localObject1 = new byte[k];
              System.arraycopy(localObject2, this.offset, localObject1, 0, k);
              i = j;
              continue;
              l = this.lAW - this.offset;
              break;
            }
            localObject1 = u.aY(this.filePath, this.offset, k);
            i = j;
            continue;
          }
        }
        localObject1 = u.aY(this.filePath, this.offset, k);
        i = j;
      }
      label479:
      if (localObject1 == null) {
        Log.e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(k) });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.c
 * JD-Core Version:    0.7.0.1
 */