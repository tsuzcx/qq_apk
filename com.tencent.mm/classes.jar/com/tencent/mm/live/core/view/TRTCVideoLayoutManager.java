package com.tencent.mm.live.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TRTCVideoLayoutManager
  extends RelativeLayout
  implements b.b
{
  private static final String TAG;
  public WeakReference<a> gph;
  private ArrayList<b> gsL;
  private ArrayList<RelativeLayout.LayoutParams> gsM;
  private ArrayList<RelativeLayout.LayoutParams> gsN;
  private ArrayList<RelativeLayout.LayoutParams> gsO;
  private String gsP;
  private int mCount;
  private int mMode;
  
  static
  {
    AppMethodBeat.i(209117);
    TAG = TRTCVideoLayoutManager.class.getSimpleName();
    AppMethodBeat.o(209117);
  }
  
  public TRTCVideoLayoutManager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209092);
    this.mCount = 0;
    aM(paramContext);
    AppMethodBeat.o(209092);
  }
  
  public TRTCVideoLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209093);
    this.mCount = 0;
    aM(paramContext);
    AppMethodBeat.o(209093);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(209094);
    this.gsL = new ArrayList();
    Object localObject = new b(paramContext, false);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).gsE = false;
    ((b)localObject).a(this);
    ((b)localObject).ajX();
    b localb = new b((byte)0);
    localb.gsR = ((b)localObject);
    localb.index = 0;
    this.gsL.add(localb);
    localObject = new b(paramContext, true);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).gsE = false;
    ((b)localObject).a(this);
    ((b)localObject).ajX();
    localb = new b((byte)0);
    localb.gsR = ((b)localObject);
    localb.index = 1;
    this.gsL.add(localb);
    paramContext = new b(paramContext, true);
    paramContext.setVisibility(8);
    paramContext.setBackgroundColor(-16777216);
    paramContext.gsE = false;
    paramContext.a(this);
    paramContext.ajX();
    localObject = new b((byte)0);
    ((b)localObject).gsR = paramContext;
    ((b)localObject).index = 1;
    this.gsL.add(localObject);
    this.mMode = 1;
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209091);
        TRTCVideoLayoutManager.a(TRTCVideoLayoutManager.this);
        AppMethodBeat.o(209091);
      }
    });
    AppMethodBeat.o(209094);
  }
  
  private void akb()
  {
    AppMethodBeat.i(209108);
    if ((this.gsN == null) || (this.gsN.size() == 0) || (this.gsO == null) || (this.gsO.size() == 0))
    {
      this.gsN = c.b(getContext(), getWidth(), getHeight());
      this.gsO = c.c(getContext(), getWidth(), getHeight());
    }
    ArrayList localArrayList;
    int i;
    int j;
    label95:
    b localb;
    int k;
    if (this.mCount <= 4)
    {
      localArrayList = this.gsN;
      i = 0;
      j = 1;
      if (i >= this.gsL.size()) {
        break label224;
      }
      localb = (b)this.gsL.get(i);
      localb.gsR.gsE = false;
      localb.gsR.setOnClickListener(null);
      if (!localb.userId.equals(this.gsP)) {
        break label189;
      }
      localb.gsR.setLayoutParams((ViewGroup.LayoutParams)localArrayList.get(0));
      k = j;
    }
    for (;;)
    {
      i += 1;
      j = k;
      break label95;
      localArrayList = this.gsO;
      break;
      label189:
      k = j;
      if (j < localArrayList.size())
      {
        localb.gsR.setLayoutParams((ViewGroup.LayoutParams)localArrayList.get(j));
        k = j + 1;
      }
    }
    label224:
    AppMethodBeat.o(209108);
  }
  
  private b k(b paramb)
  {
    AppMethodBeat.i(209107);
    Iterator localIterator = this.gsL.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.gsR == paramb)
      {
        AppMethodBeat.o(209107);
        return localb;
      }
    }
    AppMethodBeat.o(209107);
    return null;
  }
  
  public final TXCloudVideoView S(String paramString, int paramInt)
  {
    AppMethodBeat.i(209100);
    if (paramString == null)
    {
      AppMethodBeat.o(209100);
      return null;
    }
    Iterator localIterator = this.gsL.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.gsR.mVideoView != null) && ((("".equals(localb.userId)) && (localb.streamType == -1)) || ((bs.lr(paramString, localb.userId)) && (localb.streamType == paramInt))))
      {
        localb.userId = paramString;
        localb.streamType = paramInt;
        localb.gsR.setVisibility(0);
        this.mCount += 1;
        if ((this.mMode == 2) && (this.mCount == 5)) {
          akb();
        }
        localb.gsR.uK("");
        paramString = localb.gsR.mVideoView;
        AppMethodBeat.o(209100);
        return paramString;
      }
    }
    AppMethodBeat.o(209100);
    return null;
  }
  
  public final SurfaceView ajY()
  {
    AppMethodBeat.i(209101);
    Object localObject = this.gsL.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (localb.gsR.gss != null)
      {
        localb.userId = "";
        localb.streamType = 0;
        localb.gsR.setVisibility(0);
        this.mCount += 1;
        if ((this.mMode == 2) && (this.mCount == 5)) {
          akb();
        }
        localb.gsR.uK("");
        localObject = localb.gsR.gss;
        AppMethodBeat.o(209101);
        return localObject;
      }
    }
    AppMethodBeat.o(209101);
    return null;
  }
  
  public final void ajZ()
  {
    AppMethodBeat.i(209105);
    Iterator localIterator = this.gsL.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.gsR.gss != null)
      {
        if (localb.index == 0) {
          mS(1);
        }
        this.mCount -= 1;
        if ((this.mMode == 2) && (this.mCount == 4)) {
          akb();
        }
        b localb1 = localb.gsR;
        Context localContext = getContext();
        int i = getWidth();
        getHeight();
        localb1.setLayoutParams(c.E(localContext, i));
        localb.gsR.setVisibility(8);
        localb.userId = "";
        localb.streamType = -1;
      }
    }
    AppMethodBeat.o(209105);
  }
  
  public final void aka()
  {
    AppMethodBeat.i(209106);
    Iterator localIterator = this.gsL.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.gsR.mVideoView != null) && (localb.gsR.getParent() != null) && ((localb.gsR.getParent() instanceof ViewGroup)))
      {
        ViewGroup localViewGroup = (ViewGroup)localb.gsR.getParent();
        localViewGroup.removeView(localb.gsR);
        localViewGroup.addView(localb.gsR);
      }
    }
    AppMethodBeat.o(209106);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(209113);
    int i = 1;
    if (i < this.gsL.size())
    {
      b localb = (b)this.gsL.get(i);
      if ((localb.gsR != null) && (bs.lr(localb.userId, paramString)) && (localb.streamType == paramInt2))
      {
        if (paramInt1 != 1) {
          break label97;
        }
        localb.gsR.setLayoutParams(c.D(getContext(), getWidth()));
      }
      for (;;)
      {
        i += 1;
        break;
        label97:
        if (paramInt1 == 2) {
          localb.gsR.setLayoutParams(c.C(getContext(), getWidth()));
        }
      }
    }
    AppMethodBeat.o(209113);
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(209095);
    if (this.gph != null) {}
    for (a locala = (a)this.gph.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(209095);
      return;
    }
  }
  
  public RelativeLayout getCameraContentView()
  {
    AppMethodBeat.i(209110);
    int i = 0;
    while (i < this.gsL.size())
    {
      Object localObject = (b)this.gsL.get(i);
      if (((b)localObject).gsR.gss != null)
      {
        localObject = ((b)localObject).gsR;
        AppMethodBeat.o(209110);
        return localObject;
      }
      i += 1;
    }
    AppMethodBeat.o(209110);
    return null;
  }
  
  public int getCameraViewHeight()
  {
    AppMethodBeat.i(209103);
    Iterator localIterator = this.gsL.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.gsR.gss != null)
      {
        if (localb.gsR.getLayoutParams() == null)
        {
          AppMethodBeat.o(209103);
          return -1;
        }
        int i = localb.gsR.getLayoutParams().height;
        AppMethodBeat.o(209103);
        return i;
      }
    }
    AppMethodBeat.o(209103);
    return -1;
  }
  
  public int getCameraViewWidth()
  {
    AppMethodBeat.i(209102);
    Iterator localIterator = this.gsL.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.gsR.gss != null)
      {
        if (localb.gsR.getLayoutParams() == null)
        {
          AppMethodBeat.o(209102);
          return -1;
        }
        int i = localb.gsR.getLayoutParams().width;
        AppMethodBeat.o(209102);
        return i;
      }
    }
    AppMethodBeat.o(209102);
    return -1;
  }
  
  public int getRemoteViewIndex()
  {
    AppMethodBeat.i(209114);
    int i = 0;
    while (i < this.gsL.size())
    {
      if (((b)this.gsL.get(i)).gsR.mVideoView != null)
      {
        AppMethodBeat.o(209114);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(209114);
    return 0;
  }
  
  public final void h(b paramb)
  {
    AppMethodBeat.i(209096);
    if (this.gph != null) {}
    for (a locala = (a)this.gph.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(209096);
      return;
    }
  }
  
  public final void i(b paramb)
  {
    AppMethodBeat.i(209097);
    if (this.gph != null) {}
    for (a locala = (a)this.gph.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(209097);
      return;
    }
  }
  
  public final void j(b paramb)
  {
    AppMethodBeat.i(209098);
    if (this.gph != null) {}
    for (a locala = (a)this.gph.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(209098);
      return;
    }
  }
  
  public final void mS(int paramInt)
  {
    AppMethodBeat.i(209109);
    if ((paramInt <= 0) || (this.gsL.size() <= paramInt))
    {
      AppMethodBeat.o(209109);
      return;
    }
    b localb1 = (b)this.gsL.get(paramInt);
    ViewGroup.LayoutParams localLayoutParams1 = localb1.gsR.getLayoutParams();
    b localb2 = (b)this.gsL.get(0);
    ViewGroup.LayoutParams localLayoutParams2 = localb2.gsR.getLayoutParams();
    localb1.gsR.setLayoutParams(localLayoutParams2);
    localb1.index = 0;
    localb2.gsR.setLayoutParams(localLayoutParams1);
    localb2.index = paramInt;
    localb1.gsR.gsE = false;
    localb1.gsR.setOnClickListener(null);
    localb2.gsR.gsE = true;
    this.gsL.set(0, localb1);
    this.gsL.set(paramInt, localb2);
    paramInt = 0;
    while (paramInt < this.gsL.size())
    {
      bringChildToFront(((b)this.gsL.get(paramInt)).gsR);
      paramInt += 1;
    }
    AppMethodBeat.o(209109);
  }
  
  public final void mT(int paramInt)
  {
    AppMethodBeat.i(209112);
    int i = 1;
    if (i < this.gsL.size())
    {
      b localb = (b)this.gsL.get(i);
      if ((localb.gsR != null) && (localb.gsR.gss != null))
      {
        if (paramInt != 1) {
          break label78;
        }
        localb.gsR.setLayoutParams(c.D(getContext(), getWidth()));
      }
      for (;;)
      {
        i += 1;
        break;
        label78:
        if (paramInt == 2) {
          localb.gsR.setLayoutParams(c.C(getContext(), getWidth()));
        }
      }
    }
    AppMethodBeat.o(209112);
  }
  
  public void setGestureListener(b.a parama)
  {
    AppMethodBeat.i(209115);
    int i = 0;
    while (i < this.gsL.size())
    {
      ((b)this.gsL.get(i)).gsR.gsH = parama;
      i += 1;
    }
    AppMethodBeat.o(209115);
  }
  
  public void setIVideoLayoutListener(a parama)
  {
    AppMethodBeat.i(209099);
    if (parama == null)
    {
      this.gph = null;
      AppMethodBeat.o(209099);
      return;
    }
    this.gph = new WeakReference(parama);
    AppMethodBeat.o(209099);
  }
  
  public void setMySelfUserId(String paramString)
  {
    this.gsP = paramString;
  }
  
  public final void uL(String paramString)
  {
    AppMethodBeat.i(209104);
    if (paramString == null)
    {
      AppMethodBeat.o(209104);
      return;
    }
    b localb;
    if (this.mMode == 1)
    {
      localb = (b)this.gsL.get(0);
      if ((paramString.equals(localb.userId)) && (localb.streamType == 0)) {
        mS(1);
      }
    }
    Object localObject = this.gsL.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localb = (b)((Iterator)localObject).next();
      if ((localb.streamType == 0) && (paramString.equals(localb.userId)))
      {
        this.mCount -= 1;
        if ((this.mMode == 2) && (this.mCount == 4)) {
          akb();
        }
        paramString = localb.gsR;
        localObject = getContext();
        int i = getWidth();
        getHeight();
        paramString.setLayoutParams(c.E((Context)localObject, i));
        localb.gsR.setVisibility(8);
        localb.userId = "";
        localb.streamType = -1;
        AppMethodBeat.o(209104);
        return;
      }
    }
    AppMethodBeat.o(209104);
  }
  
  public final int uM(String paramString)
  {
    AppMethodBeat.i(209111);
    int i = 0;
    if (i < this.gsL.size())
    {
      b localb = (b)this.gsL.get(i);
      if ((localb.gsR.mVideoView == null) || (!bs.lr(paramString, localb.userId)) || (localb.streamType != 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(209111);
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    public b gsR;
    public int index = -1;
    public int streamType = -1;
    public String userId = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.view.TRTCVideoLayoutManager
 * JD-Core Version:    0.7.0.1
 */