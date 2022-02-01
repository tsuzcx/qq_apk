package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import g.a.a.b;
import java.util.LinkedList;

public final class by
  extends dyl
{
  public String CPt;
  public int CQe;
  public int CQf;
  public int CQm;
  public int CQn;
  public String mVH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41781);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CPt == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41781);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.CQe);
      paramVarArgs.aY(3, this.CQf);
      if (this.CPt != null) {
        paramVarArgs.f(4, this.CPt);
      }
      paramVarArgs.aY(5, this.CQm);
      paramVarArgs.aY(6, this.CQn);
      if (this.mVH != null) {
        paramVarArgs.f(7, this.mVH);
      }
      AppMethodBeat.o(41781);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label632;
      }
    }
    label632:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.CQe) + g.a.a.b.b.a.bM(3, this.CQf);
      paramInt = i;
      if (this.CPt != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CPt);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.CQm) + g.a.a.b.b.a.bM(6, this.CQn);
      paramInt = i;
      if (this.mVH != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.mVH);
      }
      AppMethodBeat.o(41781);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CPt == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(41781);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41781);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        by localby = (by)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41781);
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
            localby.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(41781);
          return 0;
        case 2: 
          localby.CQe = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(41781);
          return 0;
        case 3: 
          localby.CQf = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(41781);
          return 0;
        case 4: 
          localby.CPt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41781);
          return 0;
        case 5: 
          localby.CQm = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(41781);
          return 0;
        case 6: 
          localby.CQn = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(41781);
          return 0;
        }
        localby.mVH = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(41781);
        return 0;
      }
      AppMethodBeat.o(41781);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.by
 * JD-Core Version:    0.7.0.1
 */