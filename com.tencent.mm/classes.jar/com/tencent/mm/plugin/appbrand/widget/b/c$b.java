package com.tencent.mm.plugin.appbrand.widget.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class c$b
  extends BaseAdapter
{
  private LinkedList<c.c> jje;
  
  c$b(LinkedList<c.c> paramLinkedList)
  {
    this.jje = paramLinkedList;
  }
  
  private c.c qm(int paramInt)
  {
    AppMethodBeat.i(102354);
    c.c localc = (c.c)this.jje.get(paramInt);
    AppMethodBeat.o(102354);
    return localc;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102353);
    if (this.jje == null)
    {
      AppMethodBeat.o(102353);
      return 0;
    }
    int i = this.jje.size();
    AppMethodBeat.o(102353);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(102355);
    if ((this.jje == null) || (this.jje.size() <= 0))
    {
      AppMethodBeat.o(102355);
      return null;
    }
    c.c localc = qm(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new c.b.a((byte)0);
      localObject = View.inflate(paramViewGroup.getContext(), 2130968791, null);
      paramView.jji = ((ImageView)((View)localObject).findViewById(2131821584));
      paramView.jjj = ((TextView)((View)localObject).findViewById(2131821585));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      if (localc.state != 1) {
        break label173;
      }
      paramViewGroup.jji.setImageResource(2130839323);
    }
    for (;;)
    {
      paramViewGroup.jjj.setText(localc.desc);
      localObject = paramViewGroup.jji;
      paramViewGroup.jji.setOnClickListener(new c.b.1(this, localc, (ImageView)localObject));
      AppMethodBeat.o(102355);
      return paramView;
      paramViewGroup = (c.b.a)paramView.getTag();
      break;
      label173:
      if (localc.state == 3) {
        paramViewGroup.jji.setImageResource(2130839322);
      } else {
        paramViewGroup.jji.setImageResource(2130839321);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.c.b
 * JD-Core Version:    0.7.0.1
 */