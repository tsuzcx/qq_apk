package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.z.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class k
  implements com.tencent.mm.al.f, ax
{
  private ap mHandler;
  ConcurrentHashMap<Integer, com.tencent.mm.plugin.wallet_core.model.z> vDv;
  private boolean vDw;
  private cd.a vDx;
  private cd.a vDy;
  
  public k()
  {
    AppMethodBeat.i(66016);
    this.vDv = new ConcurrentHashMap();
    this.mHandler = new ap(Looper.getMainLooper());
    this.vDw = false;
    this.vDx = new cd.a()
    {
      public final void a(final e.a paramAnonymousa)
      {
        AppMethodBeat.i(66013);
        paramAnonymousa = com.tencent.mm.platformtools.z.a(paramAnonymousa.gqE.Fvk);
        ad.d("MicroMsg.SubCoreMall", "WalletNotifyConfXml:".concat(String.valueOf(paramAnonymousa)));
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66012);
            com.tencent.mm.plugin.wallet_core.model.mall.c localc = com.tencent.mm.plugin.wallet_core.model.mall.c.eGT();
            Object localObject = paramAnonymousa;
            MallNews localMallNews = com.tencent.mm.plugin.wallet_core.model.mall.c.aED((String)localObject);
            if (localMallNews != null)
            {
              if (!"2".equals(localMallNews.type))
              {
                localc.DbG.put(localMallNews.hNT, localMallNews);
                ad.i("MicroMsg.MallNewsManager", "onRecieveMsg : ".concat(String.valueOf(localObject)));
                localc.dzN();
                if (com.tencent.mm.plugin.wallet_core.model.mall.c.a(localMallNews))
                {
                  ad.i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
                  AppMethodBeat.o(66012);
                  return;
                }
                if (localMallNews.dlp == 0)
                {
                  ad.d("MicroMsg.MallNewsManager", "showType New");
                  com.tencent.mm.z.c.aht().w(262156, true);
                  g.ajD();
                  g.ajC().ajl().set(al.a.IzX, Long.valueOf(System.currentTimeMillis()));
                }
                for (;;)
                {
                  com.tencent.mm.plugin.wallet_core.model.mall.c.eGV();
                  AppMethodBeat.o(66012);
                  return;
                  if (localMallNews.dlp == 1)
                  {
                    ad.d("MicroMsg.MallNewsManager", "showType Dot");
                    com.tencent.mm.z.c.aht().x(262156, true);
                    g.ajD();
                    g.ajC().ajl().set(al.a.IzX, Long.valueOf(System.currentTimeMillis()));
                  }
                }
              }
              ad.d("MicroMsg.MallNewsManager", "removeNews : ".concat(String.valueOf(localMallNews)));
              localObject = (MallNews)localc.DbG.get(localMallNews.hNT);
              if ((localObject != null) && (((MallNews)localObject).Bhd.equals(localMallNews.Bhd)) && (((MallNews)localObject).dpf.equals(localMallNews.dpf)))
              {
                ad.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + localMallNews.hNT);
                localc.DbG.remove(localMallNews.hNT);
                AppMethodBeat.o(66012);
                return;
              }
              ad.i("MicroMsg.MallNewsManager", "onRecieveMsg cancel not found!");
            }
            AppMethodBeat.o(66012);
          }
        });
        AppMethodBeat.o(66013);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.vDy = new cd.a()
    {
      public final void a(final e.a paramAnonymousa)
      {
        AppMethodBeat.i(66015);
        paramAnonymousa = com.tencent.mm.platformtools.z.a(paramAnonymousa.gqE.Fvk);
        ad.d("MicroMsg.SubCoreMall", "receive pay msg: %s", new Object[] { paramAnonymousa });
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66014);
            com.tencent.mm.plugin.wallet_core.model.mall.c.eGT();
            com.tencent.mm.plugin.wallet_core.model.mall.c.aEA(paramAnonymousa);
            AppMethodBeat.o(66014);
          }
        });
        AppMethodBeat.o(66015);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    AppMethodBeat.o(66016);
  }
  
  public static k dka()
  {
    AppMethodBeat.i(66017);
    k localk = (k)com.tencent.mm.model.t.ap(k.class);
    AppMethodBeat.o(66017);
    return localk;
  }
  
  public final com.tencent.mm.plugin.wallet_core.model.z JC(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(66018);
    Object localObject3;
    if (!this.vDv.contains(Integer.valueOf(paramInt)))
    {
      localObject3 = com.tencent.mm.plugin.wallet_core.model.t.eFD();
      String str = "select * from WalletFunciontList where wallet_region = ".concat(String.valueOf(paramInt));
      localObject3 = ((com.tencent.mm.plugin.wallet_core.d.f)localObject3).db.a(str, null, 2);
      ad.i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo ".concat(String.valueOf(str)));
      if (localObject3 != null) {
        break label126;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.vDv.put(Integer.valueOf(paramInt), localObject1);
      }
      localObject1 = (com.tencent.mm.plugin.wallet_core.model.z)this.vDv.get(Integer.valueOf(paramInt));
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
  
  public final ArrayList<MallFunction> JD(int paramInt)
  {
    AppMethodBeat.i(66019);
    ArrayList localArrayList = JC(paramInt).vDg;
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
    ((r)g.ad(r.class)).getSysCmdMsgExtension().a("mallactivity", this.vDx, true);
    ((r)g.ad(r.class)).getSysCmdMsgExtension().a("paymsg", this.vDy, true);
    com.tencent.mm.plugin.wallet_core.model.mall.c.eGT().Zd();
    d.eGX().Zd();
    if ((u.aAB()) && (u.aAw())) {
      com.tencent.mm.plugin.wallet_core.model.mall.b.VB(com.tencent.mm.plugin.wallet_core.model.mall.b.Dbu);
    }
    for (;;)
    {
      g.ajD();
      g.ajB().gAO.a(302, this);
      AppMethodBeat.o(66020);
      return;
      com.tencent.mm.plugin.wallet_core.model.mall.b.VB(com.tencent.mm.plugin.wallet_core.model.mall.b.Dbt);
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66021);
    ((r)g.ad(r.class)).getSysCmdMsgExtension().b("mallactivity", this.vDx, true);
    ((r)g.ad(r.class)).getSysCmdMsgExtension().b("paymsg", this.vDy, true);
    g.ajD();
    g.ajB().gAO.b(302, this);
    AppMethodBeat.o(66021);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66022);
    if ((paramInt2 == 0) && (paramInt1 == 0) && (!this.vDw) && (u.aAB()))
    {
      this.vDw = true;
      com.tencent.mm.plugin.wallet_core.model.mall.b.VB(com.tencent.mm.plugin.wallet_core.model.mall.b.Dbu);
    }
    AppMethodBeat.o(66022);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.k
 * JD-Core Version:    0.7.0.1
 */