package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ip;
import f.a.a.b;
import java.util.LinkedList;

public final class bl
  extends ckq
{
  public String ijV;
  public String sbA;
  public boolean scA;
  public LinkedList<String> sch;
  public int scx;
  public int scy;
  public int scz;
  
  public bl()
  {
    AppMethodBeat.i(41777);
    this.sch = new LinkedList();
    AppMethodBeat.o(41777);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41778);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sbA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41778);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.scx);
      paramVarArgs.aR(3, this.scy);
      if (this.sbA != null) {
        paramVarArgs.d(4, this.sbA);
      }
      paramVarArgs.e(5, 1, this.sch);
      if (this.ijV != null) {
        paramVarArgs.d(6, this.ijV);
      }
      paramVarArgs.aR(7, this.scz);
      paramVarArgs.bg(8, this.scA);
      AppMethodBeat.o(41778);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.scx) + f.a.a.b.b.a.bA(3, this.scy);
      paramInt = i;
      if (this.sbA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sbA);
      }
      i = paramInt + f.a.a.a.c(5, 1, this.sch);
      paramInt = i;
      if (this.ijV != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ijV);
      }
      i = f.a.a.b.b.a.bA(7, this.scz);
      int j = f.a.a.b.b.a.fY(8);
      AppMethodBeat.o(41778);
      return paramInt + i + (j + 1);
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
          AppMethodBeat.o(41778);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41778);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bl localbl = (bl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41778);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbl.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41778);
          return 0;
        case 2: 
          localbl.scx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41778);
          return 0;
        case 3: 
          localbl.scy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41778);
          return 0;
        case 4: 
          localbl.sbA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41778);
          return 0;
        case 5: 
          localbl.sch.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(41778);
          return 0;
        case 6: 
          localbl.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41778);
          return 0;
        case 7: 
          localbl.scz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41778);
          return 0;
        }
        localbl.scA = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(41778);
        return 0;
      }
      AppMethodBeat.o(41778);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bl
 * JD-Core Version:    0.7.0.1
 */