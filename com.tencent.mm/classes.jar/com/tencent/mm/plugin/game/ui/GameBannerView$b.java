package com.tencent.mm.plugin.game.ui;

import android.graphics.drawable.Drawable;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class GameBannerView$b
  extends q
{
  private GameBannerView$b(GameBannerView paramGameBannerView) {}
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(111719);
    int i = GameBannerView.b(this.nvn).size();
    paramViewGroup.removeView((View)paramObject);
    ab.i("MicroMsg.GameBannerView", "destroyItem : new positon = %d, now position = %d", new Object[] { Integer.valueOf(paramInt % i), Integer.valueOf(paramInt) });
    AppMethodBeat.o(111719);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(111721);
    if (GameBannerView.b(this.nvn).size() <= 1)
    {
      i = GameBannerView.b(this.nvn).size();
      AppMethodBeat.o(111721);
      return i;
    }
    int i = GameBannerView.b(this.nvn).size();
    AppMethodBeat.o(111721);
    return i * 1000 * 2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(111720);
    int i = paramInt % GameBannerView.b(this.nvn).size();
    View localView = View.inflate(GameBannerView.d(this.nvn), 2130969690, null);
    localView.setTag(GameBannerView.b(this.nvn).get(i));
    localView.setOnClickListener(this.nvn);
    ImageView localImageView = (ImageView)localView.findViewById(2131824423);
    String str = ((GameBannerView.a)GameBannerView.b(this.nvn).get(i)).fqJ;
    Drawable localDrawable = localImageView.getDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof j))) {
      ((j)localDrawable).setUrl(str);
    }
    try
    {
      for (;;)
      {
        paramViewGroup.addView(localView, 0);
        ab.i("MicroMsg.GameBannerView", "instantiateItem : new positon = %d, now position = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
        AppMethodBeat.o(111720);
        return localView;
        localImageView.setImageDrawable(new j(str, (byte)0));
      }
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        ab.e("MicroMsg.GameBannerView", "add view failed, " + paramViewGroup.getMessage());
      }
    }
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBannerView.b
 * JD-Core Version:    0.7.0.1
 */