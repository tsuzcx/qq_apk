package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.plugin.finder.model.aa;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.g;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.view.recyclerview.e;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgFriendObjectRecommendLikeConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgFriendObjectRecommendLike;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class ak
  extends ah<aa>
{
  private final String TAG;
  private final int scene;
  
  public ak(int paramInt)
  {
    super(2131496233);
    this.scene = paramInt;
    this.TAG = "Finder.FinderMsgFriendObjectRecommendLikeConvert";
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(e parame, TextView paramTextView1, String paramString, TextView paramTextView2, aa paramaa) {}
    
    public final void run()
    {
      AppMethodBeat.i(201356);
      Object localObject = this.ojH.adJ(2131302660);
      d.g.b.k.g(localObject, "holder.getView<View>(R.id.name_container)");
      int i = ((View)localObject).getWidth();
      localObject = this.rck;
      d.g.b.k.g(localObject, "nickTv");
      float f = ((TextView)localObject).getPaint().measureText(this.rcl);
      if (i > f)
      {
        localObject = this.rcm;
        d.g.b.k.g(localObject, "suffixTv");
        ((TextView)localObject).setVisibility(8);
        localObject = this.rck;
        d.g.b.k.g(localObject, "nickTv");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(this.ojH.getContext(), (CharSequence)this.rcl));
        AppMethodBeat.o(201356);
        return;
      }
      localObject = this.rcm;
      d.g.b.k.g(localObject, "suffixTv");
      ((TextView)localObject).setVisibility(0);
      localObject = this.rcm;
      d.g.b.k.g(localObject, "suffixTv");
      ((TextView)localObject).setText((CharSequence)this.ojH.getContext().getString(2131766446, new Object[] { g.Ex(this.rcp.ruv.field_aggregatedContacts.EFx) }));
      localObject = this.rck;
      d.g.b.k.g(localObject, "nickTv");
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(this.ojH.getContext(), (CharSequence)this.rcl));
      AppMethodBeat.o(201356);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ak
 * JD-Core Version:    0.7.0.1
 */