package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d
  implements f, k.a, com.tencent.mm.plugin.card.base.d
{
  public WeakReference<Context> alY;
  public List<WeakReference<d.a>> fKm = new ArrayList();
  public HashMap<d.a, Boolean> ikh = new HashMap();
  public HashMap<String, Boolean> iki = new HashMap();
  public HashMap<String, Boolean> ikj = new HashMap();
  public com.tencent.mm.plugin.card.base.b ikk = null;
  public boolean ikl = false;
  public String ikm;
  
  private void azQ()
  {
    y.i("MicroMsg.CardConsumedMgr", "doVibrate()");
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
          localObject = (d.a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((d.a)localObject).azU();
          }
        }
        i += 1;
      }
    }
  }
  
  private void azR()
  {
    y.i("MicroMsg.CardConsumedMgr", "doFinishUI()");
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
          localObject = (d.a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((d.a)localObject).azV();
          }
        }
        i += 1;
      }
    }
  }
  
  private void azS()
  {
    y.i("MicroMsg.CardConsumedMgr", "needDoConsumedInfo(), need to do NetSceneGetShareCardConsumedInfo. ");
    azT();
  }
  
  /* Error */
  private void azT()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/tencent/mm/plugin/card/b/d:ikl	Z
    //   6: ifeq +13 -> 19
    //   9: ldc 56
    //   11: ldc 96
    //   13: invokestatic 64	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: ldc 56
    //   21: ldc 98
    //   23: invokestatic 64	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: iconst_1
    //   28: putfield 52	com/tencent/mm/plugin/card/b/d:ikl	Z
    //   31: new 100	com/tencent/mm/plugin/card/sharecard/model/d
    //   34: dup
    //   35: aload_0
    //   36: getfield 50	com/tencent/mm/plugin/card/b/d:ikk	Lcom/tencent/mm/plugin/card/base/b;
    //   39: invokeinterface 106 1 0
    //   44: ldc 108
    //   46: ldc 108
    //   48: invokespecial 111	com/tencent/mm/plugin/card/sharecard/model/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   51: astore_1
    //   52: invokestatic 117	com/tencent/mm/kernel/g:DO	()Lcom/tencent/mm/kernel/b;
    //   55: getfield 123	com/tencent/mm/kernel/b:dJT	Lcom/tencent/mm/ah/p;
    //   58: aload_1
    //   59: iconst_0
    //   60: invokevirtual 129	com/tencent/mm/ah/p:a	(Lcom/tencent/mm/ah/m;I)Z
    //   63: pop
    //   64: goto -48 -> 16
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	d
    //   51	8	1	locald	com.tencent.mm.plugin.card.sharecard.model.d
    //   67	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	67	finally
    //   19	64	67	finally
  }
  
  private void c(com.tencent.mm.plugin.card.base.b paramb)
  {
    y.i("MicroMsg.CardConsumedMgr", "doUpdateCardInfo()");
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
          localObject = (d.a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((d.a)localObject).d(paramb);
          }
        }
        i += 1;
      }
    }
  }
  
  private void xZ(String paramString)
  {
    y.i("MicroMsg.CardConsumedMgr", "startConsumedSuccUI()");
    if (this.fKm == null) {
      return;
    }
    int j = 0;
    int i = 0;
    label19:
    Object localObject;
    if (j < this.fKm.size())
    {
      localObject = (WeakReference)this.fKm.get(j);
      if (localObject == null) {
        break label197;
      }
      localObject = (d.a)((WeakReference)localObject).get();
      Boolean localBoolean = (Boolean)this.ikh.get(localObject);
      if ((localObject == null) || (localBoolean == null) || (!localBoolean.booleanValue())) {
        break label197;
      }
      ((d.a)localObject).ya(paramString);
      i = 1;
    }
    label197:
    for (;;)
    {
      j += 1;
      break label19;
      localObject = (Boolean)this.iki.get(this.ikk.azB());
      if (i != 0)
      {
        y.i("MicroMsg.CardConsumedMgr", "onStartConsumedSuccUI is handled!");
        this.ikm = "";
        return;
      }
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
        break;
      }
      y.i("MicroMsg.CardConsumedMgr", "add to launch pending list!");
      this.ikm = paramString;
      this.ikj.put(this.ikk.azB(), Boolean.valueOf(true));
      return;
    }
  }
  
  public final void a(d.a parama)
  {
    if (this.fKm == null) {
      this.fKm = new ArrayList();
    }
    if (parama != null) {
      this.fKm.add(new WeakReference(parama));
    }
  }
  
  public final void a(d.a parama, boolean paramBoolean)
  {
    if (this.ikh == null) {
      this.ikh = new HashMap();
    }
    this.ikh.put(parama, Boolean.valueOf(paramBoolean));
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    y.i("MicroMsg.CardConsumedMgr", "onChange()");
    y.i("MicroMsg.CardConsumedMgr", "card msg card id is " + paramg.field_card_id);
    if (this.ikk == null)
    {
      y.e("MicroMsg.CardConsumedMgr", "onChange(), do nothing, mCardInfo == null");
      azR();
    }
    do
    {
      return;
      y.i("MicroMsg.CardConsumedMgr", "card msg card id is " + paramg.field_card_id);
      if ((this.ikk.azd()) && (paramg.field_card_id != null) && (paramg.field_card_id.equals(this.ikk.azB())) && (paramg.imS == 3))
      {
        y.i("MicroMsg.CardConsumedMgr", "it is card type, don't do NetSceneGetShareCardConsumedInfo! finish UI");
        azR();
        return;
      }
      if (!this.ikk.aze())
      {
        y.i("MicroMsg.CardConsumedMgr", "it is not card type, don't update share card data!");
        azR();
        return;
      }
    } while ((paramg.imS != 3) && ((paramg.field_card_id == null) || (!paramg.field_card_id.equals(this.ikk.azB())) || (TextUtils.isEmpty(paramg.field_consumed_box_id))));
    long l1 = System.currentTimeMillis();
    y.i("MicroMsg.CardConsumedMgr", "consumed share card msg,  update share card data!");
    int i;
    Object localObject;
    if ((paramg.field_card_id != null) && (paramg.field_card_id.equals(this.ikk.azB())))
    {
      paramg = am.aAA().yy(this.ikk.azB());
      if ((paramg != null) && (paramg.azy() != null))
      {
        i = this.ikk.azy().status;
        y.d("MicroMsg.CardConsumedMgr", "onChange() current oldState %s, newStatus %s, shareCardStatus %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramg.azy().status), Integer.valueOf(((ShareCardInfo)this.ikk).field_status) });
        if (paramg.azy().status != i) {
          azQ();
        }
      }
      else
      {
        c(this.ikk);
        paramg = (Boolean)this.iki.get(this.ikk.azB());
        if ((paramg != null) && (paramg.booleanValue())) {
          break label751;
        }
        paramg = (Context)this.alY.get();
        y.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.ikk.azB());
        com.tencent.mm.plugin.card.sharecard.a.b.a(paramg, this.ikk);
        this.iki.put(this.ikk.azB(), Boolean.valueOf(true));
        long l2 = System.currentTimeMillis();
        paramg = new ArrayList();
        localObject = new IDKey();
        ((IDKey)localObject).SetID(281);
        ((IDKey)localObject).SetKey(30);
        ((IDKey)localObject).SetValue(1L);
        IDKey localIDKey = new IDKey();
        localIDKey.SetID(281);
        localIDKey.SetKey(31);
        localIDKey.SetValue((int)(l2 - l1));
        paramg.add(localObject);
        paramg.add(localIDKey);
        h.nFQ.b(paramg, true);
      }
    }
    for (;;)
    {
      azS();
      return;
      if (i == 1) {
        break;
      }
      y.i("MicroMsg.CardConsumedMgr", "share card oldState status is " + i);
      paramg = this.ikk.azy();
      paramg.status = 1;
      ((ShareCardInfo)this.ikk).field_status = 1;
      this.ikk.a(paramg);
      l.h(this.ikk);
      break;
      if (paramg.field_card_id == null) {
        break;
      }
      paramg = am.aAA().yy(paramg.field_card_id);
      if ((paramg != null) && (paramg.azy() != null))
      {
        y.d("MicroMsg.CardConsumedMgr", "onChange() not current oldState %s,shareCardStatus %s", new Object[] { Integer.valueOf(paramg.azy().status), Integer.valueOf(paramg.field_status) });
        if (paramg.azy().status == 1) {
          break;
        }
        localObject = paramg.azy();
        ((lv)localObject).status = 1;
        paramg.field_status = 1;
        paramg.a((lv)localObject);
        l.h(paramg);
        break;
      }
      y.w("MicroMsg.CardConsumedMgr", "tempCard is null");
      break;
      label751:
      y.i("MicroMsg.CardConsumedMgr", "consumed:" + paramg.booleanValue());
    }
  }
  
  public final void axs()
  {
    azQ();
  }
  
  public final void azI()
  {
    y.i("MicroMsg.CardConsumedMgr", "onDBchange()");
    if (this.ikk == null)
    {
      y.e("MicroMsg.CardConsumedMgr", "onDBchange(), do nothing, mCardInfo == null");
      return;
    }
    Object localObject1;
    label53:
    label210:
    Object localObject2;
    if (this.ikk.aze())
    {
      localObject1 = am.aAA().yy(this.ikk.azB());
      if ((localObject1 == null) || (((com.tencent.mm.plugin.card.base.b)localObject1).azy() == null) || (this.ikk == null) || (this.ikk.azy() == null)) {
        break label536;
      }
      int i = this.ikk.azy().status;
      y.d("MicroMsg.CardConsumedMgr", "onDBchange() oldState %s, newStatus %s, isDoingConsumedInfo %s, isShareCard %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.card.base.b)localObject1).azy().status), Boolean.valueOf(this.ikl), Boolean.valueOf(this.ikk.aze()) });
      if ((!this.ikk.aze()) || (!(this.ikk instanceof ShareCardInfo))) {
        break label538;
      }
      y.d("MicroMsg.CardConsumedMgr", "onDBchange() shareCardState %s", new Object[] { Integer.valueOf(((ShareCardInfo)this.ikk).field_status) });
      if (((com.tencent.mm.plugin.card.base.b)localObject1).azy().status != i)
      {
        azQ();
        if ((!this.ikk.aze()) || (this.ikl) || (((com.tencent.mm.plugin.card.base.b)localObject1).azy().status != 1)) {
          break label590;
        }
        y.i("MicroMsg.CardConsumedMgr", "onDBchange(), need to get the consumedinfo , don't finish UI!");
        localObject2 = (Boolean)this.iki.get(this.ikk.azB());
        if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
          break label561;
        }
        y.i("MicroMsg.CardConsumedMgr", "consumed is null or consumed is false!");
        long l1 = System.currentTimeMillis();
        localObject2 = (Context)this.alY.get();
        y.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.ikk.azB());
        com.tencent.mm.plugin.card.sharecard.a.b.a((Context)localObject2, this.ikk);
        this.iki.put(this.ikk.azB(), Boolean.valueOf(true));
        long l2 = System.currentTimeMillis();
        localObject2 = new ArrayList();
        IDKey localIDKey1 = new IDKey();
        localIDKey1.SetID(281);
        localIDKey1.SetKey(30);
        localIDKey1.SetValue(1L);
        IDKey localIDKey2 = new IDKey();
        localIDKey2.SetID(281);
        localIDKey2.SetKey(31);
        localIDKey2.SetValue((int)(l2 - l1));
        ((ArrayList)localObject2).add(localIDKey1);
        ((ArrayList)localObject2).add(localIDKey2);
        h.nFQ.b((ArrayList)localObject2, true);
        label491:
        azS();
      }
    }
    for (;;)
    {
      y.i("MicroMsg.CardConsumedMgr", "onDBchange(),card coupon is consumde success!");
      this.ikk = ((com.tencent.mm.plugin.card.base.b)localObject1);
      c(this.ikk);
      return;
      localObject1 = am.aAs().yi(this.ikk.azB());
      break label53;
      label536:
      break;
      label538:
      if (!this.ikk.aze()) {
        break label210;
      }
      y.e("MicroMsg.CardConsumedMgr", "onDBchange() mCardInfo is ShareCard, but not the ShareCardInfo instance!");
      break label210;
      label561:
      y.i("MicroMsg.CardConsumedMgr", "consumed:" + ((Boolean)localObject2).booleanValue());
      break label491;
      label590:
      if ((this.ikk.aze()) && (this.ikl))
      {
        y.i("MicroMsg.CardConsumedMgr", "onDBchange(), is getting the consumedinfo!");
      }
      else
      {
        y.i("MicroMsg.CardConsumedMgr", "onDBchange(),finish CardConsumeCodeUI!");
        azR();
      }
    }
  }
  
  public final void b(d.a parama)
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
          d.a locala = (d.a)localWeakReference.get();
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
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb)
  {
    this.ikk = paramb;
    if ((this.ikl) && (this.ikk != null) && (paramb.azB() != null) && (!paramb.azB().equals(this.ikk.azB()))) {
      this.ikl = false;
    }
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
          localObject = (d.a)((WeakReference)localObject).get();
          Boolean localBoolean = (Boolean)this.ikh.get(localObject);
          if ((localObject != null) && (localBoolean != null) && (!localBoolean.booleanValue())) {
            ((d.a)localObject).d(paramb);
          }
        }
        i += 1;
      }
    }
  }
  
  public final void c(d.a parama)
  {
    if (this.ikh == null) {
      this.ikh = new HashMap();
    }
    this.ikh.remove(parama);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.CardConsumedMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramm;
        if (TextUtils.isEmpty(paramString.inn)) {
          break label90;
        }
        xZ(paramString.inn);
        this.ikl = false;
        y.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo ok! finish UI!");
        azR();
      }
    }
    label90:
    while (!(paramm instanceof com.tencent.mm.plugin.card.sharecard.model.d)) {
      for (;;)
      {
        return;
        y.e("MicroMsg.CardConsumedMgr", "consumed return json is empty!");
      }
    }
    this.ikl = false;
    y.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo failed! finish UI!");
    azR();
  }
  
  public final void release()
  {
    com.tencent.mm.kernel.g.DO().dJT.b(910, this);
    am.aAz().b(this);
    b localb = am.aAr();
    if ((localb.fKm == null) || (this == null)) {}
    label139:
    for (;;)
    {
      this.fKm.clear();
      this.ikh.clear();
      this.ikj.clear();
      this.ikl = false;
      return;
      int i = 0;
      for (;;)
      {
        if (i >= localb.fKm.size()) {
          break label139;
        }
        WeakReference localWeakReference = (WeakReference)localb.fKm.get(i);
        if (localWeakReference != null)
        {
          com.tencent.mm.plugin.card.base.d locald = (com.tencent.mm.plugin.card.base.d)localWeakReference.get();
          if ((locald != null) && (locald.equals(this)))
          {
            localb.fKm.remove(localWeakReference);
            break;
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.d
 * JD-Core Version:    0.7.0.1
 */