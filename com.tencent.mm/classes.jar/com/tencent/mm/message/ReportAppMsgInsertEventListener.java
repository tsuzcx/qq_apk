package com.tencent.mm.message;

import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.z;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/message/ReportAppMsgInsertEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AppMsgInsertEvent;", "()V", "callback", "", "event", "doReportReceiveAppMsgFromNotifyMessage", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "getBusinessType", "", "opType", "getJumpUrl", "Lkotlin/Pair;", "", "srcUsername", "values", "", "getNewTemplateType", "getSrcUsername", "getTitle", "isNewTemplateSubscribeMsg", "templateType", "reportReceiveAppMsgFromNotifyMessage", "Companion", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ReportAppMsgInsertEventListener
  extends IListener<z>
{
  public static final ReportAppMsgInsertEventListener.a nVz;
  
  static
  {
    AppMethodBeat.i(233935);
    nVz = new ReportAppMsgInsertEventListener.a((byte)0);
    AppMethodBeat.o(233935);
  }
  
  public ReportAppMsgInsertEventListener()
  {
    super((q)f.hfK);
    AppMethodBeat.i(233929);
    AppMethodBeat.o(233929);
  }
  
  private static final void a(ReportAppMsgInsertEventListener paramReportAppMsgInsertEventListener, cc paramcc)
  {
    AppMethodBeat.i(233932);
    s.u(paramReportAppMsgInsertEventListener, "this$0");
    s.s(paramcc, "msgInfo");
    int n = paramcc.getType();
    Object localObject2;
    Object localObject1;
    int i;
    String str2;
    int j;
    label324:
    int i1;
    label351:
    int k;
    label360:
    label383:
    boolean bool;
    if ((n == 318767153) || (n == 721420337))
    {
      if (n == 721420337)
      {
        Log.d("MicroMsg.AppMsgInsertEventListener", "alvinluo doReportReceiveAppMsg callback msgType: %d, msgId: %s, createTime: %s, talker: %s, businessType: %d, srcUsername: %s", new Object[] { Integer.valueOf(n), Long.valueOf(paramcc.field_msgId), Long.valueOf(paramcc.getCreateTime()), paramcc.field_talker, Integer.valueOf(2), paramcc.field_talker });
        com.tencent.mm.plugin.report.service.h.OAn.b(20566, new Object[] { Integer.valueOf(0), Long.valueOf(paramcc.getCreateTime()), Integer.valueOf(0), Integer.valueOf(2), paramcc.field_talker, "", "", "", Integer.valueOf(0) });
        AppMethodBeat.o(233932);
        return;
      }
      try
      {
        localObject2 = XmlParser.parseXml(paramcc.field_content, "msg", null);
        if ((localObject2 == null) || (((Map)localObject2).isEmpty()))
        {
          Log.e("MicroMsg.AppMsgInsertEventListener", "doReportReceiveAppMsgFromNotifyMessage parse msg fail");
          AppMethodBeat.o(233932);
          return;
        }
      }
      catch (Exception paramReportAppMsgInsertEventListener)
      {
        Log.printErrStackTrace("MicroMsg.AppMsgInsertEventListener", (Throwable)paramReportAppMsgInsertEventListener, "doReportReceiveAppMsgFromNotifyMessage exception", new Object[0]);
        AppMethodBeat.o(233932);
        return;
      }
      localObject1 = Util.nullAsNil((String)((Map)localObject2).get(".msg.fromusername"));
      paramReportAppMsgInsertEventListener = (ReportAppMsgInsertEventListener)localObject1;
      if (localObject1 == null) {
        paramReportAppMsgInsertEventListener = "";
      }
      paramReportAppMsgInsertEventListener = (CharSequence)paramReportAppMsgInsertEventListener;
      if (paramReportAppMsgInsertEventListener.length() != 0) {
        break label675;
      }
      i = 1;
      if (i != 0) {
        paramReportAppMsgInsertEventListener = "";
      }
      str2 = (String)paramReportAppMsgInsertEventListener;
      int m = w((Map)localObject2);
      if (!uF(m)) {
        break label680;
      }
      j = 1;
      i1 = Util.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
      if (i1 != 2) {
        break label685;
      }
      paramReportAppMsgInsertEventListener = "";
      if (i1 != 2) {
        break label855;
      }
      k = 1;
      localObject1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_username");
      if (localObject1 != null) {
        break label861;
      }
      localObject1 = "";
      if ((i1 != 1) || (TextUtils.isEmpty((CharSequence)localObject1))) {
        break label864;
      }
      String str1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_path");
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      localObject1 = new r(Uri.encode((String)localObject2), localObject1);
      label443:
      if (localObject1 != null) {
        break label994;
      }
      localObject2 = "";
      label452:
      if (localObject1 != null) {
        break label1019;
      }
      localObject1 = "";
      label461:
      bool = ((a)com.tencent.mm.kernel.h.ax(a.class)).Hh(str2);
      if (!uF(m)) {
        break label1044;
      }
      i = m;
    }
    for (;;)
    {
      Log.d("MicroMsg.AppMsgInsertEventListener", "alvinluo doReportReceiveAppMsgFromNotifyMessage callback msgType: %d, opType: %d, msgSvrId: %s, createTime: %s, talker: %s, reportMsgType: %d, businessType: %d, srcUsername: %s, title: %s, jumpUrl: %s, jumpUsernanme: %s, msgSubType: %d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(paramcc.field_msgSvrId), Long.valueOf(paramcc.getCreateTime()), paramcc.field_talker, Integer.valueOf(j), Integer.valueOf(k), str2, paramReportAppMsgInsertEventListener, localObject2, localObject1, Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.OAn.b(20566, new Object[] { Long.valueOf(paramcc.field_msgSvrId), Long.valueOf(paramcc.getCreateTime()), Integer.valueOf(j), Integer.valueOf(k), str2, paramReportAppMsgInsertEventListener, localObject2, localObject1, Integer.valueOf(i) });
      AppMethodBeat.o(233932);
      return;
      label675:
      i = 0;
      break;
      label680:
      j = 2;
      break label324;
      label685:
      if (Util.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0) != 0)
      {
        if (Util.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) == 0) {}
        for (i = Util.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);; i = 0)
        {
          k = Util.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
          if ((i != 0) || (k != 0)) {
            break label801;
          }
          paramReportAppMsgInsertEventListener = Util.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.title"));
          s.s(paramReportAppMsgInsertEventListener, "nullAsNil(values.get(\".m….template_header.title\"))");
          break;
        }
        paramReportAppMsgInsertEventListener = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.title");
        if (paramReportAppMsgInsertEventListener == null)
        {
          paramReportAppMsgInsertEventListener = "";
          break label351;
        }
        break label351;
      }
      label801:
      paramReportAppMsgInsertEventListener = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.title");
      if (paramReportAppMsgInsertEventListener == null)
      {
        paramReportAppMsgInsertEventListener = "";
        break label351;
      }
      break label351;
      label855:
      k = 0;
      break label360;
      label861:
      break label383;
      label864:
      if ((i1 == -1) && (((a)com.tencent.mm.kernel.h.ax(a.class)).Hh(str2)))
      {
        localObject2 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject1 = new r(Uri.encode((String)localObject1), "");
        break label443;
      }
      if (i1 == 2)
      {
        localObject1 = null;
        break label443;
      }
      localObject2 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.url");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = new r(Uri.encode((String)localObject1), "");
      break label443;
      label994:
      localObject2 = (String)((r)localObject1).bsC;
      if (localObject2 == null)
      {
        localObject2 = "";
        break label452;
      }
      break label452;
      label1019:
      localObject1 = (String)((r)localObject1).bsD;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label461;
      }
      break label461;
      label1044:
      if (bool) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  private static boolean uF(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  private static int w(Map<String, String> paramMap)
  {
    AppMethodBeat.i(233930);
    paramMap = (String)paramMap.get(".msg.appmsg.mmreader.template_detail.new_tmpl_type");
    CharSequence localCharSequence = (CharSequence)paramMap;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        paramMap = "-1";
      }
      try
      {
        paramMap = Integer.valueOf(paramMap);
        s.s(paramMap, "valueOf(newTemplateMsgStr)");
        i = ((Number)paramMap).intValue();
        i = Util.nullAsInt(Integer.valueOf(i), -1);
        AppMethodBeat.o(233930);
        return i;
        i = 0;
      }
      catch (Exception paramMap)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppMsgInsertEventListener", (Throwable)paramMap, "", new Object[0]);
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.message.ReportAppMsgInsertEventListener
 * JD-Core Version:    0.7.0.1
 */