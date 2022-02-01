package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.cc;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

public final class b
{
  public static b oUZ;
  private boolean hasInit;
  public Object lock;
  private IListener lsX;
  public log_13835 oUY;
  private int oVa;
  private int oVb;
  
  static
  {
    AppMethodBeat.i(151006);
    oUZ = new b();
    AppMethodBeat.o(151006);
  }
  
  private b()
  {
    AppMethodBeat.i(150983);
    this.lock = new Object();
    this.lsX = new ChattingOperationUitl.1(this, f.hfK);
    this.oVa = 1;
    this.oVb = 1;
    this.hasInit = false;
    this.lsX.alive();
    AppMethodBeat.o(150983);
  }
  
  private String bMV()
  {
    AppMethodBeat.i(151002);
    if (this.oUY == null)
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
        ((LinkedList)localObject4).addAll(this.oUY.oplist_);
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
    Object localObject2 = (String)localObject2 + "," + this.oUY.currChatName_;
    AppMethodBeat.o(151002);
    return localObject2;
  }
  
  private void bMX()
  {
    AppMethodBeat.i(151004);
    if (this.hasInit)
    {
      AppMethodBeat.o(151004);
      return;
    }
    this.hasInit = true;
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.w("MicroMsg.ChattingOperationUitl", "account has not ready");
      AppMethodBeat.o(151004);
      return;
    }
    c localc = com.tencent.mm.model.newabtest.d.bEt().Fd("100148");
    if ((localc != null) && (localc.isValid())) {
      this.oVa = Util.getInt((String)localc.iWZ().get("needUploadData"), 1);
    }
    localc = com.tencent.mm.model.newabtest.d.bEt().Fd("100149");
    if ((localc != null) && (localc.isValid())) {
      this.oVb = Util.getInt((String)localc.iWZ().get("needUploadData"), 1);
    }
    AppMethodBeat.o(151004);
  }
  
  public final void a(cc arg1, b paramb, int paramInt)
  {
    AppMethodBeat.i(150990);
    if ((??? == null) || (!hZ(???.field_talker)))
    {
      AppMethodBeat.o(150990);
      return;
    }
    IMBehavior localIMBehavior1 = new IMBehavior();
    localIMBehavior1.opType = 2;
    localIMBehavior1.msgOp = new IMBehaviorMsgOP();
    localIMBehavior1.msgOp.msgType = (???.getType() & 0xFFFF);
    if (???.fxR()) {
      localIMBehavior1.msgOp.appMsgInnerType = paramInt;
    }
    localIMBehavior1.msgOp.msgOpType = paramb.value;
    localIMBehavior1.msgOp.count = 1;
    synchronized (this.lock)
    {
      if (localIMBehavior1.opType == b.a.oVf.value)
      {
        this.oUY.oplist_.add(localIMBehavior1);
        AppMethodBeat.o(150990);
        return;
      }
      paramb = this.oUY.oplist_.iterator();
      while (paramb.hasNext())
      {
        IMBehavior localIMBehavior2 = (IMBehavior)paramb.next();
        if (localIMBehavior2.opType == b.a.oVg.value)
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
      this.oUY.oplist_.add(localIMBehavior1);
      AppMethodBeat.o(150990);
      return;
    }
  }
  
  public final void a(cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(150999);
    if (!bMW())
    {
      AppMethodBeat.o(150999);
      return;
    }
    if (!paramcc.iYl())
    {
      AppMethodBeat.o(150999);
      return;
    }
    if (paramBoolean) {}
    for (b localb = b.oVq;; localb = b.oVr)
    {
      a(paramcc, localb, 0);
      AppMethodBeat.o(150999);
      return;
    }
  }
  
  public final void a(cc paramcc, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(151001);
    if (!bMW())
    {
      AppMethodBeat.o(151001);
      return;
    }
    if (paramBoolean) {}
    for (b localb = b.oVu;; localb = b.oVv)
    {
      a(paramcc, localb, paramInt);
      AppMethodBeat.o(151001);
      return;
    }
  }
  
  public final void ab(String arg1, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(150986);
    if (!bMW())
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
      if (hZ(???)) {
        break;
      }
      AppMethodBeat.o(150986);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.oUY.oplist_.add(localIMBehavior);
      report();
      AppMethodBeat.o(150986);
      return;
    }
  }
  
  public final void ad(String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(150988);
    if (!bMW())
    {
      AppMethodBeat.o(150988);
      return;
    }
    if (!hZ(paramString))
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
        this.oUY.oplist_.add(paramString);
        AppMethodBeat.o(150988);
        return;
        i = 2;
      }
    }
  }
  
  public final void ao(cc paramcc)
  {
    AppMethodBeat.i(150994);
    if (!bMW())
    {
      AppMethodBeat.o(150994);
      return;
    }
    a(paramcc, b.oVm, 0);
    AppMethodBeat.o(150994);
  }
  
  public final void ap(cc paramcc)
  {
    AppMethodBeat.i(242931);
    if (!bMW())
    {
      AppMethodBeat.o(242931);
      return;
    }
    a(paramcc, b.oVn, 0);
    AppMethodBeat.o(242931);
  }
  
  public final void aq(cc paramcc)
  {
    AppMethodBeat.i(150996);
    if (!bMW())
    {
      AppMethodBeat.o(150996);
      return;
    }
    a(paramcc, b.oVo, 0);
    AppMethodBeat.o(150996);
  }
  
  public final void ar(cc paramcc)
  {
    AppMethodBeat.i(150997);
    if (!bMW())
    {
      AppMethodBeat.o(150997);
      return;
    }
    a(paramcc, b.oVk, 0);
    AppMethodBeat.o(150997);
  }
  
  public final void as(cc paramcc)
  {
    AppMethodBeat.i(151000);
    if (!bMW())
    {
      AppMethodBeat.o(151000);
      return;
    }
    a(paramcc, b.oVt, 0);
    AppMethodBeat.o(151000);
  }
  
  public final boolean bMW()
  {
    AppMethodBeat.i(151003);
    bMX();
    if ((this.oVa != 0) || (this.oVb != 0))
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
    if (!bMW())
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
      if (hZ(???)) {
        break;
      }
      AppMethodBeat.o(150987);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.oUY.oplist_.add(localIMBehavior);
      if (paramBoolean1) {
        report();
      }
      AppMethodBeat.o(150987);
      return;
    }
  }
  
  public final void d(final cc paramcc, final int paramInt)
  {
    AppMethodBeat.i(150991);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150976);
        b.a(b.this, paramcc, paramInt);
        AppMethodBeat.o(150976);
      }
    });
    AppMethodBeat.o(150991);
  }
  
  public final void e(cc paramcc, int paramInt)
  {
    AppMethodBeat.i(150993);
    if (!bMW())
    {
      AppMethodBeat.o(150993);
      return;
    }
    a(paramcc, b.oVm, paramInt);
    AppMethodBeat.o(150993);
  }
  
  public final void f(cc paramcc, int paramInt)
  {
    AppMethodBeat.i(242925);
    if (!bMW())
    {
      AppMethodBeat.o(242925);
      return;
    }
    a(paramcc, b.oVn, paramInt);
    AppMethodBeat.o(242925);
  }
  
  public final void g(cc paramcc, int paramInt)
  {
    AppMethodBeat.i(150995);
    if (!bMW())
    {
      AppMethodBeat.o(150995);
      return;
    }
    a(paramcc, b.oVo, paramInt);
    AppMethodBeat.o(150995);
  }
  
  public final boolean hZ(String paramString)
  {
    AppMethodBeat.i(150984);
    if (Util.isNullOrNil(paramString))
    {
      paramString = Util.getStack().toString();
      com.tencent.threadpool.h.ahAA.g(new b.1(this, paramString), "ChattingOperationUtil.check");
      AppMethodBeat.o(150984);
      return false;
    }
    if ((this.oUY != null) && (this.oUY.currChatName_ != null) && (!this.oUY.currChatName_.equals(paramString))) {
      report();
    }
    if (this.oUY == null)
    {
      this.oUY = new log_13835();
      this.oUY.currChatName_ = paramString;
    }
    AppMethodBeat.o(150984);
    return true;
  }
  
  public final void report()
  {
    AppMethodBeat.i(150985);
    if (!bMW())
    {
      AppMethodBeat.o(150985);
      return;
    }
    synchronized (this.lock)
    {
      if ((this.oUY != null) && (!this.oUY.oplist_.isEmpty()))
      {
        i = 1;
        if (i != 0)
        {
          if (this.oVb != 0)
          {
            Log.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
            com.tencent.mm.plugin.report.service.h.OAn.c(13835, this.oUY);
          }
          if (this.oVa != 0)
          {
            ??? = bMV();
            Log.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", new Object[] { ??? });
            com.tencent.mm.plugin.report.service.h.OAn.kvStat(13748, (String)???);
          }
        }
        this.oUY = null;
        AppMethodBeat.o(150985);
        return;
      }
      int i = 0;
    }
  }
  
  public final void u(final cc paramcc)
  {
    AppMethodBeat.i(150992);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(242889);
        b.a(b.this, paramcc, 0);
        AppMethodBeat.o(242889);
      }
    });
    AppMethodBeat.o(150992);
  }
  
  public static enum b
  {
    public int value = 0;
    
    static
    {
      AppMethodBeat.i(150982);
      oVi = new b("UnKnownType", 0, 0);
      oVj = new b("expourse", 1, 1);
      oVk = new b("click", 2, 2);
      oVl = new b("send", 3, 3);
      oVm = new b("fav", 4, 4);
      oVn = new b("revoke", 5, 5);
      oVo = new b("delete", 6, 6);
      oVp = new b("voiceToText", 7, 7);
      oVq = new b("translate", 8, 8);
      oVr = new b("translateHidden", 9, 9);
      oVs = new b("doubleClickText", 10, 10);
      oVt = new b("imageSaveToLocal", 11, 11);
      oVu = new b("playMusic", 12, 12);
      oVv = new b("stopMusic", 13, 13);
      oVw = new b[] { oVi, oVj, oVk, oVl, oVm, oVn, oVo, oVp, oVq, oVr, oVs, oVt, oVu, oVv };
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