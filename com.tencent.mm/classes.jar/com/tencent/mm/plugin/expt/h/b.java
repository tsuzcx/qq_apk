package com.tencent.mm.plugin.expt.h;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class b
{
  private static b wrj;
  private String wrh = null;
  private String wri = null;
  
  private int azj(String paramString)
  {
    AppMethodBeat.i(261608);
    try
    {
      int i = dgI().getInt(paramString, 0);
      AppMethodBeat.o(261608);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(261608);
    }
    return 0;
  }
  
  public static b dgG()
  {
    AppMethodBeat.i(261583);
    if (wrj == null) {
      wrj = new b();
    }
    b localb = wrj;
    AppMethodBeat.o(261583);
    return localb;
  }
  
  private String info()
  {
    AppMethodBeat.i(261610);
    String str = hashCode();
    AppMethodBeat.o(261610);
    return str;
  }
  
  public final a Lk(int paramInt)
  {
    AppMethodBeat.i(261600);
    Object localObject = dgH();
    if (localObject == null)
    {
      AppMethodBeat.o(261600);
      return null;
    }
    localObject = ((MultiProcessMMKV)localObject).getString(String.valueOf(paramInt), "");
    if (!Util.isNullOrNil((String)localObject))
    {
      a locala = new a();
      if (locala.abx((String)localObject))
      {
        AppMethodBeat.o(261600);
        return locala;
      }
    }
    AppMethodBeat.o(261600);
    return null;
  }
  
  public final int a(String paramString1, String paramString2, PString paramPString)
  {
    AppMethodBeat.i(261603);
    int i = azj(paramString1);
    a locala;
    if (i > 0)
    {
      locala = Lk(i);
      if ((locala != null) && (locala.isReady()))
      {
        HashMap localHashMap = locala.dgD();
        if ((localHashMap != null) && (!localHashMap.isEmpty()))
        {
          paramPString.value = ((String)localHashMap.get(paramString1));
          if (Util.isNullOrNil(paramPString.value)) {}
        }
      }
    }
    for (i = locala.wrb;; i = 0)
    {
      if (i <= 0) {
        paramPString.value = paramString2;
      }
      AppMethodBeat.o(261603);
      return i;
    }
  }
  
  public final MultiProcessMMKV dgH()
  {
    AppMethodBeat.i(261587);
    d.dgX();
    int i = d.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(261587);
      return null;
    }
    Object localObject = i + "_WxExptAppIdMmkv";
    if (!Util.isEqual(this.wrh, (String)localObject))
    {
      Log.i("MicroMsg.ExptAppManager", "%s get exptId mmkv change uin old[%s] new[%s]", new Object[] { info(), this.wrh, localObject });
      this.wrh = ((String)localObject);
    }
    localObject = MultiProcessMMKV.getMMKV(this.wrh);
    AppMethodBeat.o(261587);
    return localObject;
  }
  
  public MultiProcessMMKV dgI()
  {
    AppMethodBeat.i(261591);
    d.dgX();
    int i = d.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(261591);
      return null;
    }
    Object localObject = i + "_WxExptAppKeyMmkv";
    if (!Util.isEqual(this.wri, (String)localObject))
    {
      Log.i("MicroMsg.ExptAppManager", "%s get exptKey mmkv change uin old[%s] new[%s]", new Object[] { info(), this.wri, localObject });
      this.wri = ((String)localObject);
    }
    localObject = MultiProcessMMKV.getMMKV(this.wri);
    AppMethodBeat.o(261591);
    return localObject;
  }
  
  public final boolean dgJ()
  {
    AppMethodBeat.i(261593);
    try
    {
      dgH().clear().commit();
      dgI().clear().commit();
      label31:
      AppMethodBeat.o(261593);
      return true;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  public final List<a> dgK()
  {
    AppMethodBeat.i(261596);
    ArrayList localArrayList = new ArrayList();
    MultiProcessMMKV localMultiProcessMMKV = dgH();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(261596);
      return localArrayList;
    }
    String[] arrayOfString = localMultiProcessMMKV.allKeys();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = localMultiProcessMMKV.getString(arrayOfString[i], "");
        if (!Util.isNullOrNil(str))
        {
          a locala = new a();
          if (locala.abx(str)) {
            localArrayList.add(locala);
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(261596);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.h.b
 * JD-Core Version:    0.7.0.1
 */