package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.plugin.finder.utils.ao;
import com.tencent.mm.plugin.finder.utils.ar;
import com.tencent.mm.plugin.findersdk.b;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveMicWatcher;", "", "()V", "onAnchorAcceptMicFail", "", "errCode", "", "errType", "liveId", "", "onAnchorAcceptMicPkFail", "onAnchorApplyMicPkFail", "onCloseMicFail", "isAnchor", "", "onCloseMicPkFail", "onVisitorApplyMicFail", "onVisitorEnterRoomMicFail", "roomId", "plugin-finder_release"})
public final class z
{
  public static final z ygx;
  
  static
  {
    AppMethodBeat.i(288518);
    ygx = new z();
    AppMethodBeat.o(288518);
  }
  
  public static void a(boolean paramBoolean, final int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(288513);
    Object localObject;
    if (paramBoolean)
    {
      localObject = ao.AGX;
      ao.eeT();
    }
    for (;;)
    {
      f.a.a(b.BuZ, "mic_closeMicFail", false, false, (a)new d(paramBoolean, paramInt1, paramInt2, paramLong), 12);
      AppMethodBeat.o(288513);
      return;
      localObject = ar.AIS;
      ar.ege();
    }
  }
  
  public static void l(int paramInt, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(288512);
    f.a.a(b.BuZ, "mic_visitorEnterRoomFail", false, false, (a)new g(paramInt, paramLong1, paramLong2), 12);
    AppMethodBeat.o(288512);
  }
  
  public static void m(int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(288511);
    ar localar = ar.AIS;
    ar.egc();
    f.a.a(b.BuZ, "mic_visitorApplyMicFail", false, false, (a)new f(paramInt1, paramInt2, paramLong), 12);
    AppMethodBeat.o(288511);
  }
  
  public static void n(int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(288514);
    ao localao = ao.AGX;
    ao.eeR();
    f.a.a(b.BuZ, "mic_anchorAcceptMicFail", false, false, (a)new a(paramInt1, paramInt2, paramLong), 12);
    AppMethodBeat.o(288514);
  }
  
  public static void o(int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(288515);
    f.a.a(b.BuZ, "micpk_anchorApplyMicFail", false, false, (a)new c(paramInt1, paramInt2, paramLong), 12);
    AppMethodBeat.o(288515);
  }
  
  public static void p(int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(288516);
    f.a.a(b.BuZ, "micpk_anchorAcceptMicFail", false, false, (a)new b(paramInt1, paramInt2, paramLong), 12);
    AppMethodBeat.o(288516);
  }
  
  public static void q(int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(288517);
    f.a.a(b.BuZ, "micpk_anchorCloseMicFail", false, false, (a)new e(paramInt1, paramInt2, paramLong), 12);
    AppMethodBeat.o(288517);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<String>
  {
    a(int paramInt1, int paramInt2, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<String>
  {
    b(int paramInt1, int paramInt2, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<String>
  {
    c(int paramInt1, int paramInt2, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<String>
  {
    d(boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<String>
  {
    e(int paramInt1, int paramInt2, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<String>
  {
    f(int paramInt1, int paramInt2, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<String>
  {
    g(int paramInt, long paramLong1, long paramLong2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.z
 * JD-Core Version:    0.7.0.1
 */