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
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.l;
import com.tencent.mm.plugin.thumbplayer.view.MMTPEffectVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.videocomposition.effect.EffectRenderView;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderTextStatusVideoView;", "Lcom/tencent/mm/plugin/finder/view/BaseFinderTextStatusView;", "sourceId", "", "parent", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Ljava/lang/String;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "TAG", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "isViewOpen", "", "thumbView", "Landroid/widget/ImageView;", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "checkShowValidLayout", "", "isFeedValid", "createTPMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "createThumbInfo", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "createVideoLayout", "getCurCycle", "", "getTag", "isPauseMusic", "onDestroy", "onPause", "onPostClose", "onPostOpen", "onPreClose", "onPreOpen", "onResume", "onTransAnim", "percent", "", "playVideo", "resetFinderObject", "updateVideoMute", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends a
{
  private final FinderObject ABJ;
  private final ImageView AlJ;
  private final FrameLayout GDk;
  private boolean GDm;
  private FeedData GDo;
  private MMTPEffectVideoLayout Goz;
  private final String TAG;
  
  public s(FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, l paraml, FinderObject paramFinderObject)
  {
    super(paramTextStatusJumpInfo, paramFinderObject, paraml);
    AppMethodBeat.i(344412);
    this.GDk = paramFrameLayout;
    this.ABJ = paramFinderObject;
    this.TAG = getTag();
    paramFrameLayout = FeedData.Companion;
    paramFrameLayout = FinderItem.Companion;
    paramFrameLayout = FinderItem.a.e(this.ABJ, this.ABJ.objectType);
    paramFrameLayout.setReplaceLongVideoToNormal(true);
    paramTextStatusJumpInfo = ah.aiuX;
    this.GDo = FeedData.a.n(paramFrameLayout);
    paramFrameLayout = new ImageView(this.GDk.getContext());
    paramFrameLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramFrameLayout.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramTextStatusJumpInfo = ah.aiuX;
    this.AlJ = paramFrameLayout;
    this.Goz = flr();
    af.mU(this.GDk.getContext()).inflate(e.f.finder_text_status_view, (ViewGroup)this.GDk, true);
    paramFrameLayout = (ViewGroup)this.GDk.findViewById(e.e.content_view);
    paramFrameLayout.addView((View)this.Goz);
    paramFrameLayout.addView((View)this.AlJ);
    paramFrameLayout.addView(af.mU(this.GDk.getContext()).inflate(e.f.finder_text_status_invalid_view, (ViewGroup)this.GDk, false));
    uN(fkb());
    AppMethodBeat.o(344412);
  }
  
  private static final void a(Bitmap paramBitmap, s params)
  {
    AppMethodBeat.i(344484);
    kotlin.g.b.s.u(params, "this$0");
    com.tencent.mm.videocomposition.effect.a locala = new com.tencent.mm.videocomposition.effect.a();
    kotlin.g.b.s.s(paramBitmap, "resource");
    locala.setInputBitmap(paramBitmap);
    locala.setOutputSize(params.AlJ.getWidth(), params.AlJ.getHeight());
    locala.HkF.GpO.jQk();
    locala.aW((kotlin.g.a.b)new a(params));
    AppMethodBeat.o(344484);
  }
  
  private static final void a(s params, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(344494);
    kotlin.g.b.s.u(params, "this$0");
    params.AlJ.post(new s..ExternalSyntheticLambda1(paramBitmap, params));
    AppMethodBeat.o(344494);
  }
  
  private final void atK()
  {
    AppMethodBeat.i(344479);
    if (fkb())
    {
      flu();
      com.tencent.mm.plugin.thumbplayer.e.b localb = this.Goz.getPlayer();
      if (localb != null) {
        localb.Flr = true;
      }
      localb = this.Goz.getPlayer();
      if (localb != null) {
        localb.hLh();
      }
    }
    AppMethodBeat.o(344479);
  }
  
  private final MMTPEffectVideoLayout flr()
  {
    AppMethodBeat.i(344433);
    Object localObject1 = this.GDk.getContext();
    kotlin.g.b.s.s(localObject1, "parent.context");
    localObject1 = new MMTPEffectVideoLayout((Context)localObject1);
    ((MMTPEffectVideoLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    ((MMTPEffectVideoLayout)localObject1).fva();
    ((MMTPEffectVideoLayout)localObject1).setMediaInfo(flt());
    ((MMTPEffectVideoLayout)localObject1).getEffectManager().jQk();
    ((MMTPEffectVideoLayout)localObject1).setKeepScreenOn(true);
    Object localObject2 = ((MMTPEffectVideoLayout)localObject1).getPlayer();
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).Flr = true;
    }
    localObject2 = ((MMTPEffectVideoLayout)localObject1).getPlayer();
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).setLoop(true);
    }
    localObject2 = ((MMTPEffectVideoLayout)localObject1).getPlayer();
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).setMute(true);
    }
    localObject2 = fls();
    if (localObject2 != null)
    {
      Object localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject3 = com.tencent.mm.plugin.finder.loader.p.eCl();
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject3).a(localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ)).a(new s..ExternalSyntheticLambda0(this)).blg();
    }
    this.AlJ.setVisibility(0);
    ((MMTPEffectVideoLayout)localObject1).setOnFirstFrameAvailable((q)new b(this, (MMTPEffectVideoLayout)localObject1));
    localObject2 = ((MMTPEffectVideoLayout)localObject1).getPlayer();
    if (localObject2 != null) {
      com.tencent.mm.plugin.thumbplayer.e.b.a((com.tencent.mm.plugin.thumbplayer.e.b)localObject2, (com.tencent.mm.plugin.thumbplayer.view.e)new c(this));
    }
    localObject2 = ((MMTPEffectVideoLayout)localObject1).getPlayer();
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).hLh();
    }
    if (this.DGY.ToP) {
      fkc();
    }
    AppMethodBeat.o(344433);
    return localObject1;
  }
  
  private final n fls()
  {
    AppMethodBeat.i(344447);
    Object localObject = (dji)kotlin.a.p.oL((List)this.GDo.getMediaList());
    if (localObject != null)
    {
      localObject = (n)new k((dji)localObject, com.tencent.mm.plugin.finder.storage.v.FKZ);
      AppMethodBeat.o(344447);
      return localObject;
    }
    AppMethodBeat.o(344447);
    return null;
  }
  
  private final com.tencent.mm.plugin.thumbplayer.a.b flt()
  {
    AppMethodBeat.i(344465);
    Object localObject2 = (dji)kotlin.a.p.oL((List)this.GDo.getMediaList());
    if (localObject2 != null)
    {
      Object localObject3 = com.tencent.mm.plugin.finder.storage.logic.e.FNF.b(this.GDo.getId(), (dji)localObject2);
      String str2 = kotlin.g.b.s.X(((com.tencent.mm.plugin.finder.loader.v)localObject3).aUt(), "_textStatus");
      String str3 = kotlin.g.b.s.X(((com.tencent.mm.plugin.finder.loader.v)localObject3).getPath(), "_textStatus");
      String str4 = ((com.tencent.mm.plugin.finder.loader.v)localObject3).getUrl();
      localObject1 = ((com.tencent.mm.plugin.finder.loader.v)localObject3).eCf();
      String str1 = ((com.tencent.mm.plugin.finder.loader.v)localObject3).eCe();
      long l = ((dji)localObject2).videoDuration;
      localObject3 = ((com.tencent.mm.plugin.finder.loader.v)localObject3).ExF.detail;
      Object localObject4 = new n((dji)localObject2, com.tencent.mm.plugin.finder.storage.v.FKZ, null, null, 12);
      String str5 = ((n)localObject4).getPath();
      String str6 = ((n)localObject4).eCi();
      localObject4 = ((n)localObject4).eCg();
      localObject2 = new com.tencent.mm.plugin.thumbplayer.a.b(str2, str3, str4, (int)((dji)localObject2).width, (int)((dji)localObject2).height);
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).decodeKey = str1;
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).msf = ((String)localObject1);
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).vYw = l;
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).hVy = ((String)localObject3);
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).thumbPath = str5;
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).thumbUrl = str6;
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).msh = ((String)localObject4);
      AppMethodBeat.o(344465);
      return localObject2;
    }
    Object localObject1 = new com.tencent.mm.plugin.thumbplayer.a.b("", "", "", 0, 0);
    AppMethodBeat.o(344465);
    return localObject1;
  }
  
  private final void flu()
  {
    boolean bool = false;
    AppMethodBeat.i(344474);
    Object localObject = this.DGY;
    if (localObject != null) {
      int i = ((l)localObject).ToO;
    }
    localObject = this.Goz.getPlayer();
    if (localObject != null)
    {
      if ((!this.GDm) || (com.tencent.mm.n.a.aTj()) || (com.tencent.mm.n.a.s(this.Goz.getContext(), false))) {
        bool = true;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).setMute(bool);
    }
    AppMethodBeat.o(344474);
  }
  
  public final void H(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(344556);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    super.H(paramFinderObject);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[resetFinderObject] feedId=").append(com.tencent.mm.ae.d.hF(paramFinderObject.id)).append(" player");
    Object localObject = this.Goz.getPlayer();
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.e.b)localObject).hashCode()))
    {
      Log.w(str, localObject);
      localObject = FeedData.Companion;
      localObject = FinderItem.Companion;
      paramFinderObject = FinderItem.a.e(paramFinderObject, paramFinderObject.objectType);
      paramFinderObject.setReplaceLongVideoToNormal(true);
      localObject = ah.aiuX;
      this.GDo = FeedData.a.n(paramFinderObject);
      paramFinderObject = this.Goz.getPlayer();
      if (paramFinderObject != null) {
        paramFinderObject.stop();
      }
      paramFinderObject = this.Goz.getPlayer();
      if (paramFinderObject != null) {
        paramFinderObject.recycle();
      }
      this.Goz.TGP.HkF.release();
      ((ViewGroup)this.GDk.findViewById(e.e.content_view)).removeView((View)this.Goz);
      this.Goz = flr();
      flu();
      ((ViewGroup)this.GDk.findViewById(e.e.content_view)).addView((View)this.Goz, 0);
      AppMethodBeat.o(344556);
      return;
    }
  }
  
  public final void etL()
  {
    AppMethodBeat.i(344576);
    Log.i(this.TAG, "[onPreOpen]");
    this.GDm = true;
    AppMethodBeat.o(344576);
  }
  
  public final void etM()
  {
    AppMethodBeat.i(344587);
    Log.i(this.TAG, "[onPreClose]");
    this.GDm = false;
    AppMethodBeat.o(344587);
  }
  
  public final boolean etN()
  {
    return true;
  }
  
  public final void etO()
  {
    AppMethodBeat.i(344581);
    super.etO();
    Log.i(this.TAG, kotlin.g.b.s.X("[onPostOpen] isFeedValid=", Boolean.valueOf(fkb())));
    uN(fkb());
    fkc();
    atK();
    AppMethodBeat.o(344581);
  }
  
  public final long flv()
  {
    return this.Gwr.Gwt + 1L;
  }
  
  public final String getTag()
  {
    AppMethodBeat.i(344537);
    String str = kotlin.g.b.s.X("Finder.TextStatusVideoView@", Integer.valueOf(hashCode()));
    AppMethodBeat.o(344537);
    return str;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(344643);
    super.onDestroy();
    String str = this.TAG;
    Object localObject = this.Goz.getPlayer();
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.e.b)localObject).hashCode()))
    {
      Log.i(str, kotlin.g.b.s.X("[onDestroy] player:", localObject));
      localObject = this.Goz.getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).stop();
      }
      localObject = this.Goz.getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).recycle();
      }
      this.Goz.TGP.HkF.release();
      AppMethodBeat.o(344643);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(344608);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    if (this.DGY.ToP)
    {
      com.tencent.mm.plugin.thumbplayer.e.b localb = this.Goz.getPlayer();
      if (localb != null) {
        com.tencent.mm.plugin.thumbplayer.e.b.b(localb);
      }
    }
    AppMethodBeat.o(344608);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(344600);
    super.onPostClose();
    uN(fkb());
    Object localObject = this.Goz.getPlayer();
    if (localObject != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).Flr = false;
    }
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[onPostClose] isPlaying=");
    localObject = this.Goz.getPlayer();
    if (localObject == null) {}
    for (localObject = null;; localObject = Boolean.valueOf(((com.tencent.mm.plugin.thumbplayer.e.b)localObject).isPlaying()))
    {
      Log.i(str, localObject + " isPreviewVideo:" + this.DGY.ToP);
      if (!this.DGY.ToP) {
        break;
      }
      localObject = this.Goz.getPlayer();
      if (localObject == null) {
        break label154;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).setMute(true);
      AppMethodBeat.o(344600);
      return;
    }
    localObject = this.Goz.getPlayer();
    if (localObject != null) {
      com.tencent.mm.plugin.thumbplayer.e.b.b((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
    }
    label154:
    AppMethodBeat.o(344600);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(344621);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    if (this.DGY.ToP) {
      atK();
    }
    AppMethodBeat.o(344621);
  }
  
  public final void uN(boolean paramBoolean)
  {
    AppMethodBeat.i(344568);
    Log.i(this.TAG, "[checkShowValidLayout] isFeedValid=" + paramBoolean + " isViewOpen=" + this.GDm);
    if (paramBoolean)
    {
      localObject = this.GDk.findViewById(e.e.invalid_container);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.Goz.getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).hLh();
      }
      AppMethodBeat.o(344568);
      return;
    }
    Object localObject = h.baE().ban().get(at.a.adaR, "");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(344568);
      throw ((Throwable)localObject);
    }
    localObject = (String)localObject;
    int i;
    if (((CharSequence)localObject).length() == 0)
    {
      i = 1;
      if (i == 0)
      {
        Log.i(this.TAG, kotlin.g.b.s.X("[checkShowValidLayout] wording=", localObject));
        TextView localTextView = (TextView)this.GDk.findViewById(e.e.invalid_tv);
        if (localTextView != null) {
          localTextView.setText((CharSequence)localObject);
        }
      }
      localObject = this.GDk.findViewById(e.e.invalid_container);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      if (!this.GDm) {
        break label292;
      }
      localObject = this.GDk.findViewById(e.e.invalid_layout);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.GDk.findViewById(e.e.hint_invalid_layout);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    for (;;)
    {
      localObject = this.Goz.getPlayer();
      if (localObject != null) {
        com.tencent.mm.plugin.thumbplayer.e.b.b((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
      }
      AppMethodBeat.o(344568);
      return;
      i = 0;
      break;
      label292:
      localObject = this.GDk.findViewById(e.e.hint_invalid_layout);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.GDk.findViewById(e.e.invalid_layout);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    a(s params)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements q<SurfaceTexture, Integer, Integer, ah>
  {
    b(s params, MMTPEffectVideoLayout paramMMTPEffectVideoLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderTextStatusVideoView$createVideoLayout$1$3", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "lastTime", "", "onProgress", "", "media", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "timeMs", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.thumbplayer.view.e
  {
    private long mJI;
    
    c(s params) {}
    
    public final void a(com.tencent.mm.plugin.thumbplayer.a.b paramb, long paramLong)
    {
      if (this.mJI > paramLong)
      {
        paramb = this.GDp.Gwr;
        paramb.Gwt += 1;
      }
      this.mJI = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.s
 * JD-Core Version:    0.7.0.1
 */