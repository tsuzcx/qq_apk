package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.cgi.bc;
import com.tencent.mm.plugin.finder.model.aw;
import com.tencent.mm.plugin.finder.storage.logic.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgFollowApply;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "setAccept", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "acceptBtn", "Landroid/widget/TextView;", "setAccepted", "setInvalid", "setRevoke", "plugin-finder_release"})
public final class bi
  extends bh<aw>
{
  private final String TAG = "Finder.FinderMsgFollowApplyConvert";
  final int scene = 1;
  
  private bi()
  {
    super(2131494525, 1);
  }
  
  static void a(TextView paramTextView, h paramh)
  {
    AppMethodBeat.i(243194);
    paramTextView.setBackground(null);
    paramTextView.setOnClickListener(null);
    paramTextView.setText((CharSequence)paramh.getContext().getString(2131760283));
    com.tencent.mm.ui.ao.a((Paint)paramTextView.getPaint(), 0.0F);
    paramh = paramh.getContext();
    p.g(paramh, "holder.context");
    paramTextView.setTextColor(paramh.getResources().getColor(2131099749));
    AppMethodBeat.o(243194);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(h paramh, TextView paramTextView1, String paramString, TextView paramTextView2, aw paramaw) {}
    
    public final void run()
    {
      AppMethodBeat.i(243191);
      Object localObject = this.qhp.Mn(2131305214);
      p.g(localObject, "holder.getView<View>(R.id.name_container)");
      int i = ((View)localObject).getWidth();
      localObject = this.tEU;
      p.g(localObject, "nickTv");
      float f = ((TextView)localObject).getPaint().measureText(this.tEV);
      if (i > f)
      {
        localObject = this.tEW;
        p.g(localObject, "suffixTv");
        ((TextView)localObject).setVisibility(8);
        localObject = this.tEU;
        p.g(localObject, "nickTv");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.qhp.getContext(), (CharSequence)this.tEV));
        AppMethodBeat.o(243191);
        return;
      }
      localObject = this.tEW;
      p.g(localObject, "suffixTv");
      ((TextView)localObject).setVisibility(0);
      localObject = this.tEW;
      p.g(localObject, "suffixTv");
      ((TextView)localObject).setText((CharSequence)this.qhp.getContext().getString(2131760306, new Object[] { com.tencent.mm.plugin.finder.utils.k.Lw(this.tEX.uNF.field_aggregatedContacts.LII) }));
      localObject = this.tEU;
      p.g(localObject, "nickTv");
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.qhp.getContext(), (CharSequence)this.tEV));
      AppMethodBeat.o(243191);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(bi parambi, com.tencent.mm.plugin.finder.storage.ao paramao, TextView paramTextView, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243192);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert$setAccept$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.finder.report.k.vfA;
      paramView = this.tEZ.field_username;
      p.g(paramView, "mention.field_username");
      com.tencent.mm.plugin.finder.report.k.ad(paramView, 1, cl.aWB());
      bi.a(this.tFa, this.qhp);
      paramView = f.vGV;
      f.c(this.tEZ);
      paramView = com.tencent.mm.ui.component.a.PRN;
      paramView = this.qhp.getContext();
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(243192);
        throw paramView;
      }
      paramView = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramView).get(FinderReporterUIC.class)).dIx();
      paramView = new bc(this.tEZ, paramView, this.tEY.scene);
      g.azz().b((q)paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert$setAccept$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243192);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bi
 * JD-Core Version:    0.7.0.1
 */