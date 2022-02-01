package com.tencent.mm.emoji.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.mmdata.rpt.pi;
import com.tencent.mm.cp.f;
import com.tencent.mm.emoji.c.c;
import com.tencent.mm.emoji.c.m;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestWordsSync;", "", "()V", "requestRunning", "", "checkWordListUpdate", "", "updateWordList", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i mjW;
  private static boolean mjX;
  
  static
  {
    AppMethodBeat.i(242696);
    mjW = new i();
    AppMethodBeat.o(242696);
  }
  
  private static final Boolean a(pi parampi, b.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(242687);
    kotlin.g.b.s.u(parampi, "$report");
    int i = parama.errType;
    int j = parama.errCode;
    cjg localcjg = (cjg)parama.ott;
    String str = h.aUw();
    StringBuilder localStringBuilder = new StringBuilder("updateWordList: ").append(i).append(", ").append(j).append("; ");
    label120:
    long l;
    if (localcjg == null)
    {
      parama = localObject;
      Log.i(str, parama);
      mjX = false;
      parampi.jlI = Util.nowMilliSecond();
      if ((i != 0) || (j != 0)) {
        break label287;
      }
      parampi.jlJ = 1L;
      if (localcjg != null) {
        break label254;
      }
      i = 0;
      parampi.jlR = i;
      if (localcjg != null) {
        break label277;
      }
      l = 0L;
      label134:
      parampi.jlP = parampi.F("WordVersion", String.valueOf(l), true);
      if ((localcjg != null) && (localcjg.aarO.size() > 0))
      {
        parama = m.mhY;
        i = (int)Util.nowSecond();
        m.getKV().putInt("word_list_update_time", i);
        parama = localcjg.toByteArray();
        bl.jba().adjx.n("cache_type_words_list", parama);
        parama = g.mjS;
        g.aVE();
      }
    }
    for (;;)
    {
      boolean bool = parampi.bMH();
      AppMethodBeat.o(242687);
      return Boolean.valueOf(bool);
      LinkedList localLinkedList = localcjg.aarO;
      parama = localObject;
      if (localLinkedList == null) {
        break;
      }
      parama = Integer.valueOf(localLinkedList.size());
      break;
      label254:
      parama = localcjg.aarO;
      if (parama == null)
      {
        i = 0;
        break label120;
      }
      i = parama.size();
      break label120;
      label277:
      l = localcjg.aarQ;
      break label134;
      label287:
      parampi.jlJ = 2L;
    }
  }
  
  public static void aVG()
  {
    AppMethodBeat.i(242672);
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(242672);
      return;
    }
    d.d("EmojiSuggestWordsSync_checkWordListUpdate", (a)a.mjY);
    AppMethodBeat.o(242672);
  }
  
  public static void aVH()
  {
    AppMethodBeat.i(242678);
    pi localpi = new pi();
    localpi.jlH = Util.nowMilliSecond();
    new c().bFJ().g(new i..ExternalSyntheticLambda0(localpi));
    AppMethodBeat.o(242678);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    public static final a mjY;
    
    static
    {
      AppMethodBeat.i(242661);
      mjY = new a();
      AppMethodBeat.o(242661);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c.i
 * JD-Core Version:    0.7.0.1
 */