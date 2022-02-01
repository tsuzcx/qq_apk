package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;
import org.json.JSONObject;

public final class bw
{
  public int cUP;
  private String groupId;
  public String lpK;
  public String lpM;
  public String lvm;
  public String lvn;
  public String lvo;
  public long lvp;
  public int lvq;
  public int lvr;
  public long lvs;
  public String lvt;
  public String lvu;
  private boolean lvv;
  private int lvw;
  private int lvx;
  public String name;
  public String sourceIcon;
  public String sourceName;
  private int subType;
  public long time;
  public String title;
  public int type;
  public String url;
  
  public bw()
  {
    AppMethodBeat.i(91028);
    this.lvv = false;
    this.lvw = 0;
    this.subType = 0;
    this.lvx = 0;
    this.groupId = "";
    this.cUP = -1;
    this.lvm = "";
    this.time = 0L;
    this.type = 0;
    this.name = "";
    this.title = "";
    this.url = "";
    this.lvn = "";
    this.lvo = "";
    this.lvp = 0L;
    this.sourceName = "";
    this.sourceIcon = "";
    this.lvq = 0;
    this.lpK = "";
    this.lpM = "";
    this.lvr = 0;
    this.lvs = 0L;
    this.lvt = "";
    this.lvu = "";
    AppMethodBeat.o(91028);
  }
  
  private void bfl()
  {
    AppMethodBeat.i(91036);
    if ((this.lvv) || (Util.isNullOrNil(this.lvu)))
    {
      AppMethodBeat.o(91036);
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.lvu);
        this.lvw = localJSONObject.optInt("videoLength", 0);
        int i = localJSONObject.optInt("subType", 0);
        if (i != 1) {
          continue;
        }
        this.subType = i;
        this.groupId = localJSONObject.optString("groupId", "");
        this.lvx = localJSONObject.optInt("tweetType", 0);
      }
      catch (Exception localException)
      {
        continue;
      }
      this.lvv = true;
      AppMethodBeat.o(91036);
      return;
      this.subType = 0;
    }
  }
  
  public static String va(int paramInt)
  {
    AppMethodBeat.i(91030);
    if (paramInt == 20)
    {
      AppMethodBeat.o(91030);
      return "newsapp";
    }
    if (paramInt == 11)
    {
      AppMethodBeat.o(91030);
      return "blogapp";
    }
    Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
    AppMethodBeat.o(91030);
    return null;
  }
  
  public final String aCt()
  {
    AppMethodBeat.i(91034);
    bfl();
    String str = this.groupId;
    AppMethodBeat.o(91034);
    return str;
  }
  
  public final String bfc()
  {
    if (this.lvm == null) {
      return "";
    }
    return this.lvm;
  }
  
  public final String bfd()
  {
    if (this.lvn == null) {
      return "";
    }
    return this.lvn;
  }
  
  public final String bfe()
  {
    if (this.sourceName == null) {
      return "";
    }
    return this.sourceName;
  }
  
  public final String bff()
  {
    if (this.sourceIcon == null) {
      return "";
    }
    return this.sourceIcon;
  }
  
  public final String bfg()
  {
    AppMethodBeat.i(91031);
    if (this.lpK != null)
    {
      Object localObject = this.lpK.split("\\|");
      if ((localObject != null) && (localObject.length > 0))
      {
        localObject = localObject[0];
        AppMethodBeat.o(91031);
        return localObject;
      }
      AppMethodBeat.o(91031);
      return "";
    }
    AppMethodBeat.o(91031);
    return "";
  }
  
  public final String bfh()
  {
    if (this.lvu == null) {
      return "";
    }
    return this.lvu;
  }
  
  public final int bfi()
  {
    AppMethodBeat.i(91032);
    bfl();
    int i = this.subType;
    AppMethodBeat.o(91032);
    return i;
  }
  
  public final int bfj()
  {
    AppMethodBeat.i(91033);
    bfl();
    int i = this.lvw;
    AppMethodBeat.o(91033);
    return i;
  }
  
  public final int bfk()
  {
    AppMethodBeat.i(91035);
    bfl();
    int i = this.lvx;
    AppMethodBeat.o(91035);
    return i;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(91029);
    this.lvm = paramCursor.getString(0);
    this.time = paramCursor.getLong(1);
    this.type = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.title = paramCursor.getString(4);
    this.url = paramCursor.getString(5);
    this.lvn = paramCursor.getString(6);
    this.lvo = paramCursor.getString(7);
    this.lvp = paramCursor.getLong(8);
    this.sourceName = paramCursor.getString(9);
    this.sourceIcon = paramCursor.getString(10);
    this.lvq = paramCursor.getInt(11);
    this.lpK = paramCursor.getString(12);
    this.lpM = paramCursor.getString(13);
    this.lvr = paramCursor.getInt(14);
    this.lvs = paramCursor.getLong(15);
    this.lvt = paramCursor.getString(16);
    this.lvu = paramCursor.getString(17);
    AppMethodBeat.o(91029);
  }
  
  public final String getDigest()
  {
    if (this.lpM == null) {
      return "";
    }
    return this.lpM;
  }
  
  public final String getName()
  {
    if (this.name == null) {
      return "";
    }
    return this.name;
  }
  
  public final String getTitle()
  {
    if (this.title == null) {
      return "";
    }
    return this.title;
  }
  
  public final String getUrl()
  {
    if (this.url == null) {
      return "";
    }
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.bw
 * JD-Core Version:    0.7.0.1
 */