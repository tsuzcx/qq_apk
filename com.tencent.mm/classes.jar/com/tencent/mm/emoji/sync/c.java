package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.a.ty;
import com.tencent.mm.cp.f;
import com.tencent.mm.emoji.c.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.a;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "designerUin", "", "(I)V", "TAG", "", "cgiTask", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "getDesignerUin", "()I", "call", "", "uniqueId", "CgiGetDesignerTask", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.loader.f.c
{
  private final String TAG;
  final int mhB;
  private final a mmC;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(183974);
    this.mhB = paramInt;
    this.TAG = "MicroMsg.EmojiDesignerTask";
    this.mmC = new a(this.mhB, (kotlin.g.a.b)new b(this));
    AppMethodBeat.o(183974);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(183973);
    int i = this.mhB;
    AppMethodBeat.o(183973);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(183972);
    Log.i(this.TAG, s.X("call: ", Integer.valueOf(this.mhB)));
    this.mmC.start();
    AppMethodBeat.o(183972);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "", "designerUin", "", "callback", "Lkotlin/Function1;", "", "", "(ILkotlin/jvm/functions/Function1;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "dbList", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getDesignerUin", "()I", "packList", "Ljava/util/LinkedList;", "reqBuff", "", "finish", "getNext", "start", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private final String TAG;
    private final kotlin.g.a.b<Boolean, ah> callback;
    private final int mhB;
    private byte[] mhC;
    private final LinkedList<String> mmD;
    private final bi mmE;
    
    public a(int paramInt, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      AppMethodBeat.i(183969);
      this.mhB = paramInt;
      this.callback = paramb;
      this.TAG = "MicroMsg.EmojiDesignerTask";
      this.mmD = new LinkedList();
      paramb = bi.a.adiZ;
      this.mmE = bi.a.ayV(this.mhB);
      AppMethodBeat.o(183969);
    }
    
    private static final ah a(a parama, b.a parama1)
    {
      AppMethodBeat.i(242629);
      s.u(parama, "this$0");
      int i = parama1.errType;
      int j = parama1.errCode;
      Log.i(parama.TAG, "getNext: " + i + ", " + j);
      parama1 = (cps)parama1.ott;
      Object localObject;
      if ((i == 0) && (j == 0))
      {
        if (parama1 != null)
        {
          parama1 = parama1.Zvf;
          if (parama1 != null)
          {
            parama1 = ((Iterable)parama1).iterator();
            while (parama1.hasNext())
            {
              localObject = (cjb)parama1.next();
              parama.mmD.add(((cjb)localObject).ProductID);
            }
          }
        }
        parama.finish();
        parama = ah.aiuX;
        AppMethodBeat.o(242629);
        return parama;
      }
      if ((i == 4) && (j == 2))
      {
        if (parama1 != null)
        {
          localObject = parama1.Zvf;
          if (localObject != null)
          {
            localObject = ((Iterable)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              cjb localcjb = (cjb)((Iterator)localObject).next();
              parama.mmD.add(localcjb.ProductID);
            }
          }
        }
        if (parama1 == null)
        {
          parama1 = null;
          parama.mhC = w.a(parama1);
          if (parama.mhC != null) {
            break label262;
          }
          parama.finish();
        }
        for (;;)
        {
          parama = ah.aiuX;
          AppMethodBeat.o(242629);
          return parama;
          parama1 = parama1.YGU;
          break;
          label262:
          parama.aWf();
        }
      }
      parama = parama.callback;
      if (parama == null)
      {
        AppMethodBeat.o(242629);
        return null;
      }
      parama.invoke(Boolean.FALSE);
      parama = ah.aiuX;
      AppMethodBeat.o(242629);
      return parama;
    }
    
    private final void aWf()
    {
      AppMethodBeat.i(183968);
      new e(this.mhB, this.mhC).bFJ().g(new c.a..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(183968);
    }
    
    private final void finish()
    {
      AppMethodBeat.i(242627);
      bi localbi = new bi();
      int j = (int)Util.nowSecond();
      localbi.mhB = this.mhB;
      Log.i(this.TAG, "finish: " + this.mhB + ", " + this.mmD.size() + ", oldSize " + this.mmE.Eib.size());
      Iterator localIterator1 = ((Iterable)this.mmD).iterator();
      int i = 0;
      if (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        a locala = new a();
        locala.field_designerUin = this.mhB;
        locala.field_productId = str;
        locala.field_syncTime = 0;
        if (!this.mmE.Eib.isEmpty())
        {
          Iterator localIterator2 = ((Iterable)this.mmE.Eib).iterator();
          while (localIterator2.hasNext())
          {
            localObject = localIterator2.next();
            if (s.p(((a)localObject).field_productId, str))
            {
              label219:
              localObject = (a)localObject;
              if (localObject != null) {
                break label255;
              }
              locala.field_syncTime = j;
              i = 1;
            }
          }
        }
        for (;;)
        {
          localbi.Eib.add(locala);
          break;
          localObject = null;
          break label219;
          label255:
          locala.field_syncTime = ((a)localObject).field_syncTime;
          continue;
          i = 1;
        }
      }
      if (i != 0)
      {
        bl.jba().adjH.a(localbi);
        localObject = bi.a.adiZ;
        bi.a.a(this.mhB, localbi);
        new ty().publish();
      }
      Object localObject = this.callback;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(Boolean.TRUE);
      }
      AppMethodBeat.o(242627);
    }
    
    public final void start()
    {
      AppMethodBeat.i(242633);
      aWf();
      AppMethodBeat.o(242633);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.c
 * JD-Core Version:    0.7.0.1
 */