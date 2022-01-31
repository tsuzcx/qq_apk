package com.tencent.mm.plugin.backup.i;

public final class q
  extends com.tencent.mm.bv.a
{
  public String hQA;
  public long hQB;
  public long hQC;
  public String hQD;
  public String hQE;
  public com.tencent.mm.bv.b hQF;
  public com.tencent.mm.bv.b hQG;
  public String hQd;
  public String hQx;
  public String hQy;
  public String hQz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hQx == null) {
        throw new d.a.a.b("Not all required fields were included: WeChatVersion");
      }
      if (this.hQy == null) {
        throw new d.a.a.b("Not all required fields were included: WeChatUserID");
      }
      if (this.hQz == null) {
        throw new d.a.a.b("Not all required fields were included: WeChatNickName");
      }
      if (this.hQA == null) {
        throw new d.a.a.b("Not all required fields were included: WeChatInstallDir");
      }
      if (this.hQD == null) {
        throw new d.a.a.b("Not all required fields were included: Manufacturer");
      }
      if (this.hQd == null) {
        throw new d.a.a.b("Not all required fields were included: Model");
      }
      if (this.hQE == null) {
        throw new d.a.a.b("Not all required fields were included: Version");
      }
      if (this.hQx != null) {
        paramVarArgs.d(1, this.hQx);
      }
      if (this.hQy != null) {
        paramVarArgs.d(2, this.hQy);
      }
      if (this.hQz != null) {
        paramVarArgs.d(3, this.hQz);
      }
      if (this.hQA != null) {
        paramVarArgs.d(4, this.hQA);
      }
      paramVarArgs.Y(5, this.hQB);
      paramVarArgs.Y(6, this.hQC);
      if (this.hQD != null) {
        paramVarArgs.d(7, this.hQD);
      }
      if (this.hQd != null) {
        paramVarArgs.d(8, this.hQd);
      }
      if (this.hQE != null) {
        paramVarArgs.d(9, this.hQE);
      }
      if (this.hQF != null) {
        paramVarArgs.b(10, this.hQF);
      }
      if (this.hQG != null) {
        paramVarArgs.b(11, this.hQG);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hQx == null) {
        break label939;
      }
    }
    label939:
    for (int i = d.a.a.b.b.a.e(1, this.hQx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hQy != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hQy);
      }
      i = paramInt;
      if (this.hQz != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.hQz);
      }
      paramInt = i;
      if (this.hQA != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.hQA);
      }
      i = paramInt + d.a.a.a.X(5, this.hQB) + d.a.a.a.X(6, this.hQC);
      paramInt = i;
      if (this.hQD != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.hQD);
      }
      i = paramInt;
      if (this.hQd != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.hQd);
      }
      paramInt = i;
      if (this.hQE != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.hQE);
      }
      i = paramInt;
      if (this.hQF != null) {
        i = paramInt + d.a.a.a.a(10, this.hQF);
      }
      paramInt = i;
      if (this.hQG != null) {
        paramInt = i + d.a.a.a.a(11, this.hQG);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.hQx == null) {
          throw new d.a.a.b("Not all required fields were included: WeChatVersion");
        }
        if (this.hQy == null) {
          throw new d.a.a.b("Not all required fields were included: WeChatUserID");
        }
        if (this.hQz == null) {
          throw new d.a.a.b("Not all required fields were included: WeChatNickName");
        }
        if (this.hQA == null) {
          throw new d.a.a.b("Not all required fields were included: WeChatInstallDir");
        }
        if (this.hQD == null) {
          throw new d.a.a.b("Not all required fields were included: Manufacturer");
        }
        if (this.hQd == null) {
          throw new d.a.a.b("Not all required fields were included: Model");
        }
        if (this.hQE != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: Version");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localq.hQx = locala.xpH.readString();
          return 0;
        case 2: 
          localq.hQy = locala.xpH.readString();
          return 0;
        case 3: 
          localq.hQz = locala.xpH.readString();
          return 0;
        case 4: 
          localq.hQA = locala.xpH.readString();
          return 0;
        case 5: 
          localq.hQB = locala.xpH.oE();
          return 0;
        case 6: 
          localq.hQC = locala.xpH.oE();
          return 0;
        case 7: 
          localq.hQD = locala.xpH.readString();
          return 0;
        case 8: 
          localq.hQd = locala.xpH.readString();
          return 0;
        case 9: 
          localq.hQE = locala.xpH.readString();
          return 0;
        case 10: 
          localq.hQF = locala.cUs();
          return 0;
        }
        localq.hQG = locala.cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.q
 * JD-Core Version:    0.7.0.1
 */