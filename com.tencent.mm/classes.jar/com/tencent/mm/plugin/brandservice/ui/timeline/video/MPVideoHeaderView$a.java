package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import d.v;
import java.lang.ref.WeakReference;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
final class MPVideoHeaderView$a
  implements au.b.a
{
  MPVideoHeaderView$a(WeakReference paramWeakReference) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(7255);
    ImageView localImageView = (ImageView)this.ovH.get();
    if (localImageView == null)
    {
      AppMethodBeat.o(7255);
      return;
    }
    d.g.b.p.g(localImageView, "weakReference.get() ?: return@GetContactCallBack");
    Object localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).azF().BH(paramString);
    if ((localObject1 == null) || (((an)localObject1).adE() <= 0))
    {
      AppMethodBeat.o(7255);
      return;
    }
    if ((localImageView.getTag() instanceof String))
    {
      com.tencent.mm.aj.p.aEP().Dw(paramString);
      Object localObject2 = localImageView.getTag();
      if (localObject2 == null)
      {
        paramString = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(7255);
        throw paramString;
      }
      if (bu.lX((String)localObject2, paramString))
      {
        localObject2 = com.tencent.mm.aj.p.aEN().DL(paramString);
        if ((localObject2 != null) && (!bu.isNullOrNil(((i)localObject2).aEH())))
        {
          com.tencent.mm.plugin.brandservice.b.d.a(localImageView, (an)localObject1, ((i)localObject2).aEH(), true);
          AppMethodBeat.o(7255);
          return;
        }
        a.b.d(localImageView, paramString);
      }
    }
    AppMethodBeat.o(7255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView.a
 * JD-Core Version:    0.7.0.1
 */