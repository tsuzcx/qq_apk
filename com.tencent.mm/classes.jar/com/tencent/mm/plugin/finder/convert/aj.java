package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.g;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.view.recyclerview.e;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgFriendObjectLikeLikeConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgFriendObjectLikeLike;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class aj
  extends ah<z>
{
  private final String TAG;
  private final int scene;
  
  public aj(int paramInt)
  {
    super(2131496232);
    this.scene = paramInt;
    this.TAG = "Finder.FinderMsgFriendObjectLikeLikeConvert";
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(e parame, TextView paramTextView1, String paramString, TextView paramTextView2, z paramz) {}
    
    public final void run()
    {
      AppMethodBeat.i(201354);
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
        AppMethodBeat.o(201354);
        return;
      }
      localObject = this.rcm;
      d.g.b.k.g(localObject, "suffixTv");
      ((TextView)localObject).setVisibility(0);
      localObject = this.rcm;
      d.g.b.k.g(localObject, "suffixTv");
      ((TextView)localObject).setText((CharSequence)this.ojH.getContext().getString(2131766446, new Object[] { g.Ex(this.rco.ruv.field_aggregatedContacts.EFx) }));
      localObject = this.rck;
      d.g.b.k.g(localObject, "nickTv");
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(this.ojH.getContext(), (CharSequence)this.rcl));
      AppMethodBeat.o(201354);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.aj
 * JD-Core Version:    0.7.0.1
 */