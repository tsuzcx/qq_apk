package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aa
  extends com.tencent.mm.bx.a
{
  public String Ktr;
  public String Kts;
  public String Ktt;
  public String Ktu;
  public String pdv;
  public String verifyInfo;
  public int videoHeight;
  public String videoUrl;
  public int videoWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(283925);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Ktr != null) {
        paramVarArgs.g(1, this.Ktr);
      }
      if (this.pdv != null) {
        paramVarArgs.g(2, this.pdv);
      }
      if (this.Kts != null) {
        paramVarArgs.g(3, this.Kts);
      }
      if (this.Ktt != null) {
        paramVarArgs.g(4, this.Ktt);
      }
      if (this.videoUrl != null) {
        paramVarArgs.g(5, this.videoUrl);
      }
      if (this.Ktu != null) {
        paramVarArgs.g(6, this.Ktu);
      }
      paramVarArgs.bS(7, this.videoWidth);
      paramVarArgs.bS(8, this.videoHeight);
      if (this.verifyInfo != null) {
        paramVarArgs.g(9, this.verifyInfo);
      }
      AppMethodBeat.o(283925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ktr == null) {
        break label666;
      }
    }
    label666:
    for (int i = i.a.a.b.b.a.h(1, this.Ktr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pdv != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.pdv);
      }
      i = paramInt;
      if (this.Kts != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Kts);
      }
      paramInt = i;
      if (this.Ktt != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Ktt);
      }
      i = paramInt;
      if (this.videoUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.videoUrl);
      }
      paramInt = i;
      if (this.Ktu != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Ktu);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.videoWidth) + i.a.a.b.b.a.cJ(8, this.videoHeight);
      paramInt = i;
      if (this.verifyInfo != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.verifyInfo);
      }
      AppMethodBeat.o(283925);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(283925);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(283925);
          return -1;
        case 1: 
          localaa.Ktr = locala.ajGk.readString();
          AppMethodBeat.o(283925);
          return 0;
        case 2: 
          localaa.pdv = locala.ajGk.readString();
          AppMethodBeat.o(283925);
          return 0;
        case 3: 
          localaa.Kts = locala.ajGk.readString();
          AppMethodBeat.o(283925);
          return 0;
        case 4: 
          localaa.Ktt = locala.ajGk.readString();
          AppMethodBeat.o(283925);
          return 0;
        case 5: 
          localaa.videoUrl = locala.ajGk.readString();
          AppMethodBeat.o(283925);
          return 0;
        case 6: 
          localaa.Ktu = locala.ajGk.readString();
          AppMethodBeat.o(283925);
          return 0;
        case 7: 
          localaa.videoWidth = locala.ajGk.aar();
          AppMethodBeat.o(283925);
          return 0;
        case 8: 
          localaa.videoHeight = locala.ajGk.aar();
          AppMethodBeat.o(283925);
          return 0;
        }
        localaa.verifyInfo = locala.ajGk.readString();
        AppMethodBeat.o(283925);
        return 0;
      }
      AppMethodBeat.o(283925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.aa
 * JD-Core Version:    0.7.0.1
 */