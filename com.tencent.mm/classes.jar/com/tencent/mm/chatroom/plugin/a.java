package com.tencent.mm.chatroom.plugin;

import com.tencent.mm.chatroom.b;
import com.tencent.mm.model.p;

public final class a
  extends p
{
  private static a dnl;
  
  public a()
  {
    super(b.class);
  }
  
  public static a xh()
  {
    try
    {
      if (dnl == null) {
        dnl = new a();
      }
      a locala = dnl;
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.plugin.a
 * JD-Core Version:    0.7.0.1
 */