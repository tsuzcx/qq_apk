package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiGridScrollView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastY", "getLastY", "()I", "setLastY", "(I)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "Companion", "plugin-hld_release"})
public final class ImeEmojiGridScrollView
  extends LinearLayout
{
  public static final a Dwh;
  private int zDE;
  
  static
  {
    AppMethodBeat.i(217682);
    Dwh = new a((byte)0);
    AppMethodBeat.o(217682);
  }
  
  public ImeEmojiGridScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(217679);
    AppMethodBeat.o(217679);
  }
  
  public ImeEmojiGridScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(217680);
    AppMethodBeat.o(217680);
  }
  
  public final int getLastY()
  {
    return this.zDE;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217678);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(217678);
    return bool;
  }
  
  public final void setLastY(int paramInt)
  {
    this.zDE = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiGridScrollView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.ImeEmojiGridScrollView
 * JD-Core Version:    0.7.0.1
 */