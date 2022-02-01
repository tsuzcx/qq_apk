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
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.protobuf.eo;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.LinkedList;
import java.util.List;

final class GameDetailRankLikedUI$a
  extends BaseAdapter
{
  List<eo> ell;
  private Context mContext;
  
  public GameDetailRankLikedUI$a(Context paramContext)
  {
    AppMethodBeat.i(41995);
    this.ell = new LinkedList();
    this.mContext = paramContext;
    AppMethodBeat.o(41995);
  }
  
  private eo XI(int paramInt)
  {
    AppMethodBeat.i(41997);
    eo localeo = (eo)this.ell.get(paramInt);
    AppMethodBeat.o(41997);
    return localeo;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(41996);
    int i = this.ell.size();
    AppMethodBeat.o(41996);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(41998);
    eo localeo;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(h.f.HZe, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.avatar = ((ImageView)paramView.findViewById(h.e.HUZ));
      paramViewGroup.Eoo = ((TextView)paramView.findViewById(h.e.HVa));
      paramViewGroup.vLJ = ((TextView)paramView.findViewById(h.e.HVb));
      paramView.setTag(paramViewGroup);
      localeo = XI(paramInt);
      a.b.a(paramViewGroup.avatar, localeo.IMh, 0.5F, false);
      Object localObject = ((n)h.ax(n.class)).bzA().JE(localeo.IMh);
      if (localObject == null) {
        break label200;
      }
      localObject = new SpannableString(p.b(this.mContext, ((au)localObject).aSV(), paramViewGroup.Eoo.getTextSize()));
      paramViewGroup.Eoo.setText((CharSequence)localObject);
    }
    for (;;)
    {
      paramViewGroup.vLJ.setText(localeo.IMi);
      AppMethodBeat.o(41998);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label200:
      paramViewGroup.Eoo.setText("");
    }
  }
  
  static final class a
  {
    public TextView Eoo;
    public ImageView avatar;
    public TextView vLJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI.a
 * JD-Core Version:    0.7.0.1
 */