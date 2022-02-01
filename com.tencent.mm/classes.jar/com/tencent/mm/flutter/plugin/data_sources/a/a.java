package com.tencent.mm.flutter.plugin.data_sources.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"isInTagList", "", "userName", "", "isUserChatOnlyOrInSnsTagBlackList", "plugin-voip-status_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final boolean ED(String paramString)
  {
    AppMethodBeat.i(233295);
    s.u(paramString, "<this>");
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxu(paramString);
    if ((localau != null) && (!localau.aSF()) && (!localau.aSN()))
    {
      if (q.Qkl != null) {}
      for (boolean bool = q.Qkl.aRZ(paramString); !bool; bool = false)
      {
        AppMethodBeat.o(233295);
        return false;
      }
    }
    AppMethodBeat.o(233295);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.data_sources.a.a
 * JD-Core Version:    0.7.0.1
 */