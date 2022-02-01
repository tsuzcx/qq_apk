package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.bx.a
{
  public String ID;
  public long mBa;
  public m mBd;
  public int mBf;
  public long mBg;
  public long mBh;
  public int mBi;
  public int mBj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22119);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22119);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.d(1, this.ID);
      }
      paramVarArgs.aG(2, this.mBg);
      paramVarArgs.aG(3, this.mBh);
      paramVarArgs.aR(4, this.mBi);
      paramVarArgs.aR(5, this.mBj);
      paramVarArgs.aG(6, this.mBa);
      if (this.mBd != null)
      {
        paramVarArgs.kX(7, this.mBd.computeSize());
        this.mBd.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.mBf);
      AppMethodBeat.o(22119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label696;
      }
    }
    label696:
    for (paramInt = f.a.a.b.b.a.e(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.mBg) + f.a.a.b.b.a.q(3, this.mBh) + f.a.a.b.b.a.bA(4, this.mBi) + f.a.a.b.b.a.bA(5, this.mBj) + f.a.a.b.b.a.q(6, this.mBa);
      paramInt = i;
      if (this.mBd != null) {
        paramInt = i + f.a.a.a.kW(7, this.mBd.computeSize());
      }
      i = f.a.a.b.b.a.bA(8, this.mBf);
      AppMethodBeat.o(22119);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22119);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22119);
          return -1;
        case 1: 
          localo.ID = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(22119);
          return 0;
        case 2: 
          localo.mBg = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(22119);
          return 0;
        case 3: 
          localo.mBh = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(22119);
          return 0;
        case 4: 
          localo.mBi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(22119);
          return 0;
        case 5: 
          localo.mBj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(22119);
          return 0;
        case 6: 
          localo.mBa = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(22119);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localo.mBd = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22119);
          return 0;
        }
        localo.mBf = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(22119);
        return 0;
      }
      AppMethodBeat.o(22119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.o
 * JD-Core Version:    0.7.0.1
 */