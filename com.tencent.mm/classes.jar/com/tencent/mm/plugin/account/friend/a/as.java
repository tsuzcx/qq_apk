package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as
{
  int dtM;
  String gUa;
  String gUb;
  public int gUc;
  public int gUd;
  public long ilB;
  public int ilC;
  int ilD;
  String ilE;
  String ilF;
  String ilG;
  String ilH;
  String ilI;
  public String ilJ;
  String ilK;
  String ilL;
  public String nickname;
  public String username;
  
  public as()
  {
    AppMethodBeat.i(131159);
    this.dtM = -1;
    this.ilB = 0L;
    this.ilC = 0;
    this.ilD = 0;
    this.username = "";
    this.nickname = "";
    this.ilE = "";
    this.ilF = "";
    this.ilG = "";
    this.ilH = "";
    this.ilI = "";
    this.ilJ = "";
    this.ilK = "";
    this.ilL = "";
    this.gUa = "";
    this.gUb = "";
    this.gUc = 0;
    this.gUd = 0;
    AppMethodBeat.o(131159);
  }
  
  public final String Su()
  {
    if (this.nickname == null) {
      return "";
    }
    return this.nickname;
  }
  
  public final ContentValues aJh()
  {
    AppMethodBeat.i(131161);
    ContentValues localContentValues = new ContentValues();
    if ((this.dtM & 0x1) != 0) {
      localContentValues.put("qq", Long.valueOf(this.ilB));
    }
    int i;
    if ((this.dtM & 0x2) != 0)
    {
      i = this.ilC;
      if (i == 0) {
        localContentValues.put("wexinstatus", Integer.valueOf(65536));
      }
    }
    else
    {
      if ((this.dtM & 0x4) != 0) {
        localContentValues.put("groupid", Integer.valueOf(this.ilD));
      }
      if ((this.dtM & 0x8) != 0) {
        localContentValues.put("username", getUsername());
      }
      if ((this.dtM & 0x10) != 0) {
        localContentValues.put("nickname", Su());
      }
      if ((this.dtM & 0x20) != 0)
      {
        if (this.ilE != null) {
          break label400;
        }
        str = "";
        label146:
        localContentValues.put("pyinitial", str);
      }
      if ((this.dtM & 0x40) != 0)
      {
        if (this.ilF != null) {
          break label408;
        }
        str = "";
        label173:
        localContentValues.put("quanpin", str);
      }
      if ((this.dtM & 0x80) != 0) {
        localContentValues.put("qqnickname", aJi());
      }
      if ((this.dtM & 0x100) != 0) {
        localContentValues.put("qqpyinitial", aJj());
      }
      if ((this.dtM & 0x200) != 0) {
        localContentValues.put("qqquanpin", aJk());
      }
      if ((this.dtM & 0x400) != 0) {
        localContentValues.put("qqremark", aJl());
      }
      if ((this.dtM & 0x800) != 0) {
        localContentValues.put("qqremarkpyinitial", aJm());
      }
      if ((this.dtM & 0x1000) != 0) {
        localContentValues.put("qqremarkquanpin", aJn());
      }
      if ((this.dtM & 0x4000) != 0) {
        if (this.gUb != null) {
          break label416;
        }
      }
    }
    label400:
    label408:
    label416:
    for (String str = "";; str = this.gUb)
    {
      localContentValues.put("reserved2", str);
      if ((this.dtM & 0x8000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.gUc));
      }
      if ((this.dtM & 0x10000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.gUd));
      }
      AppMethodBeat.o(131161);
      return localContentValues;
      localContentValues.put("wexinstatus", Integer.valueOf(i));
      break;
      str = this.ilE;
      break label146;
      str = this.ilF;
      break label173;
    }
  }
  
  public final String aJi()
  {
    if (this.ilG == null) {
      return "";
    }
    return this.ilG;
  }
  
  public final String aJj()
  {
    if (this.ilH == null) {
      return "";
    }
    return this.ilH;
  }
  
  public final String aJk()
  {
    if (this.ilI == null) {
      return "";
    }
    return this.ilI;
  }
  
  public final String aJl()
  {
    if (this.ilJ == null) {
      return "";
    }
    return this.ilJ;
  }
  
  public final String aJm()
  {
    if (this.ilK == null) {
      return "";
    }
    return this.ilK;
  }
  
  public final String aJn()
  {
    if (this.ilL == null) {
      return "";
    }
    return this.ilL;
  }
  
  public final void aJo()
  {
    this.gUc |= 0x1;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131160);
    this.ilB = paramCursor.getLong(0);
    int i = paramCursor.getInt(1);
    if (i == 65536) {}
    for (this.ilC = 0;; this.ilC = i)
    {
      this.ilD = paramCursor.getInt(2);
      this.username = paramCursor.getString(3);
      this.nickname = paramCursor.getString(4);
      this.ilE = paramCursor.getString(5);
      this.ilF = paramCursor.getString(6);
      this.ilG = paramCursor.getString(7);
      this.ilH = paramCursor.getString(8);
      this.ilI = paramCursor.getString(9);
      this.ilJ = paramCursor.getString(10);
      this.ilK = paramCursor.getString(11);
      this.ilL = paramCursor.getString(12);
      this.gUa = paramCursor.getString(13);
      this.gUb = paramCursor.getString(14);
      this.gUc = paramCursor.getInt(15);
      this.gUd = paramCursor.getInt(16);
      AppMethodBeat.o(131160);
      return;
    }
  }
  
  public final String getDisplayName()
  {
    AppMethodBeat.i(131162);
    if ((aJl() == null) || (aJl().length() <= 0))
    {
      str = aJi();
      AppMethodBeat.o(131162);
      return str;
    }
    String str = aJl();
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
    ((StringBuilder)localObject).append("groupID\t:").append(this.ilD).append("\n");
    ((StringBuilder)localObject).append("qq\t:").append(this.ilB).append("\n");
    ((StringBuilder)localObject).append("username\t:").append(this.username).append("\n");
    ((StringBuilder)localObject).append("nickname\t:").append(this.nickname).append("\n");
    ((StringBuilder)localObject).append("wexinStatus\t:").append(this.ilC).append("\n");
    ((StringBuilder)localObject).append("reserved3\t:").append(this.gUc).append("\n");
    ((StringBuilder)localObject).append("reserved4\t:").append(this.gUd).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(131163);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.as
 * JD-Core Version:    0.7.0.1
 */