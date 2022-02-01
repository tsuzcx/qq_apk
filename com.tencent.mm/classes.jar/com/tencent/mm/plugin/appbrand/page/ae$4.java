package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.svg.a.a;

final class ae$4
  implements Runnable
{
  ae$4(ae paramae) {}
  
  public final void run()
  {
    AppMethodBeat.i(221299);
    ad.i("MicroMsg.AppBrandPageViewWC", "customActionBarIfNeed decorateActionBarToSinglePageMode");
    if (this.mcH.mbV == null)
    {
      AppMethodBeat.o(221299);
      return;
    }
    Object localObject = this.mcH.getContext();
    this.mcH.mbV.setNavResetStyleListener(new b.c()
    {
      public final void a(ImageView paramAnonymousImageView, View paramAnonymousView1, View paramAnonymousView2)
      {
        AppMethodBeat.i(221297);
        if (paramAnonymousImageView != null)
        {
          paramAnonymousImageView.clearColorFilter();
          if ((!ae.m(ae.4.this.mcH)) && (!ae.4.this.mcH.getRuntime().Eb())) {
            break label98;
          }
        }
        label98:
        for (int i = 2131689499;; i = 2131689492)
        {
          paramAnonymousImageView.setImageDrawable(a.g(this.val$context.getResources(), i));
          paramAnonymousView2 = paramAnonymousImageView.getLayoutParams();
          paramAnonymousView2.height = -1;
          paramAnonymousView2.width = -2;
          paramAnonymousImageView.setLayoutParams(paramAnonymousView2);
          if (paramAnonymousView1 != null) {
            paramAnonymousView1.setBackground(null);
          }
          AppMethodBeat.o(221297);
          return;
        }
      }
      
      public final int buX()
      {
        return mTY;
      }
    });
    int i;
    if ((ae.m(this.mcH)) || (this.mcH.getRuntime().Eb()))
    {
      i = 2131689500;
      localObject = a.h(((Context)localObject).getResources(), i);
      this.mcH.mbV.a((Bitmap)localObject, new ae.4.2(this));
      if ("squeezed".equals(ae.n(this.mcH))) {
        break label186;
      }
    }
    label186:
    for (boolean bool = true;; bool = false)
    {
      this.mcH.hg(bool);
      this.mcH.mbV.hK(false);
      this.mcH.mbV.setFullscreenMode(false);
      this.mcH.mbV.hW(true);
      ae.o(this.mcH);
      AppMethodBeat.o(221299);
      return;
      i = 2131689493;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae.4
 * JD-Core Version:    0.7.0.1
 */