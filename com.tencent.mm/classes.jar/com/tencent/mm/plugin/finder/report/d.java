package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.bw;
import com.tencent.mm.f.b.a.bz;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "recordChatEmpty", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEmpty;", "getRecordChatEmpty", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEmpty;", "recordChatEnter", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEnter;", "getRecordChatEnter", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEnter;", "recordChatSendClick", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordChatSendClick;", "getRecordChatSendClick", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordChatSendClick;", "recordFinderChatList", "Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "getRecordFinderChatList", "()Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "recordFinderChatListInner", "getRecordFinderChatListInner", "recordFinderChatProfile", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatProfile;", "getRecordFinderChatProfile", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatProfile;", "onChatListExit", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "recordChatClickExpose", "key", "recordChatExpose", "pageSet", "", "structLog", "tag", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "ChatListRecord", "RecordChatSendClick", "RecordFinderChatEmpty", "RecordFinderChatEnter", "RecordFinderChatProfile", "plugin-finder_release"})
public final class d
{
  private static final String TAG = "FinderChatReporter";
  private static final al zUa;
  private static final al zUb;
  private static final e zUc;
  private static final c zUd;
  private static final d zUe;
  private static final b zUf;
  public static final d zUg;
  
  static
  {
    AppMethodBeat.i(276632);
    zUg = new d();
    TAG = "FinderChatReporter";
    zUa = new al();
    zUb = new al();
    zUc = new e();
    zUd = new c();
    zUe = new d();
    zUf = new b();
    AppMethodBeat.o(276632);
  }
  
  public static void aDT(String paramString)
  {
    AppMethodBeat.i(276631);
    p.k(paramString, "key");
    if (zUb.zZF)
    {
      zUb.aDT(paramString);
      AppMethodBeat.o(276631);
      return;
    }
    zUa.aDT(paramString);
    AppMethodBeat.o(276631);
  }
  
  public static al dPc()
  {
    return zUa;
  }
  
  public static al dPd()
  {
    return zUb;
  }
  
  public static e dPe()
  {
    return zUc;
  }
  
  public static c dPf()
  {
    return zUd;
  }
  
  public static d dPg()
  {
    return zUe;
  }
  
  public static b dPh()
  {
    return zUf;
  }
  
  public static void e(bid parambid)
  {
    AppMethodBeat.i(276629);
    if (zUb.zZF)
    {
      zUb.h(parambid);
      AppMethodBeat.o(276629);
      return;
    }
    zUa.h(parambid);
    AppMethodBeat.o(276629);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void n(Set<String> paramSet)
  {
    AppMethodBeat.i(276630);
    p.k(paramSet, "pageSet");
    if (zUb.zZF)
    {
      zUb.n(paramSet);
      AppMethodBeat.o(276630);
      return;
    }
    zUa.n(paramSet);
    AppMethodBeat.o(276630);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "", "()V", "accountType", "", "getAccountType", "()J", "setAccountType", "(J)V", "chatSessionId", "", "getChatSessionId", "()Ljava/lang/String;", "setChatSessionId", "(Ljava/lang/String;)V", "enterTimeStamp", "getEnterTimeStamp", "setEnterTimeStamp", "isGreetSession", "setGreetSession", "plugin-finder_release"})
  public static final class a
  {
    long wzm;
    public long zUh;
    public String zUi = "";
    long zUj;
    
