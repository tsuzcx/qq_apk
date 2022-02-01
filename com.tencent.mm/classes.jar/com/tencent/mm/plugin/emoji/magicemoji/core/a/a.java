package com.tencent.mm.plugin.emoji.magicemoji.core.a;

import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/core/wrapper/MagicEmojiServiceCallbackSafeWrapper;", "Lcom/tencent/mm/plugin/emoji/magicemoji/IMagicEmojiServiceCallback;", "callback", "errorCallback", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/plugin/emoji/magicemoji/IMagicEmojiServiceCallback;Lkotlin/jvm/functions/Function1;)V", "asBinder", "Landroid/os/IBinder;", "invoke", "type", "", "data", "onServiceCreate", "onServiceDestroy", "reason", "onServicePause", "onServicePlayed", "onServiceResume", "onServiceStart", "wrapSafe", "r", "Lkotlin/Function0;", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.emoji.magicemoji.b
{
  private final com.tencent.mm.plugin.emoji.magicemoji.b xIQ;
  private final kotlin.g.a.b<String, ah> xIW;
  
  public a(com.tencent.mm.plugin.emoji.magicemoji.b paramb, kotlin.g.a.b<? super String, ah> paramb1)
  {
    AppMethodBeat.i(270095);
    this.xIQ = paramb;
    this.xIW = paramb1;
    AppMethodBeat.o(270095);
  }
  
  private final void aK(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(270102);
    try
    {
      parama.invoke();
      AppMethodBeat.o(270102);
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
      AppMethodBeat.o(270102);
    }
  }
  
  public final void Kk(final int paramInt)
  {
    AppMethodBeat.i(270161);
    aK((kotlin.g.a.a)new b(this, paramInt));
    AppMethodBeat.o(270161);
  }
  
  public final IBinder asBinder()
  {
    AppMethodBeat.i(270108);
    IBinder localIBinder = this.xIQ.asBinder();
    AppMethodBeat.o(270108);
    return localIBinder;
  }
  
  public final String bd(int paramInt, String paramString)
  {
    AppMethodBeat.i(270117);
    s.u(paramString, "data");
    try
    {
      paramString = this.xIQ.bd(paramInt, paramString);
      AppMethodBeat.o(270117);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        kotlin.g.a.b localb = this.xIW;
        String str = paramString.getMessage();
        paramString = str;
        if (str == null) {
          paramString = "unknown";
        }
        localb.invoke(paramString);
        paramString = null;
      }
    }
  }
  
  public final void dyt()
  {
    AppMethodBeat.i(270124);
    aK((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(270124);
  }
  
  public final void dyu()
  {
    AppMethodBeat.i(270131);
    aK((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(270131);
  }
  
  public final void dyv()
  {
    AppMethodBeat.i(270138);
    aK((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(270138);
  }
  
  public final void dyw()
  {
    AppMethodBeat.i(270147);
    aK((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(270147);
  }
  
  public final void dyx()
  {
    AppMethodBeat.i(270153);
    aK((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(270153);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(a parama, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.core.a.a
 * JD-Core Version:    0.7.0.1
 */