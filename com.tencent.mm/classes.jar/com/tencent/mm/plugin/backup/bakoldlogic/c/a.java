package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends com.tencent.mm.plugin.backup.g.b
{
  final byte[] key;
  final int uWc;
  private v vct;
  private w vcu;
  final String vfA;
  private boolean vfB;
  final String vfz;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    AppMethodBeat.i(21936);
    this.vct = new v();
    this.vcu = new w();
    this.vfB = false;
    Log.i("MicroMsg.BakOldAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", new Object[] { paramString3, paramString1, paramString2, Util.getStack() });
    this.vct.vgA = new com.tencent.mm.bx.b(l.e(paramString1.getBytes(), paramArrayOfByte));
    this.vct.vhI = 0;
    this.vct.vgy = paramString3;
    this.vct.crz = 0;
    this.vfz = paramString2;
    this.vfA = paramString3;
    this.key = paramArrayOfByte;
    this.uWc = -1;
    AppMethodBeat.o(21936);
  }
  
  public final void Fo(int paramInt)
  {
    AppMethodBeat.i(21937);
    if (this.vcu.vhk == 0)
    {
      if (this.vfA.equals(this.vcu.vgy))
      {
        String str = new String(l.d(this.vcu.vgA.Op, this.key));
        if (str.length() != this.vfz.length()) {}
        for (boolean bool = false;; bool = str.equals(this.vfz))
        {
          this.vfB = bool;
          Log.i("MicroMsg.BakOldAuthScene", "check ok result:%b", new Object[] { Boolean.valueOf(this.vfB) });
          if (!this.vfB) {
            break;
          }
          u(0, 0, "auth ok");
          this.vct.vgA = new com.tencent.mm.bx.b(l.e(this.vfz.getBytes(), this.key));
          this.vct.vhI = 1;
          this.vct.vgy = this.vfA;
          try
          {
            Log.i("MicroMsg.BakOldAuthScene", "directSendAuthOk");
            com.tencent.mm.plugin.backup.g.b.D(this.vct.toByteArray(), getType(), paramInt);
            AppMethodBeat.o(21937);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.BakOldAuthScene", localException, "directSendAuthOk req to bur err.", new Object[0]);
            AppMethodBeat.o(21937);
            return;
          }
        }
        Log.e("MicroMsg.BakOldAuthScene", "check ok failed");
        u(4, 1, "not ok packet");
        AppMethodBeat.o(21937);
        return;
      }
      Log.e("MicroMsg.BakOldAuthScene", "not the same id");
      u(4, -1, "not the same id");
      AppMethodBeat.o(21937);
      return;
    }
    Log.e("MicroMsg.BakOldAuthScene", "errType %d", new Object[] { Integer.valueOf(this.vcu.vhk) });
    u(4, this.vcu.vhk, "not not success");
    AppMethodBeat.o(21937);
  }
  
  public final com.tencent.mm.bx.a cWm()
  {
    return this.vcu;
  }
  
  public final com.tencent.mm.bx.a cWn()
  {
    return this.vct;
  }
  
  public final int getType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.a
 * JD-Core Version:    0.7.0.1
 */