    public final void aDU(String paramString)
    {
      AppMethodBeat.i(285324);
      p.k(paramString, "<set-?>");
      this.zUi = paramString;
      AppMethodBeat.o(285324);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordChatSendClick;", "", "()V", "finderUserNameL", "", "toFinderUsernameL", "toUsernameL", "onClickFinderChat", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "clickScene", "", "result", "onExpose", "scene", "setUserInfo", "finderUserName", "toUserName", "toFinderUserName", "plugin-finder_release"})
  public static final class b
  {
    private String zUk = "";
    private String zUl = "";
    private String zUm = "";
    
    public final void a(bid parambid, long paramLong)
    {
      AppMethodBeat.i(262299);
      bz localbz = new bz();
      localbz.lt(this.zUk);
      localbz.lu(this.zUl);
      localbz.lv(this.zUm);
      localbz.ew(1L);
      localbz.ex(0L);
      if (parambid != null)
      {
        String str2 = parambid.sessionId;
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localbz.lw(str1);
        str1 = parambid.wmz;
        parambid = str1;
        if (str1 == null) {
          parambid = "";
        }
        localbz.lx(parambid);
      }
      localbz.ey(paramLong);
      localbz.bpa();
      parambid = d.zUg;
      d.a("onExpose", (a)localbz);
      AppMethodBeat.o(262299);
    }
    
    public final void a(bid parambid, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(262297);
      bz localbz = new bz();
      localbz.lt(this.zUk);
      localbz.lu(this.zUl);
      localbz.lv(this.zUm);
      localbz.ew(2L);
      localbz.ex(paramLong2);
      localbz.ey(paramLong1);
      if (parambid != null)
      {
        String str2 = parambid.sessionId;
        str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localbz.lw(str1);
        str1 = parambid.wmz;
        parambid = str1;
        if (str1 == null) {
          parambid = "";
        }
        localbz.lx(parambid);
      }
      String str1 = localbz.ahq();
      parambid = str1;
      if (str1 == null) {
        parambid = "";
      }
      localbz.lw(parambid);
      str1 = localbz.ahr();
      parambid = str1;
      if (str1 == null) {
        parambid = "";
      }
      localbz.lx(parambid);
      localbz.bpa();
      parambid = d.zUg;
      d.a("onClickFinderChat", (a)localbz);
      AppMethodBeat.o(262297);
    }
    
    public final void ae(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(262294);
      p.k(paramString1, "finderUserName");
      p.k(paramString2, "toUserName");
      p.k(paramString3, "toFinderUserName");
      this.zUk = paramString1;
      this.zUl = paramString2;
      this.zUm = paramString3;
      AppMethodBeat.o(262294);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEmpty;", "", "()V", "accountTypeL", "", "getAccountTypeL", "()J", "setAccountTypeL", "(J)V", "chatListSessionIdL", "", "getChatListSessionIdL", "()Ljava/lang/String;", "setChatListSessionIdL", "(Ljava/lang/String;)V", "onEnterFinderInnerChat", "", "accountType", "onFinderChatEmpty", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "delSessionCount", "resetValues", "plugin-finder_release"})
  public static final class c
  {
    public String zUn = "";
    public long zUo;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEnter;", "", "()V", "TAG", "", "accountTypeL", "", "asyncExecutor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "chatListSessionidL", "chatNameL", "getChatNameL", "()Ljava/lang/String;", "setChatNameL", "(Ljava/lang/String;)V", "chatSessionidL", "enterTimeStamp", "getEnterTimeStamp", "()J", "setEnterTimeStamp", "(J)V", "newReceiveMsgCountL", "getNewReceiveMsgCountL", "setNewReceiveMsgCountL", "newSendMsgCountL", "getNewSendMsgCountL", "setNewSendMsgCountL", "openChatInfoCountL", "getOpenChatInfoCountL", "setOpenChatInfoCountL", "reddotCountL", "getReddotCountL", "setReddotCountL", "stayDurationL", "getStayDurationL", "setStayDurationL", "talkUserNameL", "incOpenChatInfoCount", "", "onEnterChat", "accountType", "talkUserName", "chatName", "onExitChat", "talker", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fromCommentScene", "sessionId", "clickTabcontextid", "report20691", "startTime", "chatEnterStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderChatEnterStruct;", "resetValues", "setChatListSessionId", "setUnreadCont", "count", "plugin-finder_release"})
  public static final class d
  {
    public final String TAG;
    public long wzm;
    public long zUo;
    public final MMHandler zUp;
    public String zUq;
    public String zUr;
    public String zUs;
    public long zUt;
    public String zUu;
    public long zUv;
    public long zUw;
    public long zUx;
    public long zUy;
    
    public d()
    {
      AppMethodBeat.i(270062);
      this.TAG = "RecordFinderChatEnter";
      this.zUp = new MMHandler(this.TAG);
      this.zUq = "";
      this.zUr = "";
      this.zUs = "";
      this.zUu = "";
      AppMethodBeat.o(270062);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    public static final class a
      implements Runnable
    {
      public a(d.d paramd, String paramString, long paramLong, bw parambw) {}
      
      public final void run()
      {
        AppMethodBeat.i(275239);
        Object localObject = h.ae(n.class);
        p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
        localObject = ((Iterable)((n)localObject).eSe().h(this.sJQ, this.uyk, 2147483647)).iterator();
        long l1 = 0L;
        long l2 = 0L;
        while (((Iterator)localObject).hasNext())
        {
          ca localca = (ca)((Iterator)localObject).next();
          if ((localca.getType() != 570425393) && (localca.getType() != 10000) && (localca.getType() != 10001) && (localca.getType() != 10002))
          {
            switch (localca.apA())
            {
            }
            for (;;)
            {
              break;
              l2 += 1L;
              break;
              l1 += 1L;
            }
          }
        }
        localObject = this.zUA;
        ((bw)localObject).ek(l2);
        ((bw)localObject).el(l1);
        this.zUA.bpa();
        localObject = d.zUg;
        d.a(this.zUz.TAG, (a)this.zUA);
        AppMethodBeat.o(275239);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatProfile;", "", "()V", "TAG", "", "accountTypeL", "", "getAccountTypeL", "()J", "setAccountTypeL", "(J)V", "chatNameL", "getChatNameL", "()Ljava/lang/String;", "setChatNameL", "(Ljava/lang/String;)V", "chatSessionidL", "getChatSessionidL", "setChatSessionidL", "clearMsgHistoryClickCountL", "getClearMsgHistoryClickCountL", "setClearMsgHistoryClickCountL", "companionClickCountL", "getCompanionClickCountL", "setCompanionClickCountL", "openChatInfoCountL", "getOpenChatInfoCountL", "setOpenChatInfoCountL", "rejectMsgStatusL", "getRejectMsgStatusL", "setRejectMsgStatusL", "talkUserNameL", "getTalkUserNameL", "setTalkUserNameL", "incChatInfoClickCount", "", "incClearHistoryCount", "incCompanionCount", "onEnterChat", "accountType", "chatName", "talkUserName", "onExitProfile", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "report20692", "resetValues", "plugin-finder_release"})
  public static final class e
  {
    public final String TAG = "RecordFinderChatProfile";
    public long zUB;
    public long zUC;
    public long zUD;
    public long zUo;
    public String zUq = "";
    public String zUs = "";
    public String zUu = "";
    public long zUy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.d
 * JD-Core Version:    0.7.0.1
 */