package com.tencent.mm.plugin.finder.convert;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$openCommentDrawer$onCloseDrawerCallback$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
public final class e$ag
  implements CommentDrawerContract.CloseDrawerCallback
{
  e$ag(com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed) {}
  
  public final void o(int paramInt, List<? extends h> paramList)
  {
    AppMethodBeat.i(197400);
    k.h(paramList, "data");
    ((FinderFeedExposeLayout)this.nGG.abq(2131298523)).Dp(this.qqO.feedObject.getCommentCount());
    paramList = e.b(this.qqM).getVideoCore().qTH;
    if (paramList != null) {
      FinderVideoAutoPlayManager.a(paramList, "openCommentDrawer", false);
    }
    if (e.b(this.qqM).clH())
    {
      paramList = this.nGG.abq(2131304550);
      k.g(paramList, "holder.getView<TextView>…id.self_comment_count_tv)");
      ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.e.fz(1, this.qqO.feedObject.getCommentCount()));
    }
    AppMethodBeat.o(197400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e.ag
 * JD-Core Version:    0.7.0.1
 */