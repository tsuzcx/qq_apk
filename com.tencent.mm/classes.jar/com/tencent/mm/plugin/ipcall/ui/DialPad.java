package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.video.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DialPad
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final String[] lsW = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#" };
  private static final String[] lsX = { "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", "" };
  private boolean lsV = false;
  private Map<Integer, DialNumberButton> lsY = new HashMap();
  private Map<String, DialNumberButton> lsZ = new HashMap();
  private Map<Integer, View> lta = new HashMap();
  private DialPad.a ltb;
  
  public DialPad(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void a(int paramInt, String paramString1, String paramString2, float paramFloat)
  {
    DialNumberButton localDialNumberButton = (DialNumberButton)findViewById(paramInt);
    if ((!bk.bl(paramString1)) && (paramString1.length() == 1)) {
      localDialNumberButton.lsT.setText(paramString1);
    }
    if ((bk.bl(paramString2)) && (!"1".equals(paramString1))) {
      localDialNumberButton.lsU.setVisibility(8);
    }
    for (;;)
    {
      localDialNumberButton.lsT.setTextSize(0, paramFloat);
      localDialNumberButton.setOnClickListener(this);
      localDialNumberButton.setOnLongClickListener(this);
      localDialNumberButton.setInTalkUIMode(this.lsV);
      this.lsY.put(Integer.valueOf(paramInt), localDialNumberButton);
      this.lsZ.put(paramString1, localDialNumberButton);
      return;
      localDialNumberButton.lsU.setText(paramString2);
      localDialNumberButton.lsU.setVisibility(0);
    }
  }
  
  private void init()
  {
    LayoutInflater.from(getContext()).inflate(R.i.dial_pad, this);
    float f1 = getContext().getResources().getDimensionPixelSize(R.f.ip_call_dial_button_number_textsize);
    float f2 = getContext().getResources().getDimensionPixelSize(R.f.ip_call_dial_button_special_number_textsize2);
    float f3 = getContext().getResources().getDimensionPixelSize(R.f.ip_call_dial_button_special_number_textsize);
    a(R.h.dial_number_button_one, lsW[0], lsX[0], f1);
    a(R.h.dial_number_button_two, lsW[1], lsX[1], f1);
    a(R.h.dial_number_button_three, lsW[2], lsX[2], f1);
    a(R.h.dial_number_button_four, lsW[3], lsX[3], f1);
    a(R.h.dial_number_button_five, lsW[4], lsX[4], f1);
    a(R.h.dial_number_button_six, lsW[5], lsX[5], f1);
    a(R.h.dial_number_button_seven, lsW[6], lsX[6], f1);
    a(R.h.dial_number_button_eight, lsW[7], lsX[7], f1);
    a(R.h.dial_number_button_night, lsW[8], lsX[8], f1);
    a(R.h.dial_number_button_star, lsW[9], lsX[9], f3);
    a(R.h.dial_number_button_zero, lsW[10], lsX[10], f1);
    a(R.h.dial_number_button_sharp, lsW[11], lsX[11], f2);
    this.lta.put(Integer.valueOf(R.h.divider_one), findViewById(R.h.divider_one));
    this.lta.put(Integer.valueOf(R.h.divider_two), findViewById(R.h.divider_two));
    this.lta.put(Integer.valueOf(R.h.divider_three), findViewById(R.h.divider_three));
    this.lta.put(Integer.valueOf(R.h.divider_four), findViewById(R.h.divider_four));
    this.lta.put(Integer.valueOf(R.h.divider_five), findViewById(R.h.divider_five));
    Iterator localIterator = this.lta.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.lsV) {
        localView.setBackgroundDrawable(getResources().getDrawable(R.e.talk_ui_divider_color));
      } else {
        localView.setBackgroundDrawable(getResources().getDrawable(R.e.dial_ui_divider_color));
      }
    }
    setClipToPadding(false);
    setClipChildren(false);
  }
  
  public void onClick(View arg1)
  {
    String str1;
    String str2;
    d locald;
    int i;
    Object localObject2;
    if (this.lsY.containsKey(Integer.valueOf(???.getId())))
    {
      ??? = (DialNumberButton)this.lsY.get(Integer.valueOf(???.getId()));
      str1 = ???.getNumberText();
      str2 = ???.getOtherText();
      locald = i.bcr();
      i = d.Qd(str1);
      if ((i != -1) && (d.bSx()))
      {
        localObject2 = f.yi().dui;
        ??? = (View)localObject2;
        if (localObject2 == null) {
          ??? = (AudioManager)d.mContext.getSystemService("audio");
        }
        int j = ???.getRingerMode();
        if ((j != 0) && (j != 1)) {
          break label149;
        }
      }
      if (this.ltb != null)
      {
        localObject2 = this.ltb;
        if (bk.bl(str1)) {
          break label195;
        }
      }
    }
    label149:
    label195:
    for (??? = str1;; ??? = str2)
    {
      for (;;)
      {
        ((DialPad.a)localObject2).FF(???);
        return;
        synchronized (locald.qaq)
        {
          if (locald.qar != null) {
            break;
          }
        }
      }
      locald.qar.startTone(i, 250);
      break;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.lsY.containsKey(Integer.valueOf(paramView.getId())))
    {
      paramView = (DialNumberButton)this.lsY.get(Integer.valueOf(paramView.getId()));
      String str = paramView.getNumberText();
      paramView = paramView.getOtherText();
      if (this.ltb != null)
      {
        DialPad.a locala = this.ltb;
        if (!bk.bl(str)) {
          paramView = str;
        }
        locala.FG(paramView);
      }
      return true;
    }
    return false;
  }
  
  public void onViewAdded(View paramView)
  {
    y.i("MicroMsg.DialPad", "onViewAdded, class: %s", new Object[] { paramView.getClass().getSimpleName() });
  }
  
  public void onViewRemoved(View paramView)
  {
    y.i("MicroMsg.DialPad", "onViewRemoved, class: %s", new Object[] { paramView.getClass().getSimpleName() });
  }
  
  public void setDialButtonClickListener(DialPad.a parama)
  {
    this.ltb = parama;
  }
  
  public void setTalkUIMode(boolean paramBoolean)
  {
    this.lsV = paramBoolean;
    Iterator localIterator = this.lsY.values().iterator();
    while (localIterator.hasNext()) {
      ((DialNumberButton)localIterator.next()).setInTalkUIMode(paramBoolean);
    }
    localIterator = this.lta.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.lsV) {
        localView.setBackgroundDrawable(getResources().getDrawable(R.e.talk_ui_divider_color));
      } else {
        localView.setBackgroundDrawable(getResources().getDrawable(R.e.dial_ui_divider_color));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialPad
 * JD-Core Version:    0.7.0.1
 */