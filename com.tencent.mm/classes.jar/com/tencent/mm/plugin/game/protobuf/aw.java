package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class aw
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String xIy;
  public String xJt;
  public int xJv;
  public String xKM;
  public boolean xKN;
  public boolean xKO;
  public String xKP;
  public String xKQ;
  public int xKR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41742);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41742);
        throw paramVarArgs;
      }
      if (this.xKM == null)
      {
        paramVarArgs = new b("Not all required fields were included: NavKey");
        AppMethodBeat.o(41742);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.xKM != null) {
        paramVarArgs.e(2, this.xKM);
      }
      if (this.xIy != null) {
        paramVarArgs.e(3, this.xIy);
      }
      paramVarArgs.cc(4, this.xKN);
      paramVarArgs.cc(5, this.xKO);
      if (this.xKP != null) {
        paramVarArgs.e(6, this.xKP);
      }
      if (this.xKQ != null) {
        paramVarArgs.e(7, this.xKQ);
      }
      paramVarArgs.aM(8, this.xKR);
      paramVarArgs.aM(9, this.xJv);
      if (this.xJt != null) {
        paramVarArgs.e(10, this.xJt);
      }
      AppMethodBeat.o(41742);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label790;
      }
    }
    label790:
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xKM != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xKM);
      }
      i = paramInt;
      if (this.xIy != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xIy);
      }
      i = i + (g.a.a.b.b.a.fS(4) + 1) + (g.a.a.b.b.a.fS(5) + 1);
      paramInt = i;
      if (this.xKP != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xKP);
      }
      i = paramInt;
      if (this.xKQ != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.xKQ);
      }
      i = i + g.a.a.b.b.a.bu(8, this.xKR) + g.a.a.b.b.a.bu(9, this.xJv);
      paramInt = i;
      if (this.xJt != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.xJt);
      }
      AppMethodBeat.o(41742);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41742);
          throw paramVarArgs;
        }
        if (this.xKM == null)
        {
          paramVarArgs = new b("Not all required fields were included: NavKey");
          AppMethodBeat.o(41742);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41742);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aw localaw = (aw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41742);
          return -1;
        case 1: 
          localaw.Title = locala.UbS.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 2: 
          localaw.xKM = locala.UbS.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 3: 
          localaw.xIy = locala.UbS.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 4: 
          localaw.xKN = locala.UbS.yZ();
          AppMethodBeat.o(41742);
          return 0;
        case 5: 
          localaw.xKO = locala.UbS.yZ();
          AppMethodBeat.o(41742);
          return 0;
        case 6: 
          localaw.xKP = locala.UbS.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 7: 
          localaw.xKQ = locala.UbS.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 8: 
          localaw.xKR = locala.UbS.zi();
          AppMethodBeat.o(41742);
          return 0;
        case 9: 
          localaw.xJv = locala.UbS.zi();
          AppMethodBeat.o(41742);
          return 0;
        }
        localaw.xJt = locala.UbS.readString();
        AppMethodBeat.o(41742);
        return 0;
      }
      AppMethodBeat.o(41742);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.aw
 * JD-Core Version:    0.7.0.1
 */