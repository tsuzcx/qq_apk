package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.al.n;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.z.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class j
  implements com.tencent.mm.al.g, aw
{
  private ap mHandler;
  private cc.a tsA;
  ConcurrentHashMap<Integer, y> tsx;
  private boolean tsy;
  private cc.a tsz;
  
  public j()
  {
    AppMethodBeat.i(66016);
    this.tsx = new ConcurrentHashMap();
    this.mHandler = new ap(Looper.getMainLooper());
    this.tsy = false;
    this.tsz = new cc.a()
    {
      public final void a(final f.a paramAnonymousa)
      {
        AppMethodBeat.i(66013);
        paramAnonymousa = z.a(paramAnonymousa.fTo.Cxz);
        ad.d("MicroMsg.SubCoreMall", "WalletNotifyConfXml:".concat(String.valueOf(paramAnonymousa)));
        j.a(j.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66012);
            com.tencent.mm.plugin.wallet_core.model.mall.c localc = com.tencent.mm.plugin.wallet_core.model.mall.c.eds();
            Object localObject = paramAnonymousa;
            MallNews localMallNews = com.tencent.mm.plugin.wallet_core.model.mall.c.aub((String)localObject);
            if (localMallNews != null)
            {
              if (!"2".equals(localMallNews.type))
              {
                localc.AiT.put(localMallNews.gVf, localMallNews);
                ad.i("MicroMsg.MallNewsManager", "onRecieveMsg : ".concat(String.valueOf(localObject)));
                localc.dbD();
                if (com.tencent.mm.plugin.wallet_core.model.mall.c.a(localMallNews))
                {
                  ad.i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
                  AppMethodBeat.o(66012);
                  return;
                }
                if (localMallNews.dcz == 0)
                {
                  ad.d("MicroMsg.MallNewsManager", "showType New");
                  com.tencent.mm.z.c.adr().w(262156, true);
                  com.tencent.mm.kernel.g.afC();
                  com.tencent.mm.kernel.g.afB().afk().set(ae.a.FpQ, Long.valueOf(System.currentTimeMillis()));
                }
                for (;;)
                {
                  com.tencent.mm.plugin.wallet_core.model.mall.c.edu();
                  AppMethodBeat.o(66012);
                  return;
                  if (localMallNews.dcz == 1)
                  {
                    ad.d("MicroMsg.MallNewsManager", "showType Dot");
                    com.tencent.mm.z.c.adr().x(262156, true);
                    com.tencent.mm.kernel.g.afC();
                    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FpQ, Long.valueOf(System.currentTimeMillis()));
                  }
                }
              }
              ad.d("MicroMsg.MallNewsManager", "removeNews : ".concat(String.valueOf(localMallNews)));
              localObject = (MallNews)localc.AiT.get(localMallNews.gVf);
              if ((localObject != null) && (((MallNews)localObject).yCo.equals(localMallNews.yCo)) && (((MallNews)localObject).dgo.equals(localMallNews.dgo)))
              {
                ad.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + localMallNews.gVf);
                localc.AiT.remove(localMallNews.gVf);
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
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.tsA = new cc.a()
    {
      public final void a(final f.a paramAnonymousa)
      {
        AppMethodBeat.i(66015);
        paramAnonymousa = z.a(paramAnonymousa.fTo.Cxz);
        ad.d("MicroMsg.SubCoreMall", "receive pay msg: %s", new Object[] { paramAnonymousa });
        j.a(j.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66014);
            com.tencent.mm.plugin.wallet_core.model.mall.c.eds();
            com.tencent.mm.plugin.wallet_core.model.mall.c.atY(paramAnonymousa);
            AppMethodBeat.o(66014);
          }
        });
        AppMethodBeat.o(66015);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    AppMethodBeat.o(66016);
  }
  
  public static j cNg()
  {
    AppMethodBeat.i(66017);
    j localj = (j)t.ap(j.class);
    AppMethodBeat.o(66017);
    return localj;
  }
  
  public final y Gk(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(66018);
    Object localObject3;
    if (!this.tsx.contains(Integer.valueOf(paramInt)))
    {
      localObject3 = s.ech();
      String str = "select * from WalletFunciontList where wallet_region = ".concat(String.valueOf(paramInt));
      localObject3 = ((f)localObject3).db.a(str, null, 2);
      ad.i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo ".concat(String.valueOf(str)));
      if (localObject3 != null) {
        break label126;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.tsx.put(Integer.valueOf(paramInt), localObject1);
      }
      localObject1 = (y)this.tsx.get(Integer.valueOf(paramInt));
      if (localObject1 != null) {
        break;
      }
      localObject1 = new y();
      AppMethodBeat.o(66018);
      return localObject1;
      label126:
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToNext())
      {
        localObject1 = new y();
        ((y)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
    }
    AppMethodBeat.o(66018);
    return localObject1;
  }
  
  public final ArrayList<MallFunction> Gl(int paramInt)
  {
    AppMethodBeat.i(66019);
    ArrayList localArrayList = Gk(paramInt).tsk;
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
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("mallactivity", this.tsz, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("paymsg", this.tsA, true);
    com.tencent.mm.plugin.wallet_core.model.mall.c.eds().VL();
    d.edw().VL();
    if ((u.aqV()) && (u.aqQ())) {
      com.tencent.mm.plugin.wallet_core.model.mall.b.RA(com.tencent.mm.plugin.wallet_core.model.mall.b.AiH);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(302, this);
      AppMethodBeat.o(66020);
      return;
      com.tencent.mm.plugin.wallet_core.model.mall.b.RA(com.tencent.mm.plugin.wallet_core.model.mall.b.AiG);
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66021);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("mallactivity", this.tsz, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("paymsg", this.tsA, true);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(302, this);
    AppMethodBeat.o(66021);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66022);
    if ((paramInt2 == 0) && (paramInt1 == 0) && (!this.tsy) && (u.aqV()))
    {
      this.tsy = true;
      com.tencent.mm.plugin.wallet_core.model.mall.b.RA(com.tencent.mm.plugin.wallet_core.model.mall.b.AiH);
    }
    AppMethodBeat.o(66022);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.j
 * JD-Core Version:    0.7.0.1
 */