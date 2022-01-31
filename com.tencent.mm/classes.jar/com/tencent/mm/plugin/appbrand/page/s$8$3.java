package com.tencent.mm.plugin.appbrand.page;

import a.f.b.j;
import android.content.DialogInterface.OnClickListener;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.ui.MMFragmentActivity.a;

final class s$8$3
  implements Runnable
{
  s$8$3(s.8 param8) {}
  
  public final void run()
  {
    AppMethodBeat.i(155938);
    Object localObject1 = s.b(this.iwZ.iwT);
    s.a(this.iwZ.iwT, new g(this.iwZ.iwT.getContext()));
    Object localObject2 = new s.8.3.1(this);
    s.b(this.iwZ.iwT).setPositiveButton((DialogInterface.OnClickListener)localObject2);
    s.b(this.iwZ.iwT).setNegativeButton((DialogInterface.OnClickListener)localObject2);
    localObject2 = s.b(this.iwZ.iwT);
    Object localObject3 = this.iwZ.iwT;
    s.8.3.2 local2 = new s.8.3.2(this, (g)localObject1);
    j.q(localObject3, "pageContainer");
    ((g)localObject2).ivz = ((r)localObject3);
    ((r)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    ((g)localObject2).bringToFront();
    localObject3 = ((r)localObject3).getRuntime();
    if (localObject3 == null) {
      j.ebi();
    }
    Object localObject4 = ((g)localObject2).ivB;
    com.tencent.mm.modelappbrand.a.b localb;
    if (localObject4 != null)
    {
      localObject1 = ((i)localObject3).wZ();
      if (localObject1 != null)
      {
        localObject1 = ((AppBrandInitConfig)localObject1).cqQ;
        if (localObject1 != null)
        {
          localObject1 = (CharSequence)localObject1;
          ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setMainTitle((CharSequence)localObject1);
          ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setBackgroundColor(0);
          ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).setForegroundStyle(true);
          ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject4).fb(true);
        }
      }
    }
    else
    {
      localObject4 = ((g)localObject2).ivC;
      if (localObject4 != null)
      {
        localObject1 = new ColorMatrix();
        ((ColorMatrix)localObject1).setSaturation(0.0F);
        ((ImageView)localObject4).setColorFilter((ColorFilter)new ColorMatrixColorFilter((ColorMatrix)localObject1));
        localb = com.tencent.mm.modelappbrand.a.b.acD();
        localObject1 = ((i)localObject3).wZ();
        if (localObject1 == null) {
          break label388;
        }
      }
    }
    label388:
    for (localObject1 = ((AppBrandInitConfig)localObject1).iconUrl;; localObject1 = null)
    {
      localb.a((ImageView)localObject4, (String)localObject1, a.acC(), (b.f)f.fqU);
      localObject1 = ((g)localObject2).ivy;
      if (localObject1 != null) {
        ((Animation)localObject1).cancel();
      }
      ((g)localObject2).ivy = AnimationUtils.loadAnimation(((g)localObject2).getContext(), MMFragmentActivity.a.zbX);
      localObject1 = ((g)localObject2).ivy;
      if (localObject1 == null) {
        j.ebi();
      }
      ((Animation)localObject1).setAnimationListener((Animation.AnimationListener)new g.d((g)localObject2, local2));
      localObject1 = ((g)localObject2).ivy;
      if (localObject1 == null) {
        j.ebi();
      }
      ((g)localObject2).startAnimation((Animation)localObject1);
      AppMethodBeat.o(155938);
      return;
      localObject1 = (CharSequence)"";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.s.8.3
 * JD-Core Version:    0.7.0.1
 */