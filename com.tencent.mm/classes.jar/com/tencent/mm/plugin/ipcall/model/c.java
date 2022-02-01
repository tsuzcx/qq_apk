package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.ipcall.model.h.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
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
  private static c uVW;
  boolean cBE;
  private ArrayList<Integer> uVX;
  ArrayList<Integer> uVY;
  
  private c()
  {
    AppMethodBeat.i(25338);
    this.uVX = new ArrayList();
    this.uVY = new ArrayList();
    this.cBE = false;
    AppMethodBeat.o(25338);
  }
  
  private void aox(String paramString)
  {
    AppMethodBeat.i(25341);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25341);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("restriction");
      ae.d("MicroMsg.IPCallCountryCodeConfig", "restrictionCountryCode: %d", new Object[] { Integer.valueOf(paramString.length()) });
      this.uVY.clear();
      int i = 0;
      while (i < paramString.length())
      {
        int j = paramString.getInt(i);
        this.uVY.add(Integer.valueOf(j));
        i += 1;
      }
      AppMethodBeat.o(25341);
      return;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", paramString, "", new Object[0]);
      ae.e("MicroMsg.IPCallCountryCodeConfig", "initConfigFromContent error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(25341);
    }
  }
  
  public static c dgj()
  {
    AppMethodBeat.i(25339);
    if (uVW == null) {
      uVW = new c();
    }
    c localc = uVW;
    AppMethodBeat.o(25339);
    return localc;
  }
  
  private void dgk()
  {
    AppMethodBeat.i(25342);
    this.uVX.clear();
    Object localObject = g.acL().getValue("WeChatOutTopCountryCode");
    ae.d("MicroMsg.IPCallCountryCodeConfig", "popularCountryConfig: %s", new Object[] { localObject });
    if (!bu.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).trim().split(",");
      int j = localObject.length;
      try
      {
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          Integer localInteger = Integer.valueOf(bu.getInt(localObject[i], 0));
          this.uVX.add(localInteger);
          i.dgG().al(localInteger.intValue(), j);
          j -= 1;
          i += 1;
        }
        AppMethodBeat.o(25342);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ae.e("MicroMsg.IPCallCountryCodeConfig", "initPopularCountryFromDynamicConfig error: %s", new Object[] { localNumberFormatException.getMessage() });
      }
    }
    AppMethodBeat.o(25342);
  }
  
  private void dgl()
  {
    AppMethodBeat.i(25343);
    ArrayList localArrayList = i.dgG().dhg();
    if (localArrayList.size() > 0)
    {
      this.uVX = localArrayList;
      AppMethodBeat.o(25343);
      return;
    }
    dgk();
    AppMethodBeat.o(25343);
  }
  
  public final boolean IV(int paramInt)
  {
    AppMethodBeat.i(25346);
    if (!this.cBE) {
      nE(false);
    }
    if ((this.uVY == null) || (this.uVY.size() <= 0))
    {
      AppMethodBeat.o(25346);
      return false;
    }
    boolean bool = this.uVY.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(25346);
    return bool;
  }
  
  public final void aoy(String paramString)
  {
    AppMethodBeat.i(25344);
    if (!this.cBE) {
      nE(false);
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25344);
      return;
    }
    paramString = paramString.replace("+", "");
    i.dgG().al(bu.getInt(paramString, 0), bu.fpO());
    dgl();
    AppMethodBeat.o(25344);
  }
  
  public final List<Integer> dgm()
  {
    AppMethodBeat.i(25345);
    if (!this.cBE) {
      nE(false);
    }
    ArrayList localArrayList = this.uVX;
    AppMethodBeat.o(25345);
    return localArrayList;
  }
  
  public final void nE(boolean paramBoolean)
  {
    String str = null;
    InputStream localInputStream2 = null;
    AppMethodBeat.i(25340);
    if ((this.cBE) && (!paramBoolean))
    {
      AppMethodBeat.o(25340);
      return;
    }
    dgl();
    Object localObject3 = b.asb() + "ipcallCountryCodeConfig.cfg";
    InputStream localInputStream1 = localInputStream2;
    Object localObject1 = str;
    try
    {
      Object localObject4 = new k((String)localObject3);
      localInputStream1 = localInputStream2;
      localObject1 = str;
      if (!((k)localObject4).exists())
      {
        localInputStream1 = localInputStream2;
        localObject1 = str;
        ae.d("MicroMsg.IPCallCountryCodeConfig", "initConfig, file: %s not exist!", new Object[] { localObject3 });
        localInputStream1 = localInputStream2;
        localObject1 = str;
        this.cBE = true;
        w.closeQuietly(null);
        AppMethodBeat.o(25340);
        return;
      }
      localInputStream1 = localInputStream2;
      localObject1 = str;
      localInputStream2 = o.ai((k)localObject4);
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
      ae.d("MicroMsg.IPCallCountryCodeConfig", "config file content: %s", new Object[] { str });
      localInputStream1 = localInputStream2;
      localObject1 = localInputStream2;
      aox(str);
      localInputStream1 = localInputStream2;
      localObject1 = localInputStream2;
      this.cBE = true;
      w.closeQuietly(localInputStream2);
      AppMethodBeat.o(25340);
      return;
    }
    catch (Exception localException)
    {
      localObject1 = localInputStream1;
      ae.printErrStackTrace("MicroMsg.IPCallCountryCodeConfig", localException, "", new Object[0]);
      localObject1 = localInputStream1;
      ae.e("MicroMsg.IPCallCountryCodeConfig", "initConfig error: %s", new Object[] { localException.getMessage() });
      w.closeQuietly(localInputStream1);
      AppMethodBeat.o(25340);
      return;
    }
    finally
    {
      w.closeQuietly((Closeable)localObject1);
      AppMethodBeat.o(25340);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c
 * JD-Core Version:    0.7.0.1
 */