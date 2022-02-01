package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as
{
  int drx;
  String huA;
  public int huB;
  public int huC;
  String huz;
  public long iLI;
  public int iLJ;
  int iLK;
  String iLL;
  String iLM;
  String iLN;
  String iLO;
  String iLP;
  public String iLQ;
  String iLR;
  String iLS;
  public String nickname;
  public String username;
  
  public as()
  {
    AppMethodBeat.i(131159);
    this.drx = -1;
    this.iLI = 0L;
    this.iLJ = 0;
    this.iLK = 0;
    this.username = "";
    this.nickname = "";
    this.iLL = "";
    this.iLM = "";
    this.iLN = "";
    this.iLO = "";
    this.iLP = "";
    this.iLQ = "";
    this.iLR = "";
    this.iLS = "";
    this.huz = "";
    this.huA = "";
    this.huB = 0;
    this.huC = 0;
    AppMethodBeat.o(131159);
  }
  
  public final String Tn()
  {
    if (this.nickname == null) {
      return "";
    }
    return this.nickname;
  }
  
  public final ContentValues aPY()
  {
    AppMethodBeat.i(131161);
    ContentValues localContentValues = new ContentValues();
    if ((this.drx & 0x1) != 0) {
      localContentValues.put("qq", Long.valueOf(this.iLI));
    }
    int i;
    if ((this.drx & 0x2) != 0)
    {
      i = this.iLJ;
      if (i == 0) {
        localContentValues.put("wexinstatus", Integer.valueOf(65536));
      }
    }
    else
    {
      if ((this.drx & 0x4) != 0) {
        localContentValues.put("groupid", Integer.valueOf(this.iLK));
      }
      if ((this.drx & 0x8) != 0) {
        localContentValues.put("username", getUsername());
      }
      if ((this.drx & 0x10) != 0) {
        localContentValues.put("nickname", Tn());
      }
      if ((this.drx & 0x20) != 0)
      {
        if (this.iLL != null) {
          break label400;
        }
        str = "";
        label146:
        localContentValues.put("pyinitial", str);
      }
      if ((this.drx & 0x40) != 0)
      {
        if (this.iLM != null) {
          break label408;
        }
        str = "";
        label173:
        localContentValues.put("quanpin", str);
      }
      if ((this.drx & 0x80) != 0) {
        localContentValues.put("qqnickname", aPZ());
      }
      if ((this.drx & 0x100) != 0) {
        localContentValues.put("qqpyinitial", aQa());
      }
      if ((this.drx & 0x200) != 0) {
        localContentValues.put("qqquanpin", aQb());
      }
      if ((this.drx & 0x400) != 0) {
        localContentValues.put("qqremark", aQc());
      }
      if ((this.drx & 0x800) != 0) {
        localContentValues.put("qqremarkpyinitial", aQd());
      }
      if ((this.drx & 0x1000) != 0) {
        localContentValues.put("qqremarkquanpin", aQe());
      }
      if ((this.drx & 0x4000) != 0) {
        if (this.huA != null) {
          break label416;
        }
      }
    }
    label400:
    label408:
    label416:
    for (String str = "";; str = this.huA)
    {
      localContentValues.put("reserved2", str);
      if ((this.drx & 0x8000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.huB));
      }
      if ((this.drx & 0x10000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.huC));
      }
      AppMethodBeat.o(131161);
      return localContentValues;
      localContentValues.put("wexinstatus", Integer.valueOf(i));
      break;
      str = this.iLL;
      break label146;
      str = this.iLM;
      break label173;
    }
  }
  
  public final String aPZ()
  {
    if (this.iLN == null) {
      return "";
    }
    return this.iLN;
  }
  
  public final String aQa()
  {
    if (this.iLO == null) {
      return "";
    }
    return this.iLO;
  }
  
  public final String aQb()
  {
    if (this.iLP == null) {
      return "";
    }
    return this.iLP;
  }
  
  public final String aQc()
  {
    if (this.iLQ == null) {
      return "";
    }
    return this.iLQ;
  }
  
  public final String aQd()
  {
    if (this.iLR == null) {
      return "";
    }
    return this.iLR;
  }
  
  public final String aQe()
  {
    if (this.iLS == null) {
      return "";
    }
    return this.iLS;
  }
  
  public final void aQf()
  {
    this.huB |= 0x1;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131160);
    this.iLI = paramCursor.getLong(0);
    int i = paramCursor.getInt(1);
    if (i == 65536) {}
    for (this.iLJ = 0;; this.iLJ = i)
    {
      this.iLK = paramCursor.getInt(2);
      this.username = paramCursor.getString(3);
      this.nickname = paramCursor.getString(4);
      this.iLL = paramCursor.getString(5);
      this.iLM = paramCursor.getString(6);
      this.iLN = paramCursor.getString(7);
      this.iLO = paramCursor.getString(8);
      this.iLP = paramCursor.getString(9);
      this.iLQ = paramCursor.getString(10);
      this.iLR = paramCursor.getString(11);
      this.iLS = paramCursor.getString(12);
      this.huz = paramCursor.getString(13);
      this.huA = paramCursor.getString(14);
      this.huB = paramCursor.getInt(15);
      this.huC = paramCursor.getInt(16);
      AppMethodBeat.o(131160);
      return;
    }
  }
  
  public final String getDisplayName()
  {
    AppMethodBeat.i(131162);
    if ((aQc() == null) || (aQc().length() <= 0))
    {
      str = aPZ();
      AppMethodBeat.o(131162);
      return str;
    }
    String str = aQc();
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
    ((StringBuilder)localObject).append("groupID\t:").append(this.iLK).append("\n");
    ((StringBuilder)localObject).append("qq\t:").append(this.iLI).append("\n");
    ((StringBuilder)localObject).append("username\t:").append(this.username).append("\n");
    ((StringBuilder)localObject).append("nickname\t:").append(this.nickname).append("\n");
    ((StringBuilder)localObject).append("wexinStatus\t:").append(this.iLJ).append("\n");
    ((StringBuilder)localObject).append("reserved3\t:").append(this.huB).append("\n");
    ((StringBuilder)localObject).append("reserved4\t:").append(this.huC).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(131163);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.as
 * JD-Core Version:    0.7.0.1
 */