package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class z
  extends com.tencent.mm.bw.a
{
  public String oTx;
  public long oUG;
  public long oUH;
  public String oUI;
  public String oUJ;
  public LinkedList<String> oUn;
  
  public z()
  {
    AppMethodBeat.i(22131);
    this.oUn = new LinkedList();
    AppMethodBeat.o(22131);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22132);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oTx == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.oUI == null)
      {
        paramVarArgs = new b("Not all required fields were included: MsgDataID");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.oUJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.oTx != null) {
        paramVarArgs.e(1, this.oTx);
      }
      paramVarArgs.bb(2, this.oUG);
      paramVarArgs.bb(3, this.oUH);
      if (this.oUI != null) {
        paramVarArgs.e(4, this.oUI);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(5, this.oUJ);
      }
      paramVarArgs.e(6, 1, this.oUn);
      AppMethodBeat.o(22132);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oTx == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = g.a.a.b.b.a.f(1, this.oTx) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.oUG) + g.a.a.b.b.a.r(3, this.oUH);
      paramInt = i;
      if (this.oUI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.oUI);
      }
      i = paramInt;
      if (this.oUJ != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.oUJ);
      }
      paramInt = g.a.a.a.c(6, 1, this.oUn);
      AppMethodBeat.o(22132);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.oUn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.oTx == null)
        {
          paramVarArgs = new b("Not all required fields were included: BakChatName");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        if (this.oUI == null)
        {
          paramVarArgs = new b("Not all required fields were included: MsgDataID");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        if (this.oUJ == null)
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        z localz = (z)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22132);
          return -1;
        case 1: 
          localz.oTx = locala.UbS.readString();
          AppMethodBeat.o(22132);
          return 0;
        case 2: 
          localz.oUG = locala.UbS.zl();
          AppMethodBeat.o(22132);
          return 0;
        case 3: 
          localz.oUH = locala.UbS.zl();
          AppMethodBeat.o(22132);
          return 0;
        case 4: 
          localz.oUI = locala.UbS.readString();
          AppMethodBeat.o(22132);
          return 0;
        case 5: 
          localz.oUJ = locala.UbS.readString();
          AppMethodBeat.o(22132);
          return 0;
        }
        localz.oUn.add(locala.UbS.readString());
        AppMethodBeat.o(22132);
        return 0;
      }
      AppMethodBeat.o(22132);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.z
 * JD-Core Version:    0.7.0.1
 */