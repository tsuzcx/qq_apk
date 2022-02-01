package com.tencent.mm.live.core.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.ViewGroup;
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
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.w;
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
  private static final String TAG;
  public WeakReference<a> koF;
  private String ktA;
  private String ktB;
  private List<b> ktw;
  private ArrayList<RelativeLayout.LayoutParams> ktx;
  private ArrayList<RelativeLayout.LayoutParams> kty;
  private ArrayList<RelativeLayout.LayoutParams> ktz;
  private int mCount;
  private int mMode;
  
  static
  {
    AppMethodBeat.i(201171);
    TAG = TRTCVideoLayoutManager.class.getSimpleName();
    AppMethodBeat.o(201171);
  }
  
  public TRTCVideoLayoutManager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200996);
    this.mCount = 0;
    bv(paramContext);
    AppMethodBeat.o(200996);
  }
  
  public TRTCVideoLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200997);
    this.mCount = 0;
    bv(paramContext);
    AppMethodBeat.o(200997);
  }
  
  private b NV(String paramString)
  {
    AppMethodBeat.i(201065);
    Log.i(TAG, "findEntity userId:".concat(String.valueOf(paramString)));
    Iterator localIterator = this.ktw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.userId.equals(paramString))
      {
        AppMethodBeat.o(201065);
        return localb;
      }
    }
    AppMethodBeat.o(201065);
    return null;
  }
  
  private void aNt()
  {
    AppMethodBeat.i(201068);
    if ((this.kty == null) || (this.kty.size() == 0) || (this.ktz == null) || (this.ktz.size() == 0))
    {
      this.kty = c.b(getContext(), getWidth(), getHeight());
      this.ktz = c.c(getContext(), getWidth(), getHeight());
    }
    ArrayList localArrayList;
    int i;
    int j;
    label95:
    b localb;
    int k;
    if (this.mCount <= 4)
    {
      localArrayList = this.kty;
      i = 0;
      j = 1;
      if (i >= this.ktw.size()) {
        break label228;
      }
      localb = (b)this.ktw.get(i);
      localb.ktD.ktp = false;
      localb.ktD.setOnClickListener(null);
      if (!localb.userId.equals(this.ktA)) {
        break label193;
      }
      localb.ktD.setLayoutParams((ViewGroup.LayoutParams)localArrayList.get(0));
      k = j;
    }
    for (;;)
    {
      i += 1;
      j = k;
      break label95;
      localArrayList = this.ktz;
      break;
      label193:
      k = j;
      if (j < localArrayList.size())
      {
        localb.ktD.setLayoutParams((ViewGroup.LayoutParams)localArrayList.get(j));
        k = j + 1;
      }
    }
    label228:
    AppMethodBeat.o(201068);
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(201004);
    Log.i(TAG, "initView: ");
    this.ktw = Collections.synchronizedList(new ArrayList());
    Object localObject = new b(paramContext, false);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).ktp = false;
    ((b)localObject).a(this);
    ((b)localObject).aNo();
    b localb = new b((byte)0);
    localb.ktD = ((b)localObject);
    localb.index = 0;
    this.ktw.add(localb);
    localObject = new b(paramContext, true);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).ktp = false;
    ((b)localObject).a(this);
    ((b)localObject).aNo();
    localb = new b((byte)0);
    localb.ktD = ((b)localObject);
    localb.index = 1;
    this.ktw.add(localb);
    localObject = new b(paramContext, true);
    ((b)localObject).setVisibility(8);
    ((b)localObject).setBackgroundColor(-16777216);
    ((b)localObject).ktp = false;
    ((b)localObject).a(this);
    ((b)localObject).aNo();
    localb = new b((byte)0);
    localb.ktD = ((b)localObject);
    localb.index = 2;
    this.ktw.add(localb);
    paramContext = new b(paramContext, true);
    paramContext.setVisibility(8);
    paramContext.setBackgroundColor(-16777216);
    paramContext.ktp = false;
    paramContext.a(this);
    paramContext.aNo();
    localObject = new b((byte)0);
    ((b)localObject).ktD = paramContext;
    ((b)localObject).index = 3;
    this.ktw.add(localObject);
    this.mMode = 1;
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198955);
        TRTCVideoLayoutManager.a(TRTCVideoLayoutManager.this);
        AppMethodBeat.o(198955);
      }
    });
    AppMethodBeat.o(201004);
  }
  
  private b k(b paramb)
  {
    AppMethodBeat.i(201060);
    Iterator localIterator = this.ktw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.ktD == paramb)
      {
        AppMethodBeat.o(201060);
        return localb;
      }
    }
    AppMethodBeat.o(201060);
    return null;
  }
  
  public final void NS(String paramString)
  {
    AppMethodBeat.i(201046);
    if (paramString == null)
    {
      AppMethodBeat.o(201046);
      return;
    }
    b localb;
    if (this.mMode == 1)
    {
      localb = (b)this.ktw.get(0);
      if ((paramString.equals(localb.userId)) && (localb.streamType == 0)) {
        tE(1);
      }
    }
    Object localObject = this.ktw.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localb = (b)((Iterator)localObject).next();
      if ((localb.streamType == 0) && (paramString.equals(localb.userId)))
      {
        this.mCount -= 1;
        if ((this.mMode == 2) && (this.mCount == 4)) {
          aNt();
        }
        paramString = localb.ktD;
        localObject = getContext();
        int i = getWidth();
        getHeight();
        paramString.setLayoutParams(c.L((Context)localObject, i));
        localb.ktD.setVisibility(8);
        localb.userId = "";
        localb.streamType = -1;
        AppMethodBeat.o(201046);
        return;
      }
    }
    AppMethodBeat.o(201046);
  }
  
  public final b NU(String paramString)
  {
    AppMethodBeat.i(201021);
    if (paramString == null)
    {
      AppMethodBeat.o(201021);
      return null;
    }
    Iterator localIterator = this.ktw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.streamType == 0) && (localb.userId.equals(paramString)))
      {
        paramString = localb.ktD;
        AppMethodBeat.o(201021);
        return paramString;
      }
    }
    AppMethodBeat.o(201021);
    return null;
  }
  
  public final void a(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(201151);
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0) || (paramList == null) || (paramList.isEmpty()))
    {
      Log.w(TAG, "relayoutVisitorPreview return by invalid value!");
      AppMethodBeat.o(201151);
      return;
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if ((!Util.isEqual((String)localObject2, paramString2)) && (NV((String)localObject2) == null)) {
        aq((String)localObject2, 0);
      }
      Log.i(TAG, "checkVisitorRemoteView userId:".concat(String.valueOf(localObject2)));
    }
    switch (paramList.size())
    {
    }
    for (;;)
    {
      requestLayout();
      AppMethodBeat.o(201151);
      return;
      Log.i(TAG, "relayoutVisitorPreview only anchor view");
      paramString1 = NV(paramString1);
      if ((paramString1 != null) && (paramString1.ktD != null) && (paramString1.ktD.getLayoutParams() != null))
      {
        paramString2 = (RelativeLayout.LayoutParams)paramString1.ktD.getLayoutParams();
        paramString2.width = ax.au(getContext()).x;
        paramString2.height = ax.au(getContext()).y;
        paramString2.setMarginStart(0);
        paramString2.setMarginEnd(0);
        paramString1.ktD.setLayoutParams(paramString2);
        paramString1.ktD.bringToFront();
        continue;
        paramList = (String)paramList.get(1);
        float f = c.aNu();
        Log.i(TAG, "remoteAndCamera anchorUserId:" + paramString1 + " selfId:" + paramString2 + " userId:" + paramList + " ratio:" + f);
        if ((paramList == null) || (paramList.length() == 0))
        {
          Log.w(TAG, "halfCameraAndRemote case2 return by invalid value!");
        }
        else
        {
          paramString1 = NV(paramString1);
          if ((paramString1 != null) && (paramString1.ktD != null) && (paramString1.ktD.getLayoutParams() != null))
          {
            localObject1 = (RelativeLayout.LayoutParams)paramString1.ktD.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).width = (ax.au(getContext()).x / 2);
            ((RelativeLayout.LayoutParams)localObject1).height = ((int)(ax.au(getContext()).x / 2 * f));
            ((RelativeLayout.LayoutParams)localObject1).setMarginStart(0);
            ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
            ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
            paramString1.ktD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramString1.ktD.bringToFront();
          }
          if (Util.isEqual(paramString2, paramList))
          {
            paramString1 = (b)getCameraContentView();
            if ((paramString1 != null) && (paramString1.getLayoutParams() != null))
            {
              paramString2 = (RelativeLayout.LayoutParams)paramString1.getLayoutParams();
              paramString2.width = (ax.au(getContext()).x / 2);
              paramString2.height = ((int)(f * (ax.au(getContext()).x / 2)));
              paramString2.topMargin = 0;
              paramString2.bottomMargin = 0;
              paramString2.setMarginStart(paramString2.width);
              paramString2.setMarginEnd(0);
              paramString1.setLayoutParams(paramString2);
              paramString1.ktp = false;
              paramString1.setOnClickListener(null);
              paramString1.bringToFront();
            }
          }
          else
          {
            paramString1 = NV(paramList);
            if ((paramString1 != null) && (paramString1.ktD != null) && (paramString1.ktD.getLayoutParams() != null))
            {
              paramString2 = (RelativeLayout.LayoutParams)paramString1.ktD.getLayoutParams();
              paramString2.width = (ax.au(getContext()).x / 2);
              paramString2.height = ((int)(f * (ax.au(getContext()).x / 2)));
              paramString2.topMargin = 0;
              paramString2.bottomMargin = 0;
              paramString2.setMarginStart(paramString2.width);
              paramString2.setMarginEnd(0);
              paramString1.ktD.setLayoutParams(paramString2);
              paramString1.ktD.ktp = false;
              paramString1.ktD.setOnClickListener(null);
              paramString1.ktD.bringToFront();
              continue;
              localObject1 = (String)paramList.get(1);
              f = c.aNu();
              Log.i(TAG, "remoteAnd2Camera anchorUserId:" + paramString1 + " selfId:" + paramString2 + " userId1:" + (String)localObject1 + " ratio:" + f);
              label2209:
              label2601:
              if ((localObject1 == null) || (((String)localObject1).length() == 0))
              {
                Log.w(TAG, "halfCameraAndRemote case2 return by userId1 invalid value!");
              }
              else
              {
                localObject2 = NV(paramString1);
                RelativeLayout.LayoutParams localLayoutParams;
                if ((localObject2 != null) && (((b)localObject2).ktD != null) && (((b)localObject2).ktD.getLayoutParams() != null))
                {
                  localLayoutParams = (RelativeLayout.LayoutParams)((b)localObject2).ktD.getLayoutParams();
                  localLayoutParams.width = (ax.au(getContext()).x / 2);
                  localLayoutParams.height = ((int)(ax.au(getContext()).x / 2 * f));
                  localLayoutParams.setMarginStart(0);
                  localLayoutParams.setMarginEnd(0);
                  localLayoutParams.topMargin = 0;
                  localLayoutParams.bottomMargin = 0;
                  ((b)localObject2).ktD.setLayoutParams(localLayoutParams);
                  ((b)localObject2).ktD.bringToFront();
                }
                if (Util.isEqual(paramString2, (String)localObject1))
                {
                  localObject1 = (b)getCameraContentView();
                  if ((localObject1 != null) && (((b)localObject1).getLayoutParams() != null))
                  {
                    localObject2 = (RelativeLayout.LayoutParams)((b)localObject1).getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject2).width = (ax.au(getContext()).x / 2);
                    ((RelativeLayout.LayoutParams)localObject2).height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                    ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
                    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                    ((RelativeLayout.LayoutParams)localObject2).setMarginStart(((RelativeLayout.LayoutParams)localObject2).width);
                    ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                    ((b)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                    ((b)localObject1).ktp = false;
                    ((b)localObject1).setOnClickListener(null);
                    ((b)localObject1).bringToFront();
                  }
                }
                for (;;)
                {
                  paramList = (String)paramList.get(2);
                  Log.i(TAG, "remoteAnd2Camera anchorUserId:" + paramString1 + " selfId:" + paramString2 + " userId2:" + paramList);
                  if ((paramList != null) && (paramList.length() != 0)) {
                    break label1328;
                  }
                  Log.w(TAG, "halfCameraAndRemote case2 return by userId2 invalid value!");
                  break;
                  localObject1 = NV((String)localObject1);
                  if ((localObject1 != null) && (((b)localObject1).ktD != null) && (((b)localObject1).ktD.getLayoutParams() != null))
                  {
                    localObject2 = (RelativeLayout.LayoutParams)((b)localObject1).ktD.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject2).width = (ax.au(getContext()).x / 2);
                    ((RelativeLayout.LayoutParams)localObject2).height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                    ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
                    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                    ((RelativeLayout.LayoutParams)localObject2).setMarginStart(((RelativeLayout.LayoutParams)localObject2).width);
                    ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                    ((b)localObject1).ktD.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                    ((b)localObject1).ktD.ktp = false;
                    ((b)localObject1).ktD.setOnClickListener(null);
                    ((b)localObject1).ktD.bringToFront();
                  }
                }
                label1328:
                if (Util.isEqual(paramString2, paramList))
                {
                  paramString1 = (b)getCameraContentView();
                  if ((paramString1 != null) && (paramString1.getLayoutParams() != null))
                  {
                    paramString2 = (RelativeLayout.LayoutParams)paramString1.getLayoutParams();
                    paramString2.width = (ax.au(getContext()).x / 2);
                    paramString2.height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                    paramString2.topMargin = ((int)(f * (ax.au(getContext()).x / 2)) / 2);
                    paramString2.bottomMargin = 0;
                    paramString2.setMarginStart(paramString2.width);
                    paramString2.setMarginEnd(0);
                    paramString1.setLayoutParams(paramString2);
                    paramString1.ktp = false;
                    paramString1.setOnClickListener(null);
                    paramString1.bringToFront();
                  }
                }
                else
                {
                  paramString1 = NV(paramList);
                  if ((paramString1 != null) && (paramString1.ktD != null) && (paramString1.ktD.getLayoutParams() != null))
                  {
                    paramString2 = (RelativeLayout.LayoutParams)paramString1.ktD.getLayoutParams();
                    paramString2.width = (ax.au(getContext()).x / 2);
                    paramString2.height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                    paramString2.topMargin = ((int)(f * (ax.au(getContext()).x / 2)) / 2);
                    paramString2.bottomMargin = 0;
                    paramString2.setMarginStart(paramString2.width);
                    paramString2.setMarginEnd(0);
                    paramString1.ktD.setLayoutParams(paramString2);
                    paramString1.ktD.ktp = false;
                    paramString1.ktD.setOnClickListener(null);
                    paramString1.ktD.bringToFront();
                    continue;
                    localObject1 = (String)paramList.get(1);
                    f = c.aNu();
                    Log.i(TAG, "remoteAnd3Camera anchorUserId:" + paramString1 + " selfId:" + paramString2 + " userId1:" + (String)localObject1 + " ratio:" + f);
                    if ((localObject1 == null) || (((String)localObject1).length() == 0))
                    {
                      Log.w(TAG, "halfCameraAndRemote case2 return by userId1 invalid value!");
                    }
                    else
                    {
                      localObject2 = NV(paramString1);
                      if ((localObject2 != null) && (((b)localObject2).ktD != null) && (((b)localObject2).ktD.getLayoutParams() != null))
                      {
                        localLayoutParams = (RelativeLayout.LayoutParams)((b)localObject2).ktD.getLayoutParams();
                        localLayoutParams.width = (ax.au(getContext()).x / 2);
                        localLayoutParams.height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                        localLayoutParams.setMarginStart(0);
                        localLayoutParams.setMarginEnd(0);
                        localLayoutParams.topMargin = 0;
                        localLayoutParams.bottomMargin = 0;
                        ((b)localObject2).ktD.setLayoutParams(localLayoutParams);
                        ((b)localObject2).ktD.bringToFront();
                      }
                      if (Util.isEqual(paramString2, (String)localObject1))
                      {
                        localObject1 = (b)getCameraContentView();
                        if ((localObject1 != null) && (((b)localObject1).getLayoutParams() != null))
                        {
                          localObject2 = (RelativeLayout.LayoutParams)((b)localObject1).getLayoutParams();
                          ((RelativeLayout.LayoutParams)localObject2).width = (ax.au(getContext()).x / 2);
                          ((RelativeLayout.LayoutParams)localObject2).height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                          ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
                          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                          ((RelativeLayout.LayoutParams)localObject2).setMarginStart(((RelativeLayout.LayoutParams)localObject2).width);
                          ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                          ((b)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                          ((b)localObject1).ktp = false;
                          ((b)localObject1).setOnClickListener(null);
                          ((b)localObject1).bringToFront();
                        }
                      }
                      for (;;)
                      {
                        localObject1 = (String)paramList.get(2);
                        Log.i(TAG, "remoteAnd3Camera anchorUserId:" + paramString1 + " selfId:" + paramString2 + " userId2:" + (String)localObject1);
                        if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
                          break label2209;
                        }
                        Log.w(TAG, "halfCameraAndRemote case2 return by userId2 invalid value!");
                        break;
                        localObject1 = NV((String)localObject1);
                        if ((localObject1 != null) && (((b)localObject1).ktD != null) && (((b)localObject1).ktD.getLayoutParams() != null))
                        {
                          localObject2 = (RelativeLayout.LayoutParams)((b)localObject1).ktD.getLayoutParams();
                          ((RelativeLayout.LayoutParams)localObject2).width = (ax.au(getContext()).x / 2);
                          ((RelativeLayout.LayoutParams)localObject2).height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                          ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
                          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                          ((RelativeLayout.LayoutParams)localObject2).setMarginStart(((RelativeLayout.LayoutParams)localObject2).width);
                          ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                          ((b)localObject1).ktD.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                          ((b)localObject1).ktD.ktp = false;
                          ((b)localObject1).ktD.setOnClickListener(null);
                          ((b)localObject1).ktD.bringToFront();
                        }
                      }
                      if (Util.isEqual(paramString2, (String)localObject1))
                      {
                        localObject1 = (b)getCameraContentView();
                        if ((localObject1 != null) && (((b)localObject1).getLayoutParams() != null))
                        {
                          localObject2 = (RelativeLayout.LayoutParams)((b)localObject1).getLayoutParams();
                          ((RelativeLayout.LayoutParams)localObject2).width = (ax.au(getContext()).x / 2);
                          ((RelativeLayout.LayoutParams)localObject2).height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                          ((RelativeLayout.LayoutParams)localObject2).setMarginStart(0);
                          ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                          ((b)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                          ((b)localObject1).ktp = false;
                          ((b)localObject1).setOnClickListener(null);
                          ((b)localObject1).bringToFront();
                        }
                      }
                      for (;;)
                      {
                        paramList = (String)paramList.get(3);
                        Log.i(TAG, "remoteAnd3Camera anchorUserId:" + paramString1 + " selfId:" + paramString2 + " userId3:" + paramList);
                        if ((paramList != null) && (paramList.length() != 0)) {
                          break label2601;
                        }
                        Log.w(TAG, "halfCameraAndRemote case2 return by userId2 invalid value!");
                        break;
                        localObject1 = NV((String)localObject1);
                        if ((localObject1 != null) && (((b)localObject1).ktD != null) && (((b)localObject1).ktD.getLayoutParams() != null))
                        {
                          localObject2 = (RelativeLayout.LayoutParams)((b)localObject1).ktD.getLayoutParams();
                          ((RelativeLayout.LayoutParams)localObject2).width = (ax.au(getContext()).x / 2);
                          ((RelativeLayout.LayoutParams)localObject2).height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                          ((RelativeLayout.LayoutParams)localObject2).setMarginStart(0);
                          ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                          ((b)localObject1).ktD.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                          ((b)localObject1).ktD.ktp = false;
                          ((b)localObject1).ktD.setOnClickListener(null);
                          ((b)localObject1).ktD.bringToFront();
                        }
                      }
                      if (Util.isEqual(paramString2, paramList))
                      {
                        paramString1 = (b)getCameraContentView();
                        if ((paramString1 != null) && (paramString1.getLayoutParams() != null))
                        {
                          paramString2 = (RelativeLayout.LayoutParams)paramString1.getLayoutParams();
                          paramString2.width = (ax.au(getContext()).x / 2);
                          paramString2.height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                          paramString2.topMargin = ((int)(f * (ax.au(getContext()).x / 2)) / 2);
                          paramString2.bottomMargin = 0;
                          paramString2.setMarginStart(ax.au(getContext()).x / 2);
                          paramString2.setMarginEnd(0);
                          paramString1.setLayoutParams(paramString2);
                          paramString1.ktp = false;
                          paramString1.setOnClickListener(null);
                          paramString1.bringToFront();
                        }
                      }
                      else
                      {
                        paramString1 = NV(paramList);
                        if ((paramString1 != null) && (paramString1.ktD != null) && (paramString1.ktD.getLayoutParams() != null))
                        {
                          paramString2 = (RelativeLayout.LayoutParams)paramString1.ktD.getLayoutParams();
                          paramString2.width = (ax.au(getContext()).x / 2);
                          paramString2.height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                          paramString2.topMargin = ((int)(f * (ax.au(getContext()).x / 2)) / 2);
                          paramString2.bottomMargin = 0;
                          paramString2.setMarginStart(ax.au(getContext()).x / 2);
                          paramString2.setMarginEnd(0);
                          paramString1.ktD.setLayoutParams(paramString2);
                          paramString1.ktD.ktp = false;
                          paramString1.ktD.setOnClickListener(null);
                          paramString1.ktD.bringToFront();
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final SurfaceView aNp()
  {
    AppMethodBeat.i(201036);
    Object localObject = this.ktw.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (localb.ktD.ktd != null)
      {
        localb.userId = "";
        localb.streamType = 0;
        localb.ktD.setVisibility(0);
        this.mCount += 1;
        if ((this.mMode == 2) && (this.mCount == 5)) {
          aNt();
        }
        localb.ktD.NT("");
        localObject = localb.ktD.ktd;
        AppMethodBeat.o(201036);
        return localObject;
      }
    }
    AppMethodBeat.o(201036);
    return null;
  }
  
  public final void aNq()
  {
    AppMethodBeat.i(201052);
    Iterator localIterator = this.ktw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.ktD.ktd != null)
      {
        if (localb.index == 0) {
          tE(1);
        }
        this.mCount -= 1;
        if ((this.mMode == 2) && (this.mCount == 4)) {
          aNt();
        }
        b localb1 = localb.ktD;
        Context localContext = getContext();
        int i = getWidth();
        getHeight();
        localb1.setLayoutParams(c.L(localContext, i));
        localb.ktD.setVisibility(8);
        localb.userId = "";
        localb.streamType = -1;
      }
    }
    AppMethodBeat.o(201052);
  }
  
  public final void aNr()
  {
    AppMethodBeat.i(201054);
    Iterator localIterator = this.ktw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.ktD.mVideoView != null) && (localb.ktD.getParent() != null) && ((localb.ktD.getParent() instanceof ViewGroup)))
      {
        ViewGroup localViewGroup = (ViewGroup)localb.ktD.getParent();
        localViewGroup.removeView(localb.ktD);
        localViewGroup.addView(localb.ktD);
      }
    }
    AppMethodBeat.o(201054);
  }
  
  public final void aNs()
  {
    AppMethodBeat.i(201058);
    Iterator localIterator = this.ktw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.ktD.ktd != null) && (localb.ktD.getParent() != null) && ((localb.ktD.getParent() instanceof ViewGroup)))
      {
        ViewGroup localViewGroup = (ViewGroup)localb.ktD.getParent();
        localViewGroup.removeView(localb.ktD);
        localViewGroup.addView(localb.ktD);
      }
    }
    AppMethodBeat.o(201058);
  }
  
  public final void ad(List<String> paramList)
  {
    AppMethodBeat.i(201115);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.w(TAG, "halfCameraAndRemote return by invalid value!");
      AppMethodBeat.o(201115);
      return;
    }
    int i = 0;
    Object localObject1;
    while (i < paramList.size())
    {
      localObject1 = (String)paramList.get(i);
      if ((i != 0) && (NV((String)localObject1) == null)) {
        aq((String)localObject1, 0);
      }
      Log.i(TAG, "checkAnchorRemoteView userId:" + (String)localObject1 + " i:" + i);
      i += 1;
    }
    switch (paramList.size())
    {
    }
    for (;;)
    {
      requestLayout();
      AppMethodBeat.o(201115);
      return;
      paramList = (b)getCameraContentView();
      if ((paramList != null) && (paramList.getLayoutParams() != null))
      {
        localObject1 = (RelativeLayout.LayoutParams)paramList.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = -1;
        ((RelativeLayout.LayoutParams)localObject1).height = -1;
        ((RelativeLayout.LayoutParams)localObject1).setMarginStart(0);
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
        paramList.bringToFront();
        paramList.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramList.ktp = false;
        paramList.setOnClickListener(null);
        i = 0;
        while (i < this.ktw.size())
        {
          paramList = (b)this.ktw.get(i);
          if (paramList != null)
          {
            localObject1 = (RelativeLayout.LayoutParams)paramList.ktD.getLayoutParams();
            if (localObject1 != null)
            {
              ((RelativeLayout.LayoutParams)localObject1).width = -1;
              ((RelativeLayout.LayoutParams)localObject1).height = -1;
              ((RelativeLayout.LayoutParams)localObject1).setMarginStart(0);
              ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
              paramList.ktD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
          }
          i += 1;
        }
        paramList = (String)paramList.get(1);
        float f = c.aNu();
        Log.i(TAG, "cameraAndRemote userId:" + paramList + " ratio:" + f);
        if ((paramList == null) || (paramList.length() == 0))
        {
          Log.w(TAG, "halfCameraAndRemote case2 return by invalid value!");
        }
        else
        {
          localObject1 = (b)getCameraContentView();
          Object localObject2;
          if ((localObject1 != null) && (((b)localObject1).getLayoutParams() != null))
          {
            localObject2 = (RelativeLayout.LayoutParams)((b)localObject1).getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).width = (ax.au(getContext()).x / 2);
            ((RelativeLayout.LayoutParams)localObject2).height = ((int)(ax.au(getContext()).x / 2 * f));
            ((RelativeLayout.LayoutParams)localObject2).setMarginStart(0);
            ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
            ((b)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            ((b)localObject1).ktp = false;
            ((b)localObject1).setOnClickListener(null);
            ((b)localObject1).bringToFront();
          }
          paramList = NV(paramList);
          if ((paramList != null) && (paramList.ktD != null) && (paramList.ktD.getLayoutParams() != null))
          {
            localObject1 = (RelativeLayout.LayoutParams)paramList.ktD.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).width = (ax.au(getContext()).x / 2);
            ((RelativeLayout.LayoutParams)localObject1).height = ((int)(ax.au(getContext()).x / 2 * f));
            ((RelativeLayout.LayoutParams)localObject1).setMarginStart(ax.au(getContext()).x / 2);
            ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
            ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
            paramList.ktD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramList.ktD.ktp = false;
            paramList.ktD.setOnClickListener(null);
            paramList.ktD.bringToFront();
            continue;
            localObject1 = (String)paramList.get(1);
            f = c.aNu();
            Log.i(TAG, "cameraAnd2Remote userId1:" + (String)localObject1 + " ratio:" + f);
            if ((localObject1 == null) || (((String)localObject1).length() == 0))
            {
              Log.w(TAG, "halfCameraAndRemote case3 return by userId1 invalid value!");
            }
            else
            {
              localObject2 = (b)getCameraContentView();
              RelativeLayout.LayoutParams localLayoutParams;
              if ((localObject2 != null) && (((b)localObject2).getLayoutParams() != null))
              {
                localLayoutParams = (RelativeLayout.LayoutParams)((b)localObject2).getLayoutParams();
                localLayoutParams.width = (ax.au(getContext()).x / 2);
                localLayoutParams.height = ((int)(ax.au(getContext()).x / 2 * f));
                localLayoutParams.setMarginStart(0);
                localLayoutParams.setMarginEnd(0);
                ((b)localObject2).setLayoutParams(localLayoutParams);
                ((b)localObject2).ktp = false;
                ((b)localObject2).setOnClickListener(null);
                ((b)localObject2).bringToFront();
              }
              localObject1 = NV((String)localObject1);
              if ((localObject1 != null) && (((b)localObject1).ktD != null) && (((b)localObject1).ktD.getLayoutParams() != null))
              {
                localObject2 = (RelativeLayout.LayoutParams)((b)localObject1).ktD.getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject2).width = (ax.au(getContext()).x / 2);
                ((RelativeLayout.LayoutParams)localObject2).height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                ((RelativeLayout.LayoutParams)localObject2).setMarginStart(ax.au(getContext()).x / 2);
                ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
                ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                ((b)localObject1).ktD.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                ((b)localObject1).ktD.ktp = false;
                ((b)localObject1).ktD.setOnClickListener(null);
                ((b)localObject1).ktD.bringToFront();
              }
              paramList = (String)paramList.get(2);
              Log.i(TAG, "cameraAnd2Remote userId2:".concat(String.valueOf(paramList)));
              if ((paramList == null) || (paramList.length() == 0))
              {
                Log.w(TAG, "halfCameraAndRemote case3 return by userId1 invalid value!");
              }
              else
              {
                paramList = NV(paramList);
                if ((paramList != null) && (paramList.ktD != null) && (paramList.ktD.getLayoutParams() != null))
                {
                  localObject1 = (RelativeLayout.LayoutParams)paramList.ktD.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject1).width = (ax.au(getContext()).x / 2);
                  ((RelativeLayout.LayoutParams)localObject1).height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                  ((RelativeLayout.LayoutParams)localObject1).setMarginStart(ax.au(getContext()).x / 2);
                  ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
                  ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                  ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
                  paramList.ktD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  paramList.ktD.ktp = false;
                  paramList.ktD.setOnClickListener(null);
                  paramList.ktD.bringToFront();
                  continue;
                  localObject1 = (String)paramList.get(1);
                  f = c.aNu();
                  Log.i(TAG, "cameraAnd3Remote userId1:" + (String)localObject1 + " ratio:" + f);
                  if ((localObject1 == null) || (((String)localObject1).length() == 0))
                  {
                    Log.w(TAG, "halfCameraAndRemote case3 return by userId1 invalid value!");
                  }
                  else
                  {
                    localObject2 = (b)getCameraContentView();
                    if ((localObject2 != null) && (((b)localObject2).getLayoutParams() != null))
                    {
                      localLayoutParams = (RelativeLayout.LayoutParams)((b)localObject2).getLayoutParams();
                      localLayoutParams.width = (ax.au(getContext()).x / 2);
                      localLayoutParams.height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                      localLayoutParams.setMarginStart(0);
                      localLayoutParams.setMarginEnd(0);
                      ((b)localObject2).setLayoutParams(localLayoutParams);
                      ((b)localObject2).ktp = false;
                      ((b)localObject2).setOnClickListener(null);
                      ((b)localObject2).bringToFront();
                    }
                    localObject1 = NV((String)localObject1);
                    if ((localObject1 != null) && (((b)localObject1).ktD != null) && (((b)localObject1).ktD.getLayoutParams() != null))
                    {
                      localObject2 = (RelativeLayout.LayoutParams)((b)localObject1).ktD.getLayoutParams();
                      ((RelativeLayout.LayoutParams)localObject2).width = (ax.au(getContext()).x / 2);
                      ((RelativeLayout.LayoutParams)localObject2).height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                      ((RelativeLayout.LayoutParams)localObject2).setMarginStart(ax.au(getContext()).x / 2);
                      ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
                      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                      ((b)localObject1).ktD.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                      ((b)localObject1).ktD.ktp = false;
                      ((b)localObject1).ktD.setOnClickListener(null);
                      ((b)localObject1).ktD.bringToFront();
                    }
                    for (;;)
                    {
                      localObject1 = (String)paramList.get(2);
                      Log.i(TAG, "cameraAnd3Remote userId2:".concat(String.valueOf(localObject1)));
                      if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
                        break label1642;
                      }
                      Log.w(TAG, "halfCameraAndRemote case3 return by userId2 invalid value!");
                      break;
                      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger())) {
                        w.makeText(MMApplicationContext.getContext(), "pkEntity1 is nul", 0).show();
                      }
                      Log.e(TAG, "pkEntity1 is null");
                    }
                    label1642:
                    localObject1 = NV((String)localObject1);
                    if ((localObject1 != null) && (((b)localObject1).ktD != null) && (((b)localObject1).ktD.getLayoutParams() != null))
                    {
                      localObject2 = (RelativeLayout.LayoutParams)((b)localObject1).ktD.getLayoutParams();
                      ((RelativeLayout.LayoutParams)localObject2).width = (ax.au(getContext()).x / 2);
                      ((RelativeLayout.LayoutParams)localObject2).height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                      ((RelativeLayout.LayoutParams)localObject2).setMarginStart(0);
                      ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                      ((b)localObject1).ktD.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                      ((b)localObject1).ktD.ktp = false;
                      ((b)localObject1).ktD.setOnClickListener(null);
                      ((b)localObject1).ktD.bringToFront();
                    }
                    for (;;)
                    {
                      paramList = (String)paramList.get(3);
                      Log.i(TAG, "cameraAnd3Remote userId3:".concat(String.valueOf(paramList)));
                      if ((paramList != null) && (paramList.length() != 0)) {
                        break label1897;
                      }
                      Log.w(TAG, "halfCameraAndRemote case4 return by userId3 invalid value!");
                      break;
                      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger())) {
                        w.makeText(MMApplicationContext.getContext(), "pkEntity2 is nul", 0).show();
                      }
                      Log.e(TAG, "pkEntity2 is null");
                    }
                    label1897:
                    paramList = NV(paramList);
                    if ((paramList != null) && (paramList.ktD != null) && (paramList.ktD.getLayoutParams() != null))
                    {
                      localObject1 = (RelativeLayout.LayoutParams)paramList.ktD.getLayoutParams();
                      ((RelativeLayout.LayoutParams)localObject1).width = (ax.au(getContext()).x / 2);
                      ((RelativeLayout.LayoutParams)localObject1).height = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                      ((RelativeLayout.LayoutParams)localObject1).setMarginStart(ax.au(getContext()).x / 2);
                      ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
                      ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)(ax.au(getContext()).x / 2 * f) / 2);
                      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
                      paramList.ktD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                      paramList.ktD.ktp = false;
                      paramList.ktD.setOnClickListener(null);
                      paramList.ktD.bringToFront();
                    }
                    else
                    {
                      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger())) {
                        w.makeText(MMApplicationContext.getContext(), "pkEntity3 is nul", 0).show();
                      }
                      Log.e(TAG, "pkEntity3 is null");
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final TXCloudVideoView aq(String paramString, int paramInt)
  {
    AppMethodBeat.i(201032);
    if (paramString == null)
    {
      AppMethodBeat.o(201032);
      return null;
    }
    Iterator localIterator = this.ktw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb.ktD.mVideoView != null) && ((("".equals(localb.userId)) && (localb.streamType == -1)) || ((Util.isEqual(paramString, localb.userId)) && (localb.streamType == paramInt))))
      {
        localb.userId = paramString;
        localb.streamType = paramInt;
        localb.ktD.setVisibility(0);
        this.mCount += 1;
        if ((this.mMode == 2) && (this.mCount == 5)) {
          aNt();
        }
        localb.ktD.NT("");
        paramString = localb.ktD.mVideoView;
        AppMethodBeat.o(201032);
        return paramString;
      }
    }
    if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger()))
    {
      Log.printInfoStack(TAG, "allocCloudVideoView userId ".concat(String.valueOf(paramString)), new Object[0]);
      w.makeText(MMApplicationContext.getContext(), "allocCloudVideoView userId ".concat(String.valueOf(paramString)), 0).show();
    }
    Log.e(TAG, "allocCloudVideoView userId ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(201032);
    return null;
  }
  
  public final int ar(String paramString, int paramInt)
  {
    AppMethodBeat.i(201155);
    int i = 0;
    if (i < this.ktw.size())
    {
      b localb = (b)this.ktw.get(i);
      if ((localb.ktD.mVideoView == null) || (!Util.isEqual(paramString, localb.userId)) || (localb.streamType != paramInt)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(201155);
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(201160);
    int i = 1;
    if (i < this.ktw.size())
    {
      b localb = (b)this.ktw.get(i);
      if ((localb.ktD != null) && (Util.isEqual(localb.userId, paramString)) && (localb.streamType == paramInt2))
      {
        if (paramInt1 != 1) {
          break label101;
        }
        localb.ktD.setLayoutParams(c.K(getContext(), getWidth()));
      }
      for (;;)
      {
        i += 1;
        break;
        label101:
        if (paramInt1 == 2) {
          localb.ktD.setLayoutParams(c.J(getContext(), getWidth()));
        }
      }
    }
    AppMethodBeat.o(201160);
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(201006);
    if (this.koF != null) {}
    for (a locala = (a)this.koF.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(201006);
      return;
    }
  }
  
  public RelativeLayout getCameraContentView()
  {
    AppMethodBeat.i(201154);
    int i = 0;
    while (i < this.ktw.size())
    {
      Object localObject = (b)this.ktw.get(i);
      if (((b)localObject).ktD.ktd != null)
      {
        localObject = ((b)localObject).ktD;
        AppMethodBeat.o(201154);
        return localObject;
      }
      i += 1;
    }
    AppMethodBeat.o(201154);
    return null;
  }
  
  public int getCameraViewHeight()
  {
    AppMethodBeat.i(201042);
    Iterator localIterator = this.ktw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.ktD.ktd != null)
      {
        if (localb.ktD.getLayoutParams() == null)
        {
          AppMethodBeat.o(201042);
          return -1;
        }
        int i = localb.ktD.getLayoutParams().height;
        AppMethodBeat.o(201042);
        return i;
      }
    }
    AppMethodBeat.o(201042);
    return -1;
  }
  
  public int getCameraViewWidth()
  {
    AppMethodBeat.i(201040);
    Iterator localIterator = this.ktw.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.ktD.ktd != null)
      {
        if (localb.ktD.getLayoutParams() == null)
        {
          AppMethodBeat.o(201040);
          return -1;
        }
        int i = localb.ktD.getLayoutParams().width;
        AppMethodBeat.o(201040);
        return i;
      }
    }
    AppMethodBeat.o(201040);
    return -1;
  }
  
  public int getRemoteViewIndex()
  {
    AppMethodBeat.i(201163);
    int i = 0;
    while (i < this.ktw.size())
    {
      if (((b)this.ktw.get(i)).ktD.mVideoView != null)
      {
        AppMethodBeat.o(201163);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(201163);
    return 0;
  }
  
  public final void h(b paramb)
  {
    AppMethodBeat.i(201008);
    if (this.koF != null) {}
    for (a locala = (a)this.koF.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(201008);
      return;
    }
  }
  
  public final void i(b paramb)
  {
    AppMethodBeat.i(201011);
    if (this.koF != null) {}
    for (a locala = (a)this.koF.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(201011);
      return;
    }
  }
  
  public final void j(b paramb)
  {
    AppMethodBeat.i(201013);
    if (this.koF != null) {}
    for (a locala = (a)this.koF.get();; locala = null)
    {
      if (locala != null) {
        k(paramb);
      }
      AppMethodBeat.o(201013);
      return;
    }
  }
  
  public void setGestureListener(b.a parama)
  {
    AppMethodBeat.i(201167);
    int i = 0;
    while (i < this.ktw.size())
    {
      ((b)this.ktw.get(i)).ktD.kts = parama;
      i += 1;
    }
    AppMethodBeat.o(201167);
  }
  
  public void setIVideoLayoutListener(a parama)
  {
    AppMethodBeat.i(201016);
    if (parama == null)
    {
      this.koF = null;
      AppMethodBeat.o(201016);
      return;
    }
    this.koF = new WeakReference(parama);
    AppMethodBeat.o(201016);
  }
  
  public void setMySelfUserId(String paramString)
  {
    this.ktA = paramString;
  }
  
  public void setPkUserId(String paramString)
  {
    this.ktB = paramString;
  }
  
  public final void tE(int paramInt)
  {
    AppMethodBeat.i(201076);
    if ((paramInt <= 0) || (this.ktw.size() <= paramInt))
    {
      AppMethodBeat.o(201076);
      return;
    }
    Log.i(TAG, "makeFullVideoView: from = ".concat(String.valueOf(paramInt)));
    b localb1 = (b)this.ktw.get(paramInt);
    ViewGroup.LayoutParams localLayoutParams1 = localb1.ktD.getLayoutParams();
    b localb2 = (b)this.ktw.get(0);
    ViewGroup.LayoutParams localLayoutParams2 = localb2.ktD.getLayoutParams();
    localb1.ktD.setLayoutParams(localLayoutParams2);
    localb1.index = 0;
    localb2.ktD.setLayoutParams(localLayoutParams1);
    localb2.index = paramInt;
    localb1.ktD.ktp = false;
    localb1.ktD.setOnClickListener(null);
    localb2.ktD.ktp = true;
    this.ktw.set(0, localb1);
    this.ktw.set(paramInt, localb2);
    paramInt = 0;
    while (paramInt < this.ktw.size())
    {
      bringChildToFront(((b)this.ktw.get(paramInt)).ktD);
      paramInt += 1;
    }
    AppMethodBeat.o(201076);
  }
  
  public final void tF(int paramInt)
  {
    AppMethodBeat.i(201157);
    int i = 1;
    if (i < this.ktw.size())
    {
      b localb = (b)this.ktw.get(i);
      if ((localb.ktD != null) && (localb.ktD.ktd != null))
      {
        if (paramInt != 1) {
          break label82;
        }
        localb.ktD.setLayoutParams(c.K(getContext(), getWidth()));
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        if (paramInt == 2) {
          localb.ktD.setLayoutParams(c.J(getContext(), getWidth()));
        }
      }
    }
    AppMethodBeat.o(201157);
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    public int index = -1;
    public b ktD;
    public int streamType = -1;
    public String userId = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.view.TRTCVideoLayoutManager
 * JD-Core Version:    0.7.0.1
 */