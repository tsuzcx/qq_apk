package com.tencent.mm.plugin.emojicapture.c;

import com.tencent.mm.plugin.emojicapture.model.a.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "", "destroy", "", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getVideoPlayView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "isShow", "", "isShowSmileyPanel", "isShowTextEditor", "reset", "setup", "captureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "videoPath", "", "removeBgEnable", "removeBg", "videoPreparedCallback", "Lkotlin/Function0;", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "", "viewPrepared", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b$b
{
  public abstract void a(b paramb, String paramString, boolean paramBoolean1, boolean paramBoolean2, a<ah> parama);
  
  public abstract void a(boolean paramBoolean, CharSequence paramCharSequence, int paramInt);
  
  public abstract boolean cvt();
  
  public abstract void dDA();
  
  public abstract boolean dDB();
  
  public abstract boolean dDC();
  
  public abstract void destroy();
  
  public abstract EditorItemContainer getItemContainer();
  
  public abstract EmojiVideoPlayTextureView getVideoPlayView();
  
  public abstract void oo(boolean paramBoolean);
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.c.b.b
 * JD-Core Version:    0.7.0.1
 */