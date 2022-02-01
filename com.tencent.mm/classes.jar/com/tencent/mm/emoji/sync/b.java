package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.emoji.a.d;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vending.c.a;
import d.y;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "designerUin", "", "(I)V", "TAG", "", "cgiTask", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "getDesignerUin", "()I", "call", "", "uniqueId", "CgiGetDesignerTask", "plugin-emojisdk_release"})
public final class b
  extends c
{
  private final String TAG;
  final int fMB;
  private final a fRs;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(183974);
    this.fMB = paramInt;
    this.TAG = "MicroMsg.EmojiDesignerTask";
    this.fRs = new a(this.fMB, (d.g.a.b)new b(this));
    AppMethodBeat.o(183974);
  }
  
  public final String abi()
  {
    AppMethodBeat.i(183973);
    int i = this.fMB;
    AppMethodBeat.o(183973);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(183972);
    ad.i(this.TAG, "call: " + this.fMB);
    this.fRs.acq();
    AppMethodBeat.o(183972);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "", "designerUin", "", "callback", "Lkotlin/Function1;", "", "", "(ILkotlin/jvm/functions/Function1;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "dbList", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getDesignerUin", "()I", "packList", "Ljava/util/LinkedList;", "reqBuff", "", "finish", "getNext", "start", "plugin-emojisdk_release"})
  public static final class a
  {
    final String TAG;
    final d.g.a.b<Boolean, y> fLy;
    private final int fMB;
    byte[] fMC;
    final LinkedList<String> fRt;
    private final at fRu;
    
    public a(int paramInt, d.g.a.b<? super Boolean, y> paramb)
    {
      AppMethodBeat.i(183969);
      this.fMB = paramInt;
      this.fLy = paramb;
      this.TAG = "MicroMsg.EmojiDesignerTask";
      this.fRt = new LinkedList();
      paramb = at.a.FyF;
      this.fRu = at.a.Wz(this.fMB);
      AppMethodBeat.o(183969);
    }
    
    final void acq()
    {
      AppMethodBeat.i(183968);
      new d(this.fMB, this.fMC).auK().g((a)new a(this));
      AppMethodBeat.o(183968);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetPersonalDesignerResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;)Lkotlin/Unit;"})
    static final class a<_Ret, _Var>
      implements a<_Ret, _Var>
    {
      a(b.a parama) {}
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "success", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
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