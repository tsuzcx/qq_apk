package com.tencent.mm.bj;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.d;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import java.util.ArrayList;

public final class a
{
  public static ArrayList<String> DH(String paramString)
  {
    AppMethodBeat.i(20657);
    ArrayList localArrayList = new ArrayList();
    paramString = d.aJf().fS(paramString, 10);
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
    ac.d("MicroMsg.ExposeDataLogic", "get lbs sayhi msg content");
    AppMethodBeat.o(20657);
    return localArrayList;
  }
  
  public static ArrayList<String> DI(String paramString)
  {
    AppMethodBeat.i(20658);
    ArrayList localArrayList = new ArrayList();
    paramString = d.aJg().fU(paramString, 10);
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
    ac.d("MicroMsg.ExposeDataLogic", "get shake sayhi msg content");
    AppMethodBeat.o(20658);
    return localArrayList;
  }
  
  public static ArrayList<String> DJ(String paramString)
  {
    AppMethodBeat.i(20659);
    ArrayList localArrayList = new ArrayList();
    az.ayM();
    paramString = c.awD().als(paramString);
    int i;
    if ((paramString != null) && (paramString.getCount() != 0)) {
      if (paramString.moveToFirst())
      {
        i = 0;
        if (!paramString.isAfterLast())
        {
          bo localbo = new bo();
          localbo.convertFrom(paramString);
          paramString.moveToNext();
          if (!localbo.isText()) {
            break label127;
          }
          localArrayList.add(localbo.field_content);
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
  
  public static ArrayList<String> L(int paramInt, String paramString)
  {
    AppMethodBeat.i(20660);
    ArrayList localArrayList = new ArrayList();
    paramString = d.aJd().fR(paramString, 10);
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (localObject.field_type == 1) {
          localArrayList.add(bs.nullAsNil(bo.d.aOn(localObject.field_msgContent).content));
        }
        i += 1;
      }
    }
    ac.d("MicroMsg.ExposeDataLogic", "getFMessageContent,scene:%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(20660);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bj.a
 * JD-Core Version:    0.7.0.1
 */