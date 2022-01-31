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
import com.tencent.mm.plugin.game.d.x;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class GameFeedTitleDescView
  extends LinearLayout
{
  private TextView iJG;
  private TextView kPB;
  private LinearLayout nzA;
  
  public GameFeedTitleDescView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static int a(TextView paramTextView, String paramString, int paramInt)
  {
    AppMethodBeat.i(111956);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(111956);
      return 0;
    }
    if (paramTextView.getPaint().measureText(paramString) > paramInt)
    {
      AppMethodBeat.o(111956);
      return 2;
    }
    AppMethodBeat.o(111956);
    return 1;
  }
  
  public final void b(String paramString1, String paramString2, LinkedList<x> paramLinkedList)
  {
    AppMethodBeat.i(111955);
    if ((bo.isNullOrNil(paramString1)) && (bo.isNullOrNil(paramString2)))
    {
      setVisibility(8);
      AppMethodBeat.o(111955);
      return;
    }
    setVisibility(0);
    if (!bo.es(paramLinkedList))
    {
      this.nzA.setVisibility(0);
      Object localObject1;
      Object localObject2;
      while (this.nzA.getChildCount() < paramLinkedList.size() + 1)
      {
        localObject1 = new ImageView(getContext());
        localObject2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(2131427736), getResources().getDimensionPixelSize(2131427736));
        ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, getResources().getDimensionPixelSize(2131427731), 0);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
        this.nzA.addView((View)localObject1, 0, (ViewGroup.LayoutParams)localObject2);
      }
      int i = 0;
      int j;
      for (;;)
      {
        j = i;
        if (i >= paramLinkedList.size()) {
          break;
        }
        localObject1 = (x)paramLinkedList.get(i);
        localObject2 = (ImageView)this.nzA.getChildAt(i);
        e.bHE().j((ImageView)localObject2, ((x)localObject1).nqE);
        ((ImageView)localObject2).setVisibility(0);
        i += 1;
      }
      while (j < this.nzA.getChildCount() - 1)
      {
        this.nzA.getChildAt(j).setVisibility(8);
        j += 1;
      }
      if (!bo.isNullOrNil(paramString1)) {
        ((TextView)this.nzA.getChildAt(j)).setText(paramString1);
      }
      this.iJG.setVisibility(8);
      if (bo.isNullOrNil(paramString2)) {
        break label417;
      }
      this.kPB.setText(paramString2);
      this.kPB.setVisibility(0);
    }
    for (;;)
    {
      if (a(this.iJG, paramString1, c.getScreenWidth(getContext()) - ((ViewGroup)getParent()).getPaddingLeft() - ((ViewGroup)getParent()).getPaddingRight()) <= 1) {
        break label429;
      }
      this.kPB.setMaxLines(1);
      AppMethodBeat.o(111955);
      return;
      this.nzA.setVisibility(8);
      if (!bo.isNullOrNil(paramString1))
      {
        this.iJG.setText(paramString1);
        this.iJG.setVisibility(0);
        break;
      }
      this.iJG.setVisibility(8);
      break;
      label417:
      this.kPB.setVisibility(8);
    }
    label429:
    this.kPB.setMaxLines(2);
    AppMethodBeat.o(111955);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111954);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2130969754, this, true);
    this.nzA = ((LinearLayout)localView.findViewById(2131824632));
    this.iJG = ((TextView)localView.findViewById(2131820680));
    this.kPB = ((TextView)localView.findViewById(2131821115));
    AppMethodBeat.o(111954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedTitleDescView
 * JD-Core Version:    0.7.0.1
 */