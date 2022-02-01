package com.tencent.mm.plugin.finder.video.plugin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "plugin-finder_release"})
public final class SubRecordFinishView
  extends FrameLayout
{
  public SubRecordFinishView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(291610);
    LayoutInflater.from(paramContext).inflate(b.g.finder_sub_record_finish_layout, (ViewGroup)this, true);
    ((WeImageView)findViewById(b.f.sub_video_finish)).setIconColor(a.w(paramContext, b.c.Orange));
    AppMethodBeat.o(291610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.view.SubRecordFinishView
 * JD-Core Version:    0.7.0.1
 */