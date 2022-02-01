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
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.i;

public final class h
  extends d
{
  public ImageView oPl;
  public MMPinProgressBtn oPm;
  public ImageView oPn;
  private ImageView oPo;
  
  public h(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181663);
    this.oPl = ((ImageView)paramView.findViewById(2131305196));
    this.oPm = ((MMPinProgressBtn)paramView.findViewById(2131306379));
    this.oPn = ((ImageView)paramView.findViewById(2131306398));
    this.oPl.setImageResource(2131691166);
    this.oPo = ((ImageView)paramView.findViewById(2131306355));
    this.iRV.setVisibility(8);
    this.oON.setVisibility(8);
    this.oPo.setVisibility(8);
    this.oOR.setTag(this);
    this.oOR.setOnClickListener(this.oPc);
    AppMethodBeat.o(181663);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181664);
    l locall = (l)parama;
    Object localObject3 = b.Xe(locall.thumbPath);
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = localObject3;
      if (i.eA(locall.dpK))
      {
        localObject3 = e.acS(locall.dpK);
        localObject1 = localObject3;
        if (localObject3 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (i.eA(locall.thumbPath)) {
          i.deleteFile(locall.thumbPath);
        }
        f.a((Bitmap)localObject3, 60, Bitmap.CompressFormat.JPEG, locall.thumbPath, false);
        localObject1 = localObject3;
        if (localObject1 == null) {
          break label194;
        }
        localObject3 = this.oPn.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = -1;
        ((ViewGroup.LayoutParams)localObject3).height = -1;
        this.oPn.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.oPn.setImageBitmap(localObject1);
        this.oPn.setBackground(null);
        if (!parama.oQc) {
          break label270;
        }
        this.oPo.setVisibility(0);
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
      Object localObject2 = this.oPn.getResources().getDisplayMetrics();
      float f = ((DisplayMetrics)localObject2).density;
      localObject3 = this.oPn.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = (((DisplayMetrics)localObject2).widthPixels - (int)(f * 40.0F + 0.5F));
      ((ViewGroup.LayoutParams)localObject3).height = (((ViewGroup.LayoutParams)localObject3).width * 52 / 68);
      this.oPn.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      continue;
      label270:
      this.oPo.setVisibility(8);
    }
  }
  
  public final int bZp()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.h
 * JD-Core Version:    0.7.0.1
 */