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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.video.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DialPad
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final String[] tLR = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#" };
  private static final String[] tLS = { "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", "" };
  private boolean tLQ;
  private Map<Integer, DialNumberButton> tLT;
  private Map<String, DialNumberButton> tLU;
  private Map<Integer, View> tLV;
  private a tLW;
  
  public DialPad(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25575);
    this.tLQ = false;
    this.tLT = new HashMap();
    this.tLU = new HashMap();
    this.tLV = new HashMap();
    init();
    AppMethodBeat.o(25575);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(25577);
    DialNumberButton localDialNumberButton = (DialNumberButton)findViewById(paramInt);
    localDialNumberButton.hk(paramString1, paramString2);
    localDialNumberButton.setNumberTextSize$255e752(paramFloat);
    localDialNumberButton.setOnClickListener(this);
    localDialNumberButton.setOnLongClickListener(this);
    localDialNumberButton.setInTalkUIMode(this.tLQ);
    this.tLT.put(Integer.valueOf(paramInt), localDialNumberButton);
    this.tLU.put(paramString1, localDialNumberButton);
    AppMethodBeat.o(25577);
  }
  
  private void init()
  {
    AppMethodBeat.i(25576);
    LayoutInflater.from(getContext()).inflate(2131493709, this);
    float f1 = getContext().getResources().getDimensionPixelSize(2131166445);
    float f2 = getContext().getResources().getDimensionPixelSize(2131166449);
    float f3 = getContext().getResources().getDimensionPixelSize(2131166448);
    a(2131299103, tLR[0], tLS[0], f1);
    a(2131299109, tLR[1], tLS[1], f1);
    a(2131299108, tLR[2], tLS[2], f1);
    a(2131299101, tLR[3], tLS[3], f1);
    a(2131299100, tLR[4], tLS[4], f1);
    a(2131299106, tLR[5], tLS[5], f1);
    a(2131299104, tLR[6], tLS[6], f1);
    a(2131299099, tLR[7], tLS[7], f1);
    a(2131299102, tLR[8], tLS[8], f1);
    a(2131299107, tLR[9], tLS[9], f3);
    a(2131299110, tLR[10], tLS[10], f1);
    a(2131299105, tLR[11], tLS[11], f2);
    this.tLV.put(Integer.valueOf(2131299165), findViewById(2131299165));
    this.tLV.put(Integer.valueOf(2131299170), findViewById(2131299170));
    this.tLV.put(Integer.valueOf(2131299168), findViewById(2131299168));
    this.tLV.put(Integer.valueOf(2131299161), findViewById(2131299161));
    this.tLV.put(Integer.valueOf(2131299160), findViewById(2131299160));
    Iterator localIterator = this.tLV.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.tLQ) {
        localView.setBackgroundDrawable(getResources().getDrawable(2131101015));
      } else {
        localView.setBackgroundDrawable(getResources().getDrawable(2131100236));
      }
    }
    setClipToPadding(false);
    setClipChildren(false);
    AppMethodBeat.o(25576);
  }
  
  public void onClick(View arg1)
  {
    AppMethodBeat.i(25579);
    String str1;
    String str2;
    d locald;
    int i;
    Object localObject2;
    if (this.tLT.containsKey(Integer.valueOf(???.getId())))
    {
      ??? = (DialNumberButton)this.tLT.get(Integer.valueOf(???.getId()));
      str1 = ???.getNumberText();
      str2 = ???.getOtherText();
      locald = i.cUG();
      i = d.ayE(str1);
      if ((i != -1) && (d.emt()))
      {
        localObject2 = com.tencent.mm.plugin.audio.c.a.bCx().audioManager;
        ??? = (View)localObject2;
        if (localObject2 == null) {
          ??? = (AudioManager)d.mContext.getSystemService("audio");
        }
        int j = ???.getRingerMode();
        if ((j != 0) && (j != 1)) {
          break label161;
        }
      }
      if (this.tLW != null)
      {
        localObject2 = this.tLW;
        if (bs.isNullOrNil(str1)) {
          break label213;
        }
      }
    }
    label161:
    label213:
    for (??? = str1;; ??? = str2)
    {
      for (;;)
      {
        ((a)localObject2).aiT(???);
        AppMethodBeat.o(25579);
        return;
        synchronized (locald.ANj)
        {
          if (locald.ANk != null) {
            break;
          }
        }
      }
      locald.ANk.startTone(i, 250);
      break;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(25580);
    if (this.tLT.containsKey(Integer.valueOf(paramView.getId())))
    {
      paramView = (DialNumberButton)this.tLT.get(Integer.valueOf(paramView.getId()));
      String str = paramView.getNumberText();
      paramView = paramView.getOtherText();
      if (this.tLW != null)
      {
        a locala = this.tLW;
        if (!bs.isNullOrNil(str)) {
          paramView = str;
        }
        locala.aiU(paramView);
      }
      AppMethodBeat.o(25580);
      return true;
    }
    AppMethodBeat.o(25580);
    return false;
  }
  
  public void onViewAdded(View paramView)
  {
    AppMethodBeat.i(25581);
    ac.i("MicroMsg.DialPad", "onViewAdded, class: %s", new Object[] { paramView.getClass().getSimpleName() });
    AppMethodBeat.o(25581);
  }
  
  public void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(25582);
    ac.i("MicroMsg.DialPad", "onViewRemoved, class: %s", new Object[] { paramView.getClass().getSimpleName() });
    AppMethodBeat.o(25582);
  }
  
  public void setDialButtonClickListener(a parama)
  {
    this.tLW = parama;
  }
  
  public void setTalkUIMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25578);
    this.tLQ = paramBoolean;
    Iterator localIterator = this.tLT.values().iterator();
    while (localIterator.hasNext()) {
      ((DialNumberButton)localIterator.next()).setInTalkUIMode(paramBoolean);
    }
    localIterator = this.tLV.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.tLQ) {
        localView.setBackgroundDrawable(getResources().getDrawable(2131101015));
      } else {
        localView.setBackgroundDrawable(getResources().getDrawable(2131100236));
      }
    }
    AppMethodBeat.o(25578);
  }
  
  public static abstract interface a
  {
    public abstract void aiT(String paramString);
    
    public abstract void aiU(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialPad
 * JD-Core Version:    0.7.0.1
 */