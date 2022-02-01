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
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.ac;
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
  private a lTB;
  private ArrayList<String> lTC;
  private ac lTD;
  private HashMap<String, SoftReference<MultiTouchImageView>> lTE;
  private HashSet<String> lTF;
  private b lTG;
  private float scale;
  private int viewId;
  private int width;
  
  public ZoomImagePreviewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(226751);
    this.lTC = new ArrayList();
    this.width = 0;
    this.height = 0;
    this.scale = 1.0F;
    this.lTE = new HashMap();
    this.lTF = new HashSet();
    this.viewId = 0;
    this.lTG = new b((byte)0);
    init();
    AppMethodBeat.o(226751);
  }
  
  public ZoomImagePreviewer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(226750);
    this.lTC = new ArrayList();
    this.width = 0;
    this.height = 0;
    this.scale = 1.0F;
    this.lTE = new HashMap();
    this.lTF = new HashSet();
    this.viewId = 0;
    this.lTG = new b((byte)0);
    init();
    AppMethodBeat.o(226750);
  }
  
  private void init()
  {
    AppMethodBeat.i(226752);
    this.lTB = new a((byte)0);
    setVerticalFadingEdgeEnabled(false);
    setHorizontalFadingEdgeEnabled(false);
    setAdapter(this.lTB);
    setSelection(0);
    AppMethodBeat.o(226752);
  }
  
  public final void C(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(226754);
    Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "updateDataView");
    if (this.lTD == null)
    {
      Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "updateDataView url is empty or component is null");
      AppMethodBeat.o(226754);
      return;
    }
    if ((this.lTC.isEmpty()) && (!paramArrayList.isEmpty()))
    {
      this.lTC.addAll(paramArrayList);
      this.lTB.notifyDataSetChanged();
      AppMethodBeat.o(226754);
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
        if (!this.lTC.contains(localObject2))
        {
          ((ArrayList)localObject1).add(localObject2);
          Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "new url is added, url:%s", new Object[] { localObject2 });
        }
      }
      if (!((ArrayList)localObject1).isEmpty())
      {
        Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "add new Data");
        this.lTC.addAll((Collection)localObject1);
        this.lTB.notifyDataSetChanged();
      }
      Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data");
      paramArrayList = this.lTC.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (String)paramArrayList.next();
        localObject2 = (SoftReference)this.lTE.get(localObject1);
        if ((localObject2 != null) && (((SoftReference)localObject2).get() != null))
        {
          localObject1 = (MultiTouchImageView)((SoftReference)localObject2).get();
          Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data width:%d, height:%d, scale:%f", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height), Float.valueOf(this.scale) });
          ((MultiTouchImageView)localObject1).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(226744);
              if (ZoomImagePreviewer.a(ZoomImagePreviewer.this) != this.jUK.getOriginScale())
              {
                this.jUK.setOriginScale(ZoomImagePreviewer.a(ZoomImagePreviewer.this));
                this.jUK.cs(ZoomImagePreviewer.a(ZoomImagePreviewer.this));
                this.jUK.gKz();
              }
              AppMethodBeat.o(226744);
            }
          }, 100L);
        }
        else
        {
          Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data url with view is recycle or not exist, url:%s", new Object[] { localObject1 });
        }
      }
    }
    AppMethodBeat.o(226754);
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(226755);
    if (!this.lTF.contains(paramString1))
    {
      this.lTF.add(paramString1);
      b localb = this.lTG;
      HashMap localHashMap = new HashMap();
      localHashMap.put("url", paramString1);
      localHashMap.put("reason", paramString2);
      localHashMap.put("viewId", Integer.valueOf(localb.lTH.viewId));
      localb.L(localHashMap).h(localb.lTH.lTD.NY()).bEo();
    }
    AppMethodBeat.o(226755);
  }
  
  public final void ec(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void setComponent(ac paramac)
  {
    this.lTD = paramac;
  }
  
  public void setData(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(226753);
    Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "setData");
    if ((this.lTD == null) || (paramArrayList == null))
    {
      Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "url is empty or component is null");
      AppMethodBeat.o(226753);
      return;
    }
    this.lTC.clear();
    this.lTC.addAll(paramArrayList);
    this.lTB.notifyDataSetChanged();
    AppMethodBeat.o(226753);
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
      AppMethodBeat.i(226747);
      int i = ZoomImagePreviewer.d(ZoomImagePreviewer.this).size();
      AppMethodBeat.o(226747);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(226748);
      Object localObject = ZoomImagePreviewer.d(ZoomImagePreviewer.this).get(paramInt);
      AppMethodBeat.o(226748);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(226749);
      label95:
      ac localac;
      float f;
      ZoomImagePreviewer localZoomImagePreviewer;
      if (paramView == null)
      {
        paramView = new MultiTouchImageView(ZoomImagePreviewer.this.getContext(), 0, 0, (byte)0);
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        paramViewGroup = new a();
        paramViewGroup.lTJ = paramView;
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
        localac = ZoomImagePreviewer.c(ZoomImagePreviewer.this);
        f = ZoomImagePreviewer.a(ZoomImagePreviewer.this);
        localZoomImagePreviewer = ZoomImagePreviewer.this;
        if ((paramView != null) && (paramViewGroup != null)) {
          break label245;
        }
        if (localZoomImagePreviewer != null) {
          localZoomImagePreviewer.dr(paramViewGroup, "invalid imageView or url");
        }
      }
      for (;;)
      {
        paramView.setTag(paramView);
        ZoomImagePreviewer.g(ZoomImagePreviewer.this).put(paramViewGroup, new SoftReference(paramView));
        AppMethodBeat.o(226749);
        return paramView;
        paramView = ((a)paramView.getTag()).lTJ;
        Log.i("MicroMsg.appbrand.ZoomImagePreviewer", "getView from holder");
        break;
        label224:
        ForceGpuUtil.decideLayerType(paramView, ZoomImagePreviewer.e(ZoomImagePreviewer.this), ZoomImagePreviewer.f(ZoomImagePreviewer.this));
        break label95;
        label245:
        if (!TextUtils.isEmpty(paramViewGroup))
        {
          String str = ((b)localac.M(b.class)).b(localac, paramViewGroup);
          ((a)localac.M(a.class)).a(str, new c.1(localZoomImagePreviewer, paramViewGroup, str, paramView, f));
        }
      }
    }
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(226746);
      ZoomImagePreviewer.c(ZoomImagePreviewer.this).runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(226745);
          ZoomImagePreviewer.b(ZoomImagePreviewer.this).clear();
          AppMethodBeat.o(226745);
        }
      });
      super.notifyDataSetChanged();
      AppMethodBeat.o(226746);
    }
    
    public final class a
    {
      public MultiTouchImageView lTJ;
      
      public a() {}
    }
  }
  
  final class b
    extends bc
  {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "onImagePreviewerLoadFail";
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.ZoomImagePreviewer
 * JD-Core Version:    0.7.0.1
 */