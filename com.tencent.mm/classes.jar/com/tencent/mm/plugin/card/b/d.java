package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d
  implements f, k.a, com.tencent.mm.plugin.card.base.d
{
  public WeakReference<Context> aon;
  public List<WeakReference<d.a>> kkV;
  public HashMap<d.a, Boolean> klh;
  public HashMap<String, Boolean> kli;
  public HashMap<String, Boolean> klj;
  public com.tencent.mm.plugin.card.base.b klk;
  public boolean kll;
  public String klm;
  
  public d()
  {
    AppMethodBeat.i(87654);
    this.kkV = new ArrayList();
    this.klh = new HashMap();
    this.kli = new HashMap();
    this.klj = new HashMap();
    this.klk = null;
    this.kll = false;
    AppMethodBeat.o(87654);
  }
  
  private void HA(String paramString)
  {
    AppMethodBeat.i(87665);
    ab.i("MicroMsg.CardConsumedMgr", "startConsumedSuccUI()");
    if (this.kkV == null)
    {
      AppMethodBeat.o(87665);
      return;
    }
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < this.kkV.size())
    {
      localObject = (WeakReference)this.kkV.get(j);
      if (localObject == null) {
        break label216;
      }
      localObject = (d.a)((WeakReference)localObject).get();
      Boolean localBoolean = (Boolean)this.klh.get(localObject);
      if ((localObject == null) || (localBoolean == null) || (!localBoolean.booleanValue())) {
        break label216;
      }
      ((d.a)localObject).HB(paramString);
      i = 1;
    }
    label216:
    for (;;)
    {
      j += 1;
      break;
      localObject = (Boolean)this.kli.get(this.klk.bbh());
      if (i != 0)
      {
        ab.i("MicroMsg.CardConsumedMgr", "onStartConsumedSuccUI is handled!");
        this.klm = "";
        AppMethodBeat.o(87665);
        return;
      }
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        ab.i("MicroMsg.CardConsumedMgr", "add to launch pending list!");
        this.klm = paramString;
        this.klj.put(this.klk.bbh(), Boolean.TRUE);
      }
      AppMethodBeat.o(87665);
      return;
    }
  }
  
  private void bbA()
  {
    AppMethodBeat.i(87669);
    ab.i("MicroMsg.CardConsumedMgr", "needDoConsumedInfo(), need to do NetSceneGetShareCardConsumedInfo. ");
    bbB();
    AppMethodBeat.o(87669);
  }
  
  /* Error */
  private void bbB()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 132
    //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 59	com/tencent/mm/plugin/card/b/d:kll	Z
    //   11: ifeq +18 -> 29
    //   14: ldc 68
    //   16: ldc 134
    //   18: invokestatic 75	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 132
    //   23: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: ldc 68
    //   31: ldc 136
    //   33: invokestatic 75	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 59	com/tencent/mm/plugin/card/b/d:kll	Z
    //   41: new 138	com/tencent/mm/plugin/card/sharecard/model/d
    //   44: dup
    //   45: aload_0
    //   46: getfield 57	com/tencent/mm/plugin/card/b/d:klk	Lcom/tencent/mm/plugin/card/base/b;
    //   49: invokeinterface 108 1 0
    //   54: ldc 112
    //   56: ldc 112
    //   58: invokespecial 141	com/tencent/mm/plugin/card/sharecard/model/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   61: astore_1
    //   62: invokestatic 147	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   65: getfield 153	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   68: aload_1
    //   69: iconst_0
    //   70: invokevirtual 159	com/tencent/mm/ai/p:a	(Lcom/tencent/mm/ai/m;I)Z
    //   73: pop
    //   74: ldc 132
    //   76: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: goto -53 -> 26
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	d
    //   61	8	1	locald	com.tencent.mm.plugin.card.sharecard.model.d
    //   82	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	82	finally
    //   29	79	82	finally
  }
  
  private void bby()
  {
    AppMethodBeat.i(87667);
    ab.i("MicroMsg.CardConsumedMgr", "doVibrate()");
    if (this.kkV == null)
    {
      AppMethodBeat.o(87667);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (d.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((d.a)localObject).bbC();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87667);
  }
  
  private void bbz()
  {
    AppMethodBeat.i(87668);
    ab.i("MicroMsg.CardConsumedMgr", "doFinishUI()");
    if (this.kkV == null)
    {
      AppMethodBeat.o(87668);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (d.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((d.a)localObject).bbD();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87668);
  }
  
  private void c(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(87666);
    ab.i("MicroMsg.CardConsumedMgr", "doUpdateCardInfo()");
    if (this.kkV == null)
    {
      AppMethodBeat.o(87666);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (d.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((d.a)localObject).d(paramb);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87666);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(87656);
    if (this.kkV == null) {
      this.kkV = new ArrayList();
    }
    this.kkV.add(new WeakReference(parama));
    AppMethodBeat.o(87656);
  }
  
  public final void a(d.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(87659);
    if (this.klh == null) {
      this.klh = new HashMap();
    }
    this.klh.put(parama, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(87659);
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(87663);
    ab.i("MicroMsg.CardConsumedMgr", "onChange()");
    ab.i("MicroMsg.CardConsumedMgr", "card msg card id is " + paramg.field_card_id);
    if (this.klk == null)
    {
      ab.e("MicroMsg.CardConsumedMgr", "onChange(), do nothing, mCardInfo == null");
      bbz();
      AppMethodBeat.o(87663);
      return;
    }
    ab.i("MicroMsg.CardConsumedMgr", "card msg card id is " + paramg.field_card_id);
    if ((this.klk.baJ()) && (paramg.field_card_id != null) && (paramg.field_card_id.equals(this.klk.bbh())) && (paramg.knO == 3))
    {
      ab.i("MicroMsg.CardConsumedMgr", "it is card type, don't do NetSceneGetShareCardConsumedInfo! finish UI");
      bbz();
      AppMethodBeat.o(87663);
      return;
    }
    if (!this.klk.baK())
    {
      ab.i("MicroMsg.CardConsumedMgr", "it is not card type, don't update share card data!");
      bbz();
      AppMethodBeat.o(87663);
      return;
    }
    int i;
    Object localObject;
    if ((paramg.knO == 3) || ((paramg.field_card_id != null) && (paramg.field_card_id.equals(this.klk.bbh())) && (!TextUtils.isEmpty(paramg.field_consumed_box_id))))
    {
      long l1 = System.currentTimeMillis();
      ab.i("MicroMsg.CardConsumedMgr", "consumed share card msg,  update share card data!");
      if ((paramg.field_card_id == null) || (!paramg.field_card_id.equals(this.klk.bbh()))) {
        break label652;
      }
      paramg = am.bcl().HZ(this.klk.bbh());
      if ((paramg != null) && (paramg.bbe() != null))
      {
        i = this.klk.bbe().status;
        ab.d("MicroMsg.CardConsumedMgr", "onChange() current oldState %s, newStatus %s, shareCardStatus %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramg.bbe().status), Integer.valueOf(((ShareCardInfo)this.klk).field_status) });
        if (paramg.bbe().status == i) {
          break label585;
        }
        bby();
      }
      c(this.klk);
      paramg = (Boolean)this.kli.get(this.klk.bbh());
      if ((paramg != null) && (paramg.booleanValue())) {
        break label769;
      }
      paramg = (Context)this.aon.get();
      ab.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.klk.bbh());
      com.tencent.mm.plugin.card.sharecard.a.b.a(paramg, this.klk);
      this.kli.put(this.klk.bbh(), Boolean.TRUE);
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
      h.qsU.b(paramg, true);
    }
    for (;;)
    {
      bbA();
      AppMethodBeat.o(87663);
      return;
      label585:
      if (i == 1) {
        break;
      }
      ab.i("MicroMsg.CardConsumedMgr", "share card oldState status is ".concat(String.valueOf(i)));
      paramg = this.klk.bbe();
      paramg.status = 1;
      ((ShareCardInfo)this.klk).field_status = 1;
      this.klk.a(paramg);
      l.h(this.klk);
      break;
      label652:
      if (paramg.field_card_id == null) {
        break;
      }
      paramg = am.bcl().HZ(paramg.field_card_id);
      if ((paramg != null) && (paramg.bbe() != null))
      {
        ab.d("MicroMsg.CardConsumedMgr", "onChange() not current oldState %s,shareCardStatus %s", new Object[] { Integer.valueOf(paramg.bbe().status), Integer.valueOf(paramg.field_status) });
        if (paramg.bbe().status == 1) {
          break;
        }
        localObject = paramg.bbe();
        ((oj)localObject).status = 1;
        paramg.field_status = 1;
        paramg.a((oj)localObject);
        l.h(paramg);
        break;
      }
      ab.w("MicroMsg.CardConsumedMgr", "tempCard is null");
      break;
      label769:
      ab.i("MicroMsg.CardConsumedMgr", "consumed:" + paramg.booleanValue());
    }
  }
  
  public final void b(d.a parama)
  {
    AppMethodBeat.i(87657);
    if (this.kkV == null)
    {
      AppMethodBeat.o(87657);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      WeakReference localWeakReference = (WeakReference)this.kkV.get(i);
      if (localWeakReference != null)
      {
        d.a locala = (d.a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.kkV.remove(localWeakReference);
          AppMethodBeat.o(87657);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87657);
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(87658);
    this.klk = paramb;
    if ((this.kll) && (this.klk != null) && (paramb.bbh() != null) && (!paramb.bbh().equals(this.klk.bbh()))) {
      this.kll = false;
    }
    if (this.kkV == null)
    {
      AppMethodBeat.o(87658);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (d.a)((WeakReference)localObject).get();
        Boolean localBoolean = (Boolean)this.klh.get(localObject);
        if ((localObject != null) && (localBoolean != null) && (!localBoolean.booleanValue())) {
          ((d.a)localObject).d(paramb);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87658);
  }
  
  public final void bbo()
  {
    AppMethodBeat.i(87661);
    ab.i("MicroMsg.CardConsumedMgr", "onDBchange()");
    if (this.klk == null)
    {
      ab.e("MicroMsg.CardConsumedMgr", "onDBchange(), do nothing, mCardInfo == null");
      AppMethodBeat.o(87661);
      return;
    }
    Object localObject1;
    label222:
    Object localObject2;
    if (this.klk.baK())
    {
      localObject1 = am.bcl().HZ(this.klk.bbh());
      if ((localObject1 != null) && (((com.tencent.mm.plugin.card.base.b)localObject1).bbe() != null) && (this.klk != null) && (this.klk.bbe() != null))
      {
        int i = this.klk.bbe().status;
        ab.d("MicroMsg.CardConsumedMgr", "onDBchange() oldState %s, newStatus %s, isDoingConsumedInfo %s, isShareCard %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.card.base.b)localObject1).bbe().status), Boolean.valueOf(this.kll), Boolean.valueOf(this.klk.baK()) });
        if ((!this.klk.baK()) || (!(this.klk instanceof ShareCardInfo))) {
          break label555;
        }
        ab.d("MicroMsg.CardConsumedMgr", "onDBchange() shareCardState %s", new Object[] { Integer.valueOf(((ShareCardInfo)this.klk).field_status) });
        if (((com.tencent.mm.plugin.card.base.b)localObject1).bbe().status != i)
        {
          bby();
          if ((!this.klk.baK()) || (this.kll) || (((com.tencent.mm.plugin.card.base.b)localObject1).bbe().status != 1)) {
            break label607;
          }
          ab.i("MicroMsg.CardConsumedMgr", "onDBchange(), need to get the consumedinfo , don't finish UI!");
          localObject2 = (Boolean)this.kli.get(this.klk.bbh());
          if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
            break label578;
          }
          ab.i("MicroMsg.CardConsumedMgr", "consumed is null or consumed is false!");
          long l1 = System.currentTimeMillis();
          localObject2 = (Context)this.aon.get();
          ab.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.klk.bbh());
          com.tencent.mm.plugin.card.sharecard.a.b.a((Context)localObject2, this.klk);
          this.kli.put(this.klk.bbh(), Boolean.TRUE);
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
          h.qsU.b((ArrayList)localObject2, true);
          label502:
          bbA();
        }
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.CardConsumedMgr", "onDBchange(),card coupon is consumde success!");
      this.klk = ((com.tencent.mm.plugin.card.base.b)localObject1);
      c(this.klk);
      AppMethodBeat.o(87661);
      return;
      localObject1 = am.bcd().HJ(this.klk.bbh());
      break;
      label555:
      if (!this.klk.baK()) {
        break label222;
      }
      ab.e("MicroMsg.CardConsumedMgr", "onDBchange() mCardInfo is ShareCard, but not the ShareCardInfo instance!");
      break label222;
      label578:
      ab.i("MicroMsg.CardConsumedMgr", "consumed:" + ((Boolean)localObject2).booleanValue());
      break label502;
      label607:
      if ((this.klk.baK()) && (this.kll))
      {
        ab.i("MicroMsg.CardConsumedMgr", "onDBchange(), is getting the consumedinfo!");
      }
      else
      {
        ab.i("MicroMsg.CardConsumedMgr", "onDBchange(),finish CardConsumeCodeUI!");
        bbz();
      }
    }
  }
  
  public final void c(d.a parama)
  {
    AppMethodBeat.i(87660);
    if (this.klh == null) {
      this.klh = new HashMap();
    }
    this.klh.remove(parama);
    AppMethodBeat.o(87660);
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(87662);
    bby();
    AppMethodBeat.o(87662);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(87664);
    ab.i("MicroMsg.CardConsumedMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramm;
        if (!TextUtils.isEmpty(paramString.koi)) {
          HA(paramString.koi);
        }
        for (;;)
        {
          this.kll = false;
          ab.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo ok! finish UI!");
          bbz();
          AppMethodBeat.o(87664);
          return;
          ab.e("MicroMsg.CardConsumedMgr", "consumed return json is empty!");
        }
      }
    }
    else if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.d))
    {
      this.kll = false;
      ab.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo failed! finish UI!");
      bbz();
      AppMethodBeat.o(87664);
      return;
    }
    AppMethodBeat.o(87664);
  }
  
  public final void release()
  {
    AppMethodBeat.i(87655);
    com.tencent.mm.kernel.g.RK().eHt.b(910, this);
    am.bck().b(this);
    b localb = am.bcc();
    int i;
    if (localb.kkV != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < localb.kkV.size())
      {
        WeakReference localWeakReference = (WeakReference)localb.kkV.get(i);
        if (localWeakReference != null)
        {
          com.tencent.mm.plugin.card.base.d locald = (com.tencent.mm.plugin.card.base.d)localWeakReference.get();
          if ((locald != null) && (locald.equals(this))) {
            localb.kkV.remove(localWeakReference);
          }
        }
      }
      else
      {
        this.kkV.clear();
        this.klh.clear();
        this.klj.clear();
        this.kll = false;
        AppMethodBeat.o(87655);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.d
 * JD-Core Version:    0.7.0.1
 */