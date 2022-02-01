package com.tencent.mm.aj.b;

import android.content.Context;
import androidx.compose.runtime.as;
import androidx.compose.runtime.at;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.c.c;
import androidx.compose.runtime.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a;
import com.tencent.mm.aj.b.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"WeUIWrapper", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "compose-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final void b(kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(238702);
    s.u(paramm, "content");
    paramh = paramh.by(-45666240);
    final int i;
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(paramm))
      {
        i = 4;
        i |= paramInt;
      }
    }
    for (;;)
    {
      if (((i & 0xB ^ 0x2) != 0) || (!paramh.nZ()))
      {
        Object localObject1 = androidx.compose.foundation.m.mj();
        int j = b.a.BW_0_Alpha_0_1;
        Object localObject2 = MMApplicationContext.getContext();
        s.s(localObject2, "getContext()");
        localObject1 = ((as)localObject1).N(androidx.compose.b.a.m.a(false, 0.0F, a.c(j, (Context)localObject2), paramh, 3));
        localObject2 = (kotlin.g.a.m)c.a(paramh, -819895130, new a(paramm, i));
        q.a(new at[] { localObject1 }, (kotlin.g.a.m)localObject2, paramh, 56);
      }
      for (;;)
      {
        paramh = paramh.oh();
        if (paramh != null) {
          paramh.b((kotlin.g.a.m)new b(paramm, paramInt));
        }
        AppMethodBeat.o(238702);
        return;
        i = 2;
        break;
        paramh.oi();
      }
      i = paramInt;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    a(kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    b(kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.b.h
 * JD-Core Version:    0.7.0.1
 */