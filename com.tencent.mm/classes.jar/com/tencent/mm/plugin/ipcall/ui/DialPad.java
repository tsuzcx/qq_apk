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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ipcall.model.h;
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
  private static final String[] JKe = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#" };
  private static final String[] JKf = { "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", "" };
  private boolean JKd;
  private Map<Integer, DialNumberButton> JKg;
  private Map<String, DialNumberButton> JKh;
  private Map<Integer, View> JKi;
  private a JKj;
  
  public DialPad(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25575);
    this.JKd = false;
    this.JKg = new HashMap();
    this.JKh = new HashMap();
    this.JKi = new HashMap();
    init();
    AppMethodBeat.o(25575);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(25577);
    DialNumberButton localDialNumberButton = (DialNumberButton)findViewById(paramInt);
    localDialNumberButton.jI(paramString1, paramString2);
    localDialNumberButton.cw(paramFloat);
    localDialNumberButton.setOnClickListener(this);
    localDialNumberButton.setOnLongClickListener(this);
    localDialNumberButton.setInTalkUIMode(this.JKd);
    this.JKg.put(Integer.valueOf(paramInt), localDialNumberButton);
    this.JKh.put(paramString1, localDialNumberButton);
    AppMethodBeat.o(25577);
  }
  
  private void init()
  {
    AppMethodBeat.i(25576);
    LayoutInflater.from(getContext()).inflate(R.i.fFN, this);
    float f1 = getContext().getResources().getDimensionPixelSize(R.f.flH);
    float f2 = getContext().getResources().getDimensionPixelSize(R.f.flJ);
    float f3 = getContext().getResources().getDimensionPixelSize(R.f.flI);
    a(R.h.fFF, JKe[0], JKf[0], f1);
    a(R.h.fFL, JKe[1], JKf[1], f1);
    a(R.h.fFK, JKe[2], JKf[2], f1);
    a(R.h.fFD, JKe[3], JKf[3], f1);
    a(R.h.fFC, JKe[4], JKf[4], f1);
    a(R.h.fFI, JKe[5], JKf[5], f1);
    a(R.h.fFG, JKe[6], JKf[6], f1);
    a(R.h.fFB, JKe[7], JKf[7], f1);
    a(R.h.fFE, JKe[8], JKf[8], f1);
    a(R.h.fFJ, JKe[9], JKf[9], f3);
    a(R.h.fFM, JKe[10], JKf[10], f1);
    a(R.h.fFH, JKe[11], JKf[11], f2);
    this.JKi.put(Integer.valueOf(R.h.fFV), findViewById(R.h.fFV));
    this.JKi.put(Integer.valueOf(R.h.fFX), findViewById(R.h.fFX));
    this.JKi.put(Integer.valueOf(R.h.fFW), findViewById(R.h.fFW));
    this.JKi.put(Integer.valueOf(R.h.fFU), findViewById(R.h.fFU));
    this.JKi.put(Integer.valueOf(R.h.fFT), findViewById(R.h.fFT));
    Iterator localIterator = this.JKi.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.JKd) {
        localView.setBackgroundDrawable(getResources().getDrawable(R.e.flb));
      } else {
        localView.setBackgroundDrawable(getResources().getDrawable(R.e.fkp));
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
    ((b)localObject1).cH(???);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aYj());
    String str;
    c localc;
    int i;
    Object localObject3;
    if (this.JKg.containsKey(Integer.valueOf(???.getId())))
    {
      ??? = (DialNumberButton)this.JKg.get(Integer.valueOf(???.getId()));
      localObject1 = ???.getNumberText();
      str = ???.getOtherText();
      localc = h.fRB();
      i = c.bfP((String)localObject1);
      if ((i != -1) && (c.icg()))
      {
        localObject3 = com.tencent.mm.plugin.audio.c.a.cTW().audioManager;
        ??? = (View)localObject3;
        if (localObject3 == null) {
          ??? = (AudioManager)c.mContext.getSystemService("audio");
        }
        int j = ???.getRingerMode();
        if ((j != 0) && (j != 1)) {
          break label213;
        }
      }
      if (this.JKj != null)
      {
        localObject3 = this.JKj;
        if (Util.isNullOrNil((String)localObject1)) {
          break label265;
        }
      }
    }
    label265:
    for (??? = (View)localObject1;; ??? = str)
    {
      for (;;)
      {
        ((a)localObject3).aJd(???);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25579);
        return;
        label213:
        synchronized (localc.UMh)
        {
          if (localc.UMi != null) {
            break;
          }
        }
      }
      localc.UMi.startTone(i, 250);
      break;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(25580);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aYj());
    if (this.JKg.containsKey(Integer.valueOf(paramView.getId())))
    {
      paramView = (DialNumberButton)this.JKg.get(Integer.valueOf(paramView.getId()));
      localObject = paramView.getNumberText();
      paramView = paramView.getOtherText();
      if (this.JKj != null)
      {
        a locala = this.JKj;
        if (!Util.isNullOrNil((String)localObject)) {
          paramView = (View)localObject;
        }
        locala.aJe(paramView);
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
    this.JKj = parama;
  }
  
  public void setTalkUIMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25578);
    this.JKd = paramBoolean;
    Iterator localIterator = this.JKg.values().iterator();
    while (localIterator.hasNext()) {
      ((DialNumberButton)localIterator.next()).setInTalkUIMode(paramBoolean);
    }
    localIterator = this.JKi.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.JKd) {
        localView.setBackgroundDrawable(getResources().getDrawable(R.e.flb));
      } else {
        localView.setBackgroundDrawable(getResources().getDrawable(R.e.fkp));
      }
    }
    AppMethodBeat.o(25578);
  }
  
  public static abstract interface a
  {
    public abstract void aJd(String paramString);
    
    public abstract void aJe(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialPad
 * JD-Core Version:    0.7.0.1
 */