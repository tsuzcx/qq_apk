package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

public final class b
{
  public static b inZ;
  private com.tencent.mm.sdk.b.c fFC;
  private boolean hasInit;
  public log_13835 inY;
  private int ioa;
  private int iob;
  public Object lock;
  
  static
  {
    AppMethodBeat.i(151006);
    inZ = new b();
    AppMethodBeat.o(151006);
  }
  
  private b()
  {
    AppMethodBeat.i(150983);
    this.lock = new Object();
    this.fFC = new com.tencent.mm.sdk.b.c() {};
    this.ioa = 1;
    this.iob = 1;
    this.hasInit = false;
    a.IbL.b(this.fFC);
    AppMethodBeat.o(150983);
  }
  
  private void a(IMBehavior paramIMBehavior)
  {
    AppMethodBeat.i(150989);
    synchronized (this.lock)
    {
      if (paramIMBehavior.opType == b.a.ioe.value)
      {
        this.inY.oplist_.add(paramIMBehavior);
        AppMethodBeat.o(150989);
        return;
      }
      Iterator localIterator = this.inY.oplist_.iterator();
      while (localIterator.hasNext())
      {
        IMBehavior localIMBehavior = (IMBehavior)localIterator.next();
        if (localIMBehavior.opType == b.a.iof.value)
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
      this.inY.oplist_.add(paramIMBehavior);
      AppMethodBeat.o(150989);
      return;
    }
  }
  
  private void aLA()
  {
    AppMethodBeat.i(151004);
    if (this.hasInit)
    {
      AppMethodBeat.o(151004);
      return;
    }
    this.hasInit = true;
    if (!com.tencent.mm.kernel.g.ajx())
    {
      ad.w("MicroMsg.ChattingOperationUitl", "account has not ready");
      AppMethodBeat.o(151004);
      return;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDs().wz("100148");
    if (localc.isValid()) {
      this.ioa = bt.getInt((String)localc.foF().get("needUploadData"), 1);
    }
    localc = com.tencent.mm.model.c.d.aDs().wz("100149");
    if (localc.isValid()) {
      this.iob = bt.getInt((String)localc.foF().get("needUploadData"), 1);
    }
    AppMethodBeat.o(151004);
  }
  
  private String aLy()
  {
    AppMethodBeat.i(151002);
    if (this.inY == null)
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
        ((LinkedList)localObject4).addAll(this.inY.oplist_);
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
    Object localObject2 = (String)localObject2 + "," + this.inY.currChatName_;
    AppMethodBeat.o(151002);
    return localObject2;
  }
  
  public final void S(bu parambu)
  {
    AppMethodBeat.i(150994);
    if (!aLz())
    {
      AppMethodBeat.o(150994);
      return;
    }
    a(parambu, b.iol, 0);
    AppMethodBeat.o(150994);
  }
  
  public final void T(bu parambu)
  {
    AppMethodBeat.i(150996);
    if (!aLz())
    {
      AppMethodBeat.o(150996);
      return;
    }
    a(parambu, b.ion, 0);
    AppMethodBeat.o(150996);
  }
  
  public final void U(bu parambu)
  {
    AppMethodBeat.i(150997);
    if (!aLz())
    {
      AppMethodBeat.o(150997);
      return;
    }
    a(parambu, b.ioj, 0);
    AppMethodBeat.o(150997);
  }
  
  public final void V(bu parambu)
  {
    AppMethodBeat.i(150998);
    if (!aLz())
    {
      AppMethodBeat.o(150998);
      return;
    }
    a(parambu, b.ioo, 0);
    AppMethodBeat.o(150998);
  }
  
  public final void V(String arg1, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(150986);
    if (!aLz())
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
      if (eW(???)) {
        break;
      }
      AppMethodBeat.o(150986);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.inY.oplist_.add(localIMBehavior);
      report();
      AppMethodBeat.o(150986);
      return;
    }
  }
  
  public final void W(bu parambu)
  {
    AppMethodBeat.i(151000);
    if (!aLz())
    {
      AppMethodBeat.o(151000);
      return;
    }
    a(parambu, b.ios, 0);
    AppMethodBeat.o(151000);
  }
  
  public final void W(String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(150988);
    if (!aLz())
    {
      AppMethodBeat.o(150988);
      return;
    }
    if (!eW(paramString))
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
        this.inY.oplist_.add(paramString);
        AppMethodBeat.o(150988);
        return;
        i = 2;
      }
    }
  }
  
  public final void a(bu parambu, b paramb, int paramInt)
  {
    AppMethodBeat.i(150990);
    if ((parambu == null) || (!eW(parambu.field_talker)))
    {
      AppMethodBeat.o(150990);
      return;
    }
    IMBehavior localIMBehavior = new IMBehavior();
    localIMBehavior.opType = 2;
    localIMBehavior.msgOp = new IMBehaviorMsgOP();
    localIMBehavior.msgOp.msgType = (parambu.getType() & 0xFFFF);
    if (parambu.cTc()) {
      localIMBehavior.msgOp.appMsgInnerType = paramInt;
    }
    localIMBehavior.msgOp.msgOpType = paramb.value;
    localIMBehavior.msgOp.count = 1;
    a(localIMBehavior);
    AppMethodBeat.o(150990);
  }
  
  public final void a(bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(150999);
    if (!aLz())
    {
      AppMethodBeat.o(150999);
      return;
    }
    if (!parambu.isText())
    {
      AppMethodBeat.o(150999);
      return;
    }
    if (paramBoolean) {}
    for (b localb = b.iop;; localb = b.ioq)
    {
      a(parambu, localb, 0);
      AppMethodBeat.o(150999);
      return;
    }
  }
  
  public final void a(bu parambu, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(151001);
    if (!aLz())
    {
      AppMethodBeat.o(151001);
      return;
    }
    if (paramBoolean) {}
    for (b localb = b.iot;; localb = b.iou)
    {
      a(parambu, localb, paramInt);
      AppMethodBeat.o(151001);
      return;
    }
  }
  
  public final boolean aLz()
  {
    AppMethodBeat.i(151003);
    aLA();
    if ((this.ioa != 0) || (this.iob != 0))
    {
      AppMethodBeat.o(151003);
      return true;
    }
    AppMethodBeat.o(151003);
    return false;
  }
  
  public final void b(final bu parambu, final int paramInt)
  {
    AppMethodBeat.i(150991);
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150975);
        b.a(b.this, parambu, paramInt);
        AppMethodBeat.o(150975);
      }
    });
    AppMethodBeat.o(150991);
  }
  
  public final void c(bu parambu, int paramInt)
  {
    AppMethodBeat.i(150993);
    if (!aLz())
    {
      AppMethodBeat.o(150993);
      return;
    }
    a(parambu, b.iol, paramInt);
    AppMethodBeat.o(150993);
  }
  
  public final void c(boolean paramBoolean1, String arg2, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(150987);
    if (!aLz())
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
      if (eW(???)) {
        break;
      }
      AppMethodBeat.o(150987);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.inY.oplist_.add(localIMBehavior);
      if (paramBoolean1) {
        report();
      }
      AppMethodBeat.o(150987);
      return;
    }
  }
  
  public final void d(bu parambu, int paramInt)
  {
    AppMethodBeat.i(150995);
    if (!aLz())
    {
      AppMethodBeat.o(150995);
      return;
    }
    a(parambu, b.ion, paramInt);
    AppMethodBeat.o(150995);
  }
  
  public final boolean eW(String paramString)
  {
    AppMethodBeat.i(150984);
    if (bt.isNullOrNil(paramString))
    {
      paramString = bt.flS().toString();
      ad.e("MicroMsg.ChattingOperationUitl", "check error:%s", new Object[] { paramString });
      log_13913 locallog_13913 = new log_13913();
      locallog_13913.scene_ = 1;
      locallog_13913.error_ = paramString;
      com.tencent.mm.plugin.report.service.g.yhR.c(13913, locallog_13913);
      AppMethodBeat.o(150984);
      return false;
    }
    if ((this.inY != null) && (this.inY.currChatName_ != null) && (!this.inY.currChatName_.equals(paramString))) {
      report();
    }
    if (this.inY == null)
    {
      this.inY = new log_13835();
      this.inY.currChatName_ = paramString;
    }
    AppMethodBeat.o(150984);
    return true;
  }
  
  public final void q(final bu parambu)
  {
    AppMethodBeat.i(150992);
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150976);
        b.a(b.this, parambu, 0);
        AppMethodBeat.o(150976);
      }
    });
    AppMethodBeat.o(150992);
  }
  
  public final void report()
  {
    AppMethodBeat.i(150985);
    if (!aLz())
    {
      AppMethodBeat.o(150985);
      return;
    }
    synchronized (this.lock)
    {
      if ((this.inY != null) && (!this.inY.oplist_.isEmpty()))
      {
        i = 1;
        if (i != 0)
        {
          if (this.iob != 0)
          {
            ad.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
            com.tencent.mm.plugin.report.service.g.yhR.c(13835, this.inY);
          }
          if (this.ioa != 0)
          {
            ??? = aLy();
            ad.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", new Object[] { ??? });
            com.tencent.mm.plugin.report.service.g.yhR.kvStat(13748, (String)???);
          }
        }
        this.inY = null;
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
      ioh = new b("UnKnownType", 0, 0);
      ioi = new b("expourse", 1, 1);
      ioj = new b("click", 2, 2);
      iok = new b("send", 3, 3);
      iol = new b("fav", 4, 4);
      iom = new b("revoke", 5, 5);
      ion = new b("delete", 6, 6);
      ioo = new b("voiceToText", 7, 7);
      iop = new b("translate", 8, 8);
      ioq = new b("translateHidden", 9, 9);
      ior = new b("doubleClickText", 10, 10);
      ios = new b("imageSaveToLocal", 11, 11);
      iot = new b("playMusic", 12, 12);
      iou = new b("stopMusic", 13, 13);
      iov = new b[] { ioh, ioi, ioj, iok, iol, iom, ion, ioo, iop, ioq, ior, ios, iot, iou };
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