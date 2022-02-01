package com.tencent.mm.plugin.downloader.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public String icon;
  public r xlo;
  public r xlp;
  public String xlq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153059);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.icon != null) {
        paramVarArgs.g(1, this.icon);
      }
      if (this.xlo != null)
      {
        paramVarArgs.qD(2, this.xlo.computeSize());
        this.xlo.writeFields(paramVarArgs);
      }
      if (this.xlp != null)
      {
        paramVarArgs.qD(3, this.xlp.computeSize());
        this.xlp.writeFields(paramVarArgs);
      }
      if (this.xlq != null) {
        paramVarArgs.g(4, this.xlq);
      }
      AppMethodBeat.o(153059);
      return 0;
    }
    if (paramInt == 1) {
      if (this.icon == null) {
        break label538;
      }
    }
    label538:
    for (int i = i.a.a.b.b.a.h(1, this.icon) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xlo != null) {
        paramInt = i + i.a.a.a.qC(2, this.xlo.computeSize());
      }
      i = paramInt;
      if (this.xlp != null) {
        i = paramInt + i.a.a.a.qC(3, this.xlp.computeSize());
      }
      paramInt = i;
      if (this.xlq != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.xlq);
      }
      AppMethodBeat.o(153059);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153059);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        r localr;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153059);
          return -1;
        case 1: 
          localb.icon = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153059);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localr = new r();
            if ((localObject != null) && (localObject.length > 0)) {
              localr.parseFrom((byte[])localObject);
            }
            localb.xlo = localr;
            paramInt += 1;
          }
          AppMethodBeat.o(153059);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localr = new r();
            if ((localObject != null) && (localObject.length > 0)) {
              localr.parseFrom((byte[])localObject);
            }
            localb.xlp = localr;
            paramInt += 1;
          }
          AppMethodBeat.o(153059);
          return 0;
        }
        localb.xlq = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(153059);
        return 0;
      }
      AppMethodBeat.o(153059);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.b.b
 * JD-Core Version:    0.7.0.1
 */