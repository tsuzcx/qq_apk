package com.tencent.mm.plugin.brandservice.ui.timeline.img;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/img/MPImgLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "coverIV", "Landroid/widget/ImageView;", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "init", "", "initData", "plugin-brandservice_release"})
public final class MPImgLayout
  extends RelativeLayout
{
  private final String TAG;
  private ImageView mYy;
  
  public MPImgLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6537);
    this.TAG = "MicroMsg.MPImgLayout";
    View.inflate(getContext(), 2131494948, (ViewGroup)this);
    paramAttributeSet = findViewById(2131298824);
    k.g(paramAttributeSet, "findViewById(R.id.cover_iv)");
    this.mYy = ((ImageView)paramAttributeSet);
    k.h(paramContext, "context");
    AppMethodBeat.o(6537);
  }
  
  public MPImgLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6538);
    this.TAG = "MicroMsg.MPImgLayout";
    View.inflate(getContext(), 2131494948, (ViewGroup)this);
    paramAttributeSet = findViewById(2131298824);
    k.g(paramAttributeSet, "findViewById(R.id.cover_iv)");
    this.mYy = ((ImageView)paramAttributeSet);
    k.h(paramContext, "context");
    AppMethodBeat.o(6538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.img.MPImgLayout
 * JD-Core Version:    0.7.0.1
 */