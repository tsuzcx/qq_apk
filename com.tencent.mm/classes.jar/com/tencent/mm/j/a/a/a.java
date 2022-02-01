package com.tencent.mm.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bw.a
{
  public int doy;
  public int drx;
  public LinkedList<b> fBS;
  public String fBT;
  public int fBU;
  public int maxCount;
  public int status;
  public int type;
  
  public a()
  {
    AppMethodBeat.i(42660);
    this.fBS = new LinkedList();
    AppMethodBeat.o(42660);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42661);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.fBS);
      paramVarArgs.aR(2, this.drx);
      paramVarArgs.aR(3, this.type);
      paramVarArgs.aR(4, this.status);
      paramVarArgs.aR(5, this.maxCount);
      if (this.fBT != null) {
        paramVarArgs.d(6, this.fBT);
      }
      paramVarArgs.aR(7, this.doy);
      paramVarArgs.aR(8, this.fBU);
      AppMethodBeat.o(42661);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.fBS) + 0 + f.a.a.b.b.a.bx(2, this.drx) + f.a.a.b.b.a.bx(3, this.type) + f.a.a.b.b.a.bx(4, this.status) + f.a.a.b.b.a.bx(5, this.maxCount);
      paramInt = i;
      if (this.fBT != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.fBT);
      }
      i = f.a.a.b.b.a.bx(7, this.doy);
      int j = f.a.a.b.b.a.bx(8, this.fBU);
      AppMethodBeat.o(42661);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.fBS.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(42661);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      a locala = (a)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(42661);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locala.fBS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(42661);
        return 0;
      case 2: 
        locala.drx = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(42661);
        return 0;
      case 3: 
        locala.type = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(42661);
        return 0;
      case 4: 
        locala.status = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(42661);
        return 0;
      case 5: 
        locala.maxCount = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(42661);
        return 0;
      case 6: 
        locala.fBT = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(42661);
        return 0;
      case 7: 
        locala.doy = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(42661);
        return 0;
      }
      locala.fBU = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(42661);
      return 0;
    }
    AppMethodBeat.o(42661);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.j.a.a.a
 * JD-Core Version:    0.7.0.1
 */