package com.tencent.mm.plugin.emojicapture.ui;

import a.l;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.emojicapture.model.a.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
public abstract interface EmojiCaptureUI$b
{
  public abstract void Lp(String paramString);
  
  public abstract void a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract void boQ();
  
  public abstract void boR();
  
  public abstract void boS();
  
  public abstract void c(a parama);
  
  public abstract void m(boolean paramBoolean, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b
 * JD-Core Version:    0.7.0.1
 */