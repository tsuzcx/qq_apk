package com.tencent.mm.plugin.card.mgr;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.card.model.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements com.tencent.mm.am.h
{
  private List<WeakReference<a>> eNV;
  private String wrg;
  public LinkedList<String> wrh;
  public int wri;
  private int wrj;
  private int wrk;
  private int wrl;
  private int wrm;
  private boolean wrn;
  private MTimerHandler wro;
  private MTimerHandler wrp;
  
  public b()
  {
    AppMethodBeat.i(112583);
    this.eNV = new ArrayList();
    this.wrg = "";
    this.wrh = new LinkedList();
    this.wrm = 60;
    this.wrn = false;
    this.wro = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112581);
        Log.i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
        b.this.aks(b.a(b.this));
        b.this.djZ();
        AppMethodBeat.o(112581);
        return true;
      }
    }, false);
    this.wrp = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112582);
        Log.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
        b.b(b.this);
        b.this.dkb();
        AppMethodBeat.o(112582);
        return true;
      }
    }, false);
    AppMethodBeat.o(112583);
  }
  
  private void akr(String paramString)
  {
    AppMethodBeat.i(112588);
    Log.i("MicroMsg.CardCodeMgr", "onFail()");
    if (this.eNV == null)
    {
      AppMethodBeat.o(112588);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      Object localObject = (WeakReference)this.eNV.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).akr(paramString);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112588);
  }
  
  private void djY()
  {
    AppMethodBeat.i(112592);
    ac localac = new ac(this.wrg);
    com.tencent.mm.kernel.h.baD().mCm.a(localac, 0);
    AppMethodBeat.o(112592);
  }
  
  private void dka()
  {
    AppMethodBeat.i(112595);
    Log.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
    if (!this.wro.stopped()) {
      this.wro.stopTimer();
    }
    AppMethodBeat.o(112595);
  }
  
  private void onSuccess()
  {
    AppMethodBeat.i(112587);
    Log.i("MicroMsg.CardCodeMgr", "onSuccess()");
    if (this.eNV == null)
    {
      AppMethodBeat.o(112587);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      Object localObject = (WeakReference)this.eNV.get(i);
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
    if (this.eNV == null) {
      this.eNV = new ArrayList();
    }
    this.eNV.add(new WeakReference(parama));
    AppMethodBeat.o(112585);
  }
  
  public final void aks(String paramString)
  {
    AppMethodBeat.i(112591);
    if (this.wrn)
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
    this.wrn = true;
    this.wrg = paramString;
    djY();
    AppMethodBeat.o(112591);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112586);
    if (this.eNV == null)
    {
      AppMethodBeat.o(112586);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      WeakReference localWeakReference = (WeakReference)this.eNV.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.eNV.remove(localWeakReference);
          AppMethodBeat.o(112586);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112586);
  }
  
  public final void djZ()
  {
    AppMethodBeat.i(112594);
    dka();
    Log.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.wrj);
    if ((this.wrj > 0) && (!TextUtils.isEmpty(this.wrg)))
    {
      this.wro.startTimer(this.wrj * 1000);
      Log.i("MicroMsg.CardCodeMgr", "start request code timer!");
      AppMethodBeat.o(112594);
      return;
    }
    Log.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
    AppMethodBeat.o(112594);
  }
  
  public final void dkb()
  {
    AppMethodBeat.i(112596);
    dkc();
    Log.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.wrl);
    if (this.wrl > 0)
    {
      this.wrp.startTimer(this.wrl * 1000);
      Log.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
      AppMethodBeat.o(112596);
      return;
    }
    this.wrp.startTimer(this.wrm * 1000);
    Log.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
    AppMethodBeat.o(112596);
  }
  
  public final void dkc()
  {
    AppMethodBeat.i(112597);
    Log.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
    if (!this.wrp.stopped()) {
      this.wrp.stopTimer();
    }
    AppMethodBeat.o(112597);
  }
  
  public final String getCode()
  {
    AppMethodBeat.i(112589);
    if ((this.wrh == null) || (this.wrh.size() == 0))
    {
      Log.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(112589);
      return "";
    }
    if (this.wri >= this.wrh.size())
    {
      Log.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      aks(this.wrg);
      AppMethodBeat.o(112589);
      return "";
    }
    if (this.wrk >= this.wrh.size() - this.wri)
    {
      Log.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
      aks(this.wrg);
    }
    Log.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.wri + " request_count:" + this.wrk + " codes size:" + this.wrh.size());
    Object localObject = this.wrh;
    int i = this.wri;
    this.wri = (i + 1);
    localObject = (String)((LinkedList)localObject).get(i);
    AppMethodBeat.o(112589);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(112590);
    if ((this.wrh == null) || (this.wrh.size() == 0))
    {
      Log.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      AppMethodBeat.o(112590);
      return true;
    }
    if (this.wri >= this.wrh.size())
    {
      Log.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      AppMethodBeat.o(112590);
      return true;
    }
    AppMethodBeat.o(112590);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(112593);
    Log.i("MicroMsg.CardCodeMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof ac))
      {
        this.wrn = false;
        Log.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.wrg);
        paramString = (ac)paramp;
        this.wrj = paramString.wrj;
        this.wrk = paramString.wrk;
        this.wrl = paramString.wrl;
        if (paramString.wrh != null)
        {
          this.wrh.clear();
          this.wrh.addAll(paramString.wrh);
          this.wri = 0;
        }
        onSuccess();
        djZ();
        if (this.wrl != 0) {
          dkb();
        }
        AppMethodBeat.o(112593);
      }
    }
    else if ((paramp instanceof ac))
    {
      this.wrn = false;
      Log.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.wrg);
      akr(paramString);
    }
    AppMethodBeat.o(112593);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112584);
    com.tencent.mm.kernel.h.baD().mCm.b(577, this);
    this.wrh.clear();
    this.wrn = false;
    this.wrg = "";
    this.wri = 0;
    this.wrj = 0;
    this.wrk = 0;
    this.wrl = 0;
    dka();
    dkc();
    AppMethodBeat.o(112584);
  }
  
  public static abstract interface a
  {
    public abstract void akr(String paramString);
    
    public abstract void dkd();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.b
 * JD-Core Version:    0.7.0.1
 */