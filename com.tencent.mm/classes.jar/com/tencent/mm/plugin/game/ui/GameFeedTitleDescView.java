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
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.protobuf.ah;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameFeedTitleDescView
  extends LinearLayout
{
  private LinearLayout CWV;
  private TextView mMA;
  private TextView pPT;
  
  public GameFeedTitleDescView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static int b(TextView paramTextView, String paramString, int paramInt)
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
  
  public final void a(String paramString1, String paramString2, LinkedList<ah> paramLinkedList)
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
      this.CWV.setVisibility(0);
      Object localObject1;
      Object localObject2;
      while (this.CWV.getChildCount() < paramLinkedList.size() + 1)
      {
        localObject1 = new ImageView(getContext());
        localObject2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(g.c.CgX), getResources().getDimensionPixelSize(g.c.CgX));
        ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, getResources().getDimensionPixelSize(g.c.CgU), 0);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
        this.CWV.addView((View)localObject1, 0, (ViewGroup.LayoutParams)localObject2);
      }
      int i = 0;
      int j;
      for (;;)
      {
        j = i;
        if (i >= paramLinkedList.size()) {
          break;
        }
        localObject1 = (ah)paramLinkedList.get(i);
        localObject2 = (ImageView)this.CWV.getChildAt(i);
        e.eAa().p((ImageView)localObject2, ((ah)localObject1).CNM);
        ((ImageView)localObject2).setVisibility(0);
        i += 1;
      }
      while (j < this.CWV.getChildCount() - 1)
      {
        this.CWV.getChildAt(j).setVisibility(8);
        j += 1;
      }
      if (!Util.isNullOrNil(paramString1)) {
        ((TextView)this.CWV.getChildAt(j)).setText(paramString1);
      }
      this.pPT.setVisibility(8);
      if (Util.isNullOrNil(paramString2)) {
        break label420;
      }
      this.mMA.setText(paramString2);
      this.mMA.setVisibility(0);
    }
    for (;;)
    {
      if (b(this.pPT, paramString1, c.getScreenWidth(getContext()) - ((ViewGroup)getParent()).getPaddingLeft() - ((ViewGroup)getParent()).getPaddingRight()) <= 1) {
        break label432;
      }
      this.mMA.setMaxLines(1);
      AppMethodBeat.o(42137);
      return;
      this.CWV.setVisibility(8);
      if (!Util.isNullOrNil(paramString1))
      {
        this.pPT.setText(paramString1);
        this.pPT.setVisibility(0);
        break;
      }
      this.pPT.setVisibility(8);
      break;
      label420:
      this.mMA.setVisibility(8);
    }
    label432:
    this.mMA.setMaxLines(2);
    AppMethodBeat.o(42137);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42136);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(g.f.Cnm, this, true);
    this.CWV = ((LinearLayout)localView.findViewById(g.e.ClU));
    this.pPT = ((TextView)localView.findViewById(g.e.title));
    this.mMA = ((TextView)localView.findViewById(g.e.desc));
    AppMethodBeat.o(42136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedTitleDescView
 * JD-Core Version:    0.7.0.1
 */