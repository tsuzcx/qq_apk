package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.core.area.ExpandTouchDelegate;
import com.tencent.mm.accessibility.core.area.ExpandTouchDelegate.Companion;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.b;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.v;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.thumbplayer.api.ITPPlayer;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeBtn", "Landroid/widget/ImageView;", "closeLayout", "Landroid/view/View;", "hintIv", "hintLayout", "hintTv", "Landroid/widget/TextView;", "isError", "", "()Z", "setError", "(Z)V", "isVideoEnd", "setVideoEnd", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "musicAvatar", "musicCloseBtn", "musicContainer", "Landroid/view/ViewGroup;", "musicPlayCtrlLayout", "getMusicPlayCtrlLayout", "()Landroid/view/View;", "musicPlayCtrlView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "renderContainer", "shapeType", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView$ShapeType;", "getShapeType", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView$ShapeType;", "setShapeType", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView$ShapeType;)V", "videoViewCallback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "addInternalImageView", "", "bitmap", "Landroid/graphics/Bitmap;", "addInternalVideoView", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "targetTime", "playSpeedRatio", "", "needPause", "addMusicView", "mediaType", "avatarUrl", "", "addRenderView", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "calculateFloatBallLayoutParams", "Lkotlin/Triple;", "parent", "originWidth", "originHeight", "calculateShapeType", "mediaSize", "Landroid/util/Size;", "expandCloseClickArea", "getVideoView", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;", "removeAllRenderView", "resetState", "setMusicCtrlBtnStatus", "isPlay", "setupClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "closeClickListener", "Companion", "MiniViewLifeCycle", "ShapeType", "SimpleVideoPlayLifecycle", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMegaVideoMiniView
  extends FrameLayout
{
  public static final FinderMegaVideoMiniView.a EAi;
  private final MMProcessBar Bno;
  private final View EAj;
  private final View EAk;
  private final FrameLayout EAl;
  public boolean EAm;
  private c EAn;
  private final ViewGroup EAo;
  private final View EAp;
  private final ImageView EAq;
  private final View EAr;
  private final WeImageView EAs;
  private final i.b EAt;
  private final ImageView nkq;
  public boolean nnu;
  private final TextView qjr;
  private final View vKG;
  
  static
  {
    AppMethodBeat.i(342007);
    EAi = new FinderMegaVideoMiniView.a((byte)0);
    AppMethodBeat.o(342007);
  }
  
  public FinderMegaVideoMiniView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(341860);
    this.EAn = c.EAv;
    View.inflate(getContext(), e.f.finder_mega_video_mini_view_ui, (ViewGroup)this);
    paramContext = findViewById(e.e.finder_mega_video_mini_view_close_group);
    s.s(paramContext, "findViewById(R.id.finder…eo_mini_view_close_group)");
    this.vKG = paramContext;
    paramContext = findViewById(e.e.finder_mega_video_mini_view_close_btn);
    s.s(paramContext, "findViewById(R.id.finder…ideo_mini_view_close_btn)");
    this.nkq = ((ImageView)paramContext);
    paramContext = findViewById(e.e.finder_mega_video_mini_view_hint_layout);
    s.s(paramContext, "findViewById(R.id.finder…eo_mini_view_hint_layout)");
    this.EAj = paramContext;
    paramContext = findViewById(e.e.finder_mega_video_mini_view_hint_iv);
    s.s(paramContext, "findViewById(R.id.finder…_video_mini_view_hint_iv)");
    this.EAk = paramContext;
    paramContext = findViewById(e.e.finder_mega_video_mini_view_hint_tv);
    s.s(paramContext, "findViewById(R.id.finder…_video_mini_view_hint_tv)");
    this.qjr = ((TextView)paramContext);
    paramContext = findViewById(e.e.finder_mega_video_mini_view_loading_icon);
    s.s(paramContext, "findViewById(R.id.finder…o_mini_view_loading_icon)");
    this.Bno = ((MMProcessBar)paramContext);
    paramContext = findViewById(e.e.finder_mega_video_mini_view_render_container);
    s.s(paramContext, "findViewById(R.id.finder…ni_view_render_container)");
    this.EAl = ((FrameLayout)paramContext);
    this.EAl.setClipToOutline(true);
    this.EAl.setOutlineProvider((ViewOutlineProvider)new com.tencent.mm.live.core.mini.d(a.fromDPToPix(MMApplicationContext.getContext(), 8)));
    paramContext = findViewById(e.e.finder_mini_view_music_layout);
    s.s(paramContext, "findViewById(R.id.finder_mini_view_music_layout)");
    this.EAo = ((ViewGroup)paramContext);
    paramContext = findViewById(e.e.music_close_btn_layout);
    s.s(paramContext, "findViewById(R.id.music_close_btn_layout)");
    this.EAp = paramContext;
    paramContext = findViewById(e.e.music_mini_view_avatar);
    s.s(paramContext, "findViewById(R.id.music_mini_view_avatar)");
    this.EAq = ((ImageView)paramContext);
    paramContext = findViewById(e.e.music_mini_view_play_ctrl_layout);
    s.s(paramContext, "findViewById(R.id.music_…ni_view_play_ctrl_layout)");
    this.EAr = paramContext;
    paramContext = findViewById(e.e.music_mini_view_play_ctrl_view);
    s.s(paramContext, "findViewById(R.id.music_mini_view_play_ctrl_view)");
    this.EAs = ((WeImageView)paramContext);
    this.EAt = ((i.b)new g(this));
    AppMethodBeat.o(341860);
  }
  
  public FinderMegaVideoMiniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(341877);
    this.EAn = c.EAv;
    View.inflate(getContext(), e.f.finder_mega_video_mini_view_ui, (ViewGroup)this);
    paramContext = findViewById(e.e.finder_mega_video_mini_view_close_group);
    s.s(paramContext, "findViewById(R.id.finder…eo_mini_view_close_group)");
    this.vKG = paramContext;
    paramContext = findViewById(e.e.finder_mega_video_mini_view_close_btn);
    s.s(paramContext, "findViewById(R.id.finder…ideo_mini_view_close_btn)");
    this.nkq = ((ImageView)paramContext);
    paramContext = findViewById(e.e.finder_mega_video_mini_view_hint_layout);
    s.s(paramContext, "findViewById(R.id.finder…eo_mini_view_hint_layout)");
    this.EAj = paramContext;
    paramContext = findViewById(e.e.finder_mega_video_mini_view_hint_iv);
    s.s(paramContext, "findViewById(R.id.finder…_video_mini_view_hint_iv)");
    this.EAk = paramContext;
    paramContext = findViewById(e.e.finder_mega_video_mini_view_hint_tv);
    s.s(paramContext, "findViewById(R.id.finder…_video_mini_view_hint_tv)");
    this.qjr = ((TextView)paramContext);
    paramContext = findViewById(e.e.finder_mega_video_mini_view_loading_icon);
    s.s(paramContext, "findViewById(R.id.finder…o_mini_view_loading_icon)");
    this.Bno = ((MMProcessBar)paramContext);
    paramContext = findViewById(e.e.finder_mega_video_mini_view_render_container);
    s.s(paramContext, "findViewById(R.id.finder…ni_view_render_container)");
    this.EAl = ((FrameLayout)paramContext);
    this.EAl.setClipToOutline(true);
    this.EAl.setOutlineProvider((ViewOutlineProvider)new com.tencent.mm.live.core.mini.d(a.fromDPToPix(MMApplicationContext.getContext(), 8)));
    paramContext = findViewById(e.e.finder_mini_view_music_layout);
    s.s(paramContext, "findViewById(R.id.finder_mini_view_music_layout)");
    this.EAo = ((ViewGroup)paramContext);
    paramContext = findViewById(e.e.music_close_btn_layout);
    s.s(paramContext, "findViewById(R.id.music_close_btn_layout)");
    this.EAp = paramContext;
    paramContext = findViewById(e.e.music_mini_view_avatar);
    s.s(paramContext, "findViewById(R.id.music_mini_view_avatar)");
    this.EAq = ((ImageView)paramContext);
    paramContext = findViewById(e.e.music_mini_view_play_ctrl_layout);
    s.s(paramContext, "findViewById(R.id.music_…ni_view_play_ctrl_layout)");
    this.EAr = paramContext;
    paramContext = findViewById(e.e.music_mini_view_play_ctrl_view);
    s.s(paramContext, "findViewById(R.id.music_mini_view_play_ctrl_view)");
    this.EAs = ((WeImageView)paramContext);
    this.EAt = ((i.b)new g(this));
    AppMethodBeat.o(341877);
  }
  
  public FinderMegaVideoMiniView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(341894);
    this.EAn = c.EAv;
    View.inflate(getContext(), e.f.finder_mega_video_mini_view_ui, (ViewGroup)this);
    paramContext = findViewById(e.e.finder_mega_video_mini_view_close_group);
    s.s(paramContext, "findViewById(R.id.finder…eo_mini_view_close_group)");
    this.vKG = paramContext;
    paramContext = findViewById(e.e.finder_mega_video_mini_view_close_btn);
    s.s(paramContext, "findViewById(R.id.finder…ideo_mini_view_close_btn)");
    this.nkq = ((ImageView)paramContext);
    paramContext = findViewById(e.e.finder_mega_video_mini_view_hint_layout);
    s.s(paramContext, "findViewById(R.id.finder…eo_mini_view_hint_layout)");
    this.EAj = paramContext;
    paramContext = findViewById(e.e.finder_mega_video_mini_view_hint_iv);
    s.s(paramContext, "findViewById(R.id.finder…_video_mini_view_hint_iv)");
    this.EAk = paramContext;
    paramContext = findViewById(e.e.finder_mega_video_mini_view_hint_tv);
    s.s(paramContext, "findViewById(R.id.finder…_video_mini_view_hint_tv)");
    this.qjr = ((TextView)paramContext);
    paramContext = findViewById(e.e.finder_mega_video_mini_view_loading_icon);
    s.s(paramContext, "findViewById(R.id.finder…o_mini_view_loading_icon)");
    this.Bno = ((MMProcessBar)paramContext);
    paramContext = findViewById(e.e.finder_mega_video_mini_view_render_container);
    s.s(paramContext, "findViewById(R.id.finder…ni_view_render_container)");
    this.EAl = ((FrameLayout)paramContext);
    this.EAl.setClipToOutline(true);
    this.EAl.setOutlineProvider((ViewOutlineProvider)new com.tencent.mm.live.core.mini.d(a.fromDPToPix(MMApplicationContext.getContext(), 8)));
    paramContext = findViewById(e.e.finder_mini_view_music_layout);
    s.s(paramContext, "findViewById(R.id.finder_mini_view_music_layout)");
    this.EAo = ((ViewGroup)paramContext);
    paramContext = findViewById(e.e.music_close_btn_layout);
    s.s(paramContext, "findViewById(R.id.music_close_btn_layout)");
    this.EAp = paramContext;
    paramContext = findViewById(e.e.music_mini_view_avatar);
    s.s(paramContext, "findViewById(R.id.music_mini_view_avatar)");
    this.EAq = ((ImageView)paramContext);
    paramContext = findViewById(e.e.music_mini_view_play_ctrl_layout);
    s.s(paramContext, "findViewById(R.id.music_…ni_view_play_ctrl_layout)");
    this.EAr = paramContext;
    paramContext = findViewById(e.e.music_mini_view_play_ctrl_view);
    s.s(paramContext, "findViewById(R.id.music_mini_view_play_ctrl_view)");
    this.EAs = ((WeImageView)paramContext);
    this.EAt = ((i.b)new g(this));
    AppMethodBeat.o(341894);
  }
  
  private static final void a(FinderMegaVideoMiniView paramFinderMegaVideoMiniView)
  {
    AppMethodBeat.i(341949);
    s.u(paramFinderMegaVideoMiniView, "this$0");
    Rect localRect = new Rect();
    paramFinderMegaVideoMiniView.nkq.getHitRect(localRect);
    int[] arrayOfInt = new int[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfInt[i] = 0;
      i += 1;
    }
    i = a.K(MMApplicationContext.getContext(), localRect.width());
    int j = a.K(MMApplicationContext.getContext(), localRect.height());
    if (i < 44)
    {
      arrayOfInt[0] = a.fromDPToPix(MMApplicationContext.getContext(), (44 - i) / 2);
      arrayOfInt[2] = a.fromDPToPix(MMApplicationContext.getContext(), (44 - i) / 2);
    }
    if (j < 44)
    {
      arrayOfInt[1] = a.fromDPToPix(MMApplicationContext.getContext(), (44 - j) / 2);
      arrayOfInt[3] = a.fromDPToPix(MMApplicationContext.getContext(), (44 - j) / 2);
    }
    ExpandTouchDelegate.Companion.setDelegate((View)paramFinderMegaVideoMiniView.nkq, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
    AppMethodBeat.o(341949);
  }
  
  private static final void a(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, FinderMegaVideoMiniView paramFinderMegaVideoMiniView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(341935);
    s.u(paramFinderThumbPlayerProxy, "$newTPView");
    s.u(paramFinderMegaVideoMiniView, "this$0");
    Object localObject1 = paramFinderThumbPlayerProxy.getVideoMediaInfo();
    label66:
    float f1;
    float f2;
    int i;
    float f3;
    float f4;
    if (localObject1 == null)
    {
      localObject1 = localObject2;
      if (localObject1 != null) {
        break label370;
      }
      localObject2 = new Size(paramFinderMegaVideoMiniView.EAl.getWidth(), paramFinderMegaVideoMiniView.EAl.getHeight());
      localObject1 = (View)paramFinderMegaVideoMiniView.EAl;
      f1 = ((Size)localObject2).getWidth();
      f2 = ((Size)localObject2).getHeight();
      i = ImageView.ScaleType.CENTER_CROP.ordinal();
      f3 = ((View)localObject1).getHeight();
      f4 = ((View)localObject1).getWidth();
      localObject1 = paramFinderMegaVideoMiniView.EAn;
      switch (e.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        localObject1 = new u(Integer.valueOf(i), Integer.valueOf((int)f4), Integer.valueOf((int)(f4 * f2 / f1)));
      }
    }
    for (;;)
    {
      Log.i("FinderMegaVideoMiniView", "addRenderView: shapeType=" + paramFinderMegaVideoMiniView.getShapeType() + ", textureView width=" + ((Number)((u)localObject1).bsD).intValue() + " height=" + ((Number)((u)localObject1).aiuN).intValue() + ", videoWidth=" + ((Size)localObject2).getWidth() + ", videoHeight=" + ((Size)localObject2).getHeight());
      paramFinderThumbPlayerProxy.ib(((Number)((u)localObject1).bsD).intValue(), ((Number)((u)localObject1).aiuN).intValue());
      paramFinderMegaVideoMiniView.nkq.post(new FinderMegaVideoMiniView..ExternalSyntheticLambda0(paramFinderMegaVideoMiniView));
      AppMethodBeat.o(341935);
      return;
      Object localObject3 = ((v)localObject1).ANK;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject3 = ((x)localObject3).eCF();
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject1 = i.a((dji)localObject3, true);
      break;
      label370:
      localObject2 = localObject1;
      break label66;
      int j = (int)f3;
      localObject1 = new u(Integer.valueOf(i), Integer.valueOf((int)(f1 * f3 / f2)), Integer.valueOf(j));
      continue;
      if (f2 > f1)
      {
        localObject1 = new u(Integer.valueOf(i), Integer.valueOf((int)f4), Integer.valueOf((int)(f4 * f2 / f1)));
      }
      else
      {
        j = (int)f3;
        localObject1 = new u(Integer.valueOf(i), Integer.valueOf((int)(f1 * f3 / f2)), Integer.valueOf(j));
      }
    }
  }
  
  public final void Oi()
  {
    AppMethodBeat.i(342137);
    this.EAo.setVisibility(8);
    this.EAl.setVisibility(0);
    this.EAj.setVisibility(0);
    this.vKG.setVisibility(0);
    this.EAj.setVisibility(8);
    this.Bno.setVisibility(8);
    this.nnu = false;
    setContentDescription((CharSequence)getResources().getString(e.h.talkback_finder_video));
    AppMethodBeat.o(342137);
  }
  
  public final void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(342076);
    s.u(paramOnClickListener1, "clickListener");
    s.u(paramOnClickListener2, "closeClickListener");
    setOnClickListener(paramOnClickListener1);
    this.EAo.setOnClickListener(paramOnClickListener1);
    this.nkq.setOnClickListener(paramOnClickListener2);
    this.EAp.setOnClickListener(paramOnClickListener2);
    this.nkq.setContentDescription((CharSequence)getResources().getString(e.h.close_btn));
    this.EAp.setContentDescription((CharSequence)getResources().getString(e.h.close_btn));
    AppMethodBeat.o(342076);
  }
  
  public final void ayL(String paramString)
  {
    AppMethodBeat.i(342089);
    s.u(paramString, "avatarUrl");
    eCO();
    Oi();
    this.EAo.setVisibility(0);
    this.EAl.setVisibility(4);
    this.EAj.setVisibility(8);
    this.vKG.setVisibility(8);
    this.EAn = c.EAy;
    Object localObject = p.ExI;
    localObject = p.eCp();
    paramString = new b(paramString);
    ImageView localImageView = this.EAq;
    p localp = p.ExI;
    ((com.tencent.mm.loader.d)localObject).a(paramString, localImageView, p.a(p.a.ExM));
    AppMethodBeat.o(342089);
  }
  
  public final void eCO()
  {
    AppMethodBeat.i(342111);
    if (this.EAl.getChildCount() <= 0)
    {
      AppMethodBeat.o(342111);
      return;
    }
    int i = 0;
    int k = this.EAl.getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      Object localObject = this.EAl.getChildAt(i);
      if ((localObject instanceof FinderThumbPlayerProxy)) {}
      for (localObject = (FinderThumbPlayerProxy)localObject;; localObject = null)
      {
        if (localObject != null)
        {
          ((FinderThumbPlayerProxy)localObject).setVideoViewCallback(null);
          ((FinderThumbPlayerProxy)localObject).onUIDestroy();
          ((FinderThumbPlayerProxy)localObject).onRelease();
        }
        if (j < k) {
          break;
        }
        this.EAl.removeAllViews();
        AppMethodBeat.o(342111);
        return;
      }
      i = j;
    }
  }
  
  public final View getMusicPlayCtrlLayout()
  {
    return this.EAr;
  }
  
  public final c getShapeType()
  {
    return this.EAn;
  }
  
  public final FinderThumbPlayerProxy getVideoView()
  {
    AppMethodBeat.i(342120);
    Object localObject = this.EAl.getChildAt(0);
    if ((localObject instanceof FinderThumbPlayerProxy))
    {
      localObject = (FinderThumbPlayerProxy)localObject;
      AppMethodBeat.o(342120);
      return localObject;
    }
    AppMethodBeat.o(342120);
    return null;
  }
  
  public final void setError(boolean paramBoolean)
  {
    this.EAm = paramBoolean;
  }
  
  public final void setMusicCtrlBtnStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(342097);
    WeImageView localWeImageView = this.EAs;
    if (paramBoolean) {}
    for (int i = e.g.icons_filled_pause;; i = e.g.icons_filled_play)
    {
      localWeImageView.setImageResource(i);
      AppMethodBeat.o(342097);
      return;
    }
  }
  
  public final void setShapeType(c paramc)
  {
    AppMethodBeat.i(342061);
    s.u(paramc, "<set-?>");
    this.EAn = paramc;
    AppMethodBeat.o(342061);
  }
  
  public final void setVideoEnd(boolean paramBoolean)
  {
    this.nnu = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView$ShapeType;", "", "(Ljava/lang/String;I)V", "PORTRAIT", "LANDSCAPE", "SQUARE", "MUSIC", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    static
    {
      AppMethodBeat.i(341989);
      EAv = new c("PORTRAIT", 0);
      EAw = new c("LANDSCAPE", 1);
      EAx = new c("SQUARE", 2);
      EAy = new c("MUSIC", 3);
      EAz = new c[] { EAv, EAw, EAx, EAy };
      AppMethodBeat.o(341989);
    }
    
    private c() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView$videoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onSeekComplete", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements i.b
  {
    g(FinderMegaVideoMiniView paramFinderMegaVideoMiniView) {}
    
    public final void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(342035);
      FinderMegaVideoMiniView.c(this.EAu).setVisibility(0);
      FinderMegaVideoMiniView.e(this.EAu).setVisibility(0);
      FinderMegaVideoMiniView.f(this.EAu).setVisibility(0);
      FinderMegaVideoMiniView.d(this.EAu).setVisibility(8);
      FinderMegaVideoMiniView.f(this.EAu).setText(e.h.mega_video_float_net_error_hint);
      this.EAu.setContentDescription((CharSequence)this.EAu.getResources().getString(e.h.talkback_finder_video_net_error));
      this.EAu.setVideoEnd(false);
      paramString1 = this.EAu.getVideoView();
      if (paramString1 != null) {
        paramString1.stop();
      }
      this.EAu.setError(true);
      AppMethodBeat.o(342035);
    }
    
    public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
    
    public final void el(String paramString1, String paramString2) {}
    
    public final void em(String paramString1, String paramString2)
    {
      AppMethodBeat.i(342010);
      FinderMegaVideoMiniView.c(this.EAu).setVisibility(0);
      FinderMegaVideoMiniView.e(this.EAu).setVisibility(8);
      FinderMegaVideoMiniView.f(this.EAu).setVisibility(0);
      FinderMegaVideoMiniView.d(this.EAu).setVisibility(8);
      FinderMegaVideoMiniView.f(this.EAu).setText(e.h.mega_video_float_end_hint);
      this.EAu.setContentDescription((CharSequence)this.EAu.getResources().getString(e.h.talkback_finder_video_finish));
      this.EAu.setVideoEnd(true);
      AppMethodBeat.o(342010);
    }
    
    public final void en(String paramString1, String paramString2) {}
    
    public final void eo(String paramString1, String paramString2)
    {
      AppMethodBeat.i(341990);
      FinderMegaVideoMiniView.b(this.EAu);
      AppMethodBeat.o(341990);
    }
    
    public final void ep(String paramString1, String paramString2)
    {
      AppMethodBeat.i(341977);
      FinderMegaVideoMiniView.c(this.EAu).setVisibility(8);
      FinderMegaVideoMiniView.d(this.EAu).setVisibility(0);
      this.EAu.setVideoEnd(false);
      this.EAu.setContentDescription((CharSequence)this.EAu.getResources().getString(e.h.talkback_finder_video_net_error));
      AppMethodBeat.o(341977);
    }
    
    public final void eq(String paramString1, String paramString2)
    {
      AppMethodBeat.i(342000);
      FinderMegaVideoMiniView.b(this.EAu);
      AppMethodBeat.o(342000);
    }
    
    public final void gE(String paramString1, String paramString2) {}
    
    public final void onSeekComplete(ITPPlayer paramITPPlayer) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.FinderMegaVideoMiniView
 * JD-Core Version:    0.7.0.1
 */