package com.tencent.mm.emoji.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.layout.EmojiPanelLayoutManager;
import com.tencent.mm.ui.o.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/EmojiPanelGroupView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "scrollEnabled", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "setScrollEnable", "", "enable", "plugin-emojisdk_release"})
public final class EmojiPanelGroupView
  extends RecyclerView
{
  private final String TAG;
  private final b jKS;
  private boolean jKT;
  
  public EmojiPanelGroupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(105597);
    AppMethodBeat.o(105597);
  }
  
  public EmojiPanelGroupView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(105596);
    this.TAG = "MicroMsg.EmojiPanelGroupView";
    this.jKS = new b(paramContext);
    setItemViewCacheSize(0);
    AppMethodBeat.o(105596);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(105595);
    p.k(paramMotionEvent, "ev");
    this.jKS.at(paramMotionEvent);
    int i = this.jKS.XLC;
    Object localObject2 = getLayoutManager();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof EmojiPanelLayoutManager)) {
      localObject1 = null;
    }
    localObject1 = (EmojiPanelLayoutManager)localObject1;
    if (localObject1 != null)
    {
      if (!this.jKT) {
        break label116;
      }
      localObject2 = b.XLG;
      if (((i & 0x1) == 0) && ((i & 0x2) == 0)) {
        break label111;
      }
      i = 1;
      if (i != 0) {
        break label116;
      }
    }
    for (;;)
    {
      ((EmojiPanelLayoutManager)localObject1).jNh = bool;
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(105595);
      return bool;
      label111:
      i = 0;
      break;
      label116:
      bool = false;
    }
  }
  
  public final void setScrollEnable(boolean paramBoolean)
  {
    this.jKT = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.EmojiPanelGroupView
 * JD-Core Version:    0.7.0.1
 */