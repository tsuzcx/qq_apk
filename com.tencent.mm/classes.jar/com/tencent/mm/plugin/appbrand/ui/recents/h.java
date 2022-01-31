package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public final class h
  implements View.OnClickListener
{
  h.b iUf;
  h.c iUg;
  final h.d iUh;
  private final int iUi;
  private final int iUj;
  private final h.a iUk;
  
  public h(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(133439);
    this.iUg = h.c.iUn;
    this.iUh = new h.d((byte)0);
    this.iUj = 200;
    Context localContext = paramViewGroup.getContext();
    this.iUk = new h.a(this, localContext, (byte)0);
    paramViewGroup = LayoutInflater.from(localContext).inflate(2130968719, paramViewGroup, false);
    this.iUh.aku = paramViewGroup;
    this.iUh.iUs = ((TextView)paramViewGroup.findViewById(2131820680));
    this.iUh.iUt = paramViewGroup.findViewById(2131821350);
    this.iUh.iUv = ((TextView)paramViewGroup.findViewById(2131821352));
    this.iUh.iUu = ((AppBrandNearbyShowcaseView)paramViewGroup.findViewById(2131821351));
    this.iUh.iTR = ((ThreeDotsLoadingView)paramViewGroup.findViewById(2131821355));
    this.iUh.iUw = ((ImageView)paramViewGroup.findViewById(2131821356));
    this.iUh.iUx = ((ImageView)paramViewGroup.findViewById(2131821353));
    this.iUh.aku.setOnClickListener(this);
    this.iUh.iUs.setText(2131296714);
    paramViewGroup = this.iUh.iUu;
    if (paramViewGroup != null)
    {
      paramViewGroup.setIconLayerCount(4);
      paramViewGroup.setIconSize(this.iUk.eln + this.iUk.elp * 2);
      paramViewGroup.setIconGap(this.iUk.elo);
    }
    this.iUi = com.tencent.mm.cb.a.m(localContext, 2131690156);
    AppMethodBeat.o(133439);
  }
  
  static void cB(View paramView)
  {
    AppMethodBeat.i(133444);
    if (paramView.getVisibility() != 0)
    {
      paramView.setAlpha(0.0F);
      paramView.setVisibility(0);
    }
    paramView.animate().setDuration(200L).alpha(1.0F).withEndAction(null).start();
    AppMethodBeat.o(133444);
  }
  
  protected final void a(List<String> paramList, String paramString, Integer paramInteger)
  {
    AppMethodBeat.i(133441);
    ab.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loadingSuccess");
    this.iUg = h.c.iUp;
    this.iUh.iTR.dOW();
    cx(this.iUh.iTR);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ab.e("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.showLoadingSuccess empty iconUrl list");
      AppMethodBeat.o(133441);
      return;
    }
    if (paramList == null)
    {
      ab.e("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "prepareIconList without icon urls");
      if (paramInteger != null) {
        break label346;
      }
    }
    label346:
    for (int i = this.iUi;; i = paramInteger.intValue())
    {
      if (this.iUh.iUv != null)
      {
        this.iUh.iUv.setText(paramString);
        this.iUh.iUv.setTextColor(i);
      }
      if (this.iUh.iUt != null)
      {
        cB(this.iUh.iUt);
        if (this.iUh.iUu != null) {
          this.iUh.iUu.aOx();
        }
        if (this.iUh.iUv != null)
        {
          this.iUh.iUv.setAlpha(0.0F);
          this.iUh.iUv.animate().alpha(1.0F).setDuration(500L).start();
        }
      }
      AppMethodBeat.o(133441);
      return;
      this.iUh.iUu.setIconLayerCount(Math.min(paramList.size(), 4));
      this.iUh.iUu.fa(false);
      Object localObject = this.iUk;
      if (((h.a)localObject).iUm == null) {
        ((h.a)localObject).iUm = new com.tencent.mm.plugin.appbrand.ui.widget.a(((h.a)localObject).eln, ((h.a)localObject).elp);
      }
      localObject = ((h.a)localObject).iUm;
      i = 0;
      while (i < this.iUh.iUu.getChildCount())
      {
        b.acD().a(this.iUh.iUu.pU(i), (String)paramList.get(i), com.tencent.mm.modelappbrand.a.a.acC(), (b.f)localObject);
        i += 1;
      }
      break;
    }
  }
  
  final void cx(View paramView)
  {
    AppMethodBeat.i(133443);
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new h.1(this, paramView)).start();
    }
    AppMethodBeat.o(133443);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133442);
    if (this.iUf != null) {
      this.iUf.a(this.iUg, paramView);
    }
    AppMethodBeat.o(133442);
  }
  
  protected final void showLoading()
  {
    AppMethodBeat.i(133440);
    ab.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loading");
    this.iUg = h.c.iUo;
    cx(this.iUh.iUt);
    cx(this.iUh.iUw);
    cB(this.iUh.iTR);
    this.iUh.iTR.dOV();
    AppMethodBeat.o(133440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.h
 * JD-Core Version:    0.7.0.1
 */