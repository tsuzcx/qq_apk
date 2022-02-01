package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class s
  extends com.tencent.mm.bw.a
{
  public String ddB;
  public String ddo;
  public long dpl;
  public int hhc;
  public int hkU;
  public String hkV;
  public String hkW;
  public v hkX;
  public LinkedList<String> hkY;
  public long msgId;
  public int type;
  public String userName;
  
  public s()
  {
    AppMethodBeat.i(116415);
    this.hkY = new LinkedList();
    AppMethodBeat.o(116415);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.msgId);
      paramVarArgs.aO(2, this.dpl);
      if (this.ddB != null) {
        paramVarArgs.d(3, this.ddB);
      }
      paramVarArgs.aR(4, this.hkU);
      paramVarArgs.aR(5, this.type);
      if (this.userName != null) {
        paramVarArgs.d(6, this.userName);
      }
      if (this.ddo != null) {
        paramVarArgs.d(7, this.ddo);
      }
      if (this.hkV != null) {
        paramVarArgs.d(8, this.hkV);
      }
      if (this.hkW != null) {
        paramVarArgs.d(9, this.hkW);
      }
      paramVarArgs.aR(10, this.hhc);
      if (this.hkX != null)
      {
        paramVarArgs.ln(11, this.hkX.computeSize());
        this.hkX.writeFields(paramVarArgs);
      }
      paramVarArgs.e(12, 1, this.hkY);
      AppMethodBeat.o(116416);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.msgId) + 0 + f.a.a.b.b.a.p(2, this.dpl);
      paramInt = i;
      if (this.ddB != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ddB);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.hkU) + f.a.a.b.b.a.bx(5, this.type);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.userName);
      }
      i = paramInt;
      if (this.ddo != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ddo);
      }
      paramInt = i;
      if (this.hkV != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hkV);
      }
      i = paramInt;
      if (this.hkW != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.hkW);
      }
      i += f.a.a.b.b.a.bx(10, this.hhc);
      paramInt = i;
      if (this.hkX != null) {
        paramInt = i + f.a.a.a.lm(11, this.hkX.computeSize());
      }
      i = f.a.a.a.c(12, 1, this.hkY);
      AppMethodBeat.o(116416);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hkY.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        locals.msgId = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(116416);
        return 0;
      case 2: 
        locals.dpl = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(116416);
        return 0;
      case 3: 
        locals.ddB = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 4: 
        locals.hkU = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(116416);
        return 0;
      case 5: 
        locals.type = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(116416);
        return 0;
      case 6: 
        locals.userName = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 7: 
        locals.ddo = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 8: 
        locals.hkV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 9: 
        locals.hkW = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 10: 
        locals.hhc = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(116416);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new v();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((v)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locals.hkX = ((v)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116416);
        return 0;
      }
      locals.hkY.add(((f.a.a.a.a)localObject1).LVo.readString());
      AppMethodBeat.o(116416);
      return 0;
    }
    AppMethodBeat.o(116416);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.s
 * JD-Core Version:    0.7.0.1
 */