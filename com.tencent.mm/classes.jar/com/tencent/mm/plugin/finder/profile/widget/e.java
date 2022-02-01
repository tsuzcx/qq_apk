package com.tencent.mm.plugin.finder.profile.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.profile.uic.h.c;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k.b;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/widget/HeaderMiniProgramWidget;", "", "header", "Landroid/view/View;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroid/view/View;Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "finderMiniProgramListLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getFinderMiniProgramListLayout", "()Landroid/widget/LinearLayout;", "finderMiniProgramListLayout$delegate", "Lkotlin/Lazy;", "finderMiniProgramName", "Landroid/widget/TextView;", "getFinderMiniProgramName", "()Landroid/widget/TextView;", "finderMiniProgramName$delegate", "handleMIniProgramList", "", "source", "", "username", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private final j Fhl;
  private final j Fhm;
  private final AppCompatActivity activity;
  
  public e(View paramView, AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(349287);
    this.activity = paramAppCompatActivity;
    this.Fhl = kotlin.k.cm((kotlin.g.a.a)new a(paramView));
    this.Fhm = kotlin.k.cm((kotlin.g.a.a)new b(paramView));
    AppMethodBeat.o(349287);
  }
  
  private static final void a(String paramString, LinkedList paramLinkedList, e parame, m paramm, View paramView)
  {
    AppMethodBeat.i(349324);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramString);
    ((b)localObject2).cH(paramLinkedList);
    ((b)localObject2).cH(parame);
    ((b)localObject2).cH(paramm);
    ((b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/widget/HeaderMiniProgramWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    s.u(paramString, "$username");
    s.u(paramLinkedList, "$list");
    s.u(parame, "this$0");
    paramView = z.FrZ;
    paramView = ((bpl)paramLinkedList.get(0)).app_id;
    if (paramView == null)
    {
      paramView = "";
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      z.a(6, paramString, "", paramView, ((as)com.tencent.mm.ui.component.k.d(parame.activity).q(as.class)).fou());
      paramView = ((bpl)paramLinkedList.get(0)).app_id;
      localObject1 = ((bpl)paramLinkedList.get(0)).path;
      if ((paramView != null) && (localObject1 != null))
      {
        localObject2 = com.tencent.mm.plugin.finder.utils.a.GfO;
        parame = (Context)parame.activity;
        if (paramm != null) {
          break label247;
        }
        paramString = "";
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.utils.a)localObject2).a(parame, paramView, (String)localObject1, 1193, paramString);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/widget/HeaderMiniProgramWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349324);
      return;
      break;
      label247:
      paramLinkedList = paramm.getUsername();
      paramString = paramLinkedList;
      if (paramLinkedList == null) {
        paramString = "";
      }
    }
  }
  
  private final LinearLayout eKO()
  {
    AppMethodBeat.i(349300);
    LinearLayout localLinearLayout = (LinearLayout)this.Fhl.getValue();
    AppMethodBeat.o(349300);
    return localLinearLayout;
  }
  
  public final void a(String paramString1, String paramString2, m paramm)
  {
    com.tencent.mm.ui.component.k localk = null;
    AppMethodBeat.i(349366);
    s.u(paramString1, "source");
    s.u(paramString2, "username");
    Log.i("Finder.FinderProfileHeaderUIC", s.X("[handleMIniProgramList] source:", paramString1));
    Object localObject = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
    localObject = (h.c)com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp().get(paramString2);
    int i;
    if (localObject == null)
    {
      localObject = null;
      boolean bool = ((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu();
      eKO().setVisibility(8);
      Collection localCollection = (Collection)localObject;
      if ((localCollection != null) && (!localCollection.isEmpty())) {
        break label181;
      }
      i = 1;
      label105:
      if ((i != 0) || (bool)) {
        break label187;
      }
      i = 1;
      label118:
      if (i == 0) {
        break label193;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label199;
      }
      paramString1 = localk;
      if (paramString1 == null) {
        ((e)this).eKO().setVisibility(8);
      }
      AppMethodBeat.o(349366);
      return;
      localObject = ((h.c)localObject).FeG;
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = ((auh)localObject).ZEM;
      break;
      label181:
      i = 0;
      break label105;
      label187:
      i = 0;
      break label118;
      label193:
      localObject = null;
    }
    label199:
    if (s.p("onSceneEnd:[NetSceneFinderUserPage]", paramString1))
    {
      paramString1 = z.FrZ;
      paramString1 = ((bpl)((LinkedList)localObject).get(0)).app_id;
      if (paramString1 != null) {
        break label348;
      }
      paramString1 = "";
    }
    label348:
    for (;;)
    {
      localk = com.tencent.mm.ui.component.k.aeZF;
      z.a(5, paramString2, "", paramString1, ((as)com.tencent.mm.ui.component.k.d(this.activity).q(as.class)).fou());
      ((TextView)this.Fhm.getValue()).setText((CharSequence)this.activity.getResources().getString(e.h.finder_profile_mini_program_title, new Object[] { ((bpl)((LinkedList)localObject).get(0)).xkX }));
      eKO().setOnClickListener(new e..ExternalSyntheticLambda0(paramString2, (LinkedList)localObject, this, paramm));
      eKO().setVisibility(0);
      paramString1 = ah.aiuX;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    a(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<TextView>
  {
    b(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.widget.e
 * JD-Core Version:    0.7.0.1
 */