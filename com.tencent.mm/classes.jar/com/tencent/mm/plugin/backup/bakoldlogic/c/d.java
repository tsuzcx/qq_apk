package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.i;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.i.ad;
import com.tencent.mm.plugin.backup.i.ae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public final class d
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  public String id;
  private byte[] key;
  private int offset;
  private int osy;
  private int start;
  private i vfE;
  private ad vfG;
  private ae vfH;
  private String vfI;
  
  public d(String paramString1, String paramString2, int paramInt1, int paramInt2, i parami, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21944);
    this.vfG = new ad();
    this.vfH = new ae();
    this.vfE = null;
    this.start = 0;
    this.offset = 0;
    if (paramInt1 == 1) {}
    for (this.vfI = (paramString1 + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.ahL(paramString2));; this.vfI = (paramString1 + "backupMeida/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.ahL(paramString2)))
    {
      this.id = paramString2;
      this.vfG.vhN = paramString2;
      this.vfG.vhO = paramInt1;
      this.osy = paramInt2;
      Log.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", new Object[] { this.vfG.vhN, Integer.valueOf(this.vfG.vhO), Integer.valueOf(this.osy) });
      this.vfE = parami;
      this.key = paramArrayOfByte;
      AppMethodBeat.o(21944);
      return;
    }
  }
  
  public static void setProgress(int paramInt)
  {
    AppMethodBeat.i(21946);
    Log.i("MicroMsg.BakSceneRestoreData", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
    AppMethodBeat.o(21946);
  }
  
  public final void Fo(int paramInt)
  {
    AppMethodBeat.i(21947);
    Log.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.vfH.vhN, Integer.valueOf(this.vfH.vhO), Integer.valueOf(this.vfH.vhQ), Integer.valueOf(this.vfH.vhR), Integer.valueOf(this.vfH.vhk) });
    if ((this.vfH.vhk != 0) && (this.vfH.vhk != 10))
    {
      u(4, this.vfH.vhk, "error");
      AppMethodBeat.o(21947);
      return;
    }
    if ((this.vfH.vhQ != this.start) || (this.vfH.vhR != this.offset))
    {
      Log.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", new Object[] { Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.vfH.vhQ), Integer.valueOf(this.vfH.vhR) });
      u(3, -1, "error");
      AppMethodBeat.o(21947);
      return;
    }
    this.vfE.a(this.vfG.vhR - this.vfG.vhQ, this.osy, this);
    byte[] arrayOfByte = this.vfH.vgA.Op;
    Object localObject;
    boolean bool;
    if (this.key != null)
    {
      localObject = this.key;
      if (this.offset == this.osy)
      {
        bool = true;
        arrayOfByte = AesEcb.aesCryptEcb(arrayOfByte, (byte[])localObject, false, bool);
      }
    }
    for (;;)
    {
      localObject = this.vfI;
      String str = this.id;
      u localu = new u((String)localObject + str);
      long l1;
      label355:
      long l2;
      if (localu.jKS())
      {
        l1 = localu.length();
        y.e((String)localObject + str, arrayOfByte, arrayOfByte.length);
        localu = new u((String)localObject + str);
        if (!localu.jKS()) {
          break label587;
        }
        l2 = localu.length();
        label428:
        if (l1 == l2)
        {
          Log.e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", new Object[] { (String)localObject + str });
          y.e((String)localObject + str, arrayOfByte, arrayOfByte.length);
        }
        if (arrayOfByte != null) {
          break label593;
        }
      }
      label587:
      label593:
      for (paramInt = 0;; paramInt = arrayOfByte.length)
      {
        Log.i("MicroMsg.BakSceneRestoreData", "onSceneEnd appendbuf len:%d", new Object[] { Integer.valueOf(paramInt) });
        if (this.offset != this.osy) {
          break label600;
        }
        Log.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", new Object[] { this.id, Integer.valueOf(this.osy) });
        u(0, 0, "success");
        AppMethodBeat.o(21947);
        return;
        bool = false;
        break;
        l1 = 0L;
        break label355;
        l2 = 0L;
        break label428;
      }
      label600:
      cWw();
      AppMethodBeat.o(21947);
      return;
    }
  }
  
  public final com.tencent.mm.bx.a cWm()
  {
    return this.vfH;
  }
  
  public final com.tencent.mm.bx.a cWn()
  {
    return this.vfG;
  }
  
  public final boolean cWw()
  {
    long l = 524288L;
    AppMethodBeat.i(21945);
    Log.i("MicroMsg.BakSceneRestoreData", "doSecne");
    int i = this.osy;
    if (this.vfG.vhO == 2) {
      if (this.osy - this.offset > 524288L) {
        i = (int)l;
      }
    }
    for (;;)
    {
      this.start = this.offset;
      this.offset = (i + this.start);
      this.vfG.vhQ = this.start;
      this.vfG.vhR = this.offset;
      this.vfG.vhT = progress;
      boolean bool = super.cWw();
      AppMethodBeat.o(21945);
      return bool;
      l = this.osy - this.offset;
      break;
    }
  }
  
  public final int getType()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.d
 * JD-Core Version:    0.7.0.1
 */