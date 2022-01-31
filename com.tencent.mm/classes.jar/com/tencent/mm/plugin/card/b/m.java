package com.tencent.mm.plugin.card.b;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class m
  implements f, a.a
{
  private ah handler;
  public Map<String, Set<m.a>> ilh = new HashMap();
  public HashMap<String, String> ili = new HashMap();
  private String ilj;
  public v ilk;
  
  public m()
  {
    g.DO().dJT.a(563, this);
    this.handler = new ah(Looper.getMainLooper());
  }
  
  private void a(String paramString, boolean paramBoolean, ArrayList<mb> paramArrayList)
  {
    this.handler.post(new m.1(this, paramString, paramBoolean, paramArrayList));
  }
  
  public final void a(String paramString, m.a arg2)
  {
    try
    {
      label40:
      synchronized (this.ilh)
      {
        if (this.ilh.get(paramString) != null) {
          ((Set)this.ilh.get(paramString)).remove(???);
        }
      }
      synchronized (this.ili)
      {
        this.ili.remove(paramString);
        return;
        paramString = finally;
        throw paramString;
      }
    }
    catch (Exception ???)
    {
      break label40;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, m.a arg3)
  {
    y.d("MicroMsg.CardShopLBSManager", "getShopList, cardTpId = %s, card_id = %s", new Object[] { paramString1, paramString2 });
    this.ilj = paramString1;
    synchronized (this.ilh)
    {
      if (!this.ilh.containsKey(paramString1)) {
        this.ilh.put(paramString1, new HashSet());
      }
      if (!((Set)this.ilh.get(paramString1)).contains(???)) {
        ((Set)this.ilh.get(paramString1)).add(???);
      }
    }
    for (;;)
    {
      synchronized (this.ili)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          this.ili.put(paramString1, paramString2);
        }
        paramString1 = c.Ob();
        if (paramString1 == null)
        {
          y.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
          i = 0;
          if (i != 0) {
            break;
          }
          y.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
          return false;
          paramString1 = finally;
          throw paramString1;
        }
      }
      paramString1.b(this);
      int i = 1;
    }
    if (this.ilk != null) {
      g.DO().dJT.c(this.ilk);
    }
    return true;
  }
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!paramBoolean) {
      return true;
    }
    ??? = c.Ob();
    if (??? != null) {
      ((a)???).c(this);
    }
    y.d("MicroMsg.CardShopLBSManager", "onGetLocation, fLongitude = %f, fLatitude = %f, locType = %d, speed = %f, accuracy = %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    synchronized (this.ilh)
    {
      Set localSet = (Set)this.ilh.get(this.ilj);
      if ((localSet == null) || (localSet.size() == 0))
      {
        y.e("MicroMsg.CardShopLBSManager", "onGetLocation, already cancelled, no need to doScene");
        return false;
      }
    }
    for (;;)
    {
      synchronized (this.ili)
      {
        String str = (String)this.ili.get(this.ilj);
        ??? = new v(this.ilj, paramFloat1, paramFloat2, str);
        if (g.DO().dJT.a((com.tencent.mm.ah.m)???, 0))
        {
          this.ilk = ((v)???);
          return true;
        }
      }
      y.e("MicroMsg.CardShopLBSManager", "doScene fail, callback immediate");
      a(this.ilj, false, null);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    this.ilk = null;
    paramString = ((v)paramm).inw;
    y.i("MicroMsg.CardShopLBSManager", "onSceneEnd, reqCardTpId = %s, errType = %d, errCode = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.CardShopLBSManager", "onSceneEnd, cardshoplbs fail");
      a(paramString, false, null);
      return;
    }
    paramm = ((v)paramm).inx;
    if (paramm == null) {}
    for (paramInt1 = 0;; paramInt1 = paramm.size())
    {
      y.d("MicroMsg.CardShopLBSManager", "onSceneEnd, respShopList size = %d", new Object[] { Integer.valueOf(paramInt1) });
      a(paramString, true, paramm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.m
 * JD-Core Version:    0.7.0.1
 */