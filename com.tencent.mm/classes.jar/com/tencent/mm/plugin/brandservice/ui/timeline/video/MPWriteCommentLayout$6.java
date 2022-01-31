package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import a.v;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPSmileyFooter;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MPWriteCommentLayout$6
  implements View.OnClickListener
{
  MPWriteCommentLayout$6(MPWriteCommentLayout paramMPWriteCommentLayout, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(152898);
    if (MPWriteCommentLayout.g(this.khv))
    {
      paramView = MPWriteCommentLayout.e(this.khv).getText().toString();
      Object localObject = this.hEq;
      if (localObject == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        AppMethodBeat.o(152898);
        throw paramView;
      }
      localObject = ((WebViewUI)localObject).uQS;
      if (localObject != null)
      {
        ((d)localObject).o(1, paramView, 1);
        AppMethodBeat.o(152898);
        return;
      }
      AppMethodBeat.o(152898);
      return;
    }
    paramView = this.hEq;
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(152898);
      throw paramView;
    }
    ((MMActivity)paramView).hideVKB();
    if (MPWriteCommentLayout.b(this.khv).bad()) {
      MPWriteCommentLayout.b(this.khv).bae();
    }
    paramView = new eo();
    paramView.content = MPWriteCommentLayout.e(this.khv).getText().toString();
    paramView.knS = 1;
    this.khv.a(paramView);
    b.Ko(10);
    AppMethodBeat.o(152898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout.6
 * JD-Core Version:    0.7.0.1
 */