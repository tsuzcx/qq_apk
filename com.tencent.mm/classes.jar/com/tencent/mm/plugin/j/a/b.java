package com.tencent.mm.plugin.j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public String eQY;
  public String title;
  public String type;
  public int uVo;
  public String uVp;
  public String uVq;
  public String uVr;
  public String uVs;
  public String uVt;
  public String uVu;
  public String uVv;
  public String uVw;
  public String uVx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(25280);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uVo);
      if (this.type != null) {
        paramVarArgs.d(2, this.type);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.uVp != null) {
        paramVarArgs.d(4, this.uVp);
      }
      if (this.uVq != null) {
        paramVarArgs.d(5, this.uVq);
      }
      if (this.uVr != null) {
        paramVarArgs.d(6, this.uVr);
      }
      if (this.uVs != null) {
        paramVarArgs.d(7, this.uVs);
      }
      if (this.uVt != null) {
        paramVarArgs.d(8, this.uVt);
      }
      if (this.uVu != null) {
        paramVarArgs.d(9, this.uVu);
      }
      if (this.uVv != null) {
        paramVarArgs.d(10, this.uVv);
      }
      if (this.eQY != null) {
        paramVarArgs.d(11, this.eQY);
      }
      if (this.uVw != null) {
        paramVarArgs.d(12, this.uVw);
      }
      if (this.uVx != null) {
        paramVarArgs.d(13, this.uVx);
      }
      AppMethodBeat.o(25280);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uVo) + 0;
      paramInt = i;
      if (this.type != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.type);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.title);
      }
      paramInt = i;
      if (this.uVp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uVp);
      }
      i = paramInt;
      if (this.uVq != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uVq);
      }
      paramInt = i;
      if (this.uVr != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uVr);
      }
      i = paramInt;
      if (this.uVs != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.uVs);
      }
      paramInt = i;
      if (this.uVt != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.uVt);
      }
      i = paramInt;
      if (this.uVu != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.uVu);
      }
      paramInt = i;
      if (this.uVv != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.uVv);
      }
      i = paramInt;
      if (this.eQY != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.eQY);
      }
      paramInt = i;
      if (this.uVw != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.uVw);
      }
      i = paramInt;
      if (this.uVx != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.uVx);
      }
      AppMethodBeat.o(25280);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(25280);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(25280);
        return -1;
      case 1: 
        localb.uVo = locala.OmT.zc();
        AppMethodBeat.o(25280);
        return 0;
      case 2: 
        localb.type = locala.OmT.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 3: 
        localb.title = locala.OmT.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 4: 
        localb.uVp = locala.OmT.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 5: 
        localb.uVq = locala.OmT.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 6: 
        localb.uVr = locala.OmT.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 7: 
        localb.uVs = locala.OmT.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 8: 
        localb.uVt = locala.OmT.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 9: 
        localb.uVu = locala.OmT.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 10: 
        localb.uVv = locala.OmT.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 11: 
        localb.eQY = locala.OmT.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 12: 
        localb.uVw = locala.OmT.readString();
        AppMethodBeat.o(25280);
        return 0;
      }
      localb.uVx = locala.OmT.readString();
      AppMethodBeat.o(25280);
      return 0;
    }
    AppMethodBeat.o(25280);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.j.a.b
 * JD-Core Version:    0.7.0.1
 */