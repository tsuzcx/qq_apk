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
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;

public class TabItemView
  extends LinearLayout
{
  private int dmr;
  private TextView uGA;
  private View uGB;
  private TextView uGz;
  
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
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, g.a.TabItemView);
    String str = paramAttributeSet.getString(0);
    paramAttributeSet.recycle();
    LayoutInflater.from(paramContext).inflate(2131494353, this, true);
    this.uGz = ((TextView)findViewById(2131305601));
    this.uGA = ((TextView)findViewById(2131305600));
    this.uGB = findViewById(2131305599);
    this.uGz.setText(str);
    if (a.ir(getContext()))
    {
      this.uGz.setTextSize(0, a.ay(getContext(), 2131165414) * a.ip(getContext()));
      this.uGA.setTextSize(0, a.ay(getContext(), 2131165441) * a.ip(getContext()));
    }
    AppMethodBeat.o(183910);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(183909);
    if (paramBoolean)
    {
      this.uGz.setTextColor(getResources().getColor(2131100711));
      this.uGB.setVisibility(0);
      this.uGA.setVisibility(8);
      ((f)g.ab(f.class)).cZl().execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where showType=".concat(String.valueOf(this.dmr)));
      ((e)g.ab(e.class)).cZk();
      int i = this.dmr;
      o localo = r.dbL();
      if ((localo != null) && (localo.field_showType == i)) {
        r.dbM();
      }
      AppMethodBeat.o(183909);
      return;
    }
    this.uGz.setTextColor(getResources().getColor(2131100212));
    this.uGB.setVisibility(8);
    AppMethodBeat.o(183909);
  }
  
  public void setShowType(int paramInt)
  {
    this.dmr = paramInt;
  }
  
  public void setUnreadCount(int paramInt)
  {
    AppMethodBeat.i(183908);
    if (paramInt > 0)
    {
      this.uGA.setVisibility(0);
      if (paramInt < 100)
      {
        this.uGA.setText(String.valueOf(paramInt));
        AppMethodBeat.o(183908);
        return;
      }
      this.uGA.setText(2131759956);
      AppMethodBeat.o(183908);
      return;
    }
    this.uGA.setVisibility(8);
    AppMethodBeat.o(183908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.TabItemView
 * JD-Core Version:    0.7.0.1
 */