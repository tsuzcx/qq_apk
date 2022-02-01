package com.tencent.mm.plugin.finder.video.plugin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordFinishView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "plugin-finder_release"})
public final class SubRecordFinishView
  extends FrameLayout
{
  public SubRecordFinishView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(199940);
    LayoutInflater.from(paramContext).inflate(2131496256, (ViewGroup)this, true);
    ((WeImageView)findViewById(2131307879)).setIconColor(a.n(paramContext, 2131099777));
    AppMethodBeat.o(199940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.view.SubRecordFinishView
 * JD-Core Version:    0.7.0.1
 */