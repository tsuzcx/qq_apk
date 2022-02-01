package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.g.b.a.ai;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bv;
import d.g.b.p;
import java.util.Iterator;
import java.util.Set;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "recordChatEmpty", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEmpty;", "getRecordChatEmpty", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEmpty;", "recordChatEnter", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEnter;", "getRecordChatEnter", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEnter;", "recordChatSendClick", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordChatSendClick;", "getRecordChatSendClick", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordChatSendClick;", "recordFinderChatList", "Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "getRecordFinderChatList", "()Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "recordFinderChatListInner", "getRecordFinderChatListInner", "recordFinderChatProfile", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatProfile;", "getRecordFinderChatProfile", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatProfile;", "onChatListExit", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "recordChatClickExpose", "key", "recordChatExpose", "pageSet", "", "structLog", "tag", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "ChatListRecord", "RecordChatSendClick", "RecordFinderChatEmpty", "RecordFinderChatEnter", "RecordFinderChatProfile", "plugin-finder_release"})
public final class b
{
  private static final String TAG = "FinderChatReporter";
  private static final y swV;
  private static final y swW;
  private static final e swX;
  private static final c swY;
  private static final d swZ;
  private static final b sxa;
  public static final b sxb;
  
  static
  {
    AppMethodBeat.i(203739);
    sxb = new b();
    TAG = "FinderChatReporter";
    swV = new y();
    swW = new y();
    swX = new e();
    swY = new c();
    swZ = new d();
    sxa = new b();
    AppMethodBeat.o(203739);
  }
  
  public static void aiH(String paramString)
  {
    AppMethodBeat.i(203738);
    p.h(paramString, "key");
    if (swW.sCH)
    {
      swW.aiH(paramString);
      AppMethodBeat.o(203738);
      return;
    }
    swV.aiH(paramString);
    AppMethodBeat.o(203738);
  }
  
  public static void b(arn paramarn)
  {
    AppMethodBeat.i(203736);
    if (swW.sCH)
    {
      swW.e(paramarn);
      AppMethodBeat.o(203736);
      return;
    }
    swV.e(paramarn);
    AppMethodBeat.o(203736);
  }
  
  public static y cFb()
  {
    return swV;
  }
  
  public static y cFc()
  {
    return swW;
  }
  
  public static e cFd()
  {
    return swX;
  }
  
  public static c cFe()
  {
    return swY;
  }
  
  public static d cFf()
  {
    return swZ;
  }
  
  public static b cFg()
  {
    return sxa;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void l(Set<String> paramSet)
  {
    AppMethodBeat.i(203737);
    p.h(paramSet, "pageSet");
    if (swW.sCH)
    {
      swW.l(paramSet);
      AppMethodBeat.o(203737);
      return;
    }
    swV.l(paramSet);
    AppMethodBeat.o(203737);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "", "()V", "accountType", "", "getAccountType", "()J", "setAccountType", "(J)V", "chatSessionId", "", "getChatSessionId", "()Ljava/lang/String;", "setChatSessionId", "(Ljava/lang/String;)V", "enterTimeStamp", "getEnterTimeStamp", "setEnterTimeStamp", "isGreetSession", "setGreetSession", "plugin-finder_release"})
  public static final class a
  {
    public long sxc;
    public String sxd = "";
    long sxe;
    long sxf;
    
