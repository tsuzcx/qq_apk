package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class di
  extends com.tencent.mm.bx.a
{
  public String IIt;
  public dj ILn;
  public dj ILo;
  public dj ILp;
  public dj ILq;
  public dj ILr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41817);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ILn != null)
      {
        paramVarArgs.qD(1, this.ILn.computeSize());
        this.ILn.writeFields(paramVarArgs);
      }
      if (this.ILo != null)
      {
        paramVarArgs.qD(2, this.ILo.computeSize());
        this.ILo.writeFields(paramVarArgs);
      }
      if (this.ILp != null)
      {
        paramVarArgs.qD(3, this.ILp.computeSize());
        this.ILp.writeFields(paramVarArgs);
      }
      if (this.ILq != null)
      {
        paramVarArgs.qD(4, this.ILq.computeSize());
        this.ILq.writeFields(paramVarArgs);
      }
      if (this.ILr != null)
      {
        paramVarArgs.qD(6, this.ILr.computeSize());
        this.ILr.writeFields(paramVarArgs);
      }
      if (this.IIt != null) {
        paramVarArgs.g(5, this.IIt);
      }
      AppMethodBeat.o(41817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ILn == null) {
        break label876;
      }
    }
    label876:
    for (int i = i.a.a.a.qC(1, this.ILn.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ILo != null) {
        paramInt = i + i.a.a.a.qC(2, this.ILo.computeSize());
      }
      i = paramInt;
      if (this.ILp != null) {
        i = paramInt + i.a.a.a.qC(3, this.ILp.computeSize());
      }
      paramInt = i;
      if (this.ILq != null) {
        paramInt = i + i.a.a.a.qC(4, this.ILq.computeSize());
      }
      i = paramInt;
      if (this.ILr != null) {
        i = paramInt + i.a.a.a.qC(6, this.ILr.computeSize());
      }
      paramInt = i;
      if (this.IIt != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.IIt);
      }
      AppMethodBeat.o(41817);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41817);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        di localdi = (di)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        dj localdj;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41817);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdj = new dj();
            if ((localObject != null) && (localObject.length > 0)) {
              localdj.parseFrom((byte[])localObject);
            }
            localdi.ILn = localdj;
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdj = new dj();
            if ((localObject != null) && (localObject.length > 0)) {
              localdj.parseFrom((byte[])localObject);
            }
            localdi.ILo = localdj;
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdj = new dj();
            if ((localObject != null) && (localObject.length > 0)) {
              localdj.parseFrom((byte[])localObject);
            }
            localdi.ILp = localdj;
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdj = new dj();
            if ((localObject != null) && (localObject.length > 0)) {
              localdj.parseFrom((byte[])localObject);
            }
            localdi.ILq = localdj;
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdj = new dj();
            if ((localObject != null) && (localObject.length > 0)) {
              localdj.parseFrom((byte[])localObject);
            }
            localdi.ILr = localdj;
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        }
        localdi.IIt = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(41817);
        return 0;
      }
      AppMethodBeat.o(41817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.di
 * JD-Core Version:    0.7.0.1
 */