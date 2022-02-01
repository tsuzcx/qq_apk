package com.tencent.mm.plugin.biz;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI;

final class PluginBiz$1
  extends com.tencent.mm.msgsubscription.storage.a
{
  PluginBiz$1(PluginBiz paramPluginBiz) {}
  
  public final com.tencent.mm.msgsubscription.storage.d aOQ()
  {
    return b.hVA;
  }
  
  public final void k(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(124337);
    Intent localIntent = new Intent(paramContext, BizSubscribeMsgManagerUI.class);
    localIntent.putExtra("key_biz_username", paramString1);
    localIntent.putExtra("key_biz_nickname", paramString2);
    localIntent.putExtra("key_biz_presenter_class", com.tencent.mm.al.b.a.class.getName());
    localIntent.putExtra("key_need_update", true);
    localIntent.putExtra("key_need_load_from_remote", true);
    com.tencent.mm.br.d.f(paramContext, "com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI", localIntent);
    AppMethodBeat.o(124337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.biz.PluginBiz.1
 * JD-Core Version:    0.7.0.1
 */