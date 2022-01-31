package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPPreviewBar;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "closeBtn", "Landroid/widget/Button;", "root", "Landroid/view/View;", "plugin-brandservice_release"})
public final class MPPreviewBar
  extends RelativeLayout
{
  private Button kgq;
  private View kgr;
  
  public MPPreviewBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(15225);
    View.inflate(paramContext, 2130970305, (ViewGroup)this);
    paramContext = findViewById(2131826349);
    j.p(paramContext, "findViewById(R.id.biz_video_close_btn)");
    this.kgq = ((Button)paramContext);
    paramContext = findViewById(2131826348);
    j.p(paramContext, "findViewById(R.id.biz_video_preview_layout)");
    this.kgr = paramContext;
    this.kgq.setOnClickListener((View.OnClickListener)new MPPreviewBar.1(this));
    AppMethodBeat.o(15225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPPreviewBar
 * JD-Core Version:    0.7.0.1
 */