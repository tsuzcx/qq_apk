package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.m.c;
import com.tencent.mm.plugin.card.sharecard.model.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class j
  implements com.tencent.mm.ak.g
{
  public ArrayList<String> nTW;
  public ArrayList<String> nTX;
  public ao nTY;
  public HashMap<String, Runnable> nTZ;
  private List<WeakReference<a>> nTa;
  
  public j()
  {
    AppMethodBeat.i(112672);
    this.nTa = new ArrayList();
    this.nTW = new ArrayList();
    this.nTX = new ArrayList();
    this.nTY = new ao();
    this.nTZ = new LinkedHashMap();
    com.tencent.mm.kernel.g.agQ().ghe.a(1078, this);
    this.nTW.clear();
    this.nTX.clear();
    this.nTZ.clear();
    AppMethodBeat.o(112672);
  }
  
  private void Uy(String paramString)
  {
    AppMethodBeat.i(112677);
    ac.i("MicroMsg.CardMarkCodeMgr", "removeId()");
    if ((this.nTW.contains(paramString)) && (!this.nTX.contains(paramString)))
    {
      this.nTW.remove(paramString);
      ac.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if ((!this.nTW.contains(paramString)) && (this.nTX.contains(paramString)))
    {
      this.nTX.remove(paramString);
      Runnable localRunnable = (Runnable)this.nTZ.get(paramString);
      this.nTZ.remove(paramString);
      this.nTY.removeCallbacks(localRunnable);
      ac.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
      ac.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(112677);
  }
  
  private void Uz(String paramString)
  {
    AppMethodBeat.i(112678);
    ac.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
    if (this.nTX.contains(paramString))
    {
      this.nTX.remove(paramString);
      ac.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if (this.nTZ.containsKey(paramString))
    {
      ac.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
      Runnable localRunnable = (Runnable)this.nTZ.get(paramString);
      this.nTZ.remove(paramString);
      this.nTY.removeCallbacks(localRunnable);
    }
    AppMethodBeat.o(112678);
  }
  
  private void a(String paramString, b paramb)
  {
    AppMethodBeat.i(112675);
    ac.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
    if (this.nTa == null)
    {
      AppMethodBeat.o(112675);
      return;
    }
    if ((!this.nTW.contains(paramString)) && (!this.nTX.contains(paramString)))
    {
      ac.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
      AppMethodBeat.o(112675);
      return;
    }
    int i = 0;
    if (i < this.nTa.size())
    {
      Object localObject = (WeakReference)this.nTa.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (!this.nTW.contains(paramString)) {
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
        if (this.nTX.contains(paramString)) {
          ((a)localObject).UA(paramString);
        }
      }
    }
    AppMethodBeat.o(112675);
  }
  
  private void eK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112676);
    ac.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
    if (this.nTa == null)
    {
      AppMethodBeat.o(112676);
      return;
    }
    if ((!this.nTW.contains(paramString1)) || (this.nTX.contains(paramString1)))
    {
      ac.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
      AppMethodBeat.o(112676);
      return;
    }
    int i = 0;
    while (i < this.nTa.size())
    {
      Object localObject = (WeakReference)this.nTa.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).eL(paramString1, paramString2);
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
      ac.i("MicroMsg.CardMarkCodeMgr", "card_id is empty, don't call NetSceneMarkShareCard cgi");
      AppMethodBeat.o(112681);
      return;
    }
    ac.i("MicroMsg.CardMarkCodeMgr", "doMarkNetscene()");
    paramString = new f(paramString, paramInt1, paramInt2, paramInt3);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
    AppMethodBeat.o(112681);
  }
  
  public final void S(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112679);
    ac.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
    Uz(paramString);
    if (!this.nTW.contains(paramString)) {
      this.nTW.add(paramString);
    }
    k(paramString, paramInt1, 1, paramInt2);
    AppMethodBeat.o(112679);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112673);
    if (this.nTa == null) {
      this.nTa = new ArrayList();
    }
    this.nTa.add(new WeakReference(parama));
    AppMethodBeat.o(112673);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112674);
    if (this.nTa == null)
    {
      AppMethodBeat.o(112674);
      return;
    }
    int i = 0;
    while (i < this.nTa.size())
    {
      WeakReference localWeakReference = (WeakReference)this.nTa.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.nTa.remove(localWeakReference);
          AppMethodBeat.o(112674);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112674);
  }
  
  public final void cB(String paramString, int paramInt)
  {
    AppMethodBeat.i(112680);
    ac.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
    Uz(paramString);
    this.nTX.add(paramString);
    j.1 local1 = new j.1(this, paramString, paramInt);
    paramInt = bs.getInt(com.tencent.mm.m.g.ZZ().ag("ShareCard", "UnMarkDelay"), 0);
    this.nTY.postDelayed(local1, paramInt * 1000);
    this.nTZ.put(paramString, local1);
    ac.i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + paramString + " system.time:" + System.currentTimeMillis());
    AppMethodBeat.o(112680);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112682);
    ac.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof f))
      {
        paramString = (f)paramn;
        paramn = new b();
        paramn.nUe = paramString.nUe;
        paramn.nUf = paramString.nUf;
        paramn.nUg = paramString.nUg;
        paramn.nUh = paramString.nUh;
        paramn.nUi = paramString.nUi;
        ac.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + paramString.nYk);
        ac.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + paramn.nUe + " mark_succ:" + paramn.nUf + " mark_card_id:" + paramn.nUg + " expire_time:" + paramn.nUh + " pay_qrcode_wording:" + paramn.nUi);
        a(paramString.nYk, paramn);
        Uy(paramString.nYk);
        AppMethodBeat.o(112682);
      }
    }
    else if ((paramn instanceof f))
    {
      paramn = (f)paramn;
      ac.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + paramn.nYk);
      eK(paramn.nYk, paramString);
      Uy(paramn.nYk);
    }
    AppMethodBeat.o(112682);
  }
  
  public static abstract interface a
  {
    public abstract void UA(String paramString);
    
    public abstract void b(String paramString, j.b paramb);
    
    public abstract void eL(String paramString1, String paramString2);
  }
  
  public static final class b
  {
    public String nUe;
    public int nUf = 0;
    public String nUg;
    public int nUh;
    public String nUi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.j
 * JD-Core Version:    0.7.0.1
 */