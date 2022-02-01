package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as
{
  int dDp;
  String hMR;
  String hMS;
  public int hMT;
  public int hMU;
  public long jeR;
  public int jeS;
  int jeT;
  String jeU;
  String jeV;
  String jeW;
  String jeX;
  String jeY;
  public String jeZ;
  String jfa;
  String jfb;
  public String nickname;
  public String username;
  
  public as()
  {
    AppMethodBeat.i(131159);
    this.dDp = -1;
    this.jeR = 0L;
    this.jeS = 0;
    this.jeT = 0;
    this.username = "";
    this.nickname = "";
    this.jeU = "";
    this.jeV = "";
    this.jeW = "";
    this.jeX = "";
    this.jeY = "";
    this.jeZ = "";
    this.jfa = "";
    this.jfb = "";
    this.hMR = "";
    this.hMS = "";
    this.hMT = 0;
    this.hMU = 0;
    AppMethodBeat.o(131159);
  }
  
  public final String VC()
  {
    if (this.nickname == null) {
      return "";
    }
    return this.nickname;
  }
  
  public final ContentValues aTk()
  {
    AppMethodBeat.i(131161);
    ContentValues localContentValues = new ContentValues();
    if ((this.dDp & 0x1) != 0) {
      localContentValues.put("qq", Long.valueOf(this.jeR));
    }
    int i;
    if ((this.dDp & 0x2) != 0)
    {
      i = this.jeS;
      if (i == 0) {
        localContentValues.put("wexinstatus", Integer.valueOf(65536));
      }
    }
    else
    {
      if ((this.dDp & 0x4) != 0) {
        localContentValues.put("groupid", Integer.valueOf(this.jeT));
      }
      if ((this.dDp & 0x8) != 0) {
        localContentValues.put("username", getUsername());
      }
      if ((this.dDp & 0x10) != 0) {
        localContentValues.put("nickname", VC());
      }
      if ((this.dDp & 0x20) != 0)
      {
        if (this.jeU != null) {
          break label400;
        }
        str = "";
        label146:
        localContentValues.put("pyinitial", str);
      }
      if ((this.dDp & 0x40) != 0)
      {
        if (this.jeV != null) {
          break label408;
        }
        str = "";
        label173:
        localContentValues.put("quanpin", str);
      }
      if ((this.dDp & 0x80) != 0) {
        localContentValues.put("qqnickname", aTl());
      }
      if ((this.dDp & 0x100) != 0) {
        localContentValues.put("qqpyinitial", aTm());
      }
      if ((this.dDp & 0x200) != 0) {
        localContentValues.put("qqquanpin", aTn());
      }
      if ((this.dDp & 0x400) != 0) {
        localContentValues.put("qqremark", aTo());
      }
      if ((this.dDp & 0x800) != 0) {
        localContentValues.put("qqremarkpyinitial", aTp());
      }
      if ((this.dDp & 0x1000) != 0) {
        localContentValues.put("qqremarkquanpin", aTq());
      }
      if ((this.dDp & 0x4000) != 0) {
        if (this.hMS != null) {
          break label416;
        }
      }
    }
    label400:
    label408:
    label416:
    for (String str = "";; str = this.hMS)
    {
      localContentValues.put("reserved2", str);
      if ((this.dDp & 0x8000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.hMT));
      }
      if ((this.dDp & 0x10000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.hMU));
      }
      AppMethodBeat.o(131161);
      return localContentValues;
      localContentValues.put("wexinstatus", Integer.valueOf(i));
      break;
      str = this.jeU;
      break label146;
      str = this.jeV;
      break label173;
    }
  }
  
  public final String aTl()
  {
    if (this.jeW == null) {
      return "";
    }
    return this.jeW;
  }
  
  public final String aTm()
  {
    if (this.jeX == null) {
      return "";
    }
    return this.jeX;
  }
  
  public final String aTn()
  {
    if (this.jeY == null) {
      return "";
    }
    return this.jeY;
  }
  
  public final String aTo()
  {
    if (this.jeZ == null) {
      return "";
    }
    return this.jeZ;
  }
  
  public final String aTp()
  {
    if (this.jfa == null) {
      return "";
    }
    return this.jfa;
  }
  
  public final String aTq()
  {
    if (this.jfb == null) {
      return "";
    }
    return this.jfb;
  }
  
  public final void aTr()
  {
    this.hMT |= 0x1;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131160);
    this.jeR = paramCursor.getLong(0);
    int i = paramCursor.getInt(1);
    if (i == 65536) {}
    for (this.jeS = 0;; this.jeS = i)
    {
      this.jeT = paramCursor.getInt(2);
      this.username = paramCursor.getString(3);
      this.nickname = paramCursor.getString(4);
      this.jeU = paramCursor.getString(5);
      this.jeV = paramCursor.getString(6);
      this.jeW = paramCursor.getString(7);
      this.jeX = paramCursor.getString(8);
      this.jeY = paramCursor.getString(9);
      this.jeZ = paramCursor.getString(10);
      this.jfa = paramCursor.getString(11);
      this.jfb = paramCursor.getString(12);
      this.hMR = paramCursor.getString(13);
      this.hMS = paramCursor.getString(14);
      this.hMT = paramCursor.getInt(15);
      this.hMU = paramCursor.getInt(16);
      AppMethodBeat.o(131160);
      return;
    }
  }
  
  public final String getDisplayName()
  {
    AppMethodBeat.i(131162);
    if ((aTo() == null) || (aTo().length() <= 0))
    {
      str = aTl();
      AppMethodBeat.o(131162);
      return str;
    }
    String str = aTo();
    AppMethodBeat.o(131162);
    return str;
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(131163);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("groupID\t:").append(this.jeT).append("\n");
    ((StringBuilder)localObject).append("qq\t:").append(this.jeR).append("\n");
    ((StringBuilder)localObject).append("username\t:").append(this.username).append("\n");
    ((StringBuilder)localObject).append("nickname\t:").append(this.nickname).append("\n");
    ((StringBuilder)localObject).append("wexinStatus\t:").append(this.jeS).append("\n");
    ((StringBuilder)localObject).append("reserved3\t:").append(this.hMT).append("\n");
    ((StringBuilder)localObject).append("reserved4\t:").append(this.hMU).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(131163);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.as
 * JD-Core Version:    0.7.0.1
 */