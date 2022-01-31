package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

public final class b
{
  public static b fRu;
  private com.tencent.mm.sdk.b.c dZR;
  public log_13835 fRt;
  private int fRv;
  private int fRw;
  private boolean hasInit;
  public Object lock;
  
  static
  {
    AppMethodBeat.i(78656);
    fRu = new b();
    AppMethodBeat.o(78656);
  }
  
  private b()
  {
    AppMethodBeat.i(78633);
    this.lock = new Object();
    this.dZR = new b.1(this);
    this.fRv = 1;
    this.fRw = 1;
    this.hasInit = false;
    a.ymk.b(this.dZR);
    AppMethodBeat.o(78633);
  }
  
  private void a(IMBehavior paramIMBehavior)
  {
    AppMethodBeat.i(78639);
    synchronized (this.lock)
    {
      if (paramIMBehavior.opType == b.a.fRz.value)
      {
        this.fRt.oplist_.add(paramIMBehavior);
        AppMethodBeat.o(78639);
        return;
      }
      Iterator localIterator = this.fRt.oplist_.iterator();
      while (localIterator.hasNext())
      {
        IMBehavior localIMBehavior = (IMBehavior)localIterator.next();
        if (localIMBehavior.opType == b.a.fRA.value)
        {
          IMBehaviorMsgOP localIMBehaviorMsgOP1 = localIMBehavior.msgOp;
          IMBehaviorMsgOP localIMBehaviorMsgOP2 = paramIMBehavior.msgOp;
          if ((localIMBehaviorMsgOP1.msgOpType == localIMBehaviorMsgOP2.msgOpType) && (localIMBehaviorMsgOP1.msgType == localIMBehaviorMsgOP2.msgType) && (localIMBehaviorMsgOP1.appMsgInnerType == localIMBehaviorMsgOP2.appMsgInnerType)) {}
          for (int i = 1; i != 0; i = 0)
          {
            paramIMBehavior = localIMBehavior.msgOp;
            paramIMBehavior.count += 1;
            AppMethodBeat.o(78639);
            return;
          }
        }
      }
      this.fRt.oplist_.add(paramIMBehavior);
      AppMethodBeat.o(78639);
      return;
    }
  }
  
  private String akt()
  {
    AppMethodBeat.i(78652);
    if (this.fRt == null)
    {
      AppMethodBeat.o(78652);
      return "";
    }
    Object localObject1 = ",";
    Object localObject4 = new LinkedList();
    for (;;)
    {
      Object localObject5;
      synchronized (this.lock)
      {
        ((LinkedList)localObject4).addAll(this.fRt.oplist_);
        Iterator localIterator = ((LinkedList)localObject4).iterator();
        int i = 1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject5 = (IMBehavior)localIterator.next();
        ??? = localObject1;
        if (i == 0) {
          ??? = (String)localObject1 + "|";
        }
        localObject1 = (String)??? + ((IMBehavior)localObject5).opType + "#";
        if (((IMBehavior)localObject5).opType == 1)
        {
          StringBuilder localStringBuilder = new StringBuilder().append((String)localObject1);
          localObject5 = ((IMBehavior)localObject5).chattingOp;
          ??? = "";
          if (((IMBehaviorChattingOP)localObject5).changeUnread != 0) {
            ??? = "" + "changeUnread=" + ((IMBehaviorChattingOP)localObject5).changeUnread;
          }
          localObject1 = ???;
          if (((IMBehaviorChattingOP)localObject5).changeTop != 0) {
            localObject1 = (String)??? + "changeTop=" + ((IMBehaviorChattingOP)localObject5).changeTop;
          }
          localObject4 = localObject1;
          if (((IMBehaviorChattingOP)localObject5).changeNotifyStatus != 0) {
            localObject4 = (String)localObject1 + "changeNotifyStatus=" + ((IMBehaviorChattingOP)localObject5).changeNotifyStatus;
          }
          ??? = localObject4;
          if (((IMBehaviorChattingOP)localObject5).changeSaveAddress != 0) {
            ??? = (String)localObject4 + "changeSaveAddress=" + ((IMBehaviorChattingOP)localObject5).changeSaveAddress;
          }
          localObject1 = ???;
          localObject4 = localStringBuilder;
          if (((IMBehaviorChattingOP)localObject5).expose != 0)
          {
            localObject1 = (String)??? + "expose=" + ((IMBehaviorChattingOP)localObject5).expose;
            localObject4 = localStringBuilder;
          }
          localObject1 = (String)localObject1;
          i = 0;
        }
      }
      localObject4 = new StringBuilder().append(str);
      localObject2 = ((IMBehavior)localObject5).msgOp;
      if (((IMBehaviorMsgOP)localObject2).msgType == 49) {
        localObject2 = String.format(Locale.US, "msgType=%d&msgOpType=%d&appMsgInnerType=%d&count=%d", new Object[] { Integer.valueOf(((IMBehaviorMsgOP)localObject2).msgType), Integer.valueOf(((IMBehaviorMsgOP)localObject2).msgOpType), Integer.valueOf(((IMBehaviorMsgOP)localObject2).appMsgInnerType), Integer.valueOf(((IMBehaviorMsgOP)localObject2).count) });
      } else {
        localObject2 = String.format(Locale.US, "msgType=%d&msgOpType=%d&count=%d", new Object[] { Integer.valueOf(((IMBehaviorMsgOP)localObject2).msgType), Integer.valueOf(((IMBehaviorMsgOP)localObject2).msgOpType), Integer.valueOf(((IMBehaviorMsgOP)localObject2).count) });
      }
    }
    Object localObject2 = (String)localObject2 + "," + this.fRt.currChatName_;
    AppMethodBeat.o(78652);
    return localObject2;
  }
  
