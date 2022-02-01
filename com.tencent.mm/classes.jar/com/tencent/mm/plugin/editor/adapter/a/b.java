package com.tencent.mm.plugin.editor.adapter.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.a.h;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class b
  extends d
{
  private ImageView psp;
  private int thumbWidth;
  
  public b(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181644);
    this.thumbWidth = 0;
    this.dsD.setVisibility(0);
    this.jld.setVisibility(8);
    this.psv.setVisibility(8);
    this.dsD.setTag(this);
    this.dsD.setOnClickListener(this.psK);
    this.psp = ((ImageView)paramView.findViewById(2131300952));
    this.psp.setVisibility(8);
    this.thumbWidth = (j.mScreenWidth - (int)j.aX(20.0F));
    AppMethodBeat.o(181644);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181645);
    Object localObject1 = ((h)parama).dBx;
    Object localObject2 = ((h)parama).ptQ;
    if (!i.fv((String)localObject1)) {
      if (i.fv((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (bt.isNullOrNil((String)localObject1))
      {
        localObject1 = null;
        label54:
        this.dsD.setImageBitmap(null);
        localObject2 = this.dsD.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = -1;
        ((ViewGroup.LayoutParams)localObject2).height = -1;
        this.dsD.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (localObject1 == null) {
          break label150;
        }
        this.dsD.setImageBitmap((Bitmap)localObject1);
        label106:
        if (!parama.ptM) {
          break label209;
        }
        this.psp.setVisibility(0);
      }
      for (;;)
      {
        super.a(parama, paramInt1, paramInt2);
        AppMethodBeat.o(181645);
        return;
        localObject1 = null;
        break;
        localObject1 = com.tencent.mm.plugin.editor.b.aaL((String)localObject1);
        break label54;
        label150:
        this.dsD.setImageBitmap(null);
        localObject1 = this.dsD.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.thumbWidth;
        ((ViewGroup.LayoutParams)localObject1).height = this.thumbWidth;
        this.dsD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.dsD.setBackgroundColor(Color.parseColor("#f6f6f6"));
        break label106;
        label209:
        this.psp.setVisibility(8);
      }
    }
  }
  
  public final int cdT()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.b
 * JD-Core Version:    0.7.0.1
 */