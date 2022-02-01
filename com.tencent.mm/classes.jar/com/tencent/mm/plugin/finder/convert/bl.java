package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.beg;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgFollowConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgFollow;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class bl
  extends bj<ay>
{
  private final String TAG;
  private final int scene;
  
  public bl(int paramInt)
  {
    super(b.g.finder_msg_item_of_follow, paramInt);
    this.scene = paramInt;
    this.TAG = "Finder.FinderMsgFollowConvert";
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(i parami, TextView paramTextView1, String paramString, TextView paramTextView2, ay paramay) {}
    
    public final void run()
    {
      AppMethodBeat.i(223207);
      Object localObject = this.tDl.RD(b.f.name_container);
      p.j(localObject, "holder.getView<View>(R.id.name_container)");
      int i = ((View)localObject).getWidth();
      localObject = this.xkm;
      p.j(localObject, "nickTv");
      float f = ((TextView)localObject).getPaint().measureText(this.xnu);
      if (i > f)
      {
        localObject = this.xnv;
        p.j(localObject, "suffixTv");
        ((TextView)localObject).setVisibility(8);
        localObject = this.xkm;
        p.j(localObject, "nickTv");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.tDl.getContext(), (CharSequence)this.xnu));
        AppMethodBeat.o(223207);
        return;
      }
      localObject = this.xnv;
      p.j(localObject, "suffixTv");
      ((TextView)localObject).setVisibility(0);
      localObject = this.xnv;
      p.j(localObject, "suffixTv");
      ((TextView)localObject).setText((CharSequence)this.tDl.getContext().getString(b.j.finder_msg_suffix_desc, new Object[] { m.QG(this.xnA.zzT.field_aggregatedContacts.SPu) }));
      localObject = this.xkm;
      p.j(localObject, "nickTv");
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.tDl.getContext(), (CharSequence)this.xnu));
      AppMethodBeat.o(223207);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bl
 * JD-Core Version:    0.7.0.1
 */