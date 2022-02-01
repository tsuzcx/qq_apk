package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cs
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String Title;
  public String hnC;
  public String rZn;
  public f rZp;
  public String saD;
  public String sbz;
  public LinkedList<z> sdt;
  
  public cs()
  {
    AppMethodBeat.i(41823);
    this.sdt = new LinkedList();
    AppMethodBeat.o(41823);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41824);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      if (this.rZn != null) {
        paramVarArgs.d(3, this.rZn);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.sbz != null) {
        paramVarArgs.d(5, this.sbz);
      }
      if (this.rZp != null)
      {
        paramVarArgs.kX(6, this.rZp.computeSize());
        this.rZp.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.sdt);
      if (this.saD != null) {
        paramVarArgs.d(8, this.saD);
      }
      AppMethodBeat.o(41824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label818;
      }
    }
    label818:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = paramInt;
      if (this.rZn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.rZn);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      i = paramInt;
      if (this.sbz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.sbz);
      }
      paramInt = i;
      if (this.rZp != null) {
        paramInt = i + f.a.a.a.kW(6, this.rZp.computeSize());
      }
      i = paramInt + f.a.a.a.c(7, 8, this.sdt);
      paramInt = i;
      if (this.saD != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.saD);
      }
      AppMethodBeat.o(41824);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sdt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cs localcs = (cs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41824);
          return -1;
        case 1: 
          localcs.Title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 2: 
          localcs.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 3: 
          localcs.rZn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 4: 
          localcs.Desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 5: 
          localcs.sbz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcs.rZp = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41824);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new z();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((z)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcs.sdt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41824);
          return 0;
        }
        localcs.saD = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41824);
        return 0;
      }
      AppMethodBeat.o(41824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cs
 * JD-Core Version:    0.7.0.1
 */