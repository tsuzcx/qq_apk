package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import g.a.a.b;
import java.util.LinkedList;

public final class bp
  extends dyy
{
  public aq CPS;
  public at CPT;
  public au CPU;
  public cm CPV;
  public eh CPW;
  public ay CPX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41767);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41767);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.CPS != null)
      {
        paramVarArgs.oE(3, this.CPS.computeSize());
        this.CPS.writeFields(paramVarArgs);
      }
      if (this.CPT != null)
      {
        paramVarArgs.oE(4, this.CPT.computeSize());
        this.CPT.writeFields(paramVarArgs);
      }
      if (this.CPU != null)
      {
        paramVarArgs.oE(5, this.CPU.computeSize());
        this.CPU.writeFields(paramVarArgs);
      }
      if (this.CPV != null)
      {
        paramVarArgs.oE(6, this.CPV.computeSize());
        this.CPV.writeFields(paramVarArgs);
      }
      if (this.CPW != null)
      {
        paramVarArgs.oE(8, this.CPW.computeSize());
        this.CPW.writeFields(paramVarArgs);
      }
      if (this.CPX != null)
      {
        paramVarArgs.oE(9, this.CPX.computeSize());
        this.CPX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41767);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1144;
      }
    }
    label1144:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CPS != null) {
        paramInt = i + g.a.a.a.oD(3, this.CPS.computeSize());
      }
      i = paramInt;
      if (this.CPT != null) {
        i = paramInt + g.a.a.a.oD(4, this.CPT.computeSize());
      }
      paramInt = i;
      if (this.CPU != null) {
        paramInt = i + g.a.a.a.oD(5, this.CPU.computeSize());
      }
      i = paramInt;
      if (this.CPV != null) {
        i = paramInt + g.a.a.a.oD(6, this.CPV.computeSize());
      }
      paramInt = i;
      if (this.CPW != null) {
        paramInt = i + g.a.a.a.oD(8, this.CPW.computeSize());
      }
      i = paramInt;
      if (this.CPX != null) {
        i = paramInt + g.a.a.a.oD(9, this.CPX.computeSize());
      }
      AppMethodBeat.o(41767);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41767);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41767);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bp localbp = (bp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 2: 
        case 7: 
        default: 
          AppMethodBeat.o(41767);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbp.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aq)localObject2).parseFrom((byte[])localObject1);
            }
            localbp.CPS = ((aq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new at();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((at)localObject2).parseFrom((byte[])localObject1);
            }
            localbp.CPT = ((at)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new au();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((au)localObject2).parseFrom((byte[])localObject1);
            }
            localbp.CPU = ((au)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cm)localObject2).parseFrom((byte[])localObject1);
            }
            localbp.CPV = ((cm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eh)localObject2).parseFrom((byte[])localObject1);
            }
            localbp.CPW = ((eh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ay();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ay)localObject2).parseFrom((byte[])localObject1);
          }
          localbp.CPX = ((ay)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41767);
        return 0;
      }
      AppMethodBeat.o(41767);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bp
 * JD-Core Version:    0.7.0.1
 */