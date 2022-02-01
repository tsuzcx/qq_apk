package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.i.c;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.LinkedList;

public class DonorsAvatarView
  extends LinearLayout
{
  private int mMaxCount;
  private int uMT;
  private int uMU;
  private int uMV;
  private int uMW;
  private LinearLayout.LayoutParams uMX;
  
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
    this.uMT = com.tencent.mm.ci.a.kr(getContext());
    this.uMU = com.tencent.mm.ci.a.aY(getContext(), i.c.emoji_donors_avatar_size);
    this.uMV = com.tencent.mm.ci.a.aY(getContext(), i.c.BasicPaddingSize);
    this.uMW = com.tencent.mm.ci.a.aY(getContext(), i.c.NormalPadding);
    this.uMX = new LinearLayout.LayoutParams(this.uMU, this.uMU);
    this.uMX.leftMargin = this.uMV;
    this.uMX.rightMargin = this.uMV;
    this.mMaxCount = ((this.uMT - this.uMW * 2) / (this.uMU + this.uMV * 2));
    Log.i("MicroMsg.emoji.DonorsAvatarView", "max count:%d", new Object[] { Integer.valueOf(this.mMaxCount) });
    AppMethodBeat.o(109132);
  }
  
  public final void d(String paramString, LinkedList<akc> paramLinkedList)
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
        akc localakc = (akc)paramLinkedList.get(j);
        if (localakc != null)
        {
          localImageView = new ImageView(getContext());
          localImageView.setLayoutParams(this.uMX);
          if (Util.isNullOrNil(localakc.SuR)) {
            break label143;
          }
          q.bml().a(localakc.SuR, localImageView, e.m(paramString, localakc.SuR, new Object[0]));
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
          localImageView.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.ci.a.getDensity(null)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView
 * JD-Core Version:    0.7.0.1
 */