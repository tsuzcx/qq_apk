package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class az
  extends com.tencent.mm.bx.a
{
  public String IconUrl;
  public String Title;
  public String iht;
  public String ueX;
  public f ueZ;
  public LinkedList<String> uhq;
  public String uhr;
  public String uhs;
  public String uht;
  
  public az()
  {
    AppMethodBeat.i(41757);
    this.uhq = new LinkedList();
    AppMethodBeat.o(41757);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41758);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(2, this.IconUrl);
      }
      paramVarArgs.e(3, 1, this.uhq);
      if (this.uhr != null) {
        paramVarArgs.d(4, this.uhr);
      }
      if (this.ueX != null) {
        paramVarArgs.d(5, this.ueX);
      }
      if (this.uhs != null) {
        paramVarArgs.d(6, this.uhs);
      }
      if (this.uht != null) {
        paramVarArgs.d(8, this.uht);
      }
      if (this.iht != null) {
        paramVarArgs.d(9, this.iht);
      }
      if (this.ueZ != null)
      {
        paramVarArgs.lC(10, this.ueZ.computeSize());
        this.ueZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.IconUrl);
      }
      i += f.a.a.a.c(3, 1, this.uhq);
      paramInt = i;
      if (this.uhr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uhr);
      }
      i = paramInt;
      if (this.ueX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ueX);
      }
      paramInt = i;
      if (this.uhs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uhs);
      }
      i = paramInt;
      if (this.uht != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.uht);
      }
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iht);
      }
      i = paramInt;
      if (this.ueZ != null) {
        i = paramInt + f.a.a.a.lB(10, this.ueZ.computeSize());
      }
      AppMethodBeat.o(41758);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uhq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        az localaz = (az)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        default: 
          AppMethodBeat.o(41758);
          return -1;
        case 1: 
          localaz.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 2: 
          localaz.IconUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 3: 
          localaz.uhq.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(41758);
          return 0;
        case 4: 
          localaz.uhr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 5: 
          localaz.ueX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 6: 
          localaz.uhs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 8: 
          localaz.uht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41758);
          return 0;
        case 9: 
          localaz.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41758);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaz.ueZ = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41758);
        return 0;
      }
      AppMethodBeat.o(41758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.az
 * JD-Core Version:    0.7.0.1
 */