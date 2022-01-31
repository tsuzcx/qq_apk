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
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

final class EmojiCustomUI$b
  extends BaseAdapter
{
  private int exE;
  private ArrayList<EmojiInfo> lin;
  private Animation llP;
  
  public EmojiCustomUI$b(EmojiCustomUI paramEmojiCustomUI, int paramInt)
  {
    AppMethodBeat.i(53322);
    this.exE = paramInt;
    this.llP = AnimationUtils.loadAnimation(paramEmojiCustomUI, 2131034243);
    paramEmojiCustomUI = new LinearInterpolator();
    this.llP.setInterpolator(paramEmojiCustomUI);
    AppMethodBeat.o(53322);
  }
  
  private static void a(ImageView paramImageView, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(53329);
    a locala = a.evk;
    a.a(paramEmojiInfo, paramImageView);
    AppMethodBeat.o(53329);
  }
  
  private int bmB()
  {
    AppMethodBeat.i(53324);
    if ((getRealCount() > 0) && ((getRealCount() + 1) % 5 == 0))
    {
      AppMethodBeat.o(53324);
      return 1;
    }
    AppMethodBeat.o(53324);
    return 2;
  }
  
  public final boolean bmC()
  {
    AppMethodBeat.i(53328);
    int i;
    if (g.RL().isSDCardAvailable()) {
      if (this.exE == 0)
      {
        this.lin = ((ArrayList)i.getEmojiStorageMgr().yNn.pU(false));
        if (EmojiCustomUI.m(this.llF) != EmojiCustomUI.c.llR) {
          break label139;
        }
        if (EmojiCustomUI.n(this.llF) != null) {
          break label125;
        }
        i = 0;
        label63:
        this.llF.setMMTitle(this.llF.getString(2131299170, new Object[] { Integer.valueOf(i) }));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(53328);
      return true;
      this.lin = com.tencent.mm.emoji.a.d.Oz().ci(false);
      break;
      this.lin = new ArrayList();
      break;
      label125:
      i = EmojiCustomUI.n(this.llF).size();
      break label63;
      label139:
      if (this.exE == 0) {
        this.llF.setMMTitle(this.llF.getString(2131299131, new Object[] { Integer.valueOf(this.lin.size()) }));
      } else {
        this.llF.setMMTitle(this.llF.getString(2131299113, new Object[] { Integer.valueOf(this.lin.size()) }));
      }
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(53323);
    int i = getRealCount();
    int j = bmB();
    AppMethodBeat.o(53323);
    return i + j;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getRealCount()
  {
    AppMethodBeat.i(53325);
    if (this.lin == null)
    {
      AppMethodBeat.o(53325);
      return 0;
    }
    int i = this.lin.size();
    AppMethodBeat.o(53325);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(53327);
    label52:
    int i;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.llF.getContext()).inflate(2130969366, null);
      paramView.setVisibility(0);
      paramViewGroup = new EmojiCustomUI.d(paramView);
      paramView.setTag(paramViewGroup);
      if ((EmojiCustomUI.m(this.llF) != EmojiCustomUI.c.llT) && (EmojiCustomUI.m(this.llF) != EmojiCustomUI.c.llR)) {
        break label195;
      }
      i = bmB();
      label84:
      if (paramInt >= getCount() - i) {
        break label235;
      }
      if (paramInt % 5 != 0) {
        break label223;
      }
      paramViewGroup.iDS.setBackgroundResource(2130838617);
    }
    for (;;)
    {
      paramViewGroup.image.clearAnimation();
      paramViewGroup.image.setScaleType(ImageView.ScaleType.FIT_CENTER);
      switch (EmojiCustomUI.11.llK[EmojiCustomUI.m(this.llF).ordinal()])
      {
      default: 
        AppMethodBeat.o(53327);
        return paramView;
        paramView.setVisibility(0);
        paramViewGroup = (EmojiCustomUI.d)paramView.getTag();
        break label52;
        label195:
        if (1 == this.exE)
        {
          i = bmB();
          break label84;
        }
        i = bmB() - 1;
        break label84;
        label223:
        paramViewGroup.iDS.setBackgroundResource(2130838622);
        continue;
        label235:
        if (paramInt == getCount() - i) {
          paramViewGroup.iDS.setBackgroundResource(2130838621);
        } else {
          paramViewGroup.iDS.setBackgroundColor(0);
        }
        break;
      }
    }
    Object localObject;
    if (paramInt == getCount() - bmB() + 1)
    {
      localObject = a.evk;
      a.ck(paramViewGroup.image);
      paramViewGroup.image.setImageBitmap(null);
    }
    for (;;)
    {
      paramViewGroup.llV.setVisibility(8);
      break;
      if (paramInt == 0)
      {
        if (this.exE == 0)
        {
          localObject = a.evk;
          a.ck(paramViewGroup.image);
          paramViewGroup.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          paramViewGroup.image.setImageResource(2131231256);
        }
        else if (paramInt != getRealCount())
        {
          localObject = (EmojiInfo)this.lin.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
      }
      else if (this.exE == 0)
      {
        localObject = (EmojiInfo)this.lin.get(paramInt - 1);
        a(paramViewGroup.image, (EmojiInfo)localObject);
      }
      else if (paramInt != getRealCount())
      {
        localObject = (EmojiInfo)this.lin.get(paramInt);
        a(paramViewGroup.image, (EmojiInfo)localObject);
      }
      else
      {
        localObject = a.evk;
        a.ck(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
    }
    if (paramInt == getCount() - bmB() + 1)
    {
      localObject = a.evk;
      a.ck(paramViewGroup.image);
      paramViewGroup.image.setImageBitmap(null);
    }
    for (;;)
    {
      paramViewGroup.llV.setVisibility(8);
      break;
      if (paramInt == getRealCount())
      {
        localObject = a.evk;
        a.ck(paramViewGroup.image);
        paramViewGroup.image.setImageResource(2130840005);
        paramViewGroup.image.startAnimation(this.llP);
      }
      else
      {
        localObject = (EmojiInfo)this.lin.get(paramInt);
        a(paramViewGroup.image, (EmojiInfo)localObject);
      }
    }
    if (paramInt == getCount() - bmB() + 1)
    {
      localObject = a.evk;
      a.ck(paramViewGroup.image);
      paramViewGroup.image.setImageBitmap(null);
    }
    for (;;)
    {
      paramViewGroup.llV.setVisibility(8);
      break;
      if (paramInt == getRealCount())
      {
        localObject = a.evk;
        a.ck(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      else
      {
        localObject = (EmojiInfo)this.lin.get(paramInt);
        a(paramViewGroup.image, (EmojiInfo)localObject);
        if (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.yPe)
        {
          paramViewGroup.llV.setVisibility(0);
          paramViewGroup.llV.setChecked(EmojiCustomUI.n(this.llF).contains(((EmojiInfo)localObject).Al()));
          break;
          if (paramInt == getCount() - bmB() + 1)
          {
            localObject = a.evk;
            a.ck(paramViewGroup.image);
            paramViewGroup.image.setImageBitmap(null);
          }
          else if (paramInt == getRealCount())
          {
            localObject = a.evk;
            a.ck(paramViewGroup.image);
            paramViewGroup.image.setImageBitmap(null);
          }
          else
          {
            localObject = (EmojiInfo)this.lin.get(paramInt);
            a(paramViewGroup.image, (EmojiInfo)localObject);
          }
        }
      }
    }
  }
  
  public final EmojiInfo ur(int paramInt)
  {
    AppMethodBeat.i(53326);
    if (paramInt >= getRealCount())
    {
      AppMethodBeat.o(53326);
      return null;
    }
    if (this.lin == null)
    {
      AppMethodBeat.o(53326);
      return null;
    }
    EmojiInfo localEmojiInfo = (EmojiInfo)this.lin.get(paramInt);
    AppMethodBeat.o(53326);
    return localEmojiInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.b
 * JD-Core Version:    0.7.0.1
 */