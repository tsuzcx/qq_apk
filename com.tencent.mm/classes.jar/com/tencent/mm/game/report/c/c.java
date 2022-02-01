package com.tencent.mm.game.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public final class c
  extends dyl
{
  public String jUb;
  public String jUc;
  public String jUd;
  public String jUe;
  public String jUf;
  public int jUg;
  public String jUh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175998);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jUb != null) {
        paramVarArgs.f(2, this.jUb);
      }
      if (this.jUc != null) {
        paramVarArgs.f(3, this.jUc);
      }
      if (this.jUd != null) {
        paramVarArgs.f(4, this.jUd);
      }
      if (this.jUe != null) {
        paramVarArgs.f(5, this.jUe);
      }
      if (this.jUf != null) {
        paramVarArgs.f(6, this.jUf);
      }
      paramVarArgs.aY(7, this.jUg);
      if (this.jUh != null) {
        paramVarArgs.f(8, this.jUh);
      }
      AppMethodBeat.o(175998);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label700;
      }
    }
    label700:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jUb != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.jUb);
      }
      i = paramInt;
      if (this.jUc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jUc);
      }
      paramInt = i;
      if (this.jUd != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.jUd);
      }
      i = paramInt;
      if (this.jUe != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.jUe);
      }
      paramInt = i;
      if (this.jUf != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.jUf);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.jUg);
      paramInt = i;
      if (this.jUh != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.jUh);
      }
      AppMethodBeat.o(175998);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(175998);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(175998);
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
            localc.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(175998);
          return 0;
        case 2: 
          localc.jUb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(175998);
          return 0;
        case 3: 
          localc.jUc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(175998);
          return 0;
        case 4: 
          localc.jUd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(175998);
          return 0;
        case 5: 
          localc.jUe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(175998);
          return 0;
        case 6: 
          localc.jUf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(175998);
          return 0;
        case 7: 
          localc.jUg = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(175998);
          return 0;
        }
        localc.jUh = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(175998);
        return 0;
      }
      AppMethodBeat.o(175998);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.c.c
 * JD-Core Version:    0.7.0.1
 */