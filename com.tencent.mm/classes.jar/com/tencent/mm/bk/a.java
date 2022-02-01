package com.tencent.mm.bk;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.d;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;

public final class a
{
  public static ArrayList<String> K(int paramInt, String paramString)
  {
    AppMethodBeat.i(20660);
    ArrayList localArrayList = new ArrayList();
    paramString = d.aCn().fN(paramString, 10);
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (localObject.field_type == 1) {
          localArrayList.add(bt.nullAsNil(bl.d.aIR(localObject.field_msgContent).content));
        }
        i += 1;
      }
    }
    ad.d("MicroMsg.ExposeDataLogic", "getFMessageContent,scene:%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(20660);
    return localArrayList;
  }
  
  public static ArrayList<String> zC(String paramString)
  {
    AppMethodBeat.i(20657);
    ArrayList localArrayList = new ArrayList();
    paramString = d.aCp().fO(paramString, 10);
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
    ad.d("MicroMsg.ExposeDataLogic", "get lbs sayhi msg content");
    AppMethodBeat.o(20657);
    return localArrayList;
  }
  
  public static ArrayList<String> zD(String paramString)
  {
    AppMethodBeat.i(20658);
    ArrayList localArrayList = new ArrayList();
    paramString = d.aCq().fQ(paramString, 10);
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
    ad.d("MicroMsg.ExposeDataLogic", "get shake sayhi msg content");
    AppMethodBeat.o(20658);
    return localArrayList;
  }
  
  public static ArrayList<String> zE(String paramString)
  {
    AppMethodBeat.i(20659);
    ArrayList localArrayList = new ArrayList();
    az.arV();
    paramString = c.apO().agy(paramString);
    int i;
    if ((paramString != null) && (paramString.getCount() != 0)) {
      if (paramString.moveToFirst())
      {
        i = 0;
        if (!paramString.isAfterLast())
        {
          bl localbl = new bl();
          localbl.convertFrom(paramString);
          paramString.moveToNext();
          if (!localbl.isText()) {
            break label127;
          }
          localArrayList.add(localbl.field_content);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bk.a
 * JD-Core Version:    0.7.0.1
 */