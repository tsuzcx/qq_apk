package com.tencent.mm.plugin.emoji.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.a;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;

final class EmojiCustomUI$b
  extends BaseAdapter
{
  private ArrayList<EmojiInfo> jdc;
  private Animation jdd;
  
  public EmojiCustomUI$b(EmojiCustomUI paramEmojiCustomUI)
  {
    this.jdd = AnimationUtils.loadAnimation(paramEmojiCustomUI, f.a.refresh_animation);
    paramEmojiCustomUI = new LinearInterpolator();
    this.jdd.setInterpolator(paramEmojiCustomUI);
  }
  
  private static void a(ImageView paramImageView, EmojiInfo paramEmojiInfo)
  {
    paramImageView.setImageBitmap(null);
    String str1 = paramEmojiInfo.cwL();
    String str2 = str1 + "_cover";
    c.a locala = new c.a();
    locala.erk = 1;
    locala.err = true;
    locala.thumbPath = str2;
    locala.erh = str1;
    locala.erJ = new Object[] { paramEmojiInfo };
    locala.erH = true;
    paramEmojiInfo = locala.OV();
    o.ON().a(str1, paramImageView, paramEmojiInfo, null, EmojiCustomUI.bQB(), EmojiCustomUI.cbv());
  }
  
  private int aJb()
  {
    if ((getRealCount() > 0) && ((getRealCount() + 1) % 5 == 0)) {
      return 1;
    }
    return 2;
  }
  
  public final boolean aJc()
  {
    if (g.DP().isSDCardAvailable())
    {
      this.jdc = ((ArrayList)i.getEmojiStorageMgr().uBb.cwM());
      if (EmojiCustomUI.k(this.jcS) != EmojiCustomUI.c.jdf) {
        break label108;
      }
      if (EmojiCustomUI.l(this.jcS) != null) {
        break label94;
      }
    }
    label94:
    for (int i = 0;; i = EmojiCustomUI.l(this.jcS).size())
    {
      this.jcS.setMMTitle(this.jcS.getString(f.h.emoji_select_count, new Object[] { Integer.valueOf(i) }));
      return true;
      this.jdc = new ArrayList();
      break;
    }
    label108:
    this.jcS.setMMTitle(this.jcS.getString(f.h.emoji_custom_title, new Object[] { Integer.valueOf(this.jdc.size()) }));
    return true;
  }
  
  public final int getCount()
  {
    return getRealCount() + aJb();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getRealCount()
  {
    if (this.jdc == null) {
      return 0;
    }
    return this.jdc.size();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label51:
    int i;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.jcS.mController.uMN).inflate(f.f.emoji_custom_grid_item, null);
      paramView.setVisibility(0);
      paramViewGroup = new EmojiCustomUI.d(paramView);
      paramView.setTag(paramViewGroup);
      if ((EmojiCustomUI.k(this.jcS) != EmojiCustomUI.c.jdh) && (EmojiCustomUI.k(this.jcS) != EmojiCustomUI.c.jdf)) {
        break label178;
      }
      i = aJb();
      label83:
      if (paramInt >= getCount() - i) {
        break label202;
      }
      if (paramInt % 5 != 0) {
        break label189;
      }
      paramViewGroup.jdj.setBackgroundResource(f.d.emoji_grid_item_bottom);
    }
    for (;;)
    {
      paramViewGroup.jdk.clearAnimation();
      switch (EmojiCustomUI.11.jcX[EmojiCustomUI.k(this.jcS).ordinal()])
      {
      default: 
        return paramView;
        paramView.setVisibility(0);
        paramViewGroup = (EmojiCustomUI.d)paramView.getTag();
        break label51;
        label178:
        i = aJb() - 1;
        break label83;
        label189:
        paramViewGroup.jdj.setBackgroundResource(f.d.emoji_grid_item_middle);
        continue;
        label202:
        if (paramInt == getCount() - i) {
          paramViewGroup.jdj.setBackgroundResource(f.d.emoji_grid_item_left);
        } else {
          paramViewGroup.jdj.setBackgroundColor(0);
        }
        break;
      }
    }
    if (paramInt == getCount() - aJb() + 1)
    {
      o.ON().a("", paramViewGroup.jdk);
      paramViewGroup.jdk.setImageBitmap(null);
    }
    EmojiInfo localEmojiInfo;
    for (;;)
    {
      paramViewGroup.jdl.setVisibility(8);
      return paramView;
      if (paramInt == getRealCount())
      {
        o.ON().a("", paramViewGroup.jdk);
        paramViewGroup.jdk.setImageResource(f.g.emoji_add);
      }
      else
      {
        localEmojiInfo = (EmojiInfo)this.jdc.get(paramInt);
        a(paramViewGroup.jdk, localEmojiInfo);
      }
    }
    if (paramInt == getCount() - aJb() + 1)
    {
      o.ON().a("", paramViewGroup.jdk);
      paramViewGroup.jdk.setImageBitmap(null);
    }
    for (;;)
    {
      paramViewGroup.jdl.setVisibility(8);
      return paramView;
      if (paramInt == getRealCount())
      {
        o.ON().a("", paramViewGroup.jdk);
        paramViewGroup.jdk.setImageResource(f.d.progress_large_holo);
        paramViewGroup.jdk.startAnimation(this.jdd);
      }
      else
      {
        localEmojiInfo = (EmojiInfo)this.jdc.get(paramInt);
        a(paramViewGroup.jdk, localEmojiInfo);
      }
    }
    if (paramInt == getCount() - aJb() + 1)
    {
      o.ON().a("", paramViewGroup.jdk);
      paramViewGroup.jdk.setImageBitmap(null);
    }
    for (;;)
    {
      paramViewGroup.jdl.setVisibility(8);
      return paramView;
      if (paramInt == getRealCount())
      {
        o.ON().a("", paramViewGroup.jdk);
        paramViewGroup.jdk.setImageBitmap(null);
      }
      else
      {
        localEmojiInfo = (EmojiInfo)this.jdc.get(paramInt);
        a(paramViewGroup.jdk, localEmojiInfo);
        if (localEmojiInfo.field_catalog != EmojiGroupInfo.uCR)
        {
          paramViewGroup.jdl.setVisibility(0);
          paramViewGroup.jdl.setChecked(EmojiCustomUI.l(this.jcS).contains(localEmojiInfo.Wv()));
          return paramView;
          if (paramInt == getCount() - aJb() + 1)
          {
            o.ON().a("", paramViewGroup.jdk);
            paramViewGroup.jdk.setImageBitmap(null);
          }
          else if (paramInt == getRealCount())
          {
            o.ON().a("", paramViewGroup.jdk);
            paramViewGroup.jdk.setImageBitmap(null);
          }
          else
          {
            localEmojiInfo = (EmojiInfo)this.jdc.get(paramInt);
            a(paramViewGroup.jdk, localEmojiInfo);
          }
        }
      }
    }
  }
  
  public final EmojiInfo pW(int paramInt)
  {
    if (paramInt >= getRealCount()) {}
    while (this.jdc == null) {
      return null;
    }
    return (EmojiInfo)this.jdc.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.b
 * JD-Core Version:    0.7.0.1
 */