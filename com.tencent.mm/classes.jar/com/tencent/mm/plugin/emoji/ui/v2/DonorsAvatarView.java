package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.protocal.protobuf.EmotionDonor;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.util.LinkedList;

public class DonorsAvatarView
  extends LinearLayout
{
  private int mMaxCount;
  private int pSH;
  private int pSI;
  private int pSJ;
  private int pSK;
  private LinearLayout.LayoutParams pSL;
  
  public DonorsAvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109130);
    init();
    AppMethodBeat.o(109130);
  }
  
  public DonorsAvatarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109131);
    init();
    AppMethodBeat.o(109131);
  }
  
  private void init()
  {
    AppMethodBeat.i(109132);
    setOrientation(0);
    this.pSH = com.tencent.mm.cb.a.iu(getContext());
    this.pSI = com.tencent.mm.cb.a.ax(getContext(), 2131166213);
    this.pSJ = com.tencent.mm.cb.a.ax(getContext(), 2131165187);
    this.pSK = com.tencent.mm.cb.a.ax(getContext(), 2131165516);
    this.pSL = new LinearLayout.LayoutParams(this.pSI, this.pSI);
    this.pSL.leftMargin = this.pSJ;
    this.pSL.rightMargin = this.pSJ;
    this.mMaxCount = ((this.pSH - this.pSK * 2) / (this.pSI + this.pSJ * 2));
    ae.i("MicroMsg.emoji.DonorsAvatarView", "max count:%d", new Object[] { Integer.valueOf(this.mMaxCount) });
    AppMethodBeat.o(109132);
  }
  
  public final void d(String paramString, LinkedList<EmotionDonor> paramLinkedList)
  {
    AppMethodBeat.i(109133);
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
          localImageView.setLayoutParams(this.pSL);
          if (bu.isNullOrNil(localEmotionDonor.HeadUrl)) {
            break label143;
          }
          q.aJb().a(localEmotionDonor.HeadUrl, localImageView, e.k(paramString, localEmotionDonor.HeadUrl, new Object[0]));
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
          localImageView.setImageBitmap(BackwardSupportUtil.b.b(ak.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null)));
        }
        catch (IOException localIOException)
        {
          ae.printErrStackTrace("MicroMsg.emoji.DonorsAvatarView", localIOException, "", new Object[0]);
        }
      }
    }
    label187:
    AppMethodBeat.o(109133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView
 * JD-Core Version:    0.7.0.1
 */