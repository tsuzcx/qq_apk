package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class LbsInfo
  extends com.tencent.mm.cd.a
{
  public String location_desc;
  public GCLocationInfo location_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195214);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.location_info != null)
      {
        paramVarArgs.oE(1, this.location_info.computeSize());
        this.location_info.writeFields(paramVarArgs);
      }
      if (this.location_desc != null) {
        paramVarArgs.f(2, this.location_desc);
      }
      AppMethodBeat.o(195214);
      return 0;
    }
    if (paramInt == 1) {
      if (this.location_info == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.a.oD(1, this.location_info.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.location_desc != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.location_desc);
      }
      AppMethodBeat.o(195214);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195214);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        LbsInfo localLbsInfo = (LbsInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195214);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
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
          AppMethodBeat.o(195214);
          return 0;
        }
        localLbsInfo.location_desc = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(195214);
        return 0;
      }
      AppMethodBeat.o(195214);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.LbsInfo
 * JD-Core Version:    0.7.0.1
 */