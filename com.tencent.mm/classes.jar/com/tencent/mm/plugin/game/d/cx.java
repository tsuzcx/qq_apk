package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cx
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String Title;
  public String fKw;
  public String npQ;
  public String npR;
  public String nqt;
  public String ntp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111664);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ntp == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppName");
        AppMethodBeat.o(111664);
        throw paramVarArgs;
      }
      if (this.ntp != null) {
        paramVarArgs.e(1, this.ntp);
      }
      if (this.npQ != null) {
        paramVarArgs.e(2, this.npQ);
      }
      if (this.Title != null) {
        paramVarArgs.e(3, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(4, this.Desc);
      }
      if (this.nqt != null) {
        paramVarArgs.e(5, this.nqt);
      }
      if (this.npR != null) {
        paramVarArgs.e(6, this.npR);
      }
      if (this.fKw != null) {
        paramVarArgs.e(7, this.fKw);
      }
      AppMethodBeat.o(111664);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ntp == null) {
        break label626;
      }
    }
    label626:
    for (int i = e.a.a.b.b.a.f(1, this.ntp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.npQ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.npQ);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Title);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.Desc);
      }
      i = paramInt;
      if (this.nqt != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.nqt);
      }
      paramInt = i;
      if (this.npR != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.npR);
      }
      i = paramInt;
      if (this.fKw != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.fKw);
      }
      AppMethodBeat.o(111664);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.ntp == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppName");
          AppMethodBeat.o(111664);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111664);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cx localcx = (cx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111664);
          return -1;
        case 1: 
          localcx.ntp = locala.CLY.readString();
          AppMethodBeat.o(111664);
          return 0;
        case 2: 
          localcx.npQ = locala.CLY.readString();
          AppMethodBeat.o(111664);
          return 0;
        case 3: 
          localcx.Title = locala.CLY.readString();
          AppMethodBeat.o(111664);
          return 0;
        case 4: 
          localcx.Desc = locala.CLY.readString();
          AppMethodBeat.o(111664);
          return 0;
        case 5: 
          localcx.nqt = locala.CLY.readString();
          AppMethodBeat.o(111664);
          return 0;
        case 6: 
          localcx.npR = locala.CLY.readString();
          AppMethodBeat.o(111664);
          return 0;
        }
        localcx.fKw = locala.CLY.readString();
        AppMethodBeat.o(111664);
        return 0;
      }
      AppMethodBeat.o(111664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cx
 * JD-Core Version:    0.7.0.1
 */