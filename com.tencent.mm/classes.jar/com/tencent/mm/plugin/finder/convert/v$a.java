package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.protocal.protobuf.dzg;
import com.tencent.mm.sdk.platformtools.ad;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class v$a
  implements Runnable
{
  v$a(v paramv, com.tencent.mm.view.recyclerview.e parame, TextView paramTextView1, String paramString, t paramt, TextView paramTextView2) {}
  
  public final void run()
  {
    AppMethodBeat.i(197483);
    Object localObject = this.nGG.abq(2131302660);
    d.g.b.k.g(localObject, "holder.getView<View>(R.id.name_container)");
    int i = ((View)localObject).getWidth();
    localObject = this.KLv;
    d.g.b.k.g(localObject, "nickTv");
    float f = ((TextView)localObject).getPaint().measureText(this.KLw);
    ad.d(this.KLB.TAG, "allWidth:" + i + " nicknameWidth:" + f + " count:" + this.KLC.qDo.fVb());
    if (i > f)
    {
      localObject = this.KLx;
      d.g.b.k.g(localObject, "suffixTv");
      ((TextView)localObject).setVisibility(8);
      localObject = this.KLv;
      d.g.b.k.g(localObject, "nickTv");
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(this.nGG.getContext(), (CharSequence)this.KLw));
      AppMethodBeat.o(197483);
      return;
    }
    localObject = this.KLx;
    d.g.b.k.g(localObject, "suffixTv");
    ((TextView)localObject).setVisibility(0);
    localObject = this.KLx;
    d.g.b.k.g(localObject, "suffixTv");
    ((TextView)localObject).setText((CharSequence)this.nGG.getContext().getString(2131766433, new Object[] { com.tencent.mm.plugin.finder.utils.e.Df(this.KLC.qDo.field_aggregatedContacts.LxM) }));
    localObject = this.KLv;
    d.g.b.k.g(localObject, "nickTv");
    ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(this.nGG.getContext(), (CharSequence)this.KLw));
    AppMethodBeat.o(197483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.v.a
 * JD-Core Version:    0.7.0.1
 */