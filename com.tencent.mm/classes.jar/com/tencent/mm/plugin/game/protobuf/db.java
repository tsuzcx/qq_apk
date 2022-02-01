package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class db
  extends com.tencent.mm.cd.a
{
  public String CQT;
  public String CQU;
  public boolean CQV;
  public int Crm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41814);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CQU == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaURL");
        AppMethodBeat.o(41814);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.Crm);
      if (this.CQT != null) {
        paramVarArgs.f(2, this.CQT);
      }
      if (this.CQU != null) {
        paramVarArgs.f(3, this.CQU);
      }
      paramVarArgs.co(4, this.CQV);
      AppMethodBeat.o(41814);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Crm) + 0;
      paramInt = i;
      if (this.CQT != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CQT);
      }
      i = paramInt;
      if (this.CQU != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CQU);
      }
      paramInt = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(41814);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.CQU == null)
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
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      db localdb = (db)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41814);
        return -1;
      case 1: 
        localdb.Crm = locala.abFh.AK();
        AppMethodBeat.o(41814);
        return 0;
      case 2: 
        localdb.CQT = locala.abFh.readString();
        AppMethodBeat.o(41814);
        return 0;
      case 3: 
        localdb.CQU = locala.abFh.readString();
        AppMethodBeat.o(41814);
        return 0;
      }
      localdb.CQV = locala.abFh.AB();
      AppMethodBeat.o(41814);
      return 0;
    }
    AppMethodBeat.o(41814);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.db
 * JD-Core Version:    0.7.0.1
 */