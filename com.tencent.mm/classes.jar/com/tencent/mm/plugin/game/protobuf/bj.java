package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import g.a.a.b;
import java.util.LinkedList;

public final class bj
  extends dyl
{
  public String CPt;
  public int CPu;
  public f CPv;
  public int CPw;
  public String mVH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149415);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CPt == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(149415);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CPt != null) {
        paramVarArgs.f(2, this.CPt);
      }
      if (this.mVH != null) {
        paramVarArgs.f(3, this.mVH);
      }
      paramVarArgs.aY(4, this.CPu);
      if (this.CPv != null)
      {
        paramVarArgs.oE(5, this.CPv.computeSize());
        this.CPv.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.CPw);
      AppMethodBeat.o(149415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label682;
      }
    }
    label682:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CPt != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CPt);
      }
      i = paramInt;
      if (this.mVH != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.mVH);
      }
      i += g.a.a.b.b.a.bM(4, this.CPu);
      paramInt = i;
      if (this.CPv != null) {
        paramInt = i + g.a.a.a.oD(5, this.CPv.computeSize());
      }
      i = g.a.a.b.b.a.bM(7, this.CPw);
      AppMethodBeat.o(149415);
      return paramInt + i;
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
          AppMethodBeat.o(149415);
          throw paramVarArgs;
        }
        AppMethodBeat.o(149415);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bj localbj = (bj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(149415);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localbj.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149415);
          return 0;
        case 2: 
          localbj.CPt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(149415);
          return 0;
        case 3: 
          localbj.mVH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(149415);
          return 0;
        case 4: 
          localbj.CPu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(149415);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new f();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((f)localObject2).parseFrom((byte[])localObject1);
            }
            localbj.CPv = ((f)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(149415);
          return 0;
        }
        localbj.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(149415);
        return 0;
      }
      AppMethodBeat.o(149415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bj
 * JD-Core Version:    0.7.0.1
 */