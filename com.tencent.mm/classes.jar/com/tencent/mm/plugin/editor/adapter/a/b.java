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
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class b
  extends d
{
  private ImageView oOH;
  private int thumbWidth;
  
  public b(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181644);
    this.thumbWidth = 0;
    this.dhf.setVisibility(0);
    this.iRV.setVisibility(8);
    this.oON.setVisibility(8);
    this.dhf.setTag(this);
    this.dhf.setOnClickListener(this.oPc);
    this.oOH = ((ImageView)paramView.findViewById(2131300952));
    this.oOH.setVisibility(8);
    this.thumbWidth = (j.mScreenWidth - (int)j.aU(20.0F));
    AppMethodBeat.o(181644);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181645);
    Object localObject1 = ((h)parama).dpK;
    Object localObject2 = ((h)parama).oQg;
    if (!i.eA((String)localObject1)) {
      if (i.eA((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (bs.isNullOrNil((String)localObject1))
      {
        localObject1 = null;
        label54:
        this.dhf.setImageBitmap(null);
        localObject2 = this.dhf.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = -1;
        ((ViewGroup.LayoutParams)localObject2).height = -1;
        this.dhf.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (localObject1 == null) {
          break label150;
        }
        this.dhf.setImageBitmap((Bitmap)localObject1);
        label106:
        if (!parama.oQc) {
          break label209;
        }
        this.oOH.setVisibility(0);
      }
      for (;;)
      {
        super.a(parama, paramInt1, paramInt2);
        AppMethodBeat.o(181645);
        return;
        localObject1 = null;
        break;
        localObject1 = com.tencent.mm.plugin.editor.b.Xe((String)localObject1);
        break label54;
        label150:
        this.dhf.setImageBitmap(null);
        localObject1 = this.dhf.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.thumbWidth;
        ((ViewGroup.LayoutParams)localObject1).height = this.thumbWidth;
        this.dhf.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.dhf.setBackgroundColor(Color.parseColor("#f6f6f6"));
        break label106;
        label209:
        this.oOH.setVisibility(8);
      }
    }
  }
  
  public final int bZp()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.b
 * JD-Core Version:    0.7.0.1
 */