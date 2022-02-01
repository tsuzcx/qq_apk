package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import junit.framework.Assert;
import org.json.JSONObject;

public final class br
{
  public int dEu;
  private String groupId;
  public String hGe;
  public String hGg;
  public String hKA;
  public String hKB;
  public int hKC;
  public int hKD;
  public long hKE;
  public String hKF;
  public String hKG;
  private boolean hKH;
  private int hKI;
  private int hKJ;
  public String hKw;
  public String hKx;
  public String hKy;
  public long hKz;
  public String name;
  private int subType;
  public long time;
  public String title;
  public int type;
  public String url;
  
  public br()
  {
    AppMethodBeat.i(91028);
    this.hKH = false;
    this.hKI = 0;
    this.subType = 0;
    this.hKJ = 0;
    this.groupId = "";
    this.dEu = -1;
    this.hKw = "";
    this.time = 0L;
    this.type = 0;
    this.name = "";
    this.title = "";
    this.url = "";
    this.hKx = "";
    this.hKy = "";
    this.hKz = 0L;
    this.hKA = "";
    this.hKB = "";
    this.hKC = 0;
    this.hGe = "";
    this.hGg = "";
    this.hKD = 0;
    this.hKE = 0L;
    this.hKF = "";
    this.hKG = "";
    AppMethodBeat.o(91028);
  }
  
  private void aCK()
  {
    AppMethodBeat.i(91036);
    if ((this.hKH) || (bu.isNullOrNil(this.hKG)))
    {
      AppMethodBeat.o(91036);
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.hKG);
        this.hKI = localJSONObject.optInt("videoLength", 0);
        int i = localJSONObject.optInt("subType", 0);
        if (i != 1) {
          continue;
        }
        this.subType = i;
        this.groupId = localJSONObject.optString("groupId", "");
        this.hKJ = localJSONObject.optInt("tweetType", 0);
      }
      catch (Exception localException)
      {
        continue;
      }
      this.hKH = true;
      AppMethodBeat.o(91036);
      return;
      this.subType = 0;
    }
  }
  
  public static String oC(int paramInt)
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
  
  public final String aCB()
  {
    if (this.hKw == null) {
      return "";
    }
    return this.hKw;
  }
  
  public final String aCC()
  {
    if (this.hKx == null) {
      return "";
    }
    return this.hKx;
  }
  
  public final String aCD()
  {
    if (this.hKA == null) {
      return "";
    }
    return this.hKA;
  }
  
  public final String aCE()
  {
    if (this.hKB == null) {
      return "";
    }
    return this.hKB;
  }
  
  public final String aCF()
  {
    AppMethodBeat.i(91031);
    if (this.hGe != null)
    {
      Object localObject = this.hGe.split("\\|");
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
  
  public final String aCG()
  {
    if (this.hKG == null) {
      return "";
    }
    return this.hKG;
  }
  
  public final int aCH()
  {
    AppMethodBeat.i(91032);
    aCK();
    int i = this.subType;
    AppMethodBeat.o(91032);
    return i;
  }
  
  public final int aCI()
  {
    AppMethodBeat.i(91033);
    aCK();
    int i = this.hKI;
    AppMethodBeat.o(91033);
    return i;
  }
  
  public final int aCJ()
  {
    AppMethodBeat.i(91035);
    aCK();
    int i = this.hKJ;
    AppMethodBeat.o(91035);
    return i;
  }
  
  public final String afK()
  {
    AppMethodBeat.i(91034);
    aCK();
    String str = this.groupId;
    AppMethodBeat.o(91034);
    return str;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(91029);
    this.hKw = paramCursor.getString(0);
    this.time = paramCursor.getLong(1);
    this.type = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.title = paramCursor.getString(4);
    this.url = paramCursor.getString(5);
    this.hKx = paramCursor.getString(6);
    this.hKy = paramCursor.getString(7);
    this.hKz = paramCursor.getLong(8);
    this.hKA = paramCursor.getString(9);
    this.hKB = paramCursor.getString(10);
    this.hKC = paramCursor.getInt(11);
    this.hGe = paramCursor.getString(12);
    this.hGg = paramCursor.getString(13);
    this.hKD = paramCursor.getInt(14);
    this.hKE = paramCursor.getLong(15);
    this.hKF = paramCursor.getString(16);
    this.hKG = paramCursor.getString(17);
    AppMethodBeat.o(91029);
  }
  
  public final String getDigest()
  {
    if (this.hGg == null) {
      return "";
    }
    return this.hGg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.br
 * JD-Core Version:    0.7.0.1
 */