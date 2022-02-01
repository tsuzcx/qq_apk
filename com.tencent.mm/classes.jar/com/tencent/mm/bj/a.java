package com.tencent.mm.bj;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cm;
import java.util.ArrayList;

public final class a
{
  public static ArrayList<String> P(int paramInt, String paramString)
  {
    AppMethodBeat.i(20660);
    ArrayList localArrayList = new ArrayList();
    paramString = d.bgM().gQ(paramString, 10);
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (localObject.field_type == 1) {
          localArrayList.add(Util.nullAsNil(ca.d.bkD(localObject.field_msgContent).content));
        }
        i += 1;
      }
    }
    Log.d("MicroMsg.ExposeDataLogic", "getFMessageContent,scene:%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(20660);
    return localArrayList;
  }
  
  public static ArrayList<String> Qb(String paramString)
  {
    AppMethodBeat.i(20657);
    ArrayList localArrayList = new ArrayList();
    paramString = d.bgO().gR(paramString, 10);
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
    Log.d("MicroMsg.ExposeDataLogic", "get lbs sayhi msg content");
    AppMethodBeat.o(20657);
    return localArrayList;
  }
  
  public static ArrayList<String> Qc(String paramString)
  {
    AppMethodBeat.i(20658);
    ArrayList localArrayList = new ArrayList();
    paramString = d.bgP().gT(paramString, 10);
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
    Log.d("MicroMsg.ExposeDataLogic", "get shake sayhi msg content");
    AppMethodBeat.o(20658);
    return localArrayList;
  }
  
  public static ArrayList<String> Qd(String paramString)
  {
    AppMethodBeat.i(20659);
    ArrayList localArrayList = new ArrayList();
    bg.aVF();
    paramString = c.aSQ().aEG(paramString);
    int i;
    if ((paramString != null) && (paramString.getCount() != 0)) {
      if (paramString.moveToFirst())
      {
        i = 0;
        if (!paramString.isAfterLast())
        {
          ca localca = new ca();
          localca.convertFrom(paramString);
          paramString.moveToNext();
          if (!localca.isText()) {
            break label127;
          }
          localArrayList.add(localca.field_content);
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
      AppMethodBeat.o(20659);
      return localArrayList;
      label127:
      localArrayList.add("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bj.a
 * JD-Core Version:    0.7.0.1
 */