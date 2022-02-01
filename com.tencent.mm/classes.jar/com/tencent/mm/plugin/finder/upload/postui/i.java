package com.tencent.mm.plugin.finder.upload.postui;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.FinderTencentVideoChooseView;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.widget.post.d;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderTencentVideoWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderJumpWidget;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "tencentVideoChooseChooseView", "Lcom/tencent/mm/plugin/finder/view/FinderTencentVideoChooseView;", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/tencent/mm/plugin/finder/view/FinderTencentVideoChooseView;)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "onDeleteListener", "Lkotlin/Function0;", "", "getTencentVideoChooseChooseView", "()Lcom/tencent/mm/plugin/finder/view/FinderTencentVideoChooseView;", "tencentVideoJumpInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "tencentVideoJumpInfoList", "", "getPostData", "getTencentVideoJumpInfo", "title", "", "link", "style", "", "html5Style", "optionalInfo", "onCreate", "jumpInfoList", "onSelectTencentVideo", "refreshView", "resetData", "setOnDeleteListener", "showBottomSheet", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements j
{
  private final bui Auc;
  public final FinderTencentVideoChooseView GfK;
  FinderJumpInfo GfL;
  public List<? extends FinderJumpInfo> GfM;
  public kotlin.g.a.a<ah> Gft;
  final AppCompatActivity activity;
  
  public i(AppCompatActivity paramAppCompatActivity, FinderTencentVideoChooseView paramFinderTencentVideoChooseView)
  {
    AppMethodBeat.i(342862);
    this.activity = paramAppCompatActivity;
    this.GfK = paramFinderTencentVideoChooseView;
    paramAppCompatActivity = k.aeZF;
    this.Auc = ((as)k.d(this.activity).q(as.class)).fou();
    AppMethodBeat.o(342862);
  }
  
  private static final void a(i parami, View paramView)
  {
    AppMethodBeat.i(342873);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parami);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/upload/postui/FinderTencentVideoWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parami, "this$0");
    if (parami.GfL != null)
    {
      paramView = d.Haf;
      d.a(parami.activity, (kotlin.g.a.a)new i.a(parami), (kotlin.g.a.a)new b(parami));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/upload/postui/FinderTencentVideoWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(342873);
  }
  
  public final List<FinderJumpInfo> feF()
  {
    return this.GfM;
  }
  
  public final void hG(List<? extends FinderJumpInfo> paramList)
  {
    AppMethodBeat.i(342887);
    if (paramList == null) {}
    for (FinderJumpInfo localFinderJumpInfo = null;; localFinderJumpInfo = (FinderJumpInfo)p.oL(paramList))
    {
      this.GfL = localFinderJumpInfo;
      this.GfM = paramList;
      paramList = av.GiL;
      if (av.ffY()) {
        break;
      }
      this.GfK.setVisibility(8);
      AppMethodBeat.o(342887);
      return;
    }
    if (this.GfK.getVisibility() != 0)
    {
      this.GfK.setVisibility(0);
      this.Auc.AJo = 74;
      paramList = bb.FuK;
      bb.a(this.Auc, "button_post_choose_tencentVideo", 0);
    }
    refreshView();
    this.GfK.setOnClickListener(new i..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(342887);
  }
  
  final void refreshView()
  {
    AppMethodBeat.i(342898);
    FinderJumpInfo localFinderJumpInfo = this.GfL;
    if (localFinderJumpInfo != null) {
      this.GfK.aCD(localFinderJumpInfo.wording);
    }
    AppMethodBeat.o(342898);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.i
 * JD-Core Version:    0.7.0.1
 */