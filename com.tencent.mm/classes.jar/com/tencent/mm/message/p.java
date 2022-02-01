package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class p
  extends com.tencent.mm.bx.a
{
  public String Url;
  public String nUq;
  public String nUv;
  public o nUw;
  public n nUx;
  public String nUy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116411);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nUv != null) {
        paramVarArgs.g(1, this.nUv);
      }
      if (this.Url != null) {
        paramVarArgs.g(2, this.Url);
      }
      if (this.nUq != null) {
        paramVarArgs.g(3, this.nUq);
      }
      if (this.nUw != null)
      {
        paramVarArgs.qD(4, this.nUw.computeSize());
        this.nUw.writeFields(paramVarArgs);
      }
      if (this.nUx != null)
      {
        paramVarArgs.qD(5, this.nUx.computeSize());
        this.nUx.writeFields(paramVarArgs);
      }
      if (this.nUy != null) {
        paramVarArgs.g(6, this.nUy);
      }
      AppMethodBeat.o(116411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nUv == null) {
        break label658;
      }
    }
    label658:
    for (int i = i.a.a.b.b.a.h(1, this.nUv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Url);
      }
      i = paramInt;
      if (this.nUq != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nUq);
      }
      paramInt = i;
      if (this.nUw != null) {
        paramInt = i + i.a.a.a.qC(4, this.nUw.computeSize());
      }
      i = paramInt;
      if (this.nUx != null) {
        i = paramInt + i.a.a.a.qC(5, this.nUx.computeSize());
      }
      paramInt = i;
      if (this.nUy != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.nUy);
      }
      AppMethodBeat.o(116411);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116411);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116411);
          return -1;
        case 1: 
          localp.nUv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(116411);
          return 0;
        case 2: 
          localp.Url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(116411);
          return 0;
        case 3: 
          localp.nUq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(116411);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new o();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((o)localObject2).parseFrom((byte[])localObject1);
            }
            localp.nUw = ((o)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116411);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new n();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((n)localObject2).parseFrom((byte[])localObject1);
            }
            localp.nUx = ((n)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116411);
          return 0;
        }
        localp.nUy = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(116411);
        return 0;
      }
      AppMethodBeat.o(116411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.message.p
 * JD-Core Version:    0.7.0.1
 */