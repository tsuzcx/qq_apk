package com.tencent.mm.plugin.editor.adapter.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.b;
import com.tencent.mm.plugin.editor.d.e;
import com.tencent.mm.plugin.editor.d.g;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.u;

public final class h
  extends d
{
  public ImageView uqU;
  public MMPinProgressBtn uqV;
  public ImageView uqW;
  private ImageView uqX;
  
  public h(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181663);
    this.uqU = ((ImageView)paramView.findViewById(d.e.status_btn));
    this.uqV = ((MMPinProgressBtn)paramView.findViewById(d.e.video_progress));
    this.uqW = ((ImageView)paramView.findViewById(d.e.video_thumb));
    this.uqU.setImageResource(d.g.shortvideo_play_btn);
    this.uqX = ((ImageView)paramView.findViewById(d.e.video_mask));
    this.ndX.setVisibility(8);
    this.uqw.setVisibility(8);
    this.uqX.setVisibility(8);
    this.uqA.setTag(this);
    this.uqA.setOnClickListener(this.uqL);
    AppMethodBeat.o(181663);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181664);
    l locall = (l)parama;
    Object localObject3 = b.atB(locall.thumbPath);
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = localObject3;
      if (u.agG(locall.fNU))
      {
        localObject3 = e.aAn(locall.fNU);
        localObject1 = localObject3;
        if (localObject3 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (u.agG(locall.thumbPath)) {
          u.deleteFile(locall.thumbPath);
        }
        BitmapUtil.saveBitmapToImage((Bitmap)localObject3, 60, Bitmap.CompressFormat.JPEG, locall.thumbPath, false);
        localObject1 = localObject3;
        if (localObject1 == null) {
          break label194;
        }
        localObject3 = this.uqW.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = -1;
        ((ViewGroup.LayoutParams)localObject3).height = -1;
        this.uqW.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.uqW.setImageBitmap(localObject1);
        this.uqW.setBackground(null);
        if (!parama.urN) {
          break label270;
        }
        this.uqX.setVisibility(0);
        super.a(parama, paramInt1, paramInt2);
        AppMethodBeat.o(181664);
        return;
      }
      catch (Exception localException)
      {
        localObject2 = localObject3;
      }
      continue;
      label194:
      Object localObject2 = this.uqW.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject2).density;
      localObject3 = this.uqW.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = (((DisplayMetrics)localObject2).widthPixels - (int)(f * 40.0F + 0.5F));
      ((ViewGroup.LayoutParams)localObject3).height = (((ViewGroup.LayoutParams)localObject3).width * 52 / 68);
      this.uqW.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      continue;
      label270:
      this.uqX.setVisibility(8);
    }
  }
  
  public final int cRD()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.h
 * JD-Core Version:    0.7.0.1
 */