package com.tencent.mm.plugin.flutter.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.c.a.1;
import com.tencent.mm.plugin.flutter.d.c.1;
import com.tencent.mm.sdk.platformtools.ad;
import io.flutter.a.a.k;
import io.flutter.a.a.k.c;
import io.flutter.a.a.m;
import io.flutter.a.a.m.c;

public class ChannelRegistrant
{
  public static void registerWith(m paramm)
  {
    AppMethodBeat.i(148870);
    Object localObject = paramm.dB("com.tencent.mm.plugin.flutter.model.FlutterCrashReportPlugin");
    ad.i("MicroMsg.Flutter.FlutterCrashReportPlugin", "register FlutterCrashReportPlugin CHANNEL%s", new Object[] { "com.tencent.mm.flutter.crashreport" });
    new k(((m.c)localObject).IJ(), "com.tencent.mm.flutter.crashreport").a(new a());
    localObject = paramm.dB("com.tencent.mm.plugin.flutter.model.FlutterDataReportPlugin");
    ad.i("MicroMsg.Flutter.FlutterDataReportPlugin", "register");
    new k(((m.c)localObject).IJ(), "com.tencent.mm.flutter.datareport").a(new b());
    localObject = paramm.dB("com.tencent.mm.plugin.flutter.model.FlutterLvCppHandler");
    new k(((m.c)localObject).IJ(), "com.tencent.mm.mmflutter.lvcppmethod").a(new c((m.c)localObject));
    localObject = paramm.dB("com.tencent.mm.plugin.flutter.video.FlutterVideoPlayerPlugin");
    com.tencent.mm.plugin.flutter.d.c localc = new com.tencent.mm.plugin.flutter.d.c((m.c)localObject);
    new k(((m.c)localObject).IJ(), "com.tencent.mm.flutter/videoPlayer").a(localc);
    ((m.c)localObject).a(new c.1(localc));
    paramm = paramm.dB("com.tencent.mm.plugin.flutter.screen.FlutterScreenPlugin");
    localObject = new com.tencent.mm.plugin.flutter.c.a(paramm);
    new k(paramm.IJ(), "com.tencent.mm.flutter/screen").a((k.c)localObject);
    paramm.a(new a.1((com.tencent.mm.plugin.flutter.c.a)localObject));
    AppMethodBeat.o(148870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.ChannelRegistrant
 * JD-Core Version:    0.7.0.1
 */