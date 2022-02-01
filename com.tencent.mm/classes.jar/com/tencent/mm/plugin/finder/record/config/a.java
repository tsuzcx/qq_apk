package com.tencent.mm.plugin.finder.record.config;

import android.text.TextUtils;
import com.tencent.maas.camerafun.MJAuditCaptureSettings;
import com.tencent.maas.camerafun.MJAuditCaptureSettings.MJAuditCaptureOutputType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.record.FinderRecordTemplatePluginLayout;
import com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.util.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/record/config/RecordTemplateConfig;", "", "()V", "DefaultAuditCaptureSettings", "", "KeyInterval", "KeyLevel", "TAG", "checkConfigProviderEntrance", "", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "enableTemplate", "", "getMJAuditCaptureSettings", "Lcom/tencent/maas/camerafun/MJAuditCaptureSettings;", "session", "clear", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Fix;
  private static final String Fiy;
  
  static
  {
    AppMethodBeat.i(336926);
    Fix = new a();
    Fiy = "\n        {\n        \"level\":" + com.tencent.maas.instamovie.mediafoundation.b.eFW.id + ",\n        \"interval\":3.0\n        }\n    ";
    AppMethodBeat.o(336926);
  }
  
  private static MJAuditCaptureSettings azB(String paramString)
  {
    AppMethodBeat.i(336920);
    s.u(paramString, "session");
    Object localObject1 = e.Obp;
    localObject1 = e.aTo(s.X("mj", paramString));
    y.ew((String)localObject1, true);
    Object localObject2 = e.Obp;
    e.aTo(s.X("mj", paramString));
    paramString = ((c)h.ax(c.class)).a(c.a.yVz, Fiy);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(336920);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localObject2 = com.tencent.maas.instamovie.mediafoundation.b.mM(paramString.optInt("level", com.tencent.maas.instamovie.mediafoundation.b.eFW.id));
      double d = paramString.optDouble("interval", 3.0D);
      Log.i("MicroMsg.RecordTemplateConfig", "getMJAuditCaptureSettings level:" + localObject2 + " interval:" + d + " dir:" + (String)localObject1);
      paramString = new MJAuditCaptureSettings((com.tencent.maas.instamovie.mediafoundation.b)localObject2, d, MJAuditCaptureSettings.MJAuditCaptureOutputType.JPEGs, (String)localObject1, "mjScy");
      AppMethodBeat.o(336920);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.RecordTemplateConfig", (Throwable)paramString, "getMJAuditCaptureSettings error", new Object[0]);
        paramString = null;
      }
    }
  }
  
  public static void b(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(336894);
    s.u(paramRecordConfigProvider, "provider");
    com.tencent.mm.mj_template.album_template.b localb = com.tencent.mm.mj_template.album_template.b.nWa;
    if (com.tencent.mm.mj_template.album_template.b.bwC())
    {
      paramRecordConfigProvider.cD(0, FinderRecordTemplatePluginLayout.class.getName());
      AppMethodBeat.o(336894);
      return;
    }
    paramRecordConfigProvider.cD(0, FinderRecordPluginLayout.class.getName());
    AppMethodBeat.o(336894);
  }
  
  public static boolean eLj()
  {
    AppMethodBeat.i(336906);
    i locali = i.agtt;
    switch (((Integer)i.a(b.a.agsr, Integer.valueOf(-1))).intValue())
    {
    default: 
      boolean bool = ((c)h.ax(c.class)).a(c.a.yVy, false);
      Log.i("MicroMsg.RecordTemplateConfig", s.X("enableTemplate:", Boolean.valueOf(bool)));
      if ((bool) && (BuildInfo.IS_ARM64))
      {
        AppMethodBeat.o(336906);
        return true;
      }
      break;
    case 0: 
      AppMethodBeat.o(336906);
      return false;
    case 1: 
      AppMethodBeat.o(336906);
      return true;
    }
    AppMethodBeat.o(336906);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.record.config.a
 * JD-Core Version:    0.7.0.1
 */