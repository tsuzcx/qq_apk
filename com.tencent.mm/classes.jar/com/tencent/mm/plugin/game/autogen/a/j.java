package com.tencent.mm.plugin.game.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public final class j
  extends dyl
{
  public String CqB;
  public String CqE;
  public String CqF;
  public String CqG;
  public String CqH;
  public String CqI;
  public int CqJ;
  public String CqQ;
  public String CqS;
  public String CqT;
  public int errorCode;
  public String rVH;
  public int rVU;
  public String rWh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208369);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CqB != null) {
        paramVarArgs.f(2, this.CqB);
      }
      paramVarArgs.aY(3, this.CqJ);
      paramVarArgs.aY(4, this.rVU);
      if (this.CqQ != null) {
        paramVarArgs.f(5, this.CqQ);
      }
      if (this.CqS != null) {
        paramVarArgs.f(6, this.CqS);
      }
      if (this.CqT != null) {
        paramVarArgs.f(7, this.CqT);
      }
      paramVarArgs.aY(8, this.errorCode);
      if (this.CqG != null) {
        paramVarArgs.f(9, this.CqG);
      }
      if (this.CqF != null) {
        paramVarArgs.f(10, this.CqF);
      }
      if (this.CqE != null) {
        paramVarArgs.f(11, this.CqE);
      }
      if (this.CqH != null) {
        paramVarArgs.f(12, this.CqH);
      }
      if (this.CqI != null) {
        paramVarArgs.f(13, this.CqI);
      }
      if (this.rVH != null) {
        paramVarArgs.f(14, this.rVH);
      }
      if (this.rWh != null) {
        paramVarArgs.f(15, this.rWh);
      }
      AppMethodBeat.o(208369);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1100;
      }
    }
    label1100:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CqB != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CqB);
      }
      i = i + g.a.a.b.b.a.bM(3, this.CqJ) + g.a.a.b.b.a.bM(4, this.rVU);
      paramInt = i;
      if (this.CqQ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.CqQ);
      }
      i = paramInt;
      if (this.CqS != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.CqS);
      }
      paramInt = i;
      if (this.CqT != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.CqT);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.errorCode);
      paramInt = i;
      if (this.CqG != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.CqG);
      }
      i = paramInt;
      if (this.CqF != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.CqF);
      }
      paramInt = i;
      if (this.CqE != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.CqE);
      }
      i = paramInt;
      if (this.CqH != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.CqH);
      }
      paramInt = i;
      if (this.CqI != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.CqI);
      }
      i = paramInt;
      if (this.rVH != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.rVH);
      }
      paramInt = i;
      if (this.rWh != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.rWh);
      }
      AppMethodBeat.o(208369);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(208369);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(208369);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localj.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(208369);
          return 0;
        case 2: 
          localj.CqB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(208369);
          return 0;
        case 3: 
          localj.CqJ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(208369);
          return 0;
        case 4: 
          localj.rVU = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(208369);
          return 0;
        case 5: 
          localj.CqQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(208369);
          return 0;
        case 6: 
          localj.CqS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(208369);
          return 0;
        case 7: 
          localj.CqT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(208369);
          return 0;
        case 8: 
          localj.errorCode = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(208369);
          return 0;
        case 9: 
          localj.CqG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(208369);
          return 0;
        case 10: 
          localj.CqF = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(208369);
          return 0;
        case 11: 
          localj.CqE = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(208369);
          return 0;
        case 12: 
          localj.CqH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(208369);
          return 0;
        case 13: 
          localj.CqI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(208369);
          return 0;
        case 14: 
          localj.rVH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(208369);
          return 0;
        }
        localj.rWh = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(208369);
        return 0;
      }
      AppMethodBeat.o(208369);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.a.j
 * JD-Core Version:    0.7.0.1
 */