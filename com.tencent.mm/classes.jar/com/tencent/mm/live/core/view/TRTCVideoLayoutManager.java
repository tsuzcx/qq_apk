package com.tencent.mm.live.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TRTCVideoLayoutManager
  extends RelativeLayout
  implements b.b
{
  private static final String TAG;
  public WeakReference<a> gIP;
  private String gMA;
  private ArrayList<b> gMw;
  private ArrayList<RelativeLayout.LayoutParams> gMx;
  private ArrayList<RelativeLayout.LayoutParams> gMy;
  private ArrayList<RelativeLayout.LayoutParams> gMz;
  private int mCount;
  private int mMode;
  
  static
  {
    AppMethodBeat.i(216774);
    TAG = TRTCVideoLayoutManager.class.getSimpleName();
    AppMethodBeat.o(216774);
  }
  
  public TRTCVideoLayoutManager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216749);
    this.mCount = 0;
    aM(paramContext);
    AppMethodBeat.o(216749);
  }
  
  public TRTCVideoLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(216750);
    this.mCount = 0;
    aM(paramContext);
    AppMethodBeat.o(216750);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(216751);
    this.gMw = new ArrayList();
    Object localObject = new b(paramContext, false);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).gMp = false;
    ((b)localObject).a(this);
    ((b)localObject).amJ();
    b localb = new b((byte)0);
    localb.gMC = ((b)localObject);
    localb.index = 0;
    this.gMw.add(localb);
    localObject = new b(paramContext, true);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).gMp = false;
    ((b)localObject).a(this);
    ((b)localObject).amJ();
    localb = new b((byte)0);
    localb.gMC = ((b)localObject);
    localb.index = 1;
    this.gMw.add(localb);
    paramContext = new b(paramContext, true);
    paramContext.setVisibility(8);
    paramContext.setBackgroundColor(-16777216);
    paramContext.gMp = false;
    paramContext.a(this);
    paramContext.amJ();
    localObject = new b((byte)0);
    ((b)localObject).gMC = paramContext;
    ((b)localObject).index = 1;
    this.gMw.add(localObject);
    this.mMode = 1;
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216748);
        TRTCVideoLayoutManager.a(TRTCVideoLayoutManager.this);
        AppMethodBeat.o(216748);
      }
    });
    AppMethodBeat.o(216751);
  }
  
  private void amN()
  {
    AppMethodBeat.i(216765);
    if ((this.gMy == null) || (this.gMy.size() == 0) || (this.gMz == null) || (this.gMz.size() == 0))
    {
      this.gMy = c.b(getContext(), getWidth(), getHeight());
      this.gMz = c.c(getContext(), getWidth(), getHeight());
    }
    ArrayList localArrayList;
    int i;
    int j;
    label95:
    b localb;
    int k;
    if (this.mCount <= 4)
    {
      localArrayList = this.gMy;
      i = 0;
      j = 1;
      if (i >= this.gMw.size()) {
        break label224;
      }
      localb = (b)this.gMw.get(i);
      localb.gMC.gMp = false;
      localb.gMC.setOnClickListener(null);
      if (!localb.userId.equals(this.gMA)) {
        break label189;
      }
      localb.gMC.setLayoutParams((ViewGroup.LayoutParams)localArrayList.get(0));
      k = j;
    }
    for (;;)
    {
      i += 1;
      j = k;
      break label95;
      localArrayList = this.gMz;
      break;
      label189:
      k = j;
      if (j < localArrayList.size())
      {
        localb.gMC.setLayoutParams((ViewGroup.LayoutParams)localArrayList.get(j));
        k = j + 1;
      }
    }
    label224:
    AppMethodBeat.o(216765);
  }
  
  private b k(b paramb)
  {
    AppMethodBeat.i(216764);
    Iterator localIterator = this.gMw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.gMC == paramb)
      {
        AppMethodBeat.o(216764);
        return localb;
      }
    }
    AppMethodBeat.o(216764);
    return null;
  }
  
  public final TXCloudVideoView V(String paramString, int paramInt)
  {
    AppMethodBeat.i(216757);
    if (paramString == null)
    {
      AppMethodBeat.o(216757);
      return null;
    }
    Iterator localIterator = this.gMw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.gMC.mVideoView != null) && ((("".equals(localb.userId)) && (localb.streamType == -1)) || ((bt.lQ(paramString, localb.userId)) && (localb.streamType == paramInt))))
      {
        localb.userId = paramString;
        localb.streamType = paramInt;
        localb.gMC.setVisibility(0);
        this.mCount += 1;
        if ((this.mMode == 2) && (this.mCount == 5)) {
          amN();
        }
        localb.gMC.xB("");
        paramString = localb.gMC.mVideoView;
        AppMethodBeat.o(216757);
        return paramString;
      }
    }
    AppMethodBeat.o(216757);
    return null;
  }
  
  public final int W(String paramString, int paramInt)
  {
    AppMethodBeat.i(216768);
    int i = 0;
    if (i < this.gMw.size())
    {
      b localb = (b)this.gMw.get(i);
      if ((localb.gMC.mVideoView == null) || (!bt.lQ(paramString, localb.userId)) || (localb.streamType != paramInt)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(216768);
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final SurfaceView amK()
  {
    AppMethodBeat.i(216758);
    Object localObject = this.gMw.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (localb.gMC.gMd != null)
      {
        localb.userId = "";
        localb.streamType = 0;
        localb.gMC.setVisibility(0);
        this.mCount += 1;
        if ((this.mMode == 2) && (this.mCount == 5)) {
          amN();
        }
        localb.gMC.xB("");
        localObject = localb.gMC.gMd;
        AppMethodBeat.o(216758);
        return localObject;
      }
    }
    AppMethodBeat.o(216758);
    return null;
  }
  
  public final void amL()
  {
    AppMethodBeat.i(216762);
    Iterator localIterator = this.gMw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.gMC.gMd != null)
      {
        if (localb.index == 0) {
          nr(1);
        }
        this.mCount -= 1;
        if ((this.mMode == 2) && (this.mCount == 4)) {
          amN();
        }
        b localb1 = localb.gMC;
        Context localContext = getContext();
        int i = getWidth();
        getHeight();
        localb1.setLayoutParams(c.F(localContext, i));
        localb.gMC.setVisibility(8);
        localb.userId = "";
        localb.streamType = -1;
      }
    }
    AppMethodBeat.o(216762);
  }
  
  public final void amM()
  {
    AppMethodBeat.i(216763);
    Iterator localIterator = this.gMw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.gMC.mVideoView != null) && (localb.gMC.getParent() != null) && ((localb.gMC.getParent() instanceof ViewGroup)))
      {
        ViewGroup localViewGroup = (ViewGroup)localb.gMC.getParent();
        localViewGroup.removeView(localb.gMC);
        localViewGroup.addView(localb.gMC);
      }
    }
    AppMethodBeat.o(216763);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(216770);
    int i = 1;
    if (i < this.gMw.size())
    {
      b localb = (b)this.gMw.get(i);
      if ((localb.gMC != null) && (bt.lQ(localb.userId, paramString)) && (localb.streamType == paramInt2))
      {
        if (paramInt1 != 1) {
          break label97;
        }
        localb.gMC.setLayoutParams(c.E(getContext(), getWidth()));
      }
      for (;;)
      {
        i += 1;
        break;
        label97:
        if (paramInt1 == 2) {
          localb.gMC.setLayoutParams(c.D(getContext(), getWidth()));
        }
      }
    }
    AppMethodBeat.o(216770);
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(216752);
    if (this.gIP != null) {}
    for (a locala = (a)this.gIP.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(216752);
      return;
    }
  }
  
  public RelativeLayout getCameraContentView()
  {
    AppMethodBeat.i(216767);
    int i = 0;
    while (i < this.gMw.size())
    {
      Object localObject = (b)this.gMw.get(i);
      if (((b)localObject).gMC.gMd != null)
      {
        localObject = ((b)localObject).gMC;
        AppMethodBeat.o(216767);
        return localObject;
      }
      i += 1;
    }
    AppMethodBeat.o(216767);
    return null;
  }
  
  public int getCameraViewHeight()
  {
    AppMethodBeat.i(216760);
    Iterator localIterator = this.gMw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.gMC.gMd != null)
      {
        if (localb.gMC.getLayoutParams() == null)
        {
          AppMethodBeat.o(216760);
          return -1;
        }
        int i = localb.gMC.getLayoutParams().height;
        AppMethodBeat.o(216760);
        return i;
      }
    }
    AppMethodBeat.o(216760);
    return -1;
  }
  
  public int getCameraViewWidth()
  {
    AppMethodBeat.i(216759);
    Iterator localIterator = this.gMw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.gMC.gMd != null)
      {
        if (localb.gMC.getLayoutParams() == null)
        {
          AppMethodBeat.o(216759);
          return -1;
        }
        int i = localb.gMC.getLayoutParams().width;
        AppMethodBeat.o(216759);
        return i;
      }
    }
    AppMethodBeat.o(216759);
    return -1;
  }
  
  public int getRemoteViewIndex()
  {
    AppMethodBeat.i(216771);
    int i = 0;
    while (i < this.gMw.size())
    {
      if (((b)this.gMw.get(i)).gMC.mVideoView != null)
      {
        AppMethodBeat.o(216771);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(216771);
    return 0;
  }
  
  public final void h(b paramb)
  {
    AppMethodBeat.i(216753);
    if (this.gIP != null) {}
    for (a locala = (a)this.gIP.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(216753);
      return;
    }
  }
  
  public final void i(b paramb)
  {
    AppMethodBeat.i(216754);
    if (this.gIP != null) {}
    for (a locala = (a)this.gIP.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(216754);
      return;
    }
  }
  
  public final void j(b paramb)
  {
    AppMethodBeat.i(216755);
    if (this.gIP != null) {}
    for (a locala = (a)this.gIP.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(216755);
      return;
    }
  }
  
  public final void nr(int paramInt)
  {
    AppMethodBeat.i(216766);
    if ((paramInt <= 0) || (this.gMw.size() <= paramInt))
    {
      AppMethodBeat.o(216766);
      return;
    }
    b localb1 = (b)this.gMw.get(paramInt);
    ViewGroup.LayoutParams localLayoutParams1 = localb1.gMC.getLayoutParams();
    b localb2 = (b)this.gMw.get(0);
    ViewGroup.LayoutParams localLayoutParams2 = localb2.gMC.getLayoutParams();
    localb1.gMC.setLayoutParams(localLayoutParams2);
    localb1.index = 0;
    localb2.gMC.setLayoutParams(localLayoutParams1);
    localb2.index = paramInt;
    localb1.gMC.gMp = false;
    localb1.gMC.setOnClickListener(null);
    localb2.gMC.gMp = true;
    this.gMw.set(0, localb1);
    this.gMw.set(paramInt, localb2);
    paramInt = 0;
    while (paramInt < this.gMw.size())
    {
      bringChildToFront(((b)this.gMw.get(paramInt)).gMC);
      paramInt += 1;
    }
    AppMethodBeat.o(216766);
  }
  
  public final void ns(int paramInt)
  {
    AppMethodBeat.i(216769);
    int i = 1;
    if (i < this.gMw.size())
    {
      b localb = (b)this.gMw.get(i);
      if ((localb.gMC != null) && (localb.gMC.gMd != null))
      {
        if (paramInt != 1) {
          break label78;
        }
        localb.gMC.setLayoutParams(c.E(getContext(), getWidth()));
      }
      for (;;)
      {
        i += 1;
        break;
        label78:
        if (paramInt == 2) {
          localb.gMC.setLayoutParams(c.D(getContext(), getWidth()));
        }
      }
    }
    AppMethodBeat.o(216769);
  }
  
  public void setGestureListener(b.a parama)
  {
    AppMethodBeat.i(216772);
    int i = 0;
    while (i < this.gMw.size())
    {
      ((b)this.gMw.get(i)).gMC.gMs = parama;
      i += 1;
    }
    AppMethodBeat.o(216772);
  }
  
  public void setIVideoLayoutListener(a parama)
  {
    AppMethodBeat.i(216756);
    if (parama == null)
    {
      this.gIP = null;
      AppMethodBeat.o(216756);
      return;
    }
    this.gIP = new WeakReference(parama);
    AppMethodBeat.o(216756);
  }
  
  public void setMySelfUserId(String paramString)
  {
    this.gMA = paramString;
  }
  
  public final void xC(String paramString)
  {
    AppMethodBeat.i(216761);
    if (paramString == null)
    {
      AppMethodBeat.o(216761);
      return;
    }
    b localb;
    if (this.mMode == 1)
    {
      localb = (b)this.gMw.get(0);
      if ((paramString.equals(localb.userId)) && (localb.streamType == 0)) {
        nr(1);
      }
    }
    Object localObject = this.gMw.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localb = (b)((Iterator)localObject).next();
      if ((localb.streamType == 0) && (paramString.equals(localb.userId)))
      {
        this.mCount -= 1;
        if ((this.mMode == 2) && (this.mCount == 4)) {
          amN();
        }
        paramString = localb.gMC;
        localObject = getContext();
        int i = getWidth();
        getHeight();
        paramString.setLayoutParams(c.F((Context)localObject, i));
        localb.gMC.setVisibility(8);
        localb.userId = "";
        localb.streamType = -1;
        AppMethodBeat.o(216761);
        return;
      }
    }
    AppMethodBeat.o(216761);
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    public b gMC;
    public int index = -1;
    public int streamType = -1;
    public String userId = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.view.TRTCVideoLayoutManager
 * JD-Core Version:    0.7.0.1
 */