  private void akv()
  {
    AppMethodBeat.i(78654);
    if (this.hasInit)
    {
      AppMethodBeat.o(78654);
      return;
    }
    this.hasInit = true;
    if (!g.RG())
    {
      ab.w("MicroMsg.ChattingOperationUitl", "account has not ready");
      AppMethodBeat.o(78654);
      return;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100148");
    if (localc.isValid()) {
      this.fRv = bo.getInt((String)localc.dvN().get("needUploadData"), 1);
    }
    localc = com.tencent.mm.model.c.c.abU().me("100149");
    if (localc.isValid()) {
      this.fRw = bo.getInt((String)localc.dvN().get("needUploadData"), 1);
    }
    AppMethodBeat.o(78654);
  }
  
  public final void D(bi parambi)
  {
    AppMethodBeat.i(78644);
    if (!aku())
    {
      AppMethodBeat.o(78644);
      return;
    }
    a(parambi, b.b.fRG, 0);
    AppMethodBeat.o(78644);
  }
  
  public final void E(bi parambi)
  {
    AppMethodBeat.i(78646);
    if (!aku())
    {
      AppMethodBeat.o(78646);
      return;
    }
    a(parambi, b.b.fRI, 0);
    AppMethodBeat.o(78646);
  }
  
  public final void F(bi parambi)
  {
    AppMethodBeat.i(78647);
    if (!aku())
    {
      AppMethodBeat.o(78647);
      return;
    }
    a(parambi, b.b.fRE, 0);
    AppMethodBeat.o(78647);
  }
  
  public final void G(bi parambi)
  {
    AppMethodBeat.i(78648);
    if (!aku())
    {
      AppMethodBeat.o(78648);
      return;
    }
    a(parambi, b.b.fRJ, 0);
    AppMethodBeat.o(78648);
  }
  
  public final void H(bi parambi)
  {
    AppMethodBeat.i(78650);
    if (!aku())
    {
      AppMethodBeat.o(78650);
      return;
    }
    a(parambi, b.b.fRN, 0);
    AppMethodBeat.o(78650);
  }
  
  public final void IE()
  {
    AppMethodBeat.i(78635);
    if (!aku())
    {
      AppMethodBeat.o(78635);
      return;
    }
    synchronized (this.lock)
    {
      if ((this.fRt != null) && (!this.fRt.oplist_.isEmpty()))
      {
        i = 1;
        if (i != 0)
        {
          if (this.fRw != 0)
          {
            ab.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
            h.qsU.c(13835, this.fRt);
          }
          if (this.fRv != 0)
          {
            ??? = akt();
            ab.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", new Object[] { ??? });
            h.qsU.kvStat(13748, (String)???);
          }
        }
        this.fRt = null;
        AppMethodBeat.o(78635);
        return;
      }
      int i = 0;
    }
  }
  
  public final void R(String arg1, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(78636);
    if (!aku())
    {
      AppMethodBeat.o(78636);
      return;
    }
    IMBehavior localIMBehavior = new IMBehavior();
    localIMBehavior.opType = 1;
    localIMBehavior.chattingOp = new IMBehaviorChattingOP();
    IMBehaviorChattingOP localIMBehaviorChattingOP = localIMBehavior.chattingOp;
    if (paramBoolean) {}
    for (;;)
    {
      localIMBehaviorChattingOP.changeUnread = i;
      IE();
      if (jdMethod_do(???)) {
        break;
      }
      AppMethodBeat.o(78636);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.fRt.oplist_.add(localIMBehavior);
      IE();
      AppMethodBeat.o(78636);
      return;
    }
  }
  
  public final void S(String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(78638);
    if (!aku())
    {
      AppMethodBeat.o(78638);
      return;
    }
    if (!jdMethod_do(paramString))
    {
      AppMethodBeat.o(78638);
      return;
    }
    paramString = new IMBehavior();
    paramString.opType = 1;
    paramString.chattingOp = new IMBehaviorChattingOP();
    ??? = paramString.chattingOp;
    if (paramBoolean) {}
    for (;;)
    {
      ((IMBehaviorChattingOP)???).changeSaveAddress = i;
      synchronized (this.lock)
      {
        this.fRt.oplist_.add(paramString);
        AppMethodBeat.o(78638);
        return;
        i = 2;
      }
    }
  }
  
  public final void a(bi parambi, int paramInt)
  {
    AppMethodBeat.i(78641);
    new ak(Looper.getMainLooper()).post(new b.2(this, parambi, paramInt));
    AppMethodBeat.o(78641);
  }
  
  public final void a(bi parambi, b.b paramb, int paramInt)
  {
    AppMethodBeat.i(78640);
    if ((parambi == null) || (!jdMethod_do(parambi.field_talker)))
    {
      AppMethodBeat.o(78640);
      return;
    }
    IMBehavior localIMBehavior = new IMBehavior();
    localIMBehavior.opType = 2;
    localIMBehavior.msgOp = new IMBehaviorMsgOP();
    localIMBehavior.msgOp.msgType = (parambi.getType() & 0xFFFF);
    if (parambi.bCn()) {
      localIMBehavior.msgOp.appMsgInnerType = paramInt;
    }
    localIMBehavior.msgOp.msgOpType = paramb.value;
    localIMBehavior.msgOp.count = 1;
    a(localIMBehavior);
    AppMethodBeat.o(78640);
  }
  
  public final void a(bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(78649);
    if (!aku())
    {
      AppMethodBeat.o(78649);
      return;
    }
    if (!parambi.isText())
    {
      AppMethodBeat.o(78649);
      return;
    }
    if (paramBoolean) {}
    for (b.b localb = b.b.fRK;; localb = b.b.fRL)
    {
      a(parambi, localb, 0);
      AppMethodBeat.o(78649);
      return;
    }
  }
  
  public final void a(bi parambi, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(78651);
    if (!aku())
    {
      AppMethodBeat.o(78651);
      return;
    }
    if (paramBoolean) {}
    for (b.b localb = b.b.fRO;; localb = b.b.fRP)
    {
      a(parambi, localb, paramInt);
      AppMethodBeat.o(78651);
      return;
    }
  }
  
  public final boolean aku()
  {
    AppMethodBeat.i(78653);
    akv();
    if ((this.fRv != 0) || (this.fRw != 0))
    {
      AppMethodBeat.o(78653);
      return true;
    }
    AppMethodBeat.o(78653);
    return false;
  }
  
  public final void b(bi parambi, int paramInt)
  {
    AppMethodBeat.i(78643);
    if (!aku())
    {
      AppMethodBeat.o(78643);
      return;
    }
    a(parambi, b.b.fRG, paramInt);
    AppMethodBeat.o(78643);
  }
  
  public final void c(bi parambi, int paramInt)
  {
    AppMethodBeat.i(78645);
    if (!aku())
    {
      AppMethodBeat.o(78645);
      return;
    }
    a(parambi, b.b.fRI, paramInt);
    AppMethodBeat.o(78645);
  }
  
  public final void c(boolean paramBoolean1, String arg2, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(78637);
    if (!aku())
    {
      AppMethodBeat.o(78637);
      return;
    }
    IMBehavior localIMBehavior = new IMBehavior();
    localIMBehavior.opType = 1;
    localIMBehavior.chattingOp = new IMBehaviorChattingOP();
    IMBehaviorChattingOP localIMBehaviorChattingOP = localIMBehavior.chattingOp;
    if (paramBoolean2) {}
    for (;;)
    {
      localIMBehaviorChattingOP.changeTop = i;
      if (paramBoolean1) {
        IE();
      }
      if (jdMethod_do(???)) {
        break;
      }
      AppMethodBeat.o(78637);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.fRt.oplist_.add(localIMBehavior);
      if (paramBoolean1) {
        IE();
      }
      AppMethodBeat.o(78637);
      return;
    }
  }
  
  public final boolean jdMethod_do(String paramString)
  {
    AppMethodBeat.i(78634);
    if (bo.isNullOrNil(paramString))
    {
      paramString = bo.dtY().toString();
      ab.e("MicroMsg.ChattingOperationUitl", "check error:%s", new Object[] { paramString });
      log_13913 locallog_13913 = new log_13913();
      locallog_13913.scene_ = 1;
      locallog_13913.error_ = paramString;
      h.qsU.c(13913, locallog_13913);
      AppMethodBeat.o(78634);
      return false;
    }
    if ((this.fRt != null) && (this.fRt.currChatName_ != null) && (!this.fRt.currChatName_.equals(paramString))) {
      IE();
    }
    if (this.fRt == null)
    {
      this.fRt = new log_13835();
      this.fRt.currChatName_ = paramString;
    }
    AppMethodBeat.o(78634);
    return true;
  }
  
  public final void j(bi parambi)
  {
    AppMethodBeat.i(78642);
    new ak(Looper.getMainLooper()).post(new b.3(this, parambi));
    AppMethodBeat.o(78642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelstat.b
 * JD-Core Version:    0.7.0.1
 */