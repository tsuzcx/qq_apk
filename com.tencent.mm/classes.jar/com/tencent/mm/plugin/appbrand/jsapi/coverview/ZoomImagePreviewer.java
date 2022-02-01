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
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ZoomImagePreviewer
  extends MMGestureGallery
{
  private int height;
  private a jPC;
  private ArrayList<String> jPD;
  private e jPE;
  private HashMap<String, SoftReference<MultiTouchImageView>> jPF;
  private float scale;
  private int width;
  
  public ZoomImagePreviewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(195836);
    this.jPD = new ArrayList();
    this.width = 0;
    this.height = 0;
    this.scale = 1.0F;
    this.jPF = new HashMap();
    init();
    AppMethodBeat.o(195836);
  }
  
  public ZoomImagePreviewer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195835);
    this.jPD = new ArrayList();
    this.width = 0;
    this.height = 0;
    this.scale = 1.0F;
    this.jPF = new HashMap();
    init();
    AppMethodBeat.o(195835);
  }
  
  private void init()
  {
    AppMethodBeat.i(195837);
    this.jPC = new a((byte)0);
    setVerticalFadingEdgeEnabled(false);
    setHorizontalFadingEdgeEnabled(false);
    setAdapter(this.jPC);
    setSelection(0);
    AppMethodBeat.o(195837);
  }
  
  public final void dN(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void setComponent(e parame)
  {
    this.jPE = parame;
  }
  
  public void setData(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(195838);
    ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "setData");
    if ((this.jPE == null) || (paramArrayList == null))
    {
      ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "url is empty or component is null");
      AppMethodBeat.o(195838);
      return;
    }
    this.jPD.clear();
    this.jPD.addAll(paramArrayList);
    this.jPC.notifyDataSetChanged();
    AppMethodBeat.o(195838);
  }
  
  public void setScale(float paramFloat)
  {
    this.scale = paramFloat;
  }
  
  public final void t(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(195839);
    ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "updateDataView");
    if (this.jPE == null)
    {
      ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "updateDataView url is empty or component is null");
      AppMethodBeat.o(195839);
      return;
    }
    if ((this.jPD.isEmpty()) && (!paramArrayList.isEmpty()))
    {
      this.jPD.addAll(paramArrayList);
      this.jPC.notifyDataSetChanged();
      AppMethodBeat.o(195839);
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
        if (!this.jPD.contains(localObject2))
        {
          ((ArrayList)localObject1).add(localObject2);
          ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "new url is added, url:%s", new Object[] { localObject2 });
        }
      }
      if (!((ArrayList)localObject1).isEmpty())
      {
        ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "add new Data");
        this.jPD.addAll((Collection)localObject1);
        this.jPC.notifyDataSetChanged();
      }
      ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data");
      paramArrayList = this.jPD.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (String)paramArrayList.next();
        localObject2 = (SoftReference)this.jPF.get(localObject1);
        if ((localObject2 != null) && (((SoftReference)localObject2).get() != null))
        {
          localObject1 = (MultiTouchImageView)((SoftReference)localObject2).get();
          ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data width:%d, height:%d, scale:%f", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height), Float.valueOf(this.scale) });
          ((MultiTouchImageView)localObject1).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(195831);
              if (ZoomImagePreviewer.a(ZoomImagePreviewer.this) != this.ibB.getOriginScale())
              {
                this.ibB.setOriginScale(ZoomImagePreviewer.a(ZoomImagePreviewer.this));
                this.ibB.bF(ZoomImagePreviewer.a(ZoomImagePreviewer.this));
                this.ibB.eSA();
              }
              AppMethodBeat.o(195831);
            }
          }, 100L);
        }
        else
        {
          ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "update Data url with view is recycle or not exist, url:%s", new Object[] { localObject1 });
        }
      }
    }
    AppMethodBeat.o(195839);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(195832);
      int i = ZoomImagePreviewer.b(ZoomImagePreviewer.this).size();
      AppMethodBeat.o(195832);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(195833);
      Object localObject = ZoomImagePreviewer.b(ZoomImagePreviewer.this).get(paramInt);
      AppMethodBeat.o(195833);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(195834);
      label95:
      e locale;
      float f;
      if (paramView == null)
      {
        paramView = new MultiTouchImageView(ZoomImagePreviewer.this.getContext(), 0, 0, (byte)0);
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        paramViewGroup = new a();
        paramViewGroup.jPH = paramView;
        paramView.setTag(paramViewGroup);
        paramView.setMinZoomLimit(0.5F);
        paramView.setMaxZoomDoubleTab(true);
        paramView.setOriginScale(ZoomImagePreviewer.a(ZoomImagePreviewer.this));
        if (Build.VERSION.SDK_INT != 20) {
          break label203;
        }
        paramView.setLayerType(1, null);
        paramView.setEnableHorLongBmpMode(false);
        paramViewGroup = (String)getItem(paramInt);
        ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "getView url:%s", new Object[] { paramViewGroup });
        locale = ZoomImagePreviewer.e(ZoomImagePreviewer.this);
        f = ZoomImagePreviewer.a(ZoomImagePreviewer.this);
        if ((paramView != null) && (paramViewGroup != null)) {
          break label224;
        }
      }
      for (;;)
      {
        paramView.setTag(paramView);
        ZoomImagePreviewer.f(ZoomImagePreviewer.this).put(paramViewGroup, new SoftReference(paramView));
        AppMethodBeat.o(195834);
        return paramView;
        paramView = ((a)paramView.getTag()).jPH;
        ad.i("MicroMsg.appbrand.ZoomImagePreviewer", "getView from holder");
        break;
        label203:
        p.z(paramView, ZoomImagePreviewer.c(ZoomImagePreviewer.this), ZoomImagePreviewer.d(ZoomImagePreviewer.this));
        break label95;
        label224:
        if (!TextUtils.isEmpty(paramViewGroup))
        {
          String str = ((b)locale.K(b.class)).b(locale, paramViewGroup);
          ((a)locale.K(a.class)).a(str, new a.1(str, paramView, f));
        }
      }
    }
    
    public final class a
    {
      public MultiTouchImageView jPH;
      
      public a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.ZoomImagePreviewer
 * JD-Core Version:    0.7.0.1
 */