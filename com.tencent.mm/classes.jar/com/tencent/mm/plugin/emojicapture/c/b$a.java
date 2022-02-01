package com.tencent.mm.plugin.emojicapture.c;

import android.graphics.Matrix;
import com.tencent.mm.api.r;
import com.tencent.mm.plugin.emojicapture.model.a.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "touchMatrix", "Landroid/graphics/Matrix;", "destroy", "mix", "onBack", "", "onVoiceTextFinished", "voiceText", "", "pause", "removeBg", "resume", "setup", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "speedUp", "updateText", "text", "color", "", "change", "plugin-emojicapture_release"})
public abstract interface b$a
{
  public abstract boolean Ul();
  
  public abstract void a(r paramr, Matrix paramMatrix);
  
  public abstract void a(b paramb);
  
  public abstract void ank(String paramString);
  
  public abstract boolean cIx();
  
  public abstract boolean cIy();
  
  public abstract void cIz();
  
  public abstract void destroy();
  
  public abstract void n(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void pause();
  
  public abstract void resume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.c.b.a
 * JD-Core Version:    0.7.0.1
 */