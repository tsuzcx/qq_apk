package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Channel
  extends com.tencent.mm.bx.a
{
  public String cant_send_reason;
  public int channel_id;
  public String desc;
  public String name;
  public boolean read_only;
  public long unread_msg_count;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275502);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.channel_id);
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      paramVarArgs.di(3, this.read_only);
      if (this.cant_send_reason != null) {
        paramVarArgs.g(4, this.cant_send_reason);
      }
      if (this.desc != null) {
        paramVarArgs.g(5, this.desc);
      }
      paramVarArgs.bv(6, this.unread_msg_count);
      AppMethodBeat.o(275502);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.channel_id) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.name);
      }
      i = paramInt + (i.a.a.b.b.a.ko(3) + 1);
      paramInt = i;
      if (this.cant_send_reason != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.cant_send_reason);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.desc);
      }
      paramInt = i.a.a.b.b.a.q(6, this.unread_msg_count);
      AppMethodBeat.o(275502);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275502);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      Channel localChannel = (Channel)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(275502);
        return -1;
      case 1: 
        localChannel.channel_id = locala.ajGk.aar();
        AppMethodBeat.o(275502);
        return 0;
      case 2: 
        localChannel.name = locala.ajGk.readString();
        AppMethodBeat.o(275502);
        return 0;
      case 3: 
        localChannel.read_only = locala.ajGk.aai();
        AppMethodBeat.o(275502);
        return 0;
      case 4: 
        localChannel.cant_send_reason = locala.ajGk.readString();
        AppMethodBeat.o(275502);
        return 0;
      case 5: 
        localChannel.desc = locala.ajGk.readString();
        AppMethodBeat.o(275502);
        return 0;
      }
      localChannel.unread_msg_count = locala.ajGk.aaw();
      AppMethodBeat.o(275502);
      return 0;
    }
    AppMethodBeat.o(275502);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.Channel
 * JD-Core Version:    0.7.0.1
 */