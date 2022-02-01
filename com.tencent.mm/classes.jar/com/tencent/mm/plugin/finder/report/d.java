package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bg;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.Set;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "recordChatEmpty", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEmpty;", "getRecordChatEmpty", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEmpty;", "recordChatEnter", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEnter;", "getRecordChatEnter", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEnter;", "recordChatSendClick", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordChatSendClick;", "getRecordChatSendClick", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordChatSendClick;", "recordFinderChatList", "Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "getRecordFinderChatList", "()Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "recordFinderChatListInner", "getRecordFinderChatListInner", "recordFinderChatProfile", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatProfile;", "getRecordFinderChatProfile", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatProfile;", "onChatListExit", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "recordChatClickExpose", "key", "recordChatExpose", "pageSet", "", "structLog", "tag", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "ChatListRecord", "RecordChatSendClick", "RecordFinderChatEmpty", "RecordFinderChatEnter", "RecordFinderChatProfile", "plugin-finder_release"})
public final class d
{
  private static final String TAG = "FinderChatReporter";
  private static final ai vdj;
  private static final ai vdk;
  private static final e vdl;
  private static final c vdm;
  private static final d vdn;
  private static final b vdo;
  public static final d vdp;
  
  static
  {
    AppMethodBeat.i(250536);
    vdp = new d();
    TAG = "FinderChatReporter";
    vdj = new ai();
    vdk = new ai();
    vdl = new e();
    vdm = new c();
    vdn = new d();
    vdo = new b();
    AppMethodBeat.o(250536);
  }
  
  public static void auB(String paramString)
  {
    AppMethodBeat.i(250535);
    p.h(paramString, "key");
    if (vdk.viM)
    {
      vdk.auB(paramString);
      AppMethodBeat.o(250535);
      return;
    }
    vdj.auB(paramString);
    AppMethodBeat.o(250535);
  }
  
  public static void c(bbn parambbn)
  {
    AppMethodBeat.i(250533);
    if (vdk.viM)
    {
      vdk.f(parambbn);
      AppMethodBeat.o(250533);
      return;
    }
    vdj.f(parambbn);
    AppMethodBeat.o(250533);
  }
  
  public static ai dnF()
  {
    return vdj;
  }
  
  public static ai dnG()
  {
    return vdk;
  }
  
  public static e dnH()
  {
    return vdl;
  }
  
  public static c dnI()
  {
    return vdm;
  }
  
  public static d dnJ()
  {
    return vdn;
  }
  
  public static b dnK()
  {
    return vdo;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void n(Set<String> paramSet)
  {
    AppMethodBeat.i(250534);
    p.h(paramSet, "pageSet");
    if (vdk.viM)
    {
      vdk.n(paramSet);
      AppMethodBeat.o(250534);
      return;
    }
    vdj.n(paramSet);
    AppMethodBeat.o(250534);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "", "()V", "accountType", "", "getAccountType", "()J", "setAccountType", "(J)V", "chatSessionId", "", "getChatSessionId", "()Ljava/lang/String;", "setChatSessionId", "(Ljava/lang/String;)V", "enterTimeStamp", "getEnterTimeStamp", "setEnterTimeStamp", "isGreetSession", "setGreetSession", "plugin-finder_release"})
  public static final class a
  {
    long sTp;
    public long vdq;
    public String vdr = "";
    long vds;
    
