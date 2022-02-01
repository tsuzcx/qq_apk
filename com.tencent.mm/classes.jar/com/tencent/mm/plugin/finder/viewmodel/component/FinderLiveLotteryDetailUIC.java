package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.report.d.b;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s.ay;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveLotteryDetailUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class FinderLiveLotteryDetailUIC
  extends UIComponent
{
  public static final a wyd;
  
  static
  {
    AppMethodBeat.i(255758);
    wyd = new a((byte)0);
    AppMethodBeat.o(255758);
  }
  
  public FinderLiveLotteryDetailUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255757);
    AppMethodBeat.o(255757);
  }
  
  public final int getLayoutId()
  {
    return 2131494423;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(255756);
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255756);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    paramBundle.setMMTitle(2131760107);
    paramBundle.setBackBtn((MenuItem.OnMenuItemClickListener)new c(paramBundle));
    final String str = getActivity().getIntent().getStringExtra("KEY_LIVE_ANCHOR_USERNAME");
    Object localObject1 = getActivity().getIntent().getByteArrayExtra("KEY_LOTTERY_HISTORY_INFO");
    if (localObject1 != null) {
      paramBundle = new awi();
    }
    for (;;)
    {
      try
      {
        paramBundle.parseFrom((byte[])localObject1);
        localObject1 = paramBundle;
        if (localObject1 == null) {
          break label795;
        }
        paramBundle = c.tsp;
        localObject4 = c.a.asG(str);
        localObject3 = getActivity().getResources().getString(2131760042);
        p.g(localObject3, "activity.resources.getSt…ery_history_detail_title)");
        paramBundle = (Bundle)localObject3;
        if (localObject4 != null) {
          paramBundle = (String)localObject3 + "·" + ((g)localObject4).getNickname();
        }
        localObject3 = (TextView)((FragmentActivity)getActivity()).findViewById(2131303851);
        p.g(localObject3, "activity.lottery_detail_title");
        ((TextView)localObject3).setText((CharSequence)paramBundle);
        paramBundle = (CharSequence)((awi)localObject1).description;
        if ((paramBundle != null) && (paramBundle.length() != 0)) {
          break label581;
        }
        i = 1;
        if (i == 0) {
          break label586;
        }
        paramBundle = (LinearLayout)((FragmentActivity)getActivity()).findViewById(2131303846);
        p.g(paramBundle, "activity.lottery_detail_item_container");
        paramBundle.setVisibility(8);
        paramBundle = (TextView)((FragmentActivity)getActivity()).findViewById(2131303848);
        p.g(paramBundle, "activity.lottery_detail_item_desc");
        paramBundle.setText((CharSequence)((awi)localObject1).description);
        localObject3 = (TextView)((FragmentActivity)getActivity()).findViewById(2131303850);
        p.g(localObject3, "activity.lottery_detail_item_type");
        paramBundle = ((awi)localObject1).LGn;
        if ((paramBundle == null) || (paramBundle.LGY != 1)) {
          break label649;
        }
        paramBundle = ((awi)localObject1).LGn;
        if (paramBundle == null) {
          break label626;
        }
        paramBundle = paramBundle.LGZ;
        if (paramBundle == null) {
          break label626;
        }
        p.g(paramBundle, "it");
        if (((CharSequence)paramBundle).length() <= 0) {
          break label616;
        }
        i = 1;
        if (i == 0) {
          break label621;
        }
        if (paramBundle == null) {
          break label626;
        }
        paramBundle = getActivity().getResources().getString(2131760028, new Object[] { paramBundle });
        if (paramBundle == null) {
          break label626;
        }
        paramBundle = (CharSequence)paramBundle;
        ((TextView)localObject3).setText(paramBundle);
        paramBundle = (TextView)((FragmentActivity)getActivity()).findViewById(2131303847);
        p.g(paramBundle, "activity.lottery_detail_item_count");
        paramBundle.setText((CharSequence)getActivity().getResources().getString(2131760036, new Object[] { Integer.valueOf(((awi)localObject1).ugF) }));
        paramBundle = (TextView)((FragmentActivity)getActivity()).findViewById(2131303849);
        p.g(paramBundle, "activity.lottery_detail_item_time");
        paramBundle.setText((CharSequence)f.formatTime("yyyy-MM-dd HH:mm", ((awi)localObject1).iqg));
        paramBundle = FinderReporterUIC.wzC;
        paramBundle = getActivity();
        if (paramBundle != null) {
          break;
        }
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255756);
        throw paramBundle;
      }
      catch (Throwable paramBundle)
      {
        Log.e("FinderLiveLotteryDetailUIC", "onCreate: lottery info parse errpr", new Object[] { paramBundle });
        paramBundle = null;
        continue;
      }
      localObject1 = null;
      continue;
      label581:
      int i = 0;
      continue;
      label586:
      paramBundle = (LinearLayout)((FragmentActivity)getActivity()).findViewById(2131303846);
      p.g(paramBundle, "activity.lottery_detail_item_container");
      paramBundle.setVisibility(0);
      continue;
      label616:
      i = 0;
      continue;
      label621:
      paramBundle = null;
      continue;
      label626:
      paramBundle = (CharSequence)((FinderLiveLotteryDetailUIC)this).getActivity().getResources().getString(2131760048);
      continue;
      label649:
      paramBundle = (CharSequence)getActivity().getResources().getString(2131760050);
    }
    Object localObject3 = FinderReporterUIC.a.fH((Context)paramBundle);
    paramBundle = (Bundle)localObject2;
    if (localObject3 != null) {
      paramBundle = ((FinderReporterUIC)localObject3).dIx();
    }
    localObject2 = d.vdp;
    localObject3 = d.dnK();
    Object localObject4 = z.aUg();
    p.g(localObject4, "ConfigStorageLogic.getMyFinderUsername()");
    if (str == null) {}
    for (localObject2 = "";; localObject2 = str)
    {
      ((d.b)localObject3).ah((String)localObject4, "", (String)localObject2);
      localObject2 = d.vdp;
      d.dnK().a(paramBundle, 4L);
      ((LinearLayout)((FragmentActivity)getActivity()).findViewById(2131303856)).setOnClickListener((View.OnClickListener)new b(paramBundle, this, str, (awi)localObject1));
      AppMethodBeat.o(255756);
      return;
      label795:
      getActivity().finish();
      AppMethodBeat.o(255756);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveLotteryDetailUIC$Companion;", "", "()V", "KEY_LOTTERY_HISTORY_DETAIL_INFO", "", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/viewmodel/component/FinderLiveLotteryDetailUIC$onCreate$2$5"})
  static final class b
    implements View.OnClickListener
  {
    b(bbn parambbn, FinderLiveLotteryDetailUIC paramFinderLiveLotteryDetailUIC, String paramString, awi paramawi) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255754);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderLiveLotteryDetailUIC$onCreate$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.a((Context)jdField_this.getActivity(), str, this.$contextObj);
      paramView = m.vli;
      m.a(s.ay.vsQ, "");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderLiveLotteryDetailUIC$onCreate$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255754);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(MMActivity paramMMActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(255755);
      this.wyh.finish();
      AppMethodBeat.o(255755);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveLotteryDetailUIC
 * JD-Core Version:    0.7.0.1
 */