package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dg
  extends com.tencent.mm.cd.a
{
  public String CQt;
  public LinkedList<dh> CRc;
  public String CRd;
  
  public dg()
  {
    AppMethodBeat.i(41819);
    this.CRc = new LinkedList();
    AppMethodBeat.o(41819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41820);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.CRc);
      if (this.CQt != null) {
        paramVarArgs.f(2, this.CQt);
      }
      if (this.CRd != null) {
        paramVarArgs.f(3, this.CRd);
      }
      AppMethodBeat.o(41820);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.CRc) + 0;
      paramInt = i;
      if (this.CQt != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CQt);
      }
      i = paramInt;
      if (this.CRd != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CRd);
      }
      AppMethodBeat.o(41820);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CRc.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(41820);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dg localdg = (dg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41820);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dh localdh = new dh();
          if ((localObject != null) && (localObject.length > 0)) {
            localdh.parseFrom((byte[])localObject);
          }
          localdg.CRc.add(localdh);
          paramInt += 1;
        }
        AppMethodBeat.o(41820);
        return 0;
      case 2: 
        localdg.CQt = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(41820);
        return 0;
      }
      localdg.CRd = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(41820);
      return 0;
    }
    AppMethodBeat.o(41820);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dg
 * JD-Core Version:    0.7.0.1
 */