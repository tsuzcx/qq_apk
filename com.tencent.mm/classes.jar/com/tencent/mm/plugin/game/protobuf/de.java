package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class de
  extends com.tencent.mm.cd.a
{
  public String COj;
  public df CQX;
  public df CQY;
  public df CQZ;
  public df CRa;
  public df CRb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41817);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CQX != null)
      {
        paramVarArgs.oE(1, this.CQX.computeSize());
        this.CQX.writeFields(paramVarArgs);
      }
      if (this.CQY != null)
      {
        paramVarArgs.oE(2, this.CQY.computeSize());
        this.CQY.writeFields(paramVarArgs);
      }
      if (this.CQZ != null)
      {
        paramVarArgs.oE(3, this.CQZ.computeSize());
        this.CQZ.writeFields(paramVarArgs);
      }
      if (this.CRa != null)
      {
        paramVarArgs.oE(4, this.CRa.computeSize());
        this.CRa.writeFields(paramVarArgs);
      }
      if (this.CRb != null)
      {
        paramVarArgs.oE(6, this.CRb.computeSize());
        this.CRb.writeFields(paramVarArgs);
      }
      if (this.COj != null) {
        paramVarArgs.f(5, this.COj);
      }
      AppMethodBeat.o(41817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CQX == null) {
        break label880;
      }
    }
    label880:
    for (int i = g.a.a.a.oD(1, this.CQX.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CQY != null) {
        paramInt = i + g.a.a.a.oD(2, this.CQY.computeSize());
      }
      i = paramInt;
      if (this.CQZ != null) {
        i = paramInt + g.a.a.a.oD(3, this.CQZ.computeSize());
      }
      paramInt = i;
      if (this.CRa != null) {
        paramInt = i + g.a.a.a.oD(4, this.CRa.computeSize());
      }
      i = paramInt;
      if (this.CRb != null) {
        i = paramInt + g.a.a.a.oD(6, this.CRb.computeSize());
      }
      paramInt = i;
      if (this.COj != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.COj);
      }
      AppMethodBeat.o(41817);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41817);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        de localde = (de)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        df localdf;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41817);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdf = new df();
            if ((localObject != null) && (localObject.length > 0)) {
              localdf.parseFrom((byte[])localObject);
            }
            localde.CQX = localdf;
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdf = new df();
            if ((localObject != null) && (localObject.length > 0)) {
              localdf.parseFrom((byte[])localObject);
            }
            localde.CQY = localdf;
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdf = new df();
            if ((localObject != null) && (localObject.length > 0)) {
              localdf.parseFrom((byte[])localObject);
            }
            localde.CQZ = localdf;
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdf = new df();
            if ((localObject != null) && (localObject.length > 0)) {
              localdf.parseFrom((byte[])localObject);
            }
            localde.CRa = localdf;
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdf = new df();
            if ((localObject != null) && (localObject.length > 0)) {
              localdf.parseFrom((byte[])localObject);
            }
            localde.CRb = localdf;
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        }
        localde.COj = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(41817);
        return 0;
      }
      AppMethodBeat.o(41817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.de
 * JD-Core Version:    0.7.0.1
 */