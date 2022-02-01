package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import d.v;
import java.lang.ref.WeakReference;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
final class MPVideoHeaderView$a
  implements as.b.a
{
  MPVideoHeaderView$a(WeakReference paramWeakReference) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(7255);
    ImageView localImageView = (ImageView)this.opP.get();
    if (localImageView == null)
    {
      AppMethodBeat.o(7255);
      return;
    }
    d.g.b.p.g(localImageView, "weakReference.get() ?: return@GetContactCallBack");
    Object localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).azp().Bf(paramString);
    if ((localObject1 == null) || (((am)localObject1).adt() <= 0))
    {
      AppMethodBeat.o(7255);
      return;
    }
    if ((localImageView.getTag() instanceof String))
    {
      com.tencent.mm.ak.p.aEz().CU(paramString);
      Object localObject2 = localImageView.getTag();
      if (localObject2 == null)
      {
        paramString = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(7255);
        throw paramString;
      }
      if (bt.lQ((String)localObject2, paramString))
      {
        localObject2 = com.tencent.mm.ak.p.aEx().Dj(paramString);
        if ((localObject2 != null) && (!bt.isNullOrNil(((i)localObject2).aEr())))
        {
          com.tencent.mm.plugin.brandservice.b.d.a(localImageView, (am)localObject1, ((i)localObject2).aEr(), true);
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