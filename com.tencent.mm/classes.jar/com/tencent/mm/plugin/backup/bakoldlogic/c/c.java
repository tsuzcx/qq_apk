package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.i;
import com.tencent.mm.bx.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.protocal.protobuf.je;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  private String filePath;
  private byte[] key;
  private int offset;
  private int osy;
  private int start;
  private int type;
  public x vcM;
  private com.tencent.mm.plugin.backup.i.y vcN;
  private i vfE;
  private byte[] vfF;
  
  public c(String paramString1, int paramInt, LinkedList<jd> paramLinkedList, String paramString2, i parami, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21940);
    this.vcM = new x();
    this.vcN = new com.tencent.mm.plugin.backup.i.y();
    this.vfE = null;
    this.start = 0;
    this.offset = 0;
    this.osy = 0;
    this.vcM.vhN = paramString1;
    this.vcM.vhO = paramInt;
    this.type = paramInt;
    if (paramInt == 1)
    {
      paramString1 = new je();
      paramString1.vgO = paramLinkedList;
      paramString1.vgN = paramLinkedList.size();
    }
    for (;;)
    {
      try
      {
        this.vfF = paramString1.toByteArray();
        this.osy = this.vfF.length;
        paramInt = this.osy;
        this.vcM.vhP = (16 - paramInt % 16 + this.osy);
        Log.i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", new Object[] { this.vcM.vhN, Integer.valueOf(this.vcM.vhO), Integer.valueOf(this.osy), Integer.valueOf(this.vcM.vhP) });
        this.vfE = parami;
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
      this.osy = ((int)com.tencent.mm.vfs.y.bEl(paramString2));
    }
  }
  
  public static void setProgress(int paramInt)
  {
    AppMethodBeat.i(21941);
    Log.i("MicroMsg.BakSceneDataPush", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
    AppMethodBeat.o(21941);
  }
  
  public final void Fo(int paramInt)
  {
    AppMethodBeat.i(21943);
    Log.i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.vcN.vhN, Integer.valueOf(this.vcN.vhO), Integer.valueOf(this.vcN.vhQ), Integer.valueOf(this.vcN.vhR), Integer.valueOf(this.vcN.vhk) });
    if (this.vcN.vhk != 0)
    {
      Log.e("MicroMsg.BakSceneDataPush", "status:%d", new Object[] { Integer.valueOf(this.vcN.vhk) });
      u(4, this.vcN.vhk, "error");
      AppMethodBeat.o(21943);
      return;
    }
    this.vfE.a(this.vcM.vhR - this.vcM.vhQ, this.osy, this);
    if (this.offset == this.osy)
    {
      Log.i("MicroMsg.BakSceneDataPush", "back complete: %s,  %d", new Object[] { this.vcM.vhN, Integer.valueOf(this.osy) });
      u(0, 0, "success");
      AppMethodBeat.o(21943);
      return;
    }
    cWw();
    AppMethodBeat.o(21943);
  }
  
  public final a cWm()
  {
    return this.vcN;
  }
  
  public final a cWn()
  {
    return this.vcM;
  }
  
  public final boolean cWw()
  {
    AppMethodBeat.i(21942);
    Object localObject1 = null;
    Object localObject2;
    boolean bool;
    label77:
    int j;
    if (this.type == 1)
    {
      i = this.osy;
      localObject1 = this.vfF;
      this.start = this.offset;
      this.offset = (i + this.start);
      localObject2 = localObject1;
      if (this.key != null)
      {
        localObject2 = this.key;
        if (this.offset != this.osy) {
          break label518;
        }
        bool = true;
        localObject2 = AesEcb.aesCryptEcb((byte[])localObject1, (byte[])localObject2, true, bool);
      }
      this.vcM.vhQ = this.start;
      localObject1 = this.vcM;
      j = this.start;
      if (localObject2 != null) {
        break label524;
      }
    }
    label518:
    label524:
    for (int i = 0;; i = localObject2.length)
    {
      ((x)localObject1).vhR = (i + j);
      this.vcM.vgA = new com.tencent.mm.bx.b((byte[])localObject2);
      this.vcM.vhT = progress;
      Log.i("MicroMsg.BakSceneDataPush", "doSecne %s---total:%d, start:%d, offset:%d, data.len:%d", new Object[] { this.vcM.vhN, Integer.valueOf(this.osy), Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.vcM.vhR) });
      bool = super.cWw();
      AppMethodBeat.o(21942);
      return bool;
      long l;
      int k;
      if (this.osy - this.offset > 524288L)
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
          bh.bCz();
          if (((String)localObject1).startsWith(com.tencent.mm.model.c.bzQ()))
          {
            localObject1 = this.filePath.substring(this.filePath.lastIndexOf("/") + 1);
            Log.i("MicroMsg.BakSceneDataPush", "md5:%s", new Object[] { localObject1 });
            localObject1 = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe((String)localObject1);
            if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.akmb) == EmojiInfo.akmb))
            {
              localObject2 = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a((EmojiInfo)localObject1);
              localObject1 = new byte[k];
              System.arraycopy(localObject2, this.offset, localObject1, 0, k);
              i = j;
              continue;
              l = this.osy - this.offset;
              break;
            }
            localObject1 = com.tencent.mm.vfs.y.bi(this.filePath, this.offset, k);
            i = j;
            continue;
          }
        }
        localObject1 = com.tencent.mm.vfs.y.bi(this.filePath, this.offset, k);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.c
 * JD-Core Version:    0.7.0.1
 */