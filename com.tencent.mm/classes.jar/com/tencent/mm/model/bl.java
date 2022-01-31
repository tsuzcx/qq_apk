package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class bl
{
  public int bsY;
  public String fjJ;
  public String fjL;
  public String fnl;
  public String fnm;
  public String fnn;
  public long fno;
  public String fnp;
  public String fnq;
  public int fnr;
  public int fns;
  public long fnt;
  public String fnu;
  public String fnv;
  public String name;
  public long time;
  public String title;
  public int type;
  public String url;
  
  public bl()
  {
    AppMethodBeat.i(108667);
    this.bsY = -1;
    this.fnl = "";
    this.time = 0L;
    this.type = 0;
    this.name = "";
    this.title = "";
    this.url = "";
    this.fnm = "";
    this.fnn = "";
    this.fno = 0L;
    this.fnp = "";
    this.fnq = "";
    this.fnr = 0;
    this.fjJ = "";
    this.fjL = "";
    this.fns = 0;
    this.fnt = 0L;
    this.fnu = "";
    this.fnv = "";
    AppMethodBeat.o(108667);
  }
  
  public static String kF(int paramInt)
  {
    AppMethodBeat.i(108669);
    if (paramInt == 20)
    {
      AppMethodBeat.o(108669);
      return "newsapp";
    }
    if (paramInt == 11)
    {
      AppMethodBeat.o(108669);
      return "blogapp";
    }
    Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
    AppMethodBeat.o(108669);
    return null;
  }
  
  public final boolean aaU()
  {
    return this.fns == 1;
  }
  
  public final String aaV()
  {
    if (this.fnl == null) {
      return "";
    }
    return this.fnl;
  }
  
  public final String aaW()
  {
    if (this.fnm == null) {
      return "";
    }
    return this.fnm;
  }
  
  public final String aaX()
  {
    if (this.fnp == null) {
      return "";
    }
    return this.fnp;
  }
  
  public final String aaY()
  {
    if (this.fnq == null) {
      return "";
    }
    return this.fnq;
  }
  
  public final String aaZ()
  {
    AppMethodBeat.i(108670);
    if (this.fjJ != null)
    {
      Object localObject = this.fjJ.split("\\|");
      if ((localObject != null) && (localObject.length > 0))
      {
        localObject = localObject[0];
        AppMethodBeat.o(108670);
        return localObject;
      }
      AppMethodBeat.o(108670);
      return "";
    }
    AppMethodBeat.o(108670);
    return "";
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(108668);
    this.fnl = paramCursor.getString(0);
    this.time = paramCursor.getLong(1);
    this.type = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.title = paramCursor.getString(4);
    this.url = paramCursor.getString(5);
    this.fnm = paramCursor.getString(6);
    this.fnn = paramCursor.getString(7);
    this.fno = paramCursor.getLong(8);
    this.fnp = paramCursor.getString(9);
    this.fnq = paramCursor.getString(10);
    this.fnr = paramCursor.getInt(11);
    this.fjJ = paramCursor.getString(12);
    this.fjL = paramCursor.getString(13);
    this.fns = paramCursor.getInt(14);
    this.fnt = paramCursor.getLong(15);
    this.fnu = paramCursor.getString(16);
    this.fnv = paramCursor.getString(17);
    AppMethodBeat.o(108668);
  }
  
  public final String getDigest()
  {
    if (this.fjL == null) {
      return "";
    }
    return this.fjL;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.bl
 * JD-Core Version:    0.7.0.1
 */