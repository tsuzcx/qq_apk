package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.emoji.a.e;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.aw.a;
import com.tencent.mm.vending.c.a;
import d.y;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "designerUin", "", "(I)V", "TAG", "", "cgiTask", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "getDesignerUin", "()I", "call", "", "uniqueId", "CgiGetDesignerTask", "plugin-emojisdk_release"})
public final class b
  extends c
{
  private final String TAG;
  final int fQn;
  private final a fVn;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(183974);
    this.fQn = paramInt;
    this.TAG = "MicroMsg.EmojiDesignerTask";
    this.fVn = new a(this.fQn, (d.g.a.b)new b(this));
    AppMethodBeat.o(183974);
  }
  
  public final String acg()
  {
    AppMethodBeat.i(183973);
    int i = this.fQn;
    AppMethodBeat.o(183973);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(183972);
    ac.i(this.TAG, "call: " + this.fQn);
    this.fVn.adw();
    AppMethodBeat.o(183972);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "", "designerUin", "", "callback", "Lkotlin/Function1;", "", "", "(ILkotlin/jvm/functions/Function1;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "dbList", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getDesignerUin", "()I", "packList", "Ljava/util/LinkedList;", "reqBuff", "", "finish", "getNext", "start", "plugin-emojisdk_release"})
  public static final class a
  {
    final String TAG;
    final d.g.a.b<Boolean, y> fPk;
    private final int fQn;
    byte[] fQo;
    final LinkedList<String> fVo;
    private final aw fVp;
    
    public a(int paramInt, d.g.a.b<? super Boolean, y> paramb)
    {
      AppMethodBeat.i(183969);
      this.fQn = paramInt;
      this.fPk = paramb;
      this.TAG = "MicroMsg.EmojiDesignerTask";
      this.fVo = new LinkedList();
      paramb = aw.a.GXG;
      this.fVp = aw.a.YJ(this.fQn);
      AppMethodBeat.o(183969);
    }
    
    final void adw()
    {
      AppMethodBeat.i(183968);
      new e(this.fQn, this.fQo).aBB().g((a)new a(this));
      AppMethodBeat.o(183968);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetPersonalDesignerResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;)Lkotlin/Unit;"})
    static final class a<_Ret, _Var>
      implements a<_Ret, _Var>
    {
      a(b.a parama) {}
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "success", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.b
 * JD-Core Version:    0.7.0.1
 */