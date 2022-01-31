package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.o;
import com.tencent.mm.plugin.appbrand.widget.h.b;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class d
  implements e.b
{
  public final CharSequence a(Map<String, String> paramMap, String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference)
  {
    AppMethodBeat.i(132276);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      ab.w("MicroMsg.WxaSysTemplateMsgHandler", "values map is null or nil");
      AppMethodBeat.o(132276);
      return null;
    }
    Context localContext = (Context)paramWeakReference.get();
    if (localContext == null)
    {
      ab.w("MicroMsg.WxaSysTemplateMsgHandler", "context is null");
      AppMethodBeat.o(132276);
      return null;
    }
    String str1 = (String)paramMap.get(paramString + ".title");
    String str2 = (String)paramMap.get(paramString + ".username");
    int m = bo.getInt((String)paramMap.get(paramString + ".type"), 0);
    int k = bo.getInt((String)paramMap.get(paramString + ".wxaapp_type"), 0);
    String str3 = (String)paramMap.get(paramString + ".path");
    label269:
    int j;
    label281:
    long l;
    if (bo.getInt((String)paramMap.get(paramString + ".forbids"), 0) == 1)
    {
      i = 1;
      if (paramBundle == null) {
        break label332;
      }
      paramMap = paramBundle.getString("conv_talker_username");
      if (paramBundle == null) {
        break label338;
      }
      j = paramBundle.getInt("scene");
      if (paramBundle == null) {
        break label344;
      }
      l = paramBundle.getLong("msg_sever_id");
      label293:
      if (paramBundle == null) {
        break label350;
      }
    }
    label332:
    label338:
    label344:
    label350:
    for (paramString = paramBundle.getString("send_msg_username");; paramString = "")
    {
      if (!bo.isNullOrNil(str1)) {
        break label356;
      }
      ab.w("MicroMsg.WxaSysTemplateMsgHandler", "link title is null or nil");
      AppMethodBeat.o(132276);
      return null;
      i = 0;
      break;
      paramMap = "";
      break label269;
      j = 0;
      break label281;
      l = 0L;
      break label293;
    }
    label356:
    paramBundle = new SpannableString(str1);
    paramBundle.setSpan(new d.1(this, str1, str2, str3, paramMap, paramWeakReference, j, l, paramString, m), 0, str1.length(), 17);
    ab.d("MicroMsg.WxaSysTemplateMsgHandler", "handleTemplate(title : %s, username : %s, path : %s, talker : %s)", new Object[] { str1, str2, str3, paramMap });
    if (i != 0)
    {
      AppMethodBeat.o(132276);
      return paramBundle;
    }
    int i = 2131232058;
    switch (k)
    {
    }
    for (;;)
    {
      paramMap = localContext.getResources().getDrawable(i);
      paramMap.setBounds(0, 0, o.aNT(), o.aNT());
      paramMap = new b(paramMap);
      paramString = new SpannableString("@ ");
      paramString.setSpan(paramMap, 0, 1, 33);
      paramMap = TextUtils.concat(new CharSequence[] { paramString, paramBundle });
      AppMethodBeat.o(132276);
      return paramMap;
      i = 2131232059;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.d
 * JD-Core Version:    0.7.0.1
 */