package com.tencent.mm.plugin.emojicapture.c;

import android.graphics.Matrix;
import com.tencent.mm.api.r;
import com.tencent.mm.plugin.emojicapture.model.a.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "touchMatrix", "Landroid/graphics/Matrix;", "destroy", "mix", "onBack", "", "onVoiceTextFinished", "voiceText", "", "pause", "removeBg", "resume", "setup", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "speedUp", "updateText", "text", "color", "", "change", "plugin-emojicapture_release"})
public abstract interface b$a
{
  public abstract boolean YD();
  
  public abstract void a(r paramr, Matrix paramMatrix);
  
  public abstract void a(b paramb);
  
  public abstract void avi(String paramString);
  
  public abstract boolean cXg();
  
  public abstract boolean cXh();
  
  public abstract void cXi();
  
  public abstract void destroy();
  
  public abstract void pause();
  
  public abstract void r(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void resume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.c.b.a
 * JD-Core Version:    0.7.0.1
 */