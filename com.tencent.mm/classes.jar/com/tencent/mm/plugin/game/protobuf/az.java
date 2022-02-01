package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class az
  extends com.tencent.mm.bx.a
{
  public String IHI;
  public String IJj;
  public LinkedList<dn> IJk;
  public ew IJl;
  public String hAP;
  
  public az()
  {
    AppMethodBeat.i(41743);
    this.IJk = new LinkedList();
    AppMethodBeat.o(41743);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41744);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IJj != null) {
        paramVarArgs.g(1, this.IJj);
      }
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      paramVarArgs.e(3, 8, this.IJk);
      if (this.IJl != null)
      {
        paramVarArgs.qD(4, this.IJl.computeSize());
        this.IJl.writeFields(paramVarArgs);
      }
      if (this.IHI != null) {
        paramVarArgs.g(5, this.IHI);
      }
      AppMethodBeat.o(41744);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IJj == null) {
        break label586;
      }
    }
    label586:
    for (paramInt = i.a.a.b.b.a.h(1, this.IJj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hAP != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.hAP);
      }
      i += i.a.a.a.c(3, 8, this.IJk);
      paramInt = i;
      if (this.IJl != null) {
        paramInt = i + i.a.a.a.qC(4, this.IJl.computeSize());
      }
      i = paramInt;
      if (this.IHI != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IHI);
      }
      AppMethodBeat.o(41744);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IJk.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41744);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        az localaz = (az)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41744);
          return -1;
        case 1: 
          localaz.IJj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41744);
          return 0;
        case 2: 
          localaz.hAP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41744);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dn)localObject2).parseFrom((byte[])localObject1);
            }
            localaz.IJk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41744);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ew();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ew)localObject2).parseFrom((byte[])localObject1);
            }
            localaz.IJl = ((ew)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41744);
          return 0;
        }
        localaz.IHI = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(41744);
        return 0;
      }
      AppMethodBeat.o(41744);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.az
 * JD-Core Version:    0.7.0.1
 */