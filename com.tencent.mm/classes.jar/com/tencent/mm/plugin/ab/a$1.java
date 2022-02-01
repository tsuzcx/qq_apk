package com.tencent.mm.plugin.ab;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;

final class a$1
  implements com.tencent.mm.plugin.ab.a.a
{
  a$1(a parama) {}
  
  public final Cursor G(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(151504);
    j localj = a.fmz();
    String str = "select * from AppInfo where ";
    int i = 0;
    while (i <= 0)
    {
      str = str + " status = " + paramArrayOfInt[0];
      i += 1;
    }
    paramArrayOfInt = localj.rawQuery(str + " order by status desc, modifyTime asc", new String[0]);
    if (paramArrayOfInt == null)
    {
      Log.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
      AppMethodBeat.o(151504);
      return null;
    }
    AppMethodBeat.o(151504);
    return paramArrayOfInt;
  }
  
  public final Bitmap a(String paramString, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(151505);
    a.fmz();
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
      AppMethodBeat.o(151505);
      return null;
    }
    if (paramString.equals("wx7fa037cc7dfabad5"))
    {
      paramString = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), c.d.app_icon);
      AppMethodBeat.o(151505);
      return paramString;
    }
    paramString = j.ho(paramString, paramInt);
    if (!u.agG(paramString))
    {
      Log.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + paramString + ", iconType = " + paramInt);
      AppMethodBeat.o(151505);
      return null;
    }
    paramString = BackwardSupportUtil.BitmapFactory.decodeFile(paramString, paramFloat);
    AppMethodBeat.o(151505);
    return paramString;
  }
  
  public final g aTS(String paramString)
  {
    AppMethodBeat.i(151501);
    if (!h.aHB())
    {
      AppMethodBeat.o(151501);
      return null;
    }
    paramString = a.fmz().bqc(paramString);
    AppMethodBeat.o(151501);
    return paramString;
  }
  
  public final g aTT(String paramString)
  {
    AppMethodBeat.i(151502);
    a.fmy();
    paramString = i.bqb(paramString);
    AppMethodBeat.o(151502);
    return paramString;
  }
  
  public final String aTU(String paramString)
  {
    AppMethodBeat.i(215216);
    a.fmz();
    paramString = j.ho(paramString, 1);
    AppMethodBeat.o(215216);
    return paramString;
  }
  
  public final void aTV(String paramString)
  {
    AppMethodBeat.i(151507);
    a.fmy().bqa(paramString);
    AppMethodBeat.o(151507);
  }
  
  public final void bA(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151512);
    a.fmy().ce(paramLinkedList);
    AppMethodBeat.o(151512);
  }
  
  public final void e(g paramg)
  {
    AppMethodBeat.i(151508);
    j localj = a.fmz();
    if ((paramg != null) && (paramg.field_status != 5))
    {
      paramg.field_status = 3;
      Log.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", new Object[] { paramg.field_packageName });
      localj.a(paramg, new String[0]);
    }
    AppMethodBeat.o(151508);
  }
  
  public final void f(g paramg)
  {
    AppMethodBeat.i(151509);
    j localj = a.fmz();
    if ((paramg == null) || (paramg.field_status != 3))
    {
      AppMethodBeat.o(151509);
      return;
    }
    paramg.field_status = 4;
    localj.a(paramg, new String[0]);
    AppMethodBeat.o(151509);
  }
  
  public final void fA(String paramString, int paramInt)
  {
    AppMethodBeat.i(151506);
    a.fmx().hm(paramString, paramInt);
    AppMethodBeat.o(151506);
  }
  
  public final Cursor fmD()
  {
    AppMethodBeat.i(151503);
    Cursor localCursor = a.fmz().rawQuery("select * from AppInfo where status = 5 order by modifyTime asc", new String[0]);
    if (localCursor == null)
    {
      Log.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
      AppMethodBeat.o(151503);
      return null;
    }
    AppMethodBeat.o(151503);
    return localCursor;
  }
  
  public final j fmE()
  {
    AppMethodBeat.i(292905);
    j localj = a.fmz();
    AppMethodBeat.o(292905);
    return localj;
  }
  
  public final Cursor fmF()
  {
    AppMethodBeat.i(151514);
    Object localObject = a.fmz();
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("select * from AppInfo");
    localStringBuilder.append(" where ");
    localStringBuilder.append("serviceAppType > 0");
    localObject = ((j)localObject).rawQuery(localStringBuilder.toString(), new String[0]);
    if (localObject == null)
    {
      Log.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
      AppMethodBeat.o(151514);
      return null;
    }
    Log.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
    AppMethodBeat.o(151514);
    return localObject;
  }
  
  public final void g(g paramg)
  {
    AppMethodBeat.i(151510);
    a.fmz().a(paramg, new String[0]);
    AppMethodBeat.o(151510);
  }
  
  public final Cursor iL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151513);
    Cursor localCursor = a.fmz().iL(paramInt1, paramInt2);
    AppMethodBeat.o(151513);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ab.a.1
 * JD-Core Version:    0.7.0.1
 */