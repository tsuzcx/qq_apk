package com.tencent.mm.bh;

import android.os.HandlerThread;
import com.tencent.mm.ah.e.d;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.kq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.List;

public class d
  implements ar
{
  public static int[] eFc = new int[1000];
  public static int num = 0;
  private final long TIME_INTERVAL = 259200000L;
  private final int bxE = 0;
  private e eEZ = new e();
  private b eFa = new b();
  private final int eFb = 2;
  private com.tencent.mm.sdk.b.c eFd = new d.1(this);
  
  public static ay RX()
  {
    g.DN().CX();
    aw localaw = RY();
    ay localay = (ay)((j)g.r(j.class)).bhN();
    localay.a(localaw, g.DS().mnU.getLooper());
    return localay;
  }
  
  public static aw RY()
  {
    g.DN().CX();
    return (aw)((j)g.r(j.class)).bhM();
  }
  
  public static bg RZ()
  {
    g.DN().CX();
    return (bg)((j)g.r(j.class)).bhL();
  }
  
  public static bu Sa()
  {
    g.DN().CX();
    return (bu)((j)g.r(j.class)).bhK();
  }
  
  public static void a(cd paramcd, bi.d paramd)
  {
    y.d("MicroMsg.SubCoreVerify", "saveToLbsVerifyStg, cmdAM, status = " + paramcd.hQq + ", id = " + paramcd.ndp);
    bf localbf = new bf();
    localbf.field_content = aa.a(paramcd.svH);
    localbf.field_createtime = bk.UX();
    localbf.field_imgpath = "";
    localbf.field_sayhicontent = paramd.content;
    localbf.field_sayhiuser = paramd.pyp;
    localbf.field_scene = paramd.scene;
    if (paramcd.hQq > 3) {}
    for (int i = paramcd.hQq;; i = 3)
    {
      localbf.field_status = i;
      localbf.field_svrid = paramcd.ndp;
      localbf.field_talker = aa.a(paramcd.svF);
      localbf.field_type = paramcd.kSW;
      localbf.field_isSend = 0;
      localbf.field_sayhiencryptuser = paramd.uCl;
      localbf.field_ticket = paramd.kzG;
      localbf.field_flag = 1;
      ((bg)((j)g.r(j.class)).bhL()).a(localbf);
      com.tencent.mm.ag.b.M(localbf.field_sayhiencryptuser, 3);
      return;
    }
  }
  
  public static void b(cd paramcd, bi.d paramd)
  {
    y.d("MicroMsg.SubCoreVerify", "saveToShakeVerifyStg, cmdAM, status = " + paramcd.hQq + ", id = " + paramcd.ndp);
    bt localbt = new bt();
    localbt.field_content = aa.a(paramcd.svH);
    localbt.field_createtime = bk.UX();
    localbt.field_imgpath = "";
    localbt.field_sayhicontent = paramd.content;
    localbt.field_sayhiuser = paramd.pyp;
    localbt.field_scene = paramd.scene;
    if (paramcd.hQq > 3) {}
    for (int i = paramcd.hQq;; i = 3)
    {
      localbt.field_status = i;
      localbt.field_svrid = paramcd.ndp;
      localbt.field_talker = aa.a(paramcd.svF);
      localbt.field_type = paramcd.kSW;
      localbt.field_isSend = 0;
      ((bu)((j)g.r(j.class)).bhK()).a(localbt);
      com.tencent.mm.ag.b.M(localbt.field_sayhiuser, 3);
      return;
    }
  }
  
  public final void bh(boolean paramBoolean)
  {
    e.d.a(Integer.valueOf(37), this.eEZ);
    e.d.a(Integer.valueOf(65), this.eEZ);
    e.d.a(Integer.valueOf(40), this.eFa);
    com.tencent.mm.sdk.b.a.udP.c(this.eFd);
    int i = RY().cuU();
    long l = System.currentTimeMillis();
    au.Hx();
    l -= bk.a((Long)com.tencent.mm.model.c.Dz().get(340225, null), 0L);
    y.i("MicroMsg.SubCoreVerify", "timeInterval = " + l);
    if ((l > 259200000L) && (i > 0))
    {
      Object localObject = RY().cuV();
      int j = ((List)localObject).size();
      if (j > 0)
      {
        String str = (String)((List)localObject).get(0);
        i = 1;
        while (i < j)
        {
          str = str + ", " + (String)((List)localObject).get(i);
          i += 1;
        }
        y.i("MicroMsg.SubCoreVerify", "title = " + str);
        localObject = new kq();
        ((kq)localObject).bTH.userName = null;
        ((kq)localObject).bTH.aVr = str;
        ((kq)localObject).bTH.type = 0;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
        au.Hx();
        com.tencent.mm.model.c.Dz().o(340225, Long.valueOf(System.currentTimeMillis()));
      }
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    e.d.b(Integer.valueOf(37), this.eEZ);
    e.d.b(Integer.valueOf(65), this.eEZ);
    e.d.b(Integer.valueOf(40), this.eFa);
    com.tencent.mm.sdk.b.a.udP.d(this.eFd);
    au.getNotification().wp();
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bh.d
 * JD-Core Version:    0.7.0.1
 */