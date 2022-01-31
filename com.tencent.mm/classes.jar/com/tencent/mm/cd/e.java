package com.tencent.mm.cd;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.mm.h.a.hk;
import com.tencent.mm.h.a.hk.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.l.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import java.util.ArrayList;

public class e
{
  private static e ukZ = null;
  private String country;
  private String[] ula;
  private String[] ulb;
  private String[] ulc;
  private ArrayList<s> uld = new ArrayList();
  private SparseArray<s> ule = new SparseArray();
  
  public e(Context paramContext)
  {
    this.ula = paramContext.getResources().getStringArray(a.a.merge_smiley_code_smiley);
    this.ulb = paramContext.getResources().getStringArray(a.a.merge_smiley_softbank_emoji);
    this.ulc = paramContext.getResources().getStringArray(a.a.merge_smiley_unicode_emoji);
    this.uld.clear();
    this.ule.clear();
    csG();
    this.country = x.cqJ();
  }
  
  private void csG()
  {
    int k = 0;
    if ((this.ula != null) && (this.ulb != null))
    {
      int m = this.ula.length;
      int j = 0;
      int i = 0;
      s locals;
      while (j < m)
      {
        locals = new s(i, this.ula[j]);
        this.uld.add(locals);
        this.ule.put(i, locals);
        j += 1;
        i += 1;
      }
      m = this.ulb.length;
      j = k;
      while (j < m)
      {
        locals = new s(i, this.ulb[j]);
        this.uld.add(locals);
        this.ule.put(i, locals);
        j += 1;
        i += 1;
      }
    }
  }
  
  public static e csH()
  {
    if (ukZ == null) {}
    try
    {
      ukZ = new e(ae.getContext());
      return ukZ;
    }
    finally {}
  }
  
  public int asv()
  {
    y.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo " + bk.csb());
    this.uld.clear();
    Object localObject = ((PluginEmoji)g.t(PluginEmoji.class)).getEmojiMgr().aHi();
    if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHk();
      localObject = com.tencent.mm.u.b.a.b(new com.tencent.mm.vfs.b("assets:///panel/" + (String)localObject));
    }
    for (;;)
    {
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        ArrayList localArrayList = f.csI().csL();
        int k = ((ArrayList)localObject).size();
        int j = 0;
        int i = 0;
        if (j < k)
        {
          s locals = (s)((ArrayList)localObject).get(j);
          String str = locals.field_key;
          if ((str.startsWith("[")) && (!localArrayList.contains(str))) {
            y.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", new Object[] { str });
          }
          for (;;)
          {
            j += 1;
            break;
            this.uld.add(locals);
            this.ule.put(i, locals);
            i += 1;
          }
        }
        return 0;
      }
      csG();
      y.i("MicroMsg.MergerSmileyManager", "smiley panel list is null.");
      return -1;
    }
  }
  
  public int asw()
  {
    if (this.uld == null) {
      return 0;
    }
    return this.uld.size();
  }
  
  public String getText(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.uld.size()))
    {
      y.w("MicroMsg.MergerSmileyManager", "get text, error index");
      return "";
    }
    s locals = (s)this.uld.get(paramInt);
    if (locals != null)
    {
      q localq = f.csI().aaw(locals.field_key);
      if (localq != null)
      {
        if ((this.country.equals("zh_CN")) && (!bk.bl(localq.field_cnValue))) {
          return localq.field_cnValue;
        }
        if (((this.country.equals("zh_TW")) || (this.country.equals("zh_HK"))) && (!bk.bl(localq.field_twValue))) {
          return localq.field_twValue;
        }
        return localq.field_enValue;
      }
      return locals.field_key;
    }
    return "";
  }
  
  public Drawable mW(int paramInt)
  {
    if (this.ule == null)
    {
      y.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
      return null;
    }
    Object localObject1 = (s)this.ule.get(paramInt);
    if (localObject1 == null)
    {
      y.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
      return null;
    }
    Object localObject2 = f.csI().aaw(((s)localObject1).field_key);
    if (localObject2 != null)
    {
      f.csI();
      paramInt = ((q)localObject2).field_position;
      if (paramInt >= 0) {}
      for (localObject1 = b.csC().mW(paramInt);; localObject1 = f.aav(((q)localObject2).field_fileName)) {
        return localObject1;
      }
    }
    localObject2 = b.csC();
    localObject1 = ((s)localObject1).field_key;
    if (bk.bl((String)localObject1))
    {
      y.i("MicroMsg.EmojiHelper", "getEmoji item failed. key is null.");
      localObject1 = null;
    }
    for (;;)
    {
      localObject1 = b.csC().a((c)localObject1, true);
      break;
      paramInt = ((String)localObject1).codePointAt(0);
      if (((b)localObject2).Fi(paramInt) != null) {
        localObject1 = ((b)localObject2).Fi(paramInt);
      } else {
        localObject1 = ((b)localObject2).fg(paramInt, 0);
      }
    }
  }
  
  public String mX(int paramInt)
  {
    if (paramInt < 0)
    {
      y.w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
      return "";
    }
    Object localObject1 = new hk();
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    if (((hk)localObject1).bPp.bIY == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      Object localObject2 = csH().ulb[paramInt].split(" ");
      localObject1 = Character.toChars(Integer.decode(localObject2[0]).intValue());
      localObject2 = Character.toChars(Integer.decode(localObject2[1]).intValue());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((char[])localObject1);
      localStringBuilder.append((char[])localObject2);
      return localStringBuilder.toString();
    }
    return csH().ulb[paramInt];
  }
  
  public String mY(int paramInt)
  {
    if (paramInt < 0)
    {
      y.w("MicroMsg.MergerSmileyManager", "get text, error index");
      return "";
    }
    s locals = (s)this.uld.get(paramInt);
    if (locals != null) {
      return locals.field_key;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cd.e
 * JD-Core Version:    0.7.0.1
 */