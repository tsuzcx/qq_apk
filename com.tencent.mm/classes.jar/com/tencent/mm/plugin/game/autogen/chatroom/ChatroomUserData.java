package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class ChatroomUserData
  extends com.tencent.mm.cd.a
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
    AppMethodBeat.i(195573);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(195573);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.f(2, this.nickname);
      }
      if (this.avatar != null) {
        paramVarArgs.f(3, this.avatar);
      }
      paramVarArgs.aY(4, this.sex);
      if (this.jump_info != null)
      {
        paramVarArgs.oE(5, this.jump_info.computeSize());
        this.jump_info.writeFields(paramVarArgs);
      }
      if (this.signature != null) {
        paramVarArgs.f(6, this.signature);
      }
      paramVarArgs.co(7, this.is_authorized);
      if (this.tag_info != null)
      {
        paramVarArgs.oE(8, this.tag_info.computeSize());
        this.tag_info.writeFields(paramVarArgs);
      }
      if (this.lbs_info != null)
      {
        paramVarArgs.oE(9, this.lbs_info.computeSize());
        this.lbs_info.writeFields(paramVarArgs);
      }
      if (this.chatroom_name != null) {
        paramVarArgs.f(10, this.chatroom_name);
      }
      paramVarArgs.aY(11, this.role);
      paramVarArgs.co(12, this.can_be_at);
      paramVarArgs.co(13, this.is_robot);
      paramVarArgs.co(14, this.can_kick_member);
      if (this.user_role != null)
      {
        paramVarArgs.oE(15, this.user_role.computeSize());
        this.user_role.writeFields(paramVarArgs);
      }
      paramVarArgs.co(16, this.can_be_kicked);
      paramVarArgs.co(17, this.can_at_all);
      if (this.h5_profile_jump_info != null)
      {
        paramVarArgs.oE(18, this.h5_profile_jump_info.computeSize());
        this.h5_profile_jump_info.writeFields(paramVarArgs);
      }
      if (this.create_account_jump_info != null)
      {
        paramVarArgs.oE(19, this.create_account_jump_info.computeSize());
        this.create_account_jump_info.writeFields(paramVarArgs);
      }
      if (this.indentity != null)
      {
        paramVarArgs.oE(20, this.indentity.computeSize());
        this.indentity.writeFields(paramVarArgs);
      }
      if (this.extern_info != null) {
        paramVarArgs.f(21, this.extern_info);
      }
      paramVarArgs.co(22, this.is_self);
      AppMethodBeat.o(195573);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label1896;
      }
    }
    label1896:
    for (int i = g.a.a.b.b.a.g(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nickname);
      }
      i = paramInt;
      if (this.avatar != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.avatar);
      }
      i += g.a.a.b.b.a.bM(4, this.sex);
      paramInt = i;
      if (this.jump_info != null) {
        paramInt = i + g.a.a.a.oD(5, this.jump_info.computeSize());
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.signature);
      }
      i += g.a.a.b.b.a.gL(7) + 1;
      paramInt = i;
      if (this.tag_info != null) {
        paramInt = i + g.a.a.a.oD(8, this.tag_info.computeSize());
      }
      i = paramInt;
      if (this.lbs_info != null) {
        i = paramInt + g.a.a.a.oD(9, this.lbs_info.computeSize());
      }
      paramInt = i;
      if (this.chatroom_name != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.chatroom_name);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.role) + (g.a.a.b.b.a.gL(12) + 1) + (g.a.a.b.b.a.gL(13) + 1) + (g.a.a.b.b.a.gL(14) + 1);
      paramInt = i;
      if (this.user_role != null) {
        paramInt = i + g.a.a.a.oD(15, this.user_role.computeSize());
      }
      i = paramInt + (g.a.a.b.b.a.gL(16) + 1) + (g.a.a.b.b.a.gL(17) + 1);
      paramInt = i;
      if (this.h5_profile_jump_info != null) {
        paramInt = i + g.a.a.a.oD(18, this.h5_profile_jump_info.computeSize());
      }
      i = paramInt;
      if (this.create_account_jump_info != null) {
        i = paramInt + g.a.a.a.oD(19, this.create_account_jump_info.computeSize());
      }
      paramInt = i;
      if (this.indentity != null) {
        paramInt = i + g.a.a.a.oD(20, this.indentity.computeSize());
      }
      i = paramInt;
      if (this.extern_info != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.extern_info);
      }
      paramInt = g.a.a.b.b.a.gL(22);
      AppMethodBeat.o(195573);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(195573);
          throw paramVarArgs;
        }
        AppMethodBeat.o(195573);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ChatroomUserData localChatroomUserData = (ChatroomUserData)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195573);
          return -1;
        case 1: 
          localChatroomUserData.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(195573);
          return 0;
        case 2: 
          localChatroomUserData.nickname = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(195573);
          return 0;
        case 3: 
          localChatroomUserData.avatar = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(195573);
          return 0;
        case 4: 
          localChatroomUserData.sex = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(195573);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(195573);
          return 0;
        case 6: 
          localChatroomUserData.signature = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(195573);
          return 0;
        case 7: 
          localChatroomUserData.is_authorized = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(195573);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(195573);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(195573);
          return 0;
        case 10: 
          localChatroomUserData.chatroom_name = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(195573);
          return 0;
        case 11: 
          localChatroomUserData.role = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(195573);
          return 0;
        case 12: 
          localChatroomUserData.can_be_at = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(195573);
          return 0;
        case 13: 
          localChatroomUserData.is_robot = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(195573);
          return 0;
        case 14: 
          localChatroomUserData.can_kick_member = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(195573);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(195573);
          return 0;
        case 16: 
          localChatroomUserData.can_be_kicked = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(195573);
          return 0;
        case 17: 
          localChatroomUserData.can_at_all = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(195573);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(195573);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(195573);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(195573);
          return 0;
        case 21: 
          localChatroomUserData.extern_info = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(195573);
          return 0;
        }
        localChatroomUserData.is_self = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(195573);
        return 0;
      }
      AppMethodBeat.o(195573);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData
 * JD-Core Version:    0.7.0.1
 */