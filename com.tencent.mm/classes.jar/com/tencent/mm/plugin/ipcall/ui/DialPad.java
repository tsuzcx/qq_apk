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
  private static final String[] DSU = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#" };
  private static final String[] DSV = { "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", "" };
  private boolean DST;
  private Map<Integer, DialNumberButton> DSW;
  private Map<String, DialNumberButton> DSX;
  private Map<Integer, View> DSY;
  private a DSZ;
  
  public DialPad(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25575);
    this.DST = false;
    this.DSW = new HashMap();
    this.DSX = new HashMap();
    this.DSY = new HashMap();
    init();
    AppMethodBeat.o(25575);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(25577);
    DialNumberButton localDialNumberButton = (DialNumberButton)findViewById(paramInt);
    localDialNumberButton.iy(paramString1, paramString2);
    localDialNumberButton.bs(paramFloat);
    localDialNumberButton.setOnClickListener(this);
    localDialNumberButton.setOnLongClickListener(this);
    localDialNumberButton.setInTalkUIMode(this.DST);
    this.DSW.put(Integer.valueOf(paramInt), localDialNumberButton);
    this.DSX.put(paramString1, localDialNumberButton);
    AppMethodBeat.o(25577);
  }
  
  private void init()
  {
    AppMethodBeat.i(25576);
    LayoutInflater.from(getContext()).inflate(R.i.dEI, this);
    float f1 = getContext().getResources().getDimensionPixelSize(R.f.dlr);
    float f2 = getContext().getResources().getDimensionPixelSize(R.f.dlt);
    float f3 = getContext().getResources().getDimensionPixelSize(R.f.dls);
    a(R.h.dEA, DSU[0], DSV[0], f1);
    a(R.h.dEG, DSU[1], DSV[1], f1);
    a(R.h.dEF, DSU[2], DSV[2], f1);
    a(R.h.dEy, DSU[3], DSV[3], f1);
    a(R.h.dEx, DSU[4], DSV[4], f1);
    a(R.h.dED, DSU[5], DSV[5], f1);
    a(R.h.dEB, DSU[6], DSV[6], f1);
    a(R.h.dEw, DSU[7], DSV[7], f1);
    a(R.h.dEz, DSU[8], DSV[8], f1);
    a(R.h.dEE, DSU[9], DSV[9], f3);
    a(R.h.dEH, DSU[10], DSV[10], f1);
    a(R.h.dEC, DSU[11], DSV[11], f2);
    this.DSY.put(Integer.valueOf(R.h.dER), findViewById(R.h.dER));
    this.DSY.put(Integer.valueOf(R.h.dET), findViewById(R.h.dET));
    this.DSY.put(Integer.valueOf(R.h.dES), findViewById(R.h.dES));
    this.DSY.put(Integer.valueOf(R.h.dEQ), findViewById(R.h.dEQ));
    this.DSY.put(Integer.valueOf(R.h.dEP), findViewById(R.h.dEP));
    Iterator localIterator = this.DSY.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.DST) {
        localView.setBackgroundDrawable(getResources().getDrawable(R.e.dkL));
      } else {
        localView.setBackgroundDrawable(getResources().getDrawable(R.e.dkn));
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
    ((b)localObject1).bn(???);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
    String str;
    c localc;
    int i;
    Object localObject3;
    if (this.DSW.containsKey(Integer.valueOf(???.getId())))
    {
      ??? = (DialNumberButton)this.DSW.get(Integer.valueOf(???.getId()));
      localObject1 = ???.getNumberText();
      str = ???.getOtherText();
      localc = i.eJB();
      i = c.bgl((String)localObject1);
      if ((i != -1) && (c.gDk()))
      {
        localObject3 = com.tencent.mm.plugin.audio.c.a.crn().audioManager;
        ??? = (View)localObject3;
        if (localObject3 == null) {
          ??? = (AudioManager)c.mContext.getSystemService("audio");
        }
        int j = ???.getRingerMode();
        if ((j != 0) && (j != 1)) {
          break label213;
        }
      }
      if (this.DSZ != null)
      {
        localObject3 = this.DSZ;
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
        ((a)localObject3).aMj(???);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25579);
        return;
        label213:
        synchronized (localc.NYk)
        {
          if (localc.NYl != null) {
            break;
          }
        }
      }
      localc.NYl.startTone(i, 250);
      break;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(25580);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
    if (this.DSW.containsKey(Integer.valueOf(paramView.getId())))
    {
      paramView = (DialNumberButton)this.DSW.get(Integer.valueOf(paramView.getId()));
      localObject = paramView.getNumberText();
      paramView = paramView.getOtherText();
      if (this.DSZ != null)
      {
        a locala = this.DSZ;
        if (!Util.isNullOrNil((String)localObject)) {
          paramView = (View)localObject;
        }
        locala.aMk(paramView);
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
    this.DSZ = parama;
  }
  
  public void setTalkUIMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25578);
    this.DST = paramBoolean;
    Iterator localIterator = this.DSW.values().iterator();
    while (localIterator.hasNext()) {
      ((DialNumberButton)localIterator.next()).setInTalkUIMode(paramBoolean);
    }
    localIterator = this.DSY.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.DST) {
        localView.setBackgroundDrawable(getResources().getDrawable(R.e.dkL));
      } else {
        localView.setBackgroundDrawable(getResources().getDrawable(R.e.dkn));
      }
    }
    AppMethodBeat.o(25578);
  }
  
  public static abstract interface a
  {
    public abstract void aMj(String paramString);
    
    public abstract void aMk(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialPad
 * JD-Core Version:    0.7.0.1
 */