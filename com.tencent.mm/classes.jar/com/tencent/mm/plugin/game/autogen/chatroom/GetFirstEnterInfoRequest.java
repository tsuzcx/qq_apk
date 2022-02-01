package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public class GetFirstEnterInfoRequest
  extends dyl
{
  public Lbs lbs_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195288);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lbs_info != null)
      {
        paramVarArgs.oE(2, this.lbs_info.computeSize());
        this.lbs_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195288);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lbs_info != null) {
        i = paramInt + g.a.a.a.oD(2, this.lbs_info.computeSize());
      }
      AppMethodBeat.o(195288);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195288);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        GetFirstEnterInfoRequest localGetFirstEnterInfoRequest = (GetFirstEnterInfoRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195288);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localGetFirstEnterInfoRequest.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(195288);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new Lbs();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((Lbs)localObject2).parseFrom((byte[])localObject1);
          }
          localGetFirstEnterInfoRequest.lbs_info = ((Lbs)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(195288);
        return 0;
      }
      AppMethodBeat.o(195288);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetFirstEnterInfoRequest
 * JD-Core Version:    0.7.0.1
 */