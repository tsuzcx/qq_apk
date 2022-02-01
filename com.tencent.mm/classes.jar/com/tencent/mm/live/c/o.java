package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.live.d.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curNetStatus", "", "durationGroup", "Landroid/view/View;", "durationIcon", "Landroid/widget/ImageView;", "durationText", "durationTv", "Landroid/widget/TextView;", "isAnchor", "", "likeGroup", "likeTv", "membersGroup", "membersIcon", "membersTv", "netBadIcon", "Landroid/graphics/drawable/Drawable;", "netGoodIcon", "netNormalIcon", "checkDuration", "", "createTime", "checkNetwork", "getNetStatusIcon", "resId", "refreshViews", "onlineCnt", "likeCnt", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"})
public final class o
  extends a
{
  private final String TAG;
  public boolean dMz;
  final b hOp;
  final TextView hPE;
  final TextView hPF;
  final TextView hPG;
  private final View hPH;
  private final View hPI;
  private final View hPJ;
  final ImageView hPK;
  private final ImageView hPL;
  final Drawable hPM;
  final Drawable hPN;
  final Drawable hPO;
  public int hPP;
  public String hPQ;
  
  public o(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(207988);
    this.hOp = paramb;
    this.TAG = "MicroMsg.LiveCommonInfoPlugin";
    paramb = paramViewGroup.findViewById(2131303378);
    p.g(paramb, "root.findViewById(R.id.l…e_common_info_members_tv)");
    this.hPE = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303372);
    p.g(paramb, "root.findViewById(R.id.l…_common_info_duration_tv)");
    this.hPF = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303375);
    p.g(paramb, "root.findViewById(R.id.live_common_info_like_tv)");
    this.hPG = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303376);
    p.g(paramb, "root.findViewById(R.id.l…ommon_info_members_group)");
    this.hPH = paramb;
    paramb = paramViewGroup.findViewById(2131303370);
    p.g(paramb, "root.findViewById(R.id.l…mmon_info_duration_group)");
    this.hPI = paramb;
    paramb = paramViewGroup.findViewById(2131303373);
    p.g(paramb, "root.findViewById(R.id.l…e_common_info_like_group)");
    this.hPJ = paramb;
    paramb = paramViewGroup.findViewById(2131303371);
    p.g(paramb, "root.findViewById(R.id.l…ommon_info_duration_icon)");
    this.hPK = ((ImageView)paramb);
    paramViewGroup = paramViewGroup.findViewById(2131303369);
    p.g(paramViewGroup, "root.findViewById(R.id.l…e_common_info_arrow_icon)");
    this.hPL = ((ImageView)paramViewGroup);
    this.hPM = rh(2131691014);
    this.hPN = rh(2131691015);
    this.hPO = rh(2131691013);
    paramViewGroup = e.h.hya;
    this.hPP = e.h.aCS();
    this.hPQ = "00:00:00";
    this.hPH.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207980);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (this.hPR.hOp.getLiveRole() == 0) {
          f.aIN();
        }
        for (;;)
        {
          b.b.a(this.hPR.hOp, b.c.hLO);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(207980);
          return;
          com.tencent.mm.live.d.a.aIc();
        }
      }
    });
    AppMethodBeat.o(207988);
  }
  
  private final Drawable rh(int paramInt)
  {
    AppMethodBeat.i(207984);
    Object localObject = this.hwr.getContext();
    p.g(localObject, "root.context");
    localObject = ((Context)localObject).getResources().getDrawable(paramInt);
    p.g(localObject, "root.context.resources.getDrawable(resId)");
    AppMethodBeat.o(207984);
    return localObject;
  }
  
  public final void aHy()
  {
    AppMethodBeat.i(207985);
    b.a locala = com.tencent.mm.live.core.core.a.b.hyv;
    this.dMz = b.a.aDp();
    if (this.dMz)
    {
      this.hPH.setVisibility(0);
      this.hPI.setVisibility(0);
      this.hPJ.setVisibility(0);
      AppMethodBeat.o(207985);
      return;
    }
    this.hPH.setVisibility(0);
    this.hPI.setVisibility(8);
    this.hPJ.setVisibility(8);
    AppMethodBeat.o(207985);
  }
  
  public final void db(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(207983);
    this.hwr.post((Runnable)new a(this, paramInt1, paramInt2));
    AppMethodBeat.o(207983);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(207986);
    super.rg(paramInt);
    AppMethodBeat.o(207986);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(207987);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (p.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(207987);
      return;
      super.rg(0);
      AppMethodBeat.o(207987);
      return;
      super.rg(8);
      AppMethodBeat.o(207987);
      return;
      if (this.hOp.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          super.rg(4);
          AppMethodBeat.o(207987);
          return;
        }
        super.rg(0);
      }
    }
  }
  
  public final void unMount() {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(o paramo, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(207982);
      int i = this.hPR.hPP;
      Object localObject1 = e.h.hya;
      Object localObject2;
      if (i == e.h.aCS())
      {
        this.hPR.hPK.setImageDrawable(this.hPR.hPM);
        localObject1 = this.hPR.hPE;
        localObject2 = ae.SYK;
        localObject2 = this.hPR.hwr.getContext().getString(2131762331);
        p.g(localObject2, "root.context.getString(R.string.live_members_tip)");
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1) }, 1));
        p.g(localObject2, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)String.valueOf(localObject2));
        this.hPR.hPF.setText((CharSequence)String.valueOf(this.hPR.hPQ));
        localObject2 = this.hPR.hPG;
        localObject1 = u.hIn;
        i = paramInt2;
        if (i > 0) {
          break label238;
        }
        localObject1 = "0";
      }
      for (;;)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        AppMethodBeat.o(207982);
        return;
        localObject1 = e.h.hya;
        if (i == e.h.aCT())
        {
          this.hPR.hPK.setImageDrawable(this.hPR.hPN);
          break;
        }
        localObject1 = e.h.hya;
        if (i != e.h.aCU()) {
          break;
        }
        this.hPR.hPK.setImageDrawable(this.hPR.hPO);
        break;
        label238:
        if (i < 10000)
        {
          localObject1 = String.valueOf(i);
        }
        else if (i % 10000 >= 1000)
        {
          localObject1 = ae.SYK;
          localObject1 = MMApplicationContext.getContext();
          p.g(localObject1, "MMApplicationContext.getContext()");
          localObject1 = ((Context)localObject1).getResources().getString(2131762306);
          p.g(localObject1, "MMApplicationContext.get…g.live_like_count_format)");
          localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Float.valueOf(i / 10000.0F) }, 1));
          p.g(localObject1, "java.lang.String.format(format, *args)");
        }
        else
        {
          localObject1 = ae.SYK;
          localObject1 = MMApplicationContext.getContext();
          p.g(localObject1, "MMApplicationContext.getContext()");
          localObject1 = ((Context)localObject1).getResources().getString(2131762307);
          p.g(localObject1, "MMApplicationContext.get…ve_like_count_int_format)");
          localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(i / 10000) }, 1));
          p.g(localObject1, "java.lang.String.format(format, *args)");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.o
 * JD-Core Version:    0.7.0.1
 */