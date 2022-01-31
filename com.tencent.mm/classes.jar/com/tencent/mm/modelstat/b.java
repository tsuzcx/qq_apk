package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.mm.h.a.ph;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

public final class b
{
  public static b eBD = new b();
  private com.tencent.mm.sdk.b.c diy = new com.tencent.mm.sdk.b.c() {};
  public log_13835 eBC;
  private int eBE = 1;
  private int eBF = 1;
  private boolean hasInit = false;
  public Object lock = new Object();
  
  private b()
  {
    a.udP.b(this.diy);
  }
  
  private String Rl()
  {
    if (this.eBC == null) {
      return "";
    }
    Object localObject1 = ",";
    Object localObject4 = new LinkedList();
    Object localObject2;
    for (;;)
    {
      Object localObject5;
      synchronized (this.lock)
      {
        ((LinkedList)localObject4).addAll(this.eBC.oplist_);
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
    return (String)localObject2 + "," + this.eBC.currChatName_;
  }
  
  public final void A(bi parambi)
  {
    if (!Rm()) {
      return;
    }
    a(parambi, b.b.eBS, 0);
  }
  
  public final void B(bi parambi)
  {
    if (!Rm()) {
      return;
    }
    a(parambi, b.b.eBW, 0);
  }
  
  public final void N(String arg1, boolean paramBoolean)
  {
    int i = 1;
    if (!Rm()) {
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
      wn();
      if (!cd(???)) {
        break;
      }
      synchronized (this.lock)
      {
        this.eBC.oplist_.add(localIMBehavior);
        wn();
        return;
        i = 2;
      }
    }
  }
  
  public final void O(String paramString, boolean paramBoolean)
  {
    int i = 1;
    if (!Rm()) {}
    while (!cd(paramString)) {
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
        this.eBC.oplist_.add(paramString);
        return;
      }
      i = 2;
    }
  }
  
  public final boolean Rm()
  {
    if (!this.hasInit)
    {
      this.hasInit = true;
      if (g.DK()) {
        break label41;
      }
      y.w("MicroMsg.ChattingOperationUitl", "account has not ready");
    }
    while ((this.eBE != 0) || (this.eBF != 0))
    {
      return true;
      label41:
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100148");
      if (localc.isValid()) {
        this.eBE = bk.getInt((String)localc.ctr().get("needUploadData"), 1);
      }
      localc = com.tencent.mm.model.c.c.IX().fJ("100149");
      if (localc.isValid()) {
        this.eBF = bk.getInt((String)localc.ctr().get("needUploadData"), 1);
      }
    }
    return false;
  }
  
  public final void a(bi parambi, int paramInt)
  {
    new ah(Looper.getMainLooper()).post(new b.2(this, parambi, paramInt));
  }
  
  public final void a(bi arg1, b.b paramb, int paramInt)
  {
    if (!cd(???.field_talker)) {
      return;
    }
    IMBehavior localIMBehavior1 = new IMBehavior();
    localIMBehavior1.opType = 2;
    localIMBehavior1.msgOp = new IMBehaviorMsgOP();
    localIMBehavior1.msgOp.msgType = (???.getType() & 0xFFFF);
    if (???.aVK()) {
      localIMBehavior1.msgOp.appMsgInnerType = paramInt;
    }
    localIMBehavior1.msgOp.msgOpType = paramb.value;
    localIMBehavior1.msgOp.count = 1;
    synchronized (this.lock)
    {
      if (localIMBehavior1.opType == b.a.eBI.value)
      {
        this.eBC.oplist_.add(localIMBehavior1);
        return;
      }
    }
    paramb = this.eBC.oplist_.iterator();
    for (;;)
    {
      IMBehavior localIMBehavior2;
      if (paramb.hasNext())
      {
        localIMBehavior2 = (IMBehavior)paramb.next();
        if (localIMBehavior2.opType != b.a.eBJ.value) {
          continue;
        }
        IMBehaviorMsgOP localIMBehaviorMsgOP1 = localIMBehavior2.msgOp;
        IMBehaviorMsgOP localIMBehaviorMsgOP2 = localIMBehavior1.msgOp;
        if ((localIMBehaviorMsgOP1.msgOpType != localIMBehaviorMsgOP2.msgOpType) || (localIMBehaviorMsgOP1.msgType != localIMBehaviorMsgOP2.msgType) || (localIMBehaviorMsgOP1.appMsgInnerType != localIMBehaviorMsgOP2.appMsgInnerType)) {
          break label273;
        }
      }
      label273:
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        paramb = localIMBehavior2.msgOp;
        paramb.count += 1;
        return;
        this.eBC.oplist_.add(localIMBehavior1);
        return;
      }
    }
  }
  
