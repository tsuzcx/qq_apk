package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.cd.a
{
  public String CMD;
  public int CNe;
  public boolean CNf;
  public int CNg;
  public cv CNh;
  public LinkedList<ab> CNi;
  public String CNj;
  public String CNk;
  public LinkedList<v> CNl;
  public int CNm;
  public String sSV;
  
  public h()
  {
    AppMethodBeat.i(207114);
    this.CNi = new LinkedList();
    this.CNl = new LinkedList();
    AppMethodBeat.o(207114);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207115);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CNe);
      if (this.sSV != null) {
        paramVarArgs.f(2, this.sSV);
      }
      paramVarArgs.co(3, this.CNf);
      paramVarArgs.aY(4, this.CNg);
      if (this.CNh != null)
      {
        paramVarArgs.oE(5, this.CNh.computeSize());
        this.CNh.writeFields(paramVarArgs);
      }
      if (this.CMD != null) {
        paramVarArgs.f(6, this.CMD);
      }
      paramVarArgs.e(7, 8, this.CNi);
      if (this.CNj != null) {
        paramVarArgs.f(8, this.CNj);
      }
      if (this.CNk != null) {
        paramVarArgs.f(9, this.CNk);
      }
      paramVarArgs.e(10, 8, this.CNl);
      paramVarArgs.aY(11, this.CNm);
      AppMethodBeat.o(207115);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.CNe) + 0;
      paramInt = i;
      if (this.sSV != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.sSV);
      }
      i = paramInt + (g.a.a.b.b.a.gL(3) + 1) + g.a.a.b.b.a.bM(4, this.CNg);
      paramInt = i;
      if (this.CNh != null) {
        paramInt = i + g.a.a.a.oD(5, this.CNh.computeSize());
      }
      i = paramInt;
      if (this.CMD != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.CMD);
      }
      i += g.a.a.a.c(7, 8, this.CNi);
      paramInt = i;
      if (this.CNj != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.CNj);
      }
      i = paramInt;
      if (this.CNk != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.CNk);
      }
      paramInt = g.a.a.a.c(10, 8, this.CNl);
      int j = g.a.a.b.b.a.bM(11, this.CNm);
      AppMethodBeat.o(207115);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CNi.clear();
      this.CNl.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207115);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207115);
        return -1;
      case 1: 
        localh.CNe = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(207115);
        return 0;
      case 2: 
        localh.sSV = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(207115);
        return 0;
      case 3: 
        localh.CNf = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(207115);
        return 0;
      case 4: 
        localh.CNg = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(207115);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cv)localObject2).parseFrom((byte[])localObject1);
          }
          localh.CNh = ((cv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207115);
        return 0;
      case 6: 
        localh.CMD = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(207115);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ab();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ab)localObject2).parseFrom((byte[])localObject1);
          }
          localh.CNi.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207115);
        return 0;
      case 8: 
        localh.CNj = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(207115);
        return 0;
      case 9: 
        localh.CNk = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(207115);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new v();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((v)localObject2).parseFrom((byte[])localObject1);
          }
          localh.CNl.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207115);
        return 0;
      }
      localh.CNm = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(207115);
      return 0;
    }
    AppMethodBeat.o(207115);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.h
 * JD-Core Version:    0.7.0.1
 */