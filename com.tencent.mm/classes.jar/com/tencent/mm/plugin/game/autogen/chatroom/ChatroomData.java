package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class ChatroomData
  extends com.tencent.mm.bx.a
{
  public AdminInfo admin_info;
  public int allow_user_num;
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
  public LinkedList<ChatroomTag> chatroom_tag_list;
  public int chatroom_type;
  public boolean is_private;
  public int kick_out_type;
  public ChatroomNotice notice;
  public String report_str;
  public int room_member_num;
  public String room_name;
  public LinkedList<RestrictRule> rule_list;
  public boolean top_chatroom;
  public int user_chatroom_relation;
  public String version;
  
  public ChatroomData()
  {
    AppMethodBeat.i(275602);
    this.rule_list = new LinkedList();
    this.chatroom_tag_list = new LinkedList();
    AppMethodBeat.o(275602);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275626);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_name == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_name");
        AppMethodBeat.o(275626);
        throw paramVarArgs;
      }
      if (this.chatroom_name != null) {
        paramVarArgs.g(1, this.chatroom_name);
      }
      if (this.room_name != null) {
        paramVarArgs.g(2, this.room_name);
      }
      if (this.chatroom_icon != null) {
        paramVarArgs.g(3, this.chatroom_icon);
      }
      if (this.appid != null) {
        paramVarArgs.g(4, this.appid);
      }
      if (this.admin_info != null)
      {
        paramVarArgs.qD(5, this.admin_info.computeSize());
        this.admin_info.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.chatroom_type);
      paramVarArgs.di(7, this.is_private);
      if (this.announcement != null) {
        paramVarArgs.g(8, this.announcement);
      }
      paramVarArgs.bS(9, this.user_chatroom_relation);
      paramVarArgs.bS(10, this.room_member_num);
      paramVarArgs.e(11, 8, this.rule_list);
      paramVarArgs.di(12, this.can_join);
      paramVarArgs.di(13, this.can_onlooker);
      paramVarArgs.di(14, this.can_chat);
      if (this.application_question != null) {
        paramVarArgs.g(15, this.application_question);
      }
      if (this.version != null) {
        paramVarArgs.g(16, this.version);
      }
      if (this.apply_jump_info != null)
      {
        paramVarArgs.qD(17, this.apply_jump_info.computeSize());
        this.apply_jump_info.writeFields(paramVarArgs);
      }
      if (this.chatroom_profile_jump_info != null)
      {
        paramVarArgs.qD(18, this.chatroom_profile_jump_info.computeSize());
        this.chatroom_profile_jump_info.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(19, this.kick_out_type);
      if (this.chatroom_member_jump_info != null)
      {
        paramVarArgs.qD(20, this.chatroom_member_jump_info.computeSize());
        this.chatroom_member_jump_info.writeFields(paramVarArgs);
      }
      if (this.notice != null)
      {
        paramVarArgs.qD(21, this.notice.computeSize());
        this.notice.writeFields(paramVarArgs);
      }
      paramVarArgs.di(22, this.top_chatroom);
      paramVarArgs.e(23, 8, this.chatroom_tag_list);
      paramVarArgs.bS(24, this.allow_user_num);
      if (this.report_str != null) {
        paramVarArgs.g(25, this.report_str);
      }
      AppMethodBeat.o(275626);
      return 0;
    }
    if (paramInt == 1) {
      if (this.chatroom_name == null) {
        break label2032;
      }
    }
    label2032:
    for (int i = i.a.a.b.b.a.h(1, this.chatroom_name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.room_name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.room_name);
      }
      i = paramInt;
      if (this.chatroom_icon != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.chatroom_icon);
      }
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.appid);
      }
      i = paramInt;
      if (this.admin_info != null) {
        i = paramInt + i.a.a.a.qC(5, this.admin_info.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(6, this.chatroom_type) + (i.a.a.b.b.a.ko(7) + 1);
      paramInt = i;
      if (this.announcement != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.announcement);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.user_chatroom_relation) + i.a.a.b.b.a.cJ(10, this.room_member_num) + i.a.a.a.c(11, 8, this.rule_list) + (i.a.a.b.b.a.ko(12) + 1) + (i.a.a.b.b.a.ko(13) + 1) + (i.a.a.b.b.a.ko(14) + 1);
      paramInt = i;
      if (this.application_question != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.application_question);
      }
      i = paramInt;
      if (this.version != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.version);
      }
      paramInt = i;
      if (this.apply_jump_info != null) {
        paramInt = i + i.a.a.a.qC(17, this.apply_jump_info.computeSize());
      }
      i = paramInt;
      if (this.chatroom_profile_jump_info != null) {
        i = paramInt + i.a.a.a.qC(18, this.chatroom_profile_jump_info.computeSize());
      }
      i += i.a.a.b.b.a.cJ(19, this.kick_out_type);
      paramInt = i;
      if (this.chatroom_member_jump_info != null) {
        paramInt = i + i.a.a.a.qC(20, this.chatroom_member_jump_info.computeSize());
      }
      i = paramInt;
      if (this.notice != null) {
        i = paramInt + i.a.a.a.qC(21, this.notice.computeSize());
      }
      i = i + (i.a.a.b.b.a.ko(22) + 1) + i.a.a.a.c(23, 8, this.chatroom_tag_list) + i.a.a.b.b.a.cJ(24, this.allow_user_num);
      paramInt = i;
      if (this.report_str != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.report_str);
      }
      AppMethodBeat.o(275626);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rule_list.clear();
        this.chatroom_tag_list.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.chatroom_name == null)
        {
          paramVarArgs = new b("Not all required fields were included: chatroom_name");
          AppMethodBeat.o(275626);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275626);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ChatroomData localChatroomData = (ChatroomData)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275626);
          return -1;
        case 1: 
          localChatroomData.chatroom_name = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275626);
          return 0;
        case 2: 
          localChatroomData.room_name = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275626);
          return 0;
        case 3: 
          localChatroomData.chatroom_icon = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275626);
          return 0;
        case 4: 
          localChatroomData.appid = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275626);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
          AppMethodBeat.o(275626);
          return 0;
        case 6: 
          localChatroomData.chatroom_type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(275626);
          return 0;
        case 7: 
          localChatroomData.is_private = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275626);
          return 0;
        case 8: 
          localChatroomData.announcement = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275626);
          return 0;
        case 9: 
          localChatroomData.user_chatroom_relation = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(275626);
          return 0;
        case 10: 
          localChatroomData.room_member_num = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(275626);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
          AppMethodBeat.o(275626);
          return 0;
        case 12: 
          localChatroomData.can_join = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275626);
          return 0;
        case 13: 
          localChatroomData.can_onlooker = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275626);
          return 0;
        case 14: 
          localChatroomData.can_chat = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275626);
          return 0;
        case 15: 
          localChatroomData.application_question = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275626);
          return 0;
        case 16: 
          localChatroomData.version = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275626);
          return 0;
        case 17: 
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
            localChatroomData.apply_jump_info = ((JumpInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275626);
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
            localChatroomData.chatroom_profile_jump_info = ((JumpInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275626);
          return 0;
        case 19: 
          localChatroomData.kick_out_type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(275626);
          return 0;
        case 20: 
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
            localChatroomData.chatroom_member_jump_info = ((JumpInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275626);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomNotice();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomNotice)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomData.notice = ((ChatroomNotice)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275626);
          return 0;
        case 22: 
          localChatroomData.top_chatroom = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275626);
          return 0;
        case 23: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomTag();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomTag)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomData.chatroom_tag_list.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275626);
          return 0;
        case 24: 
          localChatroomData.allow_user_num = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(275626);
          return 0;
        }
        localChatroomData.report_str = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275626);
        return 0;
      }
      AppMethodBeat.o(275626);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomData
 * JD-Core Version:    0.7.0.1
 */