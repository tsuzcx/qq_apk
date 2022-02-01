package com.tencent.mm.plugin.appbrand.n;

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
import com.tencent.mm.plugin.appbrand.widget.g.b;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.a.f.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class e
  implements f.b
{
  public final CharSequence a(final Map<String, String> paramMap, final String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(196050);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      ad.w("MicroMsg.WxaSysTemplateMsgHandler", "values map is null or nil");
      AppMethodBeat.o(196050);
      return null;
    }
    Context localContext = (Context)paramWeakReference.get();
    if (localContext == null)
    {
      ad.w("MicroMsg.WxaSysTemplateMsgHandler", "context is null");
      AppMethodBeat.o(196050);
      return null;
    }
    final String str2 = (String)paramMap.get(paramString + ".title");
    final String str3 = (String)paramMap.get(paramString + ".username");
    final int m = bt.getInt((String)paramMap.get(paramString + ".type"), 0);
    int k = bt.getInt((String)paramMap.get(paramString + ".wxaapp_type"), 0);
    final String str4 = (String)paramMap.get(paramString + ".path");
    label269:
    final int j;
    label281:
    final long l;
    if (bt.getInt((String)paramMap.get(paramString + ".forbids"), 0) == 1)
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
      if (!bt.isNullOrNil(str2)) {
        break label358;
      }
      ad.w("MicroMsg.WxaSysTemplateMsgHandler", "link title is null or nil");
      AppMethodBeat.o(196050);
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
        ad.i("MicroMsg.WxaSysTemplateMsgHandler", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", new Object[] { str2, str3, str4, paramString });
        paramWeakReference.get();
        Object localObject = new Bundle();
        ((Bundle)localObject).putInt("stat_scene", j);
        ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(l));
        ((Bundle)localObject).putString("stat_chat_talker_username", paramString);
        ((Bundle)localObject).putString("stat_send_msg_user", m);
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1088;
        localAppBrandStatObject.dbt = "";
        localAppBrandStatObject.dzS = l.k(localAppBrandStatObject.scene, (Bundle)localObject);
        localAppBrandStatObject.dzT = l.l(localAppBrandStatObject.scene, (Bundle)localObject);
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
        ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(paramAnonymousView.getContext(), str3, null, paramMap, 0, (String)localObject, localAppBrandStatObject);
        ((f)g.ab(f.class)).a("link_view_wxapp", paramBundle, paramWeakReference1);
        AppMethodBeat.o(47716);
      }
    }, 0, str2.length(), 17);
    ad.d("MicroMsg.WxaSysTemplateMsgHandler", "handleTemplate(title : %s, username : %s, path : %s, talker : %s)", new Object[] { str2, str3, str4, paramString });
    if ((i != 0) || (k == 2))
    {
      AppMethodBeat.o(196050);
      return localSpannableString;
    }
    int i = 2131691249;
    switch (k)
    {
    }
    for (;;)
    {
      paramMap = localContext.getResources().getDrawable(i);
      paramMap.setBounds(0, 0, com.tencent.mm.plugin.appbrand.aa.n.bqn(), com.tencent.mm.plugin.appbrand.aa.n.bqn());
      paramMap = new b(paramMap);
      paramString = new SpannableString("@ ");
      paramString.setSpan(paramMap, 0, 1, 33);
      paramMap = TextUtils.concat(new CharSequence[] { paramString, localSpannableString });
      AppMethodBeat.o(196050);
      return paramMap;
      i = 2131691252;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.e
 * JD-Core Version:    0.7.0.1
 */