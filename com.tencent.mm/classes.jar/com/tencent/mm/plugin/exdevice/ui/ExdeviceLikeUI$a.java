package com.tencent.mm.plugin.exdevice.ui;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.exdevice.g.b.a.e;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;

final class ExdeviceLikeUI$a
  extends BaseAdapter
{
  ExdeviceLikeUI$a(ExdeviceLikeUI paramExdeviceLikeUI) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(24041);
    if (ExdeviceLikeUI.c(this.vnY) == null)
    {
      AppMethodBeat.o(24041);
      return 0;
    }
    int i = ExdeviceLikeUI.c(this.vnY).size();
    AppMethodBeat.o(24041);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(24042);
    Object localObject = ExdeviceLikeUI.c(this.vnY).get(paramInt);
    AppMethodBeat.o(24042);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24043);
    e locale = (e)ExdeviceLikeUI.c(this.vnY).get(paramInt);
    if (paramView == null) {
      if (ExdeviceLikeUI.d(this.vnY))
      {
        paramView = LayoutInflater.from(this.vnY).inflate(R.i.egv, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.jiu = ((ImageView)paramView.findViewById(R.h.dFP));
        paramViewGroup.vnZ = ((NoMeasuredTextView)paramView.findViewById(R.h.dGn));
        paramViewGroup.mrN = ((TextView)paramView.findViewById(R.h.dGh));
        paramViewGroup.timeTv = ((TextView)paramView.findViewById(R.h.dGg));
        paramViewGroup.vnZ.setTextSize(0, this.vnY.getResources().getDimension(R.f.NormalTextSize));
        paramViewGroup.vnZ.setTextColor(this.vnY.getResources().getColor(R.e.normal_text_color));
        paramViewGroup.vnZ.setSingleLine(true);
        paramViewGroup.vnZ.setShouldEllipsize(true);
        paramView.setTag(paramViewGroup);
        label179:
        a.b.B(paramViewGroup.jiu, locale.field_username);
        paramViewGroup.vnZ.setText(l.b(this.vnY, aa.PJ(locale.field_username), paramViewGroup.vnZ.getTextSize()));
        if ((Util.isNullOrNil(locale.field_liketips)) || (paramViewGroup.mrN == null)) {
          break label352;
        }
        paramViewGroup.mrN.setVisibility(0);
        paramViewGroup.mrN.setText(locale.field_liketips);
        label258:
        paramInt = (int)((System.currentTimeMillis() / 1000L - locale.field_timestamp) / 60L + 1L);
        if (paramInt > 30) {
          break label371;
        }
        paramViewGroup.timeTv.setText(this.vnY.getString(R.l.eDB, new Object[] { Integer.valueOf(paramInt) }));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(24043);
      return paramView;
      paramView = LayoutInflater.from(this.vnY).inflate(R.i.egu, paramViewGroup, false);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label179;
      label352:
      if (paramViewGroup.mrN == null) {
        break label258;
      }
      paramViewGroup.mrN.setVisibility(8);
      break label258;
      label371:
      paramViewGroup.timeTv.setText(f.d(this.vnY, locale.field_timestamp * 1000L, true));
    }
  }
  
  final class a
  {
    ImageView jiu;
    TextView mrN;
    TextView timeTv;
    NoMeasuredTextView vnZ;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI.a
 * JD-Core Version:    0.7.0.1
 */