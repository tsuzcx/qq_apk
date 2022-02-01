package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiGridScrollView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastY", "getLastY", "()I", "setLastY", "(I)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeEmojiGridScrollView
  extends LinearLayout
{
  public static final a Jpn;
  private int EHM;
  
  static
  {
    AppMethodBeat.i(312722);
    Jpn = new a((byte)0);
    AppMethodBeat.o(312722);
  }
  
  public ImeEmojiGridScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(312707);
    AppMethodBeat.o(312707);
  }
  
  public ImeEmojiGridScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(312715);
    AppMethodBeat.o(312715);
  }
  
  public final int getLastY()
  {
    return this.EHM;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(312736);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(312736);
    return bool;
  }
  
  public final void setLastY(int paramInt)
  {
    this.EHM = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiGridScrollView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.ImeEmojiGridScrollView
 * JD-Core Version:    0.7.0.1
 */