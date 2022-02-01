package com.tencent.mm.ce;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.tmassistantsdk.util.Base64;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class e
{
  private static e IEa = null;
  private String[] IEb;
  private String[] IEc;
  private String[] IEd;
  private final List<SmileyPanelConfigInfo> IEe;
  private SparseArray<SmileyPanelConfigInfo> IEf;
  private String country;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(104920);
    this.IEe = Collections.synchronizedList(new ArrayList());
    this.IEf = new SparseArray();
    this.IEb = paramContext.getResources().getStringArray(2130903068);
    this.IEc = paramContext.getResources().getStringArray(2130903069);
    this.IEd = paramContext.getResources().getStringArray(2130903070);
    this.IEe.clear();
    this.IEf.clear();
    fqR();
    this.country = ad.fom();
    if (!ak.coh()) {
      fqS();
    }
    AppMethodBeat.o(104920);
  }
  
  public static Drawable aTj(String paramString)
  {
    AppMethodBeat.i(177037);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177037);
      return null;
    }
    SmileyInfo localSmileyInfo = f.fqV().aTo(paramString);
    if (localSmileyInfo != null)
    {
      paramString = f.fqV().a(localSmileyInfo);
      AppMethodBeat.o(177037);
      return paramString;
    }
    paramString = b.fqL().aTi(paramString);
    paramString = b.fqL().a(paramString, true);
    AppMethodBeat.o(177037);
    return paramString;
  }
  
  private void fqR()
  {
    int k = 0;
    AppMethodBeat.i(104921);
    if ((this.IEb != null) && (this.IEd != null))
    {
      int m = this.IEb.length;
      int j = 0;
      int i = 0;
      SmileyPanelConfigInfo localSmileyPanelConfigInfo;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.IEb[j]);
        this.IEe.add(localSmileyPanelConfigInfo);
        this.IEf.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
      m = this.IEd.length;
      j = k;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.IEd[j]);
        this.IEe.add(localSmileyPanelConfigInfo);
        this.IEf.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
    }
    AppMethodBeat.o(104921);
  }
  
  public static e fqT()
  {
    AppMethodBeat.i(104925);
    if (IEa == null) {}
    try
    {
      IEa = new e(ak.getContext());
      e locale = IEa;
      AppMethodBeat.o(104925);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(104925);
    }
  }
  
  public final String aTk(String paramString)
  {
    AppMethodBeat.i(177038);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177038);
      return "";
    }
    SmileyInfo localSmileyInfo = f.fqV().aTo(paramString);
    if (localSmileyInfo != null)
    {
      if ((this.country.equals("zh_CN")) && (!bu.isNullOrNil(localSmileyInfo.field_cnValue)))
      {
        paramString = localSmileyInfo.field_cnValue;
        AppMethodBeat.o(177038);
        return paramString;
      }
      if (((this.country.equals("zh_TW")) || (this.country.equals("zh_HK"))) && (!bu.isNullOrNil(localSmileyInfo.field_twValue)))
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
  
  public int bFJ()
  {
    AppMethodBeat.i(104923);
    ae.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo");
    this.IEe.clear();
    ArrayList localArrayList1 = ((PluginEmoji)com.tencent.mm.kernel.g.ad(PluginEmoji.class)).getProvider().chM();
    Object localObject;
    if ((localArrayList1 == null) || (localArrayList1.isEmpty()))
    {
      localObject = ((d)com.tencent.mm.kernel.g.ad(d.class)).getProvider().chP();
      localArrayList1 = com.tencent.mm.emoji.d.b.f(new k("assets:///panel/".concat(String.valueOf(localObject))));
      if (localArrayList1.size() < 50) {
        ae.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: from asset xml %s", new Object[] { Integer.valueOf(localArrayList1.size()) });
      }
    }
    ArrayList localArrayList2;
    for (;;)
    {
      try
      {
        ae.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: %s", new Object[] { o.aZT("assets:///panel/".concat(String.valueOf(localObject))) });
        com.tencent.mm.plugin.report.service.g.yxI.dD(1062, 80);
        if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
          break label456;
        }
        localObject = f.fqV();
        localArrayList2 = new ArrayList();
        if (((f)localObject).IEn == null) {
          break;
        }
        localObject = ((f)localObject).IEn.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localArrayList2.add(((SmileyInfo)((Iterator)localObject).next()).field_key);
        continue;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MergerSmileyManager", localException, "", new Object[0]);
        continue;
      }
      if (localArrayList1.size() < 50)
      {
        ae.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: from db %s", new Object[] { Integer.valueOf(localArrayList1.size()) });
        com.tencent.mm.plugin.report.service.g.yxI.dD(1062, 81);
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
        ae.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", new Object[] { str });
      }
      for (;;)
      {
        j += 1;
        break;
        this.IEe.add(localSmileyPanelConfigInfo);
        this.IEf.put(i, localSmileyPanelConfigInfo);
        i += 1;
      }
      for (i = 0;; i = -1)
      {
        AppMethodBeat.o(104923);
        return i;
        fqR();
        ae.i("MicroMsg.MergerSmileyManager", "smiley panel list is null.");
      }
    }
  }
  
  public int bFK()
  {
    AppMethodBeat.i(104924);
    if (this.IEe == null)
    {
      AppMethodBeat.o(104924);
      return 0;
    }
    int i = this.IEe.size();
    AppMethodBeat.o(104924);
    return i;
  }
  
  public final boolean containsKey(String paramString)
  {
    AppMethodBeat.i(177036);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177036);
      return false;
    }
    synchronized (this.IEe)
    {
      Iterator localIterator = this.IEe.iterator();
      while (localIterator.hasNext()) {
        if (bu.lX(((SmileyPanelConfigInfo)localIterator.next()).field_key, paramString))
        {
          AppMethodBeat.o(177036);
          return true;
        }
      }
      AppMethodBeat.o(177036);
      return false;
    }
  }
  
  public final boolean fqS()
  {
    AppMethodBeat.i(104922);
    ae.i("MicroMsg.MergerSmileyManager", "checkNewSmiley ");
    ArrayList localArrayList = ((PluginEmoji)com.tencent.mm.kernel.g.ad(PluginEmoji.class)).getProvider().chM();
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      bFJ();
      AppMethodBeat.o(104922);
      return true;
    }
    bFJ();
    AppMethodBeat.o(104922);
    return false;
  }
  
  public final List<SmileyPanelConfigInfo> fqU()
  {
    AppMethodBeat.i(177035);
    synchronized (this.IEe)
    {
      ArrayList localArrayList = new ArrayList(this.IEe);
      AppMethodBeat.o(177035);
      return localArrayList;
    }
  }
  
  public Drawable wD(int paramInt)
  {
    AppMethodBeat.i(104926);
    if (this.IEf == null)
    {
      ae.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
      AppMethodBeat.o(104926);
      return null;
    }
    Object localObject = (SmileyPanelConfigInfo)this.IEf.get(paramInt);
    if (localObject == null)
    {
      ae.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
      AppMethodBeat.o(104926);
      return null;
    }
    localObject = aTj(((SmileyPanelConfigInfo)localObject).field_key);
    AppMethodBeat.o(104926);
    return localObject;
  }
  
  public String wE(int paramInt)
  {
    AppMethodBeat.i(104929);
    if (paramInt < 0)
    {
      ae.w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
      AppMethodBeat.o(104929);
      return "";
    }
    Object localObject2 = fqT().IEd[paramInt].split(" ");
    Object localObject1 = Character.toChars(Integer.decode(localObject2[0]).intValue());
    localObject2 = Character.toChars(Integer.decode(localObject2[1]).intValue());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((char[])localObject1);
    localStringBuilder.append((char[])localObject2);
    localObject1 = localStringBuilder.toString();
    AppMethodBeat.o(104929);
    return localObject1;
  }
  
  public String wF(int paramInt)
  {
    AppMethodBeat.i(104928);
    List localList = this.IEe;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt >= this.IEe.size())
      {
        ae.w("MicroMsg.MergerSmileyManager", "get text key, error index");
        return "";
      }
      Object localObject1 = (SmileyPanelConfigInfo)this.IEe.get(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ce.e
 * JD-Core Version:    0.7.0.1
 */