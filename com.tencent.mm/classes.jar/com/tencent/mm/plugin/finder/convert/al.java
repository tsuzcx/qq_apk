package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.model.ab;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgFollowApply;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "setAccept", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "acceptBtn", "Landroid/widget/TextView;", "setAccepted", "setInvalid", "setRevoke", "plugin-finder_release"})
public final class al
  extends ak<ab>
{
  private final String TAG = "Finder.FinderMsgFollowApplyConvert";
  final int scene = 1;
  
  private al()
  {
    super(2131496462, 1);
  }
  
  static void a(TextView paramTextView, com.tencent.mm.view.recyclerview.e parame)
  {
    AppMethodBeat.i(201452);
    paramTextView.setBackground(null);
    paramTextView.setOnClickListener(null);
    paramTextView.setText((CharSequence)parame.getContext().getString(2131767010));
    com.tencent.mm.ui.al.a((Paint)paramTextView.getPaint(), 0.0F);
    parame = parame.getContext();
    p.g(parame, "holder.context");
    paramTextView.setTextColor(parame.getResources().getColor(2131099735));
    AppMethodBeat.o(201452);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(com.tencent.mm.view.recyclerview.e parame, TextView paramTextView1, String paramString, TextView paramTextView2, ab paramab) {}
    
    public final void run()
    {
      AppMethodBeat.i(201449);
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
        AppMethodBeat.o(201449);
        return;
      }
      localObject = this.rPi;
      p.g(localObject, "suffixTv");
      ((TextView)localObject).setVisibility(0);
      localObject = this.rPi;
      p.g(localObject, "suffixTv");
      ((TextView)localObject).setText((CharSequence)this.oNd.getContext().getString(2131766446, new Object[] { com.tencent.mm.plugin.finder.utils.h.FH(this.rPj.sjN.field_aggregatedContacts.GnL) }));
      localObject = this.rPg;
      p.g(localObject, "nickTv");
      ((TextView)localObject).setText((CharSequence)k.c(this.oNd.getContext(), (CharSequence)this.rPh));
      AppMethodBeat.o(201449);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(al paramal, ac paramac, TextView paramTextView, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201450);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert$setAccept$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.report.h.soM;
      paramView = this.rPl.field_username;
      p.g(paramView, "mention.field_username");
      com.tencent.mm.plugin.finder.report.h.ab(paramView, 1, cf.aCN());
      al.a(this.rPm, this.oNd);
      paramView = com.tencent.mm.plugin.finder.storage.logic.e.sAy;
      com.tencent.mm.plugin.finder.storage.logic.e.b(this.rPl);
      paramView = com.tencent.mm.ui.component.a.KiD;
      paramView = this.oNd.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201450);
        throw paramView;
      }
      paramView = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramView).get(FinderReporterUIC.class)).cOu();
      paramView = new af(this.rPl, paramView, this.rPk.scene);
      g.aiU().b((n)paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert$setAccept$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201450);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.al
 * JD-Core Version:    0.7.0.1
 */