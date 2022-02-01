package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

public final class b
{
  public static b iqT;
  private com.tencent.mm.sdk.b.c fHG;
  private boolean hasInit;
  public log_13835 iqS;
  private int iqU;
  private int iqV;
  public Object lock;
  
  static
  {
    AppMethodBeat.i(151006);
    iqT = new b();
    AppMethodBeat.o(151006);
  }
  
  private b()
  {
    AppMethodBeat.i(150983);
    this.lock = new Object();
    this.fHG = new com.tencent.mm.sdk.b.c() {};
    this.iqU = 1;
    this.iqV = 1;
    this.hasInit = false;
    a.IvT.b(this.fHG);
    AppMethodBeat.o(150983);
  }
  
  private void a(IMBehavior paramIMBehavior)
  {
    AppMethodBeat.i(150989);
    synchronized (this.lock)
    {
      if (paramIMBehavior.opType == b.a.iqY.value)
      {
        this.iqS.oplist_.add(paramIMBehavior);
        AppMethodBeat.o(150989);
        return;
      }
      Iterator localIterator = this.iqS.oplist_.iterator();
      while (localIterator.hasNext())
      {
        IMBehavior localIMBehavior = (IMBehavior)localIterator.next();
        if (localIMBehavior.opType == b.a.iqZ.value)
        {
          IMBehaviorMsgOP localIMBehaviorMsgOP1 = localIMBehavior.msgOp;
          IMBehaviorMsgOP localIMBehaviorMsgOP2 = paramIMBehavior.msgOp;
          if ((localIMBehaviorMsgOP1.msgOpType == localIMBehaviorMsgOP2.msgOpType) && (localIMBehaviorMsgOP1.msgType == localIMBehaviorMsgOP2.msgType) && (localIMBehaviorMsgOP1.appMsgInnerType == localIMBehaviorMsgOP2.appMsgInnerType)) {}
          for (int i = 1; i != 0; i = 0)
          {
            paramIMBehavior = localIMBehavior.msgOp;
            paramIMBehavior.count += 1;
            AppMethodBeat.o(150989);
            return;
          }
        }
      }
      this.iqS.oplist_.add(paramIMBehavior);
      AppMethodBeat.o(150989);
      return;
    }
  }
  
