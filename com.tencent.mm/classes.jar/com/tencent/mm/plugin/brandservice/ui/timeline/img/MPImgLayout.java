package com.tencent.mm.plugin.brandservice.ui.timeline.img;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.s;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/img/MPImgLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "coverIV", "Landroid/widget/ImageView;", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "init", "", "initData", "plugin-brandservice_release"})
public final class MPImgLayout
  extends RelativeLayout
{
  private final String TAG;
  public s jXm;
  public b jXn;
  public ImageView jXo;
  
  public MPImgLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(152676);
    this.TAG = "MicroMsg.MPImgLayout";
    View.inflate(getContext(), 2130970304, (ViewGroup)this);
    View localView = findViewById(2131821891);
    j.p(localView, "findViewById(R.id.cover_iv)");
    this.jXo = ((ImageView)localView);
    j.q(paramContext, "context");
    AppMethodBeat.o(152676);
  }
  
  public MPImgLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152677);
    this.TAG = "MicroMsg.MPImgLayout";
    View.inflate(getContext(), 2130970304, (ViewGroup)this);
    paramAttributeSet = findViewById(2131821891);
    j.p(paramAttributeSet, "findViewById(R.id.cover_iv)");
    this.jXo = ((ImageView)paramAttributeSet);
    j.q(paramContext, "context");
    AppMethodBeat.o(152677);
  }
  
  public MPImgLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(152678);
    this.TAG = "MicroMsg.MPImgLayout";
    View.inflate(getContext(), 2130970304, (ViewGroup)this);
    paramAttributeSet = findViewById(2131821891);
    j.p(paramAttributeSet, "findViewById(R.id.cover_iv)");
    this.jXo = ((ImageView)paramAttributeSet);
    j.q(paramContext, "context");
    AppMethodBeat.o(152678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.img.MPImgLayout
 * JD-Core Version:    0.7.0.1
 */