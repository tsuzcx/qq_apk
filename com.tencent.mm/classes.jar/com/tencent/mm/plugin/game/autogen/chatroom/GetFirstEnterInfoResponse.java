package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public class GetFirstEnterInfoResponse
  extends esc
{
  public LinkedList<ContentBlock> content_list;
  public JumpInfo enter_jump_info;
  
  public GetFirstEnterInfoResponse()
  {
    AppMethodBeat.i(275499);
    this.content_list = new LinkedList();
    AppMethodBeat.o(275499);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275504);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.content_list);
      if (this.enter_jump_info != null)
      {
        paramVarArgs.qD(3, this.enter_jump_info.computeSize());
        this.enter_jump_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label536;
      }
    }
    label536:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.content_list);
      paramInt = i;
      if (this.enter_jump_info != null) {
        paramInt = i + i.a.a.a.qC(3, this.enter_jump_info.computeSize());
      }
      AppMethodBeat.o(275504);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.content_list.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275504);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        GetFirstEnterInfoResponse localGetFirstEnterInfoResponse = (GetFirstEnterInfoResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275504);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localGetFirstEnterInfoResponse.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275504);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ContentBlock();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ContentBlock)localObject2).parseFrom((byte[])localObject1);
            }
            localGetFirstEnterInfoResponse.content_list.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275504);
          return 0;
        }
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
          localGetFirstEnterInfoResponse.enter_jump_info = ((JumpInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275504);
        return 0;
      }
      AppMethodBeat.o(275504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetFirstEnterInfoResponse
 * JD-Core Version:    0.7.0.1
 */