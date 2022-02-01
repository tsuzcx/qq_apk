package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChannelInfo
  extends com.tencent.mm.bx.a
{
  public LinkedList<Channel> channel_list;
  public int default_channel_id;
  
  public ChannelInfo()
  {
    AppMethodBeat.i(275579);
    this.channel_list = new LinkedList();
    AppMethodBeat.o(275579);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275587);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.channel_list);
      paramVarArgs.bS(2, this.default_channel_id);
      AppMethodBeat.o(275587);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.channel_list);
      i = i.a.a.b.b.a.cJ(2, this.default_channel_id);
      AppMethodBeat.o(275587);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.channel_list.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275587);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ChannelInfo localChannelInfo = (ChannelInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275587);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          Channel localChannel = new Channel();
          if ((localObject != null) && (localObject.length > 0)) {
            localChannel.parseFrom((byte[])localObject);
          }
          localChannelInfo.channel_list.add(localChannel);
          paramInt += 1;
        }
        AppMethodBeat.o(275587);
        return 0;
      }
      localChannelInfo.default_channel_id = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(275587);
      return 0;
    }
    AppMethodBeat.o(275587);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChannelInfo
 * JD-Core Version:    0.7.0.1
 */