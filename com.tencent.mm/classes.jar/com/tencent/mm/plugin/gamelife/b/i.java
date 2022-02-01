package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public final class i
  extends esc
{
  public c JaL;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267799);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.session_id != null) {
        paramVarArgs.g(2, this.session_id);
      }
      if (this.JaL != null)
      {
        paramVarArgs.qD(3, this.JaL.computeSize());
        this.JaL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(267799);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label478;
      }
    }
    label478:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.session_id);
      }
      i = paramInt;
      if (this.JaL != null) {
        i = paramInt + i.a.a.a.qC(3, this.JaL.computeSize());
      }
      AppMethodBeat.o(267799);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(267799);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(267799);
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
            locali.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(267799);
          return 0;
        case 2: 
          locali.session_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(267799);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new c();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((c)localObject2).parseFrom((byte[])localObject1);
          }
          locali.JaL = ((c)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(267799);
        return 0;
      }
      AppMethodBeat.o(267799);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.i
 * JD-Core Version:    0.7.0.1
 */