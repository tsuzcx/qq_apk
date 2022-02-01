package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.cv;
import com.tencent.mm.autogen.mmdata.rpt.cy;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.cc;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "recordChatEmpty", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEmpty;", "getRecordChatEmpty", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEmpty;", "recordChatEnter", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEnter;", "getRecordChatEnter", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEnter;", "recordChatSendClick", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordChatSendClick;", "getRecordChatSendClick", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordChatSendClick;", "recordFinderChatList", "Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "getRecordFinderChatList", "()Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "recordFinderChatListInner", "getRecordFinderChatListInner", "recordFinderChatProfile", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatProfile;", "getRecordFinderChatProfile", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatProfile;", "onChatListExit", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "recordChatClickExpose", "key", "recordChatExpose", "pageSet", "", "structLog", "tag", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "ChatListRecord", "RecordChatSendClick", "RecordFinderChatEmpty", "RecordFinderChatEnter", "RecordFinderChatProfile", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f FnM;
  private static final ba FnN;
  private static final ba FnO;
  private static final e FnP;
  private static final c FnQ;
  private static final d FnR;
  private static final b FnS;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(331426);
    FnM = new f();
    TAG = "FinderChatReporter";
    FnN = new ba();
    FnO = new ba();
    FnP = new e();
    FnQ = new c();
    FnR = new d();
    FnS = new b();
    AppMethodBeat.o(331426);
  }
  
  public static void azG(String paramString)
  {
    AppMethodBeat.i(331416);
    s.u(paramString, "key");
    if (FnO.FuC)
    {
      FnO.azG(paramString);
      AppMethodBeat.o(331416);
      return;
    }
    FnN.azG(paramString);
    AppMethodBeat.o(331416);
  }
  
  public static void e(bui parambui)
  {
    AppMethodBeat.i(331404);
    if (FnO.FuC)
    {
      FnO.h(parambui);
      AppMethodBeat.o(331404);
      return;
    }
    FnN.h(parambui);
    AppMethodBeat.o(331404);
  }
  
  public static ba eMi()
  {
    return FnN;
  }
  
  public static ba eMj()
  {
    return FnO;
  }
  
  public static e eMk()
  {
    return FnP;
  }
  
  public static c eMl()
  {
    return FnQ;
  }
  
  public static d eMm()
  {
    return FnR;
  }
  
  public static b eMn()
  {
    return FnS;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void v(Set<String> paramSet)
  {
    AppMethodBeat.i(331410);
    s.u(paramSet, "pageSet");
    if (FnO.FuC)
    {
      FnO.v(paramSet);
      AppMethodBeat.o(331410);
      return;
    }
    FnN.v(paramSet);
    AppMethodBeat.o(331410);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "", "()V", "accountType", "", "getAccountType", "()J", "setAccountType", "(J)V", "chatSessionId", "", "getChatSessionId", "()Ljava/lang/String;", "setChatSessionId", "(Ljava/lang/String;)V", "enterTimeStamp", "getEnterTimeStamp", "setEnterTimeStamp", "isGreetSession", "setGreetSession", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public long FnT;
    public String FnU = "";
    long FnV;
    long zVt;
    
    public final void azH(String paramString)
    {
      AppMethodBeat.i(331103);
      s.u(paramString, "<set-?>");
      this.FnU = paramString;
      AppMethodBeat.o(331103);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordChatSendClick;", "", "()V", "finderUserNameL", "", "toFinderUsernameL", "toUsernameL", "onClickFinderChat", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "clickScene", "", "result", "chatType", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;JJLjava/lang/Long;)V", "onExpose", "scene", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;JLjava/lang/Long;)V", "setUserInfo", "finderUserName", "toUserName", "toFinderUserName", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private String FnW = "";
    private String FnX = "";
    private String FnY = "";
    
    private void a(bui parambui, long paramLong1, long paramLong2, Long paramLong)
    {
      AppMethodBeat.i(331117);
      cy localcy = new cy();
      localcy.mQ(this.FnW);
      localcy.mR(this.FnX);
      localcy.mS(this.FnY);
      localcy.ila = 2L;
      localcy.iuq = paramLong2;
      localcy.iyh = paramLong1;
      if (parambui != null)
      {
        String str2 = parambui.sessionId;
        str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localcy.mT(str1);
        str1 = parambui.zIB;
        parambui = str1;
        if (str1 == null) {
          parambui = "";
        }
        localcy.mU(parambui);
      }
      String str1 = localcy.inx;
      parambui = str1;
      if (str1 == null) {
        parambui = "";
      }
      localcy.mT(parambui);
      str1 = localcy.ixK;
      parambui = str1;
      if (str1 == null) {
        parambui = "";
      }
      localcy.mU(parambui);
      if (paramLong == null) {}
      for (paramLong1 = 1L;; paramLong1 = paramLong.longValue())
      {
        localcy.iyi = paramLong1;
        localcy.bMH();
        parambui = f.FnM;
        f.a("onClickFinderChat", (a)localcy);
        AppMethodBeat.o(331117);
        return;
      }
    }
    
    private void a(bui parambui, long paramLong, Long paramLong1)
    {
      long l = 1L;
      AppMethodBeat.i(331134);
      cy localcy = new cy();
      localcy.mQ(this.FnW);
      localcy.mR(this.FnX);
      localcy.mS(this.FnY);
      localcy.ila = 1L;
      localcy.iuq = 0L;
      if (parambui != null)
      {
        String str2 = parambui.sessionId;
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localcy.mT(str1);
        str1 = parambui.zIB;
        parambui = str1;
        if (str1 == null) {
          parambui = "";
        }
        localcy.mU(parambui);
      }
      localcy.iyh = paramLong;
      if (paramLong1 == null) {}
      for (paramLong = l;; paramLong = paramLong1.longValue())
      {
        localcy.iyi = paramLong;
        localcy.bMH();
        parambui = f.FnM;
        f.a("onExpose", (a)localcy);
        AppMethodBeat.o(331134);
        return;
      }
    }
    
    public final void ak(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(331148);
      s.u(paramString1, "finderUserName");
      s.u(paramString2, "toUserName");
      s.u(paramString3, "toFinderUserName");
      this.FnW = paramString1;
      this.FnX = paramString2;
      this.FnY = paramString3;
      AppMethodBeat.o(331148);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEmpty;", "", "()V", "accountTypeL", "", "getAccountTypeL", "()J", "setAccountTypeL", "(J)V", "chatListSessionIdL", "", "getChatListSessionIdL", "()Ljava/lang/String;", "setChatListSessionIdL", "(Ljava/lang/String;)V", "onEnterFinderInnerChat", "", "accountType", "onFinderChatEmpty", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "delSessionCount", "resetValues", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public String FnZ = "";
    public long Foa;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatEnter;", "", "()V", "TAG", "", "accountTypeL", "", "asyncExecutor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "chatListSessionidL", "chatNameL", "getChatNameL", "()Ljava/lang/String;", "setChatNameL", "(Ljava/lang/String;)V", "chatSessionidL", "enterTimeStamp", "getEnterTimeStamp", "()J", "setEnterTimeStamp", "(J)V", "newReceiveMsgCountL", "getNewReceiveMsgCountL", "setNewReceiveMsgCountL", "newSendMsgCountL", "getNewSendMsgCountL", "setNewSendMsgCountL", "openChatInfoCountL", "getOpenChatInfoCountL", "setOpenChatInfoCountL", "reddotCountL", "getReddotCountL", "setReddotCountL", "stayDurationL", "getStayDurationL", "setStayDurationL", "talkUserNameL", "incOpenChatInfoCount", "", "onEnterChat", "accountType", "talkUserName", "chatName", "onExitChat", "talker", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fromCommentScene", "sessionId", "clickTabcontextid", "report20691", "startTime", "chatEnterStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderChatEnterStruct;", "resetValues", "setChatListSessionId", "setUnreadCont", "count", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    public long Foa;
    private final MMHandler Fob;
    public String Foc;
    public String Fod;
    public String Foe;
    private long Fof;
    public String Fog;
    public long Foh;
    private long Foi;
    private long Foj;
    public long Fok;
    public final String TAG;
    public long zVt;
    
    public d()
    {
      AppMethodBeat.i(331097);
      this.TAG = "RecordFinderChatEnter";
      this.Fob = new MMHandler(this.TAG);
      this.Foc = "";
      this.Fod = "";
      this.Foe = "";
      this.Fog = "";
      AppMethodBeat.o(331097);
    }
    
    private static final void a(String paramString, long paramLong, cv paramcv, d paramd)
    {
      AppMethodBeat.i(331107);
      s.u(paramString, "$talker");
      s.u(paramcv, "$chatEnterStruct");
      s.u(paramd, "this$0");
      paramString = ((n)h.ax(n.class)).gaZ().j(paramString, paramLong, 2147483647);
      long l1 = 0L;
      paramLong = 0L;
      long l2 = paramLong;
      long l3 = l1;
      if (paramString != null)
      {
        paramString = ((Iterable)paramString).iterator();
        cc localcc;
        do
        {
          l2 = paramLong;
          l3 = l1;
          if (!paramString.hasNext()) {
            break;
          }
          localcc = (cc)paramString.next();
        } while ((localcc.getType() == 570425393) || (localcc.getType() == 10000) || (localcc.getType() == 10001) || (localcc.getType() == 10002));
        switch (localcc.field_isSend)
        {
        }
        for (;;)
        {
          break;
          l1 = 1L + l1;
          break;
          paramLong = 1L + paramLong;
        }
      }
      paramcv.ixQ = l3;
      paramcv.ixR = l2;
      paramcv.bMH();
      paramString = f.FnM;
      f.a(paramd.TAG, (a)paramcv);
      AppMethodBeat.o(331107);
    }
    
    public final void b(String paramString1, long paramLong, String paramString2, String paramString3)
    {
      AppMethodBeat.i(331125);
      s.u(paramString1, "talker");
      cv localcv = new cv();
      localcv.ixH = paramLong;
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      localcv.inx = localcv.F("sessionid", str, true);
      paramString2 = paramString3;
      if (paramString3 == null) {
        paramString2 = "";
      }
      localcv.ixK = localcv.F("clicktabcontextid", paramString2, true);
      localcv.ixI = this.Foa;
      localcv.ixJ = localcv.F("talkerUsername", this.Foc, true);
      localcv.ixM = localcv.F("chatSessionid", this.Foe, true);
      localcv.ixL = localcv.F("chatListSessionid", this.Fod, true);
      localcv.ixN = (cn.bDw() - this.zVt);
      localcv.ixO = localcv.F("chatName", this.Fog, true);
      localcv.ixP = this.Foh;
      localcv.ixS = this.Fok;
      paramLong = this.zVt;
      s.u(paramString1, "talker");
      s.u(localcv, "chatEnterStruct");
      this.Fob.post(new f.d..ExternalSyntheticLambda0(paramString1, paramLong, localcv, this));
      this.Foa = 0L;
      this.Foc = "";
      this.Fod = "";
      this.Foe = "";
      this.Fof = 0L;
      this.Fog = "";
      this.Foh = 0L;
      this.Foi = 0L;
      this.Foj = 0L;
      this.Fok = 0L;
      this.zVt = 0L;
      AppMethodBeat.o(331125);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$RecordFinderChatProfile;", "", "()V", "TAG", "", "accountTypeL", "", "getAccountTypeL", "()J", "setAccountTypeL", "(J)V", "chatNameL", "getChatNameL", "()Ljava/lang/String;", "setChatNameL", "(Ljava/lang/String;)V", "chatSessionidL", "getChatSessionidL", "setChatSessionidL", "clearMsgHistoryClickCountL", "getClearMsgHistoryClickCountL", "setClearMsgHistoryClickCountL", "companionClickCountL", "getCompanionClickCountL", "setCompanionClickCountL", "openChatInfoCountL", "getOpenChatInfoCountL", "setOpenChatInfoCountL", "rejectMsgStatusL", "getRejectMsgStatusL", "setRejectMsgStatusL", "talkUserNameL", "getTalkUserNameL", "setTalkUserNameL", "incChatInfoClickCount", "", "incClearHistoryCount", "incCompanionCount", "onEnterChat", "accountType", "chatName", "talkUserName", "onExitProfile", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "report20692", "resetValues", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
  {
    public long Foa;
    public String Foc = "";
    public String Foe = "";
    public String Fog = "";
    public long Fok;
    public long Fol;
    public long Fom;
    public long Fon;
    public final String TAG = "RecordFinderChatProfile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.f
 * JD-Core Version:    0.7.0.1
 */