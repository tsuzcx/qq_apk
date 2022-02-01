package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

public final class b
{
  public static b mcf;
  private boolean hasInit;
  private IListener iRb;
  public Object lock;
  public log_13835 mce;
  private int mcg;
  private int mch;
  
  static
  {
    AppMethodBeat.i(151006);
    mcf = new b();
    AppMethodBeat.o(151006);
  }
  
  private b()
  {
    AppMethodBeat.i(150983);
    this.lock = new Object();
    this.iRb = new b.1(this);
    this.mcg = 1;
    this.mch = 1;
    this.hasInit = false;
    EventCenter.instance.add(this.iRb);
    AppMethodBeat.o(150983);
  }
  
  private String bpo()
  {
    AppMethodBeat.i(151002);
    if (this.mce == null)
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
        ((LinkedList)localObject4).addAll(this.mce.oplist_);
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
      if (((IMBehaviorMsgOP)localObject2).msgType == 49) {
        localObject2 = String.format(Locale.US, "msgType=%d&msgOpType=%d&appMsgInnerType=%d&count=%d", new Object[] { Integer.valueOf(((IMBehaviorMsgOP)localObject2).msgType), Integer.valueOf(((IMBehaviorMsgOP)localObject2).msgOpType), Integer.valueOf(((IMBehaviorMsgOP)localObject2).appMsgInnerType), Integer.valueOf(((IMBehaviorMsgOP)localObject2).count) });
      } else {
        localObject2 = String.format(Locale.US, "msgType=%d&msgOpType=%d&count=%d", new Object[] { Integer.valueOf(((IMBehaviorMsgOP)localObject2).msgType), Integer.valueOf(((IMBehaviorMsgOP)localObject2).msgOpType), Integer.valueOf(((IMBehaviorMsgOP)localObject2).count) });
      }
    }
    Object localObject2 = (String)localObject2 + "," + this.mce.currChatName_;
    AppMethodBeat.o(151002);
    return localObject2;
  }
  
  private void bpq()
  {
    AppMethodBeat.i(151004);
    if (this.hasInit)
    {
      AppMethodBeat.o(151004);
      return;
    }
    this.hasInit = true;
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.w("MicroMsg.ChattingOperationUitl", "account has not ready");
      AppMethodBeat.o(151004);
      return;
    }
    c localc = com.tencent.mm.model.c.d.bgB().Mu("100148");
    if (localc.isValid()) {
      this.mcg = Util.getInt((String)localc.hvz().get("needUploadData"), 1);
    }
    localc = com.tencent.mm.model.c.d.bgB().Mu("100149");
    if (localc.isValid()) {
      this.mch = Util.getInt((String)localc.hvz().get("needUploadData"), 1);
    }
    AppMethodBeat.o(151004);
  }
  
  public final void X(String arg1, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(150986);
    if (!bpp())
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
      if (gz(???)) {
        break;
      }
      AppMethodBeat.o(150986);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.mce.oplist_.add(localIMBehavior);
      report();
      AppMethodBeat.o(150986);
      return;
    }
  }
  
  public final void Y(String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(150988);
    if (!bpp())
    {
      AppMethodBeat.o(150988);
      return;
    }
    if (!gz(paramString))
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
        this.mce.oplist_.add(paramString);
        AppMethodBeat.o(150988);
        return;
        i = 2;
      }
    }
  }
  
  public final void a(ca arg1, b paramb, int paramInt)
  {
    AppMethodBeat.i(150990);
    if ((??? == null) || (!gz(???.field_talker)))
    {
      AppMethodBeat.o(150990);
      return;
    }
    IMBehavior localIMBehavior1 = new IMBehavior();
    localIMBehavior1.opType = 2;
    localIMBehavior1.msgOp = new IMBehaviorMsgOP();
    localIMBehavior1.msgOp.msgType = (???.getType() & 0xFFFF);
    if (???.erk()) {
      localIMBehavior1.msgOp.appMsgInnerType = paramInt;
    }
    localIMBehavior1.msgOp.msgOpType = paramb.value;
    localIMBehavior1.msgOp.count = 1;
    synchronized (this.lock)
    {
      if (localIMBehavior1.opType == b.a.mck.value)
      {
        this.mce.oplist_.add(localIMBehavior1);
        AppMethodBeat.o(150990);
        return;
      }
      paramb = this.mce.oplist_.iterator();
      while (paramb.hasNext())
      {
        IMBehavior localIMBehavior2 = (IMBehavior)paramb.next();
        if (localIMBehavior2.opType == b.a.mcl.value)
        {
          IMBehaviorMsgOP localIMBehaviorMsgOP1 = localIMBehavior2.msgOp;
          IMBehaviorMsgOP localIMBehaviorMsgOP2 = localIMBehavior1.msgOp;
          if ((localIMBehaviorMsgOP1.msgOpType == localIMBehaviorMsgOP2.msgOpType) && (localIMBehaviorMsgOP1.msgType == localIMBehaviorMsgOP2.msgType) && (localIMBehaviorMsgOP1.appMsgInnerType == localIMBehaviorMsgOP2.appMsgInnerType)) {}
          for (paramInt = 1; paramInt != 0; paramInt = 0)
          {
            paramb = localIMBehavior2.msgOp;
            paramb.count += 1;
            AppMethodBeat.o(150990);
            return;
          }
        }
      }
      this.mce.oplist_.add(localIMBehavior1);
      AppMethodBeat.o(150990);
      return;
    }
  }
  
  public final void a(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(150999);
    if (!bpp())
    {
      AppMethodBeat.o(150999);
      return;
    }
    if (!paramca.hwH())
    {
      AppMethodBeat.o(150999);
      return;
    }
    if (paramBoolean) {}
    for (b localb = b.mcv;; localb = b.mcw)
    {
      a(paramca, localb, 0);
      AppMethodBeat.o(150999);
      return;
    }
  }
  
  public final void a(ca paramca, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(151001);
    if (!bpp())
    {
      AppMethodBeat.o(151001);
      return;
    }
    if (paramBoolean) {}
    for (b localb = b.mcz;; localb = b.mcA)
    {
      a(paramca, localb, paramInt);
      AppMethodBeat.o(151001);
      return;
    }
  }
  
  public final void aj(ca paramca)
  {
    AppMethodBeat.i(150994);
    if (!bpp())
    {
      AppMethodBeat.o(150994);
      return;
    }
    a(paramca, b.mcr, 0);
    AppMethodBeat.o(150994);
  }
  
  public final void ak(ca paramca)
  {
    AppMethodBeat.i(225131);
    if (!bpp())
    {
      AppMethodBeat.o(225131);
      return;
    }
    a(paramca, b.mcs, 0);
    AppMethodBeat.o(225131);
  }
  
  public final void al(ca paramca)
  {
    AppMethodBeat.i(150996);
    if (!bpp())
    {
      AppMethodBeat.o(150996);
      return;
    }
    a(paramca, b.mct, 0);
    AppMethodBeat.o(150996);
  }
  
  public final void am(ca paramca)
  {
    AppMethodBeat.i(150997);
    if (!bpp())
    {
      AppMethodBeat.o(150997);
      return;
    }
    a(paramca, b.mcp, 0);
    AppMethodBeat.o(150997);
  }
  
  public final void an(ca paramca)
  {
    AppMethodBeat.i(151000);
    if (!bpp())
    {
      AppMethodBeat.o(151000);
      return;
    }
    a(paramca, b.mcy, 0);
    AppMethodBeat.o(151000);
  }
  
  public final boolean bpp()
  {
    AppMethodBeat.i(151003);
    bpq();
    if ((this.mcg != 0) || (this.mch != 0))
    {
      AppMethodBeat.o(151003);
      return true;
    }
    AppMethodBeat.o(151003);
    return false;
  }
  
  public final void c(boolean paramBoolean1, String arg2, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(150987);
    if (!bpp())
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
      if (gz(???)) {
        break;
      }
      AppMethodBeat.o(150987);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.mce.oplist_.add(localIMBehavior);
      if (paramBoolean1) {
        report();
      }
      AppMethodBeat.o(150987);
      return;
    }
  }
  
  public final void d(final ca paramca, final int paramInt)
  {
    AppMethodBeat.i(150991);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150976);
        b.a(b.this, paramca, paramInt);
        AppMethodBeat.o(150976);
      }
    });
    AppMethodBeat.o(150991);
  }
  
  public final void e(ca paramca, int paramInt)
  {
    AppMethodBeat.i(150993);
    if (!bpp())
    {
      AppMethodBeat.o(150993);
      return;
    }
    a(paramca, b.mcr, paramInt);
    AppMethodBeat.o(150993);
  }
  
  public final void f(ca paramca, int paramInt)
  {
    AppMethodBeat.i(225128);
    if (!bpp())
    {
      AppMethodBeat.o(225128);
      return;
    }
    a(paramca, b.mcs, paramInt);
    AppMethodBeat.o(225128);
  }
  
  public final void g(ca paramca, int paramInt)
  {
    AppMethodBeat.i(150995);
    if (!bpp())
    {
      AppMethodBeat.o(150995);
      return;
    }
    a(paramca, b.mct, paramInt);
    AppMethodBeat.o(150995);
  }
  
  public final boolean gz(final String paramString)
  {
    AppMethodBeat.i(150984);
    if (Util.isNullOrNil(paramString))
    {
      paramString = Util.getStack().toString();
      com.tencent.e.h.ZvG.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150975);
          Log.e("MicroMsg.ChattingOperationUitl", "check error:%s", new Object[] { paramString });
          log_13913 locallog_13913 = new log_13913();
          locallog_13913.scene_ = 1;
          locallog_13913.error_ = paramString;
          com.tencent.mm.plugin.report.service.h.IzE.c(13913, locallog_13913);
          AppMethodBeat.o(150975);
        }
      }, "ChattingOperationUtil.check");
      AppMethodBeat.o(150984);
      return false;
    }
    if ((this.mce != null) && (this.mce.currChatName_ != null) && (!this.mce.currChatName_.equals(paramString))) {
      report();
    }
    if (this.mce == null)
    {
      this.mce = new log_13835();
      this.mce.currChatName_ = paramString;
    }
    AppMethodBeat.o(150984);
    return true;
  }
  
  public final void report()
  {
    AppMethodBeat.i(150985);
    if (!bpp())
    {
      AppMethodBeat.o(150985);
      return;
    }
    synchronized (this.lock)
    {
      if ((this.mce != null) && (!this.mce.oplist_.isEmpty()))
      {
        i = 1;
        if (i != 0)
        {
          if (this.mch != 0)
          {
            Log.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
            com.tencent.mm.plugin.report.service.h.IzE.c(13835, this.mce);
          }
          if (this.mcg != 0)
          {
            ??? = bpo();
            Log.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", new Object[] { ??? });
            com.tencent.mm.plugin.report.service.h.IzE.kvStat(13748, (String)???);
          }
        }
        this.mce = null;
        AppMethodBeat.o(150985);
        return;
      }
      int i = 0;
    }
  }
  
  public final void u(ca paramca)
  {
    AppMethodBeat.i(150992);
    new MMHandler(Looper.getMainLooper()).post(new b.4(this, paramca));
    AppMethodBeat.o(150992);
  }
  
  public static enum b
  {
    public int value = 0;
    
    static
    {
      AppMethodBeat.i(150982);
      mcn = new b("UnKnownType", 0, 0);
      mco = new b("expourse", 1, 1);
      mcp = new b("click", 2, 2);
      mcq = new b("send", 3, 3);
      mcr = new b("fav", 4, 4);
      mcs = new b("revoke", 5, 5);
      mct = new b("delete", 6, 6);
      mcu = new b("voiceToText", 7, 7);
      mcv = new b("translate", 8, 8);
      mcw = new b("translateHidden", 9, 9);
      mcx = new b("doubleClickText", 10, 10);
      mcy = new b("imageSaveToLocal", 11, 11);
      mcz = new b("playMusic", 12, 12);
      mcA = new b("stopMusic", 13, 13);
      mcB = new b[] { mcn, mco, mcp, mcq, mcr, mcs, mct, mcu, mcv, mcw, mcx, mcy, mcz, mcA };
      AppMethodBeat.o(150982);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.b
 * JD-Core Version:    0.7.0.1
 */