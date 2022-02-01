package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;

public final class pa
  extends ej
{
  TextView a;
  public pb.a b;
  private Context c;
  
  public pa(Context paramContext, TencentMapContext paramTencentMapContext)
  {
    AppMethodBeat.i(225552);
    this.c = paramContext;
    this.a = new mh(this.c, paramTencentMapContext);
    AppMethodBeat.o(225552);
  }
  
  private void a(pb.a parama)
  {
    this.b = parama;
  }
  
  private Bitmap e()
  {
    AppMethodBeat.i(225566);
    this.a.setTextSize(18.0F);
    this.a.setTextColor(-16777216);
    this.a.setText("鉴权失败,请检查你的key");
    Bitmap localBitmap = gv.a(this.a);
    AppMethodBeat.o(225566);
    return localBitmap;
  }
  
  public final void a(el.b paramb) {}
  
  public final boolean a(final ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(225614);
    if ((paramViewGroup == null) || (this.a == null))
    {
      AppMethodBeat.o(225614);
      return false;
    }
    paramBundle = new FrameLayout.LayoutParams(-2, -2);
    paramBundle.gravity = 17;
    this.a.setLayoutParams(paramBundle);
    int i = paramViewGroup.getMeasuredWidth();
    int j = paramViewGroup.getMeasuredHeight();
    this.a.setTextSize(18.0F);
    this.a.setTextColor(-16777216);
    this.a.setText("鉴权失败,请检查你的key");
    paramBundle = gv.a(this.a);
    jw.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226211);
        paramViewGroup.addView(pa.this.a);
        AppMethodBeat.o(226211);
      }
    });
    if (this.b != null) {
      this.b.a(paramBundle, i, j);
    }
    AppMethodBeat.o(225614);
    return true;
  }
  
  public final void b(int paramInt1, int paramInt2) {}
  
  public final View[] b()
  {
    return new View[0];
  }
  
  public final void c() {}
  
  public final el.b d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pa
 * JD-Core Version:    0.7.0.1
 */