package com.tencent.mm.live.core.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TRTCVideoLayoutManager
  extends RelativeLayout
  implements b.b
{
  private static final String TAG;
  public WeakReference<a> hAW;
  private ArrayList<b> hFr;
  private ArrayList<RelativeLayout.LayoutParams> hFs;
  private ArrayList<RelativeLayout.LayoutParams> hFt;
  private ArrayList<RelativeLayout.LayoutParams> hFu;
  private String hFv;
  private String hFw;
  private int mCount;
  private int mMode;
  
  static
  {
    AppMethodBeat.i(196371);
    TAG = TRTCVideoLayoutManager.class.getSimpleName();
    AppMethodBeat.o(196371);
  }
  
  public TRTCVideoLayoutManager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(196338);
    this.mCount = 0;
    bh(paramContext);
    AppMethodBeat.o(196338);
  }
  
  public TRTCVideoLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(196339);
    this.mCount = 0;
    bh(paramContext);
    AppMethodBeat.o(196339);
  }
  
  private b GI(String paramString)
  {
    AppMethodBeat.i(196356);
    Iterator localIterator = this.hFr.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.userId.equals(paramString))
      {
        AppMethodBeat.o(196356);
        return localb;
      }
    }
    AppMethodBeat.o(196356);
    return null;
  }
  
  private b aFb()
  {
    AppMethodBeat.i(196357);
    Iterator localIterator = this.hFr.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.hFy.hEY == null) && ((localb.userId == null) || (localb.userId.length() == 0)))
      {
        AppMethodBeat.o(196357);
        return localb;
      }
    }
    AppMethodBeat.o(196357);
    return null;
  }
  
  private void aFc()
  {
    AppMethodBeat.i(196358);
    if ((this.hFt == null) || (this.hFt.size() == 0) || (this.hFu == null) || (this.hFu.size() == 0))
    {
      this.hFt = c.b(getContext(), getWidth(), getHeight());
      this.hFu = c.c(getContext(), getWidth(), getHeight());
    }
    ArrayList localArrayList;
    int i;
    int j;
    label95:
    b localb;
    int k;
    if (this.mCount <= 4)
    {
      localArrayList = this.hFt;
      i = 0;
      j = 1;
      if (i >= this.hFr.size()) {
        break label224;
      }
      localb = (b)this.hFr.get(i);
      localb.hFy.hFk = false;
      localb.hFy.setOnClickListener(null);
      if (!localb.userId.equals(this.hFv)) {
        break label189;
      }
      localb.hFy.setLayoutParams((ViewGroup.LayoutParams)localArrayList.get(0));
      k = j;
    }
    for (;;)
    {
      i += 1;
      j = k;
      break label95;
      localArrayList = this.hFu;
      break;
      label189:
      k = j;
      if (j < localArrayList.size())
      {
        localb.hFy.setLayoutParams((ViewGroup.LayoutParams)localArrayList.get(j));
        k = j + 1;
      }
    }
    label224:
    AppMethodBeat.o(196358);
  }
  
  private void bh(Context paramContext)
  {
    AppMethodBeat.i(196340);
    this.hFr = new ArrayList();
    Object localObject = new b(paramContext, false);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).hFk = false;
    ((b)localObject).setIVideoLayoutListener(this);
    ((b)localObject).setBottomControllerVisibility(8);
    b localb = new b((byte)0);
    localb.hFy = ((b)localObject);
    localb.index = 0;
    this.hFr.add(localb);
    localObject = new b(paramContext, true);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).hFk = false;
    ((b)localObject).setIVideoLayoutListener(this);
    ((b)localObject).setBottomControllerVisibility(8);
    localb = new b((byte)0);
    localb.hFy = ((b)localObject);
    localb.index = 1;
    this.hFr.add(localb);
    paramContext = new b(paramContext, true);
    paramContext.setVisibility(8);
    paramContext.setBackgroundColor(-16777216);
    paramContext.hFk = false;
    paramContext.setIVideoLayoutListener(this);
    paramContext.setBottomControllerVisibility(8);
    localObject = new b((byte)0);
    ((b)localObject).hFy = paramContext;
    ((b)localObject).index = 1;
    this.hFr.add(localObject);
    this.mMode = 1;
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196337);
        TRTCVideoLayoutManager.a(TRTCVideoLayoutManager.this);
        AppMethodBeat.o(196337);
      }
    });
    AppMethodBeat.o(196340);
  }
  
  private b k(b paramb)
  {
    AppMethodBeat.i(196355);
    Iterator localIterator = this.hFr.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.hFy == paramb)
      {
        AppMethodBeat.o(196355);
        return localb;
      }
    }
    AppMethodBeat.o(196355);
    return null;
  }
  
  public final b GG(String paramString)
  {
    AppMethodBeat.i(196346);
    if (paramString == null)
    {
      AppMethodBeat.o(196346);
      return null;
    }
    Iterator localIterator = this.hFr.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.streamType == 0) && (localb.userId.equals(paramString)))
      {
        paramString = localb.hFy;
        AppMethodBeat.o(196346);
        return paramString;
      }
    }
    AppMethodBeat.o(196346);
    return null;
  }
  
  public final void GH(String paramString)
  {
    AppMethodBeat.i(196351);
    if (paramString == null)
    {
      AppMethodBeat.o(196351);
      return;
    }
    b localb;
    if (this.mMode == 1)
    {
      localb = (b)this.hFr.get(0);
      if ((paramString.equals(localb.userId)) && (localb.streamType == 0)) {
        qP(1);
      }
    }
    Object localObject = this.hFr.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localb = (b)((Iterator)localObject).next();
      if ((localb.streamType == 0) && (paramString.equals(localb.userId)))
      {
        this.mCount -= 1;
        if ((this.mMode == 2) && (this.mCount == 4)) {
          aFc();
        }
        paramString = localb.hFy;
        localObject = getContext();
        int i = getWidth();
        getHeight();
        paramString.setLayoutParams(c.I((Context)localObject, i));
        localb.hFy.setVisibility(8);
        localb.userId = "";
        localb.streamType = -1;
        AppMethodBeat.o(196351);
        return;
      }
    }
    AppMethodBeat.o(196351);
  }
  
  public final void GJ(String paramString)
  {
    AppMethodBeat.i(196360);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(196360);
      return;
    }
    new StringBuilder("halfCameraAndRemote selfUserId:").append(this.hFv).append(", userId:").append(paramString);
    b localb = (b)getCameraContentView();
    paramString = GI(paramString);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localb.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramString.hFy.getLayoutParams();
    localLayoutParams1.width = (au.az(getContext()).x / 2);
    localLayoutParams1.height = -1;
    localLayoutParams1.setMarginStart(0);
    localLayoutParams1.setMarginEnd(0);
    localLayoutParams2.width = (au.az(getContext()).x / 2);
    localLayoutParams2.height = -1;
    localLayoutParams2.setMarginStart(localLayoutParams1.width);
    localLayoutParams2.setMarginEnd(0);
    localLayoutParams2.topMargin = 0;
    localLayoutParams2.bottomMargin = 0;
    localb.setLayoutParams(localLayoutParams1);
    paramString.hFy.setLayoutParams(localLayoutParams2);
    paramString.hFy.hFk = false;
    paramString.hFy.setOnClickListener(null);
    localb.hFk = false;
    localb.setOnClickListener(null);
    AppMethodBeat.o(196360);
  }
  
  public final void GK(String paramString)
  {
    AppMethodBeat.i(196361);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(196361);
      return;
    }
    new StringBuilder("halfRemoteAndCamera selfUserId:").append(this.hFv).append(", userId:").append(paramString);
    b localb = (b)getCameraContentView();
    paramString = GI(paramString);
    if (paramString == null) {
      paramString = aFb();
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localb.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramString.hFy.getLayoutParams();
      localLayoutParams2.width = (au.az(getContext()).x / 2);
      localLayoutParams2.height = -1;
      localLayoutParams2.topMargin = 0;
      localLayoutParams2.bottomMargin = 0;
      localLayoutParams2.setMarginStart(0);
      localLayoutParams2.setMarginEnd(0);
      localLayoutParams1.width = (au.az(getContext()).x / 2);
      localLayoutParams1.height = -1;
      localLayoutParams1.topMargin = 0;
      localLayoutParams1.bottomMargin = 0;
      localLayoutParams1.setMarginStart(localLayoutParams2.width);
      localLayoutParams1.setMarginEnd(0);
      localb.setLayoutParams(localLayoutParams1);
      paramString.hFy.setLayoutParams(localLayoutParams2);
      paramString.hFy.hFk = false;
      paramString.hFy.setOnClickListener(null);
      localb.hFk = false;
      localb.setOnClickListener(null);
      AppMethodBeat.o(196361);
      return;
    }
  }
  
  public final TXCloudVideoView Y(String paramString, int paramInt)
  {
    AppMethodBeat.i(196347);
    if (paramString == null)
    {
      AppMethodBeat.o(196347);
      return null;
    }
    Iterator localIterator = this.hFr.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.hFy.mVideoView != null) && ((("".equals(localb.userId)) && (localb.streamType == -1)) || ((Util.isEqual(paramString, localb.userId)) && (localb.streamType == paramInt))))
      {
        localb.userId = paramString;
        localb.streamType = paramInt;
        localb.hFy.setVisibility(0);
        this.mCount += 1;
        if ((this.mMode == 2) && (this.mCount == 5)) {
          aFc();
        }
        localb.hFy.GF("");
        paramString = localb.hFy.mVideoView;
        AppMethodBeat.o(196347);
        return paramString;
      }
    }
    AppMethodBeat.o(196347);
    return null;
  }
  
  public final int Z(String paramString, int paramInt)
  {
    AppMethodBeat.i(196365);
    int i = 0;
    if (i < this.hFr.size())
    {
      b localb = (b)this.hFr.get(i);
      if ((localb.hFy.mVideoView == null) || (!Util.isEqual(paramString, localb.userId)) || (localb.streamType != paramInt)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(196365);
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final SurfaceView aEX()
  {
    AppMethodBeat.i(196348);
    Object localObject = this.hFr.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (localb.hFy.hEY != null)
      {
        localb.userId = "";
        localb.streamType = 0;
        localb.hFy.setVisibility(0);
        this.mCount += 1;
        if ((this.mMode == 2) && (this.mCount == 5)) {
          aFc();
        }
        localb.hFy.GF("");
        localObject = localb.hFy.hEY;
        AppMethodBeat.o(196348);
        return localObject;
      }
    }
    AppMethodBeat.o(196348);
    return null;
  }
  
  public final void aEY()
  {
    AppMethodBeat.i(196352);
    Iterator localIterator = this.hFr.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.hFy.hEY != null)
      {
        if (localb.index == 0) {
          qP(1);
        }
        this.mCount -= 1;
        if ((this.mMode == 2) && (this.mCount == 4)) {
          aFc();
        }
        b localb1 = localb.hFy;
        Context localContext = getContext();
        int i = getWidth();
        getHeight();
        localb1.setLayoutParams(c.I(localContext, i));
        localb.hFy.setVisibility(8);
        localb.userId = "";
        localb.streamType = -1;
      }
    }
    AppMethodBeat.o(196352);
  }
  
  public final void aEZ()
  {
    AppMethodBeat.i(196353);
    Iterator localIterator = this.hFr.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.hFy.mVideoView != null) && (localb.hFy.getParent() != null) && ((localb.hFy.getParent() instanceof ViewGroup)))
      {
        ViewGroup localViewGroup = (ViewGroup)localb.hFy.getParent();
        localViewGroup.removeView(localb.hFy);
        localViewGroup.addView(localb.hFy);
      }
    }
    AppMethodBeat.o(196353);
  }
  
  public final void aFa()
  {
    AppMethodBeat.i(196354);
    Iterator localIterator = this.hFr.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.hFy.hEY != null) && (localb.hFy.getParent() != null) && ((localb.hFy.getParent() instanceof ViewGroup)))
      {
        ViewGroup localViewGroup = (ViewGroup)localb.hFy.getParent();
        localViewGroup.removeView(localb.hFy);
        localViewGroup.addView(localb.hFy);
      }
    }
    AppMethodBeat.o(196354);
  }
  
  public final void aFd()
  {
    AppMethodBeat.i(196363);
    Object localObject = (b)getCameraContentView();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((b)localObject).getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.setMarginStart(0);
    localLayoutParams.setMarginEnd(0);
    ((b)localObject).setLayoutParams(localLayoutParams);
    ((b)localObject).hFk = false;
    ((b)localObject).setOnClickListener(null);
    int i = 0;
    while (i < this.hFr.size())
    {
      localObject = (b)this.hFr.get(i);
      if (localObject != null)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)((b)localObject).hFy.getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.width = -1;
          localLayoutParams.height = -1;
          localLayoutParams.setMarginStart(0);
          localLayoutParams.setMarginEnd(0);
          ((b)localObject).hFy.setLayoutParams(localLayoutParams);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(196363);
  }
  
  public final void av(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196362);
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0))
    {
      AppMethodBeat.o(196362);
      return;
    }
    new StringBuilder("halfRemoteAndRemote selfUserId:").append(this.hFv).append(", userId:").append(paramString2);
    paramString1 = GI(paramString1);
    paramString2 = GI(paramString2);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramString1.hFy.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramString2.hFy.getLayoutParams();
    localLayoutParams1.width = (au.az(getContext()).x / 2);
    localLayoutParams1.height = -1;
    localLayoutParams1.setMarginStart(0);
    localLayoutParams1.setMarginEnd(0);
    localLayoutParams2.width = (au.az(getContext()).x / 2);
    localLayoutParams2.height = -1;
    localLayoutParams2.topMargin = 0;
    localLayoutParams2.bottomMargin = 0;
    localLayoutParams2.setMarginStart(localLayoutParams2.width);
    localLayoutParams2.setMarginEnd(0);
    paramString1.hFy.setLayoutParams(localLayoutParams1);
    paramString2.hFy.setLayoutParams(localLayoutParams2);
    paramString2.hFy.hFk = false;
    paramString2.hFy.setOnClickListener(null);
    AppMethodBeat.o(196362);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(196367);
    int i = 1;
    if (i < this.hFr.size())
    {
      b localb = (b)this.hFr.get(i);
      if ((localb.hFy != null) && (Util.isEqual(localb.userId, paramString)) && (localb.streamType == paramInt2))
      {
        if (paramInt1 != 1) {
          break label97;
        }
        localb.hFy.setLayoutParams(c.H(getContext(), getWidth()));
      }
      for (;;)
      {
        i += 1;
        break;
        label97:
        if (paramInt1 == 2) {
          localb.hFy.setLayoutParams(c.G(getContext(), getWidth()));
        }
      }
    }
    AppMethodBeat.o(196367);
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(196341);
    if (this.hAW != null) {}
    for (a locala = (a)this.hAW.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(196341);
      return;
    }
  }
  
  public RelativeLayout getCameraContentView()
  {
    AppMethodBeat.i(196364);
    int i = 0;
    while (i < this.hFr.size())
    {
      Object localObject = (b)this.hFr.get(i);
      if (((b)localObject).hFy.hEY != null)
      {
        localObject = ((b)localObject).hFy;
        AppMethodBeat.o(196364);
        return localObject;
      }
      i += 1;
    }
    AppMethodBeat.o(196364);
    return null;
  }
  
  public int getCameraViewHeight()
  {
    AppMethodBeat.i(196350);
    Iterator localIterator = this.hFr.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.hFy.hEY != null)
      {
        if (localb.hFy.getLayoutParams() == null)
        {
          AppMethodBeat.o(196350);
          return -1;
        }
        int i = localb.hFy.getLayoutParams().height;
        AppMethodBeat.o(196350);
        return i;
      }
    }
    AppMethodBeat.o(196350);
    return -1;
  }
  
  public int getCameraViewWidth()
  {
    AppMethodBeat.i(196349);
    Iterator localIterator = this.hFr.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.hFy.hEY != null)
      {
        if (localb.hFy.getLayoutParams() == null)
        {
          AppMethodBeat.o(196349);
          return -1;
        }
        int i = localb.hFy.getLayoutParams().width;
        AppMethodBeat.o(196349);
        return i;
      }
    }
    AppMethodBeat.o(196349);
    return -1;
  }
  
  public int getRemoteViewIndex()
  {
    AppMethodBeat.i(196368);
    int i = 0;
    while (i < this.hFr.size())
    {
      if (((b)this.hFr.get(i)).hFy.mVideoView != null)
      {
        AppMethodBeat.o(196368);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(196368);
    return 0;
  }
  
  public final void h(b paramb)
  {
    AppMethodBeat.i(196342);
    if (this.hAW != null) {}
    for (a locala = (a)this.hAW.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(196342);
      return;
    }
  }
  
  public final void i(b paramb)
  {
    AppMethodBeat.i(196343);
    if (this.hAW != null) {}
    for (a locala = (a)this.hAW.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(196343);
      return;
    }
  }
  
  public final void j(b paramb)
  {
    AppMethodBeat.i(196344);
    if (this.hAW != null) {}
    for (a locala = (a)this.hAW.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(196344);
      return;
    }
  }
  
  public final void qP(int paramInt)
  {
    AppMethodBeat.i(196359);
    if ((paramInt <= 0) || (this.hFr.size() <= paramInt))
    {
      AppMethodBeat.o(196359);
      return;
    }
    b localb1 = (b)this.hFr.get(paramInt);
    ViewGroup.LayoutParams localLayoutParams1 = localb1.hFy.getLayoutParams();
    b localb2 = (b)this.hFr.get(0);
    ViewGroup.LayoutParams localLayoutParams2 = localb2.hFy.getLayoutParams();
    localb1.hFy.setLayoutParams(localLayoutParams2);
    localb1.index = 0;
    localb2.hFy.setLayoutParams(localLayoutParams1);
    localb2.index = paramInt;
    localb1.hFy.hFk = false;
    localb1.hFy.setOnClickListener(null);
    localb2.hFy.hFk = true;
    this.hFr.set(0, localb1);
    this.hFr.set(paramInt, localb2);
    paramInt = 0;
    while (paramInt < this.hFr.size())
    {
      bringChildToFront(((b)this.hFr.get(paramInt)).hFy);
      paramInt += 1;
    }
    AppMethodBeat.o(196359);
  }
  
  public final void qQ(int paramInt)
  {
    AppMethodBeat.i(196366);
    int i = 1;
    if (i < this.hFr.size())
    {
      b localb = (b)this.hFr.get(i);
      if ((localb.hFy != null) && (localb.hFy.hEY != null))
      {
        if (paramInt != 1) {
          break label78;
        }
        localb.hFy.setLayoutParams(c.H(getContext(), getWidth()));
      }
      for (;;)
      {
        i += 1;
        break;
        label78:
        if (paramInt == 2) {
          localb.hFy.setLayoutParams(c.G(getContext(), getWidth()));
        }
      }
    }
    AppMethodBeat.o(196366);
  }
  
  public void setGestureListener(b.a parama)
  {
    AppMethodBeat.i(196369);
    int i = 0;
    while (i < this.hFr.size())
    {
      ((b)this.hFr.get(i)).hFy.hFn = parama;
      i += 1;
    }
    AppMethodBeat.o(196369);
  }
  
  public void setIVideoLayoutListener(a parama)
  {
    AppMethodBeat.i(196345);
    if (parama == null)
    {
      this.hAW = null;
      AppMethodBeat.o(196345);
      return;
    }
    this.hAW = new WeakReference(parama);
    AppMethodBeat.o(196345);
  }
  
  public void setMySelfUserId(String paramString)
  {
    this.hFv = paramString;
  }
  
  public void setPkUserId(String paramString)
  {
    this.hFw = paramString;
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    public b hFy;
    public int index = -1;
    public int streamType = -1;
    public String userId = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.view.TRTCVideoLayoutManager
 * JD-Core Version:    0.7.0.1
 */