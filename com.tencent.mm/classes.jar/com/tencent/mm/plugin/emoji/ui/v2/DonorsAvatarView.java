package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.protocal.protobuf.EmotionDonor;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.LinkedList;

public class DonorsAvatarView
  extends LinearLayout
{
  private int mMaxCount;
  private int oFb;
  private int oFc;
  private int oFd;
  private int oFe;
  private LinearLayout.LayoutParams oFf;
  
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
    this.oFb = com.tencent.mm.cd.a.hV(getContext());
    this.oFc = com.tencent.mm.cd.a.ao(getContext(), 2131166213);
    this.oFd = com.tencent.mm.cd.a.ao(getContext(), 2131165187);
    this.oFe = com.tencent.mm.cd.a.ao(getContext(), 2131165516);
    this.oFf = new LinearLayout.LayoutParams(this.oFc, this.oFc);
    this.oFf.leftMargin = this.oFd;
    this.oFf.rightMargin = this.oFd;
    this.mMaxCount = ((this.oFb - this.oFe * 2) / (this.oFc + this.oFd * 2));
    ad.i("MicroMsg.emoji.DonorsAvatarView", "max count:%d", new Object[] { Integer.valueOf(this.mMaxCount) });
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
          localImageView.setLayoutParams(this.oFf);
          if (bt.isNullOrNil(localEmotionDonor.HeadUrl)) {
            break label143;
          }
          o.ayJ().a(localEmotionDonor.HeadUrl, localImageView, e.k(paramString, localEmotionDonor.HeadUrl, new Object[0]));
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
          localImageView.setImageBitmap(BackwardSupportUtil.b.b(aj.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cd.a.getDensity(null)));
        }
        catch (IOException localIOException)
        {
          ad.printErrStackTrace("MicroMsg.emoji.DonorsAvatarView", localIOException, "", new Object[0]);
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