package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "addPostRedDot", "", "addWelcomeNewRedDot", "checkOldPostRedDot", "checkPostRedDot", "getLocalRedDotDefault", "", "isShowPostRedDot", "", "isShowRedDot", "local", "flag", "setLocalRedDot", "unset", "Companion", "plugin-finder_release"})
public final class h
{
  public static final a rTb;
  final e rRG;
  
  static
  {
    AppMethodBeat.i(178193);
    rTb = new a((byte)0);
    AppMethodBeat.o(178193);
  }
  
  public h(e parame)
  {
    AppMethodBeat.i(178192);
    this.rRG = parame;
    AppMethodBeat.o(178192);
  }
  
  static boolean Eu(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  static int cAh()
  {
    int k = 1;
    int m = 0;
    AppMethodBeat.i(178191);
    Object localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject).ajl().getInt(al.a.IIb, -1);
    int j;
    if (i == -1)
    {
      localObject = b.sxa;
      if ((b.cFK()) && (((PluginFinder)g.ad(PluginFinder.class)).showPostEntry()))
      {
        j = 1;
        if (bt.isNullOrNil(u.aAu())) {
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
  
  final void cAg()
  {
    AppMethodBeat.i(201651);
    aqu localaqu = new aqu();
    localaqu.GoQ = String.valueOf(cf.aCM());
    localaqu.priority = 100000;
    localaqu.type = -1;
    ase localase = new ase();
    localase.uda = 1;
    localase.Gqr = 1;
    localase.path = "FinderEntrance";
    localaqu.GoP.add(localase);
    localase = new ase();
    localase.uda = 1;
    localase.Gqr = 1;
    localase.path = "TLPersonalCenter";
    localase.xfl = "FinderEntrance";
    localaqu.GoP.add(localase);
    localase = new ase();
    localase.uda = 1;
    localase.Gqr = 1;
    localase.path = "TLCamera";
    localase.xfl = "TLPersonalCenter";
    localaqu.GoP.add(localase);
    e.a(this.rRG, localaqu, "checkPostRedDot", null, null, 12);
    AppMethodBeat.o(201651);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.h
 * JD-Core Version:    0.7.0.1
 */