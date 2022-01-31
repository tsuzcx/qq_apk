package com.tencent.mm.ag;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.HashMap;

public class o
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private i ecn;
  private d eco;
  private c ecp;
  private g ecq;
  private am ecr = new am(com.tencent.mm.kernel.g.DS().mnU.getLooper(), new am.a()
  {
    public final boolean tC()
    {
      if ((!com.tencent.mm.kernel.g.DN().Dc()) || (o.JQ() == null))
      {
        y.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.DN().Dc()), o.JQ() });
        return false;
      }
      if (((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(90113, Boolean.valueOf(false))).booleanValue())
      {
        o.Kl();
        o.Kk();
      }
      com.tencent.mm.kernel.g.DP().Dz().o(90113, Boolean.valueOf(false));
      return false;
    }
    
    public final String toString()
    {
      return super.toString() + "|upAssetsHandler";
    }
  }, false);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("IMG_FLAG_TABLE".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return i.dXp;
      }
    });
    dgp.put(Integer.valueOf("HDHEADIMGINFO_TABLE".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return g.dXp;
      }
    });
  }
  
  public static d JQ()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Kg().eco == null) {
      Kg().eco = new d();
    }
    return Kg().eco;
  }
  
  public static o Kg()
  {
    return (o)com.tencent.mm.model.p.B(o.class);
  }
  
  public static i Kh()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Kg().ecn == null) {
      Kg().ecn = new i(com.tencent.mm.kernel.g.DP().dKu);
    }
    return Kg().ecn;
  }
  
  public static g Ki()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Kg().ecq == null) {
      Kg().ecq = new g(com.tencent.mm.kernel.g.DP().dKu);
    }
    return Kg().ecq;
  }
  
  public static c Kj()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (Kg().ecp == null) {
      Kg().ecp = new c();
    }
    return Kg().ecp;
  }
  
  public static boolean Kk()
  {
    if (bk.a((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(59, null), false)) {
      return true;
    }
    JQ();
    String str = d.z(q.Gj(), false);
    if ((com.tencent.mm.vfs.e.bK(str)) || (com.tencent.mm.vfs.e.bK(str + ".bm"))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    str = q.Gj();
    if (bk.bl(str)) {
      return false;
    }
    Bitmap localBitmap = d.b.km(com.tencent.mm.plugin.n.c.FG() + "user_" + com.tencent.mm.a.g.o(str.getBytes()) + ".png");
    if ((localBitmap == null) || (localBitmap.isRecycled())) {
      return false;
    }
    return JQ().e(str, localBitmap);
  }
  
  static Context getContext()
  {
    return ae.getContext();
  }
  
  public final void bh(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      y.d("MicroMsg.SubCoreAvatar", "update all plugin avatars");
      com.tencent.mm.kernel.g.DP().Dz().o(90113, Boolean.valueOf(true));
    }
    try
    {
      String str = q.Gj();
      d locald = JQ();
      d.B(str, false);
      d.B(str, true);
      locald.d(str, null);
      this.ecr.S(10000L, 10000L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.SubCoreAvatar", localException, "Failed to refresh avatar.", new Object[0]);
      }
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    this.ecr.stopTimer();
    if (Kg().eco != null) {
      d.reset();
    }
    Object localObject = Kg().ecp;
    if (localObject != null) {
      com.tencent.mm.kernel.g.Dk().b(123, (com.tencent.mm.ah.f)localObject);
    }
    localObject = Kg().ecn;
    if (localObject != null) {
      ((i)localObject).ebW.clear();
    }
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.o
 * JD-Core Version:    0.7.0.1
 */