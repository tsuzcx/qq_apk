package com.tencent.mm.cf;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.vfs.i;
import com.tencent.tmassistantsdk.util.Base64;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class e
{
  private static e IjP = null;
  private String[] IjQ;
  private String[] IjR;
  private String[] IjS;
  private final List<SmileyPanelConfigInfo> IjT;
  private SparseArray<SmileyPanelConfigInfo> IjU;
  private String country;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(104920);
    this.IjT = Collections.synchronizedList(new ArrayList());
    this.IjU = new SparseArray();
    this.IjQ = paramContext.getResources().getStringArray(2130903068);
    this.IjR = paramContext.getResources().getStringArray(2130903069);
    this.IjS = paramContext.getResources().getStringArray(2130903070);
    this.IjT.clear();
    this.IjU.clear();
    fmX();
    this.country = ac.fks();
    if (!aj.cmR()) {
      fmY();
    }
    AppMethodBeat.o(104920);
  }
  
  public static Drawable aRM(String paramString)
  {
    AppMethodBeat.i(177037);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177037);
      return null;
    }
    SmileyInfo localSmileyInfo = f.fnb().aRR(paramString);
    if (localSmileyInfo != null)
    {
      paramString = f.fnb().a(localSmileyInfo);
      AppMethodBeat.o(177037);
      return paramString;
    }
    paramString = b.fmR().aRL(paramString);
    paramString = b.fmR().a(paramString, true);
    AppMethodBeat.o(177037);
    return paramString;
  }
  
  private void fmX()
  {
    int k = 0;
    AppMethodBeat.i(104921);
    if ((this.IjQ != null) && (this.IjS != null))
    {
      int m = this.IjQ.length;
      int j = 0;
      int i = 0;
      SmileyPanelConfigInfo localSmileyPanelConfigInfo;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.IjQ[j]);
        this.IjT.add(localSmileyPanelConfigInfo);
        this.IjU.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
      m = this.IjS.length;
      j = k;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.IjS[j]);
        this.IjT.add(localSmileyPanelConfigInfo);
        this.IjU.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
    }
    AppMethodBeat.o(104921);
  }
  
  public static e fmZ()
  {
    AppMethodBeat.i(104925);
    if (IjP == null) {}
    try
    {
      IjP = new e(aj.getContext());
      e locale = IjP;
      AppMethodBeat.o(104925);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(104925);
    }
  }
  
  public final String aRN(String paramString)
  {
    AppMethodBeat.i(177038);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177038);
      return "";
    }
    SmileyInfo localSmileyInfo = f.fnb().aRR(paramString);
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
  
  public int bER()
  {
    AppMethodBeat.i(104923);
    ad.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo");
    this.IjT.clear();
    ArrayList localArrayList1 = ((PluginEmoji)com.tencent.mm.kernel.g.ad(PluginEmoji.class)).getProvider().cgw();
    Object localObject;
    if ((localArrayList1 == null) || (localArrayList1.isEmpty()))
    {
      localObject = ((d)com.tencent.mm.kernel.g.ad(d.class)).getProvider().cgz();
      localArrayList1 = com.tencent.mm.emoji.d.b.f(new com.tencent.mm.vfs.e("assets:///panel/".concat(String.valueOf(localObject))));
      if (localArrayList1.size() < 50) {
        ad.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: from asset xml %s", new Object[] { Integer.valueOf(localArrayList1.size()) });
      }
    }
    ArrayList localArrayList2;
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: %s", new Object[] { i.aYq("assets:///panel/".concat(String.valueOf(localObject))) });
        com.tencent.mm.plugin.report.service.g.yhR.dD(1062, 80);
        if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
          break label456;
        }
        localObject = f.fnb();
        localArrayList2 = new ArrayList();
        if (((f)localObject).Ikc == null) {
          break;
        }
        localObject = ((f)localObject).Ikc.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localArrayList2.add(((SmileyInfo)((Iterator)localObject).next()).field_key);
        continue;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MergerSmileyManager", localException, "", new Object[0]);
        continue;
      }
      if (localArrayList1.size() < 50)
      {
        ad.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: from db %s", new Object[] { Integer.valueOf(localArrayList1.size()) });
        com.tencent.mm.plugin.report.service.g.yhR.dD(1062, 81);
      }
    }
    int k = localArrayList1.size();
    int j = 0;
    int i = 0;
    SmileyPanelConfigInfo localSmileyPanelConfigInfo;
    String str;
    if (j < k)
    {
      localSmileyPanelConfigInfo = (SmileyPanelConfigInfo)localArrayList1.get(j);
      str = localSmileyPanelConfigInfo.field_key;
      if (!str.matches("^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$")) {
        break label473;
      }
      str = new String(Base64.decode(str, 0));
      localSmileyPanelConfigInfo.field_key = str;
    }
    label456:
    label473:
    for (;;)
    {
      if ((str.startsWith("[")) && (!localArrayList2.contains(str))) {
        ad.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", new Object[] { str });
      }
      for (;;)
      {
        j += 1;
        break;
        this.IjT.add(localSmileyPanelConfigInfo);
        this.IjU.put(i, localSmileyPanelConfigInfo);
        i += 1;
      }
      for (i = 0;; i = -1)
      {
        AppMethodBeat.o(104923);
        return i;
        fmX();
        ad.i("MicroMsg.MergerSmileyManager", "smiley panel list is null.");
      }
    }
  }
  
  public int bES()
  {
    AppMethodBeat.i(104924);
    if (this.IjT == null)
    {
      AppMethodBeat.o(104924);
      return 0;
    }
    int i = this.IjT.size();
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
    synchronized (this.IjT)
    {
      Iterator localIterator = this.IjT.iterator();
      while (localIterator.hasNext()) {
        if (bt.lQ(((SmileyPanelConfigInfo)localIterator.next()).field_key, paramString))
        {
          AppMethodBeat.o(177036);
          return true;
        }
      }
      AppMethodBeat.o(177036);
      return false;
    }
  }
  
  public final boolean fmY()
  {
    AppMethodBeat.i(104922);
    ad.i("MicroMsg.MergerSmileyManager", "checkNewSmiley ");
    ArrayList localArrayList = ((PluginEmoji)com.tencent.mm.kernel.g.ad(PluginEmoji.class)).getProvider().cgw();
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      bER();
      AppMethodBeat.o(104922);
      return true;
    }
    bER();
    AppMethodBeat.o(104922);
    return false;
  }
  
  public final List<SmileyPanelConfigInfo> fna()
  {
    AppMethodBeat.i(177035);
    synchronized (this.IjT)
    {
      ArrayList localArrayList = new ArrayList(this.IjT);
      AppMethodBeat.o(177035);
      return localArrayList;
    }
  }
  
  public String wA(int paramInt)
  {
    AppMethodBeat.i(104928);
    List localList = this.IjT;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt >= this.IjT.size())
      {
        ad.w("MicroMsg.MergerSmileyManager", "get text key, error index");
        return "";
      }
      Object localObject1 = (SmileyPanelConfigInfo)this.IjT.get(paramInt);
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
  
  public Drawable wy(int paramInt)
  {
    AppMethodBeat.i(104926);
    if (this.IjU == null)
    {
      ad.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
      AppMethodBeat.o(104926);
      return null;
    }
    Object localObject = (SmileyPanelConfigInfo)this.IjU.get(paramInt);
    if (localObject == null)
    {
      ad.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
      AppMethodBeat.o(104926);
      return null;
    }
    localObject = aRM(((SmileyPanelConfigInfo)localObject).field_key);
    AppMethodBeat.o(104926);
    return localObject;
  }
  
  public String wz(int paramInt)
  {
    AppMethodBeat.i(104929);
    if (paramInt < 0)
    {
      ad.w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
      AppMethodBeat.o(104929);
      return "";
    }
    Object localObject2 = fmZ().IjS[paramInt].split(" ");
    Object localObject1 = Character.toChars(Integer.decode(localObject2[0]).intValue());
    localObject2 = Character.toChars(Integer.decode(localObject2[1]).intValue());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((char[])localObject1);
    localStringBuilder.append((char[])localObject2);
    localObject1 = localStringBuilder.toString();
    AppMethodBeat.o(104929);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cf.e
 * JD-Core Version:    0.7.0.1
 */