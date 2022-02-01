package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dn
  extends com.tencent.mm.bw.a
{
  public String Label;
  public String nIJ;
  public int uvb;
  public long uvc;
  public boolean uvd;
  public int uve;
  public String uvf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41828);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(41828);
        throw paramVarArgs;
      }
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      paramVarArgs.aS(2, this.uvb);
      paramVarArgs.aZ(3, this.uvc);
      if (this.Label != null) {
        paramVarArgs.d(4, this.Label);
      }
      paramVarArgs.bC(5, this.uvd);
      paramVarArgs.aS(6, this.uve);
      if (this.uvf != null) {
        paramVarArgs.d(7, this.uvf);
      }
      AppMethodBeat.o(41828);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.b.b.a.e(1, this.nIJ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.uvb) + f.a.a.b.b.a.p(3, this.uvc);
      paramInt = i;
      if (this.Label != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Label);
      }
      i = paramInt + f.a.a.b.b.a.amF(5) + f.a.a.b.b.a.bz(6, this.uve);
      paramInt = i;
      if (this.uvf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.uvf);
      }
      AppMethodBeat.o(41828);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.nIJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(41828);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41828);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dn localdn = (dn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41828);
          return -1;
        case 1: 
          localdn.nIJ = locala.OmT.readString();
          AppMethodBeat.o(41828);
          return 0;
        case 2: 
          localdn.uvb = locala.OmT.zc();
          AppMethodBeat.o(41828);
          return 0;
        case 3: 
          localdn.uvc = locala.OmT.zd();
          AppMethodBeat.o(41828);
          return 0;
        case 4: 
          localdn.Label = locala.OmT.readString();
          AppMethodBeat.o(41828);
          return 0;
        case 5: 
          localdn.uvd = locala.OmT.gvY();
          AppMethodBeat.o(41828);
          return 0;
        case 6: 
          localdn.uve = locala.OmT.zc();
          AppMethodBeat.o(41828);
          return 0;
        }
        localdn.uvf = locala.OmT.readString();
        AppMethodBeat.o(41828);
        return 0;
      }
      AppMethodBeat.o(41828);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dn
 * JD-Core Version:    0.7.0.1
 */