package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class r
  extends com.tencent.mm.cd.a
{
  public String fUd;
  public String fUe;
  public String ilh;
  public int lpA;
  public LinkedList<v> lpz;
  public String name;
  public int type;
  
  public r()
  {
    AppMethodBeat.i(116413);
    this.lpz = new LinkedList();
    AppMethodBeat.o(116413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116414);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.name != null) {
        paramVarArgs.f(2, this.name);
      }
      if (this.fUd != null) {
        paramVarArgs.f(3, this.fUd);
      }
      if (this.fUe != null) {
        paramVarArgs.f(4, this.fUe);
      }
      if (this.ilh != null) {
        paramVarArgs.f(5, this.ilh);
      }
      paramVarArgs.e(6, 8, this.lpz);
      paramVarArgs.aY(7, this.lpA);
      AppMethodBeat.o(116414);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.name);
      }
      i = paramInt;
      if (this.fUd != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fUd);
      }
      paramInt = i;
      if (this.fUe != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.fUe);
      }
      i = paramInt;
      if (this.ilh != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.ilh);
      }
      paramInt = g.a.a.a.c(6, 8, this.lpz);
      int j = g.a.a.b.b.a.bM(7, this.lpA);
      AppMethodBeat.o(116414);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.lpz.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(116414);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      r localr = (r)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(116414);
        return -1;
      case 1: 
        localr.type = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(116414);
        return 0;
      case 2: 
        localr.name = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 3: 
        localr.fUd = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 4: 
        localr.fUe = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 5: 
        localr.ilh = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          v localv = new v();
          if ((localObject != null) && (localObject.length > 0)) {
            localv.parseFrom((byte[])localObject);
          }
          localr.lpz.add(localv);
          paramInt += 1;
        }
        AppMethodBeat.o(116414);
        return 0;
      }
      localr.lpA = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(116414);
      return 0;
    }
    AppMethodBeat.o(116414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.r
 * JD-Core Version:    0.7.0.1
 */