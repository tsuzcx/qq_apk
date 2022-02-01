package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.g.b.a.ai;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bu;
import d.g.b.p;
import java.util.Iterator;
import java.util.Set;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "recordChatEmpty", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEmpty;", "getRecordChatEmpty", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEmpty;", "recordChatEnter", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEnter;", "getRecordChatEnter", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEnter;", "recordChatSendClick", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordChatSendClick;", "getRecordChatSendClick", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordChatSendClick;", "recordFinderChatList", "Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "getRecordFinderChatList", "()Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "recordFinderChatListInner", "getRecordFinderChatListInner", "recordFinderChatProfile", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatProfile;", "getRecordFinderChatProfile", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatProfile;", "onChatListExit", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "recordChatClickExpose", "key", "recordChatExpose", "pageSet", "", "structLog", "tag", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "ChatListRecord", "RecordChatSendClick", "RecordFinderChatEmpty", "RecordFinderChatEnter", "RecordFinderChatProfile", "plugin-finder_release"})
public final class b
{
  private static final String TAG = "FinderChatReporter";
  private static final x sne;
  private static final x snf;
  private static final e sng;
  private static final c snh;
  private static final d sni;
  private static final b snj;
  public static final b snk;
  
  static
  {
    AppMethodBeat.i(203198);
    snk = new b();
    TAG = "FinderChatReporter";
    sne = new x();
    snf = new x();
    sng = new e();
    snh = new c();
    sni = new d();
    snj = new b();
    AppMethodBeat.o(203198);
  }
  
  public static void ahJ(String paramString)
  {
    AppMethodBeat.i(203197);
    p.h(paramString, "key");
    if (snf.ssx)
    {
      snf.ahJ(paramString);
      AppMethodBeat.o(203197);
      return;
    }
    sne.ahJ(paramString);
    AppMethodBeat.o(203197);
  }
  
  public static void b(aqy paramaqy)
  {
    AppMethodBeat.i(203195);
    if (snf.ssx)
    {
      snf.e(paramaqy);
      AppMethodBeat.o(203195);
      return;
    }
    sne.e(paramaqy);
    AppMethodBeat.o(203195);
  }
  
  public static x cDj()
  {
    return sne;
  }
  
  public static x cDk()
  {
    return snf;
  }
  
  public static e cDl()
  {
    return sng;
  }
  
  public static c cDm()
  {
    return snh;
  }
  
  public static d cDn()
  {
    return sni;
  }
  
  public static b cDo()
  {
    return snj;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void l(Set<String> paramSet)
  {
    AppMethodBeat.i(203196);
    p.h(paramSet, "pageSet");
    if (snf.ssx)
    {
      snf.l(paramSet);
      AppMethodBeat.o(203196);
      return;
    }
    sne.l(paramSet);
    AppMethodBeat.o(203196);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "", "()V", "accountType", "", "getAccountType", "()J", "setAccountType", "(J)V", "chatSessionId", "", "getChatSessionId", "()Ljava/lang/String;", "setChatSessionId", "(Ljava/lang/String;)V", "enterTimeStamp", "getEnterTimeStamp", "setEnterTimeStamp", "isGreetSession", "setGreetSession", "plugin-finder_release"})
  public static final class a
  {
    public long snl;
    public String snm = "";
    long snn;
    long sno;
    
