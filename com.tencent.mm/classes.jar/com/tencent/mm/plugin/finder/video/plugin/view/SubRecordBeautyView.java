package com.tencent.mm.plugin.finder.video.plugin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.finder.publish.l.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/plugin/view/SubRecordBeautyView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SubRecordBeautyView
  extends FrameLayout
{
  public SubRecordBeautyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(335686);
    LayoutInflater.from(paramContext).inflate(l.f.finder_sub_record_beauty_layout, (ViewGroup)this, true);
    setContentDescription((CharSequence)a.bt(paramContext, l.i.Fik));
    AppMethodBeat.o(335686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.view.SubRecordBeautyView
 * JD-Core Version:    0.7.0.1
 */