package com.tencent.mm.plugin.flutter.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.d.a.1;
import com.tencent.mm.plugin.flutter.e.f;
import com.tencent.mm.plugin.flutter.e.f.1;
import com.tencent.mm.sdk.platformtools.ad;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.m;
import io.flutter.plugin.a.m.c;

public class ChannelRegistrant
{
  public static void registerWith(m paramm)
  {
    AppMethodBeat.i(148870);
    Object localObject = paramm.em("com.tencent.mm.plugin.flutter.model.FlutterCrashReportPlugin");
    ad.i("MicroMsg.Flutter.FlutterCrashReportPlugin", "register FlutterCrashReportPlugin CHANNEL%s", new Object[] { "com.tencent.mm.flutter.crashreport" });
    new k(((m.c)localObject).JS(), "com.tencent.mm.flutter.crashreport").a(new a());
    localObject = paramm.em("com.tencent.mm.plugin.flutter.model.FlutterDataReportPlugin");
    ad.i("MicroMsg.Flutter.FlutterDataReportPlugin", "register");
    new k(((m.c)localObject).JS(), "com.tencent.mm.flutter.datareport").a(new b());
    localObject = paramm.em("com.tencent.mm.plugin.flutter.model.FlutterLvCppHandler");
    new k(((m.c)localObject).JS(), "com.tencent.mm.mmflutter.lvcppmethod").a(new c((m.c)localObject));
    localObject = paramm.em("com.tencent.mm.plugin.flutter.video.FlutterVideoPlayerPlugin");
    f localf = new f((m.c)localObject);
    new k(((m.c)localObject).JS(), "com.tencent.mm.flutter/videoPlayer").a(localf);
    ((m.c)localObject).a(new f.1(localf));
    paramm = paramm.em("com.tencent.mm.plugin.flutter.screen.FlutterScreenPlugin");
    localObject = new com.tencent.mm.plugin.flutter.d.a(paramm);
    new k(paramm.JS(), "com.tencent.mm.flutter/screen").a((k.c)localObject);
    paramm.a(new a.1((com.tencent.mm.plugin.flutter.d.a)localObject));
    AppMethodBeat.o(148870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.ChannelRegistrant
 * JD-Core Version:    0.7.0.1
 */