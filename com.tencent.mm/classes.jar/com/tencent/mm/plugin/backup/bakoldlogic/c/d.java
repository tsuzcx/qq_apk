package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.g;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.i.ad;
import com.tencent.mm.plugin.backup.i.ae;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

public final class d
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  private int fsd;
  public String id;
  private g jIi;
  private ad jIk;
  private ae jIl;
  private String jIm;
  private byte[] key;
  private int offset;
  private int start;
  
  public d(String paramString1, String paramString2, int paramInt1, int paramInt2, g paramg, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17887);
    this.jIk = new ad();
    this.jIl = new ae();
    this.jIi = null;
    this.start = 0;
    this.offset = 0;
    if (paramInt1 == 1) {}
    for (this.jIm = (paramString1 + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.Gi(paramString2));; this.jIm = (paramString1 + "backupMeida/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.Gi(paramString2)))
    {
      this.id = paramString2;
      this.jIk.jKw = paramString2;
      this.jIk.jKx = paramInt1;
      this.fsd = paramInt2;
      ab.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", new Object[] { this.jIk.jKw, Integer.valueOf(this.jIk.jKx), Integer.valueOf(this.fsd) });
      this.jIi = paramg;
      this.key = paramArrayOfByte;
      AppMethodBeat.o(17887);
      return;
    }
  }
  
  public static void setProgress(int paramInt)
  {
    AppMethodBeat.i(17889);
    ab.i("MicroMsg.BakSceneRestoreData", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
    AppMethodBeat.o(17889);
  }
  
  public final com.tencent.mm.bv.a aUl()
  {
    return this.jIl;
  }
  
  public final com.tencent.mm.bv.a aUm()
  {
    return this.jIk;
  }
  
  public final boolean aUv()
  {
    long l = 524288L;
    AppMethodBeat.i(17888);
    ab.i("MicroMsg.BakSceneRestoreData", "doSecne");
    int i = this.fsd;
    if (this.jIk.jKx == 2) {
      if (this.fsd - this.offset > 524288L) {
        i = (int)l;
      }
    }
    for (;;)
    {
      this.start = this.offset;
      this.offset = (i + this.start);
      this.jIk.jKz = this.start;
      this.jIk.jKA = this.offset;
      this.jIk.jKC = progress;
      boolean bool = super.aUv();
      AppMethodBeat.o(17888);
      return bool;
      l = this.fsd - this.offset;
      break;
    }
  }
  
  public final int getType()
  {
    return 7;
  }
  
  public final void rt(int paramInt)
  {
    AppMethodBeat.i(17890);
    ab.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.jIl.jKw, Integer.valueOf(this.jIl.jKx), Integer.valueOf(this.jIl.jKz), Integer.valueOf(this.jIl.jKA), Integer.valueOf(this.jIl.jJS) });
    if ((this.jIl.jJS != 0) && (this.jIl.jJS != 10))
    {
      n(4, this.jIl.jJS, "error");
      AppMethodBeat.o(17890);
      return;
    }
    if ((this.jIl.jKz != this.start) || (this.jIl.jKA != this.offset))
    {
      ab.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", new Object[] { Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.jIl.jKz), Integer.valueOf(this.jIl.jKA) });
      n(3, -1, "error");
      AppMethodBeat.o(17890);
      return;
    }
    this.jIi.a(this.jIk.jKA - this.jIk.jKz, this.fsd, this);
    byte[] arrayOfByte = this.jIl.jJh.pW;
    Object localObject;
    boolean bool;
    if (this.key != null)
    {
      localObject = this.key;
      if (this.offset == this.fsd)
      {
        bool = true;
        arrayOfByte = AesEcb.aesCryptEcb(arrayOfByte, (byte[])localObject, false, bool);
      }
    }
    for (;;)
    {
      localObject = this.jIm;
      String str = this.id;
      File localFile = new File((String)localObject + str);
      long l1;
      label355:
      long l2;
      if (localFile.exists())
      {
        l1 = localFile.length();
        e.b((String)localObject, str, arrayOfByte);
        localFile = new File((String)localObject + str);
        if (!localFile.exists()) {
          break label549;
        }
        l2 = localFile.length();
        label409:
        if (l1 == l2)
        {
          ab.e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", new Object[] { (String)localObject + str });
          e.b((String)localObject, str, arrayOfByte);
        }
        if (arrayOfByte != null) {
          break label555;
        }
      }
      label549:
      label555:
      for (paramInt = 0;; paramInt = arrayOfByte.length)
      {
        ab.i("MicroMsg.BakSceneRestoreData", "onSceneEnd appendbuf len:%d", new Object[] { Integer.valueOf(paramInt) });
        if (this.offset != this.fsd) {
          break label562;
        }
        ab.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", new Object[] { this.id, Integer.valueOf(this.fsd) });
        n(0, 0, "success");
        AppMethodBeat.o(17890);
        return;
        bool = false;
        break;
        l1 = 0L;
        break label355;
        l2 = 0L;
        break label409;
      }
      label562:
      aUv();
      AppMethodBeat.o(17890);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.d
 * JD-Core Version:    0.7.0.1
 */