package com.tencent.mm.plugin.game.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.chatroom.i.a;
import com.tencent.mm.plugin.game.chatroom.i.b;
import com.tencent.mm.plugin.game.chatroom.i.c;
import com.tencent.mm.plugin.game.chatroom.i.e;
import com.tencent.mm.plugin.game.chatroom.i.f;
import com.tencent.mm.plugin.game.chatroom.i.g;
import com.tencent.mm.plugin.game.chatroom.i.h;
import com.tencent.mm.plugin.game.chatroom.i.i;
import com.tencent.mm.plugin.game.chatroom.i.j;
import com.tencent.mm.plugin.game.chatroom.i.k;
import java.util.LinkedHashMap;
import java.util.Map;

public final class d
{
  private static Map<Integer, Class<? extends k>> Ieh;
  
  static
  {
    AppMethodBeat.i(275639);
    Ieh = new LinkedHashMap();
    b(0, j.class);
    b(10000, h.class);
    b(10001, a.class);
    b(10002, i.class);
    b(10003, g.class);
    b(10004, e.class);
    b(10005, b.class);
    b(10006, com.tencent.mm.plugin.game.chatroom.i.d.class);
    b(10007, f.class);
    b(10008, c.class);
    AppMethodBeat.o(275639);
  }
  
  public static Class<? extends k> Xa(int paramInt)
  {
    AppMethodBeat.i(275616);
    Class localClass = (Class)Ieh.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(275616);
    return localClass;
  }
  
  public static int Xb(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 10000: 
    case 10001: 
    case 10002: 
    case 10005: 
    case 10006: 
    case 10007: 
    case 10008: 
    default: 
      return 1;
    case 10003: 
      return 2;
    }
    return 3;
  }
  
  private static void b(int paramInt, Class<? extends k> paramClass)
  {
    AppMethodBeat.i(275633);
    if (!Ieh.containsKey(Integer.valueOf(paramInt))) {
      Ieh.put(Integer.valueOf(paramInt), paramClass);
    }
    AppMethodBeat.o(275633);
  }
  
  public static int jc(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return 10000;
    }
    if (paramInt1 == 47) {
      return 10005;
    }
    if (paramInt1 == 32) {}
    switch (paramInt2)
    {
    default: 
      return 0;
    case 1: 
      return 10001;
    case 2: 
      return 10002;
    case 3: 
      return 10003;
    case 4: 
      return 10004;
    case 5: 
      return 10006;
    case 6: 
      return 10007;
    }
    return 10008;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.d
 * JD-Core Version:    0.7.0.1
 */