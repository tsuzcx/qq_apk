package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.support.v4.view.n;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;

final class GameGalleryUI$a
  extends n
{
  private String[] lbL = new String[0];
  private View[] lbM;
  Context mContext;
  
  public GameGalleryUI$a(Context paramContext, String[] paramArrayOfString)
  {
    this.mContext = paramContext;
    if (paramArrayOfString != null) {
      this.lbL = paramArrayOfString;
    }
    this.lbM = new View[this.lbL.length];
  }
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public final Object b(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = this.lbM[paramInt];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = View.inflate(this.mContext, g.f.game_gallery_item, null);
      this.lbM[paramInt] = localObject1;
      localObject2 = (ImageView)((View)localObject1).findViewById(g.e.game_gallery_image);
      ProgressBar localProgressBar = (ProgressBar)((View)localObject1).findViewById(g.e.game_gallery_loading);
      localProgressBar.setVisibility(0);
      a locala = o.ON();
      String str = this.lbL[paramInt];
      c.a locala1 = new c.a();
      locala1.ere = true;
      locala.a(str, (ImageView)localObject2, locala1.OV(), new GameGalleryUI.a.1(this, localProgressBar));
    }
    paramViewGroup.addView((View)localObject1);
    ((View)localObject1).setOnClickListener(new GameGalleryUI.a.2(this));
    return localObject1;
  }
  
  public final int getCount()
  {
    return this.lbL.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameGalleryUI.a
 * JD-Core Version:    0.7.0.1
 */