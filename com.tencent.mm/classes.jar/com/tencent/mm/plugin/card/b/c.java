package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.card.model.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements i
{
  private List<WeakReference<a>> cSF;
  private String tmG;
  public LinkedList<String> tmH;
  public int tmI;
  private int tmJ;
  private int tmK;
  private int tmL;
  private int tmM;
  private boolean tmN;
  private MTimerHandler tmO;
  private MTimerHandler tmP;
  
  public c()
  {
    AppMethodBeat.i(112583);
    this.cSF = new ArrayList();
    this.tmG = "";
    this.tmH = new LinkedList();
    this.tmM = 60;
    this.tmN = false;
    this.tmO = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112581);
        Log.i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
        c.this.aqN(c.a(c.this));
        c.this.cGI();
        AppMethodBeat.o(112581);
        return true;
      }
    }, false);
    this.tmP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112582);
        Log.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
        c.b(c.this);
        c.this.cGK();
        AppMethodBeat.o(112582);
        return true;
      }
    }, false);
    AppMethodBeat.o(112583);
  }
  
  private void aqM(String paramString)
  {
    AppMethodBeat.i(112588);
    Log.i("MicroMsg.CardCodeMgr", "onFail()");
    if (this.cSF == null)
    {
      AppMethodBeat.o(112588);
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
          ((a)localObject).aqM(paramString);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112588);
  }
  
  private void cGH()
  {
    AppMethodBeat.i(112592);
    ac localac = new ac(this.tmG);
    h.aHF().kcd.a(localac, 0);
    AppMethodBeat.o(112592);
  }
  
  private void cGJ()
  {
    AppMethodBeat.i(112595);
    Log.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
    if (!this.tmO.stopped()) {
      this.tmO.stopTimer();
    }
    AppMethodBeat.o(112595);
  }
  
  private void onSuccess()
  {
    AppMethodBeat.i(112587);
    Log.i("MicroMsg.CardCodeMgr", "onSuccess()");
    if (this.cSF == null)
    {
      AppMethodBeat.o(112587);
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
          ((a)localObject).onSuccess();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112587);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112585);
    if (this.cSF == null) {
      this.cSF = new ArrayList();
    }
    this.cSF.add(new WeakReference(parama));
    AppMethodBeat.o(112585);
  }
  
  public final void aqN(String paramString)
  {
    AppMethodBeat.i(112591);
    if (this.tmN)
    {
      Log.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), is doing get codes");
      AppMethodBeat.o(112591);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), mCardId is empty!");
      AppMethodBeat.o(112591);
      return;
    }
    Log.i("MicroMsg.CardCodeMgr", "doGetCardCodes() do get codes, card id ".concat(String.valueOf(paramString)));
    this.tmN = true;
    this.tmG = paramString;
    cGH();
    AppMethodBeat.o(112591);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112586);
    if (this.cSF == null)
    {
      AppMethodBeat.o(112586);
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
          AppMethodBeat.o(112586);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112586);
  }
  
  public final void cGI()
  {
    AppMethodBeat.i(112594);
    cGJ();
    Log.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.tmJ);
    if ((this.tmJ > 0) && (!TextUtils.isEmpty(this.tmG)))
    {
      this.tmO.startTimer(this.tmJ * 1000);
      Log.i("MicroMsg.CardCodeMgr", "start request code timer!");
      AppMethodBeat.o(112594);
      return;
    }
    Log.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
    AppMethodBeat.o(112594);
  }
  
  public final void cGK()
  {
    AppMethodBeat.i(112596);
    cGL();
    Log.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.tmL);
    if (this.tmL > 0)
    {
      this.tmP.startTimer(this.tmL * 1000);
      Log.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
      AppMethodBeat.o(112596);
      return;
    }
    this.tmP.startTimer(this.tmM * 1000);
    Log.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
    AppMethodBeat.o(112596);
  }
  
  public final void cGL()
  {
    AppMethodBeat.i(112597);
    Log.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
    if (!this.tmP.stopped()) {
      this.tmP.stopTimer();
    }
    AppMethodBeat.o(112597);
  }
  
  public final String getCode()
  {
    AppMethodBeat.i(112589);
    if ((this.tmH == null) || (this.tmH.size() == 0))
    {
      Log.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(112589);
      return "";
    }
    if (this.tmI >= this.tmH.size())
    {
      Log.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      aqN(this.tmG);
      AppMethodBeat.o(112589);
      return "";
    }
    if (this.tmK >= this.tmH.size() - this.tmI)
    {
      Log.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
      aqN(this.tmG);
    }
    Log.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.tmI + " request_count:" + this.tmK + " codes size:" + this.tmH.size());
    Object localObject = this.tmH;
    int i = this.tmI;
    this.tmI = (i + 1);
    localObject = (String)((LinkedList)localObject).get(i);
    AppMethodBeat.o(112589);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(112590);
    if ((this.tmH == null) || (this.tmH.size() == 0))
    {
      Log.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(112590);
      return true;
    }
    if (this.tmI >= this.tmH.size())
    {
      Log.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      AppMethodBeat.o(112590);
      return true;
    }
    AppMethodBeat.o(112590);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(112593);
    Log.i("MicroMsg.CardCodeMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof ac))
      {
        this.tmN = false;
        Log.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.tmG);
        paramString = (ac)paramq;
        this.tmJ = paramString.tmJ;
        this.tmK = paramString.tmK;
        this.tmL = paramString.tmL;
        if (paramString.tmH != null)
        {
          this.tmH.clear();
          this.tmH.addAll(paramString.tmH);
          this.tmI = 0;
        }
        onSuccess();
        cGI();
        if (this.tmL != 0) {
          cGK();
        }
        AppMethodBeat.o(112593);
      }
    }
    else if ((paramq instanceof ac))
    {
      this.tmN = false;
      Log.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.tmG);
      aqM(paramString);
    }
    AppMethodBeat.o(112593);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112584);
    h.aHF().kcd.b(577, this);
    this.tmH.clear();
    this.tmN = false;
    this.tmG = "";
    this.tmI = 0;
    this.tmJ = 0;
    this.tmK = 0;
    this.tmL = 0;
    cGJ();
    cGL();
    AppMethodBeat.o(112584);
  }
  
  public static abstract interface a
  {
    public abstract void aqM(String paramString);
    
    public abstract void cGM();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.c
 * JD-Core Version:    0.7.0.1
 */