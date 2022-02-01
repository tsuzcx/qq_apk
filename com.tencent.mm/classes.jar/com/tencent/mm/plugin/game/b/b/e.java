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
  public boolean dtp;
  public long duration;
  public String rBh;
  public boolean rNJ;
  public boolean rNK;
  public String rNL;
  public String rNM;
  public String rNN;
  public LinkedList<l> rNO;
  public String rNP;
  public long size;
  public String title;
  public String videoPath;
  public String videoUrl;
  
  public e()
  {
    AppMethodBeat.i(40868);
    this.rNO = new LinkedList();
    AppMethodBeat.o(40868);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40869);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.dtp);
      paramVarArgs.bg(2, this.rNJ);
      paramVarArgs.bg(3, this.rNK);
      if (this.rNL != null) {
        paramVarArgs.d(4, this.rNL);
      }
      if (this.rNM != null) {
        paramVarArgs.d(5, this.rNM);
      }
      if (this.videoUrl != null) {
        paramVarArgs.d(6, this.videoUrl);
      }
      if (this.title != null) {
        paramVarArgs.d(7, this.title);
      }
      if (this.rNN != null) {
        paramVarArgs.d(8, this.rNN);
      }
      paramVarArgs.e(9, 8, this.rNO);
      paramVarArgs.aG(10, this.createTime);
      paramVarArgs.aG(11, this.duration);
      paramVarArgs.aG(12, this.size);
      if (this.appId != null) {
        paramVarArgs.d(13, this.appId);
      }
      if (this.appName != null) {
        paramVarArgs.d(14, this.appName);
      }
      paramVarArgs.aR(15, this.appType);
      if (this.videoPath != null) {
        paramVarArgs.d(16, this.videoPath);
      }
      if (this.rBh != null) {
        paramVarArgs.d(17, this.rBh);
      }
      if (this.rNP != null) {
        paramVarArgs.d(18, this.rNP);
      }
      AppMethodBeat.o(40869);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.fY(1) + 1 + 0 + (f.a.a.b.b.a.fY(2) + 1) + (f.a.a.b.b.a.fY(3) + 1);
      paramInt = i;
      if (this.rNL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rNL);
      }
      i = paramInt;
      if (this.rNM != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.rNM);
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
      if (this.rNN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.rNN);
      }
      i = paramInt + f.a.a.a.c(9, 8, this.rNO) + f.a.a.b.b.a.q(10, this.createTime) + f.a.a.b.b.a.q(11, this.duration) + f.a.a.b.b.a.q(12, this.size);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.appId);
      }
      i = paramInt;
      if (this.appName != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.appName);
      }
      i += f.a.a.b.b.a.bA(15, this.appType);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.videoPath);
      }
      i = paramInt;
      if (this.rBh != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.rBh);
      }
      paramInt = i;
      if (this.rNP != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.rNP);
      }
      AppMethodBeat.o(40869);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.rNO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        locale.dtp = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(40869);
        return 0;
      case 2: 
        locale.rNJ = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(40869);
        return 0;
      case 3: 
        locale.rNK = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(40869);
        return 0;
      case 4: 
        locale.rNL = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 5: 
        locale.rNM = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 6: 
        locale.videoUrl = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 7: 
        locale.title = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 8: 
        locale.rNN = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.rNO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(40869);
        return 0;
      case 10: 
        locale.createTime = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(40869);
        return 0;
      case 11: 
        locale.duration = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(40869);
        return 0;
      case 12: 
        locale.size = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(40869);
        return 0;
      case 13: 
        locale.appId = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 14: 
        locale.appName = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 15: 
        locale.appType = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(40869);
        return 0;
      case 16: 
        locale.videoPath = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 17: 
        locale.rBh = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(40869);
        return 0;
      }
      locale.rNP = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(40869);
      return 0;
    }
    AppMethodBeat.o(40869);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.e
 * JD-Core Version:    0.7.0.1
 */