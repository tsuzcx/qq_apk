package com.tencent.mm.emoji.loader.d;

import a.l;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "V", "Landroid/view/View;", "Lcom/tencent/mm/emoji/loader/request/Request;", "Landroid/graphics/drawable/Drawable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/view/View;)V", "weakView", "Ljava/lang/ref/WeakReference;", "getWeakView", "()Ljava/lang/ref/WeakReference;", "setWeakView", "(Ljava/lang/ref/WeakReference;)V", "cancel", "", "onLoad", "success", "", "Companion", "plugin-emojisdk_release"})
public abstract class i<V extends View>
  extends h<Drawable>
{
  private static final int ewa = 2131820596;
  public static final a ewb = new a((byte)0);
  WeakReference<V> evZ;
  
  public i(EmojiInfo paramEmojiInfo, V paramV)
  {
    super(paramEmojiInfo);
    this.evZ = new WeakReference(paramV);
    paramEmojiInfo = (h)paramV.getTag(ewa);
    if (paramEmojiInfo != null) {
      paramEmojiInfo.cancel();
    }
    paramV.setTag(ewa, this);
  }
  
  public void cancel()
  {
    super.cancel();
    Object localObject = this.evZ;
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ((View)localObject).setTag(ewa, null);
      }
      this.evZ = null;
      return;
    }
  }
  
  public void cf(boolean paramBoolean)
  {
    Object localObject = this.evZ;
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ((View)localObject).setTag(ewa, null);
      }
      return;
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/request/ViewRequest$Companion;", "", "()V", "TAG_ID", "", "getTAG_ID", "()I", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.i
 * JD-Core Version:    0.7.0.1
 */