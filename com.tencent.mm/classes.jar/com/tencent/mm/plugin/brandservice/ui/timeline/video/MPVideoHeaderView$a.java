package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.lang.ref.WeakReference;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
final class MPVideoHeaderView$a
  implements ay.b.a
{
  MPVideoHeaderView$a(WeakReference paramWeakReference) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(7255);
    ImageView localImageView = (ImageView)this.pJc.get();
    if (localImageView == null)
    {
      AppMethodBeat.o(7255);
      return;
    }
    kotlin.g.b.p.g(localImageView, "weakReference.get() ?: return@GetContactCallBack");
    Object localObject1 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    kotlin.g.b.p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).aSN().Kn(paramString);
    if ((localObject1 == null) || (((as)localObject1).arH() <= 0))
    {
      AppMethodBeat.o(7255);
      return;
    }
    if ((localImageView.getTag() instanceof String))
    {
      com.tencent.mm.aj.p.aYD().Mg(paramString);
      Object localObject2 = localImageView.getTag();
      if (localObject2 == null)
      {
        paramString = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(7255);
        throw paramString;
      }
      if (Util.isEqual((String)localObject2, paramString))
      {
        localObject2 = com.tencent.mm.aj.p.aYB().Mx(paramString);
        if ((localObject2 != null) && (!Util.isNullOrNil(((i)localObject2).aYu())))
        {
          com.tencent.mm.plugin.brandservice.b.d.a(localImageView, (as)localObject1, ((i)localObject2).aYu(), true);
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