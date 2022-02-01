package com.tencent.mm.plugin.messenger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;

final class PluginMessenger$8
  implements e.b
{
  PluginMessenger$8(PluginMessenger paramPluginMessenger) {}
  
  public final CharSequence a(final Map<String, String> paramMap, String paramString, Bundle paramBundle, final WeakReference<Context> paramWeakReference, WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(211829);
    if (paramMap == null)
    {
      AppMethodBeat.o(211829);
      return null;
    }
    paramBundle = bt.nullAsNil((String)paramMap.get(paramString + ".title"));
    paramMap = (String)paramMap.get(paramString + ".url");
    paramString = new SpannableString(paramBundle);
    if (!TextUtils.isEmpty(paramMap)) {
      paramString.setSpan(new a()
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(211828);
          paramAnonymousView = (Context)paramWeakReference.get();
          if (paramAnonymousView != null)
          {
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramMap);
            d.b(paramAnonymousView, "webview", ".ui.tools.WebViewUI", localIntent);
          }
          AppMethodBeat.o(211828);
        }
      }, 0, paramBundle.length(), 33);
    }
    AppMethodBeat.o(211829);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.8
 * JD-Core Version:    0.7.0.1
 */