    public final void auC(String paramString)
    {
      AppMethodBeat.i(250527);
      p.h(paramString, "<set-?>");
      this.vdr = paramString;
      AppMethodBeat.o(250527);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordChatSendClick;", "", "()V", "finderUserNameL", "", "toFinderUsernameL", "toUsernameL", "onClickFinderChat", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "clickScene", "", "result", "onExpose", "scene", "setUserInfo", "finderUserName", "toUserName", "toFinderUserName", "plugin-finder_release"})
  public static final class b
  {
    private String vdt = "";
    private String vdu = "";
    private String vdv = "";
    
    public final void a(bbn parambbn, long paramLong)
    {
      AppMethodBeat.i(250530);
      bj localbj = new bj();
      localbj.jj(this.vdt);
      localbj.jk(this.vdu);
      localbj.jl(this.vdv);
      localbj.dI(1L);
      localbj.dJ(0L);
      if (parambbn != null)
      {
        String str2 = parambbn.sessionId;
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localbj.jm(str1);
        str1 = parambbn.sGE;
        parambbn = str1;
        if (str1 == null) {
          parambbn = "";
        }
        localbj.jn(parambbn);
      }
      localbj.dK(paramLong);
      localbj.bfK();
      parambbn = d.vdp;
      d.a("onExpose", (a)localbj);
      AppMethodBeat.o(250530);
    }
    
    public final void a(bbn parambbn, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(250529);
      bj localbj = new bj();
      localbj.jj(this.vdt);
      localbj.jk(this.vdu);
      localbj.jl(this.vdv);
      localbj.dI(2L);
      localbj.dJ(paramLong2);
      localbj.dK(paramLong1);
      if (parambbn != null)
      {
        String str2 = parambbn.sessionId;
        str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localbj.jm(str1);
        str1 = parambbn.sGE;
        parambbn = str1;
        if (str1 == null) {
          parambbn = "";
        }
        localbj.jn(parambbn);
      }
      String str1 = localbj.acA();
      parambbn = str1;
      if (str1 == null) {
        parambbn = "";
      }
      localbj.jm(parambbn);
      str1 = localbj.acB();
      parambbn = str1;
      if (str1 == null) {
        parambbn = "";
      }
      localbj.jn(parambbn);
      localbj.bfK();
      parambbn = d.vdp;
      d.a("onClickFinderChat", (a)localbj);
      AppMethodBeat.o(250529);
    }
    
    public final void ah(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(250528);
      p.h(paramString1, "finderUserName");
      p.h(paramString2, "toUserName");
      p.h(paramString3, "toFinderUserName");
      this.vdt = paramString1;
      this.vdu = paramString2;
      this.vdv = paramString3;
      AppMethodBeat.o(250528);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEmpty;", "", "()V", "accountTypeL", "", "getAccountTypeL", "()J", "setAccountTypeL", "(J)V", "chatListSessionIdL", "", "getChatListSessionIdL", "()Ljava/lang/String;", "setChatListSessionIdL", "(Ljava/lang/String;)V", "onEnterFinderInnerChat", "", "accountType", "onFinderChatEmpty", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "delSessionCount", "resetValues", "plugin-finder_release"})
  public static final class c
  {
    public String vdw = "";
    public long vdx;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEnter;", "", "()V", "TAG", "", "accountTypeL", "", "asyncExecutor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "chatListSessionidL", "chatNameL", "getChatNameL", "()Ljava/lang/String;", "setChatNameL", "(Ljava/lang/String;)V", "chatSessionidL", "enterTimeStamp", "getEnterTimeStamp", "()J", "setEnterTimeStamp", "(J)V", "newReceiveMsgCountL", "getNewReceiveMsgCountL", "setNewReceiveMsgCountL", "newSendMsgCountL", "getNewSendMsgCountL", "setNewSendMsgCountL", "openChatInfoCountL", "getOpenChatInfoCountL", "setOpenChatInfoCountL", "reddotCountL", "getReddotCountL", "setReddotCountL", "stayDurationL", "getStayDurationL", "setStayDurationL", "talkUserNameL", "incOpenChatInfoCount", "", "onEnterChat", "accountType", "talkUserName", "chatName", "onExitChat", "talker", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fromCommentScene", "sessionId", "clickTabcontextid", "report20691", "startTime", "chatEnterStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderChatEnterStruct;", "resetValues", "setChatListSessionId", "setUnreadCont", "count", "plugin-finder_release"})
  public static final class d
  {
    public final String TAG;
    public long sTp;
    public String vdA;
    public String vdB;
    public long vdC;
    public String vdD;
    public long vdE;
    public long vdF;
    public long vdG;
    public long vdH;
    public long vdx;
    public final MMHandler vdy;
    public String vdz;
    
    public d()
    {
      AppMethodBeat.i(250532);
      this.TAG = "RecordFinderChatEnter";
      this.vdy = new MMHandler(this.TAG);
      this.vdz = "";
      this.vdA = "";
      this.vdB = "";
      this.vdD = "";
      AppMethodBeat.o(250532);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    public static final class a
      implements Runnable
    {
      public a(d.d paramd, String paramString, long paramLong, bg parambg) {}
      
      public final void run()
      {
        AppMethodBeat.i(250531);
        Object localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
        localObject = ((Iterable)((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).eiy().g(this.vdJ, this.qVz, 2147483647)).iterator();
        long l1 = 0L;
        long l2 = 0L;
        while (((Iterator)localObject).hasNext())
        {
          ca localca = (ca)((Iterator)localObject).next();
          if ((localca.getType() != 570425393) && (localca.getType() != 10000) && (localca.getType() != 10001) && (localca.getType() != 10002))
          {
            switch (localca.ajN())
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
        localObject = this.vdK;
        ((bg)localObject).dw(l2);
        ((bg)localObject).dx(l1);
        this.vdK.bfK();
        localObject = d.vdp;
        d.a(this.vdI.TAG, (a)this.vdK);
        AppMethodBeat.o(250531);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatProfile;", "", "()V", "TAG", "", "accountTypeL", "", "getAccountTypeL", "()J", "setAccountTypeL", "(J)V", "chatNameL", "getChatNameL", "()Ljava/lang/String;", "setChatNameL", "(Ljava/lang/String;)V", "chatSessionidL", "getChatSessionidL", "setChatSessionidL", "clearMsgHistoryClickCountL", "getClearMsgHistoryClickCountL", "setClearMsgHistoryClickCountL", "companionClickCountL", "getCompanionClickCountL", "setCompanionClickCountL", "openChatInfoCountL", "getOpenChatInfoCountL", "setOpenChatInfoCountL", "rejectMsgStatusL", "getRejectMsgStatusL", "setRejectMsgStatusL", "talkUserNameL", "getTalkUserNameL", "setTalkUserNameL", "incChatInfoClickCount", "", "incClearHistoryCount", "incCompanionCount", "onEnterChat", "accountType", "chatName", "talkUserName", "onExitProfile", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "report20692", "resetValues", "plugin-finder_release"})
  public static final class e
  {
    public final String TAG = "RecordFinderChatProfile";
    public String vdB = "";
    public String vdD = "";
    public long vdH;
    public long vdL;
    public long vdM;
    public long vdN;
    public long vdx;
    public String vdz = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.d
 * JD-Core Version:    0.7.0.1
 */