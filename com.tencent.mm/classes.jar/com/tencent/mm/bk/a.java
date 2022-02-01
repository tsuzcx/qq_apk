package com.tencent.mm.bk;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.d;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;
import java.util.ArrayList;

public final class a
{
  public static ArrayList<String> GM(String paramString)
  {
    AppMethodBeat.i(20657);
    ArrayList localArrayList = new ArrayList();
    paramString = d.aMp().gp(paramString, 10);
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
  
  public static ArrayList<String> GN(String paramString)
  {
    AppMethodBeat.i(20658);
    ArrayList localArrayList = new ArrayList();
    paramString = d.aMq().gr(paramString, 10);
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
  
  public static ArrayList<String> GO(String paramString)
  {
    AppMethodBeat.i(20659);
    ArrayList localArrayList = new ArrayList();
    ba.aBQ();
    paramString = c.azs().aqg(paramString);
    int i;
    if ((paramString != null) && (paramString.getCount() != 0)) {
      if (paramString.moveToFirst())
      {
        i = 0;
        if (!paramString.isAfterLast())
        {
          bu localbu = new bu();
          localbu.convertFrom(paramString);
          paramString.moveToNext();
          if (!localbu.isText()) {
            break label127;
          }
          localArrayList.add(localbu.field_content);
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
  
  public static ArrayList<String> M(int paramInt, String paramString)
  {
    AppMethodBeat.i(20660);
    ArrayList localArrayList = new ArrayList();
    paramString = d.aMn().go(paramString, 10);
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (localObject.field_type == 1) {
          localArrayList.add(bt.nullAsNil(bu.d.aUe(localObject.field_msgContent).content));
        }
        i += 1;
      }
    }
    ad.d("MicroMsg.ExposeDataLogic", "getFMessageContent,scene:%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(20660);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bk.a
 * JD-Core Version:    0.7.0.1
 */