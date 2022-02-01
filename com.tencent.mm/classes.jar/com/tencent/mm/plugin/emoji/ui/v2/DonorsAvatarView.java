package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.mgr.e;
import com.tencent.mm.protocal.protobuf.cix;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.LinkedList;

public class DonorsAvatarView
  extends LinearLayout
{
  private int sfk;
  private LinearLayout.LayoutParams xVA;
  private int xVw;
  private int xVx;
  private int xVy;
  private int xVz;
  
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
    this.xVw = com.tencent.mm.cd.a.ms(getContext());
    this.xVx = com.tencent.mm.cd.a.br(getContext(), h.c.emoji_donors_avatar_size);
    this.xVy = com.tencent.mm.cd.a.br(getContext(), h.c.BasicPaddingSize);
    this.xVz = com.tencent.mm.cd.a.br(getContext(), h.c.NormalPadding);
    this.xVA = new LinearLayout.LayoutParams(this.xVx, this.xVx);
    this.xVA.leftMargin = this.xVy;
    this.xVA.rightMargin = this.xVy;
    this.sfk = ((this.xVw - this.xVz * 2) / (this.xVx + this.xVy * 2));
    Log.i("MicroMsg.emoji.DonorsAvatarView", "max count:%d", new Object[] { Integer.valueOf(this.sfk) });
    AppMethodBeat.o(109132);
  }
  
  public final void d(String paramString, LinkedList<cix> paramLinkedList)
  {
    AppMethodBeat.i(109133);
    removeAllViews();
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      int i;
      int j;
      label39:
      ImageView localImageView;
      if (paramLinkedList.size() > this.sfk)
      {
        i = this.sfk;
        j = 0;
        if (j >= i) {
          break label187;
        }
        cix localcix = (cix)paramLinkedList.get(j);
        if (localcix != null)
        {
          localImageView = new ImageView(getContext());
          localImageView.setLayoutParams(this.xVA);
          if (Util.isNullOrNil(localcix.ZuK)) {
            break label143;
          }
          r.bKe().a(localcix.ZuK, localImageView, e.n(paramString, localcix.ZuK, new Object[0]));
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
          localImageView.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cd.a.getDensity(null)));
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.emoji.DonorsAvatarView", localIOException, "", new Object[0]);
        }
      }
    }
    label187:
    AppMethodBeat.o(109133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView
 * JD-Core Version:    0.7.0.1
 */