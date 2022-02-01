package com.tencent.mm.emoji.loader.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "V", "Landroid/view/View;", "Lcom/tencent/mm/emoji/loader/request/Request;", "Landroid/graphics/drawable/Drawable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/view/View;)V", "weakView", "Ljava/lang/ref/WeakReference;", "getWeakView", "()Ljava/lang/ref/WeakReference;", "setWeakView", "(Ljava/lang/ref/WeakReference;)V", "cancel", "", "onLoad", "success", "", "Companion", "plugin-emojisdk_release"})
public abstract class j<V extends View>
  extends i<Drawable>
{
  private static final int glR = 2131299384;
  public static final j.a glS = new j.a((byte)0);
  WeakReference<V> glQ;
  
  public j(EmojiInfo paramEmojiInfo, V paramV)
  {
    super(paramEmojiInfo);
    this.glQ = new WeakReference(paramV);
    paramEmojiInfo = (i)paramV.getTag(glR);
    if (paramEmojiInfo != null) {
      paramEmojiInfo.cancel();
    }
    paramV.setTag(glR, this);
  }
  
  public void cancel()
  {
    super.cancel();
    Object localObject = this.glQ;
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ((View)localObject).setTag(glR, null);
      }
      this.glQ = null;
      return;
    }
  }
  
  public void dh(boolean paramBoolean)
  {
    Object localObject = this.glQ;
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ((View)localObject).setTag(glR, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.j
 * JD-Core Version:    0.7.0.1
 */