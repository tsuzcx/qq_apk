package com.tencent.mm.plugin.eggspring.ui;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.eggspring.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.t.a.n;
import com.tencent.mm.t.a.o;
import com.tencent.mm.t.a.q;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"})
public final class SpringLuckyEggActivity$e<T>
  implements s<T>
{
  public SpringLuckyEggActivity$e(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
  
  public final void onChanged(T paramT)
  {
    AppMethodBeat.i(249624);
    n localn = (n)paramT;
    if (localn == null)
    {
      AppMethodBeat.o(249624);
      return;
    }
    paramT = com.tencent.mm.plugin.eggspring.e.uxF;
    com.tencent.mm.plugin.eggspring.e.R(1, localn.jEe);
    SpringLuckyEggActivity.a(this.uyj).uyy.setText((CharSequence)localn.title);
    SpringLuckyEggActivity.a(this.uyj).tuj.setText((CharSequence)localn.desc);
    if (((p.h((Boolean)SpringLuckyEggActivity.b(this.uyj).uyO.getValue(), Boolean.TRUE) ^ true)) || (!a.a(localn))) {
      SpringLuckyEggActivity.a(this.uyj).uyz.setText((CharSequence)localn.jDV);
    }
    paramT = localn.jEf.jEp;
    if (paramT != null) {
      SpringLuckyEggActivity.a(this.uyj).uyD.setText((CharSequence)paramT.jEw);
    }
    paramT = (CharSequence)localn.jEc;
    int i;
    if ((paramT == null) || (paramT.length() == 0)) {
      i = 1;
    }
    Object localObject;
    boolean bool;
    while (i == 0)
    {
      if (localn.jEb != 2) {
        break label587;
      }
      paramT = this.uyj;
      localObject = SpringLuckyEggActivity.a(this.uyj).uyF;
      c localc = SpringLuckyEggActivity.a(this.uyj);
      String str = localn.jEc;
      p.j(str, "material.creative_url");
      SpringLuckyEggActivity.a(paramT, new e((SpringEggVideoView)localObject, localc, str));
      paramT = SpringLuckyEggActivity.d(this.uyj);
      if (paramT != null)
      {
        Log.i("MicroMsg.VideoController", "start");
        paramT.uyF.start();
        localObject = paramT.uyF.getContext().getSystemService("audio");
        if (localObject == null)
        {
          paramT = new t("null cannot be cast to non-null type android.media.AudioManager");
          AppMethodBeat.o(249624);
          throw paramT;
          i = 0;
          continue;
        }
        localObject = (AudioManager)localObject;
        Log.i("MicroMsg.VideoController", "init: rangerMode=" + ((AudioManager)localObject).getRingerMode());
        if (((AudioManager)localObject).getRingerMode() == 2) {
          break label430;
        }
      }
      label430:
      for (bool = true;; bool = false)
      {
        paramT.setMute(bool);
        paramT.uyf.uyG.setVisibility(0);
        paramT.uyF.setVisibility(0);
        paramT = SpringLuckyEggActivity.a(this.uyj).uyA.getLayoutParams();
        if (paramT != null) {
          break;
        }
        paramT = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(249624);
        throw paramT;
      }
      paramT = (FrameLayout.LayoutParams)paramT;
      paramT.width = -1;
      paramT.height = this.uyj.getResources().getDimensionPixelSize(d.c.uwS);
      paramT.topMargin = 0;
      paramT.gravity = 17;
      SpringLuckyEggActivity.a(this.uyj).uyA.requestLayout();
      localObject = this.uyj;
      paramT = localn.jEd;
      p.j(paramT, "material.thumb_url");
    }
    label696:
    for (;;)
    {
      for (bool = false;; bool = true)
      {
        SpringLuckyEggActivity.a((SpringLuckyEggActivity)localObject, paramT, bool);
        label587:
        do
        {
          if (!a.b(localn)) {
            break;
          }
          SpringLuckyEggActivity.a(this.uyj).uyz.setVisibility(8);
          SpringLuckyEggActivity.a(this.uyj).uyE.setVisibility(0);
          SpringLuckyEggActivity.a(this.uyj).uyC.setVisibility(8);
          SpringLuckyEggActivity.a(this.uyj).uyz.setVisibility(8);
          AppMethodBeat.o(249624);
          return;
        } while (localn.jEb != 1);
        localObject = this.uyj;
        paramT = localn.jEc;
        p.j(paramT, "material.creative_url");
        if ((localn == null) || (localn.jDT != 4)) {
          break label696;
        }
      }
      SpringLuckyEggActivity.a(this.uyj).uyz.setVisibility(0);
      SpringLuckyEggActivity.a(this.uyj).uyE.setVisibility(8);
      SpringLuckyEggActivity.a(this.uyj).uyC.setVisibility(0);
      SpringLuckyEggActivity.a(this.uyj).uyz.setVisibility(0);
      AppMethodBeat.o(249624);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggActivity.e
 * JD-Core Version:    0.7.0.1
 */