    public final void aiI(String paramString)
    {
      AppMethodBeat.i(203730);
      p.h(paramString, "<set-?>");
      this.sxd = paramString;
      AppMethodBeat.o(203730);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordChatSendClick;", "", "()V", "finderUserNameL", "", "toFinderUsernameL", "toUsernameL", "onClickFinderChat", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "clickScene", "", "result", "onExpose", "scene", "setUserInfo", "finderUserName", "toUserName", "toFinderUserName", "plugin-finder_release"})
  public static final class b
  {
    private String sxg = "";
    private String sxh = "";
    private String sxi = "";
    
    public final void a(arn paramarn, long paramLong)
    {
      AppMethodBeat.i(203733);
      ai localai = new ai();
      localai.ho(this.sxg);
      localai.hp(this.sxh);
      localai.hq(this.sxi);
      localai.cG(1L);
      localai.cH(0L);
      if (paramarn != null)
      {
        String str2 = paramarn.sessionId;
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localai.hr(str1);
        str1 = paramarn.rfo;
        paramarn = str1;
        if (str1 == null) {
          paramarn = "";
        }
        localai.hs(paramarn);
      }
      localai.cI(paramLong);
      localai.aLH();
      paramarn = b.sxb;
      b.a("onExpose", (a)localai);
      AppMethodBeat.o(203733);
    }
    
    public final void a(arn paramarn, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(203732);
      ai localai = new ai();
      localai.ho(this.sxg);
      localai.hp(this.sxh);
      localai.hq(this.sxi);
      localai.cG(2L);
      localai.cH(paramLong2);
      localai.cI(paramLong1);
      if (paramarn != null)
      {
        String str2 = paramarn.sessionId;
        str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localai.hr(str1);
        str1 = paramarn.rfo;
        paramarn = str1;
        if (str1 == null) {
          paramarn = "";
        }
        localai.hs(paramarn);
      }
      String str1 = localai.RJ();
      paramarn = str1;
      if (str1 == null) {
        paramarn = "";
      }
      localai.hr(paramarn);
      str1 = localai.RK();
      paramarn = str1;
      if (str1 == null) {
        paramarn = "";
      }
      localai.hs(paramarn);
      localai.aLH();
      paramarn = b.sxb;
      b.a("onClickFinderChat", (a)localai);
      AppMethodBeat.o(203732);
    }
    
    public final void ab(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(203731);
      p.h(paramString1, "finderUserName");
      p.h(paramString2, "toUserName");
      p.h(paramString3, "toFinderUserName");
      this.sxg = paramString1;
      this.sxh = paramString2;
      this.sxi = paramString3;
      AppMethodBeat.o(203731);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEmpty;", "", "()V", "accountTypeL", "", "getAccountTypeL", "()J", "setAccountTypeL", "(J)V", "chatListSessionIdL", "", "getChatListSessionIdL", "()Ljava/lang/String;", "setChatListSessionIdL", "(Ljava/lang/String;)V", "onEnterFinderInnerChat", "", "accountType", "onFinderChatEmpty", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "delSessionCount", "resetValues", "plugin-finder_release"})
  public static final class c
  {
    public String sxj = "";
    public long sxk;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEnter;", "", "()V", "TAG", "", "accountTypeL", "", "asyncExecutor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "chatListSessionidL", "chatNameL", "getChatNameL", "()Ljava/lang/String;", "setChatNameL", "(Ljava/lang/String;)V", "chatSessionidL", "enterTimeStamp", "getEnterTimeStamp", "()J", "setEnterTimeStamp", "(J)V", "newReceiveMsgCountL", "getNewReceiveMsgCountL", "setNewReceiveMsgCountL", "newSendMsgCountL", "getNewSendMsgCountL", "setNewSendMsgCountL", "openChatInfoCountL", "getOpenChatInfoCountL", "setOpenChatInfoCountL", "reddotCountL", "getReddotCountL", "setReddotCountL", "stayDurationL", "getStayDurationL", "setStayDurationL", "talkUserNameL", "incOpenChatInfoCount", "", "onEnterChat", "accountType", "talkUserName", "chatName", "onExitChat", "talker", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fromCommentScene", "sessionId", "clickTabcontextid", "report20691", "startTime", "chatEnterStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderChatEnterStruct;", "resetValues", "setChatListSessionId", "setUnreadCont", "count", "plugin-finder_release"})
  public static final class d
  {
    public final String TAG;
    public long sxe;
    public long sxk;
    public final aq sxl;
    public String sxm;
    public String sxn;
    public String sxo;
    public long sxp;
    public String sxq;
    public long sxr;
    public long sxs;
    public long sxt;
    public long sxu;
    
    public d()
    {
      AppMethodBeat.i(203735);
      this.TAG = "RecordFinderChatEnter";
      this.sxl = new aq(this.TAG);
      this.sxm = "";
      this.sxn = "";
      this.sxo = "";
      this.sxq = "";
      AppMethodBeat.o(203735);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    public static final class a
      implements Runnable
    {
      public a(b.d paramd, String paramString, long paramLong, af paramaf) {}
      
      public final void run()
      {
        AppMethodBeat.i(203734);
        Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
        localObject = ((Iterable)((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).doJ().g(this.sxw, this.sxx, 2147483647)).iterator();
        long l1 = 0L;
        long l2 = 0L;
        while (((Iterator)localObject).hasNext())
        {
          bv localbv = (bv)((Iterator)localObject).next();
          if ((localbv.getType() != 570425393) && (localbv.getType() != 10000) && (localbv.getType() != 10001) && (localbv.getType() != 10002))
          {
            switch (localbv.VZ())
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
        localObject = this.sxy;
        ((af)localObject).cu(l2);
        ((af)localObject).cv(l1);
        this.sxy.aLH();
        localObject = b.sxb;
        b.a(this.sxv.TAG, (a)this.sxy);
        AppMethodBeat.o(203734);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatProfile;", "", "()V", "TAG", "", "accountTypeL", "", "getAccountTypeL", "()J", "setAccountTypeL", "(J)V", "chatNameL", "getChatNameL", "()Ljava/lang/String;", "setChatNameL", "(Ljava/lang/String;)V", "chatSessionidL", "getChatSessionidL", "setChatSessionidL", "clearMsgHistoryClickCountL", "getClearMsgHistoryClickCountL", "setClearMsgHistoryClickCountL", "companionClickCountL", "getCompanionClickCountL", "setCompanionClickCountL", "openChatInfoCountL", "getOpenChatInfoCountL", "setOpenChatInfoCountL", "rejectMsgStatusL", "getRejectMsgStatusL", "setRejectMsgStatusL", "talkUserNameL", "getTalkUserNameL", "setTalkUserNameL", "incChatInfoClickCount", "", "incClearHistoryCount", "incCompanionCount", "onEnterChat", "accountType", "chatName", "talkUserName", "onExitProfile", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "report20692", "resetValues", "plugin-finder_release"})
  public static final class e
  {
    public final String TAG = "RecordFinderChatProfile";
    public long sxA;
    public long sxB;
    public long sxk;
    public String sxm = "";
    public String sxo = "";
    public String sxq = "";
    public long sxu;
    public long sxz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.b
 * JD-Core Version:    0.7.0.1
 */