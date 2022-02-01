package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class a
  extends i
{
  public String nDs;
  public b qeb;
  public int qec;
  public int qed;
  public int qee;
  public b qef;
  public b qeg;
  public String qeh;
  public String qei;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qeB != null)
      {
        paramVarArgs.lC(1, this.qeB.computeSize());
        this.qeB.writeFields(paramVarArgs);
      }
      if (this.qeb != null) {
        paramVarArgs.c(2, this.qeb);
      }
      paramVarArgs.aS(3, this.qec);
      paramVarArgs.aS(4, this.qed);
      paramVarArgs.aS(5, this.qee);
      if (this.qef != null) {
        paramVarArgs.c(6, this.qef);
      }
      if (this.qeg != null) {
        paramVarArgs.c(7, this.qeg);
      }
      if (this.qeh != null) {
        paramVarArgs.d(10, this.qeh);
      }
      if (this.qei != null) {
        paramVarArgs.d(11, this.qei);
      }
      if (this.nDs != null) {
        paramVarArgs.d(12, this.nDs);
      }
      AppMethodBeat.o(23485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qeB == null) {
        break label834;
      }
    }
    label834:
    for (paramInt = f.a.a.a.lB(1, this.qeB.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.qeb != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.qeb);
      }
      i = i + f.a.a.b.b.a.bz(3, this.qec) + f.a.a.b.b.a.bz(4, this.qed) + f.a.a.b.b.a.bz(5, this.qee);
      paramInt = i;
      if (this.qef != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.qef);
      }
      i = paramInt;
      if (this.qeg != null) {
        i = paramInt + f.a.a.b.b.a.b(7, this.qeg);
      }
      paramInt = i;
      if (this.qeh != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.qeh);
      }
      i = paramInt;
      if (this.qei != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.qei);
      }
      paramInt = i;
      if (this.nDs != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.nDs);
      }
      AppMethodBeat.o(23485);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(23485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(23485);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, i.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locala.qeB = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23485);
          return 0;
        case 2: 
          locala.qeb = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(23485);
          return 0;
        case 3: 
          locala.qec = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(23485);
          return 0;
        case 4: 
          locala.qed = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(23485);
          return 0;
        case 5: 
          locala.qee = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(23485);
          return 0;
        case 6: 
          locala.qef = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(23485);
          return 0;
        case 7: 
          locala.qeg = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(23485);
          return 0;
        case 10: 
          locala.qeh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(23485);
          return 0;
        case 11: 
          locala.qei = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(23485);
          return 0;
        }
        locala.nDs = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(23485);
        return 0;
      }
      AppMethodBeat.o(23485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a
 * JD-Core Version:    0.7.0.1
 */