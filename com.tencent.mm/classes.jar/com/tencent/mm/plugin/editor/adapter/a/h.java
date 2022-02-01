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
import com.tencent.mm.vfs.y;

public final class h
  extends d
{
  public ImageView xxr;
  public MMPinProgressBtn xxs;
  public ImageView xxt;
  private ImageView xxu;
  
  public h(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181663);
    this.xxr = ((ImageView)paramView.findViewById(d.e.status_btn));
    this.xxs = ((MMPinProgressBtn)paramView.findViewById(d.e.video_progress));
    this.xxt = ((ImageView)paramView.findViewById(d.e.video_thumb));
    this.xxr.setImageResource(d.g.shortvideo_play_btn);
    this.xxu = ((ImageView)paramView.findViewById(d.e.video_mask));
    this.pZr.setVisibility(8);
    this.xwT.setVisibility(8);
    this.xxu.setVisibility(8);
    this.xwX.setTag(this);
    this.xwX.setOnClickListener(this.xxi);
    AppMethodBeat.o(181663);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181664);
    l locall = (l)parama;
    Object localObject3 = b.anq(locall.thumbPath);
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = localObject3;
      if (y.ZC(locall.hTM))
      {
        localObject3 = e.auu(locall.hTM);
        localObject1 = localObject3;
        if (localObject3 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (y.ZC(locall.thumbPath)) {
          y.deleteFile(locall.thumbPath);
        }
        BitmapUtil.saveBitmapToImage((Bitmap)localObject3, 60, Bitmap.CompressFormat.JPEG, locall.thumbPath, false);
        localObject1 = localObject3;
        if (localObject1 == null) {
          break label194;
        }
        localObject3 = this.xxt.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = -1;
        ((ViewGroup.LayoutParams)localObject3).height = -1;
        this.xxt.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.xxt.setImageBitmap(localObject1);
        this.xxt.setBackground(null);
        if (!parama.xyi) {
          break label270;
        }
        this.xxu.setVisibility(0);
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
      Object localObject2 = this.xxt.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject2).density;
      localObject3 = this.xxt.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = (((DisplayMetrics)localObject2).widthPixels - (int)(f * 40.0F + 0.5F));
      ((ViewGroup.LayoutParams)localObject3).height = (((ViewGroup.LayoutParams)localObject3).width * 52 / 68);
      this.xxt.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      continue;
      label270:
      this.xxu.setVisibility(8);
    }
  }
  
  public final int dvW()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.h
 * JD-Core Version:    0.7.0.1
 */