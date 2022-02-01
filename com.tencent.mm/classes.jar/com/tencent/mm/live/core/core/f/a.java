package com.tencent.mm.live.core.core.f;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.plugin.finder.live.olympic.b.a;
import com.tencent.mm.plugin.finder.live.olympic.b.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/visitor/FinderLiveVisitorPlayCore;", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "()V", "bgmPlayer", "Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveBgmPlayer;", "inVideoStream", "", "getInVideoStream", "()Z", "setInVideoStream", "(Z)V", "liveId", "", "calcMiniWindowSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "cdnStartPlay", "", "streamType", "", "playerView", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "playCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "cdnStopPlay", "keepLastFrame", "changeToAudioStream", "bgmUrls", "", "", "changeToVideoStream", "getBgmPlayer", "getCoreKey", "hideMiniWindowWhenBackground", "isAnchorLinkMic", "realSetMute", "mute", "release", "setBgmPlayer", "setMuteWhenBackground", "toString", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends d
{
  public static final a mUf;
  private static ConcurrentHashMap<Long, a> mUi;
  public long liveId;
  private com.tencent.mm.plugin.finder.live.olympic.b mUg;
  public boolean mUh = true;
  
  static
  {
    AppMethodBeat.i(248044);
    mUf = new a((byte)0);
    mUi = new ConcurrentHashMap(2);
    AppMethodBeat.o(248044);
  }
  
  public final void a(int paramInt, LiveVideoView paramLiveVideoView, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(248057);
    Log.i("FinderLiveVisitorPlayCore", "cdnStartPlay liveId:" + this.liveId + '(' + this + ")!");
    super.a(paramInt, paramLiveVideoView, paramb);
    AppMethodBeat.o(248057);
  }
  
  public final void bC(List<String> paramList)
  {
    AppMethodBeat.i(248136);
    s.u(paramList, "bgmUrls");
    if (!this.mUh)
    {
      Log.i("FinderLiveVisitorPlayCore", "changeToAudioStream already in");
      if (this.mUg != null) {
        AppMethodBeat.o(248136);
      }
    }
    else
    {
      this.mUn.bck();
      this.mUn.setMute(true);
    }
    this.mUh = false;
    Object localObject = this.mUg;
    if (localObject == null) {
      localObject = null;
    }
    while (localObject == null)
    {
      localObject = (a)this;
      if (paramList.isEmpty())
      {
        Log.i("FinderLiveVisitorPlayCore", "changeToAudioStream audio url is empty");
        AppMethodBeat.o(248136);
        return;
        Log.i(((com.tencent.mm.plugin.finder.live.olympic.b)localObject).TAG, "resume");
        ((com.tencent.mm.plugin.finder.live.olympic.b)localObject).CNh.hLh();
        Log.i("FinderLiveVisitorPlayCore", "changeToAudioStream pause video, resume audio");
        localObject = ah.aiuX;
      }
      else
      {
        com.tencent.mm.plugin.finder.live.olympic.b localb = new com.tencent.mm.plugin.finder.live.olympic.b();
        s.u(localb, "bgmPlayer");
        ((a)localObject).mUg = localb;
        Log.i("FinderLiveVisitorPlayCore", s.X("setBgmPlayer ", Integer.valueOf(localb.hashCode())));
        localObject = ((a)localObject).mUg;
        if (localObject != null)
        {
          s.u(paramList, "urls");
          ((com.tencent.mm.plugin.finder.live.olympic.b)localObject).CNi.addAll((Collection)paramList);
          ((com.tencent.mm.plugin.finder.live.olympic.b)localObject).awJ(((com.tencent.mm.plugin.finder.live.olympic.b)localObject).enq());
          ((com.tencent.mm.plugin.finder.live.olympic.b)localObject).CNh.TFi = ((kotlin.g.a.b)new b.a((com.tencent.mm.plugin.finder.live.olympic.b)localObject));
          ((com.tencent.mm.plugin.finder.live.olympic.b)localObject).CNh.j((q)new b.b((com.tencent.mm.plugin.finder.live.olympic.b)localObject));
          Log.i(((com.tencent.mm.plugin.finder.live.olympic.b)localObject).TAG, s.X("prepare ", p.a((Iterable)paramList, (CharSequence)", ", null, null, 0, null, null, 62)));
          Log.i(((com.tencent.mm.plugin.finder.live.olympic.b)localObject).TAG, "play");
          ((com.tencent.mm.plugin.finder.live.olympic.b)localObject).CNh.hLh();
          Log.i("FinderLiveVisitorPlayCore", "changeToAudioStream pause video, start play audio");
        }
      }
    }
    AppMethodBeat.o(248136);
  }
  
  public final boolean beK()
  {
    AppMethodBeat.i(248079);
    if (!bfK())
    {
      AppMethodBeat.o(248079);
      return true;
    }
    AppMethodBeat.o(248079);
    return false;
  }
  
  public final boolean beL()
  {
    AppMethodBeat.i(248087);
    if (!bfK())
    {
      AppMethodBeat.o(248087);
      return true;
    }
    AppMethodBeat.o(248087);
    return false;
  }
  
  public final void bfA()
  {
    AppMethodBeat.i(248146);
    if (this.mUh)
    {
      Log.i("FinderLiveVisitorPlayCore", "changeToVideoStream already in");
      AppMethodBeat.o(248146);
      return;
    }
    this.mUh = true;
    this.mUn.bcl();
    setMute(false);
    com.tencent.mm.plugin.finder.live.olympic.b localb = this.mUg;
    if (localb != null)
    {
      Log.i(localb.TAG, "pause");
      com.tencent.mm.plugin.thumbplayer.e.b.b(localb.CNh);
    }
    Log.i("FinderLiveVisitorPlayCore", "changeToVideoStream resume video, pause audio");
    AppMethodBeat.o(248146);
  }
  
  public final boolean bfz()
  {
    AppMethodBeat.i(248107);
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    Object localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (localObject2 == null)
    {
      AppMethodBeat.o(248107);
      return false;
    }
    localObject1 = ((j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(j.class)).Efv;
    localObject2 = ((j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(j.class)).Efw;
    if (localObject1 == null)
    {
      localObject1 = (Collection)localObject2;
      if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
        break label90;
      }
    }
    label90:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(248107);
      return true;
    }
    AppMethodBeat.o(248107);
    return false;
  }
  
  public final Point dB(Context paramContext)
  {
    AppMethodBeat.i(248097);
    s.u(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    com.tencent.mm.plugin.finder.live.model.context.a locala = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (locala == null) {}
    label211:
    for (boolean bool = false;; bool = false) {
      for (;;)
      {
        Log.i("FinderLiveVisitorPlayCore", "calcMiniWindowSize isMicingByLocal:" + bool + ", videoWidth:" + this.videoWidth + ", videoHeight:" + this.videoHeight);
        if (!bool) {
          break label216;
        }
        paramContext = super.dB(paramContext);
        AppMethodBeat.o(248097);
        return paramContext;
        localObject = ((j)locala.business(j.class)).Efw;
        s.s(localObject, "buContext.business(LiveL…).audienceLinkMicUserList");
        synchronized ((Iterable)localObject)
        {
          Iterator localIterator = ???.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject = localIterator.next();
              bool = Util.isEqual(((h)localObject).mXL, ((e)locala.business(e.class)).eyF());
              if (bool)
              {
                if (localObject == null) {
                  break label211;
                }
                bool = true;
                break;
              }
            }
          }
          localObject = null;
        }
      }
    }
    label216:
    paramContext = com.tencent.mm.live.core.d.a.mWH;
    paramContext = com.tencent.mm.live.core.d.a.em(this.videoWidth, this.videoHeight);
    AppMethodBeat.o(248097);
    return paramContext;
  }
  
  public final void fO(boolean paramBoolean)
  {
    AppMethodBeat.i(248067);
    Log.i("FinderLiveVisitorPlayCore", "cdnStopPlay liveId:" + this.liveId + '(' + this + ")!");
    super.fO(paramBoolean);
    AppMethodBeat.o(248067);
  }
  
  public final void fP(boolean paramBoolean)
  {
    AppMethodBeat.i(248112);
    super.fP(paramBoolean);
    com.tencent.mm.plugin.finder.live.olympic.b localb = this.mUg;
    if (localb != null)
    {
      localb.CNh.setMute(paramBoolean);
      Log.i(localb.TAG, s.X("setMute ", Boolean.valueOf(paramBoolean)));
    }
    AppMethodBeat.o(248112);
  }
  
  public final void release()
  {
    AppMethodBeat.i(248118);
    super.release();
    com.tencent.mm.plugin.finder.live.olympic.b localb = this.mUg;
    if (localb != null)
    {
      Log.i(localb.TAG, "stop");
      localb.CNh.stopAsync();
    }
    localb = this.mUg;
    if (localb != null)
    {
      Log.i(localb.TAG, "release");
      localb.CNh.recycle();
    }
    AppMethodBeat.o(248118);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(248073);
    String str = super.toString() + ",Core liveId:" + this.liveId;
    AppMethodBeat.o(248073);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/visitor/FinderLiveVisitorPlayCore$Companion;", "", "()V", "TAG", "", "instanceArray", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/live/core/core/visitor/FinderLiveVisitorPlayCore;", "checkPlayerLeak", "", "clear", "", "create", "liveId", "getCoreSize", "", "getInstance", "hasInstance", "releaseInstance", "stopPlay", "releaseWithoutLiveId", "stopTheWorld", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void clear()
    {
      AppMethodBeat.i(248081);
      Log.i("FinderLiveVisitorPlayCore", s.X("FinderLiveVisitorPlayCore clear, core size:", Integer.valueOf(a.bfB().size())));
      Object localObject = com.tencent.mm.plugin.findersdk.f.b.HeJ;
      com.tencent.mm.plugin.findersdk.f.b.iz("FinderLiveVisitorPlayCore", s.X("FinderLiveVisitorPlayCore clear, core size:", Integer.valueOf(a.bfB().size())));
      localObject = ((Map)a.bfB()).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        ((a)localEntry.getValue()).fO(false);
        ((a)localEntry.getValue()).release();
      }
      a.bfB().clear();
      AppMethodBeat.o(248081);
    }
    
    public static a hG(long paramLong)
    {
      AppMethodBeat.i(248050);
      ??? = com.tencent.mm.plugin.findersdk.f.b.HeJ;
      Object localObject2 = new StringBuilder(" create ").append(paramLong).append(' ');
      ??? = (a)a.bfB().get(Long.valueOf(paramLong));
      Object localObject4;
      Long localLong;
      if (??? == null)
      {
        ??? = null;
        com.tencent.mm.plugin.findersdk.f.b.iz("FinderLiveVisitorPlayCore", ???);
        localObject4 = (ConcurrentMap)a.bfB();
        localLong = Long.valueOf(paramLong);
        ??? = ((ConcurrentMap)localObject4).get(localLong);
        if (??? != null) {
          break label274;
        }
        localObject2 = new a();
      }
      label274:
      for (;;)
      {
        synchronized (a.bfB())
        {
          Object localObject5 = (a)a.bfB().get(Long.valueOf(paramLong));
          if (localObject5 != null)
          {
            ((a)localObject5).fO(false);
            ((a)localObject5).release();
          }
          ((Map)a.bfB()).put(Long.valueOf(paramLong), localObject2);
          localObject5 = ah.aiuX;
          a.a((a)localObject2, paramLong);
          Log.i("FinderLiveVisitorPlayCore", "FinderLiveVisitorPlayCore create instance:" + Integer.valueOf(((a)localObject2).hashCode()) + ", liveId:" + paramLong + ", core size:" + a.bfB().size());
          localObject4 = ((ConcurrentMap)localObject4).putIfAbsent(localLong, localObject2);
          ??? = localObject4;
          if (localObject4 == null) {
            ??? = localObject2;
          }
          s.s(???, "instanceArray.getOrPut(l…          }\n            }");
          ??? = (a)???;
          AppMethodBeat.o(248050);
          return ???;
          ??? = Integer.valueOf(((a)???).hashCode());
        }
      }
    }
    
    public static a hH(long paramLong)
    {
      AppMethodBeat.i(248059);
      a locala = (a)a.bfB().get(Long.valueOf(paramLong));
      if (locala == null) {
        Log.i("FinderLiveVisitorPlayCore", "FinderLiveVisitorPlayCore get liveId:" + paramLong + " instance is empty, core size:" + a.bfB().size());
      }
      AppMethodBeat.o(248059);
      return locala;
    }
    
    public static void hI(long paramLong)
    {
      AppMethodBeat.i(248070);
      Log.i("FinderLiveVisitorPlayCore", s.X("releaseWithoutLiveId ", Long.valueOf(paramLong)));
      a locala = (a)a.bfB().remove(Long.valueOf(paramLong));
      clear();
      if (locala != null) {
        ((Map)a.bfB()).put(Long.valueOf(paramLong), locala);
      }
      AppMethodBeat.o(248070);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.f.a
 * JD-Core Version:    0.7.0.1
 */