package com.tencent.mm.cl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.m.a.b;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class f
{
  private static f UYx = null;
  private final String PzQ;
  public final List<SmileyPanelConfigInfo> UYA;
  public SparseArray<SmileyPanelConfigInfo> UYB;
  private String[] UYy;
  private String[] UYz;
  private String country;
  private String fyn;
  private final String jGs;
  private final String versionName;
  
  private f(Context paramContext)
  {
    AppMethodBeat.i(104920);
    StringBuilder localStringBuilder = new StringBuilder();
    a locala = a.jPz;
    this.jGs = (a.aDD() + "panel/");
    this.PzQ = "assets:///panel/";
    this.versionName = "config.conf";
    this.fyn = "";
    this.UYA = Collections.synchronizedList(new ArrayList());
    this.UYB = new SparseArray();
    this.UYy = paramContext.getResources().getStringArray(a.b.merge_smiley_code_smiley);
    this.UYz = paramContext.getResources().getStringArray(a.b.merge_smiley_unicode_emoji);
    this.UYA.clear();
    this.UYB.clear();
    htN();
    this.country = LocaleUtil.getApplicationLanguage();
    if (!MMApplicationContext.isMainProcess()) {
      htO();
    }
    AppMethodBeat.o(104920);
  }
  
  public static Drawable buv(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(177037);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177037);
      return null;
    }
    Object localObject2 = g.htS().buz(paramString);
    int i;
    if (localObject2 != null)
    {
      paramString = g.htS();
      i = ((SmileyInfo)localObject2).field_position;
      if (i >= 0) {}
      for (paramString = b.htF().ash(i);; paramString = paramString.buy(((SmileyInfo)localObject2).field_fileName))
      {
        AppMethodBeat.o(177037);
        return paramString;
      }
    }
    localObject2 = b.htF();
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.EmojiHelper", "getEmoji item failed. key is null.");
      paramString = localObject1;
    }
    for (;;)
    {
      paramString = b.htF().a(paramString, true);
      AppMethodBeat.o(177037);
      return paramString;
      i = paramString.codePointAt(0);
      if (((b)localObject2).asg(i) != null) {
        paramString = ((b)localObject2).asg(i);
      } else {
        paramString = ((b)localObject2).mc(i, 0);
      }
    }
  }
  
  private void htN()
  {
    int k = 0;
    AppMethodBeat.i(104921);
    if ((this.UYy != null) && (this.UYz != null))
    {
      int m = this.UYy.length;
      int j = 0;
      int i = 0;
      SmileyPanelConfigInfo localSmileyPanelConfigInfo;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.UYy[j]);
        this.UYA.add(localSmileyPanelConfigInfo);
        this.UYB.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
      m = this.UYz.length;
      j = k;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.UYz[j]);
        this.UYA.add(localSmileyPanelConfigInfo);
        this.UYB.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
    }
    AppMethodBeat.o(104921);
  }
  
  public static f htQ()
  {
    AppMethodBeat.i(104925);
    if (UYx == null) {}
    try
    {
      UYx = new f(MMApplicationContext.getContext());
      f localf = UYx;
      AppMethodBeat.o(104925);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(104925);
    }
  }
  
  public final String asi(int paramInt)
  {
    AppMethodBeat.i(104928);
    List localList = this.UYA;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt >= this.UYA.size())
      {
        Log.w("MicroMsg.MergerSmileyManager", "get text key, error index");
        return "";
      }
      Object localObject1 = (SmileyPanelConfigInfo)this.UYA.get(paramInt);
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
  
  public final String buw(String paramString)
  {
    AppMethodBeat.i(177038);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177038);
      return "";
    }
    SmileyInfo localSmileyInfo = g.htS().buz(paramString);
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
  
  public final boolean containsKey(String paramString)
  {
    AppMethodBeat.i(177036);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177036);
      return false;
    }
    synchronized (this.UYA)
    {
      Iterator localIterator = this.UYA.iterator();
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
  
  public final boolean htO()
  {
    AppMethodBeat.i(104922);
    Log.i("MicroMsg.MergerSmileyManager", "checkNewSmiley ");
    ArrayList localArrayList = ((PluginEmoji)h.ag(PluginEmoji.class)).getProvider().cUp();
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      htP();
      AppMethodBeat.o(104922);
      return true;
    }
    htP();
    AppMethodBeat.o(104922);
    return false;
  }
  
  public final int htP()
  {
    AppMethodBeat.i(104923);
    Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo");
    this.UYA.clear();
    this.fyn = ((d)h.ag(d.class)).getProvider().cUs();
    new ArrayList();
    Object localObject2 = new ArrayList();
    int i = com.tencent.mm.emoji.e.b.LR(this.jGs + "config.conf");
    int j = com.tencent.mm.emoji.e.b.LR("assets:///panel/config.conf");
    Object localObject4 = this.jGs + this.fyn;
    Object localObject3 = "assets:///panel/" + this.fyn;
    Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: local:%s, asset:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    Object localObject1 = localObject2;
    if (i > 0)
    {
      localObject1 = localObject2;
      if (i >= j)
      {
        localObject1 = localObject2;
        if (u.agG((String)localObject4))
        {
          localObject1 = com.tencent.mm.emoji.e.b.e(new q((String)localObject4));
          Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: localSize %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
        }
      }
    }
    if (((ArrayList)localObject1).size() <= 0)
    {
      localObject1 = com.tencent.mm.emoji.e.b.e(new q((String)localObject3));
      if (((ArrayList)localObject1).size() < 50) {
        Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: from asset xml %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
      }
    }
    label528:
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: %s", new Object[] { u.bBS("assets:///panel/" + this.fyn) });
        if (!((ArrayList)localObject1).isEmpty())
        {
          localObject3 = g.htS().htX();
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
        this.UYA.add(localObject4);
        this.UYB.put(i, localObject4);
        i += 1;
        continue;
        i = 0;
        AppMethodBeat.o(104923);
        return i;
      }
      htN();
      Log.i("MicroMsg.MergerSmileyManager", "smiley panel list is null.");
      i = -1;
      continue;
    }
  }
  
  public final List<SmileyPanelConfigInfo> htR()
  {
    AppMethodBeat.i(177035);
    synchronized (this.UYA)
    {
      ArrayList localArrayList = new ArrayList(this.UYA);
      AppMethodBeat.o(177035);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cl.f
 * JD-Core Version:    0.7.0.1
 */