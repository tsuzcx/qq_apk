package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
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
  List<WeakReference<a>> pQG;
  String pQH;
  public LinkedList<String> pQI;
  public int pQJ;
  private int pQK;
  private int pQL;
  private int pQM;
  private int pQN;
  private boolean pQO;
  private MTimerHandler pQP;
  private MTimerHandler pQQ;
  
  public c()
  {
    AppMethodBeat.i(112583);
    this.pQG = new ArrayList();
    this.pQH = "";
    this.pQI = new LinkedList();
    this.pQN = 60;
    this.pQO = false;
    this.pQP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112581);
        Log.i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
        c.this.aja(c.this.pQH);
        c.this.ctg();
        AppMethodBeat.o(112581);
        return true;
      }
    }, false);
    this.pQQ = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112582);
        Log.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
        c localc = c.this;
        Log.i("MicroMsg.CardCodeMgr", "onCodeChange()");
        if (localc.pQG != null)
        {
          int i = 0;
          while (i < localc.pQG.size())
          {
            Object localObject = (WeakReference)localc.pQG.get(i);
            if (localObject != null)
            {
              localObject = (c.a)((WeakReference)localObject).get();
              if (localObject != null) {
                ((c.a)localObject).ctk();
              }
            }
            i += 1;
          }
        }
        c.this.cti();
        AppMethodBeat.o(112582);
        return true;
      }
    }, false);
    AppMethodBeat.o(112583);
  }
  
  private void aiZ(String paramString)
  {
    AppMethodBeat.i(112588);
    Log.i("MicroMsg.CardCodeMgr", "onFail()");
    if (this.pQG == null)
    {
      AppMethodBeat.o(112588);
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
          ((a)localObject).aiZ(paramString);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112588);
  }
  
  private void ctf()
  {
    AppMethodBeat.i(112592);
    ac localac = new ac(this.pQH);
    g.aAg().hqi.a(localac, 0);
    AppMethodBeat.o(112592);
  }
  
  private void cth()
  {
    AppMethodBeat.i(112595);
    Log.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
    if (!this.pQP.stopped()) {
      this.pQP.stopTimer();
    }
    AppMethodBeat.o(112595);
  }
  
  private void onSuccess()
  {
    AppMethodBeat.i(112587);
    Log.i("MicroMsg.CardCodeMgr", "onSuccess()");
    if (this.pQG == null)
    {
      AppMethodBeat.o(112587);
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
    if (this.pQG == null) {
      this.pQG = new ArrayList();
    }
    this.pQG.add(new WeakReference(parama));
    AppMethodBeat.o(112585);
  }
  
  public final void aja(String paramString)
  {
    AppMethodBeat.i(112591);
    if (this.pQO)
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
    this.pQO = true;
    this.pQH = paramString;
    ctf();
    AppMethodBeat.o(112591);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112586);
    if (this.pQG == null)
    {
      AppMethodBeat.o(112586);
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
          AppMethodBeat.o(112586);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112586);
  }
  
  public final void ctg()
  {
    AppMethodBeat.i(112594);
    cth();
    Log.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.pQK);
    if ((this.pQK > 0) && (!TextUtils.isEmpty(this.pQH)))
    {
      this.pQP.startTimer(this.pQK * 1000);
      Log.i("MicroMsg.CardCodeMgr", "start request code timer!");
      AppMethodBeat.o(112594);
      return;
    }
    Log.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
    AppMethodBeat.o(112594);
  }
  
  public final void cti()
  {
    AppMethodBeat.i(112596);
    ctj();
    Log.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.pQM);
    if (this.pQM > 0)
    {
      this.pQQ.startTimer(this.pQM * 1000);
      Log.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
      AppMethodBeat.o(112596);
      return;
    }
    this.pQQ.startTimer(this.pQN * 1000);
    Log.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
    AppMethodBeat.o(112596);
  }
  
  public final void ctj()
  {
    AppMethodBeat.i(112597);
    Log.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
    if (!this.pQQ.stopped()) {
      this.pQQ.stopTimer();
    }
    AppMethodBeat.o(112597);
  }
  
  public final String getCode()
  {
    AppMethodBeat.i(112589);
    if ((this.pQI == null) || (this.pQI.size() == 0))
    {
      Log.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(112589);
      return "";
    }
    if (this.pQJ >= this.pQI.size())
    {
      Log.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      aja(this.pQH);
      AppMethodBeat.o(112589);
      return "";
    }
    if (this.pQL >= this.pQI.size() - this.pQJ)
    {
      Log.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
      aja(this.pQH);
    }
    Log.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.pQJ + " request_count:" + this.pQL + " codes size:" + this.pQI.size());
    Object localObject = this.pQI;
    int i = this.pQJ;
    this.pQJ = (i + 1);
    localObject = (String)((LinkedList)localObject).get(i);
    AppMethodBeat.o(112589);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(112590);
    if ((this.pQI == null) || (this.pQI.size() == 0))
    {
      Log.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(112590);
      return true;
    }
    if (this.pQJ >= this.pQI.size())
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
        this.pQO = false;
        Log.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.pQH);
        paramString = (ac)paramq;
        this.pQK = paramString.pQK;
        this.pQL = paramString.pQL;
        this.pQM = paramString.pQM;
        if (paramString.pQI != null)
        {
          this.pQI.clear();
          this.pQI.addAll(paramString.pQI);
          this.pQJ = 0;
        }
        onSuccess();
        ctg();
        if (this.pQM != 0) {
          cti();
        }
        AppMethodBeat.o(112593);
      }
    }
    else if ((paramq instanceof ac))
    {
      this.pQO = false;
      Log.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.pQH);
      aiZ(paramString);
    }
    AppMethodBeat.o(112593);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112584);
    g.aAg().hqi.b(577, this);
    this.pQI.clear();
    this.pQO = false;
    this.pQH = "";
    this.pQJ = 0;
    this.pQK = 0;
    this.pQL = 0;
    this.pQM = 0;
    cth();
    ctj();
    AppMethodBeat.o(112584);
  }
  
  public static abstract interface a
  {
    public abstract void aiZ(String paramString);
    
    public abstract void ctk();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.c
 * JD-Core Version:    0.7.0.1
 */