    public final void ahK(String paramString)
    {
      AppMethodBeat.i(203189);
      p.h(paramString, "<set-?>");
      this.snm = paramString;
      AppMethodBeat.o(203189);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordChatSendClick;", "", "()V", "finderUserNameL", "", "toFinderUsernameL", "toUsernameL", "onClickFinderChat", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "clickScene", "", "result", "onExpose", "scene", "setUserInfo", "finderUserName", "toUserName", "toFinderUserName", "plugin-finder_release"})
  public static final class b
  {
    private String snp = "";
    private String snq = "";
    private String snr = "";
    
    public final void a(aqy paramaqy, long paramLong)
    {
      AppMethodBeat.i(203192);
      ai localai = new ai();
      localai.hi(this.snp);
      localai.hj(this.snq);
      localai.hk(this.snr);
      localai.cG(1L);
      localai.cH(0L);
      if (paramaqy != null)
      {
        String str2 = paramaqy.sessionId;
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localai.hl(str1);
        str1 = paramaqy.qXj;
        paramaqy = str1;
        if (str1 == null) {
          paramaqy = "";
        }
        localai.hm(paramaqy);
      }
      localai.cI(paramLong);
      localai.aLk();
      paramaqy = b.snk;
      b.a("onExpose", (a)localai);
      AppMethodBeat.o(203192);
    }
    
    public final void a(aqy paramaqy, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(203191);
      ai localai = new ai();
      localai.hi(this.snp);
      localai.hj(this.snq);
      localai.hk(this.snr);
      localai.cG(2L);
      localai.cH(paramLong2);
      localai.cI(paramLong1);
      if (paramaqy != null)
      {
        String str2 = paramaqy.sessionId;
        str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localai.hl(str1);
        str1 = paramaqy.qXj;
        paramaqy = str1;
        if (str1 == null) {
          paramaqy = "";
        }
        localai.hm(paramaqy);
      }
      String str1 = localai.RK();
      paramaqy = str1;
      if (str1 == null) {
        paramaqy = "";
      }
      localai.hl(paramaqy);
      str1 = localai.RL();
      paramaqy = str1;
      if (str1 == null) {
        paramaqy = "";
      }
      localai.hm(paramaqy);
      localai.aLk();
      paramaqy = b.snk;
      b.a("onClickFinderChat", (a)localai);
      AppMethodBeat.o(203191);
    }
    
    public final void aa(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(203190);
      p.h(paramString1, "finderUserName");
      p.h(paramString2, "toUserName");
      p.h(paramString3, "toFinderUserName");
      this.snp = paramString1;
      this.snq = paramString2;
      this.snr = paramString3;
      AppMethodBeat.o(203190);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEmpty;", "", "()V", "accountTypeL", "", "getAccountTypeL", "()J", "setAccountTypeL", "(J)V", "chatListSessionIdL", "", "getChatListSessionIdL", "()Ljava/lang/String;", "setChatListSessionIdL", "(Ljava/lang/String;)V", "onEnterFinderInnerChat", "", "accountType", "onFinderChatEmpty", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "delSessionCount", "resetValues", "plugin-finder_release"})
  public static final class c
  {
    public String sns = "";
    public long snt;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEnter;", "", "()V", "TAG", "", "accountTypeL", "", "asyncExecutor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "chatListSessionidL", "chatNameL", "getChatNameL", "()Ljava/lang/String;", "setChatNameL", "(Ljava/lang/String;)V", "chatSessionidL", "enterTimeStamp", "getEnterTimeStamp", "()J", "setEnterTimeStamp", "(J)V", "newReceiveMsgCountL", "getNewReceiveMsgCountL", "setNewReceiveMsgCountL", "newSendMsgCountL", "getNewSendMsgCountL", "setNewSendMsgCountL", "openChatInfoCountL", "getOpenChatInfoCountL", "setOpenChatInfoCountL", "reddotCountL", "getReddotCountL", "setReddotCountL", "stayDurationL", "getStayDurationL", "setStayDurationL", "talkUserNameL", "incOpenChatInfoCount", "", "onEnterChat", "accountType", "talkUserName", "chatName", "onExitChat", "talker", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fromCommentScene", "sessionId", "clickTabcontextid", "report20691", "startTime", "chatEnterStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderChatEnterStruct;", "resetValues", "setChatListSessionId", "setUnreadCont", "count", "plugin-finder_release"})
  public static final class d
  {
    public final String TAG;
    public long snA;
    public long snB;
    public long snC;
    public long snD;
    public long snn;
    public long snt;
    public final ap snu;
    public String snv;
    public String snw;
    public String snx;
    public long sny;
    public String snz;
    
    public d()
    {
      AppMethodBeat.i(203194);
      this.TAG = "RecordFinderChatEnter";
      this.snu = new ap(this.TAG);
      this.snv = "";
      this.snw = "";
      this.snx = "";
      this.snz = "";
      AppMethodBeat.o(203194);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    public static final class a
      implements Runnable
    {
      public a(b.d paramd, String paramString, long paramLong, af paramaf) {}
      
      public final void run()
      {
        AppMethodBeat.i(203193);
        Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
        localObject = ((Iterable)((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).dlK().g(this.snF, this.snG, 2147483647)).iterator();
        long l1 = 0L;
        long l2 = 0L;
        while (((Iterator)localObject).hasNext())
        {
          bu localbu = (bu)((Iterator)localObject).next();
          if ((localbu.getType() != 570425393) && (localbu.getType() != 10000) && (localbu.getType() != 10001) && (localbu.getType() != 10002))
          {
            switch (localbu.VR())
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
        localObject = this.snH;
        ((af)localObject).cu(l2);
        ((af)localObject).cv(l1);
        this.snH.aLk();
        localObject = b.snk;
        b.a(this.snE.TAG, (a)this.snH);
        AppMethodBeat.o(203193);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatProfile;", "", "()V", "TAG", "", "accountTypeL", "", "getAccountTypeL", "()J", "setAccountTypeL", "(J)V", "chatNameL", "getChatNameL", "()Ljava/lang/String;", "setChatNameL", "(Ljava/lang/String;)V", "chatSessionidL", "getChatSessionidL", "setChatSessionidL", "clearMsgHistoryClickCountL", "getClearMsgHistoryClickCountL", "setClearMsgHistoryClickCountL", "companionClickCountL", "getCompanionClickCountL", "setCompanionClickCountL", "openChatInfoCountL", "getOpenChatInfoCountL", "setOpenChatInfoCountL", "rejectMsgStatusL", "getRejectMsgStatusL", "setRejectMsgStatusL", "talkUserNameL", "getTalkUserNameL", "setTalkUserNameL", "incChatInfoClickCount", "", "incClearHistoryCount", "incCompanionCount", "onEnterChat", "accountType", "chatName", "talkUserName", "onExitProfile", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "report20692", "resetValues", "plugin-finder_release"})
  public static final class e
  {
    public final String TAG = "RecordFinderChatProfile";
    public long snD;
    public long snI;
    public long snJ;
    public long snK;
    public long snt;
    public String snv = "";
    public String snx = "";
    public String snz = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.b
 * JD-Core Version:    0.7.0.1
 */