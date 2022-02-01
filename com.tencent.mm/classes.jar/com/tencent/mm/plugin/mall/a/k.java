package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.y.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class k
  implements com.tencent.mm.ak.f, az
{
  private aq mHandler;
  private boolean vPA;
  private cf.a vPB;
  private cf.a vPC;
  ConcurrentHashMap<Integer, com.tencent.mm.plugin.wallet_core.model.z> vPz;
  
  public k()
  {
    AppMethodBeat.i(66016);
    this.vPz = new ConcurrentHashMap();
    this.mHandler = new aq(Looper.getMainLooper());
    this.vPA = false;
    this.vPB = new cf.a()
    {
      public final void a(final e.a paramAnonymousa)
      {
        AppMethodBeat.i(66013);
        paramAnonymousa = com.tencent.mm.platformtools.z.a(paramAnonymousa.gte.FNI);
        ae.d("MicroMsg.SubCoreMall", "WalletNotifyConfXml:".concat(String.valueOf(paramAnonymousa)));
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66012);
            com.tencent.mm.plugin.wallet_core.model.mall.c localc = com.tencent.mm.plugin.wallet_core.model.mall.c.eKB();
            Object localObject = paramAnonymousa;
            MallNews localMallNews = com.tencent.mm.plugin.wallet_core.model.mall.c.aFX((String)localObject);
            if (localMallNews != null)
            {
              if (!"2".equals(localMallNews.type))
              {
                localc.Dtk.put(localMallNews.hQM, localMallNews);
                ae.i("MicroMsg.MallNewsManager", "onRecieveMsg : ".concat(String.valueOf(localObject)));
                localc.dDe();
                if (com.tencent.mm.plugin.wallet_core.model.mall.c.a(localMallNews))
                {
                  ae.i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
                  AppMethodBeat.o(66012);
                  return;
                }
                if (localMallNews.dmr == 0)
                {
                  ae.d("MicroMsg.MallNewsManager", "showType New");
                  com.tencent.mm.y.c.ahI().w(262156, true);
                  g.ajS();
                  g.ajR().ajA().set(am.a.IUw, Long.valueOf(System.currentTimeMillis()));
                }
                for (;;)
                {
                  com.tencent.mm.plugin.wallet_core.model.mall.c.eKD();
                  AppMethodBeat.o(66012);
                  return;
                  if (localMallNews.dmr == 1)
                  {
                    ae.d("MicroMsg.MallNewsManager", "showType Dot");
                    com.tencent.mm.y.c.ahI().x(262156, true);
                    g.ajS();
                    g.ajR().ajA().set(am.a.IUw, Long.valueOf(System.currentTimeMillis()));
                  }
                }
              }
              ae.d("MicroMsg.MallNewsManager", "removeNews : ".concat(String.valueOf(localMallNews)));
              localObject = (MallNews)localc.Dtk.get(localMallNews.hQM);
              if ((localObject != null) && (((MallNews)localObject).ByB.equals(localMallNews.ByB)) && (((MallNews)localObject).dqk.equals(localMallNews.dqk)))
              {
                ae.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + localMallNews.hQM);
                localc.Dtk.remove(localMallNews.hQM);
                AppMethodBeat.o(66012);
                return;
              }
              ae.i("MicroMsg.MallNewsManager", "onRecieveMsg cancel not found!");
            }
            AppMethodBeat.o(66012);
          }
        });
        AppMethodBeat.o(66013);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.vPC = new cf.a()
    {
      public final void a(final e.a paramAnonymousa)
      {
        AppMethodBeat.i(66015);
        paramAnonymousa = com.tencent.mm.platformtools.z.a(paramAnonymousa.gte.FNI);
        ae.d("MicroMsg.SubCoreMall", "receive pay msg: %s", new Object[] { paramAnonymousa });
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66014);
            com.tencent.mm.plugin.wallet_core.model.mall.c.eKB();
            com.tencent.mm.plugin.wallet_core.model.mall.c.aFU(paramAnonymousa);
            AppMethodBeat.o(66014);
          }
        });
        AppMethodBeat.o(66015);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    AppMethodBeat.o(66016);
  }
  
  public static k dmZ()
  {
    AppMethodBeat.i(66017);
    k localk = (k)u.ap(k.class);
    AppMethodBeat.o(66017);
    return localk;
  }
  
  public final com.tencent.mm.plugin.wallet_core.model.z Kb(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(66018);
    Object localObject3;
    if (!this.vPz.contains(Integer.valueOf(paramInt)))
    {
      localObject3 = t.eJk();
      String str = "select * from WalletFunciontList where wallet_region = ".concat(String.valueOf(paramInt));
      localObject3 = ((com.tencent.mm.plugin.wallet_core.d.f)localObject3).db.a(str, null, 2);
      ae.i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo ".concat(String.valueOf(str)));
      if (localObject3 != null) {
        break label126;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.vPz.put(Integer.valueOf(paramInt), localObject1);
      }
      localObject1 = (com.tencent.mm.plugin.wallet_core.model.z)this.vPz.get(Integer.valueOf(paramInt));
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
  
  public final ArrayList<MallFunction> Kc(int paramInt)
  {
    AppMethodBeat.i(66019);
    ArrayList localArrayList = Kb(paramInt).vPk;
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
    ((s)g.ad(s.class)).getSysCmdMsgExtension().a("mallactivity", this.vPB, true);
    ((s)g.ad(s.class)).getSysCmdMsgExtension().a("paymsg", this.vPC, true);
    com.tencent.mm.plugin.wallet_core.model.mall.c.eKB().Zm();
    d.eKF().Zm();
    if ((v.aAR()) && (v.aAM())) {
      com.tencent.mm.plugin.wallet_core.model.mall.b.Wi(com.tencent.mm.plugin.wallet_core.model.mall.b.DsY);
    }
    for (;;)
    {
      g.ajS();
      g.ajQ().gDv.a(302, this);
      AppMethodBeat.o(66020);
      return;
      com.tencent.mm.plugin.wallet_core.model.mall.b.Wi(com.tencent.mm.plugin.wallet_core.model.mall.b.DsX);
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66021);
    ((s)g.ad(s.class)).getSysCmdMsgExtension().b("mallactivity", this.vPB, true);
    ((s)g.ad(s.class)).getSysCmdMsgExtension().b("paymsg", this.vPC, true);
    g.ajS();
    g.ajQ().gDv.b(302, this);
    AppMethodBeat.o(66021);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66022);
    if ((paramInt2 == 0) && (paramInt1 == 0) && (!this.vPA) && (v.aAR()))
    {
      this.vPA = true;
      com.tencent.mm.plugin.wallet_core.model.mall.b.Wi(com.tencent.mm.plugin.wallet_core.model.mall.b.DsY);
    }
    AppMethodBeat.o(66022);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.k
 * JD-Core Version:    0.7.0.1
 */