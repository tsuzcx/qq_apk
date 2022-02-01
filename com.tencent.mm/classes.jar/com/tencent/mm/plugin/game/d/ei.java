package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ei
  extends com.tencent.mm.bx.a
{
  public String ufX;
  public String ukA;
  public String uku;
  public String ukv;
  public String ukw;
  public String ukx;
  public int uky;
  public String ukz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41848);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ufX != null) {
        paramVarArgs.d(1, this.ufX);
      }
      if (this.uku != null) {
        paramVarArgs.d(2, this.uku);
      }
      if (this.ukv != null) {
        paramVarArgs.d(3, this.ukv);
      }
      if (this.ukw != null) {
        paramVarArgs.d(4, this.ukw);
      }
      if (this.ukx != null) {
        paramVarArgs.d(5, this.ukx);
      }
      paramVarArgs.aS(6, this.uky);
      if (this.ukz != null) {
        paramVarArgs.d(7, this.ukz);
      }
      if (this.ukA != null) {
        paramVarArgs.d(8, this.ukA);
      }
      AppMethodBeat.o(41848);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ufX == null) {
        break label626;
      }
    }
    label626:
    for (int i = f.a.a.b.b.a.e(1, this.ufX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uku != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uku);
      }
      i = paramInt;
      if (this.ukv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ukv);
      }
      paramInt = i;
      if (this.ukw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ukw);
      }
      i = paramInt;
      if (this.ukx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ukx);
      }
      i += f.a.a.b.b.a.bz(6, this.uky);
      paramInt = i;
      if (this.ukz != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ukz);
      }
      i = paramInt;
      if (this.ukA != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.ukA);
      }
      AppMethodBeat.o(41848);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41848);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ei localei = (ei)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41848);
          return -1;
        case 1: 
          localei.ufX = locala.NPN.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 2: 
          localei.uku = locala.NPN.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 3: 
          localei.ukv = locala.NPN.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 4: 
          localei.ukw = locala.NPN.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 5: 
          localei.ukx = locala.NPN.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 6: 
          localei.uky = locala.NPN.zc();
          AppMethodBeat.o(41848);
          return 0;
        case 7: 
          localei.ukz = locala.NPN.readString();
          AppMethodBeat.o(41848);
          return 0;
        }
        localei.ukA = locala.NPN.readString();
        AppMethodBeat.o(41848);
        return 0;
      }
      AppMethodBeat.o(41848);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ei
 * JD-Core Version:    0.7.0.1
 */