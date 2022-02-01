package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cl
  extends com.tencent.mm.bw.a
{
  public int sVK;
  public String tlc;
  public String tld;
  public boolean tle;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41814);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tld == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaURL");
        AppMethodBeat.o(41814);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.sVK);
      if (this.tlc != null) {
        paramVarArgs.d(2, this.tlc);
      }
      if (this.tld != null) {
        paramVarArgs.d(3, this.tld);
      }
      paramVarArgs.bl(4, this.tle);
      AppMethodBeat.o(41814);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.sVK) + 0;
      paramInt = i;
      if (this.tlc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tlc);
      }
      i = paramInt;
      if (this.tld != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tld);
      }
      paramInt = f.a.a.b.b.a.fK(4);
      AppMethodBeat.o(41814);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.tld == null)
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
        localcl.sVK = locala.LVo.xF();
        AppMethodBeat.o(41814);
        return 0;
      case 2: 
        localcl.tlc = locala.LVo.readString();
        AppMethodBeat.o(41814);
        return 0;
      case 3: 
        localcl.tld = locala.LVo.readString();
        AppMethodBeat.o(41814);
        return 0;
      }
      localcl.tle = locala.LVo.fZX();
      AppMethodBeat.o(41814);
      return 0;
    }
    AppMethodBeat.o(41814);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cl
 * JD-Core Version:    0.7.0.1
 */