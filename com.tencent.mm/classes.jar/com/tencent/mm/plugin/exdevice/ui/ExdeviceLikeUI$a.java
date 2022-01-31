package com.tencent.mm.plugin.exdevice.ui;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.exdevice.f.b.a.e;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;

final class ExdeviceLikeUI$a
  extends BaseAdapter
{
  ExdeviceLikeUI$a(ExdeviceLikeUI paramExdeviceLikeUI) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(19972);
    if (ExdeviceLikeUI.c(this.lMP) == null)
    {
      AppMethodBeat.o(19972);
      return 0;
    }
    int i = ExdeviceLikeUI.c(this.lMP).size();
    AppMethodBeat.o(19972);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(19973);
    Object localObject = ExdeviceLikeUI.c(this.lMP).get(paramInt);
    AppMethodBeat.o(19973);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(19974);
    e locale = (e)ExdeviceLikeUI.c(this.lMP).get(paramInt);
    if (paramView == null) {
      if (ExdeviceLikeUI.d(this.lMP))
      {
        paramView = LayoutInflater.from(this.lMP).inflate(2130969455, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.ehv = ((ImageView)paramView.findViewById(2131823774));
        paramViewGroup.lMQ = ((NoMeasuredTextView)paramView.findViewById(2131823776));
        paramViewGroup.gLI = ((TextView)paramView.findViewById(2131823777));
        paramViewGroup.timeTv = ((TextView)paramView.findViewById(2131823775));
        paramViewGroup.lMQ.setTextSize(0, this.lMP.getResources().getDimension(2131427809));
        paramViewGroup.lMQ.setTextColor(this.lMP.getResources().getColor(2131689763));
        paramViewGroup.lMQ.setSingleLine(true);
        paramViewGroup.lMQ.setShouldEllipsize(true);
        paramView.setTag(paramViewGroup);
        label172:
        a.b.t(paramViewGroup.ehv, locale.field_username);
        paramViewGroup.lMQ.setText(j.b(this.lMP, s.nE(locale.field_username), paramViewGroup.lMQ.getTextSize()));
        if ((bo.isNullOrNil(locale.field_liketips)) || (paramViewGroup.gLI == null)) {
          break label343;
        }
        paramViewGroup.gLI.setVisibility(0);
        paramViewGroup.gLI.setText(locale.field_liketips);
        label251:
        paramInt = (int)((System.currentTimeMillis() / 1000L - locale.field_timestamp) / 60L + 1L);
        if (paramInt > 30) {
          break label362;
        }
        paramViewGroup.timeTv.setText(this.lMP.getString(2131299421, new Object[] { Integer.valueOf(paramInt) }));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(19974);
      return paramView;
      paramView = LayoutInflater.from(this.lMP).inflate(2130969454, paramViewGroup, false);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label172;
      label343:
      if (paramViewGroup.gLI == null) {
        break label251;
      }
      paramViewGroup.gLI.setVisibility(8);
      break label251;
      label362:
      paramViewGroup.timeTv.setText(h.c(this.lMP, locale.field_timestamp * 1000L, true));
    }
  }
  
  final class a
  {
    ImageView ehv;
    TextView gLI;
    NoMeasuredTextView lMQ;
    TextView timeTv;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI.a
 * JD-Core Version:    0.7.0.1
 */