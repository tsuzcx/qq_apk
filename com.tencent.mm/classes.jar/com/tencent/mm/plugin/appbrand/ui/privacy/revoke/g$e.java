package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.protocal.protobuf.eum;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class g$e
  extends k
  implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
{
  int label;
  
  g$e(d paramd, n paramn, kotlin.d.d<? super e> paramd1)
  {
    super(2, paramd1);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(322814);
    paramObject = (kotlin.d.d)new e(this.uke, this.ukd, paramd);
    AppMethodBeat.o(322814);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(322807);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(322807);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      if (aw.isDarkMode())
      {
        paramObject = ((d.d)this.uke).ujS.ukK.abmt;
        if (paramObject != null) {
          break label168;
        }
        paramObject = ((d.d)this.uke).ujS.ukK.icon_url;
      }
      break;
    }
    for (;;)
    {
      if (paramObject != null)
      {
        ImageView localImageView = (ImageView)((n.d)this.ukd).ukO;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (x.a(paramObject, localImageView, locald) == locala)
        {
          AppMethodBeat.o(322807);
          return locala;
          paramObject = ((d.d)this.uke).ujS.ukK.icon_url;
          break;
          label168:
          continue;
          ResultKt.throwOnFailure(paramObject);
        }
      }
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(322807);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.g.e
 * JD-Core Version:    0.7.0.1
 */