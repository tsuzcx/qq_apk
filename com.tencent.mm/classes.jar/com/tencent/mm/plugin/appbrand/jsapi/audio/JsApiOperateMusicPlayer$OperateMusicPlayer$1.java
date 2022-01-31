package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.sdk.platformtools.y;

final class JsApiOperateMusicPlayer$OperateMusicPlayer$1
  implements Runnable
{
  JsApiOperateMusicPlayer$OperateMusicPlayer$1(JsApiOperateMusicPlayer.OperateMusicPlayer paramOperateMusicPlayer, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public final void run()
  {
    String str1 = new StringBuilder().append(this.giR.bOL).append(this.giL).append(this.giM).toString().hashCode();
    String str2 = this.giM;
    String str3 = this.giM;
    String str4 = this.dYK;
    String str5 = this.giN;
    String str6 = this.giO;
    String str7 = this.giP;
    String str8 = this.giL;
    String str9 = com.tencent.mm.compatible.util.e.bkH;
    String str10 = c.FG() + this.giM.hashCode();
    String str11 = this.giQ;
    com.tencent.mm.av.e locale = new com.tencent.mm.av.e();
    locale.euv = 7;
    locale.euC = str2;
    locale.euO = str3;
    locale.euz = str4;
    locale.euA = str5;
    locale.euF = str6;
    locale.euE = str7;
    locale.euD = str8;
    locale.euI = str9;
    locale.euK = "";
    locale.euH = str10;
    locale.eux = str1;
    locale.euy = 0.0F;
    locale.euB = str11;
    locale.euw = 1;
    locale.euG = null;
    locale.euN = str1;
    locale.euT = true;
    com.tencent.mm.av.a.b(locale);
    a.a.amd().a(JsApiOperateMusicPlayer.OperateMusicPlayer.b(this.giR), this.giR.bOL);
    a.a.amd().gNh = this.giR.bOL;
    a.a.amd().gNi = locale.eux;
    y.i("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
    this.giR.action = -1;
    this.giR.errorMsg = "";
    this.giR.error = false;
    JsApiOperateMusicPlayer.OperateMusicPlayer.c(this.giR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer.1
 * JD-Core Version:    0.7.0.1
 */