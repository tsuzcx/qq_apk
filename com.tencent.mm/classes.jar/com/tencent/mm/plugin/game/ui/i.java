package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.aa.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.List;

public final class i
  extends BaseAdapter
{
  int Ld;
  private Context mContext;
  int nok;
  private aa nwP;
  
  public i(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void o(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111816);
    paramViewGroup.setClipChildren(false);
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup))
      {
        ((ViewGroup)localView).setClipChildren(false);
        o((ViewGroup)localView);
      }
      i += 1;
    }
    AppMethodBeat.o(111816);
  }
  
  public final void a(aa paramaa)
  {
    AppMethodBeat.i(111812);
    this.nwP = paramaa;
    al.d(new i.1(this));
    AppMethodBeat.o(111812);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(111813);
    if (this.nwP == null)
    {
      AppMethodBeat.o(111813);
      return 0;
    }
    int i = this.nwP.now.size();
    AppMethodBeat.o(111813);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(111814);
    Object localObject = this.nwP.now.get(paramInt);
    AppMethodBeat.o(111814);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111815);
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(this.Ld, paramViewGroup, false);
      paramViewGroup = new i.a(this, (byte)0);
      paramViewGroup.nwR = ((TextView)paramView.findViewById(2131824581));
      paramViewGroup.gxs = ((ImageView)paramView.findViewById(2131824582));
      paramViewGroup.nwS = ((TextView)paramView.findViewById(2131824583));
      paramViewGroup.nwT = ((TextView)paramView.findViewById(2131824584));
      paramViewGroup.nwU = ((TextView)paramView.findViewById(2131824585));
      paramViewGroup.nwV = ((GameDetailRankLikeView)paramView.findViewById(2131824586));
      paramViewGroup.nwV.setSourceScene(this.nok);
      o((ViewGroup)paramView);
      paramView.setTag(paramViewGroup);
      localObject1 = (aa.a)getItem(paramInt);
      paramViewGroup.nwR.setText(((aa.a)localObject1).nox);
      a.b.a(paramViewGroup.gxs, ((aa.a)localObject1).cDt, 0.5F, false);
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(((aa.a)localObject1).cDt);
      if (localObject2 == null) {
        break label325;
      }
      localObject2 = new SpannableString(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, ((ad)localObject2).Of(), paramViewGroup.nwS.getTextSize()));
      paramViewGroup.nwS.setText((CharSequence)localObject2);
      label255:
      if (!bo.isNullOrNil(((aa.a)localObject1).tag)) {
        break label337;
      }
      paramViewGroup.nwT.setVisibility(8);
      label275:
      if (bo.isNullOrNil(((aa.a)localObject1).noA)) {
        break label360;
      }
      paramViewGroup.nwU.setText(((aa.a)localObject1).noA);
      paramViewGroup.nwV.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(111815);
      return paramView;
      paramViewGroup = (i.a)paramView.getTag();
      break;
      label325:
      paramViewGroup.nwS.setText("");
      break label255;
      label337:
      paramViewGroup.nwT.setVisibility(0);
      paramViewGroup.nwT.setText(((aa.a)localObject1).tag);
      break label275;
      label360:
      paramViewGroup.nwU.setText(((aa.a)localObject1).mSY);
      localObject1 = paramViewGroup.nwV;
      localObject2 = this.nwP;
      ((GameDetailRankLikeView)localObject1).nwW = ((aa)localObject2);
      ((GameDetailRankLikeView)localObject1).mAppId = ((aa)localObject2).mAppId;
      ((GameDetailRankLikeView)localObject1).nwX = ((aa.a)((aa)localObject2).now.get(paramInt));
      ((GameDetailRankLikeView)localObject1).resetState();
      paramViewGroup.nwV.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.i
 * JD-Core Version:    0.7.0.1
 */