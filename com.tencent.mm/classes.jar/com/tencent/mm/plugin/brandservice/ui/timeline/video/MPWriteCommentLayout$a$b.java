package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$BizVideoMyCommentItemAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "content", "Landroid/widget/LinearLayout;", "getContent", "()Landroid/widget/LinearLayout;", "endlineLayout", "getEndlineLayout", "setEndlineLayout", "(Landroid/widget/LinearLayout;)V", "fansContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentContent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$BizVideoMyCommentItemAdapter;", "getFansContent", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentContent;", "setFansContent", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentContent;)V", "fansLayout", "getFansLayout", "setFansLayout", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "plugin-brandservice_release"})
public final class MPWriteCommentLayout$a$b
{
  final ImageView gxs;
  private final LinearLayout khG;
  private LinearLayout khH;
  LinearLayout khI;
  MPWriteCommentLayout.a.a khJ;
  
  public MPWriteCommentLayout$a$b(View paramView)
  {
    AppMethodBeat.i(152901);
    this.gxs = ((ImageView)((View)localObject).findViewById(2131826342));
    this.khG = ((LinearLayout)((View)localObject).findViewById(2131826343));
    this.khH = ((LinearLayout)((View)localObject).findViewById(2131826344));
    this.khI = ((LinearLayout)((View)localObject).findViewById(2131826346));
    Object localObject = this.khH;
    j.p(localObject, "fansLayout");
    this.khJ = new MPWriteCommentLayout.a.a(paramView, (View)localObject);
    AppMethodBeat.o(152901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout.a.b
 * JD-Core Version:    0.7.0.1
 */