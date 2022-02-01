package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ZoomImagePreviewer
  extends MMGestureGallery
  implements c.a
{
  private int height;
  private a oQj;
  private ArrayList<String> oQk;
  private ad oQl;
  private HashMap<String, SoftReference<MultiTouchImageView>> oQm;
  private HashSet<String> oQn;
  private b oQo;
  private float scale;
  private int viewId;
  private int width;
  
  public ZoomImagePreviewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(247768);
    this.oQk = new ArrayList();
    this.width = 0;
    this.height = 0;
    this.scale = 1.0F;
    this.oQm = new HashMap();
    this.oQn = new HashSet();
    this.viewId = 0;
    this.oQo = new b((byte)0);
    init();
    AppMethodBeat.o(247768);
  }
  
  public ZoomImagePreviewer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(247767);
    this.oQk = new ArrayList();
    this.width = 0;
    this.height = 0;
    this.scale = 1.0F;
    this.oQm = new HashMap();
    this.oQn = new HashSet();
    this.viewId = 0;
    this.oQo = new b((byte)0);
    init();
    AppMethodBeat.o(247767);
  }
  
  private void init()
  {
    AppMethodBeat.i(247769);
    this.oQj = new a((byte)0);
    setVerticalFadingEdgeEnabled(false);
    setHorizontalFadingEdgeEnabled(false);
    setAdapter(this.oQj);
    setSelection(0);
    AppMethodBeat.o(247769);
  }
  
  public final void D(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(247772);
    Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "updateDataView");
    if (this.oQl == null)
    {
      Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "updateDataView url is empty or component is null");
      AppMethodBeat.o(247772);
      return;
    }
    if ((this.oQk.isEmpty()) && (!paramArrayList.isEmpty()))
    {
      this.oQk.addAll(paramArrayList);
      this.oQj.notifyDataSetChanged();
      AppMethodBeat.o(247772);
      return;
    }
    if (!paramArrayList.isEmpty())
    {
      Object localObject1 = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      Object localObject2;
      while (paramArrayList.hasNext())
      {
        localObject2 = (String)paramArrayList.next();
        if (!this.oQk.contains(localObject2))
        {
          ((ArrayList)localObject1).add(localObject2);
          Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "new url is added, url:%s", new Object[] { localObject2 });
        }
      }
      if (!((ArrayList)localObject1).isEmpty())
      {
        Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "add new Data");
        this.oQk.addAll((Collection)localObject1);
        this.oQj.notifyDataSetChanged();
      }
      Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data");
      paramArrayList = this.oQk.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (String)paramArrayList.next();
        localObject2 = (SoftReference)this.oQm.get(localObject1);
        if ((localObject2 != null) && (((SoftReference)localObject2).get() != null))
        {
          localObject1 = (MultiTouchImageView)((SoftReference)localObject2).get();
          Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data width:%d, height:%d, scale:%f", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height), Float.valueOf(this.scale) });
          ((MultiTouchImageView)localObject1).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(242820);
              if (ZoomImagePreviewer.a(ZoomImagePreviewer.this) != this.mLX.getOriginScale())
              {
                this.mLX.setOriginScale(ZoomImagePreviewer.a(ZoomImagePreviewer.this));
                this.mLX.cK(ZoomImagePreviewer.a(ZoomImagePreviewer.this));
                this.mLX.hJy();
              }
              AppMethodBeat.o(242820);
            }
          }, 100L);
        }
        else
        {
          Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data url with view is recycle or not exist, url:%s", new Object[] { localObject1 });
        }
      }
    }
    AppMethodBeat.o(247772);
  }
  
  public final void dA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(247774);
    if (!this.oQn.contains(paramString1))
    {
      this.oQn.add(paramString1);
      b localb = this.oQo;
      HashMap localHashMap = new HashMap();
      localHashMap.put("url", paramString1);
      localHashMap.put("reason", paramString2);
      localHashMap.put("viewId", Integer.valueOf(localb.oQp.viewId));
      localb.E(localHashMap).j(localb.oQp.oQl.QW()).bPO();
    }
    AppMethodBeat.o(247774);
  }
  
  public final void eA(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void setComponent(ad paramad)
  {
    this.oQl = paramad;
  }
  
  public void setData(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(247771);
    Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "setData");
    if ((this.oQl == null) || (paramArrayList == null))
    {
      Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "url is empty or component is null");
      AppMethodBeat.o(247771);
      return;
    }
    this.oQk.clear();
    this.oQk.addAll(paramArrayList);
    this.oQj.notifyDataSetChanged();
    AppMethodBeat.o(247771);
  }
  
  public void setScale(float paramFloat)
  {
    this.scale = paramFloat;
  }
  
  public void setViewId(int paramInt)
  {
    this.viewId = paramInt;
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(281279);
      int i = ZoomImagePreviewer.d(ZoomImagePreviewer.this).size();
      AppMethodBeat.o(281279);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(281280);
      Object localObject = ZoomImagePreviewer.d(ZoomImagePreviewer.this).get(paramInt);
      AppMethodBeat.o(281280);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(281284);
      label95:
      ad localad;
      float f;
      ZoomImagePreviewer localZoomImagePreviewer;
      if (paramView == null)
      {
        paramView = new MultiTouchImageView(ZoomImagePreviewer.this.getContext(), 0, 0, (byte)0);
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        paramViewGroup = new a();
        paramViewGroup.oQr = paramView;
        paramView.setTag(paramViewGroup);
        paramView.setMinZoomLimit(0.5F);
        paramView.setMaxZoomDoubleTab(true);
        paramView.setOriginScale(ZoomImagePreviewer.a(ZoomImagePreviewer.this));
        if (Build.VERSION.SDK_INT != 20) {
          break label224;
        }
        paramView.setLayerType(1, null);
        paramView.setEnableHorLongBmpMode(false);
        paramViewGroup = (String)getItem(paramInt);
        Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "getView url:%s", new Object[] { paramViewGroup });
        localad = ZoomImagePreviewer.c(ZoomImagePreviewer.this);
        f = ZoomImagePreviewer.a(ZoomImagePreviewer.this);
        localZoomImagePreviewer = ZoomImagePreviewer.this;
        if ((paramView != null) && (paramViewGroup != null)) {
          break label245;
        }
        if (localZoomImagePreviewer != null) {
          localZoomImagePreviewer.dA(paramViewGroup, "invalid imageView or url");
        }
      }
      for (;;)
      {
        paramView.setTag(paramView);
        ZoomImagePreviewer.g(ZoomImagePreviewer.this).put(paramViewGroup, new SoftReference(paramView));
        AppMethodBeat.o(281284);
        return paramView;
        paramView = ((a)paramView.getTag()).oQr;
        Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "getView from holder");
        break;
        label224:
        ForceGpuUtil.decideLayerType(paramView, ZoomImagePreviewer.e(ZoomImagePreviewer.this), ZoomImagePreviewer.f(ZoomImagePreviewer.this));
        break label95;
        label245:
        if (!TextUtils.isEmpty(paramViewGroup))
        {
          String str = ((b)localad.K(b.class)).b(localad, paramViewGroup);
          ((a)localad.K(a.class)).a(str, new c.1(localZoomImagePreviewer, paramViewGroup, str, paramView, f));
        }
      }
    }
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(281278);
      ZoomImagePreviewer.c(ZoomImagePreviewer.this).runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(271377);
          ZoomImagePreviewer.b(ZoomImagePreviewer.this).clear();
          AppMethodBeat.o(271377);
        }
      });
      super.notifyDataSetChanged();
      AppMethodBeat.o(281278);
    }
    
    public final class a
    {
      public MultiTouchImageView oQr;
      
      public a() {}
    }
  }
  
  final class b
    extends az
  {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "onImagePreviewerLoadFail";
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.ZoomImagePreviewer
 * JD-Core Version:    0.7.0.1
 */