package com.tencent.mm.cd;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import java.util.ArrayList;

public class e
{
  private static e yuD = null;
  private String country;
  private String[] yuE;
  private String[] yuF;
  private String[] yuG;
  private ArrayList<SmileyPanelConfigInfo> yuH;
  private SparseArray<SmileyPanelConfigInfo> yuI;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(62666);
    this.yuH = new ArrayList();
    this.yuI = new SparseArray();
    this.yuE = paramContext.getResources().getStringArray(2131755036);
    this.yuF = paramContext.getResources().getStringArray(2131755037);
    this.yuG = paramContext.getResources().getStringArray(2131755038);
    this.yuH.clear();
    this.yuI.clear();
    dvc();
    this.country = aa.dsG();
    if (!ah.dsT()) {
      dvd();
    }
    AppMethodBeat.o(62666);
  }
  
  private void dvc()
  {
    int k = 0;
    AppMethodBeat.i(62667);
    if ((this.yuE != null) && (this.yuG != null))
    {
      int m = this.yuE.length;
      int j = 0;
      int i = 0;
      SmileyPanelConfigInfo localSmileyPanelConfigInfo;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.yuE[j]);
        this.yuH.add(localSmileyPanelConfigInfo);
        this.yuI.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
      m = this.yuG.length;
      j = k;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.yuG[j]);
        this.yuH.add(localSmileyPanelConfigInfo);
        this.yuI.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
    }
    AppMethodBeat.o(62667);
  }
  
  public static e dve()
  {
    AppMethodBeat.i(62670);
    if (yuD == null) {}
    try
    {
      yuD = new e(ah.getContext());
      e locale = yuD;
      AppMethodBeat.o(62670);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(62670);
    }
  }
  
  public int aRA()
  {
    AppMethodBeat.i(62669);
    if (this.yuH == null)
    {
      AppMethodBeat.o(62669);
      return 0;
    }
    int i = this.yuH.size();
    AppMethodBeat.o(62669);
    return i;
  }
  
  public int aRz()
  {
    AppMethodBeat.i(62668);
    ab.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo " + bo.dtY());
    this.yuH.clear();
    ArrayList localArrayList1 = ((PluginEmoji)g.G(PluginEmoji.class)).getProvider().bkV();
    if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
      localArrayList1 = a.b(new com.tencent.mm.vfs.b("assets:///panel/".concat(String.valueOf(((d)g.G(d.class)).getProvider().bkY()))));
    }
    for (;;)
    {
      if ((localArrayList1 != null) && (!localArrayList1.isEmpty()))
      {
        ArrayList localArrayList2 = f.dvf().dvj();
        int k = localArrayList1.size();
        int j = 0;
        i = 0;
        if (j < k)
        {
          SmileyPanelConfigInfo localSmileyPanelConfigInfo = (SmileyPanelConfigInfo)localArrayList1.get(j);
          String str = localSmileyPanelConfigInfo.field_key;
          if ((str.startsWith("[")) && (!localArrayList2.contains(str))) {
            ab.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", new Object[] { str });
          }
          for (;;)
          {
            j += 1;
            break;
            this.yuH.add(localSmileyPanelConfigInfo);
            this.yuI.put(i, localSmileyPanelConfigInfo);
            i += 1;
          }
        }
      }
      for (int i = 0;; i = -1)
      {
        AppMethodBeat.o(62668);
        return i;
        dvc();
        ab.i("MicroMsg.MergerSmileyManager", "smiley panel list is null.");
      }
    }
  }
  
  public final boolean dvd()
  {
    AppMethodBeat.i(151742);
    ab.i("MicroMsg.MergerSmileyManager", "checkNewSmiley ");
    ArrayList localArrayList = ((PluginEmoji)g.G(PluginEmoji.class)).getProvider().bkV();
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      aRz();
      AppMethodBeat.o(151742);
      return true;
    }
    aRz();
    AppMethodBeat.o(151742);
    return false;
  }
  
  public String getText(int paramInt)
  {
    AppMethodBeat.i(62672);
    if ((paramInt < 0) || (paramInt >= this.yuH.size()))
    {
      ab.w("MicroMsg.MergerSmileyManager", "get text, error index");
      AppMethodBeat.o(62672);
      return "";
    }
    Object localObject = (SmileyPanelConfigInfo)this.yuH.get(paramInt);
    if (localObject != null)
    {
      SmileyInfo localSmileyInfo = f.dvf().aqG(((SmileyPanelConfigInfo)localObject).field_key);
      if (localSmileyInfo != null)
      {
        if ((this.country.equals("zh_CN")) && (!bo.isNullOrNil(localSmileyInfo.field_cnValue)))
        {
          localObject = localSmileyInfo.field_cnValue;
          AppMethodBeat.o(62672);
          return localObject;
        }
        if (((this.country.equals("zh_TW")) || (this.country.equals("zh_HK"))) && (!bo.isNullOrNil(localSmileyInfo.field_twValue)))
        {
          localObject = localSmileyInfo.field_twValue;
          AppMethodBeat.o(62672);
          return localObject;
        }
        localObject = localSmileyInfo.field_enValue;
        AppMethodBeat.o(62672);
        return localObject;
      }
      localObject = ((SmileyPanelConfigInfo)localObject).field_key;
      AppMethodBeat.o(62672);
      return localObject;
    }
    AppMethodBeat.o(62672);
    return "";
  }
  
  public Drawable qA(int paramInt)
  {
    AppMethodBeat.i(62671);
    if (this.yuI == null)
    {
      ab.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
      AppMethodBeat.o(62671);
      return null;
    }
    Object localObject1 = (SmileyPanelConfigInfo)this.yuI.get(paramInt);
    if (localObject1 == null)
    {
      ab.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
      AppMethodBeat.o(62671);
      return null;
    }
    Object localObject2 = f.dvf().aqG(((SmileyPanelConfigInfo)localObject1).field_key);
    if (localObject2 != null)
    {
      f.dvf();
      paramInt = ((SmileyInfo)localObject2).field_position;
      if (paramInt >= 0) {}
      for (localObject1 = b.duW().qA(paramInt);; localObject1 = f.aqF(((SmileyInfo)localObject2).field_fileName))
      {
        AppMethodBeat.o(62671);
        return localObject1;
      }
    }
    localObject2 = b.duW();
    localObject1 = ((SmileyPanelConfigInfo)localObject1).field_key;
    if (bo.isNullOrNil((String)localObject1))
    {
      ab.i("MicroMsg.EmojiHelper", "getEmoji item failed. key is null.");
      localObject1 = null;
    }
    for (;;)
    {
      localObject1 = b.duW().a((c)localObject1, true);
      break;
      paramInt = ((String)localObject1).codePointAt(0);
      if (((b)localObject2).Nn(paramInt) != null) {
        localObject1 = ((b)localObject2).Nn(paramInt);
      } else {
        localObject1 = ((b)localObject2).hn(paramInt, 0);
      }
    }
  }
  
  public String qB(int paramInt)
  {
    AppMethodBeat.i(62674);
    if (paramInt < 0)
    {
      ab.w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
      AppMethodBeat.o(62674);
      return "";
    }
    Object localObject2 = dve().yuG[paramInt].split(" ");
    Object localObject1 = Character.toChars(Integer.decode(localObject2[0]).intValue());
    localObject2 = Character.toChars(Integer.decode(localObject2[1]).intValue());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((char[])localObject1);
    localStringBuilder.append((char[])localObject2);
    localObject1 = localStringBuilder.toString();
    AppMethodBeat.o(62674);
    return localObject1;
  }
  
  public String qC(int paramInt)
  {
    AppMethodBeat.i(62673);
    if (paramInt < 0)
    {
      ab.w("MicroMsg.MergerSmileyManager", "get text, error index");
      AppMethodBeat.o(62673);
      return "";
    }
    Object localObject = (SmileyPanelConfigInfo)this.yuH.get(paramInt);
    if (localObject != null)
    {
      localObject = ((SmileyPanelConfigInfo)localObject).field_key;
      AppMethodBeat.o(62673);
      return localObject;
    }
    AppMethodBeat.o(62673);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cd.e
 * JD-Core Version:    0.7.0.1
 */