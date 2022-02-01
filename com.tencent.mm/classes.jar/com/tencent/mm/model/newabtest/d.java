package com.tencent.mm.model.newabtest;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.j.a;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public class d
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.storage.d ooN;
  private com.tencent.mm.storage.b ooO;
  private cl.a ooP;
  private IListener ooQ;
  private MStorage.IOnStorageChange ooR;
  private com.tencent.mm.vending.b.b ooS;
  private final com.tencent.mm.plugin.auth.a.b ooT;
  
  static
  {
    AppMethodBeat.i(153135);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("NEW_ABTEST_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("NEW_ABTEST_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(153135);
  }
  
  public d()
  {
    AppMethodBeat.i(153128);
    this.ooP = new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(153124);
        paramAnonymousa = w.a(paramAnonymousa.mpN.YFG);
        Log.d("MicroMsg.SubCoreNewABTest", "Message content(abtest): %s".concat(String.valueOf(paramAnonymousa)));
        paramAnonymousa = a.Ky(paramAnonymousa);
        if (paramAnonymousa == null)
        {
          AppMethodBeat.o(153124);
          return;
        }
        d.bEt().aa(paramAnonymousa.bMQ, 1);
        d.bEu().aa(paramAnonymousa.ooG, 2);
        AppMethodBeat.o(153124);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.ooQ = new SubCoreNewABTest.2(this, com.tencent.mm.app.f.hfK);
    this.ooR = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(153126);
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString)))
        {
          paramAnonymousString = d.bEt().Fd("100205");
          if ((paramAnonymousString != null) && (paramAnonymousString.isValid()))
          {
            paramAnonymousString = paramAnonymousString.iWZ();
            int i = Util.getInt((String)paramAnonymousString.get("main_thread_watch_enable"), 65535);
            int j = Util.getInt((String)paramAnonymousString.get("main_thread_watch_timeout"), 5000);
            int k = Util.getInt((String)paramAnonymousString.get("main_thread_watch_log_loop"), 0);
            int m = Util.getInt((String)paramAnonymousString.get("main_thread_watch_report"), 0);
            MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", g.aQe()).edit().putInt("main_thread_watch_enable", i).putInt("main_thread_watch_timeout", j).putInt("main_thread_watch_log_loop", k).putInt("main_thread_watch_report", m).commit();
            Log.i("MicroMsg.SubCoreNewABTest", "summeranr MM_MAIN_THREAD_WATCH enable[%d] timeout[%d], loop[%d] report[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
          }
          d.bEv();
        }
        AppMethodBeat.o(153126);
      }
    };
    this.ooS = null;
    this.ooT = new com.tencent.mm.plugin.auth.a.b()
    {
      public final void onAuthResponse(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(153127);
        if (paramAnonymousBoolean)
        {
          if ((paramAnonymoush != null) && ((paramAnonymoush instanceof j.a)) && (paramAnonymoush.getSceneStatus() == 12))
          {
            b.bEm();
            AppMethodBeat.o(153127);
          }
        }
        else if ((paramAnonymoush != null) && (paramAnonymoush.getSceneStatus() == 16)) {
          b.bEm();
        }
        AppMethodBeat.o(153127);
      }
      
      public final void onRegResponse(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
    };
    AppMethodBeat.o(153128);
  }
  
  private static d bEs()
  {
    try
    {
      AppMethodBeat.i(153129);
      d locald = (d)y.aL(d.class);
      AppMethodBeat.o(153129);
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static com.tencent.mm.storage.d bEt()
  {
    AppMethodBeat.i(153130);
    h.baC().aZJ();
    if (bEs().ooN == null) {
      bEs().ooN = new com.tencent.mm.storage.d(h.baE().mCN);
    }
    com.tencent.mm.storage.d locald = bEs().ooN;
    AppMethodBeat.o(153130);
    return locald;
  }
  
  public static com.tencent.mm.storage.b bEu()
  {
    AppMethodBeat.i(153131);
    h.baC().aZJ();
    if (bEs().ooO == null) {
      bEs().ooO = new com.tencent.mm.storage.b(h.baE().mCN);
    }
    com.tencent.mm.storage.b localb = bEs().ooO;
    AppMethodBeat.o(153131);
    return localb;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(153132);
    ((v)h.az(v.class)).getSysCmdMsgExtension().a("newabtest", this.ooP, true);
    ((v)h.az(v.class)).getSysCmdMsgExtension().a("newabtestinfo", this.ooP, true);
    this.ooQ.alive();
    bEt().add(this.ooR);
    this.ooS = ((com.tencent.mm.plugin.auth.a.c)h.az(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(this.ooT);
    AppMethodBeat.o(153132);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(153133);
    ((v)h.az(v.class)).getSysCmdMsgExtension().b("newabtest", this.ooP, true);
    ((v)h.az(v.class)).getSysCmdMsgExtension().b("newabtestinfo", this.ooP, true);
    this.ooQ.dead();
    bEt().remove(this.ooR);
    if (this.ooS != null)
    {
      this.ooS.dead();
      this.ooS = null;
    }
    AppMethodBeat.o(153133);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.newabtest.d
 * JD-Core Version:    0.7.0.1
 */