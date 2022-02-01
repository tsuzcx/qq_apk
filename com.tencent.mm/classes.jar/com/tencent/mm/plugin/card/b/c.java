package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements f
{
  List<WeakReference<a>> oCX;
  String oCY;
  public LinkedList<String> oCZ;
  public int oDa;
  private int oDb;
  private int oDc;
  private int oDd;
  private int oDe;
  private boolean oDf;
  private aw oDg;
  private aw oDh;
  
  public c()
  {
    AppMethodBeat.i(112583);
    this.oCX = new ArrayList();
    this.oCY = "";
    this.oCZ = new LinkedList();
    this.oDe = 60;
    this.oDf = false;
    this.oDg = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112581);
        ae.i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
        c.this.YV(c.this.oCY);
        c.this.bVs();
        AppMethodBeat.o(112581);
        return true;
      }
    }, false);
    this.oDh = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112582);
        ae.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
        c localc = c.this;
        ae.i("MicroMsg.CardCodeMgr", "onCodeChange()");
        if (localc.oCX != null)
        {
          int i = 0;
          while (i < localc.oCX.size())
          {
            Object localObject = (WeakReference)localc.oCX.get(i);
            if (localObject != null)
            {
              localObject = (c.a)((WeakReference)localObject).get();
              if (localObject != null) {
                ((c.a)localObject).bVw();
              }
            }
            i += 1;
          }
        }
        c.this.bVu();
        AppMethodBeat.o(112582);
        return true;
      }
    }, false);
    AppMethodBeat.o(112583);
  }
  
  private void YU(String paramString)
  {
    AppMethodBeat.i(112588);
    ae.i("MicroMsg.CardCodeMgr", "onFail()");
    if (this.oCX == null)
    {
      AppMethodBeat.o(112588);
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
          ((a)localObject).YU(paramString);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112588);
  }
  
  private void bVr()
  {
    AppMethodBeat.i(112592);
    ac localac = new ac(this.oCY);
    g.ajQ().gDv.a(localac, 0);
    AppMethodBeat.o(112592);
  }
  
  private void bVt()
  {
    AppMethodBeat.i(112595);
    ae.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
    if (!this.oDg.foU()) {
      this.oDg.stopTimer();
    }
    AppMethodBeat.o(112595);
  }
  
  private void onSuccess()
  {
    AppMethodBeat.i(112587);
    ae.i("MicroMsg.CardCodeMgr", "onSuccess()");
    if (this.oCX == null)
    {
      AppMethodBeat.o(112587);
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
          ((a)localObject).onSuccess();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112587);
  }
  
  public final void YV(String paramString)
  {
    AppMethodBeat.i(112591);
    if (this.oDf)
    {
      ae.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), is doing get codes");
      AppMethodBeat.o(112591);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), mCardId is empty!");
      AppMethodBeat.o(112591);
      return;
    }
    ae.i("MicroMsg.CardCodeMgr", "doGetCardCodes() do get codes, card id ".concat(String.valueOf(paramString)));
    this.oDf = true;
    this.oCY = paramString;
    bVr();
    AppMethodBeat.o(112591);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112585);
    if (this.oCX == null) {
      this.oCX = new ArrayList();
    }
    this.oCX.add(new WeakReference(parama));
    AppMethodBeat.o(112585);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112586);
    if (this.oCX == null)
    {
      AppMethodBeat.o(112586);
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
          AppMethodBeat.o(112586);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112586);
  }
  
  public final void bVs()
  {
    AppMethodBeat.i(112594);
    bVt();
    ae.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.oDb);
    if ((this.oDb > 0) && (!TextUtils.isEmpty(this.oCY)))
    {
      aw localaw = this.oDg;
      long l = this.oDb * 1000;
      localaw.ay(l, l);
      ae.i("MicroMsg.CardCodeMgr", "start request code timer!");
      AppMethodBeat.o(112594);
      return;
    }
    ae.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
    AppMethodBeat.o(112594);
  }
  
  public final void bVu()
  {
    AppMethodBeat.i(112596);
    bVv();
    ae.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.oDd);
    if (this.oDd > 0)
    {
      localaw = this.oDh;
      l = this.oDd * 1000;
      localaw.ay(l, l);
      ae.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
      AppMethodBeat.o(112596);
      return;
    }
    aw localaw = this.oDh;
    long l = this.oDe * 1000;
    localaw.ay(l, l);
    ae.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
    AppMethodBeat.o(112596);
  }
  
  public final void bVv()
  {
    AppMethodBeat.i(112597);
    ae.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
    if (!this.oDh.foU()) {
      this.oDh.stopTimer();
    }
    AppMethodBeat.o(112597);
  }
  
  public final String getCode()
  {
    AppMethodBeat.i(112589);
    if ((this.oCZ == null) || (this.oCZ.size() == 0))
    {
      ae.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(112589);
      return "";
    }
    if (this.oDa >= this.oCZ.size())
    {
      ae.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      YV(this.oCY);
      AppMethodBeat.o(112589);
      return "";
    }
    if (this.oDc >= this.oCZ.size() - this.oDa)
    {
      ae.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
      YV(this.oCY);
    }
    ae.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.oDa + " request_count:" + this.oDc + " codes size:" + this.oCZ.size());
    Object localObject = this.oCZ;
    int i = this.oDa;
    this.oDa = (i + 1);
    localObject = (String)((LinkedList)localObject).get(i);
    AppMethodBeat.o(112589);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(112590);
    if ((this.oCZ == null) || (this.oCZ.size() == 0))
    {
      ae.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(112590);
      return true;
    }
    if (this.oDa >= this.oCZ.size())
    {
      ae.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      AppMethodBeat.o(112590);
      return true;
    }
    AppMethodBeat.o(112590);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112593);
    ae.i("MicroMsg.CardCodeMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof ac))
      {
        this.oDf = false;
        ae.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.oCY);
        paramString = (ac)paramn;
        this.oDb = paramString.oDb;
        this.oDc = paramString.oDc;
        this.oDd = paramString.oDd;
        if (paramString.oCZ != null)
        {
          this.oCZ.clear();
          this.oCZ.addAll(paramString.oCZ);
          this.oDa = 0;
        }
        onSuccess();
        bVs();
        if (this.oDd != 0) {
          bVu();
        }
        AppMethodBeat.o(112593);
      }
    }
    else if ((paramn instanceof ac))
    {
      this.oDf = false;
      ae.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.oCY);
      YU(paramString);
    }
    AppMethodBeat.o(112593);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112584);
    g.ajQ().gDv.b(577, this);
    this.oCZ.clear();
    this.oDf = false;
    this.oCY = "";
    this.oDa = 0;
    this.oDb = 0;
    this.oDc = 0;
    this.oDd = 0;
    bVt();
    bVv();
    AppMethodBeat.o(112584);
  }
  
  public static abstract interface a
  {
    public abstract void YU(String paramString);
    
    public abstract void bVw();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.c
 * JD-Core Version:    0.7.0.1
 */