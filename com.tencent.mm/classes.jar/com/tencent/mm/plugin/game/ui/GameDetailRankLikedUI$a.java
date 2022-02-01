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
import com.tencent.mm.plugin.game.protobuf.ej;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;
import java.util.List;

final class GameDetailRankLikedUI$a
  extends BaseAdapter
{
  List<ej> cvc;
  private Context mContext;
  
  public GameDetailRankLikedUI$a(Context paramContext)
  {
    AppMethodBeat.i(41995);
    this.cvc = new LinkedList();
    this.mContext = paramContext;
    AppMethodBeat.o(41995);
  }
  
  private ej Ou(int paramInt)
  {
    AppMethodBeat.i(41997);
    ej localej = (ej)this.cvc.get(paramInt);
    AppMethodBeat.o(41997);
    return localej;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(41996);
    int i = this.cvc.size();
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
    ej localej;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131494851, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.keC = ((ImageView)paramView.findViewById(2131301939));
      paramViewGroup.uGh = ((TextView)paramView.findViewById(2131301940));
      paramViewGroup.pwO = ((TextView)paramView.findViewById(2131301941));
      paramView.setTag(paramViewGroup);
      localej = Ou(paramInt);
      a.b.a(paramViewGroup.keC, localej.xNH, 0.5F, false);
      Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(localej.xNH);
      if (localObject == null) {
        break label196;
      }
      localObject = new SpannableString(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, ((as)localObject).arJ(), paramViewGroup.uGh.getTextSize()));
      paramViewGroup.uGh.setText((CharSequence)localObject);
    }
    for (;;)
    {
      paramViewGroup.pwO.setText(localej.xNI);
      AppMethodBeat.o(41998);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label196:
      paramViewGroup.uGh.setText("");
    }
  }
  
  static final class a
  {
    public ImageView keC;
    public TextView pwO;
    public TextView uGh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI.a
 * JD-Core Version:    0.7.0.1
 */