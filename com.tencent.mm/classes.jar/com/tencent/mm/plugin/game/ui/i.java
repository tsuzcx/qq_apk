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
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.List;

public final class i
  extends BaseAdapter
{
  int UR;
  private Context mContext;
  int udq;
  private aa umH;
  
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
    this.umH = paramaa;
    aq.f(new Runnable()
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
    if (this.umH == null)
    {
      AppMethodBeat.o(41982);
      return 0;
    }
    int i = this.umH.udz.size();
    AppMethodBeat.o(41982);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(41983);
    Object localObject = this.umH.udz.get(paramInt);
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
      paramView = LayoutInflater.from(this.mContext).inflate(this.UR, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.umJ = ((TextView)paramView.findViewById(2131300413));
      paramViewGroup.jdF = ((ImageView)paramView.findViewById(2131300410));
      paramViewGroup.umK = ((TextView)paramView.findViewById(2131300412));
      paramViewGroup.umL = ((TextView)paramView.findViewById(2131300415));
      paramViewGroup.umM = ((TextView)paramView.findViewById(2131300414));
      paramViewGroup.umN = ((GameDetailRankLikeView)paramView.findViewById(2131300411));
      paramViewGroup.umN.setSourceScene(this.udq);
      s((ViewGroup)paramView);
      paramView.setTag(paramViewGroup);
      localObject1 = (aa.a)getItem(paramInt);
      paramViewGroup.umJ.setText(((aa.a)localObject1).udA);
      a.b.a(paramViewGroup.jdF, ((aa.a)localObject1).dDy, 0.5F, false);
      localObject2 = ((l)g.ab(l.class)).azp().Bf(((aa.a)localObject1).dDy);
      if (localObject2 == null) {
        break label325;
      }
      localObject2 = new SpannableString(k.b(this.mContext, ((am)localObject2).adv(), paramViewGroup.umK.getTextSize()));
      paramViewGroup.umK.setText((CharSequence)localObject2);
      label255:
      if (!bt.isNullOrNil(((aa.a)localObject1).tag)) {
        break label337;
      }
      paramViewGroup.umL.setVisibility(8);
      label275:
      if (bt.isNullOrNil(((aa.a)localObject1).udD)) {
        break label360;
      }
      paramViewGroup.umM.setText(((aa.a)localObject1).udD);
      paramViewGroup.umN.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(41984);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label325:
      paramViewGroup.umK.setText("");
      break label255;
      label337:
      paramViewGroup.umL.setVisibility(0);
      paramViewGroup.umL.setText(((aa.a)localObject1).tag);
      break label275;
      label360:
      paramViewGroup.umM.setText(((aa.a)localObject1).tvn);
      localObject1 = paramViewGroup.umN;
      localObject2 = this.umH;
      ((GameDetailRankLikeView)localObject1).umO = ((aa)localObject2);
      ((GameDetailRankLikeView)localObject1).mAppId = ((aa)localObject2).mAppId;
      ((GameDetailRankLikeView)localObject1).umP = ((aa.a)((aa)localObject2).udz.get(paramInt));
      ((GameDetailRankLikeView)localObject1).qY();
      paramViewGroup.umN.setVisibility(0);
    }
  }
  
  final class a
  {
    public ImageView jdF;
    public TextView umJ;
    public TextView umK;
    public TextView umL;
    public TextView umM;
    GameDetailRankLikeView umN;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.i
 * JD-Core Version:    0.7.0.1
 */