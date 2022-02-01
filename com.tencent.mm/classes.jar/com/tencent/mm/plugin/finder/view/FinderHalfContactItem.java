package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.findersdk.a.af;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.ezj;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderHalfContactItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imgIV", "", "Landroid/widget/ImageView;", "mTitle", "", "mUserRecentLikeInfo", "Lcom/tencent/mm/protocal/protobuf/UserRecentLikeInfo;", "initView", "", "refresh", "userRecentLikeInfo", "setTitle", "title", "updateAlbum", "updateView", "plugin-finder_release"})
public final class FinderHalfContactItem
  extends FrameLayout
{
  private final List<ImageView> AYn;
  private ezj AYo;
  private String mTitle;
  
  public FinderHalfContactItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(261518);
    this.mTitle = "";
    this.AYn = ((List)new LinkedList());
    initView();
    AppMethodBeat.o(261518);
  }
  
  public FinderHalfContactItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(261520);
    this.mTitle = "";
    this.AYn = ((List)new LinkedList());
    initView();
    AppMethodBeat.o(261520);
  }
  
  private final void eiM()
  {
    AppMethodBeat.i(261513);
    Object localObject = this.AYn.iterator();
    ImageView localImageView;
    while (((Iterator)localObject).hasNext())
    {
      localImageView = (ImageView)((Iterator)localObject).next();
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
    }
    localObject = this.AYo;
    if (localObject != null)
    {
      int j = ((ezj)localObject).SGi.size();
      int i = 0;
      while ((i < j) && (i < this.AYn.size()))
      {
        localImageView = (ImageView)this.AYn.get(i);
        if (localImageView != null) {
          localImageView.setVisibility(0);
        }
        com.tencent.mm.kernel.b.a locala = h.ag(ak.class);
        p.j(locala, "MMKernel.plugin(IPluginFinder::class.java)");
        ((ak)locala).getFinderUIApi().a(((ezj)localObject).SGi.get(i), localImageView);
        i += 1;
      }
    }
    AppMethodBeat.o(261513);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(261509);
    Object localObject = getContext().getSystemService("layout_inflater");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(261509);
      throw ((Throwable)localObject);
    }
    ((LayoutInflater)localObject).inflate(b.g.half_contact_finder_item, (ViewGroup)this, true);
    this.AYn.clear();
    this.AYn.add(findViewById(b.f.image_iv1));
    this.AYn.add(findViewById(b.f.image_iv2));
    this.AYn.add(findViewById(b.f.image_iv3));
    this.AYn.add(findViewById(b.f.image_iv4));
    AppMethodBeat.o(261509);
  }
  
  public final void a(ezj paramezj)
  {
    AppMethodBeat.i(261516);
    this.AYo = paramezj;
    eiM();
    AppMethodBeat.o(261516);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(261510);
    p.k(paramString, "title");
    this.mTitle = paramString;
    paramString = findViewById(b.f.album_title);
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(261510);
      throw paramString;
    }
    paramString = (TextView)paramString;
    if (!Util.isNullOrNil(this.mTitle))
    {
      paramString.setText((CharSequence)this.mTitle);
      ViewGroup.LayoutParams localLayoutParams = paramString.getLayoutParams();
      localLayoutParams.width = com.tencent.mm.ci.a.aY(getContext(), b.d.FixedTitleWidth);
      paramString.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      eiM();
      AppMethodBeat.o(261510);
      return;
      paramString.setText((CharSequence)"");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderHalfContactItem
 * JD-Core Version:    0.7.0.1
 */