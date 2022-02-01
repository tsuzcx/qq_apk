package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.plugin.finder.model.ag;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.utils.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgLikeConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgLike;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class au
  extends al<ag>
{
  final String TAG;
  private final int scene;
  
  public au(int paramInt)
  {
    super(2131494074, paramInt);
    this.scene = paramInt;
    this.TAG = "Finder.FinderMsgLikeConvert";
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(au paramau, e parame, TextView paramTextView1, String paramString, ag paramag, TextView paramTextView2) {}
    
    public final void run()
    {
      AppMethodBeat.i(201905);
      Object localObject = this.oTF.GD(2131302660);
      p.g(localObject, "holder.getView<View>(R.id.name_container)");
      int i = ((View)localObject).getWidth();
      localObject = this.rXH;
      p.g(localObject, "nickTv");
      float f = ((TextView)localObject).getPaint().measureText(this.rXI);
      ae.d(this.rXR.TAG, "allWidth:" + i + " nicknameWidth:" + f + " count:" + this.rXS.ssK.cLw());
      if (i > f)
      {
        localObject = this.rXJ;
        p.g(localObject, "suffixTv");
        ((TextView)localObject).setVisibility(8);
        localObject = this.rXH;
        p.g(localObject, "nickTv");
        ((TextView)localObject).setText((CharSequence)k.c(this.oTF.getContext(), (CharSequence)this.rXI));
        AppMethodBeat.o(201905);
        return;
      }
      localObject = this.rXJ;
      p.g(localObject, "suffixTv");
      ((TextView)localObject).setVisibility(0);
      localObject = this.rXJ;
      p.g(localObject, "suffixTv");
      ((TextView)localObject).setText((CharSequence)this.oTF.getContext().getString(2131766446, new Object[] { h.Gf(this.rXS.ssK.field_aggregatedContacts.GGR) }));
      localObject = this.rXH;
      p.g(localObject, "nickTv");
      ((TextView)localObject).setText((CharSequence)k.c(this.oTF.getContext(), (CharSequence)this.rXI));
      AppMethodBeat.o(201905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.au
 * JD-Core Version:    0.7.0.1
 */