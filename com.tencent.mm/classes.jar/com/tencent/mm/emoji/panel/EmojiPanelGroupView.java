package com.tencent.mm.emoji.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.layout.EmojiPanelLayoutManager;
import com.tencent.mm.ui.o.b;
import com.tencent.mm.ui.o.b.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/EmojiPanelGroupView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "scrollEnabled", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "setScrollEnable", "", "enable", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiPanelGroupView
  extends RecyclerView
{
  private final String TAG;
  private final b mke;
  private boolean mkf;
  
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
    this.mke = new b(paramContext);
    setItemViewCacheSize(0);
    AppMethodBeat.o(105596);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105595);
    s.u(paramMotionEvent, "ev");
    this.mke.aw(paramMotionEvent);
    int i = this.mke.Irw;
    Object localObject = getLayoutManager();
    if ((localObject instanceof EmojiPanelLayoutManager))
    {
      localObject = (EmojiPanelLayoutManager)localObject;
      if (localObject != null)
      {
        if (!this.mkf) {
          break label115;
        }
        b.a locala = b.afBH;
        if (((i & 0x1) == 0) && ((i & 0x2) == 0)) {
          break label110;
        }
        i = 1;
        label79:
        if (i != 0) {
          break label115;
        }
      }
    }
    label110:
    label115:
    for (boolean bool = true;; bool = false)
    {
      ((EmojiPanelLayoutManager)localObject).mmg = bool;
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(105595);
      return bool;
      localObject = null;
      break;
      i = 0;
      break label79;
    }
  }
  
  public final void setScrollEnable(boolean paramBoolean)
  {
    this.mkf = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.EmojiPanelGroupView
 * JD-Core Version:    0.7.0.1
 */