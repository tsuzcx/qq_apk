package com.tencent.mm.live.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TRTCVideoLayoutManager
  extends RelativeLayout
  implements b.b
{
  private static final String TAG;
  public WeakReference<a> gLy;
  private ArrayList<b> gPf;
  private ArrayList<RelativeLayout.LayoutParams> gPg;
  private ArrayList<RelativeLayout.LayoutParams> gPh;
  private ArrayList<RelativeLayout.LayoutParams> gPi;
  private String gPj;
  private int mCount;
  private int mMode;
  
  static
  {
    AppMethodBeat.i(197173);
    TAG = TRTCVideoLayoutManager.class.getSimpleName();
    AppMethodBeat.o(197173);
  }
  
  public TRTCVideoLayoutManager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(197148);
    this.mCount = 0;
    aN(paramContext);
    AppMethodBeat.o(197148);
  }
  
  public TRTCVideoLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(197149);
    this.mCount = 0;
    aN(paramContext);
    AppMethodBeat.o(197149);
  }
  
  private void aN(Context paramContext)
  {
    AppMethodBeat.i(197150);
    this.gPf = new ArrayList();
    Object localObject = new b(paramContext, false);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).gOY = false;
    ((b)localObject).a(this);
    ((b)localObject).amY();
    b localb = new b((byte)0);
    localb.gPl = ((b)localObject);
    localb.index = 0;
    this.gPf.add(localb);
    localObject = new b(paramContext, true);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).gOY = false;
    ((b)localObject).a(this);
    ((b)localObject).amY();
    localb = new b((byte)0);
    localb.gPl = ((b)localObject);
    localb.index = 1;
    this.gPf.add(localb);
    paramContext = new b(paramContext, true);
    paramContext.setVisibility(8);
    paramContext.setBackgroundColor(-16777216);
    paramContext.gOY = false;
    paramContext.a(this);
    paramContext.amY();
    localObject = new b((byte)0);
    ((b)localObject).gPl = paramContext;
    ((b)localObject).index = 1;
    this.gPf.add(localObject);
    this.mMode = 1;
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197147);
        TRTCVideoLayoutManager.a(TRTCVideoLayoutManager.this);
        AppMethodBeat.o(197147);
      }
    });
    AppMethodBeat.o(197150);
  }
  
  private void anc()
  {
    AppMethodBeat.i(197164);
    if ((this.gPh == null) || (this.gPh.size() == 0) || (this.gPi == null) || (this.gPi.size() == 0))
    {
      this.gPh = c.b(getContext(), getWidth(), getHeight());
      this.gPi = c.c(getContext(), getWidth(), getHeight());
    }
    ArrayList localArrayList;
    int i;
    int j;
    label95:
    b localb;
    int k;
    if (this.mCount <= 4)
    {
      localArrayList = this.gPh;
      i = 0;
      j = 1;
      if (i >= this.gPf.size()) {
        break label224;
      }
      localb = (b)this.gPf.get(i);
      localb.gPl.gOY = false;
      localb.gPl.setOnClickListener(null);
      if (!localb.userId.equals(this.gPj)) {
        break label189;
      }
      localb.gPl.setLayoutParams((ViewGroup.LayoutParams)localArrayList.get(0));
      k = j;
    }
    for (;;)
    {
      i += 1;
      j = k;
      break label95;
      localArrayList = this.gPi;
      break;
      label189:
      k = j;
      if (j < localArrayList.size())
      {
        localb.gPl.setLayoutParams((ViewGroup.LayoutParams)localArrayList.get(j));
        k = j + 1;
      }
    }
    label224:
    AppMethodBeat.o(197164);
  }
  
  private b k(b paramb)
  {
    AppMethodBeat.i(197163);
    Iterator localIterator = this.gPf.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.gPl == paramb)
      {
        AppMethodBeat.o(197163);
        return localb;
      }
    }
    AppMethodBeat.o(197163);
    return null;
  }
  
  public final TXCloudVideoView W(String paramString, int paramInt)
  {
    AppMethodBeat.i(197156);
    if (paramString == null)
    {
      AppMethodBeat.o(197156);
      return null;
    }
    Iterator localIterator = this.gPf.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.gPl.mVideoView != null) && ((("".equals(localb.userId)) && (localb.streamType == -1)) || ((bu.lX(paramString, localb.userId)) && (localb.streamType == paramInt))))
      {
        localb.userId = paramString;
        localb.streamType = paramInt;
        localb.gPl.setVisibility(0);
        this.mCount += 1;
        if ((this.mMode == 2) && (this.mCount == 5)) {
          anc();
        }
        localb.gPl.yk("");
        paramString = localb.gPl.mVideoView;
        AppMethodBeat.o(197156);
        return paramString;
      }
    }
    AppMethodBeat.o(197156);
    return null;
  }
  
  public final int X(String paramString, int paramInt)
  {
    AppMethodBeat.i(197167);
    int i = 0;
    if (i < this.gPf.size())
    {
      b localb = (b)this.gPf.get(i);
      if ((localb.gPl.mVideoView == null) || (!bu.lX(paramString, localb.userId)) || (localb.streamType != paramInt)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(197167);
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final SurfaceView amZ()
  {
    AppMethodBeat.i(197157);
    Object localObject = this.gPf.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (localb.gPl.gOM != null)
      {
        localb.userId = "";
        localb.streamType = 0;
        localb.gPl.setVisibility(0);
        this.mCount += 1;
        if ((this.mMode == 2) && (this.mCount == 5)) {
          anc();
        }
        localb.gPl.yk("");
        localObject = localb.gPl.gOM;
        AppMethodBeat.o(197157);
        return localObject;
      }
    }
    AppMethodBeat.o(197157);
    return null;
  }
  
  public final void ana()
  {
    AppMethodBeat.i(197161);
    Iterator localIterator = this.gPf.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.gPl.gOM != null)
      {
        if (localb.index == 0) {
          nu(1);
        }
        this.mCount -= 1;
        if ((this.mMode == 2) && (this.mCount == 4)) {
          anc();
        }
        b localb1 = localb.gPl;
        Context localContext = getContext();
        int i = getWidth();
        getHeight();
        localb1.setLayoutParams(c.F(localContext, i));
        localb.gPl.setVisibility(8);
        localb.userId = "";
        localb.streamType = -1;
      }
    }
    AppMethodBeat.o(197161);
  }
  
  public final void anb()
  {
    AppMethodBeat.i(197162);
    Iterator localIterator = this.gPf.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.gPl.mVideoView != null) && (localb.gPl.getParent() != null) && ((localb.gPl.getParent() instanceof ViewGroup)))
      {
        ViewGroup localViewGroup = (ViewGroup)localb.gPl.getParent();
        localViewGroup.removeView(localb.gPl);
        localViewGroup.addView(localb.gPl);
      }
    }
    AppMethodBeat.o(197162);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(197169);
    int i = 1;
    if (i < this.gPf.size())
    {
      b localb = (b)this.gPf.get(i);
      if ((localb.gPl != null) && (bu.lX(localb.userId, paramString)) && (localb.streamType == paramInt2))
      {
        if (paramInt1 != 1) {
          break label97;
        }
        localb.gPl.setLayoutParams(c.E(getContext(), getWidth()));
      }
      for (;;)
      {
        i += 1;
        break;
        label97:
        if (paramInt1 == 2) {
          localb.gPl.setLayoutParams(c.D(getContext(), getWidth()));
        }
      }
    }
    AppMethodBeat.o(197169);
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(197151);
    if (this.gLy != null) {}
    for (a locala = (a)this.gLy.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(197151);
      return;
    }
  }
  
  public RelativeLayout getCameraContentView()
  {
    AppMethodBeat.i(197166);
    int i = 0;
    while (i < this.gPf.size())
    {
      Object localObject = (b)this.gPf.get(i);
      if (((b)localObject).gPl.gOM != null)
      {
        localObject = ((b)localObject).gPl;
        AppMethodBeat.o(197166);
        return localObject;
      }
      i += 1;
    }
    AppMethodBeat.o(197166);
    return null;
  }
  
  public int getCameraViewHeight()
  {
    AppMethodBeat.i(197159);
    Iterator localIterator = this.gPf.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.gPl.gOM != null)
      {
        if (localb.gPl.getLayoutParams() == null)
        {
          AppMethodBeat.o(197159);
          return -1;
        }
        int i = localb.gPl.getLayoutParams().height;
        AppMethodBeat.o(197159);
        return i;
      }
    }
    AppMethodBeat.o(197159);
    return -1;
  }
  
  public int getCameraViewWidth()
  {
    AppMethodBeat.i(197158);
    Iterator localIterator = this.gPf.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.gPl.gOM != null)
      {
        if (localb.gPl.getLayoutParams() == null)
        {
          AppMethodBeat.o(197158);
          return -1;
        }
        int i = localb.gPl.getLayoutParams().width;
        AppMethodBeat.o(197158);
        return i;
      }
    }
    AppMethodBeat.o(197158);
    return -1;
  }
  
  public int getRemoteViewIndex()
  {
    AppMethodBeat.i(197170);
    int i = 0;
    while (i < this.gPf.size())
    {
      if (((b)this.gPf.get(i)).gPl.mVideoView != null)
      {
        AppMethodBeat.o(197170);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(197170);
    return 0;
  }
  
  public final void h(b paramb)
  {
    AppMethodBeat.i(197152);
    if (this.gLy != null) {}
    for (a locala = (a)this.gLy.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(197152);
      return;
    }
  }
  
  public final void i(b paramb)
  {
    AppMethodBeat.i(197153);
    if (this.gLy != null) {}
    for (a locala = (a)this.gLy.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(197153);
      return;
    }
  }
  
  public final void j(b paramb)
  {
    AppMethodBeat.i(197154);
    if (this.gLy != null) {}
    for (a locala = (a)this.gLy.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(197154);
      return;
    }
  }
  
  public final void nu(int paramInt)
  {
    AppMethodBeat.i(197165);
    if ((paramInt <= 0) || (this.gPf.size() <= paramInt))
    {
      AppMethodBeat.o(197165);
      return;
    }
    b localb1 = (b)this.gPf.get(paramInt);
    ViewGroup.LayoutParams localLayoutParams1 = localb1.gPl.getLayoutParams();
    b localb2 = (b)this.gPf.get(0);
    ViewGroup.LayoutParams localLayoutParams2 = localb2.gPl.getLayoutParams();
    localb1.gPl.setLayoutParams(localLayoutParams2);
    localb1.index = 0;
    localb2.gPl.setLayoutParams(localLayoutParams1);
    localb2.index = paramInt;
    localb1.gPl.gOY = false;
    localb1.gPl.setOnClickListener(null);
    localb2.gPl.gOY = true;
    this.gPf.set(0, localb1);
    this.gPf.set(paramInt, localb2);
    paramInt = 0;
    while (paramInt < this.gPf.size())
    {
      bringChildToFront(((b)this.gPf.get(paramInt)).gPl);
      paramInt += 1;
    }
    AppMethodBeat.o(197165);
  }
  
  public final void nv(int paramInt)
  {
    AppMethodBeat.i(197168);
    int i = 1;
    if (i < this.gPf.size())
    {
      b localb = (b)this.gPf.get(i);
      if ((localb.gPl != null) && (localb.gPl.gOM != null))
      {
        if (paramInt != 1) {
          break label78;
        }
        localb.gPl.setLayoutParams(c.E(getContext(), getWidth()));
      }
      for (;;)
      {
        i += 1;
        break;
        label78:
        if (paramInt == 2) {
          localb.gPl.setLayoutParams(c.D(getContext(), getWidth()));
        }
      }
    }
    AppMethodBeat.o(197168);
  }
  
  public void setGestureListener(b.a parama)
  {
    AppMethodBeat.i(197171);
    int i = 0;
    while (i < this.gPf.size())
    {
      ((b)this.gPf.get(i)).gPl.gPb = parama;
      i += 1;
    }
    AppMethodBeat.o(197171);
  }
  
  public void setIVideoLayoutListener(a parama)
  {
    AppMethodBeat.i(197155);
    if (parama == null)
    {
      this.gLy = null;
      AppMethodBeat.o(197155);
      return;
    }
    this.gLy = new WeakReference(parama);
    AppMethodBeat.o(197155);
  }
  
  public void setMySelfUserId(String paramString)
  {
    this.gPj = paramString;
  }
  
  public final void yl(String paramString)
  {
    AppMethodBeat.i(197160);
    if (paramString == null)
    {
      AppMethodBeat.o(197160);
      return;
    }
    b localb;
    if (this.mMode == 1)
    {
      localb = (b)this.gPf.get(0);
      if ((paramString.equals(localb.userId)) && (localb.streamType == 0)) {
        nu(1);
      }
    }
    Object localObject = this.gPf.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localb = (b)((Iterator)localObject).next();
      if ((localb.streamType == 0) && (paramString.equals(localb.userId)))
      {
        this.mCount -= 1;
        if ((this.mMode == 2) && (this.mCount == 4)) {
          anc();
        }
        paramString = localb.gPl;
        localObject = getContext();
        int i = getWidth();
        getHeight();
        paramString.setLayoutParams(c.F((Context)localObject, i));
        localb.gPl.setVisibility(8);
        localb.userId = "";
        localb.streamType = -1;
        AppMethodBeat.o(197160);
        return;
      }
    }
    AppMethodBeat.o(197160);
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    public b gPl;
    public int index = -1;
    public int streamType = -1;
    public String userId = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.view.TRTCVideoLayoutManager
 * JD-Core Version:    0.7.0.1
 */