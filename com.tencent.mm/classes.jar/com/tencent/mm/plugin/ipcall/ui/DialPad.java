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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DialPad
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final String[] sEk = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#" };
  private static final String[] sEl = { "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", "" };
  private boolean sEj;
  private Map<Integer, DialNumberButton> sEm;
  private Map<String, DialNumberButton> sEn;
  private Map<Integer, View> sEo;
  private a sEp;
  
  public DialPad(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25575);
    this.sEj = false;
    this.sEm = new HashMap();
    this.sEn = new HashMap();
    this.sEo = new HashMap();
    init();
    AppMethodBeat.o(25575);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(25577);
    DialNumberButton localDialNumberButton = (DialNumberButton)findViewById(paramInt);
    localDialNumberButton.gT(paramString1, paramString2);
    localDialNumberButton.setNumberTextSize$255e752(paramFloat);
    localDialNumberButton.setOnClickListener(this);
    localDialNumberButton.setOnLongClickListener(this);
    localDialNumberButton.setInTalkUIMode(this.sEj);
    this.sEm.put(Integer.valueOf(paramInt), localDialNumberButton);
    this.sEn.put(paramString1, localDialNumberButton);
    AppMethodBeat.o(25577);
  }
  
  private void init()
  {
    AppMethodBeat.i(25576);
    LayoutInflater.from(getContext()).inflate(2131493709, this);
    float f1 = getContext().getResources().getDimensionPixelSize(2131166445);
    float f2 = getContext().getResources().getDimensionPixelSize(2131166449);
    float f3 = getContext().getResources().getDimensionPixelSize(2131166448);
    a(2131299103, sEk[0], sEl[0], f1);
    a(2131299109, sEk[1], sEl[1], f1);
    a(2131299108, sEk[2], sEl[2], f1);
    a(2131299101, sEk[3], sEl[3], f1);
    a(2131299100, sEk[4], sEl[4], f1);
    a(2131299106, sEk[5], sEl[5], f1);
    a(2131299104, sEk[6], sEl[6], f1);
    a(2131299099, sEk[7], sEl[7], f1);
    a(2131299102, sEk[8], sEl[8], f1);
    a(2131299107, sEk[9], sEl[9], f3);
    a(2131299110, sEk[10], sEl[10], f1);
    a(2131299105, sEk[11], sEl[11], f2);
    this.sEo.put(Integer.valueOf(2131299165), findViewById(2131299165));
    this.sEo.put(Integer.valueOf(2131299170), findViewById(2131299170));
    this.sEo.put(Integer.valueOf(2131299168), findViewById(2131299168));
    this.sEo.put(Integer.valueOf(2131299161), findViewById(2131299161));
    this.sEo.put(Integer.valueOf(2131299160), findViewById(2131299160));
    Iterator localIterator = this.sEo.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.sEj) {
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
    if (this.sEm.containsKey(Integer.valueOf(???.getId())))
    {
      ??? = (DialNumberButton)this.sEm.get(Integer.valueOf(???.getId()));
      str1 = ???.getNumberText();
      str2 = ???.getOtherText();
      locald = i.cHv();
      i = d.atm(str1);
      if ((i != -1) && (d.dWZ()))
      {
        localObject2 = com.tencent.mm.plugin.audio.c.a.bvB().audioManager;
        ??? = (View)localObject2;
        if (localObject2 == null) {
          ??? = (AudioManager)d.mContext.getSystemService("audio");
        }
        int j = ???.getRingerMode();
        if ((j != 0) && (j != 1)) {
          break label161;
        }
      }
      if (this.sEp != null)
      {
        localObject2 = this.sEp;
        if (bt.isNullOrNil(str1)) {
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
        ((a)localObject2).aeb(???);
        AppMethodBeat.o(25579);
        return;
        synchronized (locald.zur)
        {
          if (locald.zus != null) {
            break;
          }
        }
      }
      locald.zus.startTone(i, 250);
      break;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(25580);
    if (this.sEm.containsKey(Integer.valueOf(paramView.getId())))
    {
      paramView = (DialNumberButton)this.sEm.get(Integer.valueOf(paramView.getId()));
      String str = paramView.getNumberText();
      paramView = paramView.getOtherText();
      if (this.sEp != null)
      {
        a locala = this.sEp;
        if (!bt.isNullOrNil(str)) {
          paramView = str;
        }
        locala.aec(paramView);
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
    ad.i("MicroMsg.DialPad", "onViewAdded, class: %s", new Object[] { paramView.getClass().getSimpleName() });
    AppMethodBeat.o(25581);
  }
  
  public void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(25582);
    ad.i("MicroMsg.DialPad", "onViewRemoved, class: %s", new Object[] { paramView.getClass().getSimpleName() });
    AppMethodBeat.o(25582);
  }
  
  public void setDialButtonClickListener(a parama)
  {
    this.sEp = parama;
  }
  
  public void setTalkUIMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25578);
    this.sEj = paramBoolean;
    Iterator localIterator = this.sEm.values().iterator();
    while (localIterator.hasNext()) {
      ((DialNumberButton)localIterator.next()).setInTalkUIMode(paramBoolean);
    }
    localIterator = this.sEo.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.sEj) {
        localView.setBackgroundDrawable(getResources().getDrawable(2131101015));
      } else {
        localView.setBackgroundDrawable(getResources().getDrawable(2131100236));
      }
    }
    AppMethodBeat.o(25578);
  }
  
  public static abstract interface a
  {
    public abstract void aeb(String paramString);
    
    public abstract void aec(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialPad
 * JD-Core Version:    0.7.0.1
 */