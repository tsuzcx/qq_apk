package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.c;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.h.k;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;

public class TabItemView
  extends LinearLayout
{
  private TextView Avi;
  private TextView IXJ;
  private int hAN;
  
  public TabItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(183906);
    c(paramContext, paramAttributeSet);
    AppMethodBeat.o(183906);
  }
  
  public TabItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(183907);
    c(paramContext, paramAttributeSet);
    AppMethodBeat.o(183907);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(183910);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, h.k.haD);
    String str = paramAttributeSet.getString(h.k.Icv);
    paramAttributeSet.recycle();
    LayoutInflater.from(paramContext).inflate(h.f.HZW, this, true);
    this.Avi = ((TextView)findViewById(h.e.HXT));
    this.IXJ = ((TextView)findViewById(h.e.HXS));
    this.Avi.setText(str);
    if (a.mp(getContext()))
    {
      this.Avi.setTextSize(0, a.bs(getContext(), h.c.HSV) * a.jO(getContext()));
      this.IXJ.setTextSize(0, a.bs(getContext(), h.c.HTe) * a.jO(getContext()));
    }
    AppMethodBeat.o(183910);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(183909);
    if (paramBoolean)
    {
      this.Avi.setTextColor(getResources().getColor(h.b.normal_text_color));
      this.IXJ.setVisibility(8);
      ((f)h.ax(f.class)).fCh().execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where showType=".concat(String.valueOf(this.hAN)));
      r localr = ((e)h.ax(e.class)).fCg();
      int i = this.hAN;
      o localo = r.fGw();
      if ((localo != null) && (localo.field_showType == i)) {
        localr.fGx();
      }
      AppMethodBeat.o(183909);
      return;
    }
    this.Avi.setTextColor(getResources().getColor(h.b.desc_text_color));
    AppMethodBeat.o(183909);
  }
  
  public void setShowType(int paramInt)
  {
    this.hAN = paramInt;
  }
  
  public void setUnreadCount(int paramInt)
  {
    AppMethodBeat.i(183908);
    if (paramInt > 0)
    {
      this.IXJ.setVisibility(0);
      if (paramInt < 100)
      {
        this.IXJ.setText(String.valueOf(paramInt));
        AppMethodBeat.o(183908);
        return;
      }
      this.IXJ.setText(h.i.IbC);
      AppMethodBeat.o(183908);
      return;
    }
    this.IXJ.setVisibility(8);
    AppMethodBeat.o(183908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.TabItemView
 * JD-Core Version:    0.7.0.1
 */