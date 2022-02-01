package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class LbsInfo
  extends com.tencent.mm.bx.a
{
  public String location_desc;
  public GCLocationInfo location_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275575);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.location_info != null)
      {
        paramVarArgs.qD(1, this.location_info.computeSize());
        this.location_info.writeFields(paramVarArgs);
      }
      if (this.location_desc != null) {
        paramVarArgs.g(2, this.location_desc);
      }
      AppMethodBeat.o(275575);
      return 0;
    }
    if (paramInt == 1) {
      if (this.location_info == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.location_info.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.location_desc != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.location_desc);
      }
      AppMethodBeat.o(275575);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275575);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        LbsInfo localLbsInfo = (LbsInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275575);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            GCLocationInfo localGCLocationInfo = new GCLocationInfo();
            if ((localObject != null) && (localObject.length > 0)) {
              localGCLocationInfo.parseFrom((byte[])localObject);
            }
            localLbsInfo.location_info = localGCLocationInfo;
            paramInt += 1;
          }
          AppMethodBeat.o(275575);
          return 0;
        }
        localLbsInfo.location_desc = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(275575);
        return 0;
      }
      AppMethodBeat.o(275575);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.LbsInfo
 * JD-Core Version:    0.7.0.1
 */