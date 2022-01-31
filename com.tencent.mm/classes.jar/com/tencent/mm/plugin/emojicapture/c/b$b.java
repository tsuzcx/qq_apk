package com.tencent.mm.plugin.emojicapture.c;

import a.l;
import a.y;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "", "destroy", "", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getVideoPlayView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "isShow", "", "isShowSmileyPanel", "isShowTextEditor", "reset", "setup", "captureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "videoPath", "", "removeBgEnable", "removeBg", "videoPreparedCallback", "Lkotlin/Function0;", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "", "viewPrepared", "plugin-emojicapture_release"})
public abstract interface b$b
{
  public abstract boolean Pk();
  
  public abstract void a(com.tencent.mm.plugin.emojicapture.model.a.a parama, String paramString, boolean paramBoolean1, boolean paramBoolean2, a.f.a.a<y> parama1);
  
  public abstract void a(boolean paramBoolean, CharSequence paramCharSequence, int paramInt);
  
  public abstract void bnD();
  
  public abstract boolean bnE();
  
  public abstract boolean bnF();
  
  public abstract void destroy();
  
  public abstract void gT(boolean paramBoolean);
  
  public abstract EditorItemContainer getItemContainer();
  
  public abstract EmojiVideoPlayTextureView getVideoPlayView();
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.c.b.b
 * JD-Core Version:    0.7.0.1
 */