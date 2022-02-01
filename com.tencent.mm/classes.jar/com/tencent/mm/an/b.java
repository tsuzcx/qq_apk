package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.b.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.threadpool.i;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelbiz/BizChattingItemReportHelper;", "", "()V", "TAG", "", "reportCache", "Lcom/tencent/mm/algorithm/LRUMap;", "", "doReportBizServiceMsgClick", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "enterTime", "doReportServiceMsgExpose", "talker", "Lcom/tencent/mm/storage/Contact;", "position", "", "msgCount", "fillReportMsgSendType", "reportInfo", "Lcom/tencent/mm/modelbiz/BizChattingItemReportHelper$BizServiceMsgReportInfo;", "fillReportMsgType", "reportBizServiceMsgClick", "reportServiceMsgExpose", "BizServiceMsgReportInfo", "BizServiceMsgSendType", "BizServiceMsgType", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b ovJ;
  private static final f<Long, Long> ovK;
  
  static
  {
    AppMethodBeat.i(239487);
    ovJ = new b();
    ovK = (f)new com.tencent.mm.b.h(20);
    AppMethodBeat.o(239487);
  }
  
  public static final void a(au paramau, cc paramcc, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(239470);
    s.u(paramau, "talker");
    s.u(paramcc, "msg");
    try
    {
      long l = System.currentTimeMillis();
      if (ovK.get(Long.valueOf(paramcc.field_msgId)) != null)
      {
        Object localObject = ovK.get(Long.valueOf(paramcc.field_msgId));
        s.s(localObject, "reportCache[msg.msgId]");
        if (l - ((Number)localObject).longValue() < 1000L)
        {
          AppMethodBeat.o(239470);
          return;
        }
      }
      ovK.put(Long.valueOf(paramcc.field_msgId), Long.valueOf(l));
      com.tencent.threadpool.h.ahAA.g(new b..ExternalSyntheticLambda0(paramau, paramcc, paramInt1, paramInt2, paramLong), "BizServicesReportThread");
      AppMethodBeat.o(239470);
      return;
    }
    catch (Exception paramau)
    {
      Log.printErrStackTrace("MicroMsg.BizChattingItemReportHelper", (Throwable)paramau, "reportServiceMsgExpose exception", new Object[0]);
      AppMethodBeat.o(239470);
    }
  }
  
  public static final void a(cc paramcc, long paramLong)
  {
    AppMethodBeat.i(239473);
    if (paramcc == null)
    {
      AppMethodBeat.o(239473);
      return;
    }
    if (paramcc.field_isSend == 1)
    {
      AppMethodBeat.o(239473);
      return;
    }
    com.tencent.threadpool.h.ahAA.bo(new b..ExternalSyntheticLambda1(paramcc, paramLong));
    AppMethodBeat.o(239473);
  }
  
  private static void a(cc paramcc, a parama)
  {
    AppMethodBeat.i(239477);
    parama.olT = paramcc.kLu;
    String str2 = paramcc.kLo;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    s.u(str1, "<set-?>");
    parama.olS = str1;
    if (paramcc.iYl())
    {
      parama.ovL = 1;
      parama.ovN = true;
      if (((CharSequence)parama.url).length() <= 0) {
        break label414;
      }
    }
    label414:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramcc = aa.aUC(parama.url);
        s.s(paramcc, "doUrlEncode(reportInfo.url)");
        parama.setUrl(paramcc);
      }
      AppMethodBeat.o(239477);
      return;
      if (paramcc.iYj())
      {
        parama.ovL = 9;
        parama.ovN = true;
        break;
      }
      if (paramcc.iYk())
      {
        parama.ovL = 2;
        parama.ovN = true;
        break;
      }
      if (paramcc.dSH())
      {
        parama.ovL = 5;
        parama.ovN = true;
        break;
      }
      if ((paramcc.getType() == 452984881) || (paramcc.getType() == 520093745))
      {
        parama.ovL = 6;
        parama.ovN = false;
        break;
      }
      if (paramcc.iYe())
      {
        parama.ovL = 3;
        parama.ovN = false;
        paramcc = ((a)com.tencent.mm.kernel.h.ax(a.class)).c(paramcc.field_msgId, paramcc.field_content);
        if ((paramcc == null) || (Util.isNullOrNil((List)paramcc.nUC))) {
          break;
        }
        paramcc = ((v)paramcc.nUC.get(0)).url;
        s.s(paramcc, "reader.items[0].url");
        parama.setUrl(paramcc);
        break;
      }
      if ((!paramcc.fxR()) || (paramcc.field_content == null)) {
        break;
      }
      parama.ovN = false;
      paramcc = k.b.Hf(paramcc.field_content);
      if (paramcc == null) {
        break;
      }
      if ((paramcc.type == 33) || (paramcc.type == 36))
      {
        parama.ovL = 4;
        str1 = paramcc.url;
        s.s(str1, "content.url");
        parama.setUrl(str1);
        paramcc = paramcc.nTE;
        s.s(paramcc, "content.appbrandAppId");
        s.u(paramcc, "<set-?>");
        parama.extraInfo = paramcc;
        break;
      }
      if (paramcc.type == 5)
      {
        parama.ovL = 7;
        break;
      }
      if (paramcc.type != 3) {
        break;
      }
      parama.ovL = 8;
      break;
    }
  }
  
  private static final void b(au paramau, cc paramcc, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(239480);
    s.u(paramau, "$talker");
    s.u(paramcc, "$msg");
    paramInt1 = paramInt2 - paramInt1 - 1;
    a locala = new a();
    a(paramcc, locala);
    b(paramcc, locala);
    if (locala.ovL > 0)
    {
      Log.d("MicroMsg.BizChattingItemReportHelper", "doReportServiceMsgExpose username: %s, msg raw Type: %d, url: %s, revertPos: %s, createTime: %s, enterTime: %s, reportMsgType: %d, sendType: %s, msgSvrId: %s, extraInfo: %s", new Object[] { paramau.field_username, Integer.valueOf(paramcc.getType()), locala.url, Integer.valueOf(paramInt1), Long.valueOf(paramcc.getCreateTime()), Long.valueOf(paramLong), Integer.valueOf(locala.ovL), Integer.valueOf(locala.ovM), Long.valueOf(paramcc.field_msgSvrId), locala.extraInfo });
      com.tencent.mm.plugin.report.service.h.OAn.b(19202, new Object[] { paramau.field_username, Integer.valueOf(locala.ovL), locala.url, Integer.valueOf(1), Integer.valueOf(paramInt1), Long.valueOf(paramcc.getCreateTime()), Long.valueOf(paramLong), Integer.valueOf(locala.ovM), Long.valueOf(paramcc.field_msgSvrId) });
    }
    AppMethodBeat.o(239480);
  }
  
  private static final void b(cc paramcc, long paramLong)
  {
    AppMethodBeat.i(239483);
    if (g.Mw(paramcc.field_talker))
    {
      a locala = new a();
      b(paramcc, locala);
      a(paramcc, locala);
      if (locala.ovL > 0)
      {
        Log.d("MicroMsg.BizChattingItemReportHelper", "alvinluo doReportBizServiceMsgClick msg raw type: %d, enterTime: %d, kfWorker: %s, kfType: %d, talker: %s, reportMsgType: %d, sendType: %d, msgSvrId: %s, extraInfo: %s", new Object[] { Integer.valueOf(paramcc.getType()), Long.valueOf(paramLong), locala.olS, Integer.valueOf(locala.olT), paramcc.field_talker, Integer.valueOf(locala.ovL), Integer.valueOf(locala.ovM), Long.valueOf(paramcc.field_msgSvrId), locala.extraInfo });
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
        String str2 = paramcc.field_talker;
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localh.b(19202, new Object[] { str1, Integer.valueOf(locala.ovL), locala.url, Integer.valueOf(2), Integer.valueOf(0), Long.valueOf(paramcc.getCreateTime()), Long.valueOf(paramLong), Integer.valueOf(locala.ovM), Long.valueOf(paramcc.field_msgSvrId) });
      }
    }
    AppMethodBeat.o(239483);
  }
  
  private static void b(cc paramcc, a parama)
  {
    AppMethodBeat.i(239478);
    if (Util.isNullOrNil(paramcc.jUr))
    {
      Log.i("MicroMsg.BizChattingItemReportHelper", "fillReportMsgSendType msg source null");
      AppMethodBeat.o(239478);
      return;
    }
    if (paramcc.getType() == 318767153) {
      parama.ovM = 2;
    }
    br.b localb = br.JP(paramcc.jUr);
    if (localb == null)
    {
      Log.i("MicroMsg.BizChattingItemReportHelper", "fillReportMsgSendType msg source value null");
      AppMethodBeat.o(239478);
      return;
    }
    if (localb.olP == 3) {
      parama.ovM = 1;
    }
    if ((localb.scene >= 4) && (localb.scene <= 6)) {
      parama.ovM = 5;
    }
    if (h.ac(paramcc)) {
      parama.ovM = 4;
    }
    if (!Util.isNullOrNil(paramcc.kLo)) {
      parama.ovM = 3;
    }
    AppMethodBeat.o(239478);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/modelbiz/BizChattingItemReportHelper$BizServiceMsgReportInfo;", "", "()V", "extraInfo", "", "getExtraInfo", "()Ljava/lang/String;", "setExtraInfo", "(Ljava/lang/String;)V", "kfType", "", "getKfType", "()I", "setKfType", "(I)V", "kfWorker", "getKfWorker", "setKfWorker", "needCheckKF", "", "getNeedCheckKF", "()Z", "setNeedCheckKF", "(Z)V", "reportMsgType", "getReportMsgType", "setReportMsgType", "sendType", "getSendType", "setSendType", "url", "getUrl", "setUrl", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    String extraInfo = "";
    String olS = "";
    int olT;
    int ovL;
    int ovM;
    boolean ovN = true;
    String url = "";
    
    public final void setUrl(String paramString)
    {
      AppMethodBeat.i(239425);
      s.u(paramString, "<set-?>");
      this.url = paramString;
      AppMethodBeat.o(239425);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.b
 * JD-Core Version:    0.7.0.1
 */