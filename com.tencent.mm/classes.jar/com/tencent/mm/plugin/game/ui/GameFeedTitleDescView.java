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
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.protobuf.ag;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameFeedTitleDescView
  extends LinearLayout
{
  private TextView jVn;
  private TextView mPa;
  private LinearLayout xSK;
  
  public GameFeedTitleDescView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static int a(TextView paramTextView, String paramString, int paramInt)
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
  
  public final void b(String paramString1, String paramString2, LinkedList<ag> paramLinkedList)
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
      this.xSK.setVisibility(0);
      Object localObject1;
      Object localObject2;
      while (this.xSK.getChildCount() < paramLinkedList.size() + 1)
      {
        localObject1 = new ImageView(getContext());
        localObject2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(2131165460), getResources().getDimensionPixelSize(2131165460));
        ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, getResources().getDimensionPixelSize(2131165453), 0);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
        this.xSK.addView((View)localObject1, 0, (ViewGroup.LayoutParams)localObject2);
      }
      int i = 0;
      int j;
      for (;;)
      {
        j = i;
        if (i >= paramLinkedList.size()) {
          break;
        }
        localObject1 = (ag)paramLinkedList.get(i);
        localObject2 = (ImageView)this.xSK.getChildAt(i);
        e.dWR().p((ImageView)localObject2, ((ag)localObject1).xJE);
        ((ImageView)localObject2).setVisibility(0);
        i += 1;
      }
      while (j < this.xSK.getChildCount() - 1)
      {
        this.xSK.getChildAt(j).setVisibility(8);
        j += 1;
      }
      if (!Util.isNullOrNil(paramString1)) {
        ((TextView)this.xSK.getChildAt(j)).setText(paramString1);
      }
      this.mPa.setVisibility(8);
      if (Util.isNullOrNil(paramString2)) {
        break label417;
      }
      this.jVn.setText(paramString2);
      this.jVn.setVisibility(0);
    }
    for (;;)
    {
      if (a(this.mPa, paramString1, c.getScreenWidth(getContext()) - ((ViewGroup)getParent()).getPaddingLeft() - ((ViewGroup)getParent()).getPaddingRight()) <= 1) {
        break label429;
      }
      this.jVn.setMaxLines(1);
      AppMethodBeat.o(42137);
      return;
      this.xSK.setVisibility(8);
      if (!Util.isNullOrNil(paramString1))
      {
        this.mPa.setText(paramString1);
        this.mPa.setVisibility(0);
        break;
      }
      this.mPa.setVisibility(8);
      break;
      label417:
      this.jVn.setVisibility(8);
    }
    label429:
    this.jVn.setMaxLines(2);
    AppMethodBeat.o(42137);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42136);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2131494870, this, true);
    this.xSK = ((LinearLayout)localView.findViewById(2131309649));
    this.mPa = ((TextView)localView.findViewById(2131309195));
    this.jVn = ((TextView)localView.findViewById(2131299495));
    AppMethodBeat.o(42136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedTitleDescView
 * JD-Core Version:    0.7.0.1
 */