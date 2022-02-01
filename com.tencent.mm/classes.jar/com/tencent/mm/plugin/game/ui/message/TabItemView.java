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
  private int dDG;
  private TextView trw;
  private TextView xYM;
  private View xYN;
  
  public TabItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(183906);
    b(paramContext, paramAttributeSet);
    AppMethodBeat.o(183906);
  }
  
  public TabItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(183907);
    b(paramContext, paramAttributeSet);
    AppMethodBeat.o(183907);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(183910);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, g.a.TabItemView);
    String str = paramAttributeSet.getString(0);
    paramAttributeSet.recycle();
    LayoutInflater.from(paramContext).inflate(2131494918, this, true);
    this.trw = ((TextView)findViewById(2131308838));
    this.xYM = ((TextView)findViewById(2131308837));
    this.xYN = findViewById(2131308835);
    this.trw.setText(str);
    if (a.jk(getContext()))
    {
      this.trw.setTextSize(0, a.aH(getContext(), 2131165425) * a.ji(getContext()));
      this.xYM.setTextSize(0, a.aH(getContext(), 2131165457) * a.ji(getContext()));
    }
    AppMethodBeat.o(183910);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(183909);
    if (paramBoolean)
    {
      this.trw.setTextColor(getResources().getColor(2131100904));
      this.xYN.setVisibility(0);
      this.xYM.setVisibility(8);
      ((f)g.af(f.class)).dSK().execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where showType=".concat(String.valueOf(this.dDG)));
      ((e)g.af(e.class)).dSJ();
      int i = this.dDG;
      o localo = r.dVs();
      if ((localo != null) && (localo.field_showType == i)) {
        r.dVt();
      }
      AppMethodBeat.o(183909);
      return;
    }
    this.trw.setTextColor(getResources().getColor(2131100245));
    this.xYN.setVisibility(8);
    AppMethodBeat.o(183909);
  }
  
  public void setShowType(int paramInt)
  {
    this.dDG = paramInt;
  }
  
  public void setUnreadCount(int paramInt)
  {
    AppMethodBeat.i(183908);
    if (paramInt > 0)
    {
      this.xYM.setVisibility(0);
      if (paramInt < 100)
      {
        this.xYM.setText(String.valueOf(paramInt));
        AppMethodBeat.o(183908);
        return;
      }
      this.xYM.setText(2131761311);
      AppMethodBeat.o(183908);
      return;
    }
    this.xYM.setVisibility(8);
    AppMethodBeat.o(183908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.TabItemView
 * JD-Core Version:    0.7.0.1
 */