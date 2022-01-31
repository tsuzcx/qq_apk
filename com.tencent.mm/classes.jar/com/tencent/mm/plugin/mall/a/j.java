package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class j
  implements f, at
{
  private ak mHandler;
  ConcurrentHashMap<Integer, y> oxW;
  private boolean oxX;
  private bz.a oxY;
  private bz.a oxZ;
  
  public j()
  {
    AppMethodBeat.i(43120);
    this.oxW = new ConcurrentHashMap();
    this.mHandler = new ak(Looper.getMainLooper());
    this.oxX = false;
    this.oxY = new j.1(this);
    this.oxZ = new j.2(this);
    AppMethodBeat.o(43120);
  }
  
  public static j bOs()
  {
    AppMethodBeat.i(43121);
    j localj = (j)q.S(j.class);
    AppMethodBeat.o(43121);
    return localj;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(43124);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("mallactivity", this.oxY, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", this.oxZ, true);
    c.cUX().Kc();
    d.cVb().Kc();
    if ((r.ZB()) && (r.Zw())) {
      com.tencent.mm.plugin.wallet_core.model.mall.b.IB(com.tencent.mm.plugin.wallet_core.model.mall.b.umm);
    }
    for (;;)
    {
      g.RM();
      g.RK().eHt.a(302, this);
      AppMethodBeat.o(43124);
      return;
      com.tencent.mm.plugin.wallet_core.model.mall.b.IB(com.tencent.mm.plugin.wallet_core.model.mall.b.uml);
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(43125);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("mallactivity", this.oxY, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", this.oxZ, true);
    g.RM();
    g.RK().eHt.b(302, this);
    AppMethodBeat.o(43125);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(43126);
    if ((paramInt2 == 0) && (paramInt1 == 0) && (!this.oxX) && (r.ZB()))
    {
      this.oxX = true;
      com.tencent.mm.plugin.wallet_core.model.mall.b.IB(com.tencent.mm.plugin.wallet_core.model.mall.b.umm);
    }
    AppMethodBeat.o(43126);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public final y yJ(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(43122);
    Object localObject3;
    if (!this.oxW.contains(Integer.valueOf(paramInt)))
    {
      localObject3 = t.cTS();
      String str = "select * from WalletFunciontList where wallet_region = ".concat(String.valueOf(paramInt));
      localObject3 = ((com.tencent.mm.plugin.wallet_core.d.e)localObject3).db.a(str, null, 2);
      ab.i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo ".concat(String.valueOf(str)));
      if (localObject3 != null) {
        break label126;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.oxW.put(Integer.valueOf(paramInt), localObject1);
      }
      localObject1 = (y)this.oxW.get(Integer.valueOf(paramInt));
      if (localObject1 != null) {
        break;
      }
      localObject1 = new y();
      AppMethodBeat.o(43122);
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
    AppMethodBeat.o(43122);
    return localObject1;
  }
  
  public final ArrayList<MallFunction> yK(int paramInt)
  {
    AppMethodBeat.i(43123);
    ArrayList localArrayList = yJ(paramInt).oxK;
    AppMethodBeat.o(43123);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.j
 * JD-Core Version:    0.7.0.1
 */