package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class MsgOptions
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> at_list;
  public int bg_type;
  public ChosenInfo chosen_info;
  public b cli_local_data;
  public String complaint_url;
  public int msg_biz_type;
  public MsgChannelInfo msg_channel_info;
  public long reply_seq;
  public boolean self_msg;
  public VoteInfo vote_info;
  
  public MsgOptions()
  {
    AppMethodBeat.i(275487);
    this.at_list = new LinkedList();
    AppMethodBeat.o(275487);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275497);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.at_list);
      if (this.complaint_url != null) {
        paramVarArgs.g(2, this.complaint_url);
      }
      if (this.cli_local_data != null) {
        paramVarArgs.d(3, this.cli_local_data);
      }
      paramVarArgs.bS(4, this.msg_biz_type);
      paramVarArgs.di(5, this.self_msg);
      paramVarArgs.bv(6, this.reply_seq);
      if (this.vote_info != null)
      {
        paramVarArgs.qD(7, this.vote_info.computeSize());
        this.vote_info.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.bg_type);
      if (this.chosen_info != null)
      {
        paramVarArgs.qD(9, this.chosen_info.computeSize());
        this.chosen_info.writeFields(paramVarArgs);
      }
      if (this.msg_channel_info != null)
      {
        paramVarArgs.qD(10, this.msg_channel_info.computeSize());
        this.msg_channel_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275497);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 1, this.at_list) + 0;
      paramInt = i;
      if (this.complaint_url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.complaint_url);
      }
      i = paramInt;
      if (this.cli_local_data != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.cli_local_data);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.msg_biz_type) + (i.a.a.b.b.a.ko(5) + 1) + i.a.a.b.b.a.q(6, this.reply_seq);
      paramInt = i;
      if (this.vote_info != null) {
        paramInt = i + i.a.a.a.qC(7, this.vote_info.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.bg_type);
      paramInt = i;
      if (this.chosen_info != null) {
        paramInt = i + i.a.a.a.qC(9, this.chosen_info.computeSize());
      }
      i = paramInt;
      if (this.msg_channel_info != null) {
        i = paramInt + i.a.a.a.qC(10, this.msg_channel_info.computeSize());
      }
      AppMethodBeat.o(275497);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.at_list.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275497);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      MsgOptions localMsgOptions = (MsgOptions)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275497);
        return -1;
      case 1: 
        localMsgOptions.at_list.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(275497);
        return 0;
      case 2: 
        localMsgOptions.complaint_url = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275497);
        return 0;
      case 3: 
        localMsgOptions.cli_local_data = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(275497);
        return 0;
      case 4: 
        localMsgOptions.msg_biz_type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(275497);
        return 0;
      case 5: 
        localMsgOptions.self_msg = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(275497);
        return 0;
      case 6: 
        localMsgOptions.reply_seq = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(275497);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new VoteInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((VoteInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localMsgOptions.vote_info = ((VoteInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275497);
        return 0;
      case 8: 
        localMsgOptions.bg_type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(275497);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ChosenInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ChosenInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localMsgOptions.chosen_info = ((ChosenInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275497);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new MsgChannelInfo();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((MsgChannelInfo)localObject2).parseFrom((byte[])localObject1);
        }
        localMsgOptions.msg_channel_info = ((MsgChannelInfo)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(275497);
      return 0;
    }
    AppMethodBeat.o(275497);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.MsgOptions
 * JD-Core Version:    0.7.0.1
 */