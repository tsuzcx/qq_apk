package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.m.c;
import com.tencent.mm.plugin.card.sharecard.model.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class j
  implements com.tencent.mm.al.g
{
  public ArrayList<String> nqW;
  public ArrayList<String> nqX;
  public ap nqY;
  public HashMap<String, Runnable> nqZ;
  private List<WeakReference<a>> nqa;
  
  public j()
  {
    AppMethodBeat.i(112672);
    this.nqa = new ArrayList();
    this.nqW = new ArrayList();
    this.nqX = new ArrayList();
    this.nqY = new ap();
    this.nqZ = new LinkedHashMap();
    com.tencent.mm.kernel.g.afA().gcy.a(1078, this);
    this.nqW.clear();
    this.nqX.clear();
    this.nqZ.clear();
    AppMethodBeat.o(112672);
  }
  
  private void Qm(String paramString)
  {
    AppMethodBeat.i(112677);
    ad.i("MicroMsg.CardMarkCodeMgr", "removeId()");
    if ((this.nqW.contains(paramString)) && (!this.nqX.contains(paramString)))
    {
      this.nqW.remove(paramString);
      ad.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if ((!this.nqW.contains(paramString)) && (this.nqX.contains(paramString)))
    {
      this.nqX.remove(paramString);
      Runnable localRunnable = (Runnable)this.nqZ.get(paramString);
      this.nqZ.remove(paramString);
      this.nqY.removeCallbacks(localRunnable);
      ad.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
      ad.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(112677);
  }
  
  private void Qn(String paramString)
  {
    AppMethodBeat.i(112678);
    ad.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
    if (this.nqX.contains(paramString))
    {
      this.nqX.remove(paramString);
      ad.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if (this.nqZ.containsKey(paramString))
    {
      ad.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
      Runnable localRunnable = (Runnable)this.nqZ.get(paramString);
      this.nqZ.remove(paramString);
      this.nqY.removeCallbacks(localRunnable);
    }
    AppMethodBeat.o(112678);
  }
  
  private void a(String paramString, b paramb)
  {
    AppMethodBeat.i(112675);
    ad.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
    if (this.nqa == null)
    {
      AppMethodBeat.o(112675);
      return;
    }
    if ((!this.nqW.contains(paramString)) && (!this.nqX.contains(paramString)))
    {
      ad.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
      AppMethodBeat.o(112675);
      return;
    }
    int i = 0;
    if (i < this.nqa.size())
    {
      Object localObject = (WeakReference)this.nqa.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (!this.nqW.contains(paramString)) {
            break label137;
          }
          ((a)localObject).b(paramString, paramb);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label137:
        if (this.nqX.contains(paramString)) {
          ((a)localObject).Qo(paramString);
        }
      }
    }
    AppMethodBeat.o(112675);
  }
  
  private void ex(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112676);
    ad.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
    if (this.nqa == null)
    {
      AppMethodBeat.o(112676);
      return;
    }
    if ((!this.nqW.contains(paramString1)) || (this.nqX.contains(paramString1)))
    {
      ad.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
      AppMethodBeat.o(112676);
      return;
    }
    int i = 0;
    while (i < this.nqa.size())
    {
      Object localObject = (WeakReference)this.nqa.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).ey(paramString1, paramString2);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112676);
  }
  
  static void k(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112681);
    if (TextUtils.isEmpty(paramString))
    {
      ad.i("MicroMsg.CardMarkCodeMgr", "card_id is empty, don't call NetSceneMarkShareCard cgi");
      AppMethodBeat.o(112681);
      return;
    }
    ad.i("MicroMsg.CardMarkCodeMgr", "doMarkNetscene()");
    paramString = new f(paramString, paramInt1, paramInt2, paramInt3);
    com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
    AppMethodBeat.o(112681);
  }
  
  public final void T(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112679);
    ad.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
    Qn(paramString);
    if (!this.nqW.contains(paramString)) {
      this.nqW.add(paramString);
    }
    k(paramString, paramInt1, 1, paramInt2);
    AppMethodBeat.o(112679);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112673);
    if (this.nqa == null) {
      this.nqa = new ArrayList();
    }
    this.nqa.add(new WeakReference(parama));
    AppMethodBeat.o(112673);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112674);
    if (this.nqa == null)
    {
      AppMethodBeat.o(112674);
      return;
    }
    int i = 0;
    while (i < this.nqa.size())
    {
      WeakReference localWeakReference = (WeakReference)this.nqa.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.nqa.remove(localWeakReference);
          AppMethodBeat.o(112674);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112674);
  }
  
  public final void cw(String paramString, int paramInt)
  {
    AppMethodBeat.i(112680);
    ad.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
    Qn(paramString);
    this.nqX.add(paramString);
    j.1 local1 = new j.1(this, paramString, paramInt);
    paramInt = bt.getInt(com.tencent.mm.m.g.Ze().ad("ShareCard", "UnMarkDelay"), 0);
    this.nqY.postDelayed(local1, paramInt * 1000);
    this.nqZ.put(paramString, local1);
    ad.i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + paramString + " system.time:" + System.currentTimeMillis());
    AppMethodBeat.o(112680);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112682);
    ad.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof f))
      {
        paramString = (f)paramn;
        paramn = new b();
        paramn.nre = paramString.nre;
        paramn.nrf = paramString.nrf;
        paramn.nrg = paramString.nrg;
        paramn.nrh = paramString.nrh;
        paramn.nri = paramString.nri;
        ad.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + paramString.nvk);
        ad.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + paramn.nre + " mark_succ:" + paramn.nrf + " mark_card_id:" + paramn.nrg + " expire_time:" + paramn.nrh + " pay_qrcode_wording:" + paramn.nri);
        a(paramString.nvk, paramn);
        Qm(paramString.nvk);
        AppMethodBeat.o(112682);
      }
    }
    else if ((paramn instanceof f))
    {
      paramn = (f)paramn;
      ad.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + paramn.nvk);
      ex(paramn.nvk, paramString);
      Qm(paramn.nvk);
    }
    AppMethodBeat.o(112682);
  }
  
  public static abstract interface a
  {
    public abstract void Qo(String paramString);
    
    public abstract void b(String paramString, j.b paramb);
    
    public abstract void ey(String paramString1, String paramString2);
  }
  
  public static final class b
  {
    public String nre;
    public int nrf = 0;
    public String nrg;
    public int nrh;
    public String nri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.j
 * JD-Core Version:    0.7.0.1
 */