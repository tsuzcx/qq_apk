package com.tencent.mm.plugin.finder.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/permission/FinderEntrancePermission;", "", "()V", "TAG", "", "hasFinderCreateEntrancePermission", "", "hasFinderEntrancePermission", "hasFinderPostEntrancePermission", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ESS;
  
  static
  {
    AppMethodBeat.i(329996);
    ESS = new a();
    AppMethodBeat.o(329996);
  }
  
  public static boolean eGX()
  {
    boolean bool2 = true;
    AppMethodBeat.i(329986);
    Object localObject = d.FAy;
    int i = ((Number)d.eSq().bmg()).intValue();
    if (i != 0)
    {
      Log.i("Finder.EntrancePermission", s.X("[hasFinderEntrancePermission] debugConfig=", Integer.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(329986);
        return true;
      }
      AppMethodBeat.o(329986);
      return false;
    }
    i = ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("FinderTimelineEntry", 100);
    boolean bool1;
    if (i != 0)
    {
      bool1 = true;
      localObject = com.tencent.mm.plugin.findersdk.d.a.Hdr;
      if (com.tencent.mm.plugin.findersdk.d.a.aDh("entrance") != 2) {
        break label152;
      }
    }
    for (;;)
    {
      Log.i("Finder.EntrancePermission", "[hasFinderEntrancePermission] hasPermission=" + bool1 + " serverConfig=" + i + " isSpam=" + bool2);
      AppMethodBeat.o(329986);
      return bool1;
      bool1 = false;
      break;
      label152:
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.permission.a
 * JD-Core Version:    0.7.0.1
 */