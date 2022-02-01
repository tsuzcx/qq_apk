package com.tencent.mm.plugin.editor.adapter.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.d.e;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.a.h;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class b
  extends d
{
  private int thumbWidth;
  private ImageView xwN;
  
  public b(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181644);
    this.thumbWidth = 0;
    this.hIz.setVisibility(0);
    this.pZr.setVisibility(8);
    this.xwT.setVisibility(8);
    this.hIz.setTag(this);
    this.hIz.setOnClickListener(this.xxi);
    this.xwN = ((ImageView)paramView.findViewById(d.e.image_mask));
    this.xwN.setVisibility(8);
    this.thumbWidth = (j.mScreenWidth - (int)j.cg(20.0F));
    AppMethodBeat.o(181644);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181645);
    Object localObject1 = ((h)parama).hTM;
    Object localObject2 = ((h)parama).xym;
    if (!y.ZC((String)localObject1)) {
      if (y.ZC((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject1 = null;
        label54:
        this.hIz.setImageBitmap(null);
        localObject2 = this.hIz.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = -1;
        ((ViewGroup.LayoutParams)localObject2).height = -1;
        this.hIz.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (localObject1 == null) {
          break label150;
        }
        this.hIz.setImageBitmap((Bitmap)localObject1);
        label106:
        if (!parama.xyi) {
          break label209;
        }
        this.xwN.setVisibility(0);
      }
      for (;;)
      {
        super.a(parama, paramInt1, paramInt2);
        AppMethodBeat.o(181645);
        return;
        localObject1 = null;
        break;
        localObject1 = com.tencent.mm.plugin.editor.b.anq((String)localObject1);
        break label54;
        label150:
        this.hIz.setImageBitmap(null);
        localObject1 = this.hIz.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.thumbWidth;
        ((ViewGroup.LayoutParams)localObject1).height = this.thumbWidth;
        this.hIz.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.hIz.setBackgroundColor(Color.parseColor("#f6f6f6"));
        break label106;
        label209:
        this.xwN.setVisibility(8);
      }
    }
  }
  
  public final int dvW()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.b
 * JD-Core Version:    0.7.0.1
 */