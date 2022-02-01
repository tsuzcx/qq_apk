package com.tencent.mm.cf;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.tmassistantsdk.util.Base64;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class e
{
  private static e GxV = null;
  private String[] GxW;
  private String[] GxX;
  private String[] GxY;
  private final List<SmileyPanelConfigInfo> GxZ;
  private SparseArray<SmileyPanelConfigInfo> Gya;
  private String country;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(104920);
    this.GxZ = Collections.synchronizedList(new ArrayList());
    this.Gya = new SparseArray();
    this.GxW = paramContext.getResources().getStringArray(2130903068);
    this.GxX = paramContext.getResources().getStringArray(2130903069);
    this.GxY = paramContext.getResources().getStringArray(2130903070);
    this.GxZ.clear();
    this.Gya.clear();
    eXn();
    this.country = ab.eUO();
    if (!ai.cin()) {
      eXo();
    }
    AppMethodBeat.o(104920);
  }
  
  public static Drawable aMf(String paramString)
  {
    AppMethodBeat.i(177037);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177037);
      return null;
    }
    SmileyInfo localSmileyInfo = f.eXr().aMk(paramString);
    if (localSmileyInfo != null)
    {
      paramString = f.eXr().a(localSmileyInfo);
      AppMethodBeat.o(177037);
      return paramString;
    }
    paramString = b.eXh().aMe(paramString);
    paramString = b.eXh().a(paramString, true);
    AppMethodBeat.o(177037);
    return paramString;
  }
  
  private void eXn()
  {
    int k = 0;
    AppMethodBeat.i(104921);
    if ((this.GxW != null) && (this.GxY != null))
    {
      int m = this.GxW.length;
      int j = 0;
      int i = 0;
      SmileyPanelConfigInfo localSmileyPanelConfigInfo;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.GxW[j]);
        this.GxZ.add(localSmileyPanelConfigInfo);
        this.Gya.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
      m = this.GxY.length;
      j = k;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.GxY[j]);
        this.GxZ.add(localSmileyPanelConfigInfo);
        this.Gya.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
    }
    AppMethodBeat.o(104921);
  }
  
  public static e eXp()
  {
    AppMethodBeat.i(104925);
    if (GxV == null) {}
    try
    {
      GxV = new e(ai.getContext());
      e locale = GxV;
      AppMethodBeat.o(104925);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(104925);
    }
  }
  
  public final String aMg(String paramString)
  {
    AppMethodBeat.i(177038);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177038);
      return "";
    }
    SmileyInfo localSmileyInfo = f.eXr().aMk(paramString);
    if (localSmileyInfo != null)
    {
      if ((this.country.equals("zh_CN")) && (!bs.isNullOrNil(localSmileyInfo.field_cnValue)))
      {
        paramString = localSmileyInfo.field_cnValue;
        AppMethodBeat.o(177038);
        return paramString;
      }
      if (((this.country.equals("zh_TW")) || (this.country.equals("zh_HK"))) && (!bs.isNullOrNil(localSmileyInfo.field_twValue)))
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
  
  public int bAP()
  {
    AppMethodBeat.i(104923);
    ac.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo " + bs.eWi());
    this.GxZ.clear();
    ArrayList localArrayList1 = ((PluginEmoji)g.ad(PluginEmoji.class)).getProvider().cbS();
    if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
      localArrayList1 = com.tencent.mm.emoji.d.b.f(new com.tencent.mm.vfs.e("assets:///panel/".concat(String.valueOf(((d)g.ad(d.class)).getProvider().cbV()))));
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
        localArrayList2 = f.eXr().eXv();
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
          ac.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", new Object[] { str });
        }
        for (;;)
        {
          j += 1;
          break;
          this.GxZ.add(localSmileyPanelConfigInfo);
          this.Gya.put(i, localSmileyPanelConfigInfo);
          i += 1;
        }
        for (i = 0;; i = -1)
        {
          AppMethodBeat.o(104923);
          return i;
          eXn();
          ac.i("MicroMsg.MergerSmileyManager", "smiley panel list is null.");
        }
      }
    }
  }
  
  public int bAQ()
  {
    AppMethodBeat.i(104924);
    if (this.GxZ == null)
    {
      AppMethodBeat.o(104924);
      return 0;
    }
    int i = this.GxZ.size();
    AppMethodBeat.o(104924);
    return i;
  }
  
  public final boolean containsKey(String paramString)
  {
    AppMethodBeat.i(177036);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177036);
      return false;
    }
    synchronized (this.GxZ)
    {
      Iterator localIterator = this.GxZ.iterator();
      while (localIterator.hasNext()) {
        if (bs.lr(((SmileyPanelConfigInfo)localIterator.next()).field_key, paramString))
        {
          AppMethodBeat.o(177036);
          return true;
        }
      }
      AppMethodBeat.o(177036);
      return false;
    }
  }
  
  public final boolean eXo()
  {
    AppMethodBeat.i(104922);
    ac.i("MicroMsg.MergerSmileyManager", "checkNewSmiley ");
    ArrayList localArrayList = ((PluginEmoji)g.ad(PluginEmoji.class)).getProvider().cbS();
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      bAP();
      AppMethodBeat.o(104922);
      return true;
    }
    bAP();
    AppMethodBeat.o(104922);
    return false;
  }
  
  public final List<SmileyPanelConfigInfo> eXq()
  {
    AppMethodBeat.i(177035);
    synchronized (this.GxZ)
    {
      ArrayList localArrayList = new ArrayList(this.GxZ);
      AppMethodBeat.o(177035);
      return localArrayList;
    }
  }
  
  public Drawable vT(int paramInt)
  {
    AppMethodBeat.i(104926);
    if (this.Gya == null)
    {
      ac.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
      AppMethodBeat.o(104926);
      return null;
    }
    Object localObject = (SmileyPanelConfigInfo)this.Gya.get(paramInt);
    if (localObject == null)
    {
      ac.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
      AppMethodBeat.o(104926);
      return null;
    }
    localObject = aMf(((SmileyPanelConfigInfo)localObject).field_key);
    AppMethodBeat.o(104926);
    return localObject;
  }
  
  public String vU(int paramInt)
  {
    AppMethodBeat.i(104929);
    if (paramInt < 0)
    {
      ac.w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
      AppMethodBeat.o(104929);
      return "";
    }
    Object localObject2 = eXp().GxY[paramInt].split(" ");
    Object localObject1 = Character.toChars(Integer.decode(localObject2[0]).intValue());
    localObject2 = Character.toChars(Integer.decode(localObject2[1]).intValue());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((char[])localObject1);
    localStringBuilder.append((char[])localObject2);
    localObject1 = localStringBuilder.toString();
    AppMethodBeat.o(104929);
    return localObject1;
  }
  
  public String vV(int paramInt)
  {
    AppMethodBeat.i(104928);
    List localList = this.GxZ;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt >= this.GxZ.size())
      {
        ac.w("MicroMsg.MergerSmileyManager", "get text key, error index");
        return "";
      }
      Object localObject1 = (SmileyPanelConfigInfo)this.GxZ.get(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cf.e
 * JD-Core Version:    0.7.0.1
 */