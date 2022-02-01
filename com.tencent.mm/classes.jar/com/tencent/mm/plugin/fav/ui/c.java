package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fav/ui/FavDataItemChecker;", "", "()V", "Companion", "ui-fav_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a Ago;
  
  static
  {
    AppMethodBeat.i(274425);
    Ago = new c.a((byte)0);
    AppMethodBeat.o(274425);
  }
  
  public static final boolean b(dn paramdn)
  {
    AppMethodBeat.i(274423);
    s.u(paramdn, "event");
    paramdn = paramdn.hDr.hDt;
    if (paramdn != null)
    {
      paramdn = paramdn.vEn;
      if (paramdn != null)
      {
        paramdn = ((Iterable)paramdn).iterator();
        while (paramdn.hasNext())
        {
          arf localarf = (arf)paramdn.next();
          arg localarg = localarf.Zzy;
          if ((localarg == null) || (localarg.ZAz == null)) {
            switch (localarf.dataType)
            {
            default: 
              break;
            case 2: 
            case 4: 
            case 8: 
            case 15: 
              if (Util.isNullOrNil(localarf.Ysw))
              {
                if (Util.isNullOrNil(localarf.Zzd))
                {
                  AppMethodBeat.o(274423);
                  return false;
                }
                if (!y.ZC(localarf.Zzd))
                {
                  AppMethodBeat.o(274423);
                  return false;
                }
              }
              break;
            case 3: 
              if (!y.ZC(localarf.Zzd))
              {
                AppMethodBeat.o(274423);
                return false;
              }
              break;
            }
          }
        }
      }
    }
    AppMethodBeat.o(274423);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c
 * JD-Core Version:    0.7.0.1
 */