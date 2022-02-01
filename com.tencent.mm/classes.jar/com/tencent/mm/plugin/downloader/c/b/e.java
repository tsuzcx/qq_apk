package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bw.a
{
  public String oGS;
  public LinkedList<String> oGT;
  public String oGU;
  public String oGV;
  public LinkedList<String> oGW;
  public n oGX;
  public f oGY;
  
  public e()
  {
    AppMethodBeat.i(153063);
    this.oGT = new LinkedList();
    this.oGW = new LinkedList();
    AppMethodBeat.o(153063);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153064);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oGS != null) {
        paramVarArgs.d(1, this.oGS);
      }
      paramVarArgs.e(2, 1, this.oGT);
      if (this.oGU != null) {
        paramVarArgs.d(3, this.oGU);
      }
      if (this.oGV != null) {
        paramVarArgs.d(4, this.oGV);
      }
      paramVarArgs.e(5, 1, this.oGW);
      if (this.oGX != null)
      {
        paramVarArgs.ln(6, this.oGX.computeSize());
        this.oGX.writeFields(paramVarArgs);
      }
      if (this.oGY != null)
      {
        paramVarArgs.ln(7, this.oGY.computeSize());
        this.oGY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oGS == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = f.a.a.b.b.a.e(1, this.oGS) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.oGT);
      paramInt = i;
      if (this.oGU != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGU);
      }
      i = paramInt;
      if (this.oGV != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.oGV);
      }
      i += f.a.a.a.c(5, 1, this.oGW);
      paramInt = i;
      if (this.oGX != null) {
        paramInt = i + f.a.a.a.lm(6, this.oGX.computeSize());
      }
      i = paramInt;
      if (this.oGY != null) {
        i = paramInt + f.a.a.a.lm(7, this.oGY.computeSize());
      }
      AppMethodBeat.o(153064);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.oGT.clear();
        this.oGW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          locale.oGS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 2: 
          locale.oGT.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(153064);
          return 0;
        case 3: 
          locale.oGU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 4: 
          locale.oGV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 5: 
          locale.oGW.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(153064);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new n();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locale.oGX = ((n)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153064);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.oGY = ((f)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.e
 * JD-Core Version:    0.7.0.1
 */