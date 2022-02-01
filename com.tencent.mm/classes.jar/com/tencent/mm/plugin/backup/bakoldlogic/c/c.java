package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.bw.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  private String filePath;
  private int iKP;
  private byte[] key;
  private y oPA;
  public x oPz;
  private j oSq;
  private byte[] oSr;
  private int offset;
  private int start;
  private int type;
  
  public c(String paramString1, int paramInt, LinkedList<is> paramLinkedList, String paramString2, j paramj, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21940);
    this.oPz = new x();
    this.oPA = new y();
    this.oSq = null;
    this.start = 0;
    this.offset = 0;
    this.iKP = 0;
    this.oPz.oUz = paramString1;
    this.oPz.oUA = paramInt;
    this.type = paramInt;
    if (paramInt == 1)
    {
      paramString1 = new it();
      paramString1.oTA = paramLinkedList;
      paramString1.oTz = paramLinkedList.size();
    }
    for (;;)
    {
      try
      {
        this.oSr = paramString1.toByteArray();
        this.iKP = this.oSr.length;
        paramInt = this.iKP;
        this.oPz.oUB = (16 - paramInt % 16 + this.iKP);
        Log.i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", new Object[] { this.oPz.oUz, Integer.valueOf(this.oPz.oUA), Integer.valueOf(this.iKP), Integer.valueOf(this.oPz.oUB) });
        this.oSq = paramj;
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
      this.iKP = ((int)s.boW(paramString2));
    }
  }
  
  public static void setProgress(int paramInt)
  {
    AppMethodBeat.i(21941);
    Log.i("MicroMsg.BakSceneDataPush", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
    AppMethodBeat.o(21941);
  }
  
  public final void Bm(int paramInt)
  {
    AppMethodBeat.i(21943);
    Log.i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.oPA.oUz, Integer.valueOf(this.oPA.oUA), Integer.valueOf(this.oPA.oUC), Integer.valueOf(this.oPA.oUD), Integer.valueOf(this.oPA.oTW) });
    if (this.oPA.oTW != 0)
    {
      Log.e("MicroMsg.BakSceneDataPush", "status:%d", new Object[] { Integer.valueOf(this.oPA.oTW) });
      q(4, this.oPA.oTW, "error");
      AppMethodBeat.o(21943);
      return;
    }
    this.oSq.a(this.oPz.oUD - this.oPz.oUC, this.iKP, this);
    if (this.offset == this.iKP)
    {
      Log.i("MicroMsg.BakSceneDataPush", "back complete: %s,  %d", new Object[] { this.oPz.oUz, Integer.valueOf(this.iKP) });
      q(0, 0, "success");
      AppMethodBeat.o(21943);
      return;
    }
    cgA();
    AppMethodBeat.o(21943);
  }
  
  public final boolean cgA()
  {
    AppMethodBeat.i(21942);
    Object localObject1 = null;
    Object localObject2;
    boolean bool;
    label77:
    int j;
    if (this.type == 1)
    {
      i = this.iKP;
      localObject1 = this.oSr;
      this.start = this.offset;
      this.offset = (i + this.start);
      localObject2 = localObject1;
      if (this.key != null)
      {
        localObject2 = this.key;
        if (this.offset != this.iKP) {
          break label518;
        }
        bool = true;
        localObject2 = AesEcb.aesCryptEcb((byte[])localObject1, (byte[])localObject2, true, bool);
      }
      this.oPz.oUC = this.start;
      localObject1 = this.oPz;
      j = this.start;
      if (localObject2 != null) {
        break label524;
      }
    }
    label518:
    label524:
    for (int i = 0;; i = localObject2.length)
    {
      ((x)localObject1).oUD = (i + j);
      this.oPz.oTm = new com.tencent.mm.bw.b((byte[])localObject2);
      this.oPz.oUF = progress;
      Log.i("MicroMsg.BakSceneDataPush", "doSecne %s---total:%d, start:%d, offset:%d, data.len:%d", new Object[] { this.oPz.oUz, Integer.valueOf(this.iKP), Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.oPz.oUD) });
      bool = super.cgA();
      AppMethodBeat.o(21942);
      return bool;
      long l;
      int k;
      if (this.iKP - this.offset > 524288L)
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
          bg.aVF();
          if (((String)localObject1).startsWith(com.tencent.mm.model.c.aTd()))
          {
            localObject1 = this.filePath.substring(this.filePath.lastIndexOf("/") + 1);
            Log.i("MicroMsg.BakSceneDataPush", "md5:%s", new Object[] { localObject1 });
            localObject1 = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml((String)localObject1);
            if ((localObject1 != null) && ((((EmojiInfo)localObject1).field_reserved4 & EmojiInfo.UuK) == EmojiInfo.UuK))
            {
              localObject2 = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((EmojiInfo)localObject1);
              localObject1 = new byte[k];
              System.arraycopy(localObject2, this.offset, localObject1, 0, k);
              i = j;
              continue;
              l = this.iKP - this.offset;
              break;
            }
            localObject1 = s.aW(this.filePath, this.offset, k);
            i = j;
            continue;
          }
        }
        localObject1 = s.aW(this.filePath, this.offset, k);
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
  
  public final a cgq()
  {
    return this.oPA;
  }
  
  public final a cgr()
  {
    return this.oPz;
  }
  
  public final int getType()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.c
 * JD-Core Version:    0.7.0.1
 */