package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends com.tencent.mm.bx.a
{
  public String appId;
  public String doD;
  public String ijb;
  public String ijc;
  public String ijd;
  public String ije;
  public String ijf;
  public String ijg;
  public String ijh;
  public String iji;
  public String ijj;
  public String ijk;
  public String ijl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150806);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.d(1, this.appId);
      }
      if (this.ijb != null) {
        paramVarArgs.d(2, this.ijb);
      }
      if (this.ijc != null) {
        paramVarArgs.d(3, this.ijc);
      }
      if (this.ijd != null) {
        paramVarArgs.d(4, this.ijd);
      }
      if (this.ije != null) {
        paramVarArgs.d(5, this.ije);
      }
      if (this.ijf != null) {
        paramVarArgs.d(6, this.ijf);
      }
      if (this.doD != null) {
        paramVarArgs.d(7, this.doD);
      }
      if (this.ijg != null) {
        paramVarArgs.d(8, this.ijg);
      }
      if (this.ijh != null) {
        paramVarArgs.d(9, this.ijh);
      }
      if (this.iji != null) {
        paramVarArgs.d(10, this.iji);
      }
      if (this.ijj != null) {
        paramVarArgs.d(11, this.ijj);
      }
      if (this.ijk != null) {
        paramVarArgs.d(12, this.ijk);
      }
      if (this.ijl != null) {
        paramVarArgs.d(13, this.ijl);
      }
      AppMethodBeat.o(150806);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label950;
      }
    }
    label950:
    for (int i = f.a.a.b.b.a.e(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ijb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ijb);
      }
      i = paramInt;
      if (this.ijc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ijc);
      }
      paramInt = i;
      if (this.ijd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ijd);
      }
      i = paramInt;
      if (this.ije != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ije);
      }
      paramInt = i;
      if (this.ijf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ijf);
      }
      i = paramInt;
      if (this.doD != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.doD);
      }
      paramInt = i;
      if (this.ijg != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ijg);
      }
      i = paramInt;
      if (this.ijh != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.ijh);
      }
      paramInt = i;
      if (this.iji != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.iji);
      }
      i = paramInt;
      if (this.ijj != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.ijj);
      }
      paramInt = i;
      if (this.ijk != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.ijk);
      }
      i = paramInt;
      if (this.ijl != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.ijl);
      }
      AppMethodBeat.o(150806);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(150806);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(150806);
          return -1;
        case 1: 
          localj.appId = locala.NPN.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 2: 
          localj.ijb = locala.NPN.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 3: 
          localj.ijc = locala.NPN.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 4: 
          localj.ijd = locala.NPN.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 5: 
          localj.ije = locala.NPN.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 6: 
          localj.ijf = locala.NPN.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 7: 
          localj.doD = locala.NPN.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 8: 
          localj.ijg = locala.NPN.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 9: 
          localj.ijh = locala.NPN.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 10: 
          localj.iji = locala.NPN.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 11: 
          localj.ijj = locala.NPN.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 12: 
          localj.ijk = locala.NPN.readString();
          AppMethodBeat.o(150806);
          return 0;
        }
        localj.ijl = locala.NPN.readString();
        AppMethodBeat.o(150806);
        return 0;
      }
      AppMethodBeat.o(150806);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bc.j
 * JD-Core Version:    0.7.0.1
 */