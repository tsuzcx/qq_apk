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
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
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
    if (ExdeviceLikeUI.c(this.yAu) == null)
    {
      AppMethodBeat.o(24041);
      return 0;
    }
    int i = ExdeviceLikeUI.c(this.yAu).size();
    AppMethodBeat.o(24041);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(24042);
    Object localObject = ExdeviceLikeUI.c(this.yAu).get(paramInt);
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
    e locale = (e)ExdeviceLikeUI.c(this.yAu).get(paramInt);
    if (paramView == null) {
      if (ExdeviceLikeUI.d(this.yAu))
      {
        paramView = LayoutInflater.from(this.yAu).inflate(R.i.gjo, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.lKK = ((ImageView)paramView.findViewById(R.h.fGV));
        paramViewGroup.yAv = ((NoMeasuredTextView)paramView.findViewById(R.h.fHt));
        paramViewGroup.pls = ((TextView)paramView.findViewById(R.h.fHn));
        paramViewGroup.timeTv = ((TextView)paramView.findViewById(R.h.fHm));
        paramViewGroup.yAv.setTextSize(0, this.yAu.getResources().getDimension(R.f.NormalTextSize));
        paramViewGroup.yAv.setTextColor(this.yAu.getResources().getColor(R.e.normal_text_color));
        paramViewGroup.yAv.setSingleLine(true);
        paramViewGroup.yAv.setShouldEllipsize(true);
        paramView.setTag(paramViewGroup);
        label179:
        a.b.B(paramViewGroup.lKK, locale.field_username);
        paramViewGroup.yAv.setText(p.b(this.yAu, aa.getDisplayName(locale.field_username), paramViewGroup.yAv.getTextSize()));
        if ((Util.isNullOrNil(locale.field_liketips)) || (paramViewGroup.pls == null)) {
          break label352;
        }
        paramViewGroup.pls.setVisibility(0);
        paramViewGroup.pls.setText(locale.field_liketips);
        label258:
        paramInt = (int)((System.currentTimeMillis() / 1000L - locale.field_timestamp) / 60L + 1L);
        if (paramInt > 30) {
          break label371;
        }
        paramViewGroup.timeTv.setText(this.yAu.getString(R.l.gGp, new Object[] { Integer.valueOf(paramInt) }));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(24043);
      return paramView;
      paramView = LayoutInflater.from(this.yAu).inflate(R.i.gjn, paramViewGroup, false);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label179;
      label352:
      if (paramViewGroup.pls == null) {
        break label258;
      }
      paramViewGroup.pls.setVisibility(8);
      break label258;
      label371:
      paramViewGroup.timeTv.setText(f.d(this.yAu, locale.field_timestamp * 1000L, true));
    }
  }
  
  final class a
  {
    ImageView lKK;
    TextView pls;
    TextView timeTv;
    NoMeasuredTextView yAv;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI.a
 * JD-Core Version:    0.7.0.1
 */