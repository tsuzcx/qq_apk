package com.tencent.mm.plugin.emojicapture.c;

import android.graphics.Matrix;
import com.tencent.mm.api.p;
import com.tencent.mm.plugin.emojicapture.model.a.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "touchMatrix", "Landroid/graphics/Matrix;", "destroy", "mix", "onBack", "", "onVoiceTextFinished", "voiceText", "", "pause", "removeBg", "resume", "setup", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "speedUp", "updateText", "text", "color", "", "change", "plugin-emojicapture_release"})
public abstract interface b$a
{
  public abstract boolean Kc();
  
  public abstract void a(p paramp, Matrix paramMatrix);
  
  public abstract void a(b paramb);
  
  public abstract void adb(String paramString);
  
  public abstract boolean ckv();
  
  public abstract boolean ckw();
  
  public abstract void ckx();
  
  public abstract void destroy();
  
  public abstract void m(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void pause();
  
  public abstract void resume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.c.b.a
 * JD-Core Version:    0.7.0.1
 */