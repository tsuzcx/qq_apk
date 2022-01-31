package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.m.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class j
  implements com.tencent.mm.ah.f
{
  private List<WeakReference<j.a>> fKm = new ArrayList();
  public ArrayList<String> ikS = new ArrayList();
  public ArrayList<String> ikT = new ArrayList();
  public ah ikU = new ah();
  public HashMap<String, Runnable> ikV = new LinkedHashMap();
  
  public j()
  {
    com.tencent.mm.kernel.g.DO().dJT.a(907, this);
    this.ikS.clear();
    this.ikT.clear();
    this.ikV.clear();
  }
  
  private void a(String paramString, j.b paramb)
  {
    y.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
    if (this.fKm == null) {
      return;
    }
    if ((!this.ikS.contains(paramString)) && (!this.ikT.contains(paramString)))
    {
      y.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
      return;
    }
    int i = 0;
    label47:
    Object localObject;
    if (i < this.fKm.size())
    {
      localObject = (WeakReference)this.fKm.get(i);
      if (localObject != null)
      {
        localObject = (j.a)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (!this.ikS.contains(paramString)) {
            break label122;
          }
          ((j.a)localObject).b(paramString, paramb);
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label122:
      if (this.ikT.contains(paramString)) {
        ((j.a)localObject).yd(paramString);
      }
    }
  }
  
  private void cq(String paramString1, String paramString2)
  {
    y.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
    if (this.fKm == null) {}
    for (;;)
    {
      return;
      if ((!this.ikS.contains(paramString1)) || (this.ikT.contains(paramString1)))
      {
        y.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
        return;
      }
      int i = 0;
      while (i < this.fKm.size())
      {
        Object localObject = (WeakReference)this.fKm.get(i);
        if (localObject != null)
        {
          localObject = (j.a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((j.a)localObject).cr(paramString1, paramString2);
          }
        }
        i += 1;
      }
    }
  }
  
  static void g(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.i("MicroMsg.CardMarkCodeMgr", "card_id is empty, don't call NetSceneMarkShareCard cgi");
      return;
    }
    y.i("MicroMsg.CardMarkCodeMgr", "doMarkNetscene()");
    paramString = new com.tencent.mm.plugin.card.sharecard.model.f(paramString, paramInt1, paramInt2, paramInt3);
    com.tencent.mm.kernel.g.DO().dJT.a(paramString, 0);
  }
  
  private void yb(String paramString)
  {
    y.i("MicroMsg.CardMarkCodeMgr", "removeId()");
    if ((this.ikS.contains(paramString)) && (!this.ikT.contains(paramString)))
    {
      this.ikS.remove(paramString);
      y.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is " + paramString);
    }
    if ((!this.ikS.contains(paramString)) && (this.ikT.contains(paramString)))
    {
      this.ikT.remove(paramString);
      Runnable localRunnable = (Runnable)this.ikV.get(paramString);
      this.ikV.remove(paramString);
      this.ikU.removeCallbacks(localRunnable);
      y.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is " + paramString);
      y.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is " + paramString);
    }
  }
  
  private void yc(String paramString)
  {
    y.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
    if (this.ikT.contains(paramString))
    {
      this.ikT.remove(paramString);
      y.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is " + paramString);
    }
    if (this.ikV.containsKey(paramString))
    {
      y.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is " + paramString);
      Runnable localRunnable = (Runnable)this.ikV.get(paramString);
      this.ikV.remove(paramString);
      this.ikU.removeCallbacks(localRunnable);
    }
  }
  
  public final void I(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
    yc(paramString);
    if (!this.ikS.contains(paramString)) {
      this.ikS.add(paramString);
    }
    g(paramString, paramInt1, 1, paramInt2);
  }
  
  public final void a(j.a parama)
  {
    if (this.fKm == null) {
      this.fKm = new ArrayList();
    }
    if (parama != null) {
      this.fKm.add(new WeakReference(parama));
    }
  }
  
  public final void b(j.a parama)
  {
    if ((this.fKm == null) || (parama == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.fKm.size())
      {
        WeakReference localWeakReference = (WeakReference)this.fKm.get(i);
        if (localWeakReference != null)
        {
          j.a locala = (j.a)localWeakReference.get();
          if ((locala != null) && (locala.equals(parama)))
          {
            this.fKm.remove(localWeakReference);
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  public final void bl(String paramString, int paramInt)
  {
    y.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
    yc(paramString);
    this.ikT.add(paramString);
    j.1 local1 = new j.1(this, paramString, paramInt);
    paramInt = bk.getInt(com.tencent.mm.m.g.AB().H("ShareCard", "UnMarkDelay"), 0);
    this.ikU.postDelayed(local1, paramInt * 1000);
    this.ikV.put(paramString, local1);
    y.i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + paramString + " system.time:" + System.currentTimeMillis());
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.f))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.f)paramm;
        paramm = new j.b();
        paramm.ila = paramString.ila;
        paramm.ilb = paramString.ilb;
        paramm.ilc = paramString.ilc;
        paramm.ild = paramString.ild;
        paramm.ile = paramString.ile;
        y.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + paramString.ioJ);
        y.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + paramm.ila + " mark_succ:" + paramm.ilb + " mark_card_id:" + paramm.ilc + " expire_time:" + paramm.ild + " pay_qrcode_wording:" + paramm.ile);
        a(paramString.ioJ, paramm);
        yb(paramString.ioJ);
      }
    }
    while (!(paramm instanceof com.tencent.mm.plugin.card.sharecard.model.f)) {
      return;
    }
    paramm = (com.tencent.mm.plugin.card.sharecard.model.f)paramm;
    y.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + paramm.ioJ);
    cq(paramm.ioJ, paramString);
    yb(paramm.ioJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.j
 * JD-Core Version:    0.7.0.1
 */