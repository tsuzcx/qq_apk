package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.plugin.finder.utils.ba;
import com.tencent.mm.plugin.finder.utils.bd;
import com.tencent.mm.plugin.findersdk.b;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveMicWatcher;", "", "()V", "onAnchorAcceptMicFail", "", "errCode", "", "errType", "liveId", "", "onAnchorAcceptMicPkFail", "onAnchorApplyMicPkFail", "onCloseMicFail", "isAnchor", "", "onCloseMicPkFail", "onCloseRandomMatchMicFail", "onVisitorApplyMicFail", "onVisitorEnterRoomMicFail", "roomId", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
{
  public static final aa CGv;
  
  static
  {
    AppMethodBeat.i(359249);
    CGv = new aa();
    AppMethodBeat.o(359249);
  }
  
  public static void a(boolean paramBoolean, final int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(359218);
    Object localObject;
    if (paramBoolean)
    {
      localObject = ba.Gjt;
      ba.fgP();
    }
    for (;;)
    {
      e.a.a((e)b.HbT, "mic_closeMicFail", false, null, false, (a)new d(paramBoolean, paramInt1, paramInt2, paramLong), 28);
      AppMethodBeat.o(359218);
      return;
      localObject = bd.Gli;
      bd.fia();
    }
  }
  
  public static void l(int paramInt, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(359211);
    e.a.a((e)b.HbT, "mic_visitorEnterRoomFail", false, null, false, (a)new h(paramInt, paramLong1, paramLong2), 28);
    AppMethodBeat.o(359211);
  }
  
  public static void n(int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(359205);
    bd localbd = bd.Gli;
    bd.fhY();
    e.a.a((e)b.HbT, "mic_visitorApplyMicFail", false, null, false, (a)new g(paramInt1, paramInt2, paramLong), 28);
    AppMethodBeat.o(359205);
  }
  
  public static void o(int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(359225);
    ba localba = ba.Gjt;
    ba.fgN();
    e.a.a((e)b.HbT, "mic_anchorAcceptMicFail", false, null, false, (a)new a(paramInt1, paramInt2, paramLong), 28);
    AppMethodBeat.o(359225);
  }
  
  public static void p(int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(359230);
    e.a.a((e)b.HbT, "micpk_anchorApplyMicFail", false, null, false, (a)new c(paramInt1, paramInt2, paramLong), 28);
    AppMethodBeat.o(359230);
  }
  
  public static void q(int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(359236);
    e.a.a((e)b.HbT, "micpk_anchorAcceptMicFail", false, null, false, (a)new b(paramInt1, paramInt2, paramLong), 28);
    AppMethodBeat.o(359236);
  }
  
  public static void r(int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(359237);
    e.a.a((e)b.HbT, "micpk_anchorCloseMicFail", false, null, false, (a)new e(paramInt1, paramInt2, paramLong), 28);
    AppMethodBeat.o(359237);
  }
  
  public static void s(int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(359245);
    e.a.a((e)b.HbT, "micpk_anchorCloseRandomMatchMicFail", false, null, false, (a)new f(paramInt1, paramInt2, paramLong), 28);
    AppMethodBeat.o(359245);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<String>
  {
    a(int paramInt1, int paramInt2, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<String>
  {
    b(int paramInt1, int paramInt2, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<String>
  {
    c(int paramInt1, int paramInt2, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<String>
  {
    d(boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<String>
  {
    e(int paramInt1, int paramInt2, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<String>
  {
    f(int paramInt1, int paramInt2, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements a<String>
  {
    g(int paramInt1, int paramInt2, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements a<String>
  {
    h(int paramInt, long paramLong1, long paramLong2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.aa
 * JD-Core Version:    0.7.0.1
 */