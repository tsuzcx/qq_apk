package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public int dvJ;
  public j fNw;
  public LinkedList<e> hoZ;
  public int hpa;
  public int hpb;
  public int hpc;
  public String hpd;
  public int hpe;
  public LinkedList<m> hpf;
  public String name;
  public int type;
  
  public d()
  {
    AppMethodBeat.i(150794);
    this.hoZ = new LinkedList();
    this.hpf = new LinkedList();
    AppMethodBeat.o(150794);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150795);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.hoZ);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      paramVarArgs.aR(3, this.hpa);
      paramVarArgs.aR(4, this.dvJ);
      paramVarArgs.aR(5, this.hpb);
      paramVarArgs.aR(6, this.hpc);
      if (this.hpd != null) {
        paramVarArgs.d(7, this.hpd);
      }
      paramVarArgs.aR(8, this.hpe);
      if (this.fNw != null)
      {
        paramVarArgs.kX(9, this.fNw.computeSize());
        this.fNw.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.hpf);
      paramVarArgs.aR(11, this.type);
      AppMethodBeat.o(150795);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.hoZ) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.hpa) + f.a.a.b.b.a.bA(4, this.dvJ) + f.a.a.b.b.a.bA(5, this.hpb) + f.a.a.b.b.a.bA(6, this.hpc);
      paramInt = i;
      if (this.hpd != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hpd);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.hpe);
      paramInt = i;
      if (this.fNw != null) {
        paramInt = i + f.a.a.a.kW(9, this.fNw.computeSize());
      }
      i = f.a.a.a.c(10, 8, this.hpf);
      int j = f.a.a.b.b.a.bA(11, this.type);
      AppMethodBeat.o(150795);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hoZ.clear();
      this.hpf.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(150795);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(150795);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.hoZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 2: 
        locald.name = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(150795);
        return 0;
      case 3: 
        locald.hpa = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(150795);
        return 0;
      case 4: 
        locald.dvJ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(150795);
        return 0;
      case 5: 
        locald.hpb = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(150795);
        return 0;
      case 6: 
        locald.hpc = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(150795);
        return 0;
      case 7: 
        locald.hpd = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(150795);
        return 0;
      case 8: 
        locald.hpe = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(150795);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new j();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.fNw = ((j)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new m();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.hpf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      }
      locald.type = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(150795);
      return 0;
    }
    AppMethodBeat.o(150795);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bc.d
 * JD-Core Version:    0.7.0.1
 */