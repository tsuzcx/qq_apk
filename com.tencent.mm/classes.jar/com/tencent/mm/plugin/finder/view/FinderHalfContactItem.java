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
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.findersdk.a.bz;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.fvm;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderHalfContactItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imgIV", "", "Landroid/widget/ImageView;", "mTitle", "", "mUserRecentLikeInfo", "Lcom/tencent/mm/protocal/protobuf/UserRecentLikeInfo;", "initView", "", "refresh", "userRecentLikeInfo", "setTitle", "title", "updateAlbum", "updateView", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderHalfContactItem
  extends FrameLayout
{
  private final List<ImageView> GzL;
  private fvm GzM;
  private String mTitle;
  
  public FinderHalfContactItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345723);
    this.mTitle = "";
    this.GzL = ((List)new LinkedList());
    initView();
    AppMethodBeat.o(345723);
  }
  
  public FinderHalfContactItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345727);
    this.mTitle = "";
    this.GzL = ((List)new LinkedList());
    initView();
    AppMethodBeat.o(345727);
  }
  
  private final void fkH()
  {
    AppMethodBeat.i(345736);
    Object localObject = this.GzL.iterator();
    ImageView localImageView;
    while (((Iterator)localObject).hasNext())
    {
      localImageView = (ImageView)((Iterator)localObject).next();
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
    }
    localObject = this.GzM;
    if (localObject != null)
    {
      int j = ((fvm)localObject).ZIQ.size();
      int i = 0;
      while ((i < j) && (i < this.GzL.size()))
      {
        localImageView = (ImageView)this.GzL.get(i);
        if (localImageView != null) {
          localImageView.setVisibility(0);
        }
        ((cn)h.az(cn.class)).getFinderUIApi().a(((fvm)localObject).ZIQ.get(i), localImageView);
        i += 1;
      }
    }
    AppMethodBeat.o(345736);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(345731);
    Object localObject = getContext().getSystemService("layout_inflater");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(345731);
      throw ((Throwable)localObject);
    }
    ((LayoutInflater)localObject).inflate(e.f.half_contact_finder_item, (ViewGroup)this, true);
    this.GzL.clear();
    this.GzL.add(findViewById(e.e.image_iv1));
    this.GzL.add(findViewById(e.e.image_iv2));
    this.GzL.add(findViewById(e.e.image_iv3));
    this.GzL.add(findViewById(e.e.image_iv4));
    AppMethodBeat.o(345731);
  }
  
  public final void a(fvm paramfvm)
  {
    AppMethodBeat.i(345761);
    this.GzM = paramfvm;
    fkH();
    AppMethodBeat.o(345761);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(345750);
    s.u(paramString, "title");
    this.mTitle = paramString;
    paramString = findViewById(e.e.album_title);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(345750);
      throw paramString;
    }
    paramString = (TextView)paramString;
    if (!Util.isNullOrNil(this.mTitle))
    {
      paramString.setText((CharSequence)this.mTitle);
      ViewGroup.LayoutParams localLayoutParams = paramString.getLayoutParams();
      localLayoutParams.width = a.br(getContext(), e.c.FixedTitleWidth);
      paramString.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      fkH();
      AppMethodBeat.o(345750);
      return;
      paramString.setText((CharSequence)"");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderHalfContactItem
 * JD-Core Version:    0.7.0.1
 */