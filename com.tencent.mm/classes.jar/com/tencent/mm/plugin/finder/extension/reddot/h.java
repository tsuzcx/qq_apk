package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "addPostRedDot", "", "addWelcomeNewRedDot", "checkPostRedDot", "getLocalRedDotDefault", "", "handleOldRedDot", "isShowPostRedDot", "", "isShowRedDot", "local", "flag", "setLocalRedDot", "unset", "Companion", "plugin-finder_release"})
public final class h
{
  public static final a sbD;
  final e sai;
  
  static
  {
    AppMethodBeat.i(178193);
    sbD = new a((byte)0);
    AppMethodBeat.o(178193);
  }
  
  public h(e parame)
  {
    AppMethodBeat.i(178192);
    this.sai = parame;
    AppMethodBeat.o(178192);
  }
  
  private static boolean EH(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  private static boolean cBO()
  {
    boolean bool2 = true;
    AppMethodBeat.i(202102);
    boolean bool1;
    int i;
    if (!bu.isNullOrNil(v.aAK()))
    {
      bool1 = true;
      com.tencent.mm.kernel.e locale = g.ajR();
      p.g(locale, "MMKernel.storage()");
      i = locale.ajA().getInt(am.a.JcE, cBP());
      if ((!((PluginFinder)g.ad(PluginFinder.class)).showPostEntry()) || (!EH(i)) || (bool1)) {
        break label118;
      }
    }
    for (;;)
    {
      ae.i("Finder.RedDotTransform", "[isShowLocalRedDot] ret=" + bool2 + " local=" + i + " hasCreatedIdentity=" + bool1);
      AppMethodBeat.o(202102);
      return bool2;
      bool1 = false;
      break;
      label118:
      bool2 = false;
    }
  }
  
  private static int cBP()
  {
    AppMethodBeat.i(178191);
    com.tencent.mm.kernel.e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    int j = locale.ajA().getInt(am.a.JcE, -1);
    int i = j;
    if (j == -1)
    {
      boolean bool = ((PluginFinder)g.ad(PluginFinder.class)).showPostEntry();
      if (bu.isNullOrNil(v.aAK())) {
        break label74;
      }
      i = 1;
      if ((!bool) || (i != 0)) {
        break label79;
      }
    }
    label74:
    label79:
    for (i = 2;; i = 0)
    {
      AppMethodBeat.o(178191);
      return i;
      i = 0;
      break;
    }
  }
  
  private static void cBQ()
  {
    AppMethodBeat.i(202103);
    com.tencent.mm.kernel.e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajA().getInt(am.a.JcE, cBP());
    int j = i & 0xFFFFFFFD;
    if (j != i)
    {
      locale = g.ajR();
      p.g(locale, "MMKernel.storage()");
      locale.ajA().set(am.a.JcE, Integer.valueOf(j));
    }
    ae.i("Finder.RedDotTransform", "[setLocalRedDot] flag=2 unset=true newLocal=" + j + " local=" + i);
    AppMethodBeat.o(202103);
  }
  
  public final void cBM()
  {
    AppMethodBeat.i(202100);
    if (cBO())
    {
      cBN();
      cBQ();
      ae.i("Finder.RedDotTransform", "[transformPostRedDot] done");
    }
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cKg().value()).intValue() != 0)
    {
      e.a(this.sai, -1);
      ae.i("Finder.RedDotTransform", "[checkPostRedDot] clear TIMELINE_CAMERA");
    }
    AppMethodBeat.o(202100);
  }
  
  final void cBN()
  {
    AppMethodBeat.i(202101);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cKg().value()).intValue() == 0)
    {
      localObject = new arj();
      ((arj)localObject).GIg = String.valueOf(ch.aDc());
      ((arj)localObject).priority = 100000;
      ((arj)localObject).type = -1;
      ast localast = new ast();
      localast.uoi = 1;
      localast.GJM = 1;
      localast.path = "FinderEntrance";
      ((arj)localObject).GIf.add(localast);
      localast = new ast();
      localast.uoi = 1;
      localast.GJM = 1;
      localast.path = "TLPersonalCenter";
      localast.xvd = "FinderEntrance";
      ((arj)localObject).GIf.add(localast);
      localast = new ast();
      localast.uoi = 1;
      localast.GJM = 1;
      localast.path = "TLCamera";
      localast.xvd = "TLPersonalCenter";
      ((arj)localObject).GIf.add(localast);
      e.a(this.sai, (arj)localObject, "checkPostRedDot", null, null, true, 12);
    }
    AppMethodBeat.o(202101);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.h
 * JD-Core Version:    0.7.0.1
 */