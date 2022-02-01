package com.tencent.mm.emoji.b.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "V", "Landroid/view/View;", "Lcom/tencent/mm/emoji/loader/request/Request;", "Landroid/graphics/drawable/Drawable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/view/View;)V", "weakView", "Ljava/lang/ref/WeakReference;", "getWeakView", "()Ljava/lang/ref/WeakReference;", "setWeakView", "(Ljava/lang/ref/WeakReference;)V", "cancel", "", "onLoad", "success", "", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class i<V extends View>
  extends h<Drawable>
{
  public static final i.a mhi = new i.a((byte)0);
  private static final int mhk = a.g.emoji_loader_target_tag;
  WeakReference<V> mhj;
  
  public i(EmojiInfo paramEmojiInfo, V paramV)
  {
    super(paramEmojiInfo);
    this.mhj = new WeakReference(paramV);
    paramEmojiInfo = (h)paramV.getTag(mhk);
    if (paramEmojiInfo != null) {
      paramEmojiInfo.cancel();
    }
    paramV.setTag(mhk, this);
  }
  
  public void cancel()
  {
    super.cancel();
    Object localObject = this.mhj;
    if (localObject == null) {}
    for (localObject = null;; localObject = (View)((WeakReference)localObject).get())
    {
      if (localObject != null) {
        ((View)localObject).setTag(mhk, null);
      }
      this.mhj = null;
      return;
    }
  }
  
  public void fc(boolean paramBoolean)
  {
    Object localObject = this.mhj;
    if (localObject == null) {}
    for (localObject = null;; localObject = (View)((WeakReference)localObject).get())
    {
      if (localObject != null) {
        ((View)localObject).setTag(mhk, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.d.i
 * JD-Core Version:    0.7.0.1
 */