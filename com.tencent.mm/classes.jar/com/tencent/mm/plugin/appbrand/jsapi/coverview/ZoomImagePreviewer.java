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
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.r;
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
  private a kOD;
  private ArrayList<String> kOE;
  private z kOF;
  private HashMap<String, SoftReference<MultiTouchImageView>> kOG;
  private HashSet<String> kOH;
  private b kOI;
  private float scale;
  private int viewId;
  private int width;
  
  public ZoomImagePreviewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(222447);
    this.kOE = new ArrayList();
    this.width = 0;
    this.height = 0;
    this.scale = 1.0F;
    this.kOG = new HashMap();
    this.kOH = new HashSet();
    this.viewId = 0;
    this.kOI = new b((byte)0);
    init();
    AppMethodBeat.o(222447);
  }
  
  public ZoomImagePreviewer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(222446);
    this.kOE = new ArrayList();
    this.width = 0;
    this.height = 0;
    this.scale = 1.0F;
    this.kOG = new HashMap();
    this.kOH = new HashSet();
    this.viewId = 0;
    this.kOI = new b((byte)0);
    init();
    AppMethodBeat.o(222446);
  }
  
  private void init()
  {
    AppMethodBeat.i(222448);
    this.kOD = new a((byte)0);
    setVerticalFadingEdgeEnabled(false);
    setHorizontalFadingEdgeEnabled(false);
    setAdapter(this.kOD);
    setSelection(0);
    AppMethodBeat.o(222448);
  }
  
  public final void dQ(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final void db(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222451);
    if (!this.kOH.contains(paramString1))
    {
      this.kOH.add(paramString1);
      b localb = this.kOI;
      HashMap localHashMap = new HashMap();
      localHashMap.put("url", paramString1);
      localHashMap.put("reason", paramString2);
      localHashMap.put("viewId", Integer.valueOf(localb.kOJ.viewId));
      localb.I(localHashMap).h(localb.kOJ.kOF.Ey()).bja();
    }
    AppMethodBeat.o(222451);
  }
  
  public void setComponent(z paramz)
  {
    this.kOF = paramz;
  }
  
  public void setData(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(222449);
    ae.i("MicroMsg.appbrand.ZoomImagePreviewer", "setData");
    if ((this.kOF == null) || (paramArrayList == null))
    {
      ae.i("MicroMsg.appbrand.ZoomImagePreviewer", "url is empty or component is null");
      AppMethodBeat.o(222449);
      return;
    }
    this.kOE.clear();
    this.kOE.addAll(paramArrayList);
    this.kOD.notifyDataSetChanged();
    AppMethodBeat.o(222449);
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
    AppMethodBeat.i(222450);
    ae.i("MicroMsg.appbrand.ZoomImagePreviewer", "updateDataView");
    if (this.kOF == null)
    {
      ae.i("MicroMsg.appbrand.ZoomImagePreviewer", "updateDataView url is empty or component is null");
      AppMethodBeat.o(222450);
      return;
    }
    if ((this.kOE.isEmpty()) && (!paramArrayList.isEmpty()))
    {
      this.kOE.addAll(paramArrayList);
      this.kOD.notifyDataSetChanged();
      AppMethodBeat.o(222450);
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
        if (!this.kOE.contains(localObject2))
        {
          ((ArrayList)localObject1).add(localObject2);
          ae.i("MicroMsg.appbrand.ZoomImagePreviewer", "new url is added, url:%s", new Object[] { localObject2 });
        }
      }
      if (!((ArrayList)localObject1).isEmpty())
      {
        ae.i("MicroMsg.appbrand.ZoomImagePreviewer", "add new Data");
        this.kOE.addAll((Collection)localObject1);
        this.kOD.notifyDataSetChanged();
      }
      ae.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data");
      paramArrayList = this.kOE.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (String)paramArrayList.next();
        localObject2 = (SoftReference)this.kOG.get(localObject1);
        if ((localObject2 != null) && (((SoftReference)localObject2).get() != null))
        {
          localObject1 = (MultiTouchImageView)((SoftReference)localObject2).get();
          ae.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data width:%d, height:%d, scale:%f", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height), Float.valueOf(this.scale) });
          ((MultiTouchImageView)localObject1).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(222440);
              if (ZoomImagePreviewer.a(ZoomImagePreviewer.this) != this.iXL.getOriginScale())
              {
                this.iXL.setOriginScale(ZoomImagePreviewer.a(ZoomImagePreviewer.this));
                this.iXL.bQ(ZoomImagePreviewer.a(ZoomImagePreviewer.this));
                this.iXL.fCB();
              }
              AppMethodBeat.o(222440);
            }
          }, 100L);
        }
        else
        {
          ae.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data url with view is recycle or not exist, url:%s", new Object[] { localObject1 });
        }
      }
    }
    AppMethodBeat.o(222450);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(222443);
      int i = ZoomImagePreviewer.d(ZoomImagePreviewer.this).size();
      AppMethodBeat.o(222443);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(222444);
      Object localObject = ZoomImagePreviewer.d(ZoomImagePreviewer.this).get(paramInt);
      AppMethodBeat.o(222444);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(222445);
      label95:
      z localz;
      float f;
      ZoomImagePreviewer localZoomImagePreviewer;
      if (paramView == null)
      {
        paramView = new MultiTouchImageView(ZoomImagePreviewer.this.getContext(), 0, 0, (byte)0);
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        paramViewGroup = new a();
        paramViewGroup.kOL = paramView;
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
        ae.i("MicroMsg.appbrand.ZoomImagePreviewer", "getView url:%s", new Object[] { paramViewGroup });
        localz = ZoomImagePreviewer.c(ZoomImagePreviewer.this);
        f = ZoomImagePreviewer.a(ZoomImagePreviewer.this);
        localZoomImagePreviewer = ZoomImagePreviewer.this;
        if ((paramView != null) && (paramViewGroup != null)) {
          break label245;
        }
        if (localZoomImagePreviewer != null) {
          localZoomImagePreviewer.db(paramViewGroup, "invalid imageView or url");
        }
      }
      for (;;)
      {
        paramView.setTag(paramView);
        ZoomImagePreviewer.g(ZoomImagePreviewer.this).put(paramViewGroup, new SoftReference(paramView));
        AppMethodBeat.o(222445);
        return paramView;
        paramView = ((a)paramView.getTag()).kOL;
        ae.i("MicroMsg.appbrand.ZoomImagePreviewer", "getView from holder");
        break;
        label224:
        r.z(paramView, ZoomImagePreviewer.e(ZoomImagePreviewer.this), ZoomImagePreviewer.f(ZoomImagePreviewer.this));
        break label95;
        label245:
        if (!TextUtils.isEmpty(paramViewGroup))
        {
          String str = ((b)localz.K(b.class)).b(localz, paramViewGroup);
          ((a)localz.K(a.class)).a(str, new a.1(localZoomImagePreviewer, paramViewGroup, str, paramView, f));
        }
      }
    }
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(222442);
      ZoomImagePreviewer.c(ZoomImagePreviewer.this).runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222441);
          ZoomImagePreviewer.b(ZoomImagePreviewer.this).clear();
          AppMethodBeat.o(222441);
        }
      });
      super.notifyDataSetChanged();
      AppMethodBeat.o(222442);
    }
    
    public final class a
    {
      public MultiTouchImageView kOL;
      
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.ZoomImagePreviewer
 * JD-Core Version:    0.7.0.1
 */