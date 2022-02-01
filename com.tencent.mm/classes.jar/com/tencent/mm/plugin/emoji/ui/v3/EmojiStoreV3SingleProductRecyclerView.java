package com.tencent.mm.plugin.emoji.ui.v3;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.ui.v3.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3SingleProductRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "onSizeChangedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "spanCount", "", "getOnSizeChangedCallback", "()Lkotlin/jvm/functions/Function1;", "setOnSizeChangedCallback", "(Lkotlin/jvm/functions/Function1;)V", "sizeResolver", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;", "getSizeResolver", "()Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;", "setSizeResolver", "(Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;)V", "onMeasure", "widthSpec", "heightSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiStoreV3SingleProductRecyclerView
  extends RecyclerView
{
  private final String TAG;
  private k xZu;
  private b<? super Integer, ah> yaN;
  
  public EmojiStoreV3SingleProductRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(270480);
    AppMethodBeat.o(270480);
  }
  
  public EmojiStoreV3SingleProductRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(270473);
    this.TAG = "MicroMsg.EmojiStoreV3SingleProductRecyclerView";
    AppMethodBeat.o(270473);
  }
  
  public final b<Integer, ah> getOnSizeChangedCallback()
  {
    return this.yaN;
  }
  
  public final k getSizeResolver()
  {
    return this.xZu;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(270513);
    Object localObject;
    k localk;
    if (this.xZu != null)
    {
      localObject = getLayoutManager();
      if (!(localObject instanceof GridLayoutManager)) {
        break label69;
      }
      localObject = (GridLayoutManager)localObject;
      if (localObject != null)
      {
        localk = getSizeResolver();
        if (localk != null) {
          break label75;
        }
      }
    }
    label69:
    label75:
    for (int i = 0;; i = localk.spanCount)
    {
      ((GridLayoutManager)localObject).fI(i);
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(270513);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(270505);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i(this.TAG, "onSizeChanged w:" + paramInt1 + ", h:" + paramInt2 + ", oldw::" + paramInt3 + ", oldH:" + paramInt4);
    k localk = this.xZu;
    if (localk != null)
    {
      localk.KI(paramInt1);
      localObject = getLayoutManager();
      if (!(localObject instanceof GridLayoutManager)) {
        break label162;
      }
    }
    label162:
    for (Object localObject = (GridLayoutManager)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((GridLayoutManager)localObject).fI(localk.spanCount);
      }
      localObject = getOnSizeChangedCallback();
      if (localObject != null) {
        ((b)localObject).invoke(Integer.valueOf(localk.spanCount));
      }
      if (getItemDecorationCount() > 0) {
        Kp();
      }
      AppMethodBeat.o(270505);
      return;
    }
  }
  
  public final void setOnSizeChangedCallback(b<? super Integer, ah> paramb)
  {
    this.yaN = paramb;
  }
  
  public final void setSizeResolver(k paramk)
  {
    this.xZu = paramk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.EmojiStoreV3SingleProductRecyclerView
 * JD-Core Version:    0.7.0.1
 */