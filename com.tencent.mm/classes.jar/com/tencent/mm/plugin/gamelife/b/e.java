package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public final class e
  extends esc
{
  public a JaG;
  public boolean JaH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267808);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.JaG != null)
      {
        paramVarArgs.qD(2, this.JaG.computeSize());
        this.JaG.writeFields(paramVarArgs);
      }
      paramVarArgs.di(3, this.JaH);
      AppMethodBeat.o(267808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.JaG != null) {
        i = paramInt + i.a.a.a.qC(2, this.JaG.computeSize());
      }
      paramInt = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(267808);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(267808);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(267808);
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
            locale.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(267808);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new a();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((a)localObject2).parseFrom((byte[])localObject1);
            }
            locale.JaG = ((a)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(267808);
          return 0;
        }
        locale.JaH = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(267808);
        return 0;
      }
      AppMethodBeat.o(267808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.e
 * JD-Core Version:    0.7.0.1
 */