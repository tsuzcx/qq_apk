package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class s
  extends com.tencent.mm.bw.a
{
  public String dHc;
  public String dHp;
  public long dTS;
  public int iAf;
  public String iAg;
  public String iAh;
  public v iAi;
  public LinkedList<String> iAj;
  public int iwg;
  public long msgId;
  public int type;
  public String userName;
  
  public s()
  {
    AppMethodBeat.i(116415);
    this.iAj = new LinkedList();
    AppMethodBeat.o(116415);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116416);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.msgId);
      paramVarArgs.bb(2, this.dTS);
      if (this.dHp != null) {
        paramVarArgs.e(3, this.dHp);
      }
      paramVarArgs.aM(4, this.iAf);
      paramVarArgs.aM(5, this.type);
      if (this.userName != null) {
        paramVarArgs.e(6, this.userName);
      }
      if (this.dHc != null) {
        paramVarArgs.e(7, this.dHc);
      }
      if (this.iAg != null) {
        paramVarArgs.e(8, this.iAg);
      }
      if (this.iAh != null) {
        paramVarArgs.e(9, this.iAh);
      }
      paramVarArgs.aM(10, this.iwg);
      if (this.iAi != null)
      {
        paramVarArgs.ni(11, this.iAi.computeSize());
        this.iAi.writeFields(paramVarArgs);
      }
      paramVarArgs.e(12, 1, this.iAj);
      AppMethodBeat.o(116416);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.msgId) + 0 + g.a.a.b.b.a.r(2, this.dTS);
      paramInt = i;
      if (this.dHp != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dHp);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.iAf) + g.a.a.b.b.a.bu(5, this.type);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.userName);
      }
      i = paramInt;
      if (this.dHc != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.dHc);
      }
      paramInt = i;
      if (this.iAg != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.iAg);
      }
      i = paramInt;
      if (this.iAh != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.iAh);
      }
      i += g.a.a.b.b.a.bu(10, this.iwg);
      paramInt = i;
      if (this.iAi != null) {
        paramInt = i + g.a.a.a.nh(11, this.iAi.computeSize());
      }
      i = g.a.a.a.c(12, 1, this.iAj);
      AppMethodBeat.o(116416);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.iAj.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(116416);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      s locals = (s)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(116416);
        return -1;
      case 1: 
        locals.msgId = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(116416);
        return 0;
      case 2: 
        locals.dTS = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(116416);
        return 0;
      case 3: 
        locals.dHp = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 4: 
        locals.iAf = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(116416);
        return 0;
      case 5: 
        locals.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(116416);
        return 0;
      case 6: 
        locals.userName = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 7: 
        locals.dHc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 8: 
        locals.iAg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 9: 
        locals.iAh = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 10: 
        locals.iwg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(116416);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new v();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((v)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locals.iAi = ((v)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116416);
        return 0;
      }
      locals.iAj.add(((g.a.a.a.a)localObject1).UbS.readString());
      AppMethodBeat.o(116416);
      return 0;
    }
    AppMethodBeat.o(116416);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ag.s
 * JD-Core Version:    0.7.0.1
 */