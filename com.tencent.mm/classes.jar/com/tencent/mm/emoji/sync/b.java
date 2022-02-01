package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bg.a;
import com.tencent.mm.vending.c.a;
import java.util.LinkedList;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "designerUin", "", "(I)V", "TAG", "", "cgiTask", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "getDesignerUin", "()I", "call", "", "uniqueId", "CgiGetDesignerTask", "plugin-emojisdk_release"})
public final class b
  extends c
{
  private final String TAG;
  final int gWW;
  private final a hcw;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(183974);
    this.gWW = paramInt;
    this.TAG = "MicroMsg.EmojiDesignerTask";
    this.hcw = new a(this.gWW, (kotlin.g.a.b)new b(this));
    AppMethodBeat.o(183974);
  }
  
  public final String auK()
  {
    AppMethodBeat.i(183973);
    int i = this.gWW;
    AppMethodBeat.o(183973);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(183972);
    Log.i(this.TAG, "call: " + this.gWW);
    this.hcw.awg();
    AppMethodBeat.o(183972);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "", "designerUin", "", "callback", "Lkotlin/Function1;", "", "", "(ILkotlin/jvm/functions/Function1;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "dbList", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getDesignerUin", "()I", "packList", "Ljava/util/LinkedList;", "reqBuff", "", "finish", "getNext", "start", "plugin-emojisdk_release"})
  public static final class a
  {
    final String TAG;
    final kotlin.g.a.b<Boolean, x> callback;
    private final int gWW;
    byte[] gWX;
    final LinkedList<String> hcx;
    private final bg hcy;
    
    public a(int paramInt, kotlin.g.a.b<? super Boolean, x> paramb)
    {
      AppMethodBeat.i(183969);
      this.gWW = paramInt;
      this.callback = paramb;
      this.TAG = "MicroMsg.EmojiDesignerTask";
      this.hcx = new LinkedList();
      paramb = bg.a.Opu;
      this.hcy = bg.a.aki(this.gWW);
      AppMethodBeat.o(183969);
    }
    
    final void awg()
    {
      AppMethodBeat.i(183968);
      new e(this.gWW, this.gWX).aYI().g((a)new a(this));
      AppMethodBeat.o(183968);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetPersonalDesignerResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
    static final class a<_Ret, _Var>
      implements a<_Ret, _Var>
    {
      a(b.a parama) {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    b(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.b
 * JD-Core Version:    0.7.0.1
 */