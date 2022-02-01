package com.tencent.mm.plugin.game.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f
{
  Map<String, List<Object>> Iei;
  public com.tencent.mm.am.h Iej;
  
  private f()
  {
    AppMethodBeat.i(275612);
    this.Iei = new HashMap();
    this.Iej = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(275707);
        if ((Util.isEqual(paramAnonymousp.getType(), 697)) && ((paramAnonymousp instanceof e)))
        {
          paramAnonymousString = (e)paramAnonymousp;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = paramAnonymousString.dAy();
            if ((paramAnonymousString != null) && (!Util.isNullOrNil(paramAnonymousString.YMz)))
            {
              paramAnonymousString = paramAnonymousString.YMz.iterator();
              while (paramAnonymousString.hasNext())
              {
                Object localObject = (amn)paramAnonymousString.next();
                paramAnonymousp = f.this;
                localObject = ((amn)localObject).Md5;
                if (!Util.isNullOrNil((String)localObject))
                {
                  paramAnonymousp = (List)paramAnonymousp.Iei.get(localObject);
                  if (!Util.isNullOrNil(paramAnonymousp))
                  {
                    paramAnonymousp = paramAnonymousp.iterator();
                    while (paramAnonymousp.hasNext()) {
                      paramAnonymousp.next();
                    }
                  }
                }
              }
            }
          }
        }
        AppMethodBeat.o(275707);
      }
    };
    AppMethodBeat.o(275612);
  }
  
  public static String gP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(275619);
    if (Util.isNullOrNil(paramString1))
    {
      if (paramString2 == null)
      {
        AppMethodBeat.o(275619);
        return "";
      }
      AppMethodBeat.o(275619);
      return paramString2;
    }
    AppMethodBeat.o(275619);
    return paramString1;
  }
  
  public final void release()
  {
    AppMethodBeat.i(275628);
    com.tencent.mm.kernel.h.baD().mCm.b(697, this.Iej);
    this.Iei.clear();
    AppMethodBeat.o(275628);
  }
  
  public static final class a
  {
    private static f Iel;
    
    static
    {
      AppMethodBeat.i(275659);
      Iel = new f((byte)0);
      AppMethodBeat.o(275659);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.f
 * JD-Core Version:    0.7.0.1
 */