package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class s
  extends com.tencent.mm.bx.a
{
  public String dfT;
  public String dgg;
  public long drA;
  public int gGB;
  public int gKu;
  public String gKv;
  public String gKw;
  public v gKx;
  public LinkedList<String> gKy;
  public long msgId;
  public int type;
  public String userName;
  
  public s()
  {
    AppMethodBeat.i(116415);
    this.gKy = new LinkedList();
    AppMethodBeat.o(116415);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.msgId);
      paramVarArgs.aG(2, this.drA);
      if (this.dgg != null) {
        paramVarArgs.d(3, this.dgg);
      }
      paramVarArgs.aR(4, this.gKu);
      paramVarArgs.aR(5, this.type);
      if (this.userName != null) {
        paramVarArgs.d(6, this.userName);
      }
      if (this.dfT != null) {
        paramVarArgs.d(7, this.dfT);
      }
      if (this.gKv != null) {
        paramVarArgs.d(8, this.gKv);
      }
      if (this.gKw != null) {
        paramVarArgs.d(9, this.gKw);
      }
      paramVarArgs.aR(10, this.gGB);
      if (this.gKx != null)
      {
        paramVarArgs.kX(11, this.gKx.computeSize());
        this.gKx.writeFields(paramVarArgs);
      }
      paramVarArgs.e(12, 1, this.gKy);
      AppMethodBeat.o(116416);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.msgId) + 0 + f.a.a.b.b.a.q(2, this.drA);
      paramInt = i;
      if (this.dgg != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dgg);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.gKu) + f.a.a.b.b.a.bA(5, this.type);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.userName);
      }
      i = paramInt;
      if (this.dfT != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dfT);
      }
      paramInt = i;
      if (this.gKv != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.gKv);
      }
      i = paramInt;
      if (this.gKw != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.gKw);
      }
      i += f.a.a.b.b.a.bA(10, this.gGB);
      paramInt = i;
      if (this.gKx != null) {
        paramInt = i + f.a.a.a.kW(11, this.gKx.computeSize());
      }
      i = f.a.a.a.c(12, 1, this.gKy);
      AppMethodBeat.o(116416);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.gKy.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        locals.msgId = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(116416);
        return 0;
      case 2: 
        locals.drA = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(116416);
        return 0;
      case 3: 
        locals.dgg = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 4: 
        locals.gKu = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(116416);
        return 0;
      case 5: 
        locals.type = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(116416);
        return 0;
      case 6: 
        locals.userName = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 7: 
        locals.dfT = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 8: 
        locals.gKv = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 9: 
        locals.gKw = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 10: 
        locals.gGB = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(116416);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new v();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((v)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locals.gKx = ((v)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116416);
        return 0;
      }
      locals.gKy.add(((f.a.a.a.a)localObject1).KhF.readString());
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