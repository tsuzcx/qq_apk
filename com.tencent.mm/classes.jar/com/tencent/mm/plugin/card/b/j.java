package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.m.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class j
  implements com.tencent.mm.ai.f
{
  private List<WeakReference<j.a>> kkV;
  public ArrayList<String> klQ;
  public ArrayList<String> klR;
  public ak klS;
  public HashMap<String, Runnable> klT;
  
  public j()
  {
    AppMethodBeat.i(87728);
    this.kkV = new ArrayList();
    this.klQ = new ArrayList();
    this.klR = new ArrayList();
    this.klS = new ak();
    this.klT = new LinkedHashMap();
    com.tencent.mm.kernel.g.RK().eHt.a(907, this);
    this.klQ.clear();
    this.klR.clear();
    this.klT.clear();
    AppMethodBeat.o(87728);
  }
  
  private void HC(String paramString)
  {
    AppMethodBeat.i(87733);
    ab.i("MicroMsg.CardMarkCodeMgr", "removeId()");
    if ((this.klQ.contains(paramString)) && (!this.klR.contains(paramString)))
    {
      this.klQ.remove(paramString);
      ab.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if ((!this.klQ.contains(paramString)) && (this.klR.contains(paramString)))
    {
      this.klR.remove(paramString);
      Runnable localRunnable = (Runnable)this.klT.get(paramString);
      this.klT.remove(paramString);
      this.klS.removeCallbacks(localRunnable);
      ab.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
      ab.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(87733);
  }
  
  private void HD(String paramString)
  {
    AppMethodBeat.i(87734);
    ab.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
    if (this.klR.contains(paramString))
    {
      this.klR.remove(paramString);
      ab.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if (this.klT.containsKey(paramString))
    {
      ab.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
      Runnable localRunnable = (Runnable)this.klT.get(paramString);
      this.klT.remove(paramString);
      this.klS.removeCallbacks(localRunnable);
    }
    AppMethodBeat.o(87734);
  }
  
  private void a(String paramString, j.b paramb)
  {
    AppMethodBeat.i(87731);
    ab.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
    if (this.kkV == null)
    {
      AppMethodBeat.o(87731);
      return;
    }
    if ((!this.klQ.contains(paramString)) && (!this.klR.contains(paramString)))
    {
      ab.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
      AppMethodBeat.o(87731);
      return;
    }
    int i = 0;
    if (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (j.a)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (!this.klQ.contains(paramString)) {
            break label137;
          }
          ((j.a)localObject).b(paramString, paramb);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label137:
        if (this.klR.contains(paramString)) {
          ((j.a)localObject).HE(paramString);
        }
      }
    }
    AppMethodBeat.o(87731);
  }
  
  private void dn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(87732);
    ab.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
    if (this.kkV == null)
    {
      AppMethodBeat.o(87732);
      return;
    }
    if ((!this.klQ.contains(paramString1)) || (this.klR.contains(paramString1)))
    {
      ab.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
      AppMethodBeat.o(87732);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (j.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((j.a)localObject).jdMethod_do(paramString1, paramString2);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87732);
  }
  
  static void i(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(87737);
    if (TextUtils.isEmpty(paramString))
    {
      ab.i("MicroMsg.CardMarkCodeMgr", "card_id is empty, don't call NetSceneMarkShareCard cgi");
      AppMethodBeat.o(87737);
      return;
    }
    ab.i("MicroMsg.CardMarkCodeMgr", "doMarkNetscene()");
    paramString = new com.tencent.mm.plugin.card.sharecard.model.f(paramString, paramInt1, paramInt2, paramInt3);
    com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
    AppMethodBeat.o(87737);
  }
  
  public final void W(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(87735);
    ab.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
    HD(paramString);
    if (!this.klQ.contains(paramString)) {
      this.klQ.add(paramString);
    }
    i(paramString, paramInt1, 1, paramInt2);
    AppMethodBeat.o(87735);
  }
  
  public final void a(j.a parama)
  {
    AppMethodBeat.i(87729);
    if (this.kkV == null) {
      this.kkV = new ArrayList();
    }
    this.kkV.add(new WeakReference(parama));
    AppMethodBeat.o(87729);
  }
  
  public final void b(j.a parama)
  {
    AppMethodBeat.i(87730);
    if (this.kkV == null)
    {
      AppMethodBeat.o(87730);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      WeakReference localWeakReference = (WeakReference)this.kkV.get(i);
      if (localWeakReference != null)
      {
        j.a locala = (j.a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.kkV.remove(localWeakReference);
          AppMethodBeat.o(87730);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87730);
  }
  
  public final void bN(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(87736);
    ab.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
    HD(paramString);
    this.klR.add(paramString);
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(87727);
        j.i(paramString, this.klV, this.klW, paramInt);
        ab.i("MicroMsg.CardMarkCodeMgr", "run the unmark task, the card is " + paramString + " system.time:" + System.currentTimeMillis());
        AppMethodBeat.o(87727);
      }
    };
    paramInt = bo.getInt(com.tencent.mm.m.g.Nr().R("ShareCard", "UnMarkDelay"), 0);
    this.klS.postDelayed(local1, paramInt * 1000);
    this.klT.put(paramString, local1);
    ab.i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + paramString + " system.time:" + System.currentTimeMillis());
    AppMethodBeat.o(87736);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(87738);
    ab.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.f))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.f)paramm;
        paramm = new j.b();
        paramm.klY = paramString.klY;
        paramm.klZ = paramString.klZ;
        paramm.kma = paramString.kma;
        paramm.kmb = paramString.kmb;
        paramm.kmc = paramString.kmc;
        ab.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + paramString.kpQ);
        ab.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + paramm.klY + " mark_succ:" + paramm.klZ + " mark_card_id:" + paramm.kma + " expire_time:" + paramm.kmb + " pay_qrcode_wording:" + paramm.kmc);
        a(paramString.kpQ, paramm);
        HC(paramString.kpQ);
        AppMethodBeat.o(87738);
      }
    }
    else if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.f))
    {
      paramm = (com.tencent.mm.plugin.card.sharecard.model.f)paramm;
      ab.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + paramm.kpQ);
      dn(paramm.kpQ, paramString);
      HC(paramm.kpQ);
    }
    AppMethodBeat.o(87738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.j
 * JD-Core Version:    0.7.0.1
 */