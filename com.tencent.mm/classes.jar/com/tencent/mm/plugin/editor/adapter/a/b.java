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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class b
  extends d
{
  private ImageView qOm;
  private int thumbWidth;
  
  public b(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181644);
    this.thumbWidth = 0;
    this.dKU.setVisibility(0);
    this.kmg.setVisibility(8);
    this.qOs.setVisibility(8);
    this.dKU.setTag(this);
    this.dKU.setOnClickListener(this.qOH);
    this.qOm = ((ImageView)paramView.findViewById(2131302585));
    this.qOm.setVisibility(8);
    this.thumbWidth = (j.mScreenWidth - (int)j.be(20.0F));
    AppMethodBeat.o(181644);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181645);
    Object localObject1 = ((h)parama).dUs;
    Object localObject2 = ((h)parama).qPL;
    if (!s.YS((String)localObject1)) {
      if (s.YS((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject1 = null;
        label54:
        this.dKU.setImageBitmap(null);
        localObject2 = this.dKU.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = -1;
        ((ViewGroup.LayoutParams)localObject2).height = -1;
        this.dKU.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (localObject1 == null) {
          break label150;
        }
        this.dKU.setImageBitmap((Bitmap)localObject1);
        label106:
        if (!parama.qPH) {
          break label209;
        }
        this.qOm.setVisibility(0);
      }
      for (;;)
      {
        super.a(parama, paramInt1, paramInt2);
        AppMethodBeat.o(181645);
        return;
        localObject1 = null;
        break;
        localObject1 = com.tencent.mm.plugin.editor.b.alI((String)localObject1);
        break label54;
        label150:
        this.dKU.setImageBitmap(null);
        localObject1 = this.dKU.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.thumbWidth;
        ((ViewGroup.LayoutParams)localObject1).height = this.thumbWidth;
        this.dKU.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.dKU.setBackgroundColor(Color.parseColor("#f6f6f6"));
        break label106;
        label209:
        this.qOm.setVisibility(8);
      }
    }
  }
  
  public final int cCY()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.b
 * JD-Core Version:    0.7.0.1
 */