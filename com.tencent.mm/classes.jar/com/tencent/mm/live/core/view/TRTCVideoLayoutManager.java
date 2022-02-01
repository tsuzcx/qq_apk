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
  private int mCount;
  private int mMode;
  public WeakReference<a> qED;
  private ArrayList<b> qVa;
  private ArrayList<RelativeLayout.LayoutParams> qVn;
  private ArrayList<RelativeLayout.LayoutParams> qVo;
  private ArrayList<RelativeLayout.LayoutParams> qVp;
  private String qVq;
  
  static
  {
    AppMethodBeat.i(205584);
    TAG = TRTCVideoLayoutManager.class.getSimpleName();
    AppMethodBeat.o(205584);
  }
  
  public TRTCVideoLayoutManager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205559);
    this.mCount = 0;
    aL(paramContext);
    AppMethodBeat.o(205559);
  }
  
  public TRTCVideoLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205560);
    this.mCount = 0;
    aL(paramContext);
    AppMethodBeat.o(205560);
  }
  
  private void aL(Context paramContext)
  {
    AppMethodBeat.i(205561);
    this.qVa = new ArrayList();
    Object localObject = new b(paramContext, false);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).qUH = false;
    ((b)localObject).a(this);
    ((b)localObject).dRc();
    b localb = new b((byte)0);
    localb.qVL = ((b)localObject);
    localb.index = 0;
    this.qVa.add(localb);
    localObject = new b(paramContext, true);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).qUH = false;
    ((b)localObject).a(this);
    ((b)localObject).dRc();
    localb = new b((byte)0);
    localb.qVL = ((b)localObject);
    localb.index = 1;
    this.qVa.add(localb);
    paramContext = new b(paramContext, true);
    paramContext.setVisibility(8);
    paramContext.setBackgroundColor(-16777216);
    paramContext.qUH = false;
    paramContext.a(this);
    paramContext.dRc();
    localObject = new b((byte)0);
    ((b)localObject).qVL = paramContext;
    ((b)localObject).index = 1;
    this.qVa.add(localObject);
    this.mMode = 1;
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205558);
        TRTCVideoLayoutManager.a(TRTCVideoLayoutManager.this);
        AppMethodBeat.o(205558);
      }
    });
    AppMethodBeat.o(205561);
  }
  
  private void dRi()
  {
    AppMethodBeat.i(205575);
    if ((this.qVo == null) || (this.qVo.size() == 0) || (this.qVp == null) || (this.qVp.size() == 0))
    {
      this.qVo = c.l(getContext(), getWidth(), getHeight());
      this.qVp = c.m(getContext(), getWidth(), getHeight());
    }
    ArrayList localArrayList;
    int i;
    int j;
    label95:
    b localb;
    int k;
    if (this.mCount <= 4)
    {
      localArrayList = this.qVo;
      i = 0;
      j = 1;
      if (i >= this.qVa.size()) {
        break label224;
      }
      localb = (b)this.qVa.get(i);
      localb.qVL.qUH = false;
      localb.qVL.setOnClickListener(null);
      if (!localb.userId.equals(this.qVq)) {
        break label189;
      }
      localb.qVL.setLayoutParams((ViewGroup.LayoutParams)localArrayList.get(0));
      k = j;
    }
    for (;;)
    {
      i += 1;
      j = k;
      break label95;
      localArrayList = this.qVp;
      break;
      label189:
      k = j;
      if (j < localArrayList.size())
      {
        localb.qVL.setLayoutParams((ViewGroup.LayoutParams)localArrayList.get(j));
        k = j + 1;
      }
    }
    label224:
    AppMethodBeat.o(205575);
  }
  
  private b k(b paramb)
  {
    AppMethodBeat.i(205574);
    Iterator localIterator = this.qVa.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.qVL == paramb)
      {
        AppMethodBeat.o(205574);
        return localb;
      }
    }
    AppMethodBeat.o(205574);
    return null;
  }
  
  public final void aUh(String paramString)
  {
    AppMethodBeat.i(205571);
    if (paramString == null)
    {
      AppMethodBeat.o(205571);
      return;
    }
    b localb;
    if (this.mMode == 1)
    {
      localb = (b)this.qVa.get(0);
      if ((paramString.equals(localb.userId)) && (localb.streamType == 0)) {
        aaq(1);
      }
    }
    Object localObject = this.qVa.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localb = (b)((Iterator)localObject).next();
      if ((localb.streamType == 0) && (paramString.equals(localb.userId)))
      {
        this.mCount -= 1;
        if ((this.mMode == 2) && (this.mCount == 4)) {
          dRi();
        }
        paramString = localb.qVL;
        localObject = getContext();
        int i = getWidth();
        getHeight();
        paramString.setLayoutParams(c.aQ((Context)localObject, i));
        localb.qVL.setVisibility(8);
        localb.userId = "";
        localb.streamType = -1;
        AppMethodBeat.o(205571);
        return;
      }
    }
    AppMethodBeat.o(205571);
  }
  
  public final int aUi(String paramString)
  {
    AppMethodBeat.i(205578);
    int i = 0;
    if (i < this.qVa.size())
    {
      b localb = (b)this.qVa.get(i);
      if ((localb.qVL.mVideoView == null) || (!bt.kU(paramString, localb.userId)) || (localb.streamType != 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(205578);
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void aaq(int paramInt)
  {
    AppMethodBeat.i(205576);
    if ((paramInt <= 0) || (this.qVa.size() <= paramInt))
    {
      AppMethodBeat.o(205576);
      return;
    }
    b localb1 = (b)this.qVa.get(paramInt);
    ViewGroup.LayoutParams localLayoutParams1 = localb1.qVL.getLayoutParams();
    b localb2 = (b)this.qVa.get(0);
    ViewGroup.LayoutParams localLayoutParams2 = localb2.qVL.getLayoutParams();
    localb1.qVL.setLayoutParams(localLayoutParams2);
    localb1.index = 0;
    localb2.qVL.setLayoutParams(localLayoutParams1);
    localb2.index = paramInt;
    localb1.qVL.qUH = false;
    localb1.qVL.setOnClickListener(null);
    localb2.qVL.qUH = true;
    this.qVa.set(0, localb1);
    this.qVa.set(paramInt, localb2);
    paramInt = 0;
    while (paramInt < this.qVa.size())
    {
      bringChildToFront(((b)this.qVa.get(paramInt)).qVL);
      paramInt += 1;
    }
    AppMethodBeat.o(205576);
  }
  
  public final void abp(int paramInt)
  {
    AppMethodBeat.i(205579);
    int i = 1;
    if (i < this.qVa.size())
    {
      b localb = (b)this.qVa.get(i);
      if ((localb.qVL != null) && (localb.qVL.qUx != null))
      {
        if (paramInt != 1) {
          break label78;
        }
        localb.qVL.setLayoutParams(c.aP(getContext(), getWidth()));
      }
      for (;;)
      {
        i += 1;
        break;
        label78:
        if (paramInt == 2) {
          localb.qVL.setLayoutParams(c.G(getContext(), getWidth()));
        }
      }
    }
    AppMethodBeat.o(205579);
  }
  
  public final SurfaceView dRd()
  {
    AppMethodBeat.i(205568);
    Object localObject = this.qVa.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (localb.qVL.qUx != null)
      {
        localb.userId = "";
        localb.streamType = 0;
        localb.qVL.setVisibility(0);
        this.mCount += 1;
        if ((this.mMode == 2) && (this.mCount == 5)) {
          dRi();
        }
        localb.qVL.aUg("");
        localObject = localb.qVL.qUx;
        AppMethodBeat.o(205568);
        return localObject;
      }
    }
    AppMethodBeat.o(205568);
    return null;
  }
  
  public final void dRf()
  {
    AppMethodBeat.i(205572);
    Iterator localIterator = this.qVa.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.qVL.qUx != null)
      {
        if (localb.index == 0) {
          aaq(1);
        }
        this.mCount -= 1;
        if ((this.mMode == 2) && (this.mCount == 4)) {
          dRi();
        }
        b localb1 = localb.qVL;
        Context localContext = getContext();
        int i = getWidth();
        getHeight();
        localb1.setLayoutParams(c.aQ(localContext, i));
        localb.qVL.setVisibility(8);
        localb.userId = "";
        localb.streamType = -1;
      }
    }
    AppMethodBeat.o(205572);
  }
  
  public final void dRh()
  {
    AppMethodBeat.i(205573);
    Iterator localIterator = this.qVa.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.qVL.mVideoView != null) && (localb.qVL.getParent() != null) && ((localb.qVL.getParent() instanceof ViewGroup)))
      {
        ViewGroup localViewGroup = (ViewGroup)localb.qVL.getParent();
        localViewGroup.removeView(localb.qVL);
        localViewGroup.addView(localb.qVL);
      }
    }
    AppMethodBeat.o(205573);
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(205562);
    if (this.qED != null) {}
    for (a locala = (a)this.qED.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(205562);
      return;
    }
  }
  
  public final TXCloudVideoView gP(String paramString, int paramInt)
  {
    AppMethodBeat.i(205567);
    if (paramString == null)
    {
      AppMethodBeat.o(205567);
      return null;
    }
    Iterator localIterator = this.qVa.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.qVL.mVideoView != null) && ((("".equals(localb.userId)) && (localb.streamType == -1)) || ((bt.kU(paramString, localb.userId)) && (localb.streamType == paramInt))))
      {
        localb.userId = paramString;
        localb.streamType = paramInt;
        localb.qVL.setVisibility(0);
        this.mCount += 1;
        if ((this.mMode == 2) && (this.mCount == 5)) {
          dRi();
        }
        localb.qVL.aUg("");
        paramString = localb.qVL.mVideoView;
        AppMethodBeat.o(205567);
        return paramString;
      }
    }
    AppMethodBeat.o(205567);
    return null;
  }
  
  public RelativeLayout getCameraContentView()
  {
    AppMethodBeat.i(205577);
    int i = 0;
    while (i < this.qVa.size())
    {
      Object localObject = (b)this.qVa.get(i);
      if (((b)localObject).qVL.qUx != null)
      {
        localObject = ((b)localObject).qVL;
        AppMethodBeat.o(205577);
        return localObject;
      }
      i += 1;
    }
    AppMethodBeat.o(205577);
    return null;
  }
  
  public int getCameraViewHeight()
  {
    AppMethodBeat.i(205570);
    Iterator localIterator = this.qVa.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.qVL.qUx != null)
      {
        if (localb.qVL.getLayoutParams() == null)
        {
          AppMethodBeat.o(205570);
          return -1;
        }
        int i = localb.qVL.getLayoutParams().height;
        AppMethodBeat.o(205570);
        return i;
      }
    }
    AppMethodBeat.o(205570);
    return -1;
  }
  
  public int getCameraViewWidth()
  {
    AppMethodBeat.i(205569);
    Iterator localIterator = this.qVa.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.qVL.qUx != null)
      {
        if (localb.qVL.getLayoutParams() == null)
        {
          AppMethodBeat.o(205569);
          return -1;
        }
        int i = localb.qVL.getLayoutParams().width;
        AppMethodBeat.o(205569);
        return i;
      }
    }
    AppMethodBeat.o(205569);
    return -1;
  }
  
  public int getRemoteViewIndex()
  {
    AppMethodBeat.i(205581);
    int i = 0;
    while (i < this.qVa.size())
    {
      if (((b)this.qVa.get(i)).qVL.mVideoView != null)
      {
        AppMethodBeat.o(205581);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(205581);
    return 0;
  }
  
  public final void h(b paramb)
  {
    AppMethodBeat.i(205563);
    if (this.qED != null) {}
    for (a locala = (a)this.qED.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(205563);
      return;
    }
  }
  
  public final void i(b paramb)
  {
    AppMethodBeat.i(205564);
    if (this.qED != null) {}
    for (a locala = (a)this.qED.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(205564);
      return;
    }
  }
  
  public final void j(b paramb)
  {
    AppMethodBeat.i(205565);
    if (this.qED != null) {}
    for (a locala = (a)this.qED.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(205565);
      return;
    }
  }
  
  public void setGestureListener(b.a parama)
  {
    AppMethodBeat.i(205582);
    int i = 0;
    while (i < this.qVa.size())
    {
      ((b)this.qVa.get(i)).qVL.qUK = parama;
      i += 1;
    }
    AppMethodBeat.o(205582);
  }
  
  public void setIVideoLayoutListener(a parama)
  {
    AppMethodBeat.i(205566);
    if (parama == null)
    {
      this.qED = null;
      AppMethodBeat.o(205566);
      return;
    }
    this.qED = new WeakReference(parama);
    AppMethodBeat.o(205566);
  }
  
  public void setMySelfUserId(String paramString)
  {
    this.qVq = paramString;
  }
  
  public final void w(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(205580);
    int i = 1;
    if (i < this.qVa.size())
    {
      b localb = (b)this.qVa.get(i);
      if ((localb.qVL != null) && (bt.kU(localb.userId, paramString)) && (localb.streamType == paramInt2))
      {
        if (paramInt1 != 1) {
          break label97;
        }
        localb.qVL.setLayoutParams(c.aP(getContext(), getWidth()));
      }
      for (;;)
      {
        i += 1;
        break;
        label97:
        if (paramInt1 == 2) {
          localb.qVL.setLayoutParams(c.G(getContext(), getWidth()));
        }
      }
    }
    AppMethodBeat.o(205580);
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    public int index = -1;
    public b qVL;
    public int streamType = -1;
    public String userId = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.view.TRTCVideoLayoutManager
 * JD-Core Version:    0.7.0.1
 */