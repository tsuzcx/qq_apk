package com.tencent.mm.bh;

import android.database.Cursor;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;

public final class a
{
  public static ArrayList<bi> d(long[] paramArrayOfLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfLong != null)
    {
      int i = 0;
      while (i < paramArrayOfLong.length)
      {
        au.Hx();
        localArrayList.add(c.Fy().fd(paramArrayOfLong[i]));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<String> nC(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = d.RZ().dw(paramString, 10);
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramString[i].field_sayhicontent);
        i += 1;
      }
    }
    y.d("MicroMsg.ExposeDataLogic", "get lbs sayhi msg content");
    return localArrayList;
  }
  
  public static ArrayList<String> nD(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = d.Sa().dy(paramString, 10);
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramString[i].field_sayhicontent);
        i += 1;
      }
    }
    y.d("MicroMsg.ExposeDataLogic", "get shake sayhi msg content");
    return localArrayList;
  }
  
  public static ArrayList<String> nE(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    au.Hx();
    paramString = c.Fy().HJ(paramString);
    int i;
    if ((paramString != null) && (paramString.getCount() != 0)) {
      if (paramString.moveToFirst())
      {
        i = 0;
        if (!paramString.isAfterLast())
        {
          bi localbi = new bi();
          localbi.d(paramString);
          paramString.moveToNext();
          if (!localbi.isText()) {
            break label115;
          }
          localArrayList.add(localbi.field_content);
        }
      }
    }
    for (;;)
    {
      int j = i + 1;
      i = j;
      if (j != 10) {
        break;
      }
      paramString.close();
      return localArrayList;
      label115:
      localArrayList.add("");
    }
  }
  
  public static ArrayList<String> t(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = d.RX().dv(paramString, 10);
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (localObject.field_type == 1) {
          localArrayList.add(bk.pm(bi.d.acc(localObject.field_msgContent).content));
        }
        i += 1;
      }
    }
    y.d("MicroMsg.ExposeDataLogic", "getFMessageContent,scene:%d", new Object[] { Integer.valueOf(paramInt) });
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bh.a
 * JD-Core Version:    0.7.0.1
 */