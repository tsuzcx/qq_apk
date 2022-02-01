package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class s
  extends com.tencent.mm.bw.a
{
  public long dCd;
  public String dpP;
  public String dqc;
  public int hBZ;
  public int hFV;
  public String hFW;
  public String hFX;
  public v hFY;
  public LinkedList<String> hFZ;
  public long msgId;
  public int type;
  public String userName;
  
  public s()
  {
    AppMethodBeat.i(116415);
    this.hFZ = new LinkedList();
    AppMethodBeat.o(116415);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.msgId);
      paramVarArgs.aZ(2, this.dCd);
      if (this.dqc != null) {
        paramVarArgs.d(3, this.dqc);
      }
      paramVarArgs.aS(4, this.hFV);
      paramVarArgs.aS(5, this.type);
      if (this.userName != null) {
        paramVarArgs.d(6, this.userName);
      }
      if (this.dpP != null) {
        paramVarArgs.d(7, this.dpP);
      }
      if (this.hFW != null) {
        paramVarArgs.d(8, this.hFW);
      }
      if (this.hFX != null) {
        paramVarArgs.d(9, this.hFX);
      }
      paramVarArgs.aS(10, this.hBZ);
      if (this.hFY != null)
      {
        paramVarArgs.lJ(11, this.hFY.computeSize());
        this.hFY.writeFields(paramVarArgs);
      }
      paramVarArgs.e(12, 1, this.hFZ);
      AppMethodBeat.o(116416);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.msgId) + 0 + f.a.a.b.b.a.p(2, this.dCd);
      paramInt = i;
      if (this.dqc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dqc);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.hFV) + f.a.a.b.b.a.bz(5, this.type);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.userName);
      }
      i = paramInt;
      if (this.dpP != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dpP);
      }
      paramInt = i;
      if (this.hFW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hFW);
      }
      i = paramInt;
      if (this.hFX != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.hFX);
      }
      i += f.a.a.b.b.a.bz(10, this.hBZ);
      paramInt = i;
      if (this.hFY != null) {
        paramInt = i + f.a.a.a.lI(11, this.hFY.computeSize());
      }
      i = f.a.a.a.c(12, 1, this.hFZ);
      AppMethodBeat.o(116416);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hFZ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        locals.msgId = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(116416);
        return 0;
      case 2: 
        locals.dCd = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(116416);
        return 0;
      case 3: 
        locals.dqc = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 4: 
        locals.hFV = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(116416);
        return 0;
      case 5: 
        locals.type = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(116416);
        return 0;
      case 6: 
        locals.userName = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 7: 
        locals.dpP = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 8: 
        locals.hFW = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 9: 
        locals.hFX = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 10: 
        locals.hBZ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(116416);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new v();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((v)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locals.hFY = ((v)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116416);
        return 0;
      }
      locals.hFZ.add(((f.a.a.a.a)localObject1).OmT.readString());
      AppMethodBeat.o(116416);
      return 0;
    }
    AppMethodBeat.o(116416);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ah.s
 * JD-Core Version:    0.7.0.1
 */