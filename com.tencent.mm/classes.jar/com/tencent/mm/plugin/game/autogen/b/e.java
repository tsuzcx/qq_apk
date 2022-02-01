package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public String ENy;
  public boolean Idj;
  public boolean Idk;
  public String Idl;
  public String Idm;
  public LinkedList<l> Idn;
  public String Ido;
  public String Idp;
  public String albumName;
  public String appId;
  public String appName;
  public int appType;
  public long createTime;
  public long duration;
  public boolean hJv;
  public long size;
  public String title;
  public String videoPath;
  public String videoUrl;
  
  public e()
  {
    AppMethodBeat.i(40868);
    this.Idn = new LinkedList();
    AppMethodBeat.o(40868);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40869);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.hJv);
      paramVarArgs.di(2, this.Idj);
      paramVarArgs.di(3, this.Idk);
      if (this.Idl != null) {
        paramVarArgs.g(4, this.Idl);
      }
      if (this.Idm != null) {
        paramVarArgs.g(5, this.Idm);
      }
      if (this.videoUrl != null) {
        paramVarArgs.g(6, this.videoUrl);
      }
      if (this.title != null) {
        paramVarArgs.g(7, this.title);
      }
      if (this.ENy != null) {
        paramVarArgs.g(8, this.ENy);
      }
      paramVarArgs.e(9, 8, this.Idn);
      paramVarArgs.bv(10, this.createTime);
      paramVarArgs.bv(11, this.duration);
      paramVarArgs.bv(12, this.size);
      if (this.appId != null) {
        paramVarArgs.g(13, this.appId);
      }
      if (this.appName != null) {
        paramVarArgs.g(14, this.appName);
      }
      paramVarArgs.bS(15, this.appType);
      if (this.videoPath != null) {
        paramVarArgs.g(16, this.videoPath);
      }
      if (this.albumName != null) {
        paramVarArgs.g(17, this.albumName);
      }
      if (this.Ido != null) {
        paramVarArgs.g(18, this.Ido);
      }
      if (this.Idp != null) {
        paramVarArgs.g(19, this.Idp);
      }
      AppMethodBeat.o(40869);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.ko(1) + 1 + 0 + (i.a.a.b.b.a.ko(2) + 1) + (i.a.a.b.b.a.ko(3) + 1);
      paramInt = i;
      if (this.Idl != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Idl);
      }
      i = paramInt;
      if (this.Idm != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Idm);
      }
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.videoUrl);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.title);
      }
      paramInt = i;
      if (this.ENy != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ENy);
      }
      i = paramInt + i.a.a.a.c(9, 8, this.Idn) + i.a.a.b.b.a.q(10, this.createTime) + i.a.a.b.b.a.q(11, this.duration) + i.a.a.b.b.a.q(12, this.size);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.appId);
      }
      i = paramInt;
      if (this.appName != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.appName);
      }
      i += i.a.a.b.b.a.cJ(15, this.appType);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.videoPath);
      }
      i = paramInt;
      if (this.albumName != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.albumName);
      }
      paramInt = i;
      if (this.Ido != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.Ido);
      }
      i = paramInt;
      if (this.Idp != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.Idp);
      }
      AppMethodBeat.o(40869);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Idn.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(40869);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(40869);
        return -1;
      case 1: 
        locale.hJv = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(40869);
        return 0;
      case 2: 
        locale.Idj = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(40869);
        return 0;
      case 3: 
        locale.Idk = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(40869);
        return 0;
      case 4: 
        locale.Idl = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 5: 
        locale.Idm = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 6: 
        locale.videoUrl = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 7: 
        locale.title = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 8: 
        locale.ENy = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          l locall = new l();
          if ((localObject != null) && (localObject.length > 0)) {
            locall.parseFrom((byte[])localObject);
          }
          locale.Idn.add(locall);
          paramInt += 1;
        }
        AppMethodBeat.o(40869);
        return 0;
      case 10: 
        locale.createTime = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(40869);
        return 0;
      case 11: 
        locale.duration = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(40869);
        return 0;
      case 12: 
        locale.size = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(40869);
        return 0;
      case 13: 
        locale.appId = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 14: 
        locale.appName = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 15: 
        locale.appType = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(40869);
        return 0;
      case 16: 
        locale.videoPath = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 17: 
        locale.albumName = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(40869);
        return 0;
      case 18: 
        locale.Ido = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(40869);
        return 0;
      }
      locale.Idp = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(40869);
      return 0;
    }
    AppMethodBeat.o(40869);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.e
 * JD-Core Version:    0.7.0.1
 */