package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.bx.a
{
  public String ID;
  public long mBa;
  public long mBb;
  public long mBc;
  public m mBd;
  public long mBe;
  public int mBf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22118);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22118);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.d(1, this.ID);
      }
      paramVarArgs.aG(2, this.mBa);
      paramVarArgs.aG(3, this.mBb);
      paramVarArgs.aG(4, this.mBc);
      if (this.mBd != null)
      {
        paramVarArgs.kX(5, this.mBd.computeSize());
        this.mBd.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(6, this.mBe);
      paramVarArgs.aR(7, this.mBf);
      AppMethodBeat.o(22118);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label655;
      }
    }
    label655:
    for (paramInt = f.a.a.b.b.a.e(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.mBa) + f.a.a.b.b.a.q(3, this.mBb) + f.a.a.b.b.a.q(4, this.mBc);
      paramInt = i;
      if (this.mBd != null) {
        paramInt = i + f.a.a.a.kW(5, this.mBd.computeSize());
      }
      i = f.a.a.b.b.a.q(6, this.mBe);
      int j = f.a.a.b.b.a.bA(7, this.mBf);
      AppMethodBeat.o(22118);
      return paramInt + i + j;
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
          AppMethodBeat.o(22118);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22118);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22118);
          return -1;
        case 1: 
          localn.ID = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(22118);
          return 0;
        case 2: 
          localn.mBa = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(22118);
          return 0;
        case 3: 
          localn.mBb = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(22118);
          return 0;
        case 4: 
          localn.mBc = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(22118);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localn.mBd = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22118);
          return 0;
        case 6: 
          localn.mBe = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(22118);
          return 0;
        }
        localn.mBf = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(22118);
        return 0;
      }
      AppMethodBeat.o(22118);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.n
 * JD-Core Version:    0.7.0.1
 */