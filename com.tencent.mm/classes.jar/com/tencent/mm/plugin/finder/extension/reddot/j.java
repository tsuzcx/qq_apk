package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "addFinderLiveEntryNewRedDot", "", "addNearbyFootRedDot", "addNearbyNewRedDot", "addNearbyUnreadRedDot", "unreadCount", "", "addPostRedDot", "addWelcomeNewRedDot", "checkPostRedDot", "getLocalRedDotDefault", "handleOldRedDot", "isShowPostRedDot", "", "isShowRedDot", "local", "flag", "setLocalRedDot", "unset", "Companion", "plugin-finder_release"})
public final class j
{
  public static final a xuH;
  final f xsq;
  
  static
  {
    AppMethodBeat.i(178193);
    xuH = new a((byte)0);
    AppMethodBeat.o(178193);
  }
  
  public j(f paramf)
  {
    AppMethodBeat.i(178192);
    this.xsq = paramf;
    AppMethodBeat.o(178192);
  }
  
  private static boolean Mt(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  private static boolean drD()
  {
    boolean bool2 = true;
    AppMethodBeat.i(278985);
    boolean bool1;
    int i;
    if (!Util.isNullOrNil(com.tencent.mm.model.z.bdh()))
    {
      bool1 = true;
      com.tencent.mm.kernel.f localf = h.aHG();
      p.j(localf, "MMKernel.storage()");
      i = localf.aHp().getInt(ar.a.VAD, drE());
      if ((!((PluginFinder)h.ag(PluginFinder.class)).showPostEntry()) || (!Mt(i)) || (bool1)) {
        break label118;
      }
    }
    for (;;)
    {
      Log.i("Finder.RedDotTransform", "[isShowLocalRedDot] ret=" + bool2 + " local=" + i + " hasCreatedIdentity=" + bool1);
      AppMethodBeat.o(278985);
      return bool2;
      bool1 = false;
      break;
      label118:
      bool2 = false;
    }
  }
  
  private static int drE()
  {
    AppMethodBeat.i(178191);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    int j = localf.aHp().getInt(ar.a.VAD, -1);
    int i = j;
    if (j == -1)
    {
      boolean bool = ((PluginFinder)h.ag(PluginFinder.class)).showPostEntry();
      if (Util.isNullOrNil(com.tencent.mm.model.z.bdh())) {
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
  
  private static void drF()
  {
    AppMethodBeat.i(278987);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.VAD, drE());
    int j = i & 0xFFFFFFFD;
    if (j != i)
    {
      localf = h.aHG();
      p.j(localf, "MMKernel.storage()");
      localf.aHp().set(ar.a.VAD, Integer.valueOf(j));
    }
    Log.i("Finder.RedDotTransform", "[setLocalRedDot] flag=2 unset=true newLocal=" + j + " local=" + i);
    AppMethodBeat.o(278987);
  }
  
  public final void Ms(int paramInt)
  {
    AppMethodBeat.i(278983);
    bhw localbhw = new bhw();
    localbhw.SQm = String.valueOf(cm.bfE());
    localbhw.priority = 10021000;
    localbhw.type = 1013;
    Object localObject = h.ag(ak.class);
    p.j(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
    localObject = ((ak)localObject).getRedDotManager();
    p.j(localObject, "MMKernel.plugin(IPluginF…class.java).redDotManager");
    boolean bool = ((com.tencent.mm.plugin.findersdk.a.z)localObject).dqJ();
    if (bool)
    {
      localObject = new bkn();
      ((bkn)localObject).CKC = 2;
      ((bkn)localObject).SVs = 2;
      ((bkn)localObject).count = paramInt;
      ((bkn)localObject).path = "NearbyEntrance";
      localbhw.MFx.add(localObject);
    }
    bkn localbkn = new bkn();
    localbkn.CKC = 2;
    int i;
    if (bool)
    {
      i = 2;
      localbkn.SVs = i;
      localbkn.count = paramInt;
      localbkn.path = "NearbyPeopleTab";
      if (!bool) {
        break label272;
      }
    }
    label272:
    for (localObject = "NearbyEntrance";; localObject = "")
    {
      localbkn.HpB = ((String)localObject);
      localbhw.MFx.add(localbkn);
      localObject = new bkn();
      ((bkn)localObject).CKC = 2;
      ((bkn)localObject).SVs = 1;
      localbkn.count = paramInt;
      ((bkn)localObject).HpB = "NearbyPeopleTab";
      ((bkn)localObject).path = "NearbyPeopleBubble";
      localbhw.MFx.add(localObject);
      this.xsq.a(localbhw, "addNearByUnreadRedDot");
      AppMethodBeat.o(278983);
      return;
      i = 1;
      break;
    }
  }
  
  final void drA()
  {
    AppMethodBeat.i(278981);
    Object localObject = d.AjH;
    if (((Number)d.dVg().aSr()).intValue() == 0)
    {
      localObject = new bhw();
      ((bhw)localObject).SQm = String.valueOf(cm.bfE());
      ((bhw)localObject).priority = 100000;
      ((bhw)localObject).type = 1002;
      bkn localbkn = new bkn();
      localbkn.CKC = 1;
      localbkn.SVs = 1;
      localbkn.path = "FinderEntrance";
      ((bhw)localObject).MFx.add(localbkn);
      localbkn = new bkn();
      localbkn.CKC = 1;
      localbkn.SVs = 1;
      localbkn.path = "TLPersonalCenter";
      localbkn.HpB = "FinderEntrance";
      ((bhw)localObject).MFx.add(localbkn);
      localbkn = new bkn();
      localbkn.CKC = 1;
      localbkn.SVs = 1;
      localbkn.path = "TLCamera";
      localbkn.HpB = "TLPersonalCenter";
      ((bhw)localObject).MFx.add(localbkn);
      f.a(this.xsq, (bhw)localObject, "checkPostRedDot", null, true, null, null, 52);
    }
    AppMethodBeat.o(278981);
  }
  
  public final void drB()
  {
    AppMethodBeat.i(278982);
    if (this.xsq.aBf("NearbyPeopleFooterprintClear") != null)
    {
      Log.i("Finder.RedDotTransform", "addNearbyFootRedDot: duplicate red dot");
      AppMethodBeat.o(278982);
      return;
    }
    bhw localbhw = new bhw();
    localbhw.SQm = String.valueOf(cm.bfE());
    localbhw.priority = 300000;
    localbhw.type = 1014;
    bkn localbkn = new bkn();
    localbkn.CKC = 101;
    localbkn.SVs = 2;
    localbkn.path = "NearbyEntrance";
    localbhw.MFx.add(localbkn);
    localbkn = new bkn();
    localbkn.CKC = 101;
    localbkn.SVs = 2;
    localbkn.HpB = "NearbyEntrance";
    localbkn.path = "NearbyPeopleTab";
    localbhw.MFx.add(localbkn);
    localbkn = new bkn();
    localbkn.CKC = 101;
    localbkn.SVs = 1;
    localbkn.HpB = "NearbyPeopleTab";
    localbkn.path = "NearbyPeopleFooterprintClear";
    localbhw.MFx.add(localbkn);
    this.xsq.a(localbhw, "addNearByFootRedDot");
    AppMethodBeat.o(278982);
  }
  
  public final void drC()
  {
    AppMethodBeat.i(278984);
    bhw localbhw = new bhw();
    localbhw.SQm = String.valueOf(cm.bfE());
    localbhw.priority = 100000;
    localbhw.type = 1011;
    bkn localbkn = new bkn();
    localbkn.CKC = 6;
    localbkn.SVs = 1;
    localbkn.path = "NearbyEntrance";
    localbhw.MFx.add(localbkn);
    this.xsq.a(localbhw, "addNearbyNewRedDot");
    AppMethodBeat.o(278984);
  }
  
  public final void drz()
  {
    AppMethodBeat.i(278980);
    if (drD())
    {
      drA();
      drF();
      Log.i("Finder.RedDotTransform", "[transformPostRedDot] done");
    }
    d locald = d.AjH;
    if (((Number)d.dVg().aSr()).intValue() != 0)
    {
      this.xsq.Mp(-1);
      Log.i("Finder.RedDotTransform", "[checkPostRedDot] clear TIMELINE_CAMERA");
    }
    AppMethodBeat.o(278980);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.j
 * JD-Core Version:    0.7.0.1
 */