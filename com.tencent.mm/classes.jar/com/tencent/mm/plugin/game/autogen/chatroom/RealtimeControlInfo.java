package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class RealtimeControlInfo
  extends com.tencent.mm.bx.a
{
  public ChatroomBanAction chatroom_ban_action;
  public boolean disable_emoji;
  public boolean enable_custom_emoji;
  public KickOutCardInfo kick_out_card_info;
  public String kick_out_wording;
  public PremadeCardInfo premade_card_info;
  public LinkedList<ChatroomUserData> update_user_data_list;
  public UserBanAction user_ban_action;
  public int user_chatroom_relation;
  public String version;
  
  public RealtimeControlInfo()
  {
    AppMethodBeat.i(275554);
    this.update_user_data_list = new LinkedList();
    AppMethodBeat.o(275554);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275566);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.user_chatroom_relation);
      if (this.user_ban_action != null)
      {
        paramVarArgs.qD(2, this.user_ban_action.computeSize());
        this.user_ban_action.writeFields(paramVarArgs);
      }
      if (this.chatroom_ban_action != null)
      {
        paramVarArgs.qD(3, this.chatroom_ban_action.computeSize());
        this.chatroom_ban_action.writeFields(paramVarArgs);
      }
      if (this.version != null) {
        paramVarArgs.g(4, this.version);
      }
      if (this.kick_out_wording != null) {
        paramVarArgs.g(5, this.kick_out_wording);
      }
      paramVarArgs.e(6, 8, this.update_user_data_list);
      paramVarArgs.di(7, this.disable_emoji);
      if (this.premade_card_info != null)
      {
        paramVarArgs.qD(8, this.premade_card_info.computeSize());
        this.premade_card_info.writeFields(paramVarArgs);
      }
      paramVarArgs.di(9, this.enable_custom_emoji);
      if (this.kick_out_card_info != null)
      {
        paramVarArgs.qD(10, this.kick_out_card_info.computeSize());
        this.kick_out_card_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275566);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.user_chatroom_relation) + 0;
      paramInt = i;
      if (this.user_ban_action != null) {
        paramInt = i + i.a.a.a.qC(2, this.user_ban_action.computeSize());
      }
      i = paramInt;
      if (this.chatroom_ban_action != null) {
        i = paramInt + i.a.a.a.qC(3, this.chatroom_ban_action.computeSize());
      }
      paramInt = i;
      if (this.version != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.version);
      }
      i = paramInt;
      if (this.kick_out_wording != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.kick_out_wording);
      }
      i = i + i.a.a.a.c(6, 8, this.update_user_data_list) + (i.a.a.b.b.a.ko(7) + 1);
      paramInt = i;
      if (this.premade_card_info != null) {
        paramInt = i + i.a.a.a.qC(8, this.premade_card_info.computeSize());
      }
      i = paramInt + (i.a.a.b.b.a.ko(9) + 1);
      paramInt = i;
      if (this.kick_out_card_info != null) {
        paramInt = i + i.a.a.a.qC(10, this.kick_out_card_info.computeSize());
      }
      AppMethodBeat.o(275566);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.update_user_data_list.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275566);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      RealtimeControlInfo localRealtimeControlInfo = (RealtimeControlInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275566);
        return -1;
      case 1: 
        localRealtimeControlInfo.user_chatroom_relation = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(275566);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new UserBanAction();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((UserBanAction)localObject2).parseFrom((byte[])localObject1);
          }
          localRealtimeControlInfo.user_ban_action = ((UserBanAction)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275566);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ChatroomBanAction();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ChatroomBanAction)localObject2).parseFrom((byte[])localObject1);
          }
          localRealtimeControlInfo.chatroom_ban_action = ((ChatroomBanAction)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275566);
        return 0;
      case 4: 
        localRealtimeControlInfo.version = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275566);
        return 0;
      case 5: 
        localRealtimeControlInfo.kick_out_wording = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275566);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ChatroomUserData();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ChatroomUserData)localObject2).parseFrom((byte[])localObject1);
          }
          localRealtimeControlInfo.update_user_data_list.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275566);
        return 0;
      case 7: 
        localRealtimeControlInfo.disable_emoji = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(275566);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new PremadeCardInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((PremadeCardInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localRealtimeControlInfo.premade_card_info = ((PremadeCardInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275566);
        return 0;
      case 9: 
        localRealtimeControlInfo.enable_custom_emoji = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(275566);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new KickOutCardInfo();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((KickOutCardInfo)localObject2).parseFrom((byte[])localObject1);
        }
        localRealtimeControlInfo.kick_out_card_info = ((KickOutCardInfo)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(275566);
      return 0;
    }
    AppMethodBeat.o(275566);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.RealtimeControlInfo
 * JD-Core Version:    0.7.0.1
 */