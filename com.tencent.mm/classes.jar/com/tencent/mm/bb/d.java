package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public int dtw;
  public j fRh;
  public LinkedList<e> hPB;
  public int hPC;
  public int hPD;
  public int hPE;
  public String hPF;
  public int hPG;
  public LinkedList<m> hPH;
  public String name;
  public int type;
  
  public d()
  {
    AppMethodBeat.i(150794);
    this.hPB = new LinkedList();
    this.hPH = new LinkedList();
    AppMethodBeat.o(150794);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150795);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.hPB);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      paramVarArgs.aR(3, this.hPC);
      paramVarArgs.aR(4, this.dtw);
      paramVarArgs.aR(5, this.hPD);
      paramVarArgs.aR(6, this.hPE);
      if (this.hPF != null) {
        paramVarArgs.d(7, this.hPF);
      }
      paramVarArgs.aR(8, this.hPG);
      if (this.fRh != null)
      {
        paramVarArgs.ln(9, this.fRh.computeSize());
        this.fRh.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.hPH);
      paramVarArgs.aR(11, this.type);
      AppMethodBeat.o(150795);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.hPB) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.hPC) + f.a.a.b.b.a.bx(4, this.dtw) + f.a.a.b.b.a.bx(5, this.hPD) + f.a.a.b.b.a.bx(6, this.hPE);
      paramInt = i;
      if (this.hPF != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hPF);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.hPG);
      paramInt = i;
      if (this.fRh != null) {
        paramInt = i + f.a.a.a.lm(9, this.fRh.computeSize());
      }
      i = f.a.a.a.c(10, 8, this.hPH);
      int j = f.a.a.b.b.a.bx(11, this.type);
      AppMethodBeat.o(150795);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hPB.clear();
      this.hPH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.hPB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 2: 
        locald.name = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(150795);
        return 0;
      case 3: 
        locald.hPC = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(150795);
        return 0;
      case 4: 
        locald.dtw = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(150795);
        return 0;
      case 5: 
        locald.hPD = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(150795);
        return 0;
      case 6: 
        locald.hPE = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(150795);
        return 0;
      case 7: 
        locald.hPF = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(150795);
        return 0;
      case 8: 
        locald.hPG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(150795);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new j();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.fRh = ((j)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new m();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.hPH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      }
      locald.type = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(150795);
      return 0;
    }
    AppMethodBeat.o(150795);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bb.d
 * JD-Core Version:    0.7.0.1
 */