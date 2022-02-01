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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.f.a;
import com.tencent.mm.plugin.game.model.s;

public class TabItemView
  extends LinearLayout
{
  private int dcz;
  private TextView snS;
  private TextView snT;
  private View snU;
  
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
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, f.a.TabItemView);
    String str = paramAttributeSet.getString(0);
    paramAttributeSet.recycle();
    LayoutInflater.from(paramContext).inflate(2131494353, this, true);
    this.snS = ((TextView)findViewById(2131305601));
    this.snT = ((TextView)findViewById(2131305600));
    this.snU = findViewById(2131305599);
    this.snS.setText(str);
    AppMethodBeat.o(183910);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(183909);
    if (paramBoolean)
    {
      this.snS.setTextColor(getResources().getColor(2131100711));
      this.snU.setVisibility(0);
      this.snT.setVisibility(8);
      ((e)g.ab(e.class)).cBd().execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where showType=".concat(String.valueOf(this.dcz)));
      AppMethodBeat.o(183909);
      return;
    }
    this.snS.setTextColor(getResources().getColor(2131100212));
    this.snU.setVisibility(8);
    AppMethodBeat.o(183909);
  }
  
  public void setShowType(int paramInt)
  {
    this.dcz = paramInt;
  }
  
  public void setUnreadCount(int paramInt)
  {
    AppMethodBeat.i(183908);
    if (paramInt > 0)
    {
      this.snT.setVisibility(0);
      if (paramInt < 100)
      {
        this.snT.setText(String.valueOf(paramInt));
        AppMethodBeat.o(183908);
        return;
      }
      this.snT.setText(2131759956);
      AppMethodBeat.o(183908);
      return;
    }
    this.snT.setVisibility(8);
    AppMethodBeat.o(183908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.TabItemView
 * JD-Core Version:    0.7.0.1
 */