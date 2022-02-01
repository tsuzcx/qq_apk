package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class k
  implements com.tencent.mm.am.h, be
{
  ConcurrentHashMap<Integer, aa> KJs;
  private boolean KJt;
  private cl.a KJu;
  private cl.a KJv;
  private MMHandler mHandler;
  
  public k()
  {
    AppMethodBeat.i(66016);
    this.KJs = new ConcurrentHashMap();
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.KJt = false;
    this.KJu = new cl.a()
    {
      public final void a(final g.a paramAnonymousa)
      {
        AppMethodBeat.i(66013);
        paramAnonymousa = w.a(paramAnonymousa.mpN.YFG);
        Log.d("MicroMsg.SubCoreMall", "WalletNotifyConfXml:".concat(String.valueOf(paramAnonymousa)));
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66012);
            com.tencent.mm.plugin.wallet_core.model.mall.c localc = com.tencent.mm.plugin.wallet_core.model.mall.c.ikd();
            Object localObject = paramAnonymousa;
            MallNews localMallNews = com.tencent.mm.plugin.wallet_core.model.mall.c.bgP((String)localObject);
            if (localMallNews != null)
            {
              if (!"2".equals(localMallNews.type))
              {
                localc.VKY.put(localMallNews.otL, localMallNews);
                Log.i("MicroMsg.MallNewsManager", "onRecieveMsg : ".concat(String.valueOf(localObject)));
                localc.gAt();
                if (com.tencent.mm.plugin.wallet_core.model.mall.c.a(localMallNews))
                {
                  Log.i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
                  AppMethodBeat.o(66012);
                  return;
                }
                if (localMallNews.hAN == 0) {
                  if ((localMallNews.igf == 0) || (localMallNews.igf == 1))
                  {
                    Log.i("MicroMsg.MallNewsManager", "showType New");
                    com.tencent.mm.aa.c.aYo().Q(262156, true);
                    com.tencent.mm.kernel.h.baF();
                    com.tencent.mm.kernel.h.baE().ban().set(at.a.acSp, Long.valueOf(System.currentTimeMillis()));
                  }
                }
                for (;;)
                {
                  com.tencent.mm.plugin.wallet_core.model.mall.c.ikf();
                  AppMethodBeat.o(66012);
                  return;
                  Log.i("MicroMsg.MallNewsManager", "showType New with wallet region:%d", new Object[] { Integer.valueOf(localMallNews.igf) });
                  com.tencent.mm.kernel.h.baF();
                  com.tencent.mm.kernel.h.baE().ban().set(at.a.acSr, Integer.valueOf(localMallNews.igf));
                  com.tencent.mm.kernel.h.baF();
                  com.tencent.mm.kernel.h.baE().ban().set(at.a.acSs, Integer.valueOf(1));
                  continue;
                  if (localMallNews.hAN == 1) {
                    if ((localMallNews.igf == 0) || (localMallNews.igf == 1))
                    {
                      Log.d("MicroMsg.MallNewsManager", "showType Dot");
                      com.tencent.mm.aa.c.aYo().R(262156, true);
                      com.tencent.mm.kernel.h.baF();
                      com.tencent.mm.kernel.h.baE().ban().set(at.a.acSp, Long.valueOf(System.currentTimeMillis()));
                    }
                    else
                    {
                      Log.i("MicroMsg.MallNewsManager", "showType dot with wallet region:%d", new Object[] { Integer.valueOf(localMallNews.igf) });
                      com.tencent.mm.kernel.h.baF();
                      com.tencent.mm.kernel.h.baE().ban().set(at.a.acSr, Integer.valueOf(localMallNews.igf));
                      com.tencent.mm.kernel.h.baF();
                      com.tencent.mm.kernel.h.baE().ban().set(at.a.acSs, Integer.valueOf(2));
                    }
                  }
                }
              }
              Log.d("MicroMsg.MallNewsManager", "removeNews : ".concat(String.valueOf(localMallNews)));
              localObject = (MallNews)localc.VKY.get(localMallNews.otL);
              if ((localObject != null) && (((MallNews)localObject).rBJ.equals(localMallNews.rBJ)) && (((MallNews)localObject).hFb.equals(localMallNews.hFb)))
              {
                Log.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + localMallNews.otL);
                localc.VKY.remove(localMallNews.otL);
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
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.KJv = new cl.a()
    {
      public final void a(final g.a paramAnonymousa)
      {
        AppMethodBeat.i(66015);
        paramAnonymousa = w.a(paramAnonymousa.mpN.YFG);
        Log.d("MicroMsg.SubCoreMall", "receive pay msg: %s", new Object[] { paramAnonymousa });
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66014);
            com.tencent.mm.plugin.wallet_core.model.mall.c.ikd();
            com.tencent.mm.plugin.wallet_core.model.mall.c.bgM(paramAnonymousa);
            AppMethodBeat.o(66014);
          }
        });
        AppMethodBeat.o(66015);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    AppMethodBeat.o(66016);
  }
  
  public static k fZb()
  {
    AppMethodBeat.i(66017);
    k localk = (k)y.aL(k.class);
    AppMethodBeat.o(66017);
    return localk;
  }
  
  public final aa aal(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(66018);
    Object localObject3;
    if (!this.KJs.contains(Integer.valueOf(paramInt)))
    {
      localObject3 = u.iiH();
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
        this.KJs.put(Integer.valueOf(paramInt), localObject1);
      }
      localObject1 = (aa)this.KJs.get(Integer.valueOf(paramInt));
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
  
  public final ArrayList<MallFunction> aam(int paramInt)
  {
    AppMethodBeat.i(66019);
    ArrayList localArrayList = aal(paramInt).KJd;
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
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("mallactivity", this.KJu, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("paymsg", this.KJv, true);
    com.tencent.mm.plugin.wallet_core.model.mall.c.ikd().aNi();
    d.ikh().aNi();
    if ((z.bBi()) && (z.bBd())) {
      b.asn(b.VKN);
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(302, this);
      AppMethodBeat.o(66020);
      return;
      b.asn(b.VKM);
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66021);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("mallactivity", this.KJu, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("paymsg", this.KJv, true);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(302, this);
    AppMethodBeat.o(66021);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(66022);
    if ((paramInt2 == 0) && (paramInt1 == 0) && (!this.KJt) && (z.bBi()))
    {
      this.KJt = true;
      b.asn(b.VKN);
    }
    AppMethodBeat.o(66022);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.k
 * JD-Core Version:    0.7.0.1
 */