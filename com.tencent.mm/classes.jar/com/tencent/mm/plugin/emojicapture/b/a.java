package com.tencent.mm.plugin.emojicapture.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.protocal.c.uv;
import com.tencent.mm.protocal.c.uw;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends com.tencent.mm.ah.a<uw>
{
  private final String TAG;
  private final String text;
  
  public a(String paramString)
  {
    this.text = paramString;
    this.TAG = "MicroMsg.CgiTextAntiSpam";
    paramString = new b.a();
    uv localuv = new uv();
    localuv.sRA = this.text;
    paramString.a((com.tencent.mm.bv.a)localuv);
    paramString.b((com.tencent.mm.bv.a)new uw());
    paramString.kr("/cgi-bin/micromsg-bin/mmemojitextantispam");
    paramString.ig(532);
    a(paramString.Kt());
    y.i(this.TAG, "Check text anti spam " + this.text);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.b.a
 * JD-Core Version:    0.7.0.1
 */