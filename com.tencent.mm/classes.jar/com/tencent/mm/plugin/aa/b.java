package com.tencent.mm.plugin.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a;
import com.tencent.mm.am.g.a;
import com.tencent.mm.autogen.a.adi;
import com.tencent.mm.autogen.a.cp;
import com.tencent.mm.autogen.a.cq;
import com.tencent.mm.autogen.a.te;
import com.tencent.mm.autogen.a.tf;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.e;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.aw;
import java.util.HashMap;
import java.util.Map;

public class b
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private IListener<tf> pFp;
  private IListener<te> pFq;
  private IListener<cp> pFr;
  private IListener<cq> pFs;
  private t pFt;
  IListener<adi> pFu;
  private com.tencent.mm.plugin.aa.model.a.d pFv;
  private com.tencent.mm.plugin.aa.model.a.b pFw;
  
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
    this.pFp = new SubCoreAA.1(this, com.tencent.mm.app.f.hfK);
    this.pFq = new SubCoreAA.2(this, com.tencent.mm.app.f.hfK);
    this.pFr = new SubCoreAA.3(this, com.tencent.mm.app.f.hfK);
    this.pFs = new SubCoreAA.4(this, com.tencent.mm.app.f.hfK);
    this.pFt = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(63310);
        int i = Util.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.PayMsgType"), 0);
        Log.d("MicroMsg.SubCoreAA", "paymsgtype: %d, current version: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.protocal.d.Yxh) });
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
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acTE, paramAnonymousString);
          Log.i("MicroMsg.SubCoreAA", "recvOrPay: %s, aa: %s, collect： %s, f2fhb: %s, qrreward: %s, version： %s", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j) });
          if (com.tencent.mm.protocal.d.Yxh >= j)
          {
            j = 0;
            if (i != 1) {
              break label436;
            }
            Log.i("MicroMsg.SubCoreAA", "mark recv or pay red dot");
            com.tencent.mm.aa.c.aYo().R(262159, true);
            if (i1 != 1) {
              break label453;
            }
            Log.i("MicroMsg.SubCoreAA", "mark group pay red dot");
            com.tencent.mm.aa.c.aYo().b(at.a.acUp, true);
            i = 1;
            label312:
            if (n != 1) {
              break label479;
            }
            Log.i("MicroMsg.SubCoreAA", "mark f2f recv red dot");
            com.tencent.mm.aa.c.aYo().b(at.a.acUq, true);
            j = 1;
            label338:
            if (m != 1) {
              break label505;
            }
            Log.i("MicroMsg.SubCoreAA", "mark f2f hb red dot");
            com.tencent.mm.aa.c.aYo().b(at.a.acUr, true);
            i = 1;
            label364:
            if (k != 1) {
              break label531;
            }
            Log.i("MicroMsg.SubCoreAA", "mark qr reward red dot");
            com.tencent.mm.aa.c.aYo().b(at.a.acUs, true);
            j = 1;
          }
        }
        for (;;)
        {
          if (j != 0) {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acUu, Boolean.FALSE);
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(14396, new Object[] { Integer.valueOf(1) });
          AppMethodBeat.o(63310);
          return;
          label436:
          if (i != 0) {
            break;
          }
          com.tencent.mm.aa.c.aYo().R(262159, false);
          break;
          label453:
          i = j;
          if (i1 != 0) {
            break label312;
          }
          com.tencent.mm.aa.c.aYo().b(at.a.acUp, false);
          i = j;
          break label312;
          label479:
          j = i;
          if (n != 0) {
            break label338;
          }
          com.tencent.mm.aa.c.aYo().b(at.a.acUq, false);
          j = i;
          break label338;
          label505:
          i = j;
          if (m != 0) {
            break label364;
          }
          com.tencent.mm.aa.c.aYo().b(at.a.acUr, false);
          i = j;
          break label364;
          label531:
          j = i;
          if (k == 0)
          {
            com.tencent.mm.aa.c.aYo().b(at.a.acUs, false);
            j = i;
          }
        }
      }
    };
    this.pFu = new SubCoreAA.6(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(63312);
  }
  
  private static b bUZ()
  {
    AppMethodBeat.i(63313);
    b localb = (b)y.aL(b.class);
    AppMethodBeat.o(63313);
    return localb;
  }
  
  public static com.tencent.mm.plugin.aa.model.a.d bVa()
  {
    AppMethodBeat.i(63314);
    if (bUZ().pFv == null)
    {
      localObject = bUZ();
      com.tencent.mm.kernel.h.baF();
      ((b)localObject).pFv = new com.tencent.mm.plugin.aa.model.a.d(com.tencent.mm.kernel.h.baE().mCN);
    }
    Object localObject = bUZ().pFv;
    AppMethodBeat.o(63314);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.aa.model.a.b bVb()
  {
    AppMethodBeat.i(63315);
    if (bUZ().pFw == null)
    {
      localObject = bUZ();
      com.tencent.mm.kernel.h.baF();
      ((b)localObject).pFw = new com.tencent.mm.plugin.aa.model.a.b(com.tencent.mm.kernel.h.baE().mCN);
    }
    Object localObject = bUZ().pFw;
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
    this.pFp.alive();
    this.pFq.alive();
    this.pFr.alive();
    this.pFs.alive();
    this.pFu.alive();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("paymsg", this.pFt);
    e.a(new com.tencent.mm.plugin.messenger.foundation.a.c()
    {
      public final void a(g.a paramAnonymousa, cc paramAnonymouscc, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(184836);
        if ((!paramAnonymousBoolean) && (paramAnonymouscc != null) && (!Util.isNullOrNil(paramAnonymouscc.field_content))) {
          if (!aw.isDarkMode()) {
            break label73;
          }
        }
        label73:
        for (paramAnonymousa = "#7D90A9";; paramAnonymousa = "#576B95")
        {
          paramAnonymouscc.setContent(paramAnonymouscc.field_content.replace("color=\"#037AFF\"", "color=\"" + paramAnonymousa + "\""));
          AppMethodBeat.o(184836);
          return;
        }
      }
      
      public final void b(g.a paramAnonymousa, cc paramAnonymouscc, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(63316);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63317);
    this.pFp.dead();
    this.pFq.dead();
    this.pFr.dead();
    this.pFs.dead();
    this.pFu.dead();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("paymsg", this.pFt);
    AppMethodBeat.o(63317);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.b
 * JD-Core Version:    0.7.0.1
 */