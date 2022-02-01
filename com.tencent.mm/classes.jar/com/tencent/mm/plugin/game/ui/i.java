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
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.List;

public final class i
  extends BaseAdapter
{
  int Sg;
  private Context mContext;
  int rXI;
  private aa sgq;
  
  public i(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void r(ViewGroup paramViewGroup)
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
        r((ViewGroup)localView);
      }
      i += 1;
    }
    AppMethodBeat.o(41985);
  }
  
  public final void a(aa paramaa)
  {
    AppMethodBeat.i(41981);
    this.sgq = paramaa;
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
    if (this.sgq == null)
    {
      AppMethodBeat.o(41982);
      return 0;
    }
    int i = this.sgq.rXR.size();
    AppMethodBeat.o(41982);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(41983);
    Object localObject = this.sgq.rXR.get(paramInt);
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
      paramView = LayoutInflater.from(this.mContext).inflate(this.Sg, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.sgs = ((TextView)paramView.findViewById(2131300413));
      paramViewGroup.ikp = ((ImageView)paramView.findViewById(2131300410));
      paramViewGroup.sgt = ((TextView)paramView.findViewById(2131300412));
      paramViewGroup.sgu = ((TextView)paramView.findViewById(2131300415));
      paramViewGroup.sgv = ((TextView)paramView.findViewById(2131300414));
      paramViewGroup.sgw = ((GameDetailRankLikeView)paramView.findViewById(2131300411));
      paramViewGroup.sgw.setSourceScene(this.rXI);
      r((ViewGroup)paramView);
      paramView.setTag(paramViewGroup);
      localObject1 = (aa.a)getItem(paramInt);
      paramViewGroup.sgs.setText(((aa.a)localObject1).rXS);
      a.b.a(paramViewGroup.ikp, ((aa.a)localObject1).dtV, 0.5F, false);
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(((aa.a)localObject1).dtV);
      if (localObject2 == null) {
        break label325;
      }
      localObject2 = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, ((af)localObject2).ZX(), paramViewGroup.sgt.getTextSize()));
      paramViewGroup.sgt.setText((CharSequence)localObject2);
      label255:
      if (!bt.isNullOrNil(((aa.a)localObject1).tag)) {
        break label337;
      }
      paramViewGroup.sgu.setVisibility(8);
      label275:
      if (bt.isNullOrNil(((aa.a)localObject1).rXV)) {
        break label360;
      }
      paramViewGroup.sgv.setText(((aa.a)localObject1).rXV);
      paramViewGroup.sgw.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(41984);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label325:
      paramViewGroup.sgt.setText("");
      break label255;
      label337:
      paramViewGroup.sgu.setVisibility(0);
      paramViewGroup.sgu.setText(((aa.a)localObject1).tag);
      break label275;
      label360:
      paramViewGroup.sgv.setText(((aa.a)localObject1).rpS);
      localObject1 = paramViewGroup.sgw;
      localObject2 = this.sgq;
      ((GameDetailRankLikeView)localObject1).sgx = ((aa)localObject2);
      ((GameDetailRankLikeView)localObject1).mAppId = ((aa)localObject2).mAppId;
      ((GameDetailRankLikeView)localObject1).sgy = ((aa.a)((aa)localObject2).rXR.get(paramInt));
      ((GameDetailRankLikeView)localObject1).cEf();
      paramViewGroup.sgw.setVisibility(0);
    }
  }
  
  final class a
  {
    public ImageView ikp;
    public TextView sgs;
    public TextView sgt;
    public TextView sgu;
    public TextView sgv;
    GameDetailRankLikeView sgw;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.i
 * JD-Core Version:    0.7.0.1
 */