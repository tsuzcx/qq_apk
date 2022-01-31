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
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g.a;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageFolderMgrView
  extends LinearLayout
  implements AdapterView.OnItemClickListener, g.a
{
  boolean Yq = false;
  private ImageFolderMgrView.a kJi = null;
  FrameLayout kJj;
  private View kJk;
  private ListView kJl;
  private b kJm;
  boolean kJn = false;
  
  public ImageFolderMgrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    this.kJj = new FrameLayout(getContext());
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.kJj.setVisibility(8);
    addView(this.kJj, paramContext);
    this.kJk = new View(getContext());
    this.kJk.setBackgroundColor(-872415232);
    this.kJk.setOnClickListener(new ImageFolderMgrView.3(this));
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.kJj.addView(this.kJk, paramContext);
    this.kJl = new ListView(getContext());
    this.kJl.setCacheColorHint(0);
    this.kJl.setBackgroundResource(R.e.navpage);
    this.kJl.setSelector(R.g.mm_trans);
    this.kJl.setOnItemClickListener(this);
    int i = getResources().getDimensionPixelSize(R.f.NormalPadding);
    this.kJl.setPadding(i, i / 3, i, i * 2 / 3);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.topMargin = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
    paramContext.gravity = 80;
    this.kJj.addView(this.kJl, paramContext);
    this.kJm = new b(getContext(), c.aXb().aXF());
    this.kJl.setAdapter(this.kJm);
  }
  
  private void gq(boolean paramBoolean)
  {
    if (this.Yq == paramBoolean)
    {
      y.d("MicroMsg.ImageFolderMgrView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.Yq) });
      return;
    }
    if (this.kJn)
    {
      y.d("MicroMsg.ImageFolderMgrView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    if (this.Yq)
    {
      this.kJn = true;
      localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.push_down_out);
      localAnimation.setAnimationListener(new ImageFolderMgrView.1(this));
      this.kJl.startAnimation(localAnimation);
      localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.fast_faded_out);
      this.kJk.startAnimation(localAnimation);
      return;
    }
    this.kJn = true;
    this.kJj.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.fast_faded_in);
    this.kJk.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.push_up_in);
    localAnimation.setAnimationListener(new ImageFolderMgrView.2(this));
    this.kJl.startAnimation(localAnimation);
  }
  
  public final void aXP()
  {
    if (!this.Yq) {}
    for (boolean bool = true;; bool = false)
    {
      gq(bool);
      return;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.kJm.rW(paramInt);
    if (paramAdapterView == null)
    {
      y.d("MicroMsg.ImageFolderMgrView", "get folder failed:" + paramInt);
      return;
    }
    if (this.kJi != null) {
      this.kJi.b(paramAdapterView);
    }
    this.kJm.kIQ = bk.aM(paramAdapterView.kGT, "");
    this.kJl.setSelection(0);
    this.kJm.notifyDataSetChanged();
    this.kJk.performClick();
  }
  
  public void setListener(ImageFolderMgrView.a parama)
  {
    this.kJi = parama;
  }
  
  public final void z(ArrayList<GalleryItem.AlbumItem> paramArrayList)
  {
    b localb = this.kJm;
    localb.kIO = paramArrayList;
    if ((localb.kIO != null) && (!localb.kIO.isEmpty()) && (((GalleryItem.AlbumItem)localb.kIO.get(0)).kGU != null))
    {
      Iterator localIterator = localb.kIO.iterator();
      paramArrayList = null;
      while (localIterator.hasNext())
      {
        GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)localIterator.next();
        if (paramArrayList == null)
        {
          paramArrayList = localAlbumItem;
        }
        else
        {
          if (paramArrayList.kGU.kGY >= localAlbumItem.kGU.kGY) {
            break label138;
          }
          paramArrayList = localAlbumItem;
        }
      }
    }
    label138:
    for (;;)
    {
      break;
      if (paramArrayList != null) {
        localb.kIP.kGU = paramArrayList.kGU;
      }
      c.aXc().d(new Runnable()
      {
        public final void run()
        {
          ImageFolderMgrView.d(ImageFolderMgrView.this).notifyDataSetChanged();
        }
        
        public final String toString()
        {
          return super.toString() + "|onQueryAlbumFinished";
        }
      });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView
 * JD-Core Version:    0.7.0.1
 */