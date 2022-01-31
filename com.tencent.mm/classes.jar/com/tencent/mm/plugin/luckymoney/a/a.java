package com.tencent.mm.plugin.luckymoney.a;

import android.text.TextUtils;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.tx;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.luckymoney.b.aj;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.pluginsdk.model.app.aq;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class a
  implements ar
{
  private bx.a iGD = new bx.a()
  {
    public final void a(e.a paramAnonymousa)
    {
      Object localObject1 = bn.s(aa.a(paramAnonymousa.dBs.svH), "sysmsg");
      y.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
      if (localObject1 == null) {
        y.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
      }
      Object localObject2;
      do
      {
        do
        {
          do
          {
            return;
          } while (!"14".equals((String)((Map)localObject1).get(".sysmsg.paymsg.PayMsgType")));
          paramAnonymousa = URLDecoder.decode((String)((Map)localObject1).get(".sysmsg.paymsg.appmsgcontent"));
          if (TextUtils.isEmpty(paramAnonymousa))
          {
            y.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
            return;
          }
          localObject2 = bn.s(paramAnonymousa, "msg");
          if (localObject2 == null)
          {
            y.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (bk.bl((String)localObject2))
          {
            y.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
            return;
          }
          localObject1 = (String)((Map)localObject1).get(".sysmsg.paymsg.tousername");
          if ((bk.bl(paramAnonymousa)) || (bk.bl((String)localObject1)))
          {
            y.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
            return;
          }
        } while (!a.this.bfj().GL((String)localObject2));
        y.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
      } while (o.C(paramAnonymousa, (String)localObject1, 1));
      a.this.bfj().GM((String)localObject2);
    }
  };
  private com.tencent.mm.plugin.luckymoney.b.e lKM;
  private com.tencent.mm.plugin.luckymoney.b.g lKN;
  private com.tencent.mm.plugin.luckymoney.b.c lKO = new com.tencent.mm.plugin.luckymoney.b.c();
  private aj lKP;
  private com.tencent.mm.sdk.b.c<tx> lKQ = new a.2(this);
  
  public a()
  {
    File localFile = new File(bfi());
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    localFile = new File(com.tencent.mm.compatible.util.e.dzM);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
  }
  
  public static a bfg()
  {
    return (a)com.tencent.mm.model.p.B(a.class);
  }
  
  public static com.tencent.mm.plugin.luckymoney.b.e bfh()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bfg().lKM == null) {
      bfg().lKM = new com.tencent.mm.plugin.luckymoney.b.e();
    }
    return bfg().lKM;
  }
  
  public static String bfi()
  {
    if (com.tencent.mm.kernel.g.DK()) {
      return com.tencent.mm.plugin.n.c.FG() + "luckymoney";
    }
    return "";
  }
  
  public final com.tencent.mm.plugin.luckymoney.b.g bfj()
  {
    try
    {
      if (this.lKN == null) {
        this.lKN = new com.tencent.mm.plugin.luckymoney.b.g();
      }
      com.tencent.mm.plugin.luckymoney.b.g localg = this.lKN;
      return localg;
    }
    finally {}
  }
  
  public final void bh(boolean paramBoolean)
  {
    aq localaq = aq.clf();
    if (com.tencent.mm.kernel.g.DK())
    {
      com.tencent.mm.plugin.z.a.brq().a(4, localaq);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(1060, localaq);
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", this.iGD, true);
    boolean bool = false;
    com.tencent.mm.kernel.g.DQ();
    long l = com.tencent.mm.kernel.g.DP().Dz().Fm(352276);
    if (System.currentTimeMillis() - l >= 43200000L) {
      bool = true;
    }
    y.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + bool + ", isUpdate=" + paramBoolean);
    if ((paramBoolean) || (bool))
    {
      y.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
      aq.clf().eT(ae.getContext());
    }
    com.tencent.mm.sdk.b.a.udP.c(this.lKO);
    com.tencent.mm.sdk.b.a.udP.c(this.lKQ);
    this.lKP = new aj();
    com.tencent.mm.plugin.luckymoney.b.b.bfF();
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    Object localObject1 = aq.clf();
    if (com.tencent.mm.kernel.g.DK())
    {
      com.tencent.mm.plugin.z.a.brq().b(4, (t)localObject1);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.b(1060, (f)localObject1);
      ((aq)localObject1).rVq = false;
      ((aq)localObject1).rVr = false;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", this.iGD, true);
    try
    {
      this.lKN = null;
      com.tencent.mm.sdk.b.a.udP.d(this.lKO);
      com.tencent.mm.sdk.b.a.udP.d(this.lKQ);
      if (this.lKP != null)
      {
        localObject1 = this.lKP;
        com.tencent.mm.sdk.b.a.udP.d(((aj)localObject1).lRT);
        if (((aj)localObject1).lRQ != null)
        {
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DO().dJT.c(((aj)localObject1).lRQ);
          ((aj)localObject1).lRQ = null;
        }
        if (((aj)localObject1).lRR != null)
        {
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DO().dJT.c(((aj)localObject1).lRR);
          ((aj)localObject1).lRR = null;
        }
      }
      com.tencent.mm.plugin.luckymoney.b.b.Vt();
      return;
    }
    finally {}
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.a
 * JD-Core Version:    0.7.0.1
 */