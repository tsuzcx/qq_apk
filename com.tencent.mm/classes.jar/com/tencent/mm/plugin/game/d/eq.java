package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class eq
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String ikm;
  public String nIJ;
  public String ura;
  public String uuA;
  public String uuo;
  public int uvQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ikm == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(41847);
        throw paramVarArgs;
      }
      if (this.ikm != null) {
        paramVarArgs.d(1, this.ikm);
      }
      if (this.uuo != null) {
        paramVarArgs.d(2, this.uuo);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(3, this.IconUrl);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(4, this.nIJ);
      }
      if (this.uuA != null) {
        paramVarArgs.d(5, this.uuA);
      }
      paramVarArgs.aS(6, this.uvQ);
      if (this.ura != null) {
        paramVarArgs.d(7, this.ura);
      }
      AppMethodBeat.o(41847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ikm == null) {
        break label610;
      }
    }
    label610:
    for (int i = f.a.a.b.b.a.e(1, this.ikm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uuo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uuo);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IconUrl);
      }
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nIJ);
      }
      i = paramInt;
      if (this.uuA != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uuA);
      }
      i += f.a.a.b.b.a.bz(6, this.uvQ);
      paramInt = i;
      if (this.ura != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ura);
      }
      AppMethodBeat.o(41847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.ikm == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(41847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41847);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eq localeq = (eq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41847);
          return -1;
        case 1: 
          localeq.ikm = locala.OmT.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 2: 
          localeq.uuo = locala.OmT.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 3: 
          localeq.IconUrl = locala.OmT.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 4: 
          localeq.nIJ = locala.OmT.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 5: 
          localeq.uuA = locala.OmT.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 6: 
          localeq.uvQ = locala.OmT.zc();
          AppMethodBeat.o(41847);
          return 0;
        }
        localeq.ura = locala.OmT.readString();
        AppMethodBeat.o(41847);
        return 0;
      }
      AppMethodBeat.o(41847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.eq
 * JD-Core Version:    0.7.0.1
 */