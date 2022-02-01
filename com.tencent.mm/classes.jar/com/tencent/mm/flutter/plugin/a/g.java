package com.tencent.mm.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bx.a
{
  public String desc;
  public String hHB;
  public String hQX;
  public long msd;
  public String mse;
  public LinkedList<h> msn;
  public String mso;
  public int type;
  
  public g()
  {
    AppMethodBeat.i(233282);
    this.msn = new LinkedList();
    AppMethodBeat.o(233282);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(233301);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hQX == null)
      {
        paramVarArgs = new b("Not all required fields were included: snsId");
        AppMethodBeat.o(233301);
        throw paramVarArgs;
      }
      if (this.desc == null)
      {
        paramVarArgs = new b("Not all required fields were included: desc");
        AppMethodBeat.o(233301);
        throw paramVarArgs;
      }
      if (this.hHB == null)
      {
        paramVarArgs = new b("Not all required fields were included: localId");
        AppMethodBeat.o(233301);
        throw paramVarArgs;
      }
      if (this.mso == null)
      {
        paramVarArgs = new b("Not all required fields were included: publishId");
        AppMethodBeat.o(233301);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.msd);
      if (this.hQX != null) {
        paramVarArgs.g(2, this.hQX);
      }
      paramVarArgs.bS(3, this.type);
      if (this.desc != null) {
        paramVarArgs.g(4, this.desc);
      }
      paramVarArgs.e(5, 8, this.msn);
      if (this.hHB != null) {
        paramVarArgs.g(6, this.hHB);
      }
      if (this.mse != null) {
        paramVarArgs.g(7, this.mse);
      }
      if (this.mso != null) {
        paramVarArgs.g(8, this.mso);
      }
      AppMethodBeat.o(233301);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.msd) + 0;
      paramInt = i;
      if (this.hQX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hQX);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.type);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.desc);
      }
      i = paramInt + i.a.a.a.c(5, 8, this.msn);
      paramInt = i;
      if (this.hHB != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.hHB);
      }
      i = paramInt;
      if (this.mse != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.mse);
      }
      paramInt = i;
      if (this.mso != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.mso);
      }
      AppMethodBeat.o(233301);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.msn.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.hQX == null)
      {
        paramVarArgs = new b("Not all required fields were included: snsId");
        AppMethodBeat.o(233301);
        throw paramVarArgs;
      }
      if (this.desc == null)
      {
        paramVarArgs = new b("Not all required fields were included: desc");
        AppMethodBeat.o(233301);
        throw paramVarArgs;
      }
      if (this.hHB == null)
      {
        paramVarArgs = new b("Not all required fields were included: localId");
        AppMethodBeat.o(233301);
        throw paramVarArgs;
      }
      if (this.mso == null)
      {
        paramVarArgs = new b("Not all required fields were included: publishId");
        AppMethodBeat.o(233301);
        throw paramVarArgs;
      }
      AppMethodBeat.o(233301);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(233301);
        return -1;
      case 1: 
        localg.msd = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(233301);
        return 0;
      case 2: 
        localg.hQX = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(233301);
        return 0;
      case 3: 
        localg.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(233301);
        return 0;
      case 4: 
        localg.desc = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(233301);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          h localh = new h();
          if ((localObject != null) && (localObject.length > 0)) {
            localh.parseFrom((byte[])localObject);
          }
          localg.msn.add(localh);
          paramInt += 1;
        }
        AppMethodBeat.o(233301);
        return 0;
      case 6: 
        localg.hHB = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(233301);
        return 0;
      case 7: 
        localg.mse = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(233301);
        return 0;
      }
      localg.mso = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(233301);
      return 0;
    }
    AppMethodBeat.o(233301);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.a.g
 * JD-Core Version:    0.7.0.1
 */