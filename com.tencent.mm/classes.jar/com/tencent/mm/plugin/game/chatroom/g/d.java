package com.tencent.mm.plugin.game.chatroom.g;

import android.graphics.Bitmap;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelavatar.AvatarStorage.a;
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
  final List<WeakReference<j>> Exg;
  private final j.a Exh;
  
  public d(j.a parama)
  {
    AppMethodBeat.i(275871);
    this.Exg = new ArrayList();
    this.Exh = parama;
    AppMethodBeat.o(275871);
  }
  
  static Pair<String, Boolean> aFz(String paramString)
  {
    AppMethodBeat.i(275877);
    paramString = new Pair(paramString, Boolean.valueOf(com.tencent.mm.plugin.game.chatroom.c.aFp(paramString)));
    AppMethodBeat.o(275877);
    return paramString;
  }
  
  final void a(com.tencent.mm.loader.a.b<a, Bitmap> paramb)
  {
    AppMethodBeat.i(275892);
    paramb.a(new com.tencent.mm.loader.e.e() {});
    paramb.blg();
    AppMethodBeat.o(275892);
  }
  
  public final void a(final j paramj)
  {
    AppMethodBeat.i(275917);
    if ((paramj instanceof AvatarStorage.a))
    {
      Object localObject = aFz(paramj.getTag());
      boolean bool = ((Boolean)((Pair)localObject).second).booleanValue();
      localObject = (String)((Pair)localObject).first;
      if (bool)
      {
        this.Exg.add(new WeakReference(paramj));
        AppMethodBeat.o(275917);
        return;
      }
      paramj.XYW = new j.c()
      {
        public final boolean ayJ(String paramAnonymousString)
        {
          AppMethodBeat.i(275880);
          if (this.lzH.equals(paramAnonymousString))
          {
            paramj.iKl();
            paramj.XYW = null;
          }
          AppMethodBeat.o(275880);
          return true;
        }
      };
      this.Exh.a(paramj);
    }
    AppMethodBeat.o(275917);
  }
  
  public final Bitmap aCj()
  {
    AppMethodBeat.i(275908);
    Bitmap localBitmap = this.Exh.aCj();
    AppMethodBeat.o(275908);
    return localBitmap;
  }
  
  public final boolean ayI(String paramString)
  {
    return false;
  }
  
  public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(275887);
    paramString = aFz(paramString);
    final String str = (String)paramString.first;
    if (((Boolean)paramString.second).booleanValue())
    {
      paramString = ((com.tencent.mm.plugin.game.chatroom.b.b)h.ax(com.tencent.mm.plugin.game.chatroom.b.b.class)).aFo(str);
      if (paramString != null) {
        paramString = Util.nullAsNil(paramString.amx());
      }
    }
    for (;;)
    {
      Log.i("ChatroomMemberPreloadManager.avatar", "AvatarUrl =  ".concat(String.valueOf(paramString)));
      if (paramString != null)
      {
        Object localObject = e.IkF;
        paramString = e.getLoader().dk(new a(paramString));
        localObject = (Bitmap)paramString.bll();
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          AppMethodBeat.o(275887);
          return localObject;
          paramString = ((com.tencent.mm.plugin.game.chatroom.f.d)h.ax(com.tencent.mm.plugin.game.chatroom.f.d.class)).SV(str);
          if (!Util.isNullOrNil(paramString)) {
            paramString = Util.nullAsNil(((com.tencent.mm.plugin.game.chatroom.f.c)paramString.get(0)).field_avatarURL);
          }
        }
        else
        {
          a(paramString);
        }
      }
      else
      {
        ((com.tencent.mm.plugin.game.chatroom.b.b)h.ax(com.tencent.mm.plugin.game.chatroom.b.b.class)).a(str, new b.a()
        {
          public final void onDone(Map<String, com.tencent.mm.plugin.game.chatroom.b.c> paramAnonymousMap)
          {
            AppMethodBeat.i(275878);
            paramAnonymousMap = (com.tencent.mm.plugin.game.chatroom.b.c)paramAnonymousMap.get(str);
            if (paramAnonymousMap == null)
            {
              Log.w("GameChatRoom.ChatRoomAvatarInterceptor", "get contact failed");
              AppMethodBeat.o(275878);
              return;
            }
            paramAnonymousMap = paramAnonymousMap.amx();
            e locale = e.IkF;
            paramAnonymousMap = e.getLoader().dk(new a(paramAnonymousMap));
            d.this.a(paramAnonymousMap);
            AppMethodBeat.o(275878);
          }
        });
        AppMethodBeat.o(275887);
        return null;
        paramString = this.Exh.b(str, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(275887);
        return paramString;
      }
      paramString = null;
    }
  }
  
  public final Bitmap ik(String paramString)
  {
    AppMethodBeat.i(275902);
    Pair localPair = aFz(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = b(paramString, 0, 0, 0);
      AppMethodBeat.o(275902);
      return paramString;
    }
    paramString = this.Exh.ik((String)localPair.first);
    AppMethodBeat.o(275902);
    return paramString;
  }
  
  public final Bitmap loadBitmap(String paramString)
  {
    AppMethodBeat.i(275895);
    Pair localPair = aFz(paramString);
    if (((Boolean)localPair.second).booleanValue())
    {
      paramString = b(paramString, 0, 0, 0);
      AppMethodBeat.o(275895);
      return paramString;
    }
    paramString = this.Exh.loadBitmap((String)localPair.first);
    AppMethodBeat.o(275895);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.g.d
 * JD-Core Version:    0.7.0.1
 */