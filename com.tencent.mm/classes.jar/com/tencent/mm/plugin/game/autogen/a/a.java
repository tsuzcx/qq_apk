package com.tencent.mm.plugin.game.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public final class a
  extends dyl
{
  public int Cqs;
  public String Cqt;
  public long Cqu;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40860);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Cqs);
      if (this.Cqt != null) {
        paramVarArgs.f(3, this.Cqt);
      }
      if (this.lVG != null) {
        paramVarArgs.f(4, this.lVG);
      }
      paramVarArgs.bm(5, this.Cqu);
      AppMethodBeat.o(40860);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Cqs);
      paramInt = i;
      if (this.Cqt != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Cqt);
      }
      i = paramInt;
      if (this.lVG != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.lVG);
      }
      paramInt = g.a.a.b.b.a.p(5, this.Cqu);
      AppMethodBeat.o(40860);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(40860);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40860);
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
            locala.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(40860);
          return 0;
        case 2: 
          locala.Cqs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(40860);
          return 0;
        case 3: 
          locala.Cqt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(40860);
          return 0;
        case 4: 
          locala.lVG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(40860);
          return 0;
        }
        locala.Cqu = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(40860);
        return 0;
      }
      AppMethodBeat.o(40860);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.a.a
 * JD-Core Version:    0.7.0.1
 */