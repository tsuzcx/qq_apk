package com.tencent.mm.plugin.finder.replay.viewmodel;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.model.i.c;
import com.tencent.mm.live.core.core.model.i.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/viewmodel/LiveReplaySlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "anchorUsername", "", "getAnchorUsername", "()Ljava/lang/String;", "setAnchorUsername", "(Ljava/lang/String;)V", "coverUrl", "getCoverUrl", "setCoverUrl", "curPos", "", "getCurPos", "()I", "setCurPos", "(I)V", "enterTime", "", "getEnterTime", "()J", "setEnterTime", "(J)V", "haveRequestServerOrigDura", "", "getHaveRequestServerOrigDura", "()Z", "setHaveRequestServerOrigDura", "(Z)V", "value", "isDocCast", "setDocCast", "liveId", "getLiveId", "setLiveId", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;)V", "manualClose", "getManualClose", "setManualClose", "manualMinimum", "getManualMinimum", "setManualMinimum", "nonceId", "getNonceId", "setNonceId", "objectId", "getObjectId", "setObjectId", "offset", "getOffset", "setOffset", "orgiDuration", "getOrgiDuration", "setOrgiDuration", "replayStartOffset", "getReplayStartOffset", "setReplayStartOffset", "replayStatus", "getReplayStatus", "setReplayStatus", "shoppingReport", "Lcom/tencent/mm/plugin/finder/replay/viewmodel/LiveReplaySlice$ShoppingReport;", "getShoppingReport", "()Lcom/tencent/mm/plugin/finder/replay/viewmodel/LiveReplaySlice$ShoppingReport;", "shoppingReport$delegate", "Lkotlin/Lazy;", "total", "getTotal", "setTotal", "Lcom/tencent/mm/live/core/core/model/LiveStatus$MiniWindowMode;", "uiStatus", "getUiStatus", "()Lcom/tencent/mm/live/core/core/model/LiveStatus$MiniWindowMode;", "setUiStatus", "(Lcom/tencent/mm/live/core/core/model/LiveStatus$MiniWindowMode;)V", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveMode;", "videoMode", "getVideoMode", "()Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveMode;", "setVideoMode", "(Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveMode;)V", "getReplayDuration", "isAudioMode", "isMyReplay", "isScreenShareMode", "onCleared", "", "setOrigDura", "fromServer", "(ILjava/lang/Boolean;)V", "switchAudioMode", "switchScreenShareMode", "docCast", "switchVideoMode", "Companion", "ShoppingReport", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.finder.live.viewmodel.data.business.c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final a FmK;
  public int CEY;
  public int FmL;
  public int FmM;
  private i.e FmN;
  private i.c FmO;
  public boolean FmP;
  public int FmQ;
  public boolean FmR;
  public boolean FmS;
  private final j FmT;
  private String coverUrl;
  public long enterTime;
  private bip liveInfo;
  private String mIC;
  public boolean mNQ;
  private String nonceId;
  public int offset;
  public int total;
  
  static
  {
    AppMethodBeat.i(332761);
    FmK = new a((byte)0);
    AppMethodBeat.o(332761);
  }
  
  public c(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(332735);
    this.FmN = i.e.mOf;
    this.liveInfo = new bip();
    this.FmO = i.c.mNY;
    this.mIC = "";
    this.nonceId = "";
    this.coverUrl = "";
    this.FmT = k.cm((kotlin.g.a.a)c.FmU);
    AppMethodBeat.o(332735);
  }
  
  private void Sc(int paramInt)
  {
    AppMethodBeat.i(332742);
    if (paramInt != this.FmQ) {
      Log.i("MMFinder.LiveReplaySlice", s.X("orgi_duration:", Integer.valueOf(paramInt)));
    }
    this.FmQ = paramInt;
    AppMethodBeat.o(332742);
  }
  
  public final void Sa(int paramInt)
  {
    AppMethodBeat.i(332767);
    if (paramInt != this.FmL)
    {
      Log.i("MMFinder.LiveReplaySlice", "replayStartOffset from:" + this.FmL + " to " + paramInt);
      this.FmL = paramInt;
    }
    AppMethodBeat.o(332767);
  }
  
  public final void Sb(int paramInt)
  {
    AppMethodBeat.i(332773);
    if (paramInt != this.FmM)
    {
      Log.i("MMFinder.LiveReplaySlice", "replayStatus from:" + this.FmM + " to " + paramInt);
      this.FmM = paramInt;
    }
    AppMethodBeat.o(332773);
  }
  
  public final void a(int paramInt, Boolean paramBoolean)
  {
    AppMethodBeat.i(332835);
    if (paramBoolean != null) {
      this.FmP = paramBoolean.booleanValue();
    }
    if (paramInt != this.FmQ) {
      Log.i("MMFinder.LiveReplaySlice", "setOrigDura from:" + this.FmQ + " to " + paramInt + ",fromServer:" + paramBoolean);
    }
    Sc(paramInt);
    AppMethodBeat.o(332835);
  }
  
  public final void a(i.c paramc)
  {
    AppMethodBeat.i(332791);
    s.u(paramc, "value");
    if (this.FmO == paramc) {
      Log.i("MMFinder.LiveReplaySlice", "set liveMode:" + this.FmO + '!');
    }
    this.FmO = paramc;
    AppMethodBeat.o(332791);
  }
  
  public final void a(i.e parame)
  {
    AppMethodBeat.i(332777);
    s.u(parame, "value");
    if (parame != this.FmN)
    {
      Log.i("MMFinder.LiveReplaySlice", "uiStatus from:" + this.FmN + " to " + parame);
      this.FmN = parame;
    }
    AppMethodBeat.o(332777);
  }
  
  public final boolean bex()
  {
    return this.FmO == i.c.mNZ;
  }
  
  public final boolean eLX()
  {
    AppMethodBeat.i(332839);
    if (((CharSequence)eyh()).length() > 0) {}
    for (int i = 1; (i != 0) && (s.p(eyh(), z.bAW())); i = 0)
    {
      AppMethodBeat.o(332839);
      return true;
    }
    AppMethodBeat.o(332839);
    return false;
  }
  
  public final long eLY()
  {
    AppMethodBeat.i(332855);
    long l1 = SystemClock.elapsedRealtime();
    if ((this.enterTime <= 0L) || (this.enterTime >= l1))
    {
      AppMethodBeat.o(332855);
      return 0L;
    }
    long l2 = this.enterTime;
    AppMethodBeat.o(332855);
    return l1 - l2;
  }
  
  public final b eLZ()
  {
    AppMethodBeat.i(332873);
    b localb = (b)this.FmT.getValue();
    AppMethodBeat.o(332873);
    return localb;
  }
  
  public final long ecI()
  {
    AppMethodBeat.i(332818);
    FinderObject localFinderObject = ((e)business(e.class)).Eco;
    if (localFinderObject == null)
    {
      AppMethodBeat.o(332818);
      return 0L;
    }
    long l = localFinderObject.id;
    AppMethodBeat.o(332818);
    return l;
  }
  
  public final String eyh()
  {
    AppMethodBeat.i(332810);
    Object localObject = ((e)business(e.class)).Eco;
    if (localObject == null)
    {
      AppMethodBeat.o(332810);
      return "";
    }
    localObject = ((FinderObject)localObject).username;
    if (localObject == null)
    {
      AppMethodBeat.o(332810);
      return "";
    }
    AppMethodBeat.o(332810);
    return localObject;
  }
  
  public final bip getLiveInfo()
  {
    AppMethodBeat.i(332785);
    bip localbip = ((f)business(f.class)).liveInfo;
    AppMethodBeat.o(332785);
    return localbip;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(332865);
    super.onCleared();
    Log.i("MMFinder.LiveReplaySlice", "onCleared");
    wj(0);
    setTotal(0);
    this.FmP = false;
    Sc(0);
    this.enterTime = 0L;
    Sa(0);
    tw(false);
    tx(false);
    a(i.c.mNY);
    AppMethodBeat.o(332865);
  }
  
  public final void setTotal(int paramInt)
  {
    AppMethodBeat.i(332828);
    if (paramInt != this.total) {
      Log.i("MMFinder.LiveReplaySlice", s.X("play total:", Integer.valueOf(paramInt)));
    }
    this.total = paramInt;
    AppMethodBeat.o(332828);
  }
  
  public final void tw(boolean paramBoolean)
  {
    AppMethodBeat.i(332845);
    Log.i("MMFinder.LiveReplaySlice", s.X("manualClose:", Boolean.valueOf(paramBoolean)));
    this.FmR = paramBoolean;
    AppMethodBeat.o(332845);
  }
  
  public final void tx(boolean paramBoolean)
  {
    AppMethodBeat.i(332848);
    Log.i("MMFinder.LiveReplaySlice", s.X("manualMinimum:", Boolean.valueOf(paramBoolean)));
    this.FmS = paramBoolean;
    AppMethodBeat.o(332848);
  }
  
  public final void wj(int paramInt)
  {
    AppMethodBeat.i(332823);
    Log.i("MMFinder.LiveReplaySlice", s.X("play offset:", Integer.valueOf(paramInt)));
    ((com.tencent.mm.plugin.finder.live.business.a)business(com.tencent.mm.plugin.finder.live.business.a.class)).awi(String.valueOf(paramInt));
    this.offset = paramInt;
    AppMethodBeat.o(332823);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/viewmodel/LiveReplaySlice$Companion;", "", "()V", "STATUS_ENDED", "", "STATUS_INIT", "STATUS_OVERTIME", "STATUS_RUNNING", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/viewmodel/LiveReplaySlice$ShoppingReport;", "", "session", "", "productId", "source", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "getSession", "setSession", "getSource", "setSource", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public String hQR;
    public String productId;
    public String source;
    
    private b(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(332686);
      this.hQR = paramString1;
      this.productId = paramString2;
      this.source = paramString3;
      AppMethodBeat.o(332686);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(332718);
      if (this == paramObject)
      {
        AppMethodBeat.o(332718);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(332718);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.hQR, paramObject.hQR))
      {
        AppMethodBeat.o(332718);
        return false;
      }
      if (!s.p(this.productId, paramObject.productId))
      {
        AppMethodBeat.o(332718);
        return false;
      }
      if (!s.p(this.source, paramObject.source))
      {
        AppMethodBeat.o(332718);
        return false;
      }
      AppMethodBeat.o(332718);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(332706);
      int i = this.hQR.hashCode();
      int j = this.productId.hashCode();
      int k = this.source.hashCode();
      AppMethodBeat.o(332706);
      return (i * 31 + j) * 31 + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(332700);
      String str = "session:" + this.hQR + ",productId:" + this.productId + ",source:" + this.source;
      AppMethodBeat.o(332700);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/replay/viewmodel/LiveReplaySlice$ShoppingReport;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<c.b>
  {
    public static final c FmU;
    
    static
    {
      AppMethodBeat.i(332684);
      FmU = new c();
      AppMethodBeat.o(332684);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.viewmodel.c
 * JD-Core Version:    0.7.0.1
 */