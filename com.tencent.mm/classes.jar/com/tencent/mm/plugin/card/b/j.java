package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.n.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class j
  implements com.tencent.mm.ak.f
{
  private List<WeakReference<a>> oCX;
  public ArrayList<String> oDT;
  public ArrayList<String> oDU;
  public aq oDV;
  public HashMap<String, Runnable> oDW;
  
  public j()
  {
    AppMethodBeat.i(112672);
    this.oCX = new ArrayList();
    this.oDT = new ArrayList();
    this.oDU = new ArrayList();
    this.oDV = new aq();
    this.oDW = new LinkedHashMap();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1078, this);
    this.oDT.clear();
    this.oDU.clear();
    this.oDW.clear();
    AppMethodBeat.o(112672);
  }
  
  private void YY(String paramString)
  {
    AppMethodBeat.i(112677);
    ae.i("MicroMsg.CardMarkCodeMgr", "removeId()");
    if ((this.oDT.contains(paramString)) && (!this.oDU.contains(paramString)))
    {
      this.oDT.remove(paramString);
      ae.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if ((!this.oDT.contains(paramString)) && (this.oDU.contains(paramString)))
    {
      this.oDU.remove(paramString);
      Runnable localRunnable = (Runnable)this.oDW.get(paramString);
      this.oDW.remove(paramString);
      this.oDV.removeCallbacks(localRunnable);
      ae.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
      ae.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(112677);
  }
  
  private void YZ(String paramString)
  {
    AppMethodBeat.i(112678);
    ae.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
    if (this.oDU.contains(paramString))
    {
      this.oDU.remove(paramString);
      ae.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if (this.oDW.containsKey(paramString))
    {
      ae.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
      Runnable localRunnable = (Runnable)this.oDW.get(paramString);
      this.oDW.remove(paramString);
      this.oDV.removeCallbacks(localRunnable);
    }
    AppMethodBeat.o(112678);
  }
  
  private void a(String paramString, b paramb)
  {
    AppMethodBeat.i(112675);
    ae.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
    if (this.oCX == null)
    {
      AppMethodBeat.o(112675);
      return;
    }
    if ((!this.oDT.contains(paramString)) && (!this.oDU.contains(paramString)))
    {
      ae.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
      AppMethodBeat.o(112675);
      return;
    }
    int i = 0;
    if (i < this.oCX.size())
    {
      Object localObject = (WeakReference)this.oCX.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (!this.oDT.contains(paramString)) {
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
        if (this.oDU.contains(paramString)) {
          ((a)localObject).Za(paramString);
        }
      }
    }
    AppMethodBeat.o(112675);
  }
  
  private void eY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112676);
    ae.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
    if (this.oCX == null)
    {
      AppMethodBeat.o(112676);
      return;
    }
    if ((!this.oDT.contains(paramString1)) || (this.oDU.contains(paramString1)))
    {
      ae.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
      AppMethodBeat.o(112676);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      Object localObject = (WeakReference)this.oCX.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).eZ(paramString1, paramString2);
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
      ae.i("MicroMsg.CardMarkCodeMgr", "card_id is empty, don't call NetSceneMarkShareCard cgi");
      AppMethodBeat.o(112681);
      return;
    }
    ae.i("MicroMsg.CardMarkCodeMgr", "doMarkNetscene()");
    paramString = new com.tencent.mm.plugin.card.sharecard.model.f(paramString, paramInt1, paramInt2, paramInt3);
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
    AppMethodBeat.o(112681);
  }
  
  public final void U(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112679);
    ae.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
    YZ(paramString);
    if (!this.oDT.contains(paramString)) {
      this.oDT.add(paramString);
    }
    k(paramString, paramInt1, 1, paramInt2);
    AppMethodBeat.o(112679);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112673);
    if (this.oCX == null) {
      this.oCX = new ArrayList();
    }
    this.oCX.add(new WeakReference(parama));
    AppMethodBeat.o(112673);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112674);
    if (this.oCX == null)
    {
      AppMethodBeat.o(112674);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      WeakReference localWeakReference = (WeakReference)this.oCX.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.oCX.remove(localWeakReference);
          AppMethodBeat.o(112674);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112674);
  }
  
  public final void cI(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(112680);
    ae.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
    YZ(paramString);
    this.oDU.add(paramString);
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112671);
        j.k(paramString, this.oDY, this.oDZ, paramInt);
        ae.i("MicroMsg.CardMarkCodeMgr", "run the unmark task, the card is " + paramString + " system.time:" + System.currentTimeMillis());
        AppMethodBeat.o(112671);
      }
    };
    paramInt = bu.getInt(com.tencent.mm.n.g.acM().ah("ShareCard", "UnMarkDelay"), 0);
    this.oDV.postDelayed(local1, paramInt * 1000);
    this.oDW.put(paramString, local1);
    ae.i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + paramString + " system.time:" + System.currentTimeMillis());
    AppMethodBeat.o(112680);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112682);
    ae.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.f))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.f)paramn;
        paramn = new b();
        paramn.oEb = paramString.oEb;
        paramn.oEc = paramString.oEc;
        paramn.oEd = paramString.oEd;
        paramn.oEe = paramString.oEe;
        paramn.oEf = paramString.oEf;
        ae.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + paramString.oIg);
        ae.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + paramn.oEb + " mark_succ:" + paramn.oEc + " mark_card_id:" + paramn.oEd + " expire_time:" + paramn.oEe + " pay_qrcode_wording:" + paramn.oEf);
        a(paramString.oIg, paramn);
        YY(paramString.oIg);
        AppMethodBeat.o(112682);
      }
    }
    else if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.f))
    {
      paramn = (com.tencent.mm.plugin.card.sharecard.model.f)paramn;
      ae.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + paramn.oIg);
      eY(paramn.oIg, paramString);
      YY(paramn.oIg);
    }
    AppMethodBeat.o(112682);
  }
  
  public static abstract interface a
  {
    public abstract void Za(String paramString);
    
    public abstract void b(String paramString, j.b paramb);
    
    public abstract void eZ(String paramString1, String paramString2);
  }
  
  public static final class b
  {
    public String oEb;
    public int oEc = 0;
    public String oEd;
    public int oEe;
    public String oEf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.j
 * JD-Core Version:    0.7.0.1
 */