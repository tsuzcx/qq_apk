package com.tencent.mm.plugin.game.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public final class e
  extends dyl
{
  public String CqB;
  public String CqE;
  public String CqF;
  public String CqG;
  public String CqH;
  public String CqI;
  public int CqJ;
  public String lVG;
  public String rVH;
  public String rWh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204099);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.rVH != null) {
        paramVarArgs.f(2, this.rVH);
      }
      if (this.rWh != null) {
        paramVarArgs.f(3, this.rWh);
      }
      if (this.CqE != null) {
        paramVarArgs.f(4, this.CqE);
      }
      if (this.CqF != null) {
        paramVarArgs.f(5, this.CqF);
      }
      if (this.CqG != null) {
        paramVarArgs.f(6, this.CqG);
      }
      if (this.CqB != null) {
        paramVarArgs.f(7, this.CqB);
      }
      if (this.lVG != null) {
        paramVarArgs.f(8, this.lVG);
      }
      if (this.CqH != null) {
        paramVarArgs.f(9, this.CqH);
      }
      if (this.CqI != null) {
        paramVarArgs.f(10, this.CqI);
      }
      paramVarArgs.aY(11, this.CqJ);
      AppMethodBeat.o(204099);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label884;
      }
    }
    label884:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rVH != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.rVH);
      }
      i = paramInt;
      if (this.rWh != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.rWh);
      }
      paramInt = i;
      if (this.CqE != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CqE);
      }
      i = paramInt;
      if (this.CqF != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CqF);
      }
      paramInt = i;
      if (this.CqG != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CqG);
      }
      i = paramInt;
      if (this.CqB != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.CqB);
      }
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.lVG);
      }
      i = paramInt;
      if (this.CqH != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.CqH);
      }
      paramInt = i;
      if (this.CqI != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.CqI);
      }
      i = g.a.a.b.b.a.bM(11, this.CqJ);
      AppMethodBeat.o(204099);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(204099);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(204099);
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
            locale.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(204099);
          return 0;
        case 2: 
          locale.rVH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(204099);
          return 0;
        case 3: 
          locale.rWh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(204099);
          return 0;
        case 4: 
          locale.CqE = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(204099);
          return 0;
        case 5: 
          locale.CqF = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(204099);
          return 0;
        case 6: 
          locale.CqG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(204099);
          return 0;
        case 7: 
          locale.CqB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(204099);
          return 0;
        case 8: 
          locale.lVG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(204099);
          return 0;
        case 9: 
          locale.CqH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(204099);
          return 0;
        case 10: 
          locale.CqI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(204099);
          return 0;
        }
        locale.CqJ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(204099);
        return 0;
      }
      AppMethodBeat.o(204099);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.a.e
 * JD-Core Version:    0.7.0.1
 */