package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.PrivateAlbumItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.i.a;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.model.s.a;
import com.tencent.mm.plugin.gallery.model.s.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.i;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public class ImageFolderMgrView
  extends LinearLayout
  implements AdapterView.OnItemClickListener, i.a
{
  boolean gX;
  i.a rJA;
  private LinkedList<GalleryItem.PrivateAlbumItem> rJB;
  private GalleryItem.PrivateAlbumItem rJC;
  b rJD;
  private a rJu;
  FrameLayout rJv;
  private View rJw;
  private ListView rJx;
  private b rJy;
  boolean rJz;
  
  public ImageFolderMgrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111536);
    this.rJu = null;
    this.gX = false;
    this.rJz = false;
    this.rJB = new LinkedList();
    this.rJC = null;
    setOrientation(1);
    this.rJv = new FrameLayout(getContext());
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.rJv.setVisibility(8);
    addView(this.rJv, paramContext);
    this.rJw = new View(getContext());
    this.rJw.setBackgroundColor(-872415232);
    this.rJw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111532);
        ImageFolderMgrView.c(ImageFolderMgrView.this);
        AppMethodBeat.o(111532);
      }
    });
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.rJv.addView(this.rJw, paramContext);
    paramContext = new RoundedCornerFrameLayout(getContext());
    paramContext.l(0.0F, 0.0F, ao.fromDPToPix(getContext(), 8), ao.fromDPToPix(getContext(), 8));
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.bottomMargin = getResources().getDimensionPixelSize(2131166394);
    paramAttributeSet.gravity = 48;
    this.rJv.addView(paramContext, paramAttributeSet);
    this.rJx = new ListView(getContext());
    this.rJx.setCacheColorHint(0);
    this.rJx.setOnItemClickListener(this);
    paramAttributeSet = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addView(this.rJx, paramAttributeSet);
    this.rJy = new b(getContext());
    this.rJx.setAdapter(this.rJy);
    this.rJA = new i.a()
    {
      public final void ah(LinkedList<GalleryItem.AlbumItem> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(173780);
        Object localObject;
        if (paramAnonymousLinkedList != null)
        {
          localObject = Integer.valueOf(paramAnonymousLinkedList.size());
          ad.i("MicroMsg.ImageFolderMgrView", "onGetPrivateAlbum, %s.", new Object[] { localObject });
          e.czh().c(ImageFolderMgrView.d(ImageFolderMgrView.this));
          if ((paramAnonymousLinkedList != null) && (paramAnonymousLinkedList.size() > 0)) {
            paramAnonymousLinkedList = paramAnonymousLinkedList.iterator();
          }
        }
        else
        {
          for (;;)
          {
            label61:
            if (!paramAnonymousLinkedList.hasNext()) {
              break label154;
            }
            localObject = (GalleryItem.AlbumItem)paramAnonymousLinkedList.next();
            if ((localObject instanceof GalleryItem.PrivateAlbumItem))
            {
              localObject = (GalleryItem.PrivateAlbumItem)localObject;
              s.b localb = ((GalleryItem.PrivateAlbumItem)localObject).rBx.rCg;
              if (localb == null) {}
              for (boolean bool = false;; bool = localb.rCj)
              {
                if (!bool) {
                  break label139;
                }
                ImageFolderMgrView.a(ImageFolderMgrView.this, (GalleryItem.PrivateAlbumItem)localObject);
                break label61;
                localObject = "res is null.";
                break;
              }
              label139:
              ImageFolderMgrView.e(ImageFolderMgrView.this).add(localObject);
            }
          }
          label154:
          ad.i("MicroMsg.ImageFolderMgrView", "filter res: %s.", new Object[] { Integer.valueOf(ImageFolderMgrView.e(ImageFolderMgrView.this).size()) });
          if ((!ImageFolderMgrView.this.isInLayout()) && ((ImageFolderMgrView.f(ImageFolderMgrView.this) != null) || (ImageFolderMgrView.e(ImageFolderMgrView.this).size() > 0)))
          {
            ImageFolderMgrView.g(ImageFolderMgrView.this).a(ImageFolderMgrView.f(ImageFolderMgrView.this), ImageFolderMgrView.e(ImageFolderMgrView.this));
            ImageFolderMgrView.a(ImageFolderMgrView.this, null);
            ImageFolderMgrView.e(ImageFolderMgrView.this).clear();
            e.czi().f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(173779);
                ImageFolderMgrView.g(ImageFolderMgrView.this).notifyDataSetChanged();
                AppMethodBeat.o(173779);
              }
            });
          }
        }
        AppMethodBeat.o(173780);
      }
    };
    getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(179469);
        ad.i("MicroMsg.ImageFolderMgrView", "onPreDraw.");
        if ((ImageFolderMgrView.f(ImageFolderMgrView.this) != null) || (ImageFolderMgrView.e(ImageFolderMgrView.this).size() > 0))
        {
          ImageFolderMgrView.g(ImageFolderMgrView.this).a(ImageFolderMgrView.f(ImageFolderMgrView.this), ImageFolderMgrView.e(ImageFolderMgrView.this));
          ImageFolderMgrView.a(ImageFolderMgrView.this, null);
          ImageFolderMgrView.e(ImageFolderMgrView.this).clear();
          e.czi().f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(179468);
              ImageFolderMgrView.g(ImageFolderMgrView.this).notifyDataSetChanged();
              AppMethodBeat.o(179468);
            }
          });
          AppMethodBeat.o(179469);
          return false;
        }
        AppMethodBeat.o(179469);
        return true;
      }
    });
    AppMethodBeat.o(111536);
  }
  
  private void cAC()
  {
    AppMethodBeat.i(111539);
    this.rJz = true;
    this.rJv.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772047);
    this.rJw.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772105);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(111530);
        ImageFolderMgrView.a(ImageFolderMgrView.this, true);
        ImageFolderMgrView.a(ImageFolderMgrView.this);
        if (ImageFolderMgrView.this.rJD != null) {
          ImageFolderMgrView.this.rJD.lF(true);
        }
        AppMethodBeat.o(111530);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.rJx.startAnimation(localAnimation);
    AppMethodBeat.o(111539);
  }
  
  private void cAD()
  {
    AppMethodBeat.i(111540);
    this.rJz = true;
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772109);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(111531);
        ImageFolderMgrView.b(ImageFolderMgrView.this).setVisibility(8);
        ImageFolderMgrView.a(ImageFolderMgrView.this, false);
        ImageFolderMgrView.a(ImageFolderMgrView.this);
        if (ImageFolderMgrView.this.rJD != null) {
          ImageFolderMgrView.this.rJD.lF(false);
        }
        AppMethodBeat.o(111531);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.rJx.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772048);
    this.rJw.startAnimation(localAnimation);
    AppMethodBeat.o(111540);
  }
  
  private void lH(boolean paramBoolean)
  {
    AppMethodBeat.i(111538);
    if (this.gX == paramBoolean)
    {
      ad.d("MicroMsg.ImageFolderMgrView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.gX) });
      AppMethodBeat.o(111538);
      return;
    }
    if (this.rJz)
    {
      ad.d("MicroMsg.ImageFolderMgrView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(111538);
      return;
    }
    if (this.gX)
    {
      cAD();
      AppMethodBeat.o(111538);
      return;
    }
    cAC();
    AppMethodBeat.o(111538);
  }
  
  public final void ah(LinkedList<GalleryItem.AlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(111541);
    ad.i("MicroMsg.ImageFolderMgrView", "onQueryAlbumFinished, %s, size: %s.", new Object[] { this, Integer.valueOf(paramLinkedList.size()) });
    e.czh().b(this);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)paramLinkedList.next();
      if (i.eK(localAlbumItem.anX())) {
        localLinkedList.add(localAlbumItem);
      }
    }
    this.rJy.rIQ = localLinkedList;
    e.czi().f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179470);
        ImageFolderMgrView.g(ImageFolderMgrView.this).notifyDataSetChanged();
        AppMethodBeat.o(179470);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(179471);
        String str = super.toString() + "|onQueryAlbumFinished";
        AppMethodBeat.o(179471);
        return str;
      }
    });
    AppMethodBeat.o(111541);
  }
  
  public final void cAB()
  {
    AppMethodBeat.i(111537);
    if (!this.gX) {}
    for (boolean bool = true;; bool = false)
    {
      lH(bool);
      AppMethodBeat.o(111537);
      return;
    }
  }
  
  public String getSelectedAlbumName()
  {
    return this.rJy.rIR;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(111542);
    paramAdapterView = this.rJy.Ee(paramInt);
    if (paramAdapterView == null)
    {
      ad.d("MicroMsg.ImageFolderMgrView", "get folder failed:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(111542);
      return;
    }
    this.rJw.performClick();
    if (this.rJu != null) {
      this.rJu.c(paramAdapterView);
    }
    this.rJy.rIR = bt.by(paramAdapterView.rBh, "");
    this.rJy.notifyDataSetChanged();
    AppMethodBeat.o(111542);
  }
  
  public void setFavItemCount(int paramInt)
  {
    AppMethodBeat.i(111543);
    this.rJy.rIS = paramInt;
    c localc = new c((byte)0);
    localc.rIz = new WeakReference(this.rJy);
    e.czi().f(localc);
    AppMethodBeat.o(111543);
  }
  
  public void setListener(a parama)
  {
    this.rJu = parama;
  }
  
  public void setOnFolderStateChanged(b paramb)
  {
    this.rJD = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void c(GalleryItem.AlbumItem paramAlbumItem);
  }
  
  public static abstract interface b
  {
    public abstract void lF(boolean paramBoolean);
  }
  
  static final class c
    implements Runnable
  {
    WeakReference<b> rIz;
    
    public final void run()
    {
      AppMethodBeat.i(111535);
      if (this.rIz != null)
      {
        b localb = (b)this.rIz.get();
        if (localb != null) {
          localb.notifyDataSetChanged();
        }
      }
      AppMethodBeat.o(111535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView
 * JD-Core Version:    0.7.0.1
 */