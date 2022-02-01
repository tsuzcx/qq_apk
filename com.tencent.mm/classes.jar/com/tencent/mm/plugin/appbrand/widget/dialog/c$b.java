package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;

final class c$b
  extends BaseAdapter
{
  private final ArrayList<c.c> ncT;
  
  c$b(ArrayList<c.c> paramArrayList)
  {
    this.ncT = paramArrayList;
  }
  
  private c.c wl(int paramInt)
  {
    AppMethodBeat.i(147737);
    c.c localc = (c.c)this.ncT.get(paramInt);
    AppMethodBeat.o(147737);
    return localc;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(147736);
    if (this.ncT == null)
    {
      AppMethodBeat.o(147736);
      return 0;
    }
    int i = this.ncT.size();
    AppMethodBeat.o(147736);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(147738);
    if ((this.ncT == null) || (this.ncT.size() <= 0))
    {
      AppMethodBeat.o(147738);
      return null;
    }
    final c.c localc = wl(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new a((byte)0);
      localObject = View.inflate(paramViewGroup.getContext(), 2131493120, null);
      paramView.ndo = ((ImageView)((View)localObject).findViewById(2131296682));
      paramView.nbj = ((TextView)((View)localObject).findViewById(2131296681));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      if (localc.state != 1) {
        break label173;
      }
      paramViewGroup.ndo.setImageResource(2131232921);
    }
    for (;;)
    {
      paramViewGroup.nbj.setText(localc.desc);
      localObject = paramViewGroup.ndo;
      paramViewGroup.ndo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(147735);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (localc.state == 2)
          {
            this.ncV.setImageResource(2131232921);
            localc.state = 1;
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(147735);
            return;
            if (localc.state == 1)
            {
              this.ncV.setImageResource(2131232919);
              localc.state = 2;
            }
          }
        }
      });
      AppMethodBeat.o(147738);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label173:
      if (localc.state == 3) {
        paramViewGroup.ndo.setImageResource(2131232920);
      } else {
        paramViewGroup.ndo.setImageResource(2131232919);
      }
    }
  }
  
  static final class a
  {
    TextView nbj;
    ImageView ndo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.c.b
 * JD-Core Version:    0.7.0.1
 */