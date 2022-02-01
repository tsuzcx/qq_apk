package com.tencent.mm.emoji.loader.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "V", "Landroid/view/View;", "Lcom/tencent/mm/emoji/loader/request/Request;", "Landroid/graphics/drawable/Drawable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/view/View;)V", "weakView", "Ljava/lang/ref/WeakReference;", "getWeakView", "()Ljava/lang/ref/WeakReference;", "setWeakView", "(Ljava/lang/ref/WeakReference;)V", "cancel", "", "onLoad", "success", "", "Companion", "plugin-emojisdk_release"})
public abstract class j<V extends View>
  extends i<Drawable>
{
  private static final int fMn = 2131299384;
  public static final a fMo = new a((byte)0);
  WeakReference<V> fMm;
  
  public j(EmojiInfo paramEmojiInfo, V paramV)
  {
    super(paramEmojiInfo);
    this.fMm = new WeakReference(paramV);
    paramEmojiInfo = (i)paramV.getTag(fMn);
    if (paramEmojiInfo != null) {
      paramEmojiInfo.cancel();
    }
    paramV.setTag(fMn, this);
  }
  
  public void cancel()
  {
    super.cancel();
    Object localObject = this.fMm;
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ((View)localObject).setTag(fMn, null);
      }
      this.fMm = null;
      return;
    }
  }
  
  public void dg(boolean paramBoolean)
  {
    Object localObject = this.fMm;
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ((View)localObject).setTag(fMn, null);
      }
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/request/ViewRequest$Companion;", "", "()V", "TAG_ID", "", "getTAG_ID", "()I", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.j
 * JD-Core Version:    0.7.0.1
 */