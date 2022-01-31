package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.ac;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements f
{
  List<WeakReference<c.a>> fKm = new ArrayList();
  String ijW = "";
  public LinkedList<String> ijX = new LinkedList();
  public int ijY;
  private int ijZ;
  private int ika;
  private int ikb;
  private int ikc = 60;
  private boolean ikd = false;
  private am ike = new am(new c.1(this), false);
  private am ikf = new am(new c.2(this), false);
  
  private void azM()
  {
    y.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
    if (!this.ike.crl()) {
      this.ike.stopTimer();
    }
  }
  
  private void onSuccess()
  {
    y.i("MicroMsg.CardCodeMgr", "onSuccess()");
    if (this.fKm == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.fKm.size())
      {
        Object localObject = (WeakReference)this.fKm.get(i);
        if (localObject != null)
        {
          localObject = (c.a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((c.a)localObject).onSuccess();
          }
        }
        i += 1;
      }
    }
  }
  
  private void xX(String paramString)
  {
    y.i("MicroMsg.CardCodeMgr", "onFail()");
    if (this.fKm == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.fKm.size())
      {
        Object localObject = (WeakReference)this.fKm.get(i);
        if (localObject != null)
        {
          localObject = (c.a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((c.a)localObject).xX(paramString);
          }
        }
        i += 1;
      }
    }
  }
  
  public final void a(c.a parama)
  {
    if (this.fKm == null) {
      this.fKm = new ArrayList();
    }
    if (parama != null) {
      this.fKm.add(new WeakReference(parama));
    }
  }
  
  public final void azL()
  {
    azM();
    y.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.ijZ);
    if ((this.ijZ > 0) && (!TextUtils.isEmpty(this.ijW)))
    {
      am localam = this.ike;
      long l = this.ijZ * 1000;
      localam.S(l, l);
      y.i("MicroMsg.CardCodeMgr", "start request code timer!");
      return;
    }
    y.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
  }
  
  public final void azN()
  {
    azO();
    y.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.ikb);
    if (this.ikb > 0)
    {
      localam = this.ikf;
      l = this.ikb * 1000;
      localam.S(l, l);
      y.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
      return;
    }
    am localam = this.ikf;
    long l = this.ikc * 1000;
    localam.S(l, l);
    y.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
  }
  
  public final void azO()
  {
    y.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
    if (!this.ikf.crl()) {
      this.ikf.stopTimer();
    }
  }
  
  public final void b(c.a parama)
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
          c.a locala = (c.a)localWeakReference.get();
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
  
  public final String getCode()
  {
    if ((this.ijX == null) || (this.ijX.size() == 0))
    {
      y.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      return "";
    }
    if (this.ijY >= this.ijX.size())
    {
      y.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      xY(this.ijW);
      return "";
    }
    if (this.ika >= this.ijX.size() - this.ijY)
    {
      y.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
      xY(this.ijW);
    }
    y.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.ijY + " request_count:" + this.ika + " codes size:" + this.ijX.size());
    LinkedList localLinkedList = this.ijX;
    int i = this.ijY;
    this.ijY = (i + 1);
    return (String)localLinkedList.get(i);
  }
  
  public final boolean isEmpty()
  {
    if ((this.ijX == null) || (this.ijX.size() == 0))
    {
      y.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
      return true;
    }
    if (this.ijY >= this.ijX.size())
    {
      y.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
      return true;
    }
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.CardCodeMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof ac))
      {
        this.ikd = false;
        y.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.ijW);
        paramString = (ac)paramm;
        this.ijZ = paramString.ijZ;
        this.ika = paramString.ika;
        this.ikb = paramString.ikb;
        if (paramString.ijX != null)
        {
          this.ijX.clear();
          this.ijX.addAll(paramString.ijX);
          this.ijY = 0;
        }
        onSuccess();
        azL();
        if (this.ikb != 0) {
          azN();
        }
      }
    }
    while (!(paramm instanceof ac)) {
      return;
    }
    this.ikd = false;
    y.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.ijW);
    xX(paramString);
  }
  
  public final void release()
  {
    g.DO().dJT.b(577, this);
    this.ijX.clear();
    this.ikd = false;
    this.ijW = "";
    this.ijY = 0;
    this.ijZ = 0;
    this.ika = 0;
    this.ikb = 0;
    azM();
    azO();
  }
  
  public final void xY(String paramString)
  {
    if (this.ikd)
    {
      y.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), is doing get codes");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), mCardId is empty!");
      return;
    }
    y.i("MicroMsg.CardCodeMgr", "doGetCardCodes() do get codes, card id " + paramString);
    this.ikd = true;
    this.ijW = paramString;
    paramString = new ac(this.ijW);
    g.DO().dJT.a(paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.c
 * JD-Core Version:    0.7.0.1
 */