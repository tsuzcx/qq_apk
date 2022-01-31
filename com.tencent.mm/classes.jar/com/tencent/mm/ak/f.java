package com.tencent.mm.ak;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ah.c;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Random;

public class f
  implements ar
{
  private a ejt = null;
  private b eju = null;
  private c ejv;
  private long ejw = 0L;
  private ah ejx = new f.2(this, Looper.getMainLooper());
  private com.tencent.mm.ah.f ejy = new f.3(this);
  
  public static f Na()
  {
    return (f)com.tencent.mm.model.p.B(f.class);
  }
  
  public static String Nb()
  {
    com.tencent.mm.kernel.g.DN().CX();
    return com.tencent.mm.kernel.g.DP().cachePath + "cdndnsinfo/";
  }
  
  public static c Nc()
  {
    return Na().ejv;
  }
  
  public static b Nd()
  {
    if (Na().eju == null) {}
    try
    {
      if (Na().eju == null) {
        Na().eju = new b();
      }
      return Na().eju;
    }
    finally {}
  }
  
  public static a Ne()
  {
    if (Na().ejt == null)
    {
      com.tencent.mm.kernel.g.DN();
      if (!com.tencent.mm.kernel.a.Db()) {
        break label48;
      }
    }
    label48:
    String str;
    for (Na().ejt = new a(com.tencent.mm.kernel.g.DP().cachePath, Nd());; Na().ejt = new a(str, Nd()))
    {
      return Na().ejt;
      str = com.tencent.mm.a.g.o(("mm" + new Random().nextLong()).getBytes());
      str = ac.dOP + str + "/";
      y.v("MicroMsg.SubCoreCdnTransport", "hy: cdn temp path: %s", new Object[] { str });
    }
  }
  
  public final void Nf()
  {
    is(0);
  }
  
  public final void bh(boolean paramBoolean)
  {
    onAccountRelease();
    com.tencent.mm.kernel.g.DN().CX();
    if (Na().eju == null)
    {
      Na().eju = new b();
      y.i("MicroMsg.SubCoreCdnTransport", "summersafecdn onAccountPostReset new CdnTransportService hash[%s]", new Object[] { Integer.valueOf(Na().eju.hashCode()) });
    }
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(Nb());
    if (!localb.exists()) {
      localb.mkdirs();
    }
    this.ejv = new f.1(this);
    com.tencent.mm.kernel.g.Dk().a(379, this.ejy);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void is(int paramInt)
  {
    this.ejw = 0L;
    this.ejx.removeMessages(1);
    com.tencent.mm.kernel.g.Dk().a(new d(paramInt), 0);
  }
  
  public final void onAccountRelease()
  {
    this.ejv = null;
    Object localObject;
    if (this.ejt != null)
    {
      localObject = this.ejt;
      CdnLogic.setCallBack(null);
      ((a)localObject).eiv = null;
      this.ejt = null;
    }
    if (this.eju != null)
    {
      localObject = this.eju;
      if (com.tencent.mm.kernel.g.DN().Dc()) {
        com.tencent.mm.kernel.g.DP().Dz().b((m.b)localObject);
      }
      ((b)localObject).eiD.removeCallbacksAndMessages(null);
      com.tencent.mm.kernel.g.DO().b(((b)localObject).eiF);
      com.tencent.mm.kernel.g.DO().dJT.b(379, (com.tencent.mm.ah.f)localObject);
      com.tencent.mm.sdk.b.a.udP.d(((b)localObject).eiE);
      this.eju = null;
    }
    this.ejw = 0L;
    this.ejx.removeCallbacksAndMessages(null);
    com.tencent.mm.kernel.g.Dk().b(379, this.ejy);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ak.f
 * JD-Core Version:    0.7.0.1
 */