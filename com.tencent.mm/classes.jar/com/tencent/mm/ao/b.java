package com.tencent.mm.ao;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.b.f;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelbiz/BizChattingItemReportHelper;", "", "()V", "TAG", "", "reportCache", "Lcom/tencent/mm/algorithm/LRUMap;", "", "doReportBizServiceMsgClick", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "enterTime", "doReportServiceMsgExpose", "talker", "Lcom/tencent/mm/storage/Contact;", "position", "", "msgCount", "fillReportMsgSendType", "reportInfo", "Lcom/tencent/mm/modelbiz/BizChattingItemReportHelper$BizServiceMsgReportInfo;", "fillReportMsgType", "reportBizServiceMsgClick", "reportServiceMsgExpose", "BizServiceMsgReportInfo", "BizServiceMsgSendType", "BizServiceMsgType", "plugin-biz_release"})
public final class b
{
  private static final f<Long, Long> lDY;
  public static final b lDZ;
  
  static
  {
    AppMethodBeat.i(208041);
    lDZ = new b();
    lDY = (f)new com.tencent.mm.b.h(20);
    AppMethodBeat.o(208041);
  }
  
  public static final void a(as paramas, final ca paramca, final int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(208028);
    p.k(paramas, "talker");
    p.k(paramca, "msg");
    try
    {
      long l = System.currentTimeMillis();
      if (lDY.get(Long.valueOf(paramca.apG())) != null)
      {
        Object localObject = lDY.get(Long.valueOf(paramca.apG()));
        p.j(localObject, "reportCache[msg.msgId]");
        if (l - ((Number)localObject).longValue() < 1000L)
        {
          AppMethodBeat.o(208028);
          return;
        }
      }
      lDY.put(Long.valueOf(paramca.apG()), Long.valueOf(l));
      com.tencent.e.h.ZvG.d((Runnable)new c(paramas, paramca, paramInt1, paramInt2, paramLong), "BizServicesReportThread");
      AppMethodBeat.o(208028);
      return;
    }
    catch (Exception paramas)
    {
      Log.printErrStackTrace("MicroMsg.BizChattingItemReportHelper", (Throwable)paramas, "reportServiceMsgExpose exception", new Object[0]);
      AppMethodBeat.o(208028);
    }
  }
  
  public static final void a(ca paramca, final long paramLong)
  {
    AppMethodBeat.i(208031);
    if (paramca == null)
    {
      AppMethodBeat.o(208031);
      return;
    }
    if (paramca.apA() == 1)
    {
      AppMethodBeat.o(208031);
      return;
    }
    com.tencent.e.h.ZvG.bg((Runnable)new b(paramca, paramLong));
    AppMethodBeat.o(208031);
  }
  
  private static void a(ca paramca, a parama)
  {
    AppMethodBeat.i(208036);
    parama.luu = paramca.apR();
    String str2 = paramca.apP();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.k(str1, "<set-?>");
    parama.lut = str1;
    if (paramca.hwH())
    {
      parama.lEa = 1;
      parama.lEc = true;
      if (((CharSequence)parama.url).length() <= 0) {
        break label414;
      }
    }
    label414:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramca = ab.aXb(parama.url);
        p.j(paramca, "WebViewUtil.doUrlEncode(reportInfo.url)");
        parama.setUrl(paramca);
      }
      AppMethodBeat.o(208036);
      return;
      if (paramca.hwF())
      {
        parama.lEa = 9;
        parama.lEc = true;
        break;
      }
      if (paramca.hwG())
      {
        parama.lEa = 2;
        parama.lEc = true;
        break;
      }
      if (paramca.dlR())
      {
        parama.lEa = 5;
        parama.lEc = true;
        break;
      }
      if ((paramca.getType() == 452984881) || (paramca.getType() == 520093745))
      {
        parama.lEa = 6;
        parama.lEc = false;
        break;
      }
      if (paramca.hwA())
      {
        parama.lEa = 3;
        parama.lEc = false;
        paramca = ((a)com.tencent.mm.kernel.h.ae(a.class)).b(paramca.apG(), paramca.getContent());
        if ((paramca == null) || (Util.isNullOrNil((List)paramca.lpz))) {
          break;
        }
        paramca = ((v)paramca.lpz.get(0)).url;
        p.j(paramca, "reader.items[0].url");
        parama.setUrl(paramca);
        break;
      }
      if ((!paramca.erk()) || (paramca.getContent() == null)) {
        break;
      }
      parama.lEc = false;
      paramca = k.b.OQ(paramca.getContent());
      if (paramca == null) {
        break;
      }
      if ((paramca.type == 33) || (paramca.type == 36))
      {
        parama.lEa = 4;
        str1 = paramca.url;
        p.j(str1, "content.url");
        parama.setUrl(str1);
        paramca = paramca.loB;
        p.j(paramca, "content.appbrandAppId");
        p.k(paramca, "<set-?>");
        parama.extraInfo = paramca;
        break;
      }
      if (paramca.type == 5)
      {
        parama.lEa = 7;
        break;
      }
      if (paramca.type != 3) {
        break;
      }
      parama.lEa = 8;
      break;
    }
  }
  
  private static void b(ca paramca, a parama)
  {
    AppMethodBeat.i(208040);
    if (Util.isNullOrNil(paramca.apc()))
    {
      Log.i("MicroMsg.BizChattingItemReportHelper", "fillReportMsgSendType msg source null");
      AppMethodBeat.o(208040);
      return;
    }
    if (paramca.getType() == 318767153) {
      parama.lEb = 2;
    }
    bq.b localb = bq.RR(paramca.apc());
    if (localb == null)
    {
      Log.i("MicroMsg.BizChattingItemReportHelper", "fillReportMsgSendType msg source value null");
      AppMethodBeat.o(208040);
      return;
    }
    if (localb.luq == 3) {
      parama.lEb = 1;
    }
    if ((localb.scene >= 4) && (localb.scene <= 6)) {
      parama.lEb = 5;
    }
    if (h.X(paramca)) {
      parama.lEb = 4;
    }
    if (!Util.isNullOrNil(paramca.apP())) {
      parama.lEb = 3;
    }
    AppMethodBeat.o(208040);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelbiz/BizChattingItemReportHelper$BizServiceMsgReportInfo;", "", "()V", "extraInfo", "", "getExtraInfo", "()Ljava/lang/String;", "setExtraInfo", "(Ljava/lang/String;)V", "kfType", "", "getKfType", "()I", "setKfType", "(I)V", "kfWorker", "getKfWorker", "setKfWorker", "needCheckKF", "", "getNeedCheckKF", "()Z", "setNeedCheckKF", "(Z)V", "reportMsgType", "getReportMsgType", "setReportMsgType", "sendType", "getSendType", "setSendType", "url", "getUrl", "setUrl", "plugin-biz_release"})
  static final class a
  {
    String extraInfo = "";
    int lEa;
    int lEb;
    boolean lEc = true;
    String lut = "";
    int luu;
    String url = "";
    
    public final void setUrl(String paramString)
    {
      AppMethodBeat.i(206244);
      p.k(paramString, "<set-?>");
      this.url = paramString;
      AppMethodBeat.o(206244);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ca paramca, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(206495);
      b localb = b.lDZ;
      b.b(this.lEd, paramLong);
      AppMethodBeat.o(206495);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(as paramas, ca paramca, int paramInt1, int paramInt2, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(206126);
      b localb = b.lDZ;
      b.b(this.lEf, paramca, paramInt1, paramInt2, paramLong);
      AppMethodBeat.o(206126);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.b
 * JD-Core Version:    0.7.0.1
 */