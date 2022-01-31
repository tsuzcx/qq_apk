package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ao
{
  int bsY;
  String fsf;
  String fsg;
  public int fsh;
  public int fsi;
  public long gyE;
  public int gyF;
  int gyG;
  String gyH;
  String gyI;
  String gyJ;
  String gyK;
  String gyL;
  public String gyM;
  String gyN;
  String gyO;
  public String nickname;
  public String username;
  
  public ao()
  {
    AppMethodBeat.i(108498);
    this.bsY = -1;
    this.gyE = 0L;
    this.gyF = 0;
    this.gyG = 0;
    this.username = "";
    this.nickname = "";
    this.gyH = "";
    this.gyI = "";
    this.gyJ = "";
    this.gyK = "";
    this.gyL = "";
    this.gyM = "";
    this.gyN = "";
    this.gyO = "";
    this.fsf = "";
    this.fsg = "";
    this.fsh = 0;
    this.fsi = 0;
    AppMethodBeat.o(108498);
  }
  
  public final String Hs()
  {
    if (this.nickname == null) {
      return "";
    }
    return this.nickname;
  }
  
  public final ContentValues aqL()
  {
    AppMethodBeat.i(108500);
    ContentValues localContentValues = new ContentValues();
    if ((this.bsY & 0x1) != 0) {
      localContentValues.put("qq", Long.valueOf(this.gyE));
    }
    int i;
    if ((this.bsY & 0x2) != 0)
    {
      i = this.gyF;
      if (i == 0) {
        localContentValues.put("wexinstatus", Integer.valueOf(65536));
      }
    }
    else
    {
      if ((this.bsY & 0x4) != 0) {
        localContentValues.put("groupid", Integer.valueOf(this.gyG));
      }
      if ((this.bsY & 0x8) != 0) {
        localContentValues.put("username", getUsername());
      }
      if ((this.bsY & 0x10) != 0) {
        localContentValues.put("nickname", Hs());
      }
      if ((this.bsY & 0x20) != 0)
      {
        if (this.gyH != null) {
          break label400;
        }
        str = "";
        label146:
        localContentValues.put("pyinitial", str);
      }
      if ((this.bsY & 0x40) != 0)
      {
        if (this.gyI != null) {
          break label408;
        }
        str = "";
        label173:
        localContentValues.put("quanpin", str);
      }
      if ((this.bsY & 0x80) != 0) {
        localContentValues.put("qqnickname", aqM());
      }
      if ((this.bsY & 0x100) != 0) {
        localContentValues.put("qqpyinitial", aqN());
      }
      if ((this.bsY & 0x200) != 0) {
        localContentValues.put("qqquanpin", aqO());
      }
      if ((this.bsY & 0x400) != 0) {
        localContentValues.put("qqremark", aqP());
      }
      if ((this.bsY & 0x800) != 0) {
        localContentValues.put("qqremarkpyinitial", aqQ());
      }
      if ((this.bsY & 0x1000) != 0) {
        localContentValues.put("qqremarkquanpin", aqR());
      }
      if ((this.bsY & 0x4000) != 0) {
        if (this.fsg != null) {
          break label416;
        }
      }
    }
    label400:
    label408:
    label416:
    for (String str = "";; str = this.fsg)
    {
      localContentValues.put("reserved2", str);
      if ((this.bsY & 0x8000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.fsh));
      }
      if ((this.bsY & 0x10000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.fsi));
      }
      AppMethodBeat.o(108500);
      return localContentValues;
      localContentValues.put("wexinstatus", Integer.valueOf(i));
      break;
      str = this.gyH;
      break label146;
      str = this.gyI;
      break label173;
    }
  }
  
  public final String aqM()
  {
    if (this.gyJ == null) {
      return "";
    }
    return this.gyJ;
  }
  
  public final String aqN()
  {
    if (this.gyK == null) {
      return "";
    }
    return this.gyK;
  }
  
  public final String aqO()
  {
    if (this.gyL == null) {
      return "";
    }
    return this.gyL;
  }
  
  public final String aqP()
  {
    if (this.gyM == null) {
      return "";
    }
    return this.gyM;
  }
  
  public final String aqQ()
  {
    if (this.gyN == null) {
      return "";
    }
    return this.gyN;
  }
  
  public final String aqR()
  {
    if (this.gyO == null) {
      return "";
    }
    return this.gyO;
  }
  
  public final void aqS()
  {
    this.fsh |= 0x1;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(108499);
    this.gyE = paramCursor.getLong(0);
    int i = paramCursor.getInt(1);
    if (i == 65536) {}
    for (this.gyF = 0;; this.gyF = i)
    {
      this.gyG = paramCursor.getInt(2);
      this.username = paramCursor.getString(3);
      this.nickname = paramCursor.getString(4);
      this.gyH = paramCursor.getString(5);
      this.gyI = paramCursor.getString(6);
      this.gyJ = paramCursor.getString(7);
      this.gyK = paramCursor.getString(8);
      this.gyL = paramCursor.getString(9);
      this.gyM = paramCursor.getString(10);
      this.gyN = paramCursor.getString(11);
      this.gyO = paramCursor.getString(12);
      this.fsf = paramCursor.getString(13);
      this.fsg = paramCursor.getString(14);
      this.fsh = paramCursor.getInt(15);
      this.fsi = paramCursor.getInt(16);
      AppMethodBeat.o(108499);
      return;
    }
  }
  
  public final String getDisplayName()
  {
    AppMethodBeat.i(108501);
    if ((aqP() == null) || (aqP().length() <= 0))
    {
      str = aqM();
      AppMethodBeat.o(108501);
      return str;
    }
    String str = aqP();
    AppMethodBeat.o(108501);
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
    AppMethodBeat.i(108502);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("groupID\t:").append(this.gyG).append("\n");
    ((StringBuilder)localObject).append("qq\t:").append(this.gyE).append("\n");
    ((StringBuilder)localObject).append("username\t:").append(this.username).append("\n");
    ((StringBuilder)localObject).append("nickname\t:").append(this.nickname).append("\n");
    ((StringBuilder)localObject).append("wexinStatus\t:").append(this.gyF).append("\n");
    ((StringBuilder)localObject).append("reserved3\t:").append(this.fsh).append("\n");
    ((StringBuilder)localObject).append("reserved4\t:").append(this.fsi).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(108502);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ao
 * JD-Core Version:    0.7.0.1
 */