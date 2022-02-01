package com.tencent.mm.plugin.appbrand.msg.dyeingtemplate;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/msg/dyeingtemplate/DyeingTemplateMsgHandler;", "", "()V", "PATH_AUDIO_TEMPLATE_URL", "", "PATH_FORCE_PUSH_INFO", "PATH_IS_AUDIO_TEMPLATE", "PATH_IS_FORCE_NOTIFY_TEMPLATE", "TAG", "handForceNotify", "", "event", "Lcom/tencent/mm/autogen/events/DyeingTemplateMsgReceiveEvent;", "handSubscribeMsgVoiceBroadcast", "initialize", "", "parseForceNotifyInfo", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyCommonItem;", "xml", "msgType", "", "parseVoiceBroadcastUrl", "willDisplayDyeingTemplateForceNotify", "msgXml", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a tmI;
  
  static
  {
    AppMethodBeat.i(317029);
    tmI = new a();
    AppMethodBeat.o(317029);
  }
  
  public static String adQ(String paramString)
  {
    AppMethodBeat.i(317020);
    boolean bool = h.baE().ban().getBoolean(at.a.adhu, true);
    Log.i("MicroMsg.DyeingTemplateMsgHandler", s.X("[DyeingTemplateMsgHandler]  subscribeMsgVoiceBroadcastEnable=", Boolean.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(317020);
      return "";
    }
    paramString = XmlParser.parseXml(paramString, "msg", null);
    if (Util.getInt((String)paramString.get(".msg.appmsg.mmreader.template_detail.template_ext.is_audio_template"), 0) == 1)
    {
      String str = (String)paramString.get(".msg.appmsg.mmreader.template_detail.template_ext.audio_template_url");
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      Log.i("MicroMsg.DyeingTemplateMsgHandler", s.X("DyeingTemplateMsgReceiveEvent  audio_template_url=", paramString));
      AppMethodBeat.o(317020);
      return paramString;
    }
    AppMethodBeat.o(317020);
    return "";
  }
  
  public static com.tencent.mm.plugin.forcenotify.c.f cW(String paramString, int paramInt)
  {
    AppMethodBeat.i(317018);
    paramString = XmlParser.parseXml(paramString, "msg", null);
    if (Util.getInt((String)paramString.get(".msg.appmsg.mmreader.template_detail.template_ext.is_accept_with_force_push"), 0) == 1)
    {
      Object localObject = new i((String)paramString.get(".msg.appmsg.mmreader.template_detail.template_ext.force_push_info"));
      paramString = ((i)localObject).optString("description");
      String str = ((i)localObject).optString("forcePushId");
      localObject = ((i)localObject).optString("nickName");
      s.s(str, "forcePushId");
      s.s(paramString, "description");
      s.s(localObject, "nickName");
      paramString = new com.tencent.mm.plugin.forcenotify.c.f(str, paramString, (String)localObject, MMApplicationContext.getContext().getResources().getString(a.h.force_notify_subscribe_msg), (b)new a.a(paramInt), (byte)0);
      AppMethodBeat.o(317018);
      return paramString;
    }
    AppMethodBeat.o(317018);
    return null;
  }
  
  public static void initialize()
  {
    AppMethodBeat.i(317014);
    new DyeingTemplateMsgHandler.initialize.1(com.tencent.mm.app.f.hfK).alive();
    AppMethodBeat.o(317014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.msg.dyeingtemplate.a
 * JD-Core Version:    0.7.0.1
 */