package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.plugin.finder.model.aa;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.utils.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgFollowConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgFollow;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class am
  extends ak<aa>
{
  private final String TAG;
  private final int scene;
  
  public am(int paramInt)
  {
    super(2131496231, paramInt);
    this.scene = paramInt;
    this.TAG = "Finder.FinderMsgFollowConvert";
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(e parame, TextView paramTextView1, String paramString, TextView paramTextView2, aa paramaa) {}
    
    public final void run()
    {
      AppMethodBeat.i(201453);
      Object localObject = this.oNd.Gd(2131302660);
      p.g(localObject, "holder.getView<View>(R.id.name_container)");
      int i = ((View)localObject).getWidth();
      localObject = this.rPg;
      p.g(localObject, "nickTv");
      float f = ((TextView)localObject).getPaint().measureText(this.rPh);
      if (i > f)
      {
        localObject = this.rPi;
        p.g(localObject, "suffixTv");
        ((TextView)localObject).setVisibility(8);
        localObject = this.rPg;
        p.g(localObject, "nickTv");
        ((TextView)localObject).setText((CharSequence)k.c(this.oNd.getContext(), (CharSequence)this.rPh));
        AppMethodBeat.o(201453);
        return;
      }
      localObject = this.rPi;
      p.g(localObject, "suffixTv");
      ((TextView)localObject).setVisibility(0);
      localObject = this.rPi;
      p.g(localObject, "suffixTv");
      ((TextView)localObject).setText((CharSequence)this.oNd.getContext().getString(2131766446, new Object[] { h.FH(this.rPn.sjN.field_aggregatedContacts.GnL) }));
      localObject = this.rPg;
      p.g(localObject, "nickTv");
      ((TextView)localObject).setText((CharSequence)k.c(this.oNd.getContext(), (CharSequence)this.rPh));
      AppMethodBeat.o(201453);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.am
 * JD-Core Version:    0.7.0.1
 */