package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.feed.aa;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.loader.b;
import com.tencent.mm.plugin.finder.loader.g;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderLiveVisitorMicFeedView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "avatarView", "Landroid/widget/ImageView;", "bgView", "adjustLayout", "", "rootView", "Landroid/view/ViewGroup;", "userId", "totalCount", "index", "scene", "adjustLayoutRoomPk", "isSelfRoom", "", "adjustLayoutRoomPkFullScreen", "rootWidth", "rootHeight", "viewWidth", "adjustLayoutRoomPkHalfScreen", "fillMicUser", "micInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveVisitorMicFeedView
  extends RelativeLayout
{
  private final ImageView Esh;
  public final String TAG;
  private final ImageView pKM;
  
  public FinderLiveVisitorMicFeedView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(334995);
    AppMethodBeat.o(334995);
  }
  
  public FinderLiveVisitorMicFeedView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(335005);
    AppMethodBeat.o(335005);
  }
  
  public FinderLiveVisitorMicFeedView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(334986);
    this.TAG = "FinderLiveVisitorMicFeedView";
    View.inflate(paramContext, p.f.CdN, (ViewGroup)this);
    paramContext = findViewById(p.e.BKx);
    s.s(paramContext, "findViewById(R.id.finder_live_feed_visitor_mic_bg)");
    this.Esh = ((ImageView)paramContext);
    paramContext = findViewById(p.e.BKw);
    s.s(paramContext, "findViewById(R.id.finder…_feed_visitor_mic_avatar)");
    this.pKM = ((ImageView)paramContext);
    AppMethodBeat.o(334986);
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    AppMethodBeat.i(335022);
    switch (paramInt4)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(335022);
      return;
      if (paramInt5 == 0)
      {
        setTag(paramString);
        if (paramBoolean)
        {
          setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(paramInt3, paramInt2 / 2));
          setTranslationX(-paramInt1 / 2.0F);
          setTranslationY(paramInt2 / 2.0F);
          setVisibility(0);
          AppMethodBeat.o(335022);
          return;
        }
        setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(paramInt3, paramInt2 / 2));
        setTranslationX(paramInt1 / 2.0F);
        setTranslationY(paramInt2 / 2.0F);
        setVisibility(0);
        AppMethodBeat.o(335022);
        return;
        setTag(paramString);
        if (paramBoolean)
        {
          if (paramInt5 == 1)
          {
            setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(paramInt3, paramInt2 / 2));
            setTranslationX(-paramInt1 / 2.0F);
            setTranslationY(paramInt2 / 2.0F);
            setVisibility(0);
            AppMethodBeat.o(335022);
          }
        }
        else if (paramInt5 == 0)
        {
          setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(paramInt3, paramInt2 / 2));
          setTranslationX(paramInt1 / 2.0F);
          setTranslationY(paramInt2 / 2.0F);
          setVisibility(0);
        }
      }
    }
  }
  
  private final void b(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    AppMethodBeat.i(335032);
    switch (paramInt4)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(335032);
      return;
      if (paramInt5 == 0)
      {
        setTag(paramString);
        if (paramBoolean)
        {
          setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(paramInt3, paramInt2 / 2));
          setTranslationX(0.0F);
          setTranslationY(paramInt2 / 2.0F);
          setVisibility(0);
          AppMethodBeat.o(335032);
          return;
        }
        setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(paramInt3, paramInt2 / 2));
        setTranslationX(paramInt1 / 2.0F);
        setTranslationY(paramInt2 / 2.0F);
        setVisibility(0);
        AppMethodBeat.o(335032);
        return;
        setTag(paramString);
        switch (paramInt5)
        {
        default: 
          break;
        case 0: 
          if (paramBoolean)
          {
            setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(paramInt3 / 2, paramInt2 / 2));
            setTranslationX(0.0F);
            setTranslationY(paramInt2 / 2.0F);
            setVisibility(0);
            AppMethodBeat.o(335032);
            return;
          }
          setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(paramInt3 / 2, paramInt2 / 2));
          setTranslationX(paramInt1 / 2.0F);
          setTranslationY(paramInt2 / 2.0F);
          setVisibility(0);
          AppMethodBeat.o(335032);
          return;
        case 1: 
          if (paramBoolean)
          {
            setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(paramInt3 / 2, paramInt2 / 2));
            setTranslationX(paramInt1 / 4.0F);
            setTranslationY(paramInt2 / 2.0F);
            setVisibility(0);
            AppMethodBeat.o(335032);
            return;
          }
          setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(paramInt3 / 2, paramInt2 / 2));
          setTranslationX(paramInt1 * 0.75F);
          setTranslationY(paramInt2 / 2.0F);
          setVisibility(0);
        }
      }
    }
  }
  
  public final void a(ViewGroup paramViewGroup, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(335059);
    Log.i(this.TAG, "adjustLayoutRoomPk userId:" + paramString + " totalCount:" + paramInt1 + " index:" + paramInt2 + " scene:" + paramInt3 + " isSelfRoom:" + paramBoolean);
    int i;
    if (paramViewGroup == null)
    {
      i = 0;
      if (paramViewGroup != null) {
        break label146;
      }
      label81:
      paramViewGroup = aa.AWs;
      if (paramInt3 != aa.ecq()) {
        break label155;
      }
    }
    label146:
    label155:
    for (int k = i;; k = i / 2)
    {
      setVisibility(8);
      paramViewGroup = aa.AWs;
      if (paramInt3 != aa.ecq()) {
        break label164;
      }
      a(i, j, k, paramString, paramInt1, paramInt2, paramBoolean);
      AppMethodBeat.o(335059);
      return;
      i = paramViewGroup.getMeasuredWidth();
      break;
      j = paramViewGroup.getMeasuredHeight();
      break label81;
    }
    label164:
    b(i, j, k, paramString, paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(335059);
  }
  
  public final void k(bgh parambgh)
  {
    ImageView localImageView1 = null;
    AppMethodBeat.i(335050);
    Object localObject2 = this.TAG;
    Object localObject1;
    label45:
    label72:
    ImageView localImageView2;
    p localp;
    if (parambgh == null)
    {
      localObject1 = null;
      Log.i((String)localObject2, s.X("fillMicUser micInfo.nickname:", localObject1));
      if (parambgh != null)
      {
        localObject1 = parambgh.contact;
        if (localObject1 != null) {
          break label187;
        }
        localObject1 = null;
        if (!au.bwV((String)localObject1)) {
          break label203;
        }
        localObject1 = p.ExI;
        localObject2 = p.eCp();
        localObject1 = parambgh.contact;
        if (localObject1 != null) {
          break label195;
        }
        localObject1 = null;
        localObject1 = new b((String)localObject1);
        localImageView2 = this.pKM;
        localp = p.ExI;
        ((d)localObject2).a(localObject1, localImageView2, p.a(p.a.ExM));
        localObject1 = p.ExI;
        localObject1 = p.eCt();
        parambgh = parambgh.contact;
        if (parambgh != null) {
          break label268;
        }
      }
    }
    label268:
    for (parambgh = localImageView1;; parambgh = parambgh.headUrl)
    {
      parambgh = new g(parambgh, v.FKZ);
      localImageView1 = this.Esh;
      localObject2 = p.ExI;
      ((d)localObject1).a(parambgh, localImageView1, p.a(p.a.ExM));
      AppMethodBeat.o(335050);
      return;
      localObject1 = parambgh.contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((FinderContact)localObject1).nickname;
      break;
      label187:
      localObject1 = ((FinderContact)localObject1).username;
      break label45;
      label195:
      localObject1 = ((FinderContact)localObject1).headUrl;
      break label72;
      label203:
      localObject1 = p.ExI;
      localObject2 = p.eCq();
      localObject1 = parambgh.contact;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((FinderContact)localObject1).headUrl)
      {
        localObject1 = new b((String)localObject1);
        localImageView2 = this.pKM;
        localp = p.ExI;
        ((d)localObject2).a(localObject1, localImageView2, p.a(p.a.ExO));
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderLiveVisitorMicFeedView
 * JD-Core Version:    0.7.0.1
 */