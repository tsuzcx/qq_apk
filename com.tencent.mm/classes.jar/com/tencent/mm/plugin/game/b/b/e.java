package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public String appId;
  public String appName;
  public int appType;
  public long createTime;
  public boolean dCQ;
  public long duration;
  public long size;
  public String tGK;
  public boolean tSe;
  public boolean tSf;
  public String tSg;
  public String tSh;
  public String tSi;
  public LinkedList<l> tSj;
  public String tSk;
  public String tSl;
  public String title;
  public String videoPath;
  public String videoUrl;
  
  public e()
  {
    AppMethodBeat.i(40868);
    this.tSj = new LinkedList();
    AppMethodBeat.o(40868);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40869);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.dCQ);
      paramVarArgs.bt(2, this.tSe);
      paramVarArgs.bt(3, this.tSf);
      if (this.tSg != null) {
        paramVarArgs.d(4, this.tSg);
      }
      if (this.tSh != null) {
        paramVarArgs.d(5, this.tSh);
      }
      if (this.videoUrl != null) {
        paramVarArgs.d(6, this.videoUrl);
      }
      if (this.title != null) {
        paramVarArgs.d(7, this.title);
      }
      if (this.tSi != null) {
        paramVarArgs.d(8, this.tSi);
      }
      paramVarArgs.e(9, 8, this.tSj);
      paramVarArgs.aY(10, this.createTime);
      paramVarArgs.aY(11, this.duration);
      paramVarArgs.aY(12, this.size);
      if (this.appId != null) {
        paramVarArgs.d(13, this.appId);
      }
      if (this.appName != null) {
        paramVarArgs.d(14, this.appName);
      }
      paramVarArgs.aS(15, this.appType);
      if (this.videoPath != null) {
        paramVarArgs.d(16, this.videoPath);
      }
      if (this.tGK != null) {
        paramVarArgs.d(17, this.tGK);
      }
      if (this.tSk != null) {
        paramVarArgs.d(18, this.tSk);
      }
      if (this.tSl != null) {
        paramVarArgs.d(19, this.tSl);
      }
      AppMethodBeat.o(40869);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.alV(1) + 0 + f.a.a.b.b.a.alV(2) + f.a.a.b.b.a.alV(3);
      paramInt = i;
      if (this.tSg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tSg);
      }
      i = paramInt;
      if (this.tSh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tSh);
      }
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.videoUrl);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.title);
      }
      paramInt = i;
      if (this.tSi != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.tSi);
      }
      i = paramInt + f.a.a.a.c(9, 8, this.tSj) + f.a.a.b.b.a.p(10, this.createTime) + f.a.a.b.b.a.p(11, this.duration) + f.a.a.b.b.a.p(12, this.size);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.appId);
      }
      i = paramInt;
      if (this.appName != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.appName);
      }
      i += f.a.a.b.b.a.bz(15, this.appType);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.videoPath);
      }
      i = paramInt;
      if (this.tGK != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.tGK);
      }
      paramInt = i;
      if (this.tSk != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.tSk);
      }
      i = paramInt;
      if (this.tSl != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.tSl);
      }
      AppMethodBeat.o(40869);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tSj.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(40869);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(40869);
        return -1;
      case 1: 
        locale.dCQ = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(40869);
        return 0;
      case 2: 
        locale.tSe = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(40869);
        return 0;
      case 3: 
        locale.tSf = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(40869);
        return 0;
      case 4: 
        locale.tSg = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 5: 
        locale.tSh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 6: 
        locale.videoUrl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 7: 
        locale.title = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 8: 
        locale.tSi = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.tSj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(40869);
        return 0;
      case 10: 
        locale.createTime = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(40869);
        return 0;
      case 11: 
        locale.duration = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(40869);
        return 0;
      case 12: 
        locale.size = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(40869);
        return 0;
      case 13: 
        locale.appId = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 14: 
        locale.appName = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 15: 
        locale.appType = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(40869);
        return 0;
      case 16: 
        locale.videoPath = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 17: 
        locale.tGK = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 18: 
        locale.tSk = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(40869);
        return 0;
      }
      locale.tSl = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(40869);
      return 0;
    }
    AppMethodBeat.o(40869);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.e
 * JD-Core Version:    0.7.0.1
 */