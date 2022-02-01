package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.ipcall.model.h.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
  private static c JFO;
  private ArrayList<Integer> JFP;
  ArrayList<Integer> JFQ;
  boolean isInit;
  
  private c()
  {
    AppMethodBeat.i(25338);
    this.JFP = new ArrayList();
    this.JFQ = new ArrayList();
    this.isInit = false;
    AppMethodBeat.o(25338);
  }
  
  private void aIS(String paramString)
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
      this.JFQ.clear();
      int i = 0;
      while (i < paramString.length())
      {
        int j = paramString.getInt(i);
        this.JFQ.add(Integer.valueOf(j));
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
  
  public static c fRb()
  {
    AppMethodBeat.i(25339);
    if (JFO == null) {
      JFO = new c();
    }
    c localc = JFO;
    AppMethodBeat.o(25339);
    return localc;
  }
  
  private void fRc()
  {
    AppMethodBeat.i(25342);
    this.JFP.clear();
    Object localObject = i.aRC().getValue("WeChatOutTopCountryCode");
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
          this.JFP.add(localInteger);
          h.fRy().aG(localInteger.intValue(), j);
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
  
  private void fRd()
  {
    AppMethodBeat.i(25343);
    ArrayList localArrayList = h.fRy().fRY();
    if (localArrayList.size() > 0)
    {
      this.JFP = localArrayList;
      AppMethodBeat.o(25343);
      return;
    }
    fRc();
    AppMethodBeat.o(25343);
  }
  
  public final boolean Zb(int paramInt)
  {
    AppMethodBeat.i(25346);
    if (!this.isInit) {
      xA(false);
    }
    if ((this.JFQ == null) || (this.JFQ.size() <= 0))
    {
      AppMethodBeat.o(25346);
      return false;
    }
    boolean bool = this.JFQ.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(25346);
    return bool;
  }
  
  public final void aIT(String paramString)
  {
    AppMethodBeat.i(25344);
    if (!this.isInit) {
      xA(false);
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25344);
      return;
    }
    paramString = paramString.replace("+", "");
    h.fRy().aG(Util.getInt(paramString, 0), Util.nowMilliSecond());
    fRd();
    AppMethodBeat.o(25344);
  }
  
  public final List<Integer> fRe()
  {
    AppMethodBeat.i(25345);
    if (!this.isInit) {
      xA(false);
    }
    ArrayList localArrayList = this.JFP;
    AppMethodBeat.o(25345);
    return localArrayList;
  }
  
  public final void xA(boolean paramBoolean)
  {
    String str = null;
    InputStream localInputStream2 = null;
    AppMethodBeat.i(25340);
    if ((this.isInit) && (!paramBoolean))
    {
      AppMethodBeat.o(25340);
      return;
    }
    fRd();
    Object localObject3 = b.bmr() + "ipcallCountryCodeConfig.cfg";
    InputStream localInputStream1 = localInputStream2;
    Object localObject1 = str;
    try
    {
      Object localObject4 = new u((String)localObject3);
      localInputStream1 = localInputStream2;
      localObject1 = str;
      if (!((u)localObject4).jKS())
      {
        localInputStream1 = localInputStream2;
        localObject1 = str;
        Log.d("MicroMsg.IPCallCountryCodeConfig", "initConfig, file: %s not exist!", new Object[] { localObject3 });
        localInputStream1 = localInputStream2;
        localObject1 = str;
        this.isInit = true;
        ah.closeQuietly(null);
        AppMethodBeat.o(25340);
        return;
      }
      localInputStream1 = localInputStream2;
      localObject1 = str;
      localInputStream2 = y.ao((u)localObject4);
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
      aIS(str);
      localInputStream1 = localInputStream2;
      localObject1 = localInputStream2;
      this.isInit = true;
      ah.closeQuietly(localInputStream2);
      AppMethodBeat.o(25340);
      return;
    }
    catch (Exception localException)
    {
      localObject1 = localInputStream1;
      Log.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", localException, "", new Object[0]);
      localObject1 = localInputStream1;
      Log.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", new Object[] { localException.getMessage() });
      ah.closeQuietly(localInputStream1);
      AppMethodBeat.o(25340);
      return;
    }
    finally
    {
      ah.closeQuietly((Closeable)localObject1);
      AppMethodBeat.o(25340);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c
 * JD-Core Version:    0.7.0.1
 */