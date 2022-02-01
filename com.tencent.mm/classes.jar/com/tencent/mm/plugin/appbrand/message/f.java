package com.tencent.mm.plugin.appbrand.message;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.l;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.widget.g.b;
import com.tencent.mm.plugin.appbrand.y.o;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class f
  implements e.b
{
  public final CharSequence a(final Map<String, String> paramMap, final String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(222847);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      ae.w("MicroMsg.WxaSysTemplateMsgHandler", "values map is null or nil");
      AppMethodBeat.o(222847);
      return null;
    }
    Context localContext = (Context)paramWeakReference.get();
    if (localContext == null)
    {
      ae.w("MicroMsg.WxaSysTemplateMsgHandler", "context is null");
      AppMethodBeat.o(222847);
      return null;
    }
    final String str2 = (String)paramMap.get(paramString + ".title");
    final String str3 = (String)paramMap.get(paramString + ".username");
    final int m = bu.getInt((String)paramMap.get(paramString + ".type"), 0);
    int k = bu.getInt((String)paramMap.get(paramString + ".wxaapp_type"), 0);
    final String str4 = (String)paramMap.get(paramString + ".path");
    label269:
    final int j;
    label281:
    final long l;
    if (bu.getInt((String)paramMap.get(paramString + ".forbids"), 0) == 1)
    {
      i = 1;
      if (paramBundle == null) {
        break label333;
      }
      paramString = paramBundle.getString("conv_talker_username");
      if (paramBundle == null) {
        break label339;
      }
      j = paramBundle.getInt("scene");
      if (paramBundle == null) {
        break label345;
      }
      l = paramBundle.getLong("msg_sever_id");
      label293:
      if (paramBundle == null) {
        break label351;
      }
    }
    label333:
    label339:
    label345:
    label351:
    for (String str1 = paramBundle.getString("send_msg_username");; str1 = "")
    {
      if (!bu.isNullOrNil(str2)) {
        break label358;
      }
      ae.w("MicroMsg.WxaSysTemplateMsgHandler", "link title is null or nil");
      AppMethodBeat.o(222847);
      return null;
      i = 0;
      break;
      paramString = "";
      break label269;
      j = 0;
      break label281;
      l = 0L;
      break label293;
    }
    label358:
    SpannableString localSpannableString = new SpannableString(str2);
    localSpannableString.setSpan(new a()
    {
      public final void onClickImp(View paramAnonymousView)
      {
        AppMethodBeat.i(47716);
        ae.i("MicroMsg.WxaSysTemplateMsgHandler", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", new Object[] { str2, str3, str4, paramString });
        paramWeakReference.get();
        Object localObject = new Bundle();
        ((Bundle)localObject).putInt("stat_scene", j);
        ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(l));
        ((Bundle)localObject).putString("stat_chat_talker_username", paramString);
        ((Bundle)localObject).putString("stat_send_msg_user", m);
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1088;
        localAppBrandStatObject.dlj = "";
        localAppBrandStatObject.dLf = l.l(localAppBrandStatObject.scene, (Bundle)localObject);
        localAppBrandStatObject.dLg = l.m(localAppBrandStatObject.scene, (Bundle)localObject);
        String str = "";
        localObject = str;
        if (str4 != null)
        {
          localObject = str;
          if (str4.length() > 0)
          {
            byte[] arrayOfByte = Base64.decode(str4, 2);
            localObject = str;
            if (arrayOfByte != null) {
              localObject = new String(arrayOfByte);
            }
          }
        }
        ((p)g.ab(p.class)).a(paramAnonymousView.getContext(), str3, null, paramMap, 0, (String)localObject, localAppBrandStatObject);
        ((e)g.ab(e.class)).a("link_view_wxapp", paramBundle, paramWeakReference1);
        AppMethodBeat.o(47716);
      }
    }, 0, str2.length(), 17);
    ae.d("MicroMsg.WxaSysTemplateMsgHandler", "handleTemplate(title : %s, username : %s, path : %s, talker : %s)", new Object[] { str2, str3, str4, paramString });
    if ((i != 0) || (k == 2))
    {
      AppMethodBeat.o(222847);
      return localSpannableString;
    }
    int i = 2131691249;
    switch (k)
    {
    }
    for (;;)
    {
      paramMap = localContext.getResources().getDrawable(i);
      paramMap.setBounds(0, 0, o.vP(16), o.vP(16));
      paramMap = new b(paramMap);
      paramString = new SpannableString("@ ");
      paramString.setSpan(paramMap, 0, 1, 33);
      paramMap = TextUtils.concat(new CharSequence[] { paramString, localSpannableString });
      AppMethodBeat.o(222847);
      return paramMap;
      i = 2131691252;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.f
 * JD-Core Version:    0.7.0.1
 */