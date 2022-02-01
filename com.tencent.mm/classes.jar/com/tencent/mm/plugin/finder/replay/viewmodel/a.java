package com.tencent.mm.plugin.finder.replay.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.t;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/viewmodel/LiveMsgOffsetSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveBuContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "callback", "Lcom/tencent/mm/plugin/finder/replay/model/LiveMsgOffsetCallback;", "messageRequesting", "", "getMessageRequesting", "()Z", "setMessageRequesting", "(Z)V", "messageRequestingUniqCode", "", "msgArray", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/protocal/protobuf/FrameItem;", "value", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgWithOffsetResponse;", "offsetMsgInfo", "setOffsetMsgInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgWithOffsetResponse;)V", "params", "Lcom/tencent/mm/plugin/finder/replay/model/LiveMsgOffsetParams;", "scene", "", "getScene", "()I", "setScene", "(I)V", "startOffsetSec", "getStartOffsetSec", "setStartOffsetSec", "firstMessageOffset", "getMessage", "", "offsetSecond", "force", "init", "lastMessageOffset", "onCleared", "printMsgInfo", "prefix", "release", "resetParams", "stopMessage", "trackMessage", "msgParams", "tryGetMessage", "playerOffsetSecond", "updateMessage", "offset", "updateMessageImpl", "validInfo", "liveId", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.finder.live.viewmodel.data.business.c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final a Fmx;
  public com.tencent.mm.plugin.finder.replay.model.e FmA;
  public com.tencent.mm.plugin.finder.replay.model.d FmB;
  public CopyOnWriteArrayList<cai> FmC;
  public int FmD;
  private azr FmE;
  private volatile String Fmy;
  volatile boolean Fmz;
  public int scene;
  
  static
  {
    AppMethodBeat.i(332826);
    Fmx = new a((byte)0);
    AppMethodBeat.o(332826);
  }
  
  public a(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(332750);
    this.Fmy = "";
    this.FmA = new com.tencent.mm.plugin.finder.replay.model.e();
    this.FmC = new CopyOnWriteArrayList();
    AppMethodBeat.o(332750);
  }
  
  private final void a(azr paramazr)
  {
    AppMethodBeat.i(332760);
    if (paramazr == null) {}
    for (com.tencent.mm.bx.b localb = null;; localb = paramazr.ZEQ)
    {
      if (localb == null) {
        Log.i("LiveMsgOffsetSlice", "set offsetMsgInfo last buffer to null!");
      }
      this.FmE = paramazr;
      AppMethodBeat.o(332760);
      return;
    }
  }
  
  private final void aH(int paramInt, boolean paramBoolean)
  {
    ah.a locala;
    label63:
    long l2;
    int i;
    try
    {
      AppMethodBeat.i(332783);
      if ((!paramBoolean) && (this.Fmz))
      {
        Log.i("LiveMsgOffsetSlice", "getMessage invalid,message requesting!");
        AppMethodBeat.o(332783);
        return;
      }
      locala = new ah.a();
      if (paramBoolean) {
        break label343;
      }
      localObject1 = this.FmE;
      if (localObject1 != null) {
        break label278;
      }
      localObject1 = null;
    }
    finally {}
    locala.aiwY = bool;
    this.Fmz = true;
    long l1 = ((f)business(f.class)).liveInfo.liveId;
    this.Fmy = (l1 + '-' + System.currentTimeMillis());
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
    label145:
    String str;
    bui localbui;
    if (localObject1 == null)
    {
      localObject1 = "";
      l2 = ((f)business(f.class)).hKN;
      str = ((f)business(f.class)).nonceId;
      localbui = new bui();
      i = this.scene;
      if (locala.aiwY) {
        break label355;
      }
    }
    label278:
    label338:
    label343:
    label355:
    for (boolean bool = true;; bool = false)
    {
      Object localObject4;
      if (locala.aiwY) {
        localObject4 = null;
      }
      Object localObject3;
      for (;;)
      {
        com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)new t((String)localObject1, l1, l2, str, i, "", localbui, paramInt, bool, (com.tencent.mm.bx.b)localObject4, this.Fmy).bFJ(), (kotlin.g.a.b)new a.b(this, paramBoolean, locala, paramInt));
        AppMethodBeat.o(332783);
        break;
        localObject3 = localObject2.ZEQ;
        break label338;
        localObject4 = ((FinderObject)localObject3).username;
        localObject3 = localObject4;
        if (localObject4 != null) {
          break label145;
        }
        localObject3 = "";
        break label145;
        localObject4 = this.FmE;
        if (localObject4 == null) {
          localObject4 = null;
        } else {
          localObject4 = ((azr)localObject4).ZEQ;
        }
      }
      if (localObject3 == null)
      {
        bool = true;
        break label63;
      }
      bool = false;
      break label63;
    }
  }
  
  private final int eLW()
  {
    AppMethodBeat.i(332770);
    cai localcai = (cai)p.oN((List)this.FmC);
    if (localcai == null)
    {
      AppMethodBeat.o(332770);
      return 0;
    }
    int i = localcai.aajp;
    AppMethodBeat.o(332770);
    return i;
  }
  
  private final void resetParams()
  {
    AppMethodBeat.i(332765);
    this.Fmy = "";
    this.Fmz = false;
    this.FmC.clear();
    this.FmB = null;
    a(null);
    AppMethodBeat.o(332765);
  }
  
  public final boolean RZ(int paramInt)
  {
    AppMethodBeat.i(332841);
    aI(paramInt, false);
    Object localObject1;
    if (this.FmC.isEmpty())
    {
      localObject1 = this.FmB;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.replay.model.d)localObject1).a(null);
      }
      AppMethodBeat.o(332841);
      return false;
    }
    try
    {
      localObject3 = ((Iterable)this.FmC).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = ((Iterator)localObject3).next();
        if (((cai)localObject1).aajp == paramInt)
        {
          i = 1;
          break label479;
        }
      }
      for (;;)
      {
        localObject1 = (cai)localObject1;
        if (localObject1 != null) {
          break;
        }
        localObject1 = null;
        bool = false;
        if (localObject1 == null) {
          bool = false;
        }
        label123:
        AppMethodBeat.o(332841);
        return bool;
        i = 0;
        break label479;
        localObject1 = null;
      }
      localObject3 = ((cai)localObject1).aajq;
      if (localObject3 != null)
      {
        localObject3 = ((azp)localObject3).PmC;
        if (localObject3 != null)
        {
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((bke)((Iterator)localObject3).next()).ZOd = paramInt;
          }
        }
      }
    }
    catch (NoSuchElementException localNoSuchElementException1)
    {
      for (;;)
      {
        Object localObject3;
        int i;
        boolean bool = false;
        for (;;)
        {
          Log.w("LiveMsgOffsetSlice", s.X("updateMessage err: ", localNoSuchElementException1.getMessage()));
          break label123;
          localObject3 = localNoSuchElementException1.aajq;
          if (localObject3 != null)
          {
            localObject3 = ((azp)localObject3).ZJV;
            if (localObject3 != null)
            {
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((bdm)((Iterator)localObject3).next()).ZOd = paramInt;
              }
            }
          }
          localObject3 = this.FmB;
          if (localObject3 != null) {
            ((com.tencent.mm.plugin.finder.replay.model.d)localObject3).a(localNoSuchElementException1.aajq);
          }
          this.FmC.remove(localNoSuchElementException1);
          localObject3 = new StringBuilder("after updateMessage msg(");
          com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
          Object localObject2 = com.tencent.mm.plugin.finder.live.view.convert.a.a(localNoSuchElementException1) + ')';
          localObject2 = new StringBuilder("ReplayMsgInfo:").append((String)localObject2).append(" msg size:").append(this.FmC.size()).append("(second:");
          localObject3 = (cai)p.oL((List)this.FmC);
          if (localObject3 == null) {}
          for (paramInt = 0;; paramInt = ((cai)localObject3).aajp) {
            for (;;)
            {
              Log.i("LiveMsgOffsetSlice", paramInt + '~' + eLW() + ')');
              try
              {
                localObject2 = ah.aiuX;
                bool = true;
              }
              catch (NoSuchElementException localNoSuchElementException2)
              {
                bool = true;
              }
            }
          }
        }
        label479:
        if (i == 0) {}
      }
    }
  }
  
  public final void aI(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(332849);
    int k = this.FmA.FlW;
    Log.i("LiveMsgOffsetSlice", "tryGetMessage playerOffsetSecond:" + paramInt + "(total:" + k + "),force:" + paramBoolean);
    int j;
    if (paramInt >= 0)
    {
      if (paramBoolean)
      {
        aH(paramInt, paramBoolean);
        AppMethodBeat.o(332849);
        return;
      }
      j = eLW();
      paramInt = j - paramInt;
      if (paramInt < 0) {
        break label146;
      }
      if (paramInt > 2) {
        break label141;
      }
      paramInt = 1;
      if (paramInt != 0)
      {
        if (j <= 0) {
          break label156;
        }
        if (j >= k) {
          break label151;
        }
        paramInt = i;
      }
    }
    for (;;)
    {
      if (paramInt != 0) {
        aH(j + 1, paramBoolean);
      }
      AppMethodBeat.o(332849);
      return;
      label141:
      paramInt = 0;
      break;
      label146:
      paramInt = 0;
      break;
      label151:
      paramInt = 0;
      continue;
      label156:
      paramInt = 0;
    }
  }
  
  public final void eLV()
  {
    AppMethodBeat.i(332831);
    Log.i("LiveMsgOffsetSlice", "stopMessage");
    resetParams();
    AppMethodBeat.o(332831);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(332854);
    super.onCleared();
    Log.i("LiveMsgOffsetSlice", "onCleared");
    resetParams();
    AppMethodBeat.o(332854);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/viewmodel/LiveMsgOffsetSlice$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.viewmodel.a
 * JD-Core Version:    0.7.0.1
 */