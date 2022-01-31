package com.tencent.mm.plugin.appbrand.l;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.u.p;
import com.tencent.mm.plugin.appbrand.widget.g.b;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class d
  implements e.b
{
  public final CharSequence a(Map<String, String> paramMap, String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference)
  {
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      y.w("MicroMsg.WxaSysTemplateMsgHandler", "values map is null or nil");
      return null;
    }
    Context localContext = (Context)paramWeakReference.get();
    if (localContext == null)
    {
      y.w("MicroMsg.WxaSysTemplateMsgHandler", "context is null");
      return null;
    }
    String str1 = (String)paramMap.get(paramString + ".title");
    String str2 = (String)paramMap.get(paramString + ".username");
    int m = bk.getInt((String)paramMap.get(paramString + ".type"), 0);
    int k = bk.getInt((String)paramMap.get(paramString + ".wxaapp_type"), 0);
    String str3 = (String)paramMap.get(paramString + ".path");
    label254:
    int j;
    label266:
    long l;
    if (bk.getInt((String)paramMap.get(paramString + ".forbids"), 0) == 1)
    {
      i = 1;
      if (paramBundle == null) {
        break label312;
      }
      paramMap = paramBundle.getString("conv_talker_username");
      if (paramBundle == null) {
        break label318;
      }
      j = paramBundle.getInt("scene");
      if (paramBundle == null) {
        break label324;
      }
      l = paramBundle.getLong("msg_sever_id");
      label278:
      if (paramBundle == null) {
        break label330;
      }
    }
    label312:
    label318:
    label324:
    label330:
    for (paramString = paramBundle.getString("send_msg_username");; paramString = "")
    {
      if (!bk.bl(str1)) {
        break label336;
      }
      y.w("MicroMsg.WxaSysTemplateMsgHandler", "link title is null or nil");
      return null;
      i = 0;
      break;
      paramMap = "";
      break label254;
      j = 0;
      break label266;
      l = 0L;
      break label278;
    }
    label336:
    paramBundle = new SpannableString(str1);
    paramBundle.setSpan(new d.1(this, str1, str2, str3, paramMap, paramWeakReference, j, l, paramString, m), 0, str1.length(), 17);
    y.d("MicroMsg.WxaSysTemplateMsgHandler", "handleTemplate(title : %s, username : %s, path : %s, talker : %s)", new Object[] { str1, str2, str3, paramMap });
    if (i != 0) {
      return paramBundle;
    }
    int i = y.i.spannable_app_brand_link_logo;
    switch (k)
    {
    }
    for (;;)
    {
      paramMap = localContext.getResources().getDrawable(i);
      paramMap.setBounds(0, 0, p.aqq(), p.aqq());
      paramMap = new b(paramMap);
      paramString = new SpannableString("@ ");
      paramString.setSpan(paramMap, 0, 1, 33);
      return TextUtils.concat(new CharSequence[] { paramString, paramBundle });
      i = y.i.spannable_wxa_game_link_logo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.d
 * JD-Core Version:    0.7.0.1
 */