package com.tencent.mm.plugin.finder.upload.postui;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.view.FinderEmojiChooseView;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderEmojiWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderJumpWidget;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "emojiChooseView", "Lcom/tencent/mm/plugin/finder/view/FinderEmojiChooseView;", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/tencent/mm/plugin/finder/view/FinderEmojiChooseView;)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getEmojiChooseView", "()Lcom/tencent/mm/plugin/finder/view/FinderEmojiChooseView;", "emojiJumpInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "jumpInfoList", "", "onDeleteListener", "Lkotlin/Function0;", "", "getPostData", "onCreate", "jumpInfo", "onSelectEmoji", "data", "Landroid/content/Intent;", "refreshView", "resetData", "setOnDeleteListener", "showBottomSheet", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements j
{
  private final bui Auc;
  public List<? extends FinderJumpInfo> Gfq;
  public final FinderEmojiChooseView Gfr;
  FinderJumpInfo Gfs;
  public kotlin.g.a.a<ah> Gft;
  final AppCompatActivity activity;
  
  public d(AppCompatActivity paramAppCompatActivity, FinderEmojiChooseView paramFinderEmojiChooseView)
  {
    AppMethodBeat.i(342863);
    this.activity = paramAppCompatActivity;
    this.Gfr = paramFinderEmojiChooseView;
    paramAppCompatActivity = k.aeZF;
    this.Auc = ((as)k.d(this.activity).q(as.class)).fou();
    AppMethodBeat.o(342863);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(342879);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/upload/postui/FinderEmojiWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    if (paramd.Gfs != null)
    {
      paramView = com.tencent.mm.plugin.finder.widget.post.d.Haf;
      com.tencent.mm.plugin.finder.widget.post.d.a(paramd.activity, (kotlin.g.a.a)new a(paramd), (kotlin.g.a.a)new b(paramd));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/upload/postui/FinderEmojiWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(342879);
  }
  
  public final List<FinderJumpInfo> feF()
  {
    return this.Gfq;
  }
  
  public final void hG(List<? extends FinderJumpInfo> paramList)
  {
    AppMethodBeat.i(342905);
    this.Gfq = paramList;
    if (paramList == null) {}
    for (paramList = null;; paramList = (FinderJumpInfo)p.oL(paramList))
    {
      this.Gfs = paramList;
      paramList = com.tencent.mm.plugin.finder.widget.post.d.Haf;
      if (com.tencent.mm.plugin.finder.widget.post.d.fqD()) {
        break;
      }
      this.Gfr.setVisibility(8);
      AppMethodBeat.o(342905);
      return;
    }
    if (this.Gfr.getVisibility() != 0)
    {
      this.Gfr.setVisibility(0);
      this.Auc.AJo = 74;
      paramList = bb.FuK;
      bb.a(this.Auc, "button_post_choose_emoji", 0);
    }
    refreshView();
    this.Gfr.setOnClickListener(new d..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(342905);
  }
  
  final void refreshView()
  {
    AppMethodBeat.i(342926);
    Object localObject = this.Gfs;
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        ((d)this).Gfr.fkv();
      }
      AppMethodBeat.o(342926);
      return;
      this.Gfr.aCD(((FinderJumpInfo)localObject).wording);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.d
 * JD-Core Version:    0.7.0.1
 */