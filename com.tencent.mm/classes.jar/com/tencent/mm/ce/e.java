package com.tencent.mm.ce;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class e
{
  private static e NKR = null;
  private final String IFy;
  private String[] NKS;
  private String[] NKT;
  private final List<SmileyPanelConfigInfo> NKU;
  private SparseArray<SmileyPanelConfigInfo> NKV;
  private String country;
  private String dFG;
  private final String gVw;
  private final String versionName;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(104920);
    StringBuilder localStringBuilder = new StringBuilder();
    a locala = a.hdT;
    this.gVw = (a.awv() + "panel/");
    this.IFy = "assets:///panel/";
    this.versionName = "config.conf";
    this.dFG = "";
    this.NKU = Collections.synchronizedList(new ArrayList());
    this.NKV = new SparseArray();
    this.NKS = paramContext.getResources().getStringArray(2130903069);
    this.NKT = paramContext.getResources().getStringArray(2130903071);
    this.NKU.clear();
    this.NKV.clear();
    gxP();
    this.country = LocaleUtil.getApplicationLanguage();
    if (!MMApplicationContext.isMainProcess()) {
      gxQ();
    }
    AppMethodBeat.o(104920);
  }
  
  public static Drawable bid(String paramString)
  {
    AppMethodBeat.i(177037);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177037);
      return null;
    }
    SmileyInfo localSmileyInfo = f.gxT().bii(paramString);
    if (localSmileyInfo != null)
    {
      paramString = f.gxT().a(localSmileyInfo);
      AppMethodBeat.o(177037);
      return paramString;
    }
    paramString = b.gxI().bic(paramString);
    paramString = b.gxI().a(paramString, true);
    AppMethodBeat.o(177037);
    return paramString;
  }
  
  private void gxP()
  {
    int k = 0;
    AppMethodBeat.i(104921);
    if ((this.NKS != null) && (this.NKT != null))
    {
      int m = this.NKS.length;
      int j = 0;
      int i = 0;
      SmileyPanelConfigInfo localSmileyPanelConfigInfo;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.NKS[j]);
        this.NKU.add(localSmileyPanelConfigInfo);
        this.NKV.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
      m = this.NKT.length;
      j = k;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.NKT[j]);
        this.NKU.add(localSmileyPanelConfigInfo);
        this.NKV.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
    }
    AppMethodBeat.o(104921);
  }
  
  public static e gxR()
  {
    AppMethodBeat.i(104925);
    if (NKR == null) {}
    try
    {
      NKR = new e(MMApplicationContext.getContext());
      e locale = NKR;
      AppMethodBeat.o(104925);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(104925);
    }
  }
  
  public Drawable Al(int paramInt)
  {
    AppMethodBeat.i(104926);
    if (this.NKV == null)
    {
      Log.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
      AppMethodBeat.o(104926);
      return null;
    }
    Object localObject = (SmileyPanelConfigInfo)this.NKV.get(paramInt);
    if (localObject == null)
    {
      Log.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
      AppMethodBeat.o(104926);
      return null;
    }
    localObject = bid(((SmileyPanelConfigInfo)localObject).field_key);
    AppMethodBeat.o(104926);
    return localObject;
  }
  
  public String Am(int paramInt)
  {
    AppMethodBeat.i(104929);
    if (paramInt < 0)
    {
      Log.w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
      AppMethodBeat.o(104929);
      return "";
    }
    Object localObject2 = gxR().NKT[paramInt].split(" ");
    Object localObject1 = Character.toChars(Integer.decode(localObject2[0]).intValue());
    localObject2 = Character.toChars(Integer.decode(localObject2[1]).intValue());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((char[])localObject1);
    localStringBuilder.append((char[])localObject2);
    localObject1 = localStringBuilder.toString();
    AppMethodBeat.o(104929);
    return localObject1;
  }
  
  public String An(int paramInt)
  {
    AppMethodBeat.i(104928);
    List localList = this.NKU;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt >= this.NKU.size())
      {
        Log.w("MicroMsg.MergerSmileyManager", "get text key, error index");
        return "";
      }
      Object localObject1 = (SmileyPanelConfigInfo)this.NKU.get(paramInt);
      if (localObject1 != null)
      {
        localObject1 = ((SmileyPanelConfigInfo)localObject1).field_key;
        return localObject1;
      }
      return "";
    }
    finally
    {
      AppMethodBeat.o(104928);
    }
  }
  
  public final String bie(String paramString)
  {
    AppMethodBeat.i(177038);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177038);
      return "";
    }
    SmileyInfo localSmileyInfo = f.gxT().bii(paramString);
    if (localSmileyInfo != null)
    {
      if ((this.country.equals("zh_CN")) && (!Util.isNullOrNil(localSmileyInfo.field_cnValue)))
      {
        paramString = localSmileyInfo.field_cnValue;
        AppMethodBeat.o(177038);
        return paramString;
      }
      if (((this.country.equals("zh_TW")) || (this.country.equals("zh_HK"))) && (!Util.isNullOrNil(localSmileyInfo.field_twValue)))
      {
        paramString = localSmileyInfo.field_twValue;
        AppMethodBeat.o(177038);
        return paramString;
      }
      paramString = localSmileyInfo.field_enValue;
      AppMethodBeat.o(177038);
      return paramString;
    }
    AppMethodBeat.o(177038);
    return paramString;
  }
  
  public int cbZ()
  {
    AppMethodBeat.i(104923);
    Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo");
    this.NKU.clear();
    this.dFG = ((d)g.ah(d.class)).getProvider().cFN();
    new ArrayList();
    Object localObject2 = new ArrayList();
    int i = com.tencent.mm.emoji.e.b.EY(this.gVw + "config.conf");
    int j = com.tencent.mm.emoji.e.b.EY("assets:///panel/config.conf");
    Object localObject4 = this.gVw + this.dFG;
    Object localObject3 = "assets:///panel/" + this.dFG;
    Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: local:%s, asset:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    Object localObject1 = localObject2;
    if (i > 0)
    {
      localObject1 = localObject2;
      if (i >= j)
      {
        localObject1 = localObject2;
        if (s.YS((String)localObject4))
        {
          localObject1 = com.tencent.mm.emoji.e.b.e(new o((String)localObject4));
          Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: localSize %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
        }
      }
    }
    if (((ArrayList)localObject1).size() <= 0)
    {
      localObject1 = com.tencent.mm.emoji.e.b.e(new o((String)localObject3));
      if (((ArrayList)localObject1).size() < 50) {
        Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: from asset xml %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
      }
    }
    label528:
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: %s", new Object[] { s.boY("assets:///panel/" + this.dFG) });
        if (!((ArrayList)localObject1).isEmpty())
        {
          localObject3 = f.gxT().gxY();
          int k = ((ArrayList)localObject1).size();
          j = 0;
          i = 0;
          if (j < k)
          {
            localObject4 = (SmileyPanelConfigInfo)((ArrayList)localObject1).get(j);
            localObject2 = ((SmileyPanelConfigInfo)localObject4).field_key;
            if (!((String)localObject2).matches("^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$")) {
              break label528;
            }
            localObject2 = new String(Base64.decode((String)localObject2, 0));
            ((SmileyPanelConfigInfo)localObject4).field_key = ((String)localObject2);
            if ((((String)localObject2).startsWith("[")) && (!((ArrayList)localObject3).contains(localObject2)))
            {
              Log.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", new Object[] { localObject2 });
              j += 1;
              continue;
            }
          }
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MergerSmileyManager", localException, "", new Object[0]);
        continue;
        this.NKU.add(localObject4);
        this.NKV.put(i, localObject4);
        i += 1;
        continue;
        i = 0;
        AppMethodBeat.o(104923);
        return i;
      }
      gxP();
      Log.i("MicroMsg.MergerSmileyManager", "smiley panel list is null.");
      i = -1;
      continue;
    }
  }
  
  public int cca()
  {
    AppMethodBeat.i(104924);
    if (this.NKU == null)
    {
      AppMethodBeat.o(104924);
      return 0;
    }
    int i = this.NKU.size();
    AppMethodBeat.o(104924);
    return i;
  }
  
  public final boolean containsKey(String paramString)
  {
    AppMethodBeat.i(177036);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177036);
      return false;
    }
    synchronized (this.NKU)
    {
      Iterator localIterator = this.NKU.iterator();
      while (localIterator.hasNext()) {
        if (Util.isEqual(((SmileyPanelConfigInfo)localIterator.next()).field_key, paramString))
        {
          AppMethodBeat.o(177036);
          return true;
        }
      }
      AppMethodBeat.o(177036);
      return false;
    }
  }
  
  public final boolean gxQ()
  {
    AppMethodBeat.i(104922);
    Log.i("MicroMsg.MergerSmileyManager", "checkNewSmiley ");
    ArrayList localArrayList = ((PluginEmoji)g.ah(PluginEmoji.class)).getProvider().cFK();
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      cbZ();
      AppMethodBeat.o(104922);
      return true;
    }
    cbZ();
    AppMethodBeat.o(104922);
    return false;
  }
  
  public final List<SmileyPanelConfigInfo> gxS()
  {
    AppMethodBeat.i(177035);
    synchronized (this.NKU)
    {
      ArrayList localArrayList = new ArrayList(this.NKU);
      AppMethodBeat.o(177035);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ce.e
 * JD-Core Version:    0.7.0.1
 */