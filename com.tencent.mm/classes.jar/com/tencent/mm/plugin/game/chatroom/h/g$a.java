package com.tencent.mm.plugin.game.chatroom.h;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.chatroom.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class g$a
{
  public static g ak(View paramView, int paramInt)
  {
    AppMethodBeat.i(210996);
    Object localObject = d.Tp(paramInt);
    if (localObject == null)
    {
      paramView = new g(paramView, paramInt);
      AppMethodBeat.o(210996);
      return paramView;
    }
    try
    {
      localObject = ((Class)localObject).getDeclaredConstructor(new Class[] { View.class, Integer.TYPE });
      ((Constructor)localObject).setAccessible(true);
      paramView = (g)((Constructor)localObject).newInstance(new Object[] { paramView, Integer.valueOf(paramInt) });
      AppMethodBeat.o(210996);
      return paramView;
    }
    catch (NoSuchMethodException paramView)
    {
      Log.e("GameChatRoom.GameChatItemVH", "err_1:%s", new Object[] { paramView.getMessage() });
      AppMethodBeat.o(210996);
      return null;
    }
    catch (IllegalAccessException paramView)
    {
      for (;;)
      {
        Log.e("GameChatRoom.GameChatItemVH", "err_2:%s", new Object[] { paramView.getMessage() });
      }
    }
    catch (InstantiationException paramView)
    {
      for (;;)
      {
        Log.e("GameChatRoom.GameChatItemVH", "err_3:%s", new Object[] { paramView.getMessage() });
      }
    }
    catch (InvocationTargetException paramView)
    {
      for (;;)
      {
        Log.e("GameChatRoom.GameChatItemVH", "err_4:%s", new Object[] { paramView.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.h.g.a
 * JD-Core Version:    0.7.0.1
 */