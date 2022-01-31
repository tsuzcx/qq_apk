package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter;", "enable", "", "isFans", "isTmpUrl", "()I", "setTmpUrl", "(I)V", "onlyFansCanComment", "", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/MRecyclerView;", "selectedCommentTv", "Landroid/widget/TextView;", "writeCommentLayout", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout;", "writeTv", "onDeleteComment", "", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "openId", "setListView", "header", "Landroid/view/View;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "setWriteComment", "setWriteCommentLayout", "layout", "updateData", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentListResp;", "updateViewStatus", "BizCommentItemAdapter", "plugin-brandservice_release"})
public final class MPVideoCommentView
  extends RelativeLayout
{
  private final String TAG;
  private int eoD;
  private TextView kgt;
  private TextView kgu;
  private MPWriteCommentLayout kgv;
  private int kgw;
  int kgx;
  
  public MPVideoCommentView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(15245);
    this.TAG = "MicroMsg.MPVideoView_back";
    this.eoD = 1;
    this.kgw = 1;
    View.inflate(paramContext, 2130970308, (ViewGroup)this);
    paramAttributeSet = findViewById(2131826358);
    j.p(paramAttributeSet, "findViewById(R.id.biz_video_write_comment_tv)");
    this.kgt = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826357);
    j.p(paramAttributeSet, "findViewById(R.id.biz_video_selected_comment_tv)");
    this.kgu = ((TextView)paramAttributeSet);
    this.kgt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(15226);
        if (this.kgy.kgx == 1)
        {
          h.a(paramContext, paramContext.getString(2131301636), "", paramContext.getString(2131297018), null);
          AppMethodBeat.o(15226);
          return;
        }
        if (MPVideoCommentView.a(this.kgy) != null) {
          MPVideoCommentView.a(this.kgy).fQ(false);
        }
        AppMethodBeat.o(15226);
      }
    });
    AppMethodBeat.o(15245);
  }
  
  public final void setTmpUrl(int paramInt)
  {
    this.kgx = paramInt;
  }
  
  public final void setWriteCommentLayout(MPWriteCommentLayout paramMPWriteCommentLayout)
  {
    AppMethodBeat.i(152883);
    j.q(paramMPWriteCommentLayout, "layout");
    this.kgv = paramMPWriteCommentLayout;
    AppMethodBeat.o(152883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoCommentView
 * JD-Core Version:    0.7.0.1
 */