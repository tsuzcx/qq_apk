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
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.p;
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
  private a kqm;
  private ArrayList<String> kqn;
  private aa kqo;
  private HashMap<String, SoftReference<MultiTouchImageView>> kqp;
  private HashSet<String> kqq;
  private b kqr;
  private float scale;
  private int viewId;
  private int width;
  
  public ZoomImagePreviewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(186601);
    this.kqn = new ArrayList();
    this.width = 0;
    this.height = 0;
    this.scale = 1.0F;
    this.kqp = new HashMap();
    this.kqq = new HashSet();
    this.viewId = 0;
    this.kqr = new b((byte)0);
    init();
    AppMethodBeat.o(186601);
  }
  
  public ZoomImagePreviewer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(186600);
    this.kqn = new ArrayList();
    this.width = 0;
    this.height = 0;
    this.scale = 1.0F;
    this.kqp = new HashMap();
    this.kqq = new HashSet();
    this.viewId = 0;
    this.kqr = new b((byte)0);
    init();
    AppMethodBeat.o(186600);
  }
  
  private void init()
  {
    AppMethodBeat.i(186602);
    this.kqm = new a((byte)0);
    setVerticalFadingEdgeEnabled(false);
    setHorizontalFadingEdgeEnabled(false);
    setAdapter(this.kqm);
    setSelection(0);
    AppMethodBeat.o(186602);
  }
  
  public final void cX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186605);
    if (!this.kqq.contains(paramString1))
    {
      this.kqq.add(paramString1);
      b localb = this.kqr;
      HashMap localHashMap = new HashMap();
      localHashMap.put("url", paramString1);
      localHashMap.put("reason", paramString2);
      localHashMap.put("viewId", Integer.valueOf(localb.kqs.viewId));
      localb.B(localHashMap).h(localb.kqs.kqo.CX()).beN();
    }
    AppMethodBeat.o(186605);
  }
  
  public final void dO(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void setComponent(aa paramaa)
  {
    this.kqo = paramaa;
  }
  
  public void setData(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(186603);
    ac.i("MicroMsg.appbrand.ZoomImagePreviewer", "setData");
    if ((this.kqo == null) || (paramArrayList == null))
    {
      ac.i("MicroMsg.appbrand.ZoomImagePreviewer", "url is empty or component is null");
      AppMethodBeat.o(186603);
      return;
    }
    this.kqn.clear();
    this.kqn.addAll(paramArrayList);
    this.kqm.notifyDataSetChanged();
    AppMethodBeat.o(186603);
  }
  
  public void setScale(float paramFloat)
  {
    this.scale = paramFloat;
  }
  
  public void setViewId(int paramInt)
  {
    this.viewId = paramInt;
  }
  
  public final void y(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(186604);
    ac.i("MicroMsg.appbrand.ZoomImagePreviewer", "updateDataView");
    if (this.kqo == null)
    {
      ac.i("MicroMsg.appbrand.ZoomImagePreviewer", "updateDataView url is empty or component is null");
      AppMethodBeat.o(186604);
      return;
    }
    if ((this.kqn.isEmpty()) && (!paramArrayList.isEmpty()))
    {
      this.kqn.addAll(paramArrayList);
      this.kqm.notifyDataSetChanged();
      AppMethodBeat.o(186604);
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
        if (!this.kqn.contains(localObject2))
        {
          ((ArrayList)localObject1).add(localObject2);
          ac.i("MicroMsg.appbrand.ZoomImagePreviewer", "new url is added, url:%s", new Object[] { localObject2 });
        }
      }
      if (!((ArrayList)localObject1).isEmpty())
      {
        ac.i("MicroMsg.appbrand.ZoomImagePreviewer", "add new Data");
        this.kqn.addAll((Collection)localObject1);
        this.kqm.notifyDataSetChanged();
      }
      ac.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data");
      paramArrayList = this.kqn.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (String)paramArrayList.next();
        localObject2 = (SoftReference)this.kqp.get(localObject1);
        if ((localObject2 != null) && (((SoftReference)localObject2).get() != null))
        {
          localObject1 = (MultiTouchImageView)((SoftReference)localObject2).get();
          ac.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data width:%d, height:%d, scale:%f", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height), Float.valueOf(this.scale) });
          ((MultiTouchImageView)localObject1).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186594);
              if (ZoomImagePreviewer.a(ZoomImagePreviewer.this) != this.iBI.getOriginScale())
              {
                this.iBI.setOriginScale(ZoomImagePreviewer.a(ZoomImagePreviewer.this));
                this.iBI.bN(ZoomImagePreviewer.a(ZoomImagePreviewer.this));
                this.iBI.fik();
              }
              AppMethodBeat.o(186594);
            }
          }, 100L);
        }
        else
        {
          ac.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data url with view is recycle or not exist, url:%s", new Object[] { localObject1 });
        }
      }
    }
    AppMethodBeat.o(186604);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(186597);
      int i = ZoomImagePreviewer.d(ZoomImagePreviewer.this).size();
      AppMethodBeat.o(186597);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(186598);
      Object localObject = ZoomImagePreviewer.d(ZoomImagePreviewer.this).get(paramInt);
      AppMethodBeat.o(186598);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(186599);
      label95:
      aa localaa;
      float f;
      ZoomImagePreviewer localZoomImagePreviewer;
      if (paramView == null)
      {
        paramView = new MultiTouchImageView(ZoomImagePreviewer.this.getContext(), 0, 0, (byte)0);
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        paramViewGroup = new a();
        paramViewGroup.kqu = paramView;
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
        ac.i("MicroMsg.appbrand.ZoomImagePreviewer", "getView url:%s", new Object[] { paramViewGroup });
        localaa = ZoomImagePreviewer.c(ZoomImagePreviewer.this);
        f = ZoomImagePreviewer.a(ZoomImagePreviewer.this);
        localZoomImagePreviewer = ZoomImagePreviewer.this;
        if ((paramView != null) && (paramViewGroup != null)) {
          break label245;
        }
        if (localZoomImagePreviewer != null) {
          localZoomImagePreviewer.cX(paramViewGroup, "invalid imageView or url");
        }
      }
      for (;;)
      {
        paramView.setTag(paramView);
        ZoomImagePreviewer.g(ZoomImagePreviewer.this).put(paramViewGroup, new SoftReference(paramView));
        AppMethodBeat.o(186599);
        return paramView;
        paramView = ((a)paramView.getTag()).kqu;
        ac.i("MicroMsg.appbrand.ZoomImagePreviewer", "getView from holder");
        break;
        label224:
        p.z(paramView, ZoomImagePreviewer.e(ZoomImagePreviewer.this), ZoomImagePreviewer.f(ZoomImagePreviewer.this));
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
      AppMethodBeat.i(186596);
      ZoomImagePreviewer.c(ZoomImagePreviewer.this).runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186595);
          ZoomImagePreviewer.b(ZoomImagePreviewer.this).clear();
          AppMethodBeat.o(186595);
        }
      });
      super.notifyDataSetChanged();
      AppMethodBeat.o(186596);
    }
    
    public final class a
    {
      public MultiTouchImageView kqu;
      
      public a() {}
    }
  }
  
  final class b
    extends ar
  {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "onImagePreviewerLoadFail";
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.ZoomImagePreviewer
 * JD-Core Version:    0.7.0.1
 */