package com.tencent.mm.plugin.appbrand.l;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.u.p;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public class a
  implements j
{
  private static SpannableString a(Context paramContext, int paramInt, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      if (paramInt == 1) {
        paramInt = y.i.spannable_wxa_game_link_logo;
      }
    }
    for (paramContext = paramContext.getResources().getDrawable(paramInt);; paramContext = new BitmapDrawable(paramContext.getResources(), paramBitmap))
    {
      paramContext.setBounds(0, 0, p.aqq(), p.aqq());
      paramContext = new com.tencent.mm.plugin.appbrand.widget.g.b(paramContext);
      paramBitmap = new SpannableString("@ ");
      paramBitmap.setSpan(paramContext, 0, 1, 33);
      return paramBitmap;
      paramInt = y.i.spannable_app_brand_link_logo;
      break;
    }
  }
  
  public final CharSequence a(String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference, WeakReference<TextView> paramWeakReference1)
  {
    com.tencent.mm.ae.a.a locala = com.tencent.mm.ae.a.a.gw(paramString);
    Context localContext = (Context)paramWeakReference.get();
    if (localContext == null)
    {
      y.w("MicroMsg.WxaSubscribeMsgService", "context is null");
      return null;
    }
    paramString = locala.content;
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.WxaSubscribeMsgService", "content is null, return");
      return null;
    }
    Object localObject = paramBundle.getString("conv_talker_username");
    int i = paramBundle.getInt("scene");
    long l = paramBundle.getLong("msg_sever_id");
    String str = paramBundle.getString("send_msg_username");
    paramBundle = new SpannableString(paramString);
    paramBundle.setSpan(new a.1(this, locala, (String)localObject, i, l, str), paramString.indexOf(locala.title), paramString.indexOf(locala.title) + locala.title.length(), 17);
    y.i("MicroMsg.WxaSubscribeMsgService", "wxaSubscribeSysContent.forbids:%d", new Object[] { Integer.valueOf(locala.dTY) });
    if (locala.dTY == 1) {
      return paramBundle;
    }
    paramString = ((c)g.r(c.class)).so(locala.username);
    if (paramString != null) {}
    for (paramString = paramString.field_brandIconURL;; paramString = "")
    {
      localObject = com.tencent.mm.modelappbrand.a.b.JD().a(paramString, null);
      if (localObject != null) {
        break;
      }
      com.tencent.mm.modelappbrand.a.b.JD().a(new a.2(this, paramWeakReference1, paramWeakReference, paramBundle), paramString, null);
      return TextUtils.concat(new CharSequence[] { a(localContext, locala.dTZ, null), paramBundle });
    }
    return TextUtils.concat(new CharSequence[] { a(localContext, locala.dTZ, (Bitmap)localObject), paramBundle });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.a
 * JD-Core Version:    0.7.0.1
 */