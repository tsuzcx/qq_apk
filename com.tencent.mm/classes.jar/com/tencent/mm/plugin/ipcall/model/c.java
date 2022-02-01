package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.ipcall.model.h.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private static c yox;
  boolean isInit;
  private ArrayList<Integer> yoy;
  ArrayList<Integer> yoz;
  
  private c()
  {
    AppMethodBeat.i(25338);
    this.yoy = new ArrayList();
    this.yoz = new ArrayList();
    this.isInit = false;
    AppMethodBeat.o(25338);
  }
  
  private void aBR(String paramString)
  {
    AppMethodBeat.i(25341);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25341);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("restriction");
      Log.d("MicroMsg.IPCallCountryCodeConfig", "restrictionCountryCode: %d", new Object[] { Integer.valueOf(paramString.length()) });
      this.yoz.clear();
      int i = 0;
      while (i < paramString.length())
      {
        int j = paramString.getInt(i);
        this.yoz.add(Integer.valueOf(j));
        i += 1;
      }
      AppMethodBeat.o(25341);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", paramString, "", new Object[0]);
      Log.e("MicroMsg.IPCallCountryCodeConfig", "initConfigFromContent error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(25341);
    }
  }
  
  public static c ead()
  {
    AppMethodBeat.i(25339);
    if (yox == null) {
      yox = new c();
    }
    c localc = yox;
    AppMethodBeat.o(25339);
    return localc;
  }
  
  private void eae()
  {
    AppMethodBeat.i(25342);
    this.yoy.clear();
    Object localObject = h.aqJ().getValue("WeChatOutTopCountryCode");
    Log.d("MicroMsg.IPCallCountryCodeConfig", "popularCountryConfig: %s", new Object[] { localObject });
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).trim().split(",");
      int j = localObject.length;
      try
      {
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          Integer localInteger = Integer.valueOf(Util.getInt(localObject[i], 0));
          this.yoy.add(localInteger);
          i.eaA().ar(localInteger.intValue(), j);
          j -= 1;
          i += 1;
        }
        AppMethodBeat.o(25342);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.e("MicroMsg.IPCallCountryCodeConfig", "initPopularCountryFromDynamicConfig error: %s", new Object[] { localNumberFormatException.getMessage() });
      }
    }
    AppMethodBeat.o(25342);
  }
  
  private void eaf()
  {
    AppMethodBeat.i(25343);
    ArrayList localArrayList = i.eaA().eba();
    if (localArrayList.size() > 0)
    {
      this.yoy = localArrayList;
      AppMethodBeat.o(25343);
      return;
    }
    eae();
    AppMethodBeat.o(25343);
  }
  
  public final boolean OY(int paramInt)
  {
    AppMethodBeat.i(25346);
    if (!this.isInit) {
      qn(false);
    }
    if ((this.yoz == null) || (this.yoz.size() <= 0))
    {
      AppMethodBeat.o(25346);
      return false;
    }
    boolean bool = this.yoz.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(25346);
    return bool;
  }
  
  public final void aBS(String paramString)
  {
    AppMethodBeat.i(25344);
    if (!this.isInit) {
      qn(false);
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25344);
      return;
    }
    paramString = paramString.replace("+", "");
    i.eaA().ar(Util.getInt(paramString, 0), Util.nowMilliSecond());
    eaf();
    AppMethodBeat.o(25344);
  }
  
  public final List<Integer> eag()
  {
    AppMethodBeat.i(25345);
    if (!this.isInit) {
      qn(false);
    }
    ArrayList localArrayList = this.yoy;
    AppMethodBeat.o(25345);
    return localArrayList;
  }
  
  public final void qn(boolean paramBoolean)
  {
    String str = null;
    InputStream localInputStream2 = null;
    AppMethodBeat.i(25340);
    if ((this.isInit) && (!paramBoolean))
    {
      AppMethodBeat.o(25340);
      return;
    }
    eaf();
    Object localObject3 = b.aKB() + "ipcallCountryCodeConfig.cfg";
    InputStream localInputStream1 = localInputStream2;
    Object localObject1 = str;
    try
    {
      Object localObject4 = new o((String)localObject3);
      localInputStream1 = localInputStream2;
      localObject1 = str;
      if (!((o)localObject4).exists())
      {
        localInputStream1 = localInputStream2;
        localObject1 = str;
        Log.d("MicroMsg.IPCallCountryCodeConfig", "initConfig, file: %s not exist!", new Object[] { localObject3 });
        localInputStream1 = localInputStream2;
        localObject1 = str;
        this.isInit = true;
        aa.closeQuietly(null);
        AppMethodBeat.o(25340);
        return;
      }
      localInputStream1 = localInputStream2;
      localObject1 = str;
      localInputStream2 = s.ao((o)localObject4);
      localInputStream1 = localInputStream2;
      localObject1 = localInputStream2;
      localObject3 = new BufferedReader(new InputStreamReader(localInputStream2));
      for (str = "";; str = str + (String)localObject4)
      {
        localInputStream1 = localInputStream2;
        localObject1 = localInputStream2;
        localObject4 = ((BufferedReader)localObject3).readLine();
        if (localObject4 == null) {
          break;
        }
        localInputStream1 = localInputStream2;
        localObject1 = localInputStream2;
      }
      localInputStream1 = localInputStream2;
      localObject1 = localInputStream2;
      Log.d("MicroMsg.IPCallCountryCodeConfig", "config file content: %s", new Object[] { str });
      localInputStream1 = localInputStream2;
      localObject1 = localInputStream2;
      aBR(str);
      localInputStream1 = localInputStream2;
      localObject1 = localInputStream2;
      this.isInit = true;
      aa.closeQuietly(localInputStream2);
      AppMethodBeat.o(25340);
      return;
    }
    catch (Exception localException)
    {
      localObject1 = localInputStream1;
      Log.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", localException, "", new Object[0]);
      localObject1 = localInputStream1;
      Log.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", new Object[] { localException.getMessage() });
      aa.closeQuietly(localInputStream1);
      AppMethodBeat.o(25340);
      return;
    }
    finally
    {
      aa.closeQuietly((Closeable)localObject1);
      AppMethodBeat.o(25340);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c
 * JD-Core Version:    0.7.0.1
 */