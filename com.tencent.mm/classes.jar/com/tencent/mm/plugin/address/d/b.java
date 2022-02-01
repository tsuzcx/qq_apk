package com.tencent.mm.plugin.address.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public int id;
  public String jrZ;
  public String jsa;
  public String jsb;
  public String jsc;
  public String jsd;
  public String jse;
  public String jsf;
  public String jsg;
  public String jsh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(20827);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.id);
      if (this.jrZ != null) {
        paramVarArgs.d(2, this.jrZ);
      }
      if (this.jsa != null) {
        paramVarArgs.d(3, this.jsa);
      }
      if (this.jsb != null) {
        paramVarArgs.d(4, this.jsb);
      }
      if (this.jsc != null) {
        paramVarArgs.d(5, this.jsc);
      }
      if (this.jsd != null) {
        paramVarArgs.d(6, this.jsd);
      }
      if (this.jse != null) {
        paramVarArgs.d(7, this.jse);
      }
      if (this.jsf != null) {
        paramVarArgs.d(8, this.jsf);
      }
      if (this.jsg != null) {
        paramVarArgs.d(9, this.jsg);
      }
      if (this.jsh != null) {
        paramVarArgs.d(10, this.jsh);
      }
      AppMethodBeat.o(20827);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.id) + 0;
      paramInt = i;
      if (this.jrZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.jrZ);
      }
      i = paramInt;
      if (this.jsa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.jsa);
      }
      paramInt = i;
      if (this.jsb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.jsb);
      }
      i = paramInt;
      if (this.jsc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jsc);
      }
      paramInt = i;
      if (this.jsd != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.jsd);
      }
      i = paramInt;
      if (this.jse != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.jse);
      }
      paramInt = i;
      if (this.jsf != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.jsf);
      }
      i = paramInt;
      if (this.jsg != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.jsg);
      }
      paramInt = i;
      if (this.jsh != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.jsh);
      }
      AppMethodBeat.o(20827);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(20827);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(20827);
        return -1;
      case 1: 
        localb.id = locala.NPN.zc();
        AppMethodBeat.o(20827);
        return 0;
      case 2: 
        localb.jrZ = locala.NPN.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 3: 
        localb.jsa = locala.NPN.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 4: 
        localb.jsb = locala.NPN.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 5: 
        localb.jsc = locala.NPN.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 6: 
        localb.jsd = locala.NPN.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 7: 
        localb.jse = locala.NPN.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 8: 
        localb.jsf = locala.NPN.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 9: 
        localb.jsg = locala.NPN.readString();
        AppMethodBeat.o(20827);
        return 0;
      }
      localb.jsh = locala.NPN.readString();
      AppMethodBeat.o(20827);
      return 0;
    }
    AppMethodBeat.o(20827);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.d.b
 * JD-Core Version:    0.7.0.1
 */