package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ds
  extends com.tencent.mm.bx.a
{
  public String IconUrl;
  public String hnC;
  public String mAQ;
  public String rZW;
  public String scR;
  public String sdZ;
  public int sea;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hnC == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(41847);
        throw paramVarArgs;
      }
      if (this.hnC != null) {
        paramVarArgs.d(1, this.hnC);
      }
      if (this.scR != null) {
        paramVarArgs.d(2, this.scR);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(3, this.IconUrl);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(4, this.mAQ);
      }
      if (this.sdZ != null) {
        paramVarArgs.d(5, this.sdZ);
      }
      paramVarArgs.aR(6, this.sea);
      if (this.rZW != null) {
        paramVarArgs.d(7, this.rZW);
      }
      AppMethodBeat.o(41847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hnC == null) {
        break label610;
      }
    }
    label610:
    for (int i = f.a.a.b.b.a.e(1, this.hnC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.scR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.scR);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IconUrl);
      }
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mAQ);
      }
      i = paramInt;
      if (this.sdZ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.sdZ);
      }
      i += f.a.a.b.b.a.bA(6, this.sea);
      paramInt = i;
      if (this.rZW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.rZW);
      }
      AppMethodBeat.o(41847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.hnC == null)
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
        ds localds = (ds)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41847);
          return -1;
        case 1: 
          localds.hnC = locala.KhF.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 2: 
          localds.scR = locala.KhF.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 3: 
          localds.IconUrl = locala.KhF.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 4: 
          localds.mAQ = locala.KhF.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 5: 
          localds.sdZ = locala.KhF.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 6: 
          localds.sea = locala.KhF.xS();
          AppMethodBeat.o(41847);
          return 0;
        }
        localds.rZW = locala.KhF.readString();
        AppMethodBeat.o(41847);
        return 0;
      }
      AppMethodBeat.o(41847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ds
 * JD-Core Version:    0.7.0.1
 */