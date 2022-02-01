package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ac
  extends com.tencent.mm.bx.a
{
  public int mAw;
  public q mBZ;
  public int mBi;
  public p mCa;
  public r mCb;
  public s mCc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22135);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mAw);
      paramVarArgs.aR(2, this.mBi);
      if (this.mBZ != null)
      {
        paramVarArgs.kX(3, this.mBZ.computeSize());
        this.mBZ.writeFields(paramVarArgs);
      }
      if (this.mCa != null)
      {
        paramVarArgs.kX(4, this.mCa.computeSize());
        this.mCa.writeFields(paramVarArgs);
      }
      if (this.mCb != null)
      {
        paramVarArgs.kX(5, this.mCb.computeSize());
        this.mCb.writeFields(paramVarArgs);
      }
      if (this.mCc != null)
      {
        paramVarArgs.kX(6, this.mCc.computeSize());
        this.mCc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.mAw) + 0 + f.a.a.b.b.a.bA(2, this.mBi);
      paramInt = i;
      if (this.mBZ != null) {
        paramInt = i + f.a.a.a.kW(3, this.mBZ.computeSize());
      }
      i = paramInt;
      if (this.mCa != null) {
        i = paramInt + f.a.a.a.kW(4, this.mCa.computeSize());
      }
      paramInt = i;
      if (this.mCb != null) {
        paramInt = i + f.a.a.a.kW(5, this.mCb.computeSize());
      }
      i = paramInt;
      if (this.mCc != null) {
        i = paramInt + f.a.a.a.kW(6, this.mCc.computeSize());
      }
      AppMethodBeat.o(22135);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ac localac = (ac)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(22135);
        return -1;
      case 1: 
        localac.mAw = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(22135);
        return 0;
      case 2: 
        localac.mBi = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(22135);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new q();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((q)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localac.mBZ = ((q)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localac.mCa = ((p)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new r();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localac.mCb = ((r)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new s();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((s)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localac.mCc = ((s)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    AppMethodBeat.o(22135);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ac
 * JD-Core Version:    0.7.0.1
 */