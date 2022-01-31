package com.tencent.mm.plugin.account.ui;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class RegByMobileWaitingSMSUI$a
  extends ArrayAdapter<String>
{
  private final LayoutInflater exe;
  private final ArrayList<String> gJj;
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(125480);
    String str = (String)this.gJj.get(paramInt);
    AppMethodBeat.o(125480);
    return str;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(125479);
    int i = this.gJj.size();
    AppMethodBeat.o(125479);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(125481);
    if (((Integer)RegByMobileWaitingSMSUI.h(this.gJh).get(paramInt % RegByMobileWaitingSMSUI.h(this.gJh).size())).intValue() % 4 == 0)
    {
      AppMethodBeat.o(125481);
      return 1;
    }
    AppMethodBeat.o(125481);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(125478);
    int i = getItemViewType(paramInt);
    label111:
    int j;
    if (paramView == null)
    {
      paramViewGroup = new RegByMobileWaitingSMSUI.b(this.gJh, (byte)0);
      switch (i)
      {
      default: 
        paramView = new IllegalArgumentException("UNIMPLEMENT TYPE");
        AppMethodBeat.o(125478);
        throw paramView;
      case 0: 
        paramView = this.exe.inflate(2130968649, null);
        paramViewGroup.gJk = ((TextView)paramView.findViewById(2131821123));
        paramViewGroup.gxs = ((ImageView)paramView.findViewById(2131821121));
        paramView.setTag(paramViewGroup);
        j = ((Integer)RegByMobileWaitingSMSUI.h(this.gJh).get(paramInt % RegByMobileWaitingSMSUI.h(this.gJh).size())).intValue();
        switch (i)
        {
        }
        break;
      }
    }
    for (;;)
    {
      paramViewGroup.gJk.setText(getItem(paramInt));
      AppMethodBeat.o(125478);
      return paramView;
      paramView = this.exe.inflate(2130968650, null);
      break;
      paramViewGroup = (RegByMobileWaitingSMSUI.b)paramView.getTag();
      break label111;
      paramViewGroup.gxs.setImageDrawable((Drawable)RegByMobileWaitingSMSUI.i(this.gJh).get(j % RegByMobileWaitingSMSUI.i(this.gJh).size()));
      continue;
      paramViewGroup.gxs.setImageDrawable(RegByMobileWaitingSMSUI.j(this.gJh));
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final void xB(String paramString)
  {
    AppMethodBeat.i(125482);
    this.gJj.add(paramString);
    notifyDataSetChanged();
    AppMethodBeat.o(125482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI.a
 * JD-Core Version:    0.7.0.1
 */