  public final void a(bi parambi, boolean paramBoolean)
  {
    if (!Rm()) {}
    while (!parambi.isText()) {
      return;
    }
    if (paramBoolean) {}
    for (b.b localb = b.b.eBT;; localb = b.b.eBU)
    {
      a(parambi, localb, 0);
      return;
    }
  }
  
  public final void a(bi parambi, boolean paramBoolean, int paramInt)
  {
    if (!Rm()) {
      return;
    }
    if (paramBoolean) {}
    for (b.b localb = b.b.eBX;; localb = b.b.eBY)
    {
      a(parambi, localb, paramInt);
      return;
    }
  }
  
  public final void b(bi parambi, int paramInt)
  {
    if (!Rm()) {
      return;
    }
    a(parambi, b.b.eBP, paramInt);
  }
  
  public final void c(bi parambi, int paramInt)
  {
    if (!Rm()) {
      return;
    }
    a(parambi, b.b.eBR, paramInt);
  }
  
  public final void c(boolean paramBoolean1, String arg2, boolean paramBoolean2)
  {
    int i = 1;
    if (!Rm()) {}
    for (;;)
    {
      return;
      IMBehavior localIMBehavior = new IMBehavior();
      localIMBehavior.opType = 1;
      localIMBehavior.chattingOp = new IMBehaviorChattingOP();
      IMBehaviorChattingOP localIMBehaviorChattingOP = localIMBehavior.chattingOp;
      if (paramBoolean2)
      {
        localIMBehaviorChattingOP.changeTop = i;
        if (paramBoolean1) {
          wn();
        }
        if (!cd(???)) {
          continue;
        }
      }
      synchronized (this.lock)
      {
        this.eBC.oplist_.add(localIMBehavior);
        if (!paramBoolean1) {
          continue;
        }
        wn();
        return;
        i = 2;
      }
    }
  }
  
  public final boolean cd(String paramString)
  {
    if (bk.bl(paramString))
    {
      paramString = bk.csb().toString();
      y.e("MicroMsg.ChattingOperationUitl", "check error:%s", new Object[] { paramString });
      log_13913 locallog_13913 = new log_13913();
      locallog_13913.scene_ = 1;
      locallog_13913.error_ = paramString;
      h.nFQ.c(13913, locallog_13913);
      return false;
    }
    if ((this.eBC != null) && (this.eBC.currChatName_ != null) && (!this.eBC.currChatName_.equals(paramString))) {
      wn();
    }
    if (this.eBC == null)
    {
      this.eBC = new log_13835();
      this.eBC.currChatName_ = paramString;
    }
    return true;
  }
  
  public final void f(bi parambi)
  {
    new ah(Looper.getMainLooper()).post(new b.3(this, parambi));
  }
  
  public final void wn()
  {
    if (!Rm()) {
      return;
    }
    synchronized (this.lock)
    {
      if ((this.eBC != null) && (!this.eBC.oplist_.isEmpty()))
      {
        i = 1;
        if (i != 0)
        {
          if (this.eBF != 0)
          {
            y.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
            h.nFQ.c(13835, this.eBC);
          }
          if (this.eBE != 0)
          {
            ??? = Rl();
            y.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", new Object[] { ??? });
            h.nFQ.aC(13748, (String)???);
          }
        }
        this.eBC = null;
        return;
      }
      int i = 0;
    }
  }
  
  public final void x(bi parambi)
  {
    if (!Rm()) {
      return;
    }
    a(parambi, b.b.eBP, 0);
  }
  
  public final void y(bi parambi)
  {
    if (!Rm()) {
      return;
    }
    a(parambi, b.b.eBR, 0);
  }
  
  public final void z(bi parambi)
  {
    if (!Rm()) {
      return;
    }
    a(parambi, b.b.eBN, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelstat.b
 * JD-Core Version:    0.7.0.1
 */