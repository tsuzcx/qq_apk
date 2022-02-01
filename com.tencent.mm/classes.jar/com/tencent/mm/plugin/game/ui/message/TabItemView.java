package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.g.k;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;

public class TabItemView
  extends LinearLayout
{
  private TextView Ddr;
  private View Dds;
  private int fwp;
  private TextView wXS;
  
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
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, g.k.eXa);
    String str = paramAttributeSet.getString(g.k.Cqm);
    paramAttributeSet.recycle();
    LayoutInflater.from(paramContext).inflate(g.f.CnO, this, true);
    this.wXS = ((TextView)findViewById(g.e.ClL));
    this.Ddr = ((TextView)findViewById(g.e.ClK));
    this.Dds = findViewById(g.e.tab_indicator);
    this.wXS.setText(str);
    if (a.ko(getContext()))
    {
      this.wXS.setTextSize(0, a.aZ(getContext(), g.c.CgM) * a.km(getContext()));
      this.Ddr.setTextSize(0, a.aZ(getContext(), g.c.CgV) * a.km(getContext()));
    }
    AppMethodBeat.o(183910);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(183909);
    if (paramBoolean)
    {
      this.wXS.setTextColor(getResources().getColor(g.b.normal_text_color));
      this.Dds.setVisibility(0);
      this.Ddr.setVisibility(8);
      ((f)h.ae(f.class)).evo().execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where showType=".concat(String.valueOf(this.fwp)));
      r localr = ((e)h.ae(e.class)).evn();
      int i = this.fwp;
      o localo = r.eyA();
      if ((localo != null) && (localo.field_showType == i)) {
        localr.eyB();
      }
      AppMethodBeat.o(183909);
      return;
    }
    this.wXS.setTextColor(getResources().getColor(g.b.desc_text_color));
    this.Dds.setVisibility(8);
    AppMethodBeat.o(183909);
  }
  
  public void setShowType(int paramInt)
  {
    this.fwp = paramInt;
  }
  
  public void setUnreadCount(int paramInt)
  {
    AppMethodBeat.i(183908);
    if (paramInt > 0)
    {
      this.Ddr.setVisibility(0);
      if (paramInt < 100)
      {
        this.Ddr.setText(String.valueOf(paramInt));
        AppMethodBeat.o(183908);
        return;
      }
      this.Ddr.setText(g.i.Cpu);
      AppMethodBeat.o(183908);
      return;
    }
    this.Ddr.setVisibility(8);
    AppMethodBeat.o(183908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.TabItemView
 * JD-Core Version:    0.7.0.1
 */