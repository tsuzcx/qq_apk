package com.tencent.mm.emoji.loader.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "V", "Landroid/view/View;", "Lcom/tencent/mm/emoji/loader/request/Request;", "Landroid/graphics/drawable/Drawable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/view/View;)V", "weakView", "Ljava/lang/ref/WeakReference;", "getWeakView", "()Ljava/lang/ref/WeakReference;", "setWeakView", "(Ljava/lang/ref/WeakReference;)V", "cancel", "", "onLoad", "success", "", "Companion", "plugin-emojisdk_release"})
public abstract class j<V extends View>
  extends i<Drawable>
{
  private static final int gWI = 2131299997;
  public static final j.a gWJ = new j.a((byte)0);
  WeakReference<V> gWH;
  
  public j(EmojiInfo paramEmojiInfo, V paramV)
  {
    super(paramEmojiInfo);
    this.gWH = new WeakReference(paramV);
    paramEmojiInfo = (i)paramV.getTag(gWI);
    if (paramEmojiInfo != null) {
      paramEmojiInfo.cancel();
    }
    paramV.setTag(gWI, this);
  }
  
  public void cancel()
  {
    super.cancel();
    Object localObject = this.gWH;
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ((View)localObject).setTag(gWI, null);
      }
      this.gWH = null;
      return;
    }
  }
  
  public void dR(boolean paramBoolean)
  {
    Object localObject = this.gWH;
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ((View)localObject).setTag(gWI, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.j
 * JD-Core Version:    0.7.0.1
 */