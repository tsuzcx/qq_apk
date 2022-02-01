package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class ChatroomUserData
  extends com.tencent.mm.bx.a
{
  public String avatar;
  public boolean can_at_all;
  public boolean can_be_at;
  public boolean can_be_kicked;
  public boolean can_kick_member;
  public String chatroom_name;
  public JumpInfo create_account_jump_info;
  public String extern_info;
  public JumpInfo h5_profile_jump_info;
  public AccountIdentityInfo indentity;
  public boolean is_authorized;
  public boolean is_robot;
  public boolean is_self;
  public JumpInfo jump_info;
  public LbsInfo lbs_info;
  public String nickname;
  public int role;
  public int sex;
  public String signature;
  public TagInfo tag_info;
  public UserRole user_role;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275560);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(275560);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.avatar != null) {
        paramVarArgs.g(3, this.avatar);
      }
      paramVarArgs.bS(4, this.sex);
      if (this.jump_info != null)
      {
        paramVarArgs.qD(5, this.jump_info.computeSize());
        this.jump_info.writeFields(paramVarArgs);
      }
      if (this.signature != null) {
        paramVarArgs.g(6, this.signature);
      }
      paramVarArgs.di(7, this.is_authorized);
      if (this.tag_info != null)
      {
        paramVarArgs.qD(8, this.tag_info.computeSize());
        this.tag_info.writeFields(paramVarArgs);
      }
      if (this.lbs_info != null)
      {
        paramVarArgs.qD(9, this.lbs_info.computeSize());
        this.lbs_info.writeFields(paramVarArgs);
      }
      if (this.chatroom_name != null) {
        paramVarArgs.g(10, this.chatroom_name);
      }
      paramVarArgs.bS(11, this.role);
      paramVarArgs.di(12, this.can_be_at);
      paramVarArgs.di(13, this.is_robot);
      paramVarArgs.di(14, this.can_kick_member);
      if (this.user_role != null)
      {
        paramVarArgs.qD(15, this.user_role.computeSize());
        this.user_role.writeFields(paramVarArgs);
      }
      paramVarArgs.di(16, this.can_be_kicked);
      paramVarArgs.di(17, this.can_at_all);
      if (this.h5_profile_jump_info != null)
      {
        paramVarArgs.qD(18, this.h5_profile_jump_info.computeSize());
        this.h5_profile_jump_info.writeFields(paramVarArgs);
      }
      if (this.create_account_jump_info != null)
      {
        paramVarArgs.qD(19, this.create_account_jump_info.computeSize());
        this.create_account_jump_info.writeFields(paramVarArgs);
      }
      if (this.indentity != null)
      {
        paramVarArgs.qD(20, this.indentity.computeSize());
        this.indentity.writeFields(paramVarArgs);
      }
      if (this.extern_info != null) {
        paramVarArgs.g(21, this.extern_info);
      }
      paramVarArgs.di(22, this.is_self);
      AppMethodBeat.o(275560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label1892;
      }
    }
    label1892:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.avatar != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.avatar);
      }
      i += i.a.a.b.b.a.cJ(4, this.sex);
      paramInt = i;
      if (this.jump_info != null) {
        paramInt = i + i.a.a.a.qC(5, this.jump_info.computeSize());
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.signature);
      }
      i += i.a.a.b.b.a.ko(7) + 1;
      paramInt = i;
      if (this.tag_info != null) {
        paramInt = i + i.a.a.a.qC(8, this.tag_info.computeSize());
      }
      i = paramInt;
      if (this.lbs_info != null) {
        i = paramInt + i.a.a.a.qC(9, this.lbs_info.computeSize());
      }
      paramInt = i;
      if (this.chatroom_name != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.chatroom_name);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.role) + (i.a.a.b.b.a.ko(12) + 1) + (i.a.a.b.b.a.ko(13) + 1) + (i.a.a.b.b.a.ko(14) + 1);
      paramInt = i;
      if (this.user_role != null) {
        paramInt = i + i.a.a.a.qC(15, this.user_role.computeSize());
      }
      i = paramInt + (i.a.a.b.b.a.ko(16) + 1) + (i.a.a.b.b.a.ko(17) + 1);
      paramInt = i;
      if (this.h5_profile_jump_info != null) {
        paramInt = i + i.a.a.a.qC(18, this.h5_profile_jump_info.computeSize());
      }
      i = paramInt;
      if (this.create_account_jump_info != null) {
        i = paramInt + i.a.a.a.qC(19, this.create_account_jump_info.computeSize());
      }
      paramInt = i;
      if (this.indentity != null) {
        paramInt = i + i.a.a.a.qC(20, this.indentity.computeSize());
      }
      i = paramInt;
      if (this.extern_info != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.extern_info);
      }
      paramInt = i.a.a.b.b.a.ko(22);
      AppMethodBeat.o(275560);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(275560);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275560);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ChatroomUserData localChatroomUserData = (ChatroomUserData)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275560);
          return -1;
        case 1: 
          localChatroomUserData.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275560);
          return 0;
        case 2: 
          localChatroomUserData.nickname = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275560);
          return 0;
        case 3: 
          localChatroomUserData.avatar = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275560);
          return 0;
        case 4: 
          localChatroomUserData.sex = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(275560);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new JumpInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((JumpInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomUserData.jump_info = ((JumpInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275560);
          return 0;
        case 6: 
          localChatroomUserData.signature = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275560);
          return 0;
        case 7: 
          localChatroomUserData.is_authorized = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275560);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new TagInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((TagInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomUserData.tag_info = ((TagInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275560);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new LbsInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((LbsInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomUserData.lbs_info = ((LbsInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275560);
          return 0;
        case 10: 
          localChatroomUserData.chatroom_name = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275560);
          return 0;
        case 11: 
          localChatroomUserData.role = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(275560);
          return 0;
        case 12: 
          localChatroomUserData.can_be_at = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275560);
          return 0;
        case 13: 
          localChatroomUserData.is_robot = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275560);
          return 0;
        case 14: 
          localChatroomUserData.can_kick_member = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275560);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new UserRole();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((UserRole)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomUserData.user_role = ((UserRole)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275560);
          return 0;
        case 16: 
          localChatroomUserData.can_be_kicked = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275560);
          return 0;
        case 17: 
          localChatroomUserData.can_at_all = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275560);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new JumpInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((JumpInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomUserData.h5_profile_jump_info = ((JumpInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275560);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new JumpInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((JumpInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomUserData.create_account_jump_info = ((JumpInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275560);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new AccountIdentityInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((AccountIdentityInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomUserData.indentity = ((AccountIdentityInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275560);
          return 0;
        case 21: 
          localChatroomUserData.extern_info = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275560);
          return 0;
        }
        localChatroomUserData.is_self = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(275560);
        return 0;
      }
      AppMethodBeat.o(275560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData
 * JD-Core Version:    0.7.0.1
 */