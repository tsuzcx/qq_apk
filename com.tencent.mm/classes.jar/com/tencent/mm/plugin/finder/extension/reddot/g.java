package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;
import d.v;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "addPostRedDot", "", "addWelcomeNewRedDot", "checkFirstFeedFav", "checkOldPostRedDot", "checkPostRedDot", "getLocalRedDotDefault", "", "isShowPostRedDot", "", "isShowRedDot", "local", "flag", "setLocalRedDot", "unset", "Companion", "plugin-finder_release"})
public final class g
{
  public static final a rfs;
  final d rfr;
  
  static
  {
    AppMethodBeat.i(178193);
    rfs = new a((byte)0);
    AppMethodBeat.o(178193);
  }
  
  public g(d paramd)
  {
    AppMethodBeat.i(178192);
    this.rfr = paramd;
    AppMethodBeat.o(178192);
  }
  
  static boolean DB(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  static int ctX()
  {
    int k = 1;
    int m = 0;
    AppMethodBeat.i(178191);
    Object localObject = com.tencent.mm.kernel.g.agR();
    k.g(localObject, "MMKernel.storage()");
    int i = ((e)localObject).agA().getInt(ah.a.GVt, -1);
    int j;
    if (i == -1)
    {
      localObject = b.rCU;
      if ((b.cyP()) && (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry()))
      {
        j = 1;
        if (bs.isNullOrNil(u.axE())) {
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
  
  final void ctV()
  {
    AppMethodBeat.i(201483);
    ani localani = new ani();
    localani.EGt = String.valueOf(ce.azJ());
    localani.priority = 100000;
    localani.type = -1;
    aon localaon = new aon();
    localaon.tfk = 1;
    localaon.EHC = 1;
    localaon.path = "FinderEntrance";
    localani.EGs.add(localaon);
    localaon = new aon();
    localaon.tfk = 1;
    localaon.EHC = 1;
    localaon.path = "TLPersonalCenter";
    localaon.vXx = "FinderEntrance";
    localani.EGs.add(localaon);
    localaon = new aon();
    localaon.tfk = 1;
    localaon.EHC = 1;
    localaon.path = "TLCamera";
    localaon.vXx = "TLPersonalCenter";
    localani.EGs.add(localaon);
    d.a(this.rfr, localani, "checkPostRedDot");
    AppMethodBeat.o(201483);
  }
  
  public final void ctW()
  {
    AppMethodBeat.i(201484);
    ac.i("Finder.RedDotTransform", "checkFirstFeedFav");
    Object localObject = b.rCU;
    if (!b.czT())
    {
      ac.i("Finder.RedDotTransform", "checkFirstFeedFav return");
      AppMethodBeat.o(201484);
      return;
    }
    localObject = com.tencent.mm.kernel.g.agR();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).agA().get(ah.a.GWf, Boolean.FALSE);
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(201484);
      throw ((Throwable)localObject);
    }
    if (!((Boolean)localObject).booleanValue())
    {
      localObject = new ani();
      ((ani)localObject).EGt = String.valueOf(ce.azJ());
      ((ani)localObject).priority = 100000;
      ((ani)localObject).type = 1001;
      aon localaon = new aon();
      localaon.tfk = 1;
      localaon.EHC = 1;
      localaon.path = "TLPersonalCenter";
      ((ani)localObject).EGs.add(localaon);
      localaon = new aon();
      localaon.tfk = 1;
      localaon.EHC = 1;
      localaon.path = "FinderFirstFav";
      ((ani)localObject).EGs.add(localaon);
      d.a(this.rfr, (ani)localObject, "checkTlFirstFav");
      localObject = com.tencent.mm.kernel.g.agR();
      k.g(localObject, "MMKernel.storage()");
      ((e)localObject).agA().set(ah.a.GWg, Boolean.TRUE);
      localObject = com.tencent.mm.kernel.g.agR();
      k.g(localObject, "MMKernel.storage()");
      ((e)localObject).agA().set(ah.a.GWf, Boolean.TRUE);
    }
    AppMethodBeat.o(201484);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.g
 * JD-Core Version:    0.7.0.1
 */