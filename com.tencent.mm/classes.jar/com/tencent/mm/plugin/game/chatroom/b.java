package com.tencent.mm.plugin.game.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.Color;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgOptions;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  public static Map<String, a> IdP;
  public static boolean IdQ;
  public static String IdR;
  public static boolean IdS;
  public static boolean IdT;
  
  static
  {
    AppMethodBeat.i(275617);
    IdP = new HashMap();
    IdQ = false;
    IdS = false;
    IdT = false;
    AppMethodBeat.o(275617);
  }
  
  public static final class a
  {
    public boolean IdU = false;
    public boolean IdV = false;
  }
  
  public static final class b
  {
    public long IdW = -1L;
    public long IdX = -1L;
    public long IdY = 0L;
    public long eRP = 0L;
    
    public final void reset()
    {
      this.IdW = -1L;
      this.eRP = 0L;
      this.IdX = -1L;
      this.IdY = 0L;
    }
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(275687);
      IdZ = new c("KEEP_ALIVE_TYPE_RECEIVE_CHATROOM_MSG", 0);
      Iea = new c("KEEP_ALIVE_TYPE_GET_CHATROOM_REALTIME_INFO", 1);
      Ieb = new c("KEEP_ALIVE_TYPE_GET_MY_CHAT_ROOM", 2);
      Iec = new c[] { IdZ, Iea, Ieb };
      AppMethodBeat.o(275687);
    }
    
    private c() {}
  }
  
  public static final class d
  {
    public String Ied;
    public MsgOptions Iee;
    public MsgContent Ief;
    public int channelId;
    public String hBy;
    public int msgType;
    public String userName;
    
    public d()
    {
      AppMethodBeat.i(275669);
      this.Iee = new MsgOptions();
      this.Ief = new MsgContent();
      AppMethodBeat.o(275669);
    }
  }
  
  public static final class e
  {
    public Color Ieg;
    public String iconUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.b
 * JD-Core Version:    0.7.0.1
 */