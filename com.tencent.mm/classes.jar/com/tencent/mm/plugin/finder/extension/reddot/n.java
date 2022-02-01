package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform;", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "addFinderLiveEntryNewRedDot", "", "addNearbyFootRedDot", "addNearbyNewRedDot", "addNearbyUnreadRedDot", "unreadCount", "", "addPostRedDot", "addWelcomeNewRedDot", "checkPostRedDot", "getLocalRedDotDefault", "handleOldRedDot", "isShowPostRedDot", "", "isShowRedDot", "local", "flag", "setLocalRedDot", "unset", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final a ASt;
  final i APO;
  
  static
  {
    AppMethodBeat.i(178193);
    ASt = new a((byte)0);
    AppMethodBeat.o(178193);
  }
  
  public n(i parami)
  {
    AppMethodBeat.i(178192);
    this.APO = parami;
    AppMethodBeat.o(178192);
  }
  
  private static boolean NA(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  private static boolean eas()
  {
    boolean bool2 = true;
    AppMethodBeat.i(366806);
    boolean bool1;
    int i;
    if (!Util.isNullOrNil(z.bAW()))
    {
      bool1 = true;
      i = h.baE().ban().getInt(at.a.adcV, eat());
      if ((!((PluginFinder)h.az(PluginFinder.class)).showPostEntry()) || (!NA(i)) || (bool1)) {
        break label110;
      }
    }
    for (;;)
    {
      Log.i("Finder.RedDotTransform", "[isShowLocalRedDot] ret=" + bool2 + " local=" + i + " hasCreatedIdentity=" + bool1);
      AppMethodBeat.o(366806);
      return bool2;
      bool1 = false;
      break;
      label110:
      bool2 = false;
    }
  }
  
  private static int eat()
  {
    AppMethodBeat.i(178191);
    int j = h.baE().ban().getInt(at.a.adcV, -1);
    int i = j;
    if (j == -1)
    {
      boolean bool = ((PluginFinder)h.az(PluginFinder.class)).showPostEntry();
      if (Util.isNullOrNil(z.bAW())) {
        break label66;
      }
      i = 1;
      if ((!bool) || (i != 0)) {
        break label71;
      }
    }
    label66:
    label71:
    for (i = 2;; i = 0)
    {
      AppMethodBeat.o(178191);
      return i;
      i = 0;
      break;
    }
  }
  
  private static void eau()
  {
    AppMethodBeat.i(366820);
    int i = h.baE().ban().getInt(at.a.adcV, eat());
    int j = i & 0xFFFFFFFD;
    if (j != i) {
      h.baE().ban().set(at.a.adcV, Integer.valueOf(j));
    }
    Log.i("Finder.RedDotTransform", "[setLocalRedDot] flag=2 unset=true newLocal=" + j + " local=" + i);
    AppMethodBeat.o(366820);
  }
  
  public final void Nz(int paramInt)
  {
    AppMethodBeat.i(366870);
    btw localbtw = new btw();
    localbtw.ZYN = String.valueOf(com.tencent.mm.model.cn.bDw());
    localbtw.priority = 10021000;
    localbtw.type = 1013;
    boolean bool = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().dZt();
    if (bool)
    {
      localObject = new bxq();
      ((bxq)localObject).show_type = 2;
      ((bxq)localObject).aagq = 2;
      ((bxq)localObject).count = paramInt;
      ((bxq)localObject).path = "NearbyEntrance";
      localbtw.aabA.add(localObject);
    }
    bxq localbxq = new bxq();
    localbxq.show_type = 2;
    int i;
    if (bool)
    {
      i = 2;
      localbxq.aagq = i;
      localbxq.count = paramInt;
      localbxq.path = "NearbyPeopleTab";
      if (!bool) {
        break label248;
      }
    }
    label248:
    for (Object localObject = "NearbyEntrance";; localObject = "")
    {
      localbxq.Nnp = ((String)localObject);
      localbtw.aabA.add(localbxq);
      localObject = new bxq();
      ((bxq)localObject).show_type = 2;
      ((bxq)localObject).aagq = 1;
      localbxq.count = paramInt;
      ((bxq)localObject).Nnp = "NearbyPeopleTab";
      ((bxq)localObject).path = "NearbyPeopleBubble";
      localbtw.aabA.add(localObject);
      this.APO.a(localbtw, "addNearByUnreadRedDot");
      AppMethodBeat.o(366870);
      return;
      i = 1;
      break;
    }
  }
  
  public final void eao()
  {
    AppMethodBeat.i(366834);
    if (eas())
    {
      eap();
      eau();
      Log.i("Finder.RedDotTransform", "[transformPostRedDot] done");
    }
    d locald = d.FAy;
    if (((Number)d.eTC().bmg()).intValue() != 0)
    {
      this.APO.Nv(-1);
      Log.i("Finder.RedDotTransform", "[checkPostRedDot] clear TIMELINE_CAMERA");
    }
    AppMethodBeat.o(366834);
  }
  
  final void eap()
  {
    AppMethodBeat.i(366849);
    Object localObject = d.FAy;
    if (((Number)d.eTC().bmg()).intValue() == 0)
    {
      localObject = new btw();
      ((btw)localObject).ZYN = String.valueOf(com.tencent.mm.model.cn.bDw());
      ((btw)localObject).priority = 100000;
      ((btw)localObject).type = 1002;
      bxq localbxq = new bxq();
      localbxq.show_type = 1;
      localbxq.aagq = 1;
      localbxq.path = "FinderEntrance";
      ((btw)localObject).aabA.add(localbxq);
      localbxq = new bxq();
      localbxq.show_type = 1;
      localbxq.aagq = 1;
      localbxq.path = "TLPersonalCenter";
      localbxq.Nnp = "FinderEntrance";
      ((btw)localObject).aabA.add(localbxq);
      localbxq = new bxq();
      localbxq.show_type = 1;
      localbxq.aagq = 1;
      localbxq.path = "TLCamera";
      localbxq.Nnp = "TLPersonalCenter";
      ((btw)localObject).aabA.add(localbxq);
      i.a(this.APO, (btw)localObject, "checkPostRedDot", null, true, null, null, 0L, 116);
    }
    AppMethodBeat.o(366849);
  }
  
  public final void eaq()
  {
    AppMethodBeat.i(366860);
    if (this.APO.Su("NearbyPeopleFooterprintClear") != null)
    {
      Log.i("Finder.RedDotTransform", "addNearbyFootRedDot: duplicate red dot");
      AppMethodBeat.o(366860);
      return;
    }
    btw localbtw = new btw();
    localbtw.ZYN = String.valueOf(com.tencent.mm.model.cn.bDw());
    localbtw.priority = 300000;
    localbtw.type = 1014;
    bxq localbxq = new bxq();
    localbxq.show_type = 101;
    localbxq.aagq = 2;
    localbxq.path = "NearbyEntrance";
    localbtw.aabA.add(localbxq);
    localbxq = new bxq();
    localbxq.show_type = 101;
    localbxq.aagq = 2;
    localbxq.Nnp = "NearbyEntrance";
    localbxq.path = "NearbyPeopleTab";
    localbtw.aabA.add(localbxq);
    localbxq = new bxq();
    localbxq.show_type = 101;
    localbxq.aagq = 1;
    localbxq.Nnp = "NearbyPeopleTab";
    localbxq.path = "NearbyPeopleFooterprintClear";
    localbtw.aabA.add(localbxq);
    this.APO.a(localbtw, "addNearByFootRedDot");
    AppMethodBeat.o(366860);
  }
  
  public final void ear()
  {
    AppMethodBeat.i(366879);
    btw localbtw = new btw();
    localbtw.ZYN = String.valueOf(com.tencent.mm.model.cn.bDw());
    localbtw.priority = 100000;
    localbtw.type = 1011;
    bxq localbxq = new bxq();
    localbxq.show_type = 6;
    localbxq.aagq = 1;
    localbxq.path = "NearbyEntrance";
    localbtw.aabA.add(localbxq);
    this.APO.a(localbtw, "addNearbyNewRedDot");
    AppMethodBeat.o(366879);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotTransform$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.n
 * JD-Core Version:    0.7.0.1
 */