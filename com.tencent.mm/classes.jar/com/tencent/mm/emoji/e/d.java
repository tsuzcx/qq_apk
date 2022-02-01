package com.tencent.mm.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.protocal.protobuf.ajd;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/util/EmojiUserDataUtil;", "", "()V", "addPurchase", "", "groupId", "", "isPurchased", "", "plugin-emojisdk_release"})
public final class d
{
  public static final d hdY;
  
  static
  {
    AppMethodBeat.i(200014);
    hdY = new d();
    AppMethodBeat.o(200014);
  }
  
  public static boolean EZ(String paramString)
  {
    AppMethodBeat.i(200012);
    p.h(paramString, "groupId");
    j localj = j.auL();
    p.g(localj, "EmojiStorageCache.getInstance()");
    boolean bool = localj.auM().LsH.contains(paramString);
    AppMethodBeat.o(200012);
    return bool;
  }
  
  public static void Fa(String paramString)
  {
    AppMethodBeat.i(200013);
    p.h(paramString, "groupId");
    Object localObject = j.auL();
    p.g(localObject, "EmojiStorageCache.getInstance()");
    localObject = ((j)localObject).auM();
    if (!((ajd)localObject).LsH.contains(paramString))
    {
      ((ajd)localObject).LsH.add(paramString);
      j.auL().auN();
    }
    AppMethodBeat.o(200013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.e.d
 * JD-Core Version:    0.7.0.1
 */