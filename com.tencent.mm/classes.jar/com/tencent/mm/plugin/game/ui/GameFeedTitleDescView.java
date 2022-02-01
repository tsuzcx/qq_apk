package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.h.c;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.protobuf.ai;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameFeedTitleDescView
  extends LinearLayout
{
  private LinearLayout IRm;
  private TextView pJi;
  private TextView sUt;
  
  public GameFeedTitleDescView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static int d(TextView paramTextView, String paramString, int paramInt)
  {
    AppMethodBeat.i(42138);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42138);
      return 0;
    }
    if (paramTextView.getPaint().measureText(paramString) > paramInt)
    {
      AppMethodBeat.o(42138);
      return 2;
    }
    AppMethodBeat.o(42138);
    return 1;
  }
  
  public final void a(String paramString1, String paramString2, LinkedList<ai> paramLinkedList)
  {
    AppMethodBeat.i(42137);
    if ((Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2)))
    {
      setVisibility(8);
      AppMethodBeat.o(42137);
      return;
    }
    setVisibility(0);
    if (!Util.isNullOrNil(paramLinkedList))
    {
      this.IRm.setVisibility(0);
      Object localObject1;
      Object localObject2;
      while (this.IRm.getChildCount() < paramLinkedList.size() + 1)
      {
        localObject1 = new ImageView(getContext());
        localObject2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(h.c.HTg), getResources().getDimensionPixelSize(h.c.HTg));
        ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, getResources().getDimensionPixelSize(h.c.HTd), 0);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
        this.IRm.addView((View)localObject1, 0, (ViewGroup.LayoutParams)localObject2);
      }
      int i = 0;
      int j;
      for (;;)
      {
        j = i;
        if (i >= paramLinkedList.size()) {
          break;
        }
        localObject1 = (ai)paramLinkedList.get(i);
        localObject2 = (ImageView)this.IRm.getChildAt(i);
        e.fIb().q((ImageView)localObject2, ((ai)localObject1).IHW);
        ((ImageView)localObject2).setVisibility(0);
        i += 1;
      }
      while (j < this.IRm.getChildCount() - 1)
      {
        this.IRm.getChildAt(j).setVisibility(8);
        j += 1;
      }
      if (!Util.isNullOrNil(paramString1)) {
        ((TextView)this.IRm.getChildAt(j)).setText(paramString1);
      }
      this.sUt.setVisibility(8);
      if (Util.isNullOrNil(paramString2)) {
        break label420;
      }
      this.pJi.setText(paramString2);
      this.pJi.setVisibility(0);
    }
    for (;;)
    {
      if (d(this.sUt, paramString1, c.getScreenWidth(getContext()) - ((ViewGroup)getParent()).getPaddingLeft() - ((ViewGroup)getParent()).getPaddingRight()) <= 1) {
        break label432;
      }
      this.pJi.setMaxLines(1);
      AppMethodBeat.o(42137);
      return;
      this.IRm.setVisibility(8);
      if (!Util.isNullOrNil(paramString1))
      {
        this.sUt.setText(paramString1);
        this.sUt.setVisibility(0);
        break;
      }
      this.sUt.setVisibility(8);
      break;
      label420:
      this.pJi.setVisibility(8);
    }
    label432:
    this.pJi.setMaxLines(2);
    AppMethodBeat.o(42137);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42136);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(h.f.HZu, this, true);
    this.IRm = ((LinearLayout)localView.findViewById(h.e.HYc));
    this.sUt = ((TextView)localView.findViewById(h.e.title));
    this.pJi = ((TextView)localView.findViewById(h.e.desc));
    AppMethodBeat.o(42136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedTitleDescView
 * JD-Core Version:    0.7.0.1
 */