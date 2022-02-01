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
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.util.List;

public final class i
  extends BaseAdapter
{
  int Tb;
  private Context mContext;
  int tfA;
  private aa toj;
  
  public i(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void s(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(41985);
    paramViewGroup.setClipChildren(false);
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup))
      {
        ((ViewGroup)localView).setClipChildren(false);
        s((ViewGroup)localView);
      }
      i += 1;
    }
    AppMethodBeat.o(41985);
  }
  
  public final void a(aa paramaa)
  {
    AppMethodBeat.i(41981);
    this.toj = paramaa;
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41980);
        i.this.notifyDataSetChanged();
        AppMethodBeat.o(41980);
      }
    });
    AppMethodBeat.o(41981);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(41982);
    if (this.toj == null)
    {
      AppMethodBeat.o(41982);
      return 0;
    }
    int i = this.toj.tfJ.size();
    AppMethodBeat.o(41982);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(41983);
    Object localObject = this.toj.tfJ.get(paramInt);
    AppMethodBeat.o(41983);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(41984);
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(this.Tb, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.tol = ((TextView)paramView.findViewById(2131300413));
      paramViewGroup.iKw = ((ImageView)paramView.findViewById(2131300410));
      paramViewGroup.tom = ((TextView)paramView.findViewById(2131300412));
      paramViewGroup.ton = ((TextView)paramView.findViewById(2131300415));
      paramViewGroup.too = ((TextView)paramView.findViewById(2131300414));
      paramViewGroup.toq = ((GameDetailRankLikeView)paramView.findViewById(2131300411));
      paramViewGroup.toq.setSourceScene(this.tfA);
      s((ViewGroup)paramView);
      paramView.setTag(paramViewGroup);
      localObject1 = (aa.a)getItem(paramInt);
      paramViewGroup.tol.setText(((aa.a)localObject1).tfK);
      a.b.a(paramViewGroup.iKw, ((aa.a)localObject1).drG, 0.5F, false);
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(((aa.a)localObject1).drG);
      if (localObject2 == null) {
        break label325;
      }
      localObject2 = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, ((ai)localObject2).aaS(), paramViewGroup.tom.getTextSize()));
      paramViewGroup.tom.setText((CharSequence)localObject2);
      label255:
      if (!bs.isNullOrNil(((aa.a)localObject1).tag)) {
        break label337;
      }
      paramViewGroup.ton.setVisibility(8);
      label275:
      if (bs.isNullOrNil(((aa.a)localObject1).tfN)) {
        break label360;
      }
      paramViewGroup.too.setText(((aa.a)localObject1).tfN);
      paramViewGroup.toq.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(41984);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label325:
      paramViewGroup.tom.setText("");
      break label255;
      label337:
      paramViewGroup.ton.setVisibility(0);
      paramViewGroup.ton.setText(((aa.a)localObject1).tag);
      break label275;
      label360:
      paramViewGroup.too.setText(((aa.a)localObject1).syM);
      localObject1 = paramViewGroup.toq;
      localObject2 = this.toj;
      ((GameDetailRankLikeView)localObject1).tor = ((aa)localObject2);
      ((GameDetailRankLikeView)localObject1).mAppId = ((aa)localObject2).mAppId;
      ((GameDetailRankLikeView)localObject1).tos = ((aa.a)((aa)localObject2).tfJ.get(paramInt));
      ((GameDetailRankLikeView)localObject1).cRp();
      paramViewGroup.toq.setVisibility(0);
    }
  }
  
  final class a
  {
    public ImageView iKw;
    public TextView tol;
    public TextView tom;
    public TextView ton;
    public TextView too;
    GameDetailRankLikeView toq;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.i
 * JD-Core Version:    0.7.0.1
 */