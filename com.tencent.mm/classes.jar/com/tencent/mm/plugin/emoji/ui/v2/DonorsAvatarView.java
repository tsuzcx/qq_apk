package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.LinkedList;

public class DonorsAvatarView
  extends LinearLayout
{
  private int jfU;
  private int jfV;
  private int jfW;
  private int jfX;
  private LinearLayout.LayoutParams jfY;
  private int mMaxCount;
  
  public DonorsAvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public DonorsAvatarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setOrientation(0);
    this.jfU = com.tencent.mm.cb.a.fj(getContext());
    this.jfV = com.tencent.mm.cb.a.aa(getContext(), f.c.emoji_donors_avatar_size);
    this.jfW = com.tencent.mm.cb.a.aa(getContext(), f.c.BasicPaddingSize);
    this.jfX = com.tencent.mm.cb.a.aa(getContext(), f.c.NormalPadding);
    this.jfY = new LinearLayout.LayoutParams(this.jfV, this.jfV);
    this.jfY.leftMargin = this.jfW;
    this.jfY.rightMargin = this.jfW;
    this.mMaxCount = ((this.jfU - this.jfX * 2) / (this.jfV + this.jfW * 2));
    y.i("MicroMsg.emoji.DonorsAvatarView", "max count:%d", new Object[] { Integer.valueOf(this.mMaxCount) });
  }
  
  public final void c(String paramString, LinkedList<vk> paramLinkedList)
  {
    removeAllViews();
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      int i;
      int j;
      label34:
      ImageView localImageView;
      if (paramLinkedList.size() > this.mMaxCount)
      {
        i = this.mMaxCount;
        j = 0;
        if (j >= i) {
          return;
        }
        vk localvk = (vk)paramLinkedList.get(j);
        if (localvk != null)
        {
          localImageView = new ImageView(getContext());
          localImageView.setLayoutParams(this.jfY);
          if (bk.bl(localvk.sSy)) {
            break label138;
          }
          o.ON().a(localvk.sSy, localImageView, e.k(paramString, localvk.sSy, new Object[0]));
        }
      }
      for (;;)
      {
        addView(localImageView);
        j += 1;
        break label34;
        i = paramLinkedList.size();
        break;
        try
        {
          label138:
          localImageView.setImageBitmap(BackwardSupportUtil.b.a(ae.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null)));
        }
        catch (IOException localIOException)
        {
          y.printErrStackTrace("MicroMsg.emoji.DonorsAvatarView", localIOException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView
 * JD-Core Version:    0.7.0.1
 */