package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import junit.framework.Assert;
import org.json.JSONObject;

public final class bo
{
  public int dtM;
  public String gKD;
  public String gKF;
  public String gOM;
  public String gON;
  public String gOO;
  public long gOP;
  public String gOQ;
  public String gOR;
  public int gOS;
  public int gOT;
  public long gOU;
  public String gOV;
  public String gOW;
  private boolean gOX;
  private int gOY;
  private int gOZ;
  private String groupId;
  public String name;
  private int subType;
  public long time;
  public String title;
  public int type;
  public String url;
  
  public bo()
  {
    AppMethodBeat.i(91028);
    this.gOX = false;
    this.gOY = 0;
    this.subType = 0;
    this.gOZ = 0;
    this.groupId = "";
    this.dtM = -1;
    this.gOM = "";
    this.time = 0L;
    this.type = 0;
    this.name = "";
    this.title = "";
    this.url = "";
    this.gON = "";
    this.gOO = "";
    this.gOP = 0L;
    this.gOQ = "";
    this.gOR = "";
    this.gOS = 0;
    this.gKD = "";
    this.gKF = "";
    this.gOT = 0;
    this.gOU = 0L;
    this.gOV = "";
    this.gOW = "";
    AppMethodBeat.o(91028);
  }
  
  private void asA()
  {
    AppMethodBeat.i(91036);
    if ((this.gOX) || (bt.isNullOrNil(this.gOW)))
    {
      AppMethodBeat.o(91036);
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.gOW);
        this.gOY = localJSONObject.optInt("videoLength", 0);
        int i = localJSONObject.optInt("subType", 0);
        if (i != 1) {
          continue;
        }
        this.subType = i;
        this.groupId = localJSONObject.optString("groupId", "");
        this.gOZ = localJSONObject.optInt("tweetType", 0);
      }
      catch (Exception localException)
      {
        continue;
      }
      this.gOX = true;
      AppMethodBeat.o(91036);
      return;
      this.subType = 0;
    }
  }
  
  public static String nl(int paramInt)
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
  
  public final String asq()
  {
    if (this.gOM == null) {
      return "";
    }
    return this.gOM;
  }
  
  public final String asr()
  {
    if (this.gON == null) {
      return "";
    }
    return this.gON;
  }
  
  public final String ass()
  {
    if (this.gOQ == null) {
      return "";
    }
    return this.gOQ;
  }
  
  public final String ast()
  {
    if (this.gOR == null) {
      return "";
    }
    return this.gOR;
  }
  
  public final String asu()
  {
    AppMethodBeat.i(91031);
    if (this.gKD != null)
    {
      Object localObject = this.gKD.split("\\|");
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
  
  public final String asv()
  {
    if (this.gOW == null) {
      return "";
    }
    return this.gOW;
  }
  
  public final int asw()
  {
    AppMethodBeat.i(91032);
    asA();
    int i = this.subType;
    AppMethodBeat.o(91032);
    return i;
  }
  
  public final int asx()
  {
    AppMethodBeat.i(91033);
    asA();
    int i = this.gOY;
    AppMethodBeat.o(91033);
    return i;
  }
  
  public final String asy()
  {
    AppMethodBeat.i(91034);
    asA();
    String str = this.groupId;
    AppMethodBeat.o(91034);
    return str;
  }
  
  public final int asz()
  {
    AppMethodBeat.i(91035);
    asA();
    int i = this.gOZ;
    AppMethodBeat.o(91035);
    return i;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(91029);
    this.gOM = paramCursor.getString(0);
    this.time = paramCursor.getLong(1);
    this.type = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.title = paramCursor.getString(4);
    this.url = paramCursor.getString(5);
    this.gON = paramCursor.getString(6);
    this.gOO = paramCursor.getString(7);
    this.gOP = paramCursor.getLong(8);
    this.gOQ = paramCursor.getString(9);
    this.gOR = paramCursor.getString(10);
    this.gOS = paramCursor.getInt(11);
    this.gKD = paramCursor.getString(12);
    this.gKF = paramCursor.getString(13);
    this.gOT = paramCursor.getInt(14);
    this.gOU = paramCursor.getLong(15);
    this.gOV = paramCursor.getString(16);
    this.gOW = paramCursor.getString(17);
    AppMethodBeat.o(91029);
  }
  
  public final String getDigest()
  {
    if (this.gKF == null) {
      return "";
    }
    return this.gKF;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bo
 * JD-Core Version:    0.7.0.1
 */