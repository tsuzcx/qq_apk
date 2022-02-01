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
import com.tencent.mm.hellhoundlib.b.b;
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
  private static final String[] uOE = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#" };
  private static final String[] uOF = { "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", "" };
  private boolean uOD;
  private Map<Integer, DialNumberButton> uOG;
  private Map<String, DialNumberButton> uOH;
  private Map<Integer, View> uOI;
  private a uOJ;
  
  public DialPad(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25575);
    this.uOD = false;
    this.uOG = new HashMap();
    this.uOH = new HashMap();
    this.uOI = new HashMap();
    init();
    AppMethodBeat.o(25575);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(25577);
    DialNumberButton localDialNumberButton = (DialNumberButton)findViewById(paramInt);
    localDialNumberButton.hw(paramString1, paramString2);
    localDialNumberButton.setNumberTextSize$255e752(paramFloat);
    localDialNumberButton.setOnClickListener(this);
    localDialNumberButton.setOnLongClickListener(this);
    localDialNumberButton.setInTalkUIMode(this.uOD);
    this.uOG.put(Integer.valueOf(paramInt), localDialNumberButton);
    this.uOH.put(paramString1, localDialNumberButton);
    AppMethodBeat.o(25577);
  }
  
  private void init()
  {
    AppMethodBeat.i(25576);
    LayoutInflater.from(getContext()).inflate(2131493709, this);
    float f1 = getContext().getResources().getDimensionPixelSize(2131166445);
    float f2 = getContext().getResources().getDimensionPixelSize(2131166449);
    float f3 = getContext().getResources().getDimensionPixelSize(2131166448);
    a(2131299103, uOE[0], uOF[0], f1);
    a(2131299109, uOE[1], uOF[1], f1);
    a(2131299108, uOE[2], uOF[2], f1);
    a(2131299101, uOE[3], uOF[3], f1);
    a(2131299100, uOE[4], uOF[4], f1);
    a(2131299106, uOE[5], uOF[5], f1);
    a(2131299104, uOE[6], uOF[6], f1);
    a(2131299099, uOE[7], uOF[7], f1);
    a(2131299102, uOE[8], uOF[8], f1);
    a(2131299107, uOE[9], uOF[9], f3);
    a(2131299110, uOE[10], uOF[10], f1);
    a(2131299105, uOE[11], uOF[11], f2);
    this.uOI.put(Integer.valueOf(2131299165), findViewById(2131299165));
    this.uOI.put(Integer.valueOf(2131299170), findViewById(2131299170));
    this.uOI.put(Integer.valueOf(2131299168), findViewById(2131299168));
    this.uOI.put(Integer.valueOf(2131299161), findViewById(2131299161));
    this.uOI.put(Integer.valueOf(2131299160), findViewById(2131299160));
    Iterator localIterator = this.uOI.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.uOD) {
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
    Object localObject1 = new b();
    ((b)localObject1).bd(???);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).ahq());
    String str;
    d locald;
    int i;
    Object localObject3;
    if (this.uOG.containsKey(Integer.valueOf(???.getId())))
    {
      ??? = (DialNumberButton)this.uOG.get(Integer.valueOf(???.getId()));
      localObject1 = ???.getNumberText();
      str = ???.getOtherText();
      locald = i.ddR();
      i = d.aDM((String)localObject1);
      if ((i != -1) && (d.eAp()))
      {
        localObject3 = com.tencent.mm.plugin.audio.c.a.bGC().audioManager;
        ??? = (View)localObject3;
        if (localObject3 == null) {
          ??? = (AudioManager)d.mContext.getSystemService("audio");
        }
        int j = ???.getRingerMode();
        if ((j != 0) && (j != 1)) {
          break label205;
        }
      }
      if (this.uOJ != null)
      {
        localObject3 = this.uOJ;
        if (bt.isNullOrNil((String)localObject1)) {
          break label257;
        }
      }
    }
    label257:
    for (??? = (View)localObject1;; ??? = str)
    {
      for (;;)
      {
        ((a)localObject3).anG(???);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25579);
        return;
        label205:
        synchronized (locald.Cmw)
        {
          if (locald.Cmx != null) {
            break;
          }
        }
      }
      locald.Cmx.startTone(i, 250);
      break;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(25580);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahq());
    if (this.uOG.containsKey(Integer.valueOf(paramView.getId())))
    {
      paramView = (DialNumberButton)this.uOG.get(Integer.valueOf(paramView.getId()));
      localObject = paramView.getNumberText();
      paramView = paramView.getOtherText();
      if (this.uOJ != null)
      {
        a locala = this.uOJ;
        if (!bt.isNullOrNil((String)localObject)) {
          paramView = (View)localObject;
        }
        locala.anH(paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(25580);
      return true;
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
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
    this.uOJ = parama;
  }
  
  public void setTalkUIMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25578);
    this.uOD = paramBoolean;
    Iterator localIterator = this.uOG.values().iterator();
    while (localIterator.hasNext()) {
      ((DialNumberButton)localIterator.next()).setInTalkUIMode(paramBoolean);
    }
    localIterator = this.uOI.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.uOD) {
        localView.setBackgroundDrawable(getResources().getDrawable(2131101015));
      } else {
        localView.setBackgroundDrawable(getResources().getDrawable(2131100236));
      }
    }
    AppMethodBeat.o(25578);
  }
  
  public static abstract interface a
  {
    public abstract void anG(String paramString);
    
    public abstract void anH(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialPad
 * JD-Core Version:    0.7.0.1
 */