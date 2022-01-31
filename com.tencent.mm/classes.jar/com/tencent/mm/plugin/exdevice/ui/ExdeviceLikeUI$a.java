package com.tencent.mm.plugin.exdevice.ui;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.exdevice.f.b.a.e;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;

final class ExdeviceLikeUI$a
  extends BaseAdapter
{
  ExdeviceLikeUI$a(ExdeviceLikeUI paramExdeviceLikeUI) {}
  
  public final int getCount()
  {
    if (ExdeviceLikeUI.c(this.jDq) == null) {
      return 0;
    }
    return ExdeviceLikeUI.c(this.jDq).size();
  }
  
  public final Object getItem(int paramInt)
  {
    return ExdeviceLikeUI.c(this.jDq).get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    e locale = (e)ExdeviceLikeUI.c(this.jDq).get(paramInt);
    if (paramView == null) {
      if (ExdeviceLikeUI.d(this.jDq))
      {
        paramView = LayoutInflater.from(this.jDq).inflate(R.i.exdevice_like_item_readonly, paramViewGroup, false);
        paramViewGroup = new ExdeviceLikeUI.a.a(this);
        paramViewGroup.dpY = ((ImageView)paramView.findViewById(R.h.exdevice_avatar));
        paramViewGroup.jDr = ((NoMeasuredTextView)paramView.findViewById(R.h.exdevice_username));
        paramViewGroup.fug = ((TextView)paramView.findViewById(R.h.exdevice_tip));
        paramViewGroup.igx = ((TextView)paramView.findViewById(R.h.exdevice_time));
        paramViewGroup.jDr.setTextSize(0, this.jDq.getResources().getDimension(R.f.NormalTextSize));
        paramViewGroup.jDr.setTextColor(this.jDq.getResources().getColor(R.e.black));
        paramViewGroup.jDr.setSingleLine(true);
        paramViewGroup.jDr.setShouldEllipsize(true);
        paramView.setTag(paramViewGroup);
        label173:
        a.b.o(paramViewGroup.dpY, locale.field_username);
        paramViewGroup.jDr.setText(j.a(this.jDq, r.gV(locale.field_username), paramViewGroup.jDr.getTextSize()));
        if ((bk.bl(locale.field_liketips)) || (paramViewGroup.fug == null)) {
          break label340;
        }
        paramViewGroup.fug.setVisibility(0);
        paramViewGroup.fug.setText(locale.field_liketips);
      }
    }
    for (;;)
    {
      paramInt = (int)((System.currentTimeMillis() / 1000L - locale.field_timestamp) / 60L + 1L);
      if (paramInt > 30) {
        break label359;
      }
      paramViewGroup.igx.setText(this.jDq.getString(R.l.exdevice_like_time_ago, new Object[] { Integer.valueOf(paramInt) }));
      return paramView;
      paramView = LayoutInflater.from(this.jDq).inflate(R.i.exdevice_like_item, paramViewGroup, false);
      break;
      paramViewGroup = (ExdeviceLikeUI.a.a)paramView.getTag();
      break label173;
      label340:
      if (paramViewGroup.fug != null) {
        paramViewGroup.fug.setVisibility(8);
      }
    }
    label359:
    paramViewGroup.igx.setText(h.c(this.jDq, locale.field_timestamp * 1000L, true));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI.a
 * JD-Core Version:    0.7.0.1
 */