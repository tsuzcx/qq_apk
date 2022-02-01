package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.model.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements com.tencent.mm.al.g
{
  List<WeakReference<a>> nqa;
  String nqb;
  public LinkedList<String> nqc;
  public int nqd;
  private int nqe;
  private int nqf;
  private int nqg;
  private int nqh;
  private boolean nqi;
  private av nqj;
  private av nqk;
  
  public c()
  {
    AppMethodBeat.i(112583);
    this.nqa = new ArrayList();
    this.nqb = "";
    this.nqc = new LinkedList();
    this.nqh = 60;
    this.nqi = false;
    this.nqj = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112581);
        ad.i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
        c.this.Qj(c.this.nqb);
        c.this.bIl();
        AppMethodBeat.o(112581);
        return true;
      }
    }, false);
    this.nqk = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112582);
        ad.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
        c localc = c.this;
        ad.i("MicroMsg.CardCodeMgr", "onCodeChange()");
        if (localc.nqa != null)
        {
          int i = 0;
          while (i < localc.nqa.size())
          {
            Object localObject = (WeakReference)localc.nqa.get(i);
            if (localObject != null)
            {
              localObject = (c.a)((WeakReference)localObject).get();
              if (localObject != null) {
                ((c.a)localObject).bIp();
              }
            }
            i += 1;
          }
        }
        c.this.bIn();
        AppMethodBeat.o(112582);
        return true;
      }
    }, false);
    AppMethodBeat.o(112583);
  }
  
  private void Qi(String paramString)
  {
    AppMethodBeat.i(112588);
    ad.i("MicroMsg.CardCodeMgr", "onFail()");
    if (this.nqa == null)
    {
      AppMethodBeat.o(112588);
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
          ((a)localObject).Qi(paramString);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112588);
  }
  
  private void bIk()
  {
    AppMethodBeat.i(112592);
    ac localac = new ac(this.nqb);
    com.tencent.mm.kernel.g.afA().gcy.a(localac, 0);
    AppMethodBeat.o(112592);
  }
  
  private void bIm()
  {
    AppMethodBeat.i(112595);
    ad.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
    if (!this.nqj.eFX()) {
      this.nqj.stopTimer();
    }
    AppMethodBeat.o(112595);
  }
  
  private void onSuccess()
  {
    AppMethodBeat.i(112587);
    ad.i("MicroMsg.CardCodeMgr", "onSuccess()");
    if (this.nqa == null)
    {
      AppMethodBeat.o(112587);
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
          ((a)localObject).onSuccess();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112587);
  }
  
  public final void Qj(String paramString)
  {
    AppMethodBeat.i(112591);
    if (this.nqi)
    {
      ad.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), is doing get codes");
      AppMethodBeat.o(112591);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), mCardId is empty!");
      AppMethodBeat.o(112591);
      return;
    }
    ad.i("MicroMsg.CardCodeMgr", "doGetCardCodes() do get codes, card id ".concat(String.valueOf(paramString)));
    this.nqi = true;
    this.nqb = paramString;
    bIk();
    AppMethodBeat.o(112591);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112585);
    if (this.nqa == null) {
      this.nqa = new ArrayList();
    }
    this.nqa.add(new WeakReference(parama));
    AppMethodBeat.o(112585);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112586);
    if (this.nqa == null)
    {
      AppMethodBeat.o(112586);
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
          AppMethodBeat.o(112586);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112586);
  }
  
  public final void bIl()
  {
    AppMethodBeat.i(112594);
    bIm();
    ad.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.nqe);
    if ((this.nqe > 0) && (!TextUtils.isEmpty(this.nqb)))
    {
      av localav = this.nqj;
      long l = this.nqe * 1000;
      localav.av(l, l);
      ad.i("MicroMsg.CardCodeMgr", "start request code timer!");
      AppMethodBeat.o(112594);
      return;
    }
    ad.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
    AppMethodBeat.o(112594);
  }
  
  public final void bIn()
  {
    AppMethodBeat.i(112596);
    bIo();
    ad.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.nqg);
    if (this.nqg > 0)
    {
      localav = this.nqk;
      l = this.nqg * 1000;
      localav.av(l, l);
      ad.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
      AppMethodBeat.o(112596);
      return;
    }
    av localav = this.nqk;
    long l = this.nqh * 1000;
    localav.av(l, l);
    ad.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
    AppMethodBeat.o(112596);
  }
  
  public final void bIo()
  {
    AppMethodBeat.i(112597);
    ad.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
    if (!this.nqk.eFX()) {
      this.nqk.stopTimer();
    }
    AppMethodBeat.o(112597);
  }
  
  public final String getCode()
  {
    AppMethodBeat.i(112589);
    if ((this.nqc == null) || (this.nqc.size() == 0))
    {
      ad.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(112589);
      return "";
    }
    if (this.nqd >= this.nqc.size())
    {
      ad.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      Qj(this.nqb);
      AppMethodBeat.o(112589);
      return "";
    }
    if (this.nqf >= this.nqc.size() - this.nqd)
    {
      ad.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
      Qj(this.nqb);
    }
    ad.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.nqd + " request_count:" + this.nqf + " codes size:" + this.nqc.size());
    Object localObject = this.nqc;
    int i = this.nqd;
    this.nqd = (i + 1);
    localObject = (String)((LinkedList)localObject).get(i);
    AppMethodBeat.o(112589);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(112590);
    if ((this.nqc == null) || (this.nqc.size() == 0))
    {
      ad.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(112590);
      return true;
    }
    if (this.nqd >= this.nqc.size())
    {
      ad.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      AppMethodBeat.o(112590);
      return true;
    }
    AppMethodBeat.o(112590);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112593);
    ad.i("MicroMsg.CardCodeMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof ac))
      {
        this.nqi = false;
        ad.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.nqb);
        paramString = (ac)paramn;
        this.nqe = paramString.nqe;
        this.nqf = paramString.nqf;
        this.nqg = paramString.nqg;
        if (paramString.nqc != null)
        {
          this.nqc.clear();
          this.nqc.addAll(paramString.nqc);
          this.nqd = 0;
        }
        onSuccess();
        bIl();
        if (this.nqg != 0) {
          bIn();
        }
        AppMethodBeat.o(112593);
      }
    }
    else if ((paramn instanceof ac))
    {
      this.nqi = false;
      ad.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.nqb);
      Qi(paramString);
    }
    AppMethodBeat.o(112593);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112584);
    com.tencent.mm.kernel.g.afA().gcy.b(577, this);
    this.nqc.clear();
    this.nqi = false;
    this.nqb = "";
    this.nqd = 0;
    this.nqe = 0;
    this.nqf = 0;
    this.nqg = 0;
    bIm();
    bIo();
    AppMethodBeat.o(112584);
  }
  
  public static abstract interface a
  {
    public abstract void Qi(String paramString);
    
    public abstract void bIp();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.c
 * JD-Core Version:    0.7.0.1
 */