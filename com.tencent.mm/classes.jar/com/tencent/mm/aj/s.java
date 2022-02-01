package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class s
  extends com.tencent.mm.cd.a
{
  public String fAg;
  public long fNu;
  public String fzT;
  public int llt;
  public int lpB;
  public String lpC;
  public String lpD;
  public v lpE;
  public LinkedList<String> lpF;
  public long msgId;
  public int type;
  public String userName;
  
  public s()
  {
    AppMethodBeat.i(116415);
    this.lpF = new LinkedList();
    AppMethodBeat.o(116415);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116416);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.msgId);
      paramVarArgs.bm(2, this.fNu);
      if (this.fAg != null) {
        paramVarArgs.f(3, this.fAg);
      }
      paramVarArgs.aY(4, this.lpB);
      paramVarArgs.aY(5, this.type);
      if (this.userName != null) {
        paramVarArgs.f(6, this.userName);
      }
      if (this.fzT != null) {
        paramVarArgs.f(7, this.fzT);
      }
      if (this.lpC != null) {
        paramVarArgs.f(8, this.lpC);
      }
      if (this.lpD != null) {
        paramVarArgs.f(9, this.lpD);
      }
      paramVarArgs.aY(10, this.llt);
      if (this.lpE != null)
      {
        paramVarArgs.oE(11, this.lpE.computeSize());
        this.lpE.writeFields(paramVarArgs);
      }
      paramVarArgs.e(12, 1, this.lpF);
      AppMethodBeat.o(116416);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.msgId) + 0 + g.a.a.b.b.a.p(2, this.fNu);
      paramInt = i;
      if (this.fAg != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.fAg);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.lpB) + g.a.a.b.b.a.bM(5, this.type);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.userName);
      }
      i = paramInt;
      if (this.fzT != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.fzT);
      }
      paramInt = i;
      if (this.lpC != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.lpC);
      }
      i = paramInt;
      if (this.lpD != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.lpD);
      }
      i += g.a.a.b.b.a.bM(10, this.llt);
      paramInt = i;
      if (this.lpE != null) {
        paramInt = i + g.a.a.a.oD(11, this.lpE.computeSize());
      }
      i = g.a.a.a.c(12, 1, this.lpF);
      AppMethodBeat.o(116416);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.lpF.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(116416);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      s locals = (s)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(116416);
        return -1;
      case 1: 
        locals.msgId = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(116416);
        return 0;
      case 2: 
        locals.fNu = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(116416);
        return 0;
      case 3: 
        locals.fAg = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 4: 
        locals.lpB = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(116416);
        return 0;
      case 5: 
        locals.type = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(116416);
        return 0;
      case 6: 
        locals.userName = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 7: 
        locals.fzT = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 8: 
        locals.lpC = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 9: 
        locals.lpD = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 10: 
        locals.llt = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(116416);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          v localv = new v();
          if ((localObject != null) && (localObject.length > 0)) {
            localv.parseFrom((byte[])localObject);
          }
          locals.lpE = localv;
          paramInt += 1;
        }
        AppMethodBeat.o(116416);
        return 0;
      }
      locals.lpF.add(((g.a.a.a.a)localObject).abFh.readString());
      AppMethodBeat.o(116416);
      return 0;
    }
    AppMethodBeat.o(116416);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aj.s
 * JD-Core Version:    0.7.0.1
 */