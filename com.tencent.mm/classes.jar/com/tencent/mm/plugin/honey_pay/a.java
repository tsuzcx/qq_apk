package com.tencent.mm.plugin.honey_pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.tg;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.honey_pay.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storagebase.h.b;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class a
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.cp.h<b> JAr;
  private IListener<tg> JAs;
  private t JAt;
  
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
    this.JAr = new com.tencent.mm.cp.h(new com.tencent.mm.cp.c() {});
    this.JAs = new SubCoreHoneyPay.3(this, f.hfK);
    this.JAt = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(64605);
        if (Util.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.PayMsgType"), 0) == 35)
        {
          Log.i("MicroMsg.SubCoreHoneyPay", "receive honey pay newxml");
          Object localObject = (String)paramAnonymousMap.get(".sysmsg.paymsg.appmsgcontent");
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.paymsg.fromusername");
          paramAnonymousa = (String)paramAnonymousMap.get(".sysmsg.paymsg.tousername");
          String str = (String)paramAnonymousMap.get(".sysmsg.paymsg.paymsgid");
          paramAnonymousMap = (String)paramAnonymousMap.get(".sysmsg.paymsg.systip");
          if (!Util.isNullOrNil((String)localObject))
          {
            localObject = URLDecoder.decode((String)localObject);
            Log.d("MicroMsg.SubCoreHoneyPay", "appmsg: %s", new Object[] { localObject });
            com.tencent.mm.plugin.honey_pay.model.c.z(str, (String)localObject, paramAnonymousa, paramAnonymousString);
          }
          if (!Util.isNullOrNil(paramAnonymousMap))
          {
            paramAnonymousMap = URLDecoder.decode(paramAnonymousMap);
            Log.d("MicroMsg.SubCoreHoneyPay", "systip: %s", new Object[] { paramAnonymousMap });
            localObject = new com.tencent.mm.plugin.honey_pay.model.a();
            ((com.tencent.mm.plugin.honey_pay.model.a)localObject).field_payMsgId = str;
            a.fPu().fPv().get((IAutoDBItem)localObject, new String[0]);
            if (((com.tencent.mm.plugin.honey_pay.model.a)localObject).field_msgId > 0L)
            {
              if (((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((com.tencent.mm.plugin.honey_pay.model.a)localObject).field_msgId).field_msgId > 0L)
              {
                if (z.Iy(paramAnonymousString))
                {
                  com.tencent.mm.plugin.honey_pay.model.c.aA(paramAnonymousa, paramAnonymousMap, paramAnonymousString);
                  AppMethodBeat.o(64605);
                  return;
                }
                com.tencent.mm.plugin.honey_pay.model.c.aA(paramAnonymousString, paramAnonymousMap, paramAnonymousa);
                AppMethodBeat.o(64605);
                return;
              }
              Log.i("MicroMsg.SubCoreHoneyPay", "can not found honey bubble, will not insert sysmsg");
              AppMethodBeat.o(64605);
              return;
            }
            Log.i("MicroMsg.SubCoreHoneyPay", "can not found honey pay record, will not insert sysmsg");
          }
        }
        AppMethodBeat.o(64605);
      }
    };
    AppMethodBeat.o(64607);
  }
  
  public static a fPu()
  {
    AppMethodBeat.i(64606);
    a locala = (a)y.aL(a.class);
    AppMethodBeat.o(64606);
    return locala;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final b fPv()
  {
    AppMethodBeat.i(64610);
    b localb = (b)this.JAr.get();
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
    this.JAs.alive();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("paymsg", this.JAt);
    AppMethodBeat.o(64608);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64609);
    this.JAs.dead();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("paymsg", this.JAt);
    AppMethodBeat.o(64609);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a
 * JD-Core Version:    0.7.0.1
 */