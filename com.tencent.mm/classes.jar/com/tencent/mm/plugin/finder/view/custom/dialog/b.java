package com.tencent.mm.plugin.finder.view.custom.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private List<String> GGS;
  private Context mContext;
  private List<String> pJZ;
  
  public b(Context paramContext, List<String> paramList1, List<String> paramList2)
  {
    this.mContext = paramContext;
    this.pJZ = paramList2;
    this.GGS = paramList1;
  }
  
  private static a hh(View paramView)
  {
    AppMethodBeat.i(345014);
    a locala = new a((byte)0);
    locala.lBC = ((ImageView)paramView.findViewById(e.e.chatroom_member_avatar));
    locala.pUL = ((TextView)paramView.findViewById(e.e.chatroom_member_name));
    paramView.setTag(locala);
    AppMethodBeat.o(345014);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(345023);
    int i = this.pJZ.size();
    AppMethodBeat.o(345023);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(345030);
    Object localObject = this.pJZ.get(paramInt);
    AppMethodBeat.o(345030);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(345054);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, e.f.chatroom_avatar_item, null);
      paramViewGroup = hh(paramView);
    }
    label260:
    for (;;)
    {
      int i = this.pJZ.size();
      if ((paramInt >= 0) && (paramInt < this.pJZ.size()) && (paramInt < this.GGS.size()))
      {
        paramViewGroup.lBC.setVisibility(0);
        paramViewGroup.pUL.setVisibility(0);
        a.b.g(paramViewGroup.lBC, (String)this.GGS.get(paramInt));
        paramViewGroup.pUL.setText((CharSequence)this.pJZ.get(paramInt));
        paramViewGroup.pUL.setText(((com.tencent.mm.plugin.emoji.c.a)h.ax(com.tencent.mm.plugin.emoji.c.a.class)).a(this.mContext, (CharSequence)this.pJZ.get(paramInt), paramViewGroup.pUL.getTextSize()));
        if ((this.pJZ.size() <= 12) || (paramInt < this.pJZ.size() - i % 4)) {
          break label246;
        }
        paramViewGroup.pUL.setPadding(0, 0, 0, com.tencent.mm.cd.a.br(this.mContext, e.c.DialogAvatarLinePadding));
      }
      for (;;)
      {
        AppMethodBeat.o(345054);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        if (paramViewGroup != null) {
          break label260;
        }
        paramViewGroup = hh(paramView);
        break;
        label246:
        paramViewGroup.pUL.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  static final class a
  {
    public ImageView lBC;
    public TextView pUL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.custom.dialog.b
 * JD-Core Version:    0.7.0.1
 */