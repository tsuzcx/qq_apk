package com.tencent.mm.plugin.backup.i;

public final class ae
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b hPF;
  public String hQV;
  public int hQW;
  public int hQY;
  public int hQZ;
  public int hQq;
  public int hRa;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hQV == null) {
        throw new d.a.a.b("Not all required fields were included: DataID");
      }
      if (this.hQV != null) {
        paramVarArgs.d(1, this.hQV);
      }
      paramVarArgs.gB(2, this.hQW);
      paramVarArgs.gB(3, this.hQY);
      paramVarArgs.gB(4, this.hQZ);
      paramVarArgs.gB(5, this.hQq);
      paramVarArgs.gB(6, this.hRa);
      if (this.hPF != null) {
        paramVarArgs.b(7, this.hPF);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hQV == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = d.a.a.b.b.a.e(1, this.hQV) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.hQW) + d.a.a.a.gy(3, this.hQY) + d.a.a.a.gy(4, this.hQZ) + d.a.a.a.gy(5, this.hQq) + d.a.a.a.gy(6, this.hRa);
      paramInt = i;
      if (this.hPF != null) {
        paramInt = i + d.a.a.a.a(7, this.hPF);
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
        if (this.hQV != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: DataID");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localae.hQV = locala.xpH.readString();
          return 0;
        case 2: 
          localae.hQW = locala.xpH.oD();
          return 0;
        case 3: 
          localae.hQY = locala.xpH.oD();
          return 0;
        case 4: 
          localae.hQZ = locala.xpH.oD();
          return 0;
        case 5: 
          localae.hQq = locala.xpH.oD();
          return 0;
        case 6: 
          localae.hRa = locala.xpH.oD();
          return 0;
        }
        localae.hPF = locala.cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ae
 * JD-Core Version:    0.7.0.1
 */