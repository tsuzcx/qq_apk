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
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.List;

public final class i
  extends BaseAdapter
{
  int Ve;
  private Context mContext;
  int xGR;
  private aa xQe;
  
  public i(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void x(ViewGroup paramViewGroup)
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
        x((ViewGroup)localView);
      }
      i += 1;
    }
    AppMethodBeat.o(41985);
  }
  
  public final void a(aa paramaa)
  {
    AppMethodBeat.i(41981);
    this.xQe = paramaa;
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
    if (this.xQe == null)
    {
      AppMethodBeat.o(41982);
      return 0;
    }
    int i = this.xQe.xHa.size();
    AppMethodBeat.o(41982);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(41983);
    Object localObject = this.xQe.xHa.get(paramInt);
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
      paramView = LayoutInflater.from(this.mContext).inflate(this.Ve, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.xQg = ((TextView)paramView.findViewById(2131301936));
      paramViewGroup.keC = ((ImageView)paramView.findViewById(2131301933));
      paramViewGroup.uGh = ((TextView)paramView.findViewById(2131301935));
      paramViewGroup.xQh = ((TextView)paramView.findViewById(2131301938));
      paramViewGroup.xQi = ((TextView)paramView.findViewById(2131301937));
      paramViewGroup.xQj = ((GameDetailRankLikeView)paramView.findViewById(2131301934));
      paramViewGroup.xQj.setSourceScene(this.xGR);
      x((ViewGroup)paramView);
      paramView.setTag(paramViewGroup);
      localObject1 = (aa.a)getItem(paramInt);
      paramViewGroup.xQg.setText(((aa.a)localObject1).xHb);
      a.b.a(paramViewGroup.keC, ((aa.a)localObject1).dWq, 0.5F, false);
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(((aa.a)localObject1).dWq);
      if (localObject2 == null) {
        break label325;
      }
      localObject2 = new SpannableString(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, ((as)localObject2).arJ(), paramViewGroup.uGh.getTextSize()));
      paramViewGroup.uGh.setText((CharSequence)localObject2);
      label255:
      if (!Util.isNullOrNil(((aa.a)localObject1).tag)) {
        break label337;
      }
      paramViewGroup.xQh.setVisibility(8);
      label275:
      if (Util.isNullOrNil(((aa.a)localObject1).xHe)) {
        break label360;
      }
      paramViewGroup.xQi.setText(((aa.a)localObject1).xHe);
      paramViewGroup.xQj.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(41984);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label325:
      paramViewGroup.uGh.setText("");
      break label255;
      label337:
      paramViewGroup.xQh.setVisibility(0);
      paramViewGroup.xQh.setText(((aa.a)localObject1).tag);
      break label275;
      label360:
      paramViewGroup.xQi.setText(((aa.a)localObject1).wXd);
      localObject1 = paramViewGroup.xQj;
      localObject2 = this.xQe;
      ((GameDetailRankLikeView)localObject1).xQk = ((aa)localObject2);
      ((GameDetailRankLikeView)localObject1).mAppId = ((aa)localObject2).mAppId;
      ((GameDetailRankLikeView)localObject1).xQl = ((aa.a)((aa)localObject2).xHa.get(paramInt));
      ((GameDetailRankLikeView)localObject1).rb();
      paramViewGroup.xQj.setVisibility(0);
    }
  }
  
  final class a
  {
    public ImageView keC;
    public TextView uGh;
    public TextView xQg;
    public TextView xQh;
    public TextView xQi;
    GameDetailRankLikeView xQj;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.i
 * JD-Core Version:    0.7.0.1
 */