package com.tencent.mm.plugin.honey_pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.f.a.rr;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.honey_pay.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h.b;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class a
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.cw.h<b> DJv;
  private IListener<rr> DJw;
  private t DJx;
  
  static
  {
    AppMethodBeat.i(64611);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("HoneyPayMsgRecord".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(64611);
  }
  
  public a()
  {
    AppMethodBeat.i(64607);
    this.DJv = new com.tencent.mm.cw.h(new com.tencent.mm.cw.c() {});
    this.DJw = new IListener() {};
    this.DJx = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(64605);
        if (Util.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.PayMsgType"), 0) == 35)
        {
          Log.i("MicroMsg.SubCoreHoneyPay", "receive honey pay newxml");
          String str2 = (String)paramAnonymousMap.get(".sysmsg.paymsg.appmsgcontent");
          paramAnonymousa = (String)paramAnonymousMap.get(".sysmsg.paymsg.fromusername");
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.paymsg.tousername");
          String str1 = (String)paramAnonymousMap.get(".sysmsg.paymsg.paymsgid");
          paramAnonymousMap = (String)paramAnonymousMap.get(".sysmsg.paymsg.systip");
          if (!Util.isNullOrNil(str2))
          {
            str2 = URLDecoder.decode(str2);
            Log.d("MicroMsg.SubCoreHoneyPay", "appmsg: %s", new Object[] { str2 });
            com.tencent.mm.plugin.honey_pay.model.c.x(str1, str2, paramAnonymousString, paramAnonymousa);
          }
          if (!Util.isNullOrNil(paramAnonymousMap))
          {
            paramAnonymousMap = URLDecoder.decode(paramAnonymousMap);
            Log.d("MicroMsg.SubCoreHoneyPay", "systip: %s", new Object[] { paramAnonymousMap });
            Log.i("MicroMsg.HoneyPayUtil", "insert sys msg: %s, %s", new Object[] { paramAnonymousString, Boolean.valueOf(Util.isNullOrNil(paramAnonymousMap)) });
            if ((!Util.isNullOrNil(paramAnonymousMap)) && (!Util.isNullOrNil(paramAnonymousString)))
            {
              paramAnonymousMap = com.tencent.mm.plugin.honey_pay.model.c.aa(com.tencent.mm.plugin.honey_pay.model.c.aa(paramAnonymousMap, paramAnonymousString, -1), paramAnonymousa, -1);
              paramAnonymousa = new ca();
              paramAnonymousa.pJ(0);
              paramAnonymousa.Jm(paramAnonymousString);
              paramAnonymousa.setStatus(3);
              paramAnonymousa.setContent(paramAnonymousMap);
              paramAnonymousa.setCreateTime(bq.z(paramAnonymousString, System.currentTimeMillis() / 1000L));
              paramAnonymousa.setType(10000);
              paramAnonymousa.setFlag(paramAnonymousa.field_flag | 0x8);
              long l = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM(paramAnonymousa);
              Log.i("MicroMsg.HoneyPayUtil", "insert msgId: %s", new Object[] { Long.valueOf(l) });
              if (l <= 0L) {
                Log.w("MicroMsg.HoneyPayUtil", "insert sys msg fail!");
              }
            }
          }
        }
        AppMethodBeat.o(64605);
      }
    };
    AppMethodBeat.o(64607);
  }
  
  public static a eHJ()
  {
    AppMethodBeat.i(64606);
    a locala = (a)y.as(a.class);
    AppMethodBeat.o(64606);
    return locala;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final b eHK()
  {
    AppMethodBeat.i(64610);
    b localb = (b)this.DJv.get();
    AppMethodBeat.o(64610);
    return localb;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(64608);
    this.DJw.alive();
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("paymsg", this.DJx);
    AppMethodBeat.o(64608);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64609);
    this.DJw.dead();
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("paymsg", this.DJx);
    AppMethodBeat.o(64609);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a
 * JD-Core Version:    0.7.0.1
 */