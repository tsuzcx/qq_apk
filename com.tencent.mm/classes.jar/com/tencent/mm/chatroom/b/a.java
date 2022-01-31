package com.tencent.mm.chatroom.b;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class a
  implements e.b
{
  public com.tencent.mm.chatroom.d.a dmF = new com.tencent.mm.chatroom.d.a();
  
  public final CharSequence a(Map<String, String> paramMap, String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramMap = (String)paramMap.get(paramString + ".title");
    if (bk.bl(paramMap)) {
      return "";
    }
    paramString = j.b(ae.getContext(), paramMap);
    paramString.setSpan(new a.1(this, paramWeakReference, paramBundle), 0, paramMap.length(), 33);
    localSpannableStringBuilder.append(paramString);
    return localSpannableStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.a
 * JD-Core Version:    0.7.0.1
 */