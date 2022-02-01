package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cvp;
import f.a.a.b;
import java.util.LinkedList;

public final class bh
  extends cvp
{
  public ai uii;
  public al uij;
  public am uik;
  public ce uil;
  public dx uim;
  public aq uio;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41767);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41767);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.uii != null)
      {
        paramVarArgs.lC(3, this.uii.computeSize());
        this.uii.writeFields(paramVarArgs);
      }
      if (this.uij != null)
      {
        paramVarArgs.lC(4, this.uij.computeSize());
        this.uij.writeFields(paramVarArgs);
      }
      if (this.uik != null)
      {
        paramVarArgs.lC(5, this.uik.computeSize());
        this.uik.writeFields(paramVarArgs);
      }
      if (this.uil != null)
      {
        paramVarArgs.lC(6, this.uil.computeSize());
        this.uil.writeFields(paramVarArgs);
      }
      if (this.uim != null)
      {
        paramVarArgs.lC(8, this.uim.computeSize());
        this.uim.writeFields(paramVarArgs);
      }
      if (this.uio != null)
      {
        paramVarArgs.lC(9, this.uio.computeSize());
        this.uio.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41767);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1298;
      }
    }
    label1298:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uii != null) {
        paramInt = i + f.a.a.a.lB(3, this.uii.computeSize());
      }
      i = paramInt;
      if (this.uij != null) {
        i = paramInt + f.a.a.a.lB(4, this.uij.computeSize());
      }
      paramInt = i;
      if (this.uik != null) {
        paramInt = i + f.a.a.a.lB(5, this.uik.computeSize());
      }
      i = paramInt;
      if (this.uil != null) {
        i = paramInt + f.a.a.a.lB(6, this.uil.computeSize());
      }
      paramInt = i;
      if (this.uim != null) {
        paramInt = i + f.a.a.a.lB(8, this.uim.computeSize());
      }
      i = paramInt;
      if (this.uio != null) {
        i = paramInt + f.a.a.a.lB(9, this.uio.computeSize());
      }
      AppMethodBeat.o(41767);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bh localbh = (bh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 7: 
        default: 
          AppMethodBeat.o(41767);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ai();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbh.uii = ((ai)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new al();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((al)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbh.uij = ((al)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new am();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((am)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbh.uik = ((am)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ce();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ce)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbh.uil = ((ce)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbh.uim = ((dx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbh.uio = ((aq)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bh
 * JD-Core Version:    0.7.0.1
 */