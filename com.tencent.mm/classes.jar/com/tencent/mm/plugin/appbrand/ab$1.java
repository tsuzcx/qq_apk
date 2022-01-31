package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;

final class ab$1
  implements Runnable
{
  ab$1(ab paramab, WxaAttributes paramWxaAttributes, Context paramContext, int paramInt) {}
  
  public final void run()
  {
    g.DN();
    int i = a.CK();
    Object localObject = this.pIb.field_roundedSquareIconURL;
    String str1 = this.pIb.field_brandIconURL;
    String str2 = this.pIb.field_bigHeadURL;
    String str3 = this.pIb.field_nickname;
    String str4 = this.pIb.field_appId;
    String str5 = this.pIb.field_username;
    localObject = new q.a(i, new String[] { localObject, str1, str2 }, str3, str4, str5);
    q.a(this.val$context, (q.a)localObject, this.fAF, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.1
 * JD-Core Version:    0.7.0.1
 */