package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.protocal.protobuf.EmotionDonor;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.LinkedList;

public class DonorsAvatarView
  extends LinearLayout
{
  private int loN;
  private int loO;
  private int loP;
  private int loQ;
  private LinearLayout.LayoutParams loR;
  private int mMaxCount;
  
  public DonorsAvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(53567);
    init();
    AppMethodBeat.o(53567);
  }
  
  public DonorsAvatarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(53568);
    init();
    AppMethodBeat.o(53568);
  }
  
  private void init()
  {
    AppMethodBeat.i(53569);
    setOrientation(0);
    this.loN = com.tencent.mm.cb.a.gw(getContext());
    this.loO = com.tencent.mm.cb.a.ao(getContext(), 2131428356);
    this.loP = com.tencent.mm.cb.a.ao(getContext(), 2131427496);
    this.loQ = com.tencent.mm.cb.a.ao(getContext(), 2131427808);
    this.loR = new LinearLayout.LayoutParams(this.loO, this.loO);
    this.loR.leftMargin = this.loP;
    this.loR.rightMargin = this.loP;
    this.mMaxCount = ((this.loN - this.loQ * 2) / (this.loO + this.loP * 2));
    ab.i("MicroMsg.emoji.DonorsAvatarView", "max count:%d", new Object[] { Integer.valueOf(this.mMaxCount) });
    AppMethodBeat.o(53569);
  }
  
  public final void c(String paramString, LinkedList<EmotionDonor> paramLinkedList)
  {
    AppMethodBeat.i(53570);
    removeAllViews();
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      int i;
      int j;
      label39:
      ImageView localImageView;
      if (paramLinkedList.size() > this.mMaxCount)
      {
        i = this.mMaxCount;
        j = 0;
        if (j >= i) {
          break label187;
        }
        EmotionDonor localEmotionDonor = (EmotionDonor)paramLinkedList.get(j);
        if (localEmotionDonor != null)
        {
          localImageView = new ImageView(getContext());
          localImageView.setLayoutParams(this.loR);
          if (bo.isNullOrNil(localEmotionDonor.HeadUrl)) {
            break label143;
          }
          o.ahG().a(localEmotionDonor.HeadUrl, localImageView, g.k(paramString, localEmotionDonor.HeadUrl, new Object[0]));
        }
      }
      for (;;)
      {
        addView(localImageView);
        j += 1;
        break label39;
        i = paramLinkedList.size();
        break;
        try
        {
          label143:
          localImageView.setImageBitmap(BackwardSupportUtil.b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null)));
        }
        catch (IOException localIOException)
        {
          ab.printErrStackTrace("MicroMsg.emoji.DonorsAvatarView", localIOException, "", new Object[0]);
        }
      }
    }
    label187:
    AppMethodBeat.o(53570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView
 * JD-Core Version:    0.7.0.1
 */