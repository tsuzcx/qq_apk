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
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.q;
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
  implements a.a
{
  private int height;
  private a kLo;
  private ArrayList<String> kLp;
  private aa kLq;
  private HashMap<String, SoftReference<MultiTouchImageView>> kLr;
  private HashSet<String> kLs;
  private b kLt;
  private float scale;
  private int viewId;
  private int width;
  
  public ZoomImagePreviewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(188321);
    this.kLp = new ArrayList();
    this.width = 0;
    this.height = 0;
    this.scale = 1.0F;
    this.kLr = new HashMap();
    this.kLs = new HashSet();
    this.viewId = 0;
    this.kLt = new b((byte)0);
    init();
    AppMethodBeat.o(188321);
  }
  
  public ZoomImagePreviewer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(188320);
    this.kLp = new ArrayList();
    this.width = 0;
    this.height = 0;
    this.scale = 1.0F;
    this.kLr = new HashMap();
    this.kLs = new HashSet();
    this.viewId = 0;
    this.kLt = new b((byte)0);
    init();
    AppMethodBeat.o(188320);
  }
  
  private void init()
  {
    AppMethodBeat.i(188322);
    this.kLo = new a((byte)0);
    setVerticalFadingEdgeEnabled(false);
    setHorizontalFadingEdgeEnabled(false);
    setAdapter(this.kLo);
    setSelection(0);
    AppMethodBeat.o(188322);
  }
  
  public final void cZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(188325);
    if (!this.kLs.contains(paramString1))
    {
      this.kLs.add(paramString1);
      b localb = this.kLt;
      HashMap localHashMap = new HashMap();
      localHashMap.put("url", paramString1);
      localHashMap.put("reason", paramString2);
      localHashMap.put("viewId", Integer.valueOf(localb.kLu.viewId));
      localb.B(localHashMap).h(localb.kLu.kLq.Ew()).bir();
    }
    AppMethodBeat.o(188325);
  }
  
  public final void dQ(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void setComponent(aa paramaa)
  {
    this.kLq = paramaa;
  }
  
  public void setData(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(188323);
    ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "setData");
    if ((this.kLq == null) || (paramArrayList == null))
    {
      ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "url is empty or component is null");
      AppMethodBeat.o(188323);
      return;
    }
    this.kLp.clear();
    this.kLp.addAll(paramArrayList);
    this.kLo.notifyDataSetChanged();
    AppMethodBeat.o(188323);
  }
  
  public void setScale(float paramFloat)
  {
    this.scale = paramFloat;
  }
  
  public void setViewId(int paramInt)
  {
    this.viewId = paramInt;
  }
  
  public final void x(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(188324);
    ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "updateDataView");
    if (this.kLq == null)
    {
      ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "updateDataView url is empty or component is null");
      AppMethodBeat.o(188324);
      return;
    }
    if ((this.kLp.isEmpty()) && (!paramArrayList.isEmpty()))
    {
      this.kLp.addAll(paramArrayList);
      this.kLo.notifyDataSetChanged();
      AppMethodBeat.o(188324);
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
        if (!this.kLp.contains(localObject2))
        {
          ((ArrayList)localObject1).add(localObject2);
          ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "new url is added, url:%s", new Object[] { localObject2 });
        }
      }
      if (!((ArrayList)localObject1).isEmpty())
      {
        ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "add new Data");
        this.kLp.addAll((Collection)localObject1);
        this.kLo.notifyDataSetChanged();
      }
      ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data");
      paramArrayList = this.kLp.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (String)paramArrayList.next();
        localObject2 = (SoftReference)this.kLr.get(localObject1);
        if ((localObject2 != null) && (((SoftReference)localObject2).get() != null))
        {
          localObject1 = (MultiTouchImageView)((SoftReference)localObject2).get();
          ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data width:%d, height:%d, scale:%f", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height), Float.valueOf(this.scale) });
          ((MultiTouchImageView)localObject1).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(188314);
              if (ZoomImagePreviewer.a(ZoomImagePreviewer.this) != this.iUS.getOriginScale())
              {
                this.iUS.setOriginScale(ZoomImagePreviewer.a(ZoomImagePreviewer.this));
                this.iUS.bS(ZoomImagePreviewer.a(ZoomImagePreviewer.this));
                this.iUS.fyz();
              }
              AppMethodBeat.o(188314);
            }
          }, 100L);
        }
        else
        {
          ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data url with view is recycle or not exist, url:%s", new Object[] { localObject1 });
        }
      }
    }
    AppMethodBeat.o(188324);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(188317);
      int i = ZoomImagePreviewer.d(ZoomImagePreviewer.this).size();
      AppMethodBeat.o(188317);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(188318);
      Object localObject = ZoomImagePreviewer.d(ZoomImagePreviewer.this).get(paramInt);
      AppMethodBeat.o(188318);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(188319);
      label95:
      aa localaa;
      float f;
      ZoomImagePreviewer localZoomImagePreviewer;
      if (paramView == null)
      {
        paramView = new MultiTouchImageView(ZoomImagePreviewer.this.getContext(), 0, 0, (byte)0);
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        paramViewGroup = new a();
        paramViewGroup.kLw = paramView;
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
        ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "getView url:%s", new Object[] { paramViewGroup });
        localaa = ZoomImagePreviewer.c(ZoomImagePreviewer.this);
        f = ZoomImagePreviewer.a(ZoomImagePreviewer.this);
        localZoomImagePreviewer = ZoomImagePreviewer.this;
        if ((paramView != null) && (paramViewGroup != null)) {
          break label245;
        }
        if (localZoomImagePreviewer != null) {
          localZoomImagePreviewer.cZ(paramViewGroup, "invalid imageView or url");
        }
      }
      for (;;)
      {
        paramView.setTag(paramView);
        ZoomImagePreviewer.g(ZoomImagePreviewer.this).put(paramViewGroup, new SoftReference(paramView));
        AppMethodBeat.o(188319);
        return paramView;
        paramView = ((a)paramView.getTag()).kLw;
        ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "getView from holder");
        break;
        label224:
        q.A(paramView, ZoomImagePreviewer.e(ZoomImagePreviewer.this), ZoomImagePreviewer.f(ZoomImagePreviewer.this));
        break label95;
        label245:
        if (!TextUtils.isEmpty(paramViewGroup))
        {
          String str = ((b)localaa.K(b.class)).b(localaa, paramViewGroup);
          ((a)localaa.K(a.class)).a(str, new a.1(localZoomImagePreviewer, paramViewGroup, str, paramView, f));
        }
      }
    }
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(188316);
      ZoomImagePreviewer.c(ZoomImagePreviewer.this).runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188315);
          ZoomImagePreviewer.b(ZoomImagePreviewer.this).clear();
          AppMethodBeat.o(188315);
        }
      });
      super.notifyDataSetChanged();
      AppMethodBeat.o(188316);
    }
    
    public final class a
    {
      public MultiTouchImageView kLw;
      
      public a() {}
    }
  }
  
  final class b
    extends at
  {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "onImagePreviewerLoadFail";
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.ZoomImagePreviewer
 * JD-Core Version:    0.7.0.1
 */