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
import com.tencent.mm.vfs.u;

public final class b
  extends d
{
  private int thumbWidth;
  private ImageView uqq;
  
  public b(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181644);
    this.thumbWidth = 0;
    this.fDJ.setVisibility(0);
    this.ndX.setVisibility(8);
    this.uqw.setVisibility(8);
    this.fDJ.setTag(this);
    this.fDJ.setOnClickListener(this.uqL);
    this.uqq = ((ImageView)paramView.findViewById(d.e.image_mask));
    this.uqq.setVisibility(8);
    this.thumbWidth = (j.mScreenWidth - (int)j.bd(20.0F));
    AppMethodBeat.o(181644);
  }
  
  public final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181645);
    Object localObject1 = ((h)parama).fNU;
    Object localObject2 = ((h)parama).urR;
    if (!u.agG((String)localObject1)) {
      if (u.agG((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject1 = null;
        label54:
        this.fDJ.setImageBitmap(null);
        localObject2 = this.fDJ.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = -1;
        ((ViewGroup.LayoutParams)localObject2).height = -1;
        this.fDJ.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (localObject1 == null) {
          break label150;
        }
        this.fDJ.setImageBitmap((Bitmap)localObject1);
        label106:
        if (!parama.urN) {
          break label209;
        }
        this.uqq.setVisibility(0);
      }
      for (;;)
      {
        super.a(parama, paramInt1, paramInt2);
        AppMethodBeat.o(181645);
        return;
        localObject1 = null;
        break;
        localObject1 = com.tencent.mm.plugin.editor.b.atB((String)localObject1);
        break label54;
        label150:
        this.fDJ.setImageBitmap(null);
        localObject1 = this.fDJ.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.thumbWidth;
        ((ViewGroup.LayoutParams)localObject1).height = this.thumbWidth;
        this.fDJ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.fDJ.setBackgroundColor(Color.parseColor("#f6f6f6"));
        break label106;
        label209:
        this.uqq.setVisibility(8);
      }
    }
  }
  
  public final int cRD()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.b
 * JD-Core Version:    0.7.0.1
 */