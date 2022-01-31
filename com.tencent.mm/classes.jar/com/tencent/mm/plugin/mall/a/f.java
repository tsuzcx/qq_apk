package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.m;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class f
  implements com.tencent.mm.ah.f, ar
{
  ConcurrentHashMap<Integer, t> lYr = new ConcurrentHashMap();
  private boolean lYs = false;
  private bx.a lYt = new f.1(this);
  private bx.a lYu = new bx.a()
  {
    public final void a(e.a paramAnonymousa)
    {
      paramAnonymousa = aa.a(paramAnonymousa.dBs.svH);
      y.d("MicroMsg.SubCoreMall", "receive pay msg: %s", new Object[] { paramAnonymousa });
      f.a(f.this).post(new f.2.1(this, paramAnonymousa));
    }
  };
  private ah mHandler = new ah(Looper.getMainLooper());
  
  public static f bgz()
  {
    return (f)com.tencent.mm.model.p.B(f.class);
  }
  
  public final void bh(boolean paramBoolean)
  {
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("mallactivity", this.lYt, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", this.lYu, true);
    c.bWg().xK();
    d.bWk().xK();
    if ((q.Gw()) && (q.Gs())) {
      com.tencent.mm.plugin.wallet_core.model.mall.b.AQ(com.tencent.mm.plugin.wallet_core.model.mall.b.qzC);
    }
    for (;;)
    {
      g.DQ();
      g.DO().dJT.a(302, this);
      return;
      com.tencent.mm.plugin.wallet_core.model.mall.b.AQ(com.tencent.mm.plugin.wallet_core.model.mall.b.qzB);
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("mallactivity", this.lYt, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", this.lYu, true);
    g.DQ();
    g.DO().dJT.b(302, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt2 == 0) && (paramInt1 == 0) && (!this.lYs) && (q.Gw()))
    {
      this.lYs = true;
      com.tencent.mm.plugin.wallet_core.model.mall.b.AQ(com.tencent.mm.plugin.wallet_core.model.mall.b.qzC);
    }
  }
  
  public final t tx(int paramInt)
  {
    t localt = null;
    Object localObject1 = null;
    Object localObject2;
    if (!this.lYr.contains(Integer.valueOf(paramInt)))
    {
      localObject2 = o.bVx();
      String str = "select * from WalletFunciontList where wallet_region = " + paramInt;
      localObject2 = ((com.tencent.mm.plugin.wallet_core.d.e)localObject2).dXw.a(str, null, 2);
      y.i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo " + str);
      if (localObject2 != null) {
        break label132;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.lYr.put(Integer.valueOf(paramInt), localObject1);
      }
      localt = (t)this.lYr.get(Integer.valueOf(paramInt));
      localObject1 = localt;
      if (localt == null) {
        localObject1 = new t();
      }
      return localObject1;
      label132:
      localObject1 = localt;
      if (((Cursor)localObject2).moveToNext())
      {
        localObject1 = new t();
        ((t)localObject1).d((Cursor)localObject2);
      }
      ((Cursor)localObject2).close();
    }
  }
  
  public final ArrayList<MallFunction> ty(int paramInt)
  {
    return tx(paramInt).lYj;
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.f
 * JD-Core Version:    0.7.0.1
 */