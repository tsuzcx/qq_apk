package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class k
  implements i, be
{
  ConcurrentHashMap<Integer, aa> EOU;
  private boolean EOV;
  private ck.a EOW;
  private ck.a EOX;
  private MMHandler mHandler;
  
  public k()
  {
    AppMethodBeat.i(66016);
    this.EOU = new ConcurrentHashMap();
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.EOV = false;
    this.EOW = new ck.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(66013);
        paramAnonymousa = com.tencent.mm.platformtools.z.a(paramAnonymousa.jQG.RIF);
        Log.d("MicroMsg.SubCoreMall", "WalletNotifyConfXml:".concat(String.valueOf(paramAnonymousa)));
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66012);
            com.tencent.mm.plugin.wallet_core.model.mall.c localc = com.tencent.mm.plugin.wallet_core.model.mall.c.gKL();
            Object localObject = paramAnonymousa;
            MallNews localMallNews = com.tencent.mm.plugin.wallet_core.model.mall.c.bhf((String)localObject);
            if (localMallNews != null)
            {
              if (!"2".equals(localMallNews.type))
              {
                localc.OUH.put(localMallNews.lCb, localMallNews);
                Log.i("MicroMsg.MallNewsManager", "onRecieveMsg : ".concat(String.valueOf(localObject)));
                localc.fpp();
                if (com.tencent.mm.plugin.wallet_core.model.mall.c.a(localMallNews))
                {
                  Log.i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
                  AppMethodBeat.o(66012);
                  return;
                }
                if (localMallNews.fwp == 0) {
                  if ((localMallNews.fZX == 0) || (localMallNews.fZX == 1))
                  {
                    Log.i("MicroMsg.MallNewsManager", "showType New");
                    com.tencent.mm.aa.c.aFn().C(262156, true);
                    h.aHH();
                    h.aHG().aHp().set(ar.a.VqN, Long.valueOf(System.currentTimeMillis()));
                  }
                }
                for (;;)
                {
                  com.tencent.mm.plugin.wallet_core.model.mall.c.gKN();
                  AppMethodBeat.o(66012);
                  return;
                  Log.i("MicroMsg.MallNewsManager", "showType New with wallet region:%d", new Object[] { Integer.valueOf(localMallNews.fZX) });
                  h.aHH();
                  h.aHG().aHp().set(ar.a.VqP, Integer.valueOf(localMallNews.fZX));
                  h.aHH();
                  h.aHG().aHp().set(ar.a.VqQ, Integer.valueOf(1));
                  continue;
                  if (localMallNews.fwp == 1) {
                    if ((localMallNews.fZX == 0) || (localMallNews.fZX == 1))
                    {
                      Log.d("MicroMsg.MallNewsManager", "showType Dot");
                      com.tencent.mm.aa.c.aFn().D(262156, true);
                      h.aHH();
                      h.aHG().aHp().set(ar.a.VqN, Long.valueOf(System.currentTimeMillis()));
                    }
                    else
                    {
                      Log.i("MicroMsg.MallNewsManager", "showType dot with wallet region:%d", new Object[] { Integer.valueOf(localMallNews.fZX) });
                      h.aHH();
                      h.aHG().aHp().set(ar.a.VqP, Integer.valueOf(localMallNews.fZX));
                      h.aHH();
                      h.aHG().aHp().set(ar.a.VqQ, Integer.valueOf(2));
                    }
                  }
                }
              }
              Log.d("MicroMsg.MallNewsManager", "removeNews : ".concat(String.valueOf(localMallNews)));
              localObject = (MallNews)localc.OUH.get(localMallNews.lCb);
              if ((localObject != null) && (((MallNews)localObject).oym.equals(localMallNews.oym)) && (((MallNews)localObject).fAo.equals(localMallNews.fAo)))
              {
                Log.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + localMallNews.lCb);
                localc.OUH.remove(localMallNews.lCb);
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
    this.EOX = new ck.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(66015);
        paramAnonymousa = com.tencent.mm.platformtools.z.a(paramAnonymousa.jQG.RIF);
        Log.d("MicroMsg.SubCoreMall", "receive pay msg: %s", new Object[] { paramAnonymousa });
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66014);
            com.tencent.mm.plugin.wallet_core.model.mall.c.gKL();
            com.tencent.mm.plugin.wallet_core.model.mall.c.bhc(paramAnonymousa);
            AppMethodBeat.o(66014);
          }
        });
        AppMethodBeat.o(66015);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    AppMethodBeat.o(66016);
  }
  
  public static k eQr()
  {
    AppMethodBeat.i(66017);
    k localk = (k)y.as(k.class);
    AppMethodBeat.o(66017);
    return localk;
  }
  
  public final aa Wp(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(66018);
    Object localObject3;
    if (!this.EOU.contains(Integer.valueOf(paramInt)))
    {
      localObject3 = u.gJt();
      String str = "select * from WalletFunciontList where wallet_region = ".concat(String.valueOf(paramInt));
      localObject3 = ((com.tencent.mm.plugin.wallet_core.d.f)localObject3).db.rawQuery(str, null, 2);
      Log.i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo ".concat(String.valueOf(str)));
      if (localObject3 != null) {
        break label126;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.EOU.put(Integer.valueOf(paramInt), localObject1);
      }
      localObject1 = (aa)this.EOU.get(Integer.valueOf(paramInt));
      if (localObject1 != null) {
        break;
      }
      localObject1 = new aa();
      AppMethodBeat.o(66018);
      return localObject1;
      label126:
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToNext())
      {
        localObject1 = new aa();
        ((aa)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
    }
    AppMethodBeat.o(66018);
    return localObject1;
  }
  
  public final ArrayList<MallFunction> Wq(int paramInt)
  {
    AppMethodBeat.i(66019);
    ArrayList localArrayList = Wp(paramInt).EOE;
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
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("mallactivity", this.EOW, true);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("paymsg", this.EOX, true);
    com.tencent.mm.plugin.wallet_core.model.mall.c.gKL().ata();
    d.gKP().ata();
    if ((com.tencent.mm.model.z.bdq()) && (com.tencent.mm.model.z.bdl())) {
      b.amz(b.OUw);
    }
    for (;;)
    {
      h.aHH();
      h.aHF().kcd.a(302, this);
      AppMethodBeat.o(66020);
      return;
      b.amz(b.OUv);
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66021);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("mallactivity", this.EOW, true);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("paymsg", this.EOX, true);
    h.aHH();
    h.aHF().kcd.b(302, this);
    AppMethodBeat.o(66021);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(66022);
    if ((paramInt2 == 0) && (paramInt1 == 0) && (!this.EOV) && (com.tencent.mm.model.z.bdq()))
    {
      this.EOV = true;
      b.amz(b.OUw);
    }
    AppMethodBeat.o(66022);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.k
 * JD-Core Version:    0.7.0.1
 */