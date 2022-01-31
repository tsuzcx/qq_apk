package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class z
  extends com.tencent.mm.bv.a
{
  public String jJs;
  public long jKD;
  public long jKE;
  public String jKF;
  public String jKG;
  public LinkedList<String> jKk;
  
  public z()
  {
    AppMethodBeat.i(18074);
    this.jKk = new LinkedList();
    AppMethodBeat.o(18074);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18075);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJs == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(18075);
        throw paramVarArgs;
      }
      if (this.jKF == null)
      {
        paramVarArgs = new b("Not all required fields were included: MsgDataID");
        AppMethodBeat.o(18075);
        throw paramVarArgs;
      }
      if (this.jKG == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(18075);
        throw paramVarArgs;
      }
      if (this.jJs != null) {
        paramVarArgs.e(1, this.jJs);
      }
      paramVarArgs.am(2, this.jKD);
      paramVarArgs.am(3, this.jKE);
      if (this.jKF != null) {
        paramVarArgs.e(4, this.jKF);
      }
      if (this.jKG != null) {
        paramVarArgs.e(5, this.jKG);
      }
      paramVarArgs.e(6, 1, this.jKk);
      AppMethodBeat.o(18075);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJs == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = e.a.a.b.b.a.f(1, this.jJs) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.jKD) + e.a.a.b.b.a.p(3, this.jKE);
      paramInt = i;
      if (this.jKF != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.jKF);
      }
      i = paramInt;
      if (this.jKG != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.jKG);
      }
      paramInt = e.a.a.a.c(6, 1, this.jKk);
      AppMethodBeat.o(18075);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.jKk.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.jJs == null)
        {
          paramVarArgs = new b("Not all required fields were included: BakChatName");
          AppMethodBeat.o(18075);
          throw paramVarArgs;
        }
        if (this.jKF == null)
        {
          paramVarArgs = new b("Not all required fields were included: MsgDataID");
          AppMethodBeat.o(18075);
          throw paramVarArgs;
        }
        if (this.jKG == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(18075);
          throw paramVarArgs;
        }
        AppMethodBeat.o(18075);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        z localz = (z)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(18075);
          return -1;
        case 1: 
          localz.jJs = locala.CLY.readString();
          AppMethodBeat.o(18075);
          return 0;
        case 2: 
          localz.jKD = locala.CLY.sm();
          AppMethodBeat.o(18075);
          return 0;
        case 3: 
          localz.jKE = locala.CLY.sm();
          AppMethodBeat.o(18075);
          return 0;
        case 4: 
          localz.jKF = locala.CLY.readString();
          AppMethodBeat.o(18075);
          return 0;
        case 5: 
          localz.jKG = locala.CLY.readString();
          AppMethodBeat.o(18075);
          return 0;
        }
        localz.jKk.add(locala.CLY.readString());
        AppMethodBeat.o(18075);
        return 0;
      }
      AppMethodBeat.o(18075);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.z
 * JD-Core Version:    0.7.0.1
 */