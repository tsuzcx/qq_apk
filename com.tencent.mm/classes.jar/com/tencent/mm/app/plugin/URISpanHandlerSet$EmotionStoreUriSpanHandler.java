package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

@URISpanHandlerSet.a
class URISpanHandlerSet$EmotionStoreUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$EmotionStoreUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    if (paramm.type == 29)
    {
      if (paramg != null) {
        paramg.a(paramm);
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("download_entrance_scene", 21);
      localIntent.putExtra("extra_id", (String)paramm.S(String.class));
      localIntent.putExtra("preceding_scence", 3);
      d.b(URISpanHandlerSet.a(this.byk), "emoji", ".ui.EmojiStoreDetailUI", localIntent);
      if (paramg != null) {
        paramg.b(paramm);
      }
      return true;
    }
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().startsWith("weixin://emoticonstore/"))
    {
      int i = paramString.lastIndexOf("/");
      String str = "";
      if (i != -1) {
        str = paramString.substring(i + 1);
      }
      return new m(paramString, 29, str);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 29 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.EmotionStoreUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */