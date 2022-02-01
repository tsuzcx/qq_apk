package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class eh
  extends com.tencent.mm.bx.a
{
  public String IconUrl;
  public String iht;
  public String nDo;
  public String ufG;
  public String uiR;
  public String ujc;
  public int ukt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iht == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(41847);
        throw paramVarArgs;
      }
      if (this.iht != null) {
        paramVarArgs.d(1, this.iht);
      }
      if (this.uiR != null) {
        paramVarArgs.d(2, this.uiR);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(3, this.IconUrl);
      }
      if (this.nDo != null) {
        paramVarArgs.d(4, this.nDo);
      }
      if (this.ujc != null) {
        paramVarArgs.d(5, this.ujc);
      }
      paramVarArgs.aS(6, this.ukt);
      if (this.ufG != null) {
        paramVarArgs.d(7, this.ufG);
      }
      AppMethodBeat.o(41847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iht == null) {
        break label610;
      }
    }
    label610:
    for (int i = f.a.a.b.b.a.e(1, this.iht) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uiR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uiR);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IconUrl);
      }
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nDo);
      }
      i = paramInt;
      if (this.ujc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ujc);
      }
      i += f.a.a.b.b.a.bz(6, this.ukt);
      paramInt = i;
      if (this.ufG != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ufG);
      }
      AppMethodBeat.o(41847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.iht == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(41847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41847);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eh localeh = (eh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41847);
          return -1;
        case 1: 
          localeh.iht = locala.NPN.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 2: 
          localeh.uiR = locala.NPN.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 3: 
          localeh.IconUrl = locala.NPN.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 4: 
          localeh.nDo = locala.NPN.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 5: 
          localeh.ujc = locala.NPN.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 6: 
          localeh.ukt = locala.NPN.zc();
          AppMethodBeat.o(41847);
          return 0;
        }
        localeh.ufG = locala.NPN.readString();
        AppMethodBeat.o(41847);
        return 0;
      }
      AppMethodBeat.o(41847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.eh
 * JD-Core Version:    0.7.0.1
 */