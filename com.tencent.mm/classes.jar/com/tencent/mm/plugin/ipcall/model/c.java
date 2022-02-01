package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.ipcall.model.h.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static c uKj;
  boolean cAX;
  private ArrayList<Integer> uKk;
  ArrayList<Integer> uKl;
  
  private c()
  {
    AppMethodBeat.i(25338);
    this.uKk = new ArrayList();
    this.uKl = new ArrayList();
    this.cAX = false;
    AppMethodBeat.o(25338);
  }
  
  private void anv(String paramString)
  {
    AppMethodBeat.i(25341);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25341);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("restriction");
      ad.d("MicroMsg.IPCallCountryCodeConfig", "restrictionCountryCode: %d", new Object[] { Integer.valueOf(paramString.length()) });
      this.uKl.clear();
      int i = 0;
      while (i < paramString.length())
      {
        int j = paramString.getInt(i);
        this.uKl.add(Integer.valueOf(j));
        i += 1;
      }
      AppMethodBeat.o(25341);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", paramString, "", new Object[0]);
      ad.e("MicroMsg.IPCallCountryCodeConfig", "initConfigFromContent error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(25341);
    }
  }
  
  public static c ddr()
  {
    AppMethodBeat.i(25339);
    if (uKj == null) {
      uKj = new c();
    }
    c localc = uKj;
    AppMethodBeat.o(25339);
    return localc;
  }
  
  private void dds()
  {
    AppMethodBeat.i(25342);
    this.uKk.clear();
    Object localObject = g.acA().getValue("WeChatOutTopCountryCode");
    ad.d("MicroMsg.IPCallCountryCodeConfig", "popularCountryConfig: %s", new Object[] { localObject });
    if (!bt.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).trim().split(",");
      int j = localObject.length;
      try
      {
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          Integer localInteger = Integer.valueOf(bt.getInt(localObject[i], 0));
          this.uKk.add(localInteger);
          i.ddO().al(localInteger.intValue(), j);
          j -= 1;
          i += 1;
        }
        AppMethodBeat.o(25342);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ad.e("MicroMsg.IPCallCountryCodeConfig", "initPopularCountryFromDynamicConfig error: %s", new Object[] { localNumberFormatException.getMessage() });
      }
    }
    AppMethodBeat.o(25342);
  }
  
  private void ddt()
  {
    AppMethodBeat.i(25343);
    ArrayList localArrayList = i.ddO().deo();
    if (localArrayList.size() > 0)
    {
      this.uKk = localArrayList;
      AppMethodBeat.o(25343);
      return;
    }
    dds();
    AppMethodBeat.o(25343);
  }
  
  public final boolean Ix(int paramInt)
  {
    AppMethodBeat.i(25346);
    if (!this.cAX) {
      nA(false);
    }
    if ((this.uKl == null) || (this.uKl.size() <= 0))
    {
      AppMethodBeat.o(25346);
      return false;
    }
    boolean bool = this.uKl.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(25346);
    return bool;
  }
  
  public final void anw(String paramString)
  {
    AppMethodBeat.i(25344);
    if (!this.cAX) {
      nA(false);
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25344);
      return;
    }
    paramString = paramString.replace("+", "");
    i.ddO().al(bt.getInt(paramString, 0), bt.flT());
    ddt();
    AppMethodBeat.o(25344);
  }
  
  public final List<Integer> ddu()
  {
    AppMethodBeat.i(25345);
    if (!this.cAX) {
      nA(false);
    }
    ArrayList localArrayList = this.uKk;
    AppMethodBeat.o(25345);
    return localArrayList;
  }
  
  public final void nA(boolean paramBoolean)
  {
    String str = null;
    InputStream localInputStream2 = null;
    AppMethodBeat.i(25340);
    if ((this.cAX) && (!paramBoolean))
    {
      AppMethodBeat.o(25340);
      return;
    }
    ddt();
    Object localObject3 = b.arM() + "ipcallCountryCodeConfig.cfg";
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
        ad.d("MicroMsg.IPCallCountryCodeConfig", "initConfig, file: %s not exist!", new Object[] { localObject3 });
        localInputStream1 = localInputStream2;
        localObject1 = str;
        this.cAX = true;
        q.closeQuietly(null);
        AppMethodBeat.o(25340);
        return;
      }
      localInputStream1 = localInputStream2;
      localObject1 = str;
      localInputStream2 = com.tencent.mm.vfs.i.ai((com.tencent.mm.vfs.e)localObject4);
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
      ad.d("MicroMsg.IPCallCountryCodeConfig", "config file content: %s", new Object[] { str });
      localInputStream1 = localInputStream2;
      localObject1 = localInputStream2;
      anv(str);
      localInputStream1 = localInputStream2;
      localObject1 = localInputStream2;
      this.cAX = true;
      q.closeQuietly(localInputStream2);
      AppMethodBeat.o(25340);
      return;
    }
    catch (Exception localException)
    {
      localObject1 = localInputStream1;
      ad.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", localException, "", new Object[0]);
      localObject1 = localInputStream1;
      ad.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", new Object[] { localException.getMessage() });
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