package com.tencent.mm.plugin.game.ui;

import android.graphics.drawable.Drawable;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

final class GameBannerView$b
  extends q
{
  private GameBannerView$b(GameBannerView paramGameBannerView) {}
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(41879);
    int i = GameBannerView.b(this.uwF).size();
    paramViewGroup.removeView((View)paramObject);
    ae.i("MicroMsg.GameBannerView", "destroyItem : new positon = %d, now position = %d", new Object[] { Integer.valueOf(paramInt % i), Integer.valueOf(paramInt) });
    AppMethodBeat.o(41879);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(41881);
    if (GameBannerView.b(this.uwF).size() <= 1)
    {
      i = GameBannerView.b(this.uwF).size();
      AppMethodBeat.o(41881);
      return i;
    }
    int i = GameBannerView.b(this.uwF).size();
    AppMethodBeat.o(41881);
    return i * 1000 * 2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(41880);
    int i = paramInt % GameBannerView.b(this.uwF).size();
    View localView = View.inflate(GameBannerView.d(this.uwF), 2131494242, null);
    localView.setTag(GameBannerView.b(this.uwF).get(i));
    localView.setOnClickListener(this.uwF);
    ImageView localImageView = (ImageView)localView.findViewById(2131300347);
    String str = ((GameBannerView.a)GameBannerView.b(this.uwF).get(i)).hOr;
    Drawable localDrawable = localImageView.getDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof j))) {
      ((j)localDrawable).setUrl(str);
    }
    try
    {
      for (;;)
      {
        paramViewGroup.addView(localView, 0);
        ae.i("MicroMsg.GameBannerView", "instantiateItem : new positon = %d, now position = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
        AppMethodBeat.o(41880);
        return localView;
        localImageView.setImageDrawable(new j(str, (byte)0));
      }
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        ae.e("MicroMsg.GameBannerView", "add view failed, " + paramViewGroup.getMessage());
      }
    }
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBannerView.b
 * JD-Core Version:    0.7.0.1
 */