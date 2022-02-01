package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dz
  extends com.tencent.mm.cd.a
{
  public LinkedList<ed> CRA;
  public ea CRB;
  public String CRC;
  public String CRD;
  
  public dz()
  {
    AppMethodBeat.i(207110);
    this.CRA = new LinkedList();
    AppMethodBeat.o(207110);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207113);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.CRA);
      if (this.CRB != null)
      {
        paramVarArgs.oE(2, this.CRB.computeSize());
        this.CRB.writeFields(paramVarArgs);
      }
      if (this.CRC != null) {
        paramVarArgs.f(3, this.CRC);
      }
      if (this.CRD != null) {
        paramVarArgs.f(4, this.CRD);
      }
      AppMethodBeat.o(207113);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.CRA) + 0;
      paramInt = i;
      if (this.CRB != null) {
        paramInt = i + g.a.a.a.oD(2, this.CRB.computeSize());
      }
      i = paramInt;
      if (this.CRC != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CRC);
      }
      paramInt = i;
      if (this.CRD != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CRD);
      }
      AppMethodBeat.o(207113);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CRA.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207113);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dz localdz = (dz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207113);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ed();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ed)localObject2).parseFrom((byte[])localObject1);
          }
          localdz.CRA.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207113);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ea();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ea)localObject2).parseFrom((byte[])localObject1);
          }
          localdz.CRB = ((ea)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207113);
        return 0;
      case 3: 
        localdz.CRC = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(207113);
        return 0;
      }
      localdz.CRD = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(207113);
      return 0;
    }
    AppMethodBeat.o(207113);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dz
 * JD-Core Version:    0.7.0.1
 */