package com.tencent.mm.plugin.game.chatroom.f;

import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.chatroom.b.b.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.j.b;
import com.tencent.mm.pluginsdk.ui.j.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d
  implements j.a, j.b
{
  final List<WeakReference<j>> ztn;
  private final j.a zto;
  
  public d(j.a parama)
  {
    AppMethodBeat.i(211057);
    this.ztn = new ArrayList();
    this.zto = parama;
    AppMethodBeat.o(211057);
  }
  
  static Pair<String, Boolean> aIS(String paramString)
  {
    AppMethodBeat.i(211059);
    paramString = new Pair(paramString, Boolean.valueOf(com.tencent.mm.plugin.game.chatroom.c.aIO(paramString)));
    AppMethodBeat.o(211059);
    return paramString;
  }
  
  public final void a(final j paramj)
  {
    AppMethodBeat.i(211063);
    if ((paramj instanceof f.a))
    {
      Object localObject = aIS(paramj.getTag());
      boolean bool = ((Boolean)((Pair)localObject).second).booleanValue();
      localObject = (String)((Pair)localObject).first;
      if (bool)
      {
        this.ztn.add(new WeakReference(paramj));
        AppMethodBeat.o(211063);
        return;
      }
      paramj.RcQ = new j.c()
      {
        public final boolean aDo(String paramAnonymousString)
        {
          AppMethodBeat.i(210687);
          if (this.iXL.equals(paramAnonymousString))
          {
            paramj.hjt();
            paramj.RcQ = null;
          }
          AppMethodBeat.o(210687);
          return true;
        }
      };
      this.zto.a(paramj);
    }
    AppMethodBeat.o(211063);
  }
  
  public final boolean aDn(String paramString)
  {
    return false;
  }
  
  public final Bitmap aaC()
  {
    AppMethodBeat.i(211062);
    Bitmap localBitmap = this.zto.aaC();
    AppMethodBeat.o(211062);
    return localBitmap;
  }
  
  public final Bitmap b(final String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(211058);
    Object localObject = aIS(paramString);
    paramString = (String)((Pair)localObject).first;
    if (((Boolean)((Pair)localObject).second).booleanValue())
    {
      localObject = ((com.tencent.mm.plugin.game.chatroom.b.b)h.ae(com.tencent.mm.plugin.game.chatroom.b.b.class)).aIN(paramString);
      if (localObject != null)
      {
        localObject = Util.nullAsNil(((com.tencent.mm.plugin.game.chatroom.b.c)localObject).Mm());
        e locale = e.CuH;
        localObject = (Bitmap)e.getLoader().bQ(new a((String)localObject)).aRw();
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          AppMethodBeat.o(211058);
          return localObject;
        }
      }
      ((com.tencent.mm.plugin.game.chatroom.b.b)h.ae(com.tencent.mm.plugin.game.chatroom.b.b.class)).a(paramString, new b.a()
      {
        public final void ac(Map<String, com.tencent.mm.plugin.game.chatroom.b.c> paramAnonymousMap)
        {
          AppMethodBeat.i(212309);
          paramAnonymousMap = (com.tencent.mm.plugin.game.chatroom.b.c)paramAnonymousMap.get(paramString);
          if (paramAnonymousMap == null)
          {
            Log.w("GameChatRoom.ChatRoomAvatarInterceptor", "get contact failed");
            AppMethodBeat.o(212309);
            return;
          }
          paramAnonymousMap = paramAnonymousMap.Mm();
          e locale = e.CuH;
          paramAnonymousMap = e.getLoader().bQ(new a(paramAnonymousMap));
          paramAnonymousMap.a(new com.tencent.mm.loader.f.e() {});
          paramAnonymousMap.aRr();
          AppMethodBeat.o(212309);
        }
      });
      AppMethodBeat.o(211058);
      return null;
    }
    paramString = this.zto.b(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(211058);
    return paramString;
  }
  
  public final Bitmap gJ(String paramString)
  {
    AppMethodBeat.i(211060);
    Pair localPair = aIS(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = b(paramString, 0, 0, 0);
      AppMethodBeat.o(211060);
      return paramString;
    }
    paramString = this.zto.gJ((String)localPair.first);
    AppMethodBeat.o(211060);
    return paramString;
  }
  
  public final Bitmap gK(String paramString)
  {
    AppMethodBeat.i(211061);
    Pair localPair = aIS(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = b(paramString, 0, 0, 0);
      AppMethodBeat.o(211061);
      return paramString;
    }
    paramString = this.zto.gK((String)localPair.first);
    AppMethodBeat.o(211061);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.f.d
 * JD-Core Version:    0.7.0.1
 */