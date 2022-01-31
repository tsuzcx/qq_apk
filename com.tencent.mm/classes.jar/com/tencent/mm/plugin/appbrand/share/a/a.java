package com.tencent.mm.plugin.appbrand.share.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.a;
import com.tencent.mm.at.o;
import com.tencent.mm.at.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.i.a;
import com.tencent.mm.modelappbrand.i.b;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage.1;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class a
  implements i
{
  private final Map<Integer, a.a> iJA;
  private final Map<Integer, Bundle> iJB;
  private final Map<String, SoftReference<b.e>> iJy;
  private final Map<String, SoftReference<b.f>> iJz;
  
  public a()
  {
    AppMethodBeat.i(132743);
    this.iJy = new ConcurrentHashMap();
    this.iJz = new ConcurrentHashMap();
    this.iJA = new ConcurrentHashMap();
    this.iJB = new ConcurrentHashMap();
    a(1, new a.1(this));
    AppMethodBeat.o(132743);
  }
  
  private void a(int paramInt, a.a parama)
  {
    AppMethodBeat.i(132753);
    this.iJA.put(Integer.valueOf(paramInt), parama);
    if (this.iJB.containsKey(Integer.valueOf(paramInt))) {
      parama.F((Bundle)this.iJB.get(Integer.valueOf(paramInt)));
    }
    AppMethodBeat.o(132753);
  }
  
  private static void a(i.b paramb, int paramInt)
  {
    AppMethodBeat.i(132747);
    if (paramb != null) {
      paramb.kP(paramInt);
    }
    AppMethodBeat.o(132747);
  }
  
  public final b.e a(int paramInt1, int paramInt2, i.a parama)
  {
    AppMethodBeat.i(132751);
    String str = String.format("%d-%d-dp", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = (SoftReference)this.iJy.get(str);
    b.e locale;
    if (localObject != null)
    {
      locale = (b.e)((SoftReference)localObject).get();
      localObject = locale;
      if (locale != null) {
        break label167;
      }
    }
    try
    {
      localObject = (SoftReference)this.iJy.get(str);
      if (localObject != null)
      {
        locale = (b.e)((SoftReference)localObject).get();
        localObject = locale;
        if (locale != null) {}
      }
      else
      {
        localObject = new com.tencent.mm.plugin.appbrand.share.a(com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), paramInt1), com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), paramInt2));
        ((com.tencent.mm.plugin.appbrand.share.a)localObject).iJw = parama;
        this.iJy.put(str, new SoftReference(localObject));
      }
      label167:
      return localObject;
    }
    finally
    {
      AppMethodBeat.o(132751);
    }
  }
  
  public final void a(String paramString, View paramView)
  {
    AppMethodBeat.i(132748);
    Assert.assertNotNull(paramView);
    if (!(paramView instanceof WxaShareMessagePage))
    {
      AppMethodBeat.o(132748);
      return;
    }
    ab.i("MicroMsg.WxaShareMessageService", "onUnbindView(%s, %s)", new Object[] { paramString, Integer.valueOf(paramView.hashCode()) });
    paramView = (WxaShareMessagePage)paramView;
    ((e)g.E(e.class)).a(paramString, paramView.getWidgetPageView());
    this.iJA.remove(Integer.valueOf(2));
    AppMethodBeat.o(132748);
  }
  
  public final boolean a(String paramString, View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(132745);
    boolean bool = a(paramString, paramView, paramBundle, null);
    AppMethodBeat.o(132745);
    return bool;
  }
  
  public final boolean a(String paramString, View paramView, Bundle paramBundle, i.b paramb)
  {
    IPCDynamicPageView localIPCDynamicPageView = null;
    AppMethodBeat.i(132746);
    Assert.assertNotNull(paramView);
    Assert.assertNotNull(paramBundle);
    if (!(paramView instanceof WxaShareMessagePage))
    {
      AppMethodBeat.o(132746);
      return false;
    }
    ab.i("MicroMsg.WxaShareMessageService", "onBindView(%s, %s)", new Object[] { paramString, Integer.valueOf(paramView.hashCode()) });
    paramView = (WxaShareMessagePage)paramView;
    boolean bool1 = paramBundle.getBoolean("is_dynamic_page");
    paramView.setTitle(paramBundle.getString("title", ""));
    boolean bool2 = paramBundle.getBoolean("is_video", false);
    if (bool2)
    {
      paramView.getVideoIcon().setVisibility(0);
      if (!bool1) {
        break label206;
      }
      paramView.getCoverImageView().setVisibility(4);
      localIPCDynamicPageView = paramView.getWidgetPageView();
      localIPCDynamicPageView.setVisibility(0);
      paramBundle.putInt("view_init_width", paramView.getWidgetWidth());
      paramBundle.putInt("view_init_height", paramView.getWidgetHeight());
      ((e)g.E(e.class)).a(paramString, localIPCDynamicPageView, paramBundle, new ac(new a.2(this, paramView)));
      a(paramb, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(132746);
      return true;
      paramView.getVideoIcon().setVisibility(8);
      break;
      label206:
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
          AppMethodBeat.o(132746);
          return true;
        }
      }
      String str = paramBundle.getString("delay_load_img_path");
      if (bool2)
      {
        paramString = paramBundle.getString("video_path");
        paramBundle = paramBundle.getString("video_thumb_path");
        if (!bo.isNullOrNil(paramBundle))
        {
          paramBundle = com.tencent.mm.modelappbrand.a.b.acD().a(paramBundle, null);
          if ((paramBundle != null) && (!paramBundle.isRecycled()))
          {
            paramView.setImageData(paramBundle);
            a(paramb, 0);
            AppMethodBeat.o(132746);
            return true;
          }
          paramView.acH();
          a(paramb, 1);
        }
        if (!bo.isNullOrNil(paramString)) {
          paramView.getCoverImageView().setOnClickListener(new a.3(this));
        }
      }
      else if (!bo.isNullOrNil(str))
      {
        if (str.startsWith("delayLoadFile://"))
        {
          paramString = localIPCDynamicPageView;
          if (this.iJB.containsKey(Integer.valueOf(2)))
          {
            paramString = d.aoV(str.replace("delayLoadFile://", ""));
            ab.i("MicroMsg.WxaShareMessageService", "getBitmapNative(%s)", new Object[] { str });
          }
          if (paramString == null) {
            break label528;
          }
          if (paramString.isRecycled()) {
            break label513;
          }
          paramView.setImageData(paramString);
          a(paramb, 0);
        }
        for (;;)
        {
          AppMethodBeat.o(132746);
          return true;
          paramString = com.tencent.mm.modelappbrand.a.b.acD().a(str, null);
          ab.i("MicroMsg.WxaShareMessageService", "findCachedLocal(%s)", new Object[] { str });
          break;
          label513:
          paramView.setOnLoadImageResult(paramb);
          paramView.setImageUrl(str);
        }
        label528:
        ab.i("MicroMsg.WxaShareMessageService", "delay loadImage(%s)", new Object[] { str });
        paramView.getLoadingView().setVisibility(0);
        paramView.getErrorImageView().setVisibility(4);
        paramView.getCoverImageView().setVisibility(4);
        paramView.getLoadingView().dOV();
        a(2, new a.4(this, paramView, paramb));
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
            paramString = com.tencent.mm.modelappbrand.a.b.acD().a(paramString, null);
            if ((paramString != null) && (!paramString.isRecycled()))
            {
              paramView.setImageData(paramString);
              a(paramb, 0);
              AppMethodBeat.o(132746);
              return true;
            }
          }
          paramView.acH();
          a(paramb, 1);
        }
      }
    }
  }
  
  public final b.f acn()
  {
    AppMethodBeat.i(132752);
    String str = String.format("%d-%d-dp", new Object[] { Integer.valueOf(112), Integer.valueOf(90) });
    Object localObject1 = (SoftReference)this.iJz.get(str);
    b.f localf;
    if (localObject1 != null)
    {
      localf = (b.f)((SoftReference)localObject1).get();
      localObject1 = localf;
      if (localf != null) {
        break label143;
      }
    }
    try
    {
      localObject1 = (SoftReference)this.iJz.get(str);
      if (localObject1 != null)
      {
        localf = (b.f)((SoftReference)localObject1).get();
        localObject1 = localf;
        if (localf != null) {}
      }
      else
      {
        localObject1 = new com.tencent.mm.plugin.appbrand.share.b(com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 112), com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 90));
        this.iJz.put(str, new SoftReference(localObject1));
      }
      label143:
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(132752);
    }
  }
  
  public final b.e cu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132750);
    b.e locale = a(paramInt1, paramInt2, i.a.fpS);
    AppMethodBeat.o(132750);
    return locale;
  }
  
  public final View e(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(132744);
    Assert.assertNotNull(paramContext);
    paramContext = new WxaShareMessagePage(paramContext);
    int i;
    boolean bool;
    Object localObject;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("key_biz", j.a.fgr.ordinal());
      bool = paramBundle.getBoolean("is_video", false);
      if ((j.a.isValid(i)) || (bool))
      {
        paramContext.iJN = true;
        localObject = paramContext.icw.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cb.a.fromDPToPix(paramContext.getContext(), 112);
        ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.cb.a.fromDPToPix(paramContext.getContext(), 63);
        paramContext.icw.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramContext.icw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        localObject = paramContext.iJH.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cb.a.fromDPToPix(paramContext.getContext(), 112);
        ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.cb.a.fromDPToPix(paramContext.getContext(), 63);
        paramContext.iJH.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = paramContext.jU.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cb.a.fromDPToPix(paramContext.getContext(), 112);
        ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.cb.a.fromDPToPix(paramContext.getContext(), 63);
        paramContext.jU.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (j.a.fgp.ordinal() != i) {
          break label287;
        }
        paramContext.iJK.setImageResource(2131231747);
        paramContext.iJH.setImageResource(2131230918);
        localObject = paramBundle.getString("key_footer_text", "");
        paramBundle = paramBundle.getString("key_footer_text_default", "");
        if (((String)localObject).isEmpty()) {
          break label342;
        }
        paramContext.iJL.setText((CharSequence)localObject);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(132744);
      return paramContext;
      label287:
      if ((j.a.fgq.ordinal() != i) && (!bool)) {
        break;
      }
      localObject = paramBundle.getString("key_footer_icon", "");
      if (bo.isNullOrNil((String)localObject)) {
        break;
      }
      o.ahF().a((String)localObject, new WxaShareMessagePage.1(paramContext, bool));
      break;
      label342:
      if (!paramBundle.isEmpty()) {
        paramContext.iJL.setText(paramBundle);
      }
    }
  }
  
  public final void f(int paramInt, Bundle paramBundle)
  {
    try
    {
      AppMethodBeat.i(132749);
      a.a locala = (a.a)this.iJA.get(Integer.valueOf(paramInt));
      if (locala != null) {
        locala.F(paramBundle);
      }
      this.iJB.put(Integer.valueOf(paramInt), paramBundle);
      ab.i("MicroMsg.WxaShareMessageService", "onAction(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramBundle });
      AppMethodBeat.o(132749);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.a.a
 * JD-Core Version:    0.7.0.1
 */