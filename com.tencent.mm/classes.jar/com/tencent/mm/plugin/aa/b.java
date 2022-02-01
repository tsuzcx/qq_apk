package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.e.a;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.g.a.yt;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.aa.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.al;
import com.tencent.mm.vending.g.d.a;
import java.util.HashMap;
import java.util.Map;

public class b
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.sdk.b.c<pv> iRI;
  private com.tencent.mm.sdk.b.c<pu> iRJ;
  private com.tencent.mm.sdk.b.c<ca> iRK;
  private com.tencent.mm.sdk.b.c<cb> iRL;
  private q iRM;
  com.tencent.mm.sdk.b.c<yt> iRN;
  private com.tencent.mm.plugin.aa.model.a.d iRO;
  private com.tencent.mm.plugin.aa.model.a.b iRP;
  
  static
  {
    AppMethodBeat.i(63318);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("AARecord".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.aa.model.a.d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("AAPayRecord".hashCode()), new b.8());
    AppMethodBeat.o(63318);
  }
  
  public b()
  {
    AppMethodBeat.i(63312);
    this.iRI = new b.1(this);
    this.iRJ = new com.tencent.mm.sdk.b.c() {};
    this.iRK = new com.tencent.mm.sdk.b.c() {};
    this.iRL = new com.tencent.mm.sdk.b.c() {};
    this.iRM = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, e.a paramAnonymousa)
      {
        AppMethodBeat.i(63310);
        int i = bt.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.PayMsgType"), 0);
        ad.d("MicroMsg.SubCoreAA", "paymsgtype: %d, current version: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.protocal.d.Fnj) });
        int i1;
        int n;
        int m;
        int k;
        int j;
        if (i == 32)
        {
          i = bt.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.receiveorpayreddot"), -1);
          i1 = bt.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.grouppayreddot"), -1);
          n = bt.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.facingreceivereddot"), -1);
          m = bt.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.f2fhongbaoreddot"), -1);
          k = bt.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.rewardcodereddot"), -1);
          j = bt.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.android_minclientversion"), -1);
          paramAnonymousString = bt.bI((String)paramAnonymousMap.get(".sysmsg.paymsg.facingreceivereddotwording"), "");
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAY, paramAnonymousString);
          ad.i("MicroMsg.SubCoreAA", "recvOrPay: %s, aa: %s, collect： %s, f2fhb: %s, qrreward: %s, version： %s", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j) });
          if (com.tencent.mm.protocal.d.Fnj >= j)
          {
            j = 0;
            if (i != 1) {
              break label436;
            }
            ad.i("MicroMsg.SubCoreAA", "mark recv or pay red dot");
            com.tencent.mm.z.c.aht().x(262159, true);
            if (i1 != 1) {
              break label453;
            }
            ad.i("MicroMsg.SubCoreAA", "mark group pay red dot");
            com.tencent.mm.z.c.aht().b(al.a.IBI, true);
            i = 1;
            label312:
            if (n != 1) {
              break label479;
            }
            ad.i("MicroMsg.SubCoreAA", "mark f2f recv red dot");
            com.tencent.mm.z.c.aht().b(al.a.IBJ, true);
            j = 1;
            label338:
            if (m != 1) {
              break label505;
            }
            ad.i("MicroMsg.SubCoreAA", "mark f2f hb red dot");
            com.tencent.mm.z.c.aht().b(al.a.IBK, true);
            i = 1;
            label364:
            if (k != 1) {
              break label531;
            }
            ad.i("MicroMsg.SubCoreAA", "mark qr reward red dot");
            com.tencent.mm.z.c.aht().b(al.a.IBL, true);
            j = 1;
          }
        }
        for (;;)
        {
          if (j != 0) {
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBN, Boolean.FALSE);
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(14396, new Object[] { Integer.valueOf(1) });
          AppMethodBeat.o(63310);
          return;
          label436:
          if (i != 0) {
            break;
          }
          com.tencent.mm.z.c.aht().x(262159, false);
          break;
          label453:
          i = j;
          if (i1 != 0) {
            break label312;
          }
          com.tencent.mm.z.c.aht().b(al.a.IBI, false);
          i = j;
          break label312;
          label479:
          j = i;
          if (n != 0) {
            break label338;
          }
          com.tencent.mm.z.c.aht().b(al.a.IBJ, false);
          j = i;
          break label338;
          label505:
          i = j;
          if (m != 0) {
            break label364;
          }
          com.tencent.mm.z.c.aht().b(al.a.IBK, false);
          i = j;
          break label364;
          label531:
          j = i;
          if (k == 0)
          {
            com.tencent.mm.z.c.aht().b(al.a.IBL, false);
            j = i;
          }
        }
      }
    };
    this.iRN = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(63312);
  }
  
  private static b aQV()
  {
    AppMethodBeat.i(63313);
    b localb = (b)t.ap(b.class);
    AppMethodBeat.o(63313);
    return localb;
  }
  
  public static com.tencent.mm.plugin.aa.model.a.d aQW()
  {
    AppMethodBeat.i(63314);
    if (aQV().iRO == null)
    {
      localObject = aQV();
      com.tencent.mm.kernel.g.ajD();
      ((b)localObject).iRO = new com.tencent.mm.plugin.aa.model.a.d(com.tencent.mm.kernel.g.ajC().gBq);
    }
    Object localObject = aQV().iRO;
    AppMethodBeat.o(63314);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.aa.model.a.b aQX()
  {
    AppMethodBeat.i(63315);
    if (aQV().iRP == null)
    {
      localObject = aQV();
      com.tencent.mm.kernel.g.ajD();
      ((b)localObject).iRP = new com.tencent.mm.plugin.aa.model.a.b(com.tencent.mm.kernel.g.ajC().gBq);
    }
    Object localObject = aQV().iRP;
    AppMethodBeat.o(63315);
    return localObject;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(63316);
    com.tencent.mm.sdk.b.a.IbL.c(this.iRI);
    com.tencent.mm.sdk.b.a.IbL.c(this.iRJ);
    com.tencent.mm.sdk.b.a.IbL.c(this.iRK);
    com.tencent.mm.sdk.b.a.IbL.c(this.iRL);
    com.tencent.mm.sdk.b.a.IbL.c(this.iRN);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("paymsg", this.iRM);
    com.tencent.mm.model.e.a(new com.tencent.mm.plugin.messenger.foundation.a.a()
    {
      public final void a(e.a paramAnonymousa, bu paramAnonymousbu, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(184836);
        if ((!paramAnonymousBoolean) && (paramAnonymousbu != null) && (!bt.isNullOrNil(paramAnonymousbu.field_content))) {
          if (!al.isDarkMode()) {
            break label73;
          }
        }
        label73:
        for (paramAnonymousa = "#7D90A9";; paramAnonymousa = "#576B95")
        {
          paramAnonymousbu.setContent(paramAnonymousbu.field_content.replace("color=\"#037AFF\"", "color=\"" + paramAnonymousa + "\""));
          AppMethodBeat.o(184836);
          return;
        }
      }
      
      public final void b(e.a paramAnonymousa, bu paramAnonymousbu, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(63316);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63317);
    com.tencent.mm.sdk.b.a.IbL.d(this.iRI);
    com.tencent.mm.sdk.b.a.IbL.d(this.iRJ);
    com.tencent.mm.sdk.b.a.IbL.d(this.iRK);
    com.tencent.mm.sdk.b.a.IbL.d(this.iRL);
    com.tencent.mm.sdk.b.a.IbL.d(this.iRN);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("paymsg", this.iRM);
    AppMethodBeat.o(63317);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.b
 * JD-Core Version:    0.7.0.1
 */