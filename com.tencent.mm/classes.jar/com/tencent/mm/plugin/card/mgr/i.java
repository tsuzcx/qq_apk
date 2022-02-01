package com.tencent.mm.plugin.card.mgr;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.k.d;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.card.sharecard.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class i
  implements com.tencent.mm.am.h
{
  private List<WeakReference<a>> eNV;
  public ArrayList<String> wsd;
  public ArrayList<String> wse;
  public MMHandler wsf;
  public HashMap<String, Runnable> wsg;
  
  public i()
  {
    AppMethodBeat.i(112672);
    this.eNV = new ArrayList();
    this.wsd = new ArrayList();
    this.wse = new ArrayList();
    this.wsf = new MMHandler();
    this.wsg = new LinkedHashMap();
    com.tencent.mm.kernel.h.baD().mCm.a(1078, this);
    this.wsd.clear();
    this.wse.clear();
    this.wsg.clear();
    AppMethodBeat.o(112672);
  }
  
  private void a(String paramString, b paramb)
  {
    AppMethodBeat.i(112675);
    Log.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
    if (this.eNV == null)
    {
      AppMethodBeat.o(112675);
      return;
    }
    if ((!this.wsd.contains(paramString)) && (!this.wse.contains(paramString)))
    {
      Log.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
      AppMethodBeat.o(112675);
      return;
    }
    int i = 0;
    if (i < this.eNV.size())
    {
      Object localObject = (WeakReference)this.eNV.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (!this.wsd.contains(paramString)) {
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
        if (this.wse.contains(paramString)) {
          ((a)localObject).akx(paramString);
        }
      }
    }
    AppMethodBeat.o(112675);
  }
  
  private void akv(String paramString)
  {
    AppMethodBeat.i(112677);
    Log.i("MicroMsg.CardMarkCodeMgr", "removeId()");
    if ((this.wsd.contains(paramString)) && (!this.wse.contains(paramString)))
    {
      this.wsd.remove(paramString);
      Log.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if ((!this.wsd.contains(paramString)) && (this.wse.contains(paramString)))
    {
      this.wse.remove(paramString);
      Runnable localRunnable = (Runnable)this.wsg.get(paramString);
      this.wsg.remove(paramString);
      this.wsf.removeCallbacks(localRunnable);
      Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
      Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(112677);
  }
  
  private void akw(String paramString)
  {
    AppMethodBeat.i(112678);
    Log.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
    if (this.wse.contains(paramString))
    {
      this.wse.remove(paramString);
      Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(paramString)));
    }
    if (this.wsg.containsKey(paramString))
    {
      Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(paramString)));
      Runnable localRunnable = (Runnable)this.wsg.get(paramString);
      this.wsg.remove(paramString);
      this.wsf.removeCallbacks(localRunnable);
    }
    AppMethodBeat.o(112678);
  }
  
  private void gc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112676);
    Log.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
    if (this.eNV == null)
    {
      AppMethodBeat.o(112676);
      return;
    }
    if ((!this.wsd.contains(paramString1)) || (this.wse.contains(paramString1)))
    {
      Log.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
      AppMethodBeat.o(112676);
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
          ((a)localObject).gd(paramString1, paramString2);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112676);
  }
  
  private static void m(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112681);
    if (TextUtils.isEmpty(paramString))
    {
      Log.i("MicroMsg.CardMarkCodeMgr", "card_id is empty, don't call NetSceneMarkShareCard cgi");
      AppMethodBeat.o(112681);
      return;
    }
    Log.i("MicroMsg.CardMarkCodeMgr", "doMarkNetscene()");
    paramString = new f(paramString, paramInt1, paramInt2, paramInt3);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    AppMethodBeat.o(112681);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112673);
    if (this.eNV == null) {
      this.eNV = new ArrayList();
    }
    this.eNV.add(new WeakReference(parama));
    AppMethodBeat.o(112673);
  }
  
  public final void ab(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112679);
    Log.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
    akw(paramString);
    if (!this.wsd.contains(paramString)) {
      this.wsd.add(paramString);
    }
    m(paramString, paramInt1, 1, paramInt2);
    AppMethodBeat.o(112679);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112674);
    if (this.eNV == null)
    {
      AppMethodBeat.o(112674);
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
          AppMethodBeat.o(112674);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112674);
  }
  
  public final void dJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(112680);
    Log.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
    akw(paramString);
    this.wse.add(paramString);
    i.1 local1 = new i.1(this, paramString, paramInt);
    paramInt = Util.getInt(com.tencent.mm.k.i.aRD().at("ShareCard", "UnMarkDelay"), 0);
    this.wsf.postDelayed(local1, paramInt * 1000);
    this.wsg.put(paramString, local1);
    Log.i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + paramString + " system.time:" + System.currentTimeMillis());
    AppMethodBeat.o(112680);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(112682);
    Log.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof f))
      {
        paramString = (f)paramp;
        paramp = new b();
        paramp.wsl = paramString.wsl;
        paramp.wsm = paramString.wsm;
        paramp.wsn = paramString.wsn;
        paramp.wso = paramString.wso;
        paramp.wsp = paramString.wsp;
        Log.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + paramString.wwt);
        Log.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + paramp.wsl + " mark_succ:" + paramp.wsm + " mark_card_id:" + paramp.wsn + " expire_time:" + paramp.wso + " pay_qrcode_wording:" + paramp.wsp);
        a(paramString.wwt, paramp);
        akv(paramString.wwt);
        AppMethodBeat.o(112682);
      }
    }
    else if ((paramp instanceof f))
    {
      paramp = (f)paramp;
      Log.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + paramp.wwt);
      gc(paramp.wwt, paramString);
      akv(paramp.wwt);
    }
    AppMethodBeat.o(112682);
  }
  
  public static abstract interface a
  {
    public abstract void akx(String paramString);
    
    public abstract void b(String paramString, i.b paramb);
    
    public abstract void gd(String paramString1, String paramString2);
  }
  
  public static final class b
  {
    public String wsl;
    public int wsm = 0;
    public String wsn;
    public int wso;
    public String wsp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.i
 * JD-Core Version:    0.7.0.1
 */