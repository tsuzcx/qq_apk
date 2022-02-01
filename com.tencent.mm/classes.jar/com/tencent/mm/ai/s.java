package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class s
  extends com.tencent.mm.bx.a
{
  public long dAY;
  public String doK;
  public String doX;
  public int hDd;
  public String hDe;
  public String hDf;
  public v hDg;
  public LinkedList<String> hDh;
  public int hzl;
  public long msgId;
  public int type;
  public String userName;
  
  public s()
  {
    AppMethodBeat.i(116415);
    this.hDh = new LinkedList();
    AppMethodBeat.o(116415);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.msgId);
      paramVarArgs.aY(2, this.dAY);
      if (this.doX != null) {
        paramVarArgs.d(3, this.doX);
      }
      paramVarArgs.aS(4, this.hDd);
      paramVarArgs.aS(5, this.type);
      if (this.userName != null) {
        paramVarArgs.d(6, this.userName);
      }
      if (this.doK != null) {
        paramVarArgs.d(7, this.doK);
      }
      if (this.hDe != null) {
        paramVarArgs.d(8, this.hDe);
      }
      if (this.hDf != null) {
        paramVarArgs.d(9, this.hDf);
      }
      paramVarArgs.aS(10, this.hzl);
      if (this.hDg != null)
      {
        paramVarArgs.lC(11, this.hDg.computeSize());
        this.hDg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(12, 1, this.hDh);
      AppMethodBeat.o(116416);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.msgId) + 0 + f.a.a.b.b.a.p(2, this.dAY);
      paramInt = i;
      if (this.doX != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.doX);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.hDd) + f.a.a.b.b.a.bz(5, this.type);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.userName);
      }
      i = paramInt;
      if (this.doK != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.doK);
      }
      paramInt = i;
      if (this.hDe != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hDe);
      }
      i = paramInt;
      if (this.hDf != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.hDf);
      }
      i += f.a.a.b.b.a.bz(10, this.hzl);
      paramInt = i;
      if (this.hDg != null) {
        paramInt = i + f.a.a.a.lB(11, this.hDg.computeSize());
      }
      i = f.a.a.a.c(12, 1, this.hDh);
      AppMethodBeat.o(116416);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hDh.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(116416);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      s locals = (s)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(116416);
        return -1;
      case 1: 
        locals.msgId = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(116416);
        return 0;
      case 2: 
        locals.dAY = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(116416);
        return 0;
      case 3: 
        locals.doX = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 4: 
        locals.hDd = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(116416);
        return 0;
      case 5: 
        locals.type = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(116416);
        return 0;
      case 6: 
        locals.userName = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 7: 
        locals.doK = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 8: 
        locals.hDe = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 9: 
        locals.hDf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 10: 
        locals.hzl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(116416);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new v();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((v)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locals.hDg = ((v)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116416);
        return 0;
      }
      locals.hDh.add(((f.a.a.a.a)localObject1).NPN.readString());
      AppMethodBeat.o(116416);
      return 0;
    }
    AppMethodBeat.o(116416);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.s
 * JD-Core Version:    0.7.0.1
 */