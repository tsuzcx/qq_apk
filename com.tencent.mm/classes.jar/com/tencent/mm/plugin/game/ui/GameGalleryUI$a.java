package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;

final class GameGalleryUI$a
  extends q
{
  Context mContext;
  private String[] nzG;
  private View[] nzH;
  
  public GameGalleryUI$a(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(111964);
    this.nzG = new String[0];
    this.mContext = paramContext;
    if (paramArrayOfString != null) {
      this.nzG = paramArrayOfString;
    }
    this.nzH = new View[this.nzG.length];
    AppMethodBeat.o(111964);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(111966);
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(111966);
  }
  
  public final int getCount()
  {
    return this.nzG.length;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(111965);
    Object localObject2 = this.nzH[paramInt];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = View.inflate(this.mContext, 2130969757, null);
      this.nzH[paramInt] = localObject1;
      localObject2 = (ImageView)((View)localObject1).findViewById(2131824639);
      ProgressBar localProgressBar = (ProgressBar)((View)localObject1).findViewById(2131824640);
      localProgressBar.setVisibility(0);
      a locala = o.ahG();
      String str = this.nzG[paramInt];
      c.a locala1 = new c.a();
      locala1.eNL = true;
      locala.a(str, (ImageView)localObject2, locala1.ahY(), new GameGalleryUI.a.1(this, localProgressBar));
    }
    paramViewGroup.addView((View)localObject1);
    ((View)localObject1).setOnClickListener(new GameGalleryUI.a.2(this));
    AppMethodBeat.o(111965);
    return localObject1;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameGalleryUI.a
 * JD-Core Version:    0.7.0.1
 */