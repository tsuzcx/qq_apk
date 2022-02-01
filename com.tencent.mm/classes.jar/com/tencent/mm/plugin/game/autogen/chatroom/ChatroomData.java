package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class ChatroomData
  extends com.tencent.mm.cd.a
{
  public AdminInfo admin_info;
  public String announcement;
  public String appid;
  public String application_question;
  public JumpInfo apply_jump_info;
  public boolean can_chat;
  public boolean can_join;
  public boolean can_onlooker;
  public String chatroom_icon;
  public JumpInfo chatroom_member_jump_info;
  public String chatroom_name;
  public JumpInfo chatroom_profile_jump_info;
  public int chatroom_type;
  public boolean is_private;
  public int kick_out_type;
  public int room_member_num;
  public String room_name;
  public LinkedList<RestrictRule> rule_list;
  public int user_chatroom_relation;
  public String version;
  
  public ChatroomData()
  {
    AppMethodBeat.i(194810);
    this.rule_list = new LinkedList();
    AppMethodBeat.o(194810);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194824);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_name == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_name");
        AppMethodBeat.o(194824);
        throw paramVarArgs;
      }
      if (this.chatroom_name != null) {
        paramVarArgs.f(1, this.chatroom_name);
      }
      if (this.room_name != null) {
        paramVarArgs.f(2, this.room_name);
      }
      if (this.chatroom_icon != null) {
        paramVarArgs.f(3, this.chatroom_icon);
      }
      if (this.appid != null) {
        paramVarArgs.f(4, this.appid);
      }
      if (this.admin_info != null)
      {
        paramVarArgs.oE(5, this.admin_info.computeSize());
        this.admin_info.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.chatroom_type);
      paramVarArgs.co(7, this.is_private);
      if (this.announcement != null) {
        paramVarArgs.f(8, this.announcement);
      }
      paramVarArgs.aY(9, this.user_chatroom_relation);
      paramVarArgs.aY(10, this.room_member_num);
      paramVarArgs.e(11, 8, this.rule_list);
      paramVarArgs.co(12, this.can_join);
      paramVarArgs.co(13, this.can_onlooker);
      paramVarArgs.co(14, this.can_chat);
      if (this.application_question != null) {
        paramVarArgs.f(15, this.application_question);
      }
      if (this.version != null) {
        paramVarArgs.f(16, this.version);
      }
      if (this.apply_jump_info != null)
      {
        paramVarArgs.oE(17, this.apply_jump_info.computeSize());
        this.apply_jump_info.writeFields(paramVarArgs);
      }
      if (this.chatroom_profile_jump_info != null)
      {
        paramVarArgs.oE(18, this.chatroom_profile_jump_info.computeSize());
        this.chatroom_profile_jump_info.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(19, this.kick_out_type);
      if (this.chatroom_member_jump_info != null)
      {
        paramVarArgs.oE(20, this.chatroom_member_jump_info.computeSize());
        this.chatroom_member_jump_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(194824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.chatroom_name == null) {
        break label1632;
      }
    }
    label1632:
    for (int i = g.a.a.b.b.a.g(1, this.chatroom_name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.room_name != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.room_name);
      }
      i = paramInt;
      if (this.chatroom_icon != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.chatroom_icon);
      }
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.appid);
      }
      i = paramInt;
      if (this.admin_info != null) {
        i = paramInt + g.a.a.a.oD(5, this.admin_info.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(6, this.chatroom_type) + (g.a.a.b.b.a.gL(7) + 1);
      paramInt = i;
      if (this.announcement != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.announcement);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.user_chatroom_relation) + g.a.a.b.b.a.bM(10, this.room_member_num) + g.a.a.a.c(11, 8, this.rule_list) + (g.a.a.b.b.a.gL(12) + 1) + (g.a.a.b.b.a.gL(13) + 1) + (g.a.a.b.b.a.gL(14) + 1);
      paramInt = i;
      if (this.application_question != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.application_question);
      }
      i = paramInt;
      if (this.version != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.version);
      }
      paramInt = i;
      if (this.apply_jump_info != null) {
        paramInt = i + g.a.a.a.oD(17, this.apply_jump_info.computeSize());
      }
      i = paramInt;
      if (this.chatroom_profile_jump_info != null) {
        i = paramInt + g.a.a.a.oD(18, this.chatroom_profile_jump_info.computeSize());
      }
      i += g.a.a.b.b.a.bM(19, this.kick_out_type);
      paramInt = i;
      if (this.chatroom_member_jump_info != null) {
        paramInt = i + g.a.a.a.oD(20, this.chatroom_member_jump_info.computeSize());
      }
      AppMethodBeat.o(194824);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rule_list.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.chatroom_name == null)
        {
          paramVarArgs = new b("Not all required fields were included: chatroom_name");
          AppMethodBeat.o(194824);
          throw paramVarArgs;
        }
        AppMethodBeat.o(194824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ChatroomData localChatroomData = (ChatroomData)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194824);
          return -1;
        case 1: 
          localChatroomData.chatroom_name = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(194824);
          return 0;
        case 2: 
          localChatroomData.room_name = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(194824);
          return 0;
        case 3: 
          localChatroomData.chatroom_icon = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(194824);
          return 0;
        case 4: 
          localChatroomData.appid = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(194824);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new AdminInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((AdminInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomData.admin_info = ((AdminInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194824);
          return 0;
        case 6: 
          localChatroomData.chatroom_type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(194824);
          return 0;
        case 7: 
          localChatroomData.is_private = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(194824);
          return 0;
        case 8: 
          localChatroomData.announcement = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(194824);
          return 0;
        case 9: 
          localChatroomData.user_chatroom_relation = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(194824);
          return 0;
        case 10: 
          localChatroomData.room_member_num = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(194824);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new RestrictRule();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((RestrictRule)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomData.rule_list.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194824);
          return 0;
        case 12: 
          localChatroomData.can_join = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(194824);
          return 0;
        case 13: 
          localChatroomData.can_onlooker = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(194824);
          return 0;
        case 14: 
          localChatroomData.can_chat = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(194824);
          return 0;
        case 15: 
          localChatroomData.application_question = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(194824);
          return 0;
        case 16: 
          localChatroomData.version = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(194824);
          return 0;
        case 17: 
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
            localChatroomData.apply_jump_info = ((JumpInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194824);
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
            localChatroomData.chatroom_profile_jump_info = ((JumpInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194824);
          return 0;
        case 19: 
          localChatroomData.kick_out_type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(194824);
          return 0;
        }
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
          localChatroomData.chatroom_member_jump_info = ((JumpInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(194824);
        return 0;
      }
      AppMethodBeat.o(194824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomData
 * JD-Core Version:    0.7.0.1
 */