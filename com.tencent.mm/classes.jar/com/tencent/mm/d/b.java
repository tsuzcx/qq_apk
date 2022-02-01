package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.cd.a
{
  public String apkMd5;
  public int autoAddAccount;
  public int channelId;
  public String faP;
  public String faQ;
  public boolean faR;
  public boolean faS;
  public String profileDeviceType;
  public int updateMode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(944);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.apkMd5 == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: apkMd5");
        AppMethodBeat.o(944);
        throw paramVarArgs;
      }
      if (this.apkMd5 != null) {
        paramVarArgs.f(1, this.apkMd5);
      }
      paramVarArgs.aY(2, this.channelId);
      if (this.profileDeviceType != null) {
        paramVarArgs.f(3, this.profileDeviceType);
      }
      paramVarArgs.aY(4, this.updateMode);
      if (this.faP != null) {
        paramVarArgs.f(5, this.faP);
      }
      if (this.faQ != null) {
        paramVarArgs.f(6, this.faQ);
      }
      paramVarArgs.co(7, this.faR);
      paramVarArgs.aY(8, this.autoAddAccount);
      paramVarArgs.co(9, this.faS);
      AppMethodBeat.o(944);
      return 0;
    }
    if (paramInt == 1) {
      if (this.apkMd5 == null) {
        break label685;
      }
    }
    label685:
    for (paramInt = g.a.a.b.b.a.g(1, this.apkMd5) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.channelId);
      paramInt = i;
      if (this.profileDeviceType != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.profileDeviceType);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.updateMode);
      paramInt = i;
      if (this.faP != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.faP);
      }
      i = paramInt;
      if (this.faQ != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.faQ);
      }
      paramInt = g.a.a.b.b.a.gL(7);
      int j = g.a.a.b.b.a.bM(8, this.autoAddAccount);
      int k = g.a.a.b.b.a.gL(9);
      AppMethodBeat.o(944);
      return i + (paramInt + 1) + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs);; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs))
        {
          if (paramInt <= 0)
          {
            if (this.apkMd5 != null) {
              break;
            }
            paramVarArgs = new g.a.a.b("Not all required fields were included: apkMd5");
            AppMethodBeat.o(944);
            throw paramVarArgs;
          }
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(944);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(944);
          return -1;
        case 1: 
          localb.apkMd5 = locala.abFh.readString();
          AppMethodBeat.o(944);
          return 0;
        case 2: 
          localb.channelId = locala.abFh.AK();
          AppMethodBeat.o(944);
          return 0;
        case 3: 
          localb.profileDeviceType = locala.abFh.readString();
          AppMethodBeat.o(944);
          return 0;
        case 4: 
          localb.updateMode = locala.abFh.AK();
          AppMethodBeat.o(944);
          return 0;
        case 5: 
          localb.faP = locala.abFh.readString();
          AppMethodBeat.o(944);
          return 0;
        case 6: 
          localb.faQ = locala.abFh.readString();
          AppMethodBeat.o(944);
          return 0;
        case 7: 
          localb.faR = locala.abFh.AB();
          AppMethodBeat.o(944);
          return 0;
        case 8: 
          localb.autoAddAccount = locala.abFh.AK();
          AppMethodBeat.o(944);
          return 0;
        }
        localb.faS = locala.abFh.AB();
        AppMethodBeat.o(944);
        return 0;
      }
      AppMethodBeat.o(944);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.d.b
 * JD-Core Version:    0.7.0.1
 */