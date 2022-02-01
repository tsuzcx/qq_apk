package com.tencent.mm.cg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.tmassistantsdk.util.Base64;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class e
{
  private static e FaE = null;
  private String[] FaF;
  private String[] FaG;
  private String[] FaH;
  private final List<SmileyPanelConfigInfo> FaI;
  private SparseArray<SmileyPanelConfigInfo> FaJ;
  private String country;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(104920);
    this.FaI = Collections.synchronizedList(new ArrayList());
    this.FaJ = new SparseArray();
    this.FaF = paramContext.getResources().getStringArray(2130903068);
    this.FaG = paramContext.getResources().getStringArray(2130903069);
    this.FaH = paramContext.getResources().getStringArray(2130903070);
    this.FaI.clear();
    this.FaJ.clear();
    eHR();
    this.country = ac.eFu();
    if (!aj.cbe()) {
      eHS();
    }
    AppMethodBeat.o(104920);
  }
  
  public static Drawable aGN(String paramString)
  {
    AppMethodBeat.i(177037);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177037);
      return null;
    }
    SmileyInfo localSmileyInfo = f.eHV().aGS(paramString);
    if (localSmileyInfo != null)
    {
      paramString = f.eHV().a(localSmileyInfo);
      AppMethodBeat.o(177037);
      return paramString;
    }
    paramString = b.eHL().aGM(paramString);
    paramString = b.eHL().a(paramString, true);
    AppMethodBeat.o(177037);
    return paramString;
  }
  
  private void eHR()
  {
    int k = 0;
    AppMethodBeat.i(104921);
    if ((this.FaF != null) && (this.FaH != null))
    {
      int m = this.FaF.length;
      int j = 0;
      int i = 0;
      SmileyPanelConfigInfo localSmileyPanelConfigInfo;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.FaF[j]);
        this.FaI.add(localSmileyPanelConfigInfo);
        this.FaJ.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
      m = this.FaH.length;
      j = k;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.FaH[j]);
        this.FaI.add(localSmileyPanelConfigInfo);
        this.FaJ.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
    }
    AppMethodBeat.o(104921);
  }
  
  public static e eHT()
  {
    AppMethodBeat.i(104925);
    if (FaE == null) {}
    try
    {
      FaE = new e(aj.getContext());
      e locale = FaE;
      AppMethodBeat.o(104925);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(104925);
    }
  }
  
  public final String aGO(String paramString)
  {
    AppMethodBeat.i(177038);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177038);
      return "";
    }
    SmileyInfo localSmileyInfo = f.eHV().aGS(paramString);
    if (localSmileyInfo != null)
    {
      if ((this.country.equals("zh_CN")) && (!bt.isNullOrNil(localSmileyInfo.field_cnValue)))
      {
        paramString = localSmileyInfo.field_cnValue;
        AppMethodBeat.o(177038);
        return paramString;
      }
      if (((this.country.equals("zh_TW")) || (this.country.equals("zh_HK"))) && (!bt.isNullOrNil(localSmileyInfo.field_twValue)))
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
  
  public int btQ()
  {
    AppMethodBeat.i(104923);
    ad.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo " + bt.eGN());
    this.FaI.clear();
    ArrayList localArrayList1 = ((PluginEmoji)g.ad(PluginEmoji.class)).getProvider().bUF();
    if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
      localArrayList1 = com.tencent.mm.emoji.d.b.f(new com.tencent.mm.vfs.e("assets:///panel/".concat(String.valueOf(((d)g.ad(d.class)).getProvider().bUI()))));
    }
    for (;;)
    {
      ArrayList localArrayList2;
      int j;
      int i;
      SmileyPanelConfigInfo localSmileyPanelConfigInfo;
      String str;
      if ((localArrayList1 != null) && (!localArrayList1.isEmpty()))
      {
        localArrayList2 = f.eHV().eHZ();
        int k = localArrayList1.size();
        j = 0;
        i = 0;
        if (j < k)
        {
          localSmileyPanelConfigInfo = (SmileyPanelConfigInfo)localArrayList1.get(j);
          str = localSmileyPanelConfigInfo.field_key;
          if (!str.matches("^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$")) {
            break label293;
          }
          str = new String(Base64.decode(str, 0));
          localSmileyPanelConfigInfo.field_key = str;
        }
      }
      label293:
      for (;;)
      {
        if ((str.startsWith("[")) && (!localArrayList2.contains(str))) {
          ad.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", new Object[] { str });
        }
        for (;;)
        {
          j += 1;
          break;
          this.FaI.add(localSmileyPanelConfigInfo);
          this.FaJ.put(i, localSmileyPanelConfigInfo);
          i += 1;
        }
        for (i = 0;; i = -1)
        {
          AppMethodBeat.o(104923);
          return i;
          eHR();
          ad.i("MicroMsg.MergerSmileyManager", "smiley panel list is null.");
        }
      }
    }
  }
  
  public int btR()
  {
    AppMethodBeat.i(104924);
    if (this.FaI == null)
    {
      AppMethodBeat.o(104924);
      return 0;
    }
    int i = this.FaI.size();
    AppMethodBeat.o(104924);
    return i;
  }
  
  public final boolean containsKey(String paramString)
  {
    AppMethodBeat.i(177036);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177036);
      return false;
    }
    synchronized (this.FaI)
    {
      Iterator localIterator = this.FaI.iterator();
      while (localIterator.hasNext()) {
        if (bt.kU(((SmileyPanelConfigInfo)localIterator.next()).field_key, paramString))
        {
          AppMethodBeat.o(177036);
          return true;
        }
      }
      AppMethodBeat.o(177036);
      return false;
    }
  }
  
  public final boolean eHS()
  {
    AppMethodBeat.i(104922);
    ad.i("MicroMsg.MergerSmileyManager", "checkNewSmiley ");
    ArrayList localArrayList = ((PluginEmoji)g.ad(PluginEmoji.class)).getProvider().bUF();
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      btQ();
      AppMethodBeat.o(104922);
      return true;
    }
    btQ();
    AppMethodBeat.o(104922);
    return false;
  }
  
  public final List<SmileyPanelConfigInfo> eHU()
  {
    AppMethodBeat.i(177035);
    synchronized (this.FaI)
    {
      ArrayList localArrayList = new ArrayList(this.FaI);
      AppMethodBeat.o(177035);
      return localArrayList;
    }
  }
  
  public Drawable vc(int paramInt)
  {
    AppMethodBeat.i(104926);
    if (this.FaJ == null)
    {
      ad.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
      AppMethodBeat.o(104926);
      return null;
    }
    Object localObject = (SmileyPanelConfigInfo)this.FaJ.get(paramInt);
    if (localObject == null)
    {
      ad.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
      AppMethodBeat.o(104926);
      return null;
    }
    localObject = aGN(((SmileyPanelConfigInfo)localObject).field_key);
    AppMethodBeat.o(104926);
    return localObject;
  }
  
  public String vd(int paramInt)
  {
    AppMethodBeat.i(104929);
    if (paramInt < 0)
    {
      ad.w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
      AppMethodBeat.o(104929);
      return "";
    }
    Object localObject2 = eHT().FaH[paramInt].split(" ");
    Object localObject1 = Character.toChars(Integer.decode(localObject2[0]).intValue());
    localObject2 = Character.toChars(Integer.decode(localObject2[1]).intValue());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((char[])localObject1);
    localStringBuilder.append((char[])localObject2);
    localObject1 = localStringBuilder.toString();
    AppMethodBeat.o(104929);
    return localObject1;
  }
  
  public String ve(int paramInt)
  {
    AppMethodBeat.i(104928);
    List localList = this.FaI;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt >= this.FaI.size())
      {
        ad.w("MicroMsg.MergerSmileyManager", "get text key, error index");
        return "";
      }
      Object localObject1 = (SmileyPanelConfigInfo)this.FaI.get(paramInt);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cg.e
 * JD-Core Version:    0.7.0.1
 */