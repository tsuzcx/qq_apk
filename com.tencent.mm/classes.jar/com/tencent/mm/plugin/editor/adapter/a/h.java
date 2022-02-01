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
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.o;

public final class h
  extends d
{
  public MMPinProgressBtn pzA;
  public ImageView pzB;
  private ImageView pzC;
  public ImageView pzz;
  
  public h(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181663);
    this.pzz = ((ImageView)paramView.findViewById(2131305196));
    this.pzA = ((MMPinProgressBtn)paramView.findViewById(2131306379));
    this.pzB = ((ImageView)paramView.findViewById(2131306398));
    this.pzz.setImageResource(2131691166);
    this.pzC = ((ImageView)paramView.findViewById(2131306355));
    this.jnX.setVisibility(8);
    this.pzb.setVisibility(8);
    this.pzC.setVisibility(8);
    this.pzf.setTag(this);
    this.pzf.setOnClickListener(this.pzq);
    AppMethodBeat.o(181663);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181664);
    l locall = (l)parama;
    Object localObject3 = b.abC(locall.thumbPath);
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = localObject3;
      if (o.fB(locall.dCC))
      {
        localObject3 = e.ahE(locall.dCC);
        localObject1 = localObject3;
        if (localObject3 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (o.fB(locall.thumbPath)) {
          o.deleteFile(locall.thumbPath);
        }
        com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject3, 60, Bitmap.CompressFormat.JPEG, locall.thumbPath, false);
        localObject1 = localObject3;
        if (localObject1 == null) {
          break label194;
        }
        localObject3 = this.pzB.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = -1;
        ((ViewGroup.LayoutParams)localObject3).height = -1;
        this.pzB.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.pzB.setImageBitmap(localObject1);
        this.pzB.setBackground(null);
        if (!parama.pAq) {
          break label270;
        }
        this.pzC.setVisibility(0);
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
      Object localObject2 = this.pzB.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject2).density;
      localObject3 = this.pzB.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = (((DisplayMetrics)localObject2).widthPixels - (int)(f * 40.0F + 0.5F));
      ((ViewGroup.LayoutParams)localObject3).height = (((ViewGroup.LayoutParams)localObject3).width * 52 / 68);
      this.pzB.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      continue;
      label270:
      this.pzC.setVisibility(8);
    }
  }
  
  public final int cfi()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.h
 * JD-Core Version:    0.7.0.1
 */