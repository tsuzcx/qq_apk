package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.n.d;
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
  private List<WeakReference<a>> cSF;
  public ArrayList<String> tnC;
  public ArrayList<String> tnD;
  public MMHandler tnE;
  public HashMap<String, Runnable> tnF;
  
  public j()
  {
    AppMethodBeat.i(112672);
    this.cSF = new ArrayList();
    this.tnC = new ArrayList();
    this.tnD = new ArrayList();
    this.tnE = new MMHandler();
    this.tnF = new LinkedHashMap();
    com.tencent.mm.kernel.h.aHF().kcd.a(1078, this);
    this.tnC.clear();
    this.tnD.clear();
    this.tnF.clear();
    AppMethodBeat.o(112672);
  }
  
  private void a(String paramString, b paramb)
  {
    AppMethodBeat.i(112675);
    Log.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
    if (this.cSF == null)
    {
      AppMethodBeat.o(112675);
      return;
    }
    if ((!this.tnC.contains(paramString)) && (!this.tnD.contains(paramString)))
    {
      Log.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
      AppMethodBeat.o(112675);
      return;
    }
    int i = 0;
    if (i < this.cSF.size())
    {
      Object localObject = (WeakReference)this.cSF.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (!this.tnC.contains(paramString)) {
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
        if (this.tnD.contains(paramString)) {
          ((a)localObject).aqS(paramString);
        }
      }
    }
    AppMethodBeat.o(112675);
  }
  
  private void aqQ(String paramString)
  {
    AppMethodBeat.i(112677);
    Log.i("MicroMsg.CardMarkCodeMgr", "removeId()");
    if ((this.tnC.contains(paramString)) && (!this.tnD.contains(paramString)))
    {
      this.tnC.remove(paramString);
      Log.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if ((!this.tnC.contains(paramString)) && (this.tnD.contains(paramString)))
    {
      this.tnD.remove(paramString);
      Runnable localRunnable = (Runnable)this.tnF.get(paramString);
      this.tnF.remove(paramString);
      this.tnE.removeCallbacks(localRunnable);
      Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
      Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(112677);
  }
  
  private void aqR(String paramString)
  {
    AppMethodBeat.i(112678);
    Log.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
    if (this.tnD.contains(paramString))
    {
      this.tnD.remove(paramString);
      Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if (this.tnF.containsKey(paramString))
    {
      Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
      Runnable localRunnable = (Runnable)this.tnF.get(paramString);
      this.tnF.remove(paramString);
      this.tnE.removeCallbacks(localRunnable);
    }
    AppMethodBeat.o(112678);
  }
  
  private void fD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112676);
    Log.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
    if (this.cSF == null)
    {
      AppMethodBeat.o(112676);
      return;
    }
    if ((!this.tnC.contains(paramString1)) || (this.tnD.contains(paramString1)))
    {
      Log.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
      AppMethodBeat.o(112676);
      return;
    }
    int i = 0;
    while (i < this.cSF.size())
    {
      Object localObject = (WeakReference)this.cSF.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).fE(paramString1, paramString2);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112676);
  }
  
  private static void l(String paramString, int paramInt1, int paramInt2, int paramInt3)
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
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
    AppMethodBeat.o(112681);
  }
  
  public final void X(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112679);
    Log.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
    aqR(paramString);
    if (!this.tnC.contains(paramString)) {
      this.tnC.add(paramString);
    }
    l(paramString, paramInt1, 1, paramInt2);
    AppMethodBeat.o(112679);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112673);
    if (this.cSF == null) {
      this.cSF = new ArrayList();
    }
    this.cSF.add(new WeakReference(parama));
    AppMethodBeat.o(112673);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112674);
    if (this.cSF == null)
    {
      AppMethodBeat.o(112674);
      return;
    }
    int i = 0;
    while (i < this.cSF.size())
    {
      WeakReference localWeakReference = (WeakReference)this.cSF.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.cSF.remove(localWeakReference);
          AppMethodBeat.o(112674);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112674);
  }
  
  public final void di(String paramString, int paramInt)
  {
    AppMethodBeat.i(112680);
    Log.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
    aqR(paramString);
    this.tnD.add(paramString);
    j.1 local1 = new j.1(this, paramString, paramInt);
    paramInt = Util.getInt(com.tencent.mm.n.h.axd().ao("ShareCard", "UnMarkDelay"), 0);
    this.tnE.postDelayed(local1, paramInt * 1000);
    this.tnF.put(paramString, local1);
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
        paramq.tnK = paramString.tnK;
        paramq.tnL = paramString.tnL;
        paramq.tnM = paramString.tnM;
        paramq.tnN = paramString.tnN;
        paramq.tnO = paramString.tnO;
        Log.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + paramString.trV);
        Log.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + paramq.tnK + " mark_succ:" + paramq.tnL + " mark_card_id:" + paramq.tnM + " expire_time:" + paramq.tnN + " pay_qrcode_wording:" + paramq.tnO);
        a(paramString.trV, paramq);
        aqQ(paramString.trV);
        AppMethodBeat.o(112682);
      }
    }
    else if ((paramq instanceof f))
    {
      paramq = (f)paramq;
      Log.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + paramq.trV);
      fD(paramq.trV, paramString);
      aqQ(paramq.trV);
    }
    AppMethodBeat.o(112682);
  }
  
  public static abstract interface a
  {
    public abstract void aqS(String paramString);
    
    public abstract void b(String paramString, j.b paramb);
    
    public abstract void fE(String paramString1, String paramString2);
  }
  
  public static final class b
  {
    public String tnK;
    public int tnL = 0;
    public String tnM;
    public int tnN;
    public String tnO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.j
 * JD-Core Version:    0.7.0.1
 */