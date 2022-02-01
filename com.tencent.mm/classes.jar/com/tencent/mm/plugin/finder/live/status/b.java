package com.tencent.mm.plugin.finder.live.status;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.d.a.a.a.b.b;
import com.tencent.d.a.a.a.b.d;
import com.tencent.d.a.a.a.b.b.k;
import com.tencent.d.a.a.a.b.b.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.l;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.bb;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/status/LiveStatusService;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "()V", "liveEndCache", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "", "createCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpType", "createPullDownView", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "isStatusValid", "", "release", "", "updateLiveInfo", "username", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements o
{
  private final Map<String, bip> DHh;
  
  public b()
  {
    AppMethodBeat.i(351479);
    this.DHh = Collections.synchronizedMap((Map)new HashMap());
    AppMethodBeat.o(351479);
  }
  
  public final com.tencent.mm.ui.widget.b a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, l paraml)
  {
    AppMethodBeat.i(351488);
    kotlin.g.b.s.u(paramFrameLayout, "container");
    kotlin.g.b.s.u(paraml, "pullDownParam");
    if (paraml.ToO == 0)
    {
      AppMethodBeat.o(351488);
      return null;
    }
    Map localMap = this.DHh;
    kotlin.g.b.s.s(localMap, "liveEndCache");
    paramString = (com.tencent.mm.ui.widget.b)new a(paramString, paramFrameLayout, paramTextStatusJumpInfo, paraml, localMap);
    AppMethodBeat.o(351488);
    return paramString;
  }
  
  public final k axF(String paramString)
  {
    AppMethodBeat.i(351493);
    paramString = (k)new a(paramString);
    AppMethodBeat.o(351493);
    return paramString;
  }
  
  public final void release() {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/status/LiveStatusService$createCustomParts$1", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "finderLiveShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getJumpInfos", "()Ljava/util/List;", "setJumpInfos", "(Ljava/util/List;)V", "liveIconViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/widget/ImageView;", "getLiveIconViewRef", "()Ljava/lang/ref/WeakReference;", "setLiveIconViewRef", "(Ljava/lang/ref/WeakReference;)V", "liveStatus", "", "getLiveStatus", "()I", "setLiveStatus", "(I)V", "doJumpAuthor", "", "context", "Landroid/content/Context;", "doJumpSource", "extParam", "Landroid/os/Bundle;", "getAuthorName", "", "getCurLiveStatus", "", "getReportFeedId", "", "getSourceDesc", "isHasCustomPullDown", "isHideSourceInfo", "loadAvatar", "avatarView", "onAttach", "textStatusID", "", "onDetach", "setCustomAuthorView", "container", "Landroid/widget/FrameLayout;", "setCustomSourceView", "setCustomThumbView", "updateSourceView", "imgView", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends k
  {
    private bmr DHa;
    private List<? extends TextStatusJumpInfo> DHi;
    WeakReference<ImageView> DHj;
    int liveStatus = 1;
    
    a(String paramString)
    {
      super();
    }
    
    private static final void a(ImageView paramImageView, String paramString1, Bitmap paramBitmap, String paramString2)
    {
      AppMethodBeat.i(351521);
      kotlin.g.b.s.u(paramImageView, "$img");
      if (paramBitmap == null)
      {
        AppMethodBeat.o(351521);
        return;
      }
      paramString1 = new com.tencent.mm.videocomposition.effect.a();
      paramString1.setInputBitmap(paramBitmap);
      paramString1.setOutputSize(paramImageView.getWidth(), paramImageView.getHeight());
      paramString1.HkF.GpO.jQk();
      paramString1.aW((kotlin.g.a.b)new b(paramImageView));
      AppMethodBeat.o(351521);
    }
    
    private static final void b(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(351529);
      kotlin.g.b.s.u(paramImageView, "$img");
      r.bKd().a(paramString, new b.a..ExternalSyntheticLambda0(paramImageView));
      AppMethodBeat.o(351529);
    }
    
    private void etR()
    {
      AppMethodBeat.i(351507);
      Object localObject = this.DHa;
      if (localObject != null)
      {
        localObject = ((bmr)localObject).liveId;
        if (localObject != null)
        {
          com.tencent.mm.kernel.b.a locala = h.az(com.tencent.d.a.a.a.b.class);
          kotlin.g.b.s.s(locala, "plugin(IPluginFinderLive::class.java)");
          b.b.a((com.tencent.d.a.a.a.b)locala, Util.safeParseLong((String)localObject), false, (b.d)new a(this), 6);
        }
      }
      AppMethodBeat.o(351507);
    }
    
    public final boolean d(FrameLayout paramFrameLayout)
    {
      AppMethodBeat.i(351603);
      kotlin.g.b.s.u(paramFrameLayout, "container");
      Object localObject1 = this.DHa;
      Object localObject2;
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (!n.bp((CharSequence)localObject2))) {
          break label135;
        }
        i = 1;
        label43:
        if (i == 0)
        {
          localObject2 = (ImageView)paramFrameLayout.findViewWithTag("Finder.TextStatusProvider");
          if (localObject2 != null) {
            break label140;
          }
          localObject2 = new ImageView(paramFrameLayout.getContext());
          ((ImageView)localObject2).setTag("Finder.TextStatusProvider");
          paramFrameLayout.removeAllViews();
          paramFrameLayout.addView((View)localObject2);
        }
      }
      label135:
      label140:
      for (paramFrameLayout = (FrameLayout)localObject2;; paramFrameLayout = (FrameLayout)localObject2)
      {
        paramFrameLayout.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramFrameLayout.post(new b.a..ExternalSyntheticLambda1((String)localObject1, paramFrameLayout));
        AppMethodBeat.o(351603);
        return true;
        localObject1 = ((bmr)localObject1).coverUrl;
        break;
        i = 0;
        break label43;
      }
    }
    
    public final boolean e(FrameLayout paramFrameLayout)
    {
      AppMethodBeat.i(351611);
      kotlin.g.b.s.u(paramFrameLayout, "container");
      etR();
      ImageView localImageView = new ImageView(paramFrameLayout.getContext());
      k(localImageView);
      paramFrameLayout.addView((View)localImageView);
      paramFrameLayout.setVisibility(0);
      this.DHj = new WeakReference(localImageView);
      AppMethodBeat.o(351611);
      return true;
    }
    
    public final String etP()
    {
      Object localObject = this.DHa;
      if (localObject == null) {
        localObject = "";
      }
      String str;
      do
      {
        return localObject;
        str = ((bmr)localObject).feedId;
        localObject = str;
      } while (str != null);
      return "";
    }
    
    public final boolean etQ()
    {
      return true;
    }
    
    public final CharSequence etS()
    {
      Object localObject = this.DHa;
      if (localObject == null) {
        return (CharSequence)"";
      }
      localObject = ((bmr)localObject).nickName;
      if (localObject == null) {
        return (CharSequence)"";
      }
      return (CharSequence)localObject;
    }
    
    public final CharSequence etT()
    {
      Object localObject = this.DHa;
      if (localObject == null) {
        return (CharSequence)"";
      }
      localObject = ((bmr)localObject).desc;
      if (localObject == null) {
        return (CharSequence)"";
      }
      return (CharSequence)localObject;
    }
    
    public final boolean f(FrameLayout paramFrameLayout)
    {
      AppMethodBeat.i(351629);
      kotlin.g.b.s.u(paramFrameLayout, "container");
      ImageView localImageView = (ImageView)paramFrameLayout.findViewWithTag("Finder.TextStatusProvider");
      if (localImageView == null)
      {
        localImageView = new ImageView(paramFrameLayout.getContext());
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramFrameLayout.removeAllViews();
        paramFrameLayout.addView((View)localImageView);
        paramFrameLayout = this.DHa;
        if (paramFrameLayout != null) {
          break label113;
        }
      }
      label113:
      for (paramFrameLayout = null;; paramFrameLayout = paramFrameLayout.headUrl)
      {
        Object localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject = com.tencent.mm.plugin.finder.loader.p.eCp();
        paramFrameLayout = new com.tencent.mm.plugin.finder.loader.b(paramFrameLayout);
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject).a(paramFrameLayout, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        AppMethodBeat.o(351629);
        return true;
        break;
      }
    }
    
    public final boolean g(Context paramContext, Bundle paramBundle)
    {
      AppMethodBeat.i(351591);
      kotlin.g.b.s.u(paramContext, "context");
      long l1 = -1L;
      paramContext = this.DHi;
      if (paramContext != null)
      {
        Iterator localIterator = ((Iterable)paramContext).iterator();
        bool = false;
        while (localIterator.hasNext())
        {
          paramContext = (TextStatusJumpInfo)localIterator.next();
          l1 += 1L;
          if (kotlin.g.b.s.p(paramContext.jumpType, "2"))
          {
            paramContext = XmlParser.parseXml(paramContext.busiBuf, "finderLive", null);
            bmr localbmr;
            Object localObject1;
            Object localObject2;
            Object localObject3;
            long l2;
            long l3;
            if (paramContext != null)
            {
              localbmr = q.z("", paramContext);
              ce.a.a((ce)j.Dob, com.tencent.mm.ae.d.FK(localbmr.feedId), com.tencent.mm.ae.d.FK(localbmr.liveId), localbmr.username, -1L, l1, q.w.DwU, q.n.DtH.scene);
              if (!Util.isEqual(z.bAW(), localbmr.username)) {
                break label273;
              }
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("KEY_PARAMS_SOURCE_TYPE", localbmr.sourceType);
              localObject2 = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
              localObject3 = MMApplicationContext.getContext();
              l2 = com.tencent.mm.ae.d.FK(localbmr.feedId);
              l3 = com.tencent.mm.ae.d.FK(localbmr.liveId);
              paramBundle = localbmr.objectNonceId;
              paramContext = paramBundle;
              if (paramBundle == null) {
                paramContext = "";
              }
              ((com.tencent.d.a.a.a.b)localObject2).enterFinderLiveAnchorUI((Intent)localObject1, (Context)localObject3, l2, Long.valueOf(l3), paramContext, localbmr.desc, "", "", "");
            }
            for (;;)
            {
              bool = true;
              break;
              label273:
              localObject2 = new Intent();
              paramBundle = localbmr.ecSource;
              paramContext = paramBundle;
              if (paramBundle == null) {
                paramContext = "";
              }
              ((Intent)localObject2).putExtra("key_enter_live_param_ecsource", paramContext);
              paramContext = b.k.ahpq;
              ((Intent)localObject2).putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_SOURCE", b.k.a.jWm());
              paramContext = h.az(com.tencent.d.a.a.a.b.class);
              kotlin.g.b.s.s(paramContext, "plugin(IPluginFinderLive::class.java)");
              localObject3 = (com.tencent.d.a.a.a.b)paramContext;
              Context localContext = MMApplicationContext.getContext();
              l2 = com.tencent.mm.ae.d.FK(localbmr.feedId);
              l3 = com.tencent.mm.ae.d.FK(localbmr.liveId);
              paramBundle = localbmr.username;
              paramContext = paramBundle;
              if (paramBundle == null) {
                paramContext = "";
              }
              localObject1 = localbmr.objectNonceId;
              paramBundle = (Bundle)localObject1;
              if (localObject1 == null) {
                paramBundle = "";
              }
              b.b.a((com.tencent.d.a.a.a.b)localObject3, (Intent)localObject2, localContext, l2, Long.valueOf(l3), paramContext, paramBundle, localbmr.desc, "", "", "", "", 1);
            }
          }
          bool = false;
        }
      }
      boolean bool = false;
      AppMethodBeat.o(351591);
      return bool;
    }
    
    public final boolean gz(Context paramContext)
    {
      AppMethodBeat.i(351656);
      kotlin.g.b.s.u(paramContext, "context");
      bmr localbmr = this.DHa;
      if (localbmr != null)
      {
        Intent localIntent = new Intent();
        boolean bool = kotlin.g.b.s.p(localbmr.username, z.bAW());
        localIntent.putExtra("finder_username", localbmr.username);
        if (bool) {
          ((cn)h.az(cn.class)).enterFinderSelfProfile(paramContext, localIntent, 20, 2);
        }
        for (;;)
        {
          AppMethodBeat.o(351656);
          return true;
          ((cn)h.az(cn.class)).fillContextIdToIntent(20, 2, 32, localIntent);
          ((cn)h.az(cn.class)).enterFinderProfileUI(paramContext, localIntent);
        }
      }
      AppMethodBeat.o(351656);
      return false;
    }
    
    public final void k(ImageView paramImageView)
    {
      AppMethodBeat.i(351620);
      if (this.liveStatus == 2) {}
      for (Drawable localDrawable = bb.e(MMApplicationContext.getContext().getResources().getDrawable(p.g.finder_live_icon), -1);; localDrawable = MMApplicationContext.getContext().getResources().getDrawable(p.g.finder_live_icon))
      {
        if (paramImageView != null) {
          paramImageView.setImageDrawable(localDrawable);
        }
        AppMethodBeat.o(351620);
        return;
      }
    }
    
    public final void onDetach()
    {
      this.DHa = null;
    }
    
    public final void y(String paramString, List<TextStatusJumpInfo> paramList)
    {
      AppMethodBeat.i(351550);
      this.liveStatus = 1;
      this.DHi = paramList;
      if (paramList == null) {}
      for (paramString = null;; paramString = (TextStatusJumpInfo)kotlin.a.p.oL(paramList))
      {
        if (paramString != null)
        {
          paramString = XmlParser.parseXml(paramString.busiBuf, "finderLive", null);
          if (paramString != null) {
            this.DHa = q.z("", paramString);
          }
        }
        etR();
        AppMethodBeat.o(351550);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/status/LiveStatusService$createCustomParts$1$getCurLiveStatus$1$1", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "onLiveStatusCallback", "", "liveId", "", "status", "", "liveInfoResp", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements b.d
    {
      a(b.a parama) {}
      
      public final void onLiveStatusCallback(long paramLong, int paramInt, Object paramObject)
      {
        AppMethodBeat.i(351483);
        this.DHl.liveStatus = paramInt;
        b.a locala = this.DHl;
        paramObject = this.DHl.DHj;
        if (paramObject == null) {}
        for (paramObject = null;; paramObject = (ImageView)paramObject.get())
        {
          locala.k(paramObject);
          AppMethodBeat.o(351483);
          return;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<Bitmap, ah>
    {
      b(ImageView paramImageView)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.status.b
 * JD-Core Version:    0.7.0.1
 */