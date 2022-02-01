package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements com.tencent.mm.ak.g
{
  List<WeakReference<a>> nTa;
  String nTb;
  public LinkedList<String> nTc;
  public int nTd;
  private int nTe;
  private int nTf;
  private int nTg;
  private int nTh;
  private boolean nTi;
  private au nTj;
  private au nTk;
  
  public c()
  {
    AppMethodBeat.i(112583);
    this.nTa = new ArrayList();
    this.nTb = "";
    this.nTc = new LinkedList();
    this.nTh = 60;
    this.nTi = false;
    this.nTj = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112581);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
        c.this.Uv(c.this.nTb);
        c.this.bPy();
        AppMethodBeat.o(112581);
        return true;
      }
    }, false);
    this.nTk = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112582);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
        c localc = c.this;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CardCodeMgr", "onCodeChange()");
        if (localc.nTa != null)
        {
          int i = 0;
          while (i < localc.nTa.size())
          {
            Object localObject = (WeakReference)localc.nTa.get(i);
            if (localObject != null)
            {
              localObject = (c.a)((WeakReference)localObject).get();
              if (localObject != null) {
                ((c.a)localObject).bPC();
              }
            }
            i += 1;
          }
        }
        c.this.bPA();
        AppMethodBeat.o(112582);
        return true;
      }
    }, false);
    AppMethodBeat.o(112583);
  }
  
  private void Uu(String paramString)
  {
    AppMethodBeat.i(112588);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CardCodeMgr", "onFail()");
    if (this.nTa == null)
    {
      AppMethodBeat.o(112588);
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
          ((a)localObject).Uu(paramString);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112588);
  }
  
  private void bPx()
  {
    AppMethodBeat.i(112592);
    com.tencent.mm.plugin.card.model.ac localac = new com.tencent.mm.plugin.card.model.ac(this.nTb);
    com.tencent.mm.kernel.g.agQ().ghe.a(localac, 0);
    AppMethodBeat.o(112592);
  }
  
  private void bPz()
  {
    AppMethodBeat.i(112595);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
    if (!this.nTj.eVs()) {
      this.nTj.stopTimer();
    }
    AppMethodBeat.o(112595);
  }
  
  private void onSuccess()
  {
    AppMethodBeat.i(112587);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CardCodeMgr", "onSuccess()");
    if (this.nTa == null)
    {
      AppMethodBeat.o(112587);
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
          ((a)localObject).onSuccess();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112587);
  }
  
  public final void Uv(String paramString)
  {
    AppMethodBeat.i(112591);
    if (this.nTi)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), is doing get codes");
      AppMethodBeat.o(112591);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), mCardId is empty!");
      AppMethodBeat.o(112591);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CardCodeMgr", "doGetCardCodes() do get codes, card id ".concat(String.valueOf(paramString)));
    this.nTi = true;
    this.nTb = paramString;
    bPx();
    AppMethodBeat.o(112591);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112585);
    if (this.nTa == null) {
      this.nTa = new ArrayList();
    }
    this.nTa.add(new WeakReference(parama));
    AppMethodBeat.o(112585);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112586);
    if (this.nTa == null)
    {
      AppMethodBeat.o(112586);
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
          AppMethodBeat.o(112586);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112586);
  }
  
  public final void bPA()
  {
    AppMethodBeat.i(112596);
    bPB();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.nTg);
    if (this.nTg > 0)
    {
      localau = this.nTk;
      l = this.nTg * 1000;
      localau.au(l, l);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
      AppMethodBeat.o(112596);
      return;
    }
    au localau = this.nTk;
    long l = this.nTh * 1000;
    localau.au(l, l);
    com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
    AppMethodBeat.o(112596);
  }
  
  public final void bPB()
  {
    AppMethodBeat.i(112597);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
    if (!this.nTk.eVs()) {
      this.nTk.stopTimer();
    }
    AppMethodBeat.o(112597);
  }
  
  public final void bPy()
  {
    AppMethodBeat.i(112594);
    bPz();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.nTe);
    if ((this.nTe > 0) && (!TextUtils.isEmpty(this.nTb)))
    {
      au localau = this.nTj;
      long l = this.nTe * 1000;
      localau.au(l, l);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CardCodeMgr", "start request code timer!");
      AppMethodBeat.o(112594);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
    AppMethodBeat.o(112594);
  }
  
  public final String getCode()
  {
    AppMethodBeat.i(112589);
    if ((this.nTc == null) || (this.nTc.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(112589);
      return "";
    }
    if (this.nTd >= this.nTc.size())
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      Uv(this.nTb);
      AppMethodBeat.o(112589);
      return "";
    }
    if (this.nTf >= this.nTc.size() - this.nTd)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
      Uv(this.nTb);
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.nTd + " request_count:" + this.nTf + " codes size:" + this.nTc.size());
    Object localObject = this.nTc;
    int i = this.nTd;
    this.nTd = (i + 1);
    localObject = (String)((LinkedList)localObject).get(i);
    AppMethodBeat.o(112589);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(112590);
    if ((this.nTc == null) || (this.nTc.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(112590);
      return true;
    }
    if (this.nTd >= this.nTc.size())
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      AppMethodBeat.o(112590);
      return true;
    }
    AppMethodBeat.o(112590);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112593);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.CardCodeMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.model.ac))
      {
        this.nTi = false;
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.nTb);
        paramString = (com.tencent.mm.plugin.card.model.ac)paramn;
        this.nTe = paramString.nTe;
        this.nTf = paramString.nTf;
        this.nTg = paramString.nTg;
        if (paramString.nTc != null)
        {
          this.nTc.clear();
          this.nTc.addAll(paramString.nTc);
          this.nTd = 0;
        }
        onSuccess();
        bPy();
        if (this.nTg != 0) {
          bPA();
        }
        AppMethodBeat.o(112593);
      }
    }
    else if ((paramn instanceof com.tencent.mm.plugin.card.model.ac))
    {
      this.nTi = false;
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.nTb);
      Uu(paramString);
    }
    AppMethodBeat.o(112593);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112584);
    com.tencent.mm.kernel.g.agQ().ghe.b(577, this);
    this.nTc.clear();
    this.nTi = false;
    this.nTb = "";
    this.nTd = 0;
    this.nTe = 0;
    this.nTf = 0;
    this.nTg = 0;
    bPz();
    bPB();
    AppMethodBeat.o(112584);
  }
  
  public static abstract interface a
  {
    public abstract void Uu(String paramString);
    
    public abstract void bPC();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.c
 * JD-Core Version:    0.7.0.1
 */