package com.tencent.mm.plugin.expt.hellhound;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.c.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.f;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  implements f
{
  public final void a(Activity paramActivity, be parambe1, be parambe2)
  {
    AppMethodBeat.i(152230);
    if (parambe1 == null)
    {
      AppMethodBeat.o(152230);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("habbyge-mali, Stack, onPush: ").append(parambe1.wnr.activityName).append("/");
    if (parambe2 == null) {}
    for (String str = "NULL";; str = parambe2.wnr.activityName)
    {
      ab.i("HellhoundService", str);
      b.brY().a(paramActivity, parambe1, 0, parambe2);
      AppMethodBeat.o(152230);
      return;
    }
  }
  
  public final void a(be parambe1, be parambe2)
  {
    AppMethodBeat.i(152231);
    if (parambe1 == null)
    {
      AppMethodBeat.o(152231);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("habbyge-mali, Stack, onPop: ").append(parambe1.wnr.activityName).append("/");
    if (parambe2 == null) {}
    for (String str = "NULL";; str = parambe2.wnr.activityName)
    {
      ab.i("HellhoundService", str);
      b.brY().a(null, parambe1, 1, parambe2);
      if (parambe1 != null) {
        d.a(3, parambe1.wnr.activityName, null);
      }
      AppMethodBeat.o(152231);
      return;
    }
  }
  
  public final void b(be parambe1, be parambe2)
  {
    AppMethodBeat.i(152232);
    if (parambe1 == null)
    {
      AppMethodBeat.o(152232);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("habbyge-mali, Stack, onPopWithSlience: ").append(parambe1.wnr.activityName).append(" | ");
    if (parambe2 == null) {}
    for (String str = "NULL";; str = parambe2.wnr.activityName)
    {
      ab.i("HellhoundService", str);
      b.brY().a(null, parambe1, 2, parambe2);
      if (parambe1 != null) {
        d.a(3, parambe1.wnr.activityName, null);
      }
      AppMethodBeat.o(152232);
      return;
    }
  }
  
  public final void c(be parambe1, be parambe2)
  {
    AppMethodBeat.i(152233);
    if (parambe2 != null) {
      ab.d("HellhoundService", "habbyge-mali, onMoveActivityTaskToBack, curAR/nextAR: " + parambe1.wnr.activityName + "/" + parambe2.wnr.activityName);
    }
    b.brY().a(null, parambe1, 3, parambe2);
    AppMethodBeat.o(152233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.2
 * JD-Core Version:    0.7.0.1
 */