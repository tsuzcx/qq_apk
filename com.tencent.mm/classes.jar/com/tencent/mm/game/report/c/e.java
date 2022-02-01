package com.tencent.mm.game.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public final class e
  extends dyl
{
  public String jUi;
  public int jUj;
  public int jUk;
  public int jUl;
  public String jUm;
  public String jUn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176000);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jUi != null) {
        paramVarArgs.f(2, this.jUi);
      }
      paramVarArgs.aY(3, this.jUj);
      paramVarArgs.aY(4, this.jUk);
      paramVarArgs.aY(5, this.jUl);
      if (this.jUm != null) {
        paramVarArgs.f(6, this.jUm);
      }
      if (this.jUn != null) {
        paramVarArgs.f(7, this.jUn);
      }
      AppMethodBeat.o(176000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jUi != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.jUi);
      }
      i = i + g.a.a.b.b.a.bM(3, this.jUj) + g.a.a.b.b.a.bM(4, this.jUk) + g.a.a.b.b.a.bM(5, this.jUl);
      paramInt = i;
      if (this.jUm != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.jUm);
      }
      i = paramInt;
      if (this.jUn != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.jUn);
      }
      AppMethodBeat.o(176000);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(176000);
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
          AppMethodBeat.o(176000);
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
          AppMethodBeat.o(176000);
          return 0;
        case 2: 
          locale.jUi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(176000);
          return 0;
        case 3: 
          locale.jUj = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(176000);
          return 0;
        case 4: 
          locale.jUk = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(176000);
          return 0;
        case 5: 
          locale.jUl = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(176000);
          return 0;
        case 6: 
          locale.jUm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(176000);
          return 0;
        }
        locale.jUn = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(176000);
        return 0;
      }
      AppMethodBeat.o(176000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.c.e
 * JD-Core Version:    0.7.0.1
 */