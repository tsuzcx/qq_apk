package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class r
  extends com.tencent.mm.bx.a
{
  public String dHo;
  public String dHp;
  public String fkq;
  public LinkedList<v> hDb;
  public int hDc;
  public String name;
  public int type;
  
  public r()
  {
    AppMethodBeat.i(116413);
    this.hDb = new LinkedList();
    AppMethodBeat.o(116413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116414);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.dHo != null) {
        paramVarArgs.d(3, this.dHo);
      }
      if (this.dHp != null) {
        paramVarArgs.d(4, this.dHp);
      }
      if (this.fkq != null) {
        paramVarArgs.d(5, this.fkq);
      }
      paramVarArgs.e(6, 8, this.hDb);
      paramVarArgs.aS(7, this.hDc);
      AppMethodBeat.o(116414);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.dHo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dHo);
      }
      paramInt = i;
      if (this.dHp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dHp);
      }
      i = paramInt;
      if (this.fkq != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.fkq);
      }
      paramInt = f.a.a.a.c(6, 8, this.hDb);
      int j = f.a.a.b.b.a.bz(7, this.hDc);
      AppMethodBeat.o(116414);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hDb.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
        localr.type = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(116414);
        return 0;
      case 2: 
        localr.name = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 3: 
        localr.dHo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 4: 
        localr.dHp = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 5: 
        localr.fkq = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new v();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((v)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localr.hDb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116414);
        return 0;
      }
      localr.hDc = ((f.a.a.a.a)localObject1).NPN.zc();
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