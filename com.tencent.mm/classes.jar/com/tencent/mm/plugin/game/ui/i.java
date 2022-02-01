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
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.aa.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.List;

public final class i
  extends BaseAdapter
{
  int CKU;
  private aa CUn;
  int QY;
  private Context mContext;
  
  public i(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void D(ViewGroup paramViewGroup)
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
        D((ViewGroup)localView);
      }
      i += 1;
    }
    AppMethodBeat.o(41985);
  }
  
  public final void a(aa paramaa)
  {
    AppMethodBeat.i(41981);
    this.CUn = paramaa;
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
    if (this.CUn == null)
    {
      AppMethodBeat.o(41982);
      return 0;
    }
    int i = this.CUn.CLd.size();
    AppMethodBeat.o(41982);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(41983);
    Object localObject = this.CUn.CLd.get(paramInt);
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
      paramView = LayoutInflater.from(this.mContext).inflate(this.QY, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.CUp = ((TextView)paramView.findViewById(g.e.CiO));
      paramViewGroup.mWb = ((ImageView)paramView.findViewById(g.e.CiL));
      paramViewGroup.znp = ((TextView)paramView.findViewById(g.e.CiN));
      paramViewGroup.CUq = ((TextView)paramView.findViewById(g.e.CiQ));
      paramViewGroup.CUr = ((TextView)paramView.findViewById(g.e.CiP));
      paramViewGroup.CUs = ((GameDetailRankLikeView)paramView.findViewById(g.e.CiM));
      paramViewGroup.CUs.setSourceScene(this.CKU);
      D((ViewGroup)paramView);
      paramView.setTag(paramViewGroup);
      localObject1 = (aa.a)getItem(paramInt);
      paramViewGroup.CUp.setText(((aa.a)localObject1).CLe);
      a.b.a(paramViewGroup.mWb, ((aa.a)localObject1).fPV, 0.5F, false);
      localObject2 = ((n)h.ae(n.class)).bbL().RG(((aa.a)localObject1).fPV);
      if (localObject2 == null) {
        break label331;
      }
      localObject2 = new SpannableString(l.b(this.mContext, ((as)localObject2).ays(), paramViewGroup.znp.getTextSize()));
      paramViewGroup.znp.setText((CharSequence)localObject2);
      label261:
      if (!Util.isNullOrNil(((aa.a)localObject1).tag)) {
        break label344;
      }
      paramViewGroup.CUq.setVisibility(8);
      label281:
      if (Util.isNullOrNil(((aa.a)localObject1).CLh)) {
        break label367;
      }
      paramViewGroup.CUr.setText(((aa.a)localObject1).CLh);
      paramViewGroup.CUs.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(41984);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label331:
      paramViewGroup.znp.setText("");
      break label261;
      label344:
      paramViewGroup.CUq.setVisibility(0);
      paramViewGroup.CUq.setText(((aa.a)localObject1).tag);
      break label281;
      label367:
      paramViewGroup.CUr.setText(((aa.a)localObject1).BIY);
      localObject1 = paramViewGroup.CUs;
      localObject2 = this.CUn;
      ((GameDetailRankLikeView)localObject1).CUt = ((aa)localObject2);
      ((GameDetailRankLikeView)localObject1).mAppId = ((aa)localObject2).mAppId;
      ((GameDetailRankLikeView)localObject1).CUu = ((aa.a)((aa)localObject2).CLd.get(paramInt));
      ((GameDetailRankLikeView)localObject1).oA();
      paramViewGroup.CUs.setVisibility(0);
    }
  }
  
  final class a
  {
    public TextView CUp;
    public TextView CUq;
    public TextView CUr;
    GameDetailRankLikeView CUs;
    public ImageView mWb;
    public TextView znp;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.i
 * JD-Core Version:    0.7.0.1
 */