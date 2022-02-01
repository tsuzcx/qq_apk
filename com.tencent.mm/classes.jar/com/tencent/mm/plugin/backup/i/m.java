package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class m
  extends com.tencent.mm.bw.a
{
  public String ncU;
  public String ncV;
  public String ncW;
  public String ncX;
  public String ncY;
  public int ncZ;
  public long nda;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22117);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncU == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceID");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.ncV == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceName");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.ncW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Model");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.ncX == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemName");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.ncY == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemVersion");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.ncU != null) {
        paramVarArgs.d(1, this.ncU);
      }
      if (this.ncV != null) {
        paramVarArgs.d(2, this.ncV);
      }
      if (this.ncW != null) {
        paramVarArgs.d(3, this.ncW);
      }
      if (this.ncX != null) {
        paramVarArgs.d(4, this.ncX);
      }
      if (this.ncY != null) {
        paramVarArgs.d(5, this.ncY);
      }
      paramVarArgs.aR(6, this.ncZ);
      paramVarArgs.aO(7, this.nda);
      AppMethodBeat.o(22117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncU == null) {
        break label811;
      }
    }
    label811:
    for (int i = f.a.a.b.b.a.e(1, this.ncU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ncV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ncV);
      }
      i = paramInt;
      if (this.ncW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ncW);
      }
      paramInt = i;
      if (this.ncX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ncX);
      }
      i = paramInt;
      if (this.ncY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ncY);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.ncZ);
      int j = f.a.a.b.b.a.p(7, this.nda);
      AppMethodBeat.o(22117);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ncU == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceID");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.ncV == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceName");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.ncW == null)
        {
          paramVarArgs = new b("Not all required fields were included: Model");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.ncX == null)
        {
          paramVarArgs = new b("Not all required fields were included: SystemName");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.ncY == null)
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22117);
          return -1;
        case 1: 
          localm.ncU = locala.LVo.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 2: 
          localm.ncV = locala.LVo.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 3: 
          localm.ncW = locala.LVo.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 4: 
          localm.ncX = locala.LVo.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 5: 
          localm.ncY = locala.LVo.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 6: 
          localm.ncZ = locala.LVo.xF();
          AppMethodBeat.o(22117);
          return 0;
        }
        localm.nda = locala.LVo.xG();
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