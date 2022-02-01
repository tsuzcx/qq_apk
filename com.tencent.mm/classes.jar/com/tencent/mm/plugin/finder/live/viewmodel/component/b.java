package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bm;
import com.tencent.mm.plugin.finder.report.d.b;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.dis;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveLotteryDetailUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class b
  extends UIComponent
{
  public static final a zdz;
  
  static
  {
    AppMethodBeat.i(250640);
    zdz = new a((byte)0);
    AppMethodBeat.o(250640);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250639);
    AppMethodBeat.o(250639);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_lottery_detail_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250637);
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(250637);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    paramBundle.setMMTitle(b.j.finder_live_more_action_lottery_detail);
    paramBundle.setBackBtn((MenuItem.OnMenuItemClickListener)new c(paramBundle));
    final String str1 = getActivity().getIntent().getStringExtra("KEY_LIVE_ANCHOR_USERNAME");
    Object localObject1 = getActivity().getIntent().getByteArrayExtra("KEY_LOTTERY_HISTORY_INFO");
    if (localObject1 != null) {
      paramBundle = new bal();
    }
    final long l;
    Object localObject3;
    for (;;)
    {
      try
      {
        paramBundle.parseFrom((byte[])localObject1);
        localObject1 = paramBundle;
        l = getActivity().getIntent().getLongExtra("KEY_LOTTERY_HISTORY_OBJECT_ID", 0L);
        if (localObject1 == null) {
          break label827;
        }
        paramBundle = com.tencent.mm.plugin.finder.api.d.wZQ;
        localObject3 = d.a.aAK(str1);
        localObject2 = getActivity().getResources().getString(b.j.finder_live_lottery_history_detail_title);
        p.j(localObject2, "activity.resources.getSt…ery_history_detail_title)");
        paramBundle = (Bundle)localObject2;
        if (localObject3 != null) {
          paramBundle = (String)localObject2 + "·" + ((i)localObject3).getNickname();
        }
        localObject2 = (TextView)((FragmentActivity)getActivity()).findViewById(b.f.lottery_detail_title);
        p.j(localObject2, "activity.lottery_detail_title");
        ((TextView)localObject2).setText((CharSequence)paramBundle);
        paramBundle = (CharSequence)((bal)localObject1).description;
        if ((paramBundle != null) && (paramBundle.length() != 0)) {
          break label611;
        }
        i = 1;
        if (i == 0) {
          break label616;
        }
        paramBundle = (LinearLayout)((FragmentActivity)getActivity()).findViewById(b.f.lottery_detail_item_container);
        p.j(paramBundle, "activity.lottery_detail_item_container");
        paramBundle.setVisibility(8);
        paramBundle = (TextView)((FragmentActivity)getActivity()).findViewById(b.f.lottery_detail_item_desc);
        p.j(paramBundle, "activity.lottery_detail_item_desc");
        paramBundle.setText((CharSequence)((bal)localObject1).description);
        localObject2 = (TextView)((FragmentActivity)getActivity()).findViewById(b.f.lottery_detail_item_type);
        p.j(localObject2, "activity.lottery_detail_item_type");
        paramBundle = ((bal)localObject1).SKZ;
        if ((paramBundle == null) || (paramBundle.SMp != 1)) {
          break label680;
        }
        paramBundle = ((bal)localObject1).SKZ;
        if (paramBundle == null) {
          break label657;
        }
        paramBundle = paramBundle.SMq;
        if (paramBundle == null) {
          break label657;
        }
        if (((CharSequence)paramBundle).length() <= 0) {
          break label647;
        }
        i = 1;
        if (i == 0) {
          break label652;
        }
        if (paramBundle == null) {
          break label657;
        }
        paramBundle = getActivity().getResources().getString(b.j.finder_live_lottery_desc_comment, new Object[] { paramBundle });
        if (paramBundle == null) {
          break label657;
        }
        paramBundle = (CharSequence)paramBundle;
        ((TextView)localObject2).setText(paramBundle);
        paramBundle = (TextView)((FragmentActivity)getActivity()).findViewById(b.f.lottery_detail_item_count);
        p.j(paramBundle, "activity.lottery_detail_item_count");
        paramBundle.setText((CharSequence)getActivity().getResources().getString(b.j.finder_live_lottery_history_detail_item_count_num, new Object[] { Integer.valueOf(((bal)localObject1).yaH) }));
        paramBundle = (TextView)((FragmentActivity)getActivity()).findViewById(b.f.lottery_detail_item_time);
        p.j(paramBundle, "activity.lottery_detail_item_time");
        paramBundle.setText((CharSequence)f.formatTime("yyyy-MM-dd HH:mm", ((bal)localObject1).endTime));
        paramBundle = aj.Bnu;
        paramBundle = getActivity();
        if (paramBundle != null) {
          break;
        }
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(250637);
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
      label611:
      int i = 0;
      continue;
      label616:
      paramBundle = (LinearLayout)((FragmentActivity)getActivity()).findViewById(b.f.lottery_detail_item_container);
      p.j(paramBundle, "activity.lottery_detail_item_container");
      paramBundle.setVisibility(0);
      continue;
      label647:
      i = 0;
      continue;
      label652:
      paramBundle = null;
      continue;
      label657:
      paramBundle = (CharSequence)((b)this).getActivity().getResources().getString(b.j.finder_live_lottery_input_any_comment);
      continue;
      label680:
      paramBundle = (CharSequence)getActivity().getResources().getString(b.j.finder_live_lottery_like);
    }
    paramBundle = aj.a.fZ((Context)paramBundle);
    String str2;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.ekY();
      localObject2 = com.tencent.mm.plugin.finder.report.d.zUg;
      localObject3 = com.tencent.mm.plugin.finder.report.d.dPh();
      str2 = z.bdh();
      p.j(str2, "ConfigStorageLogic.getMyFinderUsername()");
      if (str1 != null) {
        break label840;
      }
    }
    label827:
    label840:
    for (Object localObject2 = "";; localObject2 = str1)
    {
      ((d.b)localObject3).ae(str2, "", (String)localObject2);
      localObject2 = com.tencent.mm.plugin.finder.report.d.zUg;
      com.tencent.mm.plugin.finder.report.d.dPh().a(paramBundle, 4L);
      ((LinearLayout)((FragmentActivity)getActivity()).findViewById(b.f.lottery_message_entrance)).setOnClickListener((View.OnClickListener)new b(paramBundle, this, str1, (bal)localObject1, l));
      AppMethodBeat.o(250637);
      return;
      paramBundle = null;
      break;
      getActivity().finish();
      AppMethodBeat.o(250637);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveLotteryDetailUIC$Companion;", "", "()V", "KEY_LOTTERY_HISTORY_DETAIL_INFO", "", "KEY_LOTTERY_HISTORY_OBJECT_ID", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveLotteryDetailUIC$onCreate$2$5"})
  static final class b
    implements View.OnClickListener
  {
    b(bid parambid, b paramb, String paramString, bal parambal, long paramLong) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257102);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveLotteryDetailUIC$onCreate$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dUP().aSr()).intValue() <= 0)
      {
        p.j(paramView, "it");
        localObject = paramView.getContext();
        paramView = paramView.getContext();
        p.j(paramView, "it.context");
        w.makeText((Context)localObject, (CharSequence)paramView.getResources().getString(b.j.finder_cannot_send_msg_title), 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveLotteryDetailUIC$onCreate$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(257102);
        return;
      }
      paramView = new bak();
      paramView.username = str1;
      paramView.SKV = false;
      localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject = (Context)jdField_this.getActivity();
      int i = this.zdC.SMs.TQj;
      String str = this.zdC.id;
      p.j(str, "lotteryInfo.id");
      com.tencent.mm.plugin.finder.utils.a.a((Context)localObject, i, paramView, str, l, this.$contextObj, false);
      m.yCt.a(s.bm.yMW, "");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveLotteryDetailUIC$onCreate$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257102);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(MMActivity paramMMActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(229909);
      this.zdE.finish();
      AppMethodBeat.o(229909);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.b
 * JD-Core Version:    0.7.0.1
 */