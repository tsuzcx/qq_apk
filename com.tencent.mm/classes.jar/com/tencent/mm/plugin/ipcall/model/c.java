package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.ipcall.model.h.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.q;
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
  private static c tHw;
  boolean cqf;
  private ArrayList<Integer> tHx;
  ArrayList<Integer> tHy;
  
  private c()
  {
    AppMethodBeat.i(25338);
    this.tHx = new ArrayList();
    this.tHy = new ArrayList();
    this.cqf = false;
    AppMethodBeat.o(25338);
  }
  
  private void aiI(String paramString)
  {
    AppMethodBeat.i(25341);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25341);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("restriction");
      ac.d("MicroMsg.IPCallCountryCodeConfig", "restrictionCountryCode: %d", new Object[] { Integer.valueOf(paramString.length()) });
      this.tHy.clear();
      int i = 0;
      while (i < paramString.length())
      {
        int j = paramString.getInt(i);
        this.tHy.add(Integer.valueOf(j));
        i += 1;
      }
      AppMethodBeat.o(25341);
      return;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", paramString, "", new Object[0]);
      ac.e("MicroMsg.IPCallCountryCodeConfig", "initConfigFromContent error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(25341);
    }
  }
  
  public static c cUg()
  {
    AppMethodBeat.i(25339);
    if (tHw == null) {
      tHw = new c();
    }
    c localc = tHw;
    AppMethodBeat.o(25339);
    return localc;
  }
  
  private void cUh()
  {
    AppMethodBeat.i(25342);
    this.tHx.clear();
    Object localObject = g.ZY().getValue("WeChatOutTopCountryCode");
    ac.d("MicroMsg.IPCallCountryCodeConfig", "popularCountryConfig: %s", new Object[] { localObject });
    if (!bs.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).trim().split(",");
      int j = localObject.length;
      try
      {
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          Integer localInteger = Integer.valueOf(bs.getInt(localObject[i], 0));
          this.tHx.add(localInteger);
          i.cUD().ah(localInteger.intValue(), j);
          j -= 1;
          i += 1;
        }
        AppMethodBeat.o(25342);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ac.e("MicroMsg.IPCallCountryCodeConfig", "initPopularCountryFromDynamicConfig error: %s", new Object[] { localNumberFormatException.getMessage() });
      }
    }
    AppMethodBeat.o(25342);
  }
  
  private void cUi()
  {
    AppMethodBeat.i(25343);
    ArrayList localArrayList = i.cUD().cVd();
    if (localArrayList.size() > 0)
    {
      this.tHx = localArrayList;
      AppMethodBeat.o(25343);
      return;
    }
    cUh();
    AppMethodBeat.o(25343);
  }
  
  public final boolean Hb(int paramInt)
  {
    AppMethodBeat.i(25346);
    if (!this.cqf) {
      ng(false);
    }
    if ((this.tHy == null) || (this.tHy.size() <= 0))
    {
      AppMethodBeat.o(25346);
      return false;
    }
    boolean bool = this.tHy.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(25346);
    return bool;
  }
  
  public final void aiJ(String paramString)
  {
    AppMethodBeat.i(25344);
    if (!this.cqf) {
      ng(false);
    }
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25344);
      return;
    }
    paramString = paramString.replace("+", "");
    i.cUD().ah(bs.getInt(paramString, 0), bs.eWj());
    cUi();
    AppMethodBeat.o(25344);
  }
  
  public final List<Integer> cUj()
  {
    AppMethodBeat.i(25345);
    if (!this.cqf) {
      ng(false);
    }
    ArrayList localArrayList = this.tHx;
    AppMethodBeat.o(25345);
    return localArrayList;
  }
  
  public final void ng(boolean paramBoolean)
  {
    String str = null;
    InputStream localInputStream2 = null;
    AppMethodBeat.i(25340);
    if ((this.cqf) && (!paramBoolean))
    {
      AppMethodBeat.o(25340);
      return;
    }
    cUi();
    Object localObject3 = b.aoZ() + "ipcallCountryCodeConfig.cfg";
    InputStream localInputStream1 = localInputStream2;
    Object localObject1 = str;
    try
    {
      Object localObject4 = new com.tencent.mm.vfs.e((String)localObject3);
      localInputStream1 = localInputStream2;
      localObject1 = str;
      if (!((com.tencent.mm.vfs.e)localObject4).exists())
      {
        localInputStream1 = localInputStream2;
        localObject1 = str;
        ac.d("MicroMsg.IPCallCountryCodeConfig", "initConfig, file: %s not exist!", new Object[] { localObject3 });
        localInputStream1 = localInputStream2;
        localObject1 = str;
        this.cqf = true;
        q.closeQuietly(null);
        AppMethodBeat.o(25340);
        return;
      }
      localInputStream1 = localInputStream2;
      localObject1 = str;
      localInputStream2 = com.tencent.mm.vfs.i.ag((com.tencent.mm.vfs.e)localObject4);
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
      ac.d("MicroMsg.IPCallCountryCodeConfig", "config file content: %s", new Object[] { str });
      localInputStream1 = localInputStream2;
      localObject1 = localInputStream2;
      aiI(str);
      localInputStream1 = localInputStream2;
      localObject1 = localInputStream2;
      this.cqf = true;
      q.closeQuietly(localInputStream2);
      AppMethodBeat.o(25340);
      return;
    }
    catch (Exception localException)
    {
      localObject1 = localInputStream1;
      ac.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", localException, "", new Object[0]);
      localObject1 = localInputStream1;
      ac.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", new Object[] { localException.getMessage() });
      q.closeQuietly(localInputStream1);
      AppMethodBeat.o(25340);
      return;
    }
    finally
    {
      q.closeQuietly((Closeable)localObject1);
      AppMethodBeat.o(25340);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c
 * JD-Core Version:    0.7.0.1
 */