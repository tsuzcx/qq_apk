package com.tencent.mm.plugin.finder.live.view;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.multitask.a.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;", "", "activity", "Landroid/app/Activity;", "byteArray", "", "(Landroid/app/Activity;[B)V", "manager", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;)V", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getMainHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mainHandler$delegate", "Lkotlin/Lazy;", "multiTaskDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMultiTaskData;", "Lkotlin/collections/HashMap;", "multiTaskHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper;", "addToHistory", "", "checkAddToHistory", "closeNotify", "generateMultiTaskMap", "originData", "release", "updateCurrentMultiTaskInfo", "Companion", "plugin-finder_release"})
public final class i
{
  private static final f uzM;
  public static final a uzN;
  private final f ufG;
  public h uzK;
  public HashMap<Long, aws> uzL;
  
  static
  {
    AppMethodBeat.i(247550);
    uzN = new a((byte)0);
    uzM = kotlin.g.ah((kotlin.g.a.a)b.uzO);
    AppMethodBeat.o(247550);
  }
  
  public i(Activity paramActivity, i parami)
  {
    AppMethodBeat.i(247549);
    this.uzL = new HashMap();
    this.ufG = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.uzL = parami.uzL;
    this.uzK = new h((Context)paramActivity, (com.tencent.mm.plugin.multitask.a.a)new b(paramActivity));
    paramActivity = o.ujN;
    paramActivity = o.dfZ();
    if (paramActivity != null)
    {
      paramActivity = (aws)this.uzL.get(Long.valueOf(paramActivity.liveInfo.liveId));
      if (paramActivity != null) {
        paramActivity = paramActivity.key;
      }
    }
    for (;;)
    {
      h localh = this.uzK;
      parami = paramActivity;
      if (paramActivity == null)
      {
        paramActivity = k.vfA;
        parami = k.doc();
      }
      localh.G(21, parami);
      AppMethodBeat.o(247549);
      return;
      paramActivity = null;
      continue;
      paramActivity = null;
    }
  }
  
  public i(Activity paramActivity, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(247548);
    this.uzL = new HashMap();
    this.ufG = kotlin.g.ah((kotlin.g.a.a)new d(this));
    Object localObject = new aws();
    if (paramArrayOfByte != null) {}
    try
    {
      ((aws)localObject).parseFrom(paramArrayOfByte);
      a((aws)localObject);
      paramArrayOfByte = ((aws)localObject).key;
      this.uzK = new h((Context)paramActivity, (com.tencent.mm.plugin.multitask.a.a)new b(paramActivity));
      localObject = this.uzK;
      if (paramArrayOfByte == null)
      {
        paramActivity = k.vfA;
        paramActivity = k.doc();
        ((h)localObject).G(21, paramActivity);
        AppMethodBeat.o(247548);
        return;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        Log.e("FinderLiveMultiTaskManager", "initMultiTaskData", new Object[] { paramArrayOfByte });
        continue;
        paramActivity = paramArrayOfByte;
      }
    }
  }
  
  private final void a(aws paramaws)
  {
    AppMethodBeat.i(247546);
    if (paramaws.LHu.isEmpty())
    {
      if (paramaws.liveId != 0L)
      {
        ((Map)this.uzL).put(Long.valueOf(paramaws.liveId), paramaws);
        AppMethodBeat.o(247546);
      }
    }
    else
    {
      paramaws = paramaws.LHu;
      p.g(paramaws, "originData.allHistoryFinderObjectList");
      Iterator localIterator = ((Iterable)paramaws).iterator();
      while (localIterator.hasNext())
      {
        FinderObject localFinderObject = (FinderObject)localIterator.next();
        paramaws = localFinderObject.liveInfo;
        if (paramaws != null)
        {
          Map localMap = (Map)this.uzL;
          long l = paramaws.liveId;
          aws localaws = new aws();
          localaws.key = d.zs(paramaws.liveId);
          localaws.liveId = paramaws.liveId;
          localaws.hwg = localFinderObject.objectNonceId;
          localaws.hwe = localFinderObject.id;
          String str = localFinderObject.username;
          paramaws = str;
          if (str == null) {
            paramaws = "";
          }
          localaws.hwd = paramaws;
          paramaws = localFinderObject.objectDesc;
          if (paramaws != null)
          {
            str = paramaws.description;
            paramaws = str;
            if (str != null) {}
          }
          else
          {
            paramaws = "";
          }
          localaws.desc = paramaws;
          localaws.sessionBuffer = localFinderObject.sessionBuffer;
          localaws.tuO = localFinderObject;
          localMap.put(Long.valueOf(l), localaws);
        }
      }
    }
    AppMethodBeat.o(247546);
  }
  
  public final void diB()
  {
    Object localObject3 = null;
    AppMethodBeat.i(247547);
    Object localObject1 = o.ujN;
    Object localObject2 = o.dfZ();
    if (localObject2 != null)
    {
      aws localaws = (aws)this.uzL.get(Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject2).liveInfo.liveId));
      if (localaws == null)
      {
        AppMethodBeat.o(247547);
        return;
      }
      p.g(localaws, "multiTaskDataMap[it.liveInfo.liveId] ?: return");
      MultiTaskInfo localMultiTaskInfo = this.uzK.Abp;
      if (localMultiTaskInfo != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject2).uDz;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObject)localObject1).contact;
          localMultiTaskInfo.field_id = d.zs(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject2).liveInfo.liveId);
          localaws.key = localMultiTaskInfo.field_id;
          cru localcru = localMultiTaskInfo.erh();
          if (localObject1 != null)
          {
            String str = ((FinderContact)localObject1).headUrl;
            localObject2 = str;
            if (str != null) {}
          }
          else
          {
            localObject2 = "";
          }
          localcru.MwR = ((String)localObject2);
          localMultiTaskInfo.field_data = localaws.toByteArray();
          if (localObject1 == null) {
            break label256;
          }
          localMultiTaskInfo.erh().nickname = ((FinderContact)localObject1).nickname;
          localObject2 = ((FinderContact)localObject1).authInfo;
          if (localObject2 == null) {
            break label249;
          }
          if (((FinderAuthInfo)localObject2).authIconType <= 0) {
            break label244;
          }
        }
        label244:
        for (int i = 1;; i = 0)
        {
          localObject1 = localObject3;
          if (i != 0) {
            localObject1 = localObject2;
          }
          if (localObject1 == null) {
            break label249;
          }
          localMultiTaskInfo.erh().MwS = ((FinderAuthInfo)localObject1).authIconType;
          localMultiTaskInfo.erh().MwQ = ((FinderAuthInfo)localObject1).authIconUrl;
          AppMethodBeat.o(247547);
          return;
          localObject1 = null;
          break;
        }
        label249:
        AppMethodBeat.o(247547);
        return;
        label256:
        AppMethodBeat.o(247547);
        return;
      }
      AppMethodBeat.o(247547);
      return;
    }
    AppMethodBeat.o(247547);
  }
  
  public final MMHandler getMainHandler()
  {
    AppMethodBeat.i(247545);
    MMHandler localMMHandler = (MMHandler)this.ufG.getValue();
    AppMethodBeat.o(247545);
    return localMMHandler;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager$Companion;", "", "()V", "ADD_TO_HISTORY_DELAY", "", "getADD_TO_HISTORY_DELAY", "()J", "ADD_TO_HISTORY_DELAY$delegate", "Lkotlin/Lazy;", "MSG_ADD_TO_HISTORY", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Long>
  {
    public static final b uzO;
    
    static
    {
      AppMethodBeat.i(247541);
      uzO = new b();
      AppMethodBeat.o(247541);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager$addToHistory$1$1"})
  static final class c
    implements Runnable
  {
    c(i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(247542);
      i.b(this.uzP).dkj();
      AppMethodBeat.o(247542);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<MMHandler>
  {
    d(i parami)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class a
      implements MMHandler.Callback
    {
      a(i.d paramd) {}
      
      public final boolean handleMessage(Message paramMessage)
      {
        boolean bool3 = false;
        AppMethodBeat.i(247543);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(247543);
          return true;
        }
        i locali = this.uzQ.uzP;
        paramMessage = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g localg = o.dfZ();
        if (localg != null)
        {
          paramMessage = (aws)locali.uzL.get(Long.valueOf(localg.liveInfo.liveId));
          if (paramMessage != null) {
            break label383;
          }
          paramMessage = new aws();
        }
        label129:
        label378:
        label383:
        for (;;)
        {
          p.g(paramMessage, "multiTaskDataMap[it.live…FinderLiveMultiTaskData()");
          Object localObject = (CharSequence)paramMessage.key;
          int i;
          if ((localObject == null) || (((CharSequence)localObject).length() == 0))
          {
            i = 1;
            if (i != 0) {
              break label378;
            }
          }
          for (boolean bool1 = true;; bool1 = false)
          {
            localObject = o.ujN;
            localObject = o.dfZ();
            boolean bool2 = bool3;
            if (localObject != null)
            {
              bool2 = bool3;
              if (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).djl() == true) {
                bool2 = true;
              }
            }
            Log.i("FinderLiveMultiTaskManager", "addToHistory: has added = " + bool1 + ", is live finished = " + bool2 + ", liveId = " + localg.liveInfo.liveId + ", objectId = " + localg.hFK);
            if ((bool1) || (bool2)) {
              break;
            }
            paramMessage.liveId = localg.liveInfo.liveId;
            paramMessage.hwg = localg.hwg;
            paramMessage.hwe = localg.hFK;
            paramMessage.hwd = localg.hwd;
            paramMessage.desc = localg.desc;
            paramMessage.sessionBuffer = localg.sessionBuffer;
            paramMessage.tuO = localg.uDz;
            ((Map)locali.uzL).put(Long.valueOf(localg.liveInfo.liveId), paramMessage);
            locali.diB();
            if (com.tencent.f.h.RTc.aY((Runnable)new i.c(locali)) != null) {
              break;
            }
            Log.e("FinderLiveMultiTaskManager", "addToHistory: curLiveRoomData is null");
            paramMessage = x.SXb;
            break;
            i = 0;
            break label129;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.i
 * JD-Core Version:    0.7.0.1
 */