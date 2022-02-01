package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> pkA;
  public n pkB;
  public f pkC;
  public String pkw;
  public LinkedList<String> pkx;
  public String pky;
  public String pkz;
  
  public e()
  {
    AppMethodBeat.i(153063);
    this.pkx = new LinkedList();
    this.pkA = new LinkedList();
    AppMethodBeat.o(153063);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153064);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pkw != null) {
        paramVarArgs.d(1, this.pkw);
      }
      paramVarArgs.e(2, 1, this.pkx);
      if (this.pky != null) {
        paramVarArgs.d(3, this.pky);
      }
      if (this.pkz != null) {
        paramVarArgs.d(4, this.pkz);
      }
      paramVarArgs.e(5, 1, this.pkA);
      if (this.pkB != null)
      {
        paramVarArgs.lC(6, this.pkB.computeSize());
        this.pkB.writeFields(paramVarArgs);
      }
      if (this.pkC != null)
      {
        paramVarArgs.lC(7, this.pkC.computeSize());
        this.pkC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pkw == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = f.a.a.b.b.a.e(1, this.pkw) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.pkx);
      paramInt = i;
      if (this.pky != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.pky);
      }
      i = paramInt;
      if (this.pkz != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.pkz);
      }
      i += f.a.a.a.c(5, 1, this.pkA);
      paramInt = i;
      if (this.pkB != null) {
        paramInt = i + f.a.a.a.lB(6, this.pkB.computeSize());
      }
      i = paramInt;
      if (this.pkC != null) {
        i = paramInt + f.a.a.a.lB(7, this.pkC.computeSize());
      }
      AppMethodBeat.o(153064);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.pkx.clear();
        this.pkA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153064);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153064);
          return -1;
        case 1: 
          locale.pkw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 2: 
          locale.pkx.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(153064);
          return 0;
        case 3: 
          locale.pky = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 4: 
          locale.pkz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 5: 
          locale.pkA.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(153064);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new n();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locale.pkB = ((n)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153064);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.pkC = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153064);
        return 0;
      }
      AppMethodBeat.o(153064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.e
 * JD-Core Version:    0.7.0.1
 */