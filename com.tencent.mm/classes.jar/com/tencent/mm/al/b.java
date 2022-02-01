package com.tencent.mm.al;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/modelbiz/BizChattingItemReportHelper;", "", "()V", "TAG", "", "reportCache", "Lcom/tencent/mm/algorithm/LRUMap;", "", "doReportBizServiceMsgClick", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "enterTime", "doReportServiceMsgExpose", "talker", "Lcom/tencent/mm/storage/Contact;", "position", "", "msgCount", "fillReportMsgSendType", "reportInfo", "Lcom/tencent/mm/modelbiz/BizChattingItemReportHelper$BizServiceMsgReportInfo;", "fillReportMsgType", "reportBizServiceMsgClick", "reportServiceMsgExpose", "BizServiceMsgReportInfo", "BizServiceMsgSendType", "BizServiceMsgType", "plugin-biz_release"})
public final class b
{
  private static final f<Long, Long> iNH;
  public static final b iNI;
  
  static
  {
    AppMethodBeat.i(212430);
    iNI = new b();
    iNH = (f)new com.tencent.mm.b.h(20);
    AppMethodBeat.o(212430);
  }
  
  public static final void a(as paramas, final ca paramca, final int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(212426);
    p.h(paramas, "talker");
    p.h(paramca, "msg");
    try
    {
      long l = System.currentTimeMillis();
      if (iNH.get(Long.valueOf(paramca.ajL())) != null)
      {
        Object localObject = iNH.get(Long.valueOf(paramca.ajL()));
        p.g(localObject, "reportCache[msg.msgId]");
        if (l - ((Number)localObject).longValue() < 1000L)
        {
          AppMethodBeat.o(212426);
          return;
        }
      }
      iNH.put(Long.valueOf(paramca.ajL()), Long.valueOf(l));
      com.tencent.f.h.RTc.b((Runnable)new c(paramas, paramca, paramInt1, paramInt2, paramLong), "BizServicesReportThread");
      AppMethodBeat.o(212426);
      return;
    }
    catch (Exception paramas)
    {
      Log.printErrStackTrace("MicroMsg.BizChattingItemReportHelper", (Throwable)paramas, "reportServiceMsgExpose exception", new Object[0]);
      AppMethodBeat.o(212426);
    }
  }
  
  public static final void a(ca paramca, final long paramLong)
  {
    AppMethodBeat.i(212427);
    if (paramca == null)
    {
      AppMethodBeat.o(212427);
      return;
    }
    if (paramca.ajN() == 1)
    {
      AppMethodBeat.o(212427);
      return;
    }
    com.tencent.f.h.RTc.aZ((Runnable)new b(paramca, paramLong));
    AppMethodBeat.o(212427);
  }
  
  private static void a(ca paramca, a parama)
  {
    AppMethodBeat.i(212428);
    parama.iEt = paramca.ajV();
    String str2 = paramca.ajT();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.h(str1, "<set-?>");
    parama.iEs = str1;
    if (paramca.isText())
    {
      parama.iNJ = 1;
      parama.iNL = true;
      if (((CharSequence)parama.url).length() <= 0) {
        break label414;
      }
    }
    label414:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramca = z.bfG(parama.url);
        p.g(paramca, "WebViewUtil.doUrlEncode(reportInfo.url)");
        parama.setUrl(paramca);
      }
      AppMethodBeat.o(212428);
      return;
      if (paramca.gAy())
      {
        parama.iNJ = 9;
        parama.iNL = true;
        break;
      }
      if (paramca.gAz())
      {
        parama.iNJ = 2;
        parama.iNL = true;
        break;
      }
      if (paramca.cWJ())
      {
        parama.iNJ = 5;
        parama.iNL = true;
        break;
      }
      if ((paramca.getType() == 452984881) || (paramca.getType() == 520093745))
      {
        parama.iNJ = 6;
        parama.iNL = false;
        break;
      }
      if (paramca.gAt())
      {
        parama.iNJ = 3;
        parama.iNL = false;
        paramca = ((a)g.af(a.class)).a(paramca.ajL(), paramca.getContent());
        if ((paramca == null) || (Util.isNullOrNil((List)paramca.iAd))) {
          break;
        }
        paramca = ((v)paramca.iAd.get(0)).url;
        p.g(paramca, "reader.items[0].url");
        parama.setUrl(paramca);
        break;
      }
      if ((!paramca.dOQ()) || (paramca.getContent() == null)) {
        break;
      }
      parama.iNL = false;
      paramca = k.b.HD(paramca.getContent());
      if (paramca == null) {
        break;
      }
      if ((paramca.type == 33) || (paramca.type == 36))
      {
        parama.iNJ = 4;
        str1 = paramca.url;
        p.g(str1, "content.url");
        parama.setUrl(str1);
        paramca = paramca.izj;
        p.g(paramca, "content.appbrandAppId");
        p.h(paramca, "<set-?>");
        parama.extraInfo = paramca;
        break;
      }
      if (paramca.type == 5)
      {
        parama.iNJ = 7;
        break;
      }
      if (paramca.type != 3) {
        break;
      }
      parama.iNJ = 8;
      break;
    }
  }
  
  private static void b(ca paramca, a parama)
  {
    AppMethodBeat.i(212429);
    if (Util.isNullOrNil(paramca.ajw()))
    {
      Log.i("MicroMsg.BizChattingItemReportHelper", "fillReportMsgSendType msg source null");
      AppMethodBeat.o(212429);
      return;
    }
    if (paramca.getType() == 318767153) {
      parama.iNK = 2;
    }
    bp.b localb = bp.Ky(paramca.ajw());
    if (localb == null)
    {
      Log.i("MicroMsg.BizChattingItemReportHelper", "fillReportMsgSendType msg source value null");
      AppMethodBeat.o(212429);
      return;
    }
    if (localb.iEp == 3) {
      parama.iNK = 1;
    }
    if ((localb.scene >= 4) && (localb.scene <= 6)) {
      parama.iNK = 5;
    }
    if (h.R(paramca)) {
      parama.iNK = 4;
    }
    if (!Util.isNullOrNil(paramca.ajT())) {
      parama.iNK = 3;
    }
    AppMethodBeat.o(212429);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/modelbiz/BizChattingItemReportHelper$BizServiceMsgReportInfo;", "", "()V", "extraInfo", "", "getExtraInfo", "()Ljava/lang/String;", "setExtraInfo", "(Ljava/lang/String;)V", "kfType", "", "getKfType", "()I", "setKfType", "(I)V", "kfWorker", "getKfWorker", "setKfWorker", "needCheckKF", "", "getNeedCheckKF", "()Z", "setNeedCheckKF", "(Z)V", "reportMsgType", "getReportMsgType", "setReportMsgType", "sendType", "getSendType", "setSendType", "url", "getUrl", "setUrl", "plugin-biz_release"})
  static final class a
  {
    String extraInfo = "";
    String iEs = "";
    int iEt;
    int iNJ;
    int iNK;
    boolean iNL = true;
    String url = "";
    
    public final void setUrl(String paramString)
    {
      AppMethodBeat.i(212423);
      p.h(paramString, "<set-?>");
      this.url = paramString;
      AppMethodBeat.o(212423);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ca paramca, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(212424);
      b localb = b.iNI;
      b.b(this.iNM, paramLong);
      AppMethodBeat.o(212424);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(as paramas, ca paramca, int paramInt1, int paramInt2, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(212425);
      b localb = b.iNI;
      b.b(this.iNO, paramca, paramInt1, paramInt2, paramLong);
      AppMethodBeat.o(212425);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.al.b
 * JD-Core Version:    0.7.0.1
 */