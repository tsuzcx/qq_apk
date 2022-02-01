package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class RealtimeControlInfo
  extends com.tencent.mm.cd.a
{
  public ChatroomBanAction chatroom_ban_action;
  public String kick_out_wording;
  public LinkedList<ChatroomUserData> update_user_data_list;
  public UserBanAction user_ban_action;
  public int user_chatroom_relation;
  public String version;
  
  public RealtimeControlInfo()
  {
    AppMethodBeat.i(195632);
    this.update_user_data_list = new LinkedList();
    AppMethodBeat.o(195632);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195635);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.user_chatroom_relation);
      if (this.user_ban_action != null)
      {
        paramVarArgs.oE(2, this.user_ban_action.computeSize());
        this.user_ban_action.writeFields(paramVarArgs);
      }
      if (this.chatroom_ban_action != null)
      {
        paramVarArgs.oE(3, this.chatroom_ban_action.computeSize());
        this.chatroom_ban_action.writeFields(paramVarArgs);
      }
      if (this.version != null) {
        paramVarArgs.f(4, this.version);
      }
      if (this.kick_out_wording != null) {
        paramVarArgs.f(5, this.kick_out_wording);
      }
      paramVarArgs.e(6, 8, this.update_user_data_list);
      AppMethodBeat.o(195635);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.user_chatroom_relation) + 0;
      paramInt = i;
      if (this.user_ban_action != null) {
        paramInt = i + g.a.a.a.oD(2, this.user_ban_action.computeSize());
      }
      i = paramInt;
      if (this.chatroom_ban_action != null) {
        i = paramInt + g.a.a.a.oD(3, this.chatroom_ban_action.computeSize());
      }
      paramInt = i;
      if (this.version != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.version);
      }
      i = paramInt;
      if (this.kick_out_wording != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.kick_out_wording);
      }
      paramInt = g.a.a.a.c(6, 8, this.update_user_data_list);
      AppMethodBeat.o(195635);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.update_user_data_list.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(195635);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      RealtimeControlInfo localRealtimeControlInfo = (RealtimeControlInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(195635);
        return -1;
      case 1: 
        localRealtimeControlInfo.user_chatroom_relation = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(195635);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
        AppMethodBeat.o(195635);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
        AppMethodBeat.o(195635);
        return 0;
      case 4: 
        localRealtimeControlInfo.version = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(195635);
        return 0;
      case 5: 
        localRealtimeControlInfo.kick_out_wording = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(195635);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
      AppMethodBeat.o(195635);
      return 0;
    }
    AppMethodBeat.o(195635);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.RealtimeControlInfo
 * JD-Core Version:    0.7.0.1
 */