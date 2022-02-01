package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "checkFirstFeedFav", "", "checkPostRedDot", "getLocalRedDotDefault", "", "isShowPostRedDot", "", "isShowRedDot", "local", "flag", "setLocalRedDot", "unset", "test", "Companion", "plugin-finder_release"})
public final class e
{
  public static final a qtK;
  public final c qtJ;
  
  static
  {
    AppMethodBeat.i(178193);
    qtK = new a((byte)0);
    AppMethodBeat.o(178193);
  }
  
  public e(c paramc)
  {
    AppMethodBeat.i(178192);
    this.qtJ = paramc;
    AppMethodBeat.o(178192);
  }
  
  static boolean Cz(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  static int getLocalRedDotDefault()
  {
    int k = 1;
    int m = 0;
    AppMethodBeat.i(178191);
    Object localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject).afk().getInt(ae.a.Fxd, -1);
    int j;
    if (i == -1)
    {
      localObject = b.qJA;
      if ((b.cps()) && (((PluginFinder)g.ad(PluginFinder.class)).showPostEntry()))
      {
        j = 1;
        if (bt.isNullOrNil(u.aqO())) {
          break label101;
        }
        label75:
        i = m;
        if (j != 0)
        {
          i = m;
          if (k == 0) {
            i = 2;
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(178191);
      return i;
      j = 0;
      break;
      label101:
      k = 0;
      break label75;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.e
 * JD-Core Version:    0.7.0.1
 */