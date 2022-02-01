package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ip;
import f.a.a.b;
import java.util.LinkedList;

public final class bd
  extends ckq
{
  public String ijV;
  public String sbA;
  public int sbB;
  public LinkedList<String> sch;
  public v sci;
  public int scj;
  public boolean sck;
  
  public bd()
  {
    AppMethodBeat.i(41765);
    this.sch = new LinkedList();
    AppMethodBeat.o(41765);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41766);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sbA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41766);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.sbA != null) {
        paramVarArgs.d(2, this.sbA);
      }
      paramVarArgs.e(3, 1, this.sch);
      if (this.ijV != null) {
        paramVarArgs.d(4, this.ijV);
      }
      if (this.sci != null)
      {
        paramVarArgs.kX(5, this.sci.computeSize());
        this.sci.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.scj);
      paramVarArgs.bg(7, this.sck);
      paramVarArgs.aR(8, this.sbB);
      AppMethodBeat.o(41766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sbA != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.sbA);
      }
      i += f.a.a.a.c(3, 1, this.sch);
      paramInt = i;
      if (this.ijV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ijV);
      }
      i = paramInt;
      if (this.sci != null) {
        i = paramInt + f.a.a.a.kW(5, this.sci.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(6, this.scj);
      int j = f.a.a.b.b.a.fY(7);
      int k = f.a.a.b.b.a.bA(8, this.sbB);
      AppMethodBeat.o(41766);
      return i + paramInt + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sch.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.sbA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(41766);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bd localbd = (bd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41766);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbd.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41766);
          return 0;
        case 2: 
          localbd.sbA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41766);
          return 0;
        case 3: 
          localbd.sch.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(41766);
          return 0;
        case 4: 
          localbd.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41766);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new v();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((v)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbd.sci = ((v)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41766);
          return 0;
        case 6: 
          localbd.scj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41766);
          return 0;
        case 7: 
          localbd.sck = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(41766);
          return 0;
        }
        localbd.sbB = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(41766);
        return 0;
      }
      AppMethodBeat.o(41766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bd
 * JD-Core Version:    0.7.0.1
 */