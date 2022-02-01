package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.thumbplayer.view.MMTPEffectVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ad;
import com.tencent.mm.videocomposition.effect.EffectRenderView;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderTextStatusVideoView;", "Lcom/tencent/mm/plugin/finder/view/BaseFinderTextStatusView;", "sourceId", "", "parent", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Ljava/lang/String;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "TAG", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "isViewOpen", "", "thumbView", "Landroid/widget/ImageView;", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "checkShowValidLayout", "", "isFeedValid", "createTPMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "createThumbInfo", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "createVideoLayout", "getCurCycle", "", "getTag", "isPauseMusic", "onDestroy", "onPause", "onPostClose", "onPostOpen", "onPreClose", "onPreOpen", "onResume", "onTransAnim", "percent", "", "playVideo", "resetFinderObject", "updateVideoMute", "plugin-finder_release"})
public final class q
  extends a
{
  private boolean BaU;
  private final FrameLayout BaV;
  private FeedData BaZ;
  private MMTPEffectVideoLayout Bba;
  private final String TAG;
  private final ImageView wPh;
  private final FinderObject xcx;
  
  public q(FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, com.tencent.mm.plugin.textstatus.proto.d paramd, FinderObject paramFinderObject)
  {
    super(paramTextStatusJumpInfo, paramFinderObject, paramd);
    AppMethodBeat.i(291784);
    this.BaV = paramFrameLayout;
    this.xcx = paramFinderObject;
    this.TAG = "Finder.TextStatusVideoView";
    paramFrameLayout = FeedData.Companion;
    paramFrameLayout = FinderItem.Companion;
    paramFrameLayout = FinderItem.a.b(this.xcx, this.xcx.objectType);
    paramFrameLayout.setReplaceLongVideoToNormal(true);
    this.BaZ = FeedData.a.j(paramFrameLayout);
    paramFrameLayout = new ImageView(this.BaV.getContext());
    paramFrameLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramFrameLayout.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.wPh = paramFrameLayout;
    this.Bba = ejo();
    ad.kS(this.BaV.getContext()).inflate(b.g.finder_text_status_view, (ViewGroup)this.BaV, true);
    paramFrameLayout = (ViewGroup)this.BaV.findViewById(b.f.content_view);
    paramFrameLayout.addView((View)this.Bba);
    paramFrameLayout.addView((View)this.wPh);
    paramFrameLayout.addView(ad.kS(this.BaV.getContext()).inflate(b.g.finder_text_status_invalid_view, (ViewGroup)this.BaV, false));
    rm(eib());
    AppMethodBeat.o(291784);
  }
  
  private final void Tf()
  {
    AppMethodBeat.i(291776);
    if (eib())
    {
      ejp();
      com.tencent.mm.plugin.thumbplayer.f.b localb = this.Bba.getPlayer();
      if (localb != null) {
        localb.ALj = true;
      }
      localb = this.Bba.getPlayer();
      if (localb != null)
      {
        localb.gos();
        AppMethodBeat.o(291776);
        return;
      }
    }
    AppMethodBeat.o(291776);
  }
  
  private final MMTPEffectVideoLayout ejo()
  {
    AppMethodBeat.i(291771);
    Object localObject1 = this.BaV.getContext();
    p.j(localObject1, "parent.context");
    MMTPEffectVideoLayout localMMTPEffectVideoLayout = new MMTPEffectVideoLayout((Context)localObject1);
    localMMTPEffectVideoLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    localMMTPEffectVideoLayout.goU();
    localObject1 = (csg)j.lp((List)this.BaZ.getMediaList());
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      Object localObject4 = com.tencent.mm.plugin.finder.storage.logic.d.AnN.b(this.BaZ.getId(), (csg)localObject1);
      String str1 = ((aa)localObject4).aBv();
      String str2 = ((aa)localObject4).getPath();
      String str3 = ((aa)localObject4).getUrl();
      localObject2 = ((aa)localObject4).dIZ();
      localObject3 = ((aa)localObject4).dIY();
      long l = ((csg)localObject1).videoDuration;
      localObject4 = ((aa)localObject4).ztP.detail;
      Object localObject5 = new r((csg)localObject1, u.Alz, null, null, 12);
      String str4 = ((r)localObject5).getPath();
      String str5 = ((r)localObject5).aJi();
      localObject5 = ((r)localObject5).dJa();
      localObject1 = new com.tencent.mm.plugin.thumbplayer.e.d(str1, str2, str3, (int)((csg)localObject1).width, (int)((csg)localObject1).height);
      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).decodeKey = ((String)localObject3);
      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).beR((String)localObject2);
      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).sTg = l;
      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fPD = ((String)localObject4);
      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).ON(str4);
      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).Oc(str5);
      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).beS((String)localObject5);
      localMMTPEffectVideoLayout.setMediaInfo((com.tencent.mm.plugin.thumbplayer.e.d)localObject1);
      localMMTPEffectVideoLayout.getEffectManager().ikd();
      localMMTPEffectVideoLayout.setKeepScreenOn(true);
      localObject1 = localMMTPEffectVideoLayout.getPlayer();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).ALj = true;
      }
      localObject1 = localMMTPEffectVideoLayout.getPlayer();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).setLoop(true);
      }
      localObject1 = localMMTPEffectVideoLayout.getPlayer();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).setMute(true);
      }
      localObject1 = (csg)j.lp((List)this.BaZ.getMediaList());
      if (localObject1 == null) {
        break label505;
      }
    }
    label505:
    for (localObject1 = (r)new o((csg)localObject1, u.Alz);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject2 = com.tencent.mm.plugin.finder.loader.t.dJe();
        localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((com.tencent.mm.loader.d)localObject2).a(localObject1, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU)).a((com.tencent.mm.loader.f.e)new a(this)).aRr();
      }
      this.wPh.setVisibility(0);
      localMMTPEffectVideoLayout.setOnFrameAvailable((kotlin.g.a.q)new b(localMMTPEffectVideoLayout, this));
      localObject1 = localMMTPEffectVideoLayout.getPlayer();
      if (localObject1 != null) {
        com.tencent.mm.plugin.thumbplayer.f.b.a((com.tencent.mm.plugin.thumbplayer.f.b)localObject1, (com.tencent.mm.plugin.thumbplayer.view.e)new c(this));
      }
      localObject1 = localMMTPEffectVideoLayout.getPlayer();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).gos();
      }
      if (this.yNR.MEP) {
        eic();
      }
      AppMethodBeat.o(291771);
      return localMMTPEffectVideoLayout;
      localObject1 = new com.tencent.mm.plugin.thumbplayer.e.d("", "", "", 0, 0);
      break;
    }
  }
  
  private final void ejp()
  {
    boolean bool = false;
    AppMethodBeat.i(291775);
    Object localObject = this.yNR;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((com.tencent.mm.plugin.textstatus.proto.d)localObject).MEO);
      switch (((Integer)localObject).intValue())
      {
      }
    }
    for (int i = 0;; i = 1)
    {
      localObject = this.Bba.getPlayer();
      if (localObject == null) {
        break label117;
      }
      if ((i != 0) || (!this.BaU) || (com.tencent.mm.q.a.aAo()) || (com.tencent.mm.q.a.r(this.Bba.getContext(), false))) {
        bool = true;
      }
      ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).setMute(bool);
      AppMethodBeat.o(291775);
      return;
      localObject = null;
      break;
    }
    label117:
    AppMethodBeat.o(291775);
  }
  
  public final void G(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(291772);
    p.k(paramFinderObject, "finderObject");
    super.G(paramFinderObject);
    Log.w(this.TAG, "[resetFinderObject] feedId=" + com.tencent.mm.ae.d.Fw(paramFinderObject.id));
    Object localObject = FeedData.Companion;
    localObject = FinderItem.Companion;
    paramFinderObject = FinderItem.a.b(paramFinderObject, paramFinderObject.objectType);
    paramFinderObject.setReplaceLongVideoToNormal(true);
    this.BaZ = FeedData.a.j(paramFinderObject);
    paramFinderObject = this.Bba.getPlayer();
    if (paramFinderObject != null) {
      paramFinderObject.stop();
    }
    paramFinderObject = this.Bba.getPlayer();
    if (paramFinderObject != null) {
      paramFinderObject.recycle();
    }
    this.Bba.MUh.YIy.release();
    ((ViewGroup)this.BaV.findViewById(b.f.content_view)).removeView((View)this.Bba);
    this.Bba = ejo();
    ejp();
    ((ViewGroup)this.BaV.findViewById(b.f.content_view)).addView((View)this.Bba, 0);
    AppMethodBeat.o(291772);
  }
  
  public final void dDB()
  {
    AppMethodBeat.i(291774);
    Log.i(this.TAG, "[onPreOpen]");
    this.BaU = true;
    AppMethodBeat.o(291774);
  }
  
  public final void dDC()
  {
    AppMethodBeat.i(291778);
    Log.i(this.TAG, "[onPreClose]");
    this.BaU = false;
    AppMethodBeat.o(291778);
  }
  
  public final boolean dDD()
  {
    com.tencent.mm.plugin.textstatus.proto.d locald = this.yNR;
    return (locald == null) || (locald.MEO != 2);
  }
  
  public final void dDE()
  {
    AppMethodBeat.i(291777);
    super.dDE();
    Log.i(this.TAG, "[onPostOpen] isFeedValid=" + eib());
    rm(eib());
    eic();
    Tf();
    AppMethodBeat.o(291777);
  }
  
  public final long ejq()
  {
    return this.ATW.AUa + 1L;
  }
  
  public final String getTag()
  {
    return "Finder.TextStatusVideoView";
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291783);
    super.onDestroy();
    Log.i(this.TAG, "[onDestroy]");
    com.tencent.mm.plugin.thumbplayer.f.b localb = this.Bba.getPlayer();
    if (localb != null) {
      localb.stop();
    }
    localb = this.Bba.getPlayer();
    if (localb != null) {
      localb.recycle();
    }
    this.Bba.MUh.YIy.release();
    AppMethodBeat.o(291783);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(291780);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    if (this.yNR.MEP)
    {
      com.tencent.mm.plugin.thumbplayer.f.b localb = this.Bba.getPlayer();
      if (localb != null)
      {
        localb.pause();
        AppMethodBeat.o(291780);
        return;
      }
    }
    AppMethodBeat.o(291780);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(291779);
    super.onPostClose();
    rm(eib());
    Object localObject = this.Bba.getPlayer();
    if (localObject != null) {
      ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).ALj = false;
    }
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[onPostClose] isPlaying=");
    localObject = this.Bba.getPlayer();
    if (localObject != null) {}
    for (localObject = Boolean.valueOf(((com.tencent.mm.plugin.thumbplayer.f.b)localObject).isPlaying());; localObject = null)
    {
      Log.i(str, localObject + " isPreviewVideo:" + this.yNR.MEP);
      if (!this.yNR.MEP) {
        break label145;
      }
      localObject = this.Bba.getPlayer();
      if (localObject == null) {
        break;
      }
      ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).setMute(true);
      AppMethodBeat.o(291779);
      return;
    }
    AppMethodBeat.o(291779);
    return;
    label145:
    localObject = this.Bba.getPlayer();
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).pause();
      AppMethodBeat.o(291779);
      return;
    }
    AppMethodBeat.o(291779);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(291781);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    if (this.yNR.MEP) {
      Tf();
    }
    AppMethodBeat.o(291781);
  }
  
  public final void rm(boolean paramBoolean)
  {
    AppMethodBeat.i(291773);
    Log.i(this.TAG, "[checkShowValidLayout] isFeedValid=" + paramBoolean + " isViewOpen=" + this.BaU);
    if (paramBoolean)
    {
      localObject = this.BaV.findViewById(b.f.invalid_container);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.Bba.getPlayer();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).gos();
        AppMethodBeat.o(291773);
        return;
      }
      AppMethodBeat.o(291773);
      return;
    }
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((f)localObject).aHp().get(ar.a.VyV, "");
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(291773);
      throw ((Throwable)localObject);
    }
    localObject = (String)localObject;
    int i;
    if (((CharSequence)localObject).length() == 0)
    {
      i = 1;
      if (i == 0)
      {
        Log.i(this.TAG, "[checkShowValidLayout] wording=".concat(String.valueOf(localObject)));
        TextView localTextView = (TextView)this.BaV.findViewById(b.f.invalid_tv);
        if (localTextView != null) {
          localTextView.setText((CharSequence)localObject);
        }
      }
      localObject = this.BaV.findViewById(b.f.invalid_container);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      if (!this.BaU) {
        break label311;
      }
      localObject = this.BaV.findViewById(b.f.invalid_layout);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.BaV.findViewById(b.f.hint_invalid_layout);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    for (;;)
    {
      localObject = this.Bba.getPlayer();
      if (localObject == null) {
        break label355;
      }
      ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).pause();
      AppMethodBeat.o(291773);
      return;
      i = 0;
      break;
      label311:
      localObject = this.BaV.findViewById(b.f.hint_invalid_layout);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.BaV.findViewById(b.f.invalid_layout);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    label355:
    AppMethodBeat.o(291773);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/view/FinderTextStatusVideoView$createVideoLayout$1$1$1", "com/tencent/mm/plugin/finder/view/FinderTextStatusVideoView$$special$$inlined$let$lambda$1"})
  static final class a<T, R>
    implements com.tencent.mm.loader.f.e<w, Bitmap>
  {
    a(q paramq) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "invoke", "com/tencent/mm/plugin/finder/view/FinderTextStatusVideoView$createVideoLayout$1$2"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.q<SurfaceTexture, Integer, Integer, x>
  {
    b(MMTPEffectVideoLayout paramMMTPEffectVideoLayout, q paramq)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderTextStatusVideoView$createVideoLayout$1$3", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "lastTime", "", "onProgress", "", "media", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "timeMs", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.plugin.thumbplayer.view.e
  {
    private long kje;
    
    c(q paramq) {}
    
    public final void a(com.tencent.mm.plugin.thumbplayer.e.d paramd, long paramLong)
    {
      if (this.kje > paramLong)
      {
        paramd = this.Bbb.ATW;
        paramd.AUa += 1;
      }
      this.kje = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.q
 * JD-Core Version:    0.7.0.1
 */