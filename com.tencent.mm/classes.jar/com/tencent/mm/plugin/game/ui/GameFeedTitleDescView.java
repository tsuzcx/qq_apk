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
import com.tencent.mm.plugin.game.d.aa;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public class GameFeedTitleDescView
  extends LinearLayout
{
  private TextView lCL;
  private TextView lDu;
  private LinearLayout upq;
  
  public GameFeedTitleDescView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static int a(TextView paramTextView, String paramString, int paramInt)
  {
    AppMethodBeat.i(42138);
    if (bt.isNullOrNil(paramString))
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
  
  public final void b(String paramString1, String paramString2, LinkedList<aa> paramLinkedList)
  {
    AppMethodBeat.i(42137);
    if ((bt.isNullOrNil(paramString1)) && (bt.isNullOrNil(paramString2)))
    {
      setVisibility(8);
      AppMethodBeat.o(42137);
      return;
    }
    setVisibility(0);
    if (!bt.hj(paramLinkedList))
    {
      this.upq.setVisibility(0);
      Object localObject1;
      Object localObject2;
      while (this.upq.getChildCount() < paramLinkedList.size() + 1)
      {
        localObject1 = new ImageView(getContext());
        localObject2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(2131165444), getResources().getDimensionPixelSize(2131165444));
        ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, getResources().getDimensionPixelSize(2131165437), 0);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
        this.upq.addView((View)localObject1, 0, (ViewGroup.LayoutParams)localObject2);
      }
      int i = 0;
      int j;
      for (;;)
      {
        j = i;
        if (i >= paramLinkedList.size()) {
          break;
        }
        localObject1 = (aa)paramLinkedList.get(i);
        localObject2 = (ImageView)this.upq.getChildAt(i);
        e.dav().m((ImageView)localObject2, ((aa)localObject1).ufR);
        ((ImageView)localObject2).setVisibility(0);
        i += 1;
      }
      while (j < this.upq.getChildCount() - 1)
      {
        this.upq.getChildAt(j).setVisibility(8);
        j += 1;
      }
      if (!bt.isNullOrNil(paramString1)) {
        ((TextView)this.upq.getChildAt(j)).setText(paramString1);
      }
      this.lCL.setVisibility(8);
      if (bt.isNullOrNil(paramString2)) {
        break label417;
      }
      this.lDu.setText(paramString2);
      this.lDu.setVisibility(0);
    }
    for (;;)
    {
      if (a(this.lCL, paramString1, c.getScreenWidth(getContext()) - ((ViewGroup)getParent()).getPaddingLeft() - ((ViewGroup)getParent()).getPaddingRight()) <= 1) {
        break label429;
      }
      this.lDu.setMaxLines(1);
      AppMethodBeat.o(42137);
      return;
      this.upq.setVisibility(8);
      if (!bt.isNullOrNil(paramString1))
      {
        this.lCL.setText(paramString1);
        this.lCL.setVisibility(0);
        break;
      }
      this.lCL.setVisibility(8);
      break;
      label417:
      this.lDu.setVisibility(8);
    }
    label429:
    this.lDu.setMaxLines(2);
    AppMethodBeat.o(42137);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42136);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2131494308, this, true);
    this.upq = ((LinearLayout)localView.findViewById(2131306250));
    this.lCL = ((TextView)localView.findViewById(2131305902));
    this.lDu = ((TextView)localView.findViewById(2131298996));
    AppMethodBeat.o(42136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedTitleDescView
 * JD-Core Version:    0.7.0.1
 */