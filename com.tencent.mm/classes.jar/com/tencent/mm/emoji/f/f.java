package com.tencent.mm.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bl;
import java.io.IOException;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/util/EmojiUserDataUtil;", "", "()V", "addPurchase", "", "groupId", "", "isPurchased", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f mow;
  
  static
  {
    AppMethodBeat.i(242540);
    mow = new f();
    AppMethodBeat.o(242540);
  }
  
  public static final boolean Ey(String paramString)
  {
    AppMethodBeat.i(242536);
    kotlin.g.b.s.u(paramString, "groupId");
    boolean bool = l.aUF().mhV.ZtU.contains(paramString);
    AppMethodBeat.o(242536);
    return bool;
  }
  
  public static final void Ez(String paramString)
  {
    AppMethodBeat.i(242538);
    kotlin.g.b.s.u(paramString, "groupId");
    amz localamz = l.aUF().mhV;
    if (!localamz.ZtU.contains(paramString))
    {
      localamz.ZtU.add(paramString);
      paramString = l.aUF();
      try
      {
        paramString = paramString.mhV.toByteArray();
        bl.jba().adjx.n("cache_type_user_data", paramString);
        AppMethodBeat.o(242538);
        return;
      }
      catch (IOException paramString)
      {
        Log.printErrStackTrace("MicroMsg.EmojiStorageCache", paramString, "save user data error", new Object[0]);
      }
    }
    AppMethodBeat.o(242538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.f.f
 * JD-Core Version:    0.7.0.1
 */