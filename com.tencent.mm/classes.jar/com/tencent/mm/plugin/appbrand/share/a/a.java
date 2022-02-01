package com.tencent.mm.plugin.appbrand.share.a;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.b;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage.3;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class a
  implements k
{
  private final Map<String, SoftReference<b.f>> mBv;
  private final Map<String, SoftReference<b.h>> mBw;
  private final Map<Integer, a> mBx;
  private final Map<Integer, Bundle> mBy;
  
  public a()
  {
    AppMethodBeat.i(48325);
    this.mBv = new ConcurrentHashMap();
    this.mBw = new ConcurrentHashMap();
    this.mBx = new ConcurrentHashMap();
    this.mBy = new ConcurrentHashMap();
    a(1, new a()
    {
      public final void M(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(48320);
        a.a(a.this).remove(Integer.valueOf(2));
        AppMethodBeat.o(48320);
      }
    });
    AppMethodBeat.o(48325);
  }
  
  private void a(int paramInt, a parama)
  {
    AppMethodBeat.i(48335);
    this.mBx.put(Integer.valueOf(paramInt), parama);
    if (this.mBy.containsKey(Integer.valueOf(paramInt))) {
      parama.M((Bundle)this.mBy.get(Integer.valueOf(paramInt)));
    }
    AppMethodBeat.o(48335);
  }
  
  private static void a(k.b paramb, int paramInt)
  {
    AppMethodBeat.i(48329);
    if (paramb != null) {
      paramb.oP(paramInt);
    }
    AppMethodBeat.o(48329);
  }
  
  public final View a(Context paramContext, Bundle paramBundle, boolean paramBoolean, k.c paramc)
  {
    AppMethodBeat.i(180363);
    Assert.assertNotNull(paramContext);
    WxaShareMessagePage localWxaShareMessagePage = new WxaShareMessagePage(paramContext);
    int i;
    boolean bool;
    Object localObject;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("key_biz", com.tencent.mm.ah.k.a.hCx.ordinal());
      bool = paramBundle.getBoolean("is_video", false);
      if ((com.tencent.mm.ah.k.a.isValid(i)) || (bool))
      {
        localWxaShareMessagePage.mBO = true;
        localObject = localWxaShareMessagePage.lpo.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cb.a.fromDPToPix(localWxaShareMessagePage.getContext(), 112);
        ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.cb.a.fromDPToPix(localWxaShareMessagePage.getContext(), 63);
        localWxaShareMessagePage.lpo.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localWxaShareMessagePage.lpo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        localObject = localWxaShareMessagePage.mBD.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cb.a.fromDPToPix(localWxaShareMessagePage.getContext(), 112);
        ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.cb.a.fromDPToPix(localWxaShareMessagePage.getContext(), 63);
        localWxaShareMessagePage.mBD.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = localWxaShareMessagePage.mBN.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cb.a.fromDPToPix(localWxaShareMessagePage.getContext(), 112);
        ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.cb.a.fromDPToPix(localWxaShareMessagePage.getContext(), 63);
        localWxaShareMessagePage.mBN.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (com.tencent.mm.ah.k.a.hCv.ordinal() != i) {
          break label336;
        }
        localWxaShareMessagePage.mBJ.setImageResource(2131690913);
        localWxaShareMessagePage.mBD.setImageResource(2131689684);
        localObject = paramBundle.getString("key_footer_text", "");
        paramBundle = paramBundle.getString("key_footer_text_default", "");
        if (((String)localObject).isEmpty()) {
          break label393;
        }
        localWxaShareMessagePage.mBK.setText((CharSequence)localObject);
      }
    }
    label294:
    if (paramBoolean) {
      localWxaShareMessagePage.mBG.setVisibility(0);
    }
    for (;;)
    {
      localWxaShareMessagePage.mBM = paramc;
      ((LifecycleOwner)paramContext).getLifecycle().addObserver(localWxaShareMessagePage);
      AppMethodBeat.o(180363);
      return localWxaShareMessagePage;
      label336:
      if ((com.tencent.mm.ah.k.a.hCw.ordinal() != i) && (!bool)) {
        break;
      }
      localObject = paramBundle.getString("key_footer_icon", "");
      if (bu.isNullOrNil((String)localObject)) {
        break;
      }
      q.aJa().a((String)localObject, new WxaShareMessagePage.3(localWxaShareMessagePage, bool));
      break;
      label393:
      if (paramBundle.isEmpty()) {
        break label294;
      }
      localWxaShareMessagePage.mBK.setText(paramBundle);
      break label294;
      localWxaShareMessagePage.mBG.setVisibility(8);
    }
  }
  
  public final b.f a(int paramInt1, int paramInt2, com.tencent.mm.modelappbrand.k.a parama)
  {
    AppMethodBeat.i(48333);
    String str = String.format("%d-%d-dp", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = (SoftReference)this.mBv.get(str);
    b.f localf;
    if (localObject != null)
    {
      localf = (b.f)((SoftReference)localObject).get();
      localObject = localf;
      if (localf != null) {
        break label169;
      }
    }
    try
    {
      localObject = (SoftReference)this.mBv.get(str);
      if (localObject != null)
      {
        localf = (b.f)((SoftReference)localObject).get();
        localObject = localf;
        if (localf != null) {}
      }
      else
      {
        localObject = new com.tencent.mm.plugin.appbrand.share.a(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), paramInt1), com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), paramInt2));
        ((com.tencent.mm.plugin.appbrand.share.a)localObject).mBt = parama;
        this.mBv.put(str, new SoftReference(localObject));
      }
      label169:
      return localObject;
    }
    finally
    {
      AppMethodBeat.o(48333);
    }
  }
  
  public final void a(String paramString, View paramView)
  {
    AppMethodBeat.i(48330);
    Assert.assertNotNull(paramView);
    if (!(paramView instanceof WxaShareMessagePage))
    {
      AppMethodBeat.o(48330);
      return;
    }
    ae.i("MicroMsg.WxaShareMessageService", "onUnbindView(%s, %s)", new Object[] { paramString, Integer.valueOf(paramView.hashCode()) });
    paramView = (WxaShareMessagePage)paramView;
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).a(paramString, paramView.getWidgetPageView());
    this.mBx.remove(Integer.valueOf(2));
    AppMethodBeat.o(48330);
  }
  
  public final boolean a(String paramString, View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(48327);
    boolean bool = a(paramString, paramView, paramBundle, null);
    AppMethodBeat.o(48327);
    return bool;
  }
  
  public final boolean a(String paramString, final View paramView, Bundle paramBundle, final k.b paramb)
  {
    IPCDynamicPageView localIPCDynamicPageView = null;
    AppMethodBeat.i(48328);
    Assert.assertNotNull(paramView);
    Assert.assertNotNull(paramBundle);
    if (!(paramView instanceof WxaShareMessagePage))
    {
      AppMethodBeat.o(48328);
      return false;
    }
    ae.i("MicroMsg.WxaShareMessageService", "onBindView(%s, %s)", new Object[] { paramString, Integer.valueOf(paramView.hashCode()) });
    paramView = (WxaShareMessagePage)paramView;
    boolean bool1 = paramBundle.getBoolean("is_dynamic_page");
    paramView.setTitle(paramBundle.getString("title", ""));
    boolean bool2 = paramBundle.getBoolean("is_video", false);
    int i = paramBundle.getInt("sub_type", 0);
    if ((bool2) || (i == 1))
    {
      paramView.getVideoIcon().setVisibility(0);
      if (!bool1) {
        break label232;
      }
      paramView.getCoverImageView().setVisibility(4);
      localIPCDynamicPageView = paramView.getWidgetPageView();
      localIPCDynamicPageView.setVisibility(0);
      paramBundle.putInt("view_init_width", paramView.getWidgetWidth());
      paramBundle.putInt("view_init_height", paramView.getWidgetHeight());
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).a(paramString, localIPCDynamicPageView, paramBundle, new ac(new com.tencent.mm.modelappbrand.h()
      {
        public final void N(View paramAnonymousView, int paramAnonymousInt)
        {
          AppMethodBeat.i(48321);
          switch (paramAnonymousInt)
          {
          case 2: 
          case 3: 
          default: 
            paramView.getLoadingView().fQe();
            paramView.getLoadingView().setVisibility(4);
            paramView.getErrorImageView().setVisibility(0);
            paramView.getWidgetPageView().setVisibility(4);
            paramView.getErrorImageView().setImageResource(2131689648);
            AppMethodBeat.o(48321);
            return;
          case 0: 
            paramView.getLoadingView().setVisibility(0);
            paramView.getErrorImageView().setVisibility(4);
            paramView.getWidgetPageView().setVisibility(4);
            paramView.getLoadingView().fQd();
            AppMethodBeat.o(48321);
            return;
          case 1: 
            paramView.getLoadingView().fQe();
            paramView.getLoadingView().setVisibility(4);
            paramView.getErrorImageView().setVisibility(0);
            paramView.getWidgetPageView().setVisibility(4);
            paramView.getErrorImageView().setImageResource(2131690080);
            AppMethodBeat.o(48321);
            return;
          }
          paramView.getLoadingView().setVisibility(4);
          paramView.getErrorImageView().setVisibility(4);
          paramView.getWidgetPageView().setVisibility(0);
          AppMethodBeat.o(48321);
        }
      }));
      a(paramb, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(48328);
      return true;
      paramView.getVideoIcon().setVisibility(8);
      break;
      label232:
      paramView.getWidgetPageView().setVisibility(4);
      paramView.getCoverImageView().setVisibility(0);
      paramString = paramBundle.getByteArray("image_data");
      if ((paramString != null) && (paramString.length > 0))
      {
        paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
        if ((paramString != null) && (!paramString.isRecycled()))
        {
          paramView.setImageData(paramString);
          a(paramb, 0);
          AppMethodBeat.o(48328);
          return true;
        }
      }
      String str = paramBundle.getString("delay_load_img_path");
      if (bool2)
      {
        paramString = paramBundle.getString("video_path");
        paramBundle = paramBundle.getString("video_thumb_path");
        if (!bu.isNullOrNil(paramBundle))
        {
          paramBundle = com.tencent.mm.modelappbrand.a.b.aEl().a(paramBundle, null);
          if ((paramBundle != null) && (!paramBundle.isRecycled()))
          {
            paramView.setImageData(paramBundle);
            a(paramb, 0);
            AppMethodBeat.o(48328);
            return true;
          }
          paramView.ox();
          a(paramb, 1);
        }
        if (!bu.isNullOrNil(paramString)) {
          paramView.getCoverImageView().setOnClickListener(new a.3(this));
        }
      }
      else if (!bu.isNullOrNil(str))
      {
        if (str.startsWith("delayLoadFile://"))
        {
          paramString = localIPCDynamicPageView;
          if (this.mBy.containsKey(Integer.valueOf(2)))
          {
            paramString = com.tencent.mm.sdk.platformtools.h.aRC(str.replace("delayLoadFile://", ""));
            ae.i("MicroMsg.WxaShareMessageService", "getBitmapNative(%s)", new Object[] { str });
          }
          if (paramString == null) {
            break label560;
          }
          if (paramString.isRecycled()) {
            break label545;
          }
          paramView.setImageData(paramString);
          a(paramb, 0);
        }
        for (;;)
        {
          AppMethodBeat.o(48328);
          return true;
          paramString = com.tencent.mm.modelappbrand.a.b.aEl().a(str, null);
          ae.i("MicroMsg.WxaShareMessageService", "findCachedLocal(%s)", new Object[] { str });
          break;
          label545:
          paramView.setOnLoadImageResult(paramb);
          paramView.setImageUrl(str);
        }
        label560:
        ae.i("MicroMsg.WxaShareMessageService", "delay loadImage(%s)", new Object[] { str });
        paramView.getLoadingView().setVisibility(0);
        paramView.getErrorImageView().setVisibility(4);
        paramView.getCoverImageView().setVisibility(4);
        paramView.getLoadingView().fQd();
        a(2, new a()
        {
          public final void M(final Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(48324);
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(48323);
                String str = paramAnonymousBundle.getString("delay_load_img_path");
                a.4.this.mBA.setImageUrl(str);
                ae.i("MicroMsg.WxaShareMessageService", "onLoadImageFinishedAction(%s)", new Object[] { str });
                a.a(a.4.this.mBB);
                AppMethodBeat.o(48323);
              }
            });
            AppMethodBeat.o(48324);
          }
        });
      }
      else
      {
        paramString = paramBundle.getString("image_url");
        if ((paramString != null) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
        {
          paramView.setOnLoadImageResult(paramb);
          paramView.setImageUrl(paramString);
        }
        else
        {
          if ((paramString != null) && (paramString.startsWith("file://")))
          {
            paramString = com.tencent.mm.modelappbrand.a.b.aEl().a(paramString, null);
            if ((paramString != null) && (!paramString.isRecycled()))
            {
              paramView.setImageData(paramString);
              a(paramb, 0);
              AppMethodBeat.o(48328);
              return true;
            }
          }
          paramView.ox();
          a(paramb, 1);
        }
      }
    }
  }
  
  public final b.h aDX()
  {
    AppMethodBeat.i(48334);
    String str = String.format("%d-%d-dp", new Object[] { Integer.valueOf(112), Integer.valueOf(90) });
    Object localObject1 = (SoftReference)this.mBw.get(str);
    b.h localh;
    if (localObject1 != null)
    {
      localh = (b.h)((SoftReference)localObject1).get();
      localObject1 = localh;
      if (localh != null) {
        break label144;
      }
    }
    try
    {
      localObject1 = (SoftReference)this.mBw.get(str);
      if (localObject1 != null)
      {
        localh = (b.h)((SoftReference)localObject1).get();
        localObject1 = localh;
        if (localh != null) {}
      }
      else
      {
        localObject1 = new com.tencent.mm.plugin.appbrand.share.b(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 112), com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 90));
        this.mBw.put(str, new SoftReference(localObject1));
      }
      label144:
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(48334);
    }
  }
  
  public final b.f de(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(48332);
    b.f localf = a(paramInt1, paramInt2, com.tencent.mm.modelappbrand.k.a.hNk);
    AppMethodBeat.o(48332);
    return localf;
  }
  
  public final void h(int paramInt, Bundle paramBundle)
  {
    try
    {
      AppMethodBeat.i(48331);
      a locala = (a)this.mBx.get(Integer.valueOf(paramInt));
      if (locala != null) {
        locala.M(paramBundle);
      }
      this.mBy.put(Integer.valueOf(paramInt), paramBundle);
      ae.i("MicroMsg.WxaShareMessageService", "onAction(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramBundle });
      AppMethodBeat.o(48331);
      return;
    }
    finally {}
  }
  
  static abstract interface a
  {
    public abstract void M(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.a.a
 * JD-Core Version:    0.7.0.1
 */