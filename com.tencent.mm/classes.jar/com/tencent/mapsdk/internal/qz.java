package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayer.OnLayerStatusChangedListener;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.tools.Callback;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class qz
  implements VisualLayer
{
  private static final int b = 15;
  ra a;
  private dv c;
  private List<VisualLayer.OnLayerStatusChangedListener> d;
  private int e;
  private int f;
  private int g;
  private float h;
  private boolean i;
  private boolean j;
  private final String k;
  private VectorOverlay l;
  private ec m;
  private boolean n;
  private volatile int o;
  
  public qz(VisualLayerOptions paramVisualLayerOptions)
  {
    AppMethodBeat.i(226131);
    this.n = true;
    this.o = -1;
    this.k = paramVisualLayerOptions.getLayerId();
    a(paramVisualLayerOptions);
    AppMethodBeat.o(226131);
  }
  
  private BaseOverlayProvider a(ec paramec)
  {
    AppMethodBeat.i(226170);
    if (this.a != null)
    {
      paramec = this.a.a(paramec);
      AppMethodBeat.o(226170);
      return paramec;
    }
    AppMethodBeat.o(226170);
    return null;
  }
  
  private void a(ra paramra)
  {
    this.a = paramra;
  }
  
  private int b()
  {
    return this.g;
  }
  
  private ec b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(226166);
    if (this.a != null)
    {
      paramArrayOfByte = this.a.a(paramArrayOfByte);
      AppMethodBeat.o(226166);
      return paramArrayOfByte;
    }
    AppMethodBeat.o(226166);
    return null;
  }
  
  private boolean b(int paramInt)
  {
    if (this.o == paramInt) {
      return false;
    }
    int i1;
    switch (this.o)
    {
    default: 
      i1 = paramInt;
    }
    while (this.o != i1)
    {
      this.o = i1;
      return true;
      i1 = paramInt;
      if (paramInt > this.o) {
        i1 = this.o;
      }
    }
  }
  
  private <T extends ec> T c()
  {
    return this.m;
  }
  
  private void c(dv paramdv)
  {
    AppMethodBeat.i(226159);
    if ((paramdv == null) || (!this.n))
    {
      AppMethodBeat.o(226159);
      return;
    }
    this.n = false;
    if (this.g > 0)
    {
      if (this.g < 15) {
        this.g = 15;
      }
      paramdv.a(this.k, this.g);
      AppMethodBeat.o(226159);
      return;
    }
    paramdv.e(this.k);
    AppMethodBeat.o(226159);
  }
  
  private void d(dv paramdv)
  {
    AppMethodBeat.i(226182);
    kh.b("TDL", "#drawLayer");
    if ((this.m == null) || (!this.m.c()) || (paramdv == null))
    {
      AppMethodBeat.o(226182);
      return;
    }
    Object localObject = this.m;
    if (this.a != null) {}
    for (localObject = this.a.a((ec)localObject); localObject == null; localObject = null)
    {
      kh.d("TDL", "创建OverlayProvider失败");
      a(4);
      AppMethodBeat.o(226182);
      return;
    }
    kh.b("TDL", "创建OverlayProvider:".concat(String.valueOf(localObject)));
    if (this.l == null)
    {
      this.l = paramdv.c_().b.getMap().addVectorOverlay((VectorOverlayProvider)localObject);
      kh.b("TDL", "创建Overlay:" + this.l);
    }
    for (;;)
    {
      a(0);
      AppMethodBeat.o(226182);
      return;
      paramdv.c_().b.getMap().updateVectorOverlay(this.l, (VectorOverlayProvider)localObject);
      kh.b("TDL", "更新Overlay:" + this.l);
    }
  }
  
  public final void a()
  {
    AppMethodBeat.i(226272);
    if (this.l != null)
    {
      this.l.remove();
      this.l = null;
    }
    AppMethodBeat.o(226272);
  }
  
  public final void a(final int paramInt)
  {
    AppMethodBeat.i(226284);
    kh.b("TDL", "notifyStatusChange want from[" + this.o + "]to[" + paramInt + "]");
    jw.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224134);
        if (!qz.a(qz.this, paramInt))
        {
          AppMethodBeat.o(224134);
          return;
        }
        if (qz.b(qz.this) == null)
        {
          AppMethodBeat.o(224134);
          return;
        }
        kh.b("TDL", "notifyStatusChange do success");
        Iterator localIterator = new ArrayList(qz.b(qz.this)).iterator();
        while (localIterator.hasNext())
        {
          VisualLayer.OnLayerStatusChangedListener localOnLayerStatusChangedListener = (VisualLayer.OnLayerStatusChangedListener)localIterator.next();
          if (localOnLayerStatusChangedListener != null) {
            localOnLayerStatusChangedListener.onLayerLoadFinish(paramInt);
          }
        }
        AppMethodBeat.o(224134);
      }
    }, 10L);
    AppMethodBeat.o(226284);
  }
  
  public final void a(VisualLayerOptions paramVisualLayerOptions)
  {
    AppMethodBeat.i(226282);
    if (paramVisualLayerOptions != null)
    {
      setAlpha(paramVisualLayerOptions.getAlpha());
      setLevel(paramVisualLayerOptions.getLevel());
      setTimeInterval(paramVisualLayerOptions.getTimeInterval());
      setVisible(paramVisualLayerOptions.isVisible());
      setZIndex(paramVisualLayerOptions.getZIndex());
    }
    AppMethodBeat.o(226282);
  }
  
  public final void a(final dv paramdv)
  {
    AppMethodBeat.i(226280);
    this.c = paramdv;
    if (paramdv.c(this.k))
    {
      paramdv.a(this.k, new Callback()
      {
        private void a(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(224515);
          StringBuilder localStringBuilder = new StringBuilder("读取本地图层数据[");
          if (paramAnonymousArrayOfByte != null) {}
          for (int i = paramAnonymousArrayOfByte.length;; i = 0)
          {
            kh.b("TDL", i + "]");
            if ((paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0) && (qz.this.a(paramAnonymousArrayOfByte))) {
              qz.a(qz.this, paramdv);
            }
            qz.this.b(paramdv);
            AppMethodBeat.o(224515);
            return;
          }
        }
      });
      AppMethodBeat.o(226280);
      return;
    }
    if (paramdv.a())
    {
      a(2);
      AppMethodBeat.o(226280);
      return;
    }
    paramdv.d(this.k);
    AppMethodBeat.o(226280);
  }
  
  public final boolean a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(226283);
    StringBuilder localStringBuilder = new StringBuilder("#parseLayerData[");
    int i1;
    if (paramArrayOfByte != null)
    {
      i1 = paramArrayOfByte.length;
      kh.b("TDL", i1 + "]");
      if (this.a == null) {
        break label137;
      }
    }
    label137:
    for (paramArrayOfByte = this.a.a(paramArrayOfByte);; paramArrayOfByte = null)
    {
      this.m = paramArrayOfByte;
      if ((this.m == null) || (this.c == null) || (!this.m.c())) {
        break label142;
      }
      this.c.a(getId(), this.m.a(), this.m.b());
      kh.b("TDL", "创建Protocol对象：成功");
      AppMethodBeat.o(226283);
      return true;
      i1 = 0;
      break;
    }
    label142:
    a(3);
    kh.d("TDL", "创建Protocol对象：失败");
    AppMethodBeat.o(226283);
    return false;
  }
  
  public final void addLayerStatusChangedListener(VisualLayer.OnLayerStatusChangedListener paramOnLayerStatusChangedListener)
  {
    AppMethodBeat.i(226262);
    if (this.d == null) {
      this.d = new ArrayList();
    }
    this.d.remove(paramOnLayerStatusChangedListener);
    this.d.add(paramOnLayerStatusChangedListener);
    AppMethodBeat.o(226262);
  }
  
  public final void b(final dv paramdv)
  {
    AppMethodBeat.i(226281);
    if (paramdv == null)
    {
      AppMethodBeat.o(226281);
      return;
    }
    paramdv.b(this.k, new Callback()
    {
      private void a(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(224203);
        if ((paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0) && (qz.this.a(paramAnonymousArrayOfByte)))
        {
          qz.a(qz.this, paramdv);
          paramdv.a(qz.a(qz.this), paramAnonymousArrayOfByte);
        }
        qz.b(qz.this, paramdv);
        AppMethodBeat.o(224203);
      }
    });
    AppMethodBeat.o(226281);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(226278);
    if ((isRemoved()) || (TextUtils.isEmpty(this.k)))
    {
      AppMethodBeat.o(226278);
      return;
    }
    if (this.c != null) {
      this.c.b(this.k);
    }
    AppMethodBeat.o(226278);
  }
  
  public final float getAlpha()
  {
    return this.h;
  }
  
  public final String getId()
  {
    return this.k;
  }
  
  public final int getLevel()
  {
    return this.e;
  }
  
  public final int getZIndex()
  {
    return this.f;
  }
  
  public final boolean isRemoved()
  {
    return this.i;
  }
  
  public final boolean isVisible()
  {
    return this.j;
  }
  
  public final void releaseData()
  {
    AppMethodBeat.i(226277);
    if ((isRemoved()) || (TextUtils.isEmpty(this.k)))
    {
      AppMethodBeat.o(226277);
      return;
    }
    a();
    AppMethodBeat.o(226277);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(226270);
    if (this.d != null)
    {
      this.d.clear();
      this.d = null;
    }
    a();
    if (this.c != null)
    {
      this.c.a(this.k);
      this.c = null;
    }
    this.i = true;
    AppMethodBeat.o(226270);
  }
  
  public final void removeLayerStatusChangedListener(VisualLayer.OnLayerStatusChangedListener paramOnLayerStatusChangedListener)
  {
    AppMethodBeat.i(226265);
    if (this.d != null) {
      this.d.remove(paramOnLayerStatusChangedListener);
    }
    AppMethodBeat.o(226265);
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(226266);
    if (this.h != paramFloat)
    {
      this.h = paramFloat;
      if (this.l != null) {
        this.l.setOpacity(this.h);
      }
    }
    AppMethodBeat.o(226266);
  }
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(226239);
    if ((this.e != paramInt) && (paramInt != 0))
    {
      this.e = paramInt;
      if (this.l != null) {
        this.l.setLevel(this.e);
      }
    }
    AppMethodBeat.o(226239);
  }
  
  public final void setTimeInterval(int paramInt)
  {
    AppMethodBeat.i(226259);
    if (this.g != paramInt)
    {
      this.n = true;
      this.g = paramInt;
      if ((this.g > 0) && (this.g < 15)) {
        this.g = 15;
      }
      c(this.c);
    }
    AppMethodBeat.o(226259);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(226279);
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      if (this.l != null) {
        this.l.setVisibility(this.j);
      }
    }
    AppMethodBeat.o(226279);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(226250);
    setZIndex((int)paramFloat);
    AppMethodBeat.o(226250);
  }
  
  public final void setZIndex(int paramInt)
  {
    AppMethodBeat.i(226244);
    if (this.f != paramInt)
    {
      this.f = paramInt;
      if (this.l != null) {
        this.l.setZIndex(this.f);
      }
    }
    AppMethodBeat.o(226244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qz
 * JD-Core Version:    0.7.0.1
 */