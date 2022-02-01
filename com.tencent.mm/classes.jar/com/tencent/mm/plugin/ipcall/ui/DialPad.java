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
import com.tencent.mm.plugin.voip.video.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DialPad
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final String[] ysQ = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#" };
  private static final String[] ysR = { "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", "" };
  private boolean ysP;
  private Map<Integer, DialNumberButton> ysS;
  private Map<String, DialNumberButton> ysT;
  private Map<Integer, View> ysU;
  private a ysV;
  
  public DialPad(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25575);
    this.ysP = false;
    this.ysS = new HashMap();
    this.ysT = new HashMap();
    this.ysU = new HashMap();
    init();
    AppMethodBeat.o(25575);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(25577);
    DialNumberButton localDialNumberButton = (DialNumberButton)findViewById(paramInt);
    localDialNumberButton.il(paramString1, paramString2);
    localDialNumberButton.setNumberTextSize$255e752(paramFloat);
    localDialNumberButton.setOnClickListener(this);
    localDialNumberButton.setOnLongClickListener(this);
    localDialNumberButton.setInTalkUIMode(this.ysP);
    this.ysS.put(Integer.valueOf(paramInt), localDialNumberButton);
    this.ysT.put(paramString1, localDialNumberButton);
    AppMethodBeat.o(25577);
  }
  
  private void init()
  {
    AppMethodBeat.i(25576);
    LayoutInflater.from(getContext()).inflate(2131493841, this);
    float f1 = getContext().getResources().getDimensionPixelSize(2131166538);
    float f2 = getContext().getResources().getDimensionPixelSize(2131166542);
    float f3 = getContext().getResources().getDimensionPixelSize(2131166541);
    a(2131299626, ysQ[0], ysR[0], f1);
    a(2131299632, ysQ[1], ysR[1], f1);
    a(2131299631, ysQ[2], ysR[2], f1);
    a(2131299624, ysQ[3], ysR[3], f1);
    a(2131299623, ysQ[4], ysR[4], f1);
    a(2131299629, ysQ[5], ysR[5], f1);
    a(2131299627, ysQ[6], ysR[6], f1);
    a(2131299622, ysQ[7], ysR[7], f1);
    a(2131299625, ysQ[8], ysR[8], f1);
    a(2131299630, ysQ[9], ysR[9], f3);
    a(2131299633, ysQ[10], ysR[10], f1);
    a(2131299628, ysQ[11], ysR[11], f2);
    this.ysU.put(Integer.valueOf(2131299709), findViewById(2131299709));
    this.ysU.put(Integer.valueOf(2131299714), findViewById(2131299714));
    this.ysU.put(Integer.valueOf(2131299712), findViewById(2131299712));
    this.ysU.put(Integer.valueOf(2131299705), findViewById(2131299705));
    this.ysU.put(Integer.valueOf(2131299704), findViewById(2131299704));
    Iterator localIterator = this.ysU.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.ysP) {
        localView.setBackgroundDrawable(getResources().getDrawable(2131101245));
      } else {
        localView.setBackgroundDrawable(getResources().getDrawable(2131100270));
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
    ((b)localObject1).bm(???);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
    String str;
    c localc;
    int i;
    Object localObject3;
    if (this.ysS.containsKey(Integer.valueOf(???.getId())))
    {
      ??? = (DialNumberButton)this.ysS.get(Integer.valueOf(???.getId()));
      localObject1 = ???.getNumberText();
      str = ???.getOtherText();
      localc = i.eaD();
      i = c.aUD((String)localObject1);
      if ((i != -1) && (c.fKK()))
      {
        localObject3 = com.tencent.mm.plugin.audio.c.a.cea().audioManager;
        ??? = (View)localObject3;
        if (localObject3 == null) {
          ??? = (AudioManager)c.mContext.getSystemService("audio");
        }
        int j = ???.getRingerMode();
        if ((j != 0) && (j != 1)) {
          break label205;
        }
      }
      if (this.ysV != null)
      {
        localObject3 = this.ysV;
        if (Util.isNullOrNil((String)localObject1)) {
          break label257;
        }
      }
    }
    label257:
    for (??? = (View)localObject1;; ??? = str)
    {
      for (;;)
      {
        ((a)localObject3).aCc(???);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25579);
        return;
        label205:
        synchronized (localc.Hhv)
        {
          if (localc.Hhw != null) {
            break;
          }
        }
      }
      localc.Hhw.startTone(i, 250);
      break;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(25580);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
    if (this.ysS.containsKey(Integer.valueOf(paramView.getId())))
    {
      paramView = (DialNumberButton)this.ysS.get(Integer.valueOf(paramView.getId()));
      localObject = paramView.getNumberText();
      paramView = paramView.getOtherText();
      if (this.ysV != null)
      {
        a locala = this.ysV;
        if (!Util.isNullOrNil((String)localObject)) {
          paramView = (View)localObject;
        }
        locala.aCd(paramView);
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
    Log.i("MicroMsg.DialPad", "onViewAdded, class: %s", new Object[] { paramView.getClass().getSimpleName() });
    AppMethodBeat.o(25581);
  }
  
  public void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(25582);
    Log.i("MicroMsg.DialPad", "onViewRemoved, class: %s", new Object[] { paramView.getClass().getSimpleName() });
    AppMethodBeat.o(25582);
  }
  
  public void setDialButtonClickListener(a parama)
  {
    this.ysV = parama;
  }
  
  public void setTalkUIMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25578);
    this.ysP = paramBoolean;
    Iterator localIterator = this.ysS.values().iterator();
    while (localIterator.hasNext()) {
      ((DialNumberButton)localIterator.next()).setInTalkUIMode(paramBoolean);
    }
    localIterator = this.ysU.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.ysP) {
        localView.setBackgroundDrawable(getResources().getDrawable(2131101245));
      } else {
        localView.setBackgroundDrawable(getResources().getDrawable(2131100270));
      }
    }
    AppMethodBeat.o(25578);
  }
  
  public static abstract interface a
  {
    public abstract void aCc(String paramString);
    
    public abstract void aCd(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialPad
 * JD-Core Version:    0.7.0.1
 */