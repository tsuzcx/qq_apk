package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class VoteInfo
  extends com.tencent.mm.bx.a
{
  public boolean can_vote;
  public String desc;
  public LinkedList<String> latest_voter_username_list;
  public int show_type;
  public boolean voted_by_me;
  
  public VoteInfo()
  {
    AppMethodBeat.i(275545);
    this.latest_voter_username_list = new LinkedList();
    AppMethodBeat.o(275545);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275555);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.latest_voter_username_list);
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      paramVarArgs.bS(3, this.show_type);
      paramVarArgs.di(4, this.voted_by_me);
      paramVarArgs.di(5, this.can_vote);
      AppMethodBeat.o(275555);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.a.c(1, 1, this.latest_voter_username_list) + 0;
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.desc);
      }
      i = i.a.a.b.b.a.cJ(3, this.show_type);
      int j = i.a.a.b.b.a.ko(4);
      int k = i.a.a.b.b.a.ko(5);
      AppMethodBeat.o(275555);
      return paramInt + i + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.latest_voter_username_list.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275555);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      VoteInfo localVoteInfo = (VoteInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(275555);
        return -1;
      case 1: 
        localVoteInfo.latest_voter_username_list.add(locala.ajGk.readString());
        AppMethodBeat.o(275555);
        return 0;
      case 2: 
        localVoteInfo.desc = locala.ajGk.readString();
        AppMethodBeat.o(275555);
        return 0;
      case 3: 
        localVoteInfo.show_type = locala.ajGk.aar();
        AppMethodBeat.o(275555);
        return 0;
      case 4: 
        localVoteInfo.voted_by_me = locala.ajGk.aai();
        AppMethodBeat.o(275555);
        return 0;
      }
      localVoteInfo.can_vote = locala.ajGk.aai();
      AppMethodBeat.o(275555);
      return 0;
    }
    AppMethodBeat.o(275555);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.VoteInfo
 * JD-Core Version:    0.7.0.1
 */