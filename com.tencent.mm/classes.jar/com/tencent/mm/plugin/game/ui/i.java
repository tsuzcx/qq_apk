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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.aa.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.List;

public final class i
  extends BaseAdapter
{
  int IFc;
  private aa IOE;
  int bxp;
  private Context mContext;
  
  public i(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void N(ViewGroup paramViewGroup)
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
        N((ViewGroup)localView);
      }
      i += 1;
    }
    AppMethodBeat.o(41985);
  }
  
  public final void a(aa paramaa)
  {
    AppMethodBeat.i(41981);
    this.IOE = paramaa;
    MMHandlerThread.postToMainThread(new Runnable()
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
    if (this.IOE == null)
    {
      AppMethodBeat.o(41982);
      return 0;
    }
    int i = this.IOE.IFl.size();
    AppMethodBeat.o(41982);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(41983);
    Object localObject = this.IOE.IFl.get(paramInt);
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
      paramView = LayoutInflater.from(this.mContext).inflate(this.bxp, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.IOG = ((TextView)paramView.findViewById(h.e.HUW));
      paramViewGroup.avatar = ((ImageView)paramView.findViewById(h.e.HUT));
      paramViewGroup.Eoo = ((TextView)paramView.findViewById(h.e.HUV));
      paramViewGroup.IOH = ((TextView)paramView.findViewById(h.e.HUY));
      paramViewGroup.IOI = ((TextView)paramView.findViewById(h.e.HUX));
      paramViewGroup.IOJ = ((GameDetailRankLikeView)paramView.findViewById(h.e.HUU));
      paramViewGroup.IOJ.setSourceScene(this.IFc);
      N((ViewGroup)paramView);
      paramView.setTag(paramViewGroup);
      localObject1 = (aa.a)getItem(paramInt);
      paramViewGroup.IOG.setText(((aa.a)localObject1).Caf);
      a.b.a(paramViewGroup.avatar, ((aa.a)localObject1).hVQ, 0.5F, false);
      localObject2 = ((n)h.ax(n.class)).bzA().JE(((aa.a)localObject1).hVQ);
      if (localObject2 == null) {
        break label331;
      }
      localObject2 = new SpannableString(p.b(this.mContext, ((au)localObject2).aSV(), paramViewGroup.Eoo.getTextSize()));
      paramViewGroup.Eoo.setText((CharSequence)localObject2);
      label261:
      if (!Util.isNullOrNil(((aa.a)localObject1).tag)) {
        break label344;
      }
      paramViewGroup.IOH.setVisibility(8);
      label281:
      if (Util.isNullOrNil(((aa.a)localObject1).IFo)) {
        break label367;
      }
      paramViewGroup.IOI.setText(((aa.a)localObject1).IFo);
      paramViewGroup.IOJ.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(41984);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label331:
      paramViewGroup.Eoo.setText("");
      break label261;
      label344:
      paramViewGroup.IOH.setVisibility(0);
      paramViewGroup.IOH.setText(((aa.a)localObject1).tag);
      break label281;
      label367:
      paramViewGroup.IOI.setText(((aa.a)localObject1).HtH);
      localObject1 = paramViewGroup.IOJ;
      localObject2 = this.IOE;
      ((GameDetailRankLikeView)localObject1).IOK = ((aa)localObject2);
      ((GameDetailRankLikeView)localObject1).mAppId = ((aa)localObject2).mAppId;
      ((GameDetailRankLikeView)localObject1).IOL = ((aa.a)((aa)localObject2).IFl.get(paramInt));
      ((GameDetailRankLikeView)localObject1).Oi();
      paramViewGroup.IOJ.setVisibility(0);
    }
  }
  
  final class a
  {
    public TextView Eoo;
    public TextView IOG;
    public TextView IOH;
    public TextView IOI;
    GameDetailRankLikeView IOJ;
    public ImageView avatar;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.i
 * JD-Core Version:    0.7.0.1
 */