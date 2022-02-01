package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.n.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class j
  implements com.tencent.mm.al.f
{
  private List<WeakReference<a>> owv;
  public ArrayList<String> oxr;
  public ArrayList<String> oxs;
  public ap oxt;
  public HashMap<String, Runnable> oxu;
  
  public j()
  {
    AppMethodBeat.i(112672);
    this.owv = new ArrayList();
    this.oxr = new ArrayList();
    this.oxs = new ArrayList();
    this.oxt = new ap();
    this.oxu = new LinkedHashMap();
    com.tencent.mm.kernel.g.ajB().gAO.a(1078, this);
    this.oxr.clear();
    this.oxs.clear();
    this.oxu.clear();
    AppMethodBeat.o(112672);
  }
  
  private void Yh(String paramString)
  {
    AppMethodBeat.i(112677);
    ad.i("MicroMsg.CardMarkCodeMgr", "removeId()");
    if ((this.oxr.contains(paramString)) && (!this.oxs.contains(paramString)))
    {
      this.oxr.remove(paramString);
      ad.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if ((!this.oxr.contains(paramString)) && (this.oxs.contains(paramString)))
    {
      this.oxs.remove(paramString);
      Runnable localRunnable = (Runnable)this.oxu.get(paramString);
      this.oxu.remove(paramString);
      this.oxt.removeCallbacks(localRunnable);
      ad.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
      ad.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(112677);
  }
  
  private void Yi(String paramString)
  {
    AppMethodBeat.i(112678);
    ad.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
    if (this.oxs.contains(paramString))
    {
      this.oxs.remove(paramString);
      ad.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if (this.oxu.containsKey(paramString))
    {
      ad.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
      Runnable localRunnable = (Runnable)this.oxu.get(paramString);
      this.oxu.remove(paramString);
      this.oxt.removeCallbacks(localRunnable);
    }
    AppMethodBeat.o(112678);
  }
  
  private void a(String paramString, b paramb)
  {
    AppMethodBeat.i(112675);
    ad.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
    if (this.owv == null)
    {
      AppMethodBeat.o(112675);
      return;
    }
    if ((!this.oxr.contains(paramString)) && (!this.oxs.contains(paramString)))
    {
      ad.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
      AppMethodBeat.o(112675);
      return;
    }
    int i = 0;
    if (i < this.owv.size())
    {
      Object localObject = (WeakReference)this.owv.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (!this.oxr.contains(paramString)) {
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
        if (this.oxs.contains(paramString)) {
          ((a)localObject).Yj(paramString);
        }
      }
    }
    AppMethodBeat.o(112675);
  }
  
  private void eU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112676);
    ad.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
    if (this.owv == null)
    {
      AppMethodBeat.o(112676);
      return;
    }
    if ((!this.oxr.contains(paramString1)) || (this.oxs.contains(paramString1)))
    {
      ad.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
      AppMethodBeat.o(112676);
      return;
    }
    int i = 0;
    while (i < this.owv.size())
    {
      Object localObject = (WeakReference)this.owv.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).eV(paramString1, paramString2);
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
    paramString = new com.tencent.mm.plugin.card.sharecard.model.f(paramString, paramInt1, paramInt2, paramInt3);
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
    AppMethodBeat.o(112681);
  }
  
  public final void U(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112679);
    ad.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
    Yi(paramString);
    if (!this.oxr.contains(paramString)) {
      this.oxr.add(paramString);
    }
    k(paramString, paramInt1, 1, paramInt2);
    AppMethodBeat.o(112679);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112673);
    if (this.owv == null) {
      this.owv = new ArrayList();
    }
    this.owv.add(new WeakReference(parama));
    AppMethodBeat.o(112673);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112674);
    if (this.owv == null)
    {
      AppMethodBeat.o(112674);
      return;
    }
    int i = 0;
    while (i < this.owv.size())
    {
      WeakReference localWeakReference = (WeakReference)this.owv.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.owv.remove(localWeakReference);
          AppMethodBeat.o(112674);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112674);
  }
  
  public final void cE(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(112680);
    ad.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
    Yi(paramString);
    this.oxs.add(paramString);
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112671);
        j.k(paramString, this.oxw, this.oxx, paramInt);
        ad.i("MicroMsg.CardMarkCodeMgr", "run the unmark task, the card is " + paramString + " system.time:" + System.currentTimeMillis());
        AppMethodBeat.o(112671);
      }
    };
    paramInt = bt.getInt(com.tencent.mm.n.g.acB().ah("ShareCard", "UnMarkDelay"), 0);
    this.oxt.postDelayed(local1, paramInt * 1000);
    this.oxu.put(paramString, local1);
    ad.i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + paramString + " system.time:" + System.currentTimeMillis());
    AppMethodBeat.o(112680);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112682);
    ad.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.f))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.f)paramn;
        paramn = new b();
        paramn.oxz = paramString.oxz;
        paramn.oxA = paramString.oxA;
        paramn.oxB = paramString.oxB;
        paramn.oxC = paramString.oxC;
        paramn.oxD = paramString.oxD;
        ad.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + paramString.oBE);
        ad.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + paramn.oxz + " mark_succ:" + paramn.oxA + " mark_card_id:" + paramn.oxB + " expire_time:" + paramn.oxC + " pay_qrcode_wording:" + paramn.oxD);
        a(paramString.oBE, paramn);
        Yh(paramString.oBE);
        AppMethodBeat.o(112682);
      }
    }
    else if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.f))
    {
      paramn = (com.tencent.mm.plugin.card.sharecard.model.f)paramn;
      ad.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + paramn.oBE);
      eU(paramn.oBE, paramString);
      Yh(paramn.oBE);
    }
    AppMethodBeat.o(112682);
  }
  
  public static abstract interface a
  {
    public abstract void Yj(String paramString);
    
    public abstract void b(String paramString, j.b paramb);
    
    public abstract void eV(String paramString1, String paramString2);
  }
  
  public static final class b
  {
    public int oxA = 0;
    public String oxB;
    public int oxC;
    public String oxD;
    public String oxz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.j
 * JD-Core Version:    0.7.0.1
 */