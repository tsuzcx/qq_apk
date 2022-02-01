package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.emoji.a.e;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.ba.a;
import com.tencent.mm.vending.c.a;
import d.g.b.q;
import d.l;
import d.z;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "designerUin", "", "(I)V", "TAG", "", "cgiTask", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "getDesignerUin", "()I", "call", "", "uniqueId", "CgiGetDesignerTask", "plugin-emojisdk_release"})
public final class b
  extends c
{
  private final String TAG;
  final int gjN;
  private final a goQ;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(183974);
    this.gjN = paramInt;
    this.TAG = "MicroMsg.EmojiDesignerTask";
    this.goQ = new a(this.gjN, (d.g.a.b)new b(this));
    AppMethodBeat.o(183974);
  }
  
  public final String aeK()
  {
    AppMethodBeat.i(183973);
    int i = this.gjN;
    AppMethodBeat.o(183973);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(183972);
    ad.i(this.TAG, "call: " + this.gjN);
    this.goQ.agc();
    AppMethodBeat.o(183972);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "", "designerUin", "", "callback", "Lkotlin/Function1;", "", "", "(ILkotlin/jvm/functions/Function1;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "dbList", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getDesignerUin", "()I", "packList", "Ljava/util/LinkedList;", "reqBuff", "", "finish", "getNext", "start", "plugin-emojisdk_release"})
  public static final class a
  {
    final String TAG;
    final d.g.a.b<Boolean, z> giK;
    private final int gjN;
    byte[] gjO;
    final LinkedList<String> goR;
    private final ba goS;
    
    public a(int paramInt, d.g.a.b<? super Boolean, z> paramb)
    {
      AppMethodBeat.i(183969);
      this.gjN = paramInt;
      this.giK = paramb;
      this.TAG = "MicroMsg.EmojiDesignerTask";
      this.goR = new LinkedList();
      paramb = ba.a.IKU;
      this.goS = ba.a.aaS(this.gjN);
      AppMethodBeat.o(183969);
    }
    
    final void agc()
    {
      AppMethodBeat.i(183968);
      new e(this.gjN, this.gjO).aED().g((a)new a(this));
      AppMethodBeat.o(183968);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetPersonalDesignerResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
    static final class a<_Ret, _Var>
      implements a<_Ret, _Var>
    {
      a(b.a parama) {}
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "success", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<Boolean, z>
  {
    b(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.b
 * JD-Core Version:    0.7.0.1
 */