package com.tencent.mm.plugin.emojicapture.c;

import android.graphics.Matrix;
import com.tencent.mm.api.t;
import com.tencent.mm.plugin.emojicapture.model.a.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "touchMatrix", "Landroid/graphics/Matrix;", "destroy", "mix", "onBack", "", "onVoiceTextFinished", "voiceText", "", "pause", "removeBg", "resume", "setup", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "speedUp", "updateText", "text", "color", "", "change", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b$a
{
  public abstract void a(t paramt, Matrix paramMatrix);
  
  public abstract void a(b paramb);
  
  public abstract boolean aAx();
  
  public abstract void api(String paramString);
  
  public abstract boolean dDx();
  
  public abstract boolean dDy();
  
  public abstract void dDz();
  
  public abstract void destroy();
  
  public abstract void pause();
  
  public abstract void resume();
  
  public abstract void s(String paramString, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.c.b.a
 * JD-Core Version:    0.7.0.1
 */