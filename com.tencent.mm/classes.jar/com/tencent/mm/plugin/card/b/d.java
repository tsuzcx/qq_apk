package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d
  implements i, k.a, com.tencent.mm.plugin.card.base.d
{
  public WeakReference<Context> mContextRef;
  public List<WeakReference<a>> pQG;
  public HashMap<a, Boolean> pQS;
  public HashMap<String, Boolean> pQT;
  public HashMap<String, Boolean> pQU;
  public com.tencent.mm.plugin.card.base.b pQV;
  public boolean pQW;
  public String pQX;
  
  public d()
  {
    AppMethodBeat.i(112598);
    this.pQG = new ArrayList();
    this.pQS = new HashMap();
    this.pQT = new HashMap();
    this.pQU = new HashMap();
    this.pQV = null;
    this.pQW = false;
    AppMethodBeat.o(112598);
  }
  
  private void ajb(String paramString)
  {
    AppMethodBeat.i(112609);
    Log.i("MicroMsg.CardConsumedMgr", "startConsumedSuccUI()");
    if (this.pQG == null)
    {
      AppMethodBeat.o(112609);
      return;
    }
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < this.pQG.size())
    {
      localObject = (WeakReference)this.pQG.get(j);
      if (localObject == null) {
        break label216;
      }
      localObject = (a)((WeakReference)localObject).get();
      Boolean localBoolean = (Boolean)this.pQS.get(localObject);
      if ((localObject == null) || (localBoolean == null) || (!localBoolean.booleanValue())) {
        break label216;
      }
      ((a)localObject).ajc(paramString);
      i = 1;
    }
    label216:
    for (;;)
    {
      j += 1;
      break;
      localObject = (Boolean)this.pQT.get(this.pQV.csU());
      if (i != 0)
      {
        Log.i("MicroMsg.CardConsumedMgr", "onStartConsumedSuccUI is handled!");
        this.pQX = "";
        AppMethodBeat.o(112609);
        return;
      }
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        Log.i("MicroMsg.CardConsumedMgr", "add to launch pending list!");
        this.pQX = paramString;
        this.pQU.put(this.pQV.csU(), Boolean.TRUE);
      }
      AppMethodBeat.o(112609);
      return;
    }
  }
  
  private void c(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(112610);
    Log.i("MicroMsg.CardConsumedMgr", "doUpdateCardInfo()");
    if (this.pQG == null)
    {
      AppMethodBeat.o(112610);
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
          ((a)localObject).d(paramb);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112610);
  }
  
  private void ctl()
  {
    AppMethodBeat.i(112611);
    Log.i("MicroMsg.CardConsumedMgr", "doVibrate()");
    if (this.pQG == null)
    {
      AppMethodBeat.o(112611);
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
          ((a)localObject).ctp();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112611);
  }
  
  private void ctm()
  {
    AppMethodBeat.i(112612);
    Log.i("MicroMsg.CardConsumedMgr", "doFinishUI()");
    if (this.pQG == null)
    {
      AppMethodBeat.o(112612);
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
          ((a)localObject).ctq();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112612);
  }
  
  private void ctn()
  {
    AppMethodBeat.i(112613);
    Log.i("MicroMsg.CardConsumedMgr", "needDoConsumedInfo(), need to do NetSceneGetShareCardConsumedInfo. ");
    cto();
    AppMethodBeat.o(112613);
  }
  
  /* Error */
  private void cto()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 155
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 60	com/tencent/mm/plugin/card/b/d:pQW	Z
    //   11: ifeq +18 -> 29
    //   14: ldc 69
    //   16: ldc 157
    //   18: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 155
    //   23: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: ldc 69
    //   31: ldc 159
    //   33: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 60	com/tencent/mm/plugin/card/b/d:pQW	Z
    //   41: new 161	com/tencent/mm/plugin/card/sharecard/model/d
    //   44: dup
    //   45: aload_0
    //   46: getfield 58	com/tencent/mm/plugin/card/b/d:pQV	Lcom/tencent/mm/plugin/card/base/b;
    //   49: invokeinterface 109 1 0
    //   54: ldc 113
    //   56: ldc 113
    //   58: invokespecial 164	com/tencent/mm/plugin/card/sharecard/model/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   61: astore_1
    //   62: invokestatic 170	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   65: getfield 176	com/tencent/mm/kernel/b:hqi	Lcom/tencent/mm/ak/t;
    //   68: aload_1
    //   69: iconst_0
    //   70: invokevirtual 181	com/tencent/mm/ak/t:a	(Lcom/tencent/mm/ak/q;I)Z
    //   73: pop
    //   74: ldc 155
    //   76: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112600);
    if (this.pQG == null) {
      this.pQG = new ArrayList();
    }
    this.pQG.add(new WeakReference(parama));
    AppMethodBeat.o(112600);
  }
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112603);
    if (this.pQS == null) {
      this.pQS = new HashMap();
    }
    this.pQS.put(parama, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(112603);
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(112607);
    Log.i("MicroMsg.CardConsumedMgr", "onChange()");
    Log.i("MicroMsg.CardConsumedMgr", "card msg card id is " + paramg.field_card_id);
    if (this.pQV == null)
    {
      Log.e("MicroMsg.CardConsumedMgr", "onChange(), do nothing, mCardInfo == null");
      ctm();
      AppMethodBeat.o(112607);
      return;
    }
    Log.i("MicroMsg.CardConsumedMgr", "card msg card id is " + paramg.field_card_id);
    if ((this.pQV.csv()) && (paramg.field_card_id != null) && (paramg.field_card_id.equals(this.pQV.csU())) && (paramg.pTF == 3))
    {
      Log.i("MicroMsg.CardConsumedMgr", "it is card type, don't do NetSceneGetShareCardConsumedInfo! finish UI");
      ctm();
      AppMethodBeat.o(112607);
      return;
    }
    if (!this.pQV.csw())
    {
      Log.i("MicroMsg.CardConsumedMgr", "it is not card type, don't update share card data!");
      ctm();
      AppMethodBeat.o(112607);
      return;
    }
    int i;
    Object localObject;
    if ((paramg.pTF == 3) || ((paramg.field_card_id != null) && (paramg.field_card_id.equals(this.pQV.csU())) && (!TextUtils.isEmpty(paramg.field_consumed_box_id))))
    {
      long l1 = System.currentTimeMillis();
      Log.i("MicroMsg.CardConsumedMgr", "consumed share card msg,  update share card data!");
      if ((paramg.field_card_id == null) || (!paramg.field_card_id.equals(this.pQV.csU()))) {
        break label652;
      }
      paramg = am.ctY().ajA(this.pQV.csU());
      if ((paramg != null) && (paramg.csR() != null))
      {
        i = this.pQV.csR().status;
        Log.d("MicroMsg.CardConsumedMgr", "onChange() current oldState %s, newStatus %s, shareCardStatus %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramg.csR().status), Integer.valueOf(((ShareCardInfo)this.pQV).field_status) });
        if (paramg.csR().status == i) {
          break label585;
        }
        ctl();
      }
      c(this.pQV);
      paramg = (Boolean)this.pQT.get(this.pQV.csU());
      if ((paramg != null) && (paramg.booleanValue())) {
        break label769;
      }
      paramg = (Context)this.mContextRef.get();
      Log.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.pQV.csU());
      com.tencent.mm.plugin.card.sharecard.a.b.a(paramg, this.pQV);
      this.pQT.put(this.pQV.csU(), Boolean.TRUE);
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
      h.CyF.b(paramg, true);
    }
    for (;;)
    {
      ctn();
      AppMethodBeat.o(112607);
      return;
      label585:
      if (i == 1) {
        break;
      }
      Log.i("MicroMsg.CardConsumedMgr", "share card oldState status is ".concat(String.valueOf(i)));
      paramg = this.pQV.csR();
      paramg.status = 1;
      ((ShareCardInfo)this.pQV).field_status = 1;
      this.pQV.a(paramg);
      l.h(this.pQV);
      break;
      label652:
      if (paramg.field_card_id == null) {
        break;
      }
      paramg = am.ctY().ajA(paramg.field_card_id);
      if ((paramg != null) && (paramg.csR() != null))
      {
        Log.d("MicroMsg.CardConsumedMgr", "onChange() not current oldState %s,shareCardStatus %s", new Object[] { Integer.valueOf(paramg.csR().status), Integer.valueOf(paramg.field_status) });
        if (paramg.csR().status == 1) {
          break;
        }
        localObject = paramg.csR();
        ((ty)localObject).status = 1;
        paramg.field_status = 1;
        paramg.a((ty)localObject);
        l.h(paramg);
        break;
      }
      Log.w("MicroMsg.CardConsumedMgr", "tempCard is null");
      break;
      label769:
      Log.i("MicroMsg.CardConsumedMgr", "consumed:" + paramg.booleanValue());
    }
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112601);
    if (this.pQG == null)
    {
      AppMethodBeat.o(112601);
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
          AppMethodBeat.o(112601);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112601);
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(112602);
    this.pQV = paramb;
    if ((this.pQW) && (this.pQV != null) && (paramb.csU() != null) && (!paramb.csU().equals(this.pQV.csU()))) {
      this.pQW = false;
    }
    if (this.pQG == null)
    {
      AppMethodBeat.o(112602);
      return;
    }
    int i = 0;
    while (i < this.pQG.size())
    {
      Object localObject = (WeakReference)this.pQG.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        Boolean localBoolean = (Boolean)this.pQS.get(localObject);
        if ((localObject != null) && (localBoolean != null) && (!localBoolean.booleanValue())) {
          ((a)localObject).d(paramb);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112602);
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(112604);
    if (this.pQS == null) {
      this.pQS = new HashMap();
    }
    this.pQS.remove(parama);
    AppMethodBeat.o(112604);
  }
  
  public final void ctb()
  {
    AppMethodBeat.i(112605);
    Log.i("MicroMsg.CardConsumedMgr", "onDBchange()");
    if (this.pQV == null)
    {
      Log.e("MicroMsg.CardConsumedMgr", "onDBchange(), do nothing, mCardInfo == null");
      AppMethodBeat.o(112605);
      return;
    }
    Object localObject1;
    label222:
    Object localObject2;
    if (this.pQV.csw())
    {
      localObject1 = am.ctY().ajA(this.pQV.csU());
      if ((localObject1 != null) && (((com.tencent.mm.plugin.card.base.b)localObject1).csR() != null) && (this.pQV != null) && (this.pQV.csR() != null))
      {
        int i = this.pQV.csR().status;
        Log.d("MicroMsg.CardConsumedMgr", "onDBchange() oldState %s, newStatus %s, isDoingConsumedInfo %s, isShareCard %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.card.base.b)localObject1).csR().status), Boolean.valueOf(this.pQW), Boolean.valueOf(this.pQV.csw()) });
        if ((!this.pQV.csw()) || (!(this.pQV instanceof ShareCardInfo))) {
          break label555;
        }
        Log.d("MicroMsg.CardConsumedMgr", "onDBchange() shareCardState %s", new Object[] { Integer.valueOf(((ShareCardInfo)this.pQV).field_status) });
        if (((com.tencent.mm.plugin.card.base.b)localObject1).csR().status != i)
        {
          ctl();
          if ((!this.pQV.csw()) || (this.pQW) || (((com.tencent.mm.plugin.card.base.b)localObject1).csR().status != 1)) {
            break label607;
          }
          Log.i("MicroMsg.CardConsumedMgr", "onDBchange(), need to get the consumedinfo , don't finish UI!");
          localObject2 = (Boolean)this.pQT.get(this.pQV.csU());
          if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
            break label578;
          }
          Log.i("MicroMsg.CardConsumedMgr", "consumed is null or consumed is false!");
          long l1 = System.currentTimeMillis();
          localObject2 = (Context)this.mContextRef.get();
          Log.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.pQV.csU());
          com.tencent.mm.plugin.card.sharecard.a.b.a((Context)localObject2, this.pQV);
          this.pQT.put(this.pQV.csU(), Boolean.TRUE);
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
          h.CyF.b((ArrayList)localObject2, true);
          label502:
          ctn();
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.CardConsumedMgr", "onDBchange(),card coupon is consumde success!");
      this.pQV = ((com.tencent.mm.plugin.card.base.b)localObject1);
      c(this.pQV);
      AppMethodBeat.o(112605);
      return;
      localObject1 = am.ctQ().ajk(this.pQV.csU());
      break;
      label555:
      if (!this.pQV.csw()) {
        break label222;
      }
      Log.e("MicroMsg.CardConsumedMgr", "onDBchange() mCardInfo is ShareCard, but not the ShareCardInfo instance!");
      break label222;
      label578:
      Log.i("MicroMsg.CardConsumedMgr", "consumed:" + ((Boolean)localObject2).booleanValue());
      break label502;
      label607:
      if ((this.pQV.csw()) && (this.pQW))
      {
        Log.i("MicroMsg.CardConsumedMgr", "onDBchange(), is getting the consumedinfo!");
      }
      else
      {
        Log.i("MicroMsg.CardConsumedMgr", "onDBchange(),finish CardConsumeCodeUI!");
        ctm();
      }
    }
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(112606);
    ctl();
    AppMethodBeat.o(112606);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(112608);
    Log.i("MicroMsg.CardConsumedMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramq;
        if (!TextUtils.isEmpty(paramString.pTY)) {
          ajb(paramString.pTY);
        }
        for (;;)
        {
          this.pQW = false;
          Log.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo ok! finish UI!");
          ctm();
          AppMethodBeat.o(112608);
          return;
          Log.e("MicroMsg.CardConsumedMgr", "consumed return json is empty!");
        }
      }
    }
    else if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.d))
    {
      this.pQW = false;
      Log.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo failed! finish UI!");
      ctm();
      AppMethodBeat.o(112608);
      return;
    }
    AppMethodBeat.o(112608);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112599);
    com.tencent.mm.kernel.g.aAg().hqi.b(910, this);
    am.ctX().b(this);
    b localb = am.ctP();
    int i;
    if (localb.pQG != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < localb.pQG.size())
      {
        WeakReference localWeakReference = (WeakReference)localb.pQG.get(i);
        if (localWeakReference != null)
        {
          com.tencent.mm.plugin.card.base.d locald = (com.tencent.mm.plugin.card.base.d)localWeakReference.get();
          if ((locald != null) && (locald.equals(this))) {
            localb.pQG.remove(localWeakReference);
          }
        }
      }
      else
      {
        this.pQG.clear();
        this.pQS.clear();
        this.pQU.clear();
        this.pQW = false;
        AppMethodBeat.o(112599);
        return;
      }
      i += 1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void ajc(String paramString);
    
    public abstract void ctp();
    
    public abstract void ctq();
    
    public abstract void d(com.tencent.mm.plugin.card.base.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.d
 * JD-Core Version:    0.7.0.1
 */