package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class r
  extends com.tencent.mm.bw.a
{
  public String dvl;
  public String dvm;
  public String eSb;
  public LinkedList<v> hkS;
  public int hkT;
  public String name;
  public int type;
  
  public r()
  {
    AppMethodBeat.i(116413);
    this.hkS = new LinkedList();
    AppMethodBeat.o(116413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116414);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.dvl != null) {
        paramVarArgs.d(3, this.dvl);
      }
      if (this.dvm != null) {
        paramVarArgs.d(4, this.dvm);
      }
      if (this.eSb != null) {
        paramVarArgs.d(5, this.eSb);
      }
      paramVarArgs.e(6, 8, this.hkS);
      paramVarArgs.aR(7, this.hkT);
      AppMethodBeat.o(116414);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.dvl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dvl);
      }
      paramInt = i;
      if (this.dvm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dvm);
      }
      i = paramInt;
      if (this.eSb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.eSb);
      }
      paramInt = f.a.a.a.c(6, 8, this.hkS);
      int j = f.a.a.b.b.a.bx(7, this.hkT);
      AppMethodBeat.o(116414);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hkS.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(116414);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      r localr = (r)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(116414);
        return -1;
      case 1: 
        localr.type = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(116414);
        return 0;
      case 2: 
        localr.name = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 3: 
        localr.dvl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 4: 
        localr.dvm = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 5: 
        localr.eSb = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new v();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((v)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localr.hkS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116414);
        return 0;
      }
      localr.hkT = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(116414);
      return 0;
    }
    AppMethodBeat.o(116414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.r
 * JD-Core Version:    0.7.0.1
 */