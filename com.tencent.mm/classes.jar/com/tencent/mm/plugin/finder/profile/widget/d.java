package com.tencent.mm.plugin.finder.profile.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.profile.uic.h.c;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.f;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/widget/HeaderMediaEntranceWidget;", "", "header", "Landroid/view/View;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroid/view/View;Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "finderMediaEntrance", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "getFinderMediaEntrance", "()Landroid/widget/RelativeLayout;", "finderMediaEntrance$delegate", "Lkotlin/Lazy;", "finderMediaName", "Landroid/widget/TextView;", "getFinderMediaName", "()Landroid/widget/TextView;", "finderMediaName$delegate", "checkEnterBizProfile", "", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "handleMediaEntrance", "username", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private final j Fhg;
  private final j Fhh;
  public final AppCompatActivity activity;
  
  public d(View paramView, AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(349265);
    this.activity = paramAppCompatActivity;
    this.Fhg = kotlin.k.cm((kotlin.g.a.a)new b(paramView));
    this.Fhh = kotlin.k.cm((kotlin.g.a.a)new c(paramView));
    AppMethodBeat.o(349265);
  }
  
  private static final void a(m paramm, pu parampu, d paramd, View paramView)
  {
    AppMethodBeat.i(349282);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramm);
    localb.cH(parampu);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/widget/HeaderMediaEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parampu, "$bizInfo");
    s.u(paramd, "this$0");
    paramView = z.FrZ;
    if (paramm == null)
    {
      paramm = "";
      paramView = parampu.ADE;
      if (paramView != null) {
        break label241;
      }
      paramView = "";
    }
    label241:
    for (;;)
    {
      localObject = com.tencent.mm.ui.component.k.aeZF;
      z.c(4, paramm, paramView, ((as)com.tencent.mm.ui.component.k.d(paramd.activity).q(as.class)).fou());
      paramm = new Intent();
      paramm.putExtra("Contact_User", parampu.ADE);
      paramm.putExtra("Contact_Scene", 183);
      paramm.putExtra("force_get_contact", true);
      paramm.putExtra("key_use_new_contact_profile", true);
      paramm.putExtra("Contact_Scene", 210);
      c.b((Context)paramd.activity, "profile", ".ui.ContactInfoUI", paramm);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/widget/HeaderMediaEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349282);
      return;
      paramm = paramm.getUsername();
      if (paramm == null)
      {
        paramm = "";
        break;
      }
      break;
    }
  }
  
  private final RelativeLayout eKN()
  {
    AppMethodBeat.i(349270);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Fhg.getValue();
    AppMethodBeat.o(349270);
    return localRelativeLayout;
  }
  
  public final void c(final String paramString, m paramm)
  {
    AppMethodBeat.i(349302);
    s.u(paramString, "username");
    Object localObject = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
    paramString = (h.c)com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp().get(paramString);
    boolean bool;
    if (paramString == null)
    {
      paramString = new h.c();
      bool = ((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu();
      paramString = paramString.FeG;
      if (paramString != null) {
        break label90;
      }
      paramString = null;
    }
    for (;;)
    {
      if (paramString == null) {
        ((d)this).eKN().setVisibility(8);
      }
      AppMethodBeat.o(349302);
      return;
      break;
      label90:
      paramString = paramString.ZEL;
      if (paramString == null)
      {
        paramString = null;
      }
      else
      {
        int i;
        if (!((Collection)paramString).isEmpty())
        {
          i = 1;
          label118:
          if ((i == 0) || (bool)) {
            break label147;
          }
          i = 1;
          label129:
          if (i == 0) {
            break label152;
          }
        }
        for (;;)
        {
          if (paramString != null) {
            break label157;
          }
          paramString = null;
          break;
          i = 0;
          break label118;
          label147:
          i = 0;
          break label129;
          label152:
          paramString = null;
        }
        label157:
        localObject = (CharSequence)((pu)paramString.get(0)).ADE;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0))
        {
          i = 1;
          label190:
          if (i != 0) {
            break label214;
          }
          i = 1;
          label196:
          if (i == 0) {
            break label219;
          }
        }
        for (;;)
        {
          if (paramString != null) {
            break label224;
          }
          paramString = null;
          break;
          i = 0;
          break label190;
          label214:
          i = 0;
          break label196;
          label219:
          paramString = null;
        }
        label224:
        paramString = (pu)paramString.get(0);
        if (paramString == null)
        {
          paramString = null;
        }
        else
        {
          localObject = eKN();
          s.s(localObject, "finderMediaEntrance");
          f.a((View)localObject, (e.b)new d(paramm, paramString, this));
          eKN().setVisibility(0);
          ((TextView)this.Fhh.getValue()).setText((CharSequence)this.activity.getResources().getString(e.h.finder_profile_biz_name, new Object[] { paramString.YTl }));
          eKN().setOnClickListener(new d..ExternalSyntheticLambda0(paramm, paramString, this));
          paramString = ah.aiuX;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    public a(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<RelativeLayout>
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
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/widget/HeaderMediaEntranceWidget$handleMediaEntrance$3$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends e.b
  {
    d(m paramm, pu parampu, d paramd) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(349335);
      s.u(paramView, "view");
      String str;
      if (paramBoolean)
      {
        paramView = z.FrZ;
        paramView = this.Fhj;
        if (paramView != null) {
          break label89;
        }
        paramView = "";
        str = paramString.ADE;
        if (str != null) {
          break label107;
        }
        str = "";
      }
      label89:
      label107:
      for (;;)
      {
        com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
        z.c(3, paramView, str, ((as)com.tencent.mm.ui.component.k.d(jdField_this.activity).q(as.class)).fou());
        AppMethodBeat.o(349335);
        return;
        paramView = paramView.getUsername();
        if (paramView == null)
        {
          paramView = "";
          break;
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.widget.d
 * JD-Core Version:    0.7.0.1
 */