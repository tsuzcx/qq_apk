package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class m
  extends com.tencent.mm.bx.a
{
  public String mAT;
  public String mAU;
  public String mAV;
  public String mAW;
  public String mAX;
  public int mAY;
  public long mAZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22117);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAT == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceID");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.mAU == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceName");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.mAV == null)
      {
        paramVarArgs = new b("Not all required fields were included: Model");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.mAW == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemName");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.mAX == null)
      {
        paramVarArgs = new b("Not all required fields were included: SystemVersion");
        AppMethodBeat.o(22117);
        throw paramVarArgs;
      }
      if (this.mAT != null) {
        paramVarArgs.d(1, this.mAT);
      }
      if (this.mAU != null) {
        paramVarArgs.d(2, this.mAU);
      }
      if (this.mAV != null) {
        paramVarArgs.d(3, this.mAV);
      }
      if (this.mAW != null) {
        paramVarArgs.d(4, this.mAW);
      }
      if (this.mAX != null) {
        paramVarArgs.d(5, this.mAX);
      }
      paramVarArgs.aR(6, this.mAY);
      paramVarArgs.aG(7, this.mAZ);
      AppMethodBeat.o(22117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAT == null) {
        break label811;
      }
    }
    label811:
    for (int i = f.a.a.b.b.a.e(1, this.mAT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mAU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mAU);
      }
      i = paramInt;
      if (this.mAV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mAV);
      }
      paramInt = i;
      if (this.mAW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mAW);
      }
      i = paramInt;
      if (this.mAX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.mAX);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.mAY);
      int j = f.a.a.b.b.a.q(7, this.mAZ);
      AppMethodBeat.o(22117);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.mAT == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceID");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.mAU == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceName");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.mAV == null)
        {
          paramVarArgs = new b("Not all required fields were included: Model");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.mAW == null)
        {
          paramVarArgs = new b("Not all required fields were included: SystemName");
          AppMethodBeat.o(22117);
          throw paramVarArgs;
        }
        if (this.mAX == null)
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
          localm.mAT = locala.KhF.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 2: 
          localm.mAU = locala.KhF.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 3: 
          localm.mAV = locala.KhF.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 4: 
          localm.mAW = locala.KhF.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 5: 
          localm.mAX = locala.KhF.readString();
          AppMethodBeat.o(22117);
          return 0;
        case 6: 
          localm.mAY = locala.KhF.xS();
          AppMethodBeat.o(22117);
          return 0;
        }
        localm.mAZ = locala.KhF.xT();
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