package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.i.a;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public class ImageFolderMgrView
  extends LinearLayout
  implements AdapterView.OnItemClickListener, i.a
{
  boolean Zb;
  private a nfG;
  FrameLayout nfH;
  private View nfI;
  private ListView nfJ;
  private b nfK;
  boolean nfL;
  
  public ImageFolderMgrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(21477);
    this.nfG = null;
    this.Zb = false;
    this.nfL = false;
    setOrientation(1);
    this.nfH = new FrameLayout(getContext());
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.nfH.setVisibility(8);
    addView(this.nfH, paramContext);
    this.nfI = new View(getContext());
    this.nfI.setBackgroundColor(-872415232);
    this.nfI.setOnClickListener(new ImageFolderMgrView.3(this));
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.nfH.addView(this.nfI, paramContext);
    this.nfJ = new ListView(getContext());
    this.nfJ.setCacheColorHint(0);
    this.nfJ.setBackgroundResource(2131690310);
    this.nfJ.setSelector(2130839676);
    this.nfJ.setOnItemClickListener(this);
    int i = getResources().getDimensionPixelSize(2131427808);
    this.nfJ.setPadding(i, i / 3, i, i * 2 / 3);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.topMargin = getResources().getDimensionPixelSize(2131427559);
    paramContext.gravity = 80;
    this.nfH.addView(this.nfJ, paramContext);
    this.nfK = new b(getContext(), e.bDQ().ndz);
    this.nfJ.setAdapter(this.nfK);
    AppMethodBeat.o(21477);
  }
  
  private void bEw()
  {
    AppMethodBeat.i(21480);
    this.nfL = true;
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034228);
    localAnimation.setAnimationListener(new ImageFolderMgrView.1(this));
    this.nfJ.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034182);
    this.nfI.startAnimation(localAnimation);
    AppMethodBeat.o(21480);
  }
  
  private void bEx()
  {
    AppMethodBeat.i(21481);
    this.nfL = true;
    this.nfH.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034181);
    this.nfI.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034230);
    localAnimation.setAnimationListener(new ImageFolderMgrView.2(this));
    this.nfJ.startAnimation(localAnimation);
    AppMethodBeat.o(21481);
  }
  
  private void hV(boolean paramBoolean)
  {
    AppMethodBeat.i(21479);
    if (this.Zb == paramBoolean)
    {
      ab.d("MicroMsg.ImageFolderMgrView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.Zb) });
      AppMethodBeat.o(21479);
      return;
    }
    if (this.nfL)
    {
      ab.d("MicroMsg.ImageFolderMgrView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(21479);
      return;
    }
    if (this.Zb)
    {
      bEw();
      AppMethodBeat.o(21479);
      return;
    }
    bEx();
    AppMethodBeat.o(21479);
  }
  
  public final void V(LinkedList<GalleryItem.AlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(21482);
    b localb = this.nfK;
    localb.nfl = paramLinkedList;
    if ((localb.nfl != null) && (!localb.nfl.isEmpty()) && (((GalleryItem.AlbumItem)localb.nfl.get(0)).ndm != null))
    {
      Iterator localIterator = localb.nfl.iterator();
      paramLinkedList = null;
      while (localIterator.hasNext())
      {
        GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)localIterator.next();
        if (paramLinkedList == null)
        {
          paramLinkedList = localAlbumItem;
        }
        else
        {
          if (paramLinkedList.ndm.ndq >= localAlbumItem.ndm.ndq) {
            break label150;
          }
          paramLinkedList = localAlbumItem;
        }
      }
    }
    label150:
    for (;;)
    {
      break;
      if (paramLinkedList != null) {
        localb.nfm.ndm = paramLinkedList.ndm;
      }
      e.bDR().d(new ImageFolderMgrView.4(this));
      AppMethodBeat.o(21482);
      return;
    }
  }
  
  public final void bEv()
  {
    AppMethodBeat.i(21478);
    if (!this.Zb) {}
    for (boolean bool = true;; bool = false)
    {
      hV(bool);
      AppMethodBeat.o(21478);
      return;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(21483);
    paramAdapterView = this.nfK.wS(paramInt);
    if (paramAdapterView == null)
    {
      ab.d("MicroMsg.ImageFolderMgrView", "get folder failed:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(21483);
      return;
    }
    if (this.nfG != null) {
      this.nfG.b(paramAdapterView);
    }
    this.nfK.nfn = bo.bf(paramAdapterView.ndl, "");
    this.nfJ.setSelection(0);
    this.nfK.notifyDataSetChanged();
    this.nfI.performClick();
    AppMethodBeat.o(21483);
  }
  
  public void setListener(a parama)
  {
    this.nfG = parama;
  }
  
  public static abstract interface a
  {
    public abstract void b(GalleryItem.AlbumItem paramAlbumItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView
 * JD-Core Version:    0.7.0.1
 */