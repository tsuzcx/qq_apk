package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ac
  extends com.tencent.mm.bx.a
{
  public int vgz;
  public int vhk;
  public q vic;
  public p vie;
  public r vif;
  public s vig;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22135);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vgz);
      paramVarArgs.bS(2, this.vhk);
      if (this.vic != null)
      {
        paramVarArgs.qD(3, this.vic.computeSize());
        this.vic.writeFields(paramVarArgs);
      }
      if (this.vie != null)
      {
        paramVarArgs.qD(4, this.vie.computeSize());
        this.vie.writeFields(paramVarArgs);
      }
      if (this.vif != null)
      {
        paramVarArgs.qD(5, this.vif.computeSize());
        this.vif.writeFields(paramVarArgs);
      }
      if (this.vig != null)
      {
        paramVarArgs.qD(6, this.vig.computeSize());
        this.vig.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.vgz) + 0 + i.a.a.b.b.a.cJ(2, this.vhk);
      paramInt = i;
      if (this.vic != null) {
        paramInt = i + i.a.a.a.qC(3, this.vic.computeSize());
      }
      i = paramInt;
      if (this.vie != null) {
        i = paramInt + i.a.a.a.qC(4, this.vie.computeSize());
      }
      paramInt = i;
      if (this.vif != null) {
        paramInt = i + i.a.a.a.qC(5, this.vif.computeSize());
      }
      i = paramInt;
      if (this.vig != null) {
        i = paramInt + i.a.a.a.qC(6, this.vig.computeSize());
      }
      AppMethodBeat.o(22135);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      ac localac = (ac)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(22135);
        return -1;
      case 1: 
        localac.vgz = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(22135);
        return 0;
      case 2: 
        localac.vhk = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(22135);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new q();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((q)localObject2).parseFrom((byte[])localObject1);
          }
          localac.vic = ((q)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new p();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((p)localObject2).parseFrom((byte[])localObject1);
          }
          localac.vie = ((p)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new r();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((r)localObject2).parseFrom((byte[])localObject1);
          }
          localac.vif = ((r)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new s();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((s)localObject2).parseFrom((byte[])localObject1);
        }
        localac.vig = ((s)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    AppMethodBeat.o(22135);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ac
 * JD-Core Version:    0.7.0.1
 */