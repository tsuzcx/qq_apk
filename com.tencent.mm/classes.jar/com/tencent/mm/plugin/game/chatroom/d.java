package com.tencent.mm.plugin.game.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.chatroom.h.a;
import com.tencent.mm.plugin.game.chatroom.h.b;
import com.tencent.mm.plugin.game.chatroom.h.c;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.chatroom.h.g;
import java.util.LinkedHashMap;
import java.util.Map;

public final class d
{
  private static Map<Integer, Class<? extends g>> CrR;
  
  static
  {
    AppMethodBeat.i(211113);
    CrR = new LinkedHashMap();
    a(0, f.class);
    a(10000, com.tencent.mm.plugin.game.chatroom.h.d.class);
    a(10001, a.class);
    a(10002, e.class);
    a(10003, c.class);
    a(10004, b.class);
    AppMethodBeat.o(211113);
  }
  
  public static Class<? extends g> Tp(int paramInt)
  {
    AppMethodBeat.i(211109);
    Class localClass = (Class)CrR.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(211109);
    return localClass;
  }
  
  public static int Tq(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 10000: 
    case 10001: 
    case 10002: 
    default: 
      return 1;
    case 10003: 
      return 2;
    }
    return 3;
  }
  
  private static void a(int paramInt, Class<? extends g> paramClass)
  {
    AppMethodBeat.i(211112);
    if (!CrR.containsKey(Integer.valueOf(paramInt))) {
      CrR.put(Integer.valueOf(paramInt), paramClass);
    }
    AppMethodBeat.o(211112);
  }
  
  public static int hC(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return 10000;
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
    }
    return 10004;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.d
 * JD-Core Version:    0.7.0.1
 */