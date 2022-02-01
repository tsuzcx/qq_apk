package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class m
  extends com.tencent.mm.bx.a
{
  public String nDr;
  public String nDs;
  public String nDt;
  public String nDu;
  public String nDv;
  public int nDw;
  public long nDx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22117);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDr == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceID");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.nDs == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceName");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.nDt == null)
      {
        paramVarArgs = new b("Not all required fields were included: Model");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.nDu == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemName");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.nDv == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemVersion");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.nDr != null) {
        paramVarArgs.d(1, this.nDr);
      }
      if (this.nDs != null) {
        paramVarArgs.d(2, this.nDs);
      }
      if (this.nDt != null) {
        paramVarArgs.d(3, this.nDt);
      }
      if (this.nDu != null) {
        paramVarArgs.d(4, this.nDu);
      }
      if (this.nDv != null) {
        paramVarArgs.d(5, this.nDv);
      }
      paramVarArgs.aS(6, this.nDw);
      paramVarArgs.aY(7, this.nDx);
      AppMethodBeat.o(22117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDr == null) {
        break label811;
      }
    }
    label811:
    for (int i = f.a.a.b.b.a.e(1, this.nDr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nDs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nDs);
      }
      i = paramInt;
      if (this.nDt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nDt);
      }
      paramInt = i;
      if (this.nDu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nDu);
      }
      i = paramInt;
      if (this.nDv != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nDv);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.nDw);
      int j = f.a.a.b.b.a.p(7, this.nDx);
      AppMethodBeat.o(22117);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.nDr == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceID");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.nDs == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceName");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.nDt == null)
        {
          paramVarArgs = new b("Not all required fields were included: Model");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.nDu == null)
        {
          paramVarArgs = new b("Not all required fields were included: SystemName");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.nDv == null)
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
          localm.nDr = locala.NPN.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 2: 
          localm.nDs = locala.NPN.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 3: 
          localm.nDt = locala.NPN.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 4: 
          localm.nDu = locala.NPN.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 5: 
          localm.nDv = locala.NPN.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 6: 
          localm.nDw = locala.NPN.zc();
          AppMethodBeat.o(22117);
          return 0;
        }
        localm.nDx = locala.NPN.zd();
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