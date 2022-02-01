package com.tencent.mm.plugin.finder.live.view;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.multitask.a.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;", "", "activity", "Landroid/app/Activity;", "byteArray", "", "(Landroid/app/Activity;[B)V", "manager", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;)V", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getMainHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mainHandler$delegate", "Lkotlin/Lazy;", "multiTaskDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMultiTaskData;", "Lkotlin/collections/HashMap;", "multiTaskHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper;", "addToHistory", "", "checkAddToHistory", "closeNotify", "generateMultiTaskMap", "originData", "release", "updateCurrentMultiTaskInfo", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e.a DOB;
  private static final j<Long> DOF;
  public d DOC;
  public HashMap<Long, bkg> DOD;
  private final j DOE;
  
  static
  {
    AppMethodBeat.i(357832);
    DOB = new e.a((byte)0);
    DOF = k.cm((kotlin.g.a.a)e.b.DOG);
    AppMethodBeat.o(357832);
  }
  
  public e(Activity paramActivity, e parame)
  {
    AppMethodBeat.i(357799);
    this.DOD = new HashMap();
    this.DOE = k.cm((kotlin.g.a.a)new c(this));
    this.DOD = parame.DOD;
    this.DOC = new d((Context)paramActivity, (com.tencent.mm.plugin.multitask.a.a)new b(paramActivity));
    paramActivity = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    paramActivity = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (paramActivity == null) {
      paramActivity = null;
    }
    for (;;)
    {
      d locald = this.DOC;
      parame = paramActivity;
      if (paramActivity == null) {
        parame = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUm();
      }
      locald.J(21, parame);
      AppMethodBeat.o(357799);
      return;
      paramActivity = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramActivity.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (paramActivity == null)
      {
        paramActivity = null;
      }
      else
      {
        paramActivity = (bkg)this.DOD.get(Long.valueOf(((f)paramActivity.business(f.class)).liveInfo.liveId));
        if (paramActivity == null) {
          paramActivity = null;
        } else {
          paramActivity = paramActivity.key;
        }
      }
    }
  }
  
  public e(Activity paramActivity, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(357787);
    this.DOD = new HashMap();
    this.DOE = k.cm((kotlin.g.a.a)new c(this));
    Object localObject = new bkg();
    if (paramArrayOfByte != null) {}
    try
    {
      ((bkg)localObject).parseFrom(paramArrayOfByte);
      a((bkg)localObject);
      paramArrayOfByte = ((bkg)localObject).key;
      this.DOC = new d((Context)paramActivity, (com.tencent.mm.plugin.multitask.a.a)new b(paramActivity));
      localObject = this.DOC;
      if (paramArrayOfByte == null)
      {
        paramActivity = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUm();
        ((d)localObject).J(21, paramActivity);
        AppMethodBeat.o(357787);
        return;
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("FinderLiveMultiTaskManager", "initMultiTaskData", new Object[] { paramArrayOfByte });
        continue;
        paramActivity = paramArrayOfByte;
      }
    }
  }
  
  private final void a(bkg parambkg)
  {
    AppMethodBeat.i(357809);
    if (parambkg.ZTu.isEmpty())
    {
      if (parambkg.liveId != 0L)
      {
        ((Map)this.DOD).put(Long.valueOf(parambkg.liveId), parambkg);
        AppMethodBeat.o(357809);
      }
    }
    else
    {
      parambkg = parambkg.ZTu;
      s.s(parambkg, "originData.allHistoryFinderObjectList");
      Iterator localIterator = ((Iterable)parambkg).iterator();
      while (localIterator.hasNext())
      {
        FinderObject localFinderObject = (FinderObject)localIterator.next();
        parambkg = localFinderObject.liveInfo;
        if (parambkg != null)
        {
          Map localMap = (Map)this.DOD;
          long l = parambkg.liveId;
          bkg localbkg = new bkg();
          localbkg.key = com.tencent.mm.ae.d.hF(parambkg.liveId);
          localbkg.liveId = parambkg.liveId;
          localbkg.nonceId = localFinderObject.objectNonceId;
          localbkg.mIH = localFinderObject.id;
          String str = localFinderObject.username;
          parambkg = str;
          if (str == null) {
            parambkg = "";
          }
          localbkg.mIC = parambkg;
          parambkg = localFinderObject.objectDesc;
          if (parambkg == null) {
            parambkg = "";
          }
          for (;;)
          {
            localbkg.desc = parambkg;
            localbkg.sessionBuffer = localFinderObject.sessionBuffer;
            localbkg.ABJ = localFinderObject;
            localMap.put(Long.valueOf(l), localbkg);
            break;
            str = parambkg.description;
            parambkg = str;
            if (str == null) {
              parambkg = "";
            }
          }
        }
      }
    }
    AppMethodBeat.o(357809);
  }
  
  private static final void b(e parame)
  {
    AppMethodBeat.i(357814);
    s.u(parame, "this$0");
    parame.DOC.eCK();
    AppMethodBeat.o(357814);
  }
  
  public final void evy()
  {
    boolean bool2 = true;
    AppMethodBeat.i(357863);
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 == null) {
        Log.e("FinderLiveMultiTaskManager", "addToHistory: curLiveRoomData is null");
      }
      AppMethodBeat.o(357863);
      return;
      com.tencent.mm.plugin.finder.live.viewmodel.data.business.e locale = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (locale == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = (bkg)this.DOD.get(Long.valueOf(((f)locale.business(f.class)).liveInfo.liveId));
        int i;
        label141:
        boolean bool1;
        if (localObject1 == null)
        {
          localObject1 = new bkg();
          Object localObject2 = (CharSequence)((bkg)localObject1).key;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label285;
          }
          i = 1;
          if (i != 0) {
            break label290;
          }
          bool1 = true;
          label147:
          localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
          localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
          if (localObject2 == null) {
            break label295;
          }
          localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if ((localObject2 == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).eyA() != true)) {
            break label295;
          }
        }
        for (;;)
        {
          Log.i("FinderLiveMultiTaskManager", "addToHistory: has added = " + bool1 + ", is live finished = " + bool2 + ", liveId = " + ((f)locale.business(f.class)).liveInfo.liveId + ", objectId = " + ((f)locale.business(f.class)).hKN);
          if ((!bool1) && (!bool2)) {
            break label300;
          }
          AppMethodBeat.o(357863);
          return;
          break;
          label285:
          i = 0;
          break label141;
          label290:
          bool1 = false;
          break label147;
          label295:
          bool2 = false;
        }
        label300:
        ((bkg)localObject1).liveId = ((f)locale.business(f.class)).liveInfo.liveId;
        ((bkg)localObject1).nonceId = ((f)locale.business(f.class)).nonceId;
        ((bkg)localObject1).mIH = ((f)locale.business(f.class)).hKN;
        ((bkg)localObject1).mIC = locale.mIC;
        ((bkg)localObject1).desc = locale.desc;
        ((bkg)localObject1).sessionBuffer = ((f)locale.business(f.class)).sessionBuffer;
        ((bkg)localObject1).ABJ = locale.Eco;
        ((Map)this.DOD).put(Long.valueOf(((f)locale.business(f.class)).liveInfo.liveId), localObject1);
        evz();
        localObject1 = com.tencent.threadpool.h.ahAA.bn(new e..ExternalSyntheticLambda0(this));
      }
    }
  }
  
  public final void evz()
  {
    Object localObject3 = null;
    AppMethodBeat.i(357877);
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    MultiTaskInfo localMultiTaskInfo;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject1 != null)
      {
        bkg localbkg = (bkg)this.DOD.get(Long.valueOf(((f)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).business(f.class)).liveInfo.liveId));
        if (localbkg == null)
        {
          AppMethodBeat.o(357877);
          return;
        }
        localMultiTaskInfo = this.DOC.LCE;
        if (localMultiTaskInfo != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).Eco;
          if (localObject2 != null) {
            break label244;
          }
          localObject2 = null;
          localMultiTaskInfo.field_id = com.tencent.mm.ae.d.hF(((f)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).business(f.class)).liveInfo.liveId);
          localbkg.key = localMultiTaskInfo.field_id;
          drz localdrz = localMultiTaskInfo.gkh();
          if (localObject2 != null) {
            break label252;
          }
          localObject1 = "";
          label150:
          localdrz.aaXP = ((String)localObject1);
          localMultiTaskInfo.field_data = localbkg.toByteArray();
          if (localObject2 != null)
          {
            localMultiTaskInfo.gkh().nickname = ((FinderContact)localObject2).nickname;
            localObject2 = ((FinderContact)localObject2).authInfo;
            if (localObject2 != null) {
              if (((FinderAuthInfo)localObject2).authIconType <= 0) {
                break label273;
              }
            }
          }
        }
      }
    }
    label273:
    for (int i = 1;; i = 0)
    {
      localObject1 = localObject3;
      if (i != 0) {
        localObject1 = localObject2;
      }
      if (localObject1 != null)
      {
        localMultiTaskInfo.gkh().aaXQ = ((FinderAuthInfo)localObject1).authIconType;
        localMultiTaskInfo.gkh().aaXO = ((FinderAuthInfo)localObject1).authIconUrl;
      }
      AppMethodBeat.o(357877);
      return;
      label244:
      localObject2 = ((FinderObject)localObject2).contact;
      break;
      label252:
      String str = ((FinderContact)localObject2).headUrl;
      localObject1 = str;
      if (str != null) {
        break label150;
      }
      localObject1 = "";
      break label150;
    }
  }
  
  public final MMHandler getMainHandler()
  {
    AppMethodBeat.i(357848);
    MMHandler localMMHandler = (MMHandler)this.DOE.getValue();
    AppMethodBeat.o(357848);
    return localMMHandler;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<MMHandler>
  {
    c(e parame)
    {
      super();
    }
    
    private static final boolean a(e parame, Message paramMessage)
    {
      AppMethodBeat.i(357792);
      s.u(parame, "this$0");
      s.u(paramMessage, "it");
      if (paramMessage.what == 3) {
        parame.evy();
      }
      AppMethodBeat.o(357792);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.e
 * JD-Core Version:    0.7.0.1
 */