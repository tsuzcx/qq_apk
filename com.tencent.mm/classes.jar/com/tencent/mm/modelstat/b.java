package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

public final class b
{
  public static b huc;
  private com.tencent.mm.sdk.b.c fka;
  private boolean hasInit;
  public log_13835 hub;
  private int hud;
  private int hue;
  public Object lock;
  
  static
  {
    AppMethodBeat.i(151006);
    huc = new b();
    AppMethodBeat.o(151006);
  }
  
  private b()
  {
    AppMethodBeat.i(150983);
    this.lock = new Object();
    this.fka = new com.tencent.mm.sdk.b.c() {};
    this.hud = 1;
    this.hue = 1;
    this.hasInit = false;
    a.ESL.b(this.fka);
    AppMethodBeat.o(150983);
  }
  
  private void a(IMBehavior paramIMBehavior)
  {
    AppMethodBeat.i(150989);
    synchronized (this.lock)
    {
      if (paramIMBehavior.opType == a.huh.value)
      {
        this.hub.oplist_.add(paramIMBehavior);
        AppMethodBeat.o(150989);
        return;
      }
      Iterator localIterator = this.hub.oplist_.iterator();
      while (localIterator.hasNext())
      {
        IMBehavior localIMBehavior = (IMBehavior)localIterator.next();
        if (localIMBehavior.opType == a.hui.value)
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
      this.hub.oplist_.add(paramIMBehavior);
      AppMethodBeat.o(150989);
      return;
    }
  }
  
  private void aBA()
  {
    AppMethodBeat.i(151004);
    if (this.hasInit)
    {
      AppMethodBeat.o(151004);
      return;
    }
    this.hasInit = true;
    if (!g.afw())
    {
      ad.w("MicroMsg.ChattingOperationUitl", "account has not ready");
      AppMethodBeat.o(151004);
      return;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aty().qu("100148");
    if (localc.isValid()) {
      this.hud = bt.getInt((String)localc.eJy().get("needUploadData"), 1);
    }
    localc = com.tencent.mm.model.c.d.aty().qu("100149");
    if (localc.isValid()) {
      this.hue = bt.getInt((String)localc.eJy().get("needUploadData"), 1);
    }
    AppMethodBeat.o(151004);
  }
  
  private String aBy()
  {
    AppMethodBeat.i(151002);
    if (this.hub == null)
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
        ((LinkedList)localObject4).addAll(this.hub.oplist_);
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
    Object localObject2 = (String)localObject2 + "," + this.hub.currChatName_;
    AppMethodBeat.o(151002);
    return localObject2;
  }
  
  public final void P(bl parambl)
  {
    AppMethodBeat.i(150994);
    if (!aBz())
    {
      AppMethodBeat.o(150994);
      return;
    }
    a(parambl, b.huo, 0);
    AppMethodBeat.o(150994);
  }
  
  public final void Q(bl parambl)
  {
    AppMethodBeat.i(150996);
    if (!aBz())
    {
      AppMethodBeat.o(150996);
      return;
    }
    a(parambl, b.huq, 0);
    AppMethodBeat.o(150996);
  }
  
  public final void R(bl parambl)
  {
    AppMethodBeat.i(150997);
    if (!aBz())
    {
      AppMethodBeat.o(150997);
      return;
    }
    a(parambl, b.hum, 0);
    AppMethodBeat.o(150997);
  }
  
  public final void S(bl parambl)
  {
    AppMethodBeat.i(150998);
    if (!aBz())
    {
      AppMethodBeat.o(150998);
      return;
    }
    a(parambl, b.hur, 0);
    AppMethodBeat.o(150998);
  }
  
  public final void T(bl parambl)
  {
    AppMethodBeat.i(151000);
    if (!aBz())
    {
      AppMethodBeat.o(151000);
      return;
    }
    a(parambl, b.huv, 0);
    AppMethodBeat.o(151000);
  }
  
  public final void U(String arg1, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(150986);
    if (!aBz())
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
      if (em(???)) {
        break;
      }
      AppMethodBeat.o(150986);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.hub.oplist_.add(localIMBehavior);
      report();
      AppMethodBeat.o(150986);
      return;
    }
  }
  
  public final void V(String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(150988);
    if (!aBz())
    {
      AppMethodBeat.o(150988);
      return;
    }
    if (!em(paramString))
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
        this.hub.oplist_.add(paramString);
        AppMethodBeat.o(150988);
        return;
        i = 2;
      }
    }
  }
  
  public final void a(bl parambl, b paramb, int paramInt)
  {
    AppMethodBeat.i(150990);
    if ((parambl == null) || (!em(parambl.field_talker)))
    {
      AppMethodBeat.o(150990);
      return;
    }
    IMBehavior localIMBehavior = new IMBehavior();
    localIMBehavior.opType = 2;
    localIMBehavior.msgOp = new IMBehaviorMsgOP();
    localIMBehavior.msgOp.msgType = (parambl.getType() & 0xFFFF);
    if (parambl.cxB()) {
      localIMBehavior.msgOp.appMsgInnerType = paramInt;
    }
    localIMBehavior.msgOp.msgOpType = paramb.value;
    localIMBehavior.msgOp.count = 1;
    a(localIMBehavior);
    AppMethodBeat.o(150990);
  }
  
  public final void a(bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(150999);
    if (!aBz())
    {
      AppMethodBeat.o(150999);
      return;
    }
    if (!parambl.isText())
    {
      AppMethodBeat.o(150999);
      return;
    }
    if (paramBoolean) {}
    for (b localb = b.hus;; localb = b.hut)
    {
      a(parambl, localb, 0);
      AppMethodBeat.o(150999);
      return;
    }
  }
  
  public final void a(bl parambl, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(151001);
    if (!aBz())
    {
      AppMethodBeat.o(151001);
      return;
    }
    if (paramBoolean) {}
    for (b localb = b.huw;; localb = b.hux)
    {
      a(parambl, localb, paramInt);
      AppMethodBeat.o(151001);
      return;
    }
  }
  
  public final boolean aBz()
  {
    AppMethodBeat.i(151003);
    aBA();
    if ((this.hud != 0) || (this.hue != 0))
    {
      AppMethodBeat.o(151003);
      return true;
    }
    AppMethodBeat.o(151003);
    return false;
  }
  
  public final void b(final bl parambl, final int paramInt)
  {
    AppMethodBeat.i(150991);
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150975);
        b.a(b.this, parambl, paramInt);
        AppMethodBeat.o(150975);
      }
    });
    AppMethodBeat.o(150991);
  }
  
  public final void c(bl parambl, int paramInt)
  {
    AppMethodBeat.i(150993);
    if (!aBz())
    {
      AppMethodBeat.o(150993);
      return;
    }
    a(parambl, b.huo, paramInt);
    AppMethodBeat.o(150993);
  }
  
  public final void c(boolean paramBoolean1, String arg2, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(150987);
    if (!aBz())
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
      if (em(???)) {
        break;
      }
      AppMethodBeat.o(150987);
      return;
      i = 2;
    }
    synchronized (this.lock)
    {
      this.hub.oplist_.add(localIMBehavior);
      if (paramBoolean1) {
        report();
      }
      AppMethodBeat.o(150987);
      return;
    }
  }
  
  public final void d(bl parambl, int paramInt)
  {
    AppMethodBeat.i(150995);
    if (!aBz())
    {
      AppMethodBeat.o(150995);
      return;
    }
    a(parambl, b.huq, paramInt);
    AppMethodBeat.o(150995);
  }
  
  public final boolean em(String paramString)
  {
    AppMethodBeat.i(150984);
    if (bt.isNullOrNil(paramString))
    {
      paramString = bt.eGN().toString();
      ad.e("MicroMsg.ChattingOperationUitl", "check error:%s", new Object[] { paramString });
      log_13913 locallog_13913 = new log_13913();
      locallog_13913.scene_ = 1;
      locallog_13913.error_ = paramString;
      h.vKh.c(13913, locallog_13913);
      AppMethodBeat.o(150984);
      return false;
    }
    if ((this.hub != null) && (this.hub.currChatName_ != null) && (!this.hub.currChatName_.equals(paramString))) {
      report();
    }
    if (this.hub == null)
    {
      this.hub = new log_13835();
      this.hub.currChatName_ = paramString;
    }
    AppMethodBeat.o(150984);
    return true;
  }
  
  public final void q(final bl parambl)
  {
    AppMethodBeat.i(150992);
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150976);
        b.a(b.this, parambl, 0);
        AppMethodBeat.o(150976);
      }
    });
    AppMethodBeat.o(150992);
  }
  
  public final void report()
  {
    AppMethodBeat.i(150985);
    if (!aBz())
    {
      AppMethodBeat.o(150985);
      return;
    }
    synchronized (this.lock)
    {
      if ((this.hub != null) && (!this.hub.oplist_.isEmpty()))
      {
        i = 1;
        if (i != 0)
        {
          if (this.hue != 0)
          {
            ad.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
            h.vKh.c(13835, this.hub);
          }
          if (this.hud != 0)
          {
            ??? = aBy();
            ad.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", new Object[] { ??? });
            h.vKh.kvStat(13748, (String)???);
          }
        }
        this.hub = null;
        AppMethodBeat.o(150985);
        return;
      }
      int i = 0;
    }
  }
  
  public static enum a
  {
    public int value = 0;
    
    static
    {
      AppMethodBeat.i(150979);
      huh = new a("OP_Chatting", 0, 1);
      hui = new a("OP_Msg", 1, 2);
      huj = new a[] { huh, hui };
      AppMethodBeat.o(150979);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum b
  {
    public int value = 0;
    
    static
    {
      AppMethodBeat.i(150982);
      huk = new b("UnKnownType", 0, 0);
      hul = new b("expourse", 1, 1);
      hum = new b("click", 2, 2);
      hun = new b("send", 3, 3);
      huo = new b("fav", 4, 4);
      hup = new b("revoke", 5, 5);
      huq = new b("delete", 6, 6);
      hur = new b("voiceToText", 7, 7);
      hus = new b("translate", 8, 8);
      hut = new b("translateHidden", 9, 9);
      huu = new b("doubleClickText", 10, 10);
      huv = new b("imageSaveToLocal", 11, 11);
      huw = new b("playMusic", 12, 12);
      hux = new b("stopMusic", 13, 13);
      huy = new b[] { huk, hul, hum, hun, huo, hup, huq, hur, hus, hut, huu, huv, huw, hux };
      AppMethodBeat.o(150982);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.b
 * JD-Core Version:    0.7.0.1
 */