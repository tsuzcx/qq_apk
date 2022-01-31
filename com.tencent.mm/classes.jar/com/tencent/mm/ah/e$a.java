package com.tencent.mm.ah;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.r;

final class e$a
  implements az.a
{
  boolean bak;
  boolean eyq = false;
  h frB;
  String frV;
  String frW;
  boolean frX = true;
  
  public e$a(e parame, h paramh, String paramString1, String paramString2)
  {
    this.frB = paramh;
    this.frV = paramString1;
    this.frW = paramString2;
    this.bak = false;
  }
  
  public final boolean acS()
  {
    AppMethodBeat.i(77905);
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (this.bak)
    {
      com.tencent.mm.plugin.report.service.h.qsU.cT(138, 61);
      ab.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt %s", new Object[] { this.frW });
      localObject1 = UtilsJni.DecryptAvatar(com.tencent.mm.vfs.e.i(this.frW, 0, -1));
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        com.tencent.mm.vfs.e.deleteFile(this.frW);
        com.tencent.mm.vfs.e.b(this.frW, (byte[])localObject1, localObject1.length);
      }
    }
    else
    {
      if (!r.aoZ(this.frW)) {
        break label411;
      }
      this.eyq = true;
      ab.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic start");
      com.tencent.mm.plugin.report.service.h.qsU.cT(138, 63);
      localObject1 = this.frW + "_hevc";
      boolean bool1 = com.tencent.mm.vfs.e.aT(this.frW, (String)localObject1);
      boolean bool2 = com.tencent.mm.vfs.e.avL(this.frW);
      localObject3 = com.tencent.mm.vfs.e.avH(this.frW);
      localObject2 = com.tencent.mm.vfs.e.avH((String)localObject1);
      if ((localObject3 != null) && (localObject2 != null)) {
        break label344;
      }
      ab.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: uri is null %s, %s; path %s, %s; result %s, %s", new Object[] { localObject3, localObject2, this.frW, localObject1, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      com.tencent.mm.plugin.report.service.h.qsU.cT(138, 65);
      localObject1 = com.tencent.mm.vfs.e.i((String)localObject1, 0, -1);
      if (localObject1 != null)
      {
        localObject1 = ((c)g.E(c.class)).aF((byte[])localObject1);
        if (localObject1 != null)
        {
          com.tencent.mm.vfs.e.b(this.frW, (byte[])localObject1, localObject1.length);
          com.tencent.mm.plugin.report.service.h.qsU.cT(138, 66);
        }
      }
    }
    label411:
    for (this.frX = false;; this.frX = false)
    {
      AppMethodBeat.o(77905);
      return true;
      com.tencent.mm.plugin.report.service.h.qsU.cT(138, 62);
      ab.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt failed");
      AppMethodBeat.o(77905);
      return true;
      label344:
      localObject3 = ((Uri)localObject3).getPath();
      localObject2 = ((Uri)localObject2).getPath();
      int i = ((c)g.E(c.class)).nativeWxam2Pic((String)localObject2, (String)localObject3);
      com.tencent.mm.vfs.e.deleteFile((String)localObject1);
      if (i != 0)
      {
        com.tencent.mm.plugin.report.service.h.qsU.cT(138, 64);
        ab.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic failed");
        AppMethodBeat.o(77905);
        return true;
      }
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(77906);
    if (this.frY.frR)
    {
      AppMethodBeat.o(77906);
      return false;
    }
    if (this.frX)
    {
      if ((this.eyq) && (this.frY.frS))
      {
        ab.i("MicroMsg.GetHDHeadImgHelper", "onPostExecute: first request hevc failed");
        this.frY.frS = false;
        this.frY.frT = false;
        this.frY.frU.e(new e.b(this.frY, this.frB));
      }
      for (;;)
      {
        AppMethodBeat.o(77906);
        return false;
        this.frY.frP.cv(3, -1);
      }
    }
    com.tencent.mm.vfs.e.deleteFile(this.frV);
    com.tencent.mm.vfs.e.aT(this.frW, this.frV);
    k.az(this.frV, this.frB.getUsername());
    this.frY.frP.cv(0, 0);
    AppMethodBeat.o(77906);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ah.e.a
 * JD-Core Version:    0.7.0.1
 */