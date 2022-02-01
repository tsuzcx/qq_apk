package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class z
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> nDX;
  public String nDg;
  public long nEq;
  public long nEr;
  public String nEs;
  public String nEt;
  
  public z()
  {
    AppMethodBeat.i(22131);
    this.nDX = new LinkedList();
    AppMethodBeat.o(22131);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22132);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDg == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.nEs == null)
      {
        paramVarArgs = new b("Not all required fields were included: MsgDataID");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.nEt == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.nDg != null) {
        paramVarArgs.d(1, this.nDg);
      }
      paramVarArgs.aY(2, this.nEq);
      paramVarArgs.aY(3, this.nEr);
      if (this.nEs != null) {
        paramVarArgs.d(4, this.nEs);
      }
      if (this.nEt != null) {
        paramVarArgs.d(5, this.nEt);
      }
      paramVarArgs.e(6, 1, this.nDX);
      AppMethodBeat.o(22132);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDg == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.b.b.a.e(1, this.nDg) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.nEq) + f.a.a.b.b.a.p(3, this.nEr);
      paramInt = i;
      if (this.nEs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nEs);
      }
      i = paramInt;
      if (this.nEt != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nEt);
      }
      paramInt = f.a.a.a.c(6, 1, this.nDX);
      AppMethodBeat.o(22132);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nDX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.nDg == null)
        {
          paramVarArgs = new b("Not all required fields were included: BakChatName");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        if (this.nEs == null)
        {
          paramVarArgs = new b("Not all required fields were included: MsgDataID");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        if (this.nEt == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22132);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        z localz = (z)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22132);
          return -1;
        case 1: 
          localz.nDg = locala.NPN.readString();
          AppMethodBeat.o(22132);
          return 0;
        case 2: 
          localz.nEq = locala.NPN.zd();
          AppMethodBeat.o(22132);
          return 0;
        case 3: 
          localz.nEr = locala.NPN.zd();
          AppMethodBeat.o(22132);
          return 0;
        case 4: 
          localz.nEs = locala.NPN.readString();
          AppMethodBeat.o(22132);
          return 0;
        case 5: 
          localz.nEt = locala.NPN.readString();
          AppMethodBeat.o(22132);
          return 0;
        }
        localz.nDX.add(locala.NPN.readString());
        AppMethodBeat.o(22132);
        return 0;
      }
      AppMethodBeat.o(22132);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.z
 * JD-Core Version:    0.7.0.1
 */