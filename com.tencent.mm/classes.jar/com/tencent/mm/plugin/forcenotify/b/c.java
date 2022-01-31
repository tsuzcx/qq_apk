package com.tencent.mm.plugin.forcenotify.b;

import a.l;
import a.v;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.cl;
import com.tencent.mm.protocal.protobuf.wy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.ArrayList;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogResult;", "()V", "ForceNotifyMiniAppTag", "", "ForceNotifyTag", "isSound", "", "()Z", "setSound", "(Z)V", "isTestError", "isVibrate", "setVibrate", "delete", "", "forcePushId", "scene", "", "getCount", "getExpireTime", "", "username", "getForceNotifyInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getForceNotifyStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "hasError", "isNeedNotify", "userName", "isNeedShowBanner", "isSilentMode", "context", "Landroid/content/Context;", "isVibrateMode", "modifyForceNotify", "info", "isAdd", "notifyShow", "onOpLogResult", "ret", "title", "content", "option", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "onReceive", "isNeedShow", "release", "setCanSoundAndVibrate", "setForTest", "isTest", "setting", "start", "startForceNotifyShowUI", "intent", "Landroid/content/Intent;", "plugin-force-notify_release"})
public final class c
  extends a
  implements g.a
{
  private static boolean mHr;
  private static boolean mHs;
  private static boolean mHt;
  public static final c mHu;
  
  static
  {
    AppMethodBeat.i(51050);
    mHu = new c();
    mHs = true;
    mHt = true;
    AppMethodBeat.o(51050);
  }
  
  public static ArrayList<d> bzJ()
  {
    AppMethodBeat.i(51040);
    Object localObject = com.tencent.mm.plugin.forcenotify.d.a.mHw;
    localObject = com.tencent.mm.plugin.forcenotify.d.a.bzL();
    AppMethodBeat.o(51040);
    return localObject;
  }
  
  public static boolean dX(Context paramContext)
  {
    AppMethodBeat.i(51037);
    a.f.b.j.q(paramContext, "context");
    paramContext = paramContext.getSystemService("audio");
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(51037);
      throw paramContext;
    }
    if (((AudioManager)paramContext).getRingerMode() > 0)
    {
      AppMethodBeat.o(51037);
      return true;
    }
    AppMethodBeat.o(51037);
    return false;
  }
  
  public static boolean isSilentMode(Context paramContext)
  {
    AppMethodBeat.i(51036);
    a.f.b.j.q(paramContext, "context");
    paramContext = paramContext.getSystemService("audio");
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(51036);
      throw paramContext;
    }
    if (((AudioManager)paramContext).getRingerMode() != 2)
    {
      AppMethodBeat.o(51036);
      return true;
    }
    AppMethodBeat.o(51036);
    return false;
  }
  
  public final void Ol(String paramString)
  {
    AppMethodBeat.i(51042);
    if (paramString == null)
    {
      AppMethodBeat.o(51042);
      return;
    }
    if (!at.isNetworkConnected(ah.getContext()))
    {
      com.tencent.mm.plugin.forcenotify.d.a.mHw.doNotify();
      AppMethodBeat.o(51042);
      return;
    }
    Object localObject2 = new cl();
    ((cl)localObject2).woM = (paramString + "@wxcontact");
    ((cl)localObject2).woN = 10800;
    Object localObject1 = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject1).bPK().a((j.b)new j.a(213, (com.tencent.mm.bv.a)localObject2));
    localObject1 = com.tencent.mm.plugin.forcenotify.d.a.mHw;
    Object localObject3 = ((cl)localObject2).woM;
    a.f.b.j.p(localObject3, "opLog.ForcePushId");
    a.f.b.j.q(paramString, "userName");
    a.f.b.j.q(localObject3, "forcePushId");
    localObject2 = new d();
    ((d)localObject2).field_UserName = paramString;
    ((d)localObject2).field_ForcePushId = ((String)localObject3);
    ((d)localObject2).field_CreateTime = cb.abq();
    ((d)localObject2).field_ExpiredTime = (((d)localObject2).field_CreateTime + 10800000L);
    ((d)localObject2).field_Status = 1;
    if (com.tencent.mm.plugin.forcenotify.d.a.fnw.replace("ForceNotifyData", "UserName", ((d)localObject2).convertTo()) >= 0L)
    {
      localObject3 = (Map)com.tencent.mm.plugin.forcenotify.d.a.mHv;
      String str = ((d)localObject2).field_ForcePushId;
      a.f.b.j.p(str, "info.field_ForcePushId");
      ((Map)localObject3).put(str, localObject2);
      ((com.tencent.mm.plugin.forcenotify.d.a)localObject1).doNotify();
    }
    for (boolean bool = true;; bool = false)
    {
      ab.i(this.TAG, "[setting] " + paramString + " ret:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(51042);
      return;
    }
  }
  
  public final long Om(String paramString)
  {
    AppMethodBeat.i(51041);
    a.f.b.j.q(paramString, "username");
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.mHw;
    paramString = paramString + "@wxcontact";
    a.f.b.j.q(paramString, "forcePushId");
    d locald = new d();
    locald.field_ForcePushId = paramString;
    if (locala.get((com.tencent.mm.sdk.e.c)locald, new String[0]))
    {
      long l = locald.field_ExpiredTime;
      AppMethodBeat.o(51041);
      return l;
    }
    AppMethodBeat.o(51041);
    return 0L;
  }
  
  public final boolean On(String paramString)
  {
    AppMethodBeat.i(51049);
    a.f.b.j.q(paramString, "userName");
    if (!paramString.equals("gh_0583b1a055d7@app"))
    {
      com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.mHw;
      if (!com.tencent.mm.plugin.forcenotify.d.a.On(paramString + "@wxcontact")) {}
    }
    else
    {
      AppMethodBeat.o(51049);
      return true;
    }
    AppMethodBeat.o(51049);
    return false;
  }
  
  public final void a(int paramInt, j.b paramb)
  {
    AppMethodBeat.i(51044);
    a.f.b.j.q(paramb, "option");
    ab.i(this.TAG, "[onOpLogResult] ret:%s %s", new Object[] { Integer.valueOf(paramInt), paramb });
    com.tencent.mm.plugin.forcenotify.d.a locala;
    String str;
    if (paramb.getCmdId() == 213)
    {
      paramb = paramb.bQh();
      if (paramb == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddForcePush");
        AppMethodBeat.o(51044);
        throw paramb;
      }
      paramb = (cl)paramb;
      ab.i(this.TAG, "[onOpLogResult] AddForcePush ForcePushId:%s", new Object[] { paramb.woM });
      if ((paramInt == 0) && (!mHr))
      {
        locala = com.tencent.mm.plugin.forcenotify.d.a.mHw;
        str = paramb.woM;
        a.f.b.j.p(str, "oplog.ForcePushId");
        locala.bX(str, 1);
        ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.a.class)).h(paramb.woM, 1, cb.abq() / 1000L);
        AppMethodBeat.o(51044);
        return;
      }
      locala = com.tencent.mm.plugin.forcenotify.d.a.mHw;
      str = paramb.woM;
      a.f.b.j.p(str, "oplog.ForcePushId");
      locala.bX(str, -1);
      ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.a.class)).h(paramb.woM, 6, cb.abq() / 1000L);
      AppMethodBeat.o(51044);
      return;
    }
    if (paramb.getCmdId() == 214)
    {
      paramb = paramb.bQh();
      if (paramb == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.DelForcePush");
        AppMethodBeat.o(51044);
        throw paramb;
      }
      paramb = (wy)paramb;
      int i = paramb.scene;
      if (paramInt != 0) {
        break label382;
      }
      ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.a.class)).h(paramb.woM, i, cb.abq() / 1000L);
      locala = com.tencent.mm.plugin.forcenotify.d.a.mHw;
      str = paramb.woM;
      a.f.b.j.p(str, "oplog.ForcePushId");
    }
    label382:
    for (boolean bool = locala.qD(str);; bool = false)
    {
      ab.i(this.TAG, "[onOpLogResult] DelForcePush id:%s ret:%s isDeleteLocal:%s", new Object[] { paramb.woM, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      AppMethodBeat.o(51044);
      return;
    }
  }
  
  public final void a(d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(140594);
    a.f.b.j.q(paramd, "info");
    com.tencent.mm.plugin.forcenotify.d.a locala;
    Object localObject;
    boolean bool;
    if (paramBoolean)
    {
      locala = com.tencent.mm.plugin.forcenotify.d.a.mHw;
      a.f.b.j.q(paramd, "info");
      if (com.tencent.mm.plugin.forcenotify.d.a.fnw.replace("ForceNotifyData", "UserName", paramd.convertTo()) >= 0L)
      {
        localObject = (Map)com.tencent.mm.plugin.forcenotify.d.a.mHv;
        String str = paramd.field_ForcePushId;
        a.f.b.j.p(str, "info.field_ForcePushId");
        ((Map)localObject).put(str, paramd);
        locala.doNotify();
        bool = true;
      }
    }
    for (;;)
    {
      ab.i(this.TAG, "[onNewXmlReceived] ret:%s isAdd:%s info:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramd });
      AppMethodBeat.o(140594);
      return;
      bool = false;
      continue;
      locala = com.tencent.mm.plugin.forcenotify.d.a.mHw;
      localObject = paramd.field_ForcePushId;
      a.f.b.j.p(localObject, "info.field_ForcePushId");
      bool = locala.qD((String)localObject);
    }
  }
  
  public final void aP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(51045);
    a.f.b.j.q(paramString, "userName");
    if (paramBoolean)
    {
      Intent localIntent = new Intent(ah.getContext(), ForceNotifyShowUI.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("userName", paramString);
      ah.getContext().startActivity(localIntent);
    }
    AppMethodBeat.o(51045);
  }
  
  public final void an(String paramString, int paramInt)
  {
    AppMethodBeat.i(51043);
    if (paramString == null)
    {
      AppMethodBeat.o(51043);
      return;
    }
    if (!at.isNetworkConnected(ah.getContext()))
    {
      com.tencent.mm.plugin.forcenotify.d.a.mHw.doNotify();
      AppMethodBeat.o(51043);
      return;
    }
    wy localwy = new wy();
    localwy.woM = paramString;
    localwy.scene = paramInt;
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.j)locala).bPK().a((j.b)new j.a(214, (com.tencent.mm.bv.a)localwy));
    ab.i(this.TAG, "[delete] ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(51043);
  }
  
  public final boolean bzH()
  {
    AppMethodBeat.i(51047);
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.mHw;
    if (com.tencent.mm.plugin.forcenotify.d.a.bzN() > 0)
    {
      AppMethodBeat.o(51047);
      return true;
    }
    AppMethodBeat.o(51047);
    return false;
  }
  
  public final com.tencent.mm.sdk.e.j<?> bzI()
  {
    return (com.tencent.mm.sdk.e.j)com.tencent.mm.plugin.forcenotify.d.a.mHw;
  }
  
  public final void dW(Context paramContext)
  {
    AppMethodBeat.i(51046);
    a.f.b.j.q(paramContext, "context");
    ab.i(this.TAG, "[startForceNotifyShowUI]");
    paramContext.startActivity(new Intent(paramContext, ForceNotifyListUI.class));
    AppMethodBeat.o(51046);
  }
  
  public final void hO(boolean paramBoolean)
  {
    mHr = paramBoolean;
  }
  
  public final boolean hasError()
  {
    AppMethodBeat.i(51048);
    com.tencent.mm.plugin.forcenotify.d.a locala = com.tencent.mm.plugin.forcenotify.d.a.mHw;
    if (com.tencent.mm.plugin.forcenotify.d.a.bzP() > 0)
    {
      AppMethodBeat.o(51048);
      return true;
    }
    AppMethodBeat.o(51048);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(51039);
    super.release();
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.j)locala).bPK().b(213, (g.a)this);
    locala = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.j)locala).bPK().b(214, (g.a)this);
    AppMethodBeat.o(51039);
  }
  
  public final void start()
  {
    AppMethodBeat.i(51038);
    super.start();
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.j)locala).bPK().a(213, (g.a)this);
    locala = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(locala, "MMKernel.service<IMessen…engerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.j)locala).bPK().a(214, (g.a)this);
    AppMethodBeat.o(51038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.c
 * JD-Core Version:    0.7.0.1
 */