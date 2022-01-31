package com.tencent.mm.plugin.appbrand.share.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.i.a;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class a
  implements i
{
  private final Map<String, SoftReference<b.e>> haO = new ConcurrentHashMap();
  private final Map<String, SoftReference<b.f>> haP = new ConcurrentHashMap();
  private final Map<Integer, a.a> haQ = new ConcurrentHashMap();
  private final Map<Integer, Bundle> haR = new ConcurrentHashMap();
  
  public a()
  {
    a(1, new a.1(this));
  }
  
  private void a(int paramInt, a.a parama)
  {
    this.haQ.put(Integer.valueOf(paramInt), parama);
    if (this.haR.containsKey(Integer.valueOf(paramInt))) {
      parama.y((Bundle)this.haR.get(Integer.valueOf(paramInt)));
    }
  }
  
  private static void a(i.a parama, int paramInt)
  {
    if (parama != null) {
      parama.ic(paramInt);
    }
  }
  
  public final b.f Jp()
  {
    String str = String.format("%d-%d-dp", new Object[] { Integer.valueOf(112), Integer.valueOf(90) });
    Object localObject = (SoftReference)this.haP.get(str);
    if (localObject != null)
    {
      localObject = (b.f)((SoftReference)localObject).get();
      if (localObject != null) {}
    }
    else
    {
      try
      {
        localObject = (SoftReference)this.haP.get(str);
        if (localObject != null)
        {
          b.f localf2 = (b.f)((SoftReference)localObject).get();
          localObject = localf2;
          if (localf2 != null) {}
        }
        else
        {
          localObject = new com.tencent.mm.plugin.appbrand.share.b(com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 112), com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 90));
          this.haP.put(str, new SoftReference(localObject));
        }
        return localObject;
      }
      finally {}
    }
    return localf1;
  }
  
  public final boolean a(String paramString, View paramView, Bundle paramBundle)
  {
    return a(paramString, paramView, paramBundle, null);
  }
  
  public final boolean a(String paramString, View paramView, Bundle paramBundle, i.a parama)
  {
    IPCDynamicPageView localIPCDynamicPageView = null;
    Assert.assertNotNull(paramView);
    Assert.assertNotNull(paramBundle);
    if (!(paramView instanceof WxaShareMessagePage)) {
      return false;
    }
    y.i("MicroMsg.WxaShareMessageService", "onBindView(%s, %s)", new Object[] { paramString, Integer.valueOf(paramView.hashCode()) });
    paramView = (WxaShareMessagePage)paramView;
    boolean bool = paramBundle.getBoolean("is_dynamic_page");
    paramView.setTitle(paramBundle.getString("title", ""));
    if (bool)
    {
      paramView.getCoverImageView().setVisibility(4);
      localIPCDynamicPageView = paramView.getWidgetPageView();
      localIPCDynamicPageView.setVisibility(0);
      paramBundle.putInt("view_init_width", paramView.getWidgetWidth());
      paramBundle.putInt("view_init_height", paramView.getWidgetHeight());
      ((e)g.r(e.class)).a(paramString, localIPCDynamicPageView, paramBundle, new aa(new a.2(this, paramView)));
      a(parama, 0);
    }
    for (;;)
    {
      return true;
      paramView.getWidgetPageView().setVisibility(4);
      paramView.getCoverImageView().setVisibility(0);
      paramString = paramBundle.getByteArray("image_data");
      if ((paramString != null) && (paramString.length > 0))
      {
        paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
        if ((paramString != null) && (!paramString.isRecycled()))
        {
          paramView.setImageData(paramString);
          a(parama, 0);
          return true;
        }
      }
      String str = paramBundle.getString("delay_load_img_path");
      if (!bk.bl(str))
      {
        if (str.startsWith("delayLoadFile://"))
        {
          paramString = localIPCDynamicPageView;
          if (this.haR.containsKey(Integer.valueOf(2)))
          {
            paramString = c.YW(str.replace("delayLoadFile://", ""));
            y.i("MicroMsg.WxaShareMessageService", "getBitmapNative(%s)", new Object[] { str });
          }
          if (paramString == null) {
            break label365;
          }
          if (paramString.isRecycled()) {
            break label350;
          }
          paramView.setImageData(paramString);
          a(parama, 0);
        }
        for (;;)
        {
          return true;
          paramString = com.tencent.mm.modelappbrand.a.b.JD().a(str, null);
          y.i("MicroMsg.WxaShareMessageService", "findCachedLocal(%s)", new Object[] { str });
          break;
          label350:
          paramView.setOnLoadImageResult(parama);
          paramView.setImageUrl(str);
        }
        label365:
        y.i("MicroMsg.WxaShareMessageService", "delay loadImage(%s)", new Object[] { str });
        paramView.getLoadingView().setVisibility(0);
        paramView.getErrorImageView().setVisibility(4);
        paramView.getCoverImageView().setVisibility(4);
        paramView.getLoadingView().cKb();
        a(2, new a.3(this, paramView, parama));
      }
      else
      {
        paramString = paramBundle.getString("image_url");
        if ((paramString != null) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
        {
          paramView.setOnLoadImageResult(parama);
          paramView.setImageUrl(paramString);
        }
        else
        {
          if ((paramString != null) && (paramString.startsWith("file://")))
          {
            paramString = com.tencent.mm.modelappbrand.a.b.JD().a(paramString, null);
            if ((paramString != null) && (!paramString.isRecycled()))
            {
              paramView.setImageData(paramString);
              a(parama, 0);
              return true;
            }
          }
          paramView.JH();
          a(parama, 1);
        }
      }
    }
  }
  
  public final void b(String paramString, View paramView)
  {
    Assert.assertNotNull(paramView);
    if (!(paramView instanceof WxaShareMessagePage)) {
      return;
    }
    y.i("MicroMsg.WxaShareMessageService", "onUnbindView(%s, %s)", new Object[] { paramString, Integer.valueOf(paramView.hashCode()) });
    paramView = (WxaShareMessagePage)paramView;
    ((e)g.r(e.class)).b(paramString, paramView.getWidgetPageView());
    this.haQ.remove(Integer.valueOf(2));
  }
  
  public final b.e bk(int paramInt1, int paramInt2)
  {
    String str = String.format("%d-%d-dp", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = (SoftReference)this.haO.get(str);
    if (localObject != null)
    {
      localObject = (b.e)((SoftReference)localObject).get();
      if (localObject != null) {}
    }
    else
    {
      try
      {
        localObject = (SoftReference)this.haO.get(str);
        if (localObject != null)
        {
          b.e locale2 = (b.e)((SoftReference)localObject).get();
          localObject = locale2;
          if (locale2 != null) {}
        }
        else
        {
          localObject = new com.tencent.mm.plugin.appbrand.share.a(com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), paramInt1), com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), paramInt2));
          this.haO.put(str, new SoftReference(localObject));
        }
        return localObject;
      }
      finally {}
    }
    return locale1;
  }
  
  public final View bt(Context paramContext)
  {
    Assert.assertNotNull(paramContext);
    return new WxaShareMessagePage(paramContext);
  }
  
  public final void c(int paramInt, Bundle paramBundle)
  {
    try
    {
      a.a locala = (a.a)this.haQ.get(Integer.valueOf(paramInt));
      if (locala != null) {
        locala.y(paramBundle);
      }
      this.haR.put(Integer.valueOf(paramInt), paramBundle);
      y.i("MicroMsg.WxaShareMessageService", "onAction(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramBundle });
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.a.a
 * JD-Core Version:    0.7.0.1
 */