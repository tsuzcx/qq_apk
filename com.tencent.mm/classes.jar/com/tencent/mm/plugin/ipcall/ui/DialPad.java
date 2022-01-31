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
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.video.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DialPad
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final String[] nQp = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#" };
  private static final String[] nQq = { "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", "" };
  private boolean nQo;
  private Map<Integer, DialNumberButton> nQr;
  private Map<String, DialNumberButton> nQs;
  private Map<Integer, View> nQt;
  private DialPad.a nQu;
  
  public DialPad(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(21959);
    this.nQo = false;
    this.nQr = new HashMap();
    this.nQs = new HashMap();
    this.nQt = new HashMap();
    init();
    AppMethodBeat.o(21959);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(21961);
    DialNumberButton localDialNumberButton = (DialNumberButton)findViewById(paramInt);
    localDialNumberButton.eS(paramString1, paramString2);
    localDialNumberButton.setNumberTextSize$255e752(paramFloat);
    localDialNumberButton.setOnClickListener(this);
    localDialNumberButton.setOnLongClickListener(this);
    localDialNumberButton.setInTalkUIMode(this.nQo);
    this.nQr.put(Integer.valueOf(paramInt), localDialNumberButton);
    this.nQs.put(paramString1, localDialNumberButton);
    AppMethodBeat.o(21961);
  }
  
  private void init()
  {
    AppMethodBeat.i(21960);
    LayoutInflater.from(getContext()).inflate(2130969320, this);
    float f1 = getContext().getResources().getDimensionPixelSize(2131427349);
    float f2 = getContext().getResources().getDimensionPixelSize(2131427351);
    float f3 = getContext().getResources().getDimensionPixelSize(2131427350);
    a(2131823402, nQp[0], nQq[0], f1);
    a(2131823403, nQp[1], nQq[1], f1);
    a(2131823404, nQp[2], nQq[2], f1);
    a(2131823406, nQp[3], nQq[3], f1);
    a(2131823407, nQp[4], nQq[4], f1);
    a(2131823408, nQp[5], nQq[5], f1);
    a(2131823410, nQp[6], nQq[6], f1);
    a(2131823411, nQp[7], nQq[7], f1);
    a(2131823412, nQp[8], nQq[8], f1);
    a(2131823414, nQp[9], nQq[9], f3);
    a(2131823415, nQp[10], nQq[10], f1);
    a(2131823416, nQp[11], nQq[11], f2);
    this.nQt.put(Integer.valueOf(2131823396), findViewById(2131823396));
    this.nQt.put(Integer.valueOf(2131823397), findViewById(2131823397));
    this.nQt.put(Integer.valueOf(2131823398), findViewById(2131823398));
    this.nQt.put(Integer.valueOf(2131823399), findViewById(2131823399));
    this.nQt.put(Integer.valueOf(2131823400), findViewById(2131823400));
    Iterator localIterator = this.nQt.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.nQo) {
        localView.setBackgroundDrawable(getResources().getDrawable(2131690570));
      } else {
        localView.setBackgroundDrawable(getResources().getDrawable(2131689949));
      }
    }
    setClipToPadding(false);
    setClipChildren(false);
    AppMethodBeat.o(21960);
  }
  
  public void onClick(View arg1)
  {
    AppMethodBeat.i(21963);
    String str1;
    String str2;
    d locald;
    int i;
    Object localObject2;
    if (this.nQr.containsKey(Integer.valueOf(???.getId())))
    {
      ??? = (DialNumberButton)this.nQr.get(Integer.valueOf(???.getId()));
      str1 = ???.getNumberText();
      str2 = ???.getOtherText();
      locald = i.bJy();
      i = d.aeK(str1);
      if ((i != -1) && (d.cPE()))
      {
        localObject2 = g.KC().elW;
        ??? = (View)localObject2;
        if (localObject2 == null) {
          ??? = (AudioManager)d.mContext.getSystemService("audio");
        }
        int j = ???.getRingerMode();
        if ((j != 0) && (j != 1)) {
          break label161;
        }
      }
      if (this.nQu != null)
      {
        localObject2 = this.nQu;
        if (bo.isNullOrNil(str1)) {
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
        ((DialPad.a)localObject2).Rh(???);
        AppMethodBeat.o(21963);
        return;
        synchronized (locald.tFT)
        {
          if (locald.tFU != null) {
            break;
          }
        }
      }
      locald.tFU.startTone(i, 250);
      break;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(21964);
    if (this.nQr.containsKey(Integer.valueOf(paramView.getId())))
    {
      paramView = (DialNumberButton)this.nQr.get(Integer.valueOf(paramView.getId()));
      String str = paramView.getNumberText();
      paramView = paramView.getOtherText();
      if (this.nQu != null)
      {
        DialPad.a locala = this.nQu;
        if (!bo.isNullOrNil(str)) {
          paramView = str;
        }
        locala.Ri(paramView);
      }
      AppMethodBeat.o(21964);
      return true;
    }
    AppMethodBeat.o(21964);
    return false;
  }
  
  public void onViewAdded(View paramView)
  {
    AppMethodBeat.i(21965);
    ab.i("MicroMsg.DialPad", "onViewAdded, class: %s", new Object[] { paramView.getClass().getSimpleName() });
    AppMethodBeat.o(21965);
  }
  
  public void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(21966);
    ab.i("MicroMsg.DialPad", "onViewRemoved, class: %s", new Object[] { paramView.getClass().getSimpleName() });
    AppMethodBeat.o(21966);
  }
  
  public void setDialButtonClickListener(DialPad.a parama)
  {
    this.nQu = parama;
  }
  
  public void setTalkUIMode(boolean paramBoolean)
  {
    AppMethodBeat.i(21962);
    this.nQo = paramBoolean;
    Iterator localIterator = this.nQr.values().iterator();
    while (localIterator.hasNext()) {
      ((DialNumberButton)localIterator.next()).setInTalkUIMode(paramBoolean);
    }
    localIterator = this.nQt.values().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (this.nQo) {
        localView.setBackgroundDrawable(getResources().getDrawable(2131690570));
      } else {
        localView.setBackgroundDrawable(getResources().getDrawable(2131689949));
      }
    }
    AppMethodBeat.o(21962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialPad
 * JD-Core Version:    0.7.0.1
 */