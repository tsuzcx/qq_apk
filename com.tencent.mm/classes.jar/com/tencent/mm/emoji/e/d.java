package com.tencent.mm.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.protocal.protobuf.ajs;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/util/EmojiUserDataUtil;", "", "()V", "addPurchase", "", "groupId", "", "isPurchased", "", "plugin-emojisdk_release"})
public final class d
{
  public static final d jPE;
  
  static
  {
    AppMethodBeat.i(229725);
    jPE = new d();
    AppMethodBeat.o(229725);
  }
  
  public static boolean LS(String paramString)
  {
    AppMethodBeat.i(229720);
    p.k(paramString, "groupId");
    k localk = k.aBH();
    p.j(localk, "EmojiStorageCache.getInstance()");
    boolean bool = localk.aBI().Sug.contains(paramString);
    AppMethodBeat.o(229720);
    return bool;
  }
  
  public static void LT(String paramString)
  {
    AppMethodBeat.i(229722);
    p.k(paramString, "groupId");
    Object localObject = k.aBH();
    p.j(localObject, "EmojiStorageCache.getInstance()");
    localObject = ((k)localObject).aBI();
    if (!((ajs)localObject).Sug.contains(paramString))
    {
      ((ajs)localObject).Sug.add(paramString);
      k.aBH().aBJ();
    }
    AppMethodBeat.o(229722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.e.d
 * JD-Core Version:    0.7.0.1
 */