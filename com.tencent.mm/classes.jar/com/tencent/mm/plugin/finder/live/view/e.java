package com.tencent.mm.plugin.finder.live.view;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;", "", "activity", "Landroid/app/Activity;", "byteArray", "", "(Landroid/app/Activity;[B)V", "manager", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager;)V", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getMainHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mainHandler$delegate", "Lkotlin/Lazy;", "multiTaskDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMultiTaskData;", "Lkotlin/collections/HashMap;", "multiTaskHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskHelper;", "addToHistory", "", "checkAddToHistory", "closeNotify", "generateMultiTaskMap", "originData", "release", "updateCurrentMultiTaskInfo", "Companion", "plugin-finder_release"})
public final class e
{
  private static final f yVs;
  public static final a yVt;
  public d yVp;
  public HashMap<Long, bbf> yVq;
  private final f yVr;
  
  static
  {
    AppMethodBeat.i(290062);
    yVt = new a((byte)0);
    yVs = g.ar((kotlin.g.a.a)b.yVu);
    AppMethodBeat.o(290062);
  }
  
  public e(Activity paramActivity, e parame)
  {
    AppMethodBeat.i(290061);
    this.yVq = new HashMap();
    this.yVr = g.ar((kotlin.g.a.a)new d(this));
    this.yVq = parame.yVq;
    this.yVp = new d((Context)paramActivity, (com.tencent.mm.plugin.multitask.a.a)new com.tencent.mm.plugin.multitask.a.b(paramActivity));
    paramActivity = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    paramActivity = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (paramActivity != null)
    {
      paramActivity = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramActivity.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (paramActivity != null)
      {
        paramActivity = (bbf)this.yVq.get(Long.valueOf(((c)paramActivity.business(c.class)).liveInfo.liveId));
        if (paramActivity != null) {
          paramActivity = paramActivity.key;
        }
      }
    }
    for (;;)
    {
      d locald = this.yVp;
      parame = paramActivity;
      if (paramActivity == null)
      {
        paramActivity = n.zWF;
        parame = n.dPD();
      }
      locald.I(21, parame);
      AppMethodBeat.o(290061);
      return;
      paramActivity = null;
      continue;
      paramActivity = null;
    }
  }
  
  public e(Activity paramActivity, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(290060);
    this.yVq = new HashMap();
    this.yVr = g.ar((kotlin.g.a.a)new d(this));
    Object localObject = new bbf();
    if (paramArrayOfByte != null) {}
    try
    {
      ((bbf)localObject).parseFrom(paramArrayOfByte);
      a((bbf)localObject);
      paramArrayOfByte = ((bbf)localObject).key;
      this.yVp = new d((Context)paramActivity, (com.tencent.mm.plugin.multitask.a.a)new com.tencent.mm.plugin.multitask.a.b(paramActivity));
      localObject = this.yVp;
      if (paramArrayOfByte == null)
      {
        paramActivity = n.zWF;
        paramActivity = n.dPD();
        ((d)localObject).I(21, paramActivity);
        AppMethodBeat.o(290060);
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
  
  private final void a(bbf parambbf)
  {
    AppMethodBeat.i(290058);
    if (parambbf.SMS.isEmpty())
    {
      if (parambbf.liveId != 0L)
      {
        ((Map)this.yVq).put(Long.valueOf(parambbf.liveId), parambbf);
        AppMethodBeat.o(290058);
      }
    }
    else
    {
      parambbf = parambbf.SMS;
      p.j(parambbf, "originData.allHistoryFinderObjectList");
      Iterator localIterator = ((Iterable)parambbf).iterator();
      while (localIterator.hasNext())
      {
        FinderObject localFinderObject = (FinderObject)localIterator.next();
        parambbf = localFinderObject.liveInfo;
        if (parambbf != null)
        {
          Map localMap = (Map)this.yVq;
          long l = parambbf.liveId;
          bbf localbbf = new bbf();
          localbbf.key = com.tencent.mm.ae.d.Fw(parambbf.liveId);
          localbbf.liveId = parambbf.liveId;
          localbbf.nonceId = localFinderObject.objectNonceId;
          localbbf.kik = localFinderObject.id;
          String str = localFinderObject.username;
          parambbf = str;
          if (str == null) {
            parambbf = "";
          }
          localbbf.kig = parambbf;
          parambbf = localFinderObject.objectDesc;
          if (parambbf != null)
          {
            str = parambbf.description;
            parambbf = str;
            if (str != null) {}
          }
          else
          {
            parambbf = "";
          }
          localbbf.desc = parambbf;
          localbbf.sessionBuffer = localFinderObject.sessionBuffer;
          localbbf.xcx = localFinderObject;
          localMap.put(Long.valueOf(l), localbbf);
        }
      }
    }
    AppMethodBeat.o(290058);
  }
  
  public final void dFj()
  {
    Object localObject3 = null;
    AppMethodBeat.i(290059);
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject1 != null)
    {
      Object localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject2 != null)
      {
        bbf localbbf = (bbf)this.yVq.get(Long.valueOf(((c)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject2).business(c.class)).liveInfo.liveId));
        if (localbbf == null)
        {
          AppMethodBeat.o(290059);
          return;
        }
        p.j(localbbf, "multiTaskDataMap[it.busi…iveInfo.liveId] ?: return");
        MultiTaskInfo localMultiTaskInfo = this.yVp.FHd;
        if (localMultiTaskInfo != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject2).zeZ;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObject)localObject1).contact;
            localMultiTaskInfo.field_id = com.tencent.mm.ae.d.Fw(((c)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject2).business(c.class)).liveInfo.liveId);
            localbbf.key = localMultiTaskInfo.field_id;
            dar localdar = localMultiTaskInfo.fbc();
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
            localdar.TIg = ((String)localObject2);
            localMultiTaskInfo.field_data = localbbf.toByteArray();
            if (localObject1 == null) {
              break label286;
            }
            localMultiTaskInfo.fbc().nickname = ((FinderContact)localObject1).nickname;
            localObject2 = ((FinderContact)localObject1).authInfo;
            if (localObject2 == null) {
              break label279;
            }
            if (((FinderAuthInfo)localObject2).authIconType <= 0) {
              break label274;
            }
          }
          label274:
          for (int i = 1;; i = 0)
          {
            localObject1 = localObject3;
            if (i != 0) {
              localObject1 = localObject2;
            }
            if (localObject1 == null) {
              break label279;
            }
            localMultiTaskInfo.fbc().TIh = ((FinderAuthInfo)localObject1).authIconType;
            localMultiTaskInfo.fbc().TIf = ((FinderAuthInfo)localObject1).authIconUrl;
            AppMethodBeat.o(290059);
            return;
            localObject1 = null;
            break;
          }
          label279:
          AppMethodBeat.o(290059);
          return;
          label286:
          AppMethodBeat.o(290059);
          return;
        }
        AppMethodBeat.o(290059);
        return;
      }
    }
    AppMethodBeat.o(290059);
  }
  
  public final MMHandler getMainHandler()
  {
    AppMethodBeat.i(290057);
    MMHandler localMMHandler = (MMHandler)this.yVr.getValue();
    AppMethodBeat.o(290057);
    return localMMHandler;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager$Companion;", "", "()V", "ADD_TO_HISTORY_DELAY", "", "getADD_TO_HISTORY_DELAY", "()J", "ADD_TO_HISTORY_DELAY$delegate", "Lkotlin/Lazy;", "MSG_ADD_TO_HISTORY", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Long>
  {
    public static final b yVu;
    
    static
    {
      AppMethodBeat.i(276909);
      yVu = new b();
      AppMethodBeat.o(276909);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/live/view/FinderLiveMultiTaskManager$addToHistory$1$1"})
  static final class c
    implements Runnable
  {
    c(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(290483);
      e.b(this.yVv).dJO();
      AppMethodBeat.o(290483);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<MMHandler>
  {
    d(e parame)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class a
      implements MMHandler.Callback
    {
      a(e.d paramd) {}
      
      public final boolean handleMessage(Message paramMessage)
      {
        boolean bool3 = false;
        AppMethodBeat.i(267881);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(267881);
          return true;
        }
        e locale = this.yVw.yVv;
        paramMessage = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
        paramMessage = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
        com.tencent.mm.plugin.finder.live.viewmodel.data.business.b localb;
        if (paramMessage != null)
        {
          localb = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramMessage.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if (localb != null)
          {
            paramMessage = (bbf)locale.yVq.get(Long.valueOf(((c)localb.business(c.class)).liveInfo.liveId));
            if (paramMessage != null) {
              break label482;
            }
            paramMessage = new bbf();
          }
        }
        label151:
        label477:
        label482:
        for (;;)
        {
          p.j(paramMessage, "multiTaskDataMap[it.busi…FinderLiveMultiTaskData()");
          Object localObject = (CharSequence)paramMessage.key;
          int i;
          if ((localObject == null) || (((CharSequence)localObject).length() == 0))
          {
            i = 1;
            if (i != 0) {
              break label477;
            }
          }
          for (boolean bool1 = true;; bool1 = false)
          {
            localObject = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
            localObject = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
            boolean bool2 = bool3;
            if (localObject != null)
            {
              localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
              bool2 = bool3;
              if (localObject != null)
              {
                bool2 = bool3;
                if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).dGN() == true) {
                  bool2 = true;
                }
              }
            }
            Log.i("FinderLiveMultiTaskManager", "addToHistory: has added = " + bool1 + ", is live finished = " + bool2 + ", liveId = " + ((c)localb.business(c.class)).liveInfo.liveId + ", objectId = " + ((c)localb.business(c.class)).xbk);
            if ((bool1) || (bool2)) {
              break;
            }
            paramMessage.liveId = ((c)localb.business(c.class)).liveInfo.liveId;
            paramMessage.nonceId = ((c)localb.business(c.class)).nonceId;
            paramMessage.kik = ((c)localb.business(c.class)).xbk;
            paramMessage.kig = localb.kig;
            paramMessage.desc = localb.desc;
            paramMessage.sessionBuffer = ((c)localb.business(c.class)).sessionBuffer;
            paramMessage.xcx = localb.zeZ;
            ((Map)locale.yVq).put(Long.valueOf(((c)localb.business(c.class)).liveInfo.liveId), paramMessage);
            locale.dFj();
            if (h.ZvG.bf((Runnable)new e.c(locale)) != null) {
              break;
            }
            Log.e("FinderLiveMultiTaskManager", "addToHistory: curLiveRoomData is null");
            paramMessage = x.aazN;
            break;
            i = 0;
            break label151;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.e
 * JD-Core Version:    0.7.0.1
 */