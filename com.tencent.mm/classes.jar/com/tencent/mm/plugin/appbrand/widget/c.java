package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.j.g;
import com.tencent.luggage.l.a.d;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends FrameLayout
{
  public LinearLayout hnF;
  private ImageView hnG;
  public String hnH;
  private int hnI;
  private int hnJ;
  public LinkedList<c.a> hnK = new LinkedList();
  private int hnL = 0;
  private c.b hnM;
  private int mHeight = 0;
  
  public c(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.hnG = new ImageView(paramContext);
    this.hnG.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    addView(this.hnG);
    this.hnF = new LinearLayout(paramContext);
    this.hnF.setOrientation(0);
    this.hnF.setGravity(16);
    this.hnF.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    addView(this.hnF);
  }
  
  private void a(Animator paramAnimator, Runnable paramRunnable)
  {
    paramAnimator.addListener(new c.6(this, paramRunnable));
    paramAnimator.start();
  }
  
  public static Bitmap wW(String paramString)
  {
    paramString = Base64.decode(paramString, 0);
    return BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
  }
  
  public final void a(View paramView, c.a parama)
  {
    int j = 0;
    ImageView localImageView1 = (ImageView)paramView.findViewById(a.d.icon);
    TextView localTextView1 = (TextView)paramView.findViewById(a.d.badge);
    ImageView localImageView2 = (ImageView)paramView.findViewById(a.d.reddot);
    TextView localTextView2 = (TextView)paramView.findViewById(a.d.text);
    View localView = paramView.findViewById(a.d.indicator);
    int i;
    if ("top".equals(this.hnH))
    {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(0, a.fromDPToPix(getContext(), 40), 1.0F));
      localImageView1.setVisibility(8);
      localTextView2.setTextSize(1, 14.0F);
      if (parama.hnW)
      {
        localView.setBackgroundColor(this.hnJ);
        localView.setVisibility(0);
        paramView = localTextView1.getBackground();
        if (paramView != null) {
          paramView.setColorFilter(parama.hnZ, PorterDuff.Mode.SRC_ATOP);
        }
        if (!parama.hnY.isEmpty()) {
          break label496;
        }
        i = 4;
        label165:
        localTextView1.setVisibility(i);
        localTextView1.setText(parama.hnY);
        localTextView1.setTextColor(parama.hoa);
        if (!parama.hnX) {
          break label501;
        }
        i = j;
        label199:
        localImageView2.setVisibility(i);
        if ((!parama.hnW) || (parama.hnU == null)) {
          break label506;
        }
        localImageView1.setImageBitmap(parama.hnU);
      }
    }
    for (;;)
    {
      localTextView2.setText(parama.hnV);
      if (!parama.hnW) {
        break label518;
      }
      localTextView2.setTextColor(this.hnJ);
      return;
      localView.setVisibility(4);
      break;
      if (parama.BP != null) {
        if (parama.hnV != null)
        {
          paramView.setLayoutParams(new LinearLayout.LayoutParams(0, a.fromDPToPix(getContext(), 54), 1.0F));
          localImageView1.setVisibility(0);
          localImageView1.getLayoutParams().width = a.fromDPToPix(getContext(), 32);
          localImageView1.getLayoutParams().height = a.fromDPToPix(getContext(), 28);
          localTextView2.setVisibility(0);
          localTextView2.setTextSize(1, 12.0F);
        }
      }
      for (;;)
      {
        localView.setVisibility(4);
        break;
        paramView.setLayoutParams(new LinearLayout.LayoutParams(0, a.fromDPToPix(getContext(), 48), 1.0F));
        localImageView1.setVisibility(0);
        localImageView1.getLayoutParams().width = a.fromDPToPix(getContext(), 36);
        localImageView1.getLayoutParams().height = a.fromDPToPix(getContext(), 36);
        localTextView2.setVisibility(8);
        continue;
        if ((parama.BP == null) && (parama.hnV != null))
        {
          paramView.setLayoutParams(new LinearLayout.LayoutParams(0, a.fromDPToPix(getContext(), 49), 1.0F));
          localImageView1.setVisibility(8);
          localTextView2.setVisibility(0);
          localTextView2.setTextSize(1, 16.0F);
        }
      }
      label496:
      i = 0;
      break label165;
      label501:
      i = 4;
      break label199;
      label506:
      localImageView1.setImageBitmap(parama.BP);
    }
    label518:
    localTextView2.setTextColor(this.hnI);
  }
  
  public final void aqU()
  {
    post(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        while (i < c.d(c.this).size())
        {
          c.a(c.this, c.b(c.this).getChildAt(i), (c.a)c.d(c.this).get(i));
          i += 1;
        }
      }
    });
  }
  
  public final void dL(boolean paramBoolean)
  {
    if (!ai.isMainThread())
    {
      ai.d(new c.3(this, paramBoolean));
      return;
    }
    int j = getHeight();
    int i;
    ObjectAnimator localObjectAnimator;
    if ("top".equals(this.hnH))
    {
      i = -1;
      localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, i * j });
      if (!paramBoolean) {
        break label98;
      }
    }
    label98:
    for (long l = 250L;; l = 0L)
    {
      localObjectAnimator.setDuration(l);
      a(localObjectAnimator, new c.4(this));
      return;
      i = 1;
      break;
    }
  }
  
  public final String getPosition()
  {
    return this.hnH;
  }
  
  public final void h(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    post(new c.1(this, paramString1, paramString2, paramString3, paramString4));
  }
  
  public final void mC(int paramInt)
  {
    ((c.a)this.hnK.get(this.hnL)).hnW = false;
    if ((paramInt > 0) && (paramInt < this.hnK.size())) {}
    for (this.hnL = paramInt;; this.hnL = 0)
    {
      ((c.a)this.hnK.get(this.hnL)).hnW = true;
      aqU();
      return;
    }
  }
  
  public final void setClickListener(c.b paramb)
  {
    this.hnM = paramb;
  }
  
  public final void setPosition(String paramString)
  {
    this.hnH = paramString;
  }
  
  public final int wX(String paramString)
  {
    LinkedList localLinkedList = this.hnK;
    String str = g.bi(paramString);
    Iterator localIterator = this.hnK.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramString = (c.a)localIterator.next();
    } while (!g.bi(paramString.mUrl).equals(str));
    for (;;)
    {
      return localLinkedList.indexOf(paramString);
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c
 * JD-Core Version:    0.7.0.1
 */