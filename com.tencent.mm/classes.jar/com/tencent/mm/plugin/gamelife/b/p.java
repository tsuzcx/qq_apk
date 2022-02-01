package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import g.a.a.b;
import java.util.LinkedList;

public final class p
  extends dyl
{
  public a DgM;
  public boolean DgW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203934);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.DgM == null)
      {
        paramVarArgs = new b("Not all required fields were included: black_list_info");
        AppMethodBeat.o(203934);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DgM != null)
      {
        paramVarArgs.oE(2, this.DgM.computeSize());
        this.DgM.writeFields(paramVarArgs);
      }
      paramVarArgs.co(3, this.DgW);
      AppMethodBeat.o(203934);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DgM != null) {
        i = paramInt + g.a.a.a.oD(2, this.DgM.computeSize());
      }
      paramInt = g.a.a.b.b.a.gL(3);
      AppMethodBeat.o(203934);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.DgM == null)
        {
          paramVarArgs = new b("Not all required fields were included: black_list_info");
          AppMethodBeat.o(203934);
          throw paramVarArgs;
        }
        AppMethodBeat.o(203934);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203934);
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
            localp.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(203934);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new a();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((a)localObject2).parseFrom((byte[])localObject1);
            }
            localp.DgM = ((a)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(203934);
          return 0;
        }
        localp.DgW = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(203934);
        return 0;
      }
      AppMethodBeat.o(203934);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.p
 * JD-Core Version:    0.7.0.1
 */