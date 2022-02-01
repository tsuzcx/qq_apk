package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.cd.a
{
  public String CNA;
  public LinkedList<bd> CNz;
  
  public m()
  {
    AppMethodBeat.i(41712);
    this.CNz = new LinkedList();
    AppMethodBeat.o(41712);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41713);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.CNz);
      if (this.CNA != null) {
        paramVarArgs.f(2, this.CNA);
      }
      AppMethodBeat.o(41713);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.CNz) + 0;
      paramInt = i;
      if (this.CNA != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CNA);
      }
      AppMethodBeat.o(41713);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CNz.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(41713);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41713);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bd localbd = new bd();
          if ((localObject != null) && (localObject.length > 0)) {
            localbd.parseFrom((byte[])localObject);
          }
          localm.CNz.add(localbd);
          paramInt += 1;
        }
        AppMethodBeat.o(41713);
        return 0;
      }
      localm.CNA = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(41713);
      return 0;
    }
    AppMethodBeat.o(41713);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.m
 * JD-Core Version:    0.7.0.1
 */