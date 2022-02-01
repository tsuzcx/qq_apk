package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.plugin.finder.model.ac;
import com.tencent.mm.protocal.protobuf.dzg;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgFriendObjectRecommendLikeConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgFriendObjectRecommendLike;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class ap
  extends u<ac>
{
  private final String TAG;
  private final int scene;
  
  public ap(int paramInt)
  {
    super(2131496232);
    this.scene = paramInt;
    this.TAG = "Finder.FinderMsgFriendObjectRecommendLikeConvert";
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(com.tencent.mm.view.recyclerview.e parame, TextView paramTextView1, String paramString, TextView paramTextView2, ac paramac) {}
    
    public final void run()
    {
      AppMethodBeat.i(197481);
      Object localObject = this.nGG.abq(2131302660);
      d.g.b.k.g(localObject, "holder.getView<View>(R.id.name_container)");
      int i = ((View)localObject).getWidth();
      localObject = this.KLv;
      d.g.b.k.g(localObject, "nickTv");
      float f = ((TextView)localObject).getPaint().measureText(this.KLw);
      if (i > f)
      {
        localObject = this.KLx;
        d.g.b.k.g(localObject, "suffixTv");
        ((TextView)localObject).setVisibility(8);
        localObject = this.KLv;
        d.g.b.k.g(localObject, "nickTv");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(this.nGG.getContext(), (CharSequence)this.KLw));
        AppMethodBeat.o(197481);
        return;
      }
      localObject = this.KLx;
      d.g.b.k.g(localObject, "suffixTv");
      ((TextView)localObject).setVisibility(0);
      localObject = this.KLx;
      d.g.b.k.g(localObject, "suffixTv");
      ((TextView)localObject).setText((CharSequence)this.nGG.getContext().getString(2131766433, new Object[] { com.tencent.mm.plugin.finder.utils.e.Df(this.KLA.qDo.field_aggregatedContacts.LxM) }));
      localObject = this.KLv;
      d.g.b.k.g(localObject, "nickTv");
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(this.nGG.getContext(), (CharSequence)this.KLw));
      AppMethodBeat.o(197481);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ap
 * JD-Core Version:    0.7.0.1
 */