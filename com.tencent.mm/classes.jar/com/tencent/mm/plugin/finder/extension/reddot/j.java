package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "addNearbyFootRedDot", "", "addNearbyNewRedDot", "addNearbyUnreadRedDot", "unreadCount", "", "addPostRedDot", "addWelcomeNewRedDot", "checkPostRedDot", "getLocalRedDotDefault", "handleOldRedDot", "isShowPostRedDot", "", "isShowRedDot", "local", "flag", "setLocalRedDot", "unset", "Companion", "plugin-finder_release"})
public final class j
{
  public static final a tLj;
  final f tJh;
  
  static
  {
    AppMethodBeat.i(178193);
    tLj = new a((byte)0);
    AppMethodBeat.o(178193);
  }
  
  public j(f paramf)
  {
    AppMethodBeat.i(178192);
    this.tJh = paramf;
    AppMethodBeat.o(178192);
  }
  
  private static boolean IC(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  private static boolean dbu()
  {
    boolean bool2 = true;
    AppMethodBeat.i(243630);
    boolean bool1;
    int i;
    if (!Util.isNullOrNil(z.aUg()))
    {
      bool1 = true;
      e locale = g.aAh();
      p.g(locale, "MMKernel.storage()");
      i = locale.azQ().getInt(ar.a.OlI, dbv());
      if ((!((PluginFinder)g.ah(PluginFinder.class)).showPostEntry()) || (!IC(i)) || (bool1)) {
        break label118;
      }
    }
    for (;;)
    {
      Log.i("Finder.RedDotTransform", "[isShowLocalRedDot] ret=" + bool2 + " local=" + i + " hasCreatedIdentity=" + bool1);
      AppMethodBeat.o(243630);
      return bool2;
      bool1 = false;
      break;
      label118:
      bool2 = false;
    }
  }
  
  private static int dbv()
  {
    AppMethodBeat.i(178191);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    int j = locale.azQ().getInt(ar.a.OlI, -1);
    int i = j;
    if (j == -1)
    {
      boolean bool = ((PluginFinder)g.ah(PluginFinder.class)).showPostEntry();
      if (Util.isNullOrNil(z.aUg())) {
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
  
  private static void dbw()
  {
    AppMethodBeat.i(243631);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    int i = locale.azQ().getInt(ar.a.OlI, dbv());
    int j = i & 0xFFFFFFFD;
    if (j != i)
    {
      locale = g.aAh();
      p.g(locale, "MMKernel.storage()");
      locale.azQ().set(ar.a.OlI, Integer.valueOf(j));
    }
    Log.i("Finder.RedDotTransform", "[setLocalRedDot] flag=2 unset=true newLocal=" + j + " local=" + i);
    AppMethodBeat.o(243631);
  }
  
  public final void IB(int paramInt)
  {
    AppMethodBeat.i(243628);
    bbi localbbi = new bbi();
    localbbi.LKM = String.valueOf(cl.aWA());
    localbbi.priority = 10021000;
    localbbi.type = 1013;
    bdo localbdo1 = new bdo();
    localbdo1.xGz = 2;
    localbdo1.LNm = 2;
    localbdo1.count = paramInt;
    localbdo1.path = "NearbyEntrance";
    localbbi.GaM.add(localbdo1);
    localbdo1 = new bdo();
    localbdo1.xGz = 2;
    localbdo1.LNm = 2;
    localbdo1.count = paramInt;
    localbdo1.path = "NearbyPeopleTab";
    localbdo1.Bvg = "NearbyEntrance";
    localbbi.GaM.add(localbdo1);
    bdo localbdo2 = new bdo();
    localbdo2.xGz = 2;
    localbdo2.LNm = 1;
    localbdo1.count = paramInt;
    localbdo2.Bvg = "NearbyPeopleTab";
    localbdo2.path = "NearbyPeopleBubble";
    localbbi.GaM.add(localbdo2);
    this.tJh.a(localbbi, "addNearByUnreadRedDot");
    AppMethodBeat.o(243628);
  }
  
  public final void dbq()
  {
    AppMethodBeat.i(243625);
    if (dbu())
    {
      dbr();
      dbw();
      Log.i("Finder.RedDotTransform", "[transformPostRedDot] done");
    }
    c localc = c.vCb;
    if (((Number)c.dtX().value()).intValue() != 0)
    {
      this.tJh.Iy(-1);
      Log.i("Finder.RedDotTransform", "[checkPostRedDot] clear TIMELINE_CAMERA");
    }
    AppMethodBeat.o(243625);
  }
  
  final void dbr()
  {
    AppMethodBeat.i(243626);
    Object localObject = c.vCb;
    if (((Number)c.dtX().value()).intValue() == 0)
    {
      localObject = new bbi();
      ((bbi)localObject).LKM = String.valueOf(cl.aWA());
      ((bbi)localObject).priority = 100000;
      ((bbi)localObject).type = 1002;
      bdo localbdo = new bdo();
      localbdo.xGz = 1;
      localbdo.LNm = 1;
      localbdo.path = "FinderEntrance";
      ((bbi)localObject).GaM.add(localbdo);
      localbdo = new bdo();
      localbdo.xGz = 1;
      localbdo.LNm = 1;
      localbdo.path = "TLPersonalCenter";
      localbdo.Bvg = "FinderEntrance";
      ((bbi)localObject).GaM.add(localbdo);
      localbdo = new bdo();
      localbdo.xGz = 1;
      localbdo.LNm = 1;
      localbdo.path = "TLCamera";
      localbdo.Bvg = "TLPersonalCenter";
      ((bbi)localObject).GaM.add(localbdo);
      f.a(this.tJh, (bbi)localObject, "checkPostRedDot", null, true, null, 20);
    }
    AppMethodBeat.o(243626);
  }
  
  public final void dbs()
  {
    AppMethodBeat.i(243627);
    if (this.tJh.asX("NearbyPeopleFooterprintClear") != null)
    {
      Log.i("Finder.RedDotTransform", "addNearbyFootRedDot: duplicate red dot");
      AppMethodBeat.o(243627);
      return;
    }
    bbi localbbi = new bbi();
    localbbi.LKM = String.valueOf(cl.aWA());
    localbbi.priority = 300000;
    localbbi.type = 1014;
    bdo localbdo = new bdo();
    localbdo.xGz = 101;
    localbdo.LNm = 2;
    localbdo.path = "NearbyEntrance";
    localbbi.GaM.add(localbdo);
    localbdo = new bdo();
    localbdo.xGz = 101;
    localbdo.LNm = 2;
    localbdo.Bvg = "NearbyEntrance";
    localbdo.path = "NearbyPeopleTab";
    localbbi.GaM.add(localbdo);
    localbdo = new bdo();
    localbdo.xGz = 101;
    localbdo.LNm = 1;
    localbdo.Bvg = "NearbyPeopleTab";
    localbdo.path = "NearbyPeopleFooterprintClear";
    localbbi.GaM.add(localbdo);
    this.tJh.a(localbbi, "addNearByFootRedDot");
    AppMethodBeat.o(243627);
  }
  
  public final void dbt()
  {
    AppMethodBeat.i(243629);
    bbi localbbi = new bbi();
    localbbi.LKM = String.valueOf(cl.aWA());
    localbbi.priority = 300000;
    localbbi.type = 1011;
    bdo localbdo = new bdo();
    localbdo.xGz = 6;
    localbdo.LNm = 1;
    localbdo.path = "NearbyEntrance";
    localbbi.GaM.add(localbdo);
    this.tJh.a(localbbi, "addNearbyNewRedDot");
    AppMethodBeat.o(243629);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.j
 * JD-Core Version:    0.7.0.1
 */