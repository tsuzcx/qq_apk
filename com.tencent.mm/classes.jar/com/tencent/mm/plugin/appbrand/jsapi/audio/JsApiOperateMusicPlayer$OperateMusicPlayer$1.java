package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiOperateMusicPlayer$OperateMusicPlayer$1
  implements Runnable
{
  JsApiOperateMusicPlayer$OperateMusicPlayer$1(JsApiOperateMusicPlayer.OperateMusicPlayer paramOperateMusicPlayer, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public final void run()
  {
    AppMethodBeat.i(130719);
    String str1 = new StringBuilder().append(this.hCl.cwc).append(this.hCf).append(this.hCg).toString().hashCode();
    String str2 = this.hCg;
    String str3 = this.hCg;
    String str4 = this.cbK;
    String str5 = this.hCh;
    String str6 = this.hCi;
    String str7 = this.hCj;
    String str8 = this.hCf;
    String str9 = com.tencent.mm.compatible.util.e.eQz;
    String str10 = c.YK() + this.hCg.hashCode();
    String str11 = this.hCk;
    com.tencent.mm.aw.e locale = new com.tencent.mm.aw.e();
    locale.fKh = 7;
    locale.fKo = str2;
    locale.fKA = str3;
    locale.fKl = str4;
    locale.fKm = str5;
    locale.fKr = str6;
    locale.fKq = str7;
    locale.fKp = str8;
    locale.fKu = str9;
    locale.fKw = "";
    locale.fKt = str10;
    locale.fKj = str1;
    locale.fKk = 0.0F;
    locale.fKn = str11;
    locale.fKi = 1;
    locale.fKs = null;
    locale.fKz = str1;
    locale.fKF = true;
    com.tencent.mm.aw.a.b(locale);
    a.a.aHK().a(JsApiOperateMusicPlayer.OperateMusicPlayer.b(this.hCl), this.hCl.cwc);
    a.a.aHK().ipb = this.hCl.cwc;
    a.a.aHK().ipc = locale.fKj;
    ab.i("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
    this.hCl.action = -1;
    this.hCl.errorMsg = "";
    this.hCl.error = false;
    JsApiOperateMusicPlayer.OperateMusicPlayer.c(this.hCl);
    AppMethodBeat.o(130719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer.1
 * JD-Core Version:    0.7.0.1
 */