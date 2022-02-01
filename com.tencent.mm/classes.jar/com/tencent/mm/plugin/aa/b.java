package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.g.a.aae;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.aa.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vending.g.d.a;
import java.util.HashMap;
import java.util.Map;

public class b
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  IListener<aae> jRA;
  private com.tencent.mm.plugin.aa.model.a.d jRB;
  private com.tencent.mm.plugin.aa.model.a.b jRC;
  private IListener<qq> jRv;
  private IListener<qp> jRw;
  private IListener<cc> jRx;
  private IListener<cd> jRy;
  private q jRz;
  
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
    baseDBFactories.put(Integer.valueOf("AAPayRecord".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.aa.model.a.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(63318);
  }
  
  public b()
  {
    AppMethodBeat.i(63312);
    this.jRv = new b.1(this);
    this.jRw = new IListener() {};
    this.jRx = new IListener() {};
    this.jRy = new IListener() {};
    this.jRz = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(63310);
        int i = Util.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.PayMsgType"), 0);
        Log.d("MicroMsg.SubCoreAA", "paymsgtype: %d, current version: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.protocal.d.KyO) });
        int i1;
        int n;
        int m;
        int k;
        int j;
        if (i == 32)
        {
          i = Util.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.receiveorpayreddot"), -1);
          i1 = Util.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.grouppayreddot"), -1);
          n = Util.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.facingreceivereddot"), -1);
          m = Util.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.f2fhongbaoreddot"), -1);
          k = Util.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.rewardcodereddot"), -1);
          j = Util.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.android_minclientversion"), -1);
          paramAnonymousString = Util.nullAs((String)paramAnonymousMap.get(".sysmsg.paymsg.facingreceivereddotwording"), "");
          g.aAi();
          g.aAh().azQ().set(ar.a.OdP, paramAnonymousString);
          Log.i("MicroMsg.SubCoreAA", "recvOrPay: %s, aa: %s, collect： %s, f2fhb: %s, qrreward: %s, version： %s", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j) });
          if (com.tencent.mm.protocal.d.KyO >= j)
          {
            j = 0;
            if (i != 1) {
              break label436;
            }
            Log.i("MicroMsg.SubCoreAA", "mark recv or pay red dot");
            com.tencent.mm.y.c.axV().B(262159, true);
            if (i1 != 1) {
              break label453;
            }
            Log.i("MicroMsg.SubCoreAA", "mark group pay red dot");
            com.tencent.mm.y.c.axV().b(ar.a.Oez, true);
            i = 1;
            label312:
            if (n != 1) {
              break label479;
            }
            Log.i("MicroMsg.SubCoreAA", "mark f2f recv red dot");
            com.tencent.mm.y.c.axV().b(ar.a.OeA, true);
            j = 1;
            label338:
            if (m != 1) {
              break label505;
            }
            Log.i("MicroMsg.SubCoreAA", "mark f2f hb red dot");
            com.tencent.mm.y.c.axV().b(ar.a.OeB, true);
            i = 1;
            label364:
            if (k != 1) {
              break label531;
            }
            Log.i("MicroMsg.SubCoreAA", "mark qr reward red dot");
            com.tencent.mm.y.c.axV().b(ar.a.OeC, true);
            j = 1;
          }
        }
        for (;;)
        {
          if (j != 0) {
            g.aAh().azQ().set(ar.a.OeE, Boolean.FALSE);
          }
          h.CyF.a(14396, new Object[] { Integer.valueOf(1) });
          AppMethodBeat.o(63310);
          return;
          label436:
          if (i != 0) {
            break;
          }
          com.tencent.mm.y.c.axV().B(262159, false);
          break;
          label453:
          i = j;
          if (i1 != 0) {
            break label312;
          }
          com.tencent.mm.y.c.axV().b(ar.a.Oez, false);
          i = j;
          break label312;
          label479:
          j = i;
          if (n != 0) {
            break label338;
          }
          com.tencent.mm.y.c.axV().b(ar.a.OeA, false);
          j = i;
          break label338;
          label505:
          i = j;
          if (m != 0) {
            break label364;
          }
          com.tencent.mm.y.c.axV().b(ar.a.OeB, false);
          i = j;
          break label364;
          label531:
          j = i;
          if (k == 0)
          {
            com.tencent.mm.y.c.axV().b(ar.a.OeC, false);
            j = i;
          }
        }
      }
    };
    this.jRA = new IListener() {};
    AppMethodBeat.o(63312);
  }
  
  private static b blY()
  {
    AppMethodBeat.i(63313);
    b localb = (b)y.at(b.class);
    AppMethodBeat.o(63313);
    return localb;
  }
  
  public static com.tencent.mm.plugin.aa.model.a.d blZ()
  {
    AppMethodBeat.i(63314);
    if (blY().jRB == null)
    {
      localObject = blY();
      g.aAi();
      ((b)localObject).jRB = new com.tencent.mm.plugin.aa.model.a.d(g.aAh().hqK);
    }
    Object localObject = blY().jRB;
    AppMethodBeat.o(63314);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.aa.model.a.b bma()
  {
    AppMethodBeat.i(63315);
    if (blY().jRC == null)
    {
      localObject = blY();
      g.aAi();
      ((b)localObject).jRC = new com.tencent.mm.plugin.aa.model.a.b(g.aAh().hqK);
    }
    Object localObject = blY().jRC;
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
    EventCenter.instance.addListener(this.jRv);
    EventCenter.instance.addListener(this.jRw);
    EventCenter.instance.addListener(this.jRx);
    EventCenter.instance.addListener(this.jRy);
    EventCenter.instance.addListener(this.jRA);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("paymsg", this.jRz);
    com.tencent.mm.model.e.a(new com.tencent.mm.plugin.messenger.foundation.a.a()
    {
      public final void a(h.a paramAnonymousa, ca paramAnonymousca, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(184836);
        if ((!paramAnonymousBoolean) && (paramAnonymousca != null) && (!Util.isNullOrNil(paramAnonymousca.field_content))) {
          if (!com.tencent.mm.ui.ao.isDarkMode()) {
            break label73;
          }
        }
        label73:
        for (paramAnonymousa = "#7D90A9";; paramAnonymousa = "#576B95")
        {
          paramAnonymousca.setContent(paramAnonymousca.field_content.replace("color=\"#037AFF\"", "color=\"" + paramAnonymousa + "\""));
          AppMethodBeat.o(184836);
          return;
        }
      }
      
      public final void b(h.a paramAnonymousa, ca paramAnonymousca, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(63316);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63317);
    EventCenter.instance.removeListener(this.jRv);
    EventCenter.instance.removeListener(this.jRw);
    EventCenter.instance.removeListener(this.jRx);
    EventCenter.instance.removeListener(this.jRy);
    EventCenter.instance.removeListener(this.jRA);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().b("paymsg", this.jRz);
    AppMethodBeat.o(63317);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.b
 * JD-Core Version:    0.7.0.1
 */