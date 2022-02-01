package com.tencent.mm.plugin.finder.profile.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.dou;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.e.b;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/widget/HeaderRedPackWidget;", "", "header", "Landroid/view/View;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/View;Landroidx/appcompat/app/AppCompatActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "actionBarRedPackClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getActionBarRedPackClose", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "actionBarRedPackClose$delegate", "Lkotlin/Lazy;", "actionBarRedPackLayout", "Landroid/widget/LinearLayout;", "getActionBarRedPackLayout", "()Landroid/widget/LinearLayout;", "actionBarRedPackLayout$delegate", "actionBarRedPackTxt", "Landroid/widget/TextView;", "getActionBarRedPackTxt", "()Landroid/widget/TextView;", "actionBarRedPackTxt$delegate", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "refreshRedPack", "", "isSelf", "", "isSelfFlag", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  final bui Auc;
  private final j Fhn;
  private final j Fho;
  private final j Fhp;
  private final AppCompatActivity activity;
  
  public f(View paramView, AppCompatActivity paramAppCompatActivity, bui parambui)
  {
    AppMethodBeat.i(349219);
    this.activity = paramAppCompatActivity;
    this.Auc = parambui;
    this.Fhn = k.cm((kotlin.g.a.a)new b(paramView));
    this.Fho = k.cm((kotlin.g.a.a)new a(paramView));
    this.Fhp = k.cm((kotlin.g.a.a)new c(paramView));
    AppMethodBeat.o(349219);
  }
  
  private static final void a(l.a parama, f paramf, View paramView)
  {
    AppMethodBeat.i(349243);
    s.u(paramf, "this$0");
    if (parama != null)
    {
      parama = parama.ASh;
      if (parama != null)
      {
        parama = parama.ASz;
        if (parama != null)
        {
          paramView = parama.aabJ;
          if (paramView != null)
          {
            parama = new dou();
            parama.parseFrom(paramView.toByteArray());
            paramView = parama.aaVE;
            String str = parama.YBQ;
            if ((paramView != null) && (str != null))
            {
              Object localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
              localObject = (Context)paramf.activity;
              int i = parama.YBS;
              parama = com.tencent.mm.plugin.finder.storage.d.FAy;
              com.tencent.mm.plugin.finder.utils.a.a((Context)localObject, paramView, str, i, "", (Boolean)com.tencent.mm.plugin.finder.storage.d.eWh().bmg());
            }
            parama = z.FrZ;
            z.bB(2, "");
            parama = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("FinderProfileBanner");
            paramView = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderProfileBanner");
            if ((paramView != null) && (parama != null)) {
              w.a(w.FrV, "3", paramView, parama, 2, paramf.Auc, 0, null, 0, 480);
            }
          }
        }
      }
    }
    ((cn)h.az(cn.class)).getRedDotManager().TL("ProfileEntrance");
    AppMethodBeat.o(349243);
  }
  
  private static final void a(f paramf, boolean paramBoolean1, boolean paramBoolean2, l.a parama)
  {
    AppMethodBeat.i(349263);
    s.u(paramf, "this$0");
    boolean bool = ((bw)h.ax(bw.class)).aBu();
    Object localObject = paramf.eKP();
    int i;
    label70:
    TextView localTextView;
    if ((paramBoolean1) && (paramBoolean2)) {
      if ((parama != null) && (parama.hBY == true))
      {
        i = 1;
        if ((i == 0) || (bool)) {
          break label199;
        }
        i = 0;
        ((LinearLayout)localObject).setVisibility(i);
        localTextView = (TextView)paramf.Fhp.getValue();
        if (parama != null) {
          break label206;
        }
        localObject = (CharSequence)"";
      }
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      if (paramf.eKP().getVisibility() == 0)
      {
        localObject = paramf.eKP();
        s.s(localObject, "actionBarRedPackLayout");
        com.tencent.mm.view.f.a((View)localObject, (e.b)new d(paramf));
      }
      paramf.eKP().setOnClickListener(new f..ExternalSyntheticLambda0(parama, paramf));
      ((WeImageView)paramf.Fho.getValue()).setOnClickListener(f..ExternalSyntheticLambda1.INSTANCE);
      AppMethodBeat.o(349263);
      return;
      i = 0;
      break;
      label199:
      i = 8;
      break label70;
      label206:
      localObject = parama.ASg;
      if (localObject == null)
      {
        localObject = (CharSequence)"";
      }
      else
      {
        localObject = ((bxq)localObject).title;
        if (localObject == null) {
          localObject = (CharSequence)"";
        } else {
          localObject = (CharSequence)localObject;
        }
      }
    }
  }
  
  private final LinearLayout eKP()
  {
    AppMethodBeat.i(349225);
    LinearLayout localLinearLayout = (LinearLayout)this.Fhn.getValue();
    AppMethodBeat.o(349225);
    return localLinearLayout;
  }
  
  private static final void gC(View paramView)
  {
    AppMethodBeat.i(349249);
    ((cn)h.az(cn.class)).getRedDotManager().TL("ProfileEntrance");
    ((cn)h.az(cn.class)).getRedDotManager().TL("FinderProfileBanner");
    AppMethodBeat.o(349249);
  }
  
  public final void an(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(349290);
    l locall = l.ARA;
    com.tencent.mm.ae.d.a((LiveData)l.dZT(), (q)this.activity, new f..ExternalSyntheticLambda2(this, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(349290);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    a(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    b(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<TextView>
  {
    c(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/widget/HeaderRedPackWidget$refreshRedPack$1$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends e.b
  {
    d(f paramf) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(349334);
      s.u(paramView, "view");
      if (paramBoolean)
      {
        paramView = z.FrZ;
        z.bB(1, "");
        paramView = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("FinderProfileBanner");
        p localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderProfileBanner");
        f localf = this.Fhq;
        if ((localp != null) && (paramView != null)) {
          w.a(w.FrV, "3", localp, paramView, 1, localf.Auc, 0, null, 0, 480);
        }
      }
      AppMethodBeat.o(349334);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.widget.f
 * JD-Core Version:    0.7.0.1
 */