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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DialPad
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final String[] vaq = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#" };
  private static final String[] var = { "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", "" };
  private boolean vap;
  private Map<Integer, DialNumberButton> vas;
  private Map<String, DialNumberButton> vat;
  private Map<Integer, View> vau;
  private a vav;
  
  public DialPad(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25575);
    this.vap = false;
    this.vas = new HashMap();
    this.vat = new HashMap();
    this.vau = new HashMap();
    init();
    AppMethodBeat.o(25575);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(25577);
    DialNumberButton localDialNumberButton = (DialNumberButton)findViewById(paramInt);
    localDialNumberButton.hD(paramString1, paramString2);
    localDialNumberButton.setNumberTextSize$255e752(paramFloat);
    localDialNumberButton.setOnClickListener(this);
    localDialNumberButton.setOnLongClickListener(this);
    localDialNumberButton.setInTalkUIMode(this.vap);
    this.vas.put(Integer.valueOf(paramInt), localDialNumberButton);
    this.vat.put(paramString1, localDialNumberButton);
    AppMethodBeat.o(25577);
  }
  
  private void init()
  {
    AppMethodBeat.i(25576);
    LayoutInflater.from(getContext()).inflate(2131493709, this);
    float f1 = getContext().getResources().getDimensionPixelSize(2131166445);
    float f2 = getContext().getResources().getDimensionPixelSize(2131166449);
    float f3 = getContext().getResources().getDimensionPixelSize(2131166448);
    a(2131299103, vaq[0], var[0], f1);
    a(2131299109, vaq[1], var[1], f1);
    a(2131299108, vaq[2], var[2], f1);
    a(2131299101, vaq[3], var[3], f1);
    a(2131299100, vaq[4], var[4], f1);
    a(2131299106, vaq[5], var[5], f1);
    a(2131299104, vaq[6], var[6], f1);
    a(2131299099, vaq[7], var[7], f1);
    a(2131299102, vaq[8], var[8], f1);
    a(2131299107, vaq[9], var[9], f3);
    a(2131299110, vaq[10], var[10], f1);
    a(2131299105, vaq[11], var[11], f2);
    this.vau.put(Integer.valueOf(2131299165), findViewById(2131299165));
    this.vau.put(Integer.valueOf(2131299170), findViewById(2131299170));
    this.vau.put(Integer.valueOf(2131299168), findViewById(2131299168));
    this.vau.put(Integer.valueOf(2131299161), findViewById(2131299161));
    this.vau.put(Integer.valueOf(2131299160), findViewById(2131299160));
    Iterator localIterator = this.vau.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.vap) {
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).ahF());
    String str;
    d locald;
    int i;
    Object localObject3;
    if (this.vas.containsKey(Integer.valueOf(???.getId())))
    {
      ??? = (DialNumberButton)this.vas.get(Integer.valueOf(???.getId()));
      localObject1 = ???.getNumberText();
      str = ???.getOtherText();
      locald = i.dgJ();
      i = d.aFf((String)localObject1);
      if ((i != -1) && (d.eDX()))
      {
        localObject3 = com.tencent.mm.plugin.audio.c.a.bHy().audioManager;
        ??? = (View)localObject3;
        if (localObject3 == null) {
          ??? = (AudioManager)d.mContext.getSystemService("audio");
        }
        int j = ???.getRingerMode();
        if ((j != 0) && (j != 1)) {
          break label205;
        }
      }
      if (this.vav != null)
      {
        localObject3 = this.vav;
        if (bu.isNullOrNil((String)localObject1)) {
          break label257;
        }
      }
    }
    label257:
    for (??? = (View)localObject1;; ??? = str)
    {
      for (;;)
      {
        ((a)localObject3).aoI(???);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25579);
        return;
        label205:
        synchronized (locald.CEa)
        {
          if (locald.CEb != null) {
            break;
          }
        }
      }
      locald.CEb.startTone(i, 250);
      break;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(25580);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahF());
    if (this.vas.containsKey(Integer.valueOf(paramView.getId())))
    {
      paramView = (DialNumberButton)this.vas.get(Integer.valueOf(paramView.getId()));
      localObject = paramView.getNumberText();
      paramView = paramView.getOtherText();
      if (this.vav != null)
      {
        a locala = this.vav;
        if (!bu.isNullOrNil((String)localObject)) {
          paramView = (View)localObject;
        }
        locala.aoJ(paramView);
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
    ae.i("MicroMsg.DialPad", "onViewAdded, class: %s", new Object[] { paramView.getClass().getSimpleName() });
    AppMethodBeat.o(25581);
  }
  
  public void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(25582);
    ae.i("MicroMsg.DialPad", "onViewRemoved, class: %s", new Object[] { paramView.getClass().getSimpleName() });
    AppMethodBeat.o(25582);
  }
  
  public void setDialButtonClickListener(a parama)
  {
    this.vav = parama;
  }
  
  public void setTalkUIMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25578);
    this.vap = paramBoolean;
    Iterator localIterator = this.vas.values().iterator();
    while (localIterator.hasNext()) {
      ((DialNumberButton)localIterator.next()).setInTalkUIMode(paramBoolean);
    }
    localIterator = this.vau.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.vap) {
        localView.setBackgroundDrawable(getResources().getDrawable(2131101015));
      } else {
        localView.setBackgroundDrawable(getResources().getDrawable(2131100236));
      }
    }
    AppMethodBeat.o(25578);
  }
  
  public static abstract interface a
  {
    public abstract void aoI(String paramString);
    
    public abstract void aoJ(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialPad
 * JD-Core Version:    0.7.0.1
 */