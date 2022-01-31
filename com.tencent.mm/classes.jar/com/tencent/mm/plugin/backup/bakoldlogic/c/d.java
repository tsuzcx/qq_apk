package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.a.e;
import com.tencent.mm.ah.g;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.i.ad;
import com.tencent.mm.plugin.backup.i.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class d
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  private int ebK;
  private g hOG = null;
  private ad hOI = new ad();
  private ae hOJ = new ae();
  private String hOK;
  public String id;
  private byte[] key;
  private int offset = 0;
  private int start = 0;
  
  public d(String paramString1, String paramString2, int paramInt1, int paramInt2, g paramg, byte[] paramArrayOfByte)
  {
    if (paramInt1 == 1) {}
    for (this.hOK = (paramString1 + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.xq(paramString2));; this.hOK = (paramString1 + "backupMeida/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.xq(paramString2)))
    {
      this.id = paramString2;
      this.hOI.hQV = paramString2;
      this.hOI.hQW = paramInt1;
      this.ebK = paramInt2;
      y.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", new Object[] { this.hOI.hQV, Integer.valueOf(this.hOI.hQW), Integer.valueOf(this.ebK) });
      this.hOG = paramg;
      this.key = paramArrayOfByte;
      return;
    }
  }
  
  public static void setProgress(int paramInt)
  {
    y.i("MicroMsg.BakSceneRestoreData", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
  }
  
  public final com.tencent.mm.bv.a auJ()
  {
    return this.hOJ;
  }
  
  public final com.tencent.mm.bv.a auK()
  {
    return this.hOI;
  }
  
  public final boolean auT()
  {
    long l = 524288L;
    y.i("MicroMsg.BakSceneRestoreData", "doSecne");
    int i = this.ebK;
    if (this.hOI.hQW == 2) {
      if (this.ebK - this.offset > 524288L) {
        i = (int)l;
      }
    }
    for (;;)
    {
      this.start = this.offset;
      this.offset = (i + this.start);
      this.hOI.hQY = this.start;
      this.hOI.hQZ = this.offset;
      this.hOI.hRb = progress;
      return super.auT();
      l = this.ebK - this.offset;
      break;
    }
  }
  
  public final int getType()
  {
    return 7;
  }
  
  public final void nF(int paramInt)
  {
    y.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.hOJ.hQV, Integer.valueOf(this.hOJ.hQW), Integer.valueOf(this.hOJ.hQY), Integer.valueOf(this.hOJ.hQZ), Integer.valueOf(this.hOJ.hQq) });
    if ((this.hOJ.hQq != 0) && (this.hOJ.hQq != 10))
    {
      j(4, this.hOJ.hQq, "error");
      return;
    }
    if ((this.hOJ.hQY != this.start) || (this.hOJ.hQZ != this.offset))
    {
      y.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", new Object[] { Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.hOJ.hQY), Integer.valueOf(this.hOJ.hQZ) });
      j(3, -1, "error");
      return;
    }
    this.hOG.a(this.hOI.hQZ - this.hOI.hQY, this.ebK, this);
    byte[] arrayOfByte = this.hOJ.hPF.oY;
    Object localObject;
    boolean bool;
    if (this.key != null)
    {
      localObject = this.key;
      if (this.offset == this.ebK)
      {
        bool = true;
        arrayOfByte = AesEcb.aesCryptEcb(arrayOfByte, (byte[])localObject, false, bool);
      }
    }
    for (;;)
    {
      localObject = this.hOK;
      String str = this.id;
      File localFile = new File((String)localObject + str);
      long l1;
      label337:
      long l2;
      if (localFile.exists())
      {
        l1 = localFile.length();
        e.b((String)localObject, str, arrayOfByte);
        localFile = new File((String)localObject + str);
        if (!localFile.exists()) {
          break label525;
        }
        l2 = localFile.length();
        label391:
        if (l1 == l2)
        {
          y.e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", new Object[] { (String)localObject + str });
          e.b((String)localObject, str, arrayOfByte);
        }
        if (arrayOfByte != null) {
          break label531;
        }
      }
      label525:
      label531:
      for (paramInt = 0;; paramInt = arrayOfByte.length)
      {
        y.i("MicroMsg.BakSceneRestoreData", "onSceneEnd appendbuf len:%d", new Object[] { Integer.valueOf(paramInt) });
        if (this.offset != this.ebK) {
          break label538;
        }
        y.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", new Object[] { this.id, Integer.valueOf(this.ebK) });
        j(0, 0, "success");
        return;
        bool = false;
        break;
        l1 = 0L;
        break label337;
        l2 = 0L;
        break label391;
      }
      label538:
      auT();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.d
 * JD-Core Version:    0.7.0.1
 */