  private String aLV()
  {
    AppMethodBeat.i(151002);
    if (this.iqS == null)
    {
      AppMethodBeat.o(151002);
      return "";
    }
    Object localObject1 = ",";
    Object localObject4 = new LinkedList();
    for (;;)
    {
      Object localObject5;
      synchronized (this.lock)
      {
        ((LinkedList)localObject4).addAll(this.iqS.oplist_);
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
    Object localObject2 = (String)localObject2 + "," + this.iqS.currChatName_;
    AppMethodBeat.o(151002);
    return localObject2;
  }
  
  private void aLX()
  {
    AppMethodBeat.i(151004);
    if (this.hasInit)
    {
      AppMethodBeat.o(151004);
      return;
    }
    this.hasInit = true;
    if (!com.tencent.mm.kernel.g.ajM())
    {
      ae.w("MicroMsg.ChattingOperationUitl", "account has not ready");
      AppMethodBeat.o(151004);
      return;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDI().xi("100148");
    if (localc.isValid()) {
      this.iqU = bu.getInt((String)localc.fsy().get("needUploadData"), 1);
    }
    localc = com.tencent.mm.model.c.d.aDI().xi("100149");
    if (localc.isValid()) {
      this.iqV = bu.getInt((String)localc.fsy().get("needUploadData"), 1);
    }
    AppMethodBeat.o(151004);
  }
  
  public final void S(bv parambv)
  {
    AppMethodBeat.i(150994);
    if (!aLW())
    {
      AppMethodBeat.o(150994);
      return;
    }
    a(parambv, b.irf, 0);
    AppMethodBeat.o(150994);
  }
  
  public final void T(bv parambv)
  {
    AppMethodBeat.i(150996);
    if (!aLW())
    {
      AppMethodBeat.o(150996);
      return;
    }
    a(parambv, b.irh, 0);
    AppMethodBeat.o(150996);
  }
  
  public final void U(bv parambv)
  {
    AppMethodBeat.i(150997);
    if (!aLW())
    {
      AppMethodBeat.o(150997);
      return;
    }
    a(parambv, b.ird, 0);
    AppMethodBeat.o(150997);
  }
  
  public final void V(bv parambv)
  {
    AppMethodBeat.i(151000);
    if (!aLW())
    {
      AppMethodBeat.o(151000);
      return;
    }
    a(parambv, b.irm, 0);
    AppMethodBeat.o(151000);
  }
  
  public final void V(String arg1, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(150986);
    if (!aLW())
    {
      AppMethodBeat.o(150986);
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
      report();
      if (fb(???)) {
        break;
      }
      AppMethodBeat.o(150986);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.iqS.oplist_.add(localIMBehavior);
      report();
      AppMethodBeat.o(150986);
      return;
    }
  }
  
  public final void W(String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(150988);
    if (!aLW())
    {
      AppMethodBeat.o(150988);
      return;
    }
    if (!fb(paramString))
    {
      AppMethodBeat.o(150988);
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
        this.iqS.oplist_.add(paramString);
        AppMethodBeat.o(150988);
        return;
        i = 2;
      }
    }
  }
  
  public final void a(bv parambv, b paramb, int paramInt)
  {
    AppMethodBeat.i(150990);
    if ((parambv == null) || (!fb(parambv.field_talker)))
    {
      AppMethodBeat.o(150990);
      return;
    }
    IMBehavior localIMBehavior = new IMBehavior();
    localIMBehavior.opType = 2;
    localIMBehavior.msgOp = new IMBehaviorMsgOP();
    localIMBehavior.msgOp.msgType = (parambv.getType() & 0xFFFF);
    if (parambv.cVH()) {
      localIMBehavior.msgOp.appMsgInnerType = paramInt;
    }
    localIMBehavior.msgOp.msgOpType = paramb.value;
    localIMBehavior.msgOp.count = 1;
    a(localIMBehavior);
    AppMethodBeat.o(150990);
  }
  
  public final void a(bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(150999);
    if (!aLW())
    {
      AppMethodBeat.o(150999);
      return;
    }
    if (!parambv.isText())
    {
      AppMethodBeat.o(150999);
      return;
    }
    if (paramBoolean) {}
    for (b localb = b.irj;; localb = b.irk)
    {
      a(parambv, localb, 0);
      AppMethodBeat.o(150999);
      return;
    }
  }
  
  public final void a(bv parambv, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(151001);
    if (!aLW())
    {
      AppMethodBeat.o(151001);
      return;
    }
    if (paramBoolean) {}
    for (b localb = b.irn;; localb = b.iro)
    {
      a(parambv, localb, paramInt);
      AppMethodBeat.o(151001);
      return;
    }
  }
  
  public final boolean aLW()
  {
    AppMethodBeat.i(151003);
    aLX();
    if ((this.iqU != 0) || (this.iqV != 0))
    {
      AppMethodBeat.o(151003);
      return true;
    }
    AppMethodBeat.o(151003);
    return false;
  }
  
  public final void b(final bv parambv, final int paramInt)
  {
    AppMethodBeat.i(150991);
    new aq(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150975);
        b.a(b.this, parambv, paramInt);
        AppMethodBeat.o(150975);
      }
    });
    AppMethodBeat.o(150991);
  }
  
  public final void c(bv parambv, int paramInt)
  {
    AppMethodBeat.i(150993);
    if (!aLW())
    {
      AppMethodBeat.o(150993);
      return;
    }
    a(parambv, b.irf, paramInt);
    AppMethodBeat.o(150993);
  }
  
  public final void c(boolean paramBoolean1, String arg2, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(150987);
    if (!aLW())
    {
      AppMethodBeat.o(150987);
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
        report();
      }
      if (fb(???)) {
        break;
      }
      AppMethodBeat.o(150987);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.iqS.oplist_.add(localIMBehavior);
      if (paramBoolean1) {
        report();
      }
      AppMethodBeat.o(150987);
      return;
    }
  }
  
  public final void d(bv parambv, int paramInt)
  {
    AppMethodBeat.i(150995);
    if (!aLW())
    {
      AppMethodBeat.o(150995);
      return;
    }
    a(parambv, b.irh, paramInt);
    AppMethodBeat.o(150995);
  }
  
  public final boolean fb(String paramString)
  {
    AppMethodBeat.i(150984);
    if (bu.isNullOrNil(paramString))
    {
      paramString = bu.fpN().toString();
      ae.e("MicroMsg.ChattingOperationUitl", "check error:%s", new Object[] { paramString });
      log_13913 locallog_13913 = new log_13913();
      locallog_13913.scene_ = 1;
      locallog_13913.error_ = paramString;
      com.tencent.mm.plugin.report.service.g.yxI.c(13913, locallog_13913);
      AppMethodBeat.o(150984);
      return false;
    }
    if ((this.iqS != null) && (this.iqS.currChatName_ != null) && (!this.iqS.currChatName_.equals(paramString))) {
      report();
    }
    if (this.iqS == null)
    {
      this.iqS = new log_13835();
      this.iqS.currChatName_ = paramString;
    }
    AppMethodBeat.o(150984);
    return true;
  }
  
  public final void q(final bv parambv)
  {
    AppMethodBeat.i(150992);
    new aq(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150976);
        b.a(b.this, parambv, 0);
        AppMethodBeat.o(150976);
      }
    });
    AppMethodBeat.o(150992);
  }
  
  public final void report()
  {
    AppMethodBeat.i(150985);
    if (!aLW())
    {
      AppMethodBeat.o(150985);
      return;
    }
    synchronized (this.lock)
    {
      if ((this.iqS != null) && (!this.iqS.oplist_.isEmpty()))
      {
        i = 1;
        if (i != 0)
        {
          if (this.iqV != 0)
          {
            ae.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
            com.tencent.mm.plugin.report.service.g.yxI.c(13835, this.iqS);
          }
          if (this.iqU != 0)
          {
            ??? = aLV();
            ae.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", new Object[] { ??? });
            com.tencent.mm.plugin.report.service.g.yxI.kvStat(13748, (String)???);
          }
        }
        this.iqS = null;
        AppMethodBeat.o(150985);
        return;
      }
      int i = 0;
    }
  }
  
  public static enum b
  {
    public int value = 0;
    
    static
    {
      AppMethodBeat.i(150982);
      irb = new b("UnKnownType", 0, 0);
      irc = new b("expourse", 1, 1);
      ird = new b("click", 2, 2);
      ire = new b("send", 3, 3);
      irf = new b("fav", 4, 4);
      irg = new b("revoke", 5, 5);
      irh = new b("delete", 6, 6);
      iri = new b("voiceToText", 7, 7);
      irj = new b("translate", 8, 8);
      irk = new b("translateHidden", 9, 9);
      irl = new b("doubleClickText", 10, 10);
      irm = new b("imageSaveToLocal", 11, 11);
      irn = new b("playMusic", 12, 12);
      iro = new b("stopMusic", 13, 13);
      irp = new b[] { irb, irc, ird, ire, irf, irg, irh, iri, irj, irk, irl, irm, irn, iro };
      AppMethodBeat.o(150982);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.b
 * JD-Core Version:    0.7.0.1
 */