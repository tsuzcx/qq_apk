package com.tencent.mm.plugin.emoji.magicemoji.core.a;

import android.os.IBinder;
import android.os.RemoteException;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.magicemoji.bean.WxaPkgRecordForME;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/core/wrapper/MagicEmojiServiceSafeWrapper;", "Lcom/tencent/mm/plugin/emoji/magicemoji/IMagicEmojiService;", "service", "errorCallback", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/plugin/emoji/magicemoji/IMagicEmojiService;Lkotlin/jvm/functions/Function1;)V", "asBinder", "Landroid/os/IBinder;", "exitService", "pauseService", "postEventData", "type", "", "data", "postRecord", "record", "Lcom/tencent/mm/plugin/emoji/magicemoji/bean/WxaPkgRecordForME;", "postSurfaceCreate", "surface", "Landroid/view/Surface;", "width", "height", "postSurfaceDestroy", "postSurfaceUpdate", "registerCallback", "callback", "Lcom/tencent/mm/plugin/emoji/magicemoji/IMagicEmojiServiceCallback;", "unRegisterCallback", "wrapSafe", "r", "Lkotlin/Function0;", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.emoji.magicemoji.a
{
  private final kotlin.g.a.b<String, ah> xIW;
  private final com.tencent.mm.plugin.emoji.magicemoji.a xIk;
  
  public b(com.tencent.mm.plugin.emoji.magicemoji.a parama, kotlin.g.a.b<? super String, ah> paramb)
  {
    AppMethodBeat.i(270101);
    this.xIk = parama;
    this.xIW = paramb;
    AppMethodBeat.o(270101);
  }
  
  private final void aK(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(270106);
    try
    {
      parama.invoke();
      AppMethodBeat.o(270106);
      return;
    }
    catch (RemoteException parama)
    {
      kotlin.g.a.b localb = this.xIW;
      String str = parama.getMessage();
      parama = str;
      if (str == null) {
        parama = "unknown";
      }
      localb.invoke(parama);
      AppMethodBeat.o(270106);
    }
  }
  
  public final void a(final com.tencent.mm.plugin.emoji.magicemoji.b paramb)
  {
    AppMethodBeat.i(270175);
    s.u(paramb, "callback");
    aK((kotlin.g.a.a)new h(this, paramb));
    AppMethodBeat.o(270175);
  }
  
  public final void a(final WxaPkgRecordForME paramWxaPkgRecordForME)
  {
    AppMethodBeat.i(270157);
    s.u(paramWxaPkgRecordForME, "record");
    aK((kotlin.g.a.a)new d(this, paramWxaPkgRecordForME));
    AppMethodBeat.o(270157);
  }
  
  public final IBinder asBinder()
  {
    AppMethodBeat.i(270113);
    IBinder localIBinder = this.xIk.asBinder();
    AppMethodBeat.o(270113);
    return localIBinder;
  }
  
  public final void b(final com.tencent.mm.plugin.emoji.magicemoji.b paramb)
  {
    AppMethodBeat.i(270181);
    s.u(paramb, "callback");
    aK((kotlin.g.a.a)new i(this, paramb));
    AppMethodBeat.o(270181);
  }
  
  public final void bc(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(270125);
    s.u(paramString, "data");
    aK((kotlin.g.a.a)new c(this, paramInt, paramString));
    AppMethodBeat.o(270125);
  }
  
  public final void d(final Surface paramSurface, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(270133);
    s.u(paramSurface, "surface");
    aK((kotlin.g.a.a)new e(this, paramSurface, paramInt1, paramInt2));
    AppMethodBeat.o(270133);
  }
  
  public final void dyp()
  {
    AppMethodBeat.i(270149);
    aK((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(270149);
  }
  
  public final void dyq()
  {
    AppMethodBeat.i(270164);
    aK((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(270164);
  }
  
  public final void dyr()
  {
    AppMethodBeat.i(270170);
    aK((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(270170);
  }
  
  public final void gP(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(270140);
    aK((kotlin.g.a.a)new g(this, paramInt1, paramInt2));
    AppMethodBeat.o(270140);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(b paramb, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(b paramb, WxaPkgRecordForME paramWxaPkgRecordForME)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(b paramb, Surface paramSurface, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(b paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(b paramb, com.tencent.mm.plugin.emoji.magicemoji.b paramb1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(b paramb, com.tencent.mm.plugin.emoji.magicemoji.b paramb1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.core.a.b
 * JD-Core Version:    0.7.0.1
 */