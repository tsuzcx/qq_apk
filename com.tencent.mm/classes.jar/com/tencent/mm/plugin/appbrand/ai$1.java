package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;

final class ai$1
  implements Runnable
{
  ai$1(ai paramai, WxaAttributes paramWxaAttributes, Context paramContext, int paramInt, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(129166);
    g.RJ();
    int i = a.getUin();
    Object localObject = this.gSk.field_roundedSquareIconURL;
    String str1 = this.gSk.field_brandIconURL;
    String str2 = this.gSk.field_bigHeadURL;
    String str3 = this.gSk.field_nickname;
    String str4 = this.gSk.field_appId;
    String str5 = this.gSk.field_username;
    localObject = new u.a(i, new String[] { localObject, str1, str2 }, str3, str4, str5);
    u.a(this.val$context, (u.a)localObject, this.gSl, this.gSm);
    AppMethodBeat.o(129166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ai.1
 * JD-Core Version:    0.7.0.1
 */