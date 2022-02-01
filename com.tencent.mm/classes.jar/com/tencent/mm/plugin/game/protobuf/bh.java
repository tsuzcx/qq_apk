package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bh
  extends com.tencent.mm.cd.a
{
  public String CMC;
  public g CME;
  public String CNj;
  public LinkedList<String> CPp;
  public String CPq;
  public String CPr;
  public String CPs;
  public String fwr;
  public String lVG;
  
  public bh()
  {
    AppMethodBeat.i(41757);
    this.CPp = new LinkedList();
    AppMethodBeat.o(41757);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41758);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.CNj != null) {
        paramVarArgs.f(2, this.CNj);
      }
      paramVarArgs.e(3, 1, this.CPp);
      if (this.CPq != null) {
        paramVarArgs.f(4, this.CPq);
      }
      if (this.CMC != null) {
        paramVarArgs.f(5, this.CMC);
      }
      if (this.CPr != null) {
        paramVarArgs.f(6, this.CPr);
      }
      if (this.CPs != null) {
        paramVarArgs.f(8, this.CPs);
      }
      if (this.lVG != null) {
        paramVarArgs.f(9, this.lVG);
      }
      if (this.CME != null)
      {
        paramVarArgs.oE(10, this.CME.computeSize());
        this.CME.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label780;
      }
    }
    label780:
    for (paramInt = g.a.a.b.b.a.g(1, this.fwr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CNj != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CNj);
      }
      i += g.a.a.a.c(3, 1, this.CPp);
      paramInt = i;
      if (this.CPq != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CPq);
      }
      i = paramInt;
      if (this.CMC != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CMC);
      }
      paramInt = i;
      if (this.CPr != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CPr);
      }
      i = paramInt;
      if (this.CPs != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.CPs);
      }
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.lVG);
      }
      i = paramInt;
      if (this.CME != null) {
        i = paramInt + g.a.a.a.oD(10, this.CME.computeSize());
      }
      AppMethodBeat.o(41758);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CPp.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bh localbh = (bh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        default: 
          AppMethodBeat.o(41758);
          return -1;
        case 1: 
          localbh.fwr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 2: 
          localbh.CNj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 3: 
          localbh.CPp.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(41758);
          return 0;
        case 4: 
          localbh.CPq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 5: 
          localbh.CMC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 6: 
          localbh.CPr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 8: 
          localbh.CPs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 9: 
          localbh.lVG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41758);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          g localg = new g();
          if ((localObject != null) && (localObject.length > 0)) {
            localg.parseFrom((byte[])localObject);
          }
          localbh.CME = localg;
          paramInt += 1;
        }
        AppMethodBeat.o(41758);
        return 0;
      }
      AppMethodBeat.o(41758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bh
 * JD-Core Version:    0.7.0.1
 */