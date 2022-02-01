package com.tencent.mm.plugin.emojicapture.c;

import com.tencent.mm.plugin.emojicapture.model.a.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import d.g.a.a;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "", "destroy", "", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getVideoPlayView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "isShow", "", "isShowSmileyPanel", "isShowTextEditor", "reset", "setup", "captureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "videoPath", "", "removeBgEnable", "removeBg", "videoPreparedCallback", "Lkotlin/Function0;", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "", "viewPrepared", "plugin-emojicapture_release"})
public abstract interface b$b
{
  public abstract void a(b paramb, String paramString, boolean paramBoolean1, boolean paramBoolean2, a<z> parama);
  
  public abstract void a(boolean paramBoolean, CharSequence paramCharSequence, int paramInt);
  
  public abstract boolean bnS();
  
  public abstract boolean ckA();
  
  public abstract void cky();
  
  public abstract boolean ckz();
  
  public abstract void destroy();
  
  public abstract EditorItemContainer getItemContainer();
  
  public abstract EmojiVideoPlayTextureView getVideoPlayView();
  
  public abstract void kC(boolean paramBoolean);
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.c.b.b
 * JD-Core Version:    0.7.0.1
 */