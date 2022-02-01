package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class m
  extends com.tencent.mm.cd.a
{
  public String rVF;
  public String rVG;
  public String rVH;
  public String rVI;
  public String rVJ;
  public int rVK;
  public long rVL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22117);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rVF == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceID");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.rVG == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceName");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.rVH == null)
      {
        paramVarArgs = new b("Not all required fields were included: Model");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.rVI == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemName");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.rVJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemVersion");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.rVF != null) {
        paramVarArgs.f(1, this.rVF);
      }
      if (this.rVG != null) {
        paramVarArgs.f(2, this.rVG);
      }
      if (this.rVH != null) {
        paramVarArgs.f(3, this.rVH);
      }
      if (this.rVI != null) {
        paramVarArgs.f(4, this.rVI);
      }
      if (this.rVJ != null) {
        paramVarArgs.f(5, this.rVJ);
      }
      paramVarArgs.aY(6, this.rVK);
      paramVarArgs.bm(7, this.rVL);
      AppMethodBeat.o(22117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rVF == null) {
        break label811;
      }
    }
    label811:
    for (int i = g.a.a.b.b.a.g(1, this.rVF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rVG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.rVG);
      }
      i = paramInt;
      if (this.rVH != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.rVH);
      }
      paramInt = i;
      if (this.rVI != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.rVI);
      }
      i = paramInt;
      if (this.rVJ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.rVJ);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.rVK);
      int j = g.a.a.b.b.a.p(7, this.rVL);
      AppMethodBeat.o(22117);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.rVF == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceID");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.rVG == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceName");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.rVH == null)
        {
          paramVarArgs = new b("Not all required fields were included: Model");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.rVI == null)
        {
          paramVarArgs = new b("Not all required fields were included: SystemName");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.rVJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: SystemVersion");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22117);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22117);
          return -1;
        case 1: 
          localm.rVF = locala.abFh.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 2: 
          localm.rVG = locala.abFh.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 3: 
          localm.rVH = locala.abFh.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 4: 
          localm.rVI = locala.abFh.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 5: 
          localm.rVJ = locala.abFh.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 6: 
          localm.rVK = locala.abFh.AK();
          AppMethodBeat.o(22117);
          return 0;
        }
        localm.rVL = locala.abFh.AN();
        AppMethodBeat.o(22117);
        return 0;
      }
      AppMethodBeat.o(22117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.m
 * JD-Core Version:    0.7.0.1
 */