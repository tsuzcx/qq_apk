package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.y.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class k
  implements i, bd
{
  private MMHandler mHandler;
  ConcurrentHashMap<Integer, com.tencent.mm.plugin.wallet_core.model.z> zjD;
  private boolean zjE;
  private cj.a zjF;
  private cj.a zjG;
  
  public k()
  {
    AppMethodBeat.i(66016);
    this.zjD = new ConcurrentHashMap();
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.zjE = false;
    this.zjF = new cj.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(66013);
        paramAnonymousa = com.tencent.mm.platformtools.z.a(paramAnonymousa.heO.KHn);
        Log.d("MicroMsg.SubCoreMall", "WalletNotifyConfXml:".concat(String.valueOf(paramAnonymousa)));
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66012);
            com.tencent.mm.plugin.wallet_core.model.mall.c localc = com.tencent.mm.plugin.wallet_core.model.mall.c.fSg();
            Object localObject = paramAnonymousa;
            MallNews localMallNews = com.tencent.mm.plugin.wallet_core.model.mall.c.aVw((String)localObject);
            if (localMallNews != null)
            {
              if (!"2".equals(localMallNews.type))
              {
                localc.Icv.put(localMallNews.iLU, localMallNews);
                Log.i("MicroMsg.MallNewsManager", "onRecieveMsg : ".concat(String.valueOf(localObject)));
                localc.eDw();
                if (com.tencent.mm.plugin.wallet_core.model.mall.c.a(localMallNews))
                {
                  Log.i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
                  AppMethodBeat.o(66012);
                  return;
                }
                if (localMallNews.dDG == 0)
                {
                  Log.d("MicroMsg.MallNewsManager", "showType New");
                  com.tencent.mm.y.c.axV().A(262156, true);
                  g.aAi();
                  g.aAh().azQ().set(ar.a.OcK, Long.valueOf(System.currentTimeMillis()));
                }
                for (;;)
                {
                  com.tencent.mm.plugin.wallet_core.model.mall.c.fSi();
                  AppMethodBeat.o(66012);
                  return;
                  if (localMallNews.dDG == 1)
                  {
                    Log.d("MicroMsg.MallNewsManager", "showType Dot");
                    com.tencent.mm.y.c.axV().B(262156, true);
                    g.aAi();
                    g.aAh().azQ().set(ar.a.OcK, Long.valueOf(System.currentTimeMillis()));
                  }
                }
              }
              Log.d("MicroMsg.MallNewsManager", "removeNews : ".concat(String.valueOf(localMallNews)));
              localObject = (MallNews)localc.Icv.get(localMallNews.iLU);
              if ((localObject != null) && (((MallNews)localObject).FJm.equals(localMallNews.FJm)) && (((MallNews)localObject).dHx.equals(localMallNews.dHx)))
              {
                Log.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + localMallNews.iLU);
                localc.Icv.remove(localMallNews.iLU);
                AppMethodBeat.o(66012);
                return;
              }
              Log.i("MicroMsg.MallNewsManager", "onRecieveMsg cancel not found!");
            }
            AppMethodBeat.o(66012);
          }
        });
        AppMethodBeat.o(66013);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.zjG = new cj.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(66015);
        paramAnonymousa = com.tencent.mm.platformtools.z.a(paramAnonymousa.heO.KHn);
        Log.d("MicroMsg.SubCoreMall", "receive pay msg: %s", new Object[] { paramAnonymousa });
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66014);
            com.tencent.mm.plugin.wallet_core.model.mall.c.fSg();
            com.tencent.mm.plugin.wallet_core.model.mall.c.aVt(paramAnonymousa);
            AppMethodBeat.o(66014);
          }
        });
        AppMethodBeat.o(66015);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    AppMethodBeat.o(66016);
  }
  
  public static k egL()
  {
    AppMethodBeat.i(66017);
    k localk = (k)y.at(k.class);
    AppMethodBeat.o(66017);
    return localk;
  }
  
  public final com.tencent.mm.plugin.wallet_core.model.z Qd(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(66018);
    Object localObject3;
    if (!this.zjD.contains(Integer.valueOf(paramInt)))
    {
      localObject3 = com.tencent.mm.plugin.wallet_core.model.t.fQN();
      String str = "select * from WalletFunciontList where wallet_region = ".concat(String.valueOf(paramInt));
      localObject3 = ((f)localObject3).db.rawQuery(str, null, 2);
      Log.i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo ".concat(String.valueOf(str)));
      if (localObject3 != null) {
        break label126;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.zjD.put(Integer.valueOf(paramInt), localObject1);
      }
      localObject1 = (com.tencent.mm.plugin.wallet_core.model.z)this.zjD.get(Integer.valueOf(paramInt));
      if (localObject1 != null) {
        break;
      }
      localObject1 = new com.tencent.mm.plugin.wallet_core.model.z();
      AppMethodBeat.o(66018);
      return localObject1;
      label126:
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToNext())
      {
        localObject1 = new com.tencent.mm.plugin.wallet_core.model.z();
        ((com.tencent.mm.plugin.wallet_core.model.z)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
    }
    AppMethodBeat.o(66018);
    return localObject1;
  }
  
  public final ArrayList<MallFunction> Qe(int paramInt)
  {
    AppMethodBeat.i(66019);
    ArrayList localArrayList = Qd(paramInt).zjo;
    AppMethodBeat.o(66019);
    return localArrayList;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(66020);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("mallactivity", this.zjF, true);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("paymsg", this.zjG, true);
    com.tencent.mm.plugin.wallet_core.model.mall.c.fSg().amZ();
    d.fSk().amZ();
    if ((com.tencent.mm.model.z.aUo()) && (com.tencent.mm.model.z.aUj())) {
      com.tencent.mm.plugin.wallet_core.model.mall.b.aeM(com.tencent.mm.plugin.wallet_core.model.mall.b.Ick);
    }
    for (;;)
    {
      g.aAi();
      g.aAg().hqi.a(302, this);
      AppMethodBeat.o(66020);
      return;
      com.tencent.mm.plugin.wallet_core.model.mall.b.aeM(com.tencent.mm.plugin.wallet_core.model.mall.b.Icj);
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66021);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().b("mallactivity", this.zjF, true);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().b("paymsg", this.zjG, true);
    g.aAi();
    g.aAg().hqi.b(302, this);
    AppMethodBeat.o(66021);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(66022);
    if ((paramInt2 == 0) && (paramInt1 == 0) && (!this.zjE) && (com.tencent.mm.model.z.aUo()))
    {
      this.zjE = true;
      com.tencent.mm.plugin.wallet_core.model.mall.b.aeM(com.tencent.mm.plugin.wallet_core.model.mall.b.Ick);
    }
    AppMethodBeat.o(66022);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.k
 * JD-Core Version:    0.7.0.1
 */