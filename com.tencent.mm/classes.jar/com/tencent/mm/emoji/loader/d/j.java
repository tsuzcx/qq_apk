package com.tencent.mm.emoji.loader.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "V", "Landroid/view/View;", "Lcom/tencent/mm/emoji/loader/request/Request;", "Landroid/graphics/drawable/Drawable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/view/View;)V", "weakView", "Ljava/lang/ref/WeakReference;", "getWeakView", "()Ljava/lang/ref/WeakReference;", "setWeakView", "(Ljava/lang/ref/WeakReference;)V", "cancel", "", "onLoad", "success", "", "Companion", "plugin-emojisdk_release"})
public abstract class j<V extends View>
  extends i<Drawable>
{
  public static final j.a gjA = new j.a((byte)0);
  private static final int gjz = 2131299384;
  WeakReference<V> gjy;
  
  public j(EmojiInfo paramEmojiInfo, V paramV)
  {
    super(paramEmojiInfo);
    this.gjy = new WeakReference(paramV);
    paramEmojiInfo = (i)paramV.getTag(gjz);
    if (paramEmojiInfo != null) {
      paramEmojiInfo.cancel();
    }
    paramV.setTag(gjz, this);
  }
  
  public void cancel()
  {
    super.cancel();
    Object localObject = this.gjy;
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ((View)localObject).setTag(gjz, null);
      }
      this.gjy = null;
      return;
    }
  }
  
  public void dh(boolean paramBoolean)
  {
    Object localObject = this.gjy;
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ((View)localObject).setTag(gjz, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.j
 * JD-Core Version:    0.7.0.1
 */