package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.protocal.protobuf.agu;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/util/EmojiUserDataUtil;", "", "()V", "addPurchase", "", "groupId", "", "isPurchased", "", "plugin-emojisdk_release"})
public final class d
{
  public static final d gsN;
  
  static
  {
    AppMethodBeat.i(188614);
    gsN = new d();
    AppMethodBeat.o(188614);
  }
  
  public static boolean wJ(String paramString)
  {
    AppMethodBeat.i(188612);
    p.h(paramString, "groupId");
    i locali = i.aeX();
    p.g(locali, "EmojiStorageCache.getInstance()");
    boolean bool = locali.aeY().Gxb.contains(paramString);
    AppMethodBeat.o(188612);
    return bool;
  }
  
  public static void wK(String paramString)
  {
    AppMethodBeat.i(188613);
    p.h(paramString, "groupId");
    Object localObject = i.aeX();
    p.g(localObject, "EmojiStorageCache.getInstance()");
    localObject = ((i)localObject).aeY();
    if (!((agu)localObject).Gxb.contains(paramString))
    {
      ((agu)localObject).Gxb.add(paramString);
      i.aeX().aeZ();
    }
    AppMethodBeat.o(188613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.d.d
 * JD-Core Version:    0.7.0.1
 */