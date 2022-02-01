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
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.s;

public final class h
  extends d
{
  public ImageView qOQ;
  public MMPinProgressBtn qOR;
  public ImageView qOS;
  private ImageView qOT;
  
  public h(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181663);
    this.qOQ = ((ImageView)paramView.findViewById(2131308392));
    this.qOR = ((MMPinProgressBtn)paramView.findViewById(2131309808));
    this.qOS = ((ImageView)paramView.findViewById(2131309829));
    this.qOQ.setImageResource(2131691480);
    this.qOT = ((ImageView)paramView.findViewById(2131309781));
    this.kmg.setVisibility(8);
    this.qOs.setVisibility(8);
    this.qOT.setVisibility(8);
    this.qOw.setTag(this);
    this.qOw.setOnClickListener(this.qOH);
    AppMethodBeat.o(181663);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181664);
    l locall = (l)parama;
    Object localObject3 = b.alI(locall.thumbPath);
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = localObject3;
      if (s.YS(locall.dUs))
      {
        localObject3 = e.asm(locall.dUs);
        localObject1 = localObject3;
        if (localObject3 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (s.YS(locall.thumbPath)) {
          s.deleteFile(locall.thumbPath);
        }
        BitmapUtil.saveBitmapToImage((Bitmap)localObject3, 60, Bitmap.CompressFormat.JPEG, locall.thumbPath, false);
        localObject1 = localObject3;
        if (localObject1 == null) {
          break label194;
        }
        localObject3 = this.qOS.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = -1;
        ((ViewGroup.LayoutParams)localObject3).height = -1;
        this.qOS.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.qOS.setImageBitmap(localObject1);
        this.qOS.setBackground(null);
        if (!parama.qPH) {
          break label270;
        }
        this.qOT.setVisibility(0);
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
      Object localObject2 = this.qOS.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject2).density;
      localObject3 = this.qOS.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = (((DisplayMetrics)localObject2).widthPixels - (int)(f * 40.0F + 0.5F));
      ((ViewGroup.LayoutParams)localObject3).height = (((ViewGroup.LayoutParams)localObject3).width * 52 / 68);
      this.qOS.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      continue;
      label270:
      this.qOT.setVisibility(8);
    }
  }
  
  public final int cCY()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.h
 * JD-Core Version:    0.7.0.1
 */