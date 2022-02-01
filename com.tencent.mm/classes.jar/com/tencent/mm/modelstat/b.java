package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.plugin.report.service.h;
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
  public static b jmd;
  private IListener gmS;
  private boolean hasInit;
  public log_13835 jmc;
  private int jme;
  private int jmf;
  public Object lock;
  
  static
  {
    AppMethodBeat.i(151006);
    jmd = new b();
    AppMethodBeat.o(151006);
  }
  
  private b()
  {
    AppMethodBeat.i(150983);
    this.lock = new Object();
    this.gmS = new IListener() {};
    this.jme = 1;
    this.jmf = 1;
    this.hasInit = false;
    EventCenter.instance.add(this.gmS);
    AppMethodBeat.o(150983);
  }
  
  private void a(IMBehavior paramIMBehavior)
  {
    AppMethodBeat.i(150989);
    synchronized (this.lock)
    {
      if (paramIMBehavior.opType == b.a.jmi.value)
      {
        this.jmc.oplist_.add(paramIMBehavior);
        AppMethodBeat.o(150989);
        return;
      }
      Iterator localIterator = this.jmc.oplist_.iterator();
      while (localIterator.hasNext())
      {
        IMBehavior localIMBehavior = (IMBehavior)localIterator.next();
        if (localIMBehavior.opType == b.a.jmj.value)
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
      this.jmc.oplist_.add(paramIMBehavior);
      AppMethodBeat.o(150989);
      return;
    }
  }
  
  private String bfY()
  {
    AppMethodBeat.i(151002);
    if (this.jmc == null)
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
        ((LinkedList)localObject4).addAll(this.jmc.oplist_);
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
    Object localObject2 = (String)localObject2 + "," + this.jmc.currChatName_;
    AppMethodBeat.o(151002);
    return localObject2;
  }
  
  private void bga()
  {
    AppMethodBeat.i(151004);
    if (this.hasInit)
    {
      AppMethodBeat.o(151004);
      return;
    }
    this.hasInit = true;
    if (!g.aAc())
    {
      Log.w("MicroMsg.ChattingOperationUitl", "account has not ready");
      AppMethodBeat.o(151004);
      return;
    }
    c localc = com.tencent.mm.model.c.d.aXu().Fu("100148");
    if (localc.isValid()) {
      this.jme = Util.getInt((String)localc.gzz().get("needUploadData"), 1);
    }
    localc = com.tencent.mm.model.c.d.aXu().Fu("100149");
    if (localc.isValid()) {
      this.jmf = Util.getInt((String)localc.gzz().get("needUploadData"), 1);
    }
    AppMethodBeat.o(151004);
  }
  
  public final void V(String arg1, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(150986);
    if (!bfZ())
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
      if (fP(???)) {
        break;
      }
      AppMethodBeat.o(150986);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.jmc.oplist_.add(localIMBehavior);
      report();
      AppMethodBeat.o(150986);
      return;
    }
  }
  
  public final void W(String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(150988);
    if (!bfZ())
    {
      AppMethodBeat.o(150988);
      return;
    }
    if (!fP(paramString))
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
        this.jmc.oplist_.add(paramString);
        AppMethodBeat.o(150988);
        return;
        i = 2;
      }
    }
  }
  
  public final void a(ca paramca, b paramb, int paramInt)
  {
    AppMethodBeat.i(150990);
    if ((paramca == null) || (!fP(paramca.field_talker)))
    {
      AppMethodBeat.o(150990);
      return;
    }
    IMBehavior localIMBehavior = new IMBehavior();
    localIMBehavior.opType = 2;
    localIMBehavior.msgOp = new IMBehaviorMsgOP();
    localIMBehavior.msgOp.msgType = (paramca.getType() & 0xFFFF);
    if (paramca.dOQ()) {
      localIMBehavior.msgOp.appMsgInnerType = paramInt;
    }
    localIMBehavior.msgOp.msgOpType = paramb.value;
    localIMBehavior.msgOp.count = 1;
    a(localIMBehavior);
    AppMethodBeat.o(150990);
  }
  
  public final void a(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(150999);
    if (!bfZ())
    {
      AppMethodBeat.o(150999);
      return;
    }
    if (!paramca.isText())
    {
      AppMethodBeat.o(150999);
      return;
    }
    if (paramBoolean) {}
    for (b localb = b.jmt;; localb = b.jmu)
    {
      a(paramca, localb, 0);
      AppMethodBeat.o(150999);
      return;
    }
  }
  
  public final void a(ca paramca, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(151001);
    if (!bfZ())
    {
      AppMethodBeat.o(151001);
      return;
    }
    if (paramBoolean) {}
    for (b localb = b.jmx;; localb = b.jmy)
    {
      a(paramca, localb, paramInt);
      AppMethodBeat.o(151001);
      return;
    }
  }
  
  public final void ac(ca paramca)
  {
    AppMethodBeat.i(150994);
    if (!bfZ())
    {
      AppMethodBeat.o(150994);
      return;
    }
    a(paramca, b.jmp, 0);
    AppMethodBeat.o(150994);
  }
  
  public final void ad(ca paramca)
  {
    AppMethodBeat.i(150996);
    if (!bfZ())
    {
      AppMethodBeat.o(150996);
      return;
    }
    a(paramca, b.jmr, 0);
    AppMethodBeat.o(150996);
  }
  
  public final void ae(ca paramca)
  {
    AppMethodBeat.i(150997);
    if (!bfZ())
    {
      AppMethodBeat.o(150997);
      return;
    }
    a(paramca, b.jmn, 0);
    AppMethodBeat.o(150997);
  }
  
  public final void af(ca paramca)
  {
    AppMethodBeat.i(151000);
    if (!bfZ())
    {
      AppMethodBeat.o(151000);
      return;
    }
    a(paramca, b.jmw, 0);
    AppMethodBeat.o(151000);
  }
  
  public final void b(final ca paramca, final int paramInt)
  {
    AppMethodBeat.i(150991);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150975);
        b.a(b.this, paramca, paramInt);
        AppMethodBeat.o(150975);
      }
    });
    AppMethodBeat.o(150991);
  }
  
  public final boolean bfZ()
  {
    AppMethodBeat.i(151003);
    bga();
    if ((this.jme != 0) || (this.jmf != 0))
    {
      AppMethodBeat.o(151003);
      return true;
    }
    AppMethodBeat.o(151003);
    return false;
  }
  
  public final void c(ca paramca, int paramInt)
  {
    AppMethodBeat.i(150993);
    if (!bfZ())
    {
      AppMethodBeat.o(150993);
      return;
    }
    a(paramca, b.jmp, paramInt);
    AppMethodBeat.o(150993);
  }
  
  public final void c(boolean paramBoolean1, String arg2, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(150987);
    if (!bfZ())
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
      if (fP(???)) {
        break;
      }
      AppMethodBeat.o(150987);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.jmc.oplist_.add(localIMBehavior);
      if (paramBoolean1) {
        report();
      }
      AppMethodBeat.o(150987);
      return;
    }
  }
  
  public final void d(ca paramca, int paramInt)
  {
    AppMethodBeat.i(150995);
    if (!bfZ())
    {
      AppMethodBeat.o(150995);
      return;
    }
    a(paramca, b.jmr, paramInt);
    AppMethodBeat.o(150995);
  }
  
  public final boolean fP(String paramString)
  {
    AppMethodBeat.i(150984);
    if (Util.isNullOrNil(paramString))
    {
      paramString = Util.getStack().toString();
      Log.e("MicroMsg.ChattingOperationUitl", "check error:%s", new Object[] { paramString });
      log_13913 locallog_13913 = new log_13913();
      locallog_13913.scene_ = 1;
      locallog_13913.error_ = paramString;
      h.CyF.c(13913, locallog_13913);
      AppMethodBeat.o(150984);
      return false;
    }
    if ((this.jmc != null) && (this.jmc.currChatName_ != null) && (!this.jmc.currChatName_.equals(paramString))) {
      report();
    }
    if (this.jmc == null)
    {
      this.jmc = new log_13835();
      this.jmc.currChatName_ = paramString;
    }
    AppMethodBeat.o(150984);
    return true;
  }
  
  public final void report()
  {
    AppMethodBeat.i(150985);
    if (!bfZ())
    {
      AppMethodBeat.o(150985);
      return;
    }
    synchronized (this.lock)
    {
      if ((this.jmc != null) && (!this.jmc.oplist_.isEmpty()))
      {
        i = 1;
        if (i != 0)
        {
          if (this.jmf != 0)
          {
            Log.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
            h.CyF.c(13835, this.jmc);
          }
          if (this.jme != 0)
          {
            ??? = bfY();
            Log.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", new Object[] { ??? });
            h.CyF.kvStat(13748, (String)???);
          }
        }
        this.jmc = null;
        AppMethodBeat.o(150985);
        return;
      }
      int i = 0;
    }
  }
  
  public final void s(final ca paramca)
  {
    AppMethodBeat.i(150992);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150976);
        b.a(b.this, paramca, 0);
        AppMethodBeat.o(150976);
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
      jml = new b("UnKnownType", 0, 0);
      jmm = new b("expourse", 1, 1);
      jmn = new b("click", 2, 2);
      jmo = new b("send", 3, 3);
      jmp = new b("fav", 4, 4);
      jmq = new b("revoke", 5, 5);
      jmr = new b("delete", 6, 6);
      jms = new b("voiceToText", 7, 7);
      jmt = new b("translate", 8, 8);
      jmu = new b("translateHidden", 9, 9);
      jmv = new b("doubleClickText", 10, 10);
      jmw = new b("imageSaveToLocal", 11, 11);
      jmx = new b("playMusic", 12, 12);
      jmy = new b("stopMusic", 13, 13);
      jmz = new b[] { jml, jmm, jmn, jmo, jmp, jmq, jmr, jms, jmt, jmu, jmv, jmw, jmx, jmy };
      AppMethodBeat.o(150982);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.b
 * JD-Core Version:    0.7.0.1
 */