package com.tencent.mm.bi;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  public static ArrayList<String> C(int paramInt, String paramString)
  {
    AppMethodBeat.i(16616);
    ArrayList localArrayList = new ArrayList();
    paramString = d.alh().eE(paramString, 10);
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (localObject.field_type == 1) {
          localArrayList.add(bo.nullAsNil(bi.d.asm(localObject.field_msgContent).content));
        }
        i += 1;
      }
    }
    ab.d("MicroMsg.ExposeDataLogic", "getFMessageContent,scene:%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(16616);
    return localArrayList;
  }
  
  public static ArrayList<String> uQ(String paramString)
  {
    AppMethodBeat.i(16613);
    ArrayList localArrayList = new ArrayList();
    paramString = d.alj().eF(paramString, 10);
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
    ab.d("MicroMsg.ExposeDataLogic", "get lbs sayhi msg content");
    AppMethodBeat.o(16613);
    return localArrayList;
  }
  
  public static ArrayList<String> uR(String paramString)
  {
    AppMethodBeat.i(16614);
    ArrayList localArrayList = new ArrayList();
    paramString = d.alk().eH(paramString, 10);
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
    ab.d("MicroMsg.ExposeDataLogic", "get shake sayhi msg content");
    AppMethodBeat.o(16614);
    return localArrayList;
  }
  
  public static ArrayList<String> uS(String paramString)
  {
    AppMethodBeat.i(16615);
    ArrayList localArrayList = new ArrayList();
    aw.aaz();
    paramString = c.YC().Tu(paramString);
    int i;
    if ((paramString != null) && (paramString.getCount() != 0)) {
      if (paramString.moveToFirst())
      {
        i = 0;
        if (!paramString.isAfterLast())
        {
          bi localbi = new bi();
          localbi.convertFrom(paramString);
          paramString.moveToNext();
          if (!localbi.isText()) {
            break label127;
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
      AppMethodBeat.o(16615);
      return localArrayList;
      label127:
      localArrayList.add("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bi.a
 * JD-Core Version:    0.7.0.1
 */