package com.tencent.mm.emojisearch.ui;

import android.content.Context;
import androidx.appcompat.app.e;
import com.tencent.mm.kernel.c.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emojisearch/ui/IEmojiSearchService;", "Lcom/tencent/mm/kernel/service/IService;", "genSearchRequestId", "", "genSearchSessionId", "startEmojiSearchDialog", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "talker", "toSendText", "listener", "Lcom/tencent/mm/emojisearch/ui/IEmojiSearchDialogListener;", "sessionId", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
  extends a
{
  public abstract e a(Context paramContext, String paramString1, String paramString2, b paramb, String paramString3);
  
  public abstract String aWX();
  
  public abstract String aWY();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emojisearch.ui.c
 * JD-Core Version:    0.7.0.1
 */