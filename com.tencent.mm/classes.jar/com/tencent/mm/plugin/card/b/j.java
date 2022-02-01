package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.d;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.card.sharecard.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class j
  implements i
{
  private List<WeakReference<a>> pQG;
  public ArrayList<String> pRC;
  public ArrayList<String> pRD;
  public MMHandler pRE;
  public HashMap<String, Runnable> pRF;
  
  public j()
  {
    AppMethodBeat.i(112672);
    this.pQG = new ArrayList();
    this.pRC = new ArrayList();
    this.pRD = new ArrayList();
    this.pRE = new MMHandler();
    this.pRF = new LinkedHashMap();
    g.aAg().hqi.a(1078, this);
    this.pRC.clear();
    this.pRD.clear();
    this.pRF.clear();
    AppMethodBeat.o(112672);
  }
  
  private void a(String paramString, b paramb)
  {
    AppMethodBeat.i(112675);
    Log.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
    if (this.pQG == null)
    {
      AppMethodBeat.o(112675);
      return;
    }
    if ((!this.pRC.contains(paramString)) && (!this.pRD.contains(paramString)))
    {
      Log.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
      AppMethodBeat.o(112675);
      return;
    }
    int i = 0;
    if (i < this.pQG.size())
    {
      Object localObject = (WeakReference)this.pQG.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (!this.pRC.contains(paramString)) {
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
        if (this.pRD.contains(paramString)) {
          ((a)localObject).ajf(paramString);
        }
      }
    }
    AppMethodBeat.o(112675);
  }
  
  private void ajd(String paramString)
  {
    AppMethodBeat.i(112677);
    Log.i("MicroMsg.CardMarkCodeMgr", "removeId()");
    if ((this.pRC.contains(paramString)) && (!this.pRD.contains(paramString)))
    {
      this.pRC.remove(paramString);
      Log.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if ((!this.pRC.contains(paramString)) && (this.pRD.contains(paramString)))
    {
      this.pRD.remove(paramString);
      Runnable localRunnable = (Runnable)this.pRF.get(paramString);
      this.pRF.remove(paramString);
      this.pRE.removeCallbacks(localRunnable);
      Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
      Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(112677);
  }
  
  private void aje(String paramString)
  {
    AppMethodBeat.i(112678);
    Log.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
    if (this.pRD.contains(paramString))
    {
      this.pRD.remove(paramString);
      Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if (this.pRF.containsKey(paramString))
    {
      Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
      Runnable localRunnable = (Runnable)this.pRF.get(paramString);
      this.pRF.remove(paramString);
      this.pRE.removeCallbacks(localRunnable);
    }
    AppMethodBeat.o(112678);
  }
  
  private void fp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112676);
    Log.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
    if (this.pQG == null)
    {
      AppMethodBeat.o(112676);
      return;
    }
    if ((!this.pRC.contains(paramString1)) || (this.pRD.contains(paramString1)))
    {
      Log.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
      AppMethodBeat.o(112676);
      return;
    }
    int i = 0;
    while (i < this.pQG.size())
    {
      Object localObject = (WeakReference)this.pQG.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).fq(paramString1, paramString2);
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
      Log.i("MicroMsg.CardMarkCodeMgr", "card_id is empty, don't call NetSceneMarkShareCard cgi");
      AppMethodBeat.o(112681);
      return;
    }
    Log.i("MicroMsg.CardMarkCodeMgr", "doMarkNetscene()");
    paramString = new f(paramString, paramInt1, paramInt2, paramInt3);
    g.aAg().hqi.a(paramString, 0);
    AppMethodBeat.o(112681);
  }
  
  public final void V(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112679);
    Log.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
    aje(paramString);
    if (!this.pRC.contains(paramString)) {
      this.pRC.add(paramString);
    }
    k(paramString, paramInt1, 1, paramInt2);
    AppMethodBeat.o(112679);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112673);
    if (this.pQG == null) {
      this.pQG = new ArrayList();
    }
    this.pQG.add(new WeakReference(parama));
    AppMethodBeat.o(112673);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112674);
    if (this.pQG == null)
    {
      AppMethodBeat.o(112674);
      return;
    }
    int i = 0;
    while (i < this.pQG.size())
    {
      WeakReference localWeakReference = (WeakReference)this.pQG.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.pQG.remove(localWeakReference);
          AppMethodBeat.o(112674);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112674);
  }
  
  public final void cO(String paramString, int paramInt)
  {
    AppMethodBeat.i(112680);
    Log.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
    aje(paramString);
    this.pRD.add(paramString);
    j.1 local1 = new j.1(this, paramString, paramInt);
    paramInt = Util.getInt(h.aqK().aj("ShareCard", "UnMarkDelay"), 0);
    this.pRE.postDelayed(local1, paramInt * 1000);
    this.pRF.put(paramString, local1);
    Log.i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + paramString + " system.time:" + System.currentTimeMillis());
    AppMethodBeat.o(112680);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(112682);
    Log.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof f))
      {
        paramString = (f)paramq;
        paramq = new b();
        paramq.pRK = paramString.pRK;
        paramq.pRL = paramString.pRL;
        paramq.pRM = paramString.pRM;
        paramq.pRN = paramString.pRN;
        paramq.pRO = paramString.pRO;
        Log.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + paramString.pVU);
        Log.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + paramq.pRK + " mark_succ:" + paramq.pRL + " mark_card_id:" + paramq.pRM + " expire_time:" + paramq.pRN + " pay_qrcode_wording:" + paramq.pRO);
        a(paramString.pVU, paramq);
        ajd(paramString.pVU);
        AppMethodBeat.o(112682);
      }
    }
    else if ((paramq instanceof f))
    {
      paramq = (f)paramq;
      Log.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + paramq.pVU);
      fp(paramq.pVU, paramString);
      ajd(paramq.pVU);
    }
    AppMethodBeat.o(112682);
  }
  
  public static abstract interface a
  {
    public abstract void ajf(String paramString);
    
    public abstract void b(String paramString, j.b paramb);
    
    public abstract void fq(String paramString1, String paramString2);
  }
  
  public static final class b
  {
    public String pRK;
    public int pRL = 0;
    public String pRM;
    public int pRN;
    public String pRO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.j
 * JD-Core Version:    0.7.0.1
 */