package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

public final class b
{
  public static b hUE;
  private com.tencent.mm.sdk.b.c fnu;
  public log_13835 hUD;
  private int hUF;
  private int hUG;
  private boolean hasInit;
  public Object lock;
  
  static
  {
    AppMethodBeat.i(151006);
    hUE = new b();
    AppMethodBeat.o(151006);
  }
  
  private b()
  {
    AppMethodBeat.i(150983);
    this.lock = new Object();
    this.fnu = new com.tencent.mm.sdk.b.c() {};
    this.hUF = 1;
    this.hUG = 1;
    this.hasInit = false;
    a.GpY.b(this.fnu);
    AppMethodBeat.o(150983);
  }
  
  private void a(IMBehavior paramIMBehavior)
  {
    AppMethodBeat.i(150989);
    synchronized (this.lock)
    {
      if (paramIMBehavior.opType == b.a.hUJ.value)
      {
        this.hUD.oplist_.add(paramIMBehavior);
        AppMethodBeat.o(150989);
        return;
      }
      Iterator localIterator = this.hUD.oplist_.iterator();
      while (localIterator.hasNext())
      {
        IMBehavior localIMBehavior = (IMBehavior)localIterator.next();
        if (localIMBehavior.opType == b.a.hUK.value)
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
      this.hUD.oplist_.add(paramIMBehavior);
      AppMethodBeat.o(150989);
      return;
    }
  }
  
  private String aIo()
  {
    AppMethodBeat.i(151002);
    if (this.hUD == null)
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
        ((LinkedList)localObject4).addAll(this.hUD.oplist_);
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
    Object localObject2 = (String)localObject2 + "," + this.hUD.currChatName_;
    AppMethodBeat.o(151002);
    return localObject2;
  }
  
  private void aIq()
  {
    AppMethodBeat.i(151004);
    if (this.hasInit)
    {
      AppMethodBeat.o(151004);
      return;
    }
    this.hasInit = true;
    if (!g.agM())
    {
      ac.w("MicroMsg.ChattingOperationUitl", "account has not ready");
      AppMethodBeat.o(151004);
      return;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aAp().tJ("100148");
    if (localc.isValid()) {
      this.hUF = bs.getInt((String)localc.eYV().get("needUploadData"), 1);
    }
    localc = com.tencent.mm.model.c.d.aAp().tJ("100149");
    if (localc.isValid()) {
      this.hUG = bs.getInt((String)localc.eYV().get("needUploadData"), 1);
    }
    AppMethodBeat.o(151004);
  }
  
  public final void P(bo parambo)
  {
    AppMethodBeat.i(150994);
    if (!aIp())
    {
      AppMethodBeat.o(150994);
      return;
    }
    a(parambo, b.hUQ, 0);
    AppMethodBeat.o(150994);
  }
  
  public final void Q(bo parambo)
  {
    AppMethodBeat.i(150996);
    if (!aIp())
    {
      AppMethodBeat.o(150996);
      return;
    }
    a(parambo, b.hUS, 0);
    AppMethodBeat.o(150996);
  }
  
  public final void R(bo parambo)
  {
    AppMethodBeat.i(150997);
    if (!aIp())
    {
      AppMethodBeat.o(150997);
      return;
    }
    a(parambo, b.hUO, 0);
    AppMethodBeat.o(150997);
  }
  
  public final void S(bo parambo)
  {
    AppMethodBeat.i(150998);
    if (!aIp())
    {
      AppMethodBeat.o(150998);
      return;
    }
    a(parambo, b.hUT, 0);
    AppMethodBeat.o(150998);
  }
  
  public final void T(bo parambo)
  {
    AppMethodBeat.i(151000);
    if (!aIp())
    {
      AppMethodBeat.o(151000);
      return;
    }
    a(parambo, b.hUX, 0);
    AppMethodBeat.o(151000);
  }
  
  public final void V(String arg1, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(150986);
    if (!aIp())
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
      if (eb(???)) {
        break;
      }
      AppMethodBeat.o(150986);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.hUD.oplist_.add(localIMBehavior);
      report();
      AppMethodBeat.o(150986);
      return;
    }
  }
  
  public final void W(String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(150988);
    if (!aIp())
    {
      AppMethodBeat.o(150988);
      return;
    }
    if (!eb(paramString))
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
        this.hUD.oplist_.add(paramString);
        AppMethodBeat.o(150988);
        return;
        i = 2;
      }
    }
  }
  
  public final void a(bo parambo, b paramb, int paramInt)
  {
    AppMethodBeat.i(150990);
    if ((parambo == null) || (!eb(parambo.field_talker)))
    {
      AppMethodBeat.o(150990);
      return;
    }
    IMBehavior localIMBehavior = new IMBehavior();
    localIMBehavior.opType = 2;
    localIMBehavior.msgOp = new IMBehaviorMsgOP();
    localIMBehavior.msgOp.msgType = (parambo.getType() & 0xFFFF);
    if (parambo.cKN()) {
      localIMBehavior.msgOp.appMsgInnerType = paramInt;
    }
    localIMBehavior.msgOp.msgOpType = paramb.value;
    localIMBehavior.msgOp.count = 1;
    a(localIMBehavior);
    AppMethodBeat.o(150990);
  }
  
  public final void a(bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(150999);
    if (!aIp())
    {
      AppMethodBeat.o(150999);
      return;
    }
    if (!parambo.isText())
    {
      AppMethodBeat.o(150999);
      return;
    }
    if (paramBoolean) {}
    for (b localb = b.hUU;; localb = b.hUV)
    {
      a(parambo, localb, 0);
      AppMethodBeat.o(150999);
      return;
    }
  }
  
  public final void a(bo parambo, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(151001);
    if (!aIp())
    {
      AppMethodBeat.o(151001);
      return;
    }
    if (paramBoolean) {}
    for (b localb = b.hUY;; localb = b.hUZ)
    {
      a(parambo, localb, paramInt);
      AppMethodBeat.o(151001);
      return;
    }
  }
  
  public final boolean aIp()
  {
    AppMethodBeat.i(151003);
    aIq();
    if ((this.hUF != 0) || (this.hUG != 0))
    {
      AppMethodBeat.o(151003);
      return true;
    }
    AppMethodBeat.o(151003);
    return false;
  }
  
  public final void b(final bo parambo, final int paramInt)
  {
    AppMethodBeat.i(150991);
    new ao(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150975);
        b.a(b.this, parambo, paramInt);
        AppMethodBeat.o(150975);
      }
    });
    AppMethodBeat.o(150991);
  }
  
  public final void c(bo parambo, int paramInt)
  {
    AppMethodBeat.i(150993);
    if (!aIp())
    {
      AppMethodBeat.o(150993);
      return;
    }
    a(parambo, b.hUQ, paramInt);
    AppMethodBeat.o(150993);
  }
  
  public final void c(boolean paramBoolean1, String arg2, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(150987);
    if (!aIp())
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
      if (eb(???)) {
        break;
      }
      AppMethodBeat.o(150987);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.hUD.oplist_.add(localIMBehavior);
      if (paramBoolean1) {
        report();
      }
      AppMethodBeat.o(150987);
      return;
    }
  }
  
  public final void d(bo parambo, int paramInt)
  {
    AppMethodBeat.i(150995);
    if (!aIp())
    {
      AppMethodBeat.o(150995);
      return;
    }
    a(parambo, b.hUS, paramInt);
    AppMethodBeat.o(150995);
  }
  
  public final boolean eb(String paramString)
  {
    AppMethodBeat.i(150984);
    if (bs.isNullOrNil(paramString))
    {
      paramString = bs.eWi().toString();
      ac.e("MicroMsg.ChattingOperationUitl", "check error:%s", new Object[] { paramString });
      log_13913 locallog_13913 = new log_13913();
      locallog_13913.scene_ = 1;
      locallog_13913.error_ = paramString;
      h.wUl.c(13913, locallog_13913);
      AppMethodBeat.o(150984);
      return false;
    }
    if ((this.hUD != null) && (this.hUD.currChatName_ != null) && (!this.hUD.currChatName_.equals(paramString))) {
      report();
    }
    if (this.hUD == null)
    {
      this.hUD = new log_13835();
      this.hUD.currChatName_ = paramString;
    }
    AppMethodBeat.o(150984);
    return true;
  }
  
  public final void q(final bo parambo)
  {
    AppMethodBeat.i(150992);
    new ao(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150976);
        b.a(b.this, parambo, 0);
        AppMethodBeat.o(150976);
      }
    });
    AppMethodBeat.o(150992);
  }
  
  public final void report()
  {
    AppMethodBeat.i(150985);
    if (!aIp())
    {
      AppMethodBeat.o(150985);
      return;
    }
    synchronized (this.lock)
    {
      if ((this.hUD != null) && (!this.hUD.oplist_.isEmpty()))
      {
        i = 1;
        if (i != 0)
        {
          if (this.hUG != 0)
          {
            ac.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
            h.wUl.c(13835, this.hUD);
          }
          if (this.hUF != 0)
          {
            ??? = aIo();
            ac.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", new Object[] { ??? });
            h.wUl.kvStat(13748, (String)???);
          }
        }
        this.hUD = null;
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
      hUM = new b("UnKnownType", 0, 0);
      hUN = new b("expourse", 1, 1);
      hUO = new b("click", 2, 2);
      hUP = new b("send", 3, 3);
      hUQ = new b("fav", 4, 4);
      hUR = new b("revoke", 5, 5);
      hUS = new b("delete", 6, 6);
      hUT = new b("voiceToText", 7, 7);
      hUU = new b("translate", 8, 8);
      hUV = new b("translateHidden", 9, 9);
      hUW = new b("doubleClickText", 10, 10);
      hUX = new b("imageSaveToLocal", 11, 11);
      hUY = new b("playMusic", 12, 12);
      hUZ = new b("stopMusic", 13, 13);
      hVa = new b[] { hUM, hUN, hUO, hUP, hUQ, hUR, hUS, hUT, hUU, hUV, hUW, hUX, hUY, hUZ };
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