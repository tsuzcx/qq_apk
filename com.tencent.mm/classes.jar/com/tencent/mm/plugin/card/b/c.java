package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements f
{
  private int owA;
  private int owB;
  private int owC;
  private boolean owD;
  private av owE;
  private av owF;
  List<WeakReference<a>> owv;
  String oww;
  public LinkedList<String> owx;
  public int owy;
  private int owz;
  
  public c()
  {
    AppMethodBeat.i(112583);
    this.owv = new ArrayList();
    this.oww = "";
    this.owx = new LinkedList();
    this.owC = 60;
    this.owD = false;
    this.owE = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112581);
        ad.i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
        c.this.Ye(c.this.oww);
        c.this.bUd();
        AppMethodBeat.o(112581);
        return true;
      }
    }, false);
    this.owF = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112582);
        ad.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
        c localc = c.this;
        ad.i("MicroMsg.CardCodeMgr", "onCodeChange()");
        if (localc.owv != null)
        {
          int i = 0;
          while (i < localc.owv.size())
          {
            Object localObject = (WeakReference)localc.owv.get(i);
            if (localObject != null)
            {
              localObject = (c.a)((WeakReference)localObject).get();
              if (localObject != null) {
                ((c.a)localObject).bUh();
              }
            }
            i += 1;
          }
        }
        c.this.bUf();
        AppMethodBeat.o(112582);
        return true;
      }
    }, false);
    AppMethodBeat.o(112583);
  }
  
  private void Yd(String paramString)
  {
    AppMethodBeat.i(112588);
    ad.i("MicroMsg.CardCodeMgr", "onFail()");
    if (this.owv == null)
    {
      AppMethodBeat.o(112588);
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
          ((a)localObject).Yd(paramString);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112588);
  }
  
  private void bUc()
  {
    AppMethodBeat.i(112592);
    ac localac = new ac(this.oww);
    g.ajB().gAO.a(localac, 0);
    AppMethodBeat.o(112592);
  }
  
  private void bUe()
  {
    AppMethodBeat.i(112595);
    ad.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
    if (!this.owE.fkZ()) {
      this.owE.stopTimer();
    }
    AppMethodBeat.o(112595);
  }
  
  private void onSuccess()
  {
    AppMethodBeat.i(112587);
    ad.i("MicroMsg.CardCodeMgr", "onSuccess()");
    if (this.owv == null)
    {
      AppMethodBeat.o(112587);
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
          ((a)localObject).onSuccess();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112587);
  }
  
  public final void Ye(String paramString)
  {
    AppMethodBeat.i(112591);
    if (this.owD)
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
    this.owD = true;
    this.oww = paramString;
    bUc();
    AppMethodBeat.o(112591);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112585);
    if (this.owv == null) {
      this.owv = new ArrayList();
    }
    this.owv.add(new WeakReference(parama));
    AppMethodBeat.o(112585);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112586);
    if (this.owv == null)
    {
      AppMethodBeat.o(112586);
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
          AppMethodBeat.o(112586);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112586);
  }
  
  public final void bUd()
  {
    AppMethodBeat.i(112594);
    bUe();
    ad.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.owz);
    if ((this.owz > 0) && (!TextUtils.isEmpty(this.oww)))
    {
      av localav = this.owE;
      long l = this.owz * 1000;
      localav.az(l, l);
      ad.i("MicroMsg.CardCodeMgr", "start request code timer!");
      AppMethodBeat.o(112594);
      return;
    }
    ad.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
    AppMethodBeat.o(112594);
  }
  
  public final void bUf()
  {
    AppMethodBeat.i(112596);
    bUg();
    ad.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.owB);
    if (this.owB > 0)
    {
      localav = this.owF;
      l = this.owB * 1000;
      localav.az(l, l);
      ad.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
      AppMethodBeat.o(112596);
      return;
    }
    av localav = this.owF;
    long l = this.owC * 1000;
    localav.az(l, l);
    ad.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
    AppMethodBeat.o(112596);
  }
  
  public final void bUg()
  {
    AppMethodBeat.i(112597);
    ad.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
    if (!this.owF.fkZ()) {
      this.owF.stopTimer();
    }
    AppMethodBeat.o(112597);
  }
  
  public final String getCode()
  {
    AppMethodBeat.i(112589);
    if ((this.owx == null) || (this.owx.size() == 0))
    {
      ad.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(112589);
      return "";
    }
    if (this.owy >= this.owx.size())
    {
      ad.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      Ye(this.oww);
      AppMethodBeat.o(112589);
      return "";
    }
    if (this.owA >= this.owx.size() - this.owy)
    {
      ad.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
      Ye(this.oww);
    }
    ad.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.owy + " request_count:" + this.owA + " codes size:" + this.owx.size());
    Object localObject = this.owx;
    int i = this.owy;
    this.owy = (i + 1);
    localObject = (String)((LinkedList)localObject).get(i);
    AppMethodBeat.o(112589);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(112590);
    if ((this.owx == null) || (this.owx.size() == 0))
    {
      ad.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(112590);
      return true;
    }
    if (this.owy >= this.owx.size())
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
        this.owD = false;
        ad.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.oww);
        paramString = (ac)paramn;
        this.owz = paramString.owz;
        this.owA = paramString.owA;
        this.owB = paramString.owB;
        if (paramString.owx != null)
        {
          this.owx.clear();
          this.owx.addAll(paramString.owx);
          this.owy = 0;
        }
        onSuccess();
        bUd();
        if (this.owB != 0) {
          bUf();
        }
        AppMethodBeat.o(112593);
      }
    }
    else if ((paramn instanceof ac))
    {
      this.owD = false;
      ad.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.oww);
      Yd(paramString);
    }
    AppMethodBeat.o(112593);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112584);
    g.ajB().gAO.b(577, this);
    this.owx.clear();
    this.owD = false;
    this.oww = "";
    this.owy = 0;
    this.owz = 0;
    this.owA = 0;
    this.owB = 0;
    bUe();
    bUg();
    AppMethodBeat.o(112584);
  }
  
  public static abstract interface a
  {
    public abstract void Yd(String paramString);
    
    public abstract void bUh();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.c
 * JD-Core Version:    0.7.0.1
 */