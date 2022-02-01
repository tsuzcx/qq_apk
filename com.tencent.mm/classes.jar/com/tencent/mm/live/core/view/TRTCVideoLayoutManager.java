package com.tencent.mm.live.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TRTCVideoLayoutManager
  extends RelativeLayout
  implements b.b
{
  static final String TAG;
  int mCount;
  int mMode;
  public WeakReference<a> mSv;
  public List<TRTCVideoLayoutManager.b> mXo;
  private ArrayList<RelativeLayout.LayoutParams> mXp;
  private ArrayList<RelativeLayout.LayoutParams> mXq;
  private ArrayList<RelativeLayout.LayoutParams> mXr;
  private String mXs;
  private String mXt;
  public boolean mXu;
  
  static
  {
    AppMethodBeat.i(247585);
    TAG = TRTCVideoLayoutManager.class.getSimpleName();
    AppMethodBeat.o(247585);
  }
  
  public TRTCVideoLayoutManager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(247517);
    this.mCount = 0;
    this.mXu = false;
    ci(paramContext);
    AppMethodBeat.o(247517);
  }
  
  public TRTCVideoLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(247524);
    this.mCount = 0;
    this.mXu = false;
    ci(paramContext);
    AppMethodBeat.o(247524);
  }
  
  private void bhd()
  {
    AppMethodBeat.i(247563);
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.mXo.iterator();
    while (localIterator.hasNext())
    {
      TRTCVideoLayoutManager.b localb = (TRTCVideoLayoutManager.b)localIterator.next();
      localStringBuffer.append(localb.userId).append("-").append(localb.streamType).append("\n");
    }
    Log.i(TAG, localStringBuffer.toString());
    AppMethodBeat.o(247563);
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(247539);
    Log.i(TAG, "initView: ");
    this.mXo = Collections.synchronizedList(new ArrayList());
    Object localObject = new b(paramContext, false);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).mXh = false;
    ((b)localObject).a(this);
    ((b)localObject).bhb();
    TRTCVideoLayoutManager.b localb = new TRTCVideoLayoutManager.b((byte)0);
    localb.mXw = ((b)localObject);
    localb.index = 0;
    this.mXo.add(localb);
    localObject = new b(paramContext, true);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).mXh = false;
    ((b)localObject).a(this);
    ((b)localObject).bhb();
    localb = new TRTCVideoLayoutManager.b((byte)0);
    localb.mXw = ((b)localObject);
    localb.index = 1;
    this.mXo.add(localb);
    localObject = new b(paramContext, true);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).mXh = false;
    ((b)localObject).a(this);
    ((b)localObject).bhb();
    localb = new TRTCVideoLayoutManager.b((byte)0);
    localb.mXw = ((b)localObject);
    localb.index = 2;
    this.mXo.add(localb);
    localObject = new b(paramContext, true);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).mXh = false;
    ((b)localObject).a(this);
    ((b)localObject).bhb();
    localb = new TRTCVideoLayoutManager.b((byte)0);
    localb.mXw = ((b)localObject);
    localb.index = 3;
    this.mXo.add(localb);
    localObject = new b(paramContext, true);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).mXh = false;
    ((b)localObject).a(this);
    ((b)localObject).bhb();
    localb = new TRTCVideoLayoutManager.b((byte)0);
    localb.mXw = ((b)localObject);
    localb.index = 4;
    this.mXo.add(localb);
    paramContext = new b(paramContext, true);
    paramContext.setVisibility(8);
    paramContext.setBackgroundColor(-16777216);
    paramContext.mXh = false;
    paramContext.a(this);
    paramContext.bhb();
    localObject = new TRTCVideoLayoutManager.b((byte)0);
    ((TRTCVideoLayoutManager.b)localObject).mXw = paramContext;
    ((TRTCVideoLayoutManager.b)localObject).index = 5;
    this.mXo.add(localObject);
    this.mMode = 1;
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(247547);
        TRTCVideoLayoutManager.a(TRTCVideoLayoutManager.this);
        AppMethodBeat.o(247547);
      }
    });
    AppMethodBeat.o(247539);
  }
  
  private TRTCVideoLayoutManager.b k(b paramb)
  {
    AppMethodBeat.i(247551);
    Iterator localIterator = this.mXo.iterator();
    while (localIterator.hasNext())
    {
      TRTCVideoLayoutManager.b localb = (TRTCVideoLayoutManager.b)localIterator.next();
      if (localb.mXw == paramb)
      {
        AppMethodBeat.o(247551);
        return localb;
      }
    }
    AppMethodBeat.o(247551);
    return null;
  }
  
  public final void Gg(String paramString)
  {
    AppMethodBeat.i(247703);
    Log.i(TAG, "recyclerCloudViewView userId:" + paramString + " streamType:0");
    if (paramString == null)
    {
      AppMethodBeat.o(247703);
      return;
    }
    bhd();
    if (this.mMode == 1)
    {
      localObject = (TRTCVideoLayoutManager.b)this.mXo.get(0);
      if ((paramString.equals(((TRTCVideoLayoutManager.b)localObject).userId)) && (((TRTCVideoLayoutManager.b)localObject).streamType == 0)) {
        tz(1);
      }
    }
    Object localObject = this.mXo.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TRTCVideoLayoutManager.b localb = (TRTCVideoLayoutManager.b)((Iterator)localObject).next();
      Log.i(TAG, "recyclerCloudViewView entity.userId: " + localb.userId + ", entity.streamType: " + localb.streamType);
      if ((localb.streamType == 0) && (paramString.equals(localb.userId)))
      {
        this.mCount -= 1;
        if ((this.mMode == 2) && (this.mCount == 4)) {
          bhc();
        }
        b localb1 = localb.mXw;
        Context localContext = getContext();
        int i = getWidth();
        getHeight();
        localb1.setLayoutParams(c.O(localContext, i));
        localb.mXw.setVisibility(8);
        localb.userId = "";
        localb.streamType = -1;
      }
    }
    AppMethodBeat.o(247703);
  }
  
  final TRTCVideoLayoutManager.b Gi(String paramString)
  {
    AppMethodBeat.i(247714);
    Log.i(TAG, "findEntity userId:".concat(String.valueOf(paramString)));
    Iterator localIterator = this.mXo.iterator();
    while (localIterator.hasNext())
    {
      TRTCVideoLayoutManager.b localb = (TRTCVideoLayoutManager.b)localIterator.next();
      if (localb.userId.equals(paramString))
      {
        AppMethodBeat.o(247714);
        return localb;
      }
    }
    AppMethodBeat.o(247714);
    return null;
  }
  
  public final TXCloudVideoView aA(String paramString, int paramInt)
  {
    Iterator localIterator = null;
    AppMethodBeat.i(247655);
    Log.i(TAG, "allocCloudVideoView userId:" + paramString + " streamType:" + paramInt);
    bhd();
    if (paramString == null)
    {
      AppMethodBeat.o(247655);
      return null;
    }
    Object localObject2 = this.mXo.iterator();
    do
    {
      localObject1 = localIterator;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (TRTCVideoLayoutManager.b)((Iterator)localObject2).next();
    } while ((((TRTCVideoLayoutManager.b)localObject1).mXw.mVideoView == null) || (!Util.isEqual(paramString, ((TRTCVideoLayoutManager.b)localObject1).userId)) || (((TRTCVideoLayoutManager.b)localObject1).streamType != paramInt));
    ((TRTCVideoLayoutManager.b)localObject1).userId = paramString;
    ((TRTCVideoLayoutManager.b)localObject1).streamType = paramInt;
    ((TRTCVideoLayoutManager.b)localObject1).mXw.setVisibility(0);
    this.mCount += 1;
    if ((this.mMode == 2) && (this.mCount == 5)) {
      bhc();
    }
    ((TRTCVideoLayoutManager.b)localObject1).mXw.Gh("");
    Object localObject1 = ((TRTCVideoLayoutManager.b)localObject1).mXw.mVideoView;
    if (localObject1 == null)
    {
      localIterator = this.mXo.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (TRTCVideoLayoutManager.b)localIterator.next();
        if ((((TRTCVideoLayoutManager.b)localObject2).mXw.mVideoView != null) && ("".equals(((TRTCVideoLayoutManager.b)localObject2).userId)) && (((TRTCVideoLayoutManager.b)localObject2).streamType == -1))
        {
          ((TRTCVideoLayoutManager.b)localObject2).userId = paramString;
          ((TRTCVideoLayoutManager.b)localObject2).streamType = paramInt;
          ((TRTCVideoLayoutManager.b)localObject2).mXw.setVisibility(0);
          this.mCount += 1;
          if ((this.mMode == 2) && (this.mCount == 5)) {
            bhc();
          }
          ((TRTCVideoLayoutManager.b)localObject2).mXw.Gh("");
          localObject1 = ((TRTCVideoLayoutManager.b)localObject2).mXw.mVideoView;
        }
      }
    }
    for (;;)
    {
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger()))
      {
        Log.printInfoStack(TAG, "allocCloudVideoView fail, userId ".concat(String.valueOf(paramString)), new Object[0]);
        aa.makeText(MMApplicationContext.getContext(), "allocCloudVideoView fail, userId ".concat(String.valueOf(paramString)), 0).show();
      }
      Log.e(TAG, "allocCloudVideoView userId ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(247655);
      return localObject1;
    }
  }
  
  final void bE(List<String> paramList)
  {
    AppMethodBeat.i(247762);
    int i = 0;
    while (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      if ((i != 0) && (Gi(str) == null)) {
        aA(str, 0);
      }
      Log.i(TAG, "checkAnchorRemoteView userId:" + str + " i:" + i);
      i += 1;
    }
    AppMethodBeat.o(247762);
  }
  
  final void bhc()
  {
    AppMethodBeat.i(247733);
    if ((this.mXq == null) || (this.mXq.size() == 0) || (this.mXr == null) || (this.mXr.size() == 0))
    {
      this.mXq = c.b(getContext(), getWidth(), getHeight());
      this.mXr = c.c(getContext(), getWidth(), getHeight());
    }
    ArrayList localArrayList;
    int i;
    int j;
    label96:
    TRTCVideoLayoutManager.b localb;
    int k;
    if (this.mCount <= 4)
    {
      localArrayList = this.mXq;
      i = 0;
      j = 1;
      if (i >= this.mXo.size()) {
        break label229;
      }
      localb = (TRTCVideoLayoutManager.b)this.mXo.get(i);
      localb.mXw.mXh = false;
      localb.mXw.setOnClickListener(null);
      if (!localb.userId.equals(this.mXs)) {
        break label194;
      }
      localb.mXw.setLayoutParams((ViewGroup.LayoutParams)localArrayList.get(0));
      k = j;
    }
    for (;;)
    {
      i += 1;
      j = k;
      break label96;
      localArrayList = this.mXr;
      break;
      label194:
      k = j;
      if (j < localArrayList.size())
      {
        localb.mXw.setLayoutParams((ViewGroup.LayoutParams)localArrayList.get(j));
        k = j + 1;
      }
    }
    label229:
    AppMethodBeat.o(247733);
  }
  
  final void d(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(247747);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!Util.isEqual(str, paramString)) && (Gi(str) == null)) {
        aA(str, 0);
      }
      Log.i(TAG, "checkVisitorRemoteView userId:".concat(String.valueOf(str)));
    }
    AppMethodBeat.o(247747);
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(247592);
    if (this.mSv != null) {}
    for (a locala = (a)this.mSv.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(247592);
      return;
    }
  }
  
  public RelativeLayout getCameraContentView()
  {
    AppMethodBeat.i(247792);
    int i = 0;
    while (i < this.mXo.size())
    {
      Object localObject = (TRTCVideoLayoutManager.b)this.mXo.get(i);
      if (((TRTCVideoLayoutManager.b)localObject).mXw.mWV != null)
      {
        localObject = ((TRTCVideoLayoutManager.b)localObject).mXw;
        AppMethodBeat.o(247792);
        return localObject;
      }
      i += 1;
    }
    AppMethodBeat.o(247792);
    return null;
  }
  
  public int getCameraViewHeight()
  {
    AppMethodBeat.i(247687);
    Iterator localIterator = this.mXo.iterator();
    while (localIterator.hasNext())
    {
      TRTCVideoLayoutManager.b localb = (TRTCVideoLayoutManager.b)localIterator.next();
      if (localb.mXw.mWV != null)
      {
        if (localb.mXw.getLayoutParams() == null)
        {
          AppMethodBeat.o(247687);
          return -1;
        }
        int i = localb.mXw.getLayoutParams().height;
        AppMethodBeat.o(247687);
        return i;
      }
    }
    AppMethodBeat.o(247687);
    return -1;
  }
  
  public int getCameraViewWidth()
  {
    AppMethodBeat.i(247668);
    Iterator localIterator = this.mXo.iterator();
    while (localIterator.hasNext())
    {
      TRTCVideoLayoutManager.b localb = (TRTCVideoLayoutManager.b)localIterator.next();
      if (localb.mXw.mWV != null)
      {
        if (localb.mXw.getLayoutParams() == null)
        {
          AppMethodBeat.o(247668);
          return -1;
        }
        int i = localb.mXw.getLayoutParams().width;
        AppMethodBeat.o(247668);
        return i;
      }
    }
    AppMethodBeat.o(247668);
    return -1;
  }
  
  public int getRemoteViewIndex()
  {
    AppMethodBeat.i(247802);
    int i = 0;
    while (i < this.mXo.size())
    {
      if (((TRTCVideoLayoutManager.b)this.mXo.get(i)).mXw.mVideoView != null)
      {
        AppMethodBeat.o(247802);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(247802);
    return 0;
  }
  
  public final void h(b paramb)
  {
    AppMethodBeat.i(247599);
    if (this.mSv != null) {}
    for (a locala = (a)this.mSv.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(247599);
      return;
    }
  }
  
  public final void i(b paramb)
  {
    AppMethodBeat.i(247604);
    if (this.mSv != null) {}
    for (a locala = (a)this.mSv.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(247604);
      return;
    }
  }
  
  public final void j(b paramb)
  {
    AppMethodBeat.i(247612);
    if (this.mSv != null) {}
    for (a locala = (a)this.mSv.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(247612);
      return;
    }
  }
  
  public void setGestureListener(b.a parama)
  {
    AppMethodBeat.i(247817);
    int i = 0;
    while (i < this.mXo.size())
    {
      ((TRTCVideoLayoutManager.b)this.mXo.get(i)).mXw.mXk = parama;
      i += 1;
    }
    AppMethodBeat.o(247817);
  }
  
  public void setIVideoLayoutListener(a parama)
  {
    AppMethodBeat.i(247617);
    if (parama == null)
    {
      this.mSv = null;
      AppMethodBeat.o(247617);
      return;
    }
    this.mSv = new WeakReference(parama);
    AppMethodBeat.o(247617);
  }
  
  public void setMySelfUserId(String paramString)
  {
    this.mXs = paramString;
  }
  
  public void setPkUserId(String paramString)
  {
    this.mXt = paramString;
  }
  
  public final void tz(int paramInt)
  {
    AppMethodBeat.i(247779);
    if ((paramInt <= 0) || (this.mXo.size() <= paramInt))
    {
      AppMethodBeat.o(247779);
      return;
    }
    Log.i(TAG, "makeFullVideoView: from = ".concat(String.valueOf(paramInt)));
    TRTCVideoLayoutManager.b localb1 = (TRTCVideoLayoutManager.b)this.mXo.get(paramInt);
    ViewGroup.LayoutParams localLayoutParams1 = localb1.mXw.getLayoutParams();
    TRTCVideoLayoutManager.b localb2 = (TRTCVideoLayoutManager.b)this.mXo.get(0);
    ViewGroup.LayoutParams localLayoutParams2 = localb2.mXw.getLayoutParams();
    localb1.mXw.setLayoutParams(localLayoutParams2);
    localb1.index = 0;
    localb2.mXw.setLayoutParams(localLayoutParams1);
    localb2.index = paramInt;
    localb1.mXw.mXh = false;
    localb1.mXw.setOnClickListener(null);
    localb2.mXw.mXh = true;
    this.mXo.set(0, localb1);
    this.mXo.set(paramInt, localb2);
    paramInt = 0;
    while (paramInt < this.mXo.size())
    {
      bringChildToFront(((TRTCVideoLayoutManager.b)this.mXo.get(paramInt)).mXw);
      paramInt += 1;
    }
    AppMethodBeat.o(247779);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.view.TRTCVideoLayoutManager
 * JD-Core Version:    0.7.0.1
 */