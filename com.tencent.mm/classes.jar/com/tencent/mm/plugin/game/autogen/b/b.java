package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;

public final class b
  extends dyy
{
  public int CqV;
  public String CqW;
  public boolean CqX = false;
  public String desc;
  public int tnQ;
  public String vhu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40865);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(40865);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.CqV);
      if (this.vhu != null) {
        paramVarArgs.f(3, this.vhu);
      }
      if (this.CqW != null) {
        paramVarArgs.f(4, this.CqW);
      }
      paramVarArgs.co(5, this.CqX);
      paramVarArgs.aY(6, this.tnQ);
      if (this.desc != null) {
        paramVarArgs.f(7, this.desc);
      }
      AppMethodBeat.o(40865);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label648;
      }
    }
    label648:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.CqV);
      paramInt = i;
      if (this.vhu != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.vhu);
      }
      i = paramInt;
      if (this.CqW != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.CqW);
      }
      i = i + (g.a.a.b.b.a.gL(5) + 1) + g.a.a.b.b.a.bM(6, this.tnQ);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.desc);
      }
      AppMethodBeat.o(40865);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(40865);
          throw paramVarArgs;
        }
        AppMethodBeat.o(40865);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40865);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localb.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(40865);
          return 0;
        case 2: 
          localb.CqV = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(40865);
          return 0;
        case 3: 
          localb.vhu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(40865);
          return 0;
        case 4: 
          localb.CqW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(40865);
          return 0;
        case 5: 
          localb.CqX = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(40865);
          return 0;
        case 6: 
          localb.tnQ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(40865);
          return 0;
        }
        localb.desc = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(40865);
        return 0;
      }
      AppMethodBeat.o(40865);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.b
 * JD-Core Version:    0.7.0.1
 */