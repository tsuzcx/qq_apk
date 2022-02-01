package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class r
  extends com.tencent.mm.bx.a
{
  public String dxA;
  public String dxz;
  public String eOT;
  public LinkedList<v> gKs;
  public int gKt;
  public String name;
  public int type;
  
  public r()
  {
    AppMethodBeat.i(116413);
    this.gKs = new LinkedList();
    AppMethodBeat.o(116413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116414);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.dxz != null) {
        paramVarArgs.d(3, this.dxz);
      }
      if (this.dxA != null) {
        paramVarArgs.d(4, this.dxA);
      }
      if (this.eOT != null) {
        paramVarArgs.d(5, this.eOT);
      }
      paramVarArgs.e(6, 8, this.gKs);
      paramVarArgs.aR(7, this.gKt);
      AppMethodBeat.o(116414);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.type) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.dxz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dxz);
      }
      paramInt = i;
      if (this.dxA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dxA);
      }
      i = paramInt;
      if (this.eOT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.eOT);
      }
      paramInt = f.a.a.a.c(6, 8, this.gKs);
      int j = f.a.a.b.b.a.bA(7, this.gKt);
      AppMethodBeat.o(116414);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.gKs.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(116414);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      r localr = (r)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(116414);
        return -1;
      case 1: 
        localr.type = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(116414);
        return 0;
      case 2: 
        localr.name = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 3: 
        localr.dxz = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 4: 
        localr.dxA = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 5: 
        localr.eOT = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new v();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((v)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localr.gKs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116414);
        return 0;
      }
      localr.gKt = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(116414);
      return 0;
    }
    AppMethodBeat.o(116414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.r
 * JD-Core Version:    0.7.0.1
 */