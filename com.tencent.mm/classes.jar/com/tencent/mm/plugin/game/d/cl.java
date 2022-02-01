package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cl
  extends com.tencent.mm.bx.a
{
  public int rNT;
  public String sdi;
  public String sdj;
  public boolean sdk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41814);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sdj == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaURL");
        AppMethodBeat.o(41814);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.rNT);
      if (this.sdi != null) {
        paramVarArgs.d(2, this.sdi);
      }
      if (this.sdj != null) {
        paramVarArgs.d(3, this.sdj);
      }
      paramVarArgs.bg(4, this.sdk);
      AppMethodBeat.o(41814);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.rNT) + 0;
      paramInt = i;
      if (this.sdi != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sdi);
      }
      i = paramInt;
      if (this.sdj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sdj);
      }
      paramInt = f.a.a.b.b.a.fY(4);
      AppMethodBeat.o(41814);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.sdj == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaURL");
        AppMethodBeat.o(41814);
        throw paramVarArgs;
      }
      AppMethodBeat.o(41814);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cl localcl = (cl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41814);
        return -1;
      case 1: 
        localcl.rNT = locala.KhF.xS();
        AppMethodBeat.o(41814);
        return 0;
      case 2: 
        localcl.sdi = locala.KhF.readString();
        AppMethodBeat.o(41814);
        return 0;
      case 3: 
        localcl.sdj = locala.KhF.readString();
        AppMethodBeat.o(41814);
        return 0;
      }
      localcl.sdk = locala.KhF.fHu();
      AppMethodBeat.o(41814);
      return 0;
    }
    AppMethodBeat.o(41814);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cl
 * JD-Core Version:    0.7.0.1
 */