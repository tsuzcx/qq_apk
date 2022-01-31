package com.tencent.mm.plugin.card.b;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class m
  implements f, b.a
{
  private ak handler;
  public Map<String, Set<m.a>> kmf;
  public HashMap<String, String> kmg;
  private String kmh;
  public v kmi;
  
  public m()
  {
    AppMethodBeat.i(87760);
    this.kmf = new HashMap();
    this.kmg = new HashMap();
    g.RK().eHt.a(563, this);
    this.handler = new ak(Looper.getMainLooper());
    AppMethodBeat.o(87760);
  }
  
  private void a(String paramString, boolean paramBoolean, ArrayList<oz> paramArrayList)
  {
    AppMethodBeat.i(87762);
    this.handler.post(new m.1(this, paramString, paramBoolean, paramArrayList));
    AppMethodBeat.o(87762);
  }
  
  public final void a(String paramString, m.a arg2)
  {
    AppMethodBeat.i(87761);
    try
    {
      label45:
      synchronized (this.kmf)
      {
        if (this.kmf.get(paramString) != null) {
          ((Set)this.kmf.get(paramString)).remove(???);
        }
      }
      synchronized (this.kmg)
      {
        this.kmg.remove(paramString);
        AppMethodBeat.o(87761);
        return;
        paramString = finally;
        AppMethodBeat.o(87761);
        throw paramString;
      }
    }
    catch (Exception ???)
    {
      break label45;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, m.a arg3)
  {
    AppMethodBeat.i(87763);
    ab.d("MicroMsg.CardShopLBSManager", "getShopList, cardTpId = %s, card_id = %s", new Object[] { paramString1, paramString2 });
    this.kmh = paramString1;
    synchronized (this.kmf)
    {
      if (!this.kmf.containsKey(paramString1)) {
        this.kmf.put(paramString1, new HashSet());
      }
      if (!((Set)this.kmf.get(paramString1)).contains(???)) {
        ((Set)this.kmf.get(paramString1)).add(???);
      }
    }
    for (;;)
    {
      synchronized (this.kmg)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          this.kmg.put(paramString1, paramString2);
        }
        paramString1 = d.agQ();
        if (paramString1 == null)
        {
          ab.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
          i = 0;
          if (i != 0) {
            break;
          }
          ab.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
          AppMethodBeat.o(87763);
          return false;
          paramString1 = finally;
          AppMethodBeat.o(87763);
          throw paramString1;
        }
      }
      paramString1.b(this);
      int i = 1;
    }
    if (this.kmi != null) {
      g.RK().eHt.a(this.kmi);
    }
    AppMethodBeat.o(87763);
    return true;
  }
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(87765);
    if (!paramBoolean)
    {
      AppMethodBeat.o(87765);
      return true;
    }
    ??? = d.agQ();
    if (??? != null) {
      ((com.tencent.mm.modelgeo.b)???).c(this);
    }
    ab.d("MicroMsg.CardShopLBSManager", "onGetLocation, fLongitude = %f, fLatitude = %f, locType = %d, speed = %f, accuracy = %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    synchronized (this.kmf)
    {
      Set localSet = (Set)this.kmf.get(this.kmh);
      if ((localSet == null) || (localSet.size() == 0))
      {
        ab.e("MicroMsg.CardShopLBSManager", "onGetLocation, already cancelled, no need to doScene");
        AppMethodBeat.o(87765);
        return false;
      }
    }
    for (;;)
    {
      synchronized (this.kmg)
      {
        String str = (String)this.kmg.get(this.kmh);
        ??? = new v(this.kmh, paramFloat1, paramFloat2, str);
        if (g.RK().eHt.a((com.tencent.mm.ai.m)???, 0))
        {
          this.kmi = ((v)???);
          AppMethodBeat.o(87765);
          return true;
        }
      }
      ab.e("MicroMsg.CardShopLBSManager", "doScene fail, callback immediate");
      a(this.kmh, false, null);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(87764);
    this.kmi = null;
    paramString = ((v)paramm).koq;
    ab.i("MicroMsg.CardShopLBSManager", "onSceneEnd, reqCardTpId = %s, errType = %d, errCode = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.CardShopLBSManager", "onSceneEnd, cardshoplbs fail");
      a(paramString, false, null);
      AppMethodBeat.o(87764);
      return;
    }
    paramm = ((v)paramm).kor;
    if (paramm == null) {}
    for (paramInt1 = 0;; paramInt1 = paramm.size())
    {
      ab.d("MicroMsg.CardShopLBSManager", "onSceneEnd, respShopList size = %d", new Object[] { Integer.valueOf(paramInt1) });
      a(paramString, true, paramm);
      AppMethodBeat.o(87764);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.m
 * JD-Core Version:    0.7.0.1
 */