package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.n;
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
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.y.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class j
  implements com.tencent.mm.ak.g, aw
{
  private ao mHandler;
  ConcurrentHashMap<Integer, y> uAQ;
  private boolean uAR;
  private cc.a uAS;
  private cc.a uAT;
  
  public j()
  {
    AppMethodBeat.i(66016);
    this.uAQ = new ConcurrentHashMap();
    this.mHandler = new ao(Looper.getMainLooper());
    this.uAR = false;
    this.uAS = new cc.a()
    {
      public final void a(final f.a paramAnonymousa)
      {
        AppMethodBeat.i(66013);
        paramAnonymousa = z.a(paramAnonymousa.fXi.DPV);
        ac.d("MicroMsg.SubCoreMall", "WalletNotifyConfXml:".concat(String.valueOf(paramAnonymousa)));
        j.a(j.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66012);
            com.tencent.mm.plugin.wallet_core.model.mall.c localc = com.tencent.mm.plugin.wallet_core.model.mall.c.esN();
            Object localObject = paramAnonymousa;
            MallNews localMallNews = com.tencent.mm.plugin.wallet_core.model.mall.c.azt((String)localObject);
            if (localMallNews != null)
            {
              if (!"2".equals(localMallNews.type))
              {
                localc.BBo.put(localMallNews.hvE, localMallNews);
                ac.i("MicroMsg.MallNewsManager", "onRecieveMsg : ".concat(String.valueOf(localObject)));
                localc.dpl();
                if (com.tencent.mm.plugin.wallet_core.model.mall.c.a(localMallNews))
                {
                  ac.i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
                  AppMethodBeat.o(66012);
                  return;
                }
                if (localMallNews.cZX == 0)
                {
                  ac.d("MicroMsg.MallNewsManager", "showType New");
                  com.tencent.mm.y.c.aeH().w(262156, true);
                  com.tencent.mm.kernel.g.agS();
                  com.tencent.mm.kernel.g.agR().agA().set(ah.a.GNG, Long.valueOf(System.currentTimeMillis()));
                }
                for (;;)
                {
                  com.tencent.mm.plugin.wallet_core.model.mall.c.esP();
                  AppMethodBeat.o(66012);
                  return;
                  if (localMallNews.cZX == 1)
                  {
                    ac.d("MicroMsg.MallNewsManager", "showType Dot");
                    com.tencent.mm.y.c.aeH().x(262156, true);
                    com.tencent.mm.kernel.g.agS();
                    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GNG, Long.valueOf(System.currentTimeMillis()));
                  }
                }
              }
              ac.d("MicroMsg.MallNewsManager", "removeNews : ".concat(String.valueOf(localMallNews)));
              localObject = (MallNews)localc.BBo.get(localMallNews.hvE);
              if ((localObject != null) && (((MallNews)localObject).zPC.equals(localMallNews.zPC)) && (((MallNews)localObject).ddJ.equals(localMallNews.ddJ)))
              {
                ac.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + localMallNews.hvE);
                localc.BBo.remove(localMallNews.hvE);
                AppMethodBeat.o(66012);
                return;
              }
              ac.i("MicroMsg.MallNewsManager", "onRecieveMsg cancel not found!");
            }
            AppMethodBeat.o(66012);
          }
        });
        AppMethodBeat.o(66013);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.uAT = new cc.a()
    {
      public final void a(final f.a paramAnonymousa)
      {
        AppMethodBeat.i(66015);
        paramAnonymousa = z.a(paramAnonymousa.fXi.DPV);
        ac.d("MicroMsg.SubCoreMall", "receive pay msg: %s", new Object[] { paramAnonymousa });
        j.a(j.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66014);
            com.tencent.mm.plugin.wallet_core.model.mall.c.esN();
            com.tencent.mm.plugin.wallet_core.model.mall.c.azq(paramAnonymousa);
            AppMethodBeat.o(66014);
          }
        });
        AppMethodBeat.o(66015);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    AppMethodBeat.o(66016);
  }
  
  public static j daN()
  {
    AppMethodBeat.i(66017);
    j localj = (j)t.ap(j.class);
    AppMethodBeat.o(66017);
    return localj;
  }
  
  public final y Ig(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(66018);
    Object localObject3;
    if (!this.uAQ.contains(Integer.valueOf(paramInt)))
    {
      localObject3 = s.erD();
      String str = "select * from WalletFunciontList where wallet_region = ".concat(String.valueOf(paramInt));
      localObject3 = ((f)localObject3).db.a(str, null, 2);
      ac.i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo ".concat(String.valueOf(str)));
      if (localObject3 != null) {
        break label126;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.uAQ.put(Integer.valueOf(paramInt), localObject1);
      }
      localObject1 = (y)this.uAQ.get(Integer.valueOf(paramInt));
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
  
  public final ArrayList<MallFunction> Ih(int paramInt)
  {
    AppMethodBeat.i(66019);
    ArrayList localArrayList = Ig(paramInt).uAD;
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
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("mallactivity", this.uAS, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("paymsg", this.uAT, true);
    com.tencent.mm.plugin.wallet_core.model.mall.c.esN().WJ();
    d.esR().WJ();
    if ((u.axL()) && (u.axG())) {
      com.tencent.mm.plugin.wallet_core.model.mall.b.TJ(com.tencent.mm.plugin.wallet_core.model.mall.b.BBc);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(302, this);
      AppMethodBeat.o(66020);
      return;
      com.tencent.mm.plugin.wallet_core.model.mall.b.TJ(com.tencent.mm.plugin.wallet_core.model.mall.b.BBb);
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66021);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("mallactivity", this.uAS, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("paymsg", this.uAT, true);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(302, this);
    AppMethodBeat.o(66021);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66022);
    if ((paramInt2 == 0) && (paramInt1 == 0) && (!this.uAR) && (u.axL()))
    {
      this.uAR = true;
      com.tencent.mm.plugin.wallet_core.model.mall.b.TJ(com.tencent.mm.plugin.wallet_core.model.mall.b.BBc);
    }
    AppMethodBeat.o(66022);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.j
 * JD-Core Version:    0.7